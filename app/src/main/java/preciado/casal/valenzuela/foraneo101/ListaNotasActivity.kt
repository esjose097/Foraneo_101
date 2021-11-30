package preciado.casal.valenzuela.foraneo101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListaNotasActivity : AppCompatActivity() {

    private var notas = ArrayList<Nota>()
    private lateinit var adaptador: AdaptadoNotas
    private var lista: ListView = findViewById(R.id.listadenotas)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_notas)

        adaptador = AdaptadoNotas(this, notas)
        lista.adapter = adaptador
    }
}