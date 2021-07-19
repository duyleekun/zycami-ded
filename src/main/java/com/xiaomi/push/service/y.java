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
import com.xiaomi.push.au;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
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
public final class y
extends bg$a {
    public final /* synthetic */ XMPushService a;
    public final /* synthetic */ k a;

    public y(String string2, long l10, XMPushService xMPushService, k k10) {
        this.a = xMPushService;
        this.a = k10;
        super(string2, l10);
    }

    public void a(bg object) {
        boolean bl2;
        Object object2 = au.a((Context)this.a);
        Object object3 = "MSAID";
        Object object4 = "msaid";
        String string2 = ((bg)object).a((String)object3, (String)object4);
        CharSequence charSequence = new StringBuilder();
        String string3 = ((au)object2).a();
        charSequence.append(string3);
        string3 = ((au)object2).b();
        charSequence.append(string3);
        string3 = ((au)object2).c();
        charSequence.append(string3);
        string3 = ((au)object2).d();
        charSequence.append(string3);
        charSequence = charSequence.toString();
        boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl3 && !(bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)charSequence))) {
            ((bg)object).a((String)object3, (String)object4, (String)charSequence);
            object = new il();
            object3 = this.a.d;
            ((il)object).b((String)object3);
            object3 = hw.g.a;
            ((il)object).c((String)object3);
            object3 = an.a();
            ((il)object).a((String)object3);
            object3 = new HashMap();
            ((il)object).a((Map)object3);
            object3 = ((il)object).a();
            ((au)object2).a((Map)object3);
            object2 = this.a.getPackageName();
            object3 = this.a.d;
            object4 = hm.i;
            object = iw.a(w.a((String)object2, (String)object3, (ix)object, (hm)((Object)object4)));
            object2 = this.a;
            object3 = object2.getPackageName();
            boolean bl4 = true;
            ((XMPushService)object2).a((String)object3, (byte[])object, bl4);
        }
    }
}

