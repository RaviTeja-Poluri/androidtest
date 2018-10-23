package app.ravi.com.myapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.ravi.com.myapp.R;
import app.ravi.com.myapp.activity.PlacesListActivity;
import app.ravi.com.myapp.model.State;

/**
 * Created by root on 13/2/18.
 */

public class StatesListAdapter extends RecyclerView.Adapter<StatesListAdapter.FeedHolder> {

    private List<State> feeds;
    private Context context;

    public StatesListAdapter(List<State> names, Context context) {
        this.feeds = names;
        this.context = context;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //have to create a root view using inflator.inflate(xml,parent,boolean)
        ///return a root view
        //using root view create holder obj
        //return holder
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.states_list, parent, false);
        return new FeedHolder(root);
    }



    @Override
    public void onBindViewHolder(@NonNull final FeedHolder holder, int position) {
        final State feed = feeds.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //todo : set carousal
            if (feed.getPics() != null && !feed.getPics().isEmpty()) {
                Picasso.with(context).load(feed.getPics().get(0)).into(holder.getPlacesListButton);
            }
        }

        holder.getPlacesListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : get places list and place on another recycler
                String stateId = feed.getId();
                Intent intent = new Intent(context, PlacesListActivity.class);
                intent.putExtra("stateId",stateId);
                context.startActivity(intent);
            }
        });
        holder.uname.setText(feed.getName());
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    class FeedHolder extends RecyclerView.ViewHolder {

        private TextView uname, likeCount, commentCount, shareCount;
        private ImageView imageView, getPlacesListButton;
        private Button likeButton;
        private boolean isLiked;

        FeedHolder(View itemView) {
            super(itemView);
            uname = itemView.findViewById(R.id.statename);
            getPlacesListButton = itemView.findViewById(R.id.uploaded_image);
/*            imageView = itemView.findViewById(R.id.profile_image);
           likeButton = itemView.findViewById(R.id.row_like);

            likeCount = itemView.findViewById(R.id.row_like_count);
            commentCount = itemView.findViewById(R.id.row_comment_count);
            shareCount = itemView.findViewById(R.id.row_share_count);*/
            isLiked = false;
        }
    }
}
