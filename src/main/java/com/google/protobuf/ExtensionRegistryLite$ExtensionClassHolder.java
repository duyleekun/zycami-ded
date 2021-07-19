/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public class ExtensionRegistryLite$ExtensionClassHolder {
    public static final Class INSTANCE = ExtensionRegistryLite$ExtensionClassHolder.resolveExtensionClass();

    private ExtensionRegistryLite$ExtensionClassHolder() {
    }

    public static Class resolveExtensionClass() {
        String string2 = "com.google.protobuf.Extension";
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }
}

