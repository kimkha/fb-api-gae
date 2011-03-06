package fbapp.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TransferServiceAsync {
	public void getContent(String urlStr, AsyncCallback<String> callback);

	public void fetchContent(String urlStr, String params,
			AsyncCallback<String> callback);
}
