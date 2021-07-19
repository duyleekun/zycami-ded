/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.b;

public class d
extends com.huawei.updatesdk.a.b.c.c.d {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getName();
        stringBuilder.append(string2);
        stringBuilder.append(" {\n\tresponseCode: ");
        int n10 = this.d();
        stringBuilder.append(n10);
        stringBuilder.append("\n\trtnCode_: ");
        n10 = this.e();
        stringBuilder.append(n10);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}

