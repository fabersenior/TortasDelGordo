package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
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
    private ViewPager mViewPagerp;

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

        PagerAdapterPerfil adaptador = new PagerAdapterPerfil(getSupportFragmentManager());
        mViewPagerp = (ViewPager) findViewById(R.id.pagerP);
        mViewPagerp.setAdapter(adaptador);
/*
        tUser.setText(MiUser);
        tMail.setText(MiEmail);
        tPass.setText(MiPass);*/

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPagerp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Mi perfil").setTabListener(tabListener);
        actionBar.addTab (tab);
        tab = actionBar.newTab().setText("Favoritos").setTabListener(tabListener);
        actionBar.addTab (tab);

        mViewPagerp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }
        });




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

    public class PagerAdapterPerfil extends FragmentPagerAdapter {
        public PagerAdapterPerfil(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new PerfilFragment();
                case 1: return new FavoritosFragment();
                default: return null;
            }
        }
        @Override
        public int getCount() {
            return 2;
        }
    }
}
