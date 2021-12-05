package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import preciado.casal.valenzuela.foraneo101.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth                     //Declaramos una instancia de FIREBASE
    private lateinit var binding: ActivityLoginBinding

    private lateinit var mGoogleSignInClient: GoogleSignInClient;
    val RC_SIGN_IN = 123
    val COD_LOGOUT = 999

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

        /*Empieza el apartado para el Inicio Sesión google*/

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        sign_in_button.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
        if(requestCode == COD_LOGOUT){
            signOut()
        }
    }

/*  No me jaló el updateUI() pero encontré una solución, documentarlo jsjsjs */

    /*override fun onStart() {
        super.onStart()
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }
*/
    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                Toast.makeText(this, "Sesión terminada", Toast.LENGTH_SHORT).show()
            }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            //updateUI(null)
            Toast.makeText(
                baseContext, "Lo sentimos algo salió mal... ",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        if (account != null){
            val intent = Intent(this, Menu_activity::class.java)
            Toast.makeText(
                baseContext, "Registro de usuario completo",
                Toast.LENGTH_SHORT
            ).show()
            /*val personPhoto: Uri = account.getPhotoUrl()
            intent.putExtra("photo", account.photoUrl)*/
            startActivityForResult(intent, COD_LOGOUT)
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