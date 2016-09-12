package com.chitchat.chitchat;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRootRef = new Firebase("https://fir-inandroid.firebaseio.com");
        Firebase messagesRef = mRootRef.child("messages");

        FirebaseRecyclerAdapter<String, MessageViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<String, MessageViewHolder>(
                        String.class,
                        android.R.layout.two_line_list_item,
                        MessageViewHolder.class,
                        messagesRef
                ) {
                    @Override
                    protected void populateViewHolder(MessageViewHolder messageViewHolder, String s, int i) {
                        messageViewHolder.mTextView.setText(s);
                    }
                };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MessageViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(android.R.id.text1);
        }
    }

}
