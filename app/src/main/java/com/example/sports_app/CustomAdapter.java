package com.example.sports_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//this Class is an adapter Class
public class CustomAdapter
        extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {

    public List<Sport> sportList;

    public   ItemClickListener clickListener;
    public void setClickListener(View.OnClickListener myListener){

    }

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflating the Layout for each item in the recyclerView

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout,parent,false);

        return new SportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        //called for each item in the list and is responsible for
        //bonding the data from the Sport Object to the Views
        //within the 'SportViewHolder'

        Sport sport = sportList.get(position);
        holder.textView.setText(sport.sportName);
        holder.imageView.setImageResource(sport.sportImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener != null){
                    clickListener.onCLick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }



    public  class SportsViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Holds the reference to the views within the item layout

        TextView textView;
        ImageView imageView;


        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onCLick(getAdapterPosition());
            }
        }
    }
}
