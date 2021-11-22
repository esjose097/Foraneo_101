package preciado.casal.valenzuela.foraneo101

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils

import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.asset_fade_in)
        iv_splash_logo.startAnimation(splashAnimation)

        tv_circulo1.startAnimation(splashAnimation)
        tv_circulo2.startAnimation(splashAnimation)

        tv_cuadrado1.startAnimation(splashAnimation)
        tv_cuadrado2.startAnimation(splashAnimation)

        tv_star1.startAnimation(splashAnimation)

        tv_triangulo1.startAnimation(splashAnimation)

        @Suppress("DEPRECATION")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                //Launch the main activity
                startActivity(
                    Intent(this, LoginActivity::class.java )
                )
                finish()
            }, 3000
        )


    }




}