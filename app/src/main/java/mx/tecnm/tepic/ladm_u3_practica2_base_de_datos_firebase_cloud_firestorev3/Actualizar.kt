package mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*
import mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3.Actualizar
import java.text.SimpleDateFormat
import java.util.*

class Actualizar : AppCompatActivity() {

    var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)


        var extra = intent.extras
        id = extra!!.getString("idActualizar")!!
        consultaActualizar()

        Regresar.setOnClickListener {
            finish()
        }//Regresar

        Actualizar.setOnClickListener {
            actualizart()
        }//Actualizar

        Borrar.setOnClickListener {
            eliminar()
        }
    }//onCreate

    fun consultaActualizar() {
        val nota = Nota(this).consultaActualizar(id)
        var datos = nota.get(0).split("#$")
        var Obttitulo = datos[0]
        var Obtcontenido = datos[1]

        titulo.setText(Obttitulo)
        contenido.setText(Obtcontenido)
    }///consultaActualizar

    fun actualizart() {
        val nota = Nota(this)
        val sdffecha = SimpleDateFormat("yyyy-MM-dd")
        val fecha = sdffecha.format(Date())
        val sdfhora = SimpleDateFormat("HH-mm")
        val hora = sdfhora.format(Date())

        nota.titulo = titulo.text.toString()
        nota.contenido = contenido.text.toString()
        nota.fecha = fecha
        nota.hora = hora

        val resultado = nota.actualizar(id)
        if (resultado) {
            Toast.makeText(this, "EXITO SE ACTUALIZO", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "ERROR NO SE LOGRO ACTUALIZAR", Toast.LENGTH_LONG).show()
        }
    }//actualizar

    private fun eliminar() {
        val resultado = Nota(this).eliminar(id.toInt())
        if (resultado) {
            Toast.makeText(this, "Se elemino con exito", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Error no se logro eliminar", Toast.LENGTH_LONG).show()
        }
    }//eliminar


}