package com.chitchat.chitchat;

import com.firebase.client.Firebase;

/**
 * Created by EduhG on 9/12/2016.
 */
public class LaunchApp extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
