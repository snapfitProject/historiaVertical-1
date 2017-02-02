package com.example.admin.prova;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        final  EditText editTextPassword = (EditText) findViewById(R.id.editTextUserpassword);
        final EditText editRepeatPassword = (EditText) findViewById(R.id.editRepeatPassword);
        final EditText editTextMail = (EditText) findViewById(R.id.editTextMail);
        final EditText editTextConfirmMail = (EditText) findViewById(R.id.editTextConfirmMail);
        ImageButton buttonSignUp = (ImageButton) findViewById(R.id.btnSignUp);


        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editTextUsername.getText().toString();
                String email = editTextMail.getText().toString();
                String email2 = editTextConfirmMail.getText().toString();
                String password = editTextPassword.getText().toString();
                String password2 = editRepeatPassword.getText().toString();


                signUp user = new signUp(username,email,email2,password,password2);

                JSONArray ArrayUser= new JSONArray();
                JSONObject jUser = new JSONObject();

                try {
                    jUser.put("username",user.getUsername());
                    jUser.put("password",user.getPassword());
                    jUser.put("password2",user.getPassword2());
                    jUser.put("Email", user.getEmail());
                    jUser.put("Email2", user.getEmail2());


                    //add to JSON array
                    ArrayUser.put(jUser);

                    Log.d("json api","Json array converted from SignUP " + ArrayUser.toString() );

                    String JsonData= ArrayUser.toString();

                    new DoCreateSignUp().execute(JsonData);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
class signUp
{
    private String username;
    private String password;
    private String password2;
    private String email;
    private String email2;


    public signUp(String username, String password, String password2, String email, String email2)
    {
        this.username   = username;
        this.password   = password;
        this.password2  = password2;
        this.email      = email;
        this.email2     = email2;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }
    public String getPassword2(){

        return password2;
    }
    public String getEmail (){

        return email;
    }
    public String getEmail2() {

        return email2;
    }
}

class DoCreateSignUp extends AsyncTask< String, Void, Void>
{



    protected Void doInBackground(String... Params) {

        String JsonData = Params[0];


        try {

            //Creates http url connection
            URL url = new URL("http://192.168.134.137/REST/register.php");

            HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();

            //sets http url connection settings
            httpurlconnection.setRequestMethod("POST");

            httpurlconnection.setDoOutput(true);
            httpurlconnection.setDoInput(true);

            httpurlconnection.connect();

            //send data
            OutputStream out = httpurlconnection.getOutputStream();
            out.write(JsonData.getBytes());

            //get & read data response

            InputStream in =  httpurlconnection.getInputStream();
            String result= "";


            StringBuilder sb = new StringBuilder();

            try {

                int chr;

                while ((chr = in.read()) != -1)
                {
                    sb.append((char) chr);
                }
                result = sb.toString();

            } finally {
                in.close();
            }
           /* while((byteCharacter= in.read())!=-1)
            {
                result += (char) byteCharacter;

            }*/

            Log.d("json api","DoCreateSignUp.doInBackGround Json return: " + result);

            out.close();
            httpurlconnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
