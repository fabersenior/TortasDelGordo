package com.faberospina.tortasdelgordo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Promo_Activity extends NavegationActivity {

    final String[] nombres=new String[]{"whiscake","Bizcocho Tradicional","Chocolate"};
    ListView lstnombres;

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

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,nombres);
        Adapter adapter= new Adapter(getApplicationContext(),datos);
        lstnombres = (ListView) findViewById(R.id.lst);

        lstnombres.setAdapter(adapter);
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
            price.setText(Integer.toString(datos[position].getPrecio()));

            TextView info= (TextView) item.findViewById(R.id.tInfo);
            info.setText(datos[position].getInfo());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return (item);
        }
    }
}


