package preciado.casal.valenzuela.foraneo101

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import preciado.casal.valenzuela.foraneo101.databinding.ActivityRegistroBinding
import android.widget.Toast
import android.util.Log
import android.util.Patterns
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth                     //Declaramos una instancia de FIREBASE
    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_registro)

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth                                    //Inicializamos la instancia FIREBASE

        binding.btnBack.setOnClickListener{                     //Si da click en el botón atrás ir a la pantalla principal
            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
        }

        binding.btnGuardarUsuario.setOnClickListener {          //Si da click en el botón guardar validar campos y guardar en FIREBASE
            val mEmail = binding.tvEmail.text.toString()
            val mPassword = binding.tvPassword.text.toString()
            val mRepeatPassword = binding.tvPassword2.text.toString()
            val passwordRegex = Pattern.compile( "^"+
                "(?=.*[-@#$%^&+=])" +   //Al menos 1 carácter especial
                ".{6,}" +               //Al menos 6 caracteres
                "$")

        if (mEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
            Toast.makeText(this, "Ingrese un email valido.",
                Toast.LENGTH_SHORT).show()
        } else if (mPassword.isEmpty() || !passwordRegex.matcher(mPassword).matches()){
            Toast.makeText(this, "La contraseña es debil.",
                Toast.LENGTH_SHORT).show()
        } else if (mPassword != mRepeatPassword){
            Toast.makeText(this, "Las contraseñas no coinciden",
                Toast.LENGTH_SHORT).show()
        }else{
            createAccount(mEmail, mPassword)
        }

        }
    }

    private fun createAccount(email:String, password:String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "Registro completo",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this, Menu_activity::class.java)
                        this.startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
    }
}