package com.example.abdullahil.assemblyproblemsandsolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Solution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        getSupportActionBar().setElevation(0);

        TextView title = findViewById(R.id.title_name);
        TextView detail = findViewById(R.id.details_solve_show);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            title.setText(bundle.getString("probName"));
            detail.setText(bundle.getString("detSolv"));
        }
    }
}
