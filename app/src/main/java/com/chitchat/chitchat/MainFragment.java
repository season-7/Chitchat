package com.chitchat.chitchat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseRecyclerAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    Firebase mRootRef;
    ArrayList<String> mMessages = new ArrayList<>();
    RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;

    private FirebaseRecyclerAdapter mFirebaseAdapter;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        setUpFirebaseAdapter();

        // Inflate the layout for this fragment
        return rootView;
    }

    private void setUpFirebaseAdapter() {
        mRootRef = new Firebase("https://fir-inandroid.firebaseio.com");
        Firebase messagesRef = mRootRef.child("messages");

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Topic, FirebaseTopicsViewHolder>(
                Topic.class,
                R.layout.topics,
                FirebaseTopicsViewHolder.class,
                messagesRef
        ) {
            @Override
            protected void populateViewHolder(FirebaseTopicsViewHolder viewHolder,
                                              Topic model, int position) {
                viewHolder.bindTopic(model);
            }
        };

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    /*mRecyclerView.setHasFixedSize(true);
    mLayoutManager = new LinearLayoutManager(getActivity());
    mRecyclerView.setLayoutManager(mLayoutManager);

    mRootRef = new Firebase("https://fir-inandroid.firebaseio.com");
    Firebase messagesRef = mRootRef.child("topics");

    FirebaseRecyclerAdapter<String, MessageViewHolder> firebaseRecyclerAdapter =
            new FirebaseRecyclerAdapter<String, MessageViewHolder>(
                    String.class,
                    R.layout.topics,
                    MessageViewHolder.class,
                    messagesRef
            ) {
                @Override
                protected void populateViewHolder(MessageViewHolder messageViewHolder, String s, int i) {
                    messageViewHolder.topicName.setText(s);
                }
            };

    mRecyclerView.setAdapter(firebaseRecyclerAdapter);*/

    /*public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        CardView topicView;
        TextView topicName;
        TextView questions;
        ImageView topicPhoto;

        public MessageViewHolder(View itemView) {
            super(itemView);

            //mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            topicView = (CardView)itemView.findViewById(R.id.topicView);
            topicName = (TextView)itemView.findViewById(R.id.topic_name);
            questions = (TextView)itemView.findViewById(R.id.questions);
            topicPhoto = (ImageView)itemView.findViewById(R.id.topic_photo);
        }
    }*/

}
