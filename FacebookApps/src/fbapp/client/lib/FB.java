package fbapp.client.lib;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fbapp.client.rpc.TransferService;
import fbapp.client.rpc.TransferServiceAsync;

public class FB {
	private static String appId = null;
	private static boolean cookie = false;
	private static boolean logging = true;
	private static FBSession session = null;
	private static boolean status = true;
	private static boolean xfbml = false;
	private static String channelUrl = null;

	private static void fetchURL(String url, final ICallback callback) {
		TransferServiceAsync service = GWT.create(TransferService.class);
		service.getContent(url, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				callback.onComplete(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				callback.onComplete(null);
			}
		});
	}

	@SuppressWarnings("unused")
	private static void fetchURL(String url, String params,
			final ICallback callback) {
		TransferServiceAsync service = GWT.create(TransferService.class);
		service.getContent(url, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				callback.onComplete(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				callback.onComplete(null);
			}
		});
	}

	public static FBSession getSession() {
		return session;
	}

	public static void getLoginStatus(FBCallback callback) {

	}

	public static void api(Map<String, String> params, FBCallback callback) {

	}

	public static void api(String path, FBCallback callback) {

	}

	public static void api(String path, Map<String, String> params,
			FBCallback callback) {

	}

	public static void api(String path, String method, FBCallback callback) {

	}

	public static void api(String path, String method,
			Map<String, String> params, FBCallback callback) {

	}

	public static void init(Map<String, Object> options) {
		if (options.containsKey("appId")) {
			appId = (String) options.get("appId");
		}
		if (options.containsKey("cookie")) {
			cookie = (Boolean) options.get("cookie");
		}
		if (options.containsKey("logging")) {
			logging = (Boolean) options.get("logging");
		}
		if (options.containsKey("session")) {
			session = (FBSession) options.get("session");
		}
		if (options.containsKey("status")) {
			status = (Boolean) options.get("status");
		}
		if (options.containsKey("xfbml")) {
			xfbml = (Boolean) options.get("xfbml");
		}
		if (options.containsKey("channelUrl")) {
			channelUrl = (String) options.get("channelUrl");
		}
	}

	public static void login(final FBCallback callback) {
		login(callback, null);
	}

	public static void login(final FBCallback callback,
			Map<String, String> options) {
		if (Window.Location.getHash().length() <= 0) {
			String url = "https://www.facebook.com/dialog/oauth?client_id="
					+ appId + "&redirect_uri=" + Window.Location.getHref()
					+ "&response_type=token";
			
			if (options != null && options.containsKey("perms")) {
				url += "&scope="+options.get("perms");
			}
			
			Window.Location.replace(url);
		} else {
			String accessToken = Window.Location.getHash().substring(1);
			final String graphUrl = "https://graph.facebook.com/me?"
					+ accessToken;

			final FBResponse response = new FBResponse();

			// Request Graph API
			fetchURL(graphUrl, new ICallback() {
				@Override
				public void onComplete(String result) {
					if (result == null) {
						callback.onComplete(null);
					} else {
						response.setContent(result);
						
						callback.onComplete(response);
					}
				}
			});
		}
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
	
	private interface ICallback {
		void onComplete(String result);
	}
}
