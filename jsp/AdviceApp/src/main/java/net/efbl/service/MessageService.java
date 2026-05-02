package net.efbl.service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import net.etfbl.Benas.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

public class MessageService {

	public MessageService() {
		
	}
	public static final String BASE_URL = "http://localhost:8080/messages";
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	public List<MessageBean> getAll(){
		InputStream is = null;
    	ArrayList<MessageBean> list = new ArrayList<>();
    	
    	try {
			is=new URL(BASE_URL).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			
			for(int i=0;i<json.length();i++)
			{
				MessageBean message = new MessageBean();
				JSONObject obj = json.getJSONObject(i);;
				message.setId(obj.getInt("id"));
				message.setText(obj.getString("text"));
				message.setIsRead(obj.getInt("isRead"));
				JSONObject userObj = obj.getJSONObject("user");
				UserBean user = new UserBean();
				user.setId(userObj.getInt("id"));
				user.setName(userObj.getString("name"));
				user.setSurname(userObj.getString("surname"));
				user.setCity(userObj.getString("city"));
				user.setMail(userObj.getString("mail"));
				JSONObject userAccObj = userObj.getJSONObject("userAccount");
				UserAccountBean userAcc = new UserAccountBean();
				userAcc.setUsername(userAccObj.getString("username"));
				userAcc.setPassword(userAccObj.getString("password"));
				userAcc.setIsActivated(userAccObj.getInt("isActivated"));
				user.setUserAccount(userAcc);
				message.setUser(user);
				list.add(message);
			}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	
    	return list;
	}
	
	public void updateMessage(MessageBean mess) {
		Gson gson = new Gson();
		String jsonUser = gson.toJson(mess);
		
		try {
			URL url = new URL(BASE_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			JSONObject input = new JSONObject(jsonUser);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.toString().getBytes());
			os.flush();
			System.out.println("Statusni kod"+ conn.getResponseCode());
			/*if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

			}*/


		}
		catch(Exception e) {

		}
	}
}
