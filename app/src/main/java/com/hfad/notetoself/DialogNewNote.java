package com.hfad.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogNewNote extends DialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        TextView tvNewTitle = dialogView.findViewById(R.id.etNewTitle);
        TextView tvNewContents = dialogView.findViewById(R.id.etNewContents);
        Spinner spnStatuses = dialogView.findViewById(R.id.spnStatuses);
        Button btnCancel = dialogView.findViewById(R.id.btnCancel);
        Button btnOkay = dialogView.findViewById(R.id.btnOkay);

        btnCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dismiss();
            }
        });

        btnOkay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String newTitle;
                String newContents;
                String newStatus;

                newTitle = tvNewTitle.getText().toString();
                newContents = tvNewContents.getText().toString();
                newStatus = spnStatuses.getSelectedItem().toString();

                Database.addNote(newStatus, newTitle, newContents);
                dismiss();
            }
        });

        builder.setView(dialogView);

        return builder.create();
    }

}
