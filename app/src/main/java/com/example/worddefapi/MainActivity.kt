package com.example.worddefapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import android.util.Log
import com.example.worddefapi.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
//    private var defination:String? = null
//    private var wordtitle:String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.getDataBtn.setOnClickListener {
        val word = binding.serchword.text.toString()
        val service = ApiCall.makeAPiCall()

        val response = service.getDefination(word,"e848d78ccbmshcda6467b31b2c48p1b520djsn2375a290d03e", "mashape-community-urban-dictionary.p.rapidapi.com")

        GlobalScope.launch {Dispatchers.IO
            response.enqueue(object : retrofit2.Callback<Words> {
                override fun onResponse(call: Call<Words>, response: Response<Words>) {
                    Log.e("TAG", response.body().toString())
                    binding.word.text = response.body()?.list?.get(0)?.word.toString()
                    binding.defination.setText(response.body()?.list?.get(0)?.definition.toString())

                }

                override fun onFailure(call: Call<Words>, t: Throwable) {
                    Log.e("TAG", "onFailure: failed")
                }

            })
        }
//


    }

    }

//    private fun getData(word:String) {
//        binding.word.setText(wordtitle)
//        binding.defination.setText(defination)
//    }
}