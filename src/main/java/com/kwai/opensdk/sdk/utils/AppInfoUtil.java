/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 */
package com.kwai.opensdk.sdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class AppInfoUtil {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getAppName(Context object) {
        Class<AppInfoUtil> clazz = AppInfoUtil.class;
        synchronized (clazz) {
            Throwable throwable22222;
            PackageManager packageManager = object.getPackageManager();
            String string2 = object.getPackageName();
            packageManager = packageManager.getPackageInfo(string2, 0);
            packageManager = packageManager.applicationInfo;
            int n10 = packageManager.labelRes;
            object = object.getResources();
            return object.getString(n10);
            {
                catch (Throwable throwable22222) {
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                    return null;
                }
            }
            throw throwable22222;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap getBitmap(Context object) {
        Class<AppInfoUtil> clazz = AppInfoUtil.class;
        synchronized (clazz) {
            ApplicationInfo applicationInfo = null;
            try {
                Context context;
                block8: {
                    context = object.getApplicationContext();
                    context = context.getPackageManager();
                    try {
                        object = object.getPackageName();
                        applicationInfo = context.getApplicationInfo((String)object, 0);
                        break block8;
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {}
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        context = null;
                    }
                }
                object = context.getApplicationIcon(applicationInfo);
                object = (BitmapDrawable)object;
                return object.getBitmap();
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getPackageName(Context object) {
        Class<AppInfoUtil> clazz = AppInfoUtil.class;
        synchronized (clazz) {
            Throwable throwable22222;
            PackageManager packageManager = object.getPackageManager();
            object = object.getPackageName();
            object = packageManager.getPackageInfo((String)object, 0);
            return object.packageName;
            {
                catch (Throwable throwable22222) {
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                    return null;
                }
            }
            throw throwable22222;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getVersionCode(Context object) {
        Class<AppInfoUtil> clazz = AppInfoUtil.class;
        synchronized (clazz) {
            Throwable throwable22222;
            PackageManager packageManager = object.getPackageManager();
            object = object.getPackageName();
            object = packageManager.getPackageInfo((String)object, 0);
            return object.versionCode;
            {
                catch (Throwable throwable22222) {
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                    return 0;
                }
            }
            throw throwable22222;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getVersionName(Context object) {
        Class<AppInfoUtil> clazz = AppInfoUtil.class;
        synchronized (clazz) {
            Throwable throwable22222;
            PackageManager packageManager = object.getPackageManager();
            object = object.getPackageName();
            object = packageManager.getPackageInfo((String)object, 0);
            return object.versionName;
            {
                catch (Throwable throwable22222) {
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                    return null;
                }
            }
            throw throwable22222;
        }
    }
}

