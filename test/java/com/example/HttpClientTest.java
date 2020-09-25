package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class HttpClientTest {

    @Test
    public void test() throws IOException {
        HttpGet request = new HttpGet("https://www.google.com");
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(request);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
    }
}
