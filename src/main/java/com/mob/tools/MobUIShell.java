/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.res.Configuration
 *  android.content.res.TypedArray
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package com.mob.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MobUIShell
extends Activity {
    private static HashMap executors;
    private FakeActivity executor;

    static {
        Object object = new HashMap();
        executors = object;
        object = MobLog.getInstance();
        Object object2 = new Object[]{};
        String string2 = "===============================";
        ((NLog)object).d(string2, (Object[])object2);
        CharSequence charSequence = "-";
        object = "2020-12-17".replace("-0", charSequence).replace(charSequence, ".");
        object2 = MobLog.getInstance();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("MobTools ");
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        charSequence = new Object[]{};
        ((NLog)object2).d(object, (Object[])charSequence);
        object = MobLog.getInstance();
        Object[] objectArray = new Object[]{};
        ((NLog)object).d(string2, objectArray);
    }

    private FakeActivity activityForName(String object) {
        block12: {
            Object[] objectArray;
            boolean bl2;
            block13: {
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (bl2) break block12;
                objectArray = ".";
                bl2 = ((String)object).startsWith((String)objectArray);
                if (!bl2) break block13;
                objectArray = new StringBuilder();
                String string2 = this.getPackageName();
                objectArray.append(string2);
                objectArray.append((String)object);
                object = objectArray.toString();
            }
            object = ReflectHelper.importClass((String)object);
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block12;
            bl2 = false;
            objectArray = null;
            objectArray = new Object[]{};
            object = ReflectHelper.newInstance((String)object, objectArray);
            if (object == null || !(bl2 = object instanceof FakeActivity)) break block12;
            try {
                return (FakeActivity)object;
            }
            catch (Throwable throwable) {
                objectArray = MobLog.getInstance();
                objectArray.w(throwable);
            }
        }
        return null;
    }

    private boolean fixOrientation() {
        Object[] objectArray;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        if (n10 > n11) {
            return false;
        }
        Object object = Activity.class;
        Object object2 = "mActivityInfo";
        try {
            object = ((Class)object).getDeclaredField((String)object2);
            n11 = 1;
        }
        catch (Exception exception) {
            object2 = MobLog.getInstance();
            objectArray = new Object[]{};
            ((NLog)object2).w(exception, (Object)"Fix orientation for 8.0 encountered exception", objectArray);
            return false;
        }
        ((Field)object).setAccessible(n11 != 0);
        objectArray = ((Field)object).get((Object)this);
        objectArray = objectArray;
        int n12 = -1;
        objectArray.screenOrientation = n12;
        ((Field)object).setAccessible(false);
        return n11 != 0;
    }

    private boolean initExecutor() {
        Object object = this.executor;
        boolean bl2 = true;
        if (object == null) {
            String string2;
            Object object2;
            boolean bl3;
            object = this.getIntent();
            Object object3 = object.getData();
            Object object4 = "MobUIShell found executor: ";
            if (object3 != null && (bl3 = ((String)(object2 = "mobui")).equals(string2 = object3.getScheme()))) {
                object3 = object3.getHost();
                object3 = this.activityForName((String)object3);
                this.executor = object3;
                if (object3 != null) {
                    object = MobLog.getInstance();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)object4);
                    object4 = this.executor.getClass();
                    ((StringBuilder)object3).append(object4);
                    object3 = ((StringBuilder)object3).toString();
                    object4 = new Object[]{};
                    ((NLog)object).i(object3, (Object[])object4);
                    this.executor.setActivity(this);
                    return bl2;
                }
            }
            object3 = "launch_time";
            try {
                object3 = object.getStringExtra((String)object3);
                string2 = "executor_name";
            }
            catch (Throwable throwable) {
                MobLog.getInstance().w(throwable);
                return false;
            }
            string2 = object.getStringExtra(string2);
            this.executor = object2 = (FakeActivity)executors.remove(object3);
            if (object2 == null) {
                object = object.getScheme();
                object2 = executors;
                this.executor = object = (FakeActivity)((HashMap)object2).remove(object);
                if (object == null) {
                    this.executor = object = this.getDefault();
                    if (object == null) {
                        object = MobLog.getInstance();
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("Executor lost! launchTime = ");
                        ((StringBuilder)object4).append((String)object3);
                        ((StringBuilder)object4).append(", executorName: ");
                        ((StringBuilder)object4).append(string2);
                        object3 = ((StringBuilder)object4).toString();
                        RuntimeException runtimeException = new RuntimeException((String)object3);
                        ((NLog)object).w(runtimeException);
                        return false;
                    }
                }
            }
            object = MobLog.getInstance();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object4);
            object4 = this.executor.getClass();
            ((StringBuilder)object3).append(object4);
            object3 = ((StringBuilder)object3).toString();
            object4 = new Object[]{};
            ((NLog)object).i(object3, (Object[])object4);
            object = this.executor;
            ((FakeActivity)object).setActivity(this);
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean isTranslucentOrFloating() {
        void var2_8;
        void var1_4;
        Object object;
        block5: {
            Object object3;
            int bl2 = Build.VERSION.SDK_INT;
            Object var2_5 = null;
            int n10 = 27;
            if (bl2 > n10) {
                return false;
            }
            Object object2 = "com.android.internal.R$styleable";
            try {
                Class<TypedArray> clazz;
                object2 = Class.forName((String)object2);
                object = "Window";
                object2 = ((Class)object2).getField((String)object);
                boolean bl3 = false;
                object = null;
                object2 = ((Field)object2).get(null);
                object2 = (int[])object2;
                object3 = this.executor;
                object3 = ((FakeActivity)object3).activity;
                object2 = object3.obtainStyledAttributes((int[])object2);
                object3 = ActivityInfo.class;
                Object[] objectArray = "isTranslucentOrFloating";
                int n11 = 1;
                Class[] classArray = new Class[n11];
                classArray[0] = clazz = TypedArray.class;
                object3 = ((Class)object3).getMethod((String)objectArray, classArray);
                ((Method)object3).setAccessible(n11 != 0);
                objectArray = new Object[n11];
                objectArray[0] = object2;
                object2 = ((Method)object3).invoke(null, objectArray);
                object2 = (Boolean)object2;
                boolean bl4 = (Boolean)object2;
            }
            catch (Exception exception) {
                boolean bl5 = false;
                object2 = null;
                break block5;
            }
            try {
                ((Method)object3).setAccessible(false);
                return (boolean)var1_4;
            }
            catch (Exception exception) {}
        }
        object = MobLog.getInstance();
        ((NLog)object).w((Throwable)var2_8);
        return (boolean)var1_4;
    }

    public static String registerExecutor(Object object) {
        return MobUIShell.registerExecutor(String.valueOf(System.currentTimeMillis()), object);
    }

    public static String registerExecutor(String string2, Object object) {
        HashMap hashMap = executors;
        object = (FakeActivity)object;
        hashMap.put(string2, object);
        return string2;
    }

    public static Uri toMobUIShellUri(String string2, HashMap serializable) {
        boolean bl2;
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        Iterator iterator2 = ((HashMap)serializable).keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string3 = (String)iterator2.next();
            String string4 = String.valueOf(((HashMap)serializable).get(string3));
            KVPair kVPair = new KVPair(string3, string4);
            arrayList.add(kVPair);
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("mobui://");
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("?");
        string2 = ResHelper.encodeUrl(arrayList);
        ((StringBuilder)serializable).append(string2);
        return Uri.parse((String)((StringBuilder)serializable).toString());
    }

    public void finish() {
        boolean bl2;
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null && (bl2 = fakeActivity.onFinish())) {
            return;
        }
        super.finish();
    }

    public FakeActivity getDefault() {
        Object object = this.getPackageManager();
        Object object2 = this.getComponentName();
        int n10 = 128;
        object = object.getActivityInfo((ComponentName)object2, n10);
        object = object.metaData;
        object2 = "defaultActivity";
        try {
            object = object.getString((String)object2);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
            object = null;
        }
        return this.activityForName((String)object);
    }

    public Object getExecutor() {
        return this.executor;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.onActivityResult(n10, n11, intent);
        }
        super.onActivityResult(n10, n11, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle object) {
        int n10 = this.initExecutor();
        if (n10 != 0) {
            NLog nLog = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            String string2 = this.executor.getClass().getSimpleName();
            charSequence.append(string2);
            charSequence.append(" onCreate");
            charSequence = charSequence.toString();
            string2 = null;
            Object[] objectArray = new Object[]{};
            nLog.d(charSequence, objectArray);
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 == n11 && (n11 = (int)(this.isTranslucentOrFloating() ? 1 : 0)) != 0) {
                this.fixOrientation();
            }
            if (n10 >= (n11 = 21)) {
                nLog = this.executor.activity.getWindow();
                n11 = -1 << -1;
                nLog.addFlags(n11);
                nLog = this.executor.activity.getWindow();
                nLog.setStatusBarColor(0);
            }
            super.onCreate((Bundle)object);
            object = this.executor;
            ((FakeActivity)object).onCreate();
        } else {
            super.onCreate((Bundle)object);
            this.finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        boolean bl2 = super.onCreateOptionsMenu(menu2);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            return fakeActivity.onCreateOptionsMenu(menu2);
        }
        return bl2;
    }

    public void onDestroy() {
        Object object = this.executor;
        if (object != null) {
            ((FakeActivity)object).sendResult();
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = this.executor.getClass().getSimpleName();
            charSequence.append((String)objectArray);
            charSequence.append(" onDestroy");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = this.executor;
            ((FakeActivity)object).onDestroy();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        boolean bl2;
        block7: {
            FakeActivity fakeActivity;
            block6: {
                try {
                    fakeActivity = this.executor;
                    if (fakeActivity == null) break block6;
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().w(throwable);
                    return false;
                }
                bl2 = fakeActivity.onKeyEvent(n10, keyEvent);
                break block7;
            }
            bl2 = false;
            fakeActivity = null;
        }
        if (bl2) {
            n10 = 1;
        } else {
            n10 = (int)(super.onKeyDown(n10, keyEvent) ? 1 : 0);
        }
        return n10 != 0;
    }

    public boolean onKeyUp(int n10, KeyEvent keyEvent) {
        boolean bl2;
        block7: {
            FakeActivity fakeActivity;
            block6: {
                try {
                    fakeActivity = this.executor;
                    if (fakeActivity == null) break block6;
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().w(throwable);
                    return false;
                }
                bl2 = fakeActivity.onKeyEvent(n10, keyEvent);
                break block7;
            }
            bl2 = false;
            fakeActivity = null;
        }
        if (bl2) {
            n10 = 1;
        } else {
            n10 = (int)(super.onKeyUp(n10, keyEvent) ? 1 : 0);
        }
        return n10 != 0;
    }

    public void onNewIntent(Intent intent) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity == null) {
            super.onNewIntent(intent);
        } else {
            fakeActivity.onNewIntent(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean bl2 = super.onOptionsItemSelected(menuItem);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            return fakeActivity.onOptionsItemSelected(menuItem);
        }
        return bl2;
    }

    public void onPause() {
        Object object = this.executor;
        if (object != null) {
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = this.executor.getClass().getSimpleName();
            charSequence.append((String)objectArray);
            charSequence.append(" onPause");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = this.executor;
            ((FakeActivity)object).onPause();
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.onRequestPermissionsResult(n10, stringArray, nArray);
        }
    }

    public void onRestart() {
        Object object = this.executor;
        if (object != null) {
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = this.executor.getClass().getSimpleName();
            charSequence.append((String)objectArray);
            charSequence.append(" onRestart");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = this.executor;
            ((FakeActivity)object).onRestart();
        }
        super.onRestart();
    }

    public void onResume() {
        Object object = this.executor;
        if (object != null) {
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = this.executor.getClass().getSimpleName();
            charSequence.append((String)objectArray);
            charSequence.append(" onResume");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = this.executor;
            ((FakeActivity)object).onResume();
        }
        super.onResume();
    }

    public void onStart() {
        Object object = this.executor;
        if (object != null) {
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = this.executor.getClass().getSimpleName();
            charSequence.append((String)objectArray);
            charSequence.append(" onStart");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = this.executor;
            ((FakeActivity)object).onStart();
        }
        super.onStart();
    }

    public void onStop() {
        Object object = this.executor;
        if (object != null) {
            object = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = this.executor.getClass().getSimpleName();
            charSequence.append((String)objectArray);
            charSequence.append(" onStop");
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = this.executor;
            ((FakeActivity)object).onStop();
        }
        super.onStop();
    }

    public void setContentView(int n10) {
        View view = LayoutInflater.from((Context)this).inflate(n10, null);
        this.setContentView(view);
    }

    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        super.setContentView(view);
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }

    public void setContentView(View view, ViewGroup.LayoutParams object) {
        if (view == null) {
            return;
        }
        if (object == null) {
            super.setContentView(view);
        } else {
            super.setContentView(view, (ViewGroup.LayoutParams)object);
        }
        object = this.executor;
        if (object != null) {
            ((FakeActivity)object).setContentView(view);
        }
    }

    public void setRequestedOrientation(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 == n12 && (n11 = (int)(this.isTranslucentOrFloating() ? 1 : 0)) != 0) {
            return;
        }
        super.setRequestedOrientation(n10);
    }

    public final void setTheme(int n10) {
        boolean bl2 = this.initExecutor();
        if (bl2) {
            int n11;
            Object object = Thread.currentThread().getStackTrace();
            FakeActivity fakeActivity = null;
            for (int i10 = 0; i10 < (n11 = ((StackTraceElement[])object).length); ++i10) {
                String string2;
                String string3 = object[i10].toString();
                n11 = (int)(string3.startsWith(string2 = "java.lang.Thread.getStackTrace") ? 1 : 0);
                if (n11 == 0 || (i10 += 2) >= (n11 = ((StackTraceElement[])object).length)) continue;
                fakeActivity = this.executor;
                bl2 = ((String)(object = object[i10].toString())).startsWith("android.app.ActivityThread.performLaunchActivity");
                if ((n10 = fakeActivity.onSetTheme(n10, bl2)) > 0) {
                    super.setTheme(n10);
                }
                return;
            }
        }
        super.setTheme(n10);
    }

    public void startActivityForResult(Intent intent, int n10) {
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, n10, null);
        }
        super.startActivityForResult(intent, n10);
    }

    public void startActivityForResult(Intent intent, int n10, Bundle bundle) {
        int n11;
        int n12;
        FakeActivity fakeActivity = this.executor;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, n10, bundle);
        }
        if ((n12 = Build.VERSION.SDK_INT) >= (n11 = 16)) {
            super.startActivityForResult(intent, n10, bundle);
        } else {
            super.startActivityForResult(intent, n10);
        }
    }
}

