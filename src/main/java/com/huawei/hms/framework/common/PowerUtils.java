/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 */
package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.huawei.hms.framework.common.ContextCompat;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PowerUtils$PowerMode;
import com.huawei.hms.framework.common.SettingUtil;

public class PowerUtils {
    private static final String TAG = "PowerUtils";

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isDozeIdleMode(Context object) {
        void var0_4;
        boolean bl2 = false;
        String string2 = TAG;
        if (object == null) {
            String string3 = "isDozeIdleMode Context is null!";
            Logger.i(string2, string3);
            return bl2;
        }
        String string4 = "power";
        Object object2 = ContextCompat.getSystemService(object, string4);
        int n10 = object2 instanceof PowerManager;
        if (n10 != 0) {
            PowerManager powerManager = (PowerManager)object2;
        } else {
            Object var0_3 = null;
        }
        if (var0_4 == null) {
            Logger.i(string2, "isDozeIdleMode powerManager is null!");
            return false;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            Logger.i(string2, "isDozeIdleMode is version control state!");
            return false;
        }
        try {
            return var0_4.isDeviceIdleMode();
        }
        catch (RuntimeException runtimeException) {
            string4 = "dealType rethrowFromSystemServer:";
            Logger.e(string2, string4, runtimeException);
            return bl2;
        }
    }

    public static boolean isInteractive(Context object) {
        boolean bl2;
        block4: {
            CharSequence charSequence;
            int n10;
            if (object != null && (n10 = (object = ContextCompat.getSystemService(object, (String)(charSequence = "power"))) instanceof PowerManager) != 0) {
                object = (PowerManager)object;
                n10 = Build.VERSION.SDK_INT;
                int n11 = 20;
                if (n10 >= n11) {
                    try {
                        bl2 = object.isInteractive();
                        break block4;
                    }
                    catch (RuntimeException runtimeException) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("getActiveNetworkInfo failed, exception:");
                        String string2 = runtimeException.getClass().getSimpleName();
                        ((StringBuilder)charSequence).append(string2);
                        object = runtimeException.getMessage();
                        ((StringBuilder)charSequence).append((String)object);
                        object = ((StringBuilder)charSequence).toString();
                        charSequence = TAG;
                        Logger.i((String)charSequence, object);
                    }
                }
            }
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean isWhilteList(Context object) {
        boolean bl2;
        block4: {
            if (object != null) {
                int n10;
                Object object2 = ContextCompat.getSystemService(object, "power");
                int n11 = object2 instanceof PowerManager;
                object2 = n11 != 0 ? (PowerManager)object2 : null;
                object = object.getPackageName();
                if (object2 != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
                    try {
                        bl2 = object2.isIgnoringBatteryOptimizations((String)object);
                        break block4;
                    }
                    catch (RuntimeException runtimeException) {
                        object2 = TAG;
                        String string2 = "dealType rethrowFromSystemServer:";
                        Logger.e((String)object2, string2, runtimeException);
                    }
                }
            }
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static int readPowerSaverMode(Context object) {
        int n10;
        block8: {
            String string2;
            block7: {
                block9: {
                    int n11;
                    block6: {
                        String string3;
                        block5: {
                            int n12;
                            int n13;
                            string2 = TAG;
                            if (object == null) break block7;
                            ContentResolver contentResolver = object.getContentResolver();
                            n10 = SettingUtil.getSystemInt(contentResolver, string3 = PowerUtils$PowerMode.SMART_MODE_STATUS, n13 = PowerUtils$PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
                            if (n10 != (n12 = PowerUtils$PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE)) break block8;
                            n12 = 0;
                            string3 = null;
                            String string4 = "power";
                            n13 = (object = ContextCompat.getSystemService(object, string4)) instanceof PowerManager;
                            if (n13 != 0) {
                                string3 = object;
                                string3 = (PowerManager)object;
                            }
                            if (string3 == null) break block8;
                            n11 = Build.VERSION.SDK_INT;
                            n13 = 21;
                            if (n11 < n13) break block9;
                            n11 = (int)(string3.isPowerSaveMode() ? 1 : 0);
                            if (n11 == 0) break block5;
                            n11 = PowerUtils$PowerMode.POWER_SAVER_MODE;
                            break block6;
                        }
                        try {
                            n11 = PowerUtils$PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
                        }
                        catch (RuntimeException runtimeException) {
                            string3 = "dealType rethrowFromSystemServer:";
                            Logger.e(string2, string3, runtimeException);
                        }
                    }
                    n10 = n11;
                    break block8;
                    break block8;
                }
                object = "readPowerSaverMode is control by version!";
                Logger.i(string2, object);
                break block8;
            }
            object = "readPowerSaverMode Context is null!";
            Logger.i(string2, object);
            n10 = 0;
            Object var2_4 = null;
        }
        return n10;
    }
}

