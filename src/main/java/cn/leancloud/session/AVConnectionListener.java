/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$GenericCommand;

public interface AVConnectionListener {
    public void onError(Integer var1, Messages.ErrorCommand var2);

    public void onMessageArriving(String var1, Integer var2, Messages$GenericCommand var3);

    public void onWebSocketClose();

    public void onWebSocketOpen();
}

