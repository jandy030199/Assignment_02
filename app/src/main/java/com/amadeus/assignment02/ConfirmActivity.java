package com.amadeus.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConfirmActivity extends AppCompatActivity {

    TextView tvMostrarNombre;
    TextView tvMostrarFecha;
    TextView tvMostrarTelefono;
    TextView tvMostrarEmail;
    TextView tvMostrarDescripcion;
    Button btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvMostrarNombre         =   (TextView) findViewById(R.id.tvMostrarNombre);
        tvMostrarFecha          =   (TextView) findViewById(R.id.tvMostrarFecha);
        tvMostrarTelefono       =   (TextView) findViewById(R.id.tvMostrarTelefono);
        tvMostrarEmail          =   (TextView) findViewById(R.id.tvMostrarEmail);
        tvMostrarDescripcion    =   (TextView) findViewById(R.id.tvMostrarDescripcion);
        btnEditar               =   (Button)   findViewById(R.id.btnEditar);

        Bundle datos        =  getIntent().getExtras();

        String nombreuser       =   datos.getString(getResources().getString(R.string.extra_nombre));
        int day             =   datos.getInt(getResources().getString(R.string.extra_day));
        int month           =   datos.getInt(getResources().getString(R.string.extra_month));
        int year            =   datos.getInt(getResources().getString(R.string.extra_year));
        String telefono     =   datos.getString(getResources().getString(R.string.extra_telefono));
        String email        =   datos.getString(getResources().getString(R.string.extra_email));
        String descripcion  =   datos.getString(getResources().getString(R.string.extra_descripcion));


        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date myDate = calendar.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = simpleDateFormat.format(myDate);

        tvMostrarNombre.setText(nombreuser);
        tvMostrarFecha.setText(dateString);
        tvMostrarTelefono.setText(telefono);
        tvMostrarEmail.setText(email);
        tvMostrarDescripcion.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra(getResources().getString(R.string.extra_nombre), tvMostrarNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.extra_day), datos.getInt(getResources().getString(R.string.extra_day)));
                intent.putExtra(getResources().getString(R.string.extra_month), datos.getInt(getResources().getString(R.string.extra_month)));
                intent.putExtra(getResources().getString(R.string.extra_year), datos.getInt(getResources().getString(R.string.extra_year)));
                intent.putExtra(getResources().getString(R.string.extra_telefono), tvMostrarTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.extra_email), tvMostrarEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.extra_descripcion), tvMostrarDescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });



    }


}