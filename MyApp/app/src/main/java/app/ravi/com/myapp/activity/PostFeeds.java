package app.ravi.com.myapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.Collections;

import app.ravi.com.myapp.R;
import app.ravi.com.myapp.adapter.PostFeedsAdaptor;
import app.ravi.com.myapp.model.Feed;

public class PostFeeds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feeds_activity);
        RecyclerView viewById = findViewById(R.id.recycler1);
        String userName = getIntent().getStringExtra("uname");
        if (userName == null || userName.isEmpty()) {
            userName = "Guest";
        }


        Feed user = new Feed();
        user.setUserName("ravi");
        user.setLikeCout(5);
        user.setCommentCount(3);
        user.setFeedText("universe");
        user.setUserProfilePicUrl("http://www.iloveindia.com/indian-heroes/pics/shaheed-bhagat-singh.jpg");
        user.setFeedUrl("http://www.davidreneke.com/wp-content/uploads/2017/07/Spiral.jpg");

/*        Feed user1 = new Feed();
        user1.setName("teja");
        user1.setAge(25);
        user1.setImagePath("https://www.thebetterindia.com/wp-content/uploads/2014/07/speech_bose.jpg");
        user1.setLocation("Hyderabad");
        user1.setMobile(9651245879L);
        user1.setFeedPath("http://images.all-free-download.com/images/graphicthumb/cute_puppy_photo_picture_11_168839.jpg");

        Feed user2 = new Feed();
        user2.setName("nagendra");
        user2.setAge(29);
        user2.setImagePath("https://www.mapsofindia.com/who-is-who/images/icon-sports.png");
        user2.setLocation("Chennai");
        user2.setMobile(9652312546L);
        user2.setFeedPath("http://images.indianexpress.com/2017/08/odisha-cricket-association-shiv-sundar-das-sports-news-cricket-indian-express.jpg");

        Feed user3 = new Feed();
        user3.setName("vishwa");
        user3.setAge(28);
        user3.setImagePath("https://www.filmibeat.com/img/2014/11/04-1-rajinikanth.jpg");
        user3.setLocation("Bangalore");
        user3.setMobile(9874563215L);
        user3.setFeedPath("https://pbs.twimg.com/profile_images/531732001431117824/6IbZCMQX_400x400.jpeg");

        Feed user4 = new Feed();
        user4.setName("Guest");
        user4.setImagePath("https://youprogrammer.com/wp-content/uploads/2017/12/amazon-ask-question-community.jpg");
        user4.setFeedPath("http://www.calvarybaptistbeaufort.com/wordpress/wp-content/uploads/2015/09/Question.png");*/


/*        PostFeedsAdaptor postFeedsAdaptor;
        if (userName.equals("ravi")) {
            postFeedsAdaptor = new PostFeedsAdaptor(Arrays.asList(user, user1), getApplicationContext());
        } else if (userName.equals("nag")) {
            postFeedsAdaptor = new PostFeedsAdaptor(Collections.singletonList(user2), getApplicationContext());
        } else if (userName.equals("vishwa")) {
            postFeedsAdaptor = new PostFeedsAdaptor(Collections.singletonList(user3), getApplicationContext());
        } else {
            postFeedsAdaptor = new PostFeedsAdaptor(Collections.singletonList(user4), getApplicationContext());
        }*/

        PostFeedsAdaptor postFeedsAdaptor = postFeedsAdaptor = new PostFeedsAdaptor(Arrays.asList(user), getApplicationContext());
        viewById.setAdapter(postFeedsAdaptor);
        viewById.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
