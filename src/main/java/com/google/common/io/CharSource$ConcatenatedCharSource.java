/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import com.google.common.io.MultiReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.Iterator;

public final class CharSource$ConcatenatedCharSource
extends CharSource {
    private final Iterable sources;

    public CharSource$ConcatenatedCharSource(Iterable iterable) {
        this.sources = iterable = (Iterable)Preconditions.checkNotNull(iterable);
    }

    public boolean isEmpty() {
        boolean bl2;
        Iterator iterator2 = this.sources.iterator();
        while (bl2 = iterator2.hasNext()) {
            CharSource charSource = (CharSource)iterator2.next();
            bl2 = charSource.isEmpty();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public long length() {
        boolean bl2;
        Iterator iterator2 = this.sources.iterator();
        long l10 = 0L;
        while (bl2 = iterator2.hasNext()) {
            CharSource charSource = (CharSource)iterator2.next();
            long l11 = charSource.length();
            l10 += l11;
        }
        return l10;
    }

    public Optional lengthIfKnown() {
        boolean bl2;
        Iterator iterator2 = this.sources.iterator();
        long l10 = 0L;
        while (bl2 = iterator2.hasNext()) {
            Serializable serializable = ((CharSource)iterator2.next()).lengthIfKnown();
            boolean bl3 = ((Optional)serializable).isPresent();
            if (!bl3) {
                return Optional.absent();
            }
            serializable = (Long)((Optional)serializable).get();
            long l11 = (Long)serializable;
            l10 += l11;
        }
        return Optional.of(l10);
    }

    public Reader openStream() {
        Iterator iterator2 = this.sources.iterator();
        MultiReader multiReader = new MultiReader(iterator2);
        return multiReader;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharSource.concat(");
        Iterable iterable = this.sources;
        stringBuilder.append(iterable);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

