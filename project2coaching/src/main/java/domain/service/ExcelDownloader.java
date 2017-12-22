package domain.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import domain.model.ModelClass;

// http://www.java67.com/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html

public class ExcelDownloader {
	
	public void buildXlsxDocument(List<ModelClass> models, OutputStream outputStream) {
		Workbook workbook = new XSSFWorkbook();
		this.buildExcelDocument(models, outputStream, workbook);
	}

	public void buildXlsDocument(List<ModelClass> models, OutputStream outputStream) {
		Workbook workbook = new HSSFWorkbook();
		this.buildExcelDocument(models, outputStream, workbook);
	}

	private void buildExcelDocument(List<ModelClass> models, OutputStream outputStream, Workbook workbook) {
        //create an excel sheet
        Sheet sheet = workbook.createSheet("Single List");
        sheet.setDefaultColumnWidth(30);

        //create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("DATE");
        header.createCell(1).setCellValue("Artist");
        header.createCell(2).setCellValue("Title");
        header.createCell(3).setCellValue("Link");

        //create cellstyle for header
        CellStyle cs = workbook.createCellStyle();
        cs.setFillBackgroundColor(IndexedColors.DARK_RED.getIndex());
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //create font for header
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        cs.setFont(font);
        
        //set style for header
        header.getCell(0).setCellStyle(cs);
        header.getCell(1).setCellStyle(cs);
        header.getCell(2).setCellStyle(cs);
        header.getCell(3).setCellStyle(cs);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yy hh:mm:ss");
        //create data cells
        int rowCount = 1;
        for (ModelClass model: models) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(sdf.format(model.getDate()));
            row.createCell(1).setCellValue(model.getArtist());
            row.createCell(2).setCellValue(model.getTitle());
            row.createCell(3).setCellValue(model.getUrl());
        }

        try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}
}
