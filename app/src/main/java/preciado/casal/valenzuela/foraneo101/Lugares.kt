package preciado.casal.valenzuela.foraneo101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import preciado.casal.valenzuela.foraneo101.Lugar

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import preciado.casal.valenzuela.foraneo101.databinding.ActivityLugaresBinding

class Lugares : AppCompatActivity(), OnMapReadyCallback {
    /*De momento lo voy a comentariar porque no puedo correrlo, iré a la segura.*/
    //private lateinit var listaLugares: ArrayList<Lugar>
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLugaresBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLugaresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Hospitales
        val hImms = LatLng(27.4944218,-109.9628197)
        val hGeneral = LatLng(27.4828052,-109.955163)
        val hCruzR = LatLng(27.4856902,-109.9347807)
        val hIssste = LatLng(27.5059753,-109.9518257)
        val hCentroM = LatLng(27.512353,-109.9335324,)
        val hIsteSon1 = LatLng(27.5064778,-109.932049)
        val hIsteSon2 = LatLng(27.4935887,-109.957588)

        //Bancos
            //Banorte
        val bBtTutuli = LatLng(27.4936738,-109.9489918)
        val bBtBella = LatLng(27.4829297,-109.9580834)
        val bBtCentro = LatLng(27.4961716,-109.9303402)
        val bBtAle = LatLng(27.5039551,-109.9307093)
            //Banamex
        val bBnTutuli = LatLng(27.4936061,-109.945798)
        val bBnBella = LatLng(27.4825594,-109.96029)
        val bBnAle = LatLng(27.5059663,-109.9308328)
        val bBnCentro = LatLng(27.4935765,-109.9330347)
            //BBVA
        val bBVBella = LatLng(27.4829567,-109.9570432)
        val bBVCali = LatLng(27.4859272,-109.9451701)
        val bBVAle = LatLng(27.5047526,-109.9303081)
        val bBVCentro = LatLng(27.4915995,-109.9314328)
            //HSBC
        val bHsAle = LatLng(27.5016291,-109.9302398)
        val bHsCentro = LatLng(27.4937177,-109.9339)
            //Santander
        val bSaAle = LatLng(27.5016598,-109.9308972)
        val bSaCentro = LatLng(27.4940941,-109.9342252)

        //Super mercados
        //Leys
        val leyJal = LatLng(27.4787696,-109.9271335)
        val leyAlem = LatLng(27.4905643,-109.9299941)
        val leySen = LatLng(27.4688641,-109.913668)
        //Sorianas
        val sorBella = LatLng(27.4843233,-109.959475)
        val sorTutu = LatLng(27.4931615,-109.9477406)
        //Aurreras
        val bau200 = LatLng(27.4817292,-109.9701628)
        val bauEstadio = LatLng(27.4932953,-109.9531713)
        val bauPuente = LatLng(27.468316,-109.9331542)

        //Estacion de autobuses
        val estacion = LatLng(27.4821077,-109.946736)
        //Entretenimiento
        val estadio = LatLng(27.5274922,-109.950681)
        val laguna = LatLng(27.4955106,-109.9665848)
        //Cines
        val cineBella = LatLng(27.4839761,-109.9601036)
        val cineSendero = LatLng(27.4688641,-109.913668)
        val cineMex = LatLng(27.4923714,-109.9519016)

