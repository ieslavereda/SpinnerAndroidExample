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
import java.util.List;

public class CustomArrayAdapter<T extends Listable> extends ArrayAdapter<T> {

    private int resource;

    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull List<T> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }
    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
        this(context, resource, new ArrayList<>(List.of(objects)));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(resource,parent,false);

        T item = getItem(position);

        TextView name = listItem.findViewById(R.id.text);
        ImageView image = listItem.findViewById(R.id.imageView);

        name.setText(item.getDescription());
        image.setImageResource(item.getDrawableSimbol());

        return listItem;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(resource,parent,false);

        T item = getItem(position);

        TextView name = listItem.findViewById(R.id.text);
        ImageView image = listItem.findViewById(R.id.imageView);

        name.setText(item.getDescription());
        image.setImageResource(item.getDrawableImage());

        return listItem;
    }
}
