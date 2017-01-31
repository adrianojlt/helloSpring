package pt.adrz.hellospring.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.util.NumberUtils;

public class Utils {
	
	public static String address = "http://arenavision.in/agenda";
	
	public static String download(String add) throws IOException {
		
		URL url;
		String finalHTML = "";

		url = new URL(add);
		URLConnection spoof = url.openConnection();

		// Spoof the connection so we look like a web browser
		spoof.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0;    H010818)");
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));

		String strLine = "";

		// Loop through every line in the source
		while ((strLine = in.readLine()) != null) {
			finalHTML += strLine;
		}

		return finalHTML;
	}
	
	public static String parse(String html) {
		try {
			Document doc = Jsoup.parse(html);
			//Element elem = doc.getElementsByClass("content").first();
			Element elem = doc.select("table").first();
			//Element elem = doc.getElementsByTag("table").first();
			//Node first = elem.childNodes().get(0).childNode(1);
			//return first.toString();
			return elem.html();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String table() {
		
		String html = "";

		try {
			html = download(address);
			html = parse(html);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return html;
	}
	
	public static String getLink(String param) {
		
		String acestreamPattern = "acestream://\\w*";
		String soapPattern = "sop://[a-z.:\\d/]*";
		String useThisPattern = null;
		String oneOrTwoDigitsPattern = "^[0-9]{1,2}$";
		String pageContent = "";
		String link = "";
		
		if ( param.startsWith("av")  && param.substring(2).matches(oneOrTwoDigitsPattern)) {
			 useThisPattern = acestreamPattern;
		}

		if ( param.startsWith("avs") && param.substring(3).matches(oneOrTwoDigitsPattern)) {
			 useThisPattern = soapPattern;
		}
		
		if ( useThisPattern == null ) {
			return "";
		}
		
		try {
			pageContent = download("http://arenavision.in/" + param);
		} catch (IOException e) {
			return "";
		}

		Pattern pattern = Pattern.compile(useThisPattern);
		Matcher matcher = pattern.matcher(pageContent);

		if ( matcher.find() ) {
			link = matcher.group();
		} 
		
		return link;
	}
	
	public static void main(String[] args) {
		//System.out.println(table());
		System.out.println(getLink("avs1"));
		//getAcestream();
	}
}
