package moex

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RequestSender {
    private val _client = HttpClient.newBuilder().build();

    fun Send(request: Request) : HttpResponse<String>{
        val body = request.body
        val request = HttpRequest.newBuilder()
            .uri(URI.create(body))
            .build()

        val response = _client.send(request, HttpResponse.BodyHandlers.ofString());

        return response
    }
}