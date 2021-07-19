/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import f.r;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        r r10;
        try {
            r10 = r.f;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            return null;
        }
        return r10.toString();
    }
}

