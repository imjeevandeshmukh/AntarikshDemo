package com.bytelogs.antarikshdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NewsActivity extends AppCompatActivity {

    public static String url = "https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=top&apiKey=e9a8e0e55d85480b863d0d4d7517e745";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                News news = gson.fromJson(response,News.class);
                recyclerView.setAdapter(new NewsAdapter(NewsActivity.this,news.getArticles()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
