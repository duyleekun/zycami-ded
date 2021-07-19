/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Utf8;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    public static final Charset ISO_8859_1;
    public static final Charset UTF_8;

    static {
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] byArray = new byte[]{};
        EMPTY_BYTE_ARRAY = byArray;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(byArray);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(byArray);
    }

    private Internal() {
    }

    public static byte[] byteArrayDefaultValue(String string2) {
        Charset charset = ISO_8859_1;
        return string2.getBytes(charset);
    }

    public static ByteBuffer byteBufferDefaultValue(String string2) {
        return ByteBuffer.wrap(Internal.byteArrayDefaultValue(string2));
    }

    public static ByteString bytesDefaultValue(String string2) {
        Charset charset = ISO_8859_1;
        return ByteString.copyFrom(string2.getBytes(charset));
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object checkNotNull(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.clear();
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer2.put(byteBuffer);
        byteBuffer2.clear();
        return byteBuffer2;
    }

    public static boolean equals(List list, List list2) {
        int n10;
        int n11 = list.size();
        if (n11 != (n10 = list2.size())) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = list.size()); ++n11) {
            byte[] byArray;
            byte[] byArray2 = (byte[])list.get(n11);
            n10 = (int)(Arrays.equals(byArray2, byArray = (byte[])list2.get(n11)) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer buffer, ByteBuffer buffer2) {
        int n10;
        int n11 = buffer.capacity();
        if (n11 != (n10 = buffer2.capacity())) {
            return false;
        }
        buffer = ((ByteBuffer)buffer).duplicate().clear();
        buffer2 = buffer2.duplicate().clear();
        return buffer.equals(buffer2);
    }

    public static boolean equalsByteBuffer(List list, List list2) {
        int n10;
        int n11 = list.size();
        if (n11 != (n10 = list2.size())) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = list.size()); ++n11) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2 = (ByteBuffer)list.get(n11);
            n10 = (int)(Internal.equalsByteBuffer(byteBuffer2, byteBuffer = (ByteBuffer)list2.get(n11)) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public static MessageLite getDefaultInstance(Class object) {
        Object object2;
        Object object3 = "getDefaultInstance";
        Object[] objectArray = null;
        try {
            object2 = new Class[]{};
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to get default instance for ");
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            objectArray = new RuntimeException((String)object, exception);
            throw objectArray;
        }
        object3 = ((Class)object).getMethod((String)object3, (Class<?>)object2);
        objectArray = new Object[]{};
        object3 = ((Method)object3).invoke(object3, objectArray);
        return (MessageLite)object3;
    }

    /*
     * WARNING - void declaration
     */
    public static int hashBoolean(boolean bl2) {
        void var0_3;
        if (bl2) {
            int n10 = 1231;
        } else {
            int n11 = 1237;
        }
        return (int)var0_3;
    }

    public static int hashCode(List object) {
        int n10;
        object = object.iterator();
        int n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            byte[] byArray = (byte[])object.next();
            n11 *= 31;
            n10 = Internal.hashCode(byArray);
            n11 += n10;
        }
        return n11;
    }

    public static int hashCode(byte[] byArray) {
        int n10 = byArray.length;
        return Internal.hashCode(byArray, 0, n10);
    }

    public static int hashCode(byte[] byArray, int n10, int n11) {
        int n12 = Internal.partialHash(n11, byArray, n10, n11);
        if (n12 == 0) {
            n12 = 1;
        }
        return n12;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        int n10;
        int n11;
        int n12 = byteBuffer.hasArray();
        int n13 = 1;
        if (n12 != 0) {
            n12 = byteBuffer.capacity();
            byte[] byArray = byteBuffer.array();
            int n14 = byteBuffer.arrayOffset();
            int n15 = byteBuffer.capacity();
            if ((n15 = Internal.partialHash(n12, byArray, n14, n15)) != 0) {
                n13 = n15;
            }
            return n13;
        }
        n12 = byteBuffer.capacity();
        if (n12 <= (n11 = 4096)) {
            n11 = byteBuffer.capacity();
        }
        byte[] byArray = new byte[n11];
        ByteBuffer byteBuffer2 = byteBuffer.duplicate();
        byteBuffer2.clear();
        int n16 = byteBuffer.capacity();
        while ((n10 = byteBuffer2.remaining()) > 0) {
            n10 = byteBuffer2.remaining();
            n10 = n10 <= n11 ? byteBuffer2.remaining() : n11;
            byteBuffer2.get(byArray, 0, n10);
            n16 = Internal.partialHash(n16, byArray, 0, n10);
        }
        if (n16 != 0) {
            n13 = n16;
        }
        return n13;
    }

    public static int hashCodeByteBuffer(List object) {
        int n10;
        object = object.iterator();
        int n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            ByteBuffer byteBuffer = (ByteBuffer)object.next();
            n11 *= 31;
            n10 = Internal.hashCodeByteBuffer(byteBuffer);
            n11 += n10;
        }
        return n11;
    }

    public static int hashEnum(Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }

    public static int hashEnumList(List object) {
        int n10;
        object = object.iterator();
        int n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            Internal$EnumLite internal$EnumLite = (Internal$EnumLite)object.next();
            n11 *= 31;
            n10 = Internal.hashEnum(internal$EnumLite);
            n11 += n10;
        }
        return n11;
    }

    public static int hashLong(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] byArray) {
        return Utf8.isValidUtf8(byArray);
    }

    public static Object mergeMessage(Object object, Object object2) {
        object = ((MessageLite)object).toBuilder();
        object2 = (MessageLite)object2;
        return object.mergeFrom((MessageLite)object2).buildPartial();
    }

    public static int partialHash(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        for (int i10 = n11; i10 < (n13 = n11 + n12); ++i10) {
            n10 *= 31;
            n13 = byArray[i10];
            n10 += n13;
        }
        return n10;
    }

    public static String stringDefaultValue(String object) {
        Charset charset = ISO_8859_1;
        object = ((String)object).getBytes(charset);
        charset = UTF_8;
        String string2 = new String((byte[])object, charset);
        return string2;
    }

    public static byte[] toByteArray(String string2) {
        Charset charset = UTF_8;
        return string2.getBytes(charset);
    }

    public static String toStringUtf8(byte[] byArray) {
        Charset charset = UTF_8;
        String string2 = new String(byArray, charset);
        return string2;
    }
}

