/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.io.Reader;
import java.util.Iterator;

public class MultiReader
extends Reader {
    private Reader current;
    private final Iterator it;

    public MultiReader(Iterator iterator2) {
        this.it = iterator2;
        this.advance();
    }

    private void advance() {
        this.close();
        Object object = this.it;
        boolean bl2 = object.hasNext();
        if (bl2) {
            this.current = object = ((CharSource)this.it.next()).openStream();
        }
    }

    public void close() {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            }
            finally {
                this.current = null;
            }
        }
    }

    public int read(char[] cArray, int n10, int n11) {
        Reader reader = this.current;
        int n12 = -1;
        if (reader == null) {
            return n12;
        }
        int n13 = reader.read(cArray, n10, n11);
        if (n13 == n12) {
            this.advance();
            return this.read(cArray, n10, n11);
        }
        return n13;
    }

    public boolean ready() {
        boolean bl2;
        Reader reader = this.current;
        if (reader != null && (bl2 = reader.ready())) {
            bl2 = true;
        } else {
            bl2 = false;
            reader = null;
        }
        return bl2;
    }

    public long skip(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        boolean bl2 = object >= 0;
        String string2 = "n is negative";
        Preconditions.checkArgument(bl2, string2);
        if (object > 0) {
            Reader reader;
            while ((reader = this.current) != null) {
                long l13 = reader.skip(l10);
                long l14 = l13 - l11;
                Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 > 0) {
                    return l13;
                }
                this.advance();
            }
        }
        return l11;
    }
}

