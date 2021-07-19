/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a;

import java.io.IOException;

public class a
extends IOException {
    public a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        super(string2);
    }
}

