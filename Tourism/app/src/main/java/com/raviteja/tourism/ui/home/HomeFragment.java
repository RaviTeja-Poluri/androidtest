package com.raviteja.tourism.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raviteja.tourism.R;

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
        recyclerView.setAdapter(new MyAdapter(names));
        return view;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView textView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public MyViewHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.home_card_view, container, false));
            if (container != null) {
                cardView = container.findViewById(R.id.card_view);
                textView = container.findViewById(R.id.textViewVersion);
                textView1 = container.findViewById(R.id.textViewVersion1);
                textView2 = container.findViewById(R.id.textViewVersion2);
                textView3 = container.findViewById(R.id.textViewVersion3);
            } else {
                Log.e("ViewHolder::", "view is null");
            }
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

        public MyAdapter(List<Name> names) {
            this.names = names;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new MyViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Name name = names.get(position);
            System.out.println("names:: " + name.toString());
            holder.textView.setText(name.getName());
            holder.textView1.setText(name.getJob());
            holder.textView2.setText(name.getAge());
            holder.textView3.setText(name.getSalary());

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