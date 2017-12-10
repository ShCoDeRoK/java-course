package ru.mipt.java2017.hw3.Parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import ru.mipt.java2017.hw3.Models.Author;
import ru.mipt.java2017.hw3.Models.Book;
import ru.mipt.java2017.hw3.Models.BookAuthor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XLSXWriter {

  final String pathToFile;
  final Workbook workBook;
  Sheet sheet;

  public XLSXWriter(String inputName) {
    pathToFile = inputName;
    workBook = new HSSFWorkbook();
  }

  public void startWriteToSheet(String sheetName) {
    sheet = workBook.createSheet(sheetName);
  }

  public void writeAuthors(List<Author> authorList) {
    Row row = sheet.createRow(0);
    Cell Id = row.createCell(0);
    Id.setCellValue("ID");
    Cell Name = row.createCell(1);
    Name.setCellValue("Name");


    for (int i = 0; i < authorList.toArray().length; ++i) {
      row = sheet.createRow(i + 1);
      Id = row.createCell(0);
      Id.setCellValue(authorList.get(i).getID());
      Name = row.createCell(1);
      Name.setCellValue(authorList.get(i).getName());
    }
  }

  public void writeBooks(List<Book> bookList) {
    Row row = sheet.createRow(0);
    Cell Id = row.createCell(0);
    Id.setCellValue("ID");
    Cell ISBN = row.createCell(1);
    ISBN.setCellValue("ISBN");
    Cell title = row.createCell(2);
    title.setCellValue("title");
    Cell cover = row.createCell(3);
    cover.setCellValue("cover");
    for (int i = 0; i < bookList.toArray().length; ++i) {
      row = sheet.createRow(i + 1);
      Id = row.createCell(0);
      Id.setCellValue(bookList.get(i).getID());
      ISBN = row.createCell(1);
      ISBN.setCellValue(String.valueOf(bookList.get(i).getISBN()));
      title = row.createCell(2);
      title.setCellValue(bookList.get(i).getTitle());
      cover = row.createCell(3);
      cover.setCellValue(bookList.get(i).getCover());
    }
  }

  public void writeBooksAuthors(List<BookAuthor> bookAuthorList) {
    Row row = sheet.createRow(0);
    Cell Id = row.createCell(0);
    Id.setCellValue("ID");
    Cell bookId = row.createCell(1);
    bookId.setCellValue("books_id");
    Cell authorId = row.createCell(2);
    authorId.setCellValue("authors_id");
    Cell num = row.createCell(3);
    num.setCellValue("num");

    for (int i = 0; i < bookAuthorList.toArray().length; ++i) {
      row = sheet.createRow(i + 1);
      Id = row.createCell(0);
      Id.setCellValue(bookAuthorList.get(i).getID());
      bookId = row.createCell(1);
      bookId.setCellValue(bookAuthorList.get(i).getBookId());
      authorId = row.createCell(2);
      authorId.setCellValue(bookAuthorList.get(i).getAuthorId());
      num = row.createCell(3);
      num.setCellValue(bookAuthorList.get(i).getOrderNumber());
    }

  }

  public void finish() throws IOException {
    workBook.write(new FileOutputStream(pathToFile));
    workBook.close();
  }
}