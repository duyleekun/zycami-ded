/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.system.Os
 *  android.system.StructStat
 */
package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import android.system.StructStat;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class ch {
    public static long a(String string2) {
        long l10;
        block6: {
            int n10 = Build.VERSION.SDK_INT;
            l10 = 0L;
            int n11 = 21;
            if (n10 >= n11) {
                File file = new File(string2);
                n10 = (int)(file.exists() ? 1 : 0);
                if (n10 == 0) break block6;
                string2 = Os.stat((String)string2);
                try {
                    long l11;
                    l10 = l11 = ((StructStat)string2).st_size;
                }
                catch (Exception exception) {
                    b.a(exception);
                }
            }
        }
        return l10;
    }
}

