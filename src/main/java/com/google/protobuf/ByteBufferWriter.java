/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.UnsafeUtil;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class ByteBufferWriter {
    private static final ThreadLocal BUFFER;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0L;
    private static final Class FILE_OUTPUT_STREAM_CLASS;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    static {
        Object object = new ThreadLocal();
        BUFFER = object;
        FILE_OUTPUT_STREAM_CLASS = object = ByteBufferWriter.safeGetClass("java.io.FileOutputStream");
        CHANNEL_FIELD_OFFSET = ByteBufferWriter.getChannelFieldOffset((Class)object);
    }

    private ByteBufferWriter() {
    }

    public static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    private static byte[] getBuffer() {
        Object object = (SoftReference)BUFFER.get();
        object = object == null ? null : (Object)((byte[])((SoftReference)object).get());
        return object;
    }

    private static long getChannelFieldOffset(Class annotatedElement) {
        block5: {
            if (annotatedElement != null) {
                String string2;
                try {
                    boolean bl2 = UnsafeUtil.hasUnsafeArrayOperations();
                    if (!bl2) break block5;
                    string2 = "channel";
                }
                catch (Throwable throwable) {}
                annotatedElement = annotatedElement.getDeclaredField(string2);
                return UnsafeUtil.objectFieldOffset((Field)annotatedElement);
            }
        }
        return -1;
    }

    private static byte[] getOrCreateBuffer(int n10) {
        byte[] byArray;
        block5: {
            int n11;
            block4: {
                int n12 = 1024;
                n10 = Math.max(n10, n12);
                byArray = ByteBufferWriter.getBuffer();
                if (byArray == null) break block4;
                n11 = byArray.length;
                if ((n11 = (int)(ByteBufferWriter.needToReallocate(n10, n11) ? 1 : 0)) == 0) break block5;
            }
            byArray = new byte[n10];
            n11 = 16384;
            if (n10 <= n11) {
                ByteBufferWriter.setBuffer(byArray);
            }
        }
        return byArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean needToReallocate(int n10, int n11) {
        if (n11 >= n10) return 0 != 0;
        float f10 = n11;
        float f11 = n10;
        float f12 = 0.5f;
        float f13 = f10 - (f11 *= f12);
        n10 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
        if (n10 >= 0) return 0 != 0;
        return 1 != 0;
    }

    private static Class safeGetClass(String string2) {
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    private static void setBuffer(byte[] byArray) {
        ThreadLocal threadLocal = BUFFER;
        SoftReference<byte[]> softReference = new SoftReference<byte[]>(byArray);
        threadLocal.set(softReference);
    }

    public static void write(ByteBuffer byteBuffer, OutputStream outputStream) {
        block19: {
            byte[] byArray;
            int n10;
            int n11;
            block18: {
                n11 = byteBuffer.position();
                n10 = byteBuffer.hasArray();
                if (n10 == 0) break block18;
                byte[] byArray2 = byteBuffer.array();
                int n12 = byteBuffer.arrayOffset();
                int n13 = byteBuffer.position();
                n12 += n13;
                n13 = byteBuffer.remaining();
                outputStream.write(byArray2, n12, n13);
                break block19;
            }
            n10 = ByteBufferWriter.writeToChannel(byteBuffer, outputStream);
            if (n10 != 0) break block19;
            n10 = byteBuffer.remaining();
            try {
                byArray = ByteBufferWriter.getOrCreateBuffer(n10);
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
                byteBuffer.position(n11);
            }
            while (true) {
                int n14 = byteBuffer.hasRemaining();
                if (n14 == 0) break;
                n14 = byteBuffer.remaining();
                int n15 = byArray.length;
                n14 = Math.min(n14, n15);
                n15 = 0;
                byteBuffer.get(byArray, 0, n14);
                outputStream.write(byArray, 0, n14);
                continue;
                break;
            }
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean writeToChannel(ByteBuffer byteBuffer, OutputStream object) {
        Object object2;
        long l10 = CHANNEL_FIELD_OFFSET;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 >= 0 && (object3 = (Object)((Class)(object2 = FILE_OUTPUT_STREAM_CLASS)).isInstance(object)) != false) {
            object3 = 0;
            object2 = null;
            try {
                object = UnsafeUtil.getObject(object, l10);
                object2 = object = (WritableByteChannel)object;
            }
            catch (ClassCastException classCastException) {}
            if (object2 != null) {
                object2.write(byteBuffer);
                return true;
            }
        }
        return false;
    }
}

