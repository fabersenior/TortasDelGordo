package com.faberospina.tortasdelgordo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Faber on 19/10/2016.
 */
public class ContactosSQLHelper extends SQLiteOpenHelper {

    private String DATA_BASE_NAME = "TortasBD";
    private int DATA_VERSION =1;

    String sqlCreate = "CREATE TABLE Contactos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "usuario TEXT," +
            "contraseña INTEGER," +
            "correo TEXT)";

/*    String sqlCreate2 = "CREATE TABLE Productos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "producto TEXT," +
            "descripcion INTEGER," +
            "precio INTEGER)";

    String sqlCreate3 = "CREATE TABLE MisFavoritos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuario TEXT," +
            "idProducto INTEGER)";*/

    public ContactosSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
/*        this.DATA_BASE_NAME = DATA_BASE_NAME;
        this.DATA_VERSION = DATA_VERSION;
        this.sqlCreate = sqlCreate;*/
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Contactos");
        db.execSQL(sqlCreate);

    }

    public void AddUsser(String us, String pa, String em) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("usuario", us);
            valores.put("contraseña", pa);
            valores.put("correo", em);
            db.insert("Contactos", null, valores);
            db.close();
        }
    }

    public void editusuario(String us, String pa, String em){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("contraseña", pa);
        valores.put("correo", em);


        //db.execSQL("UPDATE usuarios SET contraseña='"+pa+"',correo='"+em+"' WHERE usuario='"+us+"'");
        db.update("Contactos", valores, "usuario" + us, null);
        db.close();
    }

    public void eraseusuario(String us) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Contactos", "usuario="+us, null);
        db.close();
    }

    public Usuarios getUsser(String us) {
        int w;
        String x,y,z;
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id", "usuario", "contraseña", "correo"};
        //Cursor c = db.query("usuarios", valores_recuperar, "usuario=" + us,null, null, null, null, null);
        //Cursor c=db.rawQuery("select * from usuarios where usuario= '"+us+"')",null);
        Cursor c= db.rawQuery("SELECT * FROM Contactos WHERE usuario= '"+us+"'",null);
        if(c.moveToFirst()) {
            w=c.getInt(0);
            x=c.getString(1);
            y=c.getString(2);
            z=c.getString(3);
        }
        else{
            w=-1;
            x="no usuario";
            y="no contraseña";
            z="no correo";
        }
        Usuarios u = new Usuarios(w,x,y,z);
        db.close();
        c.close();
        return u;
    }



}