package cookies.net.group;

import inter.net.group.login_test;

import java.util.List;


import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;


public class CookiesUtil {
	
//	login_test lTest=new login_test();
	  
//	  Cookie[] cookies =post.getcookies();//这样便可以获取一个cookie数组
//	  for(Cookie cookie : cookies){
//	  cookie.getName();// get the cookie name
//	  cookie.getValue(); // get the cookie value
//	  }
	public static   String sessionID(){
		System.out.println(login_test.client);
	  String JSESSIONID = null;
     String cookie_user = null;
     //获得Cookies
     CookieStore cookieStore = ((AbstractHttpClient) login_test.client).getCookieStore();
     List<Cookie> cookies = cookieStore.getCookies();
     for (int i = 0; i < cookies.size(); i++) {
//         //遍历Cookies
//         System.out.println(cookies.get(i));
//         System.out.println("cookiename=="+cookies.get(i).getName());
         System.out.println("cookieValue=="+cookies.get(i).getValue());
//         System.out.println("Domain=="+cookies.get(i).getDomain());
//         System.out.println("Path=="+cookies.get(i).getPath());
//         System.out.println("Version=="+cookies.get(i).getVersion());
return cookies.get(i).getValue();
//         if (cookies.get(i).getName().equals("JSESSIONID")) {
//             JSESSIONID = cookies.get(i).getValue();
//         }
//         if (cookies.get(i).getName().equals("cookie_user")) {
//             cookie_user = cookies.get(i).getValue();
//         }
//         System.out.println( cookies.get(i).getValue());
     }
	return null ;
//	return cookie_user;
    
}
	}
