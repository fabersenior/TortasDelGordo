package com.faberospina.tortasdelgordo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

public class showActivity extends AppCompatActivity {

    int pos;
    int prod;
    ImageView imageShow;
    Button BSF;
    String uu;
    CheckBox CBF;

    private final static String usuario="usuario";
    private final static String password="password";
    private final static String correo="correo";
    private final static String jumplis="no";

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String usuario2,password2,correo2,jp;

    final MisFavoritosSQLHelp FDB = new MisFavoritosSQLHelp(this,"favoritosBD",null,1);
    final ContactosSQLHelper UDB = new ContactosSQLHelper(this,"LoginBD",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show);

        BSF  = (Button) findViewById(R.id.savefav);
        CBF  = (CheckBox) findViewById(R.id.checkfav);

        prefs = getApplicationContext().getSharedPreferences("com.sp.main_preferences", Context.MODE_PRIVATE);


        correo2 = prefs.getString("kEmail","07");
        usuario2 = prefs.getString("kName","07");
        password2 = prefs.getString("kPass","07");

        Bundle bundle= getIntent().getExtras();

        imageShow = (ImageView) findViewById(R.id.imageView);


        pos=bundle.getInt("kPos");
        prod=pos+1;
        CBF.setChecked(FDB.getFavs(UDB.getUsser(usuario2).getId(),prod).getId()>0);
        Log.d("ADebugTag", "Usuario: " + UDB.getUsser(usuario2).getId());
        Log.d("ADebugTag", "posicion: " + prod);
        Log.d("ADebugTag", "Value: " + FDB.getFavs(UDB.getUsser(usuario2).getId(),pos+1).getId());
        BSF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                if(CBF.isChecked()){
                    FDB.AddFav(UDB.getUsser(usuario2).getId(),prod);
                    uu ="añadido a favoritos";
                    Toast.makeText(showActivity.this, uu, Toast.LENGTH_SHORT).show();
                }
                else{
                    FDB.eraseFav(UDB.getUsser(usuario2).getId(),pos+1);
                    uu = "este producto ya no hace parte e sus favoritos";
                    Toast.makeText(showActivity.this, uu, Toast.LENGTH_SHORT).show();
                }
            }
        });

        CBF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                BSF.setVisibility(View.VISIBLE);
            }
        });

        switch (pos){
            case 0:
                imageShow.setImageResource(R.drawable.bizcocho_tradicional);
                break;

            case 1:
                imageShow.setImageResource(R.drawable.maria_luisa_arequipe);
                break;

            case 2:
                imageShow.setImageResource(R.drawable.big_chocolate);
                break;

            case 3:
                imageShow.setImageResource(R.drawable.phoca_697);
                break;

            case  4:
                imageShow.setImageResource(R.drawable.cama_erotico);
                break;

        }


    }
}
