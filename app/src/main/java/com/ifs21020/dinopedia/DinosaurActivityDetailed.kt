package com.ifs21020.dinopedia

import DinosaurFamily
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ifs21020.dinopedia.databinding.ActivityDinosaurDetailedBinding

class DinosaurActivityDetailed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDinosaurDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedDinosaur = intent.getParcelableExtra<DinosaurFamily>("SELECTED_DINOSAUR")

        if (selectedDinosaur != null) {
            with(binding) {
                tvFamilyName.text = selectedDinosaur.name
                tvDescription.text = selectedDinosaur.description
                tvLifespan.text = selectedDinosaur.lifespan
                tvPhysicalCharacteristics.text = selectedDinosaur.physicalCharacteristics
                tvHabitat.text = selectedDinosaur.habitat
                tvBehavior.text = selectedDinosaur.behavior
                tvClassification.text = selectedDinosaur.classification
                ivDinosaurImage.setImageResource(selectedDinosaur.imageResourceId)
            }
        } else {
            finish() // Menutup aktivitas dan kembali ke aktivitas sebelumnya.
        }
    }
}
