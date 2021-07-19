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
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.bj;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hk {
    private static volatile hk a;
    private final Context a;
    private Map a;

    private hk(Context context) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static hk a(Context context) {
        if (context == null) {
            b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        Object object = a;
        if (object != null) return a;
        object = hk.class;
        synchronized (object) {
            hk hk2 = a;
            if (hk2 != null) return a;
            a = hk2 = new hk(context);
            return a;
        }
    }

    private boolean a(String string2, String string3, String string4, String string5, long l10, String string6) {
        hq hq2 = new hq();
        hq2.d(string4);
        hq2.c(string5);
        hq2.a(l10);
        hq2.b(string6);
        hq2.a(true);
        hq2.a("push_sdk_channel");
        hq2.e(string3);
        return this.a(hq2, string2);
    }

    public hl a() {
        Object object = this.a;
        String string2 = "UPLOADER_PUSH_CHANNEL";
        if ((object = (hl)object.get(string2)) != null) {
            return object;
        }
        object = this.a;
        string2 = "UPLOADER_HTTP";
        if ((object = (hl)object.get(string2)) != null) {
            return object;
        }
        return null;
    }

    public Map a() {
        return this.a;
    }

    public void a(hl hl2, String string2) {
        if (hl2 == null) {
            b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
            return;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            b.d("[TinyDataManager]: can not add a provider from unkown resource.");
            return;
        }
        this.a().put(string2, hl2);
    }

    public boolean a(hq hq2, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            b.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        bl2 = bi.a(hq2, false);
        if (bl2) {
            return false;
        }
        String string3 = hq2.d();
        bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            string3 = bi.a();
            hq2.f(string3);
        }
        hq2.g(string2);
        bj.a(this.a, hq2);
        return true;
    }

    public boolean a(String string2, String string3, long l10, String string4) {
        String string5 = this.a.getPackageName();
        String string6 = this.a.getPackageName();
        return this.a(string5, string6, string2, string3, l10, string4);
    }
}

