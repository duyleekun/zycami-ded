/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.h.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;

public class BOWTrainer {
    public final long a;

    public BOWTrainer(long l10) {
        this.a = l10;
    }

    public static BOWTrainer a(long l10) {
        BOWTrainer bOWTrainer = new BOWTrainer(l10);
        return bOWTrainer;
    }

    private static native void add_0(long var0, long var2);

    private static native void clear_0(long var0);

    private static native long cluster_0(long var0, long var2);

    private static native long cluster_1(long var0);

    private static native void delete(long var0);

    private static native int descriptorsCount_0(long var0);

    private static native long getDescriptors_0(long var0);

    public void b(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        BOWTrainer.add_0(l10, l11);
    }

    public void c() {
        BOWTrainer.clear_0(this.a);
    }

    public Mat d() {
        long l10 = BOWTrainer.cluster_1(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat e(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = BOWTrainer.cluster_0(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public int f() {
        return BOWTrainer.descriptorsCount_0(this.a);
    }

    public void finalize() {
        BOWTrainer.delete(this.a);
    }

    public List g() {
        ArrayList arrayList = new ArrayList();
        long l10 = BOWTrainer.getDescriptors_0(this.a);
        Mat mat = new Mat(l10);
        i.f.h.a.c(mat, arrayList);
        return arrayList;
    }

    public long h() {
        return this.a;
    }
}

