package com.ifs21020.dinopedia

import Family
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifs21020.dinopedia.databinding.ActivityFamilyDetailedBinding

class FamilyActivityDetailed : AppCompatActivity() {

    private lateinit var binding: ActivityFamilyDetailedBinding
    private var family: Family? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFamilyDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data Family dari intent
        family = intent.getParcelableExtra(EXTRA_FAMILY)

        // Menampilkan tombol back di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Jika data Family tidak null, maka tampilkan detailnya
        family?.let {
            supportActionBar?.title = it.dino_name
            loadData(it)
        } ?: finish() // Jika data Family null, maka tutup activity

        // Mendapatkan referensi button
        val buttonViewDinosaurs = findViewById<Button>(R.id.buttonViewDinosaurs)

        // Menambahkan listener klik pada button
        buttonViewDinosaurs.setOnClickListener {
            val familyName = family?.dino_name
            val intent = Intent(this@FamilyActivityDetailed, MainDinosaur::class.java)
            intent.putExtra(MainDinosaur.EXTRA_SELECTED_FAMILY, familyName)
            startActivity(intent)

        }
    }

    private fun loadData(familyDino: Family) {
        binding.ivDetailImage.setImageResource(familyDino.dino_images)
        binding.tvDetailTitle.text = familyDino.dino_name
        binding.textview1.text = familyDino.dino_description
        binding.textView2.text = familyDino.dino_lifespans
        binding.textView3.text = familyDino.dino_characteristic
        binding.textView4.text = familyDino.dino_habitat
        binding.textView6.text = familyDino.dino_classification
    }

    companion object {
        const val EXTRA_FAMILY = "EXTRA_FAMILY"
    }
}
