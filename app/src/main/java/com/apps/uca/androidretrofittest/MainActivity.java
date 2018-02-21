package com.apps.uca.androidretrofittest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import com.apps.uca.androidretrofittest.Api.Api;
import com.apps.uca.androidretrofittest.adapters.isiAdapter;
import com.apps.uca.androidretrofittest.models.PostPage;
import com.apps.uca.androidretrofittest.models.Posts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        configureRecyclerView();
        fetchHttpRequest();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void configureRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void fetchHttpRequest() {
        Call<PostPage> call = Api.instance().getPosts()  ;
        call.enqueue(new Callback<PostPage>() {
            @Override
            public void onResponse(@NonNull Call<PostPage> call, Response<PostPage> response) {
                if (response.body() != null) {
                    isiAdapter isiAdapter = new isiAdapter(response.body());
                    recyclerView.setAdapter(isiAdapter);
                }
            }
            @Override
            public void onFailure(@NonNull Call<PostPage> call, @NonNull Throwable t) {
                Log.i("Debug: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}