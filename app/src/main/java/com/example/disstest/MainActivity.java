package com.example.disstest;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DissDialog.DissDialogListener {

    private List<CardData> dataList = new ArrayList<>();
    private MemberAdapter memberAdapter;
    private final int space = 20;

    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);

        memberAdapter = new MemberAdapter(this,dataList);
        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(memberAdapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(space));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
//                Toast.makeText(this,"Click",Toast.LENGTH_SHORT).show();
                openDialog();
                break;
        }
    }

    public void openDialog(){
        DissDialog dissDialog = new DissDialog();
        dissDialog.show(getSupportFragmentManager(),"Diss Dialog");
    }


    @Override
    public void applyTexts(String title, String content) {

        Calendar calendar = Calendar.getInstance();
        String dateFormat = "yyyy年MM月dd日";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String today = simpleDateFormat.format(calendar.getTime());
        String date = today.substring(0,5);
        if(today.substring(5,6).equals("0")){
            date = date.concat(today.substring(6,7));
        }else{
            date = date.concat(today.substring(5,7));
        }
        date = date.concat("月");
        if(today.substring(8,9).equals("0")){
            date = date.concat(today.substring(9,10));
        }else{
            date = date.concat(today.substring(8,10));
        }
        date = date.concat("日");

        CardData cardData = new CardData(title,content, date,"NAME");
        dataList.add(cardData);
        memberAdapter.notifyDataSetChanged();
//        Toast.makeText(this,"SIZE:" + dataList.size(), Toast.LENGTH_LONG).show();
    }
}
