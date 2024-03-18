package pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaAPICallWithJavaLib {

    public static void getMethod() throws IOException {

        URL url = new URL("https://reqres.in/api/users?page=2");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuffer sp = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            sp.append(line);
        }
        System.out.println(sp);

    }

    public static void postMethod() throws IOException {

        URL url = new URL("https://reqres.in/api/users");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(("{\n\"name\": \"Dhivaagar\",\n\"job\": \"Automation\"\n}").getBytes());

        connection.connect();
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuffer sp = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            sp.append(line);
        }
        System.out.println(sp);

    }

    public static void putMethod() throws IOException {

        URL url = new URL("https://reqres.in/api/users/979");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(("{\n\"name\": \"Dhivaagar\",\n\"job\": \"Automation\"\n}").getBytes());

        connection.connect();
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuffer sp = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            sp.append(line);
        }
        System.out.println(sp);

    }

    public static void deleteMethod() throws IOException {

        URL url = new URL("https://reqres.in/api/users/979");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();

        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer sp = new StringBuffer();

        while ((line = bufferedReader.readLine()) != null) {
            sp.append(line);
        }
        System.out.println(sp);

    }

    public static void main(String[] args) throws IOException {
        JavaAPICallWithJavaLib.getMethod();
//        JavaAPICallExample.postMethod(); //979
        JavaAPICallWithJavaLib.deleteMethod();
    }

}
