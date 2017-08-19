package com.example.pushpika.mobileresturant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DeliveryActivity extends AppCompatActivity {
    private EditText nameText, placeText, contactText;
    private TextView totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }

        nameText = (EditText) findViewById(R.id.nameText);
        placeText = (EditText) findViewById(R.id.placeText);
        contactText = (EditText) findViewById(R.id.contactText);
        totalText = (TextView) findViewById(R.id.totalText);

        totalText.setText(" LKR : "+TotalOrderActivity.fullAmount);
    }

    public void goOrder(View view){

    }

    public void goSendOrder(View view){

    }
}
