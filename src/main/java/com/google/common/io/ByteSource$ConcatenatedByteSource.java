/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.MultiInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public final class ByteSource$ConcatenatedByteSource
extends ByteSource {
    public final Iterable sources;

    public ByteSource$ConcatenatedByteSource(Iterable iterable) {
        this.sources = iterable = (Iterable)Preconditions.checkNotNull(iterable);
    }

    public boolean isEmpty() {
        boolean bl2;
        Iterator iterator2 = this.sources.iterator();
        while (bl2 = iterator2.hasNext()) {
            ByteSource byteSource = (ByteSource)iterator2.next();
            bl2 = byteSource.isEmpty();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public InputStream openStream() {
        Iterator iterator2 = this.sources.iterator();
        MultiInputStream multiInputStream = new MultiInputStream(iterator2);
        return multiInputStream;
    }

    public long size() {
        Object object;
        long l10;
        Iterator iterator2 = this.sources.iterator();
        long l11 = l10 = 0L;
        while ((object = iterator2.hasNext()) != 0) {
            ByteSource byteSource = (ByteSource)iterator2.next();
            long l12 = byteSource.size();
            long l13 = (l11 += l12) - l10;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object >= 0) continue;
            return Long.MAX_VALUE;
        }
        return l11;
    }

    public Optional sizeIfKnown() {
        Object object;
        long l10;
        Object object2 = this.sources;
        boolean bl2 = object2 instanceof Collection;
        if (!bl2) {
            return Optional.absent();
        }
        object2 = object2.iterator();
        long l11 = l10 = 0L;
        while ((object = object2.hasNext()) != 0) {
            Serializable serializable = ((ByteSource)object2.next()).sizeIfKnown();
            boolean bl3 = ((Optional)serializable).isPresent();
            if (!bl3) {
                return Optional.absent();
            }
            long l12 = (Long)(serializable = (Long)((Optional)serializable).get());
            long l13 = (l11 += l12) - l10;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object >= 0) continue;
            return Optional.of(Long.MAX_VALUE);
        }
        return Optional.of(l11);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ByteSource.concat(");
        Iterable iterable = this.sources;
        stringBuilder.append(iterable);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

