package preciado.casal.valenzuela.foraneo101

import android.Manifest
import android.app.Activity
import android.content.Context
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


import java.io.File
import java.io.FileOutputStream

class NotaActivity : AppCompatActivity() {
    val eTitulo: EditText = findViewById(R.id.et_titutlo)
    val eContenido: EditText = findViewById(R.id.et_contenido)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        val btnG: Button =findViewById(R.id.btn_guardar)

        btnG.setOnClickListener {
            guardar_Nota()
        }


        /*
        Nose que es esto pero no lo borre por si acaso era una mouse Herramienta miesteriosa que nos
        ayudará despues.
        var extras = intent.extras
        if (extras != null){
            var titulo = extras.getString("titulo")
            var contenido = extras.getString("contenido")

            val et_titutlo: TextView = findViewById(R.id.et_titutlo)
            et_titutlo.setText(titulo)

            val et_contenido: TextView = findViewById(R.id.et_contenido)
            et_contenido.setText(contenido)
        }*/
    }

    fun guardar_Nota(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                235)
        }
        else{}
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