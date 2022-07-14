package ru.timcock.mayday.data;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestBuilder {
    static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .baseUrl("")
            .build();

    static RequestsInterface buildService() {
        return retrofit.create(RequestsInterface.class);
    }
}
