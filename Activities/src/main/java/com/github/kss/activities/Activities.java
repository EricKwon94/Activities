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
        if (lifecycleListener.getActivities().size() >= 2) {
            int index = lifecycleListener.getActivities().size() - 2;
            return lifecycleListener.getActivities().get(index);
        }
        return null;
    }

    public static List<Activity> getActivities() {
        return lifecycleListener.getActivities();
    }

    public static Context getApplicationContext() {
        return lifecycleListener.getActivity().getApplicationContext();
    }

    public static void setListener(ActivitiesListener listener) {
        lifecycleListener.setListener(listener);
    }

    public static void init(Activity activity) {
        lifecycleListener = new ActivityLifecycleContextListener();
        activity.getApplication().registerActivityLifecycleCallbacks(lifecycleListener);
        lifecycleListener.setActivity(activity);
    }

    public static void release() {
        if (lifecycleListener == null)
            return;
        lifecycleListener.getActivities().clear();
        lifecycleListener.setListener(null);
        lifecycleListener.getActivity().getApplication().unregisterActivityLifecycleCallbacks(lifecycleListener);
        lifecycleListener = null;
    }
}
