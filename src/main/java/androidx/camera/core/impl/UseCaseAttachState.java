/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$ValidatingBuilder;
import androidx.camera.core.impl.UseCaseAttachState$AttachStateFilter;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;
import b.a.b.w1.m;
import b.a.b.w1.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map mAttachedUseCasesToInfoMap;
    private final String mCameraId;

    public UseCaseAttachState(String string2) {
        HashMap hashMap;
        this.mAttachedUseCasesToInfoMap = hashMap = new HashMap();
        this.mCameraId = string2;
    }

    public static /* synthetic */ boolean a(UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo) {
        boolean bl2;
        boolean bl3 = useCaseAttachState$UseCaseAttachInfo.getActive();
        if (bl3 && (bl2 = useCaseAttachState$UseCaseAttachInfo.getAttached())) {
            bl2 = true;
        } else {
            bl2 = false;
            useCaseAttachState$UseCaseAttachInfo = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean b(UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo) {
        return useCaseAttachState$UseCaseAttachInfo.getAttached();
    }

    private UseCaseAttachState$UseCaseAttachInfo getOrCreateUseCaseAttachInfo(String string2, SessionConfig object) {
        UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo)this.mAttachedUseCasesToInfoMap.get(string2);
        if (useCaseAttachState$UseCaseAttachInfo == null) {
            useCaseAttachState$UseCaseAttachInfo = new UseCaseAttachState$UseCaseAttachInfo((SessionConfig)object);
            object = this.mAttachedUseCasesToInfoMap;
            object.put(string2, useCaseAttachState$UseCaseAttachInfo);
        }
        return useCaseAttachState$UseCaseAttachInfo;
    }

    private Collection getSessionConfigs(UseCaseAttachState$AttachStateFilter useCaseAttachState$AttachStateFilter) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo;
            boolean bl3;
            Object object = iterator2.next();
            if (useCaseAttachState$AttachStateFilter != null && !(bl3 = useCaseAttachState$AttachStateFilter.filter(useCaseAttachState$UseCaseAttachInfo = (UseCaseAttachState$UseCaseAttachInfo)object.getValue()))) continue;
            object = ((UseCaseAttachState$UseCaseAttachInfo)object.getValue()).getSessionConfig();
            arrayList.add(object);
        }
        return arrayList;
    }

    public SessionConfig$ValidatingBuilder getActiveAndAttachedBuilder() {
        boolean bl2;
        SessionConfig$ValidatingBuilder sessionConfig$ValidatingBuilder = new SessionConfig$ValidatingBuilder();
        Object object = new ArrayList();
        Object object2 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            Map.Entry entry = object2.next();
            Object object3 = (UseCaseAttachState$UseCaseAttachInfo)entry.getValue();
            boolean bl3 = ((UseCaseAttachState$UseCaseAttachInfo)object3).getActive();
            if (!bl3 || !(bl3 = ((UseCaseAttachState$UseCaseAttachInfo)object3).getAttached())) continue;
            entry = (String)entry.getKey();
            object3 = ((UseCaseAttachState$UseCaseAttachInfo)object3).getSessionConfig();
            sessionConfig$ValidatingBuilder.add((SessionConfig)object3);
            object.add(entry);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Active and attached use case: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" for camera: ");
        object = this.mCameraId;
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        Logger.d(TAG, (String)object);
        return sessionConfig$ValidatingBuilder;
    }

    public Collection getActiveAndAttachedSessionConfigs() {
        n n10 = n.a;
        return Collections.unmodifiableCollection(this.getSessionConfigs(n10));
    }

    public SessionConfig$ValidatingBuilder getAttachedBuilder() {
        boolean bl2;
        SessionConfig$ValidatingBuilder sessionConfig$ValidatingBuilder = new SessionConfig$ValidatingBuilder();
        Object object = new ArrayList();
        Object object2 = this.mAttachedUseCasesToInfoMap.entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            Map.Entry entry = object2.next();
            Object object3 = (UseCaseAttachState$UseCaseAttachInfo)entry.getValue();
            boolean bl3 = ((UseCaseAttachState$UseCaseAttachInfo)object3).getAttached();
            if (!bl3) continue;
            object3 = ((UseCaseAttachState$UseCaseAttachInfo)object3).getSessionConfig();
            sessionConfig$ValidatingBuilder.add((SessionConfig)object3);
            entry = (String)entry.getKey();
            object.add(entry);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("All use case: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" for camera: ");
        object = this.mCameraId;
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        Logger.d(TAG, (String)object);
        return sessionConfig$ValidatingBuilder;
    }

    public Collection getAttachedSessionConfigs() {
        m m10 = m.a;
        return Collections.unmodifiableCollection(this.getSessionConfigs(m10));
    }

    public boolean isUseCaseAttached(String string2) {
        Map map = this.mAttachedUseCasesToInfoMap;
        boolean bl2 = map.containsKey(string2);
        if (!bl2) {
            return false;
        }
        return ((UseCaseAttachState$UseCaseAttachInfo)this.mAttachedUseCasesToInfoMap.get(string2)).getAttached();
    }

    public void removeUseCase(String string2) {
        this.mAttachedUseCasesToInfoMap.remove(string2);
    }

    public void setUseCaseActive(String string2, SessionConfig sessionConfig) {
        this.getOrCreateUseCaseAttachInfo(string2, sessionConfig).setActive(true);
    }

    public void setUseCaseAttached(String string2, SessionConfig sessionConfig) {
        this.getOrCreateUseCaseAttachInfo(string2, sessionConfig).setAttached(true);
    }

    public void setUseCaseDetached(String string2) {
        Object object = this.mAttachedUseCasesToInfoMap;
        boolean bl2 = object.containsKey(string2);
        if (!bl2) {
            return;
        }
        object = (UseCaseAttachState$UseCaseAttachInfo)this.mAttachedUseCasesToInfoMap.get(string2);
        ((UseCaseAttachState$UseCaseAttachInfo)object).setAttached(false);
        bl2 = ((UseCaseAttachState$UseCaseAttachInfo)object).getActive();
        if (!bl2) {
            object = this.mAttachedUseCasesToInfoMap;
            object.remove(string2);
        }
    }

    public void setUseCaseInactive(String string2) {
        Object object = this.mAttachedUseCasesToInfoMap;
        boolean bl2 = object.containsKey(string2);
        if (!bl2) {
            return;
        }
        object = (UseCaseAttachState$UseCaseAttachInfo)this.mAttachedUseCasesToInfoMap.get(string2);
        ((UseCaseAttachState$UseCaseAttachInfo)object).setActive(false);
        bl2 = ((UseCaseAttachState$UseCaseAttachInfo)object).getAttached();
        if (!bl2) {
            object = this.mAttachedUseCasesToInfoMap;
            object.remove(string2);
        }
    }

    public void updateUseCase(String string2, SessionConfig object) {
        Object object2 = this.mAttachedUseCasesToInfoMap;
        boolean bl2 = object2.containsKey(string2);
        if (!bl2) {
            return;
        }
        object2 = new UseCaseAttachState$UseCaseAttachInfo((SessionConfig)object);
        object = (UseCaseAttachState$UseCaseAttachInfo)this.mAttachedUseCasesToInfoMap.get(string2);
        boolean bl3 = ((UseCaseAttachState$UseCaseAttachInfo)object).getAttached();
        ((UseCaseAttachState$UseCaseAttachInfo)object2).setAttached(bl3);
        boolean bl4 = ((UseCaseAttachState$UseCaseAttachInfo)object).getActive();
        ((UseCaseAttachState$UseCaseAttachInfo)object2).setActive(bl4);
        this.mAttachedUseCasesToInfoMap.put(string2, object2);
    }
}

