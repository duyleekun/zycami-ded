/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ix;
import com.xiaomi.push.je$a;
import com.xiaomi.push.ji;
import com.xiaomi.push.jk;
import com.xiaomi.push.jp;
import java.io.ByteArrayOutputStream;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class jd {
    private ji a;
    private final jp a;
    private final ByteArrayOutputStream a;

    public jd() {
        je$a je$a = new je$a();
        this(je$a);
    }

    public jd(jk object) {
        jp jp2;
        ByteArrayOutputStream byteArrayOutputStream;
        this.a = byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = jp2 = new jp(byteArrayOutputStream);
        this.a = object = object.a(jp2);
    }

    public byte[] a(ix ix2) {
        this.a.reset();
        ji ji2 = this.a;
        ix2.b(ji2);
        return this.a.toByteArray();
    }
}

