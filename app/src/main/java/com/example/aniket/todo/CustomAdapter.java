package com.example.aniket.todo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(@NonNull Context context, String[] notes) {
        super(context, R.layout.notes_layout  ,notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater myLayout=LayoutInflater.from(getContext());

        View customView=myLayout.inflate(R.layout.notes_layout,parent,false);

        String note=getItem(position);

        TextView txt=(TextView)customView.findViewById(R.id.display_text);

        ImageView imga=(ImageView)customView.findViewById(R.id.my_image);

        txt.setText(note);
        imga.setImageResource(R.drawable.ani);

        return customView;

    }
}

