package com.example.admin.prova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ImageView logoPagPrin = (ImageView) findViewById(R.id.LogoPagPrincipal);
        ImageButton BtnLogIn = (ImageButton) findViewById(R.id.btnLogIn);
        ImageButton BtnSignIn = (ImageButton) findViewById(R.id.btnSignIn);

        logoPagPrin.setImageResource(R.drawable.logo256);
        BtnLogIn.setImageResource(R.drawable.login);
        BtnSignIn.setImageResource(R.drawable.signup);
    }
}
