/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.SplineSet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SplineSet$ProgressSet
extends SplineSet {
    public boolean mNoMethod = false;

    public void setProperty(View object, float f10) {
        String string2 = "unable to setProgress";
        String string3 = "SplineSet";
        boolean bl2 = object instanceof MotionLayout;
        if (bl2) {
            object = (MotionLayout)object;
            f10 = this.get(f10);
            ((MotionLayout)object).setProgress(f10);
        } else {
            bl2 = this.mNoMethod;
            if (bl2) {
                return;
            }
            bl2 = false;
            Method method = null;
            int n10 = 1;
            Class<?> clazz = object.getClass();
            String string4 = "setProgress";
            Class[] classArray = new Class[n10];
            Class<Float> clazz2 = Float.TYPE;
            classArray[0] = clazz2;
            try {
                method = clazz.getMethod(string4, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.mNoMethod = n10;
            }
            if (method != null) {
                Object[] objectArray = new Object[n10];
                f10 = this.get(f10);
                Float f11 = Float.valueOf(f10);
                objectArray[0] = f11;
                try {
                    method.invoke(object, objectArray);
                }
                catch (InvocationTargetException invocationTargetException) {
                    Log.e((String)string3, (String)string2, (Throwable)invocationTargetException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
                }
            }
        }
    }
}

