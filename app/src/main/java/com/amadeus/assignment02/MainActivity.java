package com.amadeus.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre ;
    DatePicker dpFechaNac;
    EditText edtTelefono;
    EditText edtEmail;
    EditText edtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre          = (EditText) findViewById(R.id.edtNombre);
        edtTelefono        = (EditText) findViewById(R.id.edtTelefono);
        edtEmail           = (EditText) findViewById(R.id.edtEmail);
        edtDescripcion     = (EditText) findViewById(R.id.edtDescripcion);
        dpFechaNac         = (DatePicker) findViewById(R.id.dpFechaNac);

        Button btnSiguiente  = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnviarDatos();
            }
        });

        Bundle datos = getIntent().getExtras();

        if (datos != null){

            String nombre       =   datos.getString(getResources().getString(R.string.extra_nombre));
            int day             =   datos.getInt(getResources().getString(R.string.extra_day));
            int month           =   datos.getInt(getResources().getString(R.string.extra_month));
            int year            =   datos.getInt(getResources().getString(R.string.extra_year));
            String telefono     =   datos.getString(getResources().getString(R.string.extra_telefono));
            String email        =   datos.getString(getResources().getString(R.string.extra_email));
            String descripcion  =   datos.getString(getResources().getString(R.string.extra_descripcion));

            dpFechaNac.updateDate(year,month,day);
            edtNombre .setText(nombre);
            edtTelefono.setText(telefono);
            edtEmail.setText(email);
            edtDescripcion.setText(descripcion);
        }

    }

    public void EnviarDatos(){


        Intent intent   = new Intent(this, ConfirmActivity.class);
        intent.putExtra(getResources().getString(R.string.extra_nombre), edtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_day), dpFechaNac.getDayOfMonth());
        intent.putExtra(getResources().getString(R.string.extra_month), dpFechaNac.getMonth());
        intent.putExtra(getResources().getString(R.string.extra_year), dpFechaNac.getYear());
        intent.putExtra(getResources().getString(R.string.extra_telefono),  edtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_email), edtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.extra_descripcion), edtDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }


} 