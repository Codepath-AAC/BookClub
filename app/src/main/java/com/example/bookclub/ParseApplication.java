package com.example.bookclub;

import android.app.Application;

import com.parse.BuildConfig;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    public static final String APP_ID = "9VwvZFfQeUwkoVggg2d7U8mRWLUGJk3m6AQ3s7sH";
    public static final String CLIENT_KEY = "m84NUNVcWDudI0KXiZ3YHD5MErO22XreGDw56g4o";
    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        //ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                //.applicationId(BuildConfig.APP_ID)
                .applicationId(APP_ID)
                //.clientKey(BuildConfig.CLIENT_KEY)
                .clientKey(CLIENT_KEY)
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
