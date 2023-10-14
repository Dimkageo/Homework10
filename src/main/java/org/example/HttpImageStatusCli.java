package org.example;
import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private HttpStatusChecker checker;
    private HttpStatusImageDownloader downloader;

    public HttpImageStatusCli() {
        checker = new HttpStatusChecker();
        downloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter HTTP status code:");

        try {
            int statusCode = scanner.nextInt();
            String imageUrl = checker.getStatusImage(statusCode);

            try {
                downloader.downloadStatusImage(imageUrl);
                System.out.println("Image downloaded successfully!");
            } catch (IOException e) {
                System.err.println("There is not image for HTTP status " + statusCode);
            }
        } catch (Exception e) {
            System.err.println("Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
