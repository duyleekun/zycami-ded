/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$BuilderParent;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$2;
import com.google.protobuf.GeneratedMessage$3;
import com.google.protobuf.GeneratedMessage$4;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.GeneratedMessageLite$SerializedForm;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage
extends AbstractMessage
implements Serializable {
    public static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1L;
    public UnknownFieldSet unknownFields;

    public GeneratedMessage() {
        UnknownFieldSet unknownFieldSet;
        this.unknownFields = unknownFieldSet = UnknownFieldSet.getDefaultInstance();
    }

    public GeneratedMessage(GeneratedMessage$Builder messageLiteOrBuilder) {
        messageLiteOrBuilder = messageLiteOrBuilder.getUnknownFields();
        this.unknownFields = messageLiteOrBuilder;
    }

    public static /* synthetic */ Method access$1100(Class clazz, String string2, Class[] classArray) {
        return GeneratedMessage.getMethodOrDie(clazz, string2, classArray);
    }

    public static /* synthetic */ Object access$1200(Method method, Object object, Object[] objectArray) {
        return GeneratedMessage.invokeOrDie(method, object, objectArray);
    }

    public static /* synthetic */ Extension access$500(ExtensionLite extensionLite) {
        return GeneratedMessage.checkNotLite(extensionLite);
    }

    public static /* synthetic */ Map access$800(GeneratedMessage generatedMessage, boolean bl2) {
        return generatedMessage.getAllFieldsMutable(bl2);
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

    public static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    private Map getAllFieldsMutable(boolean bl2) {
        int n10;
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        List list = GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable()).getFields();
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

    public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(Class clazz, Message message) {
        Extension$ExtensionType extension$ExtensionType = Extension$ExtensionType.IMMUTABLE;
        GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension = new GeneratedMessage$GeneratedExtension(null, clazz, message, extension$ExtensionType);
        return generatedMessage$GeneratedExtension;
    }

    public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(Class clazz, Message message, String object, String string2) {
        GeneratedMessage$4 generatedMessage$4 = new GeneratedMessage$4(clazz, (String)object, string2);
        object = Extension$ExtensionType.MUTABLE;
        GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension = new GeneratedMessage$GeneratedExtension(generatedMessage$4, clazz, message, (Extension$ExtensionType)((Object)object));
        return generatedMessage$GeneratedExtension;
    }

    public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(Message object, int n10, Class clazz, Message message) {
        GeneratedMessage$2 generatedMessage$2 = new GeneratedMessage$2((Message)object, n10);
        object = Extension$ExtensionType.IMMUTABLE;
        GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension = new GeneratedMessage$GeneratedExtension(generatedMessage$2, clazz, message, (Extension$ExtensionType)((Object)object));
        return generatedMessage$GeneratedExtension;
    }

    public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(Message object, String string2, Class clazz, Message message) {
        GeneratedMessage$3 generatedMessage$3 = new GeneratedMessage$3((Message)object, string2);
        object = Extension$ExtensionType.MUTABLE;
        GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension = new GeneratedMessage$GeneratedExtension(generatedMessage$3, clazz, message, (Extension$ExtensionType)((Object)object));
        return generatedMessage$GeneratedExtension;
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
        return GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).get(this);
    }

    public Object getFieldRaw(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRaw(this);
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).get(this);
    }

    public Parser getParserForType() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        throw unsupportedOperationException;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeated(this, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedCount(this);
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
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).has(this);
    }

    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).has(this);
    }

    public abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();

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

    public Message$Builder newBuilderForType(AbstractMessage$BuilderParent abstractMessage$BuilderParent) {
        GeneratedMessage$1 generatedMessage$1 = new GeneratedMessage$1(this, abstractMessage$BuilderParent);
        return this.newBuilderForType(generatedMessage$1);
    }

    public abstract Message$Builder newBuilderForType(GeneratedMessage$BuilderParent var1);

    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n10) {
        return unknownFieldSet$Builder.mergeFieldFrom(n10, codedInputStream);
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

