/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.r;

import java.util.HashMap;
import java.util.Map;

public class c {
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 3;
    public static final int u = 4;
    public static final int v = 1;
    private int a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private boolean k;
    private long l;
    private Map m;
    private int n;
    private String o;
    private int p;

    public c() {
        HashMap hashMap;
        this.m = hashMap = new HashMap();
    }

    public void A(int n10) {
        this.e = n10;
    }

    public void B(Map map) {
        this.m = map;
    }

    public void C(String string2) {
        this.f = string2;
    }

    public void D(boolean bl2) {
        this.k = bl2;
    }

    public void E(String string2) {
        this.i = string2;
    }

    public void F(int n10) {
        this.j = n10;
    }

    public void G(int n10) {
        this.a = n10;
    }

    public void H(String string2) {
        this.c = string2;
    }

    public void I(String string2) {
        this.b = string2;
    }

    public void a() {
        this.g = "";
    }

    public void b() {
        this.f = "";
    }

    public String c() {
        return this.o;
    }

    public int d() {
        return this.p;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.n;
    }

    public long i() {
        return this.l;
    }

    public int j() {
        return this.e;
    }

    public Map k() {
        return this.m;
    }

    public String l() {
        return this.f;
    }

    public String m() {
        return this.i;
    }

    public int n() {
        return this.j;
    }

    public int o() {
        return this.a;
    }

    public String p() {
        return this.c;
    }

    public String q() {
        return this.b;
    }

    public boolean r() {
        int n10 = this.n;
        int n11 = 1;
        if (n10 == n11) {
            return n11 != 0;
        }
        return false;
    }

    public boolean s() {
        return this.k;
    }

    public void t(String string2) {
        this.o = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UPSNotificationMessage{mTargetType=");
        int bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", mTragetContent='");
        Object object = this.b;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", mTitle='");
        String string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", mContent='");
        string2 = this.d;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", mNotifyType=");
        int n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", mPurePicUrl='");
        string2 = this.f;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", mIconUrl='");
        string2 = this.g;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", mCoverUrl='");
        string2 = this.h;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", mSkipContent='");
        string2 = this.i;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", mSkipType=");
        int n11 = this.j;
        stringBuilder.append(n11);
        stringBuilder.append(", mShowTime=");
        boolean bl3 = this.k;
        stringBuilder.append(bl3);
        stringBuilder.append(", mMsgId=");
        long l10 = this.l;
        stringBuilder.append(l10);
        stringBuilder.append(", mParams=");
        object = this.m;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u(int n10) {
        this.p = n10;
    }

    public void v(String string2) {
        this.d = string2;
    }

    public void w(String string2) {
        this.h = string2;
    }

    public void x(String string2) {
        this.g = string2;
    }

    public void y(int n10) {
        this.n = n10;
    }

    public void z(long l10) {
        this.l = l10;
    }
}

