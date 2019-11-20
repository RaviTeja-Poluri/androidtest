package com.android.ravidemo;

 import android.content.Context;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
 import androidx.cardview.widget.CardView;
 import androidx.recyclerview.widget.RecyclerView;

 import java.util.List;


public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyviewHolder> {


    Context context;
    List<String> placesList;
    RvItemClickListener listener;
    public MyRvAdapter(Context context, List<String> placesList,RvItemClickListener listener) {

        this.listener=listener;
        this.context=context;
        this.placesList=placesList;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_row, parent, false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, final int position) {

        holder.textView.setText(placesList.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return placesList.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder{

CardView cardView;
        TextView textView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardview1);
            textView=itemView.findViewById(R.id.tv_title);
        }
    }

}
