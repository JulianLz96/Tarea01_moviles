package com.iteso.tarea1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.tarea1.utils.Alumno;

public class ActivityMain extends AppCompatActivity {

    private static final int radfem_ID = 0;

    AutoCompleteTextView libfav;
    Button save;
    EditText nombre;
    EditText telefono;
    Spinner escolaridad;
    CheckBox deporte;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button limpiar;

    public static String[] libros = {"Aventuras de Sherlock Holmes, Sherlock",
        "The Secret, Rhonda Byrne", "Cuentos variados, Hermanos Grimm",
        "El hombre invisble, H. G. Wells", "El caballero de la armadura oxidada, Robert Fisher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fill_componentes();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityMain.this,
                android.R.layout.simple_dropdown_item_1line, libros);
        libfav.setAdapter(adapter);

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                builder.setMessage("Desea limpiar el contenido?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                limpiar();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }

                        });
                builder.show();
            }
        });
/*
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.acitivty_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.activity_main_menu_save:
                radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                Alumno alumnos = new Alumno(nombre.getText().toString(),
                        telefono.getText().toString(), escolaridad.getSelectedItem().toString(),
                        radioButton.getText().toString(), libfav.getText().toString(), deporte.isChecked());
                Toast alu = Toast.makeText(ActivityMain.this,
                        alumnos.toString(),Toast.LENGTH_LONG );
                alu.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0,0);
                alu.show();
                limpiar();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    protected void limpiar(){
        nombre.getText().clear();
        telefono.getText().clear();
        escolaridad.setSelection(1);
        libfav.getText().clear();
        deporte.setChecked(true);
        ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
        escolaridad.setSelection(0);
    }

    protected void fill_componentes(){
        libfav = findViewById(R.id.auto_comp_text);
        save = findViewById(R.id.activity_main_menu_save);
        nombre = findViewById(R.id.edit_text_nombre);
        telefono = findViewById(R.id.edit_text_telefono);
        escolaridad = findViewById(R.id.spinner_escolaridad);
        deporte = findViewById(R.id.checkbox_deporte);
        radioGroup = findViewById(R.id.radio_group);
        limpiar = findViewById(R.id.limpiar);
    }
}
