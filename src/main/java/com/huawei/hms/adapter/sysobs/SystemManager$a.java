/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemNotifier;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import java.util.ArrayList;
import java.util.List;

public final class SystemManager$a
implements SystemNotifier {
    public final List a;

    public SystemManager$a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyObservers(int n10) {
        Object object = SystemManager.a();
        synchronized (object) {
            Object object2 = this.a;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                bl2 = (object3 = (SystemObserver)object3).onUpdateResult(n10);
                if (!bl2) continue;
                object2.remove();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyObservers(Intent intent, String string2) {
        Object object = SystemManager.a();
        synchronized (object) {
            Object object2 = this.a;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                bl2 = (object3 = (SystemObserver)object3).onSolutionResult(intent, string2);
                if (!bl2) continue;
                object2.remove();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerObserver(SystemObserver systemObserver) {
        if (systemObserver == null) {
            return;
        }
        Object object = this.a;
        boolean bl2 = object.contains(systemObserver);
        if (bl2) return;
        object = SystemManager.a();
        synchronized (object) {
            List list = this.a;
            list.add(systemObserver);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unRegisterObserver(SystemObserver systemObserver) {
        Object object = SystemManager.a();
        synchronized (object) {
            List list = this.a;
            list.remove(systemObserver);
            return;
        }
    }
}

