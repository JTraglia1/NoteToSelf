package com.hfad.notetoself;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>
{
    private ArrayList<Note> noteList;
    private FragmentManager fragmentManager;

    public NoteAdapter(FragmentManager man, ArrayList <Note> n)
    {
        fragmentManager = man;
        noteList = n;
    }

    //Creates an empty view of a single row - inflate a vacation_row_item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row_item, parent, false);

        return new MyViewHolder(view);
    }

    //Total in the list
    @Override
    public int getItemCount()
    {
        return noteList.size();
    }

    //Binds data to an empty row view
    //position - index in the list that you want to show
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Note na = noteList.get(position);
        holder.setData(na, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        //handles to the view inside one row
        private TextView tvNoteStatus;
        private TextView tvNoteTitle;
        private TextView tvNoteContents;
        private ImageView imvDelete;

        private int currentPositionInList = -1;
        private Note currentNote = null;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tvNoteStatus = itemView.findViewById(R.id.tvNoteStatus);
            tvNoteTitle = itemView.findViewById(R.id.tvNoteTitle);
            tvNoteContents = itemView.findViewById(R.id.tvNoteContents);
            imvDelete = itemView.findViewById(R.id.imvDelete);

            imvDelete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    noteList.remove(currentPositionInList);
                    notifyItemRemoved(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, noteList.size());
                }
            });

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        public void setData(Note note, int position)
        {
            tvNoteStatus.setText(note.getNoteStatus());
            tvNoteTitle.setText(note.getNoteTitle());
            tvNoteContents.setText(note.getNoteContents());
            currentPositionInList = position;
            currentNote = note;
        }

        @Override
        public void onClick(View view)
        {
            DialogShowNote dialog = new DialogShowNote(currentNote);
            dialog.show(fragmentManager, "");
        }

    }

}
