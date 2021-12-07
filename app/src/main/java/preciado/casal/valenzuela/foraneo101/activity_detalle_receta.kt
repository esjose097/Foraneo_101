package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class activity_detalle_receta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_receta)

        val backButton: ImageView = findViewById(R.id.backMenuRecetaDetalle)
        val avatarButton: ImageView = findViewById(R.id.foraneoImg)

        backButton.setOnClickListener {
            val intent = Intent(this, Menu_activity::class.java)
            this.startActivity(intent)
        }

        var tvTitulo: TextView = findViewById(R.id.tv_nombre)
        var ivFoto: ImageView = findViewById(R.id.iv_detalle)
        var tvIngredientes: TextView = findViewById(R.id.tv_ingredientes)
        var tvProceso:TextView = findViewById(R.id.tv_proceso)

        val bundle = intent.extras
        if(bundle != null)
        {
            tvTitulo.setText(bundle.getString("nombre"))
            ivFoto.setImageResource(bundle.getInt("imagen"))
            tvIngredientes.setText(bundle.getString("ingredientes"))
            tvProceso.setText(bundle.getString("proceso"))
        }
    }
}