package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        int responseCode = connection.getResponseCode();

        System.out.println("Image URL for status code "+code+": " + url);

        if (responseCode == 404) {
            throw new IOException("Image not found for status code " + code);
        }
        return url;
    }
}