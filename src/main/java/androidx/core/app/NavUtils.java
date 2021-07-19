/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    public static Intent getParentActivityIntent(Activity object) {
        block9: {
            ComponentName componentName;
            block8: {
                Object object2;
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 16;
                if (n10 >= n11 && (object2 = object.getParentActivityIntent()) != null) {
                    return object2;
                }
                object2 = NavUtils.getParentActivityName((Activity)object);
                n11 = 0;
                if (object2 == null) {
                    return null;
                }
                componentName = new ComponentName((Context)object, (String)object2);
                try {
                    object = NavUtils.getParentActivityName((Context)object, componentName);
                    if (object != null) break block8;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("getParentActivityIntent: bad parentActivityName '");
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append("' in manifest");
                    object = ((StringBuilder)object).toString();
                    Log.e((String)TAG, (String)object);
                    return null;
                }
                object = Intent.makeMainActivity((ComponentName)componentName);
                break block9;
            }
            object = new Intent();
            object = object.setComponent(componentName);
        }
        return object;
    }

    public static Intent getParentActivityIntent(Context object, ComponentName object2) {
        String string2 = NavUtils.getParentActivityName(object, object2);
        if (string2 == null) {
            return null;
        }
        ComponentName componentName = new ComponentName((String)(object2 = object2.getPackageName()), string2);
        if ((object = NavUtils.getParentActivityName(object, componentName)) == null) {
            object = Intent.makeMainActivity((ComponentName)componentName);
        } else {
            object = new Intent();
            object = object.setComponent(componentName);
        }
        return object;
    }

    public static Intent getParentActivityIntent(Context object, Class object2) {
        ComponentName componentName = new ComponentName(object, (Class)object2);
        if ((object2 = NavUtils.getParentActivityName(object, componentName)) == null) {
            return null;
        }
        componentName = new ComponentName(object, (String)object2);
        if ((object = NavUtils.getParentActivityName(object, componentName)) == null) {
            object = Intent.makeMainActivity((ComponentName)componentName);
        } else {
            object = new Intent();
            object = object.setComponent(componentName);
        }
        return object;
    }

    public static String getParentActivityName(Activity activity) {
        Object object;
        try {
            object = activity.getComponentName();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new IllegalArgumentException(nameNotFoundException);
            throw object;
        }
        return NavUtils.getParentActivityName((Context)activity, object);
    }

    public static String getParentActivityName(Context object, ComponentName object2) {
        Object object3 = object.getPackageManager();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        int n12 = 640;
        int n13 = 29;
        if (n10 >= n13) {
            n12 = 269222528;
        } else if (n10 >= n11) {
            n12 = 787072;
        }
        object2 = object3.getActivityInfo((ComponentName)object2, n12);
        int n14 = 16;
        if (n10 >= n14 && (object3 = ((ActivityInfo)object2).parentActivityName) != null) {
            return object3;
        }
        object2 = ((ActivityInfo)object2).metaData;
        n14 = 0;
        object3 = null;
        if (object2 == null) {
            return null;
        }
        String string2 = PARENT_ACTIVITY;
        if ((object2 = object2.getString(string2)) == null) {
            return null;
        }
        object3 = null;
        n14 = ((String)object2).charAt(0);
        if (n14 == (n10 = 46)) {
            object3 = new StringBuilder();
            object = object.getPackageName();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
        }
        return object2;
    }

    public static void navigateUpFromSameTask(Activity object) {
        Object object2 = NavUtils.getParentActivityIntent(object);
        if (object2 != null) {
            NavUtils.navigateUpTo(object, object2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Activity ");
        object = object.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append(" does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static void navigateUpTo(Activity activity, Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            activity.navigateUpTo(intent);
        } else {
            n10 = 0x4000000;
            intent.addFlags(n10);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static boolean shouldUpRecreateTask(Activity object, Intent object2) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return object.shouldUpRecreateTask(object2);
        }
        if ((object = object.getIntent().getAction()) != null && !(bl2 = ((String)object).equals(object2 = "android.intent.action.MAIN"))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

