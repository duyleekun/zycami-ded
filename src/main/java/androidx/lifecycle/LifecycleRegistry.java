/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry$ObserverWithState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class LifecycleRegistry
extends Lifecycle {
    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap mObserverMap;
    private ArrayList mParentStates;
    private Lifecycle$State mState;

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    private LifecycleRegistry(LifecycleOwner object, boolean bl2) {
        WeakReference<LifecycleOwner> weakReference = new WeakReference<LifecycleOwner>();
        this.mObserverMap = weakReference;
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = weakReference;
        this.mLifecycleOwner = weakReference = new WeakReference<LifecycleOwner>((LifecycleOwner)object);
        object = Lifecycle$State.INITIALIZED;
        this.mState = object;
        this.mEnforceMainThread = bl2;
    }

    private void backwardPass(LifecycleOwner object) {
        boolean bl2;
        Object object2 = this.mObserverMap.descendingIterator();
        while ((bl2 = object2.hasNext()) && !(bl2 = this.mNewEventOccurred)) {
            Lifecycle$State lifecycle$State;
            Object object3;
            int n10;
            Object object4 = (Map.Entry)object2.next();
            LifecycleRegistry$ObserverWithState lifecycleRegistry$ObserverWithState = (LifecycleRegistry$ObserverWithState)object4.getValue();
            while ((n10 = (object3 = lifecycleRegistry$ObserverWithState.mState).compareTo(lifecycle$State = this.mState)) > 0 && (n10 = (int)(this.mNewEventOccurred ? 1 : 0)) == 0 && (n10 = (int)(((FastSafeIterableMap)(object3 = this.mObserverMap)).contains((Object)(lifecycle$State = object4.getKey())) ? 1 : 0)) != 0) {
                object3 = Lifecycle$Event.downFrom(lifecycleRegistry$ObserverWithState.mState);
                if (object3 != null) {
                    lifecycle$State = ((Lifecycle$Event)((Object)object3)).getTargetState();
                    this.pushParentState(lifecycle$State);
                    lifecycleRegistry$ObserverWithState.dispatchEvent((LifecycleOwner)object, (Lifecycle$Event)((Object)object3));
                    this.popParentState();
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("no event down from ");
                object4 = lifecycleRegistry$ObserverWithState.mState;
                ((StringBuilder)object2).append(object4);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
        }
    }

    private Lifecycle$State calculateTargetState(LifecycleObserver object) {
        object = this.mObserverMap.ceil(object);
        Object object2 = null;
        object = object != null ? ((LifecycleRegistry$ObserverWithState)object.getValue()).mState : null;
        ArrayList arrayList = this.mParentStates;
        int n10 = arrayList.isEmpty();
        if (n10 == 0) {
            object2 = this.mParentStates;
            n10 = object2.size() + -1;
            object2 = (Lifecycle$State)((Object)object2.get(n10));
        }
        return LifecycleRegistry.min(LifecycleRegistry.min(this.mState, (Lifecycle$State)((Object)object)), (Lifecycle$State)((Object)object2));
    }

    public static LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(lifecycleOwner, false);
        return lifecycleRegistry;
    }

    private void enforceMainThreadIfNeeded(String string2) {
        Object object;
        boolean bl2 = this.mEnforceMainThread;
        if (bl2 && !(bl2 = ((ArchTaskExecutor)(object = ArchTaskExecutor.getInstance())).isMainThread())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(string2);
            stringBuilder.append(" must be called on the main thread");
            string2 = stringBuilder.toString();
            object = new IllegalStateException(string2);
            throw object;
        }
    }

    private void forwardPass(LifecycleOwner object) {
        boolean bl2;
        Object object2 = this.mObserverMap.iteratorWithAdditions();
        while ((bl2 = object2.hasNext()) && !(bl2 = this.mNewEventOccurred)) {
            Lifecycle$State lifecycle$State;
            Object object3;
            int n10;
            Object object4 = (Map.Entry)object2.next();
            LifecycleRegistry$ObserverWithState lifecycleRegistry$ObserverWithState = (LifecycleRegistry$ObserverWithState)object4.getValue();
            while ((n10 = (object3 = lifecycleRegistry$ObserverWithState.mState).compareTo(lifecycle$State = this.mState)) < 0 && (n10 = (int)(this.mNewEventOccurred ? 1 : 0)) == 0 && (n10 = (int)(((FastSafeIterableMap)(object3 = this.mObserverMap)).contains((Object)(lifecycle$State = object4.getKey())) ? 1 : 0)) != 0) {
                object3 = lifecycleRegistry$ObserverWithState.mState;
                this.pushParentState((Lifecycle$State)((Object)object3));
                object3 = Lifecycle$Event.upFrom(lifecycleRegistry$ObserverWithState.mState);
                if (object3 != null) {
                    lifecycleRegistry$ObserverWithState.dispatchEvent((LifecycleOwner)object, (Lifecycle$Event)((Object)object3));
                    this.popParentState();
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("no event up from ");
                object4 = lifecycleRegistry$ObserverWithState.mState;
                ((StringBuilder)object2).append(object4);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
        }
    }

    private boolean isSynced() {
        Object object = this.mObserverMap;
        int n10 = object.size();
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        object = ((LifecycleRegistry$ObserverWithState)this.mObserverMap.eldest().getValue()).mState;
        Lifecycle$State lifecycle$State = ((LifecycleRegistry$ObserverWithState)this.mObserverMap.newest().getValue()).mState;
        if (object != lifecycle$State || (object = this.mState) != lifecycle$State) {
            bl2 = false;
        }
        return bl2;
    }

    public static Lifecycle$State min(Lifecycle$State lifecycle$State, Lifecycle$State lifecycle$State2) {
        int n10;
        if (lifecycle$State2 != null && (n10 = lifecycle$State2.compareTo(lifecycle$State)) < 0) {
            lifecycle$State = lifecycle$State2;
        }
        return lifecycle$State;
    }

    private void moveToState(Lifecycle$State lifecycle$State) {
        Lifecycle$State lifecycle$State2 = this.mState;
        if (lifecycle$State2 == lifecycle$State) {
            return;
        }
        this.mState = lifecycle$State;
        int n10 = this.mHandlingEvent;
        boolean bl2 = true;
        if (n10 == 0 && (n10 = this.mAddingObserverCounter) == 0) {
            this.mHandlingEvent = bl2;
            this.sync();
            this.mHandlingEvent = false;
            return;
        }
        this.mNewEventOccurred = bl2;
    }

    private void popParentState() {
        ArrayList arrayList = this.mParentStates;
        int n10 = arrayList.size() + -1;
        arrayList.remove(n10);
    }

    private void pushParentState(Lifecycle$State lifecycle$State) {
        this.mParentStates.add(lifecycle$State);
    }

    private void sync() {
        Object object = (LifecycleOwner)this.mLifecycleOwner.get();
        if (object != null) {
            while (true) {
                int n10 = this.isSynced();
                boolean bl2 = false;
                Lifecycle$State lifecycle$State = null;
                if (n10 != 0) break;
                this.mNewEventOccurred = false;
                Object object2 = this.mState;
                lifecycle$State = ((LifecycleRegistry$ObserverWithState)this.mObserverMap.eldest().getValue()).mState;
                n10 = object2.compareTo(lifecycle$State);
                if (n10 < 0) {
                    this.backwardPass((LifecycleOwner)object);
                }
                object2 = this.mObserverMap.newest();
                bl2 = this.mNewEventOccurred;
                if (bl2 || object2 == null || (n10 = (lifecycle$State = this.mState).compareTo(object2 = ((LifecycleRegistry$ObserverWithState)object2.getValue()).mState)) <= 0) continue;
                this.forwardPass((LifecycleOwner)object);
            }
            this.mNewEventOccurred = false;
            return;
        }
        object = new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        throw object;
    }

    public void addObserver(LifecycleObserver object) {
        int n10;
        Lifecycle$State lifecycle$State;
        int n11;
        int n12;
        this.enforceMainThreadIfNeeded("addObserver");
        Object object2 = this.mState;
        Object object3 = Lifecycle$State.DESTROYED;
        if (object2 != object3) {
            object3 = Lifecycle$State.INITIALIZED;
        }
        object2 = new LifecycleRegistry$ObserverWithState((LifecycleObserver)object, (Lifecycle$State)((Object)object3));
        object3 = (LifecycleRegistry$ObserverWithState)this.mObserverMap.putIfAbsent(object, object2);
        if (object3 != null) {
            return;
        }
        object3 = (LifecycleOwner)this.mLifecycleOwner.get();
        if (object3 == null) {
            return;
        }
        int n13 = this.mAddingObserverCounter;
        int n14 = 1;
        n13 = n13 == 0 && (n13 = (int)(this.mHandlingEvent ? 1 : 0)) == 0 ? 0 : n14;
        Object object4 = this.calculateTargetState((LifecycleObserver)object);
        this.mAddingObserverCounter = n12 = this.mAddingObserverCounter + n14;
        while ((n11 = (lifecycle$State = ((LifecycleRegistry$ObserverWithState)object2).mState).compareTo(object4)) < 0 && (n11 = (int)(((FastSafeIterableMap)(object4 = this.mObserverMap)).contains(object) ? 1 : 0)) != 0) {
            object4 = ((LifecycleRegistry$ObserverWithState)object2).mState;
            this.pushParentState((Lifecycle$State)((Object)object4));
            object4 = Lifecycle$Event.upFrom(((LifecycleRegistry$ObserverWithState)object2).mState);
            if (object4 != null) {
                ((LifecycleRegistry$ObserverWithState)object2).dispatchEvent((LifecycleOwner)object3, (Lifecycle$Event)((Object)object4));
                this.popParentState();
                object4 = this.calculateTargetState((LifecycleObserver)object);
                continue;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("no event up from ");
            object2 = ((LifecycleRegistry$ObserverWithState)object2).mState;
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        if (n13 == 0) {
            this.sync();
        }
        this.mAddingObserverCounter = n10 = this.mAddingObserverCounter - n14;
    }

    public Lifecycle$State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        this.enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(Lifecycle$Event enum_) {
        this.enforceMainThreadIfNeeded("handleLifecycleEvent");
        enum_ = ((Lifecycle$Event)enum_).getTargetState();
        this.moveToState((Lifecycle$State)enum_);
    }

    public void markState(Lifecycle$State lifecycle$State) {
        this.enforceMainThreadIfNeeded("markState");
        this.setCurrentState(lifecycle$State);
    }

    public void removeObserver(LifecycleObserver lifecycleObserver) {
        this.enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove(lifecycleObserver);
    }

    public void setCurrentState(Lifecycle$State lifecycle$State) {
        this.enforceMainThreadIfNeeded("setCurrentState");
        this.moveToState(lifecycle$State);
    }
}

