package com.ifs21020.dinopedia

import DinosaurFamily
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21020.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // Deklarasi variabel binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inisialisasi variabel binding
        setContentView(binding.root)

        val dinosaurList = listOf(
            DinosaurFamily(
                getString(R.string.tyrannosauridae_name),
                getString(R.string.tyrannosauridae_description),
                getString(R.string.tyrannosauridae_lifespan),
                getString(R.string.tyrannosauridae_physical_characteristics),
                getString(R.string.tyrannosauridae_habitat),
                getString(R.string.tyrannosauridae_behavior),
                getString(R.string.tyrannosauridae_classification),
                R.drawable.tyrannosauridae
            ),
            DinosaurFamily(
                getString(R.string.stegosauridae_name),
                getString(R.string.stegosauridae_description),
                getString(R.string.stegosauridae_lifespan),
                getString(R.string.stegosauridae_physical_characteristics),
                getString(R.string.stegosauridae_habitat),
                getString(R.string.stegosauridae_behavior),
                getString(R.string.stegosauridae_classification),
                R.drawable.stegosauridae
            ),
            DinosaurFamily(
                getString(R.string.triceratopsidae_name),
                getString(R.string.triceratopsidae_description),
                getString(R.string.triceratopsidae_lifespan),
                getString(R.string.triceratopsidae_physical_characteristics),
                getString(R.string.triceratopsidae_habitat),
                getString(R.string.triceratopsidae_behavior),
                getString(R.string.triceratopsidae_classification),
                R.drawable.triceratopsidae
            ),
            DinosaurFamily(
                getString(R.string.hadrosauridae_name),
                getString(R.string.hadrosauridae_description),
                getString(R.string.hadrosauridae_lifespan),
                getString(R.string.hadrosauridae_physical_characteristics),
                getString(R.string.hadrosauridae_habitat),
                getString(R.string.hadrosauridae_behavior),
                getString(R.string.hadrosauridae_classification),
                R.drawable.hadrosauridae
            ),
            DinosaurFamily(
                getString(R.string.sauropodidae_name),
                getString(R.string.sauropodidae_description),
                getString(R.string.sauropodidae_lifespan),
                getString(R.string.sauropodidae_physical_characteristics),
                getString(R.string.sauropodidae_habitat),
                getString(R.string.sauropodidae_behavior),
                getString(R.string.sauropodidae_classification),
                R.drawable.sauropodidae
            ),
            DinosaurFamily(
                getString(R.string.ornithomimidae_name),
                getString(R.string.ornithomimidae_description),
                getString(R.string.ornithomimidae_lifespan),
                getString(R.string.ornithomimidae_physical_characteristics),
                getString(R.string.ornithomimidae_habitat),
                getString(R.string.ornithomimidae_behavior),
                getString(R.string.ornithomimidae_classification),
                R.drawable.ornithomimidae
            ),
            DinosaurFamily(
                getString(R.string.ceratopsidae_name),
                getString(R.string.ceratopsidae_description),
                getString(R.string.ceratopsidae_lifespan),
                getString(R.string.ceratopsidae_physical_characteristics),
                getString(R.string.ceratopsidae_habitat),
                getString(R.string.ceratopsidae_behavior),
                getString(R.string.ceratopsidae_classification),
                R.drawable.ceratopsidae
            ),
            DinosaurFamily(
                getString(R.string.velociraptoridae_name),
                getString(R.string.velociraptoridae_description),
                getString(R.string.velociraptoridae_lifespan),
                getString(R.string.velociraptoridae_physical_characteristics),
                getString(R.string.velociraptoridae_habitat),
                getString(R.string.velociraptoridae_behavior),
                getString(R.string.velociraptoridae_classification),
                R.drawable.velociraptoridae
            )
        )

        val adapter = DinosaurAdapter(dinosaurList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
