package com.faberospina.tortasdelgordo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;
import  static com.faberospina.tortasdelgordo.R.id.lstf;




/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    String P1,P2,P3,P4,P5,P6,I1,I2,I3,I4,I5,I6;
    String MiPass;
    int V1,V2,V3,V4,V5,V6;
    int[] C={0,0,0,0,0,0};

    int usu=0,i=0,j=0;

    ArrayList<Lista_entrada> data;
    private Lista_entrada[] datos= new Lista_entrada[]{
            new Lista_entrada(R.color.red,"",0,""),
            new Lista_entrada(R.color.red,"",0,""),
            new Lista_entrada(R.color.red,"",0,""),
            new Lista_entrada(R.color.red,"",0,""),
            new Lista_entrada(R.color.red,"",0,""),
            new Lista_entrada(R.color.red,"",0,"")
    };

    String usuario1,correo1,jp;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Adapter adapterData;

    ListView lst;

    public FavoritosFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        //prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        prefs = getActivity().getSharedPreferences("com.sp.main_preferences", Context.MODE_PRIVATE);
       // prefs = getApplicationContext().getSharedPreferences("com.sp.main_preferences", Context.MODE_PRIVATE);
        //Recupera los valores de usuario y contraseña guardados en la actividad de SignUp
/*        usuario1= prefs.getString(usuario,"");
        correo1= prefs.getString(correo,"");
        jp= prefs.getString(jumplis,"");*/

        correo1 = prefs.getString("kEmail","07");
        usuario1 = prefs.getString("kName","07");
        MiPass = prefs.getString("kPass","07");



       /* final MisFavoritosSQLHelp UDB = new MisFavoritosSQLHelp(this.getContext(),"favoritosBD",null,1);
        final ProductosSQLHelp UDB = new ProductosSQLHelp(this.getContext(),"catalogoBD",null,1);*/
        final ContactosSQLHelper UDB = new ContactosSQLHelper(this.getContext(),"TortasBD",null,1);

        P1=UDB.getProd(1).getNamep();I1=UDB.getProd(1).getInfo();
        P2=UDB.getProd(2).getNamep();I2=UDB.getProd(2).getInfo();
        P3=UDB.getProd(3).getNamep();I3=UDB.getProd(3).getInfo();
        P4=UDB.getProd(4).getNamep();I4=UDB.getProd(4).getInfo();
        P5=UDB.getProd(5).getNamep();I5=UDB.getProd(5).getInfo();
        P6=UDB.getProd(6).getNamep();I6=UDB.getProd(6).getInfo();
        V1=UDB.getProd(1).getPrice();V2=UDB.getProd(2).getPrice();V3=UDB.getProd(3).getPrice();
        V4=UDB.getProd(4).getPrice();V5=UDB.getProd(5).getPrice();V6=UDB.getProd(6).getPrice();
        usu=UDB.getUsser(usuario1).getId();
        i=0;
        if(UDB.getFavs(usu,1).getId()>0){
            datos[i].Editlista(R.drawable.phoca_697,P1,V1,I1);
            data.add(i,datos[i]);
            i++;
            C[j]=0;
            j++;
        }

        if(UDB.getFavs(usu,2).getId()>0){
            datos[i].Editlista(R.drawable.cama_erotico,P2,V2,I2);
            data.add(i,datos[i]);
            i++;
            C[j]=1;
            j++;
        }

        if(UDB.getFavs(usu,3).getId()>0){
            datos[i].Editlista(R.drawable.choco_arequipe,P3,V3,I3);
            data.add(i,datos[i]);
            i++;
            C[j]=2;
            j++;
        }

        if(UDB.getFavs(usu,4).getId()>0){
            datos[i].Editlista(R.drawable.chocolate,P4,V4,I4);
            data.add(i,datos[i]);
            i++;
            C[j]=3;
            j++;
        }

        if(UDB.getFavs(usu,5).getId()>0){
            datos[i].Editlista(R.drawable.chocofresa,P5,V5,I5);
            data.add(i,datos[i]);
            i++;
            C[j]=4;
            j++;
        }

        if(UDB.getFavs(usu,6).getId()>0){
            datos[i].Editlista(R.drawable.bizcocho_tradicional,P6,V6,I6);
            data.add(i,datos[i]);
            i++;
            C[j]=5;
            j++;
        }

        Log.d("ADebugTag", "c1: " + C[0]);
        Log.d("ADebugTag", "c2: " + C[1]);
        Log.d("ADebugTag", "c3: " + C[2]);
        Log.d("ADebugTag", "c4: " + C[3]);
        Log.d("ADebugTag", "c5: " + C[4]);
        Log.d("ADebugTag", "c6: " + C[5]);


        adapterData = new Adapter(this.getContext(),datos);
        lst = (ListView) view.findViewById(lstf);
        lst.setAdapter(adapterData);



        //aceptable

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getContext(),showActivity.class);// crea un nuevo intent
                intent.putExtra("kPos",C[i]);
                startActivity(intent);
            }
        });

       

        return view;

    }

    class Adapter extends ArrayAdapter<Lista_entrada> {
        public Adapter(Context context, Lista_entrada[] datos) {
            super(context,R.layout.listitem,datos);
        }
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            String flag="";
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem,null);
            TextView nombre = (TextView) item.findViewById(R.id.tBizco);
            nombre.setText(datos[position].getNombre());
            TextView price= (TextView) item.findViewById(R.id.tPrecio);
            if(datos[position].getPrecio()>0) {
                price.setText(" $" + Integer.toString(datos[position].getPrecio()));
            }
            else{
                price.setText("");
            }
           // price.setText(Integer.toString(datos[position].getPrecio()));
            TextView info= (TextView) item.findViewById(R.id.tInfo);
            info.setText(datos[position].getInfo());
            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return (item);
        }
    }

}