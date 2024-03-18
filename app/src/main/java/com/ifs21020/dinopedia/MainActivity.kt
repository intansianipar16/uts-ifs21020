package com.ifs21020.dinopedia

import DinosaurFamily
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21020.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dinosaurList = ArrayList<DinosaurFamily>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateDinosaurList()
        setUpRecyclerView()
    }

    private fun populateDinosaurList() {
        val names = resources.getStringArray(R.array.dinos_name)
        val descriptions = resources.getStringArray(R.array.dinos_description)
        val lifespans = resources.getStringArray(R.array.dinosaur_lifespans)
        val characteristics = resources.getStringArray(R.array.dinos_characteristic)
        val habitats = resources.getStringArray(R.array.dinos_habitat)
        val behaviors = resources.getStringArray(R.array.dinos_behavior)
        val classifications = resources.getStringArray(R.array.dinos_classification)
        val images = resources.obtainTypedArray(R.array.dinos_image)

        for (i in names.indices) {
            val dinosaur = DinosaurFamily(
                names[i],
                descriptions[i],
                lifespans[i],
                characteristics[i],
                habitats[i],
                behaviors[i],
                classifications[i],
                images.getResourceId(i, -1)
            )
            dinosaurList.add(dinosaur)
        }

        images.recycle()
    }

    private fun setUpRecyclerView() {
        val layoutManager = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }

        val adapter = DinosaurAdapter(this, dinosaurList, object : DinosaurAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedDinosaur = dinosaurList[position]
                val intent = Intent(this@MainActivity, DinosaurActivityDetailed::class.java).apply {
                    putExtra("SELECTED_DINOSAUR", selectedDinosaur)
                }
                startActivity(intent)
            }
        })

        binding.rvDinosaur.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }
}
