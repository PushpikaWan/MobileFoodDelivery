package com.example.pushpika.mobileresturant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminViewOrderActivity extends AppCompatActivity {

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "https://mobirest.000webhostapp.com/request_orders.php";

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_order);

        linearLayout = (LinearLayout) findViewById(R.id.order_linear_layout);
        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(AdminViewOrderActivity.this);

        progressDialog = new ProgressDialog(AdminViewOrderActivity.this);
        requestData();
    }


    public void requestData(){
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are retrieving Data from Server");
        progressDialog.show();

        // Creating string request with post method.
        //JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, HttpUrl,null,
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        showJSON(ServerResponse);
                        // Showing response message coming from server.
                        // Toast.makeText(SplashScreenActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(AdminViewOrderActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Admin order screen","Server error Response"+volleyError);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                params.put("Request", "All data");

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(AdminViewOrderActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response){

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            int curIndex = 0;

            for(int i = 0; i < result.length(); i++){
                if(Integer.parseInt(result.getJSONObject(i).getString("Order_ID"))==curIndex){
                    //add item card
                    final TextView rowTextView = new TextView(this);

                    // set some properties of rowTextView or something
                    rowTextView.setText("\n"+result.getJSONObject(i).getString("ItemName")+ "   "+ result.getJSONObject(i).getString("Quantity")+
                            "   "+" X "+"   "+result.getJSONObject(i).getString("Price")+ "   --------> "+result.getJSONObject(i).getString("TotalLine"));

                    // add the textview to the linearlayout
                    linearLayout.addView(rowTextView);

                }
                else{
                    curIndex = Integer.parseInt(result.getJSONObject(i).getString("Order_ID"));

                    //add item card
                    final TextView rowTextView = new TextView(this);

                    // set some properties of rowTextView or something
                    rowTextView.setText("------------------------------------------------------------------------------- \n \n \n Order ID = "+result.getJSONObject(i).getString("Order_ID")+ "   Buyer Name = "+ result.getJSONObject(i).getString("BuyerName")+
                            "    Place = " +result.getJSONObject(i).getString("Place")+ "  Contact = "+result.getJSONObject(i).getString("Contact")+
                            "  \n Total Amount = "+result.getJSONObject(i).getString("Total")+" Date & Time = "+ result.getJSONObject(i).getString("DateTime"));

                    // add the textview to the linearlayout
                    linearLayout.addView(rowTextView);

                    //add item card
                    final TextView rowTextView2 = new TextView(this);

                    // set some properties of rowTextView or something
                    rowTextView2.setText("\n"+result.getJSONObject(i).getString("ItemName")+ "   "+ result.getJSONObject(i).getString("Quantity")+
                            "   "+" X "+"   "+result.getJSONObject(i).getString("Price")+ "   --------> "+result.getJSONObject(i).getString("TotalLine"));

                    // add the textview to the linearlayout
                    linearLayout.addView(rowTextView2);
                }
                Log.d("Admin order screen ","Server response item name : "+ result.getJSONObject(i).getString("ItemName"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

