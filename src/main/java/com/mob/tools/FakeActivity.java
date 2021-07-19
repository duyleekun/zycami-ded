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
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.Window
 */
package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.mob.tools.FakeActivity$1;
import com.mob.tools.FakeActivity$2;
import com.mob.tools.FakeActivity$3;
import com.mob.tools.MobLog;
import com.mob.tools.MobUIShell;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FakeActivity {
    private static Class shellClass;
    public Activity activity;
    private View contentView;
    private HashMap result;
    private FakeActivity resultReceiver;

    public static /* synthetic */ void access$000(FakeActivity fakeActivity, Context context, Intent intent) {
        fakeActivity.showActivity(context, intent);
    }

    public static void registerExecutor(String string2, Object object) {
        GenericDeclaration genericDeclaration = shellClass;
        if (genericDeclaration != null) {
            String string3 = "registerExecutor";
            int n10 = 2;
            Class[] classArray = new Class[n10];
            Class clazz = String.class;
            classArray[0] = clazz;
            clazz = Object.class;
            int n11 = 1;
            classArray[n11] = clazz;
            genericDeclaration = ((Class)genericDeclaration).getMethod(string3, classArray);
            ((Method)genericDeclaration).setAccessible(n11 != 0);
            string3 = null;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            objectArray[n11] = object;
            try {
                ((Method)genericDeclaration).invoke(null, objectArray);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        } else {
            MobUIShell.registerExecutor(string2, object);
        }
    }

    public static void setShell(Class clazz) {
        shellClass = clazz;
    }

    private void showActivity(Context context, Intent intent) {
        int n10 = context instanceof Activity;
        if (n10 == 0) {
            Activity activity = DeviceHelper.getInstance(context).getTopActivity();
            if (activity == null) {
                n10 = 0x10000000;
                intent.addFlags(n10);
            } else {
                context = activity;
            }
        }
        context.startActivity(intent);
    }

    public void beforeStartActivityForResult(Intent intent, int n10, Bundle bundle) {
    }

    public boolean disableScreenCapture() {
        int n10;
        int n11;
        Activity activity = this.activity;
        if (activity != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 11)) {
            activity = activity.getWindow();
            n11 = 8192;
            activity.setFlags(n11, n11);
            return true;
        }
        return false;
    }

    public View findViewById(int n10) {
        Activity activity = this.activity;
        if (activity == null) {
            return null;
        }
        return activity.findViewById(n10);
    }

    public View findViewByResName(View view, String string2) {
        Activity activity = this.activity;
        if (activity == null) {
            return null;
        }
        int n10 = ResHelper.getIdRes((Context)activity, string2);
        if (n10 > 0) {
            return view.findViewById(n10);
        }
        return null;
    }

    public View findViewByResName(String string2) {
        Activity activity = this.activity;
        if (activity == null) {
            return null;
        }
        int n10 = ResHelper.getIdRes((Context)activity, string2);
        if (n10 > 0) {
            return this.findViewById(n10);
        }
        return null;
    }

    public final void finish() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    public View getContentView() {
        return this.contentView;
    }

    public Context getContext() {
        return this.activity;
    }

    public int getOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    public FakeActivity getParent() {
        return this.resultReceiver;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        return true;
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int n10, KeyEvent keyEvent) {
        return false;
    }

    public void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
    }

    public void onRestart() {
    }

    public void onResult(HashMap hashMap) {
    }

    public void onResume() {
    }

    public int onSetTheme(int n10, boolean bl2) {
        return n10;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void requestFullScreen(boolean bl2) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        int n10 = 1024;
        int n11 = 2048;
        if (bl2) {
            activity.getWindow().addFlags(n10);
            Window window = this.activity.getWindow();
            window.clearFlags(n11);
        } else {
            activity.getWindow().addFlags(n11);
            Window window = this.activity.getWindow();
            window.clearFlags(n10);
        }
        this.activity.getWindow().getDecorView().requestLayout();
    }

    public void requestLandscapeOrientation() {
        this.setRequestedOrientation(0);
    }

    public void requestPermissions(String[] object, int n10) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            String string2 = "requestPermissions";
            n12 = 2;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object;
            object = n10;
            n10 = 1;
            objectArray[n10] = object;
            object = new Class[n12];
            Class clazz = String.class;
            object[0] = clazz;
            clazz = Integer.TYPE;
            object[n10] = clazz;
            try {
                ReflectHelper.invokeInstanceMethod((Object)activity, string2, objectArray, (Class[])object);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
    }

    public void requestPortraitOrientation() {
        this.setRequestedOrientation(1);
    }

    public void requestSensorLandscapeOrientation() {
        this.setRequestedOrientation(6);
    }

    public void requestSensorPortraitOrientation() {
        this.setRequestedOrientation(7);
    }

    public void runOnUIThread(Runnable runnable) {
        FakeActivity$2 fakeActivity$2 = new FakeActivity$2(this, runnable);
        UIHandler.sendEmptyMessage(0, fakeActivity$2);
    }

    public void runOnUIThread(Runnable runnable, long l10) {
        FakeActivity$3 fakeActivity$3 = new FakeActivity$3(this, runnable);
        UIHandler.sendEmptyMessageDelayed(0, l10, fakeActivity$3);
    }

    public void sendResult() {
        FakeActivity fakeActivity = this.resultReceiver;
        if (fakeActivity != null) {
            HashMap hashMap = this.result;
            fakeActivity.onResult(hashMap);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public void setContentViewLayoutResName(String string2) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        int n10 = ResHelper.getLayoutRes((Context)activity, string2);
        if (n10 > 0) {
            activity = this.activity;
            activity.setContentView(n10);
        }
    }

    public void setRequestedOrientation(int n10) {
        block5: {
            Activity activity;
            block4: {
                activity = this.activity;
                if (activity == null) {
                    return;
                }
                int n11 = Build.VERSION.SDK_INT;
                int n12 = 26;
                if (n11 < n12) break block4;
                activity = this.getContext().getApplicationInfo();
                n11 = activity.targetSdkVersion;
                n12 = 27;
                if (n11 >= n12) break block5;
            }
            activity = this.activity;
            activity.setRequestedOrientation(n10);
        }
    }

    public final void setResult(HashMap hashMap) {
        this.result = hashMap;
    }

    public void show(Context context, Intent intent) {
        this.showForResult(context, intent, null);
    }

    public void showForResult(Context context, Intent object, FakeActivity object2) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object3;
        this.resultReceiver = object2;
        object2 = shellClass;
        Object object4 = null;
        if (object2 != null) {
            object3 = shellClass;
            object2 = new Intent(context, (Class)object3);
            object3 = shellClass;
            Object[] objectArray = "registerExecutor";
            int n10 = 1;
            Class[] classArray = new Class[n10];
            Class<Object> clazz = Object.class;
            classArray[0] = clazz;
            object3 = ((Class)object3).getMethod((String)objectArray, classArray);
            ((Method)object3).setAccessible(n10 != 0);
            objectArray = new Object[n10];
            objectArray[0] = this;
            object3 = ((Method)object3).invoke(null, objectArray);
            try {
                object4 = object3 = (String)object3;
            }
            catch (Throwable throwable) {
                objectArray = MobLog.getInstance();
                objectArray.w(throwable);
            }
        } else {
            object2 = new Intent(context, MobUIShell.class);
            object4 = MobUIShell.registerExecutor(this);
        }
        object2.putExtra("launch_time", (String)object4);
        object4 = this.getClass().getName();
        object3 = "executor_name";
        object2.putExtra((String)object3, (String)object4);
        if (object != null) {
            object2.putExtras((Intent)object);
        }
        if ((l13 = (l12 = (l11 = Thread.currentThread().getId()) - (l10 = ((Thread)(object = Looper.getMainLooper().getThread())).getId())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            this.showActivity(context, (Intent)object2);
        } else {
            object = new FakeActivity$1(this, context, (Intent)object2);
            UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
        }
    }

    public void startActivity(Intent intent) {
        this.startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int n10) {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        activity.startActivityForResult(intent, n10);
    }
}

