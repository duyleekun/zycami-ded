/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.b;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public final class a$1
extends Thread {
    public void run() {
        b b10 = b.a();
        try {
            b10.b();
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "CheckAppKeyAsyn verify the appkey catch ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(string3, objectArray);
        }
    }
}

