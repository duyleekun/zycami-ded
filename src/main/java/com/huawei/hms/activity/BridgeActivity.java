/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 */
package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.hms.activity.BridgeActivity$a;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BridgeActivity
extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_DELEGATE_UPDATE_INFO = "intent.extra.update.info";
    public static final String EXTRA_INTENT = "intent.extra.intent";
    public static final String EXTRA_IS_FULLSCREEN = "intent.extra.isfullscreen";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";
    public static final int b = BridgeActivity.a("ro.build.hw_emui_api_level", 0);
    public IBridgeActivityDelegate a;

    public static int a(String object, int n10) {
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        Object object3 = "getInt";
        int n11 = 2;
        Class[] classArray = new Class[n11];
        Class clazz = String.class;
        classArray[0] = clazz;
        clazz = Integer.TYPE;
        int n12 = 1;
        classArray[n12] = clazz;
        object3 = ((Class)object2).getDeclaredMethod((String)object3, classArray);
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = n10;
        objectArray[n12] = object;
        object = ((Method)object3).invoke(object2, objectArray);
        object = (Integer)object;
        try {
            return (Integer)object;
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException exception) {
            HMSLog.e("BridgeActivity", "An exception occurred while reading: EMUI_SDK_INT");
            return n10;
        }
    }

    public static void a(Window window, boolean bl2) {
        block13: {
            String string2;
            Object object = window.getClass();
            Object[] objectArray = "setHwFloating";
            int n10 = 1;
            Class[] classArray = new Class[n10];
            Class<Boolean> clazz = Boolean.TYPE;
            classArray[0] = clazz;
            object = ((Class)object).getMethod((String)objectArray, classArray);
            objectArray = new Object[n10];
            Object object2 = bl2;
            objectArray[0] = object2;
            try {
                ((Method)object).invoke(window, objectArray);
                break block13;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            object2 = new StringBuilder();
            object = "In setHwFloating, Failed to call Window.setHwFloating().";
            ((StringBuilder)object2).append((String)object);
            string2 = ((Throwable)((Object)string2)).getMessage();
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object2 = "BridgeActivity";
            HMSLog.e((String)object2, string2);
        }
    }

    public static Intent getIntentStartBridgeActivity(Activity activity, String string2) {
        Intent intent = new Intent((Context)activity, BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, string2);
        boolean bl2 = UIUtil.isActivityFullscreen(activity);
        intent.putExtra(EXTRA_IS_FULLSCREEN, bl2);
        return intent;
    }

    public static Intent getIntentStartBridgeActivity(Context context, String string2) {
        Intent intent = new Intent(context, BridgeActivity.class);
        intent.putExtra(EXTRA_DELEGATE_CLASS_NAME, string2);
        intent.putExtra(EXTRA_IS_FULLSCREEN, false);
        return intent;
    }

    public final void a() {
        Object object;
        String string2;
        int n10;
        Window window;
        block23: {
            window = this.getWindow();
            n10 = 0x1020002;
            window = (ViewGroup)window.findViewById(n10);
            string2 = "BridgeActivity";
            if (window == null) {
                HMSLog.e(string2, "rootView is null");
                return;
            }
            object = this.getWindow().getAttributes();
            Object object2 = "com.huawei.android.view.WindowManagerEx$LayoutParamsEx";
            object2 = Class.forName((String)object2);
            int n11 = 1;
            Object object3 = new Class[n11];
            Object[] objectArray = WindowManager.LayoutParams.class;
            object3[0] = objectArray;
            object3 = ((Class)object2).getDeclaredConstructor((Class<?>)object3);
            objectArray = new Object[n11];
            objectArray[0] = object;
            object = ((Constructor)object3).newInstance(objectArray);
            object3 = "setDisplaySideMode";
            objectArray = new Class[n11];
            Class<Integer> clazz = Integer.TYPE;
            objectArray[0] = clazz;
            object2 = ((Class)object2).getMethod((String)object3, (Class<?>[])objectArray);
            object3 = new Object[n11];
            Object object4 = n11;
            object3[0] = object4;
            try {
                ((Method)object2).invoke(object, (Object[])object3);
                break block23;
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (InstantiationException instantiationException) {
            }
            catch (ClassCastException classCastException) {
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            object2 = new StringBuilder();
            object4 = "An exception occurred while reading: setDisplaySideMode";
            ((StringBuilder)object2).append((String)object4);
            object = object.getMessage();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            HMSLog.e(string2, (String)object);
        }
        n10 = Build.VERSION.SDK_INT;
        int n12 = 20;
        if (n10 >= n12) {
            string2 = this.getWindow().getDecorView();
            object = new BridgeActivity$a(this, (ViewGroup)window);
            string2.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean b() {
        String string2;
        Object object;
        String string3;
        block10: {
            Object object2 = this.getIntent();
            string3 = "BridgeActivity";
            if (object2 == null) {
                HMSLog.e(string3, "In initialize, Must not pass in a null intent.");
                return false;
            }
            object = EXTRA_IS_FULLSCREEN;
            boolean bl2 = object2.getBooleanExtra((String)object, false);
            if (bl2) {
                object = this.getWindow();
                int n10 = 1024;
                object.setFlags(n10, n10);
            }
            if ((object2 = object2.getStringExtra((String)(object = EXTRA_DELEGATE_CLASS_NAME))) == null) {
                HMSLog.e(string3, "In initialize, Must not pass in a null or non class object.");
                return false;
            }
            try {
                object2 = Class.forName((String)object2);
                object = IBridgeActivityDelegate.class;
                object2 = ((Class)object2).asSubclass(object);
                object2 = ((Class)object2).newInstance();
                object2 = (IBridgeActivityDelegate)object2;
                this.a = object2;
            }
            catch (ClassNotFoundException classNotFoundException) {
                break block10;
            }
            catch (IllegalAccessException illegalAccessException) {
                break block10;
            }
            catch (InstantiationException instantiationException) {
                break block10;
            }
            catch (ClassCastException classCastException) {
                // empty catch block
                break block10;
            }
            try {
                object2.onBridgeActivityCreate(this);
                return true;
            }
            catch (RuntimeException runtimeException) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Run time Exception.");
                String string4 = runtimeException.getMessage();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                HMSLog.e(string3, string4);
                return false;
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("In initialize, Failed to create 'IUpdateWizard' instance.");
        string2 = ((Throwable)((Object)string2)).getMessage();
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        HMSLog.e(string3, string2);
        return false;
    }

    public final void c() {
        boolean bl2 = true;
        this.requestWindowFeature((int)(bl2 ? 1 : 0));
        Window window = this.getWindow();
        int n10 = b;
        int n11 = 9;
        if (n10 >= n11) {
            n10 = 0x4000000;
            window.addFlags(n10);
            BridgeActivity.a(window, bl2);
        }
        window.getDecorView().setSystemUiVisibility(0);
    }

    public void finish() {
        HMSLog.i("BridgeActivity", "Enter finish.");
        super.finish();
    }

    public Intent getIntent() {
        Intent intent = super.getIntent();
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            return safeIntent;
        }
        return intent;
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        SafeIntent safeIntent = new SafeIntent((Intent)object);
        super.onActivityResult(n10, n11, (Intent)safeIntent);
        object = this.a;
        if (object != null && (n10 = (int)(object.onBridgeActivityResult(n10, n11, safeIntent) ? 1 : 0)) == 0 && (n10 = (int)(this.isFinishing() ? 1 : 0)) == 0) {
            this.setResult(n11, safeIntent);
            this.finish();
        }
    }

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged((Configuration)object);
        object = this.a;
        if (object != null) {
            object.onBridgeConfigurationChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        int n10;
        super.onCreate(bundle);
        bundle = this.getIntent();
        if (bundle == null) {
            return;
        }
        this.c();
        this.a();
        bundle = ResourceLoaderUtil.getmContext();
        if (bundle == null) {
            bundle = this.getApplicationContext();
            ResourceLoaderUtil.setmContext((Context)bundle);
        }
        if ((n10 = this.b()) == 0) {
            n10 = 1;
            this.setResult(n10, null);
            this.finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
    }

    public boolean onKeyUp(int n10, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate = this.a;
        if (iBridgeActivityDelegate != null) {
            iBridgeActivityDelegate.onKeyUp(n10, keyEvent);
        }
        return super.onKeyUp(n10, keyEvent);
    }
}

