/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$OpType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Messages$OpType
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Messages$OpType[] $VALUES;
    private static final Messages$OpType[] VALUES;
    public static final /* enum */ Messages$OpType add;
    public static final int add_VALUE = 2;
    public static final /* enum */ Messages$OpType add_shutup;
    public static final int add_shutup_VALUE = 180;
    public static final /* enum */ Messages$OpType added;
    public static final int added_VALUE = 10;
    public static final /* enum */ Messages$OpType block;
    public static final int block_VALUE = 170;
    public static final /* enum */ Messages$OpType blocked;
    public static final int blocked_VALUE = 172;
    public static final /* enum */ Messages$OpType check_block;
    public static final int check_block_VALUE = 176;
    public static final /* enum */ Messages$OpType check_result;
    public static final int check_result_VALUE = 177;
    public static final /* enum */ Messages$OpType check_shutup;
    public static final int check_shutup_VALUE = 190;
    public static final /* enum */ Messages$OpType close;
    public static final int close_VALUE = 4;
    public static final /* enum */ Messages$OpType closed;
    public static final int closed_VALUE = 6;
    public static final /* enum */ Messages$OpType conflict;
    public static final int conflict_VALUE = 9;
    public static final /* enum */ Messages$OpType count;
    public static final int count_VALUE = 43;
    private static final Internal$EnumLiteMap internalValueMap;
    public static final /* enum */ Messages$OpType invite;
    public static final int invite_VALUE = 81;
    public static final /* enum */ Messages$OpType invited;
    public static final int invited_VALUE = 85;
    public static final /* enum */ Messages$OpType is_member;
    public static final int is_member_VALUE = 52;
    public static final /* enum */ Messages$OpType is_subscribed;
    public static final int is_subscribed_VALUE = 124;
    public static final /* enum */ Messages$OpType join;
    public static final int join_VALUE = 80;
    public static final /* enum */ Messages$OpType joined;
    public static final int joined_VALUE = 32;
    public static final /* enum */ Messages$OpType kick;
    public static final int kick_VALUE = 83;
    public static final /* enum */ Messages$OpType kicked;
    public static final int kicked_VALUE = 86;
    public static final /* enum */ Messages$OpType leave;
    public static final int leave_VALUE = 82;
    public static final /* enum */ Messages$OpType left;
    public static final int left_VALUE = 39;
    public static final /* enum */ Messages$OpType max_read;
    public static final int max_read_VALUE = 51;
    public static final /* enum */ Messages$OpType member_info_changed;
    public static final int member_info_changed_VALUE = 55;
    public static final /* enum */ Messages$OpType member_info_update;
    public static final int member_info_update_VALUE = 53;
    public static final /* enum */ Messages$OpType member_info_updated;
    public static final int member_info_updated_VALUE = 54;
    public static final /* enum */ Messages$OpType members;
    public static final int members_VALUE = 50;
    public static final /* enum */ Messages$OpType members_blocked;
    public static final int members_blocked_VALUE = 174;
    public static final /* enum */ Messages$OpType members_joined;
    public static final int members_joined_VALUE = 33;
    public static final /* enum */ Messages$OpType members_left;
    public static final int members_left_VALUE = 40;
    public static final /* enum */ Messages$OpType members_shutuped;
    public static final int members_shutuped_VALUE = 188;
    public static final /* enum */ Messages$OpType members_unblocked;
    public static final int members_unblocked_VALUE = 175;
    public static final /* enum */ Messages$OpType members_unshutuped;
    public static final int members_unshutuped_VALUE = 189;
    public static final /* enum */ Messages$OpType modified;
    public static final int modified_VALUE = 151;
    public static final /* enum */ Messages$OpType modify;
    public static final int modify_VALUE = 150;
    public static final /* enum */ Messages$OpType mute;
    public static final int mute_VALUE = 47;
    public static final /* enum */ Messages$OpType open;
    public static final int open_VALUE = 1;
    public static final /* enum */ Messages$OpType opened;
    public static final int opened_VALUE = 5;
    public static final /* enum */ Messages$OpType query;
    public static final int query_VALUE = 7;
    public static final /* enum */ Messages$OpType query_result;
    public static final int query_result_VALUE = 8;
    public static final /* enum */ Messages$OpType query_shutup;
    public static final int query_shutup_VALUE = 182;
    public static final /* enum */ Messages$OpType refresh;
    public static final int refresh_VALUE = 12;
    public static final /* enum */ Messages$OpType refreshed;
    public static final int refreshed_VALUE = 13;
    public static final /* enum */ Messages$OpType reject;
    public static final int reject_VALUE = 84;
    public static final /* enum */ Messages$OpType remove;
    public static final int remove_VALUE = 3;
    public static final /* enum */ Messages$OpType remove_shutup;
    public static final int remove_shutup_VALUE = 181;
    public static final /* enum */ Messages$OpType removed;
    public static final int removed_VALUE = 11;
    public static final /* enum */ Messages$OpType result;
    public static final int result_VALUE = 44;
    public static final /* enum */ Messages$OpType results;
    public static final int results_VALUE = 42;
    public static final /* enum */ Messages$OpType shutup_added;
    public static final int shutup_added_VALUE = 183;
    public static final /* enum */ Messages$OpType shutup_removed;
    public static final int shutup_removed_VALUE = 184;
    public static final /* enum */ Messages$OpType shutup_result;
    public static final int shutup_result_VALUE = 185;
    public static final /* enum */ Messages$OpType shutuped;
    public static final int shutuped_VALUE = 186;
    public static final /* enum */ Messages$OpType start;
    public static final int start_VALUE = 30;
    public static final /* enum */ Messages$OpType started;
    public static final int started_VALUE = 31;
    public static final /* enum */ Messages$OpType status;
    public static final int status_VALUE = 49;
    public static final /* enum */ Messages$OpType subscribe;
    public static final int subscribe_VALUE = 120;
    public static final /* enum */ Messages$OpType subscribed;
    public static final int subscribed_VALUE = 121;
    public static final /* enum */ Messages$OpType unblock;
    public static final int unblock_VALUE = 171;
    public static final /* enum */ Messages$OpType unblocked;
    public static final int unblocked_VALUE = 173;
    public static final /* enum */ Messages$OpType unmute;
    public static final int unmute_VALUE = 48;
    public static final /* enum */ Messages$OpType unshutuped;
    public static final int unshutuped_VALUE = 187;
    public static final /* enum */ Messages$OpType unsubscribe;
    public static final int unsubscribe_VALUE = 122;
    public static final /* enum */ Messages$OpType unsubscribed;
    public static final int unsubscribed_VALUE = 123;
    public static final /* enum */ Messages$OpType update;
    public static final int update_VALUE = 45;
    public static final /* enum */ Messages$OpType updated;
    public static final int updated_VALUE = 46;
    public static final /* enum */ Messages$OpType upload;
    public static final int upload_VALUE = 100;
    public static final /* enum */ Messages$OpType uploaded;
    public static final int uploaded_VALUE = 101;
    private final int value;

    static {
        Messages$OpType messages$OpType;
        int n10 = 1;
        Object object = new Messages$OpType("open", 0, n10);
        open = object;
        int n11 = 2;
        object = new Messages$OpType("add", n10, n11);
        add = object;
        int n12 = 3;
        object = new Messages$OpType("remove", n11, n12);
        remove = object;
        int n13 = 4;
        object = new Messages$OpType("close", n12, n13);
        close = object;
        int n14 = 5;
        object = new Messages$OpType("opened", n13, n14);
        opened = object;
        int n15 = 6;
        object = new Messages$OpType("closed", n14, n15);
        closed = object;
        int n16 = 7;
        object = new Messages$OpType("query", n15, n16);
        query = object;
        int n17 = 8;
        object = new Messages$OpType("query_result", n16, n17);
        query_result = object;
        int n18 = 9;
        object = new Messages$OpType("conflict", n17, n18);
        conflict = object;
        int n19 = 10;
        object = new Messages$OpType("added", n18, n19);
        added = object;
        int n20 = 11;
        object = new Messages$OpType("removed", n19, n20);
        removed = object;
        int n21 = 12;
        object = new Messages$OpType("refresh", n20, n21);
        refresh = object;
        int n22 = 13;
        object = new Messages$OpType("refreshed", n21, n22);
        refreshed = object;
        int n23 = 30;
        object = new Messages$OpType("start", n22, n23);
        start = object;
        n21 = 31;
        object = new Messages$OpType("started", 14, n21);
        started = object;
        n20 = 32;
        object = new Messages$OpType("joined", 15, n20);
        joined = object;
        n19 = 33;
        object = new Messages$OpType("members_joined", 16, n19);
        members_joined = object;
        n18 = 39;
        object = new Messages$OpType("left", 17, n18);
        left = object;
        n17 = 40;
        object = new Messages$OpType("members_left", 18, n17);
        members_left = object;
        n16 = 42;
        object = new Messages$OpType("results", 19, n16);
        results = object;
        n15 = 43;
        object = new Messages$OpType("count", 20, n15);
        count = object;
        n14 = 44;
        object = new Messages$OpType("result", 21, n14);
        result = object;
        object = new Messages$OpType("update", 22, 45);
        update = object;
        object = new Messages$OpType("updated", 23, 46);
        updated = object;
        object = new Messages$OpType("mute", 24, 47);
        mute = object;
        object = new Messages$OpType("unmute", 25, 48);
        unmute = object;
        object = new Messages$OpType("status", 26, 49);
        status = object;
        object = new Messages$OpType("members", 27, 50);
        members = object;
        object = new Messages$OpType("max_read", 28, 51);
        max_read = object;
        object = new Messages$OpType("is_member", 29, 52);
        is_member = object;
        object = new Messages$OpType("member_info_update", n23, 53);
        member_info_update = object;
        object = new Messages$OpType("member_info_updated", n21, 54);
        member_info_updated = object;
        object = new Messages$OpType("member_info_changed", n20, 55);
        member_info_changed = object;
        object = new Messages$OpType("join", n19, 80);
        join = object;
        object = new Messages$OpType("invite", 34, 81);
        invite = object;
        object = new Messages$OpType("leave", 35, 82);
        leave = object;
        object = new Messages$OpType("kick", 36, 83);
        kick = object;
        object = new Messages$OpType("reject", 37, 84);
        reject = object;
        object = new Messages$OpType("invited", 38, 85);
        invited = object;
        object = new Messages$OpType("kicked", n18, 86);
        kicked = object;
        object = new Messages$OpType("upload", n17, 100);
        upload = object;
        object = new Messages$OpType("uploaded", 41, 101);
        uploaded = object;
        object = new Messages$OpType("subscribe", n16, 120);
        subscribe = object;
        object = new Messages$OpType("subscribed", n15, 121);
        subscribed = object;
        object = new Messages$OpType("unsubscribe", n14, 122);
        unsubscribe = object;
        object = new Messages$OpType("unsubscribed", 45, 123);
        unsubscribed = object;
        object = new Messages$OpType("is_subscribed", 46, 124);
        is_subscribed = object;
        object = new Messages$OpType("modify", 47, 150);
        modify = object;
        object = new Messages$OpType("modified", 48, 151);
        modified = object;
        object = new Messages$OpType("block", 49, 170);
        block = object;
        object = new Messages$OpType("unblock", 50, 171);
        unblock = object;
        object = new Messages$OpType("blocked", 51, 172);
        blocked = object;
        object = new Messages$OpType("unblocked", 52, 173);
        unblocked = object;
        object = new Messages$OpType("members_blocked", 53, 174);
        members_blocked = object;
        object = new Messages$OpType("members_unblocked", 54, 175);
        members_unblocked = object;
        object = new Messages$OpType("check_block", 55, 176);
        check_block = object;
        object = new Messages$OpType("check_result", 56, 177);
        check_result = object;
        object = new Messages$OpType("add_shutup", 57, 180);
        add_shutup = object;
        object = new Messages$OpType("remove_shutup", 58, 181);
        remove_shutup = object;
        object = new Messages$OpType("query_shutup", 59, 182);
        query_shutup = object;
        object = new Messages$OpType("shutup_added", 60, 183);
        shutup_added = object;
        object = new Messages$OpType("shutup_removed", 61, 184);
        shutup_removed = object;
        object = new Messages$OpType("shutup_result", 62, 185);
        shutup_result = object;
        object = new Messages$OpType("shutuped", 63, 186);
        shutuped = object;
        object = new Messages$OpType("unshutuped", 64, 187);
        unshutuped = object;
        object = new Messages$OpType("members_shutuped", 65, 188);
        members_shutuped = object;
        object = new Messages$OpType("members_unshutuped", 66, 189);
        members_unshutuped = object;
        object = new Messages$OpType("check_shutup", 67, 190);
        check_shutup = object;
        object = new Messages$OpType[68];
        object[0] = messages$OpType = open;
        object[n10] = messages$OpType = add;
        object[n11] = messages$OpType = remove;
        object[n12] = messages$OpType = close;
        object[4] = messages$OpType = opened;
        object[5] = messages$OpType = closed;
        object[6] = messages$OpType = query;
        object[7] = messages$OpType = query_result;
        object[8] = messages$OpType = conflict;
        object[9] = messages$OpType = added;
        object[10] = messages$OpType = removed;
        object[11] = messages$OpType = refresh;
        object[12] = messages$OpType = refreshed;
        object[13] = messages$OpType = start;
        object[14] = messages$OpType = started;
        object[15] = messages$OpType = joined;
        object[16] = messages$OpType = members_joined;
        object[17] = messages$OpType = left;
        object[18] = messages$OpType = members_left;
        object[19] = messages$OpType = results;
        object[20] = messages$OpType = count;
        object[21] = messages$OpType = result;
        object[22] = messages$OpType = update;
        object[23] = messages$OpType = updated;
        object[24] = messages$OpType = mute;
        object[25] = messages$OpType = unmute;
        object[26] = messages$OpType = status;
        object[27] = messages$OpType = members;
        object[28] = messages$OpType = max_read;
        object[29] = messages$OpType = is_member;
        object[n23] = messages$OpType = member_info_update;
        object[n21] = messages$OpType = member_info_updated;
        object[n20] = messages$OpType = member_info_changed;
        object[n19] = messages$OpType = join;
        object[34] = messages$OpType = invite;
        object[35] = messages$OpType = leave;
        object[36] = messages$OpType = kick;
        object[37] = messages$OpType = reject;
        object[38] = messages$OpType = invited;
        object[n18] = messages$OpType = kicked;
        object[n17] = messages$OpType = upload;
        object[41] = messages$OpType = uploaded;
        object[n16] = messages$OpType = subscribe;
        object[n15] = messages$OpType = subscribed;
        object[n14] = messages$OpType = unsubscribe;
        object[45] = messages$OpType = unsubscribed;
        object[46] = messages$OpType = is_subscribed;
        object[47] = messages$OpType = modify;
        object[48] = messages$OpType = modified;
        object[49] = messages$OpType = block;
        object[50] = messages$OpType = unblock;
        object[51] = messages$OpType = blocked;
        object[52] = messages$OpType = unblocked;
        object[53] = messages$OpType = members_blocked;
        object[54] = messages$OpType = members_unblocked;
        object[55] = messages$OpType = check_block;
        object[56] = messages$OpType = check_result;
        object[57] = messages$OpType = add_shutup;
        object[58] = messages$OpType = remove_shutup;
        object[59] = messages$OpType = query_shutup;
        object[60] = messages$OpType = shutup_added;
        object[61] = messages$OpType = shutup_removed;
        object[62] = messages$OpType = shutup_result;
        object[63] = messages$OpType = shutuped;
        object[64] = messages$OpType = unshutuped;
        object[65] = messages$OpType = members_shutuped;
        object[66] = messages$OpType = members_unshutuped;
        object[67] = messages$OpType = check_shutup;
        $VALUES = object;
        internalValueMap = object = new Messages$OpType$1();
        VALUES = Messages$OpType.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Messages$OpType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Messages$OpType forNumber(int n10) {
        int n11 = 39;
        if (n10 != n11) {
            n11 = 40;
            if (n10 != n11) {
                n11 = 100;
                if (n10 != n11) {
                    n11 = 101;
                    if (n10 != n11) {
                        n11 = 150;
                        if (n10 != n11) {
                            n11 = 151;
                            if (n10 != n11) {
                                switch (n10) {
                                    default: {
                                        switch (n10) {
                                            default: {
                                                switch (n10) {
                                                    default: {
                                                        switch (n10) {
                                                            default: {
                                                                switch (n10) {
                                                                    default: {
                                                                        switch (n10) {
                                                                            default: {
                                                                                switch (n10) {
                                                                                    default: {
                                                                                        return null;
                                                                                    }
                                                                                    case 190: {
                                                                                        return check_shutup;
                                                                                    }
                                                                                    case 189: {
                                                                                        return members_unshutuped;
                                                                                    }
                                                                                    case 188: {
                                                                                        return members_shutuped;
                                                                                    }
                                                                                    case 187: {
                                                                                        return unshutuped;
                                                                                    }
                                                                                    case 186: {
                                                                                        return shutuped;
                                                                                    }
                                                                                    case 185: {
                                                                                        return shutup_result;
                                                                                    }
                                                                                    case 184: {
                                                                                        return shutup_removed;
                                                                                    }
                                                                                    case 183: {
                                                                                        return shutup_added;
                                                                                    }
                                                                                    case 182: {
                                                                                        return query_shutup;
                                                                                    }
                                                                                    case 181: {
                                                                                        return remove_shutup;
                                                                                    }
                                                                                    case 180: 
                                                                                }
                                                                                return add_shutup;
                                                                            }
                                                                            case 177: {
                                                                                return check_result;
                                                                            }
                                                                            case 176: {
                                                                                return check_block;
                                                                            }
                                                                            case 175: {
                                                                                return members_unblocked;
                                                                            }
                                                                            case 174: {
                                                                                return members_blocked;
                                                                            }
                                                                            case 173: {
                                                                                return unblocked;
                                                                            }
                                                                            case 172: {
                                                                                return blocked;
                                                                            }
                                                                            case 171: {
                                                                                return unblock;
                                                                            }
                                                                            case 170: 
                                                                        }
                                                                        return block;
                                                                    }
                                                                    case 124: {
                                                                        return is_subscribed;
                                                                    }
                                                                    case 123: {
                                                                        return unsubscribed;
                                                                    }
                                                                    case 122: {
                                                                        return unsubscribe;
                                                                    }
                                                                    case 121: {
                                                                        return subscribed;
                                                                    }
                                                                    case 120: 
                                                                }
                                                                return subscribe;
                                                            }
                                                            case 86: {
                                                                return kicked;
                                                            }
                                                            case 85: {
                                                                return invited;
                                                            }
                                                            case 84: {
                                                                return reject;
                                                            }
                                                            case 83: {
                                                                return kick;
                                                            }
                                                            case 82: {
                                                                return leave;
                                                            }
                                                            case 81: {
                                                                return invite;
                                                            }
                                                            case 80: 
                                                        }
                                                        return join;
                                                    }
                                                    case 55: {
                                                        return member_info_changed;
                                                    }
                                                    case 54: {
                                                        return member_info_updated;
                                                    }
                                                    case 53: {
                                                        return member_info_update;
                                                    }
                                                    case 52: {
                                                        return is_member;
                                                    }
                                                    case 51: {
                                                        return max_read;
                                                    }
                                                    case 50: {
                                                        return members;
                                                    }
                                                    case 49: {
                                                        return status;
                                                    }
                                                    case 48: {
                                                        return unmute;
                                                    }
                                                    case 47: {
                                                        return mute;
                                                    }
                                                    case 46: {
                                                        return updated;
                                                    }
                                                    case 45: {
                                                        return update;
                                                    }
                                                    case 44: {
                                                        return result;
                                                    }
                                                    case 43: {
                                                        return count;
                                                    }
                                                    case 42: 
                                                }
                                                return results;
                                            }
                                            case 33: {
                                                return members_joined;
                                            }
                                            case 32: {
                                                return joined;
                                            }
                                            case 31: {
                                                return started;
                                            }
                                            case 30: 
                                        }
                                        return start;
                                    }
                                    case 13: {
                                        return refreshed;
                                    }
                                    case 12: {
                                        return refresh;
                                    }
                                    case 11: {
                                        return removed;
                                    }
                                    case 10: {
                                        return added;
                                    }
                                    case 9: {
                                        return conflict;
                                    }
                                    case 8: {
                                        return query_result;
                                    }
                                    case 7: {
                                        return query;
                                    }
                                    case 6: {
                                        return closed;
                                    }
                                    case 5: {
                                        return opened;
                                    }
                                    case 4: {
                                        return close;
                                    }
                                    case 3: {
                                        return remove;
                                    }
                                    case 2: {
                                        return add;
                                    }
                                    case 1: 
                                }
                                return open;
                            }
                            return modified;
                        }
                        return modify;
                    }
                    return uploaded;
                }
                return upload;
            }
            return members_left;
        }
        return left;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Messages.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Messages$OpType valueOf(int n10) {
        return Messages$OpType.forNumber(n10);
    }

    public static Messages$OpType valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Messages$OpType[] messages$OpTypeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (messages$OpTypeArray == (descriptors$EnumDescriptor = Messages$OpType.getDescriptor())) {
            messages$OpTypeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return messages$OpTypeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Messages$OpType valueOf(String string2) {
        return Enum.valueOf(Messages$OpType.class, string2);
    }

    public static Messages$OpType[] values() {
        return (Messages$OpType[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Messages$OpType.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Messages$OpType.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

