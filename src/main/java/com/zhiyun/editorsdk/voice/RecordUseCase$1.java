/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.voice;

import com.zhiyun.editorsdk.voice.RecordUseCase;
import d.v.h.h.a$a;

public class RecordUseCase$1
implements a$a {
    public final /* synthetic */ a$a a;
    public final /* synthetic */ RecordUseCase b;

    public RecordUseCase$1(RecordUseCase recordUseCase, a$a a$a) {
        this.b = recordUseCase;
        this.a = a$a;
    }

    public void a(short[] sArray) {
        a$a a$a = this.a;
        if (a$a != null) {
            a$a.a(sArray);
        }
    }

    public void b(Exception exception, String string2) {
        a$a a$a = this.a;
        if (a$a != null) {
            a$a.b(exception, string2);
        }
    }

    public void c(long l10) {
        a$a a$a = this.a;
        if (a$a != null) {
            a$a.c(l10);
        }
    }

    public void d(long l10) {
        a$a a$a = this.a;
        if (a$a != null) {
            a$a.d(l10);
        }
    }

    public void e() {
        this.b.a(true);
    }
}

