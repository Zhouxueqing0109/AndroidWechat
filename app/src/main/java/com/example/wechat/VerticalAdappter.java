package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalAdappter extends RecyclerView.Adapter<VerticalAdappter.verticalviewholder> {
    private List<String>list;
    private Context context;

    public VerticalAdappter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public verticalviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_demo,parent,false);
        return new verticalviewholder(view);
    }

    @Override
    public void onBindViewHolder(verticalviewholder holder, int position) {
        holder.tvContent.setText(list.get(position));
    }

    @Override
    public int getItemCount() {return list.size();}


    public class verticalviewholder extends RecyclerView.ViewHolder{
        TextView tvContent;

        public verticalviewholder(View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.content);
        }
    }
}

