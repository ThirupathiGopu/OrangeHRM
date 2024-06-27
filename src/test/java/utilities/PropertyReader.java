package utilities;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PropertyReader 
{
	public static double getdata(String filename, int row, int colu) throws Exception {
		String filepath = ".//TestData//" + filename + ".xlsx";
		FileInputStream instream = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		return sheet.getRow(row).getCell(colu).getNumericCellValue();
	}

	// Integer data convert to String method
	public static List<String> getdataa(String filename, int row) throws Exception {
		String filepat = ".//TestData//" + filename + ".xlsx";
		FileInputStream instream = new FileInputStream(filepat);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		XSSFRow rows = sheet.getRow(row);
		// XSSFCell cell=rows.getCell(colu);
		int cellscount = sheet.getRow(row).getLastCellNum();
		DataFormatter format = new DataFormatter();
		List<String> rowdata = new ArrayList<String>();
		for (int i = 0; i < cellscount; i++) {
			String data = format.formatCellValue(sheet.getRow(row).getCell(i));
			rowdata.add(data);
		}
		return rowdata;
	}

	public static List<String> getData(String filename, int row) throws Exception {
		String filepath = ".//TestData//" + filename + ".xlsx";
		FileInputStream instream = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int cellscount = sheet.getRow(row).getLastCellNum();
		List<String> rowdata = new ArrayList<String>();
		for (int i = 0; i < cellscount; i++) {
			String data = sheet.getRow(row).getCell(i).getStringCellValue();
			rowdata.add(data);
			
		}
		return rowdata;	
	
	}

//	public void getDat(String filename, int row) throws Exception {
//
//		String filepath = ".//TestData//" + filename + ".xlsx";
//		FileInputStream instream = new FileInputStream(filepath);
//		XSSFWorkbook workbook = new XSSFWorkbook(instream);
//		XSSFSheet sheet = workbook.getSheet("sheet1");
//		int cellscount = sheet.getRow(row).getLastCellNum();
//
//		HashMap<Integer, String> map = new HashMap<>();
//
//		for (int i = 0; i < cellscount; i++) {
//			String col1 = sheet.getRow(row).getCell(i).getStringCellValue();
//			map.put(i, col1);
//
//			System.out.println(map.put(i, col1));
//		}
//	}


	public static String[][] getdata(String filename) throws Exception {
		String filepath = ".//TestData//" + filename + ".xlsx";
		FileInputStream instream = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		
		int rows = sheet.getLastRowNum();
		System.out.println("rows=" + rows);
		
		int cellscount = sheet.getRow(rows).getLastCellNum();
		System.out.println("cellscount=" + cellscount);
		
		String info[][] = new String[rows][cellscount];
		System.out.println(info);
		int k = 0, l = 0;
		for (int i = 1; i <= rows; i++) {
			l = 0;
			for (int j = 0; j <cellscount; j++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				info[k][l] = data;
				l++;
			}
			k++;
		}
		return info;
	}
	
	public static String[][] getdat(String filename) throws Exception 
	{
	    String filepath = ".//TestData//" + filename + ".xlsx";
	    FileInputStream instream = new FileInputStream(filepath);
	    XSSFWorkbook workbook = new XSSFWorkbook(instream);
	    XSSFSheet sheet = workbook.getSheet("sheet1");
	    
	    // Get the last row number
	    int rows = sheet.getLastRowNum();
	    System.out.println("rows = " + rows);
	    
	    // Check if the sheet is empty
	    if (rows < 0)
	    {
	        workbook.close();
	        throw new IllegalArgumentException("The sheet is empty");
	    }
	    
	    // Get the number of cells in the first row (assuming it has headers)
	    int cellscount = sheet.getRow(0).getLastCellNum();
	    System.out.println("cellscount = " + cellscount);
	    
	    // Initialize the array to hold the data
	    String info[][] = new String[rows][cellscount];
	    
	    int k = 0;
	    for (int i = 1; i <= rows; i++) {
	        for (int j = 0; j < cellscount; j++) {
	            XSSFCell cell = sheet.getRow(i).getCell(j);
	            String data = (cell == null) ? "" : cell.getStringCellValue();
	            info[k][j] = data;
	        }
	        k++;
	    }
	    
	    workbook.close();
	    return info;
	}

	
//	public static String[][] Getdata(String filename) throws Exception {
//	    String filepath = ".//TestData//" + filename + ".xlsx";
//	    FileInputStream instream = new FileInputStream(filepath);
//	    XSSFWorkbook workbook = new XSSFWorkbook(instream);
//	    XSSFSheet sheet = workbook.getSheet("sheet1");
//
//	    // Get the last row number
//	    int rows = sheet.getLastRowNum();
//	    System.out.println("rows = " + rows);
//
//	    // Check if the sheet is empty
//	    if (rows < 0) 
//	    {
//	        workbook.close();
//	        throw new IllegalArgumentException("The sheet is empty");
//	    }
//
//	    // Get the number of cells in the first row (assuming it has headers)
//	    int cellscount = sheet.getRow(0).getLastCellNum();
//	    System.out.println("cellscount = " + cellscount);
//
//	    // Initialize the array to hold the data
//	    String[][] info = new String[rows][cellscount];
//
//	    int k = 0;
//	    for (int i = 1; i <= rows; i++) {
//	        XSSFRow row = sheet.getRow(i);
//	        for (int j = 0; j < cellscount; j++) {
//	            XSSFCell cell = row.getCell(j);
//	            String data = "";
//
//	            if (cell != null) {
//	                switch (cell.getCellType()) {
//	                    case STRING:
//	                        data = cell.getStringCellValue();
//	                        break;
//	                    case NUMERIC:
//	                        if (DateUtil.isCellDateFormatted(cell)) {
//	                            data = cell.getDateCellValue().toString();
//	                        }
//	                        else 
//	                        {
//	                            data = Double.toString(cell.getNumericCellValue());
//	                        }
//	                        break;
//	                    case BOOLEAN:
//	                        data = Boolean.toString(cell.getBooleanCellValue());
//	                        break;
//	                    case FORMULA:
//	                        data = cell.getCellFormula();
//	                        break;
//	                    default:
//	                        data = "";
//	                }
//	            }
//	            info[k][j] = data;
//	        }
//	        k++;
//	    }
//
//	    workbook.close();
//	    return info;
//	}
//	
	public static String[][] Getdata(String filename) throws Exception {
	    String filepath = ".//TestData//" + filename + ".xlsx";
	    FileInputStream instream = new FileInputStream(filepath);
	    XSSFWorkbook workbook = new XSSFWorkbook(instream);
	    XSSFSheet sheet = workbook.getSheet("sheet1");

	    // Get the last row number
	    int rows = sheet.getLastRowNum();
	    System.out.println("rows = " + rows);

	    // Check if the sheet is empty
	    if (rows < 0)
	    {
	        workbook.close();
	        throw new IllegalArgumentException("The sheet is empty");
	    }

	    // Get the number of cells in the first row (assuming it has headers)
	    int cellscount = sheet.getRow(rows).getLastCellNum();
	    System.out.println("cellscount = " + cellscount);

	    // Initialize the array to hold the data
	    String[][] info = new String[rows][cellscount];

	    int k = 0;
	    for (int i = 1; i <= rows; i++) {
	        XSSFRow row = sheet.getRow(i);
	        if (row == null) {
	            // If the row is null, skip to the next iteration
	            continue;
	        }
	        for (int j = 0; j < cellscount; j++) {
	            XSSFCell cell = row.getCell(j);
	            String data = "";

	            if (cell != null) {
	                switch (cell.getCellType()) {
	                    case STRING:
	                        data = cell.getStringCellValue();
	                        break;
	                    case NUMERIC:
	                        if (DateUtil.isCellDateFormatted(cell)) {
	                            data = cell.getDateCellValue().toString();
	                        } else {
	                            data = Double.toString(cell.getNumericCellValue());
	                        }
	                        break;
	                    case BOOLEAN:
	                        data = Boolean.toString(cell.getBooleanCellValue());
	                        break;
	                    case FORMULA:
	                        data = cell.getCellFormula();
	                        break;
	                    default:
	                        data = "";
	                }
	            }
	            info[k][j] = data;
	        }
	        k++;
	    }

	    workbook.close();
	    return info;
	}
	
	public static String[][] getdataa(String filename) throws Exception 
	{
		String filepath = ".//TestData//" + filename + ".xlsx";
		FileInputStream instream = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rows = sheet.getLastRowNum();
		System.out.println("rows=" + rows);
		int cellscount = sheet.getRow(rows).getLastCellNum();
		System.out.println("cellscount=" + cellscount);
		String info[][] = new String[rows][cellscount];
		DataFormatter format = new DataFormatter();
		int k = 0, l = 0;
		for (int i = 1; i <=rows; i++) 
		{
			l = 0;
			for (int j = 0; j <cellscount; j++) 
			{
				String data =format.formatCellValue(sheet.getRow(i).getCell(j));
				info[k][l] = data;
				l++;
			}
			k++;
		}
		return info;
	}

	public static String getLocater(String filename, String key) throws Exception {
		String filepath = ".//Locators//" + filename + ".properties";
		FileInputStream instream = new FileInputStream(filepath);
		Properties pro = new Properties();
		pro.load(instream);
		return pro.getProperty(key);
	}

}

