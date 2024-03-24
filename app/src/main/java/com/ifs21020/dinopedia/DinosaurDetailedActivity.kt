package com.ifs21020.dinopedia

import Dinosaur
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifs21020.dinopedia.databinding.ActivityDinosaurDetailedBinding

class DinosaurDetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDinosaurDetailedBinding
    private var dino: Dinosaur? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDinosaurDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Membaca data dari intent
        dino = intent.getParcelableExtra(EXTRA_DINO)

        // Menampilkan tombol back di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Memeriksa apakah data dino null atau tidak
        if (dino != null) {
            // Mengatur judul ActionBar sesuai nama dinosaurus
            supportActionBar?.title = dino!!.dinos_name
            // Memuat data ke tampilan
            loadData(dino!!)
        } else {
            // Jika data dino null, maka akhiri aktivitas ini
            finish()
        }

        // Menampilkan tombol kembali di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun loadData(dino: Dinosaur) {
        // Memuat data ke tampilan
        binding.imageViewFamily.setImageResource(dino.dinos_image)
        binding.textViewDinosaurName.text = dino.dinos_name
        binding.textView28.text = dino.dinos_desc
        binding.textView29.text = dino.dinos_characteristic
        binding.textViewb.text = dino.dinos_kelompok
        binding.textView32.text = dino.dinos_habitat
        binding.textView0.text = dino.dinos_makanan
        binding.textViewa.text = dino.dinos_tinggi
        binding.textView11.text = dino.dinos_panjang
        binding.textView25.text = dino.dinos_bobot
        binding.textView12.text = dino.dinos_kelemahan
    }


    companion object {
        const val EXTRA_DINO = "extra_dino"
    }
    fun onBackClicked(view: View) {
        onBackPressed()
    }

    fun onShareClicked(view: View) {
        shareContent()
    }
    private fun shareContent() {
        dino?.let {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Info Dino: ${it.dinos_name}")
            val shareMessage = "Nama Dino: ${it.dinos_name}\n" +
                    "Deskripsi: ${it.dinos_desc}\n" +
                    "Karakteristik: ${it.dinos_characteristic}\n" +
                    "Sel: ${it.dinos_kelompok}\n" +
                    "Habitat: ${it.dinos_habitat}\n" +
                    "Makanan: ${it.dinos_makanan}\n" +
                    "Panjang: ${it.dinos_tinggi}\n" +
                    "Umur: ${it.dinos_panjang}\n" +
                    "Berat: ${it.dinos_bobot}\n" +
                    "Kekurangan: ${it.dinos_kelemahan}"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }

}
