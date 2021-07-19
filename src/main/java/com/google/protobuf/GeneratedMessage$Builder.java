/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$Builder$BuilderParentImpl;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage$Builder
extends AbstractMessage$Builder {
    private GeneratedMessage$BuilderParent builderParent;
    private boolean isClean;
    private GeneratedMessage$Builder$BuilderParentImpl meAsParent;
    private UnknownFieldSet unknownFields;

    public GeneratedMessage$Builder() {
        this(null);
    }

    public GeneratedMessage$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        UnknownFieldSet unknownFieldSet;
        this.unknownFields = unknownFieldSet = UnknownFieldSet.getDefaultInstance();
        this.builderParent = generatedMessage$BuilderParent;
    }

    public static /* synthetic */ Map access$900(GeneratedMessage$Builder generatedMessage$Builder) {
        return generatedMessage$Builder.getAllFieldsMutable();
    }

    private Map getAllFieldsMutable() {
        int n10;
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        List list = GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable()).getFields();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)list.get(i10);
            Object object = descriptors$FieldDescriptor.getContainingOneof();
            if (object != null) {
                n10 = ((Descriptors$OneofDescriptor)object).getFieldCount() + -1;
                i10 += n10;
                n10 = (int)(this.hasOneof((Descriptors$OneofDescriptor)object) ? 1 : 0);
                if (n10 == 0) continue;
                descriptors$FieldDescriptor = this.getOneofFieldDescriptor((Descriptors$OneofDescriptor)object);
            } else {
                boolean bl2 = descriptors$FieldDescriptor.isRepeated();
                if (bl2) {
                    object = (List)this.getField(descriptors$FieldDescriptor);
                    boolean bl3 = object.isEmpty();
                    if (bl3) continue;
                    treeMap.put(descriptors$FieldDescriptor, object);
                    continue;
                }
                bl2 = this.hasField(descriptors$FieldDescriptor);
                if (!bl2) continue;
            }
            object = this.getField(descriptors$FieldDescriptor);
            treeMap.put(descriptors$FieldDescriptor, object);
        }
        return treeMap;
    }

    public GeneratedMessage$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).addRepeated(this, object);
        return this;
    }

    public GeneratedMessage$Builder clear() {
        UnknownFieldSet unknownFieldSet;
        this.unknownFields = unknownFieldSet = UnknownFieldSet.getDefaultInstance();
        this.onChanged();
        return this;
    }

    public GeneratedMessage$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).clear(this);
        return this;
    }

    public GeneratedMessage$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).clear(this);
        return this;
    }

    public GeneratedMessage$Builder clone() {
        GeneratedMessage$Builder generatedMessage$Builder = (GeneratedMessage$Builder)this.getDefaultInstanceForType().newBuilderForType();
        Message message = this.buildPartial();
        generatedMessage$Builder.mergeFrom(message);
        return generatedMessage$Builder;
    }

    public void dispose() {
        this.builderParent = null;
    }

    public Map getAllFields() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable());
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        Object object = GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).get(this);
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (bl2) {
            return Collections.unmodifiableList((List)object);
        }
        return object;
    }

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getBuilder(this);
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).get(this);
    }

    public GeneratedMessage$BuilderParent getParentForChildren() {
        GeneratedMessage$Builder$BuilderParentImpl generatedMessage$Builder$BuilderParentImpl = this.meAsParent;
        if (generatedMessage$Builder$BuilderParentImpl == null) {
            this.meAsParent = generatedMessage$Builder$BuilderParentImpl = new GeneratedMessage$Builder$BuilderParentImpl(this, null);
        }
        return this.meAsParent;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeated(this, n10);
    }

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedBuilder(this, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedCount(this);
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
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

    public MapField internalGetMutableMapField(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("No map fields found in ");
        String string2 = this.getClass().getName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        RuntimeException runtimeException = new RuntimeException((String)charSequence);
        throw runtimeException;
    }

    public boolean isClean() {
        return this.isClean;
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

    public void markClean() {
        this.isClean = true;
    }

    public GeneratedMessage$Builder mergeUnknownFields(UnknownFieldSet messageLite) {
        this.unknownFields = messageLite = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom((UnknownFieldSet)messageLite).build();
        this.onChanged();
        return this;
    }

    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).newBuilder();
    }

    public void onBuilt() {
        GeneratedMessage$BuilderParent generatedMessage$BuilderParent = this.builderParent;
        if (generatedMessage$BuilderParent != null) {
            this.markClean();
        }
    }

    public final void onChanged() {
        GeneratedMessage$BuilderParent generatedMessage$BuilderParent;
        boolean bl2 = this.isClean;
        if (bl2 && (generatedMessage$BuilderParent = this.builderParent) != null) {
            generatedMessage$BuilderParent.markDirty();
            bl2 = false;
            generatedMessage$BuilderParent = null;
            this.isClean = false;
        }
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n10) {
        return unknownFieldSet$Builder.mergeFieldFrom(n10, codedInputStream);
    }

    public GeneratedMessage$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).set(this, object);
        return this;
    }

    public GeneratedMessage$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).setRepeated(this, n10, object);
        return this;
    }

    public GeneratedMessage$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        this.unknownFields = unknownFieldSet;
        this.onChanged();
        return this;
    }
}

