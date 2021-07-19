/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AllocatedBuffer;
import com.google.protobuf.BinaryWriter$1;
import com.google.protobuf.BinaryWriter$SafeDirectWriter;
import com.google.protobuf.BinaryWriter$SafeHeapWriter;
import com.google.protobuf.BinaryWriter$UnsafeDirectWriter;
import com.google.protobuf.BinaryWriter$UnsafeHeapWriter;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.BufferAllocator;
import com.google.protobuf.ByteOutput;
import com.google.protobuf.ByteString;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.Schema;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.Writer;
import com.google.protobuf.Writer$FieldOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public abstract class BinaryWriter
extends ByteOutput
implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    public final ArrayDeque buffers;
    private final int chunkSize;
    public int totalDoneBytes;

    private BinaryWriter(BufferAllocator object, int n10) {
        ArrayDeque arrayDeque;
        int n11 = 4;
        this.buffers = arrayDeque = new ArrayDeque(n11);
        if (n10 > 0) {
            this.alloc = object = (BufferAllocator)Internal.checkNotNull(object, "alloc");
            this.chunkSize = n10;
            return;
        }
        object = new IllegalArgumentException("chunkSize must be > 0");
        throw object;
    }

    public /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int n10, BinaryWriter$1 binaryWriter$1) {
        this(bufferAllocator, n10);
    }

    public static /* synthetic */ byte access$200(long l10) {
        return BinaryWriter.computeUInt64SizeNoTag(l10);
    }

    private static byte computeUInt64SizeNoTag(long l10) {
        long l11;
        long l12;
        int n10;
        long l13 = (long)-128 & l10;
        long l14 = 0L;
        long l15 = l13 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            return 1;
        }
        object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object < 0) {
            return 10;
        }
        l13 = 0xFFFFFFF800000000L & l10;
        long l16 = l13 - l14;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false) {
            object = (byte)6;
            n10 = 28;
            l10 >>>= n10;
        } else {
            object = 2;
        }
        long l17 = 0xFFE00000L & l10;
        n10 = (int)(l17 == l14 ? 0 : (l17 < l14 ? -1 : 1));
        if (n10 != 0) {
            object = (byte)(object + 2);
            n10 = 14;
            l10 >>>= n10;
        }
        if ((l12 = (l11 = (l10 &= (l17 = -16384L)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object = (byte)(object + true);
        }
        return (byte)object;
    }

    public static boolean isUnsafeDirectSupported() {
        return BinaryWriter$UnsafeDirectWriter.access$000();
    }

    public static boolean isUnsafeHeapSupported() {
        return BinaryWriter$UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return BinaryWriter.newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator object, int n10) {
        boolean bl2 = BinaryWriter.isUnsafeDirectSupported();
        object = bl2 ? BinaryWriter.newUnsafeDirectInstance((BufferAllocator)object, n10) : BinaryWriter.newSafeDirectInstance((BufferAllocator)object, n10);
        return object;
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return BinaryWriter.newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator object, int n10) {
        boolean bl2 = BinaryWriter.isUnsafeHeapSupported();
        object = bl2 ? BinaryWriter.newUnsafeHeapInstance((BufferAllocator)object, n10) : BinaryWriter.newSafeHeapInstance((BufferAllocator)object, n10);
        return object;
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int n10) {
        BinaryWriter$SafeDirectWriter binaryWriter$SafeDirectWriter = new BinaryWriter$SafeDirectWriter(bufferAllocator, n10);
        return binaryWriter$SafeDirectWriter;
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int n10) {
        BinaryWriter$SafeHeapWriter binaryWriter$SafeHeapWriter = new BinaryWriter$SafeHeapWriter(bufferAllocator, n10);
        return binaryWriter$SafeHeapWriter;
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator object, int n10) {
        boolean bl2 = BinaryWriter.isUnsafeDirectSupported();
        if (bl2) {
            BinaryWriter$UnsafeDirectWriter binaryWriter$UnsafeDirectWriter = new BinaryWriter$UnsafeDirectWriter((BufferAllocator)object, n10);
            return binaryWriter$UnsafeDirectWriter;
        }
        object = new UnsupportedOperationException("Unsafe operations not supported");
        throw object;
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator object, int n10) {
        boolean bl2 = BinaryWriter.isUnsafeHeapSupported();
        if (bl2) {
            BinaryWriter$UnsafeHeapWriter binaryWriter$UnsafeHeapWriter = new BinaryWriter$UnsafeHeapWriter((BufferAllocator)object, n10);
            return binaryWriter$UnsafeHeapWriter;
        }
        object = new UnsupportedOperationException("Unsafe operations not supported");
        throw object;
    }

    private final void writeBoolList_Internal(int n10, BooleanArrayList booleanArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = booleanArrayList.size() + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = booleanArrayList.size() + -1; i10 >= 0; i10 += -1) {
                boolean bl2 = booleanArrayList.getBoolean(i10);
                this.writeBool(bl2);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = booleanArrayList.size() + -1; n11 >= 0; n11 += -1) {
                boolean bl3 = booleanArrayList.getBoolean(n11);
                this.writeBool(n10, bl3);
            }
        }
    }

    private final void writeBoolList_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Boolean bl2 = (Boolean)list.get(i10);
                boolean bl3 = bl2;
                this.writeBool(bl3);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Boolean bl4 = (Boolean)list.get(n11);
                boolean bl5 = bl4;
                this.writeBool(n10, bl5);
            }
        }
    }

    private final void writeDoubleList_Internal(int n10, DoubleArrayList doubleArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = doubleArrayList.size() * 8 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = doubleArrayList.size() + -1; i10 >= 0; i10 += -1) {
                double d10 = doubleArrayList.getDouble(i10);
                long l10 = Double.doubleToRawLongBits(d10);
                this.writeFixed64(l10);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = doubleArrayList.size() + -1; n11 >= 0; n11 += -1) {
                double d11 = doubleArrayList.getDouble(n11);
                this.writeDouble(n10, d11);
            }
        }
    }

    private final void writeDoubleList_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 8 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Double d10 = (Double)list.get(i10);
                double d11 = d10;
                long l10 = Double.doubleToRawLongBits(d11);
                this.writeFixed64(l10);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Double d12 = (Double)list.get(n11);
                double d13 = d12;
                this.writeDouble(n10, d13);
            }
        }
    }

    private final void writeFixed32List_Internal(int n10, IntArrayList intArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = intArrayList.size() * 4 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = intArrayList.size() + -1; i10 >= 0; i10 += -1) {
                int n12 = intArrayList.getInt(i10);
                this.writeFixed32(n12);
            }
            int n13 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n13);
            n13 = 2;
            this.writeTag(n10, n13);
        } else {
            for (n11 = intArrayList.size() + -1; n11 >= 0; n11 += -1) {
                int n14 = intArrayList.getInt(n11);
                this.writeFixed32(n10, n14);
            }
        }
    }

    private final void writeFixed32List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 4 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Integer n12 = (Integer)list.get(i10);
                int n13 = n12;
                this.writeFixed32(n13);
            }
            int n14 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n14);
            n14 = 2;
            this.writeTag(n10, n14);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Integer n15 = (Integer)list.get(n11);
                int n16 = n15;
                this.writeFixed32(n10, n16);
            }
        }
    }

    private final void writeFixed64List_Internal(int n10, LongArrayList longArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = longArrayList.size() * 8 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = longArrayList.size() + -1; i10 >= 0; i10 += -1) {
                long l10 = longArrayList.getLong(i10);
                this.writeFixed64(l10);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = longArrayList.size() + -1; n11 >= 0; n11 += -1) {
                long l11 = longArrayList.getLong(n11);
                this.writeFixed64(n10, l11);
            }
        }
    }

    private final void writeFixed64List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 8 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Long l10 = (Long)list.get(i10);
                long l11 = l10;
                this.writeFixed64(l11);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Long l12 = (Long)list.get(n11);
                long l13 = l12;
                this.writeFixed64(n10, l13);
            }
        }
    }

    private final void writeFloatList_Internal(int n10, FloatArrayList floatArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = floatArrayList.size() * 4 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = floatArrayList.size() + -1; i10 >= 0; i10 += -1) {
                float f10 = floatArrayList.getFloat(i10);
                int n12 = Float.floatToRawIntBits(f10);
                this.writeFixed32(n12);
            }
            int n13 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n13);
            n13 = 2;
            this.writeTag(n10, n13);
        } else {
            for (n11 = floatArrayList.size() + -1; n11 >= 0; n11 += -1) {
                float f11 = floatArrayList.getFloat(n11);
                this.writeFloat(n10, f11);
            }
        }
    }

    private final void writeFloatList_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 4 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Float f10 = (Float)list.get(i10);
                float f11 = f10.floatValue();
                int n12 = Float.floatToRawIntBits(f11);
                this.writeFixed32(n12);
            }
            int n13 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n13);
            n13 = 2;
            this.writeTag(n10, n13);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Float f12 = (Float)list.get(n11);
                float f13 = f12.floatValue();
                this.writeFloat(n10, f13);
            }
        }
    }

    private final void writeInt32List_Internal(int n10, IntArrayList intArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = intArrayList.size() * 10 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = intArrayList.size() + -1; i10 >= 0; i10 += -1) {
                int n12 = intArrayList.getInt(i10);
                this.writeInt32(n12);
            }
            int n13 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n13);
            n13 = 2;
            this.writeTag(n10, n13);
        } else {
            for (n11 = intArrayList.size() + -1; n11 >= 0; n11 += -1) {
                int n14 = intArrayList.getInt(n11);
                this.writeInt32(n10, n14);
            }
        }
    }

    private final void writeInt32List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 10 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Integer n12 = (Integer)list.get(i10);
                int n13 = n12;
                this.writeInt32(n13);
            }
            int n14 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n14);
            n14 = 2;
            this.writeTag(n10, n14);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Integer n15 = (Integer)list.get(n11);
                int n16 = n15;
                this.writeInt32(n10, n16);
            }
        }
    }

    private void writeLazyString(int n10, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            this.writeString(n10, (String)object);
        } else {
            object = (ByteString)object;
            this.writeBytes(n10, (ByteString)object);
        }
    }

    public static final void writeMapEntryField(Writer object, int n10, WireFormat$FieldType wireFormat$FieldType, Object object2) {
        int[] nArray = BinaryWriter$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
        int n11 = wireFormat$FieldType.ordinal();
        int n12 = nArray[n11];
        switch (n12) {
            default: {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Unsupported map value type for: ");
                charSequence.append((Object)wireFormat$FieldType);
                charSequence = charSequence.toString();
                object = new IllegalArgumentException((String)charSequence);
                throw object;
            }
            case 17: {
                int n13 = object2 instanceof Internal$EnumLite;
                if (n13 != 0) {
                    object2 = (Internal$EnumLite)object2;
                    n13 = object2.getNumber();
                    object.writeEnum(n10, n13);
                    break;
                }
                n13 = object2 instanceof Integer;
                if (n13 != 0) {
                    object2 = (Integer)object2;
                    n13 = (Integer)object2;
                    object.writeEnum(n10, n13);
                    break;
                }
                object = new IllegalArgumentException("Unexpected type for enum in map.");
                throw object;
            }
            case 16: {
                object2 = (ByteString)object2;
                object.writeBytes(n10, (ByteString)object2);
                break;
            }
            case 15: {
                object.writeMessage(n10, object2);
                break;
            }
            case 14: {
                object2 = (Double)object2;
                double d10 = (Double)object2;
                object.writeDouble(n10, d10);
                break;
            }
            case 13: {
                object2 = (Float)object2;
                float f10 = ((Float)object2).floatValue();
                object.writeFloat(n10, f10);
                break;
            }
            case 12: {
                object2 = (Long)object2;
                long l10 = (Long)object2;
                object.writeUInt64(n10, l10);
                break;
            }
            case 11: {
                object2 = (Integer)object2;
                int n14 = (Integer)object2;
                object.writeUInt32(n10, n14);
                break;
            }
            case 10: {
                object2 = (String)object2;
                object.writeString(n10, (String)object2);
                break;
            }
            case 9: {
                object2 = (Long)object2;
                long l11 = (Long)object2;
                object.writeSInt64(n10, l11);
                break;
            }
            case 8: {
                object2 = (Integer)object2;
                int n15 = (Integer)object2;
                object.writeSInt32(n10, n15);
                break;
            }
            case 7: {
                object2 = (Long)object2;
                long l12 = (Long)object2;
                object.writeSFixed64(n10, l12);
                break;
            }
            case 6: {
                object2 = (Integer)object2;
                int n16 = (Integer)object2;
                object.writeSFixed32(n10, n16);
                break;
            }
            case 5: {
                object2 = (Long)object2;
                long l13 = (Long)object2;
                object.writeInt64(n10, l13);
                break;
            }
            case 4: {
                object2 = (Integer)object2;
                int n17 = (Integer)object2;
                object.writeInt32(n10, n17);
                break;
            }
            case 3: {
                object2 = (Long)object2;
                long l14 = (Long)object2;
                object.writeFixed64(n10, l14);
                break;
            }
            case 2: {
                object2 = (Integer)object2;
                int n18 = (Integer)object2;
                object.writeFixed32(n10, n18);
                break;
            }
            case 1: {
                object2 = (Boolean)object2;
                boolean bl2 = (Boolean)object2;
                object.writeBool(n10, bl2);
            }
        }
    }

    private final void writeSInt32List_Internal(int n10, IntArrayList intArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = intArrayList.size() * 5 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = intArrayList.size() + -1; i10 >= 0; i10 += -1) {
                int n12 = intArrayList.getInt(i10);
                this.writeSInt32(n12);
            }
            int n13 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n13);
            n13 = 2;
            this.writeTag(n10, n13);
        } else {
            for (n11 = intArrayList.size() + -1; n11 >= 0; n11 += -1) {
                int n14 = intArrayList.getInt(n11);
                this.writeSInt32(n10, n14);
            }
        }
    }

    private final void writeSInt32List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 5 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Integer n12 = (Integer)list.get(i10);
                int n13 = n12;
                this.writeSInt32(n13);
            }
            int n14 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n14);
            n14 = 2;
            this.writeTag(n10, n14);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Integer n15 = (Integer)list.get(n11);
                int n16 = n15;
                this.writeSInt32(n10, n16);
            }
        }
    }

    private final void writeSInt64List_Internal(int n10, LongArrayList longArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = longArrayList.size() * 10 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = longArrayList.size() + -1; i10 >= 0; i10 += -1) {
                long l10 = longArrayList.getLong(i10);
                this.writeSInt64(l10);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = longArrayList.size() + -1; n11 >= 0; n11 += -1) {
                long l11 = longArrayList.getLong(n11);
                this.writeSInt64(n10, l11);
            }
        }
    }

    private final void writeSInt64List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 10 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Long l10 = (Long)list.get(i10);
                long l11 = l10;
                this.writeSInt64(l11);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Long l12 = (Long)list.get(n11);
                long l13 = l12;
                this.writeSInt64(n10, l13);
            }
        }
    }

    private final void writeUInt32List_Internal(int n10, IntArrayList intArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = intArrayList.size() * 5 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = intArrayList.size() + -1; i10 >= 0; i10 += -1) {
                int n12 = intArrayList.getInt(i10);
                this.writeVarint32(n12);
            }
            int n13 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n13);
            n13 = 2;
            this.writeTag(n10, n13);
        } else {
            for (n11 = intArrayList.size() + -1; n11 >= 0; n11 += -1) {
                int n14 = intArrayList.getInt(n11);
                this.writeUInt32(n10, n14);
            }
        }
    }

    private final void writeUInt32List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 5 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Integer n12 = (Integer)list.get(i10);
                int n13 = n12;
                this.writeVarint32(n13);
            }
            int n14 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n14);
            n14 = 2;
            this.writeTag(n10, n14);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Integer n15 = (Integer)list.get(n11);
                int n16 = n15;
                this.writeUInt32(n10, n16);
            }
        }
    }

    private final void writeUInt64List_Internal(int n10, LongArrayList longArrayList, boolean n11) {
        if (n11 != 0) {
            n11 = longArrayList.size() * 10 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = longArrayList.size() + -1; i10 >= 0; i10 += -1) {
                long l10 = longArrayList.getLong(i10);
                this.writeVarint64(l10);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = longArrayList.size() + -1; n11 >= 0; n11 += -1) {
                long l11 = longArrayList.getLong(n11);
                this.writeUInt64(n10, l11);
            }
        }
    }

    private final void writeUInt64List_Internal(int n10, List list, boolean n11) {
        if (n11 != 0) {
            n11 = list.size() * 10 + 10;
            this.requireSpace(n11);
            n11 = this.getTotalBytesWritten();
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Long l10 = (Long)list.get(i10);
                long l11 = l10;
                this.writeVarint64(l11);
            }
            int n12 = this.getTotalBytesWritten() - n11;
            this.writeVarint32(n12);
            n12 = 2;
            this.writeTag(n10, n12);
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                Long l12 = (Long)list.get(n11);
                long l13 = l12;
                this.writeUInt64(n10, l13);
            }
        }
    }

    public final Queue complete() {
        this.finishCurrentBuffer();
        return this.buffers;
    }

    public final Writer$FieldOrder fieldOrder() {
        return Writer$FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        BufferAllocator bufferAllocator = this.alloc;
        int n10 = this.chunkSize;
        return bufferAllocator.allocateDirectBuffer(n10);
    }

    public final AllocatedBuffer newDirectBuffer(int n10) {
        BufferAllocator bufferAllocator = this.alloc;
        int n11 = this.chunkSize;
        n10 = Math.max(n10, n11);
        return bufferAllocator.allocateDirectBuffer(n10);
    }

    public final AllocatedBuffer newHeapBuffer() {
        BufferAllocator bufferAllocator = this.alloc;
        int n10 = this.chunkSize;
        return bufferAllocator.allocateHeapBuffer(n10);
    }

    public final AllocatedBuffer newHeapBuffer(int n10) {
        BufferAllocator bufferAllocator = this.alloc;
        int n11 = this.chunkSize;
        n10 = Math.max(n10, n11);
        return bufferAllocator.allocateHeapBuffer(n10);
    }

    public abstract void requireSpace(int var1);

    public abstract void writeBool(boolean var1);

    public final void writeBoolList(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof BooleanArrayList;
        if (bl3) {
            list = (BooleanArrayList)list;
            this.writeBoolList_Internal(n10, (BooleanArrayList)list, bl2);
        } else {
            this.writeBoolList_Internal(n10, list, bl2);
        }
    }

    public final void writeBytesList(int n10, List list) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            ByteString byteString = (ByteString)list.get(i10);
            this.writeBytes(n10, byteString);
        }
    }

    public final void writeDouble(int n10, double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.writeFixed64(n10, l10);
    }

    public final void writeDoubleList(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof DoubleArrayList;
        if (bl3) {
            list = (DoubleArrayList)list;
            this.writeDoubleList_Internal(n10, (DoubleArrayList)list, bl2);
        } else {
            this.writeDoubleList_Internal(n10, list, bl2);
        }
    }

    public final void writeEnum(int n10, int n11) {
        this.writeInt32(n10, n11);
    }

    public final void writeEnumList(int n10, List list, boolean bl2) {
        this.writeInt32List(n10, list, bl2);
    }

    public abstract void writeFixed32(int var1);

    public final void writeFixed32List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof IntArrayList;
        if (bl3) {
            list = (IntArrayList)list;
            this.writeFixed32List_Internal(n10, (IntArrayList)list, bl2);
        } else {
            this.writeFixed32List_Internal(n10, list, bl2);
        }
    }

    public abstract void writeFixed64(long var1);

    public final void writeFixed64List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof LongArrayList;
        if (bl3) {
            list = (LongArrayList)list;
            this.writeFixed64List_Internal(n10, (LongArrayList)list, bl2);
        } else {
            this.writeFixed64List_Internal(n10, list, bl2);
        }
    }

    public final void writeFloat(int n10, float f10) {
        int n11 = Float.floatToRawIntBits(f10);
        this.writeFixed32(n10, n11);
    }

    public final void writeFloatList(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof FloatArrayList;
        if (bl3) {
            list = (FloatArrayList)list;
            this.writeFloatList_Internal(n10, (FloatArrayList)list, bl2);
        } else {
            this.writeFloatList_Internal(n10, list, bl2);
        }
    }

    public final void writeGroupList(int n10, List list) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Object e10 = list.get(i10);
            this.writeGroup(n10, e10);
        }
    }

    public final void writeGroupList(int n10, List list, Schema schema) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Object e10 = list.get(i10);
            this.writeGroup(n10, e10, schema);
        }
    }

    public abstract void writeInt32(int var1);

    public final void writeInt32List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof IntArrayList;
        if (bl3) {
            list = (IntArrayList)list;
            this.writeInt32List_Internal(n10, (IntArrayList)list, bl2);
        } else {
            this.writeInt32List_Internal(n10, list, bl2);
        }
    }

    public final void writeInt64(int n10, long l10) {
        this.writeUInt64(n10, l10);
    }

    public final void writeInt64List(int n10, List list, boolean bl2) {
        this.writeUInt64List(n10, list, bl2);
    }

    public void writeMap(int n10, MapEntryLite$Metadata mapEntryLite$Metadata, Map object) {
        int n11;
        object = object.entrySet().iterator();
        while ((n11 = object.hasNext()) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            int n12 = this.getTotalBytesWritten();
            WireFormat$FieldType wireFormat$FieldType = mapEntryLite$Metadata.valueType;
            Object object2 = entry.getValue();
            int n13 = 2;
            BinaryWriter.writeMapEntryField(this, n13, wireFormat$FieldType, object2);
            int n14 = 1;
            object2 = mapEntryLite$Metadata.keyType;
            entry = entry.getKey();
            BinaryWriter.writeMapEntryField(this, n14, object2, entry);
            n11 = this.getTotalBytesWritten() - n12;
            this.writeVarint32(n11);
            this.writeTag(n10, n13);
        }
    }

    public final void writeMessageList(int n10, List list) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Object e10 = list.get(i10);
            this.writeMessage(n10, e10);
        }
    }

    public final void writeMessageList(int n10, List list, Schema schema) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Object e10 = list.get(i10);
            this.writeMessage(n10, e10, schema);
        }
    }

    public final void writeMessageSetItem(int n10, Object object) {
        int n11 = 1;
        this.writeTag(n11, 4);
        boolean bl2 = object instanceof ByteString;
        int n12 = 3;
        if (bl2) {
            object = (ByteString)object;
            this.writeBytes(n12, (ByteString)object);
        } else {
            this.writeMessage(n12, object);
        }
        this.writeUInt32(2, n10);
        this.writeTag(n11, n12);
    }

    public final void writeSFixed32(int n10, int n11) {
        this.writeFixed32(n10, n11);
    }

    public final void writeSFixed32List(int n10, List list, boolean bl2) {
        this.writeFixed32List(n10, list, bl2);
    }

    public final void writeSFixed64(int n10, long l10) {
        this.writeFixed64(n10, l10);
    }

    public final void writeSFixed64List(int n10, List list, boolean bl2) {
        this.writeFixed64List(n10, list, bl2);
    }

    public abstract void writeSInt32(int var1);

    public final void writeSInt32List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof IntArrayList;
        if (bl3) {
            list = (IntArrayList)list;
            this.writeSInt32List_Internal(n10, (IntArrayList)list, bl2);
        } else {
            this.writeSInt32List_Internal(n10, list, bl2);
        }
    }

    public abstract void writeSInt64(long var1);

    public final void writeSInt64List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof LongArrayList;
        if (bl3) {
            list = (LongArrayList)list;
            this.writeSInt64List_Internal(n10, (LongArrayList)list, bl2);
        } else {
            this.writeSInt64List_Internal(n10, list, bl2);
        }
    }

    public abstract void writeString(String var1);

    public final void writeStringList(int n10, List list) {
        int n11 = list instanceof LazyStringList;
        if (n11 != 0) {
            List list2 = list;
            list2 = (LazyStringList)list;
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Object object = list2.getRaw(i10);
                this.writeLazyString(n10, object);
            }
        } else {
            for (n11 = list.size() + -1; n11 >= 0; n11 += -1) {
                String string2 = (String)list.get(n11);
                this.writeString(n10, string2);
            }
        }
    }

    public abstract void writeTag(int var1, int var2);

    public final void writeUInt32List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof IntArrayList;
        if (bl3) {
            list = (IntArrayList)list;
            this.writeUInt32List_Internal(n10, (IntArrayList)list, bl2);
        } else {
            this.writeUInt32List_Internal(n10, list, bl2);
        }
    }

    public final void writeUInt64List(int n10, List list, boolean bl2) {
        boolean bl3 = list instanceof LongArrayList;
        if (bl3) {
            list = (LongArrayList)list;
            this.writeUInt64List_Internal(n10, (LongArrayList)list, bl2);
        } else {
            this.writeUInt64List_Internal(n10, list, bl2);
        }
    }

    public abstract void writeVarint32(int var1);

    public abstract void writeVarint64(long var1);
}

