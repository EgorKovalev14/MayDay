package ru.timcock.mayday.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import ru.timcock.mayday.R;

public class TagAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;

    public TagAdapter(Context context, ArrayList<String> list) {
        super(context, R.layout.tag_adapter_item, list);
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tag_adapter_item, parent, false);
        }

        String tag = list.get(position);

        TextView tagName = convertView.findViewById(R.id.tagName);
        tagName.setText(tag.toString());

        return convertView;
    }
}
