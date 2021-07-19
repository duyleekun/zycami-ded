/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public final class CharSequenceReader
extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = charSequence = (CharSequence)Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() {
        Object object = this.seq;
        if (object != null) {
            return;
        }
        object = new IOException("reader closed");
        throw object;
    }

    private boolean hasRemaining() {
        int n10 = this.remaining();
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    private int remaining() {
        int n10 = this.seq.length();
        int n11 = this.pos;
        return n10 - n11;
    }

    public void close() {
        synchronized (this) {
            Object var1_1 = null;
            this.seq = null;
            return;
        }
    }

    public void mark(int n10) {
        synchronized (this) {
            boolean bl2 = n10 >= 0;
            String string2 = "readAheadLimit (%s) may not be negative";
            Preconditions.checkArgument(bl2, string2, n10);
            this.checkOpen();
            n10 = this.pos;
            this.mark = n10;
            return;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        synchronized (this) {
            int n10;
            block8: {
                block7: {
                    this.checkOpen();
                    n10 = this.hasRemaining();
                    if (n10 == 0) break block7;
                    CharSequence charSequence = this.seq;
                    int n11 = this.pos;
                    int n12 = n11 + 1;
                    this.pos = n12;
                    n10 = charSequence.charAt(n11);
                    break block8;
                }
                n10 = -1;
            }
            return n10;
        }
    }

    public int read(CharBuffer charBuffer) {
        synchronized (this) {
            int n10;
            block12: {
                Preconditions.checkNotNull(charBuffer);
                this.checkOpen();
                n10 = this.hasRemaining();
                if (n10 != 0) break block12;
                return -1;
            }
            n10 = charBuffer.remaining();
            int n11 = this.remaining();
            n10 = Math.min(n10, n11);
            for (n11 = 0; n11 < n10; ++n11) {
                CharSequence charSequence = this.seq;
                int n12 = this.pos;
                int n13 = n12 + 1;
                this.pos = n13;
                char c10 = charSequence.charAt(n12);
                charBuffer.put(c10);
                continue;
            }
            return n10;
        }
    }

    public int read(char[] cArray, int n10, int n11) {
        synchronized (this) {
            int n12;
            int n13;
            block12: {
                n13 = n10 + n11;
                n12 = cArray.length;
                Preconditions.checkPositionIndexes(n10, n13, n12);
                this.checkOpen();
                n13 = (int)(this.hasRemaining() ? 1 : 0);
                if (n13 != 0) break block12;
                return -1;
            }
            n13 = this.remaining();
            n11 = Math.min(n11, n13);
            for (n13 = 0; n13 < n11; ++n13) {
                n12 = n10 + n13;
                CharSequence charSequence = this.seq;
                int n14 = this.pos;
                int n15 = n14 + 1;
                this.pos = n15;
                char c10 = charSequence.charAt(n14);
                cArray[n12] = c10;
                continue;
            }
            return n11;
        }
    }

    public boolean ready() {
        synchronized (this) {
            this.checkOpen();
            return true;
        }
    }

    public void reset() {
        synchronized (this) {
            this.checkOpen();
            int n10 = this.mark;
            this.pos = n10;
            return;
        }
    }

    public long skip(long l10) {
        synchronized (this) {
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            l12 = l12 >= 0 ? (long)1 : (long)0;
            String string2 = "n (%s) may not be negative";
            Preconditions.checkArgument((boolean)l12, string2, l10);
            this.checkOpen();
            l12 = this.remaining();
            l11 = l12;
            l10 = Math.min(l11, l10);
            int n10 = (int)l10;
            int n11 = this.pos + n10;
            this.pos = n11;
            l10 = n10;
            return l10;
        }
    }
}

