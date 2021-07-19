/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor
implements GeneratedMessageV3$FieldAccessorTable$FieldAccessor {
    private final Descriptors$FieldDescriptor field;
    private final Message mapEntryMessageDefaultInstance;

    public GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor(Descriptors$FieldDescriptor object, String object2, Class clazz, Class clazz2) {
        this.field = object;
        object2 = new Class[]{};
        object2 = GeneratedMessageV3.access$1000(clazz, "getDefaultInstance", object2);
        object = new Object[]{};
        object = (GeneratedMessageV3)GeneratedMessageV3.access$1100((Method)object2, null, object);
        this.mapEntryMessageDefaultInstance = object = this.getMapField((GeneratedMessageV3)object).getMapEntryMessageDefaultInstance();
    }

    private Message coerceType(Message message) {
        if (message == null) {
            return null;
        }
        Class<?> clazz = this.mapEntryMessageDefaultInstance.getClass();
        boolean bl2 = clazz.isInstance(message);
        if (bl2) {
            return message;
        }
        return this.mapEntryMessageDefaultInstance.toBuilder().mergeFrom(message).build();
    }

    private MapField getMapField(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        int n10 = this.field.getNumber();
        return generatedMessageV3$Builder.internalGetMapField(n10);
    }

    private MapField getMapField(GeneratedMessageV3 generatedMessageV3) {
        int n10 = this.field.getNumber();
        return generatedMessageV3.internalGetMapField(n10);
    }

    private MapField getMutableMapField(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        int n10 = this.field.getNumber();
        return generatedMessageV3$Builder.internalGetMutableMapField(n10);
    }

    public void addRepeated(GeneratedMessageV3$Builder object, Object object2) {
        object = this.getMutableMapField((GeneratedMessageV3$Builder)object).getMutableList();
        object2 = (Message)object2;
        object2 = this.coerceType((Message)object2);
        object.add(object2);
    }

    public void clear(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        this.getMutableMapField(generatedMessageV3$Builder).getMutableList().clear();
    }

    public Object get(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = this.getRepeatedCount(generatedMessageV3$Builder)); ++i10) {
            Object object = this.getRepeated(generatedMessageV3$Builder, i10);
            arrayList.add(object);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Object get(GeneratedMessageV3 generatedMessageV3) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = this.getRepeatedCount(generatedMessageV3)); ++i10) {
            Object object = this.getRepeated(generatedMessageV3, i10);
            arrayList.add(object);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Message$Builder getBuilder(GeneratedMessageV3$Builder object) {
        object = new UnsupportedOperationException("Nested builder not supported for map fields.");
        throw object;
    }

    public Object getRaw(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        return this.get(generatedMessageV3$Builder);
    }

    public Object getRaw(GeneratedMessageV3 generatedMessageV3) {
        return this.get(generatedMessageV3);
    }

    public Object getRepeated(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10) {
        return this.getMapField(generatedMessageV3$Builder).getList().get(n10);
    }

    public Object getRepeated(GeneratedMessageV3 generatedMessageV3, int n10) {
        return this.getMapField(generatedMessageV3).getList().get(n10);
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessageV3$Builder object, int n10) {
        object = new UnsupportedOperationException("Nested builder not supported for map fields.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        return this.getMapField(generatedMessageV3$Builder).getList().size();
    }

    public int getRepeatedCount(GeneratedMessageV3 generatedMessageV3) {
        return this.getMapField(generatedMessageV3).getList().size();
    }

    public Object getRepeatedRaw(GeneratedMessageV3$Builder generatedMessageV3$Builder, int n10) {
        return this.getRepeated(generatedMessageV3$Builder, n10);
    }

    public Object getRepeatedRaw(GeneratedMessageV3 generatedMessageV3, int n10) {
        return this.getRepeated(generatedMessageV3, n10);
    }

    public boolean has(GeneratedMessageV3$Builder object) {
        object = new UnsupportedOperationException("hasField() is not supported for repeated fields.");
        throw object;
    }

    public boolean has(GeneratedMessageV3 serializable) {
        serializable = new UnsupportedOperationException("hasField() is not supported for repeated fields.");
        throw serializable;
    }

    public Message$Builder newBuilder() {
        return this.mapEntryMessageDefaultInstance.newBuilderForType();
    }

    public void set(GeneratedMessageV3$Builder generatedMessageV3$Builder, Object iterator2) {
        boolean bl2;
        this.clear(generatedMessageV3$Builder);
        iterator2 = ((List)((Object)iterator2)).iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.addRepeated(generatedMessageV3$Builder, e10);
        }
    }

    public void setRepeated(GeneratedMessageV3$Builder object, int n10, Object object2) {
        object = this.getMutableMapField((GeneratedMessageV3$Builder)object).getMutableList();
        object2 = (Message)object2;
        object2 = this.coerceType((Message)object2);
        object.set(n10, object2);
    }
}

