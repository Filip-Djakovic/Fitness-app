package net.efbl.service;

import java.io.Serializable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import net.etfbl.Benas.UserAccountBean;
import com.google.gson.Gson;
public class UserAccountService implements Serializable{

	private static final long serialVersionUID = -6509796155905343198L;
	public static final String USER_URL = "http://localhost:8080/users_account/advice_user";
	public UserAccountService() {
		
	}

	
	public UserAccountBean logInUser(UserAccountBean userAccountBean) {
		Gson gson = new Gson();
		UserAccountBean user = userAccountBean;
		user.setIsActivated(0);
		String jsonUser = gson.toJson(user);
		
		try {
			URL url = new URL(USER_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			JSONObject input = new JSONObject(jsonUser);
			
			OutputStream os = conn.getOutputStream();
			os.write(input.toString().getBytes());
			os.flush();
			System.out.println(conn.getResponseCode());
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return user;
			}
			else
				return null;
		}
		catch(Exception e) {
			return null;
		}
	}
}
