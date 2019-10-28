package com.example.scrolling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VHolder> {

    ArrayList <String> data;
    Context context;


    public Adapter(ArrayList<String> arrayList, Context context) {
        this.data = arrayList;
        this.context = context;
    }



    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position)
    {
      holder.textView.setText(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class VHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public VHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textItem);
        }
    }
}
