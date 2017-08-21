package com.example.pushpika.mobileresturant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
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

import org.json.JSONArray;

import java.text.DateFormat;
import java.util.Date;
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
    String HttpUrl2 = "https://mobirest.000webhostapp.com/insert_items.php";

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,TotalOrderActivity.class);
        startActivity(intent);
        finish();
    }

    // Creating method to get value from EditText.
    public void GetValueFromEditText(){

        nameHolder = nameText.getText().toString().trim();
        placeHolder = placeText.getText().toString().trim();
        contactHolder = contactText.getText().toString().trim();
        totalHolder = totalText.getText().toString().trim();

    }

    public void goOrder(View view){
        Intent intent = new Intent(this,TotalOrderActivity.class);
        startActivity(intent);
        finish();
    }

    public void goSendOrder(final View view){
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");

        // Calling method to get value from EditText.
        GetValueFromEditText();

        //check validity
        if (TextUtils.isEmpty(nameHolder)) {
            nameText.setError(getString(R.string.error_field_required));
            return;
        }

        if (TextUtils.isEmpty(placeHolder)) {
            placeText.setError(getString(R.string.error_field_required));
            return;
        }

        if (TextUtils.isEmpty(contactHolder)) {
            contactText.setError(getString(R.string.error_field_required));
            return;
        }

        if (contactHolder.length()!=10) {
            contactText.setError(getString(R.string.error_contact));
            return;
        }

        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        //Integer.parseInt(ServerResponse)==0 error
                        sendItems(view, Integer.parseInt(ServerResponse));
                        // Showing response message coming from server.
                        //Toast.makeText(DeliveryActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(DeliveryActivity.this, "There is an error with internet connection", Toast.LENGTH_LONG).show();
                        //Toast.makeText(DeliveryActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                Log.d("Delivery activity","TimeDate"+currentDateTimeString);

                // Adding All values to Params.
                params.put("Name", nameHolder);
                params.put("Place", placeHolder);
                params.put("Contact", contactHolder);
                params.put("Total", totalHolder);
                params.put("DataTime",currentDateTimeString);
                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(DeliveryActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

    public void sendItems(View view, final int orderID){
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Sending your order");
        progressDialog.show();
        final Intent intent = new Intent(this,ThankActivity.class);
        // Calling method to get value from EditText.
        GetValueFromEditText();

        // Creating string request with post method.
        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, HttpUrl2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing response message coming from server.
                        //Toast.makeText(DeliveryActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        MainActivity.orderList.clear();
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(DeliveryActivity.this, "There is an error with internet connection", Toast.LENGTH_LONG).show();
                        //Toast.makeText(DeliveryActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                String item_array ="",quantity_array="",price_array="",total_line_array="";

                for (int i = 0; i < MainActivity.orderList.size(); i++) {

                    item_array = item_array + "," + (String.valueOf(MainActivity.orderList.get(i).getId()));
                    quantity_array = quantity_array + "," + (String.valueOf(MainActivity.orderList.get(i).getQuantity()));
                    price_array = price_array + "," + (String.valueOf(MainActivity.orderList.get(i).getPrice()));
                    total_line_array = total_line_array + "," + (String.valueOf(MainActivity.orderList.get(i).getQuantity()*MainActivity.orderList.get(i).getPrice()));

                }

                params.put("Order_ID",String.valueOf(orderID));
                params.put("Array_Length",String.valueOf(MainActivity.orderList.size()));
                params.put("Item_Array",item_array);
                params.put("Quantity_Array",quantity_array);
                params.put("Price_Array",price_array);
                params.put("Total_Line_Array",total_line_array);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(DeliveryActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest2);

    }

}

