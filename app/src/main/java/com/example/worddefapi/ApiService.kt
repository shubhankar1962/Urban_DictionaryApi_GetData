package com.example.worddefapi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

   @GET("define")
   fun getDefination(
       @Query("term") term:String,
       @Header("X-RapidAPI-Key") apiKey: String,
       @Header("X-RapidAPI-Host") apiHost: String
   ):Call<Words>

}