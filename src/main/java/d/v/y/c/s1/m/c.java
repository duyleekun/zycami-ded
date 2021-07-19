/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.m;

import com.zhiyun.protocol.utils.Axis;
import d.v.y.c.s1.a;
import d.v.y.d.b;

public class c
extends a {
    private Axis b;

    public c() {
        Axis axis;
        this.b = axis = new Axis(0.0f, 0.0f, 0.0f);
    }

    private short e(float f10) {
        return (short)(f10 * 100.0f);
    }

    private float f(short s10) {
        return (float)s10 * 1.0f / 100.0f;
    }

    public byte[] a() {
        float f10 = this.b.pitch;
        short s10 = this.e(f10);
        float f11 = this.b.roll;
        short s11 = this.e(f11);
        float f12 = this.b.yaw;
        short s12 = this.e(f12);
        short s13 = (short)(this.b.duration / 10);
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = n10;
        boolean bl2 = this.b();
        byte[] byArray2 = d.v.y.d.b.t(s10, bl2);
        bl2 = this.b();
        byte[] byArray3 = d.v.y.d.b.t(s11, bl2);
        bl2 = this.b();
        byte[] byArray4 = d.v.y.d.b.t(s12, bl2);
        bl2 = this.b();
        byte[] byArray5 = d.v.y.d.b.t(s13, bl2);
        byte[][] byArrayArray = new byte[4][];
        byArrayArray[0] = byArray2;
        byArrayArray[n10] = byArray3;
        byArrayArray[2] = byArray4;
        byArrayArray[3] = byArray5;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        Axis axis;
        this.b = axis = new Axis(0.0f, 0.0f, 0.0f);
    }

    public Axis d() {
        return this.b;
    }

    public void g(Axis axis) {
        this.b = axis;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean parseFrom(byte[] object) {
        void var1_6;
        Axis axis;
        void var3_14;
        float f10;
        byte by2;
        float f11;
        byte by3;
        float f12;
        block10: {
            block9: {
                float f13;
                block8: {
                    byte by4;
                    short s10;
                    boolean bl3;
                    Axis axis2 = null;
                    try {
                        int bl2 = ((Object)object).length;
                        int n11 = 9;
                        f13 = 1.3E-44f;
                        if (bl2 < n11) break block8;
                        Object object2 = object[0];
                        bl3 = true;
                        f13 = Float.MIN_VALUE;
                        if (object2 != bl3) break block8;
                        int n12 = 3;
                        f12 = 4.2E-45f;
                        Object object3 = object[n12];
                        by3 = 4;
                        f11 = 5.6E-45f;
                        by3 = (byte)object[by3];
                        by2 = (byte)(this.b() ? 1 : 0);
                        s10 = d.v.y.d.b.y((byte)object3, by3, by2 != 0);
                    }
                    catch (Throwable throwable) {
                        boolean bl6 = false;
                        f12 = 0.0f;
                        by3 = 0;
                        f11 = 0.0f;
                        break block9;
                    }
                    try {
                        by3 = (byte)object[bl3];
                        by2 = 2;
                        f10 = 2.8E-45f;
                        by2 = (byte)object[by2];
                        by4 = this.b();
                        by3 = (byte)d.v.y.d.b.y(by3, by2, by4 != 0);
                    }
                    catch (Throwable throwable) {
                        by3 = 0;
                        f11 = 0.0f;
                        break block9;
                    }
                    by2 = (byte)5;
                    f10 = 7.0E-45f;
                    try {
                        by2 = (byte)object[by2];
                        by4 = 6;
                        by4 = (byte)object[by4];
                        boolean bl4 = this.b();
                        by2 = (byte)d.v.y.d.b.y(by2, by4, bl4);
                    }
                    catch (Throwable throwable) {
                        by2 = 0;
                        f10 = 0.0f;
                        break block10;
                    }
                    by4 = (byte)7;
                    try {
                        by4 = (byte)object[by4];
                        int n10 = 8;
                        reference var13_29 = object[n10];
                        boolean bl5 = this.b();
                        var13_29 = (reference)d.v.y.d.b.y(by4, (byte)var13_29, bl5);
                        f10 = this.f(by2);
                        f11 = this.f(by3);
                        f12 = this.f(s10);
                        this.b = axis2 = new Axis(f10, f11, f12);
                    }
                    catch (Throwable throwable) {
                        break block10;
                    }
                    axis2.duration = (int)(var13_29 *= 10);
                    return bl3;
                }
                float f14 = this.f((short)0);
                f13 = this.f((short)0);
                float f15 = this.f((short)0);
                this.b = object = new Axis(f14, f13, f15);
                ((Axis)object).duration = 0;
                return false;
            }
            by2 = 0;
            f10 = 0.0f;
        }
        f10 = this.f(by2);
        f11 = this.f(by3);
        f12 = this.f((short)var3_14);
        this.b = axis = new Axis(f10, f11, f12);
        axis.duration = 0;
        throw var1_6;
    }
}

