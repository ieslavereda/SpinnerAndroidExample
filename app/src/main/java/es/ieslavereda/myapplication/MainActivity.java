package es.ieslavereda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Spinner simpleSpinner;
    private TextView descripcion;
    private ImageView icon;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleSpinner = findViewById(R.id.simple_spinner);
        spinner = findViewById(R.id.custom_spinner);
        descripcion = findViewById(R.id.description);
        icon = findViewById(R.id.icon);
        image = findViewById(R.id.image);

        simpleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Sexo.values()));
        spinner.setAdapter(new CustomArrayAdapter<>(this, R.layout.custom_spinner_item, Sexo.values()));

        simpleSpinner.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(this);

    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        descripcion.setText(((Listable)adapterView.getSelectedItem()).getDescription());
        icon.setImageResource(((Listable)adapterView.getSelectedItem()).getDrawableSimbol());
        image.setImageResource(((Listable)adapterView.getSelectedItem()).getDrawableImage());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}