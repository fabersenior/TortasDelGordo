package com.faberospina.tortasdelgordo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class showActivity extends AppCompatActivity {

    int pos;
    ImageView imageShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show);

        Bundle bundle= getIntent().getExtras();

        imageShow = (ImageView) findViewById(R.id.imageView);


        pos=bundle.getInt("kPos");

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
