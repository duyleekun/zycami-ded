/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.resources;

public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public static void setShouldLoadFontSynchronously(boolean bl2) {
        shouldLoadFontSynchronously = bl2;
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }
}

