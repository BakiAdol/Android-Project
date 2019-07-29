package com.example.abdullahil.assemblyproblemsandsolution;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Problems extends AppCompatActivity {

    public String[] probs;
    public String[] solvs;
    public String startCode, endCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);

        startCode = getResources().getString(R.string.start_code);
        endCode = getResources().getString(R.string.end_code);

        probs = getResources().getStringArray(R.array.problems_name_list);
        solvs = getResources().getStringArray(R.array.solve_details);

        ListView listView = findViewById(R.id.problem_Name_show);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Problems.this, Solution.class);
                intent.putExtra("probName", probs[i]);
                intent.putExtra("detSolv",startCode + solvs[i] + endCode);
                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return probs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.custom_layout, null);
            TextView textView = view.findViewById(R.id.problem_name_view);
            textView.setText(probs[position]);
            TextView numb = view.findViewById(R.id.probNumber);
            numb.setText(""+(position+1));
            return view;
        }
    }

}
