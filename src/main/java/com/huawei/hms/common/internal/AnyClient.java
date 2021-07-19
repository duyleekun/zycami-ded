/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.AnyClient$CallBack;
import com.huawei.hms.core.aidl.IMessageEntity;

public interface AnyClient {
    public void connect(int var1);

    public void connect(int var1, boolean var2);

    public void disconnect();

    public String getSessionId();

    public boolean isConnected();

    public boolean isConnecting();

    public void post(IMessageEntity var1, String var2, AnyClient$CallBack var3);
}

