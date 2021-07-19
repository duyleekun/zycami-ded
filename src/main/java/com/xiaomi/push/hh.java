/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hr;
import com.xiaomi.push.i;
import com.xiaomi.push.service.XMPushService$l;
import com.xiaomi.push.service.ak;
import java.io.File;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hh
implements XMPushService$l {
    private static boolean a = false;
    private int a;
    private Context a;
    private boolean b;

    public hh(Context context) {
        this.a = context;
    }

    private String a(String string2) {
        String string3 = "com.xiaomi.xmsf";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            string2 = "1000271";
        } else {
            string3 = this.a;
            String string4 = "pref_registered_pkg_names";
            string3 = string3.getSharedPreferences(string4, 0);
            string2 = string3.getString(string2, null);
        }
        return string2;
    }

    private void a(Context object) {
        int n10;
        int n11;
        ak ak2 = ak.a((Context)object);
        int n12 = hr.ak.a();
        this.b = n11 = ak2.a(n12, true);
        object = ak.a((Context)object);
        n11 = hr.al.a();
        this.a = n10 = ((ak)object).a(n11, 7200);
        this.a = n10 = Math.max(60, n10);
    }

    public static void a(boolean bl2) {
        a = bl2;
    }

    private boolean a() {
        int n10;
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("mipush_extra", 4);
        String string2 = "last_tiny_data_upload_timestamp";
        long l10 = sharedPreferences.getLong(string2, (long)-1);
        long l11 = System.currentTimeMillis();
        long l12 = 1000L;
        long l13 = (l10 = Math.abs(l11 / l12 - l10)) - (l11 = (long)(n10 = this.a));
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            object = 1;
        } else {
            object = 0;
            sharedPreferences = null;
        }
        return (boolean)object;
    }

    private boolean a(hl object) {
        String string2;
        Object object2 = this.a;
        int n10 = az.b((Context)object2);
        if (n10 == 0) {
            return false;
        }
        if (object == null) {
            return false;
        }
        object = this.a.getPackageName();
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = this.a((String)object)));
        if (bl2) {
            return false;
        }
        object2 = this.a.getFilesDir();
        object = new File((File)object2, string2 = "tiny_data.data");
        bl2 = ((File)object).exists();
        if (!bl2) {
            return false;
        }
        bl2 = a;
        if (bl2) {
            return false;
        }
        object = ak.a(this.a);
        bl2 = ((ak)object).a(n10 = ((hr)((Object)(object2 = hr.aV))).a(), false);
        return !bl2 || (bl2 = i.a((Context)(object = this.a))) || (bl2 = i.b((Context)(object = this.a)));
    }

    public void a() {
        Object object = this.a;
        this.a((Context)object);
        boolean bl2 = this.b;
        if (bl2 && (bl2 = this.a())) {
            object = new StringBuilder();
            String string2 = "TinyData TinyDataCacheProcessor.pingFollowUpAction ts:";
            ((StringBuilder)object).append(string2);
            long l10 = System.currentTimeMillis();
            ((StringBuilder)object).append(l10);
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
            object = hk.a(this.a).a();
            boolean bl3 = this.a((hl)object);
            if (!bl3) {
                object = new StringBuilder();
                ((StringBuilder)object).append("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:");
                l10 = System.currentTimeMillis();
                ((StringBuilder)object).append(l10);
                com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
                return;
            }
            a = bl3 = true;
            string2 = this.a;
            hi.a((Context)string2, (hl)object);
        }
    }
}

