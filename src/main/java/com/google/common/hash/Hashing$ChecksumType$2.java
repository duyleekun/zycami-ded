/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Hashing$ChecksumType;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

public final class Hashing$ChecksumType$2
extends Hashing$ChecksumType {
    public Hashing$ChecksumType$2(String string3) {
    }

    public Checksum get() {
        Adler32 adler32 = new Adler32();
        return adler32;
    }
}

