/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.a0;
import org.opencv.core.Mat;
import org.opencv.features2d.BOWTrainer;

public class BOWKMeansTrainer
extends BOWTrainer {
    public BOWKMeansTrainer(int n10) {
        long l10 = BOWKMeansTrainer.BOWKMeansTrainer_3(n10);
        super(l10);
    }

    public BOWKMeansTrainer(int n10, a0 a02) {
        int n11 = a02.a;
        int n12 = a02.b;
        double d10 = a02.c;
        long l10 = BOWKMeansTrainer.BOWKMeansTrainer_2(n10, n11, n12, d10);
        super(l10);
    }

    public BOWKMeansTrainer(int n10, a0 a02, int n11) {
        int n12 = a02.a;
        int n13 = a02.b;
        double d10 = a02.c;
        long l10 = BOWKMeansTrainer.BOWKMeansTrainer_1(n10, n12, n13, d10, n11);
        super(l10);
    }

    public BOWKMeansTrainer(int n10, a0 a02, int n11, int n12) {
        int n13 = a02.a;
        int n14 = a02.b;
        double d10 = a02.c;
        long l10 = BOWKMeansTrainer.BOWKMeansTrainer_0(n10, n13, n14, d10, n11, n12);
        super(l10);
    }

    public BOWKMeansTrainer(long l10) {
        super(l10);
    }

    private static native long BOWKMeansTrainer_0(int var0, int var1, int var2, double var3, int var5, int var6);

    private static native long BOWKMeansTrainer_1(int var0, int var1, int var2, double var3, int var5);

    private static native long BOWKMeansTrainer_2(int var0, int var1, int var2, double var3);

    private static native long BOWKMeansTrainer_3(int var0);

    private static native long cluster_0(long var0, long var2);

    private static native long cluster_1(long var0);

    private static native void delete(long var0);

    public static BOWKMeansTrainer i(long l10) {
        BOWKMeansTrainer bOWKMeansTrainer = new BOWKMeansTrainer(l10);
        return bOWKMeansTrainer;
    }

    public Mat d() {
        long l10 = BOWKMeansTrainer.cluster_1(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat e(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = BOWKMeansTrainer.cluster_0(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public void finalize() {
        BOWKMeansTrainer.delete(this.a);
    }
}

