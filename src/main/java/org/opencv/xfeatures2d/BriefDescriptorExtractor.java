/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class BriefDescriptorExtractor
extends Feature2D {
    public BriefDescriptorExtractor(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, boolean var1);

    private static native long create_1(int var0);

    private static native long create_2();

    private static native void delete(long var0);

    public static BriefDescriptorExtractor u(long l10) {
        BriefDescriptorExtractor briefDescriptorExtractor = new BriefDescriptorExtractor(l10);
        return briefDescriptorExtractor;
    }

    public static BriefDescriptorExtractor v() {
        return BriefDescriptorExtractor.u(BriefDescriptorExtractor.create_2());
    }

    public static BriefDescriptorExtractor w(int n10) {
        return BriefDescriptorExtractor.u(BriefDescriptorExtractor.create_1(n10));
    }

    public static BriefDescriptorExtractor x(int n10, boolean bl2) {
        return BriefDescriptorExtractor.u(BriefDescriptorExtractor.create_0(n10, bl2));
    }

    public void finalize() {
        BriefDescriptorExtractor.delete(this.a);
    }
}

