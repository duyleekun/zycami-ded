/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorinterface.compose;

import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;

public class ComposeParams {
    private ComposeParams$Resolution a;
    private long b;
    private int c;
    private int d;
    private int e;

    public int a() {
        return this.e;
    }

    public long b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public ComposeParams$Resolution d() {
        return this.a;
    }

    public int e() {
        return this.d;
    }

    public ComposeParams f(int n10) {
        this.e = n10;
        return this;
    }

    public ComposeParams g(long l10) {
        this.b = l10;
        return this;
    }

    public ComposeParams h(int n10) {
        this.c = n10;
        return this;
    }

    public ComposeParams i(ComposeParams$Resolution composeParams$Resolution) {
        this.a = composeParams$Resolution;
        return this;
    }

    public ComposeParams j(int n10) {
        this.d = n10;
        return this;
    }
}

