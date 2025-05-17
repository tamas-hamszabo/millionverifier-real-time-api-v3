import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MillionVerifierEmailVerifier {
    // !!! PUT YOUR API KEY HERE !!!
    private static final String API_KEY = "YOUR_API_KEY";

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: java MillionVerifierEmailVerifier <email>");
            return;
        }

        String email = args[0];
        String requestUrl = "https://api.millionverifier.com/api/v3/?api=" + API_KEY + "&email=" + URLEncoder.encode(email, "UTF-8");
        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        String json = content.toString();

        int resultcode = 0;
        String error = "";
        Matcher m = Pattern.compile("\"resultcode\"\\s*:\\s*(\\d+)").matcher(json);
        if (m.find()) {
            resultcode = Integer.parseInt(m.group(1));
        }
        m = Pattern.compile("\"error\"\\s*:\\s*\"([^\"]*)\"").matcher(json);
        if (m.find()) {
            error = m.group(1);
        }

        switch (resultcode) {
            case 1:
                System.out.println("Ok");
                break;
            case 2:
                System.out.println("Catch All");
                break;
            case 3:
                System.out.println("Unknown");
                break;
            case 4:
                System.out.println("Error: " + error);
                break;
            case 5:
                System.out.println("Disposable");
                break;
            case 6:
                System.out.println("Invlaid");
                break;
        }
    }
}
