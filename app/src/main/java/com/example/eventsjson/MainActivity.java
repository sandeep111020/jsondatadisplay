package com.example.eventsjson;


import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.eventsjson.Adapters.MyAdapter;
import com.example.eventsjson.Adapters.eventsAdapter;
import com.example.eventsjson.Models.eventsmodel;
import com.example.eventsjson.Models.placesmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView listView;
    TwoWayView listViewevents;
    private final static String url = "http://www.json-generator.com/api/json/get/clKeRRnWWa?indent=2";
    private final static String urlevents = "http://www.json-generator.com/api/json/get/bQyhMwyTQO?indent=2";

    //the tutorial list where we will store all the tutorial objects after parsing json
    List<placesmodel> tutorialList;
    List<eventsmodel> eventlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (GridView) findViewById(R.id.listView);
        tutorialList = new ArrayList<>();
        eventlist = new ArrayList<>();
        //this method will fetch and parse the data
        loadTutorialList();
        listViewevents= findViewById(R.id.listviewevents);
/*
        listViewevents.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
*/
        loadTutorialListevents();
    }

    private void loadTutorialList() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named tutorial inside the object
                            //so here we are getting that json array
                            JSONArray tutorialsArray = obj.getJSONArray("places");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < tutorialsArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject tutorialsObject = tutorialsArray.getJSONObject(i);

                                //creating a tutorial object and giving them the values from json object
                                placesmodel tutorial = new placesmodel(tutorialsObject.getString("name"), tutorialsObject.getString("image"));

                                //adding the tutorial to tutoriallist
                                tutorialList.add(tutorial);
                            }

                            //creating custom adapter object
                            MyAdapter adapter = new MyAdapter(tutorialList, getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occur
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
    private void loadTutorialListevents() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlevents,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named tutorial inside the object
                            //so here we are getting that json array
                            JSONArray tutorialsArray = obj.getJSONArray("events");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < tutorialsArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject tutorialsObject = tutorialsArray.getJSONObject(i);

                                //creating a tutorial object and giving them the values from json object
                                eventsmodel tutorial = new eventsmodel(tutorialsObject.getString("name"), tutorialsObject.getString("image"),tutorialsObject.getString("date"),tutorialsObject.getString("place"),tutorialsObject.getString("fee"));

                                //adding the tutorial to tutoriallist
                                eventlist.add(tutorial);
                            }

                            //creating custom adapter object
                            eventsAdapter adapter = new eventsAdapter(eventlist, getApplicationContext());

                            //adding the adapter to listview
                            listViewevents.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occur
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
}

