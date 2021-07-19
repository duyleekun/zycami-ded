/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package cn.leancloud;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;
import cn.leancloud.AVLogger;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;

public class AVManifestUtils {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVManifestUtils.class);

    public static boolean checkPermission(Context context, String string2) {
        int n10 = ContextCompat.checkSelfPermission(context, string2);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        if (!n10) {
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "permission ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.append(" is missing!");
            string2 = stringBuilder.toString();
            AVManifestUtils.printErrorLog(string2);
        }
        return n10 != 0;
    }

    public static boolean checkReceiver(Context object, Class object2) {
        PackageManager packageManager;
        boolean bl2 = false;
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("receiver ");
            object2 = ((Class)object2).getName();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" is missing!");
            AVManifestUtils.printErrorLog(((StringBuilder)object).toString());
            return false;
        }
        ComponentName componentName = new ComponentName((Context)object, (Class)object2);
        object = packageManager.getReceiverInfo(componentName, 0);
        if (object != null) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean checkService(Context object, Class object2) {
        PackageManager packageManager;
        boolean bl2 = false;
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("service ");
            object2 = ((Class)object2).getName();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" is missing!");
            AVManifestUtils.printErrorLog(((StringBuilder)object).toString());
            return false;
        }
        ComponentName componentName = new ComponentName((Context)object, (Class)object2);
        object = packageManager.getServiceInfo(componentName, 0);
        if (object != null) {
            bl2 = true;
        }
        return bl2;
    }

    private static void printErrorLog(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            AVLogger aVLogger = LOGGER;
            aVLogger.e(string2);
        }
    }
}

