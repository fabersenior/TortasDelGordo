package com.faberospina.tortasdelgordo;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    String usuario1,correo1,jp,MiPass;
    private final static String usuario="usuario";
    private final static String password="password";
    private final static String correo="correo";
    private final static String jumplis="no";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    TextView userp,passp,TextEMAIL;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        prefs = getActivity().getSharedPreferences("com.sp.main_preferences", Context.MODE_PRIVATE);

        //prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        //prefs = getApplicationContext().getSharedPreferences("com.sp.main_preferences", Context.MODE_PRIVATE);
        //Recupera los valores de usuario y contraseña guardados en la actividad de SignUp
/*        usuario1= prefs.getString(usuario,"");
        correo1= prefs.getString(correo,"");
        jp= prefs.getString(jumplis,"");*/


        // String  data = prefs.getString("name", "08:00") ;

        correo1 = prefs.getString("kEmail","07");
        usuario1 = prefs.getString("kName","07");
        MiPass = prefs.getString("kPass","07");

        userp = (TextView) view.findViewById(R.id.tUser);
        passp = (TextView) view.findViewById(R.id.tPass);
        TextEMAIL = (TextView) view.findViewById(R.id.tEmail);
        userp.setText(usuario1);
        passp.setText(MiPass);
        TextEMAIL.setText(correo1);

        return view;
    }
}
