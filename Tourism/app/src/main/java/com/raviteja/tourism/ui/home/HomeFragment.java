package com.raviteja.tourism.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raviteja.tourism.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        List<Name> names = new ArrayList<>();
        names.add(new Name("test1", "java", "15", "15000"));
        names.add(new Name("test2", "java1", "25", "55000"));
        names.add(new Name("test3", "java2", "55", "1555000"));
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyAdapter(names, getContext()));
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

    private class Name {
        private String name;
        private String job;
        private String age;
        private String salary;

        public Name(String name, String job, String age, String salary) {
            this.name = name;
            this.job = job;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public String getAge() {
            return age;
        }

        public String getSalary() {
            return salary;
        }

        @NonNull
        @Override
        public String toString() {
            return "Name{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    ", age='" + age + '\'' +
                    ", salary='" + salary + '\'' +
                    '}';
        }
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        List<Name> names;
        TextView textView;
        Context context;

        public MyAdapter(List<Name> names, Context context) {
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
            Name name = names.get(position);
            System.out.println("names:: " + name.toString());
            holder.textView.setText(name.getName());
            holder.textView1.setText(name.getJob());
            holder.textView2.setText(name.getAge());
            holder.textView3.setText(name.getSalary());

            Picasso.with(context).load("https://upload.wikimedia.org/wikipedia/commons/0/05/India_geo_stub.svg")
                    .resize(50,50).centerCrop().into(holder.imageView);
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