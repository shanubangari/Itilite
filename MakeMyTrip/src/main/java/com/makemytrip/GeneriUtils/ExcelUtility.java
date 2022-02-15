package com.makemytrip.GeneriUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
/**
 * @author Jyoti H M
 * This method is used to read the data from excel by specifying Sheet Number, Row Number, Cell Number
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */
	
	public String  getExcelDataFromSheet(String SheetName, int RowNum, int CellNum ) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.Excel_File);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		return data;
	}
}
