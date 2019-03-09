package com.example.disstest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ReplyActivity extends AppCompatActivity implements View.OnClickListener ,PenDialog.PenDialogListener{


    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        floatingActionButton = findViewById(R.id.fab_pen);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_pen:
//                Toast.makeText(this,"Click",Toast.LENGTH_SHORT).show();
                openDialog();
                break;
        }
    }

    public void openDialog(){
        PenDialog penDialog = new PenDialog();
        penDialog.show(getSupportFragmentManager(),"Pen Dialog");
    }

    @Override
    public void applyTexts(String content) {
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
}
