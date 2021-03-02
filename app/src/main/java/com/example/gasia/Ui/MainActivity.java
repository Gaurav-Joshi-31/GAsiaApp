package com.example.gasia.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gasia.Adapters.Adapter;
import com.example.gasia.Api.ApiService;
import com.example.gasia.R;
import com.example.gasia.Repo.Repository;
import com.example.gasia.Viewmodel.CountryViewModel;
import com.example.gasia.models.Country;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Country> getCountryList;
    private Adapter adapter;
    public ProgressBar progress;
    private Repository repository;
    private CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository(getApplication());
        getCountryList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        progress = findViewById(R.id.progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        adapter = new Adapter(this, getCountryList);
        recyclerView.setAdapter(adapter);
        countryViewModel.getAllCountry().observe(this, countries -> {
            adapter.setData(countries);
            progress.setVisibility(View.GONE);

        });
        getData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                deleteAll();
                Toast.makeText(getApplicationContext(), "All data deleted", Toast.LENGTH_LONG).show();


        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteAll() {
        countryViewModel.deleteAll();
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Country>> call = apiService.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    countryViewModel.insert(response.body());

                }

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("main", "onFailure: " + t.getMessage());
            }
        });
    }
}