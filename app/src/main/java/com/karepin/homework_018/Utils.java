package com.karepin.homework_018;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_MARGIN_1 = 0;
    public final static int THEME_MARGIN_2 = 0;
    public final static int THEME_MARGIN_3 = 0;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_MARGIN_1:
                activity.setTheme(R.style.Margin1);
                break;
            case THEME_MARGIN_2:
                activity.setTheme(R.style.Margin2);
                break;
            case THEME_MARGIN_3:
                activity.setTheme(R.style.Margin3);
                break;
        }
    }
}
