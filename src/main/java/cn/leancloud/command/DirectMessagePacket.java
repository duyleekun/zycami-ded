/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$DirectCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.utils.StringUtil;
import java.util.Collection;

public class DirectMessagePacket
extends PeerBasedCommandPacket {
    private String msg;
    private boolean receipt;
    private String roomId;
    private Collection toPeerIds;
    private boolean transi;

    public DirectMessagePacket() {
        this.setCmd("direct");
    }

    public Messages$DirectCommand getDirectCommand() {
        boolean bl2;
        Messages$DirectCommand$Builder messages$DirectCommand$Builder = Messages$DirectCommand.newBuilder();
        Object object = this.getMsg();
        messages$DirectCommand$Builder.setMsg((String)object);
        object = this.getToPeerIds();
        if (object != null && !(bl2 = (object = this.getToPeerIds()).isEmpty())) {
            object = this.getToPeerIds();
            messages$DirectCommand$Builder.addAllToPeerIds((Iterable)object);
        }
        if (bl2 = this.receipt) {
            bl2 = true;
            messages$DirectCommand$Builder.setR(bl2);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.getGroupId())))) {
            object = this.getGroupId();
            messages$DirectCommand$Builder.setRoomId((String)object);
        }
        if (bl2 = this.isTransient()) {
            bl2 = this.isTransient();
            messages$DirectCommand$Builder.setTransient(bl2);
        }
        return messages$DirectCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Messages$DirectCommand messages$DirectCommand = this.getDirectCommand();
        messages$GenericCommand$Builder.setDirectMessage(messages$DirectCommand);
        return messages$GenericCommand$Builder;
    }

    public String getGroupId() {
        return this.roomId;
    }

    public String getMsg() {
        return this.msg;
    }

    public Collection getToPeerIds() {
        return this.toPeerIds;
    }

    public boolean isReceipt() {
        return this.receipt;
    }

    public boolean isTransient() {
        return this.transi;
    }

    public void setGroupId(String string2) {
        this.roomId = string2;
    }

    public void setMsg(String string2) {
        this.msg = string2;
    }

    public void setReceipt(boolean bl2) {
        this.receipt = bl2;
    }

    public void setToPeerIds(Collection collection) {
        this.toPeerIds = collection;
    }

    public void setTransient(boolean bl2) {
        this.transi = bl2;
    }
}

