package fbapp.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import fbapp.client.lib.FB;
import fbapp.client.lib.FBCallback;
import fbapp.client.lib.FBResponse;

public class FacebookApps implements EntryPoint {
	public void onModuleLoad() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("appId", "316426390227"); // www.kimkha.com
		//options.put("appId", "158098150912207"); // nkimkha.appspot.com
		FB.init(options);
		FB.login(new FBCallback() {
			@Override
			public void onComplete(FBResponse response) {
				Window.alert(response.getContent());
			}
		});
	}
}
