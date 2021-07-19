/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.DescriptorMatcher;

public class BFMatcher
extends DescriptorMatcher {
    public BFMatcher() {
        long l10 = BFMatcher.BFMatcher_2();
        super(l10);
    }

    public BFMatcher(int n10) {
        long l10 = BFMatcher.BFMatcher_1(n10);
        super(l10);
    }

    public BFMatcher(int n10, boolean bl2) {
        long l10 = BFMatcher.BFMatcher_0(n10, bl2);
        super(l10);
    }

    public BFMatcher(long l10) {
        super(l10);
    }

    private static native long BFMatcher_0(int var0, boolean var1);

    private static native long BFMatcher_1(int var0);

    private static native long BFMatcher_2();

    public static BFMatcher H(long l10) {
        BFMatcher bFMatcher = new BFMatcher(l10);
        return bFMatcher;
    }

    public static BFMatcher I() {
        return BFMatcher.H(BFMatcher.create_2());
    }

    public static BFMatcher J(int n10) {
        return BFMatcher.H(BFMatcher.create_1(n10));
    }

    public static BFMatcher K(int n10, boolean bl2) {
        return BFMatcher.H(BFMatcher.create_0(n10, bl2));
    }

    private static native long create_0(int var0, boolean var1);

    private static native long create_1(int var0);

    private static native long create_2();

    private static native void delete(long var0);

    public void finalize() {
        BFMatcher.delete(this.a);
    }
}

