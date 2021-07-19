/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.Schema;
import com.google.protobuf.Writer$FieldOrder;
import java.util.List;
import java.util.Map;

public interface Writer {
    public Writer$FieldOrder fieldOrder();

    public void writeBool(int var1, boolean var2);

    public void writeBoolList(int var1, List var2, boolean var3);

    public void writeBytes(int var1, ByteString var2);

    public void writeBytesList(int var1, List var2);

    public void writeDouble(int var1, double var2);

    public void writeDoubleList(int var1, List var2, boolean var3);

    public void writeEndGroup(int var1);

    public void writeEnum(int var1, int var2);

    public void writeEnumList(int var1, List var2, boolean var3);

    public void writeFixed32(int var1, int var2);

    public void writeFixed32List(int var1, List var2, boolean var3);

    public void writeFixed64(int var1, long var2);

    public void writeFixed64List(int var1, List var2, boolean var3);

    public void writeFloat(int var1, float var2);

    public void writeFloatList(int var1, List var2, boolean var3);

    public void writeGroup(int var1, Object var2);

    public void writeGroup(int var1, Object var2, Schema var3);

    public void writeGroupList(int var1, List var2);

    public void writeGroupList(int var1, List var2, Schema var3);

    public void writeInt32(int var1, int var2);

    public void writeInt32List(int var1, List var2, boolean var3);

    public void writeInt64(int var1, long var2);

    public void writeInt64List(int var1, List var2, boolean var3);

    public void writeMap(int var1, MapEntryLite$Metadata var2, Map var3);

    public void writeMessage(int var1, Object var2);

    public void writeMessage(int var1, Object var2, Schema var3);

    public void writeMessageList(int var1, List var2);

    public void writeMessageList(int var1, List var2, Schema var3);

    public void writeMessageSetItem(int var1, Object var2);

    public void writeSFixed32(int var1, int var2);

    public void writeSFixed32List(int var1, List var2, boolean var3);

    public void writeSFixed64(int var1, long var2);

    public void writeSFixed64List(int var1, List var2, boolean var3);

    public void writeSInt32(int var1, int var2);

    public void writeSInt32List(int var1, List var2, boolean var3);

    public void writeSInt64(int var1, long var2);

    public void writeSInt64List(int var1, List var2, boolean var3);

    public void writeStartGroup(int var1);

    public void writeString(int var1, String var2);

    public void writeStringList(int var1, List var2);

    public void writeUInt32(int var1, int var2);

    public void writeUInt32List(int var1, List var2, boolean var3);

    public void writeUInt64(int var1, long var2);

    public void writeUInt64List(int var1, List var2, boolean var3);
}

