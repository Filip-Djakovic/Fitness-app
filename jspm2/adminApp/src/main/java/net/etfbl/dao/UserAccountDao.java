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

import net.etfbl.dto.Category;
import net.etfbl.dto.User;
import net.etfbl.dto.UserAccount;

import com.google.gson.Gson;
public class UserAccountDao {
	private static final String URL = "http://localhost:8080/users_account/admin_user";
	public static final String BASE_URL = "http://localhost:8080/categorys";
	public UserAccountDao() {
		
	}
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	public static boolean login(UserAccount user) {
		Gson gson = new Gson();
		String jsonUser = gson.toJson(user);
		
		try {
			URL url = new URL(URL);
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
				return true;
			}
			else
				return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
}
