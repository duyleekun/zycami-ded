/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$CommandType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Messages$CommandType
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Messages$CommandType[] $VALUES;
    private static final Messages$CommandType[] VALUES;
    public static final /* enum */ Messages$CommandType ack;
    public static final int ack_VALUE = 3;
    public static final /* enum */ Messages$CommandType blacklist;
    public static final int blacklist_VALUE = 20;
    public static final /* enum */ Messages$CommandType conv;
    public static final int conv_VALUE = 1;
    public static final /* enum */ Messages$CommandType data;
    public static final int data_VALUE = 9;
    public static final /* enum */ Messages$CommandType direct;
    public static final int direct_VALUE = 2;
    public static final /* enum */ Messages$CommandType echo;
    public static final int echo_VALUE = 14;
    public static final /* enum */ Messages$CommandType error;
    public static final int error_VALUE = 7;
    public static final /* enum */ Messages$CommandType goaway;
    public static final int goaway_VALUE = 21;
    private static final Internal$EnumLiteMap internalValueMap;
    public static final /* enum */ Messages$CommandType loggedin;
    public static final int loggedin_VALUE = 15;
    public static final /* enum */ Messages$CommandType loggedout;
    public static final int loggedout_VALUE = 17;
    public static final /* enum */ Messages$CommandType login;
    public static final int login_VALUE = 8;
    public static final /* enum */ Messages$CommandType logout;
    public static final int logout_VALUE = 16;
    public static final /* enum */ Messages$CommandType logs;
    public static final int logs_VALUE = 6;
    public static final /* enum */ Messages$CommandType patch;
    public static final int patch_VALUE = 18;
    public static final /* enum */ Messages$CommandType presence;
    public static final int presence_VALUE = 12;
    public static final /* enum */ Messages$CommandType pubsub;
    public static final int pubsub_VALUE = 19;
    public static final /* enum */ Messages$CommandType rcp;
    public static final int rcp_VALUE = 4;
    public static final /* enum */ Messages$CommandType read;
    public static final int read_VALUE = 11;
    public static final /* enum */ Messages$CommandType report;
    public static final int report_VALUE = 13;
    public static final /* enum */ Messages$CommandType room;
    public static final int room_VALUE = 10;
    public static final /* enum */ Messages$CommandType session;
    public static final int session_VALUE = 0;
    public static final /* enum */ Messages$CommandType unread;
    public static final int unread_VALUE = 5;
    private final int value;

    static {
        Messages$CommandType messages$CommandType;
        Messages$CommandType messages$CommandType2;
        Messages$CommandType messages$CommandType3;
        Messages$CommandType messages$CommandType4;
        Messages$CommandType messages$CommandType5;
        Messages$CommandType messages$CommandType6;
        Messages$CommandType messages$CommandType7;
        Messages$CommandType messages$CommandType8;
        Messages$CommandType messages$CommandType9;
        Messages$CommandType messages$CommandType10;
        Messages$CommandType messages$CommandType11;
        Messages$CommandType messages$CommandType12;
        Messages$CommandType messages$CommandType13;
        Messages$CommandType messages$CommandType14;
        Object object = new Messages$CommandType("session", 0, 0);
        session = object;
        int n10 = 1;
        conv = messages$CommandType14 = new Messages$CommandType("conv", n10, n10);
        int n11 = 2;
        direct = messages$CommandType13 = new Messages$CommandType("direct", n11, n11);
        int n12 = 3;
        ack = messages$CommandType12 = new Messages$CommandType("ack", n12, n12);
        int n13 = 4;
        rcp = messages$CommandType11 = new Messages$CommandType("rcp", n13, n13);
        int n14 = 5;
        unread = messages$CommandType10 = new Messages$CommandType("unread", n14, n14);
        int n15 = 6;
        logs = messages$CommandType9 = new Messages$CommandType("logs", n15, n15);
        n15 = 7;
        error = messages$CommandType8 = new Messages$CommandType("error", n15, n15);
        n14 = 8;
        login = messages$CommandType7 = new Messages$CommandType("login", n14, n14);
        n13 = 9;
        data = messages$CommandType6 = new Messages$CommandType("data", n13, n13);
        n12 = 10;
        room = messages$CommandType5 = new Messages$CommandType("room", n12, n12);
        n11 = 11;
        read = messages$CommandType4 = new Messages$CommandType("read", n11, n11);
        n10 = 12;
        presence = messages$CommandType3 = new Messages$CommandType("presence", n10, n10);
        int n16 = 13;
        Messages$CommandType[] messages$CommandTypeArray = new Messages$CommandType("report", n16, n16);
        report = messages$CommandTypeArray;
        Messages$CommandType[] messages$CommandTypeArray2 = messages$CommandTypeArray;
        n11 = 14;
        echo = messages$CommandType2 = new Messages$CommandType("echo", n11, n11);
        Messages$CommandType messages$CommandType15 = messages$CommandType2;
        n10 = 15;
        loggedin = messages$CommandType = new Messages$CommandType("loggedin", n10, n10);
        Messages$CommandType messages$CommandType16 = messages$CommandType;
        n16 = 16;
        messages$CommandTypeArray = new Messages$CommandType("logout", n16, n16);
        logout = messages$CommandTypeArray;
        Messages$CommandType[] messages$CommandTypeArray3 = messages$CommandTypeArray;
        n11 = 17;
        loggedout = messages$CommandType2 = new Messages$CommandType("loggedout", n11, n11);
        Messages$CommandType messages$CommandType17 = messages$CommandType2;
        n10 = 18;
        patch = messages$CommandType = new Messages$CommandType("patch", n10, n10);
        Messages$CommandType messages$CommandType18 = messages$CommandType;
        n16 = 19;
        messages$CommandTypeArray = new Messages$CommandType("pubsub", n16, n16);
        pubsub = messages$CommandTypeArray;
        Messages$CommandType[] messages$CommandTypeArray4 = messages$CommandTypeArray;
        n11 = 20;
        blacklist = messages$CommandType2 = new Messages$CommandType("blacklist", n11, n11);
        n10 = 21;
        goaway = messages$CommandType = new Messages$CommandType("goaway", n10, n10);
        messages$CommandTypeArray = new Messages$CommandType[22];
        messages$CommandTypeArray[0] = object;
        messages$CommandTypeArray[1] = messages$CommandType14;
        messages$CommandTypeArray[2] = messages$CommandType13;
        messages$CommandTypeArray[3] = messages$CommandType12;
        messages$CommandTypeArray[4] = messages$CommandType11;
        messages$CommandTypeArray[5] = messages$CommandType10;
        messages$CommandTypeArray[6] = messages$CommandType9;
        messages$CommandTypeArray[7] = messages$CommandType8;
        messages$CommandTypeArray[8] = messages$CommandType7;
        messages$CommandTypeArray[9] = messages$CommandType6;
        messages$CommandTypeArray[10] = messages$CommandType5;
        messages$CommandTypeArray[11] = messages$CommandType4;
        messages$CommandTypeArray[12] = messages$CommandType3;
        messages$CommandTypeArray[13] = messages$CommandTypeArray2;
        messages$CommandTypeArray[14] = messages$CommandType15;
        messages$CommandTypeArray[15] = messages$CommandType16;
        messages$CommandTypeArray[16] = messages$CommandTypeArray3;
        messages$CommandTypeArray[17] = messages$CommandType17;
        messages$CommandTypeArray[18] = messages$CommandType18;
        messages$CommandTypeArray[19] = messages$CommandTypeArray4;
        messages$CommandTypeArray[20] = messages$CommandType2;
        messages$CommandTypeArray[n10] = messages$CommandType;
        $VALUES = messages$CommandTypeArray;
        internalValueMap = object = new Messages$CommandType$1();
        VALUES = Messages$CommandType.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Messages$CommandType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Messages$CommandType forNumber(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 21: {
                return goaway;
            }
            case 20: {
                return blacklist;
            }
            case 19: {
                return pubsub;
            }
            case 18: {
                return patch;
            }
            case 17: {
                return loggedout;
            }
            case 16: {
                return logout;
            }
            case 15: {
                return loggedin;
            }
            case 14: {
                return echo;
            }
            case 13: {
                return report;
            }
            case 12: {
                return presence;
            }
            case 11: {
                return read;
            }
            case 10: {
                return room;
            }
            case 9: {
                return data;
            }
            case 8: {
                return login;
            }
            case 7: {
                return error;
            }
            case 6: {
                return logs;
            }
            case 5: {
                return unread;
            }
            case 4: {
                return rcp;
            }
            case 3: {
                return ack;
            }
            case 2: {
                return direct;
            }
            case 1: {
                return conv;
            }
            case 0: 
        }
        return session;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Messages.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Messages$CommandType valueOf(int n10) {
        return Messages$CommandType.forNumber(n10);
    }

    public static Messages$CommandType valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Messages$CommandType[] messages$CommandTypeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (messages$CommandTypeArray == (descriptors$EnumDescriptor = Messages$CommandType.getDescriptor())) {
            messages$CommandTypeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return messages$CommandTypeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Messages$CommandType valueOf(String string2) {
        return Enum.valueOf(Messages$CommandType.class, string2);
    }

    public static Messages$CommandType[] values() {
        return (Messages$CommandType[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Messages$CommandType.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Messages$CommandType.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

