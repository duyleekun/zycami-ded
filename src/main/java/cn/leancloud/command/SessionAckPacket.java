/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import java.util.ArrayList;
import java.util.List;

public class SessionAckPacket
extends PeerBasedCommandPacket {
    public List ids;

    public SessionAckPacket() {
        this.setCmd("ack");
    }

    public Messages$AckCommand getAckCommand() {
        int n10;
        Messages$AckCommand$Builder messages$AckCommand$Builder = Messages$AckCommand.newBuilder();
        List list = this.ids;
        if (list != null && (n10 = list.size()) > 0) {
            list = this.ids;
            messages$AckCommand$Builder.addAllIds(list);
        }
        return messages$AckCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Messages$AckCommand messages$AckCommand = this.getAckCommand();
        messages$GenericCommand$Builder.setAckMessage(messages$AckCommand);
        return messages$GenericCommand$Builder;
    }

    public void setMessageId(String string2) {
        ArrayList<String> arrayList;
        this.ids = arrayList = new ArrayList<String>(1);
        arrayList.add(string2);
    }
}

