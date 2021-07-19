/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.BindResolveClients$1;
import com.huawei.hms.common.internal.BindResolveClients$SingletonManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import java.util.ArrayList;

public class BindResolveClients {
    private static final Object LOCK_INST;
    private ArrayList mClientList;

    static {
        Object object;
        LOCK_INST = object = new Object();
    }

    private BindResolveClients() {
        ArrayList arrayList;
        this.mClientList = arrayList = new ArrayList();
    }

    public /* synthetic */ BindResolveClients(BindResolveClients$1 bindResolveClients$1) {
        this();
    }

    public static BindResolveClients getInstance() {
        return BindResolveClients$SingletonManager.access$100();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        Object object = LOCK_INST;
        synchronized (object) {
            ArrayList arrayList = this.mClientList;
            return arrayList.contains(resolveClientBean);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyClientReconnect() {
        Object object = LOCK_INST;
        synchronized (object) {
            Object object2 = this.mClientList;
            object2 = ((ArrayList)object2).listIterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    object2 = this.mClientList;
                    ((ArrayList)object2).clear();
                    return;
                }
                Object object3 = object2.next();
                object3 = (ResolveClientBean)object3;
                ((ResolveClientBean)object3).clientReconnect();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        Object object = LOCK_INST;
        synchronized (object) {
            ArrayList arrayList = this.mClientList;
            boolean bl2 = arrayList.contains(resolveClientBean);
            if (!bl2) {
                arrayList = this.mClientList;
                arrayList.add(resolveClientBean);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        Object object = LOCK_INST;
        synchronized (object) {
            Object object2 = this.mClientList;
            boolean bl2 = ((ArrayList)object2).contains(resolveClientBean);
            if (bl2) {
                boolean bl3;
                object2 = this.mClientList;
                object2 = ((ArrayList)object2).listIterator();
                while (bl3 = object2.hasNext()) {
                    Object e10 = object2.next();
                    bl3 = resolveClientBean.equals(e10);
                    if (!bl3) continue;
                    object2.remove();
                    break;
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unRegisterAll() {
        Object object = LOCK_INST;
        synchronized (object) {
            ArrayList arrayList = this.mClientList;
            arrayList.clear();
            return;
        }
    }
}

