/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;

public final class SipHashFunction$SipHasher
extends AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 8;
    private long b;
    private final int c;
    private final int d;
    private long finalM;
    private long v0;
    private long v1;
    private long v2;
    private long v3;

    public SipHashFunction$SipHasher(int n10, int n11, long l10, long l11) {
        super(8);
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        this.v0 = l16 = 8317987319222330741L;
        this.v1 = l15 = 7237128888997146477L;
        this.v2 = l14 = 7816392313619706465L;
        this.v3 = l13 = 8387220255154660723L;
        this.b = l12 = 0L;
        this.finalM = l12;
        this.c = n10;
        this.d = n11;
        this.v0 = l16 ^= l10;
        this.v1 = l16 = l15 ^ l11;
        this.v2 = l16 = l14 ^ l10;
        this.v3 = l16 = l13 ^ l11;
    }

    private void processM(long l10) {
        long l11;
        this.v3 = l11 = this.v3 ^ l10;
        int n10 = this.c;
        this.sipRound(n10);
        l11 = this.v0;
        this.v0 = l10 ^= l11;
    }

    private void sipRound(int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            long l11 = this.v0;
            long l12 = this.v1;
            this.v0 = l11 += l12;
            l11 = this.v2;
            long l13 = this.v3;
            this.v2 = l11 += l13;
            this.v1 = l11 = Long.rotateLeft(l12, 13);
            l11 = this.v3;
            int n11 = 16;
            this.v3 = l11 = Long.rotateLeft(l11, n11);
            l12 = this.v1;
            l13 = this.v0;
            this.v1 = l12 ^= l13;
            l12 = this.v2;
            this.v3 = l11 ^= l12;
            int n12 = 32;
            this.v0 = l10 = Long.rotateLeft(l13, n12);
            long l14 = this.v2;
            long l15 = this.v1;
            this.v2 = l14 += l15;
            l14 = this.v3;
            this.v0 = l10 += l14;
            int n13 = 17;
            this.v1 = l10 = Long.rotateLeft(l15, n13);
            l10 = this.v3;
            int n14 = 21;
            this.v3 = l10 = Long.rotateLeft(l10, n14);
            l14 = this.v1;
            l15 = this.v2;
            this.v1 = l14 ^= l15;
            l14 = this.v0;
            this.v3 = l10 ^= l14;
            this.v2 = l11 = Long.rotateLeft(l15, n12);
        }
    }

    public HashCode makeHash() {
        long l10 = this.finalM;
        long l11 = this.b << 56;
        this.finalM = l10 ^= l11;
        this.processM(l10);
        this.v2 = l10 = this.v2 ^ 0xFFL;
        int n10 = this.d;
        this.sipRound(n10);
        l10 = this.v0;
        l11 = this.v1;
        l10 ^= l11;
        l11 = this.v2;
        l10 ^= l11;
        l11 = this.v3;
        return HashCode.fromLong(l10 ^ l11);
    }

    public void process(ByteBuffer byteBuffer) {
        long l10;
        this.b = l10 = this.b + (long)8;
        l10 = byteBuffer.getLong();
        this.processM(l10);
    }

    public void processRemaining(ByteBuffer byteBuffer) {
        boolean bl2;
        long l10 = this.b;
        int n10 = byteBuffer.remaining();
        long l11 = n10;
        this.b = l10 += l11;
        int n11 = 0;
        while (bl2 = byteBuffer.hasRemaining()) {
            long l12 = this.finalM;
            byte by2 = byteBuffer.get();
            long l13 = by2;
            long l14 = 255L;
            l13 = (l13 & l14) << n11;
            this.finalM = l12 ^= l13;
            n11 += 8;
        }
    }
}

