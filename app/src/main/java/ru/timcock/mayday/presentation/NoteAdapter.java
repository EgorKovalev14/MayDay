package ru.timcock.mayday.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import ru.timcock.mayday.R;

public class NoteAdapter extends ArrayAdapter<NoteItem> {

    ArrayList<NoteItem> list;
    Context context;

    public NoteAdapter(Context context, ArrayList<NoteItem> list) {
        super(context, R.layout.note_adapter_item, list);
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_adapter_item, parent, false);
        }

        NoteItem noteItem = list.get(position);

        TextView name = convertView.findViewById(R.id.textViewNoteName);
        name.setText(noteItem.getName());

        TextView date = convertView.findViewById(R.id.textViewNoteDate);
        date.setText(noteItem.getDate());

        ListView tagListView = convertView.findViewById(R.id.tagList);
        ArrayList<String> tags = noteItem.getTags();
        TagAdapter adapter = new TagAdapter(context, tags);
        tagListView.setAdapter(adapter);

        return convertView;
    }


}
