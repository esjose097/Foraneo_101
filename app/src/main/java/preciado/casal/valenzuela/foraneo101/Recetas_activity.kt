package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import preciado.casal.valenzuela.foraneo101.databinding.ActivityRecetasBinding


class Recetas_activity : AppCompatActivity() {
    private lateinit var binding: ActivityRecetasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recetas)

        binding = ActivityRecetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backMenuRecetas.setOnClickListener {
            val intent = Intent(this, Menu_activity::class.java)
            this.startActivity(intent)
        }

    }


}