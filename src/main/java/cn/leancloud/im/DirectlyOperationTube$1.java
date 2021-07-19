/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.v2.Conversation$AVIMOperation;

public class DirectlyOperationTube$1 {
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
            conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_OPEN;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_DISCONNECT;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_REFRESH_TOKEN;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_ONLINE_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UPDATE_MESSAGE;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_RECALL_MESSAGE;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_CREATION;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_SEND_MESSAGE;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MEMBER_COUNT_QUERY;
            n11 = conversation$AVIMOperation.ordinal();
            nArray[n11] = n10 = 13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

