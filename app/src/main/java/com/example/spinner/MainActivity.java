package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener,AdapterView.OnItemSelectedListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.sspinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
        parent.getItemAtPosition(position);
        Button b = (Button) findViewById(R.id.button);
        TextView a = (TextView) findViewById(R.id.view);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                    startActivity(i);
                } else if (position == 1) {

                    Intent i1 = new Intent(Intent.ACTION_SENDTO, Uri.parse("+216 28235539"));
                    startActivity(i1);
                }
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"oui",Toast.LENGTH_SHORT).show();

    }
}