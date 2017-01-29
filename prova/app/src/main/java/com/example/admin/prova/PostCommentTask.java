package com.example.admin.prova;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class PostCommentTask extends AsyncTask<URL, Void, Void>

{


    String username;
    String password;



    @Override
    protected Void doInBackground(URL... urls) {

        HttpURLConnection con = null;

        try {



            con = (HttpURLConnection)urls[0].openConnection();


            con.setDoOutput(true);


            OutputStream out = new BufferedOutputStream(con.getOutputStream());

            out.write(username.getBytes());
            out.write(password.getBytes());
            out.flush();
            out.close();




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(con!=null)
                con.disconnect();
        }

        return null;

    }

    protected void onPostExecute(Void s) {


        //Toast.makeText(getBaseContext(), "Comentario posteado", Toast.LENGTH_LONG).show();
    }


    public  void setUsername(String username) {
        this.username = username;

    }

    public void setPassword(String password) {
        this.password = password;
    }
}
