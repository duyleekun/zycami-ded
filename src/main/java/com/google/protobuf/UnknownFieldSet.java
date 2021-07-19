/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Parser;
import com.google.protobuf.Writer;
import com.google.protobuf.Writer$FieldOrder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class UnknownFieldSet
implements MessageLite {
    private static final UnknownFieldSet$Parser PARSER;
    private static final UnknownFieldSet defaultInstance;
    private final Map fields;
    private final Map fieldsDescending;

    static {
        Map map = Collections.emptyMap();
        Map map2 = Collections.emptyMap();
        Object object = new UnknownFieldSet(map, map2);
        defaultInstance = object;
        PARSER = object = new UnknownFieldSet$Parser();
    }

    private UnknownFieldSet() {
        this.fields = null;
        this.fieldsDescending = null;
    }

    public UnknownFieldSet(Map map, Map map2) {
        this.fields = map;
        this.fieldsDescending = map2;
    }

    public static /* synthetic */ Map access$200(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.fields;
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static UnknownFieldSet$Builder newBuilder() {
        return UnknownFieldSet$Builder.access$000();
    }

    public static UnknownFieldSet$Builder newBuilder(UnknownFieldSet unknownFieldSet) {
        return UnknownFieldSet.newBuilder().mergeFrom(unknownFieldSet);
    }

    public static UnknownFieldSet parseFrom(ByteString byteString) {
        return ((UnknownFieldSet$Builder)UnknownFieldSet.newBuilder().mergeFrom(byteString)).build();
    }

    public static UnknownFieldSet parseFrom(CodedInputStream codedInputStream) {
        return ((UnknownFieldSet$Builder)UnknownFieldSet.newBuilder().mergeFrom(codedInputStream)).build();
    }

    public static UnknownFieldSet parseFrom(InputStream inputStream) {
        return ((UnknownFieldSet$Builder)UnknownFieldSet.newBuilder().mergeFrom(inputStream)).build();
    }

    public static UnknownFieldSet parseFrom(byte[] byArray) {
        return ((UnknownFieldSet$Builder)UnknownFieldSet.newBuilder().mergeFrom(byArray)).build();
    }

    public Map asMap() {
        return this.fields;
    }

    public boolean equals(Object object) {
        Map map;
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof UnknownFieldSet;
        if (!bl4 || !(bl2 = (map = this.fields).equals(object = ((UnknownFieldSet)object).fields))) {
            bl3 = false;
        }
        return bl3;
    }

    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    public UnknownFieldSet$Field getField(int n10) {
        Map map = this.fields;
        Object object = n10;
        if ((object = (UnknownFieldSet$Field)map.get(object)) == null) {
            object = UnknownFieldSet$Field.getDefaultInstance();
        }
        return object;
    }

    public final UnknownFieldSet$Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10;
        Iterator iterator2 = this.fields.entrySet().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = iterator2.next();
            UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
            object = (Integer)object.getKey();
            n10 = (Integer)object;
            n10 = unknownFieldSet$Field.getSerializedSize(n10);
            n11 += n10;
        }
        return n11;
    }

    public int getSerializedSizeAsMessageSet() {
        int n10;
        Iterator iterator2 = this.fields.entrySet().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = iterator2.next();
            UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
            object = (Integer)object.getKey();
            n10 = (Integer)object;
            n10 = unknownFieldSet$Field.getSerializedSizeAsMessageSetExtension(n10);
            n11 += n10;
        }
        return n11;
    }

    public boolean hasField(int n10) {
        Map map = this.fields;
        Integer n11 = n10;
        return map.containsKey(n11);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isInitialized() {
        return true;
    }

    public UnknownFieldSet$Builder newBuilderForType() {
        return UnknownFieldSet.newBuilder();
    }

    public UnknownFieldSet$Builder toBuilder() {
        return UnknownFieldSet.newBuilder().mergeFrom(this);
    }

    public byte[] toByteArray() {
        Object object;
        int n10;
        try {
            n10 = this.getSerializedSize();
        }
        catch (IOException iOException) {
            object = new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
            throw object;
        }
        byte[] byArray = new byte[n10];
        object = CodedOutputStream.newInstance(byArray);
        this.writeTo((CodedOutputStream)object);
        ((CodedOutputStream)object).checkNoSpaceLeft();
        return byArray;
    }

    public ByteString toByteString() {
        Object object;
        int n10;
        try {
            n10 = this.getSerializedSize();
        }
        catch (IOException iOException) {
            object = new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", iOException);
            throw object;
        }
        ByteString$CodedBuilder byteString$CodedBuilder = ByteString.newCodedBuilder(n10);
        object = byteString$CodedBuilder.getCodedOutput();
        this.writeTo((CodedOutputStream)object);
        return byteString$CodedBuilder.build();
    }

    public String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) {
        int n10;
        Iterator iterator2 = this.fields.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = iterator2.next();
            UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
            object = (Integer)object.getKey();
            n10 = (Integer)object;
            unknownFieldSet$Field.writeAsMessageSetExtensionTo(n10, codedOutputStream);
        }
    }

    public void writeAsMessageSetTo(Writer writer) {
        Object object;
        Object object2 = writer.fieldOrder();
        if (object2 == (object = Writer$FieldOrder.DESCENDING)) {
            int n10;
            object2 = this.fieldsDescending.entrySet().iterator();
            while ((n10 = object2.hasNext()) != 0) {
                object = (Map.Entry)object2.next();
                UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
                object = (Integer)object.getKey();
                n10 = (Integer)object;
                UnknownFieldSet$Field.access$100(unknownFieldSet$Field, n10, writer);
            }
        } else {
            int n11;
            object2 = this.fields.entrySet().iterator();
            while ((n11 = object2.hasNext()) != 0) {
                object = (Map.Entry)object2.next();
                UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
                object = (Integer)object.getKey();
                n11 = (Integer)object;
                UnknownFieldSet$Field.access$100(unknownFieldSet$Field, n11, writer);
            }
        }
    }

    public void writeDelimitedTo(OutputStream object) {
        object = CodedOutputStream.newInstance((OutputStream)object);
        int n10 = this.getSerializedSize();
        ((CodedOutputStream)object).writeRawVarint32(n10);
        this.writeTo((CodedOutputStream)object);
        ((CodedOutputStream)object).flush();
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        Iterator iterator2 = this.fields.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = iterator2.next();
            UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
            object = (Integer)object.getKey();
            n10 = (Integer)object;
            unknownFieldSet$Field.writeTo(n10, codedOutputStream);
        }
    }

    public void writeTo(Writer writer) {
        Object object;
        Object object2 = writer.fieldOrder();
        if (object2 == (object = Writer$FieldOrder.DESCENDING)) {
            int n10;
            object2 = this.fieldsDescending.entrySet().iterator();
            while ((n10 = object2.hasNext()) != 0) {
                object = (Map.Entry)object2.next();
                UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
                object = (Integer)object.getKey();
                n10 = (Integer)object;
                unknownFieldSet$Field.writeTo(n10, writer);
            }
        } else {
            int n11;
            object2 = this.fields.entrySet().iterator();
            while ((n11 = object2.hasNext()) != 0) {
                object = (Map.Entry)object2.next();
                UnknownFieldSet$Field unknownFieldSet$Field = (UnknownFieldSet$Field)object.getValue();
                object = (Integer)object.getKey();
                n11 = (Integer)object;
                unknownFieldSet$Field.writeTo(n11, writer);
            }
        }
    }

    public void writeTo(OutputStream object) {
        object = CodedOutputStream.newInstance((OutputStream)object);
        this.writeTo((CodedOutputStream)object);
        ((CodedOutputStream)object).flush();
    }
}

