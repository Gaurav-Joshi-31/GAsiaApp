package com.example.gasia.Repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.gasia.Dao.CountryDao;
import com.example.gasia.Database.CountryDatabase;
import com.example.gasia.models.Country;

import java.util.List;

public class Repository {
    public CountryDao countryDao;
    public LiveData<List<Country>> getAllCountry;
    private CountryDatabase database;


    public Repository(Application application){
        database=CountryDatabase.getInstance(application);
        countryDao=database.countryDao();
        getAllCountry=countryDao.getAllCountry();

    }

    public void insert(List<Country> countries){

        new InsertAsyncTask(countryDao).execute(countries);
    }

    public void deleteAll(){
        new deleteAllWordsAsyncTask(countryDao).execute();
    }

    public LiveData<List<Country>> getAllCountry(){
        return getAllCountry;
    }


    private static class InsertAsyncTask extends AsyncTask<List<Country>,Void,Void> {
        private CountryDao countryDao;

        public InsertAsyncTask(CountryDao countryDao)
        {
            this.countryDao=countryDao;
        }

        @Override
        protected Void doInBackground(List<Country>... lists) {
            countryDao.insert(lists[0]);
            return null;
        }
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private CountryDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(CountryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }
}
