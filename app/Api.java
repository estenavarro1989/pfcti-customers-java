import java.net.http.*;
import java.net.URI;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;

public class Api {
    private static String baseUrl = "http://localhost:8080/api/customers";

    public static boolean addCustomer(Customer customer) {
        String url = baseUrl;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(url))
                    .POST(BodyPublishers.ofString(customer.toString()))
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                return true;
            } else {
                System.out.println(Helper.formatErrors(response.body()));
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean editCustomer(String id, Customer customer) {
        String url = baseUrl + "/" + id;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(url))
                    .PUT(BodyPublishers.ofString(customer.toString()))
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                return true;
            } else {
                System.out.println(Helper.formatErrors(response.body()));
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteCustomer(String id) {
        String url = baseUrl + "/" + id;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(url))
                    .DELETE()
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                return true;
            } else {
                System.out.println(Helper.formatErrors(response.body()));
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean getCustomerById(String id) {
        String url = baseUrl + "/" + id;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println(Helper.formatResponse(response.body()));
                return true;
            } else {
                System.out.println(response.body());
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean getCustomersList(String orderParam) {
        String url = baseUrl + "/" + orderParam;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println(Helper.formatResponse(response.body()));
                return true;
            } else {
                System.out.println(response.body());
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
