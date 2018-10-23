package app.ravi.com.myapp.adapter;

import android.content.Context;
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
import app.ravi.com.myapp.model.Place;

/**
 * Created by root on 13/2/18.
 */

public class PlacesListAdapter extends RecyclerView.Adapter<PlacesListAdapter.FeedHolder> {

    private List<Place> placesList;
    private Context context;

    public PlacesListAdapter(List<Place> places, Context context) {
        this.placesList = places;
        this.context = context;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //have to create a root view using inflator.inflate(xml,parent,boolean)
        ///return a root view
        //using root view create holder obj
        //return holder
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_list, parent, false);
        return new FeedHolder(root);
    }



    @Override
    public void onBindViewHolder(@NonNull final FeedHolder holder, int position) {
        final Place feed = placesList.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //todo : set carousal
            if (feed.getImageUris() != null && !feed.getImageUris().isEmpty()) {
                Picasso.with(context).load(feed.getImageUris().get(0)).into(holder.placeImage);
            }
        }
        holder.placeName.setText(feed.getName());
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    class FeedHolder extends RecyclerView.ViewHolder {

        private TextView placeName, likeCount, commentCount, shareCount;
        private ImageView imageView, placeImage;
        private Button likeButton;
        private boolean isLiked;

        FeedHolder(View itemView) {
            super(itemView);
            placeName = itemView.findViewById(R.id.placeName);
            placeImage = itemView.findViewById(R.id.place_image);
/*            imageView = itemView.findViewById(R.id.profile_image);
           likeButton = itemView.findViewById(R.id.row_like);

            likeCount = itemView.findViewById(R.id.row_like_count);
            commentCount = itemView.findViewById(R.id.row_comment_count);
            shareCount = itemView.findViewById(R.id.row_share_count);*/
            isLiked = false;
        }
    }
}
