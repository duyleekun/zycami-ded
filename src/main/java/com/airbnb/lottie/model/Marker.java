/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

public class Marker {
    private static String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    public Marker(String string2, float f10, float f11) {
        this.name = string2;
        this.durationFrames = f11;
        this.startFrame = f10;
    }

    public boolean matchesName(String string2) {
        String string3 = this.name;
        boolean bl2 = string3.equalsIgnoreCase(string2);
        int n10 = 1;
        if (bl2) {
            return n10 != 0;
        }
        string3 = this.name;
        String string4 = CARRIAGE_RETURN;
        bl2 = string3.endsWith(string4);
        string4 = null;
        if (bl2) {
            string3 = this.name;
            int n11 = string3.length() - n10;
            boolean bl3 = (string3 = string3.substring(0, n11)).equalsIgnoreCase(string2);
            if (bl3) {
                return n10 != 0;
            }
        }
        return false;
    }
}

