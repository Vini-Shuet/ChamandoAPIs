package TheMealDB;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class TheMealDB {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite uma receita para busca: ");
		var receita = teclado.next(); // var ja entende que e String

		String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + receita;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		// exibir o corpo da resposta
		System.out.println(response.body());

	}
	
}
