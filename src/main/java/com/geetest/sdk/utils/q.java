/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import java.security.SecureRandom;

public final class q {
    public static String a() {
        return q.a(16);
    }

    public static String a(int n10) {
        StringBuffer stringBuffer = new StringBuffer();
        SecureRandom secureRandom = new SecureRandom();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = secureRandom.nextInt(36);
            String string2 = "0123456789abcdefghijklmnopqrstuvwxyz";
            c10 = string2.charAt(c10);
            stringBuffer.append(c10);
        }
        return stringBuffer.toString();
    }
}

