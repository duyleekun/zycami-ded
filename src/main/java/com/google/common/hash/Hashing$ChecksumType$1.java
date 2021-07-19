/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Hashing$ChecksumType;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public final class Hashing$ChecksumType$1
extends Hashing$ChecksumType {
    public Hashing$ChecksumType$1(String string3) {
    }

    public Checksum get() {
        CRC32 cRC32 = new CRC32();
        return cRC32;
    }
}

