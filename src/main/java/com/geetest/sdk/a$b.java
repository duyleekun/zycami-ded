/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.a;
import com.geetest.sdk.am;
import com.geetest.sdk.utils.l;

public class a$b
implements am {
    public a$b(a a10) {
    }

    public void a(int n10, byte[] object) {
        String string2 = object != null ? new String((byte[])object) : "";
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("\u65e5\u5fd7\u4e0a\u4f20\u7ed3\u679c, http\u72b6\u6001\u7801: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", \u8be6\u7ec6: ");
        ((StringBuilder)object).append(string2);
        String string3 = ((StringBuilder)object).toString();
        l.d("GeeLogger", string3);
    }
}

