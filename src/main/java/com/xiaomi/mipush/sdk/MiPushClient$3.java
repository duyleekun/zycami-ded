/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.au;
import com.xiaomi.push.bf;
import com.xiaomi.push.hm;
import com.xiaomi.push.i;
import com.xiaomi.push.il;
import com.xiaomi.push.ix;
import com.xiaomi.push.l;
import com.xiaomi.push.service.an;
import java.util.HashMap;
import java.util.Map;

public final class MiPushClient$3
implements Runnable {
    public void run() {
        Object object;
        boolean bl2 = l.d();
        if (!bl2 && ((object = i.f(MiPushClient.access$000())) != null || (bl2 = ((au)(object = au.a(MiPushClient.access$000()))).a()))) {
            boolean bl3;
            CharSequence charSequence;
            object = new il();
            Object object2 = b.a(MiPushClient.access$000()).a();
            ((il)object).b((String)object2);
            ((il)object).c("client_info_update");
            object2 = an.a();
            ((il)object).a((String)object2);
            object2 = new HashMap();
            ((il)object).a((Map)object2);
            object2 = "";
            Object object3 = i.f(MiPushClient.access$000());
            boolean bl4 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl4) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                object2 = bf.a((String)object3);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
            }
            object3 = i.h(MiPushClient.access$000());
            bl4 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl4 && !(bl4 = TextUtils.isEmpty((CharSequence)object3))) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(",");
                ((StringBuilder)charSequence).append((String)object3);
                object2 = ((StringBuilder)charSequence).toString();
            }
            if (!(bl3 = TextUtils.isEmpty((CharSequence)object2))) {
                object3 = ((il)object).a();
                charSequence = "imei_md5";
                object3.put(charSequence, object2);
            }
            object2 = au.a(MiPushClient.access$000());
            object3 = ((il)object).a();
            ((au)object2).a((Map)object3);
            int n10 = i.a();
            if (n10 >= 0) {
                object3 = ((il)object).a();
                object2 = Integer.toString(n10);
                charSequence = "space_id";
                object3.put(charSequence, object2);
            }
            object2 = aq.a(MiPushClient.access$000());
            object3 = hm.i;
            bl4 = false;
            charSequence = null;
            ((aq)object2).a((ix)object, (hm)((Object)object3), false, null);
        }
    }
}

