/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$Utf8Validation;

public final class WireFormat {
    public static final int FIXED32_SIZE = 4;
    public static final int FIXED64_SIZE = 8;
    public static final int MAX_VARINT32_SIZE = 5;
    public static final int MAX_VARINT64_SIZE = 10;
    public static final int MAX_VARINT_SIZE = 10;
    public static final int MESSAGE_SET_ITEM = 1;
    public static final int MESSAGE_SET_ITEM_END_TAG = 0;
    public static final int MESSAGE_SET_ITEM_TAG = 0;
    public static final int MESSAGE_SET_MESSAGE = 3;
    public static final int MESSAGE_SET_MESSAGE_TAG = 0;
    public static final int MESSAGE_SET_TYPE_ID = 2;
    public static final int MESSAGE_SET_TYPE_ID_TAG = 0;
    public static final int TAG_TYPE_BITS = 3;
    public static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT;

    static {
        int n10 = 1;
        int n11 = 3;
        MESSAGE_SET_ITEM_TAG = WireFormat.makeTag(n10, n11);
        MESSAGE_SET_ITEM_END_TAG = WireFormat.makeTag(n10, 4);
        n10 = 2;
        MESSAGE_SET_TYPE_ID_TAG = WireFormat.makeTag(n10, 0);
        MESSAGE_SET_MESSAGE_TAG = WireFormat.makeTag(n11, n10);
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int n10) {
        return n10 >>> 3;
    }

    public static int getTagWireType(int n10) {
        return n10 & 7;
    }

    public static int makeTag(int n10, int n11) {
        return n10 << 3 | n11;
    }

    public static Object readPrimitiveField(CodedInputStream object, WireFormat$FieldType wireFormat$FieldType, WireFormat$Utf8Validation wireFormat$Utf8Validation) {
        int[] nArray = WireFormat$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
        int n10 = wireFormat$FieldType.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                object = new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
                throw object;
            }
            case 18: {
                object = new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                throw object;
            }
            case 17: {
                object = new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                throw object;
            }
            case 16: {
                object = new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                throw object;
            }
            case 15: {
                return wireFormat$Utf8Validation.readString((CodedInputStream)object);
            }
            case 14: {
                return ((CodedInputStream)object).readSInt64();
            }
            case 13: {
                return ((CodedInputStream)object).readSInt32();
            }
            case 12: {
                return ((CodedInputStream)object).readSFixed64();
            }
            case 11: {
                return ((CodedInputStream)object).readSFixed32();
            }
            case 10: {
                return ((CodedInputStream)object).readUInt32();
            }
            case 9: {
                return ((CodedInputStream)object).readBytes();
            }
            case 8: {
                return ((CodedInputStream)object).readBool();
            }
            case 7: {
                return ((CodedInputStream)object).readFixed32();
            }
            case 6: {
                return ((CodedInputStream)object).readFixed64();
            }
            case 5: {
                return ((CodedInputStream)object).readInt32();
            }
            case 4: {
                return ((CodedInputStream)object).readUInt64();
            }
            case 3: {
                return ((CodedInputStream)object).readInt64();
            }
            case 2: {
                return Float.valueOf(((CodedInputStream)object).readFloat());
            }
            case 1: 
        }
        return ((CodedInputStream)object).readDouble();
    }
}

