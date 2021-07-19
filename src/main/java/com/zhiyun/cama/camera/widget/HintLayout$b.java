/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View$OnClickListener
 */
package com.zhiyun.cama.camera.widget;

import android.view.View;

public class HintLayout$b {
    private final String a;
    private int b;
    private Object[] c;
    private boolean d;
    private long e;
    private Runnable f;
    private boolean g;
    private int h;
    private View.OnClickListener i;
    private View.OnClickListener j;

    public HintLayout$b(String string2) {
        this.a = string2;
    }

    public static /* synthetic */ String a(HintLayout$b hintLayout$b) {
        return hintLayout$b.a;
    }

    public static /* synthetic */ boolean b(HintLayout$b hintLayout$b) {
        return hintLayout$b.d;
    }

    public static /* synthetic */ long c(HintLayout$b hintLayout$b) {
        return hintLayout$b.e;
    }

    public View.OnClickListener d() {
        return this.i;
    }

    public int e() {
        return this.h;
    }

    public View.OnClickListener f() {
        return this.j;
    }

    public long g() {
        return this.e;
    }

    public Runnable h() {
        return this.f;
    }

    public String i() {
        return this.a;
    }

    public int j() {
        return this.b;
    }

    public Object[] k() {
        return this.c;
    }

    public boolean l() {
        return this.d;
    }

    public boolean m() {
        return this.g;
    }

    public HintLayout$b n(View.OnClickListener onClickListener) {
        this.i = onClickListener;
        return this;
    }

    public HintLayout$b o(int n10) {
        this.h = n10;
        return this;
    }

    public HintLayout$b p(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        return this;
    }

    public HintLayout$b q(long l10) {
        this.e = l10;
        return this;
    }

    public HintLayout$b r(boolean bl2) {
        this.d = bl2;
        return this;
    }

    public HintLayout$b s(Runnable runnable) {
        this.f = runnable;
        return this;
    }

    public HintLayout$b t(boolean bl2) {
        this.g = bl2;
        return this;
    }

    public HintLayout$b u(int n10) {
        this.b = n10;
        return this;
    }

    public HintLayout$b v(int n10, Object ... objectArray) {
        this.b = n10;
        this.c = objectArray;
        return this;
    }

    public HintLayout$b w(Object ... objectArray) {
        this.c = objectArray;
        return this;
    }
}

