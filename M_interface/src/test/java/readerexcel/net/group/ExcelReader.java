package readerexcel.net.group;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * 读取excel公共方法
 * 
 *
 */

public class ExcelReader {
	
	public static Object[][] data;
//	private static int number;
	/**
	 * 
	 * @param excelFile 读取文件对象
	 * @param rowNum 从第几行开始读，如果有一行表头则从第二行开始读
	 * @param number 从第number页开始（标签）
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public static List<String[]> readExcel(File excelFile,int rowNum,int number) throws BiffException,IOException {
		// 创建一个list 用来存储读取的内容
		List<String[]> list = new ArrayList<String[]>();
		Workbook rwb = null;
		Cell cell = null;
		// 创建输入流
		InputStream stream = new FileInputStream(excelFile);
		// 获取Excel文件对象
		rwb = Workbook.getWorkbook(stream);
		// 获取文件的指定工作表 默认的第一个
		Sheet sheet = rwb.getSheet(number);
		// 行数(表头的目录不需要，从1开始)
		for (int i = rowNum-1; i < sheet.getRows(); i++) {
			// 创建一个数组 用来存储每一列的值
			String[] str = new String[sheet.getColumns()];
			// 列数
			for (int j = 0; j < sheet.getColumns(); j++) {
				// 获取第i行，第j列的值
				cell = sheet.getCell(j, i);
				str[j] = cell.getContents();
//				System.out.println(str[j]);
			}
			// 把刚获取的列存入list
			list.add(str);
//			System.out.println(list);
		}
		// 返回值集合
		return list;
	}
//	public static void main(String[] args) throws BiffException, IOException {
//		System.out.println(number);
//		getExcelData(number);
//		
//		
//	}
	public static Object[][] getExcelData(int number,String path) throws BiffException, IOException {
		String excelFileName = path;
		Workbook rwb = null;
		InputStream stream = new FileInputStream(excelFileName);
		
		rwb = Workbook.getWorkbook(stream);
		
		Sheet sheet = rwb.getSheet(number);
		System.out.println("读取sheet页的第"+number+"页");
		 data = new Object[sheet.getRows()][sheet.getColumns()];
		try {
			List<String[]> list = ExcelReader.readExcel(new File(excelFileName),1,number);
			for (int i = 0; i < list.size(); i++) {
				String[] str = (String[])list.get(i);
				for (int j = 0; j < str.length; j++) {
					data[i][j]=str[j];
//					System.out.println(data[i][j]);
				
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
