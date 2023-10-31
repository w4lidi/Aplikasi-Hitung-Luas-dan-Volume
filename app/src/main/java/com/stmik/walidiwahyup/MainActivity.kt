package com.stmik.walidiwahyup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat



class MainActivity : AppCompatActivity() {
    private lateinit var lebar : EditText
    private lateinit var panjang : EditText
    private  lateinit var tombol : Button
    private  lateinit var hasil : TextView
    private lateinit var tinggi : EditText

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang = findViewById(R.id.editTextPanjang)
        lebar = findViewById(R.id.editTextLebar)
        tinggi = findViewById(R.id.editTextTinggi)

        tombol = findViewById(R.id.button)
        hasil = findViewById(R.id.editTextHasil)



        tombol.setOnClickListener {
            val nilaitinggi = tinggi.text.toString()
            val nilaipanjang = panjang.text.toString()
            val nilailebar = lebar.text.toString()
            val persegi = " m2"
            val kubik = " m3"
            if (nilaipanjang.isEmpty() || nilailebar.isEmpty()){
                if (nilaipanjang.isEmpty() && nilailebar.isNotEmpty()){
                    //val msg = "Masukkan Nilai Panjang"
                    panjang.setHintTextColor(ContextCompat.getColor(this, R.color.error))
                }else if (nilailebar.isEmpty() && nilaipanjang.isNotEmpty()){
                    lebar.setHintTextColor(ContextCompat.getColor(this, R.color.error))
            }else{
                    panjang.setHintTextColor(ContextCompat.getColor(this, R.color.error))
                    lebar.setHintTextColor(ContextCompat.getColor(this, R.color.error))

                }
            }else if (nilaipanjang.isNotEmpty() && nilailebar.isNotEmpty() && nilaitinggi.isEmpty()){
                panjang.setHintTextColor(ContextCompat.getColor(this, R.color.hint))
                lebar.setHintTextColor(ContextCompat.getColor(this, R.color.hint))

                val nilaihasil = nilaipanjang.toInt() * nilailebar.toInt()
                val hasilstring =  nilaihasil.toString() + persegi
                hasil.text = hasilstring
            }else if (nilaipanjang.isNotEmpty() && nilailebar.isNotEmpty() && nilaitinggi.isNotEmpty()){
                panjang.setHintTextColor(ContextCompat.getColor(this, R.color.hint))
                lebar.setHintTextColor(ContextCompat.getColor(this, R.color.hint))

                val nilaihasil = nilaipanjang.toInt() * nilailebar.toInt() * nilaitinggi.toInt()
                val hasilstring = nilaihasil.toString() + kubik
                hasil.text = hasilstring
            }
        }

    }



}