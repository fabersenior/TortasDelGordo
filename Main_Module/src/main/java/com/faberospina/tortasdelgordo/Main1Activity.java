package com.faberospina.tortasdelgordo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class Main1Activity extends NavegationActivity {

    String usuario,password,correo;
    ContentValues dataBD;
    SQLiteDatabase db;
/*
    SharedPreferences prefs;
    SharedPreferences.Editor editor;*/



    final ContactosSQLHelper UDB = new ContactosSQLHelper(this,"TortasBD",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
       // setContentView(R.layout.activity_main1);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main1, contentFrameLayout);

        //prefs = getApplicationContext().getSharedPreferences("com.sp.main_preferences",Context.MODE_PRIVATE);

        // CREA BASE DE DATOS
   /*     contactosSQLHelper = new ContactosSQLHelper(getApplicationContext(),"TortasBD",null,1);
        productosSQLHelp = new ProductosSQLHelp(getApplicationContext(),"TortasBD",null,1);
        misFavoritosSQLHelp = new MisFavoritosSQLHelp(getApplicationContext(),"TortasBD",null,1);

                //CREA BASE DE DATOS EDITABLES
        db = contactosSQLHelper.getWritableDatabase();
        db= productosSQLHelp.getWritableDatabase();
        db = misFavoritosSQLHelp.getWritableDatabase();*/

        //db.execSQL(sqlCreate);
/*        UDB.eraseProd(1);
        UDB.eraseProd(2);
        UDB.eraseProd(3);
        UDB.eraseProd(4);
        UDB.eraseProd(5);
        UDB.eraseProd(6);

        UDB.AddProd(1,"Bizcocho Tradicional","Rico Bizcocho Tradicional a 2x1",50000);
        UDB.AddProd(2,"Maria Luisa de Arequipe","Compra una Maria Luisa de Arequipe con 20% de Descuento",30000);
        UDB.AddProd(3,"Chocolate","La mejor torta para compartir ahora mas economica",67000);
        UDB.AddProd(4,"Erotico Senos","LLeva esta espectacular diseño erotico para sorprender a tus familiares, mas economico que antes",80000);
        UDB.AddProd(5,"Cama Erotica","La mejor posicion para practicar en casa con su pareja ahora en una torta, 50% de descuento en septiembre",75000);*/


        if(UDB.getProd(1).getId()<0){
            //al crear al tabla esta ya esta llena;

            UDB.AddProd(1,"Bizcocho Tradicional","Rico Bizcocho Tradicional a 2x1",50000);
            UDB.AddProd(2,"Maria Luisa de Arequipe","Compra una Maria Luisa de Arequipe con 20% de Descuento",30000);
            UDB.AddProd(3,"Chocolate","La mejor torta para compartir ahora mas economica",67000);
            UDB.AddProd(4,"Erotico Senos","LLeva esta espectacular diseño erotico para sorprender a tus familiares, mas economico que antes",80000);
            UDB.AddProd(5,"Cama Erotica","La mejor posicion para practicar en casa con su pareja ahora en una torta, 50% de descuento en septiembre",75000);
           // UDB.editProd(6,"LLevala hoy y siempre","con su delicioso sabor la torta degustara de tus sentidos",7500);
            //fin
        }

       // Log.d("name",)



        if (getIntent() == null) {

            Log.d("k","intent nulo");
            //SavePreferences("kName",UDB.);

        }else {
            Bundle b = getIntent().getExtras();

            if (getIntent().getExtras() == null) {
                Log.d("extras","extras nulos");

            } else {

                usuario = b.getString("kName");
                password = b.getString("kPass");
                correo = b.getString("kMail");

                SavePreferences("kName",UDB.getUsser(usuario).getUsser());//Actualiza las preferencias compartidas con respecto a la base de datos
                SavePreferences("kPass",UDB.getUsser(usuario).getPass());
                SavePreferences("kEmail",UDB.getUsser(usuario).getEmail());

            }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        switch (id){
            case R.id.miperfil:


                Intent intent = new Intent(this,PerfilActivity.class);// crea un nuevo intent
              /*  intent.putExtra("kUsuario",usuario); //tname.getText().toString()
                intent.putExtra("kPassword",password);
                intent.putExtra("kMail2",correo);*/
                //startActivityForResult(intent,1234);
                startActivity(intent);
                break;

            case R.id.publicidad :
                break;

            case R.id.catalogo :
                Intent intent1= new Intent(this,CatalogoActivity.class);
/*                intent1.putExtra("kUsuario",usuario); //tname.getText().toString()
                intent1.putExtra("kPassword",password);
                intent1.putExtra("kMail2",correo);*/
                startActivity(intent1);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void SavePreferences(String key, String value){
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences prefs  = getApplicationContext().getSharedPreferences("com.sp.main_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        //Toast.makeText(getApplicationContext(),prefs.getString("kName","08:00"),Toast.LENGTH_SHORT).show();
        editor.commit();
/*        Intent sd=new Intent(this,Secongtess.class);
        startActivity(sd);*/
    }


}
