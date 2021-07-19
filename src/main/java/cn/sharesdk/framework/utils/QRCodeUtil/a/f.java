/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.framework.utils.QRCodeUtil.a.b
 */
package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.a.b;
import cn.sharesdk.framework.utils.QRCodeUtil.i;
import cn.sharesdk.framework.utils.QRCodeUtil.n;

public final class f {
    private i a;
    private cn.sharesdk.framework.utils.QRCodeUtil.f b;
    private n c;
    private int d = -1;
    private b e;

    public static boolean b(int n10) {
        int n11;
        n10 = n10 >= 0 && n10 < (n11 = 8) ? 1 : 0;
        return n10 != 0;
    }

    public b a() {
        return this.e;
    }

    public void a(int n10) {
        this.d = n10;
    }

    public void a(b b10) {
        this.e = b10;
    }

    public void a(cn.sharesdk.framework.utils.QRCodeUtil.f f10) {
        this.b = f10;
    }

    public void a(i i10) {
        this.a = i10;
    }

    public void a(n n10) {
        this.c = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append("\n ecLevel: ");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append("\n version: ");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append("\n maskPattern: ");
        int n10 = this.d;
        stringBuilder.append(n10);
        object = this.e;
        if (object == null) {
            object = "\n matrix: null\n";
            stringBuilder.append((String)object);
        } else {
            stringBuilder.append("\n matrix:\n");
            object = this.e;
            stringBuilder.append(object);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}

