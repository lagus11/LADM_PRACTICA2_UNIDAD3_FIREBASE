package mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startTimer()
    }

    fun startTimer(){
        object : CountDownTimer(3000,1000){
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                val intent1 = Intent(applicationContext, MainActivity2::class.java).apply {}
                startActivity(intent1)
            }
        }.start()
    }
}