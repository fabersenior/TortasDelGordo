package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

public class CatalogoActivity extends NavegationActivity {

    private ViewPager mViewPager;
    String MiEmail,MiUser,MiPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_catalogo);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_catalogo, contentFrameLayout);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //rep();

        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab= actionBar.newTab().setText("Tradicionales").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Refrigeradas").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Muñecos 3D").setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
               getSupportActionBar().setSelectedNavigationItem(position);
            }
        }  );


    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new TradicionalFragment();
                case 1: return new RefrigeradasFragment();
                case 2: return new Print3dFragment();

                default: return null;

            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (id){
            case R.id.miperfil:

/*                SupermanFragment fragment = new SupermanFragment();
                ft.replace(android.R.id.content, fragment).commit();*/

               // Toast.makeText(getApplicationContext(),"Opcion Invalida",Toast.LENGTH_SHORT);
                Intent intent = new Intent(this,PerfilActivity.class);// crea un nuevo intent
                intent.putExtra("kUsuario",MiUser); //tname.getText().toString()
                intent.putExtra("kPassword",MiPass);
                intent.putExtra("kMail2",MiUser);
                //startActivityForResult(intent,1234);
                startActivity(intent);
                break;

            case R.id.publicidad :
                Intent intent1= new Intent(this,Main1Activity.class);
                intent1.putExtra("kUsuario",MiUser); //tname.getText().toString()
                intent1.putExtra("kPassword",MiPass);
                intent1.putExtra("kMail2",MiUser);
                startActivity(intent1);
                break;

            case R.id.catalogo :

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


