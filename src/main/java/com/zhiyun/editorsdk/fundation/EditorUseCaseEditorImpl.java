/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.fundation;

import com.zhiyun.editorsdk.fundation.IEditorUseCaseEditor;
import d.v.h.e.b;
import d.v.h.e.c;

public class EditorUseCaseEditorImpl
implements IEditorUseCaseEditor {
    private c a;

    public EditorUseCaseEditorImpl(c c10) {
        this.a = c10;
    }

    private boolean a() {
        boolean bl2;
        c c10 = this.a;
        if (c10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        return bl2;
    }

    public long A() {
        long l10;
        boolean bl2 = this.a();
        if (bl2) {
            c c10 = this.a;
            l10 = c10.A();
        } else {
            l10 = 0L;
        }
        return l10;
    }

    public void I(b b10) {
        boolean bl2 = this.a();
        if (bl2) {
            c c10 = this.a;
            c10.I(b10);
        }
    }

    public boolean M() {
        c c10;
        boolean bl2 = this.a();
        if (bl2 && (bl2 = (c10 = this.a).M())) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        return bl2;
    }

    public void b(b b10) {
        boolean bl2 = this.a();
        if (bl2) {
            c c10 = this.a;
            c10.b(b10);
        }
    }

    public long i() {
        long l10;
        boolean bl2 = this.a();
        if (bl2) {
            c c10 = this.a;
            l10 = c10.i();
        } else {
            l10 = 0L;
        }
        return l10;
    }
}

