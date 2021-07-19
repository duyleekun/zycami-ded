/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

public class Font {
    private final float ascent;
    private final String family;
    private final String name;
    private final String style;

    public Font(String string2, String string3, String string4, float f10) {
        this.family = string2;
        this.name = string3;
        this.style = string4;
        this.ascent = f10;
    }

    public float getAscent() {
        return this.ascent;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }
}

