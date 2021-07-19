/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$StatusType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Messages$StatusType
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Messages$StatusType[] $VALUES;
    private static final Messages$StatusType[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    public static final /* enum */ Messages$StatusType off;
    public static final int off_VALUE = 2;
    public static final /* enum */ Messages$StatusType on;
    public static final int on_VALUE = 1;
    private final int value;

    static {
        Messages$StatusType messages$StatusType;
        int n10 = 1;
        Object object = new Messages$StatusType("on", 0, n10);
        on = object;
        int n11 = 2;
        off = messages$StatusType = new Messages$StatusType("off", n10, n11);
        Messages$StatusType[] messages$StatusTypeArray = new Messages$StatusType[n11];
        messages$StatusTypeArray[0] = object;
        messages$StatusTypeArray[n10] = messages$StatusType;
        $VALUES = messages$StatusTypeArray;
        internalValueMap = object = new Messages$StatusType$1();
        VALUES = Messages$StatusType.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Messages$StatusType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Messages$StatusType forNumber(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return null;
            }
            return off;
        }
        return on;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Messages.getDescriptor().getEnumTypes().get(2);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Messages$StatusType valueOf(int n10) {
        return Messages$StatusType.forNumber(n10);
    }

    public static Messages$StatusType valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Messages$StatusType[] messages$StatusTypeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (messages$StatusTypeArray == (descriptors$EnumDescriptor = Messages$StatusType.getDescriptor())) {
            messages$StatusTypeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return messages$StatusTypeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Messages$StatusType valueOf(String string2) {
        return Enum.valueOf(Messages$StatusType.class, string2);
    }

    public static Messages$StatusType[] values() {
        return (Messages$StatusType[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Messages$StatusType.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Messages$StatusType.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

