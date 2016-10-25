package com.faberospina.tortasdelgordo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    String sqlCreate2 = "CREATE TABLE Productos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "producto TEXT," +
            "descripcion TEXT," +
            "precio INTEGER)";

    String sqlCreate3 = "CREATE TABLE MisFavoritos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuario INTEGER," +
            "idProducto INTEGER)";

    public ContactosSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
/*        this.DATA_BASE_NAME = DATA_BASE_NAME;
        this.DATA_VERSION = DATA_VERSION;
        this.sqlCreate = sqlCreate;*/
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Contactos");
        db.execSQL("DROP TABLE IF EXIST Productos");
        db.execSQL("DROP TABLE IF EXIST MisFavoritos");

        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);
        db.execSQL(sqlCreate3);

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

    public void AddProd(int idp,String np, String in, int pr) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("id", idp);
            valores.put("producto", np);
            valores.put("descripcion", in);
            valores.put("precio", pr);
            db.insert("Productos", null, valores);
            db.close();
        }
    }

    public void editProd(int idp,String np, String in, int pr){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("producto", np);
        valores.put("descripcion", in);
        valores.put("precio", pr);
        //db.execSQL("UPDATE usuarios SET pass='"+pa+"',email='"+em+"' WHERE usser='"+us+"'");
        db.update("Productos", valores, "id" + idp, null);
        db.close();
    }

    public void eraseProd(int idp) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Productos", "id="+idp, null);
        db.close();
    }

    public Productos getProd(String np) {
        int w,z;
        String x,y;
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id", "producto", "descripcion", "precio"};
        //Cursor c = db.query("usuarios", valores_recuperar, "usser=" + us,null, null, null, null, null);
        //Cursor c=db.rawQuery("select * from usuarios where usser= '"+us+"')",null);
        Cursor c= db.rawQuery("SELECT * FROM Productos WHERE producto= '"+np+"'",null);
        if(c.moveToFirst()) {
            w=c.getInt(0);
            x=c.getString(1);
            y=c.getString(2);
            z=c.getInt(3);
        }
        else{
            w=-1;
            x="no prod";
            y="no descripcion";
            z=-1;
        }
        Productos pr = new Productos(w,x,y,z);
        db.close();
        c.close();
        return pr;
    }

    public Productos getProd(int idp) {
        int w,z;
        String x,y;
        SQLiteDatabase db = getWritableDatabase();
        String[] valores_recuperar = {"id", "producto", "descripcion", "precio"};
        //Cursor c = db.query("usuarios", valores_recuperar, "usser=" + us,null, null, null, null, null);
        //Cursor c=db.rawQuery("select * from usuarios where usser= '"+us+"')",null);
        Cursor c= db.rawQuery("SELECT * FROM Productos WHERE id= '"+idp+"'",null);
        if(c.moveToFirst()) {
            w=c.getInt(0);
            x=c.getString(1);
            y=c.getString(2);
            z=c.getInt(3);
        }
        else{
            w=-1;
            x="no prod";
            y="no descripcion";
            z=-1;
        }
        Productos pr = new Productos(w,x,y,z);
        db.close();
        c.close();
        return pr;
    }

    public List<Productos> getAllProds() {
        SQLiteDatabase db = getReadableDatabase();
        List<Productos> lista_productos = new ArrayList<Productos>();
        String[] valores_recuperar = {"id", "producto", "descripcion", "precio"};
        Cursor c = db.query("Productos", valores_recuperar,
                null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Productos uss = new Productos(c.getInt(0), c.getString(1),
                    c.getString(2), c.getInt(3));
            lista_productos.add(uss);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_productos;
    }

    public void AddFav(int idus, int idProductor) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("idUsuario", idus);
            valores.put("idProducto", idProductor);
            db.insert("MisFavoritos", null, valores);
            db.close();
        }
    }

    public void editFav(int idus, int idProductor){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("idProducto", idProductor);
        //db.execSQL("UPDATE usuarios SET pass='"+pa+"',email='"+em+"' WHERE usser='"+us+"'");
        db.update("MisFavoritos", valores, "idUsuario" + idus, null);
        db.close();
    }

    public void eraseFav(int idus,int idProductor) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("MisFavoritos", "idUsuario="+idus+" AND idProducto="+idProductor, null);
        db.close();
    }

    public Favs getFavs(int idus,int idProductor) {
        int w,x,y;
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id", "idUsuario","idProducto"};
        Cursor c= db.rawQuery("SELECT * FROM MisFavoritos WHERE idUsuario= '"+idus+"' AND idProducto= '"+idProductor+"'",null);
        //Cursor c = db.query("usuarios", valores_recuperar, "usser=" + us,null, null, null, null, null);
        //Cursor c=db.rawQuery("select * from usuarios where usser= '"+us+"')",null);
        //Cursor c= db.rawQuery("SELECT * FROM favoritos WHERE idUsuario= '"+idus+"' AND idProducto= '"+idProductor+"'",null);
        //Cursor c= db.rawQuery("SELECT * FROM favoritos WHERE idUsuario= '"+idus,null);
        //Cursor c = db.query("contactos", valores_recuperar, "idUsuario=" + idus, null, null, null, null, null);
        //Cursor c = db.query("favoritos", valores_recuperar, "idUsuario=" + idus+" AND idProducto="+ idProductor, null, null, null, null, null);

        if(c.moveToFirst()) {
            w=c.getInt(0);
            x=c.getInt(1);
            y=c.getInt(2);
        }
        else{
            w=-1;
            x=-1;
            y=-1;
        }
        Favs fv = new Favs(w,x,y);
        db.close();
        c.close();
        return fv;
    }

    public List<Favs> getAllFavs() {
        SQLiteDatabase db = getReadableDatabase();
        List<Favs> lista_favs = new ArrayList<Favs>();
        String[] valores_recuperar = {"id", "idUsuario", "idProductoroducto"};
        Cursor c = db.query("MisFavoritos", valores_recuperar,
                null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Favs uss = new Favs(c.getInt(0),c.getInt(1),c.getInt(2));
            lista_favs.add(uss);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_favs;
    }

    public List<Favs> getMyFavs(int idus) {
        SQLiteDatabase db = getReadableDatabase();
        List<Favs> lista_favs = new ArrayList<Favs>();
        String[] valores_recuperar = {"id", "idUsuario", "idProducto"};
        Cursor c= db.rawQuery("SELECT * FROM MisFavoritos WHERE idUsuario= '"+idus+"'",null);
        c.moveToFirst();
        do {
            Favs uss = new Favs(c.getInt(0),c.getInt(1),c.getInt(2));
            lista_favs.add(uss);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_favs;
    }



}