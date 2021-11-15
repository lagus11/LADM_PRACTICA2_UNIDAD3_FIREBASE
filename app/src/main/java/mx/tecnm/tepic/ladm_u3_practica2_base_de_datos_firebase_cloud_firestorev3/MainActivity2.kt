package mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    var archivos = ArrayList<String>()
    var idNota =ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        consultaNotas()

        agregar.setOnClickListener() {
            var agregar = Intent(this, MainActivity3::class.java)
            //agregar.putExtra("abiertos",archivos)
            startActivity(agregar)
            DeseaActualizarLista()
        }//agregar------------------------------------------

    }//onCreate

    fun consultaNotas(){
        var con = ArrayList<String>()
        val arregloNota = Nota(this).consulta()
        if(!(arregloNota[0]=="No hay Notas")) {
            for(i in arregloNota){
                var nota = i.split("#$")
                con.add(nota[0]+"\n"+nota[1]+"\n"+nota[2]+"\n"+nota[3]+"\n"+nota[4]+"\n")
            }
            listaNota.setPadding(10,15,10,0)
            listaNota.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,con)
            idNota.clear()
            idNota = Nota(this).obtenerIDs()
            activarEvento(listaNota)
        }//if
    }//consultaNotas


    private fun activarEvento(listaNotas: ListView){
        listaNotas.setOnItemClickListener { adapterView, view, indiceSeleccionado, l ->
            val idSeleccionado = idNota[indiceSeleccionado]
            val intento = Intent(this, Actualizar::class.java)
            intento.putExtra("idActualizar",idSeleccionado.toString())
            startActivity(intento)
            DeseaActualizarLista()
        }
    }//activarEvento

    fun DeseaActualizarLista(){
        AlertDialog.Builder(this).setMessage("DESEAS ACTUALIZAR LISTA?")
            .setPositiveButton("SI "){d,i-> consultaNotas()}
            .setNegativeButton("NO "){d,i-> d.cancel()}
            .show()
    }//DeseaActualizarLista
}//Main

