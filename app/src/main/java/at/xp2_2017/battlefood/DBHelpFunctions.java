package at.xp2_2017.battlefood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Michael on 29.03.2017.
 */

public class DBHelpFunctions {

    public static HttpURLConnection getConnection(String url_string) {
        try {
            URL url = new URL(url_string);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            return httpURLConnection;

        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeToConnection(HttpURLConnection httpURLConnection, String parse_text) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(parse_text);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String readFromConnection(HttpURLConnection httpURLConnection) {
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();

            return result;
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return "";
    }

    public static void closeConnection(HttpURLConnection httpURLConnection) {
        httpURLConnection.disconnect();
    }

}

