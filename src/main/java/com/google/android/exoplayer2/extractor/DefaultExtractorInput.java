/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class DefaultExtractorInput
implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataReader dataReader;
    private byte[] peekBuffer;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final byte[] scratchSpace;
    private final long streamLength;

    public DefaultExtractorInput(DataReader object, long l10, long l11) {
        this.dataReader = object;
        this.position = l10;
        this.streamLength = l11;
        object = new byte[65536];
        this.peekBuffer = (byte[])object;
        object = new byte[4096];
        this.scratchSpace = (byte[])object;
    }

    private void commitBytesRead(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            long l10 = this.position;
            long l11 = n10;
            this.position = l10 += l11;
        }
    }

    private void ensureSpaceForPeek(int n10) {
        int n11 = this.peekBufferPosition + n10;
        byte[] byArray = this.peekBuffer;
        int n12 = byArray.length;
        if (n11 > n12) {
            n10 = byArray.length * 2;
            n12 = 65536 + n11;
            int n13 = 524288;
            n10 = Util.constrainValue(n10, n12, n11 += n13);
            byte[] byArray2 = this.peekBuffer;
            this.peekBuffer = byArray = Arrays.copyOf(byArray2, n10);
        }
    }

    private int readFromPeekBuffer(byte[] byArray, int n10, int n11) {
        int n12 = this.peekBufferLength;
        if (n12 == 0) {
            return 0;
        }
        n11 = Math.min(n12, n11);
        System.arraycopy(this.peekBuffer, 0, byArray, n10, n11);
        this.updatePeekBuffer(n11);
        return n11;
    }

    private int readFromUpstream(byte[] object, int n10, int n11, int n12, boolean bl2) {
        boolean bl3 = Thread.interrupted();
        if (!bl3) {
            DataReader dataReader = this.dataReader;
            n10 += n12;
            int n13 = dataReader.read((byte[])object, n10, n11 -= n12);
            if (n13 == (n10 = -1)) {
                if (n12 == 0 && bl2) {
                    return n10;
                }
                object = new EOFException;
                object();
                throw object;
            }
            return n12 + n13;
        }
        object = new InterruptedIOException;
        object();
        throw object;
    }

    private int skipFromPeekBuffer(int n10) {
        n10 = Math.min(this.peekBufferLength, n10);
        this.updatePeekBuffer(n10);
        return n10;
    }

    private void updatePeekBuffer(int n10) {
        byte[] byArray;
        int n11;
        this.peekBufferLength = n11 = this.peekBufferLength - n10;
        this.peekBufferPosition = 0;
        byte[] byArray2 = this.peekBuffer;
        int n12 = byArray2.length;
        int n13 = 524288;
        if (n11 < (n12 -= n13)) {
            n12 = 65536 + n11;
            byArray = new byte[n12];
        } else {
            byArray = byArray2;
        }
        System.arraycopy(byArray2, n10, byArray, 0, n11);
        this.peekBuffer = byArray;
    }

    public void advancePeekPosition(int n10) {
        this.advancePeekPosition(n10, false);
    }

    public boolean advancePeekPosition(int n10, boolean bl2) {
        int n11;
        this.ensureSpaceForPeek(n10);
        int n12 = this.peekBufferLength;
        int n13 = this.peekBufferPosition;
        int n14 = n12 -= n13;
        while (n14 < n10) {
            byte[] byArray = this.peekBuffer;
            int n15 = this.peekBufferPosition;
            if ((n14 = this.readFromUpstream(byArray, n15, n10, n14, bl2)) == (n12 = -1)) {
                return false;
            }
            this.peekBufferLength = n12 = this.peekBufferPosition + n14;
        }
        this.peekBufferPosition = n11 = this.peekBufferPosition + n10;
        return true;
    }

    public long getLength() {
        return this.streamLength;
    }

    public long getPeekPosition() {
        long l10 = this.position;
        long l11 = this.peekBufferPosition;
        return l10 + l11;
    }

    public long getPosition() {
        return this.position;
    }

    public int peek(byte[] byArray, int n10, int n11) {
        int n12;
        this.ensureSpaceForPeek(n11);
        int n13 = this.peekBufferLength;
        int n14 = this.peekBufferPosition;
        if ((n13 -= n14) == 0) {
            byte[] byArray2 = this.peekBuffer;
            boolean bl2 = true;
            if ((n11 = this.readFromUpstream(byArray2, n14, n11, 0, bl2)) == (n13 = -1)) {
                return n13;
            }
            this.peekBufferLength = n13 = this.peekBufferLength + n11;
        } else {
            n11 = Math.min(n11, n13);
        }
        byte[] byArray3 = this.peekBuffer;
        int n15 = this.peekBufferPosition;
        System.arraycopy(byArray3, n15, byArray, n10, n11);
        this.peekBufferPosition = n12 = this.peekBufferPosition + n11;
        return n11;
    }

    public void peekFully(byte[] byArray, int n10, int n11) {
        this.peekFully(byArray, n10, n11, false);
    }

    public boolean peekFully(byte[] byArray, int n10, int n11, boolean bl2) {
        if (!(bl2 = this.advancePeekPosition(n11, bl2))) {
            return false;
        }
        byte[] byArray2 = this.peekBuffer;
        int n12 = this.peekBufferPosition - n11;
        System.arraycopy(byArray2, n12, byArray, n10, n11);
        return true;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = this.readFromPeekBuffer(byArray, n10, n11);
        if (n12 == 0) {
            boolean bl2 = true;
            n12 = this.readFromUpstream(byArray, n10, n11, 0, bl2);
        }
        this.commitBytesRead(n12);
        return n12;
    }

    public void readFully(byte[] byArray, int n10, int n11) {
        this.readFully(byArray, n10, n11, false);
    }

    public boolean readFully(byte[] byArray, int n10, int n11, boolean bl2) {
        boolean bl3;
        int n12;
        int n13 = n12 = this.readFromPeekBuffer(byArray, n10, n11);
        while (true) {
            n12 = -1;
            if (n13 >= n11 || n13 == n12) break;
            n13 = this.readFromUpstream(byArray, n10, n11, n13, bl2);
        }
        this.commitBytesRead(n13);
        if (n13 != n12) {
            bl3 = true;
        } else {
            bl3 = false;
            byArray = null;
        }
        return bl3;
    }

    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    public void setRetryPosition(long l10, Throwable throwable) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Assertions.checkArgument((boolean)object);
        this.position = l10;
        throw throwable;
    }

    public int skip(int n10) {
        int n11 = this.skipFromPeekBuffer(n10);
        if (n11 == 0) {
            byte[] byArray = this.scratchSpace;
            n11 = byArray.length;
            int n12 = Math.min(n10, n11);
            boolean bl2 = true;
            n11 = this.readFromUpstream(byArray, 0, n12, 0, bl2);
        }
        this.commitBytesRead(n11);
        return n11;
    }

    public void skipFully(int n10) {
        this.skipFully(n10, false);
    }

    public boolean skipFully(int n10, boolean bl2) {
        int n11;
        int n12 = n11 = this.skipFromPeekBuffer(n10);
        while (true) {
            n11 = -1;
            if (n12 >= n10 || n12 == n11) break;
            byte[] byArray = this.scratchSpace;
            n11 = byArray.length + n12;
            int n13 = Math.min(n10, n11);
            byte[] byArray2 = this.scratchSpace;
            int n14 = -n12;
            n12 = this.readFromUpstream(byArray2, n14, n13, n12, bl2);
        }
        this.commitBytesRead(n12);
        n10 = n12 != n11 ? 1 : 0;
        return n10 != 0;
    }
}

