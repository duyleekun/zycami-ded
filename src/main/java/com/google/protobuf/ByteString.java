/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Android;
import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString$1;
import com.google.protobuf.ByteString$2;
import com.google.protobuf.ByteString$ArraysByteArrayCopier;
import com.google.protobuf.ByteString$BoundedByteString;
import com.google.protobuf.ByteString$ByteArrayCopier;
import com.google.protobuf.ByteString$ByteIterator;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.ByteString$LiteralByteString;
import com.google.protobuf.ByteString$Output;
import com.google.protobuf.ByteString$SystemByteArrayCopier;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal;
import com.google.protobuf.NioByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.TextFormatEscaper;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class ByteString
implements Iterable,
Serializable {
    public static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY;
    public static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final ByteString$ByteArrayCopier byteArrayCopier;
    private int hash = 0;

    static {
        byte[] byArray = Internal.EMPTY_BYTE_ARRAY;
        Object object = new ByteString$LiteralByteString(byArray);
        EMPTY = object;
        boolean bl2 = Android.isOnAndroidDevice();
        byArray = null;
        object = bl2 ? new ByteString$SystemByteArrayCopier(null) : new ByteString$ArraysByteArrayCopier(null);
        byteArrayCopier = object;
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = object = new ByteString$2();
    }

    public static /* synthetic */ int access$200(byte by2) {
        return ByteString.toInt(by2);
    }

    private static ByteString balancedConcat(Iterator object, int n10) {
        Object object2;
        int n11 = 1;
        if (n10 >= n11) {
            if (n10 == n11) {
                object = (ByteString)object.next();
            } else {
                n11 = n10 >>> 1;
                ByteString byteString = ByteString.balancedConcat((Iterator)object, n11);
                object = ByteString.balancedConcat((Iterator)object, n10 -= n11);
                object = byteString.concat((ByteString)object);
            }
            return object;
        }
        Object[] objectArray = new Object[n11];
        objectArray[0] = object2 = Integer.valueOf(n10);
        object2 = String.format("length (%s) must be >= 1", objectArray);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static void checkIndex(int n10, int n11) {
        int n12 = n10 + 1;
        if ((n12 = n11 - n12 | n10) < 0) {
            if (n10 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Index < 0: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(string2);
                throw arrayIndexOutOfBoundsException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index > length: ");
            stringBuilder.append(n10);
            stringBuilder.append(", ");
            stringBuilder.append(n11);
            String string3 = stringBuilder.toString();
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(string3);
            throw arrayIndexOutOfBoundsException;
        }
    }

    public static int checkRange(int n10, int n11, int n12) {
        int n13 = n11 - n10;
        int n14 = n10 | n11 | n13;
        int n15 = n12 - n11;
        if ((n14 |= n15) < 0) {
            if (n10 >= 0) {
                if (n11 < n10) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Beginning index larger than ending index: ");
                    stringBuilder.append(n10);
                    stringBuilder.append(", ");
                    stringBuilder.append(n11);
                    String string2 = stringBuilder.toString();
                    IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
                    throw indexOutOfBoundsException;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("End index: ");
                stringBuilder.append(n11);
                stringBuilder.append(" >= ");
                stringBuilder.append(n12);
                String string3 = stringBuilder.toString();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string3);
                throw indexOutOfBoundsException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Beginning index: ");
            stringBuilder.append(n10);
            stringBuilder.append(" < 0");
            String string4 = stringBuilder.toString();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string4);
            throw indexOutOfBoundsException;
        }
        return n13;
    }

    public static ByteString copyFrom(Iterable iterable) {
        int n10 = iterable instanceof Collection;
        if (n10 == 0) {
            boolean bl2;
            n10 = 0;
            Object var2_2 = null;
            Iterator iterator2 = iterable.iterator();
            while (bl2 = iterator2.hasNext()) {
                iterator2.next();
                ++n10;
            }
        } else {
            Iterable iterable2 = iterable;
            iterable2 = (Collection)iterable;
            n10 = iterable2.size();
        }
        if (n10 == 0) {
            return EMPTY;
        }
        return ByteString.balancedConcat(iterable.iterator(), n10);
    }

    public static ByteString copyFrom(String object, String string2) {
        object = ((String)object).getBytes(string2);
        ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString((byte[])object);
        return byteString$LiteralByteString;
    }

    public static ByteString copyFrom(String object, Charset charset) {
        object = ((String)object).getBytes(charset);
        ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString((byte[])object);
        return byteString$LiteralByteString;
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        return ByteString.copyFrom(byteBuffer, n10);
    }

    public static ByteString copyFrom(ByteBuffer object, int n10) {
        int n11 = ((Buffer)object).remaining();
        ByteString.checkRange(0, n10, n11);
        byte[] byArray = new byte[n10];
        ((ByteBuffer)object).get(byArray);
        object = new ByteString$LiteralByteString(byArray);
        return object;
    }

    public static ByteString copyFrom(byte[] byArray) {
        int n10 = byArray.length;
        return ByteString.copyFrom(byArray, 0, n10);
    }

    public static ByteString copyFrom(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = byArray.length;
        ByteString.checkRange(n10, n12, n13);
        byArray = byteArrayCopier.copyFrom(byArray, n10, n11);
        ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString(byArray);
        return byteString$LiteralByteString;
    }

    public static ByteString copyFromUtf8(String object) {
        Charset charset = Internal.UTF_8;
        object = ((String)object).getBytes(charset);
        ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString((byte[])object);
        return byteString$LiteralByteString;
    }

    public static ByteString$CodedBuilder newCodedBuilder(int n10) {
        ByteString$CodedBuilder byteString$CodedBuilder = new ByteString$CodedBuilder(n10, null);
        return byteString$CodedBuilder;
    }

    public static ByteString$Output newOutput() {
        ByteString$Output byteString$Output = new ByteString$Output(128);
        return byteString$Output;
    }

    public static ByteString$Output newOutput(int n10) {
        ByteString$Output byteString$Output = new ByteString$Output(n10);
        return byteString$Output;
    }

    private static ByteString readChunk(InputStream inputStream, int n10) {
        int n11;
        int n12;
        byte[] byArray = new byte[n10];
        for (n11 = 0; n11 < n10; n11 += n12) {
            int n13;
            n12 = n10 - n11;
            if ((n12 = inputStream.read(byArray, n11, n12)) == (n13 = -1)) break;
        }
        if (n11 == 0) {
            return null;
        }
        return ByteString.copyFrom(byArray, 0, n11);
    }

    public static ByteString readFrom(InputStream inputStream) {
        return ByteString.readFrom(inputStream, 256, 8192);
    }

    public static ByteString readFrom(InputStream inputStream, int n10) {
        return ByteString.readFrom(inputStream, n10, n10);
    }

    public static ByteString readFrom(InputStream inputStream, int n10, int n11) {
        ArrayList<ByteString> arrayList = new ArrayList<ByteString>();
        ByteString byteString;
        while ((byteString = ByteString.readChunk(inputStream, n10)) != null) {
            arrayList.add(byteString);
            n10 = Math.min(n10 * 2, n11);
        }
        return ByteString.copyFrom(arrayList);
    }

    private static int toInt(byte by2) {
        return by2 & 0xFF;
    }

    private String truncateAndEscapeForDisplay() {
        CharSequence charSequence;
        int n10;
        int n11 = this.size();
        if (n11 <= (n10 = 50)) {
            charSequence = TextFormatEscaper.escapeBytes(this);
        } else {
            charSequence = new StringBuilder();
            n10 = 0;
            int n12 = 47;
            String string2 = TextFormatEscaper.escapeBytes(this.substring(0, n12));
            ((StringBuilder)charSequence).append(string2);
            string2 = "...";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public static Comparator unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public static ByteString wrap(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.hasArray();
        if (n10 != 0) {
            n10 = byteBuffer.arrayOffset();
            byte[] byArray = byteBuffer.array();
            int n11 = byteBuffer.position();
            int n12 = byteBuffer.remaining();
            return ByteString.wrap(byArray, n10 += n11, n12);
        }
        NioByteString nioByteString = new NioByteString(byteBuffer);
        return nioByteString;
    }

    public static ByteString wrap(byte[] byArray) {
        ByteString$LiteralByteString byteString$LiteralByteString = new ByteString$LiteralByteString(byArray);
        return byteString$LiteralByteString;
    }

    public static ByteString wrap(byte[] byArray, int n10, int n11) {
        ByteString$BoundedByteString byteString$BoundedByteString = new ByteString$BoundedByteString(byArray, n10, n11);
        return byteString$BoundedByteString;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List asReadOnlyByteBufferList();

    public abstract byte byteAt(int var1);

    public final ByteString concat(ByteString object) {
        int n10 = this.size();
        int n11 = (-1 >>> 1) - n10;
        if (n11 >= (n10 = ((ByteString)object).size())) {
            return RopeByteString.concatenate(this, (ByteString)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ByteString would be too long: ");
        int n12 = this.size();
        stringBuilder.append(n12);
        stringBuilder.append("+");
        int n13 = ((ByteString)object).size();
        stringBuilder.append(n13);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public abstract void copyTo(ByteBuffer var1);

    public void copyTo(byte[] byArray, int n10) {
        int n11 = this.size();
        this.copyTo(byArray, 0, n10, n11);
    }

    public final void copyTo(byte[] byArray, int n10, int n11, int n12) {
        int n13 = n10 + n12;
        int n14 = this.size();
        ByteString.checkRange(n10, n13, n14);
        n13 = n11 + n12;
        n14 = byArray.length;
        ByteString.checkRange(n11, n13, n14);
        if (n12 > 0) {
            this.copyToInternal(byArray, n10, n11, n12);
        }
    }

    public abstract void copyToInternal(byte[] var1, int var2, int var3, int var4);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean endsWith(ByteString byteString) {
        int n10;
        int n11 = this.size();
        if (n11 < (n10 = byteString.size())) return false;
        n11 = this.size();
        n10 = byteString.size();
        ByteString byteString2 = this.substring(n11 -= n10);
        boolean bl2 = byteString2.equals(byteString);
        if (!bl2) return false;
        return true;
    }

    public abstract boolean equals(Object var1);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int n10 = this.hash;
        if (n10 == 0) {
            n10 = this.size();
            if ((n10 = this.partialHash(n10, 0, n10)) == 0) {
                n10 = 1;
            }
            this.hash = n10;
        }
        return n10;
    }

    public abstract byte internalByteAt(int var1);

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public abstract boolean isValidUtf8();

    public ByteString$ByteIterator iterator() {
        ByteString$1 byteString$1 = new ByteString$1(this);
        return byteString$1;
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int var1, int var2, int var3);

    public abstract int partialIsValidUtf8(int var1, int var2, int var3);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        ByteString byteString2;
        boolean bl2;
        int n10 = this.size();
        int n11 = byteString.size();
        boolean bl3 = false;
        if (n10 >= n11 && (bl2 = (byteString2 = this.substring(0, n10 = byteString.size())).equals(byteString))) {
            bl3 = true;
        }
        return bl3;
    }

    public final ByteString substring(int n10) {
        int n11 = this.size();
        return this.substring(n10, n11);
    }

    public abstract ByteString substring(int var1, int var2);

    public final byte[] toByteArray() {
        int n10 = this.size();
        if (n10 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] byArray = new byte[n10];
        this.copyToInternal(byArray, 0, 0, n10);
        return byArray;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object object = Integer.toHexString(System.identityHashCode(this));
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.size()), object = this.truncateAndEscapeForDisplay()};
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objectArray);
    }

    public final String toString(String string2) {
        Charset charset;
        try {
            charset = Charset.forName(string2);
        }
        catch (UnsupportedCharsetException unsupportedCharsetException) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(string2);
            unsupportedEncodingException.initCause(unsupportedCharsetException);
            throw unsupportedEncodingException;
        }
        return this.toString(charset);
    }

    public final String toString(Charset object) {
        int n10 = this.size();
        object = n10 == 0 ? "" : this.toStringInternal((Charset)object);
        return object;
    }

    public abstract String toStringInternal(Charset var1);

    public final String toStringUtf8() {
        Charset charset = Internal.UTF_8;
        return this.toString(charset);
    }

    public abstract void writeTo(ByteOutput var1);

    public abstract void writeTo(OutputStream var1);

    public final void writeTo(OutputStream outputStream, int n10, int n11) {
        int n12 = n10 + n11;
        int n13 = this.size();
        ByteString.checkRange(n10, n12, n13);
        if (n11 > 0) {
            this.writeToInternal(outputStream, n10, n11);
        }
    }

    public abstract void writeToInternal(OutputStream var1, int var2, int var3);

    public abstract void writeToReverse(ByteOutput var1);
}

