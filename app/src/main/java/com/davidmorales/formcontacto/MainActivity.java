package com.davidmorales.formcontacto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    String snombre = null, Fecha = null, stelefono = null, semail = null, sdescripcion = null;
    TextInputEditText nombre, date, telefono, email, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonAction();
    }

    public void ButtonAction(){
        Button miBoton = (Button) findViewById(R.id.BotonSiguiente);
        nombre = (TextInputEditText) findViewById(R.id.tiNombre);
        datePicker = (DatePicker) findViewById(R.id.DPfecha);
        telefono = (TextInputEditText) findViewById(R.id.tiTelefono);
        email = (TextInputEditText) findViewById(R.id.tiEmail);
        descripcion = (TextInputEditText) findViewById(R.id.tiDesc);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snombre = nombre.getText().toString();
                Fecha  = Integer.toString(datePicker.getDayOfMonth())+"/"+Integer.toString((datePicker.getMonth()+1))+"/"+Integer.toString(datePicker.getYear());
                stelefono = telefono.getText().toString();
                semail = email.getText().toString();
                sdescripcion = descripcion.getText().toString();
                Intent intent = new Intent(MainActivity.this, detalle_contacto.class);
                intent.putExtra("Nombre", snombre);
                intent.putExtra("Fecha",Fecha);
                intent.putExtra("Telefono",stelefono);
                intent.putExtra("Email",semail);
                intent.putExtra("Descripcion",sdescripcion);
                startActivity(intent);
            }
        });
    }
}
