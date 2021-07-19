/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.hl;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.j;
import java.util.List;

public class i
implements hl {
    private final XMPushService a;

    public i(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public static /* synthetic */ XMPushService a(i i10) {
        return i10.a;
    }

    public static /* synthetic */ String a(i i10, String string2) {
        return i10.a(string2);
    }

    private String a(String string2) {
        Object object = "com.xiaomi.xmsf";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            string2 = "1000271";
        } else {
            object = this.a;
            String string3 = "pref_registered_pkg_names";
            object = object.getSharedPreferences(string3, 0);
            string2 = object.getString(string2, null);
        }
        return string2;
    }

    public void a(List list, String string2, String string3) {
        XMPushService xMPushService = this.a;
        j j10 = new j(this, 4, string2, list, string3);
        xMPushService.a(j10);
    }
}

