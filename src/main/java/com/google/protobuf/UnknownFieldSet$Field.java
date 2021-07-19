/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$1;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import com.google.protobuf.Writer;
import com.google.protobuf.Writer$FieldOrder;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class UnknownFieldSet$Field {
    private static final UnknownFieldSet$Field fieldDefaultInstance = UnknownFieldSet$Field.newBuilder().build();
    private List fixed32;
    private List fixed64;
    private List group;
    private List lengthDelimited;
    private List varint;

    private UnknownFieldSet$Field() {
    }

    public /* synthetic */ UnknownFieldSet$Field(UnknownFieldSet$1 unknownFieldSet$1) {
        this();
    }

    public static /* synthetic */ void access$100(UnknownFieldSet$Field unknownFieldSet$Field, int n10, Writer writer) {
        unknownFieldSet$Field.writeAsMessageSetExtensionTo(n10, writer);
    }

    public static /* synthetic */ List access$500(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.varint;
    }

    public static /* synthetic */ List access$502(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.varint = list;
        return list;
    }

    public static /* synthetic */ List access$600(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.fixed32;
    }

    public static /* synthetic */ List access$602(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.fixed32 = list;
        return list;
    }

    public static /* synthetic */ List access$700(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.fixed64;
    }

    public static /* synthetic */ List access$702(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.fixed64 = list;
        return list;
    }

    public static /* synthetic */ List access$800(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.lengthDelimited;
    }

    public static /* synthetic */ List access$802(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.lengthDelimited = list;
        return list;
    }

    public static /* synthetic */ List access$900(UnknownFieldSet$Field unknownFieldSet$Field) {
        return unknownFieldSet$Field.group;
    }

    public static /* synthetic */ List access$902(UnknownFieldSet$Field unknownFieldSet$Field, List list) {
        unknownFieldSet$Field.group = list;
        return list;
    }

    public static UnknownFieldSet$Field getDefaultInstance() {
        return fieldDefaultInstance;
    }

    private Object[] getIdentityArray() {
        Object[] objectArray = new Object[5];
        List list = this.varint;
        objectArray[0] = list;
        list = this.fixed32;
        objectArray[1] = list;
        list = this.fixed64;
        objectArray[2] = list;
        list = this.lengthDelimited;
        objectArray[3] = list;
        list = this.group;
        objectArray[4] = list;
        return objectArray;
    }

    public static UnknownFieldSet$Field$Builder newBuilder() {
        return UnknownFieldSet$Field$Builder.access$300();
    }

    public static UnknownFieldSet$Field$Builder newBuilder(UnknownFieldSet$Field unknownFieldSet$Field) {
        return UnknownFieldSet$Field.newBuilder().mergeFrom(unknownFieldSet$Field);
    }

    private void writeAsMessageSetExtensionTo(int n10, Writer writer) {
        Object object;
        Object object2 = writer.fieldOrder();
        if (object2 == (object = Writer$FieldOrder.DESCENDING)) {
            object2 = this.lengthDelimited;
            int n11 = object2.size();
            object2 = object2.listIterator(n11);
            while ((n11 = (int)(object2.hasPrevious() ? 1 : 0)) != 0) {
                object = object2.previous();
                writer.writeMessageSetItem(n10, object);
            }
        } else {
            boolean bl2;
            object2 = this.lengthDelimited.iterator();
            while (bl2 = object2.hasNext()) {
                object = (ByteString)object2.next();
                writer.writeMessageSetItem(n10, object);
            }
        }
    }

    public boolean equals(Object objectArray) {
        if (this == objectArray) {
            return true;
        }
        boolean bl2 = objectArray instanceof UnknownFieldSet$Field;
        if (!bl2) {
            return false;
        }
        Object[] objectArray2 = this.getIdentityArray();
        objectArray = ((UnknownFieldSet$Field)objectArray).getIdentityArray();
        return Arrays.equals(objectArray2, objectArray);
    }

    public List getFixed32List() {
        return this.fixed32;
    }

    public List getFixed64List() {
        return this.fixed64;
    }

    public List getGroupList() {
        return this.group;
    }

    public List getLengthDelimitedList() {
        return this.lengthDelimited;
    }

    public int getSerializedSize(int n10) {
        long l10;
        Object object;
        int n11;
        Iterator iterator2 = this.varint.iterator();
        int n12 = 0;
        while ((n11 = iterator2.hasNext()) != 0) {
            object = (Long)iterator2.next();
            l10 = (Long)object;
            n11 = CodedOutputStream.computeUInt64Size(n10, l10);
            n12 += n11;
        }
        iterator2 = this.fixed32.iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            object = (Integer)iterator2.next();
            n11 = (Integer)object;
            n11 = CodedOutputStream.computeFixed32Size(n10, n11);
            n12 += n11;
        }
        iterator2 = this.fixed64.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Long)iterator2.next();
            l10 = (Long)object;
            n11 = CodedOutputStream.computeFixed64Size(n10, l10);
            n12 += n11;
        }
        iterator2 = this.lengthDelimited.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (ByteString)iterator2.next();
            n11 = CodedOutputStream.computeBytesSize(n10, (ByteString)object);
            n12 += n11;
        }
        iterator2 = this.group.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (UnknownFieldSet)iterator2.next();
            n11 = CodedOutputStream.computeGroupSize(n10, (MessageLite)object);
            n12 += n11;
        }
        return n12;
    }

    public int getSerializedSizeAsMessageSetExtension(int n10) {
        int n11;
        Iterator iterator2 = this.lengthDelimited.iterator();
        int n12 = 0;
        while ((n11 = iterator2.hasNext()) != 0) {
            ByteString byteString = (ByteString)iterator2.next();
            n11 = CodedOutputStream.computeRawMessageSetExtensionSize(n10, byteString);
            n12 += n11;
        }
        return n12;
    }

    public List getVarintList() {
        return this.varint;
    }

    public int hashCode() {
        return Arrays.hashCode(this.getIdentityArray());
    }

    public ByteString toByteString(int n10) {
        Object object;
        int n11;
        try {
            n11 = this.getSerializedSize(n10);
        }
        catch (IOException iOException) {
            object = new RuntimeException("Serializing to a ByteString should never fail with an IOException", iOException);
            throw object;
        }
        object = ByteString.newCodedBuilder(n11);
        CodedOutputStream codedOutputStream = ((ByteString$CodedBuilder)object).getCodedOutput();
        this.writeTo(n10, codedOutputStream);
        return ((ByteString$CodedBuilder)object).build();
    }

    public void writeAsMessageSetExtensionTo(int n10, CodedOutputStream codedOutputStream) {
        boolean bl2;
        Iterator iterator2 = this.lengthDelimited.iterator();
        while (bl2 = iterator2.hasNext()) {
            ByteString byteString = (ByteString)iterator2.next();
            codedOutputStream.writeRawMessageSetExtension(n10, byteString);
        }
    }

    public void writeTo(int n10, CodedOutputStream codedOutputStream) {
        long l10;
        Object object;
        int n11;
        Iterator iterator2 = this.varint.iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            object = (Long)iterator2.next();
            l10 = (Long)object;
            codedOutputStream.writeUInt64(n10, l10);
        }
        iterator2 = this.fixed32.iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            object = (Integer)iterator2.next();
            n11 = (Integer)object;
            codedOutputStream.writeFixed32(n10, n11);
        }
        iterator2 = this.fixed64.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Long)iterator2.next();
            l10 = (Long)object;
            codedOutputStream.writeFixed64(n10, l10);
        }
        iterator2 = this.lengthDelimited.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (ByteString)iterator2.next();
            codedOutputStream.writeBytes(n10, (ByteString)object);
        }
        iterator2 = this.group.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (UnknownFieldSet)iterator2.next();
            codedOutputStream.writeGroup(n10, (MessageLite)object);
        }
    }

    public void writeTo(int n10, Writer writer) {
        Object object = this.varint;
        UnknownFieldSet unknownFieldSet = null;
        writer.writeInt64List(n10, (List)object, false);
        object = this.fixed32;
        writer.writeFixed32List(n10, (List)object, false);
        object = this.fixed64;
        writer.writeFixed64List(n10, (List)object, false);
        object = this.lengthDelimited;
        writer.writeBytesList(n10, (List)object);
        object = writer.fieldOrder();
        Writer$FieldOrder writer$FieldOrder = Writer$FieldOrder.ASCENDING;
        if (object == writer$FieldOrder) {
            int n11;
            for (int i10 = 0; i10 < (n11 = (object = this.group).size()); ++i10) {
                writer.writeStartGroup(n10);
                object = (UnknownFieldSet)this.group.get(i10);
                ((UnknownFieldSet)object).writeTo(writer);
                writer.writeEndGroup(n10);
            }
        } else {
            object = this.group;
            for (int i11 = object.size() + -1; i11 >= 0; i11 += -1) {
                writer.writeEndGroup(n10);
                unknownFieldSet = (UnknownFieldSet)this.group.get(i11);
                unknownFieldSet.writeTo(writer);
                writer.writeStartGroup(n10);
            }
        }
    }
}

