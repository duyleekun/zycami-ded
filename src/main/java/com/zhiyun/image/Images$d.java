/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.Size
 */
package com.zhiyun.image;

import android.graphics.drawable.Drawable;
import android.util.Size;
import com.zhiyun.image.Images$CacheStrategy;
import com.zhiyun.image.Images$ResourceType;
import com.zhiyun.image.Images$ScaleType;

public class Images$d {
    private int a;
    private int b;
    private Drawable c;
    private Drawable d;
    private boolean e;
    private int f;
    private boolean g;
    private boolean h;
    private Images$CacheStrategy i;
    private Images$ResourceType j;
    private Images$ScaleType k;
    private Size l;
    private int m;
    private String n;

    public Images$d() {
        int n10;
        this.a = n10 = -1;
        this.b = n10;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.h = false;
        Enum enum_ = Images$CacheStrategy.DEFAULT;
        this.i = enum_;
        this.j = enum_ = Images$ResourceType.DRAWABLE;
        this.m = 0;
        this.n = "";
    }

    public void A(String string2) {
        this.n = string2;
    }

    public Images$d B(int n10) {
        this.m = n10;
        return this;
    }

    public Images$CacheStrategy a() {
        return this.i;
    }

    public Drawable b() {
        return this.d;
    }

    public Drawable c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public Size e() {
        return this.l;
    }

    public int f() {
        return this.a;
    }

    public Images$ResourceType g() {
        return this.j;
    }

    public int h() {
        return this.f;
    }

    public Images$ScaleType i() {
        return this.k;
    }

    public String j() {
        return this.n;
    }

    public int k() {
        return this.m;
    }

    public boolean l() {
        return this.h;
    }

    public boolean m() {
        return this.g;
    }

    public boolean n() {
        return this.e;
    }

    public Images$d o(boolean bl2) {
        this.h = bl2;
        return this;
    }

    public Images$d p(Images$CacheStrategy images$CacheStrategy) {
        this.i = images$CacheStrategy;
        return this;
    }

    public Images$d q(boolean bl2) {
        this.g = bl2;
        return this;
    }

    public Images$d r(boolean bl2) {
        this.e = bl2;
        return this;
    }

    public Images$d s(Drawable drawable2) {
        this.b = -1;
        this.d = drawable2;
        return this;
    }

    public Images$d t(Drawable drawable2) {
        this.a = -1;
        this.c = drawable2;
        return this;
    }

    public Images$d u(int n10) {
        this.d = null;
        this.b = n10;
        return this;
    }

    public Images$d v(Size size) {
        this.l = size;
        return this;
    }

    public Images$d w(int n10) {
        this.c = null;
        this.a = n10;
        return this;
    }

    public Images$d x(Images$ResourceType images$ResourceType) {
        this.j = images$ResourceType;
        return this;
    }

    public Images$d y(int n10) {
        this.f = n10;
        return this;
    }

    public Images$d z(Images$ScaleType images$ScaleType) {
        this.k = images$ScaleType;
        return this;
    }
}

