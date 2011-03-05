package fbapp.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("transfer")
public interface TransferService extends RemoteService {
	String getContent(String url);
}
