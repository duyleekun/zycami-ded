/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.j;

public class b {
    private String A;
    private String B;
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public boolean A() {
        return this.n;
    }

    public boolean B() {
        return this.o;
    }

    public void C(String string2) {
        this.e = string2;
    }

    public void D(int n10) {
        this.l = n10;
    }

    public void E(String string2) {
        this.r = string2;
    }

    public void F(String string2) {
        this.g = string2;
    }

    public void G(int n10) {
        this.m = n10;
    }

    public void H(String string2) {
        this.s = string2;
    }

    public void I(int n10) {
        this.k = n10;
    }

    public void J(String string2) {
        this.d = string2;
    }

    public void K(String string2) {
        this.i = string2;
    }

    public void L(String string2) {
        this.b = string2;
    }

    public void M(String string2) {
        this.c = string2;
    }

    public void N(String string2) {
        this.h = string2;
    }

    public void O(boolean bl2) {
        this.n = bl2;
    }

    public void P(String string2) {
        this.f = string2;
    }

    public void Q(boolean bl2) {
        this.o = bl2;
    }

    public void R(int n10) {
        this.p = n10;
    }

    public void S(String string2) {
        this.t = string2;
    }

    public void T(String string2) {
        this.q = string2;
    }

    public void U(int n10) {
        this.a = n10;
    }

    public void V(String string2) {
        this.v = string2;
    }

    public void W(String string2) {
        this.w = string2;
    }

    public void X(String string2) {
        this.y = string2;
    }

    public void Y(String string2) {
        this.A = string2;
    }

    public void Z(String string2) {
        this.B = string2;
    }

    public String a() {
        return this.e;
    }

    public void a0(String string2) {
        this.u = string2;
    }

    public int b() {
        return this.l;
    }

    public void b0(String string2) {
        this.x = string2;
    }

    public String c() {
        return this.r;
    }

    public void c0(String string2) {
        this.z = string2;
    }

    public String d() {
        return this.g;
    }

    public void d0(int n10) {
        this.j = n10;
    }

    public int e() {
        return this.m;
    }

    public String f() {
        return this.s;
    }

    public int g() {
        return this.k;
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.b;
    }

    public String k() {
        return this.c;
    }

    public String l() {
        return this.h;
    }

    public String m() {
        return this.f;
    }

    public int n() {
        return this.p;
    }

    public String o() {
        return this.t;
    }

    public String p() {
        return this.q;
    }

    public int q() {
        return this.a;
    }

    public String r() {
        return this.v;
    }

    public String s() {
        return this.w;
    }

    public String t() {
        return this.y;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LivePlatformInfo{src=");
        int c10 = this.a;
        stringBuilder.append(c10);
        stringBuilder.append(", livePlatform='");
        String string2 = this.b;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", livePlatformName='");
        String string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", liveAuthorityTip='");
        string3 = this.d;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", avatar='");
        string3 = this.e;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", nickname='");
        string3 = this.f;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", coverUri='");
        string3 = this.g;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", liveTitle='");
        string3 = this.h;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", liveIntroduced='");
        string3 = this.i;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", width=");
        int n10 = this.j;
        stringBuilder.append(n10);
        stringBuilder.append(", height=");
        n10 = this.k;
        stringBuilder.append(n10);
        stringBuilder.append(", codeRate=");
        n10 = this.l;
        stringBuilder.append(n10);
        stringBuilder.append(", fps=");
        n10 = this.m;
        stringBuilder.append(n10);
        stringBuilder.append(", isMobileNetwork=");
        n10 = (int)(this.n ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", isRecordLive=");
        n10 = this.o;
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", recordTime=");
        n10 = this.p;
        stringBuilder.append(n10);
        stringBuilder.append(", resolutionRatioP='");
        string3 = this.q;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", codeRateMpbs='");
        string3 = this.r;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", fpss='");
        string3 = this.s;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", recordTimes='");
        string3 = this.t;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateResolutionRatio='");
        string3 = this.u;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateCodeRateMpbs='");
        string3 = this.v;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateFps='");
        string3 = this.w;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateSpace='");
        string3 = this.x;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateLivePlatform='");
        string3 = this.y;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateTime='");
        string3 = this.z;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", statePushNum='");
        string3 = this.A;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", stateRecordTime='");
        string3 = this.B;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public String u() {
        return this.A;
    }

    public String v() {
        return this.B;
    }

    public String w() {
        return this.u;
    }

    public String x() {
        return this.x;
    }

    public String y() {
        return this.z;
    }

    public int z() {
        return this.j;
    }
}

