package fbapp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fbapp.client.rpc.TransferService;

@SuppressWarnings("serial")
public class TransferServiceImpl extends RemoteServiceServlet implements TransferService {

	@Override
	public String getContent(String urlStr) {
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
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

	@Override
	public String fetchContent(String urlStr, String params) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(params);
            writer.close();
            
            return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
