/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.utils.StringUtil;

public class CommandPacket {
    public static final int UNSUPPORTED_OPERATION = 0xFEFFFF;
    private String appId;
    private String cmd;
    private String installationId;
    private int requestId = -65537;

    public String getAppId() {
        return this.appId;
    }

    public String getCmd() {
        return this.cmd;
    }

    public Messages$GenericCommand getGenericCommand() {
        return this.getGenericCommandBuilder().build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        int n10;
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = Messages$GenericCommand.newBuilder();
        Object object = this.appId;
        int n11 = StringUtil.isEmpty((String)object);
        if (n11 == 0) {
            object = this.appId;
            messages$GenericCommand$Builder.setAppId((String)object);
        }
        object = Messages$CommandType.valueOf(this.getCmd());
        messages$GenericCommand$Builder.setCmd((Messages$CommandType)object);
        object = this.getInstallationId();
        if (object != null) {
            object = this.getInstallationId();
            messages$GenericCommand$Builder.setInstallationId((String)object);
        }
        if ((n11 = this.requestId) > (n10 = -65537)) {
            messages$GenericCommand$Builder.setI(n11);
        }
        return messages$GenericCommand$Builder;
    }

    public String getInstallationId() {
        return this.installationId;
    }

    public int getLength() {
        return this.getGenericCommandBuilder().build().getSerializedSize();
    }

    public int getRequestId() {
        return this.requestId;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setCmd(String string2) {
        this.cmd = string2;
    }

    public void setInstallationId(String string2) {
        this.installationId = string2;
    }

    public void setRequestId(int n10) {
        this.requestId = n10;
    }
}

