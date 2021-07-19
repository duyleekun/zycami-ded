/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.pm.ActivityInfo
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseActivity
extends Activity {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean l() {
        boolean bl2;
        Exception exception;
        block4: {
            Object object2;
            exception = null;
            Object object = "com.android.internal.R$styleable";
            try {
                Class<TypedArray> clazz;
                object = Class.forName((String)object);
                String string2 = "Window";
                object = ((Class)object).getField(string2);
                string2 = null;
                object = ((Field)object).get(null);
                object = (int[])object;
                object = this.obtainStyledAttributes((int[])object);
                object2 = ActivityInfo.class;
                Object[] objectArray = "isTranslucentOrFloating";
                int n10 = 1;
                Class[] classArray = new Class[n10];
                classArray[0] = clazz = TypedArray.class;
                object2 = ((Class)object2).getMethod((String)objectArray, classArray);
                ((Method)object2).setAccessible(n10 != 0);
                objectArray = new Object[n10];
                objectArray[0] = object;
                object = ((Method)object2).invoke(null, objectArray);
                object = (Boolean)object;
                bl2 = (Boolean)object;
            }
            catch (Exception exception3) {
                bl2 = false;
                object = null;
                exception = exception3;
                break block4;
            }
            try {
                ((Method)object2).setAccessible(false);
                return bl2;
            }
            catch (Exception exception2) {}
        }
        exception.printStackTrace();
        return bl2;
    }

    private boolean m() {
        boolean bl2;
        Object object = Activity.class;
        String string2 = "mActivityInfo";
        try {
            object = ((Class)object).getDeclaredField(string2);
            bl2 = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        ((Field)object).setAccessible(bl2);
        Object object2 = ((Field)object).get((Object)this);
        object2 = (ActivityInfo)object2;
        int n10 = -1;
        ((ActivityInfo)object2).screenOrientation = n10;
        ((Field)object).setAccessible(false);
        return bl2;
    }

    public void onCreate(Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 == n11 && (n10 = (int)(this.l() ? 1 : 0)) != 0) {
            this.m();
        }
        super.onCreate(bundle);
    }

    public void setRequestedOrientation(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 == n12 && (n11 = (int)(this.l() ? 1 : 0)) != 0) {
            return;
        }
        super.setRequestedOrientation(n10);
    }
}

