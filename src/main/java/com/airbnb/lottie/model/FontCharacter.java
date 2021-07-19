/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

import java.util.List;

public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List shapes;
    private final double size;
    private final String style;
    private final double width;

    public FontCharacter(List list, char c10, double d10, double d11, String string2, String string3) {
        this.shapes = list;
        this.character = c10;
        this.size = d10;
        this.width = d11;
        this.style = string2;
        this.fontFamily = string3;
    }

    public static int hashFor(char c10, String string2, String string3) {
        int n10 = ('\u0000' + c10) * 31;
        c10 = (char)string2.hashCode();
        n10 = (n10 + c10) * 31;
        c10 = (char)string3.hashCode();
        return n10 + c10;
    }

    public List getShapes() {
        return this.shapes;
    }

    public double getSize() {
        return this.size;
    }

    public String getStyle() {
        return this.style;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        char c10 = this.character;
        String string2 = this.fontFamily;
        String string3 = this.style;
        return FontCharacter.hashFor(c10, string2, string3);
    }
}

