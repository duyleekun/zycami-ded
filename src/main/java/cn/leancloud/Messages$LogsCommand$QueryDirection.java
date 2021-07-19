/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$LogsCommand$QueryDirection$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Messages$LogsCommand$QueryDirection
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Messages$LogsCommand$QueryDirection[] $VALUES;
    public static final /* enum */ Messages$LogsCommand$QueryDirection NEW;
    public static final int NEW_VALUE = 2;
    public static final /* enum */ Messages$LogsCommand$QueryDirection OLD;
    public static final int OLD_VALUE = 1;
    private static final Messages$LogsCommand$QueryDirection[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        Messages$LogsCommand$QueryDirection messages$LogsCommand$QueryDirection;
        int n10 = 1;
        Object object = new Messages$LogsCommand$QueryDirection("OLD", 0, n10);
        OLD = object;
        int n11 = 2;
        NEW = messages$LogsCommand$QueryDirection = new Messages$LogsCommand$QueryDirection("NEW", n10, n11);
        Messages$LogsCommand$QueryDirection[] messages$LogsCommand$QueryDirectionArray = new Messages$LogsCommand$QueryDirection[n11];
        messages$LogsCommand$QueryDirectionArray[0] = object;
        messages$LogsCommand$QueryDirectionArray[n10] = messages$LogsCommand$QueryDirection;
        $VALUES = messages$LogsCommand$QueryDirectionArray;
        internalValueMap = object = new Messages$LogsCommand$QueryDirection$1();
        VALUES = Messages$LogsCommand$QueryDirection.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Messages$LogsCommand$QueryDirection() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Messages$LogsCommand$QueryDirection forNumber(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return null;
            }
            return NEW;
        }
        return OLD;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Messages$LogsCommand.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Messages$LogsCommand$QueryDirection valueOf(int n10) {
        return Messages$LogsCommand$QueryDirection.forNumber(n10);
    }

    public static Messages$LogsCommand$QueryDirection valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Messages$LogsCommand$QueryDirection[] messages$LogsCommand$QueryDirectionArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (messages$LogsCommand$QueryDirectionArray == (descriptors$EnumDescriptor = Messages$LogsCommand$QueryDirection.getDescriptor())) {
            messages$LogsCommand$QueryDirectionArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return messages$LogsCommand$QueryDirectionArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Messages$LogsCommand$QueryDirection valueOf(String string2) {
        return Enum.valueOf(Messages$LogsCommand$QueryDirection.class, string2);
    }

    public static Messages$LogsCommand$QueryDirection[] values() {
        return (Messages$LogsCommand$QueryDirection[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Messages$LogsCommand$QueryDirection.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Messages$LogsCommand$QueryDirection.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

