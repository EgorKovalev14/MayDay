package ru.timcock.mayday.presentation;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class NotificationsListener extends Application
        implements Application.ActivityLifecycleCallbacks {
    private ArrayList<Activity> acts = new ArrayList<Activity>(0);

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        acts.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {
        acts.remove(activity);
        if (acts.size() == 0) {
            message(activity);
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
        acts.remove(activity);
        if (acts.size() == 0) {
            message(activity);
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        acts.remove(activity);
        if (acts.size() == 0) {
            message(activity);
        }
    }

    private void message(Activity activity) {
        Intent intent = new Intent(activity, Service.class).putExtra("command", 1);
        startForegroundService(intent);
    }
}
