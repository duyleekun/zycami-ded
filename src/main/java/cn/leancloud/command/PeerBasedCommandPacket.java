/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.CommandPacket;

public class PeerBasedCommandPacket
extends CommandPacket {
    private String peerId;

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        String string2 = this.getPeerId();
        if (string2 != null) {
            string2 = this.getPeerId();
            messages$GenericCommand$Builder.setPeerId(string2);
        }
        return messages$GenericCommand$Builder;
    }

    public String getPeerId() {
        return this.peerId;
    }

    public void setPeerId(String string2) {
        this.peerId = string2;
    }
}

