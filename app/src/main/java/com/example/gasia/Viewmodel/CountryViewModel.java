package com.example.gasia.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gasia.Repo.Repository;
import com.example.gasia.models.Country;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {
    private Repository repository;
    public LiveData<List<Country>> getAllCountry;


    public CountryViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        getAllCountry=repository.getAllCountry();
    }

    public void insert(List<Country> country){
        repository.insert(country);
    }

    public void deleteAll(){
        repository.deleteAll();
    }



    public LiveData<List<Country>> getAllCountry()
    {
        return getAllCountry;
    }
}
