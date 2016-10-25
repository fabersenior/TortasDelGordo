package com.faberospina.tortasdelgordo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Promo_Activity extends NavegationActivity {

    final String[] nombres=new String[]{"whiscake","Bizcocho Tradicional","Chocolate"};
    ListView lstnombres;
    String P1,P2,P3,P4,P5,P6,I1,I2,I3,I4,I5,I6;
    int V1,V2,V3,V4,V5,V6;
    final ContactosSQLHelper UDB = new ContactosSQLHelper(this,"TortasBD",null,1);

    private Lista_entrada[] datos= new Lista_entrada[]{
            new Lista_entrada(R.drawable.bizcocho_tradicional,"Bizcocho Tradicional",50000,"Rico Bizcocho Tradicional a 2x1"),
            new Lista_entrada(R.drawable.maria_luisa_arequipe,"Maria Luisa de Arequipe",30000,"Compra una Maria Luisa de Arequipe con 20% de Descuento"),
            new Lista_entrada(R.drawable.big_chocolate,"Chocolate",67000,"La mejor torta par compartir ahora mas economica"),
            new Lista_entrada(R.drawable.phoca_697,"Erotico Senos",80000,"LLeva esta espectacular diseño erotico para sorprender a tus familiares, mas economico que antes"),
            new Lista_entrada(R.drawable.cama_erotico,"Cama Erotica",75000,"La mejor posicion para practicar en casa con su pareja ahora en una torta, 50% de descuento en septiembre")

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.list_promociones, contentFrameLayout);

        P1=UDB.getProd(1).getNamep();I1=UDB.getProd(1).getInfo();
        P2=UDB.getProd(2).getNamep();I2=UDB.getProd(2).getInfo();
        P3=UDB.getProd(3).getNamep();I3=UDB.getProd(3).getInfo();
        P4=UDB.getProd(4).getNamep();I4=UDB.getProd(4).getInfo();
        P5=UDB.getProd(5).getNamep();I5=UDB.getProd(5).getInfo();
        P6=UDB.getProd(6).getNamep();I6=UDB.getProd(6).getInfo();
        V1=UDB.getProd(1).getPrice();V2=UDB.getProd(2).getPrice();V3=UDB.getProd(3).getPrice();
        V4=UDB.getProd(4).getPrice();V5=UDB.getProd(5).getPrice();V6=UDB.getProd(6).getPrice();

        datos[0].Editlista(P1,V1,I1);
        datos[1].Editlista(P2,V2,I2);
        datos[2].Editlista(P3,V3,I3);
        datos[3].Editlista(P4,V4,I4);
        datos[4].Editlista(P5,V5,I5);
//        datos[5].Editlista(P6,V6,I6);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,nombres);
        Adapter adapter= new Adapter(getApplicationContext(),datos);
        lstnombres = (ListView) findViewById(R.id.lst);

        lstnombres.setAdapter(adapter);

        lstnombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),showActivity.class);// crea un nuevo intent
                intent.putExtra("kPos",i); //tname.getText().toString()
                startActivity(intent);
            }
        });
    }

    class Adapter extends ArrayAdapter<Lista_entrada> {

        public Adapter(Context context, Lista_entrada[] datos) {
            super(context,R.layout.listitem,datos);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

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
            //price.setText(Integer.toString(datos[position].getPrecio()));

            TextView info= (TextView) item.findViewById(R.id.tInfo);
            info.setText(datos[position].getInfo());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return (item);
        }


    }
}


