package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("53AgMfNnw0qOgRBfJ9MSaGOYz77MpRdFDVuNby2t")
                .clientKey("5MLJWJbmayyHFoV7jhsbqTrHxss0XAAGwA9ZfJjv")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
