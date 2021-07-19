/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.a;
import com.geetest.sdk.aj;
import com.geetest.sdk.utils.l;

public class a$a
implements aj {
    public a$a(a a10) {
    }

    public void a(String string2, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cgeelogger > cmd : ");
        stringBuilder.append(string2);
        stringBuilder.append(" | code : ");
        stringBuilder.append(n10);
        string2 = stringBuilder.toString();
        l.d("GeeLogger", string2);
    }
}

