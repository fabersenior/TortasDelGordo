package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PerfilActivity extends NavegationActivity {

    String MiUser,MiEmail,MiPass;
    TextView tUser,tMail,tPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.activity_perfil_);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_perfil_, contentFrameLayout);
        rep();

        tUser = (TextView) findViewById(R.id.tUser);
        tMail = (TextView) findViewById(R.id.tEmail);
        tPass = (TextView) findViewById(R.id.tPass);

        tUser.setText(MiUser);
        tMail.setText(MiEmail);
        tPass.setText(MiPass);

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

                break;

            case R.id.publicidad :
                Intent intent = new Intent(this,Main1Activity.class);// crea un nuevo intent
 /*               intent.putExtra("kName",tUser.getText().toString()); //tname.getText().toString()
                intent.putExtra("kPass",tPass.getText().toString());
                intent.putExtra("kMail",tMail.getText().toString());*/
                //startActivityForResult(intent,1234);
                startActivity(intent);
                break;

            case R.id.catalogo:
                Intent intent1 = new Intent(this,CatalogoActivity.class);// crea un nuevo intent
 /*               intent.putExtra("kName",tUser.getText().toString()); //tname.getText().toString()
                intent.putExtra("kPass",tPass.getText().toString());
                intent.putExtra("kMail",tMail.getText().toString());*/
                //startActivityForResult(intent,1234);
                startActivity(intent1);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public  void rep(){
        //Bundle extras = getIntent().getExtras();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
       // String  data = prefs.getString("name", "08:00") ;

        MiEmail = prefs.getString("kEmail","07");
        MiUser = prefs.getString("kName","07");
        MiPass = prefs.getString("kPass","07");

    }
}
