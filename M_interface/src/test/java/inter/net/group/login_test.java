package inter.net.group;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import jxl.read.biff.BiffException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import readerexcel.net.group.ExcelReader;


import bsh.util.Sessiond;

import com.alibaba.fastjson.JSONObject;

import constant.net.group.ConstantReader;
import cookies.net.group.CookiesUtil;

public class login_test {
	public static HttpClient client = HttpClientBuilder.create().build();
	
  @Test(dataProvider = "inter")
  public void Login(String  name ,String pwd,String expected) throws Exception {
	  System.out.println(name);
	  System.out.println(pwd);
	  URI url = new URI(ConstantReader.Name_URL);
	  HttpPost post= new HttpPost(url);
	  
//	  post.addHeader("Content-Type","application/x-www-form-urlencoded");
	 
	  HashMap<String, Object> map=new  HashMap<>();
	  map.put("username", name);
	  map.put("password", pwd);
	  
	  StringEntity entity = new StringEntity(JSONObject.toJSONString(map));
	 
	  entity.setContentEncoding("UTF-8");
//	  entity.setContentType("application/x-www-form-urlencoded");
	  entity.setContentType("application/json");
	  post.setEntity(entity);
	  HttpResponse response =client.execute(post);
	  
//	 CookiesUtil.sessionID();获取得到cookies值  
	  
	  String result= EntityUtils.toString(response.getEntity());
//	  String result1= EntityUtils.toString(entity);
	  System.out.println(result);
	  //可以写正则表达式获取需要的预期值也可用其他方法
	  String status=result.split(":")[1].split(",")[0];
	  System.out.println(status);
	  Assert.assertEquals(status, expected);
	 
//	  System.out.println(result1);
	  
	  post.releaseConnection();
	 
	  
  }
  @Test(dataProvider = "inter",dependsOnMethods="Login",alwaysRun=true)
  public void fill(){
	  //依赖login方法，同理也可用组方法
	  System.out.println("以上执行依赖方法");
  }
  
  
  @DataProvider
  public Object[][] inter()throws BiffException, IOException {
//	        ExcelReader e=new ExcelReader();
//	        System.out.println(ExcelReader.getExcelData());
//	        return ExcelReader.getExcelData(1,"/opt/abc.xls");
//	        return ExcelReader.getExcelData(1,"D:/Android/M_interface/abc.xls");
//	        return ExcelReader.getExcelData(1,System.getProperty("user.dir") + File.separator +"abc.xls");
	        return ExcelReader.getExcelData(1,"./abc.xls");
  }

}
