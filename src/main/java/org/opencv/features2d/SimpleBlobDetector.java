/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class SimpleBlobDetector
extends Feature2D {
    public SimpleBlobDetector(long l10) {
        super(l10);
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native String getDefaultName_0(long var0);

    public static SimpleBlobDetector u(long l10) {
        SimpleBlobDetector simpleBlobDetector = new SimpleBlobDetector(l10);
        return simpleBlobDetector;
    }

    public static SimpleBlobDetector v() {
        return SimpleBlobDetector.u(SimpleBlobDetector.create_0());
    }

    public String d() {
        return SimpleBlobDetector.getDefaultName_0(this.a);
    }

    public void finalize() {
        SimpleBlobDetector.delete(this.a);
    }
}

