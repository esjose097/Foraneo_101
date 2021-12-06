package preciado.casal.valenzuela.foraneo101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class activity_detalle_receta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_receta)

        val backButton: ImageView = findViewById(R.id.btn_back)
        val avatarButton: ImageView = findViewById(R.id.foraneoImg)
        var tvTitulo: TextView = findViewById(R.id.tv_nombre)
        var ivFoto: ImageView = findViewById(R.id.iv_receta)
        var tvIngredientes: TextView = findViewById(R.id.tv_ingredientes)
        var tvProceso:TextView = findViewById(R.id.tv_proceso)

        val bundle = intent.extras
        if(bundle != null)
        {
            //tvTitulo.setText(bundle)
        }
    }
}