package com.example.admin.prova;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton BtnLogIn = (ImageButton) findViewById(R.id.btnLogIn);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutLogin);
        //TextInputEditText inputEditTextUser = (TextInputEditText) findViewById(R.id.editTextUser);
        final EditText EditTextUser = (EditText) findViewById(R.id.editTextUser);
        final EditText EditTextPassword = (EditText) findViewById(R.id.editTextPass);


        BtnLogIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String user = EditTextUser.getText().toString();
                String pass = EditTextPassword.getText().toString();


                    LogIn log = new LogIn(user,pass);

                    JSONArray ArrayLogin = new JSONArray();
                    JSONObject jLogin = new JSONObject();
                    try {
                        jLogin.put("username",log.getUsername());
                        jLogin.put("Password",log.getPassword());

                        //add to JSON array
                        ArrayLogin.put(jLogin);
                        Log.d("json api","Json array converted from login " + ArrayLogin.toString() );

                        String JsonData= ArrayLogin.toString();

                        new DoCreateLogin().execute(JsonData);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



            }


        });
    }

}
class LogIn
{
    private String username;
    private String Password;

    public LogIn(String username, String Password)
    {
        this.username = username;
        this.Password=Password;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return username;
    }
}

class DoCreateLogin  extends AsyncTask<String, Void, Void>

{

    @Override
    protected Void doInBackground(String... Params) {
            String JsonData = Params[0];


        try {

            //Creates http url connection
            URL url = new URL("http://192.168.134.137/REST/index_login.php");
            HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();

            //sets http url connection settings
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.getResponseCode();

            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);

            httpurlconnection.connect();

            //send data
            OutputStream out = (DataOutputStream) httpurlconnection.getOutputStream();
            out.write(JsonData.getBytes());

            //get & read data response
          InputStream in =  httpurlconnection.getInputStream();
            String result= "";
            int byteCharacter;

            while((byteCharacter= in.read())!=-1)
            {
                result += (char) byteCharacter;

            }

            Log.d("json api","DoCreateLogIn.doInBackGround Json return: " + result);
            in.close();
            out.close();
            httpurlconnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


}




