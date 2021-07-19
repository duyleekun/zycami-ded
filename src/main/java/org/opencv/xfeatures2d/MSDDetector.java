/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.xfeatures2d;

import org.opencv.features2d.Feature2D;

public class MSDDetector
extends Feature2D {
    public MSDDetector(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    public static MSDDetector u(long l10) {
        MSDDetector mSDDetector = new MSDDetector(l10);
        return mSDDetector;
    }

    public void finalize() {
        MSDDetector.delete(this.a);
    }
}

