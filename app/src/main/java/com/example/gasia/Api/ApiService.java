package com.example.gasia.Api;

import com.example.gasia.models.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("rest/v2/region/asia")
    Call<List<Country>> getCountries();
}
