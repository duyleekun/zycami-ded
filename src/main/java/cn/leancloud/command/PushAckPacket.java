/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.CommandPacket;
import java.util.List;

public class PushAckPacket
extends CommandPacket {
    public List ids;

    public PushAckPacket() {
        this.setCmd("ack");
    }

    public Messages$AckCommand getAckCommand() {
        Messages$AckCommand$Builder messages$AckCommand$Builder = Messages$AckCommand.newBuilder();
        List list = this.ids;
        messages$AckCommand$Builder.addAllIds(list);
        return messages$AckCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Messages$AckCommand messages$AckCommand = this.getAckCommand();
        messages$GenericCommand$Builder.setAckMessage(messages$AckCommand);
        return messages$GenericCommand$Builder;
    }

    public void setMessageIds(List list) {
        this.ids = list;
    }
}

