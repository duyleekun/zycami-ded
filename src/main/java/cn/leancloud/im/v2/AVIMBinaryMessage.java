/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMMessage;
import java.util.Arrays;

public class AVIMBinaryMessage
extends AVIMMessage {
    public AVIMBinaryMessage() {
    }

    public AVIMBinaryMessage(String string2, String string3) {
        super(string2, string3);
    }

    public AVIMBinaryMessage(String string2, String string3, long l10, long l11) {
        super(string2, string3, l10, l11);
    }

    public AVIMBinaryMessage(String string2, String string3, long l10, long l11, long l12) {
        super(string2, string3, l10, l11, l12);
    }

    public static AVIMBinaryMessage createInstanceFromMessage(AVIMMessage aVIMMessage) {
        long l10;
        boolean bl2;
        Object object;
        if (aVIMMessage == null) {
            return null;
        }
        AVIMBinaryMessage aVIMBinaryMessage = new AVIMBinaryMessage();
        aVIMBinaryMessage.conversationId = object = aVIMMessage.conversationId;
        aVIMBinaryMessage.currentClient = object = aVIMMessage.currentClient;
        aVIMBinaryMessage.from = object = aVIMMessage.from;
        object = aVIMMessage.ioType;
        aVIMBinaryMessage.ioType = object;
        object = aVIMMessage.mentionList;
        aVIMBinaryMessage.mentionList = object;
        aVIMBinaryMessage.mentionAll = bl2 = aVIMMessage.mentionAll;
        aVIMBinaryMessage.messageId = object = aVIMMessage.messageId;
        aVIMBinaryMessage.uniqueToken = object = aVIMMessage.uniqueToken;
        object = aVIMMessage.status;
        aVIMBinaryMessage.status = object;
        aVIMBinaryMessage.deliveredAt = l10 = aVIMMessage.deliveredAt;
        aVIMBinaryMessage.readAt = l10 = aVIMMessage.readAt;
        aVIMBinaryMessage.timestamp = l10 = aVIMMessage.timestamp;
        aVIMBinaryMessage.updateAt = l10 = aVIMMessage.updateAt;
        return aVIMBinaryMessage;
    }

    public boolean equals(Object object) {
        boolean bl2 = super.equals(object);
        if (!bl2) {
            return false;
        }
        byte[] byArray = this.bytes;
        object = ((AVIMBinaryMessage)object).bytes;
        return Arrays.equals(byArray, (byte[])object);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public int hashCode() {
        int n10 = super.hashCode();
        byte[] byArray = this.bytes;
        if (byArray != null) {
            n10 *= 31;
            int n11 = byArray.hashCode();
            n10 += n11;
        }
        return n10;
    }

    public void setBytes(byte[] byArray) {
        this.bytes = byArray;
    }
}

