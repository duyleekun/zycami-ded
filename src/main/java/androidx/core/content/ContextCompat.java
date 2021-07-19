/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Process
 *  android.util.Log
 *  android.util.TypedValue
 */
package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.ContextCompat$LegacyServiceMapHolder;
import androidx.core.content.ContextCompat$MainHandlerExecutor;
import java.io.File;
import java.util.concurrent.Executor;

public class ContextCompat {
    private static final String TAG = "ContextCompat";
    private static final Object sLock;
    private static TypedValue sTempValue;

    static {
        Object object;
        sLock = object = new Object();
    }

    public static int checkSelfPermission(Context object, String string2) {
        if (string2 != null) {
            int n10 = Process.myPid();
            int n11 = Process.myUid();
            return object.checkPermission(string2, n10, n11);
        }
        object = new IllegalArgumentException("permission is null");
        throw object;
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    private static File createFilesDir(File object) {
        Class<ContextCompat> clazz = ContextCompat.class;
        synchronized (clazz) {
            block10: {
                block11: {
                    boolean bl2 = ((File)object).exists();
                    if (bl2) break block10;
                    bl2 = ((File)object).mkdirs();
                    if (bl2) break block10;
                    bl2 = ((File)object).exists();
                    if (!bl2) break block11;
                    return object;
                }
                String string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "Unable to create files subdir ";
                stringBuilder.append(string3);
                object = ((File)object).getPath();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                Log.w((String)string2, (String)object);
                return null;
            }
            return object;
        }
    }

    public static File getCodeCacheDir(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.getCodeCacheDir();
        }
        object = object.getApplicationInfo();
        object = object.dataDir;
        File file = new File((String)object, "code_cache");
        return ContextCompat.createFilesDir(file);
    }

    public static int getColor(Context context, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return context.getColor(n10);
        }
        return context.getResources().getColor(n10);
    }

    public static ColorStateList getColorStateList(Context context, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return context.getColorStateList(n10);
        }
        return context.getResources().getColorStateList(n10);
    }

    public static File getDataDir(Context object) {
        File file;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return object.getDataDir();
        }
        object = object.getApplicationInfo().dataDir;
        if (object != null) {
            file = new File((String)object);
        } else {
            n10 = 0;
            file = null;
        }
        return file;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Drawable getDrawable(Context context, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return context.getDrawable(n10);
        }
        n12 = 16;
        if (n11 >= n12) {
            return context.getResources().getDrawable(n10);
        }
        Object object = sLock;
        synchronized (object) {
            TypedValue typedValue = sTempValue;
            if (typedValue == null) {
                sTempValue = typedValue = new TypedValue();
            }
            typedValue = context.getResources();
            TypedValue typedValue2 = sTempValue;
            boolean bl2 = true;
            typedValue.getValue(n10, typedValue2, bl2);
            TypedValue typedValue3 = sTempValue;
            n10 = typedValue3.resourceId;
            return context.getResources().getDrawable(n10);
        }
    }

    public static File[] getExternalCacheDirs(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return object.getExternalCacheDirs();
        }
        File[] fileArray = new File[1];
        object = object.getExternalCacheDir();
        fileArray[0] = object;
        return fileArray;
    }

    public static File[] getExternalFilesDirs(Context object, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return object.getExternalFilesDirs(string2);
        }
        File[] fileArray = new File[1];
        object = object.getExternalFilesDir(string2);
        fileArray[0] = object;
        return fileArray;
    }

    public static Executor getMainExecutor(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return context.getMainExecutor();
        }
        context = context.getMainLooper();
        Handler handler = new Handler((Looper)context);
        ContextCompat$MainHandlerExecutor contextCompat$MainHandlerExecutor = new ContextCompat$MainHandlerExecutor(handler);
        return contextCompat$MainHandlerExecutor;
    }

    public static File getNoBackupFilesDir(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.getNoBackupFilesDir();
        }
        object = object.getApplicationInfo();
        object = object.dataDir;
        File file = new File((String)object, "no_backup");
        return ContextCompat.createFilesDir(file);
    }

    public static File[] getObbDirs(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return object.getObbDirs();
        }
        File[] fileArray = new File[1];
        object = object.getObbDir();
        fileArray[0] = object;
        return fileArray;
    }

    public static Object getSystemService(Context object, Class object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getSystemService((Class)object2);
        }
        object = (object2 = ContextCompat.getSystemServiceName(object, (Class)object2)) != null ? object.getSystemService((String)object2) : null;
        return object;
    }

    public static String getSystemServiceName(Context context, Class clazz) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return context.getSystemServiceName(clazz);
        }
        return (String)ContextCompat$LegacyServiceMapHolder.SERVICES.get(clazz);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static boolean startActivities(Context context, Intent[] intentArray) {
        return ContextCompat.startActivities(context, intentArray, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArray, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            context.startActivities(intentArray, bundle);
        } else {
            context.startActivities(intentArray);
        }
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static void startForegroundService(Context context, Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}

