/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.OperationCallback;
import com.mob.commons.MobProduct;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.commons.dialog.a;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.tools.MobLog;

public final class MobSDK$5
implements Runnable {
    public final /* synthetic */ MobProduct a;
    public final /* synthetic */ OperationCallback b;
    public final /* synthetic */ InternalPolicyUi c;

    public MobSDK$5(MobProduct mobProduct, OperationCallback operationCallback, InternalPolicyUi internalPolicyUi) {
        this.a = mobProduct;
        this.b = operationCallback;
        this.c = internalPolicyUi;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            Object object;
            Object object2;
            Object object3 = this.a;
            if (object3 == null) {
                object3 = this.b;
                object2 = "MobProduct can not be null";
                object = new PolicyThrowable((String)object2);
                ((OperationCallback)object3).onFailure((Throwable)object);
            }
            object3 = com.mob.commons.dialog.a.a();
            object = this.a;
            object2 = this.c;
            OperationCallback operationCallback = this.b;
            ((a)object3).a((MobProduct)object, (InternalPolicyUi)object2, operationCallback);
            return;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().e(throwable);
            OperationCallback operationCallback = this.b;
            operationCallback.onFailure(throwable);
        }
    }
}

