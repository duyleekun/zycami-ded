/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.voice;

import d.v.h.i.a.a$a;
import d.v.v.o.a.b;
import d.v.v.q.h;
import m.a.a;

public class AudioWaveUseCase {
    private final d.v.h.i.a.a a;
    private a.a b;

    public AudioWaveUseCase() {
        b b10 = new b();
        this.a = b10;
    }

    public void a() {
        this.a.cancel();
    }

    public boolean b(String string2, long l10, long l11, int n10) {
        AudioWaveUseCase audioWaveUseCase = this;
        Object object = string2;
        boolean bl2 = d.v.j.b.b(string2);
        boolean bl3 = true;
        d.v.h.i.a.a a10 = null;
        if (bl2) {
            Object[] objectArray = new Object[bl3];
            objectArray[0] = string2;
            m.a.a.i("\u6587\u4ef6\u4e0d\u5b58\u5728,%s", objectArray);
            return false;
        }
        long l12 = h.C(string2);
        bl2 = d.v.j.b.j(l10, l11, l12);
        if (bl2) {
            Object[] objectArray = new Object[4];
            objectArray[0] = string2;
            objectArray[bl3] = object = Long.valueOf(l10);
            Long l13 = l11;
            objectArray[2] = l13;
            l13 = l12;
            objectArray[3] = l13;
            m.a.a.i("\u6587\u4ef6\u4fe1\u606f\u4e0d\u5408\u6cd5\u6216\u53c2\u6570\u6709\u95ee\u9898,music path:%s,startTime:%d,endTime:%d,duration:%d", objectArray);
            return false;
        }
        a.a a11 = this.b;
        if (a11 != null) {
            a10 = this.a;
            a10.c(a11);
        }
        audioWaveUseCase.a.a(string2);
        audioWaveUseCase.a.b(l10, l11, n10);
        return bl3;
    }

    public void c() {
        this.a.release();
    }

    public void d(a.a a10) {
        this.b = a10;
    }
}

