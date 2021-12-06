package preciado.casal.valenzuela.foraneo101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import preciado.casal.valenzuela.foraneo101.databinding.ActivityUbicacionesBinding

class LugaresActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityUbicacionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUbicacionesBinding.inflate(layoutInflater)
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

        /*-------          Hospitales          ------*/
        val hImms = LatLng(27.4944218,-109.9628197)
        mMap.addMarker(
            MarkerOptions()
                .position(hImms)
                .title("Hospital: IMSS")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )

        val hGeneral = LatLng(27.4828052,-109.955163)
        mMap.addMarker(
            MarkerOptions()
                .position(hGeneral)
                .title("Hospital: General")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )

        val hCruzR = LatLng(27.4856902,-109.9347807)
        mMap.addMarker(
            MarkerOptions()
                .position(hCruzR)
                .title("Hospital: Cruz roja")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )

        val hIssste = LatLng(27.5059753,-109.9518257)
        mMap.addMarker(
            MarkerOptions()
                .position(hIssste)
                .title("Hospital: ISSSTE")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )

        val hCentroM = LatLng(27.512353,-109.9335324,)
        mMap.addMarker(
            MarkerOptions()
                .position(hCentroM)
                .title("Hospital: Centro medico")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )

        val hIsteSon1 = LatLng(27.5064778,-109.932049)
        mMap.addMarker(
            MarkerOptions()
                .position(hIsteSon1)
                .title("Hospital: ISSSTESON")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )

        val hIsteSon2 = LatLng(27.4935887,-109.957588)
        mMap.addMarker(
            MarkerOptions()
                .position(hIsteSon2)
                .title("Hospital: ISSSTESON Policlinica")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
        )



        /*-------          $ Bancos $          ------*/

        // Banorte
        val bBtTutuli = LatLng(27.4936738,-109.9489918)
        mMap.addMarker(
            MarkerOptions()
                .position(bBtTutuli)
                .title("Banco: Banorte")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBtBella = LatLng(27.4829297,-109.9580834)
        mMap.addMarker(
            MarkerOptions()
                .position(bBtBella)
                .title("Banco: Banorte")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBtCentro = LatLng(27.4961716,-109.9303402)
        mMap.addMarker(
            MarkerOptions()
                .position(bBtCentro)
                .title("Banco: Banorte")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBtAle = LatLng(27.5039551,-109.9307093)
        mMap.addMarker(
            MarkerOptions()
                .position(bBtAle)
                .title("Banco: Banorte")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )


        //Banamex
        val bBnTutuli = LatLng(27.4936061,-109.945798)
        mMap.addMarker(
            MarkerOptions()
                .position(bBnTutuli)
                .title("Banco: Banamex")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBnBella = LatLng(27.4825594,-109.96029)
        mMap.addMarker(
            MarkerOptions()
                .position(bBnBella)
                .title("Banco: Banamex")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBnAle = LatLng(27.5059663,-109.9308328)
        mMap.addMarker(
            MarkerOptions()
                .position(bBnAle)
                .title("Banco: Banamex")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBnCentro = LatLng(27.4935765,-109.9330347)
        mMap.addMarker(
            MarkerOptions()
                .position(bBnCentro)
                .title("Banco: Banamex")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        //BBVA
        val bBVBella = LatLng(27.4829567,-109.9570432)
        mMap.addMarker(
            MarkerOptions()
                .position(bBVBella)
                .title("Banco: BBVA")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBVCali = LatLng(27.4859272,-109.9451701)
        mMap.addMarker(
            MarkerOptions()
                .position(bBVCali)
                .title("Banco: BBVA")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBVAle = LatLng(27.5047526,-109.9303081)
        mMap.addMarker(
            MarkerOptions()
                .position(bBVAle)
                .title("Banco: BBVA")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bBVCentro = LatLng(27.4915995,-109.9314328)
        mMap.addMarker(
            MarkerOptions()
                .position(bBVCentro)
                .title("Banco: BBVA")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        //HSBC
        val bHsAle = LatLng(27.5016291,-109.9302398)
        mMap.addMarker(
            MarkerOptions()
                .position(bHsAle)
                .title("Banco: HSBC")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bHsCentro = LatLng(27.4937177,-109.9339)
        mMap.addMarker(
            MarkerOptions()
                .position(bHsCentro)
                .title("Banco: HSBC")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        //Santander
        val bSaAle = LatLng(27.5016598,-109.9308972)
        mMap.addMarker(
            MarkerOptions()
                .position(bSaAle)
                .title("Banco: Santander")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        val bSaCentro = LatLng(27.4940941,-109.9342252)
        mMap.addMarker(
            MarkerOptions()
                .position(bSaCentro)
                .title("Banco: Santander")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bank))
        )

        //Super mercados
        //Ley
        val leyJal = LatLng(27.4787696,-109.9271335)
        mMap.addMarker(MarkerOptions()
            .position(leyJal)
            .title("Super mercado: Ley")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        val leyAlem = LatLng(27.4905643,-109.9299941)
        mMap.addMarker(
            MarkerOptions()
                .position(leyAlem)
                .title("Super mercado: Ley")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        val leySen = LatLng(27.4688641,-109.913668)
        mMap.addMarker(
            MarkerOptions()
                .position(leySen)
                .title("Super mercado: Ley")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        //Sorianas
        val sorBella = LatLng(27.4843233,-109.959475)
        mMap.addMarker(
            MarkerOptions()
                .position(sorBella)
                .title("Super mercado: Soriana")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        val sorTutu = LatLng(27.4931615,-109.9477406)
        mMap.addMarker(
            MarkerOptions()
                .position(sorTutu)
                .title("Super mercado: Soriana")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        //Aurreras
        val bau200 = LatLng(27.4817292,-109.9701628)
        mMap.addMarker(
            MarkerOptions()
                .position(bau200)
                .title("Super mercado: Bodega aurrera")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        val bauEstadio = LatLng(27.4932953,-109.9531713)
        mMap.addMarker(
            MarkerOptions()
                .position(bauEstadio)
                .title("Super mercado: Bodega aurrera")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )

        val bauPuente = LatLng(27.468316,-109.9331542)
        mMap.addMarker(
            MarkerOptions()
                .position(bauPuente)
                .title("Super mercado: Bodega aurrera")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )


        //Estacion de autobuses
        val estacion = LatLng(27.4821077,-109.946736)
        mMap.addMarker(
            MarkerOptions()
                .position(estacion)
                .title("Central de autobuses")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus))
        )

        //Entretenimiento
        val estadio = LatLng(27.5274922,-109.950681)
        mMap.addMarker(
            MarkerOptions()
                .position(estadio)
                .title("Estadio yaquis")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.entertainmen))
        )

        val laguna = LatLng(27.4955106,-109.9665848)
        mMap.addMarker(
            MarkerOptions()
                .position(laguna)
                .title("Laguna del nainari")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cart))
        )


        //Cines
        val cineBella = LatLng(27.4839761,-109.9601036)
        mMap.addMarker(
            MarkerOptions()
                .position(cineBella)
                .title("Cine: Cinepolis")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cine))
        )

        val cineSendero = LatLng(27.4688641,-109.913668)
        mMap.addMarker(
            MarkerOptions()
                .position(cineSendero)
                .title("Cine: Cinepolis")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cine))
        )

        val cineMex = LatLng(27.4923714,-109.9519016)
        mMap.addMarker(
            MarkerOptions()
                .position(cineMex)
                .title("Cine: Cinemex")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cine))
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(estacion,10.0f))

    }
}