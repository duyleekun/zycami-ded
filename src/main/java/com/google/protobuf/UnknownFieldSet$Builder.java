/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.UnknownFieldSet$Field$Builder;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class UnknownFieldSet$Builder
implements MessageLite$Builder {
    private Map fields;
    private UnknownFieldSet$Field$Builder lastField;
    private int lastFieldNumber;

    private UnknownFieldSet$Builder() {
    }

    public static /* synthetic */ UnknownFieldSet$Builder access$000() {
        return UnknownFieldSet$Builder.create();
    }

    private static UnknownFieldSet$Builder create() {
        UnknownFieldSet$Builder unknownFieldSet$Builder = new UnknownFieldSet$Builder();
        unknownFieldSet$Builder.reinitialize();
        return unknownFieldSet$Builder;
    }

    private UnknownFieldSet$Field$Builder getFieldBuilder(int n10) {
        UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder;
        Object object = this.lastField;
        if (object != null) {
            int n11 = this.lastFieldNumber;
            if (n10 == n11) {
                return object;
            }
            object = ((UnknownFieldSet$Field$Builder)object).build();
            this.addField(n11, (UnknownFieldSet$Field)object);
        }
        if (n10 == 0) {
            return null;
        }
        object = this.fields;
        Integer n12 = n10;
        object = (UnknownFieldSet$Field)object.get(n12);
        this.lastFieldNumber = n10;
        this.lastField = unknownFieldSet$Field$Builder = UnknownFieldSet$Field.newBuilder();
        if (object != null) {
            unknownFieldSet$Field$Builder.mergeFrom((UnknownFieldSet$Field)object);
        }
        return this.lastField;
    }

    private void reinitialize() {
        Map map;
        this.fields = map = Collections.emptyMap();
        this.lastFieldNumber = 0;
        this.lastField = null;
    }

    public UnknownFieldSet$Builder addField(int n10, UnknownFieldSet$Field unknownFieldSet$Field) {
        if (n10 != 0) {
            int n11;
            Object object = this.lastField;
            if (object != null && (n11 = this.lastFieldNumber) == n10) {
                this.lastField = null;
                n11 = 0;
                object = null;
                this.lastFieldNumber = 0;
            }
            if ((n11 = (int)((object = this.fields).isEmpty() ? 1 : 0)) != 0) {
                this.fields = object = new Object();
            }
            object = this.fields;
            Integer n12 = n10;
            object.put(n12, unknownFieldSet$Field);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public Map asMap() {
        this.getFieldBuilder(0);
        return Collections.unmodifiableMap(this.fields);
    }

    public UnknownFieldSet build() {
        this.getFieldBuilder(0);
        Object object = this.fields;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = UnknownFieldSet.getDefaultInstance();
        } else {
            object = Collections.unmodifiableMap(((TreeMap)this.fields).descendingMap());
            Map map = Collections.unmodifiableMap(this.fields);
            UnknownFieldSet unknownFieldSet = new UnknownFieldSet(map, (Map)object);
            object = unknownFieldSet;
        }
        this.fields = null;
        return object;
    }

    public UnknownFieldSet buildPartial() {
        return this.build();
    }

    public UnknownFieldSet$Builder clear() {
        this.reinitialize();
        return this;
    }

    public UnknownFieldSet$Builder clearField(int n10) {
        if (n10 != 0) {
            Integer n11;
            int n12;
            Object object = this.lastField;
            if (object != null && (n12 = this.lastFieldNumber) == n10) {
                this.lastField = null;
                n12 = 0;
                object = null;
                this.lastFieldNumber = 0;
            }
            if ((n12 = (int)((object = this.fields).containsKey(n11 = Integer.valueOf(n10)) ? 1 : 0)) != 0) {
                object = this.fields;
                Integer n13 = n10;
                object.remove(n13);
            }
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public UnknownFieldSet$Builder clone() {
        this.getFieldBuilder(0);
        Map map = Collections.unmodifiableMap(((TreeMap)this.fields).descendingMap());
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        Map map2 = this.fields;
        UnknownFieldSet unknownFieldSet = new UnknownFieldSet(map2, map);
        return unknownFieldSet$Builder.mergeFrom(unknownFieldSet);
    }

    public UnknownFieldSet getDefaultInstanceForType() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public boolean hasField(int n10) {
        if (n10 != 0) {
            Integer n11;
            Map map;
            int n12 = this.lastFieldNumber;
            if (n10 != n12 && (n10 = (int)((map = this.fields).containsKey(n11 = Integer.valueOf(n10)) ? 1 : 0)) == 0) {
                n10 = 0;
                n11 = null;
            } else {
                n10 = 1;
            }
            return n10 != 0;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public boolean isInitialized() {
        return true;
    }

    public boolean mergeDelimitedFrom(InputStream inputStream) {
        int n10;
        int n11 = inputStream.read();
        if (n11 == (n10 = -1)) {
            return false;
        }
        n11 = CodedInputStream.readRawVarint32(n11, inputStream);
        AbstractMessageLite$Builder$LimitedInputStream abstractMessageLite$Builder$LimitedInputStream = new AbstractMessageLite$Builder$LimitedInputStream(inputStream, n11);
        this.mergeFrom(abstractMessageLite$Builder$LimitedInputStream);
        return true;
    }

    public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeDelimitedFrom(inputStream);
    }

    public UnknownFieldSet$Builder mergeField(int n10, UnknownFieldSet$Field unknownFieldSet$Field) {
        if (n10 != 0) {
            boolean bl2 = this.hasField(n10);
            if (bl2) {
                UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = this.getFieldBuilder(n10);
                unknownFieldSet$Field$Builder.mergeFrom(unknownFieldSet$Field);
            } else {
                this.addField(n10, unknownFieldSet$Field);
            }
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public boolean mergeFieldFrom(int n10, CodedInputStream object) {
        int n11 = WireFormat.getTagFieldNumber(n10);
        n10 = WireFormat.getTagWireType(n10);
        int n12 = 1;
        if (n10 != 0) {
            if (n10 != n12) {
                int n13 = 2;
                if (n10 != n13) {
                    n13 = 3;
                    if (n10 != n13) {
                        n13 = 4;
                        if (n10 != n13) {
                            n13 = 5;
                            if (n10 == n13) {
                                UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = this.getFieldBuilder(n11);
                                int n14 = ((CodedInputStream)object).readFixed32();
                                unknownFieldSet$Field$Builder.addFixed32(n14);
                                return n12;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    MessageLiteOrBuilder messageLiteOrBuilder = UnknownFieldSet.newBuilder();
                    ExtensionRegistry extensionRegistry = ExtensionRegistry.getEmptyRegistry();
                    ((CodedInputStream)object).readGroup(n11, (MessageLite$Builder)messageLiteOrBuilder, (ExtensionRegistryLite)extensionRegistry);
                    object = this.getFieldBuilder(n11);
                    messageLiteOrBuilder = messageLiteOrBuilder.build();
                    ((UnknownFieldSet$Field$Builder)object).addGroup((UnknownFieldSet)messageLiteOrBuilder);
                    return n12;
                }
                UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = this.getFieldBuilder(n11);
                object = ((CodedInputStream)object).readBytes();
                unknownFieldSet$Field$Builder.addLengthDelimited((ByteString)object);
                return n12;
            }
            UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = this.getFieldBuilder(n11);
            long l10 = ((CodedInputStream)object).readFixed64();
            unknownFieldSet$Field$Builder.addFixed64(l10);
            return n12;
        }
        UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = this.getFieldBuilder(n11);
        long l11 = ((CodedInputStream)object).readInt64();
        unknownFieldSet$Field$Builder.addVarint(l11);
        return n12;
    }

    public UnknownFieldSet$Builder mergeFrom(ByteString object) {
        object = ((ByteString)object).newCodedInput();
        this.mergeFrom((CodedInputStream)object);
        RuntimeException runtimeException = null;
        try {
            ((CodedInputStream)object).checkLastTagWas(0);
            return this;
        }
        catch (IOException iOException) {
            runtimeException = new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", iOException);
            throw runtimeException;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException;
        }
    }

    public UnknownFieldSet$Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(byteString);
    }

    public UnknownFieldSet$Builder mergeFrom(CodedInputStream codedInputStream) {
        int n10;
        while ((n10 = codedInputStream.readTag()) != 0 && (n10 = (int)(this.mergeFieldFrom(n10, codedInputStream) ? 1 : 0)) != 0) {
        }
        return this;
    }

    public UnknownFieldSet$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(codedInputStream);
    }

    public UnknownFieldSet$Builder mergeFrom(MessageLite object) {
        boolean bl2 = object instanceof UnknownFieldSet;
        if (bl2) {
            object = (UnknownFieldSet)object;
            return this.mergeFrom((UnknownFieldSet)object);
        }
        object = new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        throw object;
    }

    public UnknownFieldSet$Builder mergeFrom(UnknownFieldSet object) {
        Object object2 = UnknownFieldSet.getDefaultInstance();
        if (object != object2) {
            boolean bl2;
            object = UnknownFieldSet.access$200((UnknownFieldSet)object).entrySet().iterator();
            while (bl2 = object.hasNext()) {
                object2 = (Map.Entry)object.next();
                Integer n10 = (Integer)object2.getKey();
                int n11 = n10;
                object2 = (UnknownFieldSet$Field)object2.getValue();
                this.mergeField(n11, (UnknownFieldSet$Field)object2);
            }
        }
        return this;
    }

    public UnknownFieldSet$Builder mergeFrom(InputStream object) {
        object = CodedInputStream.newInstance((InputStream)object);
        this.mergeFrom((CodedInputStream)object);
        ((CodedInputStream)object).checkLastTagWas(0);
        return this;
    }

    public UnknownFieldSet$Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(inputStream);
    }

    public UnknownFieldSet$Builder mergeFrom(byte[] object) {
        object = CodedInputStream.newInstance((byte[])object);
        this.mergeFrom((CodedInputStream)object);
        RuntimeException runtimeException = null;
        try {
            ((CodedInputStream)object).checkLastTagWas(0);
            return this;
        }
        catch (IOException iOException) {
            runtimeException = new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
            throw runtimeException;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException;
        }
    }

    public UnknownFieldSet$Builder mergeFrom(byte[] object, int n10, int n11) {
        object = CodedInputStream.newInstance((byte[])object, n10, n11);
        this.mergeFrom((CodedInputStream)object);
        n10 = 0;
        RuntimeException runtimeException = null;
        try {
            ((CodedInputStream)object).checkLastTagWas(0);
            return this;
        }
        catch (IOException iOException) {
            runtimeException = new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
            throw runtimeException;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException;
        }
    }

    public UnknownFieldSet$Builder mergeFrom(byte[] byArray, int n10, int n11, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(byArray, n10, n11);
    }

    public UnknownFieldSet$Builder mergeFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(byArray);
    }

    public UnknownFieldSet$Builder mergeLengthDelimitedField(int n10, ByteString byteString) {
        if (n10 != 0) {
            this.getFieldBuilder(n10).addLengthDelimited(byteString);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }

    public UnknownFieldSet$Builder mergeVarintField(int n10, int n11) {
        if (n10 != 0) {
            UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = this.getFieldBuilder(n10);
            long l10 = n11;
            unknownFieldSet$Field$Builder.addVarint(l10);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Zero is not a valid field number.");
        throw illegalArgumentException;
    }
}

