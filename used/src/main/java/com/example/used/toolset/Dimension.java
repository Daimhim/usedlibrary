package com.example.used.toolset;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

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
 *      COMPLEX_UNIT_PX
 *      COMPLEX_UNIT_DIP
 *      COMPLEX_UNIT_SP
 *      COMPLEX_UNIT_PT
 *      COMPLEX_UNIT_IN
 *      COMPLEX_UNIT_MM
 */

public class Dimension {
    public static float applyDimension(Context context,int unit, float value) {
        Resources r;
        if (context == null)
            r = Resources.getSystem();
        else
            r = context.getResources();
        return TypedValue.applyDimension(
                unit, value, r.getDisplayMetrics());
    }

    public static float outputDIP(Context context,float value) {
        return applyDimension(context,COMPLEX_UNIT_DIP,value);
    }
    public static float outputPX(Context context,float value) {
        return applyDimension(context,COMPLEX_UNIT_PX,value);
    }
    public static float outputSP(Context context,float value) {
        return applyDimension(context,COMPLEX_UNIT_SP,value);
    }
    public static float outputPT(Context context,float value) {
        return applyDimension(context,COMPLEX_UNIT_PT,value);
    }
    public static float outputIN(Context context,float value) {
        return applyDimension(context,COMPLEX_UNIT_IN,value);
    }
    public static float outputMM(Context context,float value) {
        return applyDimension(context,COMPLEX_UNIT_MM,value);
    }
}
