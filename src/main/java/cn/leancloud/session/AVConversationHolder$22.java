/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.v2.Conversation$AVIMOperation;

public class AVConversationHolder$22 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Conversation$AVIMOperation conversation$AVIMOperation;
        int n12 = Conversation$AVIMOperation.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation = nArray;
        try {
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_JOIN;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_RM_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_QUIT;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UPDATE;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTE;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNMUTE;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MEMBER_COUNT_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_FETCH_RECEIPT_TIME;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_READ;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_PROMOTE_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTE_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNMUTE_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCK_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNBLOCK_MEMBER;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 18;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

