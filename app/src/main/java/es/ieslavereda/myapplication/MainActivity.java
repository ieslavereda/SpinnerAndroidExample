package es.ieslavereda.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Spinner simpleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleSpinner = findViewById(R.id.simple_spinner);
        spinner = findViewById(R.id.custom_spinner);

        simpleSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Sexo.values()));

        spinner.setAdapter(new CustomArrayAdapter<Sexo>(this,android.R.layout.simple_spinner_item,Sexo.values()));

    }

    public enum Sexo implements Listable{
        HOMBRE,MUJER;

        @Override
        public String getText() {
            return this.name();
        }

        @Override
        public int getDrawableSimbol() {
            return (Sexo.valueOf(this.name()).equals(HOMBRE))?R.drawable.s_mas:R.drawable.s_fem;
        }

        @Override
        public int getDrawableImage() {
            return (Sexo.valueOf(this.name()).equals(HOMBRE))?R.drawable.i_mas:R.drawable.i_fem;
        }
    }
}