package at.xp2_2017.battlefood;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

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

public class LoginModel extends AsyncTask<String, Void, String>{
    Context context;

    LoginModel(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            HttpURLConnection httpURLConnection = DBHelpFunctions.getConnection("http://sewxp2.bplaced.net/login.php");
            DBHelpFunctions.writeToConnection(httpURLConnection,
                    URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8") + "&" +
                    URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8"));
            result = DBHelpFunctions.readFromConnection(httpURLConnection);
            DBHelpFunctions.closeConnection(httpURLConnection);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(String result) {

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
