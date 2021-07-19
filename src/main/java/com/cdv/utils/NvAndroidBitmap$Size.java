/*
 * Decompiled with CFR 0.151.
 */
package com.cdv.utils;

public class NvAndroidBitmap$Size {
    private int m_height;
    private int m_width;

    public NvAndroidBitmap$Size(int n10, int n11) {
        this.m_width = n10;
        this.m_height = n11;
    }

    public boolean equals(Object object) {
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n10 = object instanceof NvAndroidBitmap$Size;
        if (n10 != 0) {
            int n11;
            object = (NvAndroidBitmap$Size)object;
            n10 = this.m_width;
            int n12 = ((NvAndroidBitmap$Size)object).m_width;
            if (n10 == n12 && (n10 = this.m_height) == (n11 = ((NvAndroidBitmap$Size)object).m_height)) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public int getHeight() {
        return this.m_height;
    }

    public int getWidth() {
        return this.m_width;
    }
}

