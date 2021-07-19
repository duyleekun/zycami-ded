/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Process
 *  android.provider.Settings$Secure
 *  android.provider.Settings$System
 *  android.text.TextUtils
 */
package com.baidu.android.bbalbs.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public final class d {
    public static String a(Context context) {
        return Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
    }

    public static String a(Context context, String string2) {
        try {
            context = context.getContentResolver();
        }
        catch (Exception exception) {
            d.a(exception);
            return null;
        }
        return Settings.System.getString((ContentResolver)context, (String)string2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(File object) {
        void var0_6;
        InputStreamReader inputStreamReader;
        block15: {
            FileReader fileReader;
            block14: {
                int n10;
                inputStreamReader = null;
                fileReader = new FileReader((File)object);
                int n11 = 8192;
                object = new char[n11];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while ((n10 = fileReader.read((char[])object)) > 0) {
                    charArrayWriter.write((char[])object, 0, n10);
                }
                object = charArrayWriter.toString();
                try {
                    fileReader.close();
                    return object;
                }
                catch (Exception exception) {
                    d.a(exception);
                }
                return object;
                catch (Exception exception) {
                    break block14;
                }
                catch (Throwable throwable) {
                    break block15;
                }
                catch (Exception exception) {
                    fileReader = null;
                }
            }
            d.a((Throwable)object);
            if (fileReader == null) return null;
            try {
                fileReader.close();
                return null;
            }
            catch (Exception exception) {
                d.a(exception);
            }
            return null;
            catch (Throwable throwable) {
                inputStreamReader = fileReader;
            }
        }
        if (inputStreamReader == null) throw var0_6;
        try {
            inputStreamReader.close();
            throw var0_6;
        }
        catch (Exception exception) {
            d.a(exception);
        }
        throw var0_6;
    }

    public static void a(Throwable throwable) {
    }

    public static boolean a(Context context, String string2, String string3) {
        try {
            context = context.getContentResolver();
        }
        catch (Exception exception) {
            d.a(exception);
            return false;
        }
        return Settings.System.putString((ContentResolver)context, (String)string2, (String)string3);
    }

    public static boolean a(String string2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && n10 != 0) {
            return string2.matches("^[a-zA-Z0-9]{1,5}$");
        }
        return false;
    }

    public static boolean b(Context context) {
        return d.b(context, "android.permission.WRITE_SETTINGS");
    }

    public static boolean b(Context context, String string2) {
        int n10;
        boolean bl2 = false;
        if (context == null) {
            return false;
        }
        int n11 = Process.myPid();
        int n12 = context.checkPermission(string2, n11, n10 = Process.myUid());
        if (n12 == 0) {
            bl2 = true;
        }
        return bl2;
    }
}

