/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchCommand$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.v2.AVIMClient;

public class MessagePatchModifiedPacket
extends PeerBasedCommandPacket {
    private long lastPatchTime;

    public MessagePatchModifiedPacket() {
        this.setCmd("patch");
    }

    public static MessagePatchModifiedPacket getPatchMessagePacket(String string2, long l10) {
        int n10;
        MessagePatchModifiedPacket messagePatchModifiedPacket = new MessagePatchModifiedPacket();
        int n11 = AVIMClient.getClientsCount();
        if (n11 > (n10 = 1)) {
            messagePatchModifiedPacket.setPeerId(string2);
        }
        messagePatchModifiedPacket.lastPatchTime = l10;
        return messagePatchModifiedPacket;
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = Messages$OpType.modified;
        messages$GenericCommand$Builder.setOp((Messages$OpType)object);
        object = this.getPatchCommand();
        messages$GenericCommand$Builder.setPatchMessage((Messages$PatchCommand)object);
        return messages$GenericCommand$Builder;
    }

    public Messages$PatchCommand getPatchCommand() {
        Messages$PatchCommand$Builder messages$PatchCommand$Builder = Messages$PatchCommand.newBuilder();
        long l10 = this.lastPatchTime;
        messages$PatchCommand$Builder.setLastPatchTime(l10);
        return messages$PatchCommand$Builder.build();
    }
}

