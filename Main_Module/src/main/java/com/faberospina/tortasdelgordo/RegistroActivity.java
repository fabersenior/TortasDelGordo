package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText eName,ePass,ePass2,eEmail;
    private  String pass,correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eName = (EditText) findViewById(R.id.eUser);
        ePass = (EditText) findViewById(R.id.ePass);
        eEmail = (EditText) findViewById(R.id.eEmail);
        ePass2 = (EditText) findViewById(R.id.ePass2);

       // Bundle extras = getIntent().getExtras();


    }

/*    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        switch (id){
            case R.id.miperfil:

                break;

           *//* case R.id.publicidad :
                //Intent intent = new Intent(this,LoginActivity.class);// crea un nuevo intent
                //intent.putExtra()

                //startActivity(intent);

                Intent intent = new Intent();
               // intent.putExtra("kName",);
                //setResult(RESULT_OK,intent);
                break;
*//*
        }

        return super.onOptionsItemSelected(item);
    }*/

    public void BtnAceptar(View view){
        Intent intent = new Intent();
        int ok=0;
        if(eName.length()==0){
            Toast.makeText(getApplicationContext(),"Nombre Vacio",Toast.LENGTH_SHORT).show();
        }else{
            intent.putExtra("kName",eName.getText().toString());
            ok++;
        }

        if(ePass.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Password", Toast.LENGTH_SHORT)
                    .show();

        }else{
            pass=ePass.getText().toString();
            intent.putExtra("kPass",pass);
            ok++;
        }
        if(ePass2.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Password", Toast.LENGTH_SHORT)
                    .show();
            //info="Informacion: ";

        }else{
            if(pass.equals(ePass2.getText().toString()) ){
                Toast.makeText(getApplicationContext(), "Password correct", Toast.LENGTH_SHORT)
                        .show();
                intent.putExtra("kPass",pass);
                ok++;//3

            }else{
                Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        if (eEmail.length()==0){
            Toast.makeText(getApplicationContext(), "Ingrese Correo", Toast.LENGTH_SHORT)
                    .show();

        }else{
            correo=eEmail.getText().toString();
            intent.putExtra("kEmail",correo);
            ok++;//4
            Log.d("valor k:",Integer.toString(ok));
        }

        if (ok>=4){
            setResult(RESULT_OK,intent);
            finish();
        }



    }

    public void BtnCancel(View view){

        Intent intent = new Intent();
        setResult(RESULT_CANCELED,intent);
        finish();
        //startActivity(intent);

    }
}
