/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractByteHasher;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.ChecksumHashFunction$1;
import com.google.common.hash.HashCode;
import java.util.zip.Checksum;

public final class ChecksumHashFunction$ChecksumHasher
extends AbstractByteHasher {
    private final Checksum checksum;
    public final /* synthetic */ ChecksumHashFunction this$0;

    private ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction object, Checksum checksum) {
        this.this$0 = object;
        this.checksum = object = (Checksum)Preconditions.checkNotNull(checksum);
    }

    public /* synthetic */ ChecksumHashFunction$ChecksumHasher(ChecksumHashFunction checksumHashFunction, Checksum checksum, ChecksumHashFunction$1 checksumHashFunction$1) {
        this(checksumHashFunction, checksum);
    }

    public HashCode hash() {
        int n10;
        Checksum checksum = this.checksum;
        long l10 = checksum.getValue();
        ChecksumHashFunction checksumHashFunction = this.this$0;
        int n11 = ChecksumHashFunction.access$100(checksumHashFunction);
        if (n11 == (n10 = 32)) {
            return HashCode.fromInt((int)l10);
        }
        return HashCode.fromLong(l10);
    }

    public void update(byte by2) {
        this.checksum.update(by2);
    }

    public void update(byte[] byArray, int n10, int n11) {
        this.checksum.update(byArray, n10, n11);
    }
}

