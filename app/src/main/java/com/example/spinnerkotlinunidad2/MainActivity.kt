package com.example.spinnerkotlinunidad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var spnPaises: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spnPaises = findViewById(R.id.spnPaises)
        val adaptador = ArrayAdapter<String>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            resources.getStringArray(R.array.paises)
        )
        spnPaises.adapter = adaptador
        spnPaises.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                i: Int,
                l: Long
            ) {
                Toast.makeText(
                    this@MainActivity,
                    "Selecciono el pais " + adapterView?.getItemAtPosition(i).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                Toast.makeText(
                    this@MainActivity,
                    "Debe seleccionar una opción",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}