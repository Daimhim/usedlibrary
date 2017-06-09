package com.example.used.toolset;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.COMPLEX_UNIT_IN;
import static android.util.TypedValue.COMPLEX_UNIT_MM;
import static android.util.TypedValue.COMPLEX_UNIT_PT;
import static android.util.TypedValue.COMPLEX_UNIT_PX;
import static android.util.TypedValue.COMPLEX_UNIT_SP;

/**
 * Project name：usedlibrary
 * Project version：com.example.used.toolset
 * Creation time：2017/6/8 0008 下午 22:09
 * Founder: Daimhim
 * QQ: 154944544
 * Remarks:
 */

public class Dimension {
    public static float applyDimension(int unit, float value, Context context) {
        Resources r;

        if (context == null)
            r = Resources.getSystem();
        else
            r = context.getResources();
        DisplayMetrics metrics = r.getDisplayMetrics();
        switch (unit) {
            case COMPLEX_UNIT_PX:
                return value;
            case COMPLEX_UNIT_DIP:
                return value * metrics.density;
            case COMPLEX_UNIT_SP:
                return value * metrics.scaledDensity;
            case COMPLEX_UNIT_PT:
                return value * metrics.xdpi * (1.0f / 72);
            case COMPLEX_UNIT_IN:
                return value * metrics.xdpi;
            case COMPLEX_UNIT_MM:
                return value * metrics.xdpi * (1.0f / 25.4f);
        }
        return 0;
    }
}
