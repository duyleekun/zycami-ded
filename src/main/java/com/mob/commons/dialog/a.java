/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog;

import com.mob.OperationCallback;
import com.mob.commons.MobProduct;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class a {
    private static a a;
    private MobProduct b;

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        Object object = a;
        if (object != null) return a;
        object = a.class;
        synchronized (object) {
            a a10 = a;
            if (a10 != null) return a;
            a = a10 = new a();
            return a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(MobProduct object, InternalPolicyUi object2, OperationCallback operationCallback) {
        object2 = Boolean.TRUE;
        try {
            NLog nLog = MobLog.getInstance();
            CharSequence charSequence = "canIContinueBusiness()";
            Object[] objectArray = null;
            Object[] objectArray2 = new Object[]{};
            nLog.d(charSequence, objectArray2);
            this.b = object;
            boolean bl2 = com.mob.commons.a.c();
            nLog = MobLog.getInstance();
            charSequence = new StringBuilder();
            String string2 = "====> ppNece: ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(bl2);
            charSequence = ((StringBuilder)charSequence).toString();
            Object[] objectArray3 = new Object[]{};
            nLog.d(charSequence, objectArray3);
            if (!bl2) {
                if (operationCallback == null) return;
                operationCallback.onComplete(object2);
                return;
            }
            bl2 = com.mob.commons.a.d();
            nLog = MobLog.getInstance();
            charSequence = new StringBuilder();
            String string3 = "====> ppGrtd: ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(bl2);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray = new Object[]{};
            nLog.d(charSequence, objectArray);
            if (bl2) {
                if (operationCallback == null) return;
                operationCallback.onComplete(object2);
                return;
            }
            if (operationCallback == null) return;
            object = Boolean.FALSE;
            operationCallback.onComplete(object);
            return;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).e(throwable);
            if (operationCallback == null) return;
            operationCallback.onFailure(throwable);
        }
    }
}

