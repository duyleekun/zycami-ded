/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ArrayDecoders$Registers;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedInputStreamReader;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import java.io.IOException;

public abstract class GeneratedMessageLite$Builder
extends AbstractMessageLite$Builder {
    private final GeneratedMessageLite defaultInstance;
    public GeneratedMessageLite instance;
    public boolean isBuilt;

    public GeneratedMessageLite$Builder(GeneratedMessageLite generatedMessageLite) {
        this.defaultInstance = generatedMessageLite;
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE;
        this.instance = generatedMessageLite = (GeneratedMessageLite)generatedMessageLite.dynamicMethod(generatedMessageLite$MethodToInvoke);
        this.isBuilt = false;
    }

    private void mergeFromInstance(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        Protobuf.getInstance().schemaFor(generatedMessageLite).mergeFrom(generatedMessageLite, generatedMessageLite2);
    }

    public final GeneratedMessageLite build() {
        GeneratedMessageLite generatedMessageLite = this.buildPartial();
        boolean bl2 = generatedMessageLite.isInitialized();
        if (bl2) {
            return generatedMessageLite;
        }
        throw AbstractMessageLite$Builder.newUninitializedMessageException(generatedMessageLite);
    }

    public GeneratedMessageLite buildPartial() {
        boolean bl2 = this.isBuilt;
        if (bl2) {
            return this.instance;
        }
        this.instance.makeImmutable();
        this.isBuilt = true;
        return this.instance;
    }

    public final GeneratedMessageLite$Builder clear() {
        GeneratedMessageLite generatedMessageLite = this.instance;
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE;
        this.instance = generatedMessageLite = (GeneratedMessageLite)generatedMessageLite.dynamicMethod(generatedMessageLite$MethodToInvoke);
        return this;
    }

    public GeneratedMessageLite$Builder clone() {
        GeneratedMessageLite$Builder generatedMessageLite$Builder = this.getDefaultInstanceForType().newBuilderForType();
        GeneratedMessageLite generatedMessageLite = this.buildPartial();
        generatedMessageLite$Builder.mergeFrom(generatedMessageLite);
        return generatedMessageLite$Builder;
    }

    public final void copyOnWrite() {
        boolean bl2 = this.isBuilt;
        if (bl2) {
            this.copyOnWriteInternal();
            bl2 = false;
            this.isBuilt = false;
        }
    }

    public void copyOnWriteInternal() {
        GeneratedMessageLite generatedMessageLite = this.instance;
        Object object = GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE;
        generatedMessageLite = (GeneratedMessageLite)generatedMessageLite.dynamicMethod((GeneratedMessageLite$MethodToInvoke)((Object)object));
        object = this.instance;
        this.mergeFromInstance(generatedMessageLite, (GeneratedMessageLite)object);
        this.instance = generatedMessageLite;
    }

    public GeneratedMessageLite getDefaultInstanceForType() {
        return this.defaultInstance;
    }

    public GeneratedMessageLite$Builder internalMergeFrom(GeneratedMessageLite generatedMessageLite) {
        return this.mergeFrom(generatedMessageLite);
    }

    public final boolean isInitialized() {
        return GeneratedMessageLite.isInitialized(this.instance, false);
    }

    public GeneratedMessageLite$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        Object object3;
        this.copyOnWrite();
        try {
            object3 = Protobuf.getInstance();
        }
        catch (RuntimeException runtimeException) {
            object2 = runtimeException.getCause();
            boolean bl2 = object2 instanceof IOException;
            if (bl2) {
                throw (IOException)runtimeException.getCause();
            }
            throw runtimeException;
        }
        GeneratedMessageLite generatedMessageLite = this.instance;
        object3 = ((Protobuf)object3).schemaFor(generatedMessageLite);
        generatedMessageLite = this.instance;
        object = CodedInputStreamReader.forCodedInput((CodedInputStream)object);
        object3.mergeFrom(generatedMessageLite, (Reader)object, (ExtensionRegistryLite)object2);
        return this;
    }

    public GeneratedMessageLite$Builder mergeFrom(GeneratedMessageLite generatedMessageLite) {
        this.copyOnWrite();
        GeneratedMessageLite generatedMessageLite2 = this.instance;
        this.mergeFromInstance(generatedMessageLite2, generatedMessageLite);
        return this;
    }

    public GeneratedMessageLite$Builder mergeFrom(byte[] byArray, int n10, int n11) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        return this.mergeFrom(byArray, n10, n11, extensionRegistryLite);
    }

    public GeneratedMessageLite$Builder mergeFrom(byte[] byArray, int n10, int n11, ExtensionRegistryLite extensionRegistryLite) {
        this.copyOnWrite();
        Protobuf protobuf = Protobuf.getInstance();
        GeneratedMessageLite generatedMessageLite = this.instance;
        Schema schema = protobuf.schemaFor(generatedMessageLite);
        GeneratedMessageLite generatedMessageLite2 = this.instance;
        int n12 = n10 + n11;
        ArrayDecoders$Registers arrayDecoders$Registers = new ArrayDecoders$Registers(extensionRegistryLite);
        try {
            schema.mergeFrom(generatedMessageLite2, byArray, n10, n12, arrayDecoders$Registers);
            return this;
        }
        catch (IOException iOException) {
            RuntimeException runtimeException = new RuntimeException("Reading from byte array should not throw IOException.", iOException);
            throw runtimeException;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException;
        }
    }
}

