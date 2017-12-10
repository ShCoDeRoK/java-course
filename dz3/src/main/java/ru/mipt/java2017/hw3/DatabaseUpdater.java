package ru.mipt.java2017.hw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mipt.java2017.hw3.Application.Access;
import ru.mipt.java2017.hw3.Application.Finder;
import ru.mipt.java2017.hw3.Application.Updater;
import ru.mipt.java2017.hw3.Application.Writer;
import ru.mipt.java2017.hw3.Models.Author;
import ru.mipt.java2017.hw3.Models.Book;
import ru.mipt.java2017.hw3.Models.BookAuthor;
import ru.mipt.java2017.hw3.Parser.Reader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseUpdater {

  final static Logger logger = LoggerFactory.getLogger("DatabaseUpdater");
  final Access dataAccess;
  final Writer dataWriter;
  final Updater dataUpdater;
  final Finder dataFinder;

  public DatabaseUpdater(String connectionText) {
    this.dataAccess = new Access(connectionText);
    this.dataWriter = new Writer(dataAccess);
    this.dataUpdater = new Updater(dataAccess);
    this.dataFinder = new Finder(dataAccess);
  }

  public static void main(String args[]) throws ParseException, IOException {
    String connectionText = args[0];
    String pathToResourse = args[1];
    String pathToOutput = args[2];
    Reader xlsxReader = Reader.createReader(pathToResourse);
    if (xlsxReader == null) {
      logger.error("Cannot open file!");
      System.exit(1);
    }
    DatabaseUpdater databaseUpdater = new DatabaseUpdater(connectionText);
    databaseUpdater.modifyInformationInDatabases(xlsxReader);
    databaseUpdater.writeInformationToFile(pathToOutput);
  }

  private  void writeInformationToFile(String pathToOutput) throws IOException {
    ru.mipt.java2017.hw3.Parser.Writer xlsxWriter = new ru.mipt.java2017.hw3.Parser.Writer(pathToOutput);
    xlsxWriter.startWriteToSheet("Authors");
    xlsxWriter.writeAuthors(dataFinder.getAllAuthors());
    xlsxWriter.startWriteToSheet("Books");
    xlsxWriter.writeBooks(dataFinder.getAllBooks());
    xlsxWriter.startWriteToSheet("Books_Authors");
    xlsxWriter.writeBooksAuthors(dataFinder.getAllBooksAuthors());
    xlsxWriter.finish();
    Access.shutdown();
  }

  private  void modifyInformationInDatabases(Reader xlsxReader) throws ParseException {
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
      StringISBN = StringISBN.replaceAll("ISBN[1-9]+:|\\h", "");
      Long isbn = new Long(StringISBN.trim());
      String title = xlsxReader.get(i, map.get("Title"));
      String[] authors = xlsxReader.get(i, map.get("Authors")).split(", ");
      Long id = 0l;
      if (isBookWithISBN(isbn, title, cover)) {
        id = updateInfoAboutBook(isbn, title, cover);
      } else {
        id = createBook(isbn, title, cover);
      }
      for (int j = 0; j < authors.length; ++j) {
        Long AuthorId = createAuthorOrGet(authors[j].trim());
        createBookAuthor(id, AuthorId, j + 1);
      }
    }
  }

  private Long updateInfoAboutBook(Long isbn, String title, String cover) {
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

  private  boolean isBookWithISBN(Long isbn, String title, String cover) {
    Book book = new Book();
    book.setISBN(isbn);
    book.setTitle(title);
    book.setCover(cover);
    return dataFinder.FindFromDatabase(book);
  }

  private  Long createBook(Long isbn, String title, String cover) {
    Book book = new Book();
    book.setISBN(isbn);
    book.setTitle(title);
    book.setCover(cover);
    return dataWriter.WriteToDatabase(book);
  }
}