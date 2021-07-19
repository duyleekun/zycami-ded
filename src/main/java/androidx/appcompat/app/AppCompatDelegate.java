/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class AppCompatDelegate {
    public static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = 255;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = 156;
    public static final int MODE_NIGHT_YES = 2;
    public static final String TAG = "AppCompatDelegate";
    private static final ArraySet sActivityDelegates;
    private static final Object sActivityDelegatesLock;
    private static int sDefaultNightMode = 156;

    static {
        Object object = new ArraySet();
        sActivityDelegates = object;
        sActivityDelegatesLock = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addActiveDelegate(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate);
            ArraySet arraySet = sActivityDelegates;
            WeakReference<AppCompatDelegate> weakReference = new WeakReference<AppCompatDelegate>(appCompatDelegate);
            arraySet.add(weakReference);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void applyDayNightToActiveDelegates() {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            Object object2 = sActivityDelegates;
            object2 = ((ArraySet)object2).iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (WeakReference)object3;
                object3 = ((Reference)object3).get();
                if ((object3 = (AppCompatDelegate)object3) == null) continue;
                ((AppCompatDelegate)object3).applyDayNight();
            }
            return;
        }
    }

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        AppCompatDelegateImpl appCompatDelegateImpl = new AppCompatDelegateImpl(activity, appCompatCallback);
        return appCompatDelegateImpl;
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        AppCompatDelegateImpl appCompatDelegateImpl = new AppCompatDelegateImpl(dialog, appCompatCallback);
        return appCompatDelegateImpl;
    }

    public static AppCompatDelegate create(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        AppCompatDelegateImpl appCompatDelegateImpl = new AppCompatDelegateImpl(context, activity, appCompatCallback);
        return appCompatDelegateImpl;
    }

    public static AppCompatDelegate create(Context context, Window window, AppCompatCallback appCompatCallback) {
        AppCompatDelegateImpl appCompatDelegateImpl = new AppCompatDelegateImpl(context, window, appCompatCallback);
        return appCompatDelegateImpl;
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void removeActivityDelegate(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void removeDelegateFromActives(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            Object object2 = sActivityDelegates;
            object2 = ((ArraySet)object2).iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (WeakReference)object3;
                object3 = ((Reference)object3).get();
                if ((object3 = (AppCompatDelegate)object3) != appCompatDelegate && object3 != null) continue;
                object2.remove();
            }
            return;
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean bl2) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(bl2);
    }

    public static void setDefaultNightMode(int n10) {
        int n11 = -1;
        if (n10 != n11 && n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2) && n10 != (n11 = 3)) {
            String string2 = TAG;
            String string3 = "setDefaultNightMode() called with an unknown mode";
            Log.d((String)string2, (String)string3);
        } else {
            n11 = sDefaultNightMode;
            if (n11 != n10) {
                sDefaultNightMode = n10;
                AppCompatDelegate.applyDayNightToActiveDelegates();
            }
        }
    }

    public abstract void addContentView(View var1, ViewGroup.LayoutParams var2);

    public abstract boolean applyDayNight();

    public void attachBaseContext(Context context) {
    }

    public Context attachBaseContext2(Context context) {
        this.attachBaseContext(context);
        return context;
    }

    public abstract View createView(View var1, String var2, Context var3, AttributeSet var4);

    public abstract View findViewById(int var1);

    public abstract ActionBarDrawerToggle$Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int var1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration var1);

    public abstract void onCreate(Bundle var1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle var1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle var1);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int var1);

    public abstract void setContentView(int var1);

    public abstract void setContentView(View var1);

    public abstract void setContentView(View var1, ViewGroup.LayoutParams var2);

    public abstract void setHandleNativeActionModesEnabled(boolean var1);

    public abstract void setLocalNightMode(int var1);

    public abstract void setSupportActionBar(Toolbar var1);

    public void setTheme(int n10) {
    }

    public abstract void setTitle(CharSequence var1);

    public abstract ActionMode startSupportActionMode(ActionMode$Callback var1);
}

