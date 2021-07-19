/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.jc;
import com.xiaomi.push.je;
import com.xiaomi.push.jg;
import com.xiaomi.push.jh;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jm;
import com.xiaomi.push.js;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class jo
extends je {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = 0xA00000;
    private static int f = 0x6400000;

    public jo(js js2, boolean bl2, boolean bl3) {
        super(js2, bl2, bl3);
    }

    public jg a() {
        int n10;
        byte by2 = this.a();
        int n11 = this.a();
        if (n11 <= (n10 = c)) {
            jg jg2 = new jg(by2, n11);
            return jg2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thrift list size ");
        stringBuilder.append(n11);
        stringBuilder.append(" out of range!");
        String string2 = stringBuilder.toString();
        jj jj2 = new jj(3, string2);
        throw jj2;
    }

    public jh a() {
        int n10;
        byte by2 = this.a();
        byte by3 = this.a();
        int n11 = this.a();
        if (n11 <= (n10 = b)) {
            jh jh2 = new jh(by2, by3, n11);
            return jh2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thrift map size ");
        stringBuilder.append(n11);
        stringBuilder.append(" out of range!");
        String string2 = stringBuilder.toString();
        jj jj2 = new jj(3, string2);
        throw jj2;
    }

    public jm a() {
        int n10;
        byte by2 = this.a();
        int n11 = this.a();
        if (n11 <= (n10 = d)) {
            jm jm2 = new jm(by2, n11);
            return jm2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thrift set size ");
        stringBuilder.append(n11);
        stringBuilder.append(" out of range!");
        String string2 = stringBuilder.toString();
        jj jj2 = new jj(3, string2);
        throw jj2;
    }

    public String a() {
        int n10;
        int n11 = this.a();
        if (n11 <= (n10 = e)) {
            Object object = ((ji)this).a;
            n10 = ((js)object).b();
            if (n10 >= n11) {
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
                object = new String((byte[])object2, n12, n11, string2);
                object2 = ((ji)this).a;
                ((js)object2).a(n11);
                return object;
            }
            return this.a(n11);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thrift string size ");
        stringBuilder.append(n11);
        stringBuilder.append(" out of range!");
        String string3 = stringBuilder.toString();
        jj jj2 = new jj(3, string3);
        throw jj2;
    }

    public ByteBuffer a() {
        int n10;
        int n11 = this.a();
        if (n11 <= (n10 = f)) {
            this.c(n11);
            Object object = ((ji)this).a;
            n10 = ((js)object).b();
            if (n10 >= n11) {
                object = ((ji)this).a.a();
                int n12 = ((ji)this).a.a();
                object = ByteBuffer.wrap((byte[])object, n12, n11);
                ((ji)this).a.a(n11);
                return object;
            }
            object = new byte[n11];
            ((ji)this).a.b((byte[])object, 0, n11);
            return ByteBuffer.wrap((byte[])object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thrift binary size ");
        stringBuilder.append(n11);
        stringBuilder.append(" out of range!");
        String string2 = stringBuilder.toString();
        jj jj2 = new jj(3, string2);
        throw jj2;
    }
}

