package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.*

class ListaNotasActivity : AppCompatActivity() {

    private var notas = ArrayList<Nota>()
    private lateinit var adaptador: AdaptadoNotas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_notas)

        var lista: ListView = findViewById(R.id.listadenotas) as ListView

        val fab: FloatingActionButton = findViewById(R.id.fab) as FloatingActionButton

        fab.setOnClickListener {
            var intent =Intent(this, NotaActivity::class.java)
            startActivityForResult(intent, 123)
            }

        leerNotas()
        adaptador = AdaptadoNotas(this, notas)
        lista.adapter = adaptador
    }

    fun leerNotas(){
        notas.clear()
        var carpeta = File(ubicacion().absolutePath)

        if(carpeta.exists())
        {
            var archivos = carpeta.listFiles()
            if(archivos != null)
            {
                var contador: Int = 0
                for(archivo in archivos)
                {
                    leerArchivo(archivo)
                }
            }
        }
    }

    fun leerArchivo(archivo:File){
        val fis = FileInputStream(archivo)
        val di = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(di))
        var strLine: String? = br.readLine()
        var myData = ""

        while(strLine != null)
        {
            myData = myData + strLine
            strLine = br.readLine()
        }

        br.close()
        di.close()
        fis.close()

        var nombre = archivo.name.substring(0,archivo.name.length-4)
        var nota = Nota(nombre,myData)
        notas.add(nota)
    }

    private fun ubicacion():File{
        val folder = File(getExternalFilesDir(null),"notas")
        if(!folder.exists())
        {
            folder.mkdir()
        }
        return folder
    }

}