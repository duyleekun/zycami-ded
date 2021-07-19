/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.MobSDK$3$1;
import com.mob.OperationCallback;
import com.mob.commons.a;
import com.mob.tools.MobLog;
import com.mob.tools.utils.UIHandler;

public final class MobSDK$3
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ OperationCallback b;

    public MobSDK$3(boolean bl2, OperationCallback operationCallback) {
        this.a = bl2;
        this.b = operationCallback;
    }

    public void run() {
        block4: {
            boolean bl2 = this.a;
            OperationCallback operationCallback = this.b;
            try {
                com.mob.commons.a.a(bl2, operationCallback);
            }
            catch (Throwable throwable) {
                MobLog.getInstance().e(throwable);
                operationCallback = this.b;
                if (operationCallback == null) break block4;
                operationCallback = null;
                MobSDK$3$1 mobSDK$3$1 = new MobSDK$3$1(this, throwable);
                UIHandler.sendEmptyMessage(0, mobSDK$3$1);
            }
        }
    }
}

