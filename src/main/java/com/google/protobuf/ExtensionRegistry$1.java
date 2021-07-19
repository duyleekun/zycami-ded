/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Extension$ExtensionType;

public class ExtensionRegistry$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Extension$ExtensionType extension$ExtensionType;
        int n12 = Extension$ExtensionType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$Extension$ExtensionType = nArray;
        try {
            extension$ExtensionType = Extension$ExtensionType.IMMUTABLE;
            n11 = extension$ExtensionType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$Extension$ExtensionType;
            extension$ExtensionType = Extension$ExtensionType.MUTABLE;
            n11 = extension$ExtensionType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

