package com.chitchat.chitchat;

import com.firebase.client.Firebase;

/**
 * Created by mitchelle on 9/17/16.
 */
public class LaunchApp extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
