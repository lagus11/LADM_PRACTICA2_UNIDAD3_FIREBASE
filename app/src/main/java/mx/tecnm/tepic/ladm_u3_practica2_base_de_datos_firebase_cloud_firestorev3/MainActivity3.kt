package mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*
import kotlinx.android.synthetic.main.activity_actualizar.contenido
import kotlinx.android.synthetic.main.activity_actualizar.titulo
import kotlinx.android.synthetic.main.activity_main3.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        cancelar.setOnClickListener() {
            finish()
        }//cancelar

        aceptar.setOnClickListener() {
            insertar()
        }//aceptar

        sincronizar.setOnClickListener {
            Nota(this).insertarNube()
            //NotaFireBase(this).borrarDatosNube()

        }
    }//onCreate

    private fun insertar() {
        val nota = Nota(this)
        val sdffecha = SimpleDateFormat("yyyy-MM-dd")
        val fecha = sdffecha.format(Date())
        val sdfhora = SimpleDateFormat("HH-mm")
        val hora = sdfhora.format(Date())

        nota.titulo = titulo.text.toString()
        nota.contenido = contenido.text.toString()
        nota.fecha = fecha
        nota.hora = hora

        val resultado = nota.insertar()
        if(resultado){
            Toast.makeText(this,"SE CAPTURO LA NOTA", Toast.LENGTH_LONG).show()
            titulo.setText("")
            contenido.setText("")
        }else{
            Toast.makeText(this,"ERROR", Toast.LENGTH_LONG).show()
        }
    }//insertar
}