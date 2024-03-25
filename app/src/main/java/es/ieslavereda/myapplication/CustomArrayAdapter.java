package es.ieslavereda.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArrayAdapter<T extends Listable> extends ArrayAdapter<T> {

    private List<T> objects;
    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, objects);
        this.objects = new ArrayList<>(Arrays.asList(objects));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.spinner,parent,false);

        T object = objects.get(position);

        ImageView image = listItem.findViewById(R.id.imageView);

        image.setImageResource(object.getDrawableSimbol());

        TextView name = listItem.findViewById(R.id.text);
        name.setText(object.getText());

        return listItem;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.spinner,parent,false);

        T object = objects.get(position);

        ImageView image = listItem.findViewById(R.id.imageView);

        image.setImageResource(object.getDrawableImage());

        TextView name = listItem.findViewById(R.id.text);
        name.setText(object.getText());

        return listItem;
    }
}
