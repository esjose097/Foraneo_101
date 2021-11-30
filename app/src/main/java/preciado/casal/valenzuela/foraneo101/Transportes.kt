package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import preciado.casal.valenzuela.foraneo101.databinding.ActivityTransportesBinding

class Transportes : AppCompatActivity() {
    private lateinit var binding: ActivityTransportesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_transportes)

        binding = ActivityTransportesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backMenuTransporte.setOnClickListener {
            val intent = Intent(this, Menu_activity::class.java)
            this.startActivity(intent)
        }
    }
}