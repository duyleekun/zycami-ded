/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;
import java.lang.reflect.Method;

public class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS;

    static {
        int[] nArray = new int[]{16843531};
        THEME_ATTRS = nArray;
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        Object object = THEME_ATTRS;
        activity = activity.obtainStyledAttributes(object);
        object = activity.getDrawable(0);
        activity.recycle();
        return object;
    }

    public static ActionBarDrawerToggleHoneycomb$SetIndicatorInfo setActionBarDescription(ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo, Activity activity, int n10) {
        block11: {
            Object object;
            if (actionBarDrawerToggleHoneycomb$SetIndicatorInfo == null) {
                actionBarDrawerToggleHoneycomb$SetIndicatorInfo = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(activity);
            }
            if ((object = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator) != null) {
                activity = activity.getActionBar();
                object = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeActionContentDescription;
                int n11 = 1;
                Object[] objectArray = new Object[n11];
                Object object2 = n10;
                objectArray[0] = object2;
                ((Method)object).invoke(activity, objectArray);
                n10 = Build.VERSION.SDK_INT;
                int n12 = 19;
                if (n10 > n12) break block11;
                object2 = activity.getSubtitle();
                try {
                    activity.setSubtitle((CharSequence)object2);
                }
                catch (Exception exception) {
                    object2 = TAG;
                    object = "Couldn't set content description via JB-MR2 API";
                    Log.w((String)object2, (String)object, (Throwable)exception);
                }
            }
        }
        return actionBarDrawerToggleHoneycomb$SetIndicatorInfo;
    }

    public static ActionBarDrawerToggleHoneycomb$SetIndicatorInfo setActionBarUpIndicator(Activity object, Drawable object2, int n10) {
        ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo = new ActionBarDrawerToggleHoneycomb$SetIndicatorInfo((Activity)object);
        Object[] objectArray = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator;
        String string2 = TAG;
        if (objectArray != null) {
            object = object.getActionBar();
            objectArray = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeAsUpIndicator;
            int n11 = 1;
            Object[] objectArray2 = new Object[n11];
            objectArray2[0] = object2;
            objectArray.invoke(object, objectArray2);
            object2 = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.setHomeActionContentDescription;
            objectArray = new Object[n11];
            Integer n12 = n10;
            objectArray[0] = n12;
            try {
                ((Method)object2).invoke(object, objectArray);
            }
            catch (Exception exception) {
                object2 = "Couldn't set home-as-up indicator via JB-MR2 API";
                Log.w((String)string2, (String)object2, (Throwable)exception);
            }
        } else {
            object = actionBarDrawerToggleHoneycomb$SetIndicatorInfo.upIndicatorView;
            if (object != null) {
                object.setImageDrawable((Drawable)object2);
            } else {
                object = "Couldn't set home-as-up indicator";
                Log.w((String)string2, (String)object);
            }
        }
        return actionBarDrawerToggleHoneycomb$SetIndicatorInfo;
    }
}

