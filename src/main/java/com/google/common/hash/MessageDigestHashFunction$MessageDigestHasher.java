/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.MessageDigestHashFunction$1;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

public final class MessageDigestHashFunction$MessageDigestHasher
extends AbstractByteHasher {
    private final int bytes;
    private final MessageDigest digest;
    private boolean done;

    private MessageDigestHashFunction$MessageDigestHasher(MessageDigest messageDigest, int n10) {
        this.digest = messageDigest;
        this.bytes = n10;
    }

    public /* synthetic */ MessageDigestHashFunction$MessageDigestHasher(MessageDigest messageDigest, int n10, MessageDigestHashFunction$1 messageDigestHashFunction$1) {
        this(messageDigest, n10);
    }

    private void checkNotDone() {
        Preconditions.checkState(this.done ^ true, "Cannot re-use a Hasher after calling hash() on it");
    }

    public HashCode hash() {
        Object object;
        this.checkNotDone();
        this.done = true;
        int n10 = this.bytes;
        MessageDigest messageDigest = this.digest;
        int n11 = messageDigest.getDigestLength();
        if (n10 == n11) {
            object = HashCode.fromBytesNoCopy(this.digest.digest());
        } else {
            object = this.digest.digest();
            n11 = this.bytes;
            object = HashCode.fromBytesNoCopy(Arrays.copyOf(object, n11));
        }
        return object;
    }

    public void update(byte by2) {
        this.checkNotDone();
        this.digest.update(by2);
    }

    public void update(ByteBuffer byteBuffer) {
        this.checkNotDone();
        this.digest.update(byteBuffer);
    }

    public void update(byte[] byArray, int n10, int n11) {
        this.checkNotDone();
        this.digest.update(byArray, n10, n11);
    }
}

