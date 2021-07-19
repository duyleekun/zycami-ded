/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.cea;

public final class Cea708Decoder$DtvCcPacket {
    public int currentIndex;
    public final byte[] packetData;
    public final int packetSize;
    public final int sequenceNumber;

    public Cea708Decoder$DtvCcPacket(int n10, int n11) {
        this.sequenceNumber = n10;
        this.packetSize = n11;
        byte[] byArray = new byte[n11 * 2 + -1];
        this.packetData = byArray;
        this.currentIndex = 0;
    }
}