        //Agregamos los hospitales
        mMap.addMarker(MarkerOptions().position(hImms).title("Hospital: IMSS"))
        mMap.addMarker(MarkerOptions().position(hGeneral).title("Hospital: General"))
        mMap.addMarker(MarkerOptions().position(hCruzR).title("Hospital: Cruz roja"))
        mMap.addMarker(MarkerOptions().position(hIssste).title("Hospital: ISSSTE"))
        mMap.addMarker(MarkerOptions().position(hCentroM).title("Hospital: Centro medico"))
        mMap.addMarker(MarkerOptions().position(hIsteSon1).title("Hospital: ISSSTESON"))
        mMap.addMarker(MarkerOptions().position(hIsteSon2).title("Hospital: ISSSTESON Policlinica"))
        //Agregamos los Bancos
            //Banamex
        mMap.addMarker(MarkerOptions().position(bBnTutuli).title("Banco: Banamex"))
        mMap.addMarker(MarkerOptions().position(bBnAle).title("Banco: Banamex"))
        mMap.addMarker(MarkerOptions().position(bBnBella).title("Banco: Banamex"))
        mMap.addMarker(MarkerOptions().position(bBnCentro).title("Banco: Banamex"))
            //Banorte
        mMap.addMarker(MarkerOptions().position(bBtAle).title("Banco: Banorte"))
        mMap.addMarker(MarkerOptions().position(bBtBella).title("Banco: Banorte"))
        mMap.addMarker(MarkerOptions().position(bBtCentro).title("Banco: Banorte"))
        mMap.addMarker(MarkerOptions().position(bBtTutuli).title("Banco: Banorte"))
            //BBVA
        mMap.addMarker(MarkerOptions().position(bBVAle).title("Banco: BBVA"))
        mMap.addMarker(MarkerOptions().position(bBVBella).title("Banco: BBVA"))
        mMap.addMarker(MarkerOptions().position(bBVCali).title("Banco: BBVA"))
        mMap.addMarker(MarkerOptions().position(bBVCentro).title("Banco: BBVA"))
            //HSBC
        mMap.addMarker(MarkerOptions().position(bHsAle).title("Banco: HSBC"))
        mMap.addMarker(MarkerOptions().position(bHsCentro).title("Banco: HSBC"))
            //Santander
        mMap.addMarker(MarkerOptions().position(bSaAle).title("Banco: Santander"))
        mMap.addMarker(MarkerOptions().position(bSaCentro).title("Banco: Santander"))
        //Se agregan los super mercados
            //Ley's
        mMap.addMarker(MarkerOptions().position(leyAlem).title("Super mercado: Ley"))
        mMap.addMarker(MarkerOptions().position(leySen).title("Super mercado: Ley"))
        mMap.addMarker(MarkerOptions().position(leyJal).title("Super mercado: Ley"))
            //Soriana
        mMap.addMarker(MarkerOptions().position(sorBella).title("Super mercado: Soriana"))
        mMap.addMarker(MarkerOptions().position(sorTutu).title("Super mercado: Soriana"))
            //Bodega aurrera
        mMap.addMarker(MarkerOptions().position(bau200).title("Super mercado: Bodega aurrera"))
        mMap.addMarker(MarkerOptions().position(bauEstadio).title("Super mercado: Bodega aurrera"))
        mMap.addMarker(MarkerOptions().position(bauPuente).title("Super mercado: Bodega aurrera"))
        //Se agrega la central de camiones
        mMap.addMarker(MarkerOptions().position(estacion).title("Central de autobuses"))
        //Se agregan los cines
            //Cinepolis
        mMap.addMarker(MarkerOptions().position(cineBella).title("Cine: Cinepolis"))
        mMap.addMarker(MarkerOptions().position(cineSendero).title("Cine: Cinepolis"))
            //Cinemex
        mMap.addMarker(MarkerOptions().position(cineMex).title("Cine: Cinemex"))
        //Otros lugares de interes
        mMap.addMarker(MarkerOptions().position(estadio).title("Estadio yaquis"))
        mMap.addMarker(MarkerOptions().position(laguna).title("Laguna del nainari"))

    }

    /* De momento lo voy a comentariar porque no puedo correrlo, iré a la segura.
    El plan es optimizar esto mediante una lista que almacene objetos de la clase "Lugar"
    y mediante un for o una estructura de repetición agregarlos al mapa.
    Pero será despues de que el Preciado lo pruebe.
    private fun cargarLista(){
    }
    */
}