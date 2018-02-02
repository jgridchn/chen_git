package inter.net.group;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.net.group.ConstantReader;

import readerexcel.net.group.ExcelReader;

public class AcquireGet {
	
	HttpClient client= HttpClientBuilder.create().build();
	
	@Test(dataProvider = "dp")
 public void Login(String name,String pwd,String expected) throws Exception{
		String url=ConstantReader.Name_URL;
		HttpGet request=new HttpGet(url);
		
		
		 try {
				HttpResponse response = client.execute(request);
				
				System.out.println(EntityUtils.toString(response.getEntity()));
				int actual = response.getStatusLine().getStatusCode();
			
				Assert.assertEquals(actual, expected);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				request.releaseConnection();
			}
		
	}
	@DataProvider
	public Object[][]dp() throws Exception{
		//sheet页码，以及测试数据
		   return ExcelReader.getExcelData(1,"./abc.xls");
	}

}
