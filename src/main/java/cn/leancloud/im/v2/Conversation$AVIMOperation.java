/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public final class Conversation$AVIMOperation
extends Enum {
    private static final /* synthetic */ Conversation$AVIMOperation[] $VALUES;
    public static final /* enum */ Conversation$AVIMOperation CLIENT_DISCONNECT;
    public static final /* enum */ Conversation$AVIMOperation CLIENT_ONLINE_QUERY;
    public static final /* enum */ Conversation$AVIMOperation CLIENT_OPEN;
    public static final /* enum */ Conversation$AVIMOperation CLIENT_REFRESH_TOKEN;
    public static final /* enum */ Conversation$AVIMOperation CLIENT_STATUS;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_ADD_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_BLOCKED_MEMBER_QUERY;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_BLOCK_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_CREATION;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_FETCH_RECEIPT_TIME;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_JOIN;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_MEMBER_COUNT_QUERY;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_MESSAGE_QUERY;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_MUTE;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_MUTED_MEMBER_QUERY;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_MUTE_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_PROMOTE_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_QUERY;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_QUIT;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_READ;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_RECALL_MESSAGE;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_RM_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_SEND_MESSAGE;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_UNBLOCK_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_UNKNOWN;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_UNMUTE;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_UNMUTE_MEMBER;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_UPDATE;
    public static final /* enum */ Conversation$AVIMOperation CONVERSATION_UPDATE_MESSAGE;
    public static final /* enum */ Conversation$AVIMOperation LIVEQUERY_LOGIN;
    private final int code;
    private final String header;

    static {
        Conversation$AVIMOperation conversation$AVIMOperation;
        Conversation$AVIMOperation conversation$AVIMOperation2;
        Conversation$AVIMOperation conversation$AVIMOperation3;
        Conversation$AVIMOperation conversation$AVIMOperation4;
        Conversation$AVIMOperation conversation$AVIMOperation5;
        Conversation$AVIMOperation conversation$AVIMOperation6;
        Conversation$AVIMOperation conversation$AVIMOperation7;
        Conversation$AVIMOperation conversation$AVIMOperation8;
        Conversation$AVIMOperation conversation$AVIMOperation9;
        Conversation$AVIMOperation conversation$AVIMOperation10;
        Conversation$AVIMOperation conversation$AVIMOperation11;
        CONVERSATION_CREATION = conversation$AVIMOperation11 = new Conversation$AVIMOperation("CONVERSATION_CREATION", 0, 40000, "com.avoscloud.v2.im.conversation.creation.");
        Object object = "com.avoscloud.v2.im.conversation.members.";
        CONVERSATION_ADD_MEMBER = conversation$AVIMOperation10 = new Conversation$AVIMOperation("CONVERSATION_ADD_MEMBER", 1, 40001, object);
        CONVERSATION_RM_MEMBER = conversation$AVIMOperation9 = new Conversation$AVIMOperation("CONVERSATION_RM_MEMBER", 2, 40002, object);
        CONVERSATION_JOIN = conversation$AVIMOperation8 = new Conversation$AVIMOperation("CONVERSATION_JOIN", 3, 40003, "com.avoscloud.v2.im.conversation.join.");
        object = new Conversation$AVIMOperation("CONVERSATION_QUIT", 4, 40004, "com.avoscloud.v2.im.conversation.quit.");
        CONVERSATION_QUIT = object;
        CONVERSATION_SEND_MESSAGE = conversation$AVIMOperation7 = new Conversation$AVIMOperation("CONVERSATION_SEND_MESSAGE", 5, 40005, "com.avoscloud.v2.im.conversation.message.");
        CLIENT_OPEN = conversation$AVIMOperation6 = new Conversation$AVIMOperation("CLIENT_OPEN", 6, 40006, "com.avoscloud.v2.im.client.initialize.");
        CLIENT_DISCONNECT = conversation$AVIMOperation5 = new Conversation$AVIMOperation("CLIENT_DISCONNECT", 7, 40007, "com.avoscloud.v2.im.client.quit.");
        CONVERSATION_QUERY = conversation$AVIMOperation4 = new Conversation$AVIMOperation("CONVERSATION_QUERY", 8, 40008, "com.avoscloud.v2.im.conversation.query.");
        CONVERSATION_UPDATE = conversation$AVIMOperation3 = new Conversation$AVIMOperation("CONVERSATION_UPDATE", 9, 40009, "com.avoscloud.v2.im.conversation.update.");
        CONVERSATION_MESSAGE_QUERY = conversation$AVIMOperation2 = new Conversation$AVIMOperation("CONVERSATION_MESSAGE_QUERY", 10, 40010, "com.avoscloud.v2.im.conversation.message.query.");
        CONVERSATION_MUTE = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_MUTE", 11, 40011, "com.avoscloud.v2.im.conversation.mute.");
        Conversation$AVIMOperation conversation$AVIMOperation12 = conversation$AVIMOperation;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray = new Conversation$AVIMOperation("CONVERSATION_UNMUTE", 12, 40012, "com.avoscloud.v2.im.conversation.unmute");
        CONVERSATION_UNMUTE = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray2 = conversation$AVIMOperationArray;
        CONVERSATION_MEMBER_COUNT_QUERY = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_MEMBER_COUNT_QUERY", 13, 40013, "com.avoscloud.v2.im.conversation.membercount.");
        Conversation$AVIMOperation conversation$AVIMOperation13 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CLIENT_ONLINE_QUERY", 14, 40014, "com.avoscloud.v2.im.client.onlineQuery.");
        CLIENT_ONLINE_QUERY = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray3 = conversation$AVIMOperationArray;
        CLIENT_STATUS = conversation$AVIMOperation = new Conversation$AVIMOperation("CLIENT_STATUS", 15, 40015, "com.avoscloud.v2.im.client.status");
        Conversation$AVIMOperation conversation$AVIMOperation14 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CONVERSATION_READ", 16, 40016, "com.avoscloud.v2.im.conversation.read.");
        CONVERSATION_READ = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray4 = conversation$AVIMOperationArray;
        CONVERSATION_FETCH_RECEIPT_TIME = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_FETCH_RECEIPT_TIME", 17, 40017, "com.avoscloud.v2.im.conversation.fetchReceiptTimestamps.");
        Conversation$AVIMOperation conversation$AVIMOperation15 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CONVERSATION_UPDATE_MESSAGE", 18, 40018, "com.avoscloud.v2.im.conversation.updateMessage.");
        CONVERSATION_UPDATE_MESSAGE = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray5 = conversation$AVIMOperationArray;
        CONVERSATION_RECALL_MESSAGE = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_RECALL_MESSAGE", 19, 40019, "com.avoscloud.v2.im.conversation.recallMessage.");
        Conversation$AVIMOperation conversation$AVIMOperation16 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CLIENT_REFRESH_TOKEN", 20, 40020, "com.avoscloud.v2.im.client.refreshToken");
        CLIENT_REFRESH_TOKEN = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray6 = conversation$AVIMOperationArray;
        CONVERSATION_PROMOTE_MEMBER = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_PROMOTE_MEMBER", 21, 40021, "com.avoscloud.v2.im.conversation.promoteMember");
        Conversation$AVIMOperation conversation$AVIMOperation17 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CONVERSATION_MUTE_MEMBER", 22, 40022, "com.avoscloud.v2.im.conversation.muteMember");
        CONVERSATION_MUTE_MEMBER = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray7 = conversation$AVIMOperationArray;
        CONVERSATION_UNMUTE_MEMBER = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_UNMUTE_MEMBER", 23, 40023, "com.avoscloud.v2.im.conversation.unmuteMember");
        Conversation$AVIMOperation conversation$AVIMOperation18 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CONVERSATION_BLOCK_MEMBER", 24, 40024, "com.avoscloud.v2.im.conversation.blockMember");
        CONVERSATION_BLOCK_MEMBER = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray8 = conversation$AVIMOperationArray;
        CONVERSATION_UNBLOCK_MEMBER = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_UNBLOCK_MEMBER", 25, 40025, "com.avoscloud.v2.im.conversation.unblockMember");
        Conversation$AVIMOperation conversation$AVIMOperation19 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("CONVERSATION_MUTED_MEMBER_QUERY", 26, 40026, "com.avoscloud.v2.im.conversation.mutedMemberQuery");
        CONVERSATION_MUTED_MEMBER_QUERY = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray9 = conversation$AVIMOperationArray;
        CONVERSATION_BLOCKED_MEMBER_QUERY = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_BLOCKED_MEMBER_QUERY", 27, 40027, "com.avoscloud.v2.im.conversation.blockedMemberQuery");
        Conversation$AVIMOperation conversation$AVIMOperation20 = conversation$AVIMOperation;
        conversation$AVIMOperationArray = new Conversation$AVIMOperation("LIVEQUERY_LOGIN", 28, 40030, "com.avoscloud.v2.im.livequery.login");
        LIVEQUERY_LOGIN = conversation$AVIMOperationArray;
        Conversation$AVIMOperation[] conversation$AVIMOperationArray10 = conversation$AVIMOperationArray;
        CONVERSATION_UNKNOWN = conversation$AVIMOperation = new Conversation$AVIMOperation("CONVERSATION_UNKNOWN", 29, 49999, "com.avoscloud.v2.im.conversation.unknown");
        conversation$AVIMOperationArray = new Conversation$AVIMOperation[]{conversation$AVIMOperation11, conversation$AVIMOperation10, conversation$AVIMOperation9, conversation$AVIMOperation8, object, conversation$AVIMOperation7, conversation$AVIMOperation6, conversation$AVIMOperation5, conversation$AVIMOperation4, conversation$AVIMOperation3, conversation$AVIMOperation2, conversation$AVIMOperation12, conversation$AVIMOperationArray2, conversation$AVIMOperation13, conversation$AVIMOperationArray3, conversation$AVIMOperation14, conversation$AVIMOperationArray4, conversation$AVIMOperation15, conversation$AVIMOperationArray5, conversation$AVIMOperation16, conversation$AVIMOperationArray6, conversation$AVIMOperation17, conversation$AVIMOperationArray7, conversation$AVIMOperation18, conversation$AVIMOperationArray8, conversation$AVIMOperation19, conversation$AVIMOperationArray9, conversation$AVIMOperation20, conversation$AVIMOperationArray10, conversation$AVIMOperation};
        $VALUES = conversation$AVIMOperationArray;
    }

    /*
     * WARNING - void declaration
     */
    private Conversation$AVIMOperation() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
        this.header = var4_2;
    }

    public static Conversation$AVIMOperation getAVIMOperation(int n10) {
        switch (n10) {
            default: {
                return CONVERSATION_UNKNOWN;
            }
            case 40030: {
                return LIVEQUERY_LOGIN;
            }
            case 40027: {
                return CONVERSATION_BLOCKED_MEMBER_QUERY;
            }
            case 40026: {
                return CONVERSATION_MUTED_MEMBER_QUERY;
            }
            case 40025: {
                return CONVERSATION_UNBLOCK_MEMBER;
            }
            case 40024: {
                return CONVERSATION_BLOCK_MEMBER;
            }
            case 40023: {
                return CONVERSATION_UNMUTE_MEMBER;
            }
            case 40022: {
                return CONVERSATION_MUTE_MEMBER;
            }
            case 40021: {
                return CONVERSATION_PROMOTE_MEMBER;
            }
            case 40020: {
                return CLIENT_REFRESH_TOKEN;
            }
            case 40019: {
                return CONVERSATION_RECALL_MESSAGE;
            }
            case 40018: {
                return CONVERSATION_UPDATE_MESSAGE;
            }
            case 40017: {
                return CONVERSATION_FETCH_RECEIPT_TIME;
            }
            case 40016: {
                return CONVERSATION_READ;
            }
            case 40015: {
                return CLIENT_STATUS;
            }
            case 40014: {
                return CLIENT_ONLINE_QUERY;
            }
            case 40013: {
                return CONVERSATION_MEMBER_COUNT_QUERY;
            }
            case 40012: {
                return CONVERSATION_UNMUTE;
            }
            case 40011: {
                return CONVERSATION_MUTE;
            }
            case 40010: {
                return CONVERSATION_MESSAGE_QUERY;
            }
            case 40009: {
                return CONVERSATION_UPDATE;
            }
            case 40008: {
                return CONVERSATION_QUERY;
            }
            case 40007: {
                return CLIENT_DISCONNECT;
            }
            case 40006: {
                return CLIENT_OPEN;
            }
            case 40005: {
                return CONVERSATION_SEND_MESSAGE;
            }
            case 40004: {
                return CONVERSATION_QUIT;
            }
            case 40003: {
                return CONVERSATION_JOIN;
            }
            case 40002: {
                return CONVERSATION_RM_MEMBER;
            }
            case 40001: {
                return CONVERSATION_ADD_MEMBER;
            }
            case 40000: 
        }
        return CONVERSATION_CREATION;
    }

    public static Conversation$AVIMOperation valueOf(String string2) {
        return Enum.valueOf(Conversation$AVIMOperation.class, string2);
    }

    public static Conversation$AVIMOperation[] values() {
        return (Conversation$AVIMOperation[])$VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    public String getOperation() {
        return this.header;
    }
}

