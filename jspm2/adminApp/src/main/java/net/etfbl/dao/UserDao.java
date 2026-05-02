package net.etfbl.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import net.etfbl.dto.Category;
import net.etfbl.dto.User;
import net.etfbl.dto.UserAccount;

public class UserDao {
	
	public static final String BASE_URL = "http://localhost:8080/users";
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	public static List<User> getAll(){
		InputStream is = null;
		ArrayList<User> list = new ArrayList<>();
    	
    	try {
			is=new URL(BASE_URL).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			for(int i = 0; i < json.length(); i++) {
				User user = new User();
				JSONObject object = json.getJSONObject(i);
				user.setId(object.getInt("id"));
				user.setName(object.getString("name"));
				user.setSurname(object.getString("surname"));
				user.setCity(object.getString("city"));
				user.setMail(object.getString("mail"));
				JSONObject accObj = object.getJSONObject("userAccount");
				UserAccount userAcc = new UserAccount();
				userAcc.setUsername(accObj.getString("username"));
				userAcc.setPassword(accObj.getString("password"));
				userAcc.setIsActivated(accObj.getInt("isActivated"));
				user.setUserAccount(userAcc);
				list.add(user);
			}
			System.out.println(list.get(3).getName());
			return list;
    	}
    	catch(Exception e) {
    		return new ArrayList<>();
    	}
	}
	
	
	private static int updateCreate(User user, String method) {
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		try {
			URL url = new URL(BASE_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json");
			JSONObject input = new JSONObject(json);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.toString().getBytes());
			os.flush();
			System.out.println("Statusni kod"+ conn.getResponseCode());
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return 200;
			}
			else
				return 400;


		}
		catch(Exception e) {
			return 400;
		}
	}
	
	public static int create(User user) {
		return updateCreate(user,"POST");
	}
	public static int update(User user) {
		return updateCreate(user,"PUT");
	}
}
