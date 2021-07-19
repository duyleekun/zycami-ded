/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedOutputStreamWriter$1;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.Writer;
import com.google.protobuf.Writer$FieldOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class CodedOutputStreamWriter
implements Writer {
    private final CodedOutputStream output;

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        this.output = codedOutputStream = (CodedOutputStream)Internal.checkNotNull(codedOutputStream, "output");
        codedOutputStream.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        codedOutputStreamWriter = new CodedOutputStreamWriter(codedOutputStream);
        return codedOutputStreamWriter;
    }

    private void writeDeterministicBooleanMapEntry(int n10, boolean bl2, Object object, MapEntryLite$Metadata mapEntryLite$Metadata) {
        this.output.writeTag(n10, 2);
        CodedOutputStream codedOutputStream = this.output;
        Boolean bl3 = bl2;
        int n11 = MapEntryLite.computeSerializedSize(mapEntryLite$Metadata, bl3, object);
        codedOutputStream.writeUInt32NoTag(n11);
        codedOutputStream = this.output;
        Boolean bl4 = bl2;
        MapEntryLite.writeTo(codedOutputStream, mapEntryLite$Metadata, bl4, object);
    }

    private void writeDeterministicIntegerMap(int n10, MapEntryLite$Metadata mapEntryLite$Metadata, Map map) {
        int n11;
        Object object;
        int n12;
        int n13 = map.size();
        int[] nArray = new int[n13];
        Object object2 = map.keySet().iterator();
        int n14 = 0;
        int n15 = 0;
        Integer n16 = null;
        while ((n12 = object2.hasNext()) != 0) {
            object = (Integer)object2.next();
            n12 = (Integer)object;
            n11 = n15 + 1;
            nArray[n15] = n12;
            n15 = n11;
        }
        Arrays.sort(nArray);
        while (n14 < n13) {
            int n17 = nArray[n14];
            n16 = n17;
            n16 = map.get(n16);
            this.output.writeTag(n10, 2);
            object = this.output;
            Integer n18 = n17;
            n11 = MapEntryLite.computeSerializedSize(mapEntryLite$Metadata, n18, n16);
            ((CodedOutputStream)object).writeUInt32NoTag(n11);
            object = this.output;
            object2 = n17;
            MapEntryLite.writeTo((CodedOutputStream)object, mapEntryLite$Metadata, object2, n16);
            ++n14;
        }
    }

    private void writeDeterministicLongMap(int n10, MapEntryLite$Metadata mapEntryLite$Metadata, Map map) {
        int n11;
        boolean bl2;
        int n12 = map.size();
        long[] lArray = new long[n12];
        Object object = map.keySet().iterator();
        int n13 = 0;
        int n14 = 0;
        Long l10 = null;
        while (bl2 = object.hasNext()) {
            Long l11 = (Long)object.next();
            long l12 = l11;
            n11 = n14 + 1;
            lArray[n14] = l12;
            n14 = n11;
        }
        Arrays.sort(lArray);
        while (n13 < n12) {
            long l13 = lArray[n13];
            object = l13;
            object = map.get(object);
            this.output.writeTag(n10, 2);
            CodedOutputStream codedOutputStream = this.output;
            Long l14 = l13;
            n11 = MapEntryLite.computeSerializedSize(mapEntryLite$Metadata, l14, object);
            codedOutputStream.writeUInt32NoTag(n11);
            codedOutputStream = this.output;
            l10 = l13;
            MapEntryLite.writeTo(codedOutputStream, mapEntryLite$Metadata, l10, object);
            ++n13;
        }
    }

    private void writeDeterministicMap(int n10, MapEntryLite$Metadata object, Map object2) {
        Object object3 = CodedOutputStreamWriter$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
        WireFormat$FieldType wireFormat$FieldType = object.keyType;
        int n11 = wireFormat$FieldType.ordinal();
        boolean bl2 = object3[n11];
        switch (bl2) {
            default: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("does not support key type: ");
                object = object.keyType;
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            case 12: {
                this.writeDeterministicStringMap(n10, (MapEntryLite$Metadata)object, (Map)object2);
                break;
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                this.writeDeterministicLongMap(n10, (MapEntryLite$Metadata)object, (Map)object2);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                this.writeDeterministicIntegerMap(n10, (MapEntryLite$Metadata)object, (Map)object2);
                break;
            }
            case 1: {
                object3 = Boolean.FALSE;
                object3 = object2.get(object3);
                if (object3 != null) {
                    n11 = 0;
                    wireFormat$FieldType = null;
                    this.writeDeterministicBooleanMapEntry(n10, false, object3, (MapEntryLite$Metadata)object);
                }
                if ((object2 = object2.get(object3 = (Object)Boolean.TRUE)) == null) break;
                bl2 = true;
                this.writeDeterministicBooleanMapEntry(n10, bl2, object2, (MapEntryLite$Metadata)object);
            }
        }
    }

    private void writeDeterministicStringMap(int n10, MapEntryLite$Metadata mapEntryLite$Metadata, Map map) {
        int n11;
        Object object;
        boolean bl2;
        int n12 = map.size();
        Object[] objectArray = new String[n12];
        Object object2 = map.keySet().iterator();
        int n13 = 0;
        int n14 = 0;
        Object var9_9 = null;
        while (bl2 = object2.hasNext()) {
            object = (String)object2.next();
            n11 = n14 + 1;
            objectArray[n14] = object;
            n14 = n11;
        }
        Arrays.sort(objectArray);
        while (n13 < n12) {
            object2 = objectArray[n13];
            var9_9 = map.get(object2);
            this.output.writeTag(n10, 2);
            object = this.output;
            n11 = MapEntryLite.computeSerializedSize(mapEntryLite$Metadata, object2, var9_9);
            ((CodedOutputStream)object).writeUInt32NoTag(n11);
            object = this.output;
            MapEntryLite.writeTo((CodedOutputStream)object, mapEntryLite$Metadata, object2, var9_9);
            ++n13;
        }
    }

    private void writeLazyString(int n10, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            CodedOutputStream codedOutputStream = this.output;
            object = (String)object;
            codedOutputStream.writeString(n10, (String)object);
        } else {
            CodedOutputStream codedOutputStream = this.output;
            object = (ByteString)object;
            codedOutputStream.writeBytes(n10, (ByteString)object);
        }
    }

    public Writer$FieldOrder fieldOrder() {
        return Writer$FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    public void writeBool(int n10, boolean bl2) {
        this.output.writeBool(n10, bl2);
    }

    /*
     * WARNING - void declaration
     */
    public void writeBoolList(int n10, List list, boolean n11) {
        int n12;
        if (n11 != 0) {
            void var3_5;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            boolean bl2 = false;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Boolean bl3 = (Boolean)list.get(n10);
                n13 = CodedOutputStream.computeBoolSizeNoTag(bl3);
                var3_5 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag((int)var3_5);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Boolean)list.get(n12);
                boolean bl4 = (Boolean)object;
                codedOutputStream.writeBoolNoTag(bl4);
                ++n12;
            }
        } else {
            int n14;
            for (n12 = 0; n12 < (n14 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Boolean bl5 = (Boolean)list.get(n12);
                boolean bl6 = bl5;
                codedOutputStream.writeBool(n10, bl6);
            }
        }
    }

    public void writeBytes(int n10, ByteString byteString) {
        this.output.writeBytes(n10, byteString);
    }

    public void writeBytesList(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            CodedOutputStream codedOutputStream = this.output;
            ByteString byteString = (ByteString)list.get(i10);
            codedOutputStream.writeBytes(n10, byteString);
        }
    }

    public void writeDouble(int n10, double d10) {
        this.output.writeDouble(n10, d10);
    }

    public void writeDoubleList(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            double d10;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Double d11 = (Double)list.get(n10);
                d10 = d11;
                n13 = CodedOutputStream.computeDoubleSizeNoTag(d10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Double)list.get(n12);
                d10 = (Double)object;
                codedOutputStream.writeDoubleNoTag(d10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Double d12 = (Double)list.get(n12);
                double d13 = d12;
                codedOutputStream.writeDouble(n10, d13);
            }
        }
    }

    public void writeEndGroup(int n10) {
        this.output.writeTag(n10, 4);
    }

    public void writeEnum(int n10, int n11) {
        this.output.writeEnum(n10, n11);
    }

    public void writeEnumList(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = CodedOutputStream.computeEnumSizeNoTag(n14);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                codedOutputStream.writeEnumNoTag(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                codedOutputStream.writeEnum(n10, n16);
            }
        }
    }

    public void writeFixed32(int n10, int n11) {
        this.output.writeFixed32(n10, n11);
    }

    public void writeFixed32List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = CodedOutputStream.computeFixed32SizeNoTag(n14);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                codedOutputStream.writeFixed32NoTag(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                codedOutputStream.writeFixed32(n10, n16);
            }
        }
    }

    public void writeFixed64(int n10, long l10) {
        this.output.writeFixed64(n10, l10);
    }

    public void writeFixed64List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = CodedOutputStream.computeFixed64SizeNoTag(l10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                codedOutputStream.writeFixed64NoTag(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                codedOutputStream.writeFixed64(n10, l13);
            }
        }
    }

    public void writeFloat(int n10, float f10) {
        this.output.writeFloat(n10, f10);
    }

    public void writeFloatList(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            float f10 = 2.8E-45f;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            float f11 = 0.0f;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Float f12 = (Float)list.get(n10);
                f10 = f12.floatValue();
                n13 = CodedOutputStream.computeFloatSizeNoTag(f10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Float)list.get(n12);
                f11 = ((Float)object).floatValue();
                codedOutputStream.writeFloatNoTag(f11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Float f13 = (Float)list.get(n12);
                float f14 = f13.floatValue();
                codedOutputStream.writeFloat(n10, f14);
            }
        }
    }

    public void writeGroup(int n10, Object object) {
        CodedOutputStream codedOutputStream = this.output;
        object = (MessageLite)object;
        codedOutputStream.writeGroup(n10, (MessageLite)object);
    }

    public void writeGroup(int n10, Object object, Schema schema) {
        CodedOutputStream codedOutputStream = this.output;
        object = (MessageLite)object;
        codedOutputStream.writeGroup(n10, (MessageLite)object, schema);
    }

    public void writeGroupList(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.writeGroup(n10, e10);
        }
    }

    public void writeGroupList(int n10, List list, Schema schema) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.writeGroup(n10, e10, schema);
        }
    }

    public void writeInt32(int n10, int n11) {
        this.output.writeInt32(n10, n11);
    }

    public void writeInt32List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = CodedOutputStream.computeInt32SizeNoTag(n14);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                codedOutputStream.writeInt32NoTag(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                codedOutputStream.writeInt32(n10, n16);
            }
        }
    }

    public void writeInt64(int n10, long l10) {
        this.output.writeInt64(n10, l10);
    }

    public void writeInt64List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = CodedOutputStream.computeInt64SizeNoTag(l10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                codedOutputStream.writeInt64NoTag(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                codedOutputStream.writeInt64(n10, l13);
            }
        }
    }

    public void writeMap(int n10, MapEntryLite$Metadata mapEntryLite$Metadata, Map object) {
        Object object2 = this.output;
        boolean bl2 = ((CodedOutputStream)object2).isSerializationDeterministic();
        if (bl2) {
            this.writeDeterministicMap(n10, mapEntryLite$Metadata, (Map)object);
            return;
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            this.output.writeTag(n10, 2);
            CodedOutputStream codedOutputStream = this.output;
            Object k10 = object2.getKey();
            Object v10 = object2.getValue();
            int n11 = MapEntryLite.computeSerializedSize(mapEntryLite$Metadata, k10, v10);
            codedOutputStream.writeUInt32NoTag(n11);
            codedOutputStream = this.output;
            k10 = object2.getKey();
            object2 = object2.getValue();
            MapEntryLite.writeTo(codedOutputStream, mapEntryLite$Metadata, k10, object2);
        }
    }

    public void writeMessage(int n10, Object object) {
        CodedOutputStream codedOutputStream = this.output;
        object = (MessageLite)object;
        codedOutputStream.writeMessage(n10, (MessageLite)object);
    }

    public void writeMessage(int n10, Object object, Schema schema) {
        CodedOutputStream codedOutputStream = this.output;
        object = (MessageLite)object;
        codedOutputStream.writeMessage(n10, (MessageLite)object, schema);
    }

    public void writeMessageList(int n10, List list) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.writeMessage(n10, e10);
        }
    }

    public void writeMessageList(int n10, List list, Schema schema) {
        int n11;
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Object e10 = list.get(i10);
            this.writeMessage(n10, e10, schema);
        }
    }

    public final void writeMessageSetItem(int n10, Object object) {
        boolean bl2 = object instanceof ByteString;
        if (bl2) {
            CodedOutputStream codedOutputStream = this.output;
            object = (ByteString)object;
            codedOutputStream.writeRawMessageSetExtension(n10, (ByteString)object);
        } else {
            CodedOutputStream codedOutputStream = this.output;
            object = (MessageLite)object;
            codedOutputStream.writeMessageSetExtension(n10, (MessageLite)object);
        }
    }

    public void writeSFixed32(int n10, int n11) {
        this.output.writeSFixed32(n10, n11);
    }

    public void writeSFixed32List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = CodedOutputStream.computeSFixed32SizeNoTag(n14);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                codedOutputStream.writeSFixed32NoTag(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                codedOutputStream.writeSFixed32(n10, n16);
            }
        }
    }

    public void writeSFixed64(int n10, long l10) {
        this.output.writeSFixed64(n10, l10);
    }

    public void writeSFixed64List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = CodedOutputStream.computeSFixed64SizeNoTag(l10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                codedOutputStream.writeSFixed64NoTag(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                codedOutputStream.writeSFixed64(n10, l13);
            }
        }
    }

    public void writeSInt32(int n10, int n11) {
        this.output.writeSInt32(n10, n11);
    }

    public void writeSInt32List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = CodedOutputStream.computeSInt32SizeNoTag(n14);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                codedOutputStream.writeSInt32NoTag(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                codedOutputStream.writeSInt32(n10, n16);
            }
        }
    }

    public void writeSInt64(int n10, long l10) {
        this.output.writeSInt64(n10, l10);
    }

    public void writeSInt64List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = CodedOutputStream.computeSInt64SizeNoTag(l10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                codedOutputStream.writeSInt64NoTag(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                codedOutputStream.writeSInt64(n10, l13);
            }
        }
    }

    public void writeStartGroup(int n10) {
        this.output.writeTag(n10, 3);
    }

    public void writeString(int n10, String string2) {
        this.output.writeString(n10, string2);
    }

    public void writeStringList(int n10, List list) {
        int n11;
        int n12 = list instanceof LazyStringList;
        if (n12 != 0) {
            int n13;
            List list2 = list;
            list2 = (LazyStringList)list;
            for (n11 = 0; n11 < (n13 = list.size()); ++n11) {
                Object object = list2.getRaw(n11);
                this.writeLazyString(n10, object);
            }
        } else {
            while (n11 < (n12 = list.size())) {
                CodedOutputStream codedOutputStream = this.output;
                String string2 = (String)list.get(n11);
                codedOutputStream.writeString(n10, string2);
                ++n11;
            }
        }
    }

    public void writeUInt32(int n10, int n11) {
        this.output.writeUInt32(n10, n11);
    }

    public void writeUInt32List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Integer n14 = (Integer)list.get(n10);
                n13 = CodedOutputStream.computeUInt32SizeNoTag(n14);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Integer)list.get(n12);
                n11 = (Integer)object;
                codedOutputStream.writeUInt32NoTag(n11);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Integer n15 = (Integer)list.get(n12);
                int n16 = n15;
                codedOutputStream.writeUInt32(n10, n16);
            }
        }
    }

    public void writeUInt64(int n10, long l10) {
        this.output.writeUInt64(n10, l10);
    }

    public void writeUInt64List(int n10, List list, boolean n11) {
        int n12;
        if (n11) {
            long l10;
            Object object = this.output;
            int n13 = 2;
            ((CodedOutputStream)object).writeTag(n10, n13);
            CodedOutputStream codedOutputStream = null;
            n11 = 0;
            object = null;
            for (n10 = 0; n10 < (n13 = list.size()); ++n10) {
                Long l11 = (Long)list.get(n10);
                l10 = l11;
                n13 = CodedOutputStream.computeUInt64SizeNoTag(l10);
                n11 += n13;
            }
            codedOutputStream = this.output;
            codedOutputStream.writeUInt32NoTag(n11);
            while (n12 < (n10 = list.size())) {
                codedOutputStream = this.output;
                object = (Long)list.get(n12);
                l10 = (Long)object;
                codedOutputStream.writeUInt64NoTag(l10);
                ++n12;
            }
        } else {
            for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
                CodedOutputStream codedOutputStream = this.output;
                Long l12 = (Long)list.get(n12);
                long l13 = l12;
                codedOutputStream.writeUInt64(n10, l13);
            }
        }
    }
}

