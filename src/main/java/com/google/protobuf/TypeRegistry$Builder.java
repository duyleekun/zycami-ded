/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.TypeRegistry;
import com.google.protobuf.TypeRegistry$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public final class TypeRegistry$Builder {
    private final Set files;
    private Map types;

    private TypeRegistry$Builder() {
        Cloneable cloneable;
        this.files = cloneable = new Cloneable();
        this.types = cloneable;
    }

    public /* synthetic */ TypeRegistry$Builder(TypeRegistry$1 typeRegistry$1) {
        this();
    }

    private void addFile(Descriptors$FileDescriptor object) {
        boolean bl2;
        Object object2 = this.files;
        Object object3 = ((Descriptors$FileDescriptor)object).getFullName();
        boolean bl3 = object2.add(object3);
        if (!bl3) {
            return;
        }
        object2 = ((Descriptors$FileDescriptor)object).getDependencies().iterator();
        while (bl2 = object2.hasNext()) {
            object3 = (Descriptors$FileDescriptor)object2.next();
            this.addFile((Descriptors$FileDescriptor)object3);
        }
        object = ((Descriptors$FileDescriptor)object).getMessageTypes().iterator();
        while (bl3 = object.hasNext()) {
            object2 = (Descriptors$Descriptor)object.next();
            this.addMessage((Descriptors$Descriptor)object2);
        }
    }

    private void addMessage(Descriptors$Descriptor object) {
        Object object2;
        boolean bl2;
        Object object3 = ((Descriptors$Descriptor)object).getNestedTypes().iterator();
        while (bl2 = object3.hasNext()) {
            object2 = (Descriptors$Descriptor)object3.next();
            this.addMessage((Descriptors$Descriptor)object2);
        }
        object3 = this.types;
        object2 = ((Descriptors$Descriptor)object).getFullName();
        boolean bl3 = object3.containsKey(object2);
        if (bl3) {
            object3 = TypeRegistry.access$200();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Type ");
            object = ((Descriptors$Descriptor)object).getFullName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" is added multiple times.");
            object = ((StringBuilder)object2).toString();
            ((Logger)object3).warning((String)object);
            return;
        }
        object3 = this.types;
        object2 = ((Descriptors$Descriptor)object).getFullName();
        object3.put(object2, object);
    }

    public TypeRegistry$Builder add(Descriptors$Descriptor object) {
        Map map = this.types;
        if (map != null) {
            object = ((Descriptors$Descriptor)object).getFile();
            this.addFile((Descriptors$FileDescriptor)object);
            return this;
        }
        object = new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        throw object;
    }

    public TypeRegistry$Builder add(Iterable iterator2) {
        Object object = this.types;
        if (object != null) {
            boolean bl2;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object = ((Descriptors$Descriptor)iterator2.next()).getFile();
                this.addFile((Descriptors$FileDescriptor)object);
            }
            return this;
        }
        iterator2 = new Iterator("A TypeRegistry.Builder can only be used once.");
        throw iterator2;
    }

    public TypeRegistry build() {
        Map map = this.types;
        TypeRegistry typeRegistry = new TypeRegistry(map);
        this.types = null;
        return typeRegistry;
    }
}

