/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractService$1;
import com.google.common.util.concurrent.AbstractService$2;
import com.google.common.util.concurrent.AbstractService$3;
import com.google.common.util.concurrent.AbstractService$4;
import com.google.common.util.concurrent.AbstractService$5;
import com.google.common.util.concurrent.AbstractService$6;
import com.google.common.util.concurrent.AbstractService$HasReachedRunningGuard;
import com.google.common.util.concurrent.AbstractService$IsStartableGuard;
import com.google.common.util.concurrent.AbstractService$IsStoppableGuard;
import com.google.common.util.concurrent.AbstractService$IsStoppedGuard;
import com.google.common.util.concurrent.AbstractService$StateSnapshot;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.ListenerCallQueue$Event;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AbstractService
implements Service {
    private static final ListenerCallQueue$Event RUNNING_EVENT;
    private static final ListenerCallQueue$Event STARTING_EVENT;
    private static final ListenerCallQueue$Event STOPPING_FROM_RUNNING_EVENT;
    private static final ListenerCallQueue$Event STOPPING_FROM_STARTING_EVENT;
    private static final ListenerCallQueue$Event TERMINATED_FROM_NEW_EVENT;
    private static final ListenerCallQueue$Event TERMINATED_FROM_RUNNING_EVENT;
    private static final ListenerCallQueue$Event TERMINATED_FROM_STARTING_EVENT;
    private static final ListenerCallQueue$Event TERMINATED_FROM_STOPPING_EVENT;
    private final Monitor$Guard hasReachedRunning;
    private final Monitor$Guard isStartable;
    private final Monitor$Guard isStoppable;
    private final Monitor$Guard isStopped;
    private final ListenerCallQueue listeners;
    private final Monitor monitor;
    private volatile AbstractService$StateSnapshot snapshot;

    static {
        Object object = new AbstractService$1();
        STARTING_EVENT = object;
        object = new AbstractService$2();
        RUNNING_EVENT = object;
        object = Service$State.STARTING;
        STOPPING_FROM_STARTING_EVENT = AbstractService.stoppingEvent((Service$State)((Object)object));
        Service$State service$State = Service$State.RUNNING;
        STOPPING_FROM_RUNNING_EVENT = AbstractService.stoppingEvent(service$State);
        TERMINATED_FROM_NEW_EVENT = AbstractService.terminatedEvent(Service$State.NEW);
        TERMINATED_FROM_STARTING_EVENT = AbstractService.terminatedEvent((Service$State)((Object)object));
        TERMINATED_FROM_RUNNING_EVENT = AbstractService.terminatedEvent(service$State);
        TERMINATED_FROM_STOPPING_EVENT = AbstractService.terminatedEvent(Service$State.STOPPING);
    }

    public AbstractService() {
        Object object = new Monitor();
        this.monitor = object;
        this.isStartable = object = new AbstractService$IsStartableGuard(this);
        this.isStoppable = object = new AbstractService$IsStoppableGuard(this);
        this.hasReachedRunning = object = new AbstractService$HasReachedRunningGuard(this);
        this.isStopped = object = new AbstractService$IsStoppedGuard(this);
        this.listeners = object = new ListenerCallQueue();
        Service$State service$State = Service$State.NEW;
        this.snapshot = object = new AbstractService$StateSnapshot(service$State);
    }

    public static /* synthetic */ Monitor access$000(AbstractService abstractService) {
        return abstractService.monitor;
    }

    private void checkCurrentState(Service$State object) {
        Object object2 = this.state();
        if (object2 != object) {
            Object object3 = Service$State.FAILED;
            String string2 = " to be ";
            String string3 = "Expected the service ";
            if (object2 == object3) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(this);
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(object);
                ((StringBuilder)object3).append(", but the service has FAILED");
                object = ((StringBuilder)object3).toString();
                object3 = this.failureCause();
                object2 = new IllegalStateException((String)object, (Throwable)object3);
                throw object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(this);
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append(", but was ");
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
    }

    private void dispatchListenerEvents() {
        Object object = this.monitor;
        boolean bl2 = ((Monitor)object).isOccupiedByCurrentThread();
        if (!bl2) {
            object = this.listeners;
            ((ListenerCallQueue)object).dispatch();
        }
    }

    private void enqueueFailedEvent(Service$State service$State, Throwable throwable) {
        ListenerCallQueue listenerCallQueue = this.listeners;
        AbstractService$5 abstractService$5 = new AbstractService$5(this, service$State, throwable);
        listenerCallQueue.enqueue(abstractService$5);
    }

    private void enqueueRunningEvent() {
        ListenerCallQueue listenerCallQueue = this.listeners;
        ListenerCallQueue$Event listenerCallQueue$Event = RUNNING_EVENT;
        listenerCallQueue.enqueue(listenerCallQueue$Event);
    }

    private void enqueueStartingEvent() {
        ListenerCallQueue listenerCallQueue = this.listeners;
        ListenerCallQueue$Event listenerCallQueue$Event = STARTING_EVENT;
        listenerCallQueue.enqueue(listenerCallQueue$Event);
    }

    private void enqueueStoppingEvent(Service$State object) {
        block4: {
            block3: {
                Object object2;
                block2: {
                    object2 = Service$State.STARTING;
                    if (object != object2) break block2;
                    object = this.listeners;
                    object2 = STOPPING_FROM_STARTING_EVENT;
                    ((ListenerCallQueue)object).enqueue((ListenerCallQueue$Event)object2);
                    break block3;
                }
                object2 = Service$State.RUNNING;
                if (object != object2) break block4;
                object = this.listeners;
                object2 = STOPPING_FROM_RUNNING_EVENT;
                ((ListenerCallQueue)object).enqueue((ListenerCallQueue$Event)object2);
            }
            return;
        }
        object = new AssertionError();
        throw object;
    }

    private void enqueueTerminatedEvent(Service$State object) {
        Object object2 = AbstractService$6.$SwitchMap$com$google$common$util$concurrent$Service$State;
        int n10 = ((Enum)object).ordinal();
        n10 = object2[n10];
        switch (n10) {
            default: {
                break;
            }
            case 5: 
            case 6: {
                object = new AssertionError();
                throw object;
            }
            case 4: {
                object = this.listeners;
                object2 = TERMINATED_FROM_STOPPING_EVENT;
                ((ListenerCallQueue)object).enqueue((ListenerCallQueue$Event)object2);
                break;
            }
            case 3: {
                object = this.listeners;
                object2 = TERMINATED_FROM_RUNNING_EVENT;
                ((ListenerCallQueue)object).enqueue((ListenerCallQueue$Event)object2);
                break;
            }
            case 2: {
                object = this.listeners;
                object2 = TERMINATED_FROM_STARTING_EVENT;
                ((ListenerCallQueue)object).enqueue((ListenerCallQueue$Event)object2);
                break;
            }
            case 1: {
                object = this.listeners;
                object2 = TERMINATED_FROM_NEW_EVENT;
                ((ListenerCallQueue)object).enqueue((ListenerCallQueue$Event)object2);
            }
        }
    }

    private static ListenerCallQueue$Event stoppingEvent(Service$State service$State) {
        AbstractService$4 abstractService$4 = new AbstractService$4(service$State);
        return abstractService$4;
    }

    private static ListenerCallQueue$Event terminatedEvent(Service$State service$State) {
        AbstractService$3 abstractService$3 = new AbstractService$3(service$State);
        return abstractService$3;
    }

    public final void addListener(Service$Listener service$Listener, Executor executor) {
        this.listeners.addListener(service$Listener, executor);
    }

    public final void awaitRunning() {
        Object object = this.monitor;
        Monitor$Guard monitor$Guard = this.hasReachedRunning;
        object.enterWhenUninterruptibly(monitor$Guard);
        try {
            object = Service$State.RUNNING;
            this.checkCurrentState((Service$State)((Object)object));
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    public final void awaitRunning(long l10, TimeUnit timeUnit) {
        Monitor monitor = this.monitor;
        Monitor$Guard monitor$Guard = this.hasReachedRunning;
        boolean bl2 = monitor.enterWhenUninterruptibly(monitor$Guard, l10, timeUnit);
        if (bl2) {
            try {
                Service$State service$State = Service$State.RUNNING;
                this.checkCurrentState(service$State);
                return;
            }
            finally {
                this.monitor.leave();
            }
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Timed out waiting for ");
        charSequence.append(this);
        charSequence.append(" to reach the RUNNING state.");
        charSequence = charSequence.toString();
        TimeoutException timeoutException = new TimeoutException((String)charSequence);
        throw timeoutException;
    }

    public final void awaitTerminated() {
        Object object = this.monitor;
        Monitor$Guard monitor$Guard = this.isStopped;
        object.enterWhenUninterruptibly(monitor$Guard);
        try {
            object = Service$State.TERMINATED;
            this.checkCurrentState((Service$State)((Object)object));
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    public final void awaitTerminated(long l10, TimeUnit enum_) {
        Monitor monitor = this.monitor;
        Monitor$Guard monitor$Guard = this.isStopped;
        boolean bl2 = monitor.enterWhenUninterruptibly(monitor$Guard, l10, (TimeUnit)enum_);
        if (bl2) {
            try {
                Service$State service$State = Service$State.TERMINATED;
                this.checkCurrentState(service$State);
                return;
            }
            finally {
                this.monitor.leave();
            }
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Timed out waiting for ");
        charSequence.append(this);
        charSequence.append(" to reach a terminal state. Current state: ");
        enum_ = this.state();
        charSequence.append(enum_);
        charSequence = charSequence.toString();
        TimeoutException timeoutException = new TimeoutException((String)charSequence);
        throw timeoutException;
    }

    public void doCancelStart() {
    }

    public abstract void doStart();

    public abstract void doStop();

    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    public final boolean isRunning() {
        boolean bl2;
        Service$State service$State;
        Service$State service$State2 = this.state();
        if (service$State2 == (service$State = Service$State.RUNNING)) {
            bl2 = true;
        } else {
            bl2 = false;
            service$State2 = null;
        }
        return bl2;
    }

    public final void notifyFailed(Throwable throwable) {
        Object object;
        Object object2;
        block18: {
            block19: {
                Preconditions.checkNotNull(throwable);
                object2 = this.monitor;
                ((Monitor)object2).enter();
                object2 = this.state();
                object = AbstractService$6.$SwitchMap$com$google$common$util$concurrent$Service$State;
                int n10 = ((Enum)object2).ordinal();
                int n11 = object[n10];
                n10 = 1;
                if (n11 == n10) break block18;
                n10 = 2;
                if (n11 == n10 || n11 == (n10 = 3) || n11 == (n10 = 4)) break block19;
                n10 = 5;
                if (n11 != n10) {
                }
                break block18;
            }
            object = new AbstractService$StateSnapshot;
            Service$State service$State = Service$State.FAILED;
            Object var7_9 = null;
            object(service$State, false, throwable);
            this.snapshot = object;
            this.enqueueFailedEvent((Service$State)((Object)object2), throwable);
            return;
        }
        object = new IllegalStateException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Failed while in state:";
        stringBuilder.append(string2);
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        try {
            object((String)object2, throwable);
            throw object;
        }
        finally {
            this.monitor.leave();
            this.dispatchListenerEvents();
        }
    }

    public final void notifyStarted() {
        Object object = this.monitor;
        ((Monitor)object).enter();
        try {
            object = this.snapshot;
            object = ((AbstractService$StateSnapshot)object).state;
            Object object2 = Service$State.STARTING;
            if (object == object2) {
                object = this.snapshot;
                boolean bl2 = ((AbstractService$StateSnapshot)object).shutdownWhenStartupFinishes;
                if (bl2) {
                    object2 = Service$State.STOPPING;
                    object = new AbstractService$StateSnapshot((Service$State)((Object)object2));
                    this.snapshot = object;
                    this.doStop();
                } else {
                    object2 = Service$State.RUNNING;
                    object = new AbstractService$StateSnapshot((Service$State)((Object)object2));
                    this.snapshot = object;
                    this.enqueueRunningEvent();
                }
                return;
            }
            object2 = new StringBuilder();
            Object object3 = "Cannot notifyStarted() when the service is ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.snapshot;
            object3 = ((AbstractService$StateSnapshot)object3).state;
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalStateException((String)object2);
            this.notifyFailed((Throwable)object);
            throw object;
        }
        finally {
            this.monitor.leave();
            this.dispatchListenerEvents();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void notifyStopped() {
        var1_1 = this.monitor;
        var1_1.enter();
        var1_1 = this.state();
        var2_3 /* !! */  = AbstractService$6.$SwitchMap$com$google$common$util$concurrent$Service$State;
        var3_4 = var1_1.ordinal();
        var4_5 = var2_3 /* !! */ [var3_4];
        switch (var4_5) {
            default: {
                return;
            }
            case 2: 
            case 3: 
            case 4: {
                ** try [egrp 1[TRYBLOCK] [4 : 71->146)] { 
lbl16:
                // 1 sources

                var2_3 /* !! */  = (int[])new AbstractService$StateSnapshot;
                var5_6 = Service$State.TERMINATED;
                var2_3 /* !! */ (var5_6);
                this.snapshot = var2_3 /* !! */ ;
                this.enqueueTerminatedEvent((Service$State)var1_1);
                return;
            }
            case 1: 
            case 5: 
            case 6: 
        }
        var2_3 /* !! */  = (int[])new IllegalStateException;
        var5_7 = new StringBuilder();
        var6_8 = "Cannot notifyStopped() when the service is ";
        var5_7.append(var6_8);
        var5_7.append(var1_1);
        var1_1 = var5_7.toString();
        var2_3 /* !! */ ((String)var1_1);
        throw var2_3 /* !! */ ;
lbl33:
        // 1 sources

        finally {
            this.monitor.leave();
            this.dispatchListenerEvents();
        }
    }

    public final Service startAsync() {
        Object object = this.monitor;
        Object object2 = this.isStartable;
        boolean bl2 = ((Monitor)object).enterIf((Monitor$Guard)object2);
        if (bl2) {
            object2 = Service$State.STARTING;
            object = new AbstractService$StateSnapshot((Service$State)((Object)object2));
            try {
                this.snapshot = object;
                this.enqueueStartingEvent();
                this.doStart();
            }
            catch (Throwable throwable) {
                this.notifyFailed(throwable);
            }
            return this;
            {
                finally {
                    this.monitor.leave();
                    this.dispatchListenerEvents();
                }
            }
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Service ");
        ((StringBuilder)object2).append(this);
        ((StringBuilder)object2).append(" has already been started");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final Service$State state() {
        return this.snapshot.externalState();
    }

    /*
     * Exception decompiling
     */
    public final Service stopAsync() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [25[CASE]], but top level block is 9[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append(" [");
        object = this.state();
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

