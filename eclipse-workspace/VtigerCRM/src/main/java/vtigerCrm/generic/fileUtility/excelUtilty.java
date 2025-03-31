package vtigerCrm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtilty {
	
	public String getTestDataFromExcelFile(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook WB = WorkbookFactory.create(fise);
		String data = WB.getSheet(SheetName).getRow(RowNum).getCell(CellNum).getStringCellValue();
		WB.close();
		return data;
	}
	
	public int getRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook WB = WorkbookFactory.create(fise);
		int RowCount = WB.getSheet(Sheetname).getLastRowNum();
		WB.close();
		return RowCount;
		
		
	}
	
	public void setDataIntoExcell(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook WB = WorkbookFactory.create(fise);
		WB.getSheet(SheetName).getRow(RowNum).createCell(CellNum);
		FileOutputStream fio = new FileOutputStream("./testdata/testScriptdata.xlsx");
		WB.write(fio);
		WB.close();
		
	}

}


