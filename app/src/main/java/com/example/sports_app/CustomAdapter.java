package com.example.sports_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//this Class is an adapter Class
public class CustomAdapter
        extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {

    public List<Sport> sportList;

   private ItemClickListener clickListener;

    public  void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        //called for each item in the list and is responsible for
        //bonding the data from the Sport Object to the Views
        //within the 'SportViewHolder'

        Sport sport = sportList.get(position);
        holder.textView.setText(sport.getSportName());
        holder.imageView.setImageResource(sport.getSportImg());

        holder.itemView.setOnClickListener(new     public  class SportsViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Holds the reference to the views within the item layout

        TextView textView;
        ImageView imageView;
        CardView cardView;

        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onCLick(v,getAdapterPosition());
            }
        }
    });

    @Override
    public int getItemCount() {
        return sportList.size();
    }



View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }

            public void onClick(View v,int position ) {
                Toast.makeText(v.getContext(), "You chose "+sportList.get(position).getSportName(),
                        Toast.LENGTH_SHORT).show();
            }
        }
}

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflating the Layout for each item in the recyclerView

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout,parent,false);

        return new SportsViewHolder(itemView);
    }

    public  static  class SportViewHolder extends RecyclerView.ViewHolder{
      public CardView cardView;

        public SportViewHolder(@NonNull View itemView, CardView cardView) {
            super(itemView);
            this.cardView = cardView;
        }
    }
