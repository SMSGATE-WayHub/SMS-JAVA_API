import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.URLEncoder;

public class SmsGatewayHub {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = "YourAPIkey";
        String senderId = "TESTIN";
        String message = "YOUR MESSAGE HERE";
        String number = "91989xxxxxxx"; // MULTIPLE NUMBER VARIABLES PUT HERE...!

        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8.toString()); // encode the message content

        String url = "https://www.smsgatewayhub.com/api/mt/SendSMS?"
                + "APIKey=" + apiKey
                + "&senderid=" + senderId
                + "&channel=2"
                + "&DCS=0"
                + "&flashsms=0"
                + "&number=" + number
                + "&text=" + encodedMessage
                + "&route=1";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body()); // print the result of the API call
    }
}
