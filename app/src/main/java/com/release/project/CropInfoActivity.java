package com.release.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CropInfoActivity extends AppCompatActivity {

    private ImageView rice  , wheat , bajra , maze,BackChal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_info);



        rice = findViewById(R.id.rice);
        wheat = findViewById(R.id.wheat);
        bajra = findViewById(R.id.bajra);
        maze = findViewById(R.id.maze);
        BackChal=findViewById(R.id.BackChal);
        BackChal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CropInfoActivity.this,InfoWebView.class).putExtra("url","https://www.britannica.com/plant/rice"));
            }
        });
        wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CropInfoActivity.this,InfoWebView.class).putExtra("url","https://www.britannica.com/plant/wheat"));

            }
        });
        bajra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CropInfoActivity.this,InfoWebView.class).putExtra("url","https://www.agrifarming.in/bajra-cultivation"));

            }
        });
        maze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CropInfoActivity.this,InfoWebView.class).putExtra("url","https://harvesttotable.com/how_to_grow_sweet_corn/"));

            }
        });

    }
}


//http://ricepedia.org/rice-as-a-plant

//https://www.britannica.com/plant/wheat

//https://harvesttotable.com/how_to_grow_sweet_corn/
//https://www.agrifarming.in/bajra-cultivation