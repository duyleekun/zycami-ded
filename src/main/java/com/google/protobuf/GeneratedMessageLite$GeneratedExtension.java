/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.util.ArrayList;
import java.util.List;

public class GeneratedMessageLite$GeneratedExtension
extends ExtensionLite {
    public final MessageLite containingTypeDefaultInstance;
    public final Object defaultValue;
    public final GeneratedMessageLite$ExtensionDescriptor descriptor;
    public final MessageLite messageDefaultInstance;

    public GeneratedMessageLite$GeneratedExtension(MessageLite object, Object object2, MessageLite messageLite, GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor, Class object3) {
        if (object != null) {
            WireFormat$FieldType wireFormat$FieldType;
            object3 = generatedMessageLite$ExtensionDescriptor.getLiteType();
            if (object3 == (wireFormat$FieldType = WireFormat$FieldType.MESSAGE) && messageLite == null) {
                object = new IllegalArgumentException("Null messageDefaultInstance");
                throw object;
            }
            this.containingTypeDefaultInstance = object;
            this.defaultValue = object2;
            this.messageDefaultInstance = messageLite;
            this.descriptor = generatedMessageLite$ExtensionDescriptor;
            return;
        }
        object = new IllegalArgumentException("Null containingTypeDefaultInstance");
        throw object;
    }

    public Object fromFieldSetType(Object iterator2) {
        Object object = this.descriptor;
        boolean bl2 = object.isRepeated();
        if (bl2) {
            Object object2;
            object = this.descriptor.getLiteJavaType();
            if (object == (object2 = WireFormat$JavaType.ENUM)) {
                boolean bl3;
                object = new ArrayList();
                iterator2 = ((List)((Object)iterator2)).iterator();
                while (bl3 = iterator2.hasNext()) {
                    object2 = iterator2.next();
                    object2 = this.singularFromFieldSetType(object2);
                    object.add(object2);
                }
                return object;
            }
            return iterator2;
        }
        return this.singularFromFieldSetType(iterator2);
    }

    public MessageLite getContainingTypeDefaultInstance() {
        return this.containingTypeDefaultInstance;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public WireFormat$FieldType getLiteType() {
        return this.descriptor.getLiteType();
    }

    public MessageLite getMessageDefaultInstance() {
        return this.messageDefaultInstance;
    }

    public int getNumber() {
        return this.descriptor.getNumber();
    }

    public boolean isRepeated() {
        return this.descriptor.isRepeated;
    }

    public Object singularFromFieldSetType(Object object) {
        WireFormat$JavaType wireFormat$JavaType;
        Object object2 = this.descriptor.getLiteJavaType();
        if (object2 == (wireFormat$JavaType = WireFormat$JavaType.ENUM)) {
            object2 = this.descriptor.enumTypeMap;
            int n10 = (Integer)object;
            object = object2.findValueByNumber(n10);
        }
        return object;
    }

    public Object singularToFieldSetType(Object object) {
        WireFormat$JavaType wireFormat$JavaType;
        WireFormat$JavaType wireFormat$JavaType2 = this.descriptor.getLiteJavaType();
        if (wireFormat$JavaType2 == (wireFormat$JavaType = WireFormat$JavaType.ENUM)) {
            int n10 = ((Internal$EnumLite)object).getNumber();
            object = n10;
        }
        return object;
    }

    public Object toFieldSetType(Object iterator2) {
        Object object = this.descriptor;
        boolean bl2 = object.isRepeated();
        if (bl2) {
            Object object2;
            object = this.descriptor.getLiteJavaType();
            if (object == (object2 = WireFormat$JavaType.ENUM)) {
                boolean bl3;
                object = new ArrayList();
                iterator2 = ((List)((Object)iterator2)).iterator();
                while (bl3 = iterator2.hasNext()) {
                    object2 = iterator2.next();
                    object2 = this.singularToFieldSetType(object2);
                    object.add(object2);
                }
                return object;
            }
            return iterator2;
        }
        return this.singularToFieldSetType(iterator2);
    }
}

