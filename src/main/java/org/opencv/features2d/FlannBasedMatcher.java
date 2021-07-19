/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.DescriptorMatcher;

public class FlannBasedMatcher
extends DescriptorMatcher {
    public FlannBasedMatcher() {
        long l10 = FlannBasedMatcher.FlannBasedMatcher_0();
        super(l10);
    }

    public FlannBasedMatcher(long l10) {
        super(l10);
    }

    private static native long FlannBasedMatcher_0();

    public static FlannBasedMatcher H(long l10) {
        FlannBasedMatcher flannBasedMatcher = new FlannBasedMatcher(l10);
        return flannBasedMatcher;
    }

    public static FlannBasedMatcher I() {
        return FlannBasedMatcher.H(FlannBasedMatcher.create_0());
    }

    private static native long create_0();

    private static native void delete(long var0);

    public void finalize() {
        FlannBasedMatcher.delete(this.a);
    }
}

