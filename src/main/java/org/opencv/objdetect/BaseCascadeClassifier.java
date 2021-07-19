/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.objdetect;

import org.opencv.core.Algorithm;

public class BaseCascadeClassifier
extends Algorithm {
    public BaseCascadeClassifier(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    public static BaseCascadeClassifier g(long l10) {
        BaseCascadeClassifier baseCascadeClassifier = new BaseCascadeClassifier(l10);
        return baseCascadeClassifier;
    }

    public void finalize() {
        BaseCascadeClassifier.delete(this.a);
    }
}

