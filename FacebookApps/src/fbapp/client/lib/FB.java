package fbapp.client.lib;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Element;

public class FB {
	private static FBSession currentSession = null;
	
	public static FBSession getSession() {
		return currentSession;
	}
	
	public static void getLoginStatus(FBCallback callback) {
		
	}
	
	public static void api(Map<String, String> params, FBCallback callback) {
		
	}
	
	public static void init(Map<String, String> options) {
		
	}
	
	public static void login(FBCallback callback) {
		
	}
	
	public static void login(FBCallback callback, Map<String, String> options) {
		
	}

	public static void logout(FBCallback callback) {
		
	}
	
	public static void ui(Map<String, String> params, FBCallback callback) {
		
	}
	
	public static class Event {
		public static void subscribe(String name, FBCallback callback) {
			
		}
		
		public static void unsubscribe(String name, FBCallback callback) {
			
		}
	}
	
	public static class XFBML {
		public static void parse(FBCallback callback) {
			
		}
		
		public static void parse(Element dom, FBCallback callback) {
			
		}
	}
	
	public static class Data {
		@SuppressWarnings("rawtypes")
		public static FBQueryResult query(String template, Map data) {
			return null;
		}
		
		@SuppressWarnings("rawtypes")
		public static void waitOn(List dependencies, FBCallback callback) {
			
		}
	}
}
