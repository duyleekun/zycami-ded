/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class ParsableByteArray {
    private byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this.data = byArray;
    }

    public ParsableByteArray(int n10) {
        byte[] byArray = new byte[n10];
        this.data = byArray;
        this.limit = n10;
    }

    public ParsableByteArray(byte[] byArray) {
        int n10;
        this.data = byArray;
        this.limit = n10 = byArray.length;
    }

    public ParsableByteArray(byte[] byArray, int n10) {
        this.data = byArray;
        this.limit = n10;
    }

    public int bytesLeft() {
        int n10 = this.limit;
        int n11 = this.position;
        return n10 - n11;
    }

    public int capacity() {
        return this.data.length;
    }

    public void ensureCapacity(int n10) {
        int n11 = this.capacity();
        if (n10 > n11) {
            byte[] byArray = this.data;
            byte[] byArray2 = Arrays.copyOf(byArray, n10);
            this.data = byArray2;
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        byte[] byArray = this.data;
        int n10 = this.position;
        int n11 = (byArray[n10] & 0xFF) << 8;
        return (char)(byArray[++n10] & 0xFF | n11);
    }

    public int peekUnsignedByte() {
        byte[] byArray = this.data;
        int n10 = this.position;
        return byArray[n10] & 0xFF;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int n10) {
        byte[] byArray = parsableBitArray.data;
        this.readBytes(byArray, 0, n10);
        parsableBitArray.setPosition(0);
    }

    public void readBytes(ByteBuffer byteBuffer, int n10) {
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        byteBuffer.put(byArray, n12, n10);
        this.position = n11 = this.position + n10;
    }

    public void readBytes(byte[] byArray, int n10, int n11) {
        int n12;
        byte[] byArray2 = this.data;
        int n13 = this.position;
        System.arraycopy(byArray2, n13, byArray, n10, n11);
        this.position = n12 = this.position + n11;
    }

    public String readDelimiterTerminatedString(char c10) {
        byte[] byArray;
        int n10;
        int n11 = this.bytesLeft();
        if (n11 == 0) {
            return null;
        }
        for (n11 = this.position; n11 < (n10 = this.limit) && (n10 = (byArray = this.data)[n11]) != c10; ++n11) {
        }
        Object object = this.data;
        n10 = this.position;
        int n12 = n11 - n10;
        object = Util.fromUtf8Bytes(object, n10, n12);
        this.position = n11;
        n10 = this.limit;
        if (n11 < n10) {
            this.position = ++n11;
        }
        return object;
    }

    public double readDouble() {
        return Double.longBitsToDouble(this.readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    public int readInt() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = (byArray[n12] & 0xFF) << 24;
        this.position = n10 = n11 + 1;
        n11 = (byArray[n11] & 0xFF) << 16;
        n12 |= n11;
        this.position = n11 = n10 + 1;
        n10 = (byArray[n10] & 0xFF) << 8;
        n12 |= n10;
        this.position = n10 = n11 + 1;
        return byArray[n11] & 0xFF | n12;
    }

    public int readInt24() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = (byArray[n12] & 0xFF) << 24 >> 8;
        this.position = n10 = n11 + 1;
        n11 = (byArray[n11] & 0xFF) << 8;
        n12 |= n11;
        this.position = n11 = n10 + 1;
        return byArray[n10] & 0xFF | n12;
    }

    public String readLine() {
        int n10;
        byte[] byArray;
        int n11;
        Object object;
        int n12;
        int n13 = this.bytesLeft();
        if (n13 == 0) {
            return null;
        }
        for (n13 = this.position; n13 < (n12 = this.limit) && (n12 = (int)(Util.isLinebreak((object = this.data)[n13]) ? 1 : 0)) == 0; ++n13) {
        }
        n12 = this.position;
        int n14 = n13 - n12;
        int n15 = 3;
        if (n14 >= n15 && (n11 = (byArray = this.data)[n12]) == (n10 = -17)) {
            n11 = n12 + 1;
            n10 = -69;
            if ((n11 = byArray[n11]) == n10) {
                n11 = n12 + 2;
                n14 = byArray[n11];
                if (n14 == (n11 = -65)) {
                    this.position = n12 += n15;
                }
            }
        }
        object = this.data;
        n14 = this.position;
        n15 = n13 - n14;
        object = Util.fromUtf8Bytes(object, n14, n15);
        this.position = n13;
        n14 = this.limit;
        if (n13 == n14) {
            return object;
        }
        byte[] byArray2 = this.data;
        n11 = byArray2[n13];
        n10 = 13;
        if (n11 == n10) {
            this.position = ++n13;
            if (n13 == n14) {
                return object;
            }
        }
        if ((n14 = byArray2[n13 = this.position]) == (n15 = 10)) {
            this.position = ++n13;
        }
        return object;
    }

    public int readLittleEndianInt() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = byArray[n12] & 0xFF;
        this.position = n10 = n11 + 1;
        n11 = (byArray[n11] & 0xFF) << 8;
        n12 |= n11;
        this.position = n11 = n10 + 1;
        n10 = (byArray[n10] & 0xFF) << 16;
        n12 |= n10;
        this.position = n10 = n11 + 1;
        return (byArray[n11] & 0xFF) << 24 | n12;
    }

    public int readLittleEndianInt24() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = byArray[n12] & 0xFF;
        this.position = n10 = n11 + 1;
        n11 = (byArray[n11] & 0xFF) << 8;
        n12 |= n11;
        this.position = n11 = n10 + 1;
        return (byArray[n10] & 0xFF) << 16 | n12;
    }

    public long readLittleEndianLong() {
        int n10;
        int n11;
        int n12;
        byte[] byArray = this.data;
        int n13 = this.position;
        this.position = n12 = n13 + 1;
        long l10 = byArray[n13];
        long l11 = 255L;
        this.position = n13 = n12 + 1;
        long l12 = ((long)byArray[n12] & l11) << 8;
        long l13 = (l10 &= l11) | l12;
        this.position = n11 = n13 + 1;
        l12 = ((long)byArray[n13] & l11) << 16;
        long l14 = l13 | l12;
        this.position = n10 = n11 + 1;
        l12 = ((long)byArray[n11] & l11) << 24;
        l14 |= l12;
        this.position = n11 = n10 + 1;
        l12 = ((long)byArray[n10] & l11) << 32;
        l14 |= l12;
        this.position = n10 = n11 + 1;
        l12 = ((long)byArray[n11] & l11) << 40;
        l14 |= l12;
        this.position = n11 = n10 + 1;
        l12 = ((long)byArray[n10] & l11) << 48;
        this.position = n10 = n11 + 1;
        l10 = ((long)byArray[n11] & l11) << 56;
        return (l14 |= l12) | l10;
    }

    public short readLittleEndianShort() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = byArray[n12] & 0xFF;
        this.position = n10 = n11 + 1;
        return (short)((byArray[n11] & 0xFF) << 8 | n12);
    }

    public long readLittleEndianUnsignedInt() {
        int n10;
        int n11;
        int n12;
        byte[] byArray = this.data;
        int n13 = this.position;
        this.position = n12 = n13 + 1;
        long l10 = byArray[n13];
        long l11 = 255L;
        this.position = n13 = n12 + 1;
        long l12 = ((long)byArray[n12] & l11) << 8;
        long l13 = (l10 &= l11) | l12;
        this.position = n11 = n13 + 1;
        l12 = ((long)byArray[n13] & l11) << 16;
        long l14 = l13 | l12;
        this.position = n10 = n11 + 1;
        l10 = ((long)byArray[n11] & l11) << 24;
        return l14 | l10;
    }

    public int readLittleEndianUnsignedInt24() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = byArray[n12] & 0xFF;
        this.position = n10 = n11 + 1;
        n11 = (byArray[n11] & 0xFF) << 8;
        n12 |= n11;
        this.position = n11 = n10 + 1;
        return (byArray[n10] & 0xFF) << 16 | n12;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int n10 = this.readLittleEndianInt();
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder(29);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public int readLittleEndianUnsignedShort() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = byArray[n12] & 0xFF;
        this.position = n10 = n11 + 1;
        return (byArray[n11] & 0xFF) << 8 | n12;
    }

    public long readLong() {
        int n10;
        int n11;
        int n12;
        byte[] byArray = this.data;
        int n13 = this.position;
        this.position = n12 = n13 + 1;
        long l10 = byArray[n13];
        long l11 = 255L;
        l10 = (l10 & l11) << 56;
        this.position = n13 = n12 + 1;
        long l12 = ((long)byArray[n12] & l11) << 48;
        long l13 = l10 | l12;
        this.position = n11 = n13 + 1;
        l12 = ((long)byArray[n13] & l11) << 40;
        long l14 = l13 | l12;
        this.position = n10 = n11 + 1;
        l12 = ((long)byArray[n11] & l11) << 32;
        l14 |= l12;
        this.position = n11 = n10 + 1;
        l12 = ((long)byArray[n10] & l11) << 24;
        l14 |= l12;
        this.position = n10 = n11 + 1;
        l12 = ((long)byArray[n11] & l11) << 16;
        l14 |= l12;
        this.position = n11 = n10 + 1;
        l12 = ((long)byArray[n10] & l11) << 8;
        this.position = n10 = n11 + 1;
        l10 = (long)byArray[n11] & l11;
        return (l14 |= l12) | l10;
    }

    public String readNullTerminatedString() {
        return this.readDelimiterTerminatedString('\u0000');
    }

    public String readNullTerminatedString(int n10) {
        byte[] byArray;
        if (n10 == 0) {
            return "";
        }
        int n11 = this.position;
        int n12 = n11 + n10 + -1;
        int n13 = this.limit;
        n12 = n12 < n13 && (n12 = (byArray = this.data)[n12]) == 0 ? n10 + -1 : n10;
        String string2 = Util.fromUtf8Bytes(this.data, n11, n12);
        this.position = n12 = this.position + n10;
        return string2;
    }

    public short readShort() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        this.position = n10 = n11 + 1;
        return (short)(byArray[n11] & 0xFF | n12);
    }

    public String readString(int n10) {
        Charset charset = Charsets.UTF_8;
        return this.readString(n10, charset);
    }

    public String readString(int n10, Charset charset) {
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        String string2 = new String(byArray, n12, n10, charset);
        this.position = n11 = this.position + n10;
        return string2;
    }

    public int readSynchSafeInt() {
        int n10 = this.readUnsignedByte();
        int n11 = this.readUnsignedByte();
        int n12 = this.readUnsignedByte();
        int n13 = this.readUnsignedByte();
        n10 <<= 21;
        n11 = n12 << 7;
        return (n10 |= (n11 <<= 14)) | n11 | n13;
    }

    public int readUnsignedByte() {
        int n10;
        byte[] byArray = this.data;
        int n11 = this.position;
        this.position = n10 = n11 + 1;
        return byArray[n11] & 0xFF;
    }

    public int readUnsignedFixedPoint1616() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        this.position = n10 = n11 + 1;
        int n13 = byArray[n11] & 0xFF | n12;
        this.position = n10 += 2;
        return n13;
    }

    public long readUnsignedInt() {
        int n10;
        int n11;
        int n12;
        byte[] byArray = this.data;
        int n13 = this.position;
        this.position = n12 = n13 + 1;
        long l10 = byArray[n13];
        long l11 = 255L;
        l10 = (l10 & l11) << 24;
        this.position = n13 = n12 + 1;
        long l12 = ((long)byArray[n12] & l11) << 16;
        long l13 = l10 | l12;
        this.position = n11 = n13 + 1;
        l12 = ((long)byArray[n13] & l11) << 8;
        long l14 = l13 | l12;
        this.position = n10 = n11 + 1;
        l10 = (long)byArray[n11] & l11;
        return l14 | l10;
    }

    public int readUnsignedInt24() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = (byArray[n12] & 0xFF) << 16;
        this.position = n10 = n11 + 1;
        n11 = (byArray[n11] & 0xFF) << 8;
        n12 |= n11;
        this.position = n11 = n10 + 1;
        return byArray[n10] & 0xFF | n12;
    }

    public int readUnsignedIntToInt() {
        int n10 = this.readInt();
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder(29);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public long readUnsignedLongToLong() {
        long l10;
        long l11 = this.readLong();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return l11;
        }
        StringBuilder stringBuilder = new StringBuilder(38);
        stringBuilder.append("Top bit not zero: ");
        stringBuilder.append(l11);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public int readUnsignedShort() {
        int n10;
        int n11;
        byte[] byArray = this.data;
        int n12 = this.position;
        this.position = n11 = n12 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        this.position = n10 = n11 + 1;
        return byArray[n11] & 0xFF | n12;
    }

    public long readUtf8EncodedLong() {
        NumberFormatException numberFormatException;
        long l10;
        Object object;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        long l11;
        Object object2;
        block7: {
            object2 = this.data;
            int n15 = this.position;
            byte by2 = object2[n15];
            l11 = by2;
            n13 = n14 = 7;
            while (true) {
                n12 = 6;
                n11 = 1;
                float f10 = Float.MIN_VALUE;
                if (n13 < 0) break;
                n10 = n11 << n13;
                long l12 = (long)n10 & l11;
                long l13 = 0L;
                long l14 = l12 - l13;
                object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object == false) {
                    if (n13 < n12) {
                        l10 = n10 -= n11;
                        l11 &= l10;
                        n14 -= n13;
                    } else {
                        if (n13 != n14) break;
                        n14 = n11;
                    }
                    break block7;
                }
                n13 += -1;
            }
            n14 = 0;
            numberFormatException = null;
        }
        if (n14 != 0) {
            while (n11 < n14) {
                byte[] byArray = this.data;
                n10 = this.position + n11;
                n13 = byArray[n10];
                object = 128;
                if ((n10 = n13 & 0xC0) == object) {
                    l11 <<= n12;
                    l10 = n13 &= 0x3F;
                    l11 |= l10;
                    ++n11;
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder(62);
                stringBuilder.append("Invalid UTF-8 sequence continuation byte: ");
                stringBuilder.append(l11);
                object2 = stringBuilder.toString();
                numberFormatException = new NumberFormatException((String)object2);
                throw numberFormatException;
            }
            this.position = n13 = this.position + n14;
            return l11;
        }
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Invalid UTF-8 sequence first byte: ");
        stringBuilder.append(l11);
        object2 = stringBuilder.toString();
        numberFormatException = new NumberFormatException((String)object2);
        throw numberFormatException;
    }

    public void reset(int n10) {
        int n11 = this.capacity();
        byte[] byArray = n11 < n10 ? new byte[n10] : this.data;
        this.reset(byArray, n10);
    }

    public void reset(byte[] byArray) {
        int n10 = byArray.length;
        this.reset(byArray, n10);
    }

    public void reset(byte[] byArray, int n10) {
        this.data = byArray;
        this.limit = n10;
        this.position = 0;
    }

    public void setLimit(int n10) {
        byte[] byArray;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = (byArray = this.data).length)) {
            n11 = 1;
        } else {
            n11 = 0;
            byArray = null;
        }
        Assertions.checkArgument(n11 != 0);
        this.limit = n10;
    }

    public void setPosition(int n10) {
        int n11;
        n11 = n10 >= 0 && n10 <= (n11 = this.limit) ? 1 : 0;
        Assertions.checkArgument(n11 != 0);
        this.position = n10;
    }

    public void skipBytes(int n10) {
        int n11 = this.position + n10;
        this.setPosition(n11);
    }
}

