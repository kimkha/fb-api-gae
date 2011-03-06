package fbapp.server;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fbapp.client.rpc.TransferService;

@SuppressWarnings("serial")
public class TransferServiceImpl extends RemoteServiceServlet implements
		TransferService {

	@Override
	public String getContent(String urlStr) {
		URLFetchService fetcher = URLFetchServiceFactory.getURLFetchService();

		try {
			URL url = new URL(urlStr);
			HTTPResponse response = fetcher.fetch(new HTTPRequest(url,
					HTTPMethod.GET, FetchOptions.Builder.doNotValidateCertificate()));

			byte[] content = response.getContent();

			return new String(content);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String fetchContent(String urlStr, String params) {
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");

			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(params);
			writer.close();

			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
