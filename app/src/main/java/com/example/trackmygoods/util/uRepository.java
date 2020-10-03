package com.example.trackmygoods.util;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.trackmygoods.data.UserLogin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uRepository {

    private List<UserLogin> userLoginlist;
    private UserLogin userLogin;

    private RequestQueue requestQueue;
    Boolean userStatus;

    public uRepository(Application application, UserLogin login) {

        userLogin=login;

        userLoginlist = new ArrayList<>();

        requestQueue= Volley.newRequestQueue(application);

        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.9.38:8787/WebAPI/daapi/auth"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.toString().equals("false")) {
                    userLogin.setStatus(true);
                    userStatus = true;
                    Log.d("Repo", "RepoAPI "+userLogin.getStatus());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Repo", "RepoAPIError "+error.toString());
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("user",userLogin.getUserID());
                params.put("password",userLogin.getPassword());
                Log.d("User/Password", "Auth: "+params);

                return params;
            }
        };
        Log.d("Repo", "RepoAPIReq "+userLogin.getStatus());
        userLoginlist.add(userLogin);
        requestQueue.add(request);

    }


        //Log.d("JsonObj", "APIReq: "+request.toString());
/*            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("Content-Type","application/json;charset=utf-8");
                return params;
            }*/
    /*
          JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Constants.URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Repo", "RepoAPI "+response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
*/

    //call API for remmote data
    // Log.d("JsonObj", "JsonReq: "+login.getUserID());
/*
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Constants.URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Repo", "onResponse: "+response);
                *//*try {
                    JSONArray features = response.getJSONArray("features");
                    for(int i=0;i<30;i++) {
                        JSONObject properties = features.getJSONObject(i).getJSONObject("properties");
                        JSONObject geometry = features.getJSONObject(i).getJSONObject("geometry");
                        JSONArray coordinates=geometry.getJSONArray("coordinates");
                        double lon = coordinates.getDouble(0);
                        double lat = coordinates.getDouble(1);
                        Log.d("APIQuake", "Lon: "+lon+", Lat "+lat);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*//*
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });*/


    public Boolean getUserLogin(){
        Log.d("Repo", "GetUser "+userStatus);
        return userLoginlist.get(0).getStatus();
    }
}
