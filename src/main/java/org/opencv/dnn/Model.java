/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import i.f.c.y;
import i.f.c.z;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.dnn.Net;

public class Model
extends Net {
    public Model(long l10) {
        super(l10);
    }

    public Model(String string2) {
        long l10 = Model.Model_2(string2);
        super(l10);
    }

    public Model(String string2, String string3) {
        long l10 = Model.Model_1(string2, string3);
        super(l10);
    }

    public Model(Net net) {
        long l10 = Model.Model_0(net.a);
        super(l10);
    }

    private static native long Model_0(long var0);

    private static native long Model_1(String var0, String var1);

    private static native long Model_2(String var0);

    public static Model N(long l10) {
        Model model = new Model(l10);
        return model;
    }

    private static native void delete(long var0);

    private static native void predict_0(long var0, long var2, long var4);

    private static native long setInputCrop_0(long var0, boolean var2);

    private static native long setInputMean_0(long var0, double var2, double var4, double var6, double var8);

    private static native void setInputParams_0(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16, boolean var17);

    private static native void setInputParams_1(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, boolean var16);

    private static native void setInputParams_2(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14);

    private static native void setInputParams_3(long var0, double var2, double var4, double var6);

    private static native void setInputParams_4(long var0, double var2);

    private static native void setInputParams_5(long var0);

    private static native long setInputScale_0(long var0, double var2);

    private static native long setInputSize_0(long var0, double var2, double var4);

    private static native long setInputSize_1(long var0, int var2, int var3);

    private static native long setInputSwapRB_0(long var0, boolean var2);

    public void O(Mat mat, List list) {
        Mat mat2 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        Model.predict_0(l10, l11, l12);
        i.f.h.a.c(mat2, list);
        mat2.u0();
    }

    public Model P(boolean bl2) {
        long l10 = Model.setInputCrop_0(this.a, bl2);
        Model model = new Model(l10);
        return model;
    }

    public Model Q(y object) {
        long l10 = this.a;
        object = ((y)object).a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        l10 = Model.setInputMean_0(l10, (double)object2, (double)object3, (double)object4, (double)object5);
        Model model = new Model(l10);
        return model;
    }

    public void R() {
        Model.setInputParams_5(this.a);
    }

    public void S(double d10) {
        Model.setInputParams_4(this.a, d10);
    }

    public void T(double d10, z z10) {
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        Model.setInputParams_3(l10, d10, d11, d12);
    }

    public void U(double d10, z z10, y y10) {
        Object object = z10;
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Model.setInputParams_2(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public void V(double d10, z z10, y y10, boolean bl2) {
        Object object = z10;
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Model.setInputParams_1(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2);
    }

    public void W(double d10, z z10, y y10, boolean bl2, boolean bl3) {
        Object object = z10;
        long l10 = this.a;
        double d11 = z10.a;
        double d12 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Model.setInputParams_0(l10, d10, d11, d12, (double)object2, (double)object3, (double)object4, (double)object5, bl2, bl3);
    }

    public Model X(double d10) {
        long l10 = Model.setInputScale_0(this.a, d10);
        Model model = new Model(l10);
        return model;
    }

    public Model Y(int n10, int n11) {
        long l10 = Model.setInputSize_1(this.a, n10, n11);
        Model model = new Model(l10);
        return model;
    }

    public Model Z(z z10) {
        long l10 = this.a;
        double d10 = z10.a;
        double d11 = z10.b;
        l10 = Model.setInputSize_0(l10, d10, d11);
        Model model = new Model(l10);
        return model;
    }

    public Model a0(boolean bl2) {
        long l10 = Model.setInputSwapRB_0(this.a, bl2);
        Model model = new Model(l10);
        return model;
    }

    public void finalize() {
        Model.delete(this.a);
    }
}

