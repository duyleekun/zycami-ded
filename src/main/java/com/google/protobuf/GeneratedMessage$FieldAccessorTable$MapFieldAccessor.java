/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratedMessage$FieldAccessorTable$MapFieldAccessor
implements GeneratedMessage$FieldAccessorTable$FieldAccessor {
    private final Descriptors$FieldDescriptor field;
    private final Message mapEntryMessageDefaultInstance;

    public GeneratedMessage$FieldAccessorTable$MapFieldAccessor(Descriptors$FieldDescriptor object, String object2, Class clazz, Class clazz2) {
        this.field = object;
        object2 = new Class[]{};
        object2 = GeneratedMessage.access$1100(clazz, "getDefaultInstance", object2);
        object = new Object[]{};
        object = (GeneratedMessage)GeneratedMessage.access$1200((Method)object2, null, object);
        this.mapEntryMessageDefaultInstance = object = this.getMapField((GeneratedMessage)object).getMapEntryMessageDefaultInstance();
    }

    private MapField getMapField(GeneratedMessage$Builder generatedMessage$Builder) {
        int n10 = this.field.getNumber();
        return generatedMessage$Builder.internalGetMapField(n10);
    }

    private MapField getMapField(GeneratedMessage generatedMessage) {
        int n10 = this.field.getNumber();
        return generatedMessage.internalGetMapField(n10);
    }

    private MapField getMutableMapField(GeneratedMessage$Builder generatedMessage$Builder) {
        int n10 = this.field.getNumber();
        return generatedMessage$Builder.internalGetMutableMapField(n10);
    }

    public void addRepeated(GeneratedMessage$Builder object, Object object2) {
        object = this.getMutableMapField((GeneratedMessage$Builder)object).getMutableList();
        object2 = (Message)object2;
        object.add(object2);
    }

    public void clear(GeneratedMessage$Builder generatedMessage$Builder) {
        this.getMutableMapField(generatedMessage$Builder).getMutableList().clear();
    }

    public Object get(GeneratedMessage$Builder generatedMessage$Builder) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = this.getRepeatedCount(generatedMessage$Builder)); ++i10) {
            Object object = this.getRepeated(generatedMessage$Builder, i10);
            arrayList.add(object);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Object get(GeneratedMessage generatedMessage) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = this.getRepeatedCount(generatedMessage)); ++i10) {
            Object object = this.getRepeated(generatedMessage, i10);
            arrayList.add(object);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Message$Builder getBuilder(GeneratedMessage$Builder object) {
        object = new UnsupportedOperationException("Nested builder not supported for map fields.");
        throw object;
    }

    public Object getRaw(GeneratedMessage$Builder generatedMessage$Builder) {
        return this.get(generatedMessage$Builder);
    }

    public Object getRaw(GeneratedMessage generatedMessage) {
        return this.get(generatedMessage);
    }

    public Object getRepeated(GeneratedMessage$Builder generatedMessage$Builder, int n10) {
        return this.getMapField(generatedMessage$Builder).getList().get(n10);
    }

    public Object getRepeated(GeneratedMessage generatedMessage, int n10) {
        return this.getMapField(generatedMessage).getList().get(n10);
    }

    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder object, int n10) {
        object = new UnsupportedOperationException("Nested builder not supported for map fields.");
        throw object;
    }

    public int getRepeatedCount(GeneratedMessage$Builder generatedMessage$Builder) {
        return this.getMapField(generatedMessage$Builder).getList().size();
    }

    public int getRepeatedCount(GeneratedMessage generatedMessage) {
        return this.getMapField(generatedMessage).getList().size();
    }

    public Object getRepeatedRaw(GeneratedMessage$Builder generatedMessage$Builder, int n10) {
        return this.getRepeated(generatedMessage$Builder, n10);
    }

    public Object getRepeatedRaw(GeneratedMessage generatedMessage, int n10) {
        return this.getRepeated(generatedMessage, n10);
    }

    public boolean has(GeneratedMessage$Builder object) {
        object = new UnsupportedOperationException("hasField() is not supported for repeated fields.");
        throw object;
    }

    public boolean has(GeneratedMessage serializable) {
        serializable = new UnsupportedOperationException("hasField() is not supported for repeated fields.");
        throw serializable;
    }

    public Message$Builder newBuilder() {
        return this.mapEntryMessageDefaultInstance.newBuilderForType();
    }

    public void set(GeneratedMessage$Builder generatedMessage$Builder, Object iterator2) {
        boolean bl2;
        this.clear(generatedMessage$Builder);
        iterator2 = ((List)((Object)iterator2)).iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.addRepeated(generatedMessage$Builder, e10);
        }
    }

    public void setRepeated(GeneratedMessage$Builder object, int n10, Object object2) {
        object = this.getMutableMapField((GeneratedMessage$Builder)object).getMutableList();
        object2 = (Message)object2;
        object.set(n10, object2);
    }
}

