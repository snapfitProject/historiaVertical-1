package com.example.admin.prova;

import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView snaplogo = (ImageView) findViewById(R.id.SnapLogo);
        ImageButton submitbutton = (ImageButton) findViewById(R.id.submitButton2);
        ImageButton cancelbutton = (ImageButton) findViewById(R.id.cancelButton);

       // password.setTransformationMethod(new);

        snaplogo.getLayoutParams().height = 100;
        snaplogo.getLayoutParams().width  = 100;

        submitbutton.getLayoutParams().height = 75;
        submitbutton.getLayoutParams().width  = 100;

        cancelbutton.getLayoutParams().height = 70;
        cancelbutton.getLayoutParams().width  = 95;

        snaplogo.setImageResource(R.drawable.logo256);
        submitbutton.setImageResource(R.drawable.subbutton);
        cancelbutton.setImageResource(R.drawable.cancel);



    }

}
