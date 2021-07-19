/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.os.Handler
 *  android.os.Message
 */
package com.baidu.location.f;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f;
import java.lang.ref.WeakReference;

public class f$e
extends Handler {
    public WeakReference a;
    public com.baidu.location.f.f b;

    public f$e(com.baidu.location.f.f f10) {
        WeakReference<com.baidu.location.f.f> weakReference;
        this.a = weakReference = new WeakReference<com.baidu.location.f.f>(f10);
    }

    public void handleMessage(Message message) {
        block4: {
            com.baidu.location.f.f f10;
            block2: {
                String string2;
                block5: {
                    block3: {
                        boolean bl2 = f.isServing;
                        if (!bl2) {
                            return;
                        }
                        this.b = f10 = (com.baidu.location.f.f)this.a.get();
                        if (f10 == null) {
                            return;
                        }
                        int n10 = message.what;
                        int n11 = 1;
                        if (n10 == n11) break block2;
                        n11 = 3;
                        if (n10 == n11) break block3;
                        n11 = 4;
                        if (n10 != n11) break block4;
                        message = (Location)message.obj;
                        string2 = "&og=2";
                        break block5;
                    }
                    message = (Location)message.obj;
                    string2 = "&og=1";
                }
                com.baidu.location.f.f.a(f10, string2, (Location)message);
                break block4;
            }
            message = (Location)message.obj;
            com.baidu.location.f.f.a(f10, (Location)message);
        }
    }
}

