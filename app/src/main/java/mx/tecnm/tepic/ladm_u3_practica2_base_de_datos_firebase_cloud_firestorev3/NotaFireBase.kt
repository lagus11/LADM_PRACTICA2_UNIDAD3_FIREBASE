package mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore

class NotaFireBase(p:Context) {

    var id = 0
    var titulo = ""
    var contenido = ""
    var fecha = ""
    var hora = ""
    var pnt = p
    var baseRemota = FirebaseFirestore.getInstance()

    fun insertar(){

        var datosInsertar = hashMapOf(
            "id" to id,
            "titulo" to titulo,
            "contenido" to contenido,
            "fecha" to fecha,
            "hora" to hora
        )
        baseRemota.collection("notas")
            .add(datosInsertar as Any)
            .addOnSuccessListener {
                AlertDialog.Builder(pnt).setMessage("Se ha realizado con exito la sincronizacion")
                    .setPositiveButton("ACEPTAR "){d,i-> d.cancel()}
                    .show()
            }
            .addOnFailureListener{
                AlertDialog.Builder(pnt).setMessage("ERROR: ${it.message!!}")
                    .setPositiveButton("ACEPTAR "){d,i-> d.cancel()}
                    .show()
            }
    }//insertar

    /*fun eliminarNube(id:String) {
        baseRemota.collection("notas")
            .document(id)
            .delete()
    }//eliminar

    fun borrarDatosNube(){
        baseRemota.collection("notas")
        .addSnapshotListener { querySnapshot, error ->
            if(error !=null){
                //mensaje(error.message!!)
                return@addSnapshotListener
            }//if
            for(document in querySnapshot!!){
                eliminarNube(document.id.toString())
            }//for
        }
    }//.addSnapshow*/
}
