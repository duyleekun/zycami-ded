/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.decoration;

import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.decoration.TextUseCase;
import d.v.h.e.e;

public class TextUseCase$1
implements e {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ e b;
    public final /* synthetic */ TextUseCase c;

    public TextUseCase$1(TextUseCase textUseCase, boolean bl2, e e10) {
        this.c = textUseCase;
        this.a = bl2;
        this.b = e10;
    }

    public void a() {
        Object object = this.c;
        boolean bl2 = this.a;
        long l10 = 0x200000L;
        ((CallChangeUseCase)object).b(bl2, l10);
        object = this.b;
        if (object != null) {
            object.a();
        }
    }

    public void b() {
        Object object = this.c;
        boolean bl2 = this.a;
        long l10 = 0x200000L;
        ((CallChangeUseCase)object).b(bl2, l10);
        object = this.b;
        if (object != null) {
            object.b();
        }
    }
}

