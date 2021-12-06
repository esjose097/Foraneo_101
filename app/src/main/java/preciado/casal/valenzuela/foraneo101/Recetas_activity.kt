package preciado.casal.valenzuela.foraneo101

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_recetas.view.*
import kotlinx.android.synthetic.main.receta.view.*

import preciado.casal.valenzuela.foraneo101.databinding.ActivityRecetasBinding


class Recetas_activity : AppCompatActivity() {
    private lateinit var binding: ActivityRecetasBinding
    var adaptadoReceta: AdaptadorReceta? = null
    //Aun een proceso
    lateinit var recetas: ArrayList<receta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recetas)
        binding = ActivityRecetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var gridView: GridView = findViewById(R.id.gridView)
        var imgForaneo: ImageView = findViewById(R.id.foraneoImg)

        binding.backMenuRecetas.setOnClickListener {
            val intent = Intent(this, Menu_activity::class.java)
            this.startActivity(intent)
        }

        adaptadoReceta = AdaptadorReceta(this, recetas)
        gridView.adapter = adaptadoReceta
    }

    private fun cargaRecetas(){
        /*Aquí va la la logica donde creamos un monton de recetas y las agregamos a la lista*/
    }
}

class AdaptadorReceta: BaseAdapter{
    var recetas = ArrayList<receta>()
    var context: Context? = null

    constructor(context: Context, recetas: ArrayList<receta>){
        this.context = context
        this.recetas = recetas
    }

    override fun getCount(): Int {
        return this.recetas.size
    }

    override fun getItem(p0: Int): Any {
        return this.recetas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var receta = this.recetas[p0]
        var inflador = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflador.inflate(R.layout.receta, null)

        vista.iv_receta.setImageResource(receta.imagen)
        vista.tv_receta.setText(receta.nombre)

        vista.setOnClickListener {
            var intent = Intent(context, activity_detalle_receta::class.java)
            intent.putExtra("nombre", receta.nombre)
            intent.putExtra("imagen", receta.imagen)
            intent.putExtra("ingredientes", receta.ingredientes)
            intent.putExtra("proceso", receta.proceso)
            context!!.startActivity(intent)
        }
        return vista
    }

}