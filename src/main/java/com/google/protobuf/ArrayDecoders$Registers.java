/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionRegistryLite;
import java.util.Objects;

public final class ArrayDecoders$Registers {
    public final ExtensionRegistryLite extensionRegistry;
    public int int1;
    public long long1;
    public Object object1;

    public ArrayDecoders$Registers() {
        ExtensionRegistryLite extensionRegistryLite;
        this.extensionRegistry = extensionRegistryLite = ExtensionRegistryLite.getEmptyRegistry();
    }

    public ArrayDecoders$Registers(ExtensionRegistryLite extensionRegistryLite) {
        Objects.requireNonNull(extensionRegistryLite);
        this.extensionRegistry = extensionRegistryLite;
    }
}

