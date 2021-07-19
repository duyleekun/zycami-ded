/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.r.a.r;

import android.text.TextUtils;

public final class f {
    public String a;
    public long b;
    public int c;
    public String d;
    public boolean e;
    public boolean f;

    public f(String object) {
        long l10;
        this.b = l10 = (long)-1;
        this.c = -1;
        this.e = false;
        this.f = false;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.a = object;
            return;
        }
        object = new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        throw object;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PushPackageInfo{mPackageName=");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append(", mPushVersion=");
        long l10 = this.b;
        stringBuilder.append(l10);
        stringBuilder.append(", mPackageVersion=");
        int bl2 = this.c;
        stringBuilder.append(bl2);
        stringBuilder.append(", mInBlackList=");
        boolean bl3 = this.e;
        stringBuilder.append(bl3);
        stringBuilder.append(", mPushEnable=");
        boolean bl4 = this.f;
        stringBuilder.append(bl4);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

