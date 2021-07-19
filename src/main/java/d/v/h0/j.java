/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0;

import com.zhiyun.vtpusher.VtDataType;
import com.zhiyun.vtpusher.VtEncoderType;

public class j {
    private final VtDataType a;
    private final VtEncoderType b;
    private final int c;
    private final String d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private j(VtDataType vtDataType, VtEncoderType vtEncoderType, int n10, String string2, int n11) {
        this.a = vtDataType;
        this.b = vtEncoderType;
        this.c = n10;
        this.d = string2;
        this.e = n11;
    }

    public static j a(VtDataType vtDataType, VtEncoderType vtEncoderType, int n10, String string2, int n11) {
        j j10 = new j(vtDataType, vtEncoderType, n10, string2, n11);
        return j10;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.f;
    }

    public VtDataType i() {
        return this.a;
    }

    public VtEncoderType j() {
        return this.b;
    }

    public j k(int n10) {
        this.i = n10;
        return this;
    }

    public j l(int n10) {
        this.h = n10;
        return this;
    }

    public j m(int n10) {
        this.g = n10;
        return this;
    }

    public j n(int n10) {
        this.f = n10;
        return this;
    }
}

