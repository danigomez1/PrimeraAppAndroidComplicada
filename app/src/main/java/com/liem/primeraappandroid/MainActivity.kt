package com.liem.primeraappandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.liem.primeraappandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val cursos = arrayOf("Selecciona un curs...", "1r SMX", "2n SMX", "1r DAM", "2n DAM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val spinner = binding.spinner2
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cursos)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val botoAfegir = binding.floatingActionButton
        botoAfegir.setOnClickListener {

            if (binding.textInputEditText.text.toString().isNotEmpty() && binding.textInputEditText2.text.toString().isNotEmpty() && spinner.selectedItem != "Selecciona un curs...") {

                Datasource.addAlumne(
                    binding.textInputEditText.text.toString(),
                    binding.textInputEditText2.text.toString().toInt(),
                    spinner.selectedItem.toString()
                )
                Toast.makeText(this, "Alumne agregat", Toast.LENGTH_SHORT).show()
                binding.textInputEditText.text?.clear()
                binding.textInputEditText2.text?.clear()
            }else{
                Toast.makeText(this, "Omple tots els camps", Toast.LENGTH_SHORT).show()
            }
        }

        val botoNav = binding.floatingActionButton2
        botoNav.setOnClickListener {
            val intent = Intent(this, ResultatActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}