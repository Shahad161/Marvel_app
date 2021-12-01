package com.example.marvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.marvel.R
import com.example.marvel.data.local.MarvelDataBase
import com.example.marvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).also { binding ->
            binding.lifecycleOwner=this
        }
        MarvelDataBase.init(applicationContext)
    }


//    override fun onResume() {
//        super.onResume()
//        binding.navigation
//            .setupWithNavController(findNavController(R.id.fragment_host))
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        findNavController(R.id.fragment_host).navigateUp()
//        return true
//    }
}