/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.WindowInsets
 */
package com.huawei.hms.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BridgeActivity$a
implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewGroup a;

    public BridgeActivity$a(BridgeActivity bridgeActivity, ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        block23: {
            String string2;
            Object[] objectArray;
            Class[] classArray;
            int n10;
            Object object;
            Object object2;
            String string3;
            block22: {
                string3 = "BridgeActivity";
                object2 = "com.huawei.android.view.WindowManagerEx$LayoutParamsEx";
                object2 = Class.forName((String)object2);
                object = "getDisplaySideRegion";
                n10 = 1;
                classArray = new Class[n10];
                Class<WindowInsets> clazz = WindowInsets.class;
                classArray[0] = clazz;
                object2 = ((Class)object2).getMethod((String)object, classArray);
                object = null;
                objectArray = new Object[n10];
                objectArray[0] = windowInsets;
                object2 = ((Method)object2).invoke(null, objectArray);
                if (object2 != null) break block22;
                object2 = "sideRegion is null";
                HMSLog.i(string3, (String)object2);
                break block23;
            }
            object = "com.huawei.android.view.DisplaySideRegionEx";
            object = Class.forName((String)object);
            objectArray = "getSafeInsets";
            classArray = new Class[]{};
            object = ((Class)object).getMethod((String)objectArray, classArray);
            objectArray = new Object[]{};
            object2 = ((Method)object).invoke(object2, objectArray);
            object2 = (Rect)object2;
            object = this.a;
            if (object == null) break block23;
            n10 = ((Rect)object2).left;
            int n11 = ((Rect)object2).right;
            try {
                object.setPadding(n10, 0, n11, 0);
                break block23;
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (InvocationTargetException invocationTargetException) {
                // empty catch block
            }
            object = new StringBuilder();
            objectArray = "An exception occurred while reading: onApplyWindowInsets";
            ((StringBuilder)object).append((String)objectArray);
            string2 = ((Throwable)((Object)string2)).getMessage();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            HMSLog.e(string3, string2);
        }
        return view.onApplyWindowInsets(windowInsets);
    }
}

