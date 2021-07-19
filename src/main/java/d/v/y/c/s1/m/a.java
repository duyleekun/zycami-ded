/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.m;

import com.zhiyun.protocol.utils.Axis;
import d.v.y.d.b;

public class a
extends d.v.y.c.s1.a {
    private Axis b;

    public a() {
        Axis axis;
        this.b = axis = new Axis(0.0f, 0.0f, 0.0f);
    }

    public byte[] a() {
        int n10;
        Object object = this.b;
        short s10 = (short)((Axis)object).pitch;
        short s11 = (short)((Axis)object).roll;
        short s12 = (short)((Axis)object).yaw;
        short s13 = (short)(((Axis)object).duration / 10);
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = n10 = 2;
        boolean bl2 = this.b();
        byte[] byArray2 = d.v.y.d.b.t(s10, bl2);
        bl2 = this.b();
        byte[] byArray3 = d.v.y.d.b.t(s11, bl2);
        bl2 = this.b();
        byte[] byArray4 = d.v.y.d.b.t(s12, bl2);
        bl2 = this.b();
        object = d.v.y.d.b.t(s13, bl2);
        byte[][] byArrayArray = new byte[4][];
        byArrayArray[0] = byArray2;
        byArrayArray[n11] = byArray3;
        byArrayArray[n10] = byArray4;
        byArrayArray[3] = (byte[])object;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        Axis axis;
        this.b = axis = new Axis(0.0f, 0.0f, 0.0f);
    }

    public Axis d() {
        return this.b;
    }

    public void e(Axis axis) {
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
        void var4_14;
        float f10;
        float f11;
        byte by2;
        byte by3;
        float f12;
        block10: {
            block9: {
                block8: {
                    Object object3;
                    byte by4;
                    short s10;
                    boolean bl3;
                    Axis axis2 = null;
                    try {
                        bl3 = ((Object)object).length;
                        int bl2 = 9;
                        f12 = 1.3E-44f;
                        if (bl3 < bl2) break block8;
                        bl3 = (boolean)object[0];
                        boolean bl4 = 2 != 0;
                        f12 = 2.8E-45f;
                        if (bl3 != bl4) break block8;
                        bl3 = true;
                        float f13 = Float.MIN_VALUE;
                        by3 = object[bl3];
                        Object object2 = object[bl4];
                        by2 = this.b();
                        s10 = d.v.y.d.b.y(by3, (byte)object2, by2 != 0);
                    }
                    catch (Throwable throwable) {
                        boolean bl7 = false;
                        f12 = 0.0f;
                        by3 = false;
                        f11 = 0.0f;
                        break block9;
                    }
                    by3 = (byte)3;
                    f11 = 4.2E-45f;
                    try {
                        by3 = object[by3];
                        by2 = 4;
                        f10 = 5.6E-45f;
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
                        boolean bl5 = this.b();
                        by2 = (byte)d.v.y.d.b.y(by2, by4, bl5);
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
                        object3 = object[n10];
                        boolean bl6 = this.b();
                        object3 = d.v.y.d.b.y(by4, (byte)object3, bl6);
                    }
                    catch (Throwable throwable) {
                        break block10;
                    }
                    f12 = s10;
                    f11 = by3;
                    f10 = by2;
                    this.b = axis2 = new Axis(f12, f11, f10);
                    axis2.duration = (int)object3;
                    return bl3;
                }
                float f14 = 0.0f;
                this.b = object = new Axis(f14, f14, f14);
                ((Axis)object).duration = 0;
                return false;
            }
            by2 = 0;
            f10 = 0.0f;
        }
        f12 = (float)var4_14;
        f11 = by3;
        f10 = by2;
        this.b = axis = new Axis(f12, f11, f10);
        axis.duration = 0;
        throw var1_6;
    }
}

