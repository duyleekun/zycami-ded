/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite$Builder$LimitedInputStream;
import com.google.protobuf.ArrayDecoders$Registers;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStreamReader;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedOutputStreamWriter;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$BooleanList;
import com.google.protobuf.Internal$DoubleList;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$LongList;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteToString;
import com.google.protobuf.Parser;
import com.google.protobuf.Protobuf;
import com.google.protobuf.ProtobufArrayList;
import com.google.protobuf.RawMessageInfo;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite
extends AbstractMessageLite {
    private static Map defaultInstanceMap;
    public int memoizedSerializedSize;
    public UnknownFieldSetLite unknownFields;

    static {
        ConcurrentHashMap concurrentHashMap;
        defaultInstanceMap = concurrentHashMap = new ConcurrentHashMap();
    }

    public GeneratedMessageLite() {
        UnknownFieldSetLite unknownFieldSetLite;
        this.unknownFields = unknownFieldSetLite = UnknownFieldSetLite.getDefaultInstance();
        this.memoizedSerializedSize = -1;
    }

    public static /* synthetic */ GeneratedMessageLite$GeneratedExtension access$000(ExtensionLite extensionLite) {
        return GeneratedMessageLite.checkIsLite(extensionLite);
    }

    private static GeneratedMessageLite$GeneratedExtension checkIsLite(ExtensionLite object) {
        boolean bl2 = ((ExtensionLite)object).isLite();
        if (bl2) {
            return (GeneratedMessageLite$GeneratedExtension)object;
        }
        object = new IllegalArgumentException("Expected a lite extension.");
        throw object;
    }

    private static GeneratedMessageLite checkMessageInitialized(GeneratedMessageLite generatedMessageLite) {
        boolean bl2;
        if (generatedMessageLite != null && !(bl2 = generatedMessageLite.isInitialized())) {
            throw generatedMessageLite.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(generatedMessageLite);
        }
        return generatedMessageLite;
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

    private final void ensureUnknownFieldsInitialized() {
        UnknownFieldSetLite unknownFieldSetLite = this.unknownFields;
        UnknownFieldSetLite unknownFieldSetLite2 = UnknownFieldSetLite.getDefaultInstance();
        if (unknownFieldSetLite == unknownFieldSetLite2) {
            this.unknownFields = unknownFieldSetLite = UnknownFieldSetLite.newInstance();
        }
    }

    public static GeneratedMessageLite getDefaultInstance(Class serializable) {
        Object object = (GeneratedMessageLite)defaultInstanceMap.get(serializable);
        if (object == null) {
            boolean bl2;
            try {
                object = serializable.getName();
                bl2 = true;
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
                throw object;
            }
            ClassLoader classLoader = serializable.getClassLoader();
            Class.forName((String)object, bl2, classLoader);
            object = (GeneratedMessageLite)defaultInstanceMap.get(serializable);
        }
        if (object == null) {
            object = ((GeneratedMessageLite)UnsafeUtil.allocateInstance(serializable)).getDefaultInstanceForType();
            if (object != null) {
                Map map = defaultInstanceMap;
                map.put(serializable, object);
            } else {
                serializable = new IllegalStateException();
                throw serializable;
            }
        }
        return object;
    }

    public static Method getMethodOrDie(Class object, String string2, Class ... classArray) {
        try {
            return ((Class)object).getMethod(string2, classArray);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Generated message class \"");
            object = ((Class)object).getName();
            stringBuilder.append((String)object);
            stringBuilder.append("\" missing method \"");
            stringBuilder.append(string2);
            stringBuilder.append("\".");
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object, noSuchMethodException);
            throw runtimeException;
        }
    }

    public static Object invokeOrDie(Method object, Object object2, Object ... objectArray) {
        try {
            return ((Method)object).invoke(object2, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            object = invocationTargetException.getCause();
            boolean bl2 = object instanceof RuntimeException;
            if (!bl2) {
                bl2 = object instanceof Error;
                if (bl2) {
                    throw (Error)object;
                }
                object2 = new RuntimeException("Unexpected exception thrown by generated accessor method.", (Throwable)object);
                throw object2;
            }
            throw (RuntimeException)object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
            throw object2;
        }
    }

    public static final boolean isInitialized(GeneratedMessageLite generatedMessageLite, boolean bl2) {
        byte by2;
        Object object = GeneratedMessageLite$MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED;
        byte by3 = (Byte)(object = (Byte)generatedMessageLite.dynamicMethod((GeneratedMessageLite$MethodToInvoke)((Object)object)));
        if (by3 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by3) {
            return false;
        }
        object = Protobuf.getInstance().schemaFor(generatedMessageLite);
        by3 = object.isInitialized(generatedMessageLite);
        if (bl2) {
            GeneratedMessageLite generatedMessageLite2;
            GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
            if (by3) {
                generatedMessageLite2 = generatedMessageLite;
            } else {
                by2 = 0;
                generatedMessageLite2 = null;
            }
            generatedMessageLite.dynamicMethod(generatedMessageLite$MethodToInvoke, generatedMessageLite2);
        }
        return by3 != 0;
    }

    public static Internal$BooleanList mutableCopy(Internal$BooleanList internal$BooleanList) {
        int n10 = internal$BooleanList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$BooleanList.mutableCopyWithCapacity(n10);
    }

    public static Internal$DoubleList mutableCopy(Internal$DoubleList internal$DoubleList) {
        int n10 = internal$DoubleList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$DoubleList.mutableCopyWithCapacity(n10);
    }

    public static Internal$FloatList mutableCopy(Internal$FloatList internal$FloatList) {
        int n10 = internal$FloatList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$FloatList.mutableCopyWithCapacity(n10);
    }

    public static Internal$IntList mutableCopy(Internal$IntList internal$IntList) {
        int n10 = internal$IntList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$IntList.mutableCopyWithCapacity(n10);
    }

    public static Internal$LongList mutableCopy(Internal$LongList internal$LongList) {
        int n10 = internal$LongList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$LongList.mutableCopyWithCapacity(n10);
    }

    public static Internal$ProtobufList mutableCopy(Internal$ProtobufList internal$ProtobufList) {
        int n10 = internal$ProtobufList.size();
        n10 = n10 == 0 ? 10 : (n10 *= 2);
        return internal$ProtobufList.mutableCopyWithCapacity(n10);
    }

    public static Object newMessageInfo(MessageLite messageLite, String string2, Object[] objectArray) {
        RawMessageInfo rawMessageInfo = new RawMessageInfo(messageLite, string2, objectArray);
        return rawMessageInfo;
    }

    public static GeneratedMessageLite$GeneratedExtension newRepeatedGeneratedExtension(MessageLite messageLite, MessageLite messageLite2, Internal$EnumLiteMap internal$EnumLiteMap, int n10, WireFormat$FieldType wireFormat$FieldType, boolean bl2, Class clazz) {
        List list = Collections.emptyList();
        GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = new GeneratedMessageLite$ExtensionDescriptor(internal$EnumLiteMap, n10, wireFormat$FieldType, true, bl2);
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = new GeneratedMessageLite$GeneratedExtension(messageLite, list, messageLite2, generatedMessageLite$ExtensionDescriptor, clazz);
        return generatedMessageLite$GeneratedExtension;
    }

    public static GeneratedMessageLite$GeneratedExtension newSingularGeneratedExtension(MessageLite messageLite, Object object, MessageLite messageLite2, Internal$EnumLiteMap internal$EnumLiteMap, int n10, WireFormat$FieldType wireFormat$FieldType, Class clazz) {
        GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor = new GeneratedMessageLite$ExtensionDescriptor(internal$EnumLiteMap, n10, wireFormat$FieldType, false, false);
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = new GeneratedMessageLite$GeneratedExtension(messageLite, object, messageLite2, generatedMessageLite$ExtensionDescriptor, clazz);
        return generatedMessageLite$GeneratedExtension;
    }

    public static GeneratedMessageLite parseDelimitedFrom(GeneratedMessageLite generatedMessageLite, InputStream inputStream) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialDelimitedFrom(generatedMessageLite, inputStream, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseDelimitedFrom(GeneratedMessageLite generatedMessageLite, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialDelimitedFrom(generatedMessageLite, inputStream, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, ByteString byteString) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parseFrom(generatedMessageLite, byteString, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, byteString, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.parseFrom(generatedMessageLite, codedInputStream, extensionRegistryLite);
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, codedInputStream, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, InputStream object) {
        object = CodedInputStream.newInstance((InputStream)object);
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, (CodedInputStream)object, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, InputStream object, ExtensionRegistryLite extensionRegistryLite) {
        object = CodedInputStream.newInstance((InputStream)object);
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, (CodedInputStream)object, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, ByteBuffer byteBuffer) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.parseFrom(generatedMessageLite, byteBuffer, extensionRegistryLite);
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, ByteBuffer object, ExtensionRegistryLite extensionRegistryLite) {
        object = CodedInputStream.newInstance((ByteBuffer)object);
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parseFrom(generatedMessageLite, (CodedInputStream)object, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, byte[] byArray) {
        int n10 = byArray.length;
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, byArray, 0, n10, extensionRegistryLite));
    }

    public static GeneratedMessageLite parseFrom(GeneratedMessageLite generatedMessageLite, byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        int n10 = byArray.length;
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, byArray, 0, n10, extensionRegistryLite));
    }

    private static GeneratedMessageLite parsePartialDelimitedFrom(GeneratedMessageLite generatedMessageLite, InputStream object, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        block5: {
            try {
                n10 = ((InputStream)object).read();
                int n11 = -1;
                if (n10 != n11) break block5;
                return null;
            }
            catch (IOException iOException) {
                String string2 = iOException.getMessage();
                object = new InvalidProtocolBufferException(string2);
                throw object;
            }
        }
        n10 = CodedInputStream.readRawVarint32(n10, (InputStream)object);
        AbstractMessageLite$Builder$LimitedInputStream abstractMessageLite$Builder$LimitedInputStream = new AbstractMessageLite$Builder$LimitedInputStream((InputStream)object, n10);
        object = CodedInputStream.newInstance(abstractMessageLite$Builder$LimitedInputStream);
        generatedMessageLite = GeneratedMessageLite.parsePartialFrom(generatedMessageLite, (CodedInputStream)object, extensionRegistryLite);
        extensionRegistryLite = null;
        try {
            ((CodedInputStream)object).checkLastTagWas(0);
            return generatedMessageLite;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.setUnfinishedMessage(generatedMessageLite);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite object, ByteString object2, ExtensionRegistryLite extensionRegistryLite) {
        object2 = ((ByteString)object2).newCodedInput();
        object = GeneratedMessageLite.parsePartialFrom((GeneratedMessageLite)object, (CodedInputStream)object2, extensionRegistryLite);
        extensionRegistryLite = null;
        try {
            ((CodedInputStream)object2).checkLastTagWas(0);
            return object;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object = invalidProtocolBufferException.setUnfinishedMessage((MessageLite)object);
            throw object;
        }
    }

    public static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return GeneratedMessageLite.parsePartialFrom(generatedMessageLite, codedInputStream, extensionRegistryLite);
    }

    public static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite generatedMessageLite, CodedInputStream object, ExtensionRegistryLite object2) {
        Object object3 = GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE;
        generatedMessageLite = (GeneratedMessageLite)generatedMessageLite.dynamicMethod((GeneratedMessageLite$MethodToInvoke)((Object)object3));
        object3 = Protobuf.getInstance();
        object3 = ((Protobuf)object3).schemaFor(generatedMessageLite);
        object = CodedInputStreamReader.forCodedInput((CodedInputStream)object);
        object3.mergeFrom(generatedMessageLite, (Reader)object, (ExtensionRegistryLite)object2);
        try {
            object3.makeImmutable(generatedMessageLite);
            return generatedMessageLite;
        }
        catch (RuntimeException runtimeException) {
            object = runtimeException.getCause();
            boolean bl2 = object instanceof InvalidProtocolBufferException;
            if (bl2) {
                throw (InvalidProtocolBufferException)runtimeException.getCause();
            }
            throw runtimeException;
        }
        catch (IOException iOException) {
            object2 = iOException.getCause();
            boolean bl3 = object2 instanceof InvalidProtocolBufferException;
            if (bl3) {
                throw (InvalidProtocolBufferException)iOException.getCause();
            }
            String string2 = iOException.getMessage();
            object2 = new InvalidProtocolBufferException(string2);
            throw ((InvalidProtocolBufferException)object2).setUnfinishedMessage(generatedMessageLite);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite generatedMessageLite, byte[] object, int n10, int n11, ExtensionRegistryLite extensionRegistryLite) {
        int n12;
        block12: {
            void var4_8;
            void var3_7;
            Object object2 = GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE;
            generatedMessageLite = (GeneratedMessageLite)generatedMessageLite.dynamicMethod((GeneratedMessageLite$MethodToInvoke)((Object)object2));
            object2 = Protobuf.getInstance();
            Schema schema = ((Protobuf)object2).schemaFor(generatedMessageLite);
            void var7_11 = n12 + var3_7;
            ArrayDecoders$Registers arrayDecoders$Registers = new ArrayDecoders$Registers((ExtensionRegistryLite)var4_8);
            object2 = schema;
            schema.mergeFrom(generatedMessageLite, (byte[])object, n12, (int)var7_11, arrayDecoders$Registers);
            schema.makeImmutable(generatedMessageLite);
            int n13 = generatedMessageLite.memoizedHashCode;
            if (n13 != 0) break block12;
            return generatedMessageLite;
        }
        try {
            RuntimeException runtimeException = new RuntimeException();
            throw runtimeException;
        }
        catch (IOException iOException) {
            Throwable throwable = iOException.getCause();
            n12 = throwable instanceof InvalidProtocolBufferException;
            if (n12 != 0) {
                throw (InvalidProtocolBufferException)iOException.getCause();
            }
            String string2 = iOException.getMessage();
            throwable = new InvalidProtocolBufferException(string2);
            throw ((InvalidProtocolBufferException)throwable).setUnfinishedMessage(generatedMessageLite);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(generatedMessageLite);
        }
    }

    private static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite generatedMessageLite, byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        int n10 = byArray.length;
        return GeneratedMessageLite.checkMessageInitialized(GeneratedMessageLite.parsePartialFrom(generatedMessageLite, byArray, 0, n10, extensionRegistryLite));
    }

    public static void registerDefaultInstance(Class clazz, GeneratedMessageLite generatedMessageLite) {
        defaultInstanceMap.put(clazz, generatedMessageLite);
    }

    public Object buildMessageInfo() {
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.BUILD_MESSAGE_INFO;
        return this.dynamicMethod(generatedMessageLite$MethodToInvoke);
    }

    public final GeneratedMessageLite$Builder createBuilder() {
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.NEW_BUILDER;
        return (GeneratedMessageLite$Builder)this.dynamicMethod(generatedMessageLite$MethodToInvoke);
    }

    public final GeneratedMessageLite$Builder createBuilder(GeneratedMessageLite generatedMessageLite) {
        return this.createBuilder().mergeFrom(generatedMessageLite);
    }

    public Object dynamicMethod(GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke) {
        return this.dynamicMethod(generatedMessageLite$MethodToInvoke, null, null);
    }

    public Object dynamicMethod(GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke, Object object) {
        return this.dynamicMethod(generatedMessageLite$MethodToInvoke, object, null);
    }

    public abstract Object dynamicMethod(GeneratedMessageLite$MethodToInvoke var1, Object var2, Object var3);

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        Class<?> clazz = this.getDefaultInstanceForType().getClass();
        boolean bl2 = clazz.isInstance(object);
        if (!bl2) {
            return false;
        }
        clazz = Protobuf.getInstance().schemaFor(this);
        object = (GeneratedMessageLite)object;
        return clazz.equals(this, object);
    }

    public final GeneratedMessageLite getDefaultInstanceForType() {
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.GET_DEFAULT_INSTANCE;
        return (GeneratedMessageLite)this.dynamicMethod(generatedMessageLite$MethodToInvoke);
    }

    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final Parser getParserForType() {
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.GET_PARSER;
        return (Parser)this.dynamicMethod(generatedMessageLite$MethodToInvoke);
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSerializedSize;
        int n11 = -1;
        if (n10 == n11) {
            Schema schema = Protobuf.getInstance().schemaFor(this);
            this.memoizedSerializedSize = n10 = schema.getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        this.memoizedHashCode = n10 = Protobuf.getInstance().schemaFor(this).hashCode(this);
        return n10;
    }

    public final boolean isInitialized() {
        return GeneratedMessageLite.isInitialized(this, true);
    }

    public void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
    }

    public void mergeLengthDelimitedField(int n10, ByteString byteString) {
        this.ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(n10, byteString);
    }

    public final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = unknownFieldSetLite = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFieldSetLite);
    }

    public void mergeVarintField(int n10, int n11) {
        this.ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(n10, n11);
    }

    public final GeneratedMessageLite$Builder newBuilderForType() {
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.NEW_BUILDER;
        return (GeneratedMessageLite$Builder)this.dynamicMethod(generatedMessageLite$MethodToInvoke);
    }

    public boolean parseUnknownField(int n10, CodedInputStream codedInputStream) {
        int n11;
        int n12 = WireFormat.getTagWireType(n10);
        if (n12 == (n11 = 4)) {
            return false;
        }
        this.ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(n10, codedInputStream);
    }

    public void setMemoizedSerializedSize(int n10) {
        this.memoizedSerializedSize = n10;
    }

    public final GeneratedMessageLite$Builder toBuilder() {
        Object object = GeneratedMessageLite$MethodToInvoke.NEW_BUILDER;
        object = (GeneratedMessageLite$Builder)this.dynamicMethod((GeneratedMessageLite$MethodToInvoke)((Object)object));
        ((GeneratedMessageLite$Builder)object).mergeFrom(this);
        return object;
    }

    public String toString() {
        String string2 = super.toString();
        return MessageLiteToString.toString(this, string2);
    }

    public void writeTo(CodedOutputStream object) {
        Schema schema = Protobuf.getInstance().schemaFor(this);
        object = CodedOutputStreamWriter.forCodedOutput((CodedOutputStream)object);
        schema.writeTo(this, (Writer)object);
    }
}

