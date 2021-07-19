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
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.aw;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.au;
import com.xiaomi.push.bf;
import com.xiaomi.push.g;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.i;
import com.xiaomi.push.il;
import com.xiaomi.push.l;
import com.xiaomi.push.n;
import com.xiaomi.push.service.an;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ax
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ boolean a;

    public ax(Context context, boolean bl2) {
        this.a = context;
        this.a = bl2;
    }

    public void run() {
        CharSequence charSequence;
        com.xiaomi.channel.commonutils.logger.b.a("do sync info");
        Object object = an.a();
        il il2 = new il((String)object, false);
        object = b.a(this.a);
        Object object2 = hw.v.a;
        il2.c((String)object2);
        object2 = ((b)object).a();
        il2.b((String)object2);
        object2 = this.a.getPackageName();
        il2.d((String)object2);
        object2 = new HashMap();
        il2.a = object2;
        Object object3 = this.a;
        Object object4 = object3.getPackageName();
        object3 = g.a(object3, (String)object4);
        n.a(object2, "app_version", (String)object3);
        object2 = il2.a;
        object3 = this.a;
        object4 = object3.getPackageName();
        object3 = Integer.toString(g.a(object3, (String)object4));
        n.a(object2, "app_version_code", (String)object3);
        n.a(il2.a, "push_sdk_vn", "3_7_5");
        object2 = il2.a;
        int n10 = 30705;
        object3 = Integer.toString(n10);
        n.a(object2, "push_sdk_vc", (String)object3);
        object2 = il2.a;
        object3 = ((b)object).b();
        object4 = "token";
        n.a(object2, (String)object4, (String)object3);
        boolean bl2 = l.d();
        object3 = ",";
        if (!bl2) {
            boolean bl3;
            object2 = bf.a(i.f(this.a));
            object4 = i.h(this.a);
            boolean bl4 = TextUtils.isEmpty((CharSequence)object4);
            if (!bl4) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append((String)object3);
                ((StringBuilder)charSequence).append((String)object4);
                object2 = ((StringBuilder)charSequence).toString();
            }
            if (!(bl3 = TextUtils.isEmpty((CharSequence)object2))) {
                object4 = il2.a;
                charSequence = "imei_md5";
                n.a((Map)object4, (String)charSequence, (String)object2);
            }
        }
        object2 = au.a(this.a);
        object4 = il2.a;
        ((au)object2).a((Map)object4);
        object2 = il2.a;
        object4 = ((b)object).c();
        charSequence = "reg_id";
        n.a((Map)object2, (String)charSequence, (String)object4);
        object2 = il2.a;
        object = ((b)object).d();
        object4 = "reg_secret";
        n.a((Map)object2, (String)object4, (String)object);
        object = MiPushClient.getAcceptTime(this.a).replace((CharSequence)object3, "-");
        object2 = il2.a;
        object3 = "accept_time";
        n.a((Map)object2, (String)object3, (String)object);
        boolean bl5 = this.a;
        if (bl5) {
            object = il2.a;
            object2 = aw.a(MiPushClient.getAllAlias(this.a));
            n.a((Map)object, "aliases_md5", (String)object2);
            object = il2.a;
            object2 = aw.a(MiPushClient.getAllTopic(this.a));
            n.a((Map)object, "topics_md5", (String)object2);
            object = il2.a;
            object2 = aw.a(MiPushClient.getAllUserAccount(this.a));
            object3 = "accounts_md5";
        } else {
            object = il2.a;
            object2 = aw.b(MiPushClient.getAllAlias(this.a));
            n.a((Map)object, "aliases", (String)object2);
            object = il2.a;
            object2 = aw.b(MiPushClient.getAllTopic(this.a));
            n.a((Map)object, "topics", (String)object2);
            object = il2.a;
            object2 = aw.b(MiPushClient.getAllUserAccount(this.a));
            object3 = "user_accounts";
        }
        n.a((Map)object, (String)object3, (String)object2);
        object = aq.a(this.a);
        object2 = hm.i;
        ((aq)object).a(il2, (hm)((Object)object2), false, null);
    }
}

