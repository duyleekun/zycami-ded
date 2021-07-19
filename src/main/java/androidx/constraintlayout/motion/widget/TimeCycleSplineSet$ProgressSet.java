/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeCycleSplineSet$ProgressSet
extends TimeCycleSplineSet {
    public boolean mNoMethod = false;

    public boolean setProperty(View view, float f10, long l10, KeyCache keyCache) {
        TimeCycleSplineSet$ProgressSet timeCycleSplineSet$ProgressSet = this;
        View view2 = view;
        Object object = "unable to setProgress";
        String string2 = "SplineSet";
        boolean bl2 = view instanceof MotionLayout;
        if (bl2) {
            object = view;
            object = (MotionLayout)view;
            TimeCycleSplineSet$ProgressSet timeCycleSplineSet$ProgressSet2 = this;
            View view3 = view;
            KeyCache keyCache2 = keyCache;
            float f11 = this.get(f10, l10, view, keyCache);
            ((MotionLayout)object).setProgress(f11);
        } else {
            bl2 = this.mNoMethod;
            if (bl2) {
                return false;
            }
            bl2 = false;
            float f12 = 0.0f;
            Object object2 = null;
            int n10 = 1;
            Class<?> clazz = view.getClass();
            String string3 = "setProgress";
            View view4 = new Class[n10];
            Object object3 = Float.TYPE;
            view4[0] = object3;
            try {
                object2 = clazz.getMethod(string3, (Class<?>)view4);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                timeCycleSplineSet$ProgressSet.mNoMethod = n10;
            }
            TimeCycleSplineSet$ProgressSet timeCycleSplineSet$ProgressSet3 = object2;
            if (object2 != null) {
                Object[] objectArray = new Object[n10];
                object2 = this;
                view4 = view;
                object3 = keyCache;
                f12 = this.get(f10, l10, view, keyCache);
                object2 = Float.valueOf(f12);
                objectArray[0] = object2;
                try {
                    ((Method)((Object)timeCycleSplineSet$ProgressSet3)).invoke(view, objectArray);
                }
                catch (InvocationTargetException invocationTargetException) {
                    Log.e((String)string2, (String)object, (Throwable)invocationTargetException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    Log.e((String)string2, (String)object, (Throwable)illegalAccessException);
                }
            }
        }
        return timeCycleSplineSet$ProgressSet.mContinue;
    }
}

