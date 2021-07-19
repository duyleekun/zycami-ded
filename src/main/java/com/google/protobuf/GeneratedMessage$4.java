/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import java.lang.reflect.Field;

public final class GeneratedMessage$4
extends GeneratedMessage$CachedDescriptorRetriever {
    public final /* synthetic */ String val$descriptorOuterClass;
    public final /* synthetic */ String val$extensionName;
    public final /* synthetic */ Class val$singularType;

    public GeneratedMessage$4(Class clazz, String string2, String string3) {
        this.val$singularType = clazz;
        this.val$descriptorOuterClass = string2;
        this.val$extensionName = string3;
        super(null);
    }

    public Descriptors$FieldDescriptor loadDescriptor() {
        Object object;
        Object object2;
        try {
            object2 = this.val$singularType;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Cannot load descriptors: ");
            String string2 = this.val$descriptorOuterClass;
            charSequence.append(string2);
            charSequence.append(" is not a valid descriptor class name");
            charSequence = charSequence.toString();
            object = new RuntimeException((String)charSequence, exception);
            throw object;
        }
        object2 = ((Class)object2).getClassLoader();
        object = this.val$descriptorOuterClass;
        object2 = ((ClassLoader)object2).loadClass((String)object);
        object = "descriptor";
        object2 = ((Class)object2).getField((String)object);
        object = null;
        object2 = ((Field)object2).get(null);
        object2 = (Descriptors$FileDescriptor)object2;
        object = this.val$extensionName;
        return ((Descriptors$FileDescriptor)object2).findExtensionByName((String)object);
    }
}

