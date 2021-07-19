/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.command.LoginPacket;
import cn.leancloud.utils.StringUtil;

public class LiveQueryLoginPacket
extends LoginPacket {
    public static final int SERVICE_LIVE_QUERY = 1;
    public static final int SERVICE_PUSH;
    private long clientTs = 0L;
    private String subscribeId;

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        String string2 = this.subscribeId;
        int n10 = (int)(StringUtil.isEmpty(string2) ? 1 : 0);
        if (n10 == 0) {
            string2 = this.subscribeId;
            messages$GenericCommand$Builder.setInstallationId(string2);
            long l10 = this.clientTs;
            messages$GenericCommand$Builder.setClientTs(l10);
            n10 = 1;
            messages$GenericCommand$Builder.setService(n10);
        }
        return messages$GenericCommand$Builder;
    }

    public void setClientTs(long l10) {
        this.clientTs = l10;
    }

    public void setSubscribeId(String string2) {
        this.subscribeId = string2;
    }
}

