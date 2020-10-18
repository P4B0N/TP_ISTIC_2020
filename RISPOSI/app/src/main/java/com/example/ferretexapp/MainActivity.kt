package com.example.ferretexapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        // Agregar animaciones
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val deTextView = findViewById<TextView>(R.id.deTextView)
        val risposiTextView = findViewById<TextView>(R.id.risposiTextView)
        val logoImageView = findViewById<ImageView>(R.id.logoImageView)

        //Definición de la animación de cada componente
        deTextView.animation = animacion2
        risposiTextView.animation = animacion2
        logoImageView.animation = animacion1

        //Función Hnadler para hacer el post de las animaciones y definimos el tiempo que dura el Splash Screen
        Handler().postDelayed({
            val intentSplashScreen = Intent(this@MainActivity, Registro::class.java)
            startActivity(intentSplashScreen)

            /*
            //Funcion Array donde defino las transiciones para que se conecte con las otras pantallas
            val pairs: Array<Pair<*, *>?> = arrayOfNulls(2)
            pairs[0] = Pair<View, String>(
                logoImageView,
                "logoImageTrans"
            )
            pairs[1] = Pair<View, String>(risposiTextView, "textTrans")

            //Código para ver si esta la versión correcta
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, *pairs)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
                finish()
            }*/

        }, 4000)
    }
}



/*
// Splash Screen Version 1
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        // Agregar animaciones
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val deTextView = findViewById<TextView>(R.id.deTextView)
        val risposiTextView = findViewById<TextView>(R.id.risposiTextView)
        val logoImageView =
            findViewById<ImageView>(R.id.logoImageView)
        deTextView.animation = animacion2
        risposiTextView.animation = animacion2
        logoImageView.animation = animacion1
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
*/