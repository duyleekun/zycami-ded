/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.util.Assertions;
import java.io.BufferedReader;
import java.util.NoSuchElementException;
import java.util.Queue;

public class HlsPlaylistParser$LineIterator {
    private final Queue extraLines;
    private String next;
    private final BufferedReader reader;

    public HlsPlaylistParser$LineIterator(Queue queue, BufferedReader bufferedReader) {
        this.extraLines = queue;
        this.reader = bufferedReader;
    }

    public boolean hasNext() {
        block3: {
            Object object = this.next;
            boolean bl2 = true;
            if (object != null) {
                return bl2;
            }
            object = this.extraLines;
            boolean bl3 = object.isEmpty();
            if (!bl3) {
                this.next = object = (String)Assertions.checkNotNull((String)this.extraLines.poll());
                return bl2;
            }
            do {
                this.next = object = this.reader.readLine();
                if (object == null) break block3;
                this.next = object = ((String)object).trim();
            } while (bl3 = ((String)object).isEmpty());
            return bl2;
        }
        return false;
    }

    public String next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            String string2 = this.next;
            this.next = null;
            return string2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

