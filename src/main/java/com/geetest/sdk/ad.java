/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.text.TextUtils;
import com.geetest.sdk.ad$a;
import java.util.Arrays;

public class ad {
    public String a;
    public String b;
    public long c = 20480L;
    public long d = 604800000L;
    public long e = 500L;
    public long f = 0x3200000L;
    public byte[] g;
    public byte[] h;

    private ad() {
    }

    public /* synthetic */ ad(ad$a ad$a) {
        this();
    }

    private void a(long l10) {
        this.d = l10;
    }

    public static /* synthetic */ void a(ad ad2, long l10) {
        ad2.b(l10);
    }

    public static /* synthetic */ void a(ad ad2, String string2) {
        ad2.a(string2);
    }

    public static /* synthetic */ void a(ad ad2, byte[] byArray) {
        ad2.b(byArray);
    }

    private void a(String string2) {
        this.a = string2;
    }

    private void a(byte[] byArray) {
        this.h = byArray;
    }

    private void b(long l10) {
        this.c = l10;
    }

    public static /* synthetic */ void b(ad ad2, long l10) {
        ad2.c(l10);
    }

    public static /* synthetic */ void b(ad ad2, String string2) {
        ad2.b(string2);
    }

    public static /* synthetic */ void b(ad ad2, byte[] byArray) {
        ad2.a(byArray);
    }

    private void b(String string2) {
        this.b = string2;
    }

    private void b(byte[] byArray) {
        this.g = byArray;
    }

    private void c(long l10) {
        this.f = l10;
    }

    public static /* synthetic */ void c(ad ad2, long l10) {
        ad2.a(l10);
    }

    public boolean a() {
        Object object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b))) && (object = (Object)this.g) != null && (object = (Object)this.h) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoganConfig{mCachePath='");
        String string2 = this.a;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", mPathPath='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", mMaxFile=");
        long l10 = this.c;
        stringBuilder.append(l10);
        stringBuilder.append(", mDay=");
        l10 = this.d;
        stringBuilder.append(l10);
        stringBuilder.append(", mMaxQueue=");
        l10 = this.e;
        stringBuilder.append(l10);
        stringBuilder.append(", mMinSDCard=");
        l10 = this.f;
        stringBuilder.append(l10);
        stringBuilder.append(", mEncryptKey16=");
        string2 = Arrays.toString(this.g);
        stringBuilder.append(string2);
        stringBuilder.append(", mEncryptIv16=");
        string2 = Arrays.toString(this.h);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

