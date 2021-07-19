/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ByteSource$ByteArrayByteSource
extends ByteSource {
    public final byte[] bytes;
    public final int length;
    public final int offset;

    public ByteSource$ByteArrayByteSource(byte[] byArray) {
        int n10 = byArray.length;
        this(byArray, 0, n10);
    }

    public ByteSource$ByteArrayByteSource(byte[] byArray, int n10, int n11) {
        this.bytes = byArray;
        this.offset = n10;
        this.length = n11;
    }

    public long copyTo(OutputStream outputStream) {
        byte[] byArray = this.bytes;
        int n10 = this.offset;
        int n11 = this.length;
        outputStream.write(byArray, n10, n11);
        return this.length;
    }

    public HashCode hash(HashFunction hashFunction) {
        byte[] byArray = this.bytes;
        int n10 = this.offset;
        int n11 = this.length;
        return hashFunction.hashBytes(byArray, n10, n11);
    }

    public boolean isEmpty() {
        int n10 = this.length;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public InputStream openBufferedStream() {
        return this.openStream();
    }

    public InputStream openStream() {
        byte[] byArray = this.bytes;
        int n10 = this.offset;
        int n11 = this.length;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, n10, n11);
        return byteArrayInputStream;
    }

    public Object read(ByteProcessor byteProcessor) {
        byte[] byArray = this.bytes;
        int n10 = this.offset;
        int n11 = this.length;
        byteProcessor.processBytes(byArray, n10, n11);
        return byteProcessor.getResult();
    }

    public byte[] read() {
        byte[] byArray = this.bytes;
        int n10 = this.offset;
        int n11 = this.length + n10;
        return Arrays.copyOfRange(byArray, n10, n11);
    }

    public long size() {
        return this.length;
    }

    public Optional sizeIfKnown() {
        return Optional.of(this.length);
    }

    public ByteSource slice(long l10, long l11) {
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        boolean bl2 = true;
        l13 = l13 >= 0 ? (long)bl2 : (long)0;
        String string2 = "offset (%s) may not be negative";
        Preconditions.checkArgument((boolean)l13, string2, l10);
        long l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l14 < 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "length (%s) may not be negative", l11);
        l12 = this.length;
        l10 = Math.min(l10, l12);
        l12 = (long)this.length - l10;
        l11 = Math.min(l11, l12);
        l14 = this.offset;
        int n10 = (int)l10;
        byte[] byArray = this.bytes;
        int n11 = (int)l11;
        ByteSource$ByteArrayByteSource byteSource$ByteArrayByteSource = new ByteSource$ByteArrayByteSource(byArray, (int)(l14 += n10), n11);
        return byteSource$ByteArrayByteSource;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ByteSource.wrap(");
        Object object = BaseEncoding.base16();
        byte[] byArray = this.bytes;
        int n10 = this.offset;
        int n11 = this.length;
        object = Ascii.truncate(((BaseEncoding)object).encode(byArray, n10, n11), 30, "...");
        stringBuilder.append((String)object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

