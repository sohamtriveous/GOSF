package com.soham.gosf;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.soham.gosf.network.APIClient;
import com.soham.gosf.network.model.GOSFDeals;
import com.soham.gosf.ui.DealsAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
    private View progressBar;
    private ListView listView;
    private DealsAdapter dealsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar);
        listView = (ListView) findViewById(R.id.listview);

        APIClient.getApi().getDeals(new Callback<GOSFDeals>() {
            @Override
            public void success(GOSFDeals gosfDeals, Response response) {
                if (gosfDeals != null) {
                    dealsAdapter = new DealsAdapter(gosfDeals.getResults().getCollection1(), MainActivity.this);
                    listView.setAdapter(dealsAdapter);
                    listView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                if (error != null) {
                    Toast.makeText(MainActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error: null error", Toast.LENGTH_SHORT).show();
                }
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
