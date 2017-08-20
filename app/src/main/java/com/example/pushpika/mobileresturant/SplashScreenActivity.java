package com.example.pushpika.mobileresturant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Manifest;

public class SplashScreenActivity extends AppCompatActivity {

    public static List<ItemObject> breakfastItemList = new ArrayList<>();
    public static List<ItemObject> lunchItemList = new ArrayList<>();
    public static List<ItemObject> shorteatsItemList = new ArrayList<>();
    public static List<ItemObject> drinksItemList = new ArrayList<>();
    public static List<ItemObject> desertItemList = new ArrayList<>();
    public static List<ItemObject> fruitsItemList = new ArrayList<>();
    public static List<ItemObject> fruitJuiceItemList = new ArrayList<>();

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "https://mobirest.000webhostapp.com/request_items.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(SplashScreenActivity.this);

        progressDialog = new ProgressDialog(SplashScreenActivity.this);
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
                        Toast.makeText(SplashScreenActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Splasch screen","Server error Response"+volleyError);
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
        RequestQueue requestQueue = Volley.newRequestQueue(SplashScreenActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

    private void showJSON(String response){

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            for(int i = 0; i < result.length(); i++){

                final ItemObject item = new ItemObject(result.getJSONObject(i).getInt("Item_ID"),result.getJSONObject(i).getString("Name"),
                        result.getJSONObject(i).getString("Category"),Float.valueOf(result.getJSONObject(i).getString("Price")),
                        1,false,result.getJSONObject(i).getInt("Item_ID"));

                if(result.getJSONObject(i).getString("Category").equals("Breakfast")){
                    SplashScreenActivity.breakfastItemList.add(item);
                }
                else if(result.getJSONObject(i).getString("Category").equals("Lunch")){
                    SplashScreenActivity.lunchItemList.add(item);
                }
                else if(result.getJSONObject(i).getString("Category").equals("Shorteats")){
                    SplashScreenActivity.shorteatsItemList.add(item);
                }
                else if(result.getJSONObject(i).getString("Category").equals("Drinks")){
                    SplashScreenActivity.drinksItemList.add(item);
                }
                else if(result.getJSONObject(i).getString("Category").equals("Deserts")){
                    SplashScreenActivity.desertItemList.add(item);
                }
                else if(result.getJSONObject(i).getString("Category").equals("Fruits")){
                    SplashScreenActivity.fruitsItemList.add(item);
                }
                else if(result.getJSONObject(i).getString("Category").equals("Fruit Juice")){
                    SplashScreenActivity.fruitJuiceItemList.add(item);
                }
                else{
                    Log.d("Splash screen","category mis"+result.getJSONObject(i).getString("Category"));
                }

            }

            JSONObject item_data = result.getJSONObject(0);
            Log.d("Splash screen ","Server respons item name"+item_data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent intents = new Intent(this, MainActivity.class);
        startActivity(intents);
        finish();
    }
}
