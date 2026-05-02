package net.etfbl.dao;
import java.util.*;
import net.etfbl.dto.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import com.google.gson.Gson;
public class CategoryDAO {

	public CategoryDAO() {
		
	}
	public static final String BASE_URL = "http://localhost:8080/categorys";
	public static final String LOGGS_URL = "http://localhost:8080/loggs";
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	public static List<Category> getAll(){
		InputStream is = null;
		ArrayList<Category> list = new ArrayList<>();
    	
    	try {
			is=new URL(BASE_URL).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			
			for(int i = 0; i < json.length(); i++) {
				Category category = new Category();
				JSONObject object = json.getJSONObject(i);
				category.setId(object.getInt("id"));
				category.setName(object.getString("name"));
				category.setAttributes(object.getString("attributes"));
				list.add(category);
			}
			return list;
    	}
    	catch(Exception e) {
    		return new ArrayList<>();
    	}
	}
	private static int updateCreate(Category category, String method) {
		Gson gson = new Gson();
		String json = gson.toJson(category);
		
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
	public static int update(Category category) {
		return updateCreate(category,"PUT");
	}
	public static int create(Category category) {
		return updateCreate(category,"POST");
	}
	
	public static ArrayList<String> getAllStrings() {
		InputStream is = null;
    	try {
			is=new URL(LOGGS_URL).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			String[] array = jsonText.split(",");
			
			ArrayList<String> listStrings = new ArrayList<>(Arrays.asList(array));
			
			return listStrings;
    	}
    	catch(Exception e) {
    		return new ArrayList<>();
    	}
	}
}
