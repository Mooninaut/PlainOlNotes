package com.example.clement.plainolnotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Clement on 8/3/2017.
 */

public class NotesCursorAdapter extends CursorAdapter {
    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(
            R.layout.note_list_item, parent, false
        );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String noteText = cursor.getString(
            cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT)
        );
        if (noteText.contains("\n")) {
            noteText = noteText.replaceFirst("\n.*", " ...");
        }
        TextView tv = (TextView) view.findViewById(R.id.tvNote);
        tv.setText(noteText);
    }
}
