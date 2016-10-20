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

public class MisFavoritosSQLHelp extends SQLiteOpenHelper {

    private String DATA_BASE_NAME = "FavoritosBD";
    private int DATA_VERSION =1;

    String sqlCreate = "CREATE TABLE MisFavoritos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuario INTEGER," +
            "idProducto INTEGER)";

    public MisFavoritosSQLHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
        db.execSQL("DROP TABLE IF EXIST MisFavoritos");
        db.execSQL(sqlCreate);
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
        db.delete("MisFavoritos", "idUsuario="+idus+" AND idProductoroducto="+idProductor, null);
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