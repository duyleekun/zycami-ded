/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ManifestSchemaFactory;
import com.google.protobuf.MessageSchema;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.SchemaFactory;
import com.google.protobuf.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Protobuf {
    private static final Protobuf INSTANCE;
    private final ConcurrentMap schemaCache;
    private final SchemaFactory schemaFactory;

    static {
        Protobuf protobuf;
        INSTANCE = protobuf = new Protobuf();
    }

    private Protobuf() {
        Object object = new ConcurrentHashMap();
        this.schemaCache = object;
        this.schemaFactory = object = new ManifestSchemaFactory();
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        int n10;
        Iterator iterator2 = this.schemaCache.values().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Schema schema = (Schema)iterator2.next();
            boolean bl2 = schema instanceof MessageSchema;
            if (!bl2) continue;
            schema = (MessageSchema)schema;
            n10 = ((MessageSchema)schema).getSchemaSize();
            n11 += n10;
        }
        return n11;
    }

    public boolean isInitialized(Object object) {
        return this.schemaFor(object).isInitialized(object);
    }

    public void makeImmutable(Object object) {
        this.schemaFor(object).makeImmutable(object);
    }

    public void mergeFrom(Object object, Reader reader) {
        ExtensionRegistryLite extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
        this.mergeFrom(object, reader, extensionRegistryLite);
    }

    public void mergeFrom(Object object, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        this.schemaFor(object).mergeFrom(object, reader, extensionRegistryLite);
    }

    public Schema registerSchema(Class clazz, Schema schema) {
        Internal.checkNotNull(clazz, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(clazz, schema);
    }

    public Schema registerSchemaOverride(Class clazz, Schema schema) {
        Internal.checkNotNull(clazz, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(clazz, schema);
    }

    public Schema schemaFor(Class object) {
        Internal.checkNotNull(object, "messageType");
        Object object2 = (Schema)this.schemaCache.get(object);
        if (object2 == null && (object = this.registerSchema((Class)object, (Schema)(object2 = this.schemaFactory.createSchema((Class)object)))) != null) {
            object2 = object;
        }
        return object2;
    }

    public Schema schemaFor(Object clazz) {
        clazz = clazz.getClass();
        return this.schemaFor(clazz);
    }

    public void writeTo(Object object, Writer writer) {
        this.schemaFor(object).writeTo(object, writer);
    }
}

