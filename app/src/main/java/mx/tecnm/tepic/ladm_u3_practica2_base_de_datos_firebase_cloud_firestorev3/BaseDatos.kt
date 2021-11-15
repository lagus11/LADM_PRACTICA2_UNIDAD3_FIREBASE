package mx.tecnm.tepic.ladm_u3_practica2_base_de_datos_firebase_cloud_firestorev3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(p: SQLiteDatabase) {
        //se ejecuta cuando se instala la app en el cel y corre por 1vez
        //en kotlin puedes hacer el crud de 2 maneras diferentes
        // 1. tradicional con instrucciones sql.(insert int,update, delete from, selec* from
        // 2. la poo que maneja metodos que ejecutan instrucciones ql
        p.execSQL("CREATE TABLE Notas(IDNOTA INTEGER PRIMARY KEY AUTOINCREMENT,TITULO VARCHAR(100),CONTENIDO VARCHAR(2000), FECHA DATE, HORA DATE )")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        //se ejecuta cuando hay un cambio de version
    }
}