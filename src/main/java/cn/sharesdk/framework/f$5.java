/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public class f$5
extends Thread {
    public final /* synthetic */ Platform$ShareParams a;
    public final /* synthetic */ f b;

    public f$5(f f10, String string2, Platform$ShareParams platform$ShareParams) {
        this.b = f10;
        this.a = platform$ShareParams;
        super(string2);
    }

    public void run() {
        String string2 = "ShareSDK";
        int n10 = 1;
        Object object = this.b;
        object = f.a((f)object);
        Object[] objectArray = this.a;
        ((Platform)object).subscribeAuth((Platform$ShareParams)objectArray);
        object = SSDKLog.b();
        objectArray = new Object[n10];
        CharSequence charSequence = "subscribeAuth start on PlatformImpl";
        objectArray[0] = charSequence;
        try {
            ((NLog)object).d(string2, objectArray);
        }
        catch (Throwable throwable) {
            objectArray = SSDKLog.b();
            Object[] objectArray2 = new Object[n10];
            charSequence = new StringBuilder();
            String string3 = " subscribeAuth catch ";
            charSequence.append(string3);
            charSequence.append(throwable);
            String string4 = charSequence.toString();
            objectArray2[0] = string4;
            objectArray.d(string2, objectArray2);
        }
    }
}

