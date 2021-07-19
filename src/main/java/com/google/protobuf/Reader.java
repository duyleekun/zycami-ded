/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.Schema;
import java.util.List;
import java.util.Map;

public interface Reader {
    public static final int READ_DONE = Integer.MAX_VALUE;
    public static final int TAG_UNKNOWN;

    public int getFieldNumber();

    public int getTag();

    public boolean readBool();

    public void readBoolList(List var1);

    public ByteString readBytes();

    public void readBytesList(List var1);

    public double readDouble();

    public void readDoubleList(List var1);

    public int readEnum();

    public void readEnumList(List var1);

    public int readFixed32();

    public void readFixed32List(List var1);

    public long readFixed64();

    public void readFixed64List(List var1);

    public float readFloat();

    public void readFloatList(List var1);

    public Object readGroup(Class var1, ExtensionRegistryLite var2);

    public Object readGroupBySchemaWithCheck(Schema var1, ExtensionRegistryLite var2);

    public void readGroupList(List var1, Schema var2, ExtensionRegistryLite var3);

    public void readGroupList(List var1, Class var2, ExtensionRegistryLite var3);

    public int readInt32();

    public void readInt32List(List var1);

    public long readInt64();

    public void readInt64List(List var1);

    public void readMap(Map var1, MapEntryLite$Metadata var2, ExtensionRegistryLite var3);

    public Object readMessage(Class var1, ExtensionRegistryLite var2);

    public Object readMessageBySchemaWithCheck(Schema var1, ExtensionRegistryLite var2);

    public void readMessageList(List var1, Schema var2, ExtensionRegistryLite var3);

    public void readMessageList(List var1, Class var2, ExtensionRegistryLite var3);

    public int readSFixed32();

    public void readSFixed32List(List var1);

    public long readSFixed64();

    public void readSFixed64List(List var1);

    public int readSInt32();

    public void readSInt32List(List var1);

    public long readSInt64();

    public void readSInt64List(List var1);

    public String readString();

    public void readStringList(List var1);

    public void readStringListRequireUtf8(List var1);

    public String readStringRequireUtf8();

    public int readUInt32();

    public void readUInt32List(List var1);

    public long readUInt64();

    public void readUInt64List(List var1);

    public boolean shouldDiscardUnknownFields();

    public boolean skipField();
}

