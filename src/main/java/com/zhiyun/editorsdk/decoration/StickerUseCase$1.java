/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.decoration;

import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.decoration.StickerUseCase;
import d.v.h.e.e;

public class StickerUseCase$1
implements e {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ e b;
    public final /* synthetic */ StickerUseCase c;

    public StickerUseCase$1(StickerUseCase stickerUseCase, boolean bl2, e e10) {
        this.c = stickerUseCase;
        this.a = bl2;
        this.b = e10;
    }

    public void a() {
        Object object = this.c;
        boolean bl2 = this.a;
        ((CallChangeUseCase)object).a(bl2);
        object = this.b;
        if (object != null) {
            object.a();
        }
    }

    public void b() {
        Object object = this.c;
        boolean bl2 = this.a;
        ((CallChangeUseCase)object).a(bl2);
        object = this.b;
        if (object != null) {
            object.b();
        }
    }
}

