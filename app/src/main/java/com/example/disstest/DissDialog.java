package com.example.disstest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DissDialog extends AppCompatDialogFragment {

    private EditText et_title;
    private EditText et_content;
    private DissDialogListener dissDialogListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            dissDialogListener = (DissDialogListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement DissDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout,null);
        builder.setView(view)
                .setTitle("發佈新主題")
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = et_title.getText().toString();
                        String content = et_content.getText().toString();
                        dissDialogListener.applyTexts(title,content);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        et_title = view.findViewById(R.id.et_title);
        et_content = view.findViewById(R.id.et_content);
        return builder.create();
    }

    public interface DissDialogListener{
        void applyTexts(String title, String content);
    }
}
