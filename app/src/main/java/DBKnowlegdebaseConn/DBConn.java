package DBKnowlegdebaseConn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Michel on 11/10/17.
 */

public class DBConn {

    public static String postData(String urlUser, String parameterUser) {

        URL url;
        HttpURLConnection connection = null;

        try {

            url = new URL(urlUser);

            //Open connection
            connection = (HttpURLConnection) url.openConnection();

            //Setting up
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Lenght", "" + Integer.toString(parameterUser.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            //Disable connection cache //Only allows online DB connection
            connection.setUseCaches(false);

            //Enable IN/OUT data
            connection.setDoInput(true);
            connection.setDoOutput(true);


            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(parameterUser);
            dataOutputStream.flush();
            dataOutputStream.close();

/*
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "UTF8");
            OutputStreamWriter.write(parameterUser);
            OutputStreamWriter.flush();
*/
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            boolean line;
            StringBuffer response = new StringBuffer();

            while (line = bufferedReader.readLine() != null) {

                response.append(line);
                response.append('\r');
            }

            bufferedReader.close();

            return response.toString();

        } catch (Exception e) {

            return null;

        } finally {

            if (connection != null) {

                connection.disconnect();

            }

        }

    }

}
