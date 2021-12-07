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
    var recetas = ArrayList<receta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_recetas)
        binding = ActivityRecetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var gridView: GridView = findViewById(R.id.gridView)
        var imgForaneo: ImageView = findViewById(R.id.foraneoImg)

        this.cargaRecetas()

        binding.backMenuRecetas.setOnClickListener {
            val intent = Intent(this, Menu_activity::class.java)
            this.startActivity(intent)
        }
        binding.foraneoImg.setOnClickListener {
            /*No recuerdo a donde nos debe mandar*/
        }

        adaptadoReceta = AdaptadorReceta(this, recetas)
        gridView.adapter = adaptadoReceta
    }

    private fun cargaRecetas(){
        /*Aquí va la la logica donde creamos un monton de recetas y las agregamos a la lista*/
        recetas.add(receta("Muslos de pollo con mozarella.",R.drawable.muslospollomozarella,"900 g (2 lb) de muslos de pollo (deshuesados).\n" +
                "300 g (2 tazas) de tomates cherry.\n" +
                "1 echalote.\n" +
                "120 ml (2/3 taza) de vino blanco o caldo de pollo.\n" +
                "1 mozarella pequeño.\n" +
                "Aceite de oliva o cualquiera.\n" +
                "Albahaca fresca al gusto.\n" +
                "Sal, pimienta negra al gusto.\n","1.- Seca los muslos de pollo.\n" +
                "2.- Agrega sal y pimienta negra al gusto por ambos lados y extiendela con las manos.\n" +
                "3.- Agrega el aceite a un sarten y marca los muslos de pollo a feugo alto de 3 a 4 minutos.\n" +
                "4.- Corte en medias lunas el echalote.\n" +
                "5.- Voltee los muslos, baje el fuego a medio y cocine por otros 6 minutos.\n" +
                "6.- Remueva los muslos del sarten.\n" +
                "7.- Al sarten de donde retiro los muslos, agrege 60 ml de vino blanco o caldo de pollo, el echalote previamente picado y los tomates cherry, saltee de 3 a 4 minutos.\n" +
                "8.- Pique los tomates para sacar el jugo, agrege sal y pimienta al gusto.\n" +
                "9.- Agrege otros 60ml de vino blanco o caldo de pollo y cocine a fuego medio por 6 minutos revolviendo constantemente.\n" +
                "10.- Agrege albahaca al gusto.\n" +
                "11.- Regrese los muslos al sarten.\n" +
                "12.- Agrege queso mozarella fresco.\n" +
                "13.- Hornee a 400 ° F / 200 ° C durante 4-5 minutos solo para derretir el queso.\n"))

        recetas.add(receta("Tortilla de huevo esponjosa.",R.drawable.tortillahuevoesponjosa,"3 huevos.\n" +
                "1 cucharada de azucar.\n" +
                "Pizca de sal.\n" +
                "Mantequilla.\n","1.- Separe las claras de las yemas.\n" +
                "2.- Añada 1/4 de cucharadita de sal a las yemas y mezcle bien.\n" +
                "3.- Añada una cucharadita de azucar a las claras y mezcle hasta que se encuentre a punto de nieve.\n" +
                "4.- Gentilmente combine las yemas con las claras.\n" +
                "5.- Agrege mantequilla a un sarten y vierta la mezcla.\n" +
                "6.- Tape el sarten y cocine a fuego bajo por 3 minutos.\n" +
                "7.- Doble la tortilla resultante por la mitad.\n"))

        recetas.add(receta("Omellet con tomate",R.drawable.omelettomate, "3 huevos\n" +
                "1 cucharada de leche\n" +
                "1 cucharadita de mantequilla\n" +
                "1 tomate\n" +
                "50 g (1/4 taza) de queso cheddar\n" +
                "1 cucharada de perejil fresco o 1 cucharadita de perejil seco\n" +
                "2 lonchas de jamón de pavo\n" +
                "sal y pimienta\n", "1.- En una recipiente hondo bata los huevos con una cucharada de leche hasta que las yemas y las claras que combinen.\n" +
                "2.- Parta el tomate en cuadritos.\n" +
                "3.- Parta el jamón en cuadritos.\n" +
                "4.- Pique finamente el perejil.\n" +
                "5.- Añada mantequilla al sarten y agrege la mezla del huevo.\n" +
                "6.- Añada el tomate, el jamon, el queso rallado y perejil, con sal y pimienta al gusto. \n" +
                "7.- Tape a fuego bajo por 5 minutos.\n"))

        recetas.add(receta("Sandwich de Omelet", R.drawable.sandwichomelet,"4 huevos\n" +
                "4 rebanadas de pan\n" +
                "1/2 echalota pequeña\n" +
                "Perejil\n" +
                "1 cucharada de mantequilla + 1 cucharadita\n" +
                "1/2 cucharadita de sal\n" +
                "1/4 cucharadita de pimienta negra\n" +
                "1/4 cucharadita de pimiento rojo triturado\n" +
                "2 tomates pequeños\n" +
                "2 cucharaditas de salsa de tomate o cualquier\n" +
                "2 rebanadas de queso suizo o cualquier\n" +
                "Cebollino (opcional)","1.- En un recipiente hondo añada los huevos con 1/2 cucharadita de sal, 1/4  de cucharadita de pimiento rojo triturado y 1/4 de cucharadita de pimienta negra.\n" +
                "2.- Pique la echalota en cuadritos y agrege al recipiente.\n" +
                "3.- Pique el perejil y agregelo al recipiente, mezcle bien.\n" +
                "4.- Agrege una cucharadita de mantequilla a un sarten a fuego medio.\n" +
                "5.- Tueste 4 redabanas de pan por alrededor de 2 a 3 minutos cada lado.\n" +
                "6.- Añada una cucharada de mantequilla al sarten y vierta la mezcla.\n" +
                "7.- Coloque 2 piezas del pan en el sarte y cocine de 3 a 4 minutos.\n" +
                "8.- Parta el tomate en rebanadas.\n" +
                "9.- Doble los lados del omelet hacia el pan.\n" +
                "10.- Añada 2 cucharaditas de salsa de tomate de cualquier tipo destienda sobre el pan y el omelete.\n" +
                "11.- Sobre los panes añada una rebada de queso suizo o cualquiera, añada las rebanadas de tomate sobre el queso.\n" +
                "12.- Sal y cebollin al gusto.\n" +
                "13.- Añada una pieza de pan sobre cada uno de los panes.\n" +
                "14.- Separe y sirva.\n"))

        recetas.add(receta("Brownies HIBRIDOS",R.drawable.brownieshibridos, "150 gr de chocolate semi-amargo.\n" +
                "100 gr de mantequilla.\n" +
                "179 gr de azucar.\n" +
                "3 huevos.\n" +
                "Cucharadita de vainilla\n" +
                "50 gr de cacao\n" +
                "80 gr de harina.\n" +
                "50 gr de nuez\n" +
                "Dulce de leche al gusto.\n","1.- Derretir el chocolate con la mantequilla a baño maria\n" +
                "2.- Batir la azucar, los huevos, la cucharadita de vainilla.\n" +
                "3.- Añadir el chocolate derretido a la mezcla.\n" +
                "4.- Añada una cuchara de cacao en polvo hasta integrarlo.\n" +
                "5.- Añada la harina e integrela lentamente.\n" +
                "6.- Añada las nueces.\n" +
                "7.- Unte manteca en un recipiente, añada el cacao amargo y despues la mezcla.\n" +
                "8.- Cocine por 20 minutos a 180° en un horno.\n" +
                "9.- Dejelo reposar por 30 minutos y añada el dulce de leche.\n"))

        recetas.add(receta("Papas al horno.", R.drawable.papashorno, "1 kg (2 libras) de patatas.\n" +
                "450 g (16 oz) de carne molida.\n" +
                "1 cebolla.\n" +
                "Aceite vegetal.\n" +
                "Eneldo.\n" +
                "Mantequilla\n" +
                "Sal, pimentón, pimienta, ajo en polvo.\n" +
                "400 g de tomates molidos.\n" +
                "100 g (3,5 oz) de queso manchego.\n","1.- Pique las papas en cuadros medianos.\n" +
                "2.- Agrege agua, sal y las papas a una cacerola.\n" +
                "3.- Tapela y hierva a fuego medio-bajo de 15 a 20 minutos.\n" +
                "4.- Pique una cebolla en cuadritos pequeñps\n" +
                "5.- En un sarten añada aceite vegetal y sofria la cebolla por 5 minutos.\n" +
                "6.- Añada la carne molida y cocine por 10 minutos, revolviendo para picar la carne.\n" +
                "7.- Añada sal, ajo en polvo, pimienta negra y paprica al gusto.\n" +
                "8.- Añada el tomate molido y continue revolviendo.\n" +
                "9.- A las papas añada mantequilla, hojas de eneldo finamente picadas y comience a moler\n" +
                "10.- Untese aceite en las manos y haga 4 bolas con el pure de papa.\n" +
                "11.- Coloque las bolas de papa en una cacerola.\n" +
                "12.- Realize una hendidura en el centro y añada queso manchego.\n" +
                "13.- Arriba del queso comienze a agregar la carne, una vez terminado añada más queso.\n" +
                "14.- Hornee a 200 ° C (400 ° F) durante 10 minutos hasta que el queso se derrita.\n"))
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