/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Process
 *  android.provider.Settings
 */
package com.zhiyun.cama.camera.liveassistant;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.zhiyun.common.util.RomUtils;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.Objects;

public class FloatWindowPermissionHelper {
    private static final String a = "MI 8 Explorer Edition";

    private static boolean a(Context context) {
        String string2;
        Object object = Settings.class;
        String string3 = "ACTION_MANAGE_OVERLAY_PERMISSION";
        try {
            object = ((Class)object).getDeclaredField(string3);
            string2 = null;
        }
        catch (Exception exception) {
            return false;
        }
        object = ((Field)object).get(null);
        Objects.requireNonNull(object);
        object = object.toString();
        string3 = new Intent((String)object);
        object = new StringBuilder();
        string2 = "package:";
        ((StringBuilder)object).append(string2);
        string2 = context.getPackageName();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        object = Uri.parse((String)object);
        string3.setData((Uri)object);
        FloatWindowPermissionHelper.g((Intent)string3, context);
        return true;
    }

    private static boolean b(Context context) {
        Intent intent = new Intent();
        intent.setAction("miui.intent.action.APP_PERM_EDITOR");
        intent.addCategory("android.intent.category.DEFAULT");
        String string2 = context.getPackageName();
        intent.putExtra("extra_pkgname", string2);
        return FloatWindowPermissionHelper.g(intent, context);
    }

    private static boolean c(Context context) {
        Intent intent = new Intent();
        String string2 = context.getPackageName();
        intent.putExtra("packagename", string2);
        string2 = "com.vivo.permissionmanager";
        intent.setAction(string2);
        String string3 = "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity";
        intent.setClassName(string2, string3);
        string2 = context.getPackageManager();
        string2 = intent.resolveActivity((PackageManager)string2);
        if (string2 != null) {
            return FloatWindowPermissionHelper.g(intent, context);
        }
        string2 = "com.iqoo.secure";
        intent.setAction(string2);
        intent.setClassName(string2, "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        string3 = context.getPackageManager();
        string3 = intent.resolveActivity((PackageManager)string3);
        if (string3 != null) {
            return FloatWindowPermissionHelper.g(intent, context);
        }
        intent.setAction(string2);
        intent.setClassName(string2, "com.iqoo.secure.MainActivity");
        return FloatWindowPermissionHelper.g(intent, context);
    }

    public static boolean canBackgroundStartForXiaoMi(Context object) {
        int n10;
        Object[] objectArray;
        GenericDeclaration genericDeclaration;
        boolean bl2 = RomUtils.A();
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        AppOpsManager appOpsManager = (AppOpsManager)object.getSystemService("appops");
        int n11 = 10021;
        try {
            genericDeclaration = appOpsManager.getClass();
            objectArray = "checkOpNoThrow";
            n10 = 3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        Class[] classArray = new Class[n10];
        Class<Object> clazz = Integer.TYPE;
        classArray[0] = clazz;
        classArray[bl3] = clazz;
        clazz = String.class;
        int n12 = 2;
        classArray[n12] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        Integer n13 = n11;
        objectArray[0] = n13;
        n11 = Process.myUid();
        n13 = n11;
        objectArray[bl3] = n13;
        object = object.getPackageName();
        objectArray[n12] = object;
        object = ((Method)genericDeclaration).invoke(appOpsManager, objectArray);
        object = (Integer)object;
        int n14 = (Integer)object;
        if (n14 != 0) {
            bl3 = false;
        }
        return bl3;
    }

    public static boolean d(Context context) {
        return Settings.canDrawOverlays((Context)context);
    }

    public static boolean e(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        String string2 = context.getPackageName();
        string2 = Uri.fromParts((String)"package", (String)string2, null);
        intent.setData((Uri)string2);
        return FloatWindowPermissionHelper.g(intent, context);
    }

    private static boolean f(Intent object, Context context) {
        int n10;
        int n11;
        if (object != null && (n11 = (object = (context = context.getPackageManager()).queryIntentActivities((Intent)object, n10 = 65536)).size()) > 0) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    private static boolean g(Intent intent, Context context) {
        block4: {
            int n10;
            try {
                n10 = FloatWindowPermissionHelper.f(intent, context);
                if (n10 == 0) break block4;
                n10 = 0x10000000;
            }
            catch (Exception exception) {}
            intent.setFlags(n10);
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    public static boolean h(Context context) {
        String string2;
        String string3;
        boolean bl2 = RomUtils.q();
        if (bl2) {
            return FloatWindowPermissionHelper.e(context);
        }
        bl2 = RomUtils.z();
        if (bl2) {
            return FloatWindowPermissionHelper.c(context);
        }
        bl2 = RomUtils.A();
        if (bl2 && !(bl2 = (string3 = Build.MODEL).equals(string2 = a))) {
            boolean bl3;
            bl2 = FloatWindowPermissionHelper.b(context);
            if (!bl2 && !(bl3 = FloatWindowPermissionHelper.e(context))) {
                bl3 = false;
                context = null;
            } else {
                bl3 = true;
            }
            return bl3;
        }
        return FloatWindowPermissionHelper.a(context);
    }
}

