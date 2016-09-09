package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String MiUser,MiEmail,MiPass;
    TextView tUser,tMail,tPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_);

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
                intent.putExtra("kName",tUser.getText().toString()); //tname.getText().toString()
                intent.putExtra("kPass",tPass.getText().toString());
                intent.putExtra("kMail",tMail.getText().toString());
                //startActivityForResult(intent,1234);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public  void rep(){
        Bundle extras = getIntent().getExtras();

        MiEmail = extras.getString("kMail2");
        MiUser = extras.getString("kUsuario");
        MiPass = extras.getString("kPassword");

    }
}
