package preciado.casal.valenzuela.foraneo101

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager


import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_nota.*


import java.io.File
import java.io.FileOutputStream

class NotaActivity : AppCompatActivity() {

    private lateinit var eTitulo: EditText
    private lateinit var eContenido: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        var extras = intent.extras

        if(extras != null){
            var titulo = extras.getString("titulo")
            var contenido = extras.getString("contenido")

            et_titutlo.setText(titulo)
            et_contenido.setText(contenido)
        }

        /*Prueba*/
        this.eTitulo = findViewById(R.id.et_titutlo) as EditText
        this.eContenido = findViewById(R.id.et_contenido) as EditText

        val btnG: Button = findViewById(R.id.btn_guardar)

        btnG.setOnClickListener {
            guardar_Nota()
            var intent = Intent(this, ListaNotasActivity::class.java)
            startActivity(intent)
        }
    }

    fun guardar_Nota(){
        var titulo = et_titutlo.text.toString()
        var cuerpo = et_contenido.text.toString()
        if (titulo == "" || cuerpo ==  ""){
            Toast.makeText(this, "Porfavor de llenar todos los campos", Toast.LENGTH_SHORT).show()
        }else{
            if (isExternalStorageWritable() && verificarPermiso()){
                //val archivo = File(Environment.getExternalStorageDirectory(),titulo+".txt")
                val archivo = File(ubicacion(),titulo+".txt")
                val fos = FileOutputStream(archivo)
                fos.write(cuerpo.toByteArray())
                fos.close()
                Toast.makeText(this,"Se guardó el archivo en la carpeta pública", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Ocurrió un error al guardar el archivo :c", Toast.LENGTH_SHORT).show()
            }
        }
        finish()

        /*if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                235)
            Toast.makeText(baseContext, "Tienes acceso y estas en el request",
                Toast.LENGTH_SHORT).show()
        }
        else{
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),235)
            Toast.makeText(baseContext, "Necesita conceder los permisos necesarios, porfavor" +
                "activelos y reinicie la aplicación",
            Toast.LENGTH_SHORT).show()
        }*/
    }

    fun isExternalStorageWritable(): Boolean{
        val state = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED.equals(state)){
            return true
        }else{
            return false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode)
        {
            235 ->{
                if((grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                    guardar()
                }
                else{
                    Toast.makeText(this,"Error: permisos denegados", Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun verificarPermiso(): Boolean{
        var permiso = Manifest.permission.WRITE_EXTERNAL_STORAGE
        var verificacion = ContextCompat.checkSelfPermission(this, permiso)
        return (verificacion == PackageManager.PERMISSION_GRANTED)
    }

    fun guardar(){
        var titulo = eTitulo.text.toString()
        var contenido = eContenido.text.toString()

        if(titulo == "" || contenido == "")
        {
            Toast.makeText(this,"Error: Campos vacíos",Toast.LENGTH_SHORT).show()
        }
        else
        {
            try {
                val archivo = File(ubicacion(),titulo+".txt")
                val fos = FileOutputStream(archivo)
                fos.write(contenido.toByteArray())
                fos.close()
                Toast.makeText(this,"Se guardó el archivo en la carpeta pública",Toast.LENGTH_SHORT).show()
            }
            catch (e:Exception)
            {
                Toast.makeText(this,"Error: No se guardó el archivo",Toast.LENGTH_SHORT).show()
            }
            catch (e:java.lang.Exception)
            {
                Toast.makeText(this,"Error: No se guardó el archivo",Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }

    private fun ubicacion(): String{
        val carpeta = File(getExternalFilesDir(null),"notas")
        if(!carpeta.exists())
        {
            carpeta.mkdir()
        }
        return carpeta.absolutePath
    }





    /*
    Plan B?)
    private fun guardarExterno(){
        val et_titutlo: TextView = findViewById(R.id.et_titutlo)
        val et_contenido: TextView = findViewById(R.id.et_contenido)

        var titulo = et_titutlo.text.toString()
        var cuerpo = et_contenido.text.toString()
        if (titulo == "" || cuerpo ==  ""){
            Toast.makeText(this, "Error: campos vacíos", Toast.LENGTH_SHORT).show()
        }else{
            if (isExternalStorageWritable() && verificarPermiso()){
                //val archivo = File(Environment.getExternalStorageDirectory(),titulo+".txt")
                val archivo = File(ubicacion(),titulo+".txt")
                val fos = FileOutputStream(archivo)
                fos.write(cuerpo.toByteArray())
                fos.close()
                Toast.makeText(this,"se guardó el archivo en la carpeta pública", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Error: no se guardó el archivo", Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }

    fun isExternalStorageWritable(): Boolean{
        val state = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED.equals(state)){
            return true
        }else{
            return false
        }
    }

    private fun verificarPermiso(): Boolean{
        var permiso = Manifest.permission.WRITE_EXTERNAL_STORAGE
        var verificacion = checkSelfPermission(this, permiso)
        return (verificacion == PackageManager.PERMISSION_GRANTED)
    }

    private fun ubicacion(): String{
        val carpeta = File(Environment.getExternalStorageDirectory(), "notas")
        if(!carpeta.exists()){
            carpeta.mkdir()
        }

        return carpeta.absolutePath
    }*/


}