package com.example.activity21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Listener extends RecyclerView.Adapter<Listener.MyViewHolder> {
    ArrayList<Friends> friendsList;
    MyClickListener myClickListener;

    public Listener(ArrayList<Friends> friendsList, MyClickListener myClickListener){
        this.friendsList = friendsList;
        this.myClickListener = myClickListener;
    }

    @NonNull
    @Override
    public Listener.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view, myClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Listener.MyViewHolder holder, int position) {
        holder.Name.setText(friendsList.get(position).getName());
        holder.Hobby.setText(friendsList.get(position).getHobby());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name, Hobby;
        MyClickListener myClickListener;

        public MyViewHolder(View view, MyClickListener myClickListener){
            super(view);
            Name = view.findViewById(R.id.name);
            Hobby = view.findViewById(R.id.hobby);
            view.setOnClickListener(this);
            this.myClickListener = myClickListener;
        }

        @Override
        public void onClick(View v) {
            myClickListener.onClick(getAdapterPosition());
        }
    }

    public interface MyClickListener {
        void onClick(int position);
    }
}
