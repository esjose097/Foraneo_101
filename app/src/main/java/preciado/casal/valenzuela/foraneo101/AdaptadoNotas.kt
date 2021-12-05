package preciado.casal.valenzuela.foraneo101

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.nota_layout.view.*
import java.io.File

class AdaptadoNotas: BaseAdapter {
    var context: Context? = null
    var notas:ArrayList<Nota>

    constructor(context: Context, notas:ArrayList<Nota>){
        this.context=context
        this.notas = notas
    }


    override fun getCount(): Int {
        return notas.size
    }

    override fun getItem(p0: Int): Any {
        return notas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.nota_layout, null)
        var nota = notas[position]



       /* var titulo = vista.findViewById(R.id.tv_titulo_det) as TextView
        var contenido = vista.findViewById(R.id.tv_contenido_det) as TextView
        val btnBorrar = vista.findViewById(R.id.btn_borrar) as ImageView
        val btnEditar = vista.findViewById(R.id.btn_editar) as ImageView
*/
        vista.tv_titulo_det.text = nota.titulo
        vista.tv_contenido_det.text = nota.contenido
        /*titulo.setText(nota.titulo)
        contenido.setText(nota.contenido)*/

        vista.btn_borrar.setOnClickListener {
            eliminar(nota.titulo.toString())
            notas.remove(nota)
            this.notifyDataSetChanged()
        }

        vista.btn_editar.setOnClickListener {
            /*Aquí editariamos la nota, SI SUPIERAMOS COMO!!!!*/
            var intent = Intent(context, NotaActivity::class.java)
            intent.putExtra("titulo", nota.titulo)
            intent.putExtra("contenido", nota.contenido)
            (context as Activity).startActivityForResult(intent,123)
        }

        return vista
    }

    //Método para eliminar una nota del almacenamiento.
    private fun eliminar(titulo: String){
        if(titulo == "")
        {
            Toast.makeText(context,"Error: Título vacío", Toast.LENGTH_SHORT).show()
        }
        else
        {
            try
            {
                val archivo = File(ubicacion(),titulo + ".txt")
                archivo.delete()
                Toast.makeText(context,"Se eliminó el archivo", Toast.LENGTH_SHORT).show()
            }
            catch(e:Exception)
            {
                Toast.makeText(context,"Error al eliminar el archivo", Toast.LENGTH_SHORT).show()
            }
        }
    }
//Método para encontrar la ubicación externa
    private fun ubicacion(): String{
        val album= File(context?.getExternalFilesDir(null),"notas")
        if(!album.exists())
        {
            album.mkdir()
        }
        return album.absolutePath


    }
}