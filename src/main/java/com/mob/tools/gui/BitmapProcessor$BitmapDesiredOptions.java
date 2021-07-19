/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

public class BitmapProcessor$BitmapDesiredOptions {
    public int desiredHeight = 0;
    public int desiredWidth = 0;
    public long maxBytes = 0L;
    public int quality = 0;

    public boolean equals(Object object) {
        String string2;
        boolean bl2;
        boolean bl3 = super.equals(object);
        if (!(bl3 || object != null && (bl2 = ((String)(object = object.toString())).equals(string2 = this.toString())))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public String toString() {
        long l10;
        long l11;
        long l12;
        long l13;
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = this.desiredWidth;
        if (n10 > 0) {
            stringBuilder.append(n10);
        }
        if ((n10 = this.desiredHeight) > 0) {
            stringBuilder.append(n10);
        }
        if ((l13 = (l12 = (l11 = this.maxBytes) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            stringBuilder.append(l11);
        }
        if ((n10 = this.quality) > 0) {
            stringBuilder.append(n10);
        }
        return stringBuilder.toString();
    }
}

