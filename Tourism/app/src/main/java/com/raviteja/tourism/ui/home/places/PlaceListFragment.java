package com.raviteja.tourism.ui.home.places;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raviteja.tourism.R;
import com.raviteja.tourism.model.Place;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceListFragment extends Fragment {

private static String TAG="Home";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlacesListViewModel homeViewModel = ViewModelProviders.of(this).get(PlacesListViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Call<List<Place>> text = homeViewModel.getText();
        List<Place> places = new ArrayList<>();
        MyAdapter myAdapter = new MyAdapter(places, getContext());
        recyclerView.setAdapter(myAdapter);
        Log.d(TAG, "onCreateView: ");
        text.enqueue(
                new Callback<List<Place>>() {
                    @Override
                    public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
                        places.addAll(response.body());
                        myAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Place>> call, Throwable t) {
                        System.out.println("$$$$$$");
                        t.printStackTrace();
                    }
                }
        );
        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView textView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            textView = itemView.findViewById(R.id.textViewVersion);
            textView1 = itemView.findViewById(R.id.textViewVersion1);
            textView2 = itemView.findViewById(R.id.textViewVersion2);
            textView3 = itemView.findViewById(R.id.textViewVersion3);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        List<Place> names;
        TextView textView;
        Context context;

        public MyAdapter(List<Place> names, Context context) {
            Log.d(TAG, "MyAdapter: ");
            this.names = names;
            this.context = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View inflate = inflater.inflate(R.layout.home_card_view, parent, false);
            textView = inflate.findViewById(R.id.textViewVersion);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Place name = names.get(position);
            System.out.println("names:: " + name.toString());
            holder.textView.setText(name.getName());
            holder.textView1.setText(name.getDescription());
            holder.textView2.setText(String.valueOf(name.getCityId()));
            holder.textView3.setText(String.valueOf(name.getId()));

       /*     Picasso.with(this.context).load("http://www.pngmart.com/files/7/India-Map-Transparent-PNG.png")
                    .placeholder(R.drawable.ic_menu_gallery).resize(500, 250).centerCrop().into(holder.imageView);
       */    Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            if (names == null) {
                return 0;
            }
            return names.size();
        }
    }
}