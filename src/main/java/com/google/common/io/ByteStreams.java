/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteStreams$1;
import com.google.common.io.ByteStreams$ByteArrayDataInputStream;
import com.google.common.io.ByteStreams$ByteArrayDataOutputStream;
import com.google.common.io.ByteStreams$LimitedInputStream;
import com.google.common.math.IntMath;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 0x7FFFFFF7;
    private static final OutputStream NULL_OUTPUT_STREAM;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    static {
        ByteStreams$1 byteStreams$1 = new ByteStreams$1();
        NULL_OUTPUT_STREAM = byteStreams$1;
    }

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Deque deque, int n10) {
        int n11;
        byte[] byArray = new byte[n10];
        for (int i10 = n10; i10 > 0; i10 -= n11) {
            byte[] byArray2 = (byte[])deque.removeFirst();
            n11 = byArray2.length;
            n11 = Math.min(i10, n11);
            int n12 = n10 - i10;
            System.arraycopy(byArray2, 0, byArray, n12, n11);
        }
        return byArray;
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] byArray = ByteStreams.createBuffer();
        long l10 = 0L;
        int n10;
        int n11;
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n10 = 0;
            outputStream.write(byArray, 0, n11);
            long l11 = n11;
            l10 += l11;
        }
        return l10;
    }

    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        int n10;
        int n11;
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        boolean bl2 = readableByteChannel instanceof FileChannel;
        long l10 = 0L;
        if (bl2) {
            long l11;
            long l12;
            long l13;
            long l14;
            ReadableByteChannel readableByteChannel2 = readableByteChannel;
            readableByteChannel2 = (FileChannel)readableByteChannel;
            long l15 = l14 = ((FileChannel)readableByteChannel2).position();
            do {
                long l16 = 524288L;
                l12 = ((FileChannel)readableByteChannel2).transferTo(l15, l16, writableByteChannel);
                ((FileChannel)readableByteChannel2).position(l15 += l12);
            } while ((l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) > 0 || (l13 = (l11 = l15 - (l12 = ((FileChannel)readableByteChannel2).size())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0);
            return l15 - l14;
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(ByteStreams.createBuffer());
        while ((n11 = readableByteChannel.read(byteBuffer)) != (n10 = -1)) {
            byteBuffer.flip();
            while ((n11 = (int)(byteBuffer.hasRemaining() ? 1 : 0)) != 0) {
                n11 = writableByteChannel.write(byteBuffer);
                long l17 = n11;
                l10 += l17;
            }
            byteBuffer.clear();
        }
        return l10;
    }

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    public static long exhaust(InputStream inputStream) {
        long l10;
        int n10;
        long l11;
        long l12;
        long l13;
        byte[] byArray = ByteStreams.createBuffer();
        long l14 = 0L;
        while ((l13 = (l12 = (l11 = (long)(n10 = inputStream.read(byArray))) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            l14 += l11;
        }
        return l14;
    }

    public static InputStream limit(InputStream inputStream, long l10) {
        ByteStreams$LimitedInputStream byteStreams$LimitedInputStream = new ByteStreams$LimitedInputStream(inputStream, l10);
        return byteStreams$LimitedInputStream;
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream = (ByteArrayInputStream)Preconditions.checkNotNull(byteArrayInputStream);
        ByteStreams$ByteArrayDataInputStream byteStreams$ByteArrayDataInputStream = new ByteStreams$ByteArrayDataInputStream(byteArrayInputStream);
        return byteStreams$ByteArrayDataInputStream;
    }

    public static ByteArrayDataInput newDataInput(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return ByteStreams.newDataInput(byteArrayInputStream);
    }

    public static ByteArrayDataInput newDataInput(byte[] byArray, int n10) {
        int n11 = byArray.length;
        Preconditions.checkPositionIndex(n10, n11);
        int n12 = byArray.length - n10;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, n10, n12);
        return ByteStreams.newDataInput(byteArrayInputStream);
    }

    public static ByteArrayDataOutput newDataOutput() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        return ByteStreams.newDataOutput(byteArrayOutputStream);
    }

    public static ByteArrayDataOutput newDataOutput(int n10) {
        if (n10 >= 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n10);
            return ByteStreams.newDataOutput(byteArrayOutputStream);
        }
        Object object = n10;
        Object[] objectArray = new Object[]{object};
        object = String.format("Invalid size: %s", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream = (ByteArrayOutputStream)Preconditions.checkNotNull(byteArrayOutputStream);
        ByteStreams$ByteArrayDataOutputStream byteStreams$ByteArrayDataOutputStream = new ByteStreams$ByteArrayDataOutputStream(byteArrayOutputStream);
        return byteStreams$ByteArrayDataOutputStream;
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static int read(InputStream object, byte[] object2, int n10, int n11) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        if (n11 >= 0) {
            int n12;
            int n13 = n10 + n11;
            int n14 = ((byte[])object2).length;
            Preconditions.checkPositionIndexes(n10, n13, n14);
            for (n12 = 0; n12 < n11; n12 += n13) {
                n13 = n10 + n12;
                n14 = n11 - n12;
                if ((n13 = ((InputStream)object).read((byte[])object2, n13, n14)) == (n14 = -1)) break;
            }
            return n12;
        }
        object2 = new Object[1];
        Integer n15 = n11;
        object2[0] = (byte)n15;
        object2 = String.format("len (%s) cannot be negative", object2);
        object = new IndexOutOfBoundsException((String)object2);
        throw object;
    }

    public static Object readBytes(InputStream inputStream, ByteProcessor byteProcessor) {
        int n10;
        int n11;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] byArray = ByteStreams.createBuffer();
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n10 = 0;
            if ((n11 = (int)(byteProcessor.processBytes(byArray, 0, n11) ? 1 : 0)) != 0) continue;
        }
        return byteProcessor.getResult();
    }

    public static void readFully(InputStream inputStream, byte[] byArray) {
        int n10 = byArray.length;
        ByteStreams.readFully(inputStream, byArray, 0, n10);
    }

    public static void readFully(InputStream object, byte[] object2, int n10, int n11) {
        int n12 = ByteStreams.read((InputStream)object, object2, n10, n11);
        if (n12 == n11) {
            return;
        }
        object2 = new EOFException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reached end of stream after reading ");
        stringBuilder.append(n12);
        stringBuilder.append(" bytes; ");
        stringBuilder.append(n11);
        stringBuilder.append(" bytes expected");
        object = stringBuilder.toString();
        object2((String)object);
        throw object2;
    }

    public static void skipFully(InputStream object, long l10) {
        long l11 = ByteStreams.skipUpTo((InputStream)object, l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reached end of stream after skipping ");
        stringBuilder.append(l11);
        stringBuilder.append(" bytes; ");
        stringBuilder.append(l10);
        stringBuilder.append(" bytes expected");
        String string2 = stringBuilder.toString();
        object = new EOFException(string2);
        throw object;
    }

    private static long skipSafely(InputStream inputStream, long l10) {
        long l11;
        int n10 = inputStream.available();
        if (n10 == 0) {
            l11 = 0L;
        } else {
            long l12 = n10;
            l10 = Math.min(l12, l10);
            l11 = inputStream.skip(l10);
        }
        return l11;
    }

    public static long skipUpTo(InputStream inputStream, long l10) {
        long l11;
        long l12 = 0L;
        byte[] byArray = null;
        long l13 = l12;
        while ((l11 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) < 0) {
            long l14 = l10 - l13;
            long l15 = ByteStreams.skipSafely(inputStream, l14);
            long l16 = l15 - l12;
            Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object == false) {
                long l17;
                l15 = 8192L;
                l14 = Math.min(l14, l15);
                l11 = (int)l14;
                if (byArray == null) {
                    byArray = new byte[l11];
                }
                if ((l11 = (l17 = (l15 = (long)inputStream.read(byArray, 0, (int)l11)) - (l14 = (long)-1)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) == false) break;
            }
            l13 += l15;
        }
        return l13;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        ArrayDeque arrayDeque = new ArrayDeque(20);
        return ByteStreams.toByteArrayInternal(inputStream, arrayDeque, 0);
    }

    public static byte[] toByteArray(InputStream object, long l10) {
        StringBuilder stringBuilder;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l12 >= 0) {
            l12 = n10;
        } else {
            l12 = 0;
            stringBuilder = null;
        }
        ArrayDeque<byte[]> arrayDeque = "expectedSize (%s) must be non-negative";
        Preconditions.checkArgument((boolean)l12, (String)((Object)arrayDeque), l10);
        long l13 = 0x7FFFFFF7L;
        l12 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (l12 <= 0) {
            int n11;
            int n12 = (int)l10;
            byte[] byArray = new byte[n12];
            l12 = n12;
            while (true) {
                n11 = -1;
                if (l12 <= 0) break;
                int n13 = n12 - l12;
                int n14 = ((InputStream)object).read(byArray, n13, (int)l12);
                if (n14 == n11) {
                    return Arrays.copyOf(byArray, n13);
                }
                l12 -= n14;
            }
            l12 = ((InputStream)object).read();
            if (l12 == n11) {
                return byArray;
            }
            arrayDeque = new ArrayDeque<byte[]>(22);
            arrayDeque.add(byArray);
            byArray = new byte[n10];
            l12 = (byte)l12;
            byArray[0] = (byte)l12;
            arrayDeque.add(byArray);
            return ByteStreams.toByteArrayInternal((InputStream)object, arrayDeque, n12 += n10);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(l10);
        stringBuilder.append(" bytes is too large to fit in a byte array");
        String string2 = stringBuilder.toString();
        object = new OutOfMemoryError(string2);
        throw object;
    }

    private static byte[] toByteArrayInternal(InputStream object, Deque deque, int n10) {
        int n11;
        int n12;
        int n13 = 8192;
        while (true) {
            n12 = -1;
            n11 = 0x7FFFFFF7;
            if (n10 >= n11) break;
            n11 -= n10;
            n11 = Math.min(n13, n11);
            byte[] byArray = new byte[n11];
            deque.add(byArray);
            int n14 = 0;
            while (n14 < n11) {
                int n15 = n11 - n14;
                if ((n15 = ((InputStream)object).read(byArray, n14, n15)) == n12) {
                    return ByteStreams.combineBuffers(deque, n10);
                }
                n14 += n15;
                n10 += n15;
            }
            n12 = 2;
            n13 = IntMath.saturatedMultiply(n13, n12);
        }
        int n16 = ((InputStream)object).read();
        if (n16 == n12) {
            return ByteStreams.combineBuffers(deque, n11);
        }
        object = new OutOfMemoryError("input is too large to fit in a byte array");
        throw object;
    }
}

