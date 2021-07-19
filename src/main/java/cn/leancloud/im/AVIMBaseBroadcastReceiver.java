/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package cn.leancloud.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.leancloud.AVException;
import cn.leancloud.AVOSCloud;
import cn.leancloud.callback.AVCallback;
import java.util.HashMap;
import java.util.Map;

public abstract class AVIMBaseBroadcastReceiver
extends BroadcastReceiver {
    public AVCallback callback;

    public AVIMBaseBroadcastReceiver(AVCallback aVCallback) {
        this.callback = aVCallback;
    }

    public abstract void execute(Map var1, Throwable var2);

    public void onReceive(Context object, Intent object2) {
        block16: {
            Object object3;
            block15: {
                block14: {
                    object = "callbackException";
                    if (object2 != null) {
                        object3 = object2.getExtras();
                        if (object3 == null) break block14;
                        object3 = object2.getExtras();
                        boolean bl2 = object3.containsKey((String)object);
                        if (!bl2) break block14;
                        object3 = object2.getExtras();
                        object = object3.getSerializable((String)object);
                        object = (Throwable)object;
                        break block15;
                    }
                }
                object = null;
            }
            object3 = "callbackHashMap";
            object2 = object2.getSerializableExtra((String)object3);
            object2 = (HashMap)object2;
            this.execute((Map)object2, (Throwable)object);
            object = AVOSCloud.getContext();
            if (object == null) break block16;
            object = AVOSCloud.getContext();
            object = LocalBroadcastManager.getInstance((Context)object);
            try {
                ((LocalBroadcastManager)object).unregisterReceiver(this);
            }
            catch (Exception exception) {
                object2 = this.callback;
                if (object2 == null) break block16;
                object3 = new AVException(exception);
                ((AVCallback)object2).internalDone(null, (AVException)object3);
            }
        }
    }
}

