package preciado.casal.valenzuela.foraneo101

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import preciado.casal.valenzuela.foraneo101.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth                     //Declaramos una instancia de FIREBASE
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth                                    //Inicializamos la instancia FIREBASE

        binding.btnIniciar.setOnClickListener {                 //Al presionar el botón iniciarsesión valida los campos
            val mEmail = binding.emailEditText.text.toString()
            val mPassword = binding.passordEditText.text.toString()

            when{
                mEmail.isEmpty() || mPassword.isEmpty()->{
                    Toast.makeText(baseContext, "El campo correo o contraseña están vacíos...",
                        Toast.LENGTH_SHORT).show()
                }else ->{
                    SignIn(mEmail, mPassword)
                }
            }
        }

        binding.btnRegistrar.setOnClickListener{                //Al presionar el botón registrarse te lleva a la pantalla de registro
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun SignIn(email:String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this,
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithEmail:success")
                        reload()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        //updateUI(null)
                    }
                })
    }

    private fun reload() {
        val intent = Intent(this, Menu_activity::class.java)
        this.startActivity(intent)
    }
}