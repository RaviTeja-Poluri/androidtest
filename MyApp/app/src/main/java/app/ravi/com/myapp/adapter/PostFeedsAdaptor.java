package app.ravi.com.myapp.adapter;

import android.content.Context;
import android.os.Build;
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
import app.ravi.com.myapp.model.Feed;

/**
 * Created by root on 13/2/18.
 */

public class PostFeedsAdaptor extends RecyclerView.Adapter<PostFeedsAdaptor.FeedHolder> {

    private List<Feed> feeds;
    private Context context;

    public PostFeedsAdaptor(List<Feed> names, Context context) {
        this.feeds = names;
        this.context = context;
    }

    @Override
    public FeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //have to create a root view using inflator.inflate(xml,parent,boolean)
        ///return a root view
        //using root view create holder obj
        //return holder
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.feeds_list, parent, false);
        return new FeedHolder(root);
    }

    @Override
    public void onBindViewHolder(final FeedHolder holder, int position) {
        final Feed feed = feeds.get(position);
        //final Resources res = context.getResources();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            holder.uploadedPic.setImageDrawable(res.getDrawable(R.drawable.splash, res.newTheme()));
            Picasso.with(context).load(feed.getFeedUrl()).into(holder.uploadedPic);
        }
        holder.likeCount.setText(String.valueOf(feed.getLikeCout()));
        holder.commentCount.setText(String.valueOf(feed.getCommentCount()));
        holder.shareCount.setText(String.valueOf(feed.getShareCount()));
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long existingLikes = feed.getLikeCout();
                if (holder.isLiked) {
                    holder.isLiked = false;
                    if (holder.likeCount.getText() != null && !holder.likeCount.getText().toString().isEmpty()) {
                        existingLikes = Long.valueOf(holder.likeCount.getText().toString());
                    }
                    if (existingLikes > 0) {
                        existingLikes -= 1;
                    }
                    feed.setLikeCout(existingLikes);
                    holder.likeCount.setText(String.valueOf(existingLikes));
                    holder.likeButton.setBackgroundResource(R.drawable.like);
                } else {
                    holder.isLiked = true;
                    if (holder.likeCount.getText() != null && !holder.likeCount.getText().toString().isEmpty()) {
                        existingLikes = Long.valueOf(holder.likeCount.getText().toString());
                    }
                    existingLikes += 1;
                    feed.setLikeCout(existingLikes);
                    holder.likeCount.setText(String.valueOf(existingLikes));
                    holder.likeButton.setBackgroundResource(R.drawable.liked);

                }
            }
        });
        holder.uname.setText(feed.getUserName());
//        Resources res = context.getResources(); /** from an Activity */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            holder.imageView.setImageURI(Uri.parse("https://imagejournal.org/wp-content/uploads/bb-plugin/cache/23466317216_b99485ba14_o-panorama.jpg"));
            Picasso.with(context).load(feed.getUserProfilePicUrl()).into(holder.imageView);
//            holder.imageView.setImageDrawable(res.getDrawable(R.drawable.bgimage,res.newTheme()));
        }
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    class FeedHolder extends RecyclerView.ViewHolder {

        private TextView uname, likeCount, commentCount, shareCount;
        private ImageView imageView, uploadedPic;
        private Button likeButton;
        private boolean isLiked;

        FeedHolder(View itemView) {
            super(itemView);
            uname = itemView.findViewById(R.id.tv_uname);
            imageView = itemView.findViewById(R.id.profile_image);
            likeButton = itemView.findViewById(R.id.row_like);
            uploadedPic = itemView.findViewById(R.id.uploaded_image);
            likeCount = itemView.findViewById(R.id.row_like_count);
            commentCount = itemView.findViewById(R.id.row_comment_count);
            shareCount = itemView.findViewById(R.id.row_share_count);
            isLiked = false;
        }
    }
}
