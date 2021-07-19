/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer$1;
import com.google.protobuf.AllocatedBuffer$2;
import com.google.protobuf.Internal;
import java.nio.ByteBuffer;

public abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        AllocatedBuffer$1 allocatedBuffer$1 = new AllocatedBuffer$1(byteBuffer);
        return allocatedBuffer$1;
    }

    public static AllocatedBuffer wrap(byte[] byArray) {
        int n10 = byArray.length;
        return AllocatedBuffer.wrapNoCheck(byArray, 0, n10);
    }

    public static AllocatedBuffer wrap(byte[] object, int n10, int n11) {
        int n12;
        int n13;
        if (n10 >= 0 && n11 >= 0 && (n13 = n10 + n11) <= (n12 = ((byte[])object).length)) {
            return AllocatedBuffer.wrapNoCheck(object, n10, n11);
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        Integer n14 = n10;
        objectArray[1] = n14;
        n14 = n11;
        objectArray[2] = n14;
        object = String.format("bytes.length=%d, offset=%d, length=%d", objectArray);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    private static AllocatedBuffer wrapNoCheck(byte[] byArray, int n10, int n11) {
        AllocatedBuffer$2 allocatedBuffer$2 = new AllocatedBuffer$2(byArray, n10, n11);
        return allocatedBuffer$2;
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int var1);

    public abstract int remaining();
}

