/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class LUCID
extends Feature2D {
    public LUCID(long l10) {
        super(l10);
    }

    private static native long create_0(int var0, int var1);

    private static native long create_1(int var0);

    private static native long create_2();

    private static native void delete(long var0);

    public static LUCID u(long l10) {
        LUCID lUCID = new LUCID(l10);
        return lUCID;
    }

    public static LUCID v() {
        return LUCID.u(LUCID.create_2());
    }

    public static LUCID w(int n10) {
        return LUCID.u(LUCID.create_1(n10));
    }

    public static LUCID x(int n10, int n11) {
        return LUCID.u(LUCID.create_0(n10, n11));
    }

    public void finalize() {
        LUCID.delete(this.a);
    }
}

