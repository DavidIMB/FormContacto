package com.davidmorales.formcontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detalle_contacto extends AppCompatActivity {

    String Nombre, Fecha, Telefono, Email, Descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        Nombre = parametros.getString("Nombre");
        Fecha = "Fecha Nacimiento: "+parametros.getString("Fecha");
        Telefono = "Tel. "+parametros.getString("Telefono");
        Email = "Email: "+parametros.getString("Email");
        Descripcion = "Descripción: "+parametros.getString("Descripcion");

        TextView tvNombreconf = (TextView) findViewById(R.id.tvNombreconf);
        TextView tvFechaconf = (TextView) findViewById(R.id.tvFechaconf);
        TextView tvTelefonoconf = (TextView) findViewById(R.id.tvTelefonoconf);
        TextView tvEmailconf = (TextView) findViewById(R.id.tvEmailconf);
        TextView tvDescripcionconf = (TextView) findViewById(R.id.tvDescripcionconf);

        tvNombreconf.setText(Nombre);
        tvFechaconf.setText(Fecha);
        tvTelefonoconf.setText(Telefono);
        tvEmailconf.setText(Email);
        tvDescripcionconf.setText(Descripcion);

        ButtonActionEditar();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void ButtonActionEditar(){
        Button miBotonEditar = (Button) findViewById(R.id.BotonEditar);
        miBotonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
