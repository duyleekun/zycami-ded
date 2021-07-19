/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiTinyDataClient$a;
import com.xiaomi.push.hq;

public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static void init(Context context, String string2) {
        if (context == null) {
            b.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        MiTinyDataClient$a miTinyDataClient$a = MiTinyDataClient$a.a();
        miTinyDataClient$a.a(context);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            b.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        MiTinyDataClient$a.a().a(string2);
    }

    public static boolean upload(Context context, hq hq2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("MiTinyDataClient.upload ");
        String string2 = hq2.d();
        ((StringBuilder)object).append(string2);
        b.c(((StringBuilder)object).toString());
        object = MiTinyDataClient$a.a();
        boolean bl2 = ((MiTinyDataClient$a)object).a();
        if (!bl2) {
            object = MiTinyDataClient$a.a();
            ((MiTinyDataClient$a)object).a(context);
        }
        return MiTinyDataClient$a.a().a(hq2);
    }

    public static boolean upload(Context context, String string2, String string3, long l10, String string4) {
        hq hq2 = new hq();
        hq2.d(string2);
        hq2.c(string3);
        hq2.a(l10);
        hq2.b(string4);
        hq2.a(true);
        hq2.a("push_sdk_channel");
        return MiTinyDataClient.upload(context, hq2);
    }

    public static boolean upload(String string2, String string3, long l10, String string4) {
        hq hq2 = new hq();
        hq2.d(string2);
        hq2.c(string3);
        hq2.a(l10);
        hq2.b(string4);
        return MiTinyDataClient$a.a().a(hq2);
    }
}

