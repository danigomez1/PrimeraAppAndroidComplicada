package com.liem.primeraappandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.liem.primeraappandroid.databinding.ActivityResultatBinding

class ResultatActivity : AppCompatActivity() {

    val cursos = arrayOf("Selecciona un curs...", "1r SMX", "2n SMX", "1r DAM", "2n DAM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //setContentView(R.layout.activity_resultat)
        val binding: ActivityResultatBinding = DataBindingUtil.setContentView(this, R.layout.activity_resultat)

        val spinner = binding.spinner3
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cursos)
        spinner.adapter = arrayAdapter

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        fun actualizarAlumnes() {
            val alumnes = Datasource.getAlumneFromCurs(spinner.selectedItem.toString())
            val adapter = AdaptadorRecycle(alumnes)
            recyclerView.adapter = adapter
        }

        actualizarAlumnes()

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                actualizarAlumnes()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val botoNav = binding.floatingActionButton5
        botoNav.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}