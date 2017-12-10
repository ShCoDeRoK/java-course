package ru.mipt.java2017.hw3.Parser;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XLSXReader {

  private static final Logger logger = LoggerFactory.getLogger("Excel Reader");

  private Workbook workbook;
  private Sheet sheet;

  public static XLSXReader createReader(String filename) {
    try {
      return new XLSXReader(filename);
    } catch (FileNotFoundException e) {
      logger.info(filename);
      logger.error("File was not found;");
    } catch (IOException e) {
      logger.error("Reading error ", e.getMessage());
    }

    return null;
  }

  private XLSXReader(String filename) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(new File(filename));
    workbook = new XSSFWorkbook(fileInputStream);
    sheet = workbook.getSheetAt(0);
  }

  public int getNumberOfRows() {
    return sheet.getLastRowNum();
  }

  public int getNumberOfCells(int i) {
    return sheet.getRow(i).getLastCellNum();
  }

  public String get(int i, int j) {
    return sheet.getRow(i).getCell(j).getStringCellValue();
  }

}
