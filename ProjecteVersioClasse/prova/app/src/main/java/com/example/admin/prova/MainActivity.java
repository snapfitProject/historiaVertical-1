package com.example.admin.prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        ImageView logoPagPrin = (ImageView) findViewById(R.id.LogoPagPrincipal);
        ImageButton BtnLogIn = (ImageButton) findViewById(R.id.btnLogIn);
        ImageButton BtnSignIn = (ImageButton) findViewById(R.id.btnSignIn);

        logoPagPrin.setImageResource(R.drawable.logo256);
        BtnLogIn.setImageResource(R.drawable.login);
        BtnSignIn.setImageResource(R.drawable.signup);

        BtnLogIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        BtnSignIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent1);
            }


        });
    }
}
