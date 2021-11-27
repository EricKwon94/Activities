package com.github.kss.activities;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private static ActivityLifecycleContextListener lifecycleListener;

    public static Activity getCurrentActivity() {
        return lifecycleListener.getActivity();
    }

    public static Activity getPreviousActivity() {
        if (lifecycleListener.getActivities().size() == 0) {
            return null;
        }
        else if (lifecycleListener.getActivities().size() == 1) {
            return getCurrentActivity();
        }
        else {
            int index = lifecycleListener.getActivities().size() - 2;
            Activity activity = (Activity) lifecycleListener.getActivities().toArray()[index];
            return activity;
        }
    }

    public static List<Activity> getActivities() {
        return new ArrayList<>(lifecycleListener.getActivities());
    }

    public static Context getApplicationContext() {
        return lifecycleListener.getActivity().getApplicationContext();
    }

    public static void init(Activity activity) {
        lifecycleListener = new ActivityLifecycleContextListener();
        activity.getApplication().registerActivityLifecycleCallbacks(lifecycleListener);
        lifecycleListener.setActivity(activity);
    }

    public static void release() {
        lifecycleListener.getActivities().clear();
        lifecycleListener.getActivity().getApplication().unregisterActivityLifecycleCallbacks(lifecycleListener);
        lifecycleListener = null;
    }
}
