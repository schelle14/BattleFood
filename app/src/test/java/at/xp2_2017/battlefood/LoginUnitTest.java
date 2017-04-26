package at.xp2_2017.battlefood;



import org.junit.Test;

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

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUnitTest {


    @Test
    public void testLogin()
    {
      int f = LoginController.shit(5);
        assertEquals(10,f);
    }

    @Test
    public void testLogin2()
    {
       HttpURLConnection httpURLConnection = DBHelpFunctions.getConnection("http://sewxp2.bplaced.net/login.php");
       httpURLConnection.disconnect();

    }

}