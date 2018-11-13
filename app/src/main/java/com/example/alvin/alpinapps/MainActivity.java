package com.example.alvin.alpinapps;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] pendaftaran = {"--PILIH--", "MAHASISWA", "DOSEN"};
    Dialog myDialog;
    EditText editNama, editAlamat;
    Spinner edit_jk;
    Button btnsubmit, btnreset;
    TextView namainput, jkinput, alamatinput;
    RelativeLayout RL;

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
        myDialog = new Dialog(this);
        namainput = (TextView) findViewById(R.id.nama_input);
        jkinput = (TextView) findViewById(R.id.jk_input);
        alamatinput = (TextView) findViewById(R.id.alamat_input);
        RL = (RelativeLayout)findViewById(R.id.input_show);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == 1) {
            myDialog.setContentView(R.layout.pop1);
            RL.setVisibility(View.INVISIBLE);
            editNama = (EditText) myDialog.findViewById(R.id.et_nama);
            editAlamat = (EditText) myDialog.findViewById(R.id.et_alamat);
            edit_jk = (Spinner) myDialog.findViewById(R.id.sp_jk);
            btnsubmit = (Button) myDialog.findViewById(R.id.btn_Submit);
            btnreset = (Button) myDialog.findViewById(R.id.btn_Reset);
            btnsubmit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String nama = editNama.getText().toString();
                    String alamat = editAlamat.getText().toString();
                    String jk = edit_jk.getSelectedItem().toString();
                    namainput.setText(nama);
                    alamatinput.setText(alamat);
                    jkinput.setText(jk);
                    RL.setVisibility(View.VISIBLE);
                    myDialog.dismiss();
                }
            });

            btnreset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editNama.setText("");
                    editAlamat.setText("");
                    editNama.requestFocus();
                }
            });

            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
        }
        if(position == 2) {
            myDialog.setContentView(R.layout.pop2);
            RL.setVisibility(View.INVISIBLE);
            editNama = (EditText) myDialog.findViewById(R.id.et_nama1);
            editAlamat = (EditText) myDialog.findViewById(R.id.et_alamat1);
            edit_jk = (Spinner) myDialog.findViewById(R.id.sp_jk1);
            btnsubmit = (Button) myDialog.findViewById(R.id.btn_Submit1);
            btnreset = (Button) myDialog.findViewById(R.id.btn_Reset1);
            btnsubmit.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String nama = editNama.getText().toString();
                    String alamat = editAlamat.getText().toString();
                    String jk = edit_jk.getSelectedItem().toString();
                    namainput.setText(nama);
                    alamatinput.setText(alamat);
                    jkinput.setText(jk);
                    RL.setVisibility(View.VISIBLE);
                    myDialog.dismiss();
                }
            });

            btnreset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editNama.setText("");
                    editAlamat.setText("");
                    editNama.requestFocus();
                }
            });

            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"Silahkan Pilih Pendaftaran", Toast.LENGTH_LONG).show();
    }
}
