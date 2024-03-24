package com.ifs21020.dinopedia

import Family
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21020.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataFamily = ArrayList<Family>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(false)
        dataFamily.addAll(getListFamily())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun navigateToProfile() {
        val intent = Intent(this, UserActivity::class.java)
        startActivity(intent)
    }

    private fun getListFamily(): ArrayList<Family> {
        val dataImage = resources.obtainTypedArray(R.array.dino_image)
        val dataName = resources.getStringArray(R.array.dino_name)
        val dataDesc = resources.getStringArray(R.array.dino_description)
        val dataPeriod = resources.getStringArray(R.array.dino_lifespans)
        val dataPhysical = resources.getStringArray(R.array.dino_behavior)
        val dataHabits = resources.getStringArray(R.array.dino_habitat)
        val dataClassif = resources.getStringArray(R.array.dino_classification)
        val listFamily = ArrayList<Family>()
        for (i in dataName.indices) {
            val Family = Family(
                dataImage.getResourceId(i, -1), dataName[i],
                dataDesc[i], dataPeriod[i],
                dataPhysical[i], dataHabits[i], dataClassif[i]
            )
            listFamily.add(Family)
        }
        return listFamily
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE
        ) {
            binding.recyclerView.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.recyclerView.layoutManager =
                LinearLayoutManager(this)
        }

        val listDinoFamilyAdapter = FamilyAdapter(dataFamily)
        binding.recyclerView.adapter = listDinoFamilyAdapter
        listDinoFamilyAdapter.setOnItemClickCallback(object :
            FamilyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Family) {
                showSelectedDinoFamily(data)
            }
        })
    }

    private fun showSelectedDinoFamily(family: Family) {
        val intent = Intent(this@MainActivity, FamilyActivityDetailed::class.java)
        intent.putExtra(FamilyActivityDetailed.EXTRA_FAMILY, family)
        startActivity(intent)
    }

}
