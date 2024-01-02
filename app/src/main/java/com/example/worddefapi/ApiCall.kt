package com.example.worddefapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiCall {

    companion object{

        private const val BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com/"
        fun makeAPiCall(): ApiService
        {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)

        }
    }
}