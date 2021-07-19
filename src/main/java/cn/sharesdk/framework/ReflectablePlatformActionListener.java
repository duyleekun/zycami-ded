/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

public class ReflectablePlatformActionListener
implements PlatformActionListener {
    private int a;
    private Handler.Callback b;
    private int c;
    private Handler.Callback d;
    private int e;
    private Handler.Callback f;

    public void onCancel(Platform platform, int n10) {
        Handler.Callback callback = this.f;
        if (callback != null) {
            int n11;
            callback = new Message();
            callback.what = n11 = this.e;
            n11 = 2;
            Object[] objectArray = new Object[n11];
            objectArray[0] = platform;
            int n12 = 1;
            Integer n13 = n10;
            objectArray[n12] = n13;
            callback.obj = objectArray;
            platform = this.f;
            UIHandler.sendMessage((Message)callback, (Handler.Callback)platform);
        }
    }

    public void onComplete(Platform platform, int n10, HashMap hashMap) {
        Handler.Callback callback = this.b;
        if (callback != null) {
            int n11;
            callback = new Message();
            callback.what = n11 = this.a;
            n11 = 3;
            Object[] objectArray = new Object[n11];
            objectArray[0] = platform;
            Integer n12 = n10;
            objectArray[1] = n12;
            int n13 = 2;
            objectArray[n13] = hashMap;
            callback.obj = objectArray;
            platform = this.b;
            UIHandler.sendMessage((Message)callback, (Handler.Callback)platform);
        }
    }

    public void onError(Platform platform, int n10, Throwable throwable) {
        Handler.Callback callback = this.d;
        if (callback != null) {
            int n11;
            callback = new Message();
            callback.what = n11 = this.c;
            n11 = 3;
            Object[] objectArray = new Object[n11];
            objectArray[0] = platform;
            Integer n12 = n10;
            objectArray[1] = n12;
            int n13 = 2;
            objectArray[n13] = throwable;
            callback.obj = objectArray;
            platform = this.d;
            UIHandler.sendMessage((Message)callback, (Handler.Callback)platform);
        }
    }

    public void setOnCancelCallback(int n10, Handler.Callback callback) {
        this.e = n10;
        this.f = callback;
    }

    public void setOnCompleteCallback(int n10, Handler.Callback callback) {
        this.a = n10;
        this.b = callback;
    }

    public void setOnErrorCallback(int n10, Handler.Callback callback) {
        this.c = n10;
        this.d = callback;
    }
}

