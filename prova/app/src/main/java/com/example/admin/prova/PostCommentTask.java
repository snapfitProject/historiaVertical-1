package com.example.admin.prova;

import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import static android.widget.Toast.*;


public class PostCommentTask extends AsyncTask<Void, Void, Void>

{


    @Override
    protected Void doInBackground(Void ... Params) {

        //HttpURLConnection con = null;

       // try {

           /* URL url = new URL("http://192.168.134.137/REST/login.php");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("username", username);
            params.put("Password", Password);


            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet())
            {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (int c; (c = in.read()) >= 0;)
                sb.append((char)c);
            String response = sb.toString();

            Context context = null;
            context.getApplicationContext();
            */



           // Toast.makeText(context,response, Toast.LENGTH_LONG).show();
            /*String parammeters = "username="+username+"&Password="+ Password;

            con = (HttpURLConnection)urls[0].openConnection();
            con.connect();
            con.setDoOutput(true);
            con.setInstanceFollowRedirects(false);
            con.setRequestMethod( "POST" );
            con.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");

            OutputStream out = new BufferedOutputStream(con.getOutputStream());



            out.write(parammeters.getBytes());

            out.flush();
            out.close();*/

       // } catch (IOException e) {
         //   e.printStackTrace();
        //}

        return null;

    }

    protected void onPostExecute(Void s) {


        //Toast.makeText(getBaseContext(), "Comentario posteado", Toast.LENGTH_LONG).show();
    }


   /* public  void setUsername(String username) {
        this.username = username;

    }

    public void setPassword(String password) {
        this.Password = password;
    }*/
}
