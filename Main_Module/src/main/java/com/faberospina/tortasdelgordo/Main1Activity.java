package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Main1Activity extends AppCompatActivity {

    String usuario,password,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

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
                intent.putExtra("kUsuario",usuario); //tname.getText().toString()
                intent.putExtra("kPassword",password);
                intent.putExtra("kMail2",correo);
                //startActivityForResult(intent,1234);
                startActivity(intent);
                break;

            case R.id.publicidad :
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}
