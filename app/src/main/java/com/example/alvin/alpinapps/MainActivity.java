package com.example.alvin.alpinapps;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] pendaftaran = {"--PILIH--", "Mahasiswa", "Dosen"};
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView selection = findViewById(R.id.selection);
        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> tx = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pendaftaran);
        tx.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(tx);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myDialog = new Dialog(this);
        if(position == 1) {
            myDialog.setContentView(R.layout.pop1);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
        }
        if(position == 2) {
            myDialog.setContentView(R.layout.pop2);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"Silahkan Pilih Pendaftaran", Toast.LENGTH_LONG).show();
    }
}
