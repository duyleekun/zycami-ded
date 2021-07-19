/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.i;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.bg$a;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.w;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class x
extends bg$a {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ k a;

    public x(String string2, long l10, XMPushService xMPushService, k k10) {
        this.a = xMPushService;
        this.a = k10;
        super(string2, l10);
    }

    public void a(bg object) {
        boolean bl2;
        Object object2 = "GAID";
        String string2 = "gaid";
        Object object3 = ((bg)object).a((String)object2, string2);
        String string3 = i.b((Context)this.a);
        CharSequence charSequence = new StringBuilder();
        String string4 = "gaid :";
        charSequence.append(string4);
        charSequence.append(string3);
        charSequence = charSequence.toString();
        b.c((String)charSequence);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3 && !(bl2 = TextUtils.equals((CharSequence)object3, (CharSequence)string3))) {
            ((bg)object).a((String)object2, string2, string3);
            object = new il();
            object2 = this.a.d;
            ((il)object).b((String)object2);
            object2 = hw.g.a;
            ((il)object).c((String)object2);
            object2 = an.a();
            ((il)object).a((String)object2);
            object2 = new HashMap();
            ((il)object).a((Map)object2);
            ((il)object).a().put(string2, string3);
            object2 = this.a.getPackageName();
            string2 = this.a.d;
            object3 = hm.i;
            object = iw.a(w.a((String)object2, string2, (ix)object, (hm)((Object)object3)));
            object2 = this.a;
            string2 = object2.getPackageName();
            bl2 = true;
            ((XMPushService)object2).a(string2, (byte[])object, bl2);
        }
    }
}

