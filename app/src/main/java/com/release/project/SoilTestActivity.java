package com.release.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.ThreadLocalRandom;

public class SoilTestActivity extends AppCompatActivity {
    private ImageView BackChal;
    private TextView nitrogen, phosphorus, potasium, pH, crop, fertilizer;
    private Button GenerateReport;
    private LinearLayout reportLay;
    private DatabaseReference reportRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test);

        BackChal = findViewById(R.id.BackChal);
        GenerateReport = findViewById(R.id.generatereport);
        reportLay = findViewById(R.id.reportLay);
        nitrogen = findViewById(R.id.nitro);
        phosphorus = findViewById(R.id.phosphorus);
        potasium = findViewById(R.id.potassium);
        pH = findViewById(R.id.pH);
        crop = findViewById(R.id.crop);
        fertilizer = findViewById(R.id.fertilizer);

        GenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
               getReport("ui"+String.valueOf(randomNum));
            }
        });
        BackChal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        reportRef = FirebaseDatabase.getInstance().getReference().child("soilTest");

    }

    private void getReport(String id) {

        reportRef.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                    nitrogen.setText(snapshot.child("nitrogen").getValue().toString());
                    phosphorus.setText(snapshot.child("phosphorus").getValue().toString());
                    pH.setText(snapshot.child("pH").getValue().toString());
                    fertilizer.setText(snapshot.child("fertilizer").getValue().toString());
                    potasium.setText(snapshot.child("potassium").getValue().toString());
                    crop.setText(snapshot.child("crop").getValue().toString());
                    reportLay.setVisibility(View.VISIBLE);

                }
                else{
                    Toast.makeText(SoilTestActivity.this, "Try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SoilTestActivity.this, "Check Internet Connection!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}