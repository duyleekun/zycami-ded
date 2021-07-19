/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.TeeAudioProcessor$AudioBufferSink;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class TeeAudioProcessor$WavFileAudioBufferSink
implements TeeAudioProcessor$AudioBufferSink {
    private static final int FILE_SIZE_MINUS_44_OFFSET = 40;
    private static final int FILE_SIZE_MINUS_8_OFFSET = 4;
    private static final int HEADER_LENGTH = 44;
    private static final String TAG = "WaveFileAudioBufferSink";
    private int bytesWritten;
    private int channelCount;
    private int counter;
    private int encoding;
    private final String outputFileNamePrefix;
    private RandomAccessFile randomAccessFile;
    private int sampleRateHz;
    private final byte[] scratchBuffer;
    private final ByteBuffer scratchByteBuffer;

    public TeeAudioProcessor$WavFileAudioBufferSink(String object) {
        this.outputFileNamePrefix = object;
        object = new byte[1024];
        this.scratchBuffer = (byte[])object;
        object = ByteBuffer.wrap((byte[])object);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.scratchByteBuffer = object = ((ByteBuffer)object).order(byteOrder);
    }

    private String getNextOutputFileName() {
        int n10;
        Object object;
        Object[] objectArray = new Object[2];
        objectArray[0] = object = this.outputFileNamePrefix;
        int n11 = this.counter;
        this.counter = n10 = n11 + 1;
        objectArray[1] = object = Integer.valueOf(n11);
        return Util.formatInvariant("%s-%04d.wav", objectArray);
    }

    private void maybePrepareFile() {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            return;
        }
        String string2 = this.getNextOutputFileName();
        randomAccessFile = new RandomAccessFile(string2, "rw");
        this.writeFileHeader(randomAccessFile);
        this.randomAccessFile = randomAccessFile;
        this.bytesWritten = 44;
    }

    private void reset() {
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile == null) {
            return;
        }
        Object object = this.scratchByteBuffer;
        ((ByteBuffer)object).clear();
        object = this.scratchByteBuffer;
        int n10 = this.bytesWritten + -8;
        ((ByteBuffer)object).putInt(n10);
        long l10 = 4;
        randomAccessFile.seek(l10);
        object = this.scratchBuffer;
        n10 = 4;
        String string2 = null;
        randomAccessFile.write((byte[])object, 0, n10);
        object = this.scratchByteBuffer;
        ((ByteBuffer)object).clear();
        object = this.scratchByteBuffer;
        int n11 = this.bytesWritten + -44;
        ((ByteBuffer)object).putInt(n11);
        long l11 = 40;
        randomAccessFile.seek(l11);
        object = this.scratchBuffer;
        try {
            randomAccessFile.write((byte[])object, 0, n10);
        }
        catch (IOException iOException) {
            String string3 = TAG;
            string2 = "Error updating file size";
            Log.w(string3, string2, iOException);
        }
        object = null;
        try {
            randomAccessFile.close();
            return;
        }
        finally {
            this.randomAccessFile = null;
        }
    }

    private void writeBuffer(ByteBuffer byteBuffer) {
        int n10;
        RandomAccessFile randomAccessFile = (RandomAccessFile)Assertions.checkNotNull(this.randomAccessFile);
        while ((n10 = byteBuffer.hasRemaining()) != 0) {
            n10 = byteBuffer.remaining();
            int n11 = this.scratchBuffer.length;
            n10 = Math.min(n10, n11);
            byte[] byArray = this.scratchBuffer;
            byteBuffer.get(byArray, 0, n10);
            byArray = this.scratchBuffer;
            randomAccessFile.write(byArray, 0, n10);
            this.bytesWritten = n11 = this.bytesWritten + n10;
        }
    }

    private void writeFileHeader(RandomAccessFile randomAccessFile) {
        randomAccessFile.writeInt(1380533830);
        int n10 = -1;
        randomAccessFile.writeInt(n10);
        randomAccessFile.writeInt(1463899717);
        randomAccessFile.writeInt(1718449184);
        this.scratchByteBuffer.clear();
        this.scratchByteBuffer.putInt(16);
        Object object = this.scratchByteBuffer;
        int n11 = WavUtil.getTypeForPcmEncoding(this.encoding);
        ((ByteBuffer)object).putShort((short)n11);
        object = this.scratchByteBuffer;
        n11 = (short)this.channelCount;
        ((ByteBuffer)object).putShort((short)n11);
        object = this.scratchByteBuffer;
        n11 = this.sampleRateHz;
        ((ByteBuffer)object).putInt(n11);
        int s10 = this.encoding;
        n11 = this.channelCount;
        int n12 = Util.getPcmFrameSize(s10, n11);
        ByteBuffer byteBuffer = this.scratchByteBuffer;
        int n13 = this.sampleRateHz * n12;
        byteBuffer.putInt(n13);
        byteBuffer = this.scratchByteBuffer;
        n13 = (short)n12;
        byteBuffer.putShort((short)n13);
        byteBuffer = this.scratchByteBuffer;
        int n14 = n12 * 8;
        n13 = this.channelCount;
        short s11 = (short)(n14 / n13);
        byteBuffer.putShort(s11);
        object = this.scratchBuffer;
        n11 = this.scratchByteBuffer.position();
        randomAccessFile.write((byte[])object, 0, n11);
        randomAccessFile.writeInt(1684108385);
        randomAccessFile.writeInt(n10);
    }

    public void flush(int n10, int n11, int n12) {
        try {
            this.reset();
        }
        catch (IOException iOException) {
            String string2 = TAG;
            String string3 = "Error resetting";
            Log.e(string2, string3, iOException);
        }
        this.sampleRateHz = n10;
        this.channelCount = n11;
        this.encoding = n12;
    }

    public void handleBuffer(ByteBuffer byteBuffer) {
        this.maybePrepareFile();
        try {
            this.writeBuffer(byteBuffer);
        }
        catch (IOException iOException) {
            String string2 = TAG;
            String string3 = "Error writing data";
            Log.e(string2, string3, iOException);
        }
    }
}

