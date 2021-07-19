/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$DeviceType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Messages$DeviceType
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Messages$DeviceType[] $VALUES;
    private static final Messages$DeviceType[] VALUES;
    public static final /* enum */ Messages$DeviceType android;
    public static final int android_VALUE = 1;
    private static final Internal$EnumLiteMap internalValueMap;
    public static final /* enum */ Messages$DeviceType ios;
    public static final int ios_VALUE = 2;
    public static final /* enum */ Messages$DeviceType unknown;
    public static final int unknown_VALUE;
    private final int value;

    static {
        Messages$DeviceType messages$DeviceType;
        Messages$DeviceType messages$DeviceType2;
        Object object = new Messages$DeviceType("unknown", 0, 0);
        unknown = object;
        int n10 = 1;
        android = messages$DeviceType2 = new Messages$DeviceType("android", n10, n10);
        int n11 = 2;
        ios = messages$DeviceType = new Messages$DeviceType("ios", n11, n11);
        Messages$DeviceType[] messages$DeviceTypeArray = new Messages$DeviceType[3];
        messages$DeviceTypeArray[0] = object;
        messages$DeviceTypeArray[n10] = messages$DeviceType2;
        messages$DeviceTypeArray[n11] = messages$DeviceType;
        $VALUES = messages$DeviceTypeArray;
        internalValueMap = object = new Messages$DeviceType$1();
        VALUES = Messages$DeviceType.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Messages$DeviceType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Messages$DeviceType forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return ios;
            }
            return android;
        }
        return unknown;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Messages.getDescriptor().getEnumTypes().get(3);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Messages$DeviceType valueOf(int n10) {
        return Messages$DeviceType.forNumber(n10);
    }

    public static Messages$DeviceType valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Messages$DeviceType[] messages$DeviceTypeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (messages$DeviceTypeArray == (descriptors$EnumDescriptor = Messages$DeviceType.getDescriptor())) {
            messages$DeviceTypeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return messages$DeviceTypeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Messages$DeviceType valueOf(String string2) {
        return Enum.valueOf(Messages$DeviceType.class, string2);
    }

    public static Messages$DeviceType[] values() {
        return (Messages$DeviceType[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Messages$DeviceType.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Messages$DeviceType.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

