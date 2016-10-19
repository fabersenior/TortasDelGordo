package com.faberospina.tortasdelgordo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Faber on 19/10/2016.
 */

public class MisFavoritosSQLHelp extends SQLiteOpenHelper {

    private String DATA_BASE_NAME = "TortasBD";
    private int DATA_VERSION =1;

    String sqlCreate = "CREATE TABLE MisFavoritos (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idUsuario TEXT," +
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
}