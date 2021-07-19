/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$WithExplicitOrdering;
import java.util.Arrays;

public class CycleDetectingLockFactory$ExampleStackTrace
extends IllegalStateException {
    public static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    public static final ImmutableSet EXCLUDED_CLASS_NAMES;

    static {
        String string2 = CycleDetectingLockFactory.class.getName();
        String string3 = CycleDetectingLockFactory$ExampleStackTrace.class.getName();
        String string4 = CycleDetectingLockFactory$LockGraphNode.class.getName();
        EXCLUDED_CLASS_NAMES = ImmutableSet.of(string2, string3, string4);
    }

    public CycleDetectingLockFactory$ExampleStackTrace(CycleDetectingLockFactory$LockGraphNode stackTraceElementArray, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode) {
        StringBuilder stringBuilder = new StringBuilder();
        stackTraceElementArray = stackTraceElementArray.getLockName();
        stringBuilder.append((String)stackTraceElementArray);
        stringBuilder.append(" -> ");
        stackTraceElementArray = cycleDetectingLockFactory$LockGraphNode.getLockName();
        stringBuilder.append((String)stackTraceElementArray);
        stackTraceElementArray = stringBuilder.toString();
        super((String)stackTraceElementArray);
        stackTraceElementArray = this.getStackTrace();
        int n10 = stackTraceElementArray.length;
        stringBuilder = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            Object object = CycleDetectingLockFactory.WithExplicitOrdering.class.getName();
            boolean bl2 = ((String)object).equals(string2 = stackTraceElementArray[i10].getClassName());
            if (bl2) {
                stackTraceElementArray = EMPTY_STACK_TRACE;
                this.setStackTrace(stackTraceElementArray);
                break;
            }
            object = EXCLUDED_CLASS_NAMES;
            string2 = stackTraceElementArray[i10].getClassName();
            bl2 = ((ImmutableCollection)object).contains(string2);
            if (bl2) continue;
            stackTraceElementArray = Arrays.copyOfRange(stackTraceElementArray, i10, n10);
            this.setStackTrace(stackTraceElementArray);
            break;
        }
    }
}

