/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$BuilderParent;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStreamReader;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.Extension;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.GeneratedMessageLite$SerializedForm;
import com.google.protobuf.GeneratedMessageV3$1;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$BooleanList;
import com.google.protobuf.Internal$DoubleList;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$LongList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.Parser;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnsafeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class GeneratedMessageV3
extends AbstractMessage
implements Serializable {
    public static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1L;
    public UnknownFieldSet unknownFields;

    public GeneratedMessageV3() {
        UnknownFieldSet unknownFieldSet;
        this.unknownFields = unknownFieldSet = UnknownFieldSet.getDefaultInstance();
    }

    public GeneratedMessageV3(GeneratedMessageV3$Builder messageLiteOrBuilder) {
        messageLiteOrBuilder = messageLiteOrBuilder.getUnknownFields();
        this.unknownFields = messageLiteOrBuilder;
    }

    public static /* synthetic */ Method access$1000(Class clazz, String string2, Class[] classArray) {
        return GeneratedMessageV3.getMethodOrDie(clazz, string2, classArray);
    }

    public static /* synthetic */ Object access$1100(Method method, Object object, Object[] objectArray) {
        return GeneratedMessageV3.invokeOrDie(method, object, objectArray);
    }

    public static /* synthetic */ Extension access$500(ExtensionLite extensionLite) {
        return GeneratedMessageV3.checkNotLite(extensionLite);
    }

    public static /* synthetic */ Map access$800(GeneratedMessageV3 generatedMessageV3, boolean bl2) {
        return generatedMessageV3.getAllFieldsMutable(bl2);
    }

    public static boolean canUseUnsafe() {
        boolean bl2 = UnsafeUtil.hasUnsafeArrayOperations();
        bl2 = bl2 && (bl2 = UnsafeUtil.hasUnsafeByteBufferOperations());
        return bl2;
    }

    private static Extension checkNotLite(ExtensionLite object) {
        boolean bl2 = ((ExtensionLite)object).isLite();
        if (!bl2) {
            return (Extension)object;
        }
        object = new IllegalArgumentException("Expected non-lite extension.");
        throw object;
    }

    public static int computeStringSize(int n10, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            return CodedOutputStream.computeStringSize(n10, (String)object);
        }
        object = (ByteString)object;
        return CodedOutputStream.computeBytesSize(n10, (ByteString)object);
    }

    public static int computeStringSizeNoTag(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return CodedOutputStream.computeStringSizeNoTag((String)object);
        }
        return CodedOutputStream.computeBytesSizeNoTag((ByteString)object);
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

    public static void enableAlwaysUseFieldBuildersForTesting() {
        GeneratedMessageV3.setAlwaysUseFieldBuildersForTesting(true);
    }

    private Map getAllFieldsMutable(boolean bl2) {
        int n10;
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        List list = GeneratedMessageV3$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable()).getFields();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)list.get(i10);
            Object object = descriptors$FieldDescriptor.getContainingOneof();
            if (object != null) {
                n10 = ((Descriptors$OneofDescriptor)object).getFieldCount() + -1;
                i10 += n10;
                n10 = (int)(this.hasOneof((Descriptors$OneofDescriptor)object) ? 1 : 0);
                if (n10 == 0) continue;
                descriptors$FieldDescriptor = this.getOneofFieldDescriptor((Descriptors$OneofDescriptor)object);
            } else {
                boolean bl3 = descriptors$FieldDescriptor.isRepeated();
                if (bl3) {
                    object = (List)this.getField(descriptors$FieldDescriptor);
                    boolean bl4 = object.isEmpty();
                    if (bl4) continue;
                    treeMap.put(descriptors$FieldDescriptor, object);
                    continue;
                }
                bl3 = this.hasField(descriptors$FieldDescriptor);
                if (!bl3) continue;
            }
            if (bl2 && (object = descriptors$FieldDescriptor.getJavaType()) == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.STRING)) {
                object = this.getFieldRaw(descriptors$FieldDescriptor);
                treeMap.put(descriptors$FieldDescriptor, object);
                continue;
            }
            object = this.getField(descriptors$FieldDescriptor);
            treeMap.put(descriptors$FieldDescriptor, object);
        }
        return treeMap;
    }

    private static Method getMethodOrDie(Class object, String string2, Class ... classArray) {
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

    private static Object invokeOrDie(Method object, Object object2, Object ... objectArray) {
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

    private static void maybeSerializeBooleanEntryTo(CodedOutputStream codedOutputStream, Map object, MapEntry messageOrBuilder, int n10, boolean bl2) {
        Boolean bl3 = bl2;
        boolean bl4 = object.containsKey(bl3);
        if (bl4) {
            messageOrBuilder = ((MapEntry)messageOrBuilder).newBuilderForType();
            bl3 = bl2;
            messageOrBuilder = ((MapEntry$Builder)messageOrBuilder).setKey(bl3);
            Boolean bl5 = bl2;
            object = object.get(bl5);
            object = ((MapEntry$Builder)messageOrBuilder).setValue(object).build();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
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

    public static Message parseDelimitedWithIOException(Parser object, InputStream inputStream) {
        try {
            object = object.parseDelimitedFrom(inputStream);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.unwrapIOException();
        }
        return (Message)object;
    }

    public static Message parseDelimitedWithIOException(Parser object, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            object = object.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.unwrapIOException();
        }
        return (Message)object;
    }

    public static Message parseWithIOException(Parser object, CodedInputStream codedInputStream) {
        try {
            object = object.parseFrom(codedInputStream);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.unwrapIOException();
        }
        return (Message)object;
    }

    public static Message parseWithIOException(Parser object, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            object = object.parseFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.unwrapIOException();
        }
        return (Message)object;
    }

    public static Message parseWithIOException(Parser object, InputStream inputStream) {
        try {
            object = object.parseFrom(inputStream);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.unwrapIOException();
        }
        return (Message)object;
    }

    public static Message parseWithIOException(Parser object, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            object = object.parseFrom(inputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.unwrapIOException();
        }
        return (Message)object;
    }

    public static void serializeBooleanMapTo(CodedOutputStream codedOutputStream, MapField object, MapEntry mapEntry, int n10) {
        object = ((MapField)object).getMap();
        boolean bl2 = codedOutputStream.isSerializationDeterministic();
        if (!bl2) {
            GeneratedMessageV3.serializeMapTo(codedOutputStream, (Map)object, mapEntry, n10);
            return;
        }
        GeneratedMessageV3.maybeSerializeBooleanEntryTo(codedOutputStream, (Map)object, mapEntry, n10, false);
        GeneratedMessageV3.maybeSerializeBooleanEntryTo(codedOutputStream, (Map)object, mapEntry, n10, true);
    }

    public static void serializeIntegerMapTo(CodedOutputStream codedOutputStream, MapField object, MapEntry mapEntry, int n10) {
        Integer n11;
        int n12;
        object = ((MapField)object).getMap();
        int n13 = codedOutputStream.isSerializationDeterministic();
        if (n13 == 0) {
            GeneratedMessageV3.serializeMapTo(codedOutputStream, (Map)object, mapEntry, n10);
            return;
        }
        n13 = object.size();
        int[] nArray = new int[n13];
        Object object2 = object.keySet().iterator();
        int n14 = 0;
        int n15 = 0;
        MapEntry$Builder mapEntry$Builder = null;
        while ((n12 = object2.hasNext()) != 0) {
            n11 = (Integer)object2.next();
            n12 = n11;
            int n16 = n15 + 1;
            nArray[n15] = n12;
            n15 = n16;
        }
        Arrays.sort(nArray);
        while (n14 < n13) {
            int n17 = nArray[n14];
            mapEntry$Builder = mapEntry.newBuilderForType();
            n11 = n17;
            mapEntry$Builder = mapEntry$Builder.setKey(n11);
            object2 = n17;
            object2 = object.get(object2);
            object2 = mapEntry$Builder.setValue(object2).build();
            codedOutputStream.writeMessage(n10, (MessageLite)object2);
            ++n14;
        }
    }

    public static void serializeLongMapTo(CodedOutputStream codedOutputStream, MapField object, MapEntry mapEntry, int n10) {
        boolean bl2;
        object = ((MapField)object).getMap();
        int n11 = codedOutputStream.isSerializationDeterministic();
        if (n11 == 0) {
            GeneratedMessageV3.serializeMapTo(codedOutputStream, (Map)object, mapEntry, n10);
            return;
        }
        n11 = object.size();
        long[] lArray = new long[n11];
        Object object2 = object.keySet().iterator();
        int n12 = 0;
        int n13 = 0;
        Long l10 = null;
        while (bl2 = object2.hasNext()) {
            Long l11 = (Long)object2.next();
            long l12 = l11;
            int n14 = n13 + 1;
            lArray[n13] = l12;
            n13 = n14;
        }
        Arrays.sort(lArray);
        while (n12 < n11) {
            long l13 = lArray[n12];
            object2 = mapEntry.newBuilderForType();
            Long l14 = l13;
            object2 = ((MapEntry$Builder)object2).setKey(l14);
            l10 = l13;
            l10 = object.get(l10);
            object2 = ((MapEntry$Builder)object2).setValue(l10).build();
            codedOutputStream.writeMessage(n10, (MessageLite)object2);
            ++n12;
        }
    }

    private static void serializeMapTo(CodedOutputStream codedOutputStream, Map object, MapEntry mapEntry, int n10) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            MapEntry$Builder mapEntry$Builder = mapEntry.newBuilderForType();
            Object k10 = object2.getKey();
            mapEntry$Builder = mapEntry$Builder.setKey(k10);
            object2 = object2.getValue();
            object2 = mapEntry$Builder.setValue(object2).build();
            codedOutputStream.writeMessage(n10, (MessageLite)object2);
        }
    }

    public static void serializeStringMapTo(CodedOutputStream codedOutputStream, MapField object, MapEntry mapEntry, int n10) {
        object = ((MapField)object).getMap();
        int n11 = codedOutputStream.isSerializationDeterministic();
        if (n11 == 0) {
            GeneratedMessageV3.serializeMapTo(codedOutputStream, (Map)object, mapEntry, n10);
            return;
        }
        n11 = object.size();
        Object[] objectArray = new String[n11];
        Set set = object.keySet();
        objectArray = set.toArray(objectArray);
        Arrays.sort(objectArray);
        for (Object object2 : objectArray) {
            MapEntry$Builder mapEntry$Builder = mapEntry.newBuilderForType().setKey(object2);
            object2 = object.get(object2);
            object2 = mapEntry$Builder.setValue(object2).build();
            codedOutputStream.writeMessage(n10, (MessageLite)object2);
        }
    }

    public static void setAlwaysUseFieldBuildersForTesting(boolean bl2) {
        alwaysUseFieldBuilders = bl2;
    }

    public static void writeString(CodedOutputStream codedOutputStream, int n10, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            codedOutputStream.writeString(n10, (String)object);
        } else {
            object = (ByteString)object;
            codedOutputStream.writeBytes(n10, (ByteString)object);
        }
    }

    public static void writeStringNoTag(CodedOutputStream codedOutputStream, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            codedOutputStream.writeStringNoTag((String)object);
        } else {
            object = (ByteString)object;
            codedOutputStream.writeBytesNoTag((ByteString)object);
        }
    }

    public Map getAllFields() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable(false));
    }

    public Map getAllFieldsRaw() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable(true));
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return GeneratedMessageV3$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).get(this);
    }

    public Object getFieldRaw(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRaw(this);
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).get(this);
    }

    public Parser getParserForType() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        throw unsupportedOperationException;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeated(this, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedCount(this);
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        Map map = this.getAllFieldsRaw();
        this.memoizedSize = n10 = MessageReflection.getSerializedSize(this, map);
        return n10;
    }

    public UnknownFieldSet getUnknownFields() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        throw unsupportedOperationException;
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).has(this);
    }

    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).has(this);
    }

    public abstract GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable();

    public MapField internalGetMapField(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("No map fields found in ");
        String string2 = this.getClass().getName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        RuntimeException runtimeException = new RuntimeException((String)charSequence);
        throw runtimeException;
    }

    public boolean isInitialized() {
        boolean bl2;
        Iterator iterator2 = this.getDescriptorForType().getFields().iterator();
        while (bl2 = iterator2.hasNext()) {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
            Object object = (Descriptors$FieldDescriptor)iterator2.next();
            boolean bl3 = ((Descriptors$FieldDescriptor)object).isRequired();
            if (bl3 && !(bl3 = this.hasField((Descriptors$FieldDescriptor)object))) {
                return false;
            }
            Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
            if (object2 != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) continue;
            bl3 = ((Descriptors$FieldDescriptor)object).isRepeated();
            if (bl3) {
                object = ((List)this.getField((Descriptors$FieldDescriptor)object)).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (Message)object.next();
                    bl3 = object2.isInitialized();
                    if (bl3) continue;
                    return false;
                }
                continue;
            }
            bl3 = this.hasField((Descriptors$FieldDescriptor)object);
            if (!bl3 || (bl2 = (object = (Message)this.getField((Descriptors$FieldDescriptor)object)).isInitialized())) continue;
            return false;
        }
        return true;
    }

    public void makeExtensionsImmutable() {
    }

    public void mergeFromAndMakeImmutableInternal(CodedInputStream object, ExtensionRegistryLite object2) {
        Schema schema = Protobuf.getInstance().schemaFor(this);
        object = CodedInputStreamReader.forCodedInput((CodedInputStream)object);
        try {
            schema.mergeFrom(this, (Reader)object, (ExtensionRegistryLite)object2);
            schema.makeImmutable(this);
            return;
        }
        catch (IOException iOException) {
            object2 = new InvalidProtocolBufferException(iOException);
            throw ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
        }
    }

    public Message$Builder newBuilderForType(AbstractMessage$BuilderParent abstractMessage$BuilderParent) {
        GeneratedMessageV3$1 generatedMessageV3$1 = new GeneratedMessageV3$1(this, abstractMessage$BuilderParent);
        return this.newBuilderForType(generatedMessageV3$1);
    }

    public abstract Message$Builder newBuilderForType(GeneratedMessageV3$BuilderParent var1);

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new UnsupportedOperationException("This method must be overridden by the subclass.");
        throw object;
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n10) {
        boolean bl2 = codedInputStream.shouldDiscardUnknownFields();
        if (bl2) {
            return codedInputStream.skipField(n10);
        }
        return unknownFieldSet$Builder.mergeFieldFrom(n10, codedInputStream);
    }

    public boolean parseUnknownFieldProto3(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n10) {
        return this.parseUnknownField(codedInputStream, unknownFieldSet$Builder, extensionRegistryLite, n10);
    }

    public Object writeReplace() {
        GeneratedMessageLite$SerializedForm generatedMessageLite$SerializedForm = new GeneratedMessageLite$SerializedForm(this);
        return generatedMessageLite$SerializedForm;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Map map = this.getAllFieldsRaw();
        MessageReflection.writeMessageTo(this, map, codedOutputStream, false);
    }
}

