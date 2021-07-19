/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData$1;
import androidx.lifecycle.LiveData$AlwaysActiveObserver;
import androidx.lifecycle.LiveData$LifecycleBoundObserver;
import androidx.lifecycle.LiveData$ObserverWrapper;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData {
    public static final Object NOT_SET;
    public static final int START_VERSION = 255;
    public int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    public final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap mObservers;
    public volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    static {
        Object object;
        NOT_SET = object = new Object();
    }

    public LiveData() {
        Object object;
        this.mDataLock = object = new Object();
        this.mObservers = object = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = object = NOT_SET;
        LiveData$1 liveData$1 = new LiveData$1(this);
        this.mPostValueRunnable = liveData$1;
        this.mData = object;
        this.mVersion = -1;
    }

    public LiveData(Object object) {
        Object object2;
        Object object3;
        this.mDataLock = object3 = new Object();
        this.mObservers = object3 = new SafeIterableMap();
        this.mActiveCount = 0;
        this.mPendingData = object2 = NOT_SET;
        this.mPostValueRunnable = object2 = new LiveData$1(this);
        this.mData = object;
        this.mVersion = 0;
    }

    public static void assertMainThread(String string2) {
        Object object = ArchTaskExecutor.getInstance();
        boolean bl2 = ((ArchTaskExecutor)object).isMainThread();
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot invoke ");
        stringBuilder.append(string2);
        stringBuilder.append(" on a background thread");
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    private void considerNotify(LiveData$ObserverWrapper object) {
        boolean n10 = ((LiveData$ObserverWrapper)object).mActive;
        if (!n10) {
            return;
        }
        boolean bl2 = ((LiveData$ObserverWrapper)object).shouldBeActive();
        if (!bl2) {
            ((LiveData$ObserverWrapper)object).activeStateChanged(false);
            return;
        }
        int n11 = ((LiveData$ObserverWrapper)object).mLastVersion;
        int n12 = this.mVersion;
        if (n11 >= n12) {
            return;
        }
        ((LiveData$ObserverWrapper)object).mLastVersion = n12;
        object = ((LiveData$ObserverWrapper)object).mObserver;
        Object object2 = this.mData;
        object.onChanged(object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void changeActiveCounter(int n10) {
        int n11 = this.mActiveCount;
        this.mActiveCount = n10 += n11;
        n10 = (int)(this.mChangingActiveState ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        n10 = 1;
        this.mChangingActiveState = n10;
        try {
            while (true) {
                int n12;
                if (n11 == (n12 = this.mActiveCount)) {
                    this.mChangingActiveState = false;
                    return;
                }
                int n13 = n11 == 0 && n12 > 0 ? n10 : 0;
                n11 = n11 > 0 && n12 == 0 ? n10 : 0;
                if (n13 != 0) {
                    this.onActive();
                } else if (n11 != 0) {
                    this.onInactive();
                }
                n11 = n12;
            }
        }
        catch (Throwable throwable) {
            this.mChangingActiveState = false;
            throw throwable;
        }
    }

    public void dispatchingValue(LiveData$ObserverWrapper liveData$ObserverWrapper) {
        boolean bl2 = this.mDispatchingValue;
        boolean bl3 = true;
        if (bl2) {
            this.mDispatchInvalidated = bl3;
            return;
        }
        this.mDispatchingValue = bl3;
        do {
            boolean bl4;
            bl2 = false;
            this.mDispatchInvalidated = false;
            if (liveData$ObserverWrapper != null) {
                this.considerNotify(liveData$ObserverWrapper);
                liveData$ObserverWrapper = null;
                continue;
            }
            SafeIterableMap$IteratorWithAdditions safeIterableMap$IteratorWithAdditions = this.mObservers.iteratorWithAdditions();
            while (bl4 = safeIterableMap$IteratorWithAdditions.hasNext()) {
                LiveData$ObserverWrapper liveData$ObserverWrapper2 = (LiveData$ObserverWrapper)((Map.Entry)safeIterableMap$IteratorWithAdditions.next()).getValue();
                this.considerNotify(liveData$ObserverWrapper2);
                bl4 = this.mDispatchInvalidated;
                if (!bl4) continue;
            }
        } while (bl3 = this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public Object getValue() {
        Object object = this.mData;
        Object object2 = NOT_SET;
        if (object != object2) {
            return object;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        int n10 = this.mActiveCount;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasObservers() {
        SafeIterableMap safeIterableMap = this.mObservers;
        int n10 = safeIterableMap.size();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            safeIterableMap = null;
        }
        return n10 != 0;
    }

    public void observe(LifecycleOwner object, Observer object2) {
        boolean bl2;
        LiveData.assertMainThread("observe");
        Object object3 = object.getLifecycle().getCurrentState();
        Object object4 = Lifecycle$State.DESTROYED;
        if (object3 == object4) {
            return;
        }
        object4 = this.mObservers;
        object3 = new LiveData$LifecycleBoundObserver(this, (LifecycleOwner)object, (Observer)object2);
        if ((object2 = (LiveData$ObserverWrapper)((SafeIterableMap)object4).putIfAbsent(object2, object3)) != null && !(bl2 = ((LiveData$ObserverWrapper)object2).isAttachedTo((LifecycleOwner)object))) {
            object = new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            throw object;
        }
        if (object2 != null) {
            return;
        }
        object.getLifecycle().addObserver((LifecycleObserver)object3);
    }

    public void observeForever(Observer object) {
        LiveData.assertMainThread("observeForever");
        LiveData$AlwaysActiveObserver liveData$AlwaysActiveObserver = new LiveData$AlwaysActiveObserver(this, (Observer)object);
        SafeIterableMap safeIterableMap = this.mObservers;
        object = (LiveData$ObserverWrapper)safeIterableMap.putIfAbsent(object, liveData$AlwaysActiveObserver);
        boolean bl2 = object instanceof LiveData$LifecycleBoundObserver;
        if (!bl2) {
            if (object != null) {
                return;
            }
            liveData$AlwaysActiveObserver.activeStateChanged(true);
            return;
        }
        object = new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        throw object;
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void postValue(Object object) {
        boolean bl2;
        Object object2 = this.mDataLock;
        // MONITORENTER : object2
        Object object3 = this.mPendingData;
        Object object4 = NOT_SET;
        if (object3 == object4) {
            bl2 = true;
        } else {
            bl2 = false;
            object3 = null;
        }
        this.mPendingData = object;
        // MONITOREXIT : object2
        if (!bl2) {
            return;
        }
        object = ArchTaskExecutor.getInstance();
        object2 = this.mPostValueRunnable;
        ((ArchTaskExecutor)object).postToMainThread((Runnable)object2);
    }

    public void removeObserver(Observer object) {
        LiveData.assertMainThread("removeObserver");
        SafeIterableMap safeIterableMap = this.mObservers;
        object = (LiveData$ObserverWrapper)safeIterableMap.remove(object);
        if (object == null) {
            return;
        }
        ((LiveData$ObserverWrapper)object).detachObserver();
        ((LiveData$ObserverWrapper)object).activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        boolean bl2;
        LiveData.assertMainThread("removeObservers");
        Iterator iterator2 = this.mObservers.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Map.Entry)iterator2.next();
            LiveData$ObserverWrapper liveData$ObserverWrapper = (LiveData$ObserverWrapper)object.getValue();
            boolean bl3 = liveData$ObserverWrapper.isAttachedTo(lifecycleOwner);
            if (!bl3) continue;
            object = (Observer)object.getKey();
            this.removeObserver((Observer)object);
        }
    }

    public void setValue(Object object) {
        int n10;
        LiveData.assertMainThread("setValue");
        this.mVersion = n10 = this.mVersion + 1;
        this.mData = object;
        this.dispatchingValue(null);
    }
}

