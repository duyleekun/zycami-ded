/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import com.google.common.util.concurrent.CycleDetectingLockFactory$WithExplicitOrdering;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class CycleDetectingLockFactory {
    private static final ThreadLocal acquiredLocks;
    private static final ConcurrentMap lockGraphNodesPerType;
    private static final Logger logger;
    public final CycleDetectingLockFactory$Policy policy;

    static {
        Object object = new MapMaker();
        lockGraphNodesPerType = ((MapMaker)object).weakKeys().makeMap();
        logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        acquiredLocks = object = new CycleDetectingLockFactory$1();
    }

    private CycleDetectingLockFactory(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        this.policy = cycleDetectingLockFactory$Policy = (CycleDetectingLockFactory$Policy)Preconditions.checkNotNull(cycleDetectingLockFactory$Policy);
    }

    public /* synthetic */ CycleDetectingLockFactory(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory$Policy);
    }

    private void aboutToAcquire(CycleDetectingLockFactory$CycleDetectingLock object) {
        boolean bl2 = object.isAcquiredByCurrentThread();
        if (!bl2) {
            ArrayList arrayList = (ArrayList)acquiredLocks.get();
            object = object.getLockGraphNode();
            CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy = this.policy;
            ((CycleDetectingLockFactory$LockGraphNode)object).checkAcquiredLocks(cycleDetectingLockFactory$Policy, arrayList);
            arrayList.add(object);
        }
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ void access$600(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        cycleDetectingLockFactory.aboutToAcquire(cycleDetectingLockFactory$CycleDetectingLock);
    }

    public static /* synthetic */ void access$700(CycleDetectingLockFactory$CycleDetectingLock cycleDetectingLockFactory$CycleDetectingLock) {
        CycleDetectingLockFactory.lockStateChanged(cycleDetectingLockFactory$CycleDetectingLock);
    }

    public static Map createNodes(Class object) {
        Object object2;
        int n10;
        Object object3;
        EnumMap enumMap = Maps.newEnumMap((Class)object);
        object = (Enum[])((Class)object).getEnumConstants();
        int n11 = ((Enum[])object).length;
        ArrayList arrayList = Lists.newArrayListWithCapacity(n11);
        int n12 = ((Enum[])object).length;
        int n13 = 0;
        Object object4 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            object3 = object[i10];
            String string2 = CycleDetectingLockFactory.getLockName((Enum)object3);
            CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = new CycleDetectingLockFactory$LockGraphNode(string2);
            arrayList.add(cycleDetectingLockFactory$LockGraphNode);
            enumMap.put(object3, cycleDetectingLockFactory$LockGraphNode);
        }
        for (n10 = 1; n10 < n11; ++n10) {
            object2 = (CycleDetectingLockFactory$LockGraphNode)arrayList.get(n10);
            object4 = CycleDetectingLockFactory$Policies.THROW;
            object3 = arrayList.subList(0, n10);
            ((CycleDetectingLockFactory$LockGraphNode)object2).checkAcquiredLocks((CycleDetectingLockFactory$Policy)object4, (List)object3);
        }
        while (n13 < (n10 = n11 + -1)) {
            object = (CycleDetectingLockFactory$LockGraphNode)arrayList.get(n13);
            object2 = CycleDetectingLockFactory$Policies.DISABLED;
            object4 = arrayList.subList(++n13, n11);
            ((CycleDetectingLockFactory$LockGraphNode)object).checkAcquiredLocks((CycleDetectingLockFactory$Policy)object2, (List)object4);
        }
        return Collections.unmodifiableMap(enumMap);
    }

    private static String getLockName(Enum object) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ((Enum)object).getDeclaringClass().getSimpleName();
        stringBuilder.append(string2);
        stringBuilder.append(".");
        object = ((Enum)object).name();
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private static Map getOrCreateNodes(Class clazz) {
        ConcurrentMap concurrentMap = lockGraphNodesPerType;
        Map map = (Map)concurrentMap.get(clazz);
        if (map != null) {
            return map;
        }
        map = CycleDetectingLockFactory.createNodes(clazz);
        return (Map)MoreObjects.firstNonNull(concurrentMap.putIfAbsent(clazz, map), map);
    }

    private static void lockStateChanged(CycleDetectingLockFactory$CycleDetectingLock object) {
        boolean bl2 = object.isAcquiredByCurrentThread();
        if (!bl2) {
            ArrayList arrayList = (ArrayList)acquiredLocks.get();
            object = object.getLockGraphNode();
            for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
                Object e10 = arrayList.get(i10);
                if (e10 != object) continue;
                arrayList.remove(i10);
                break;
            }
        }
    }

    public static CycleDetectingLockFactory newInstance(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        CycleDetectingLockFactory cycleDetectingLockFactory = new CycleDetectingLockFactory(cycleDetectingLockFactory$Policy);
        return cycleDetectingLockFactory;
    }

    public static CycleDetectingLockFactory$WithExplicitOrdering newInstanceWithExplicitOrdering(Class object, CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(cycleDetectingLockFactory$Policy);
        object = CycleDetectingLockFactory.getOrCreateNodes((Class)object);
        CycleDetectingLockFactory$WithExplicitOrdering cycleDetectingLockFactory$WithExplicitOrdering = new CycleDetectingLockFactory$WithExplicitOrdering(cycleDetectingLockFactory$Policy, (Map)object);
        return cycleDetectingLockFactory$WithExplicitOrdering;
    }

    public ReentrantLock newReentrantLock(String string2) {
        return this.newReentrantLock(string2, false);
    }

    public ReentrantLock newReentrantLock(String object, boolean bl2) {
        Object object2 = this.policy;
        Object object3 = CycleDetectingLockFactory$Policies.DISABLED;
        if (object2 == object3) {
            object = new ReentrantLock(bl2);
        } else {
            object3 = new CycleDetectingLockFactory$LockGraphNode((String)object);
            object = object2 = new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, (CycleDetectingLockFactory$LockGraphNode)object3, bl2, null);
        }
        return object;
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String string2) {
        return this.newReentrantReadWriteLock(string2, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String object, boolean bl2) {
        Object object2 = this.policy;
        Object object3 = CycleDetectingLockFactory$Policies.DISABLED;
        if (object2 == object3) {
            object = new ReentrantReadWriteLock(bl2);
        } else {
            object3 = new CycleDetectingLockFactory$LockGraphNode((String)object);
            object = object2 = new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, (CycleDetectingLockFactory$LockGraphNode)object3, bl2, null);
        }
        return object;
    }
}

