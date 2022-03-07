package it.tostao.quickstart.delete;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Slawomir Leski on 26-04-2020.
 */
public class WypokConnectTest {

	@Test
	void shouldConnect() {
		var client = HttpClient.newHttpClient();

		Map<Object, Object> data = new HashMap<>();
		data.put("login", "janusz-lece");
		data.put("accountkey", "U9ZjcTjsMS8dMOZBzbAG");

		var request = HttpRequest.newBuilder()
				.POST(ofFormData(data))
				.uri(URI.create("https://a2.wykop.pl/login/index/appkey/sdGD9IZKxP/"))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("apisign", "a95794de0807a0eb24fc5b8192bab28e")
				.build();

		CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		HttpResponse<String> response = httpResponseCompletableFuture.join();
		System.out.println("Resoonse Status = " + response.statusCode());
		System.out.println("Resoonse Body = " + response.body());
//				.thenApply(HttpResponse::body)
//				.exceptionally(e -> "Error: " + e.getMessage()).join();
//		System.out.println("join = " + join);
	}

	public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
		var builder = new StringBuilder();
		for (Map.Entry<Object, Object> entry : data.entrySet()) {
			if (builder.length() > 0) {
				builder.append("&");
			}
			builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
			builder.append("=");
			builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
		}
		return HttpRequest.BodyPublishers.ofString(builder.toString());
	}
}
