package sk.sandeep.animeapp.ui.screens.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import sk.sandeep.animeapp.R
import sk.sandeep.animeapp.databinding.ActivityAnimeBinding

class AnimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityAnimeBinding>(this, R.layout.activity_anime)
    }
}

/*
class AnimeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_anime)
    }
}*/
