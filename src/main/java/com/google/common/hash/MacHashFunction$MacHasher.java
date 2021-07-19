/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.MacHashFunction$1;
import java.nio.ByteBuffer;
import javax.crypto.Mac;

public final class MacHashFunction$MacHasher
extends AbstractByteHasher {
    private boolean done;
    private final Mac mac;

    private MacHashFunction$MacHasher(Mac mac) {
        this.mac = mac;
    }

    public /* synthetic */ MacHashFunction$MacHasher(Mac mac, MacHashFunction$1 macHashFunction$1) {
        this(mac);
    }

    private void checkNotDone() {
        Preconditions.checkState(this.done ^ true, "Cannot re-use a Hasher after calling hash() on it");
    }

    public HashCode hash() {
        this.checkNotDone();
        this.done = true;
        return HashCode.fromBytesNoCopy(this.mac.doFinal());
    }

    public void update(byte by2) {
        this.checkNotDone();
        this.mac.update(by2);
    }

    public void update(ByteBuffer byteBuffer) {
        this.checkNotDone();
        Preconditions.checkNotNull(byteBuffer);
        this.mac.update(byteBuffer);
    }

    public void update(byte[] byArray) {
        this.checkNotDone();
        this.mac.update(byArray);
    }

    public void update(byte[] byArray, int n10, int n11) {
        this.checkNotDone();
        this.mac.update(byArray, n10, n11);
    }
}

