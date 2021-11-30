package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import preciado.casal.valenzuela.foraneo101.databinding.ActivityMenuBinding


class Menu_activity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.binding.imgBitacora.setOnClickListener {
            val intent = Intent(this, ListaNotasActivity::class.java)
            this.startActivity(intent)
        }

        binding.imgRecetas.setOnClickListener {
            val intent = Intent(this, Recetas_activity::class.java)
            this.startActivity(intent)
        }

        binding.imgTransporte.setOnClickListener {
            val intent = Intent(this, Transportes::class.java)
            this.startActivity(intent)
        }

        binding.imgUbicacion.setOnClickListener {
            //PENDIENTE
        }

        binding.btnCerrarSesion.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
        }

    }
}