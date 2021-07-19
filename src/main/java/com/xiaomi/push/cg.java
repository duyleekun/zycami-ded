/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bp;
import com.xiaomi.push.hq;
import java.text.SimpleDateFormat;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cg {
    private static String a;
    private static SimpleDateFormat a;

    static {
        SimpleDateFormat simpleDateFormat;
        a = simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Long l10 = System.currentTimeMillis();
        a = simpleDateFormat.format(l10);
    }

    public static hq a(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        hq hq2 = new hq();
        hq2.d("category_push_stat");
        hq2.a("push_sdk_stat_channel");
        hq2.a(1L);
        hq2.b(string2);
        hq2.a(true);
        long l10 = System.currentTimeMillis();
        hq2.b(l10);
        object = bp.a(object).a();
        hq2.g((String)object);
        hq2.e("com.xiaomi.xmsf");
        hq2.f("");
        hq2.c("push_stat");
        return hq2;
    }
}

