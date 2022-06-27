package homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final String SERVICE_URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("Test Client")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(SERVICE_URL);
        CloseableHttpResponse response = httpClient.execute(request);

        catsSorted(mapper, response);

        response.close();
        httpClient.close();
    }

    private static void catsSorted(ObjectMapper mapper, CloseableHttpResponse response) throws IOException {
        List<RequestCats> cats = mapper.readValue(
                response.getEntity().getContent(), new TypeReference<List<RequestCats>>() {});
        cats.stream()
                .filter(value -> value.getUpvotes() > 0 && value.getUpvotes() != null)
                .forEach(System.out::println);
    }
}
