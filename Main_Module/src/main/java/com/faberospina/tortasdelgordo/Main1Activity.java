package com.faberospina.tortasdelgordo;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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
    ContactosSQLHelper contactosSQLHelper;
    ProductosSQLHelp productosSQLHelp;
    MisFavoritosSQLHelp misFavoritosSQLHelp;

    final ProductosSQLHelp PDB = new ProductosSQLHelp(this,"catalogoBD",null,1);
/*    String sqlCreate = "CREATE TABLE Productos2 (" +  "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "producto TEXT," +
            "descripcion INTEGER," +
            "precio TEXT)";*/

  /*  SharedPreferences prefs;
    SharedPreferences.Editor editor;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
       // setContentView(R.layout.activity_main1);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main1, contentFrameLayout);

        // CREA BASE DE DATOS
   /*     contactosSQLHelper = new ContactosSQLHelper(getApplicationContext(),"TortasBD",null,1);
        productosSQLHelp = new ProductosSQLHelp(getApplicationContext(),"TortasBD",null,1);
        misFavoritosSQLHelp = new MisFavoritosSQLHelp(getApplicationContext(),"TortasBD",null,1);

                //CREA BASE DE DATOS EDITABLES
        db = contactosSQLHelper.getWritableDatabase();
        db= productosSQLHelp.getWritableDatabase();
        db = misFavoritosSQLHelp.getWritableDatabase();*/

        //db.execSQL(sqlCreate);

        if(PDB.getProd(1).getId()<0){
            //al crear al tabla esta ya esta llena;
            PDB.AddProd(1,"Torta deliciosa","Ofrecida en todas las tiendas",15000);
            PDB.AddProd(2,"La mejor torta para acompañar","disponilbe en medellin",12000);
            PDB.AddProd(3,"Excelente para compartir","Aprovechala en promocion",13000);
            PDB.AddProd(4,"La mejor torta de  todas","solo por hoy lleve 2x1",8000);
            PDB.AddProd(5,"Disfrutala en pequeñas porciones","a 50% de descuento",7500);
            PDB.AddProd(6,"LLevala hoy y siempre","con su delicioso sabor la torta degustara de tus sentidos",7500);
            //fin
        }



        if (getIntent() == null) {

            Log.d("k","intent nulo");
        }else {
            Bundle b = getIntent().getExtras();

            if (getIntent().getExtras() == null) {

            } else {

                usuario = b.getString("kName");
                password = b.getString("kPass");
                correo = b.getString("kMail");

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


}
