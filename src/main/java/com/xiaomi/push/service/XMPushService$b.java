/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$b
extends XMPushService$i {
    private final ap$b a;

    public XMPushService$b(ap$b ap$b) {
        super(12);
        this.a = ap$b;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bind time out. chid=");
        String string2 = this.a.g;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void a() {
        ap$b ap$b = this.a;
        ap$c ap$c = ap$c.a;
        ap$b.a(ap$c, 1, 21, null, null);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof XMPushService$b;
        if (!bl2) {
            return false;
        }
        object = ((XMPushService$b)object).a.g;
        String string2 = this.a.g;
        return TextUtils.equals((CharSequence)object, (CharSequence)string2);
    }

    public int hashCode() {
        return this.a.g.hashCode();
    }
}

