/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import org.opencv.imgproc.GeneralizedHough;

public class GeneralizedHoughBallard
extends GeneralizedHough {
    public GeneralizedHoughBallard(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native int getLevels_0(long var0);

    private static native int getVotesThreshold_0(long var0);

    private static native void setLevels_0(long var0, int var2);

    private static native void setVotesThreshold_0(long var0, int var2);

    public static GeneralizedHoughBallard z(long l10) {
        GeneralizedHoughBallard generalizedHoughBallard = new GeneralizedHoughBallard(l10);
        return generalizedHoughBallard;
    }

    public int A() {
        return GeneralizedHoughBallard.getLevels_0(this.a);
    }

    public int B() {
        return GeneralizedHoughBallard.getVotesThreshold_0(this.a);
    }

    public void C(int n10) {
        GeneralizedHoughBallard.setLevels_0(this.a, n10);
    }

    public void D(int n10) {
        GeneralizedHoughBallard.setVotesThreshold_0(this.a, n10);
    }

    public void finalize() {
        GeneralizedHoughBallard.delete(this.a);
    }
}

