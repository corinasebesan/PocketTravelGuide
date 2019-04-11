package com.example.cory4.pockettravelguide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoursDialog extends AppCompatDialogFragment {
    private EditText editTextHours;

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater= getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.layout_dialog,null);

        // String array for alert dialog multi choice items

        String[] sights = new String[]{
                getString(R.string.primul),
                getString(R.string.aldoilea)
        };

        // Boolean array for initial selected items
        final boolean[] checkedSights = new boolean[]{
                false,
                false

        };

        // Convert the color array to list
        final List<String> sightsList = Arrays.asList(sights);

        builder.setView(view)
                .setTitle(getString(R.string.which_sights))
                .setMultiChoiceItems(sights, checkedSights, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        // Update the current focused item's checked status
                        checkedSights[which] = isChecked;

                        // Get the current focused item
                        String currentItem = sightsList.get(which);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }


                });
        editTextHours=view.findViewById(R.id.edit_hours);
        return builder.create();
    }

    public interface ExampleDialogListener{

    }
}
