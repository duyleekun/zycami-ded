/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.l.a.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;

public final class a {
    public static int a(Context context, String charSequence) {
        int n10;
        String string2 = "Kwai Open Sdk";
        if (context != null && (n10 = TextUtils.isEmpty((CharSequence)charSequence)) == 0) {
            int n11;
            block12: {
                block11: {
                    context = context.getPackageManager();
                    n10 = 128;
                    context = context.getApplicationInfo((String)charSequence, n10);
                    context = context.metaData;
                    if (context == null) break block11;
                    charSequence = "authorizationSdkVersionNumber";
                    n11 = context.getInt((String)charSequence, 0);
                    break block12;
                }
                n11 = 0;
                context = null;
            }
            charSequence = new StringBuilder();
            String string3 = "kwai api level is ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                Log.i((String)string2, (String)charSequence);
                return n11;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                charSequence = new StringBuilder();
                string3 = "get kwai api level failed, ";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append((Object)nameNotFoundException);
                String string4 = ((StringBuilder)charSequence).toString();
                Log.e((String)string2, (String)string4);
            }
        }
        return 0;
    }

    private static Signature[] b(Context object, String string2) {
        int n10;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0) {
            object = object.getPackageManager();
            n10 = 64;
            try {
                object = object.getPackageInfo(string2, n10);
                if (object == null) {
                    return null;
                }
                return object.signatures;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = nameNotFoundException.getMessage();
                string2 = "PackageUtil";
                Log.e((String)string2, (String)object);
            }
        }
        return null;
    }

    public static String c(Context context) {
        String string2 = context.getPackageName();
        return a.d(context, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String d(Context object, String string2) {
        String string3;
        Object object2;
        block5: {
            object2 = null;
            if (object == null) return null;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                return null;
            }
            try {
                object = object.getPackageManager();
                bl2 = false;
                object = object.getPackageInfo(string2, 0);
                object = ((PackageInfo)object).versionName;
            }
            catch (Exception exception) {
                // empty catch block
                break block5;
            }
            try {
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                if (!bl3) return object;
                return null;
            }
            catch (Exception exception) {
                object2 = object;
            }
        }
        object = ((Throwable)((Object)string3)).getMessage();
        string3 = "PackageUtil";
        Log.e((String)string3, (String)object);
        return object2;
    }

    public static int e(Context context) {
        String string2 = context.getPackageName();
        return a.f(context, string2);
    }

    public static int f(Context object, String string2) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            object = object.getPackageManager();
            object = object.getPackageInfo(string2, 0);
            try {
                return object.versionCode;
            }
            catch (Exception exception) {
                object = exception.getMessage();
                string2 = "PackageUtil";
                Log.e((String)string2, (String)object);
            }
        }
        return 0;
    }

    public static boolean g(Context context, String string2) {
        boolean bl2;
        boolean bl3 = false;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            context = context.getPackageManager();
            try {
                context = context.getPackageInfo(string2, 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                context = null;
            }
            if (context != null) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public static boolean h(Context object, String string2, String string3) {
        int n10;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)string3)) == 0) {
            object = a.b((Context)object, string2);
            string2 = "Kwai Open Sdk";
            if (object != null && (n10 = ((Signature[])object).length) != 0) {
                int n11;
                for (n10 = 0; n10 < (n11 = ((Signature[])object).length); ++n10) {
                    String string4 = object[n10].toCharsString().toLowerCase();
                    n11 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n11 == 0) continue;
                    return true;
                }
                Log.e((String)string2, (String)"Signature check failed.");
                return false;
            }
            object = "Get signature failed";
            Log.e((String)string2, (String)object);
        }
        return false;
    }
}

