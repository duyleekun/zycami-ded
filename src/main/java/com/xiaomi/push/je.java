/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.jc;
import com.xiaomi.push.jf;
import com.xiaomi.push.jg;
import com.xiaomi.push.jh;
import com.xiaomi.push.ji;
import com.xiaomi.push.jm;
import com.xiaomi.push.jn;
import com.xiaomi.push.js;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class je
extends ji {
    private static final jn a;
    public int a;
    public boolean a;
    private byte[] a = false;
    public boolean b;
    private byte[] b;
    public boolean c;
    private byte[] c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    static {
        jn jn2;
        a = jn2 = new jn();
    }

    public je(js object, boolean bl2, boolean bl3) {
        super((js)object);
        int n10 = 1;
        this.b = n10;
        this.c = false;
        object = new byte[n10];
        this.a = (byte[])object;
        int n11 = 2;
        byte[] byArray = new byte[n11];
        this.b = byArray;
        int n12 = 4;
        byte[] byArray2 = new byte[n12];
        this.c = byArray2;
        int n13 = 8;
        byte[] byArray3 = new byte[n13];
        this.d = byArray3;
        byte[] byArray4 = new byte[n10];
        this.e = byArray4;
        object = new byte[n11];
        this.f = (byte[])object;
        object = new byte[n12];
        this.g = (byte[])object;
        object = new byte[n13];
        this.h = (byte[])object;
        this.a = bl2;
        this.b = bl3;
    }

    private int a(byte[] byArray, int n10, int n11) {
        this.c(n11);
        return ((ji)this).a.b(byArray, n10, n11);
    }

    public byte a() {
        int n10;
        Object object = ((ji)this).a;
        byte by2 = (byte)((js)object).b();
        if (by2 >= (n10 = 1)) {
            object = ((ji)this).a.a();
            int n11 = ((ji)this).a.a();
            by2 = (byte)object[n11];
            ((ji)this).a.a(n10);
            return by2;
        }
        object = this.e;
        this.a((byte[])object, 0, n10);
        return this.e[0];
    }

    public double a() {
        return Double.longBitsToDouble(this.a());
    }

    public int a() {
        byte[] byArray = this.g;
        Object object = ((ji)this).a;
        int n10 = ((js)object).b();
        int n11 = 0;
        int n12 = 4;
        if (n10 >= n12) {
            byArray = ((ji)this).a.a();
            n11 = ((ji)this).a.a();
            object = ((ji)this).a;
            ((js)object).a(n12);
        } else {
            object = this.g;
            this.a((byte[])object, 0, n12);
        }
        n10 = (byArray[n11] & 0xFF) << 24;
        n12 = n11 + 1;
        n12 = (byArray[n12] & 0xFF) << 16;
        n10 |= n12;
        n12 = n11 + 2;
        n12 = (byArray[n12] & 0xFF) << 8;
        return byArray[n11 += 3] & 0xFF | (n10 |= n12);
    }

    public long a() {
        byte[] byArray = this.h;
        Object object = ((ji)this).a;
        int n10 = ((js)object).b();
        int n11 = 0;
        int n12 = 8;
        if (n10 >= n12) {
            byArray = ((ji)this).a.a();
            n11 = ((ji)this).a.a();
            object = ((ji)this).a;
            ((js)object).a(n12);
        } else {
            object = this.h;
            this.a((byte[])object, 0, n12);
        }
        long l10 = (long)(byArray[n11] & 0xFF) << 56;
        n10 = n11 + 1;
        long l11 = (long)(byArray[n10] & 0xFF) << 48;
        l10 |= l11;
        n10 = n11 + 2;
        l11 = (long)(byArray[n10] & 0xFF) << 40;
        l10 |= l11;
        n10 = n11 + 3;
        l11 = (long)(byArray[n10] & 0xFF) << 32;
        l10 |= l11;
        n10 = n11 + 4;
        l11 = (long)(byArray[n10] & 0xFF) << 24;
        l10 |= l11;
        n10 = n11 + 5;
        l11 = (long)(byArray[n10] & 0xFF) << 16;
        l10 |= l11;
        n10 = n11 + 6;
        l11 = (long)(byArray[n10] & 0xFF) << n12;
        long l12 = l10 | l11;
        return (long)(byArray[n11 += 7] & 0xFF) | l12;
    }

    public jf a() {
        byte by2 = this.a();
        short s10 = by2 == 0 ? (short)0 : this.a();
        jf jf2 = new jf("", by2, s10);
        return jf2;
    }

    public jg a() {
        byte by2 = this.a();
        int n10 = this.a();
        jg jg2 = new jg(by2, n10);
        return jg2;
    }

    public jh a() {
        byte by2 = this.a();
        byte by3 = this.a();
        int n10 = this.a();
        jh jh2 = new jh(by2, by3, n10);
        return jh2;
    }

    public jm a() {
        byte by2 = this.a();
        int n10 = this.a();
        jm jm2 = new jm(by2, n10);
        return jm2;
    }

    public jn a() {
        return a;
    }

    public String a() {
        int n10 = this.a();
        Object object = ((ji)this).a;
        int n11 = ((js)object).b();
        if (n11 >= n10) {
            Object object2;
            try {
                object2 = ((ji)this).a;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                jc jc2 = new jc("JVM DOES NOT SUPPORT UTF-8");
                throw jc2;
            }
            object2 = ((js)object2).a();
            js js2 = ((ji)this).a;
            int n12 = js2.a();
            String string2 = "UTF-8";
            object = new String((byte[])object2, n12, n10, string2);
            object2 = ((ji)this).a;
            ((js)object2).a(n10);
            return object;
        }
        return this.a(n10);
    }

    public String a(int n10) {
        Object object;
        byte[] byArray;
        try {
            this.c(n10);
            byArray = new byte[n10];
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new jc("JVM DOES NOT SUPPORT UTF-8");
            throw object;
        }
        Object object2 = ((ji)this).a;
        ((js)object2).b(byArray, 0, n10);
        object2 = "UTF-8";
        object = new String(byArray, (String)object2);
        return object;
    }

    public ByteBuffer a() {
        int n10 = this.a();
        this.c(n10);
        Object object = ((ji)this).a;
        int n11 = ((js)object).b();
        if (n11 >= n10) {
            object = ((ji)this).a.a();
            int n12 = ((ji)this).a.a();
            object = ByteBuffer.wrap((byte[])object, n12, n10);
            ((ji)this).a.a(n10);
            return object;
        }
        object = new byte[n10];
        ((ji)this).a.b((byte[])object, 0, n10);
        return ByteBuffer.wrap((byte[])object);
    }

    public short a() {
        byte[] byArray = this.f;
        Object object = ((ji)this).a;
        int n10 = ((js)object).b();
        int n11 = 0;
        int n12 = 2;
        if (n10 >= n12) {
            byArray = ((ji)this).a.a();
            n11 = ((ji)this).a.a();
            object = ((ji)this).a;
            ((js)object).a(n12);
        } else {
            object = this.f;
            this.a((byte[])object, 0, n12);
        }
        n10 = (byArray[n11] & 0xFF) << 8;
        return (short)(byArray[++n11] & 0xFF | n10);
    }

    public void a() {
    }

    public void a(byte by2) {
        byte[] byArray = this.a;
        byArray[0] = by2;
        ((ji)this).a.a(byArray, 0, 1);
    }

    public void a(int n10) {
        byte by2;
        byte[] byArray = this.c;
        byArray[0] = by2 = (byte)(n10 >> 24 & 0xFF);
        byArray[1] = by2 = (byte)(n10 >> 16 & 0xFF);
        byArray[2] = by2 = (byte)(n10 >> 8 & 0xFF);
        byArray[3] = n10 = (int)((byte)(n10 & 0xFF));
        ((ji)this).a.a(byArray, 0, 4);
    }

    public void a(long l10) {
        byte by2;
        byte by3;
        int n10;
        byte[] byArray = this.d;
        long l11 = l10 >> 56;
        long l12 = 255L;
        byArray[0] = n10 = (int)((int)(l11 & l12));
        byArray[1] = n10 = (byte)(l10 >> 48 & l12);
        byArray[2] = n10 = (byte)(l10 >> 40 & l12);
        byArray[3] = n10 = (byte)(l10 >> 32 & l12);
        byArray[4] = n10 = (byte)(l10 >> 24 & l12);
        byArray[5] = n10 = (byte)(l10 >> 16 & l12);
        n10 = 8;
        byArray[6] = by3 = (byte)(l10 >> n10 & l12);
        byArray[7] = by2 = (byte)(l10 & l12);
        ((ji)this).a.a(byArray, 0, n10);
    }

    public void a(jf jf2) {
        byte by2 = jf2.a;
        this.a(by2);
        short s10 = jf2.a;
        this.a(s10);
    }

    public void a(jg jg2) {
        byte by2 = jg2.a;
        this.a(by2);
        int n10 = jg2.a;
        this.a(n10);
    }

    public void a(jh jh2) {
        byte by2 = jh2.a;
        this.a(by2);
        by2 = jh2.b;
        this.a(by2);
        int n10 = jh2.a;
        this.a(n10);
    }

    public void a(jn jn2) {
    }

    public void a(String object) {
        Object object2 = "UTF-8";
        try {
            object = ((String)object).getBytes((String)object2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new jc("JVM DOES NOT SUPPORT UTF-8");
            throw object;
        }
        int n10 = ((Object)object).length;
        this.a(n10);
        object2 = ((ji)this).a;
        int n11 = ((Object)object).length;
        ((js)object2).a((byte[])object, 0, n11);
    }

    public void a(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.limit();
        int n11 = byteBuffer.position();
        n10 -= n11;
        n11 = byteBuffer.arrayOffset();
        this.a(n10 -= n11);
        js js2 = ((ji)this).a;
        byte[] byArray = byteBuffer.array();
        int n12 = byteBuffer.position();
        int n13 = byteBuffer.arrayOffset();
        js2.a(byArray, n12 += n13, n10);
    }

    public void a(short s10) {
        byte by2;
        byte[] byArray = this.b;
        byArray[0] = by2 = (byte)(s10 >> 8 & 0xFF);
        byArray[1] = s10 = (short)((byte)(s10 & 0xFF));
        ((ji)this).a.a(byArray, 0, 2);
    }

    public void a(boolean bl2) {
        this.a((byte)(bl2 ? 1 : 0));
    }

    public boolean a() {
        byte by2;
        byte by3 = this.a();
        if (by3 != (by2 = 1)) {
            by2 = 0;
        }
        return by2 != 0;
    }

    public void b() {
    }

    public void b(int n10) {
        this.a = n10;
        this.c = true;
    }

    public void c() {
        this.a((byte)0);
    }

    public void c(int n10) {
        if (n10 >= 0) {
            int n11 = this.c;
            if (n11 != 0) {
                this.a = n11 = this.a - n10;
                if (n11 < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Message length exceeded: ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    jc jc2 = new jc(string2);
                    throw jc2;
                }
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative length: ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        jc jc3 = new jc(string3);
        throw jc3;
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}

