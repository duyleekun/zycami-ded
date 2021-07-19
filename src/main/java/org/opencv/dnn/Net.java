/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import i.f.c.f;
import i.f.c.k;
import i.f.c.y;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.dnn.DictValue;
import org.opencv.dnn.Layer;

public class Net {
    public final long a;

    public Net() {
        long l10;
        this.a = l10 = Net.Net_0();
    }

    public Net(long l10) {
        this.a = l10;
    }

    public static Net D(String string2, String string3) {
        long l10 = Net.readFromModelOptimizer_0(string2, string3);
        Net net = new Net(l10);
        return net;
    }

    private static native long Net_0();

    public static Net a(long l10) {
        Net net = new Net(l10);
        return net;
    }

    private static native void connect_0(long var0, String var2, String var3);

    private static native void delete(long var0);

    private static native void dumpToFile_0(long var0, String var2);

    private static native String dump_0(long var0);

    private static native boolean empty_0(long var0);

    private static native void enableFusion_0(long var0, boolean var2);

    private static native long forward_0(long var0, String var2);

    private static native long forward_1(long var0);

    private static native void forward_2(long var0, long var2, String var4);

    private static native void forward_3(long var0, long var2);

    private static native void forward_4(long var0, long var2, List var4);

    private static native long getFLOPS_0(long var0, long var2);

    private static native long getFLOPS_1(long var0, int var2, long var3);

    private static native long getFLOPS_2(long var0, int var2, List var3);

    private static native long getFLOPS_3(long var0, List var2);

    private static native int getLayerId_0(long var0, String var2);

    private static native List getLayerNames_0(long var0);

    private static native void getLayerTypes_0(long var0, List var2);

    private static native long getLayer_0(long var0, long var2);

    private static native int getLayersCount_0(long var0, String var2);

    private static native void getMemoryConsumption_0(long var0, long var2, double[] var4, double[] var5);

    private static native void getMemoryConsumption_1(long var0, int var2, long var3, double[] var5, double[] var6);

    private static native void getMemoryConsumption_2(long var0, int var2, List var3, double[] var4, double[] var5);

    private static native long getParam_0(long var0, long var2, int var4);

    private static native long getParam_1(long var0, long var2);

    private static native long getPerfProfile_0(long var0, long var2);

    private static native List getUnconnectedOutLayersNames_0(long var0);

    private static native long getUnconnectedOutLayers_0(long var0);

    private static native long readFromModelOptimizer_0(String var0, String var1);

    private static native void setHalideScheduler_0(long var0, String var2);

    private static native void setInput_0(long var0, long var2, String var4, double var5, double var7, double var9, double var11, double var13);

    private static native void setInput_1(long var0, long var2, String var4, double var5);

    private static native void setInput_2(long var0, long var2, String var4);

    private static native void setInput_3(long var0, long var2);

    private static native void setInputsNames_0(long var0, List var2);

    private static native void setParam_0(long var0, long var2, int var4, long var5);

    private static native void setPreferableBackend_0(long var0, int var2);

    private static native void setPreferableTarget_0(long var0, int var2);

    public long A(f f10) {
        long l10 = this.a;
        long l11 = f10.a;
        return Net.getPerfProfile_0(l10, l11);
    }

    public k B() {
        return k.Y0(Net.getUnconnectedOutLayers_0(this.a));
    }

    public List C() {
        return Net.getUnconnectedOutLayersNames_0(this.a);
    }

    public void E(String string2) {
        Net.setHalideScheduler_0(this.a, string2);
    }

    public void F(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        Net.setInput_3(l10, l11);
    }

    public void G(Mat mat, String string2) {
        long l10 = this.a;
        long l11 = mat.a;
        Net.setInput_2(l10, l11, string2);
    }

    public void H(Mat mat, String string2, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        Net.setInput_1(l10, l11, string2, d10);
    }

