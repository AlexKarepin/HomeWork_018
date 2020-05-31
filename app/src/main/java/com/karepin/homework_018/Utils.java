package com.karepin.homework_018;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_MARGIN_ONE = 1;
    public final static int THEME_MARGIN_TWO = 2;
    public final static int THEME_MARGIN_THREE = 3;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
    }
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_MARGIN_ONE:
                activity.setTheme(R.style.Margin1);
                break;
            case THEME_MARGIN_TWO:
                activity.setTheme(R.style.Margin2);
                break;
            case THEME_MARGIN_THREE:
                activity.setTheme(R.style.Margin3);
                break;
        }
    }
}
