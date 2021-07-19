/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.template;

public class StickerBean {
    private String a;
    private float b;
    private long c;

    public StickerBean(String string2, float f10, long l10) {
        this.a = string2;
        this.b = f10;
        this.c = l10;
    }

    public String a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public StickerBean d(String string2) {
        this.a = string2;
        return this;
    }

    public StickerBean e(float f10) {
        this.b = f10;
        return this;
    }

    public StickerBean f(long l10) {
        this.c = l10;
        return this;
    }
}