    public void I(Mat mat, String string2, double d10, y y10) {
        long l10 = this.a;
        long l11 = mat.a;
        Object object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        object = string2;
        Net.setInput_0(l10, l11, string2, d10, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public void J(List list) {
        Net.setInputsNames_0(this.a, list);
    }

    public void K(DictValue dictValue, int n10, Mat mat) {
        long l10 = this.a;
        long l11 = dictValue.d();
        long l12 = mat.a;
        Net.setParam_0(l10, l11, n10, l12);
    }

    public void L(int n10) {
        Net.setPreferableBackend_0(this.a, n10);
    }

    public void M(int n10) {
        Net.setPreferableTarget_0(this.a, n10);
    }

    public void b(String string2, String string3) {
        Net.connect_0(this.a, string2, string3);
    }

    public String c() {
        return Net.dump_0(this.a);
    }

    public void d(String string2) {
        Net.dumpToFile_0(this.a, string2);
    }

    public boolean e() {
        return Net.empty_0(this.a);
    }

    public void f(boolean bl2) {
        Net.enableFusion_0(this.a, bl2);
    }

    public void finalize() {
        Net.delete(this.a);
    }

    public Mat g() {
        long l10 = Net.forward_1(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat h(String string2) {
        long l10 = Net.forward_0(this.a, string2);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void i(List list) {
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        Net.forward_3(l10, l11);
        i.f.h.a.c(mat, list);
        mat.u0();
    }

    public void j(List list, String string2) {
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        Net.forward_2(l10, l11, string2);
        i.f.h.a.c(mat, list);
        mat.u0();
    }

    public void k(List list, List list2) {
        Mat mat = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        Net.forward_4(l10, l11, list2);
        i.f.h.a.c(mat, list);
        mat.u0();
    }

    public long l(int n10, List list) {
        return Net.getFLOPS_2(this.a, n10, list);
    }

    public long m(int n10, k k10) {
        long l10 = this.a;
        long l11 = k10.a;
        return Net.getFLOPS_1(l10, n10, l11);
    }

    public long n(List list) {
        return Net.getFLOPS_3(this.a, list);
    }

    public long o(k k10) {
        long l10 = this.a;
        long l11 = k10.a;
        return Net.getFLOPS_0(l10, l11);
    }

    public Layer p(DictValue dictValue) {
        long l10 = this.a;
        long l11 = dictValue.d();
        return Layer.g(Net.getLayer_0(l10, l11));
    }

    public int q(String string2) {
        return Net.getLayerId_0(this.a, string2);
    }

    public List r() {
        return Net.getLayerNames_0(this.a);
    }

    public void s(List list) {
        Net.getLayerTypes_0(this.a, list);
    }

    public int t(String string2) {
        return Net.getLayersCount_0(this.a, string2);
    }

    public void u(int n10, List list, long[] lArray, long[] lArray2) {
        int n11 = 1;
        double[] dArray = new double[n11];
        double[] dArray2 = new double[n11];
        long l10 = this.a;
        Net.getMemoryConsumption_2(l10, n10, list, dArray, dArray2);
        n10 = 0;
        if (lArray != null) {
            double d10 = dArray[0];
            lArray[0] = l10 = (long)d10;
        }
        if (lArray2 != null) {
            long l11;
            double d11 = dArray2[0];
            lArray2[0] = l11 = (long)d11;
        }
    }

    public void v(int n10, k k10, long[] lArray, long[] lArray2) {
        int n11 = 1;
        double[] dArray = new double[n11];
        double[] dArray2 = new double[n11];
        long l10 = this.a;
        long l11 = k10.a;
        Net.getMemoryConsumption_1(l10, n10, l11, dArray, dArray2);
        n10 = 0;
        if (lArray != null) {
            double d10 = dArray[0];
            lArray[0] = l10 = (long)d10;
        }
        if (lArray2 != null) {
            long l12;
            double d11 = dArray2[0];
            lArray2[0] = l12 = (long)d11;
        }
    }

    public void w(k k10, long[] lArray, long[] lArray2) {
        double d10;
        int n10 = 1;
        double[] dArray = new double[n10];
        double[] dArray2 = new double[n10];
        long l10 = this.a;
        long l11 = k10.a;
        Net.getMemoryConsumption_0(l10, l11, dArray, dArray2);
        k10 = null;
        if (lArray != null) {
            d10 = dArray[0];
            lArray[0] = l10 = (long)d10;
        }
        if (lArray2 != null) {
            long l12;
            d10 = dArray2[0];
            lArray2[0] = l12 = (long)d10;
        }
    }

    public long x() {
        return this.a;
    }

    public Mat y(DictValue dictValue) {
        long l10 = this.a;
        long l11 = dictValue.d();
        l10 = Net.getParam_1(l10, l11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat z(DictValue dictValue, int n10) {
        long l10 = this.a;
        long l11 = dictValue.d();
        long l12 = Net.getParam_0(l10, l11, n10);
        Mat mat = new Mat(l12);
        return mat;
    }
}

