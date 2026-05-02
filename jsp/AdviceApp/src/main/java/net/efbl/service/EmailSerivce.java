package net.efbl.service;

import net.etfbl.Benas.EmailBean;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.io.OutputStream;
public class EmailSerivce {
	public static final String USER_URL = "http://localhost:8080/email/email_picture";
	public EmailSerivce() {
		
	}
	
	
	public void sendMail(EmailBean emailBean) {
		Gson gson = new Gson();
		String jsonMail = gson.toJson(emailBean);
		
		try {
			URL url = new URL(USER_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			JSONObject input = new JSONObject(jsonMail);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.toString().getBytes());
			os.flush();
			System.out.println("Mail code "+conn.getResponseCode());
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			}
		}
		catch(Exception e) {
		}
	}
}
