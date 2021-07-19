/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleDetectingLockFactory$LockGraphNode {
    public final Map allowedPriorLocks;
    public final Map disallowedPriorLocks;
    public final String lockName;

    public CycleDetectingLockFactory$LockGraphNode(String string2) {
        Object object = new MapMaker();
        this.allowedPriorLocks = object = ((MapMaker)object).weakKeys().makeMap();
        object = new MapMaker();
        this.disallowedPriorLocks = object = ((MapMaker)object).weakKeys().makeMap();
        this.lockName = string2 = (String)Preconditions.checkNotNull(string2);
    }

    private CycleDetectingLockFactory$ExampleStackTrace findPathTo(CycleDetectingLockFactory$LockGraphNode object, Set stackTraceElementArray) {
        boolean bl2;
        boolean bl3 = stackTraceElementArray.add(this);
        if (!bl3) {
            return null;
        }
        Object object2 = (CycleDetectingLockFactory$ExampleStackTrace)this.allowedPriorLocks.get(object);
        if (object2 != null) {
            return object2;
        }
        object2 = this.allowedPriorLocks.entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            Map.Entry entry = (Map.Entry)object2.next();
            CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = (CycleDetectingLockFactory$LockGraphNode)entry.getKey();
            CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace = cycleDetectingLockFactory$LockGraphNode.findPathTo((CycleDetectingLockFactory$LockGraphNode)object, (Set)stackTraceElementArray);
            if (cycleDetectingLockFactory$ExampleStackTrace == null) continue;
            object = new CycleDetectingLockFactory$ExampleStackTrace(cycleDetectingLockFactory$LockGraphNode, this);
            stackTraceElementArray = ((CycleDetectingLockFactory$ExampleStackTrace)entry.getValue()).getStackTrace();
            ((Throwable)object).setStackTrace(stackTraceElementArray);
            ((Throwable)object).initCause(cycleDetectingLockFactory$ExampleStackTrace);
            return object;
        }
        return null;
    }

    public void checkAcquiredLock(CycleDetectingLockFactory$Policy object, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode) {
        Object object2;
        boolean bl2;
        if (this != cycleDetectingLockFactory$LockGraphNode) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        String string2 = cycleDetectingLockFactory$LockGraphNode.getLockName();
        Object object3 = "Attempted to acquire multiple locks with the same rank %s";
        Preconditions.checkState(bl2, (String)object3, (Object)string2);
        object2 = this.allowedPriorLocks;
        bl2 = object2.containsKey(cycleDetectingLockFactory$LockGraphNode);
        if (bl2) {
            return;
        }
        object2 = (CycleDetectingLockFactory$PotentialDeadlockException)this.disallowedPriorLocks.get(cycleDetectingLockFactory$LockGraphNode);
        string2 = null;
        if (object2 != null) {
            object2 = ((CycleDetectingLockFactory$PotentialDeadlockException)object2).getConflictingStackTrace();
            object3 = new CycleDetectingLockFactory$PotentialDeadlockException(cycleDetectingLockFactory$LockGraphNode, this, (CycleDetectingLockFactory$ExampleStackTrace)object2, null);
            object.handlePotentialDeadlock((CycleDetectingLockFactory$PotentialDeadlockException)object3);
            return;
        }
        object2 = Sets.newIdentityHashSet();
        if ((object2 = cycleDetectingLockFactory$LockGraphNode.findPathTo(this, (Set)object2)) == null) {
            object = this.allowedPriorLocks;
            object2 = new CycleDetectingLockFactory$ExampleStackTrace(cycleDetectingLockFactory$LockGraphNode, this);
            object.put(cycleDetectingLockFactory$LockGraphNode, object2);
        } else {
            object3 = new CycleDetectingLockFactory$PotentialDeadlockException(cycleDetectingLockFactory$LockGraphNode, this, (CycleDetectingLockFactory$ExampleStackTrace)object2, null);
            object2 = this.disallowedPriorLocks;
            object2.put(cycleDetectingLockFactory$LockGraphNode, object3);
            object.handlePotentialDeadlock((CycleDetectingLockFactory$PotentialDeadlockException)object3);
        }
    }

    public void checkAcquiredLocks(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, List list) {
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode = (CycleDetectingLockFactory$LockGraphNode)list.get(i10);
            this.checkAcquiredLock(cycleDetectingLockFactory$Policy, cycleDetectingLockFactory$LockGraphNode);
        }
    }

    public String getLockName() {
        return this.lockName;
    }
}

