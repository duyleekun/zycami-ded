/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class MessageReflection$MergeTarget$ContainerType
extends Enum {
    private static final /* synthetic */ MessageReflection$MergeTarget$ContainerType[] $VALUES;
    public static final /* enum */ MessageReflection$MergeTarget$ContainerType EXTENSION_SET;
    public static final /* enum */ MessageReflection$MergeTarget$ContainerType MESSAGE;

    static {
        MessageReflection$MergeTarget$ContainerType messageReflection$MergeTarget$ContainerType;
        MessageReflection$MergeTarget$ContainerType messageReflection$MergeTarget$ContainerType2;
        MESSAGE = messageReflection$MergeTarget$ContainerType2 = new MessageReflection$MergeTarget$ContainerType("MESSAGE", 0);
        int n10 = 1;
        EXTENSION_SET = messageReflection$MergeTarget$ContainerType = new MessageReflection$MergeTarget$ContainerType("EXTENSION_SET", n10);
        MessageReflection$MergeTarget$ContainerType[] messageReflection$MergeTarget$ContainerTypeArray = new MessageReflection$MergeTarget$ContainerType[2];
        messageReflection$MergeTarget$ContainerTypeArray[0] = messageReflection$MergeTarget$ContainerType2;
        messageReflection$MergeTarget$ContainerTypeArray[n10] = messageReflection$MergeTarget$ContainerType;
        $VALUES = messageReflection$MergeTarget$ContainerTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MessageReflection$MergeTarget$ContainerType() {
        void var2_-1;
        void var1_-1;
    }

    public static MessageReflection$MergeTarget$ContainerType valueOf(String string2) {
        return Enum.valueOf(MessageReflection$MergeTarget$ContainerType.class, string2);
    }

    public static MessageReflection$MergeTarget$ContainerType[] values() {
        return (MessageReflection$MergeTarget$ContainerType[])$VALUES.clone();
    }
}

