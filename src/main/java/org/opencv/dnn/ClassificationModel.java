/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.dnn;

import org.opencv.core.Mat;
import org.opencv.dnn.Model;
import org.opencv.dnn.Net;

public class ClassificationModel
extends Model {
    public ClassificationModel(long l10) {
        super(l10);
    }

    public ClassificationModel(String string2) {
        long l10 = ClassificationModel.ClassificationModel_2(string2);
        super(l10);
    }

    public ClassificationModel(String string2, String string3) {
        long l10 = ClassificationModel.ClassificationModel_1(string2, string3);
        super(l10);
    }

    public ClassificationModel(Net net) {
        long l10 = ClassificationModel.ClassificationModel_0(net.a);
        super(l10);
    }

    private static native long ClassificationModel_0(long var0);

    private static native long ClassificationModel_1(String var0, String var1);

    private static native long ClassificationModel_2(String var0);

    public static ClassificationModel b0(long l10) {
        ClassificationModel classificationModel = new ClassificationModel(l10);
        return classificationModel;
    }

    private static native void classify_0(long var0, long var2, double[] var4, double[] var5);

    private static native void delete(long var0);

    public void c0(Mat mat, int[] nArray, float[] fArray) {
        double d10;
        int n10 = 1;
        double[] dArray = new double[n10];
        double[] dArray2 = new double[n10];
        long l10 = this.a;
        long l11 = mat.a;
        ClassificationModel.classify_0(l10, l11, dArray, dArray2);
        mat = null;
        if (nArray != null) {
            int n11;
            d10 = dArray[0];
            nArray[0] = n11 = (int)d10;
        }
        if (fArray != null) {
            float f10;
            d10 = dArray2[0];
            fArray[0] = f10 = (float)d10;
        }
    }

    public void finalize() {
        ClassificationModel.delete(this.a);
    }
}

