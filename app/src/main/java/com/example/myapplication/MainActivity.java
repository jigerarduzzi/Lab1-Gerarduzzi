package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etn,etp;
    //hay que referenciar los elementos para el spinner
    Spinner comboMes;
    Spinner comboAnio;
    EditText mail,clave, claveR, numTarjeta, fechaVencimiento; //obligatorios, falta CCV y tipo tarj
    EditText CCV;
    Switch switchCarga;
    SeekBar seekBarCarga;
    CheckBox terminos;
    boolean aceptar=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numTarjeta=(EditText) findViewById(R.id.editTextCard);
        mail = (EditText) findViewById(R.id.editTextEmail);
        clave = (EditText) findViewById(R.id.editTextPass);
        claveR = (EditText) findViewById(R.id.editTextRepeatPass);
        CCV= (EditText) findViewById(R.id.editTextCCV);
        switchCarga = findViewById(R.id.switchCarga);
        seekBarCarga = findViewById(R.id.seekBarCarga);
        terminos = findViewById(R.id.checkBox);
        CCV.setEnabled(false);


        comboMes=(Spinner) findViewById(R.id.spinnerMeses);
        comboAnio= (Spinner) findViewById(R.id.spinnerAnios);
        //al spinner hay que pasarle el contexto, el id del layout y el array que tiene los datos para mostrar
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.comboMeses,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this, R.array.comboAnio,android.R.layout.simple_spinner_item);

        comboMes.setAdapter(adapter);
        comboAnio.setAdapter(adapter2);
    }


    public void registrar(View view){
        String mail = this.mail.getText().toString();
        String clave = this.clave.getText().toString();
        String tarjeta = this.numTarjeta.getText().toString();
        String claveR = this.claveR.getText().toString();
        if(mail.length()==0){
            Toast.makeText(this, "Debes ingresar una cuenta de mail", Toast.LENGTH_LONG).show();
        }
        if(clave.length()==0){
            Toast.makeText(this, "No has ingresado tu clave", Toast.LENGTH_LONG).show();
        }
        if(tarjeta.length()==0){
            Toast.makeText(this, "No has ingresado tu tarjeta", Toast.LENGTH_LONG).show();
        }
      //  if(clave.equals(claveR)){
      //  }Toast.makeText(this, "Las claves no son iguales", Toast.LENGTH_LONG).show();
        if(!aceptar){
            Toast.makeText(this, "Debe aceptar los terminos para continuar", Toast.LENGTH_LONG).show();
        }
    }

    public void clickSwitch(View view) {
        if(view.getId()==R.id.switchCarga){
            if(switchCarga.isChecked()){
                seekBarCarga.setVisibility(View.VISIBLE);
            }else{
                seekBarCarga.setVisibility(View.GONE);
            }
        }
    }

    public void validarTerminos(View view) {
        if(view.getId()==R.id.checkBox){
            if(terminos.isChecked()){
                aceptar=true;
            }else{
                aceptar=false;
            }
        }
    }
}