/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.os.StatFs
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aa {
    public static long a() {
        String string2;
        boolean bl2;
        int n10 = aa.b();
        long l10 = 0L;
        if (n10 != 0) {
            return l10;
        }
        Object object = Environment.getExternalStorageDirectory();
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((File)object).getPath())))) {
            try {
                object = ((File)object).getPath();
            }
            catch (Throwable throwable) {}
            string2 = new StatFs((String)object);
            n10 = string2.getBlockSize();
            long l11 = n10;
            long l12 = (long)string2.getAvailableBlocks() - (long)4;
            return l11 * l12;
        }
        return l10;
    }

    public static boolean a() {
        String string2;
        String string3;
        try {
            string3 = Environment.getExternalStorageState();
            string2 = "removed";
        }
        catch (Exception exception) {
            b.a(exception);
            return true;
        }
        return string3.equals(string2);
    }

    public static boolean b() {
        String string2;
        String string3;
        boolean bl2 = true;
        try {
            string3 = Environment.getExternalStorageState();
            string2 = "mounted";
        }
        catch (Exception exception) {
            b.a(exception);
            return bl2;
        }
        boolean bl3 = string3.equals(string2);
        return bl2 ^ bl3;
    }

    public static boolean c() {
        long l10;
        long l11 = aa.a();
        long l12 = l11 - (l10 = 102400L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static boolean d() {
        boolean bl2 = aa.b();
        bl2 = !bl2 && !(bl2 = aa.c()) && !(bl2 = aa.a());
        return bl2;
    }
}

