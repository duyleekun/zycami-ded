/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.secure.android.common.util.LogsUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class a {
    private static final String a = "HiPkgSignManager";

    private static String a(byte[] object) {
        Object object2 = "SHA-256";
        object2 = MessageDigest.getInstance((String)object2);
        object = ((MessageDigest)object2).digest((byte[])object);
        try {
            object = d.j.f.a.a.i.a.b(object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = new StringBuilder();
            String string2 = "NoSuchAlgorithmException";
            ((StringBuilder)object2).append(string2);
            object = noSuchAlgorithmException.getMessage();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = a;
            Log.e((String)object2, (String)object);
            object = "";
        }
        return object;
    }

    private static String b(byte[] object) {
        if (object == null) {
            return null;
        }
        int n10 = ((byte[])object).length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < n10; ++i10) {
            CharSequence charSequence;
            int n11 = object[i10] & 0xFF;
            int n12 = 16;
            if (n11 < n12) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("0");
                n12 = object[i10] & 0xFF;
                String string2 = Integer.toHexString(n12);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                stringBuffer.append((String)charSequence);
                continue;
            }
            n11 = object[i10] & 0xFF;
            charSequence = Integer.toHexString(n11);
            stringBuffer.append((String)charSequence);
        }
        object = stringBuffer.toString();
        Locale locale = Locale.ENGLISH;
        return ((String)object).toUpperCase(locale);
    }

    public static boolean c(Context object, String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        boolean bl3 = false;
        if (!(bl2 || (bl2 = TextUtils.isEmpty((CharSequence)string2)) || object == null || (bl2 = TextUtils.isEmpty((CharSequence)string4)))) {
            boolean bl4;
            String string5 = d.j.f.a.a.i.a.i(object, string3);
            object = d.j.f.a.a.i.a.g(object, string3);
            boolean bl5 = string2.equalsIgnoreCase(string5);
            if (bl5 && (bl4 = string4.equals(object))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public static boolean d(Context object, String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && object != null) {
            object = d.j.f.a.a.i.a.f(object, string3);
            return string2.equals(object);
        }
        return false;
    }

    public static byte[] e(Context signature, String charSequence) {
        boolean bl2;
        String string2 = a;
        if (signature != null && !(bl2 = TextUtils.isEmpty((CharSequence)charSequence))) {
            block8: {
                bl2 = true;
                signature = signature.getPackageManager();
                if (signature == null) break block8;
                int n10 = 64;
                signature = signature.getPackageInfo((String)charSequence, n10);
                if (signature == null) break block8;
                signature = signature.signatures;
                signature = signature[0];
                try {
                    return signature.toByteArray();
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    String string3 = "Exception : ";
                    ((StringBuilder)charSequence).append(string3);
                    String string4 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string4);
                    string4 = ((StringBuilder)charSequence).toString();
                    LogsUtil.q(string2, string4, bl2);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    charSequence = new StringBuilder();
                    String string5 = "PackageManager.NameNotFoundException : ";
                    ((StringBuilder)charSequence).append(string5);
                    String string6 = nameNotFoundException.getMessage();
                    ((StringBuilder)charSequence).append(string6);
                    string6 = ((StringBuilder)charSequence).toString();
                    LogsUtil.q(string2, string6, bl2);
                }
            }
            return new byte[0];
        }
        Log.e((String)string2, (String)"packageName is null or context is null");
        return new byte[0];
    }

    public static String f(Context object, String string2) {
        int n10;
        object = (object = (Object)d.j.f.a.a.i.a.e(object, string2)) != null && (n10 = ((Context)object).length) > 0 ? d.j.f.a.a.i.a.a((byte[])object) : "";
        return object;
    }

    public static String g(Context context, String charSequence) {
        int n10;
        String string2 = "";
        String string3 = a;
        if (context != null && (n10 = TextUtils.isEmpty((CharSequence)charSequence)) == 0) {
            block5: {
                context = context.getPackageManager();
                if (context == null) break block5;
                n10 = 64;
                context = context.getPackageArchiveInfo((String)charSequence, n10);
                if (context == null) break block5;
                try {
                    return context.packageName;
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    String string4 = "getUnInstalledAPPSignature exception : ";
                    ((StringBuilder)charSequence).append(string4);
                    String string5 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string5);
                    string5 = ((StringBuilder)charSequence).toString();
                    Log.e((String)string3, (String)string5);
                }
            }
            return string2;
        }
        Log.e((String)string3, (String)"archiveFilePath is null or context is null");
        return string2;
    }

    public static byte[] h(Context signature, String charSequence) {
        int n10;
        String string2 = a;
        if (signature != null && (n10 = TextUtils.isEmpty((CharSequence)charSequence)) == 0) {
            block8: {
                block9: {
                    signature = signature.getPackageManager();
                    if (signature == null) break block8;
                    n10 = 64;
                    signature = signature.getPackageArchiveInfo((String)charSequence, n10);
                    if (signature == null) break block9;
                    signature = signature.signatures;
                    signature = signature[0];
                    return signature.toByteArray();
                }
                signature = "PackageInfo is null ";
                try {
                    Log.e((String)string2, (String)signature);
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    String string3 = "Exception : ";
                    ((StringBuilder)charSequence).append(string3);
                    String string4 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string4);
                    string4 = ((StringBuilder)charSequence).toString();
                    boolean bl2 = true;
                    LogsUtil.q(string2, string4, bl2);
                }
            }
            return new byte[0];
        }
        Log.e((String)string2, (String)"archiveFilePath is null or context is null");
        return new byte[0];
    }

    public static String i(Context object, String string2) {
        int n10;
        object = (object = (Object)d.j.f.a.a.i.a.h(object, string2)) != null && (n10 = ((Context)object).length) > 0 ? d.j.f.a.a.i.a.a((byte[])object) : "";
        return object;
    }
}

