package com.example.disstest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder>{

    private Context context;
    private List<CardData> dataList;

    MemberAdapter(Context context, List<CardData> data){
        this.context = context;
        this.dataList = data;
    }

    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final CardData cardData = dataList.get(position);
        viewHolder.name.setText(cardData.getName());
        viewHolder.title.setText(cardData.getTitle());
        viewHolder.content.setText(cardData.getContent());
        viewHolder.time.setText(cardData.getTime());
        viewHolder.reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"Click",Toast.LENGTH_LONG).show();
                Intent reply_activity = new Intent(context,ReplyActivity.class);
                reply_activity.putExtra("CardData",cardData);
                context.startActivity(reply_activity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,name,content,time;
        ImageView reply;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.card_title);
            name = itemView.findViewById(R.id.card_name);
            content = itemView.findViewById(R.id.card_content);
            time = itemView.findViewById(R.id.card_time);
            reply = itemView.findViewById(R.id.card_reply);
        }
    }

}
