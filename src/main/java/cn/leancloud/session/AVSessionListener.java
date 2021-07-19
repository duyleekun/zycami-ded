/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.session.AVSession;
import java.util.List;

public abstract class AVSessionListener {
    public void onError(AVSession aVSession, Throwable throwable) {
        this.onError(aVSession, throwable, -1, -65537);
    }

    public abstract void onError(AVSession var1, Throwable var2, int var3, int var4);

    public abstract void onOnlineQuery(AVSession var1, List var2, int var3);

    public abstract void onSessionClose(AVSession var1, int var2);

    public abstract void onSessionClosedFromServer(AVSession var1, int var2);

    public abstract void onSessionOpen(AVSession var1, int var2);

    public abstract void onSessionPaused(AVSession var1);

    public abstract void onSessionResumed(AVSession var1);

    public abstract void onSessionTokenRenewed(AVSession var1, int var2);
}

