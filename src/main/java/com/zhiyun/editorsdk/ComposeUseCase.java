/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk;

import com.zhiyun.editorinterface.compose.ComposeParams;
import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.h.c.b;
import d.v.h.c.b$a;
import d.v.v.d.a;

public class ComposeUseCase
implements IUseCase {
    private b c;

    public boolean a() {
        b b10 = this.c;
        if (b10 == null) {
            return false;
        }
        return b10.e();
    }

    public void b(String string2) {
        a a10 = a.n();
        this.c = a10;
        a10.f(string2);
    }

    public void c() {
        b b10 = this.c;
        if (b10 == null) {
            return;
        }
        b10.release();
    }

    public void d(b$a b$a) {
        b b10 = this.c;
        if (b10 == null) {
            return;
        }
        b10.g(b$a);
    }

    public void e(ComposeParams composeParams) {
        this.c.h(composeParams);
    }

    public void f() {
        b b10 = this.c;
        if (b10 == null) {
            return;
        }
        b10.i();
    }
}

