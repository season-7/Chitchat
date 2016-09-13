package com.chitchat.chitchat;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by EduhG on 9/13/2016.
 */
public class FirebaseTopicsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;
    Firebase mRootRef;

    TextView topicName;
    TextView questions;
    ImageView topicPhoto;

    public FirebaseTopicsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindTopic(Topic topic) {

        topicName = (TextView)mView.findViewById(R.id.topic_name);
        questions = (TextView)mView.findViewById(R.id.questions);
        topicPhoto = (ImageView)mView.findViewById(R.id.topic_photo);

        Picasso.with(mContext)
                .load(topic.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(topicPhoto);

        topicName.setText(topic.getName());
        questions.setText(topic.getQuestions());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Topic> topic = new ArrayList<>();
        mRootRef = new Firebase("https://fir-inandroid.firebaseio.com");
        Firebase messagesRef = mRootRef.child("messages");

        messagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    topic.add(snapshot.getValue(Topic.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, TopicQuestionsActivity.class);
                intent.putExtra("position", itemPosition + "");

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
