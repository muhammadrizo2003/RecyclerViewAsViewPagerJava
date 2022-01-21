package com.example.project9.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project9.R;
import com.example.project9.models.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public final Context context;
    private final ArrayList<Member> itemList;


    public CustomAdapter(Context context, ArrayList<Member> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = itemList.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView txt_name = holder.itemView.findViewById(R.id.txt_name);
            TextView txt_surname = holder.itemView.findViewById(R.id.txt_surname);

            txt_name.setText(member.getName());
            txt_surname.setText(member.getSurname());
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private static final class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public TextView txt_name, txt_surname;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            txt_name = view.findViewById(R.id.txt_name);
            txt_surname = view.findViewById(R.id.txt_surname);
        }
    }
}
