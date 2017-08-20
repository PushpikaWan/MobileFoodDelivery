package com.example.pushpika.mobileresturant;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DeliveryActivity extends AppCompatActivity {
    private EditText nameText, placeText, contactText;
    private TextView totalText;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String nameHolder, placeHolder , contactHolder , totalHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "https://mobirest.000webhostapp.com/insert_record.php";

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
        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(DeliveryActivity.this);

        progressDialog = new ProgressDialog(DeliveryActivity.this);
    }

    // Creating method to get value from EditText.
    public void GetValueFromEditText(){

        nameHolder = nameText.getText().toString().trim();
        placeHolder = placeText.getText().toString().trim();
        contactHolder = contactText.getText().toString().trim();
        totalHolder = totalText.getText().toString().trim();

    }

    public void goOrder(View view){

    }

    public void goSendOrder(View view){
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
        progressDialog.show();

        // Calling method to get value from EditText.
        GetValueFromEditText();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing response message coming from server.
                        Toast.makeText(DeliveryActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(DeliveryActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("Name", nameHolder);
                params.put("Place", placeHolder);
                params.put("Contact", contactHolder);
                params.put("Total", totalHolder);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(DeliveryActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

}
