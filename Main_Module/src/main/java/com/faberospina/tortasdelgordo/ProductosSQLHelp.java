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

public class ProductosSQLHelp extends SQLiteOpenHelper {

    private String DATA_BASE_NAME = "CatalogoBD";
    private int DATA_VERSION =1;

    String sqlCreate = "CREATE TABLE Productos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "producto TEXT," +
            "descripcion INTEGER," +
            "precio INTEGER)";

    public ProductosSQLHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
        db.execSQL("DROP TABLE IF EXIST Productos");
        db.execSQL(sqlCreate);
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
}
