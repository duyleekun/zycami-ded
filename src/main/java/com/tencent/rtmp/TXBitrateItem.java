/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

public class TXBitrateItem
implements Comparable {
    public int bitrate;
    public int height;
    public int index;
    public int width;

    public int compareTo(TXBitrateItem tXBitrateItem) {
        int n10 = this.bitrate;
        int n11 = tXBitrateItem.bitrate;
        return n10 - n11;
    }
}

