/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3$Builder$BuilderParentImpl;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessageV3$Builder
extends AbstractMessage$Builder {
    private GeneratedMessageV3$BuilderParent builderParent;
    private boolean isClean;
    private GeneratedMessageV3$Builder$BuilderParentImpl meAsParent;
    private UnknownFieldSet unknownFields;

    public GeneratedMessageV3$Builder() {
        this(null);
    }

    public GeneratedMessageV3$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        UnknownFieldSet unknownFieldSet;
        this.unknownFields = unknownFieldSet = UnknownFieldSet.getDefaultInstance();
        this.builderParent = generatedMessageV3$BuilderParent;
    }

    public static /* synthetic */ Map access$900(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        return generatedMessageV3$Builder.getAllFieldsMutable();
    }

    private Map getAllFieldsMutable() {
        int n10;
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        List list = GeneratedMessageV3$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable()).getFields();
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

    private GeneratedMessageV3$Builder setUnknownFieldsInternal(UnknownFieldSet unknownFieldSet) {
        this.unknownFields = unknownFieldSet;
        this.onChanged();
        return this;
    }

    public GeneratedMessageV3$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).addRepeated(this, object);
        return this;
    }

    public GeneratedMessageV3$Builder clear() {
        UnknownFieldSet unknownFieldSet;
        this.unknownFields = unknownFieldSet = UnknownFieldSet.getDefaultInstance();
        this.onChanged();
        return this;
    }

    public GeneratedMessageV3$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).clear(this);
        return this;
    }

    public GeneratedMessageV3$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        GeneratedMessageV3$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).clear(this);
        return this;
    }

    public GeneratedMessageV3$Builder clone() {
        GeneratedMessageV3$Builder generatedMessageV3$Builder = (GeneratedMessageV3$Builder)this.getDefaultInstanceForType().newBuilderForType();
        Message message = this.buildPartial();
        generatedMessageV3$Builder.mergeFrom(message);
        return generatedMessageV3$Builder;
    }

    public void dispose() {
        this.builderParent = null;
    }

    public Map getAllFields() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable());
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return GeneratedMessageV3$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        Object object = GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).get(this);
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (bl2) {
            return Collections.unmodifiableList((List)object);
        }
        return object;
    }

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getBuilder(this);
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).get(this);
    }

    public GeneratedMessageV3$BuilderParent getParentForChildren() {
        GeneratedMessageV3$Builder$BuilderParentImpl generatedMessageV3$Builder$BuilderParentImpl = this.meAsParent;
        if (generatedMessageV3$Builder$BuilderParentImpl == null) {
            this.meAsParent = generatedMessageV3$Builder$BuilderParentImpl = new GeneratedMessageV3$Builder$BuilderParentImpl(this, null);
        }
        return this.meAsParent;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeated(this, n10);
    }

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedBuilder(this, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedCount(this);
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
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

    public GeneratedMessageV3$Builder mergeUnknownFields(UnknownFieldSet messageLite) {
        messageLite = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom((UnknownFieldSet)messageLite).build();
        return this.setUnknownFields((UnknownFieldSet)messageLite);
    }

    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).newBuilder();
    }

    public void onBuilt() {
        GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.builderParent;
        if (generatedMessageV3$BuilderParent != null) {
            this.markClean();
        }
    }

    public final void onChanged() {
        GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent;
        boolean bl2 = this.isClean;
        if (bl2 && (generatedMessageV3$BuilderParent = this.builderParent) != null) {
            generatedMessageV3$BuilderParent.markDirty();
            bl2 = false;
            generatedMessageV3$BuilderParent = null;
            this.isClean = false;
        }
    }

    public GeneratedMessageV3$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).set(this, object);
        return this;
    }

    public GeneratedMessageV3$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        GeneratedMessageV3$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).setRepeated(this, n10, object);
        return this;
    }

    public GeneratedMessageV3$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this.setUnknownFieldsInternal(unknownFieldSet);
    }

    public GeneratedMessageV3$Builder setUnknownFieldsProto3(UnknownFieldSet unknownFieldSet) {
        return this.setUnknownFieldsInternal(unknownFieldSet);
    }
}

