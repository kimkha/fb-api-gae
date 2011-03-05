package fbapp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fbapp.client.rpc.TransferService;

@SuppressWarnings("serial")
public class TransferServiceImpl extends RemoteServiceServlet implements TransferService {

	@Override
	public String getContent(String url) {
		try {
			URL u = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(u.openStream()));
			String lines = "";
			
			while ((lines += reader.readLine()) != null) {
				
			}
			reader.close();
			
			return lines;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
