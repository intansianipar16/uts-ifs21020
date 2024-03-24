package com.ifs21020.dinopedia

import Dinosaur
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21020.dinopedia.databinding.ActivityMainDinosaurBinding

class MainDinosaur : AppCompatActivity() {

    private lateinit var binding: ActivityMainDinosaurBinding
    private val dataDino = ArrayList<Dinosaur>()
    private var selectedFamily: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDinosaurBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDino.setHasFixedSize(false)

        selectedFamily = intent.getStringExtra(EXTRA_SELECTED_FAMILY)

        selectedFamily?.let {
            dataDino.addAll(getListDinoByFamily(it))
        }

        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListDino(): ArrayList<Dinosaur> {
        val dataImage = resources.obtainTypedArray(R.array.dinos_image)
        val dataName = resources.getStringArray(R.array.dinos_name)
        val dataDesc = resources.getStringArray(R.array.dinos_desc)
        val dataCarac = resources.getStringArray(R.array.dinos_characteristic)
        val dataCel  = resources.getStringArray(R.array.dinos_kelompok)
        val dataHabit = resources.getStringArray(R.array.dinos_habitat)
        val dataEats = resources.getStringArray(R.array.dinos_makanan)
        val dataLength  = resources.getStringArray(R.array.dinos_panjang)
        val dataLong = resources.getStringArray(R.array.dinos_tinggi)
        val dataWeight = resources.getStringArray(R.array.dinos_bobot)
        val dataWeak = resources.getStringArray(R.array.dinos_kelemahan)

        val listDino = ArrayList<Dinosaur>()
        for (i in dataName.indices) {
            val dino = Dinosaur(
                dataImage.getResourceId(i, -1),
                dataName[i],
                dataDesc[i],
                dataCarac[i],
                dataCel[i],
                dataHabit[i],
                dataEats[i],
                dataLength[i],
                dataLong[i],
                dataWeight[i],
                dataWeak[i])
            listDino.add(dino)
        }
        return listDino
    }


    @SuppressLint("Recycle")
    private fun getListDinoByFamily(family: String): ArrayList<Dinosaur> {
        val allDino = getListDino()
        val filteredDino = ArrayList<Dinosaur>()
        for (dino in allDino) {
            if (dino.dinos_kelompok == family) {
                filteredDino.add(dino)
            }
        }
        return filteredDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvDino.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvDino.layoutManager =
                LinearLayoutManager(this)
        }

        val listDinoAdapter = DinosaurAdapter(dataDino)
        binding.rvDino.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object :
            DinosaurAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dinosaur) {
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino: Dinosaur) {
        val intentWithData = Intent(this@MainDinosaur,
            DinosaurDetailedActivity::class.java)
        intentWithData.putExtra(DinosaurDetailedActivity.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }

    companion object {
        const val EXTRA_SELECTED_FAMILY = "EXTRA_SELECTED_FAMILY"
    }
}
