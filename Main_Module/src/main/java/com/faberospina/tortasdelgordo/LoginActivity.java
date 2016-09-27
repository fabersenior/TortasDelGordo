package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
     EditText eName,ePass;
    String user="",pass="",email="",var=" ";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);


        eName=(EditText) findViewById(R.id.eNombre);
        ePass= (EditText) findViewById(R.id.ePassword);



        eName.setText("");
        ePass.setText("");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        eName.setText("");
        ePass.setText("");

        

        if (requestCode==1234 && resultCode==RESULT_OK){
            prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            editor = prefs.edit();
            user = data.getExtras().getString("kName");//obtengo el extra de RegistroActivity con la clave
            pass = data.getExtras().getString("kPass");
            email = data.getExtras().getString("kEmail");
            Log.d("var",prefs.getString("kName", "07:00"));
            Log.d("User",user);//lo imprime en el log(consola) o terminal
            Log.d("password",pass);
            Log.d("email",email);



        }else if(requestCode==1234 && resultCode==RESULT_CANCELED){
           // startActivity(getParentActivityIntent());
            Log.d("Noload","NO hay datos");

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void BtnIngresarOnClick(View view) {
        int ok=0;
        Intent intent= new Intent(getApplicationContext(),Main1Activity.class);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(eName.length()==0){
            Toast.makeText(getApplicationContext(),"Ingrese Usuario",Toast.LENGTH_SHORT).show();
        }else{    //
            if(user.length()==0 || prefs.getString("kName","07").length()==0){
                Toast.makeText(getApplicationContext(),"Usuario no Registrado",Toast.LENGTH_SHORT).show();
            }else {
                if(eName.getText().toString().equals(user) || eName.getText().toString().equals(prefs.getString("kName","07"))){//
                    ok++;
                    //intent.putExtra("kName",eName.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }

        }

        if (ePass.length()==0){
            Toast.makeText(getApplicationContext(),"Ingrese contraseña",Toast.LENGTH_SHORT).show();
        }else {
            if(pass.length()==0 || prefs.getString("kPass","07").length()==0){
                Toast.makeText(getApplicationContext(),"Usuario no Registrado",Toast.LENGTH_SHORT).show();
            }else{
                if( ePass.getText().toString().equals(pass) || ePass.getText().toString().equals(prefs.getString("kPass","07"))){
                    ok++;
                    //intent.putExtra("kPass",ePass.getText().toString());
                    //intent.putExtra("kMail",email);
                    Log.d("valor de k2",Integer.toString(ok));
                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        }

        if (ok>=2){
            startActivity(intent);
        }

    }

    public void BtnOnClick(View view){
        Intent intent = new Intent(this,RegistroActivity.class);// crea un nuevo intent
        //Intent intent = new Intent();
        startActivityForResult(intent,1234);
    }




/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        switch (id){
            case R.id.miperfil:
                Intent intent = new Intent(this,RegistroActivity.class);// crea un nuevo intent
//                intent.putExtra("toper",tname.getText().toString());
//                intent.putExtra("bot",temail.getText().toString());

                startActivityForResult(intent,1234);
               // startActivity(intent);
                break;

            case R.id.publicidad :
                break;

        }

        return super.onOptionsItemSelected(item);
    }*/
}
