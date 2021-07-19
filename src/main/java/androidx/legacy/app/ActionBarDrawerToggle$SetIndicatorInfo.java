/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 */
package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

public class ActionBarDrawerToggle$SetIndicatorInfo {
    public Method mSetHomeActionContentDescription;
    public Method mSetHomeAsUpIndicator;
    public ImageView mUpIndicatorView;

    public ActionBarDrawerToggle$SetIndicatorInfo(Activity activity) {
        Class clazz;
        Class[] classArray;
        View view = null;
        int n10 = 1;
        Object object = ActionBar.class;
        String string2 = "setHomeAsUpIndicator";
        try {
            classArray = new Class[n10];
            clazz = Drawable.class;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            boolean bl2;
            int n11;
            int n12 = 16908332;
            activity = activity.findViewById(n12);
            if (activity == null) {
                return;
            }
            int n13 = (activity = (ViewGroup)activity.getParent()).getChildCount();
            if (n13 != (n11 = 2)) {
                return;
            }
            view = activity.getChildAt(0);
            activity = activity.getChildAt(n10);
            n10 = view.getId();
            if (n10 == n12) {
                view = activity;
            }
            if (bl2 = view instanceof ImageView) {
                view = (ImageView)view;
                this.mUpIndicatorView = view;
            }
            return;
        }
        classArray[0] = clazz;
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        this.mSetHomeAsUpIndicator = object;
        object = ActionBar.class;
        string2 = "setHomeActionContentDescription";
        classArray = new Class[n10];
        clazz = Integer.TYPE;
        classArray[0] = clazz;
        object = ((Class)object).getDeclaredMethod(string2, classArray);
        this.mSetHomeActionContentDescription = object;
    }
}

