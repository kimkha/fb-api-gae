package fbapp.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TransferServiceAsync {
	public void getContent(String url, AsyncCallback<String> callback);
}
