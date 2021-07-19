/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk;

import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.e.g.c;

public class CallChangeUseCase
implements IUseCase {
    public static final boolean d = true;
    private c c;

    public void a(boolean bl2) {
        this.b(bl2, -1);
    }

    public void b(boolean bl2, long l10) {
        c c10 = this.c;
        if (c10 != null) {
            c10.a(bl2, l10);
        }
    }

    public c c() {
        return this.c;
    }

    public void d(c c10) {
        this.c = c10;
    }
}

