package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;

public class Main1Activity extends NavegationActivity {

    String usuario,password,correo;
  /*  SharedPreferences prefs;
    SharedPreferences.Editor editor;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
       // setContentView(R.layout.activity_main1);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main1, contentFrameLayout);

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
