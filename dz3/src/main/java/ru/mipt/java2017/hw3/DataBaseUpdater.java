package ru.mipt.java2017.hw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mipt.java2017.hw3.Application.DataAccess;
import ru.mipt.java2017.hw3.Application.DataFinder;
import ru.mipt.java2017.hw3.Application.DataUpdater;
import ru.mipt.java2017.hw3.Application.DataWriter;
import ru.mipt.java2017.hw3.Models.Author;
import ru.mipt.java2017.hw3.Models.Book;
import ru.mipt.java2017.hw3.Models.BookAuthor;
import ru.mipt.java2017.hw3.Parser.XLSXReader;
import ru.mipt.java2017.hw3.Parser.XLSXWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class DataBaseUpdater {

  final static Logger logger = LoggerFactory.getLogger("DatabaseUpdater");
  final DataAccess dataAccess;
  final DataWriter dataWriter;
  final DataUpdater dataUpdater;
  final DataFinder dataFinder;

  public DataBaseUpdater(String connectionText) {
    this.dataAccess = new DataAccess(connectionText);
    this.dataWriter = new DataWriter(dataAccess);
    this.dataUpdater = new DataUpdater(dataAccess);
    this.dataFinder = new DataFinder(dataAccess);
  }

  public static void main(String args[]) throws ParseException, IOException {
    String connectionText = args[0];
    String pathToResourse = args[1];
    String pathToOutput = args[2];
    XLSXReader xlsxReader = XLSXReader.createReader(pathToResourse);
    if (xlsxReader == null) {
      logger.error("Cannot open file!");
      System.exit(1);
    }
    DataBaseUpdater databaseUpdater = new DataBaseUpdater(connectionText);
    databaseUpdater.modifyInformationInDatabases(xlsxReader);
    databaseUpdater.writeInformationToFile(pathToOutput);
  }

  private  void writeInformationToFile(String pathToOutput) throws IOException {
    XLSXWriter xlsxWriter = new XLSXWriter(pathToOutput);
    xlsxWriter.startWriteToSheet("Authors");
    xlsxWriter.writeAuthors(dataFinder.getAllAuthors());
    xlsxWriter.startWriteToSheet("Books");
    xlsxWriter.writeBooks(dataFinder.getAllBooks());
    xlsxWriter.startWriteToSheet("Books_Authors");
    xlsxWriter.writeBooksAuthors(dataFinder.getAllBooksAuthors());
    xlsxWriter.finish();
    DataAccess.shutdown();
  }

  private  void modifyInformationInDatabases(XLSXReader xlsxReader) throws ParseException {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < xlsxReader.getNumberOfCells(0); ++i) {
      map.put(xlsxReader.get(0, i),  i);
    }
    for(int i = 1; i <= xlsxReader.getNumberOfRows(); ++i) {
      String StringISBN = xlsxReader.get(i, map.get("ISBN"));
      String cover = "";
      if (map.containsKey("cover")) {
        cover = xlsxReader.get(i, map.get("cover"));
      }
      StringISBN = StringISBN.replaceAll("ISBN[1-9]+:", "");
      BigDecimal ISBN = new BigDecimal(StringISBN.trim());
      String title = xlsxReader.get(i, map.get("Title"));
      String[] authors = xlsxReader.get(i, map.get("Authors")).split(", ");
      Long BookId = 0l;
      BookId = updateInfoAboutBook(ISBN, title, cover);
      for (int j = 0; j < authors.length; ++j) {
        Long AuthorId = createAuthorOrGet(authors[j].trim());
        createBookAuthor(BookId, AuthorId, j + 1);
      }
    }
  }

  private Long updateInfoAboutBook(BigDecimal isbn, String title, String cover) {
    Book book = new Book();
    book.setISBN(isbn);
    book.setTitle(title);
    book.setCover(cover);
    return dataUpdater.UpdateDatabase(book);
  }

  private  void createBookAuthor(Long bookId, Long authorId, int i) {
    BookAuthor bookAuthor = new BookAuthor();
    bookAuthor.setAuthorId(authorId);
    bookAuthor.setBookId(bookId);
    bookAuthor.setOrderNumber(i);
    dataWriter.WriteToDatabase(bookAuthor);
  }

  private  Long createAuthorOrGet(String author) {
    Author author1 = new Author();
    author1.setName(author);
    Long id = dataFinder.getAuthor(author1);
    if (id == 0) {
      id = dataWriter.WriteToDatabase(author1);
    }
    return id;
  }
}
