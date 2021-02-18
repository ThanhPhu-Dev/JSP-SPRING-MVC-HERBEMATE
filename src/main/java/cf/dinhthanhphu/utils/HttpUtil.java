package cf.dinhthanhphu.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String v) {
		value =v;
	}
	
	// dùng framework ObjectMapper để mapping thuộc tính trong string json sang object
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	// là hàm chuyển json thành string json
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
}
