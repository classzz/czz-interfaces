package com.classzz.czzinterfaces.utils;

import com.classzz.czzinterfaces.CzzConstants;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;

public class HttpUtil {

    public static String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// Returns the result string
        try {
            // Create a remote url connection object
            URL url = new URL(httpurl);
            // Open a connection through the remote url connection object, strong into the httpURLConnection class
            connection = (HttpURLConnection) url.openConnection();
            // Set connection mode: get
            connection.setRequestMethod("GET");
            // Set the timeout time for connecting to the host server: 15,000 milliseconds
            connection.setConnectTimeout(15000);
            // Set the time to read the data returned remotely: 60,000 milliseconds
            connection.setReadTimeout(60000);
            // Send the request
            connection.connect();
            // The input stream is obtained through a connection
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // Encapsulates the input stream is and specifies the character set
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // To store data
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();
        }

        return result;
    }

    public static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // Open the connection through the remote url connection object
            connection = (HttpURLConnection) url.openConnection();
            // Set the connection request mode
            connection.setRequestMethod("POST");
            // Set the connection timeout time for the host server: 15000 milliseconds
            connection.setConnectTimeout(15000);
            // Set the read host server return data timeout time: 60,000 milliseconds
            connection.setReadTimeout(60000);

            // The default value is: false, which needs to be set to true when sending/writing data to the remote server
            connection.setDoOutput(true);
            // The default value is: true, which is set to true when the data is currently being read from the remote service. This parameter is optional
            connection.setDoInput(true);
            // Set the format of the incoming parameters: the request parameters should be in the form name1=value1&name2=value2.
            connection.setRequestProperty("Content-Type", "application/json");

            String auth = CzzConstants.NODE_URL_USERNAME +":"+CzzConstants.NODE_URL_PASSWD;
            // Encrypt it
            byte[] rel = Base64.encodeBase64(auth.getBytes());
            String res = new String(rel);
            // Set authentication properties
            connection.setRequestProperty("Authorization","Basic " + res);

            // Gets an output stream through the connection object
            os = connection.getOutputStream();
            // The parameters are written out/transmitted through the output stream object, which is written out through a byte array
            os.write(param.getBytes());
            // Get an input stream through the connection object and read it remotely
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // Wrap the input stream object :charset is set according to the requirements of the work team
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // Loop through row by row to read the data
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();
        }
        return result;
    }


}