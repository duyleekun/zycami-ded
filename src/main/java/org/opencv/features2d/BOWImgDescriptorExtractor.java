/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.l;
import org.opencv.core.Mat;

public class BOWImgDescriptorExtractor {
    public final long a;

    public BOWImgDescriptorExtractor(long l10) {
        this.a = l10;
    }

    public static BOWImgDescriptorExtractor a(long l10) {
        BOWImgDescriptorExtractor bOWImgDescriptorExtractor = new BOWImgDescriptorExtractor(l10);
        return bOWImgDescriptorExtractor;
    }

    private static native void compute_0(long var0, long var2, long var4, long var6);

    private static native void delete(long var0);

    private static native int descriptorSize_0(long var0);

    private static native int descriptorType_0(long var0);

    private static native long getVocabulary_0(long var0);

    private static native void setVocabulary_0(long var0, long var2);

    public void b(Mat mat, l l10, Mat mat2) {
        long l11 = this.a;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        BOWImgDescriptorExtractor.compute_0(l11, l12, l13, l14);
    }

    public int c() {
        return BOWImgDescriptorExtractor.descriptorSize_0(this.a);
    }

    public int d() {
        return BOWImgDescriptorExtractor.descriptorType_0(this.a);
    }

    public long e() {
        return this.a;
    }

    public Mat f() {
        long l10 = BOWImgDescriptorExtractor.getVocabulary_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void finalize() {
        BOWImgDescriptorExtractor.delete(this.a);
    }

    public void g(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        BOWImgDescriptorExtractor.setVocabulary_0(l10, l11);
    }
}

