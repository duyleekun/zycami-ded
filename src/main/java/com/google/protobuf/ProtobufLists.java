/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$BooleanList;
import com.google.protobuf.Internal$DoubleList;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$LongList;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.ProtobufArrayList;

public final class ProtobufLists {
    private ProtobufLists() {
    }

    public static Internal$BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    public static Internal$DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    public static Internal$FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    public static Internal$IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    public static Internal$LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    public static Internal$ProtobufList emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    public static Internal$ProtobufList mutableCopy(Internal$ProtobufList internal$ProtobufList) {
        int n10 = internal$ProtobufList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$ProtobufList.mutableCopyWithCapacity(n10);
    }

    public static Internal$BooleanList newBooleanList() {
        BooleanArrayList booleanArrayList = new BooleanArrayList();
        return booleanArrayList;
    }

    public static Internal$DoubleList newDoubleList() {
        DoubleArrayList doubleArrayList = new DoubleArrayList();
        return doubleArrayList;
    }

    public static Internal$FloatList newFloatList() {
        FloatArrayList floatArrayList = new FloatArrayList();
        return floatArrayList;
    }

    public static Internal$IntList newIntList() {
        IntArrayList intArrayList = new IntArrayList();
        return intArrayList;
    }

    public static Internal$LongList newLongList() {
        LongArrayList longArrayList = new LongArrayList();
        return longArrayList;
    }
}

