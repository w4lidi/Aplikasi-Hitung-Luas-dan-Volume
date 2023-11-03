package com.stmik.walidiwahyup

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.core.content.ContextCompat
import com.stmik.walidiwahyup.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    private lateinit var lebar : EditText
//    private lateinit var panjang : EditText
//    private  lateinit var tombol : Button
//    private  lateinit var hasil : TextView
//    private lateinit var tinggi : EditText

    private lateinit var binding : ActivityMainBinding

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        panjang = findViewById(R.id.editTextPanjang)
//        lebar = findViewById(R.id.editTextLebar)
//        tinggi = findViewById(R.id.editTextTinggi)
//
//        tombol = findViewById(R.id.button)
//        hasil = findViewById(R.id.editTextHasil)



        binding.button.setOnClickListener {
            val nilaitinggi = binding.editTextTinggi.text.toString()
            val nilaipanjang = binding.editTextPanjang.text.toString()
            val nilailebar = binding.editTextLebar.text.toString()
            val persegi = " m2"
            val kubik = " m3"
            if (nilaipanjang.isEmpty() || nilailebar.isEmpty()){
                if (nilaipanjang.isEmpty() && nilailebar.isNotEmpty()){
                    //val msg = "Masukkan Nilai Panjang"
                    binding.editTextPanjang.setHintTextColor(ContextCompat.getColor(this, R.color.error))
                }else if (nilailebar.isEmpty() && nilaipanjang.isNotEmpty()){
                    binding.editTextLebar.setHintTextColor(ContextCompat.getColor(this, R.color.error))
                }else if (nilailebar.isEmpty() && nilaipanjang.isEmpty()){
                    binding.editTextPanjang.setHintTextColor(ContextCompat.getColor(this, R.color.error))
                    binding.editTextLebar.setHintTextColor(ContextCompat.getColor(this, R.color.error))

                }
            }else if (nilaipanjang.isNotEmpty() && nilailebar.isNotEmpty() && nilaitinggi.isEmpty()){
                binding.editTextPanjang.setHintTextColor(ContextCompat.getColor(this, R.color.hint))
                binding.editTextLebar.setHintTextColor(ContextCompat.getColor(this, R.color.hint))

                val nilaihasil = nilaipanjang.toInt() * nilailebar.toInt()
                val hasilstring =  nilaihasil.toString() + persegi

//                val hasilstring = "w"

                binding.editTextHasil.text = hasilstring
            }else if (nilaipanjang.isNotEmpty() && nilailebar.isNotEmpty() && nilaitinggi.isNotEmpty()){
                binding.editTextPanjang.setHintTextColor(ContextCompat.getColor(this, R.color.hint))
                binding.editTextLebar.setHintTextColor(ContextCompat.getColor(this, R.color.hint))

                val nilaihasil = nilaipanjang.toInt() * nilailebar.toInt() * nilaitinggi.toInt()
                val hasilstring = nilaihasil.toString() + kubik

//                val hasilstring = nilaipanjang.toString()

                binding.editTextHasil.text = hasilstring
            }
        }

    }



}