/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryFactory;
import com.google.protobuf.ExtensionRegistryLite$ExtensionClassHolder;
import com.google.protobuf.ExtensionRegistryLite$ObjectIntPair;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.MessageLite;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
    public static final ExtensionRegistryLite EMPTY_REGISTRY_LITE;
    public static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets = false;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map extensionsByNumber;

    static {
        ExtensionRegistryLite extensionRegistryLite;
        EMPTY_REGISTRY_LITE = extensionRegistryLite = new ExtensionRegistryLite(true);
    }

    public ExtensionRegistryLite() {
        HashMap hashMap;
        this.extensionsByNumber = hashMap = new HashMap();
    }

    public ExtensionRegistryLite(ExtensionRegistryLite map) {
        ExtensionRegistryLite extensionRegistryLite = EMPTY_REGISTRY_LITE;
        this.extensionsByNumber = map == extensionRegistryLite ? (map = Collections.emptyMap()) : (map = Collections.unmodifiableMap(((ExtensionRegistryLite)map).extensionsByNumber));
    }

    public ExtensionRegistryLite(boolean bl2) {
        Map map;
        this.extensionsByNumber = map = Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite = emptyRegistry;
        if (extensionRegistryLite != null) return extensionRegistryLite;
        Class<ExtensionRegistryLite> clazz = ExtensionRegistryLite.class;
        synchronized (clazz) {
            extensionRegistryLite = emptyRegistry;
            if (extensionRegistryLite != null) return extensionRegistryLite;
            boolean bl2 = doFullRuntimeInheritanceCheck;
            extensionRegistryLite = bl2 ? ExtensionRegistryFactory.createEmpty() : EMPTY_REGISTRY_LITE;
            emptyRegistry = extensionRegistryLite;
            return extensionRegistryLite;
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static ExtensionRegistryLite newInstance() {
        boolean bl2 = doFullRuntimeInheritanceCheck;
        ExtensionRegistryLite extensionRegistryLite = bl2 ? ExtensionRegistryFactory.create() : new ExtensionRegistryLite();
        return extensionRegistryLite;
    }

    public static void setEagerlyParseMessageSets(boolean bl2) {
        eagerlyParseMessageSets = bl2;
    }

    public final void add(ExtensionLite object) {
        Class<GeneratedMessageLite$GeneratedExtension> clazz = GeneratedMessageLite$GeneratedExtension.class;
        Object[] objectArray = object.getClass();
        boolean bl2 = clazz.isAssignableFrom((Class<?>)objectArray);
        if (bl2) {
            clazz = object;
            clazz = (GeneratedMessageLite$GeneratedExtension)object;
            this.add((GeneratedMessageLite$GeneratedExtension)((Object)clazz));
        }
        if ((bl2 = doFullRuntimeInheritanceCheck) && (bl2 = ExtensionRegistryFactory.isFullRegistry(this))) {
            Object[] objectArray2;
            GenericDeclaration genericDeclaration;
            bl2 = false;
            clazz = null;
            int n10 = 1;
            try {
                genericDeclaration = this.getClass();
                objectArray2 = "add";
            }
            catch (Exception exception) {
                objectArray = new Object[n10];
                objectArray[0] = object;
                object = String.format("Could not invoke ExtensionRegistry#add for %s", objectArray);
                objectArray2 = new IllegalArgumentException((String)object, exception);
                throw objectArray2;
            }
            Class[] classArray = new Class[n10];
            Class clazz2 = ExtensionRegistryLite$ExtensionClassHolder.INSTANCE;
            classArray[0] = clazz2;
            genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray2, classArray);
            objectArray2 = new Object[n10];
            objectArray2[0] = object;
            ((Method)genericDeclaration).invoke(this, objectArray2);
        }
    }

    public final void add(GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension) {
        Map map = this.extensionsByNumber;
        MessageLite messageLite = generatedMessageLite$GeneratedExtension.getContainingTypeDefaultInstance();
        int n10 = generatedMessageLite$GeneratedExtension.getNumber();
        ExtensionRegistryLite$ObjectIntPair extensionRegistryLite$ObjectIntPair = new ExtensionRegistryLite$ObjectIntPair(messageLite, n10);
        map.put(extensionRegistryLite$ObjectIntPair, generatedMessageLite$GeneratedExtension);
    }

    public GeneratedMessageLite$GeneratedExtension findLiteExtensionByNumber(MessageLite messageLite, int n10) {
        Map map = this.extensionsByNumber;
        ExtensionRegistryLite$ObjectIntPair extensionRegistryLite$ObjectIntPair = new ExtensionRegistryLite$ObjectIntPair(messageLite, n10);
        return (GeneratedMessageLite$GeneratedExtension)map.get(extensionRegistryLite$ObjectIntPair);
    }

    public ExtensionRegistryLite getUnmodifiable() {
        ExtensionRegistryLite extensionRegistryLite = new ExtensionRegistryLite(this);
        return extensionRegistryLite;
    }
}

