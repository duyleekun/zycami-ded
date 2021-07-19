/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.core.os.CancellationSignal;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController$3;
import androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact;
import androidx.fragment.app.SpecialEffectsController$Operation$State;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SpecialEffectsController$Operation {
    private final List mCompletionListeners;
    private SpecialEffectsController$Operation$State mFinalState;
    private final Fragment mFragment;
    private boolean mIsCanceled;
    private boolean mIsComplete;
    private SpecialEffectsController$Operation$LifecycleImpact mLifecycleImpact;
    private final HashSet mSpecialEffectsSignals;

    public SpecialEffectsController$Operation(SpecialEffectsController$Operation$State object, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
        AbstractCollection abstractCollection;
        this.mCompletionListeners = abstractCollection = new AbstractCollection();
        this.mSpecialEffectsSignals = abstractCollection;
        this.mIsCanceled = false;
        this.mIsComplete = false;
        this.mFinalState = object;
        this.mLifecycleImpact = specialEffectsController$Operation$LifecycleImpact;
        this.mFragment = fragment;
        super(this);
        cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)object);
    }

    public final void addCompletionListener(Runnable runnable) {
        this.mCompletionListeners.add(runnable);
    }

    public final void cancel() {
        boolean bl2 = this.isCanceled();
        if (bl2) {
            return;
        }
        this.mIsCanceled = true;
        Object object = this.mSpecialEffectsSignals;
        bl2 = ((HashSet)object).isEmpty();
        if (bl2) {
            this.complete();
        } else {
            boolean bl3;
            Object object2 = this.mSpecialEffectsSignals;
            object = new ArrayList(object2);
            object = ((ArrayList)object).iterator();
            while (bl3 = object.hasNext()) {
                object2 = (CancellationSignal)object.next();
                ((CancellationSignal)object2).cancel();
            }
        }
    }

    public void complete() {
        boolean bl2;
        Object object;
        Object object2;
        boolean bl3 = this.mIsComplete;
        if (bl3) {
            return;
        }
        bl3 = FragmentManager.isLoggingEnabled(2);
        if (bl3) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("SpecialEffectsController: ");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append(" has called complete.");
            object2 = ((StringBuilder)object2).toString();
            object = "FragmentManager";
            Log.v((String)object, (String)object2);
        }
        this.mIsComplete = bl3 = true;
        object2 = this.mCompletionListeners.iterator();
        while (bl2 = object2.hasNext()) {
            object = (Runnable)object2.next();
            object.run();
        }
    }

    public final void completeSpecialEffect(CancellationSignal object) {
        HashSet hashSet = this.mSpecialEffectsSignals;
        boolean bl2 = hashSet.remove(object);
        if (bl2 && (bl2 = ((HashSet)(object = this.mSpecialEffectsSignals)).isEmpty())) {
            this.complete();
        }
    }

    public SpecialEffectsController$Operation$State getFinalState() {
        return this.mFinalState;
    }

    public final Fragment getFragment() {
        return this.mFragment;
    }

    public SpecialEffectsController$Operation$LifecycleImpact getLifecycleImpact() {
        return this.mLifecycleImpact;
    }

    public final boolean isCanceled() {
        return this.mIsCanceled;
    }

    public final boolean isComplete() {
        return this.mIsComplete;
    }

    public final void markStartedSpecialEffect(CancellationSignal cancellationSignal) {
        this.onStart();
        this.mSpecialEffectsSignals.add(cancellationSignal);
    }

    public final void mergeWith(SpecialEffectsController$Operation$State object, SpecialEffectsController$Operation$LifecycleImpact object2) {
        Object object3 = SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
        int n10 = ((Enum)object2).ordinal();
        n10 = object3[n10];
        int n11 = 1;
        Object object4 = "SpecialEffectsController: For fragment ";
        String string2 = "FragmentManager";
        int n12 = 2;
        if (n10 != n11) {
            object3 = " mFinalState = ";
            if (n10 != n12) {
                SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
                int n13 = 3;
                if (n10 == n13 && (object2 = this.mFinalState) != (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.REMOVED)) {
                    n10 = (int)(FragmentManager.isLoggingEnabled(n12) ? 1 : 0);
                    if (n10 != 0) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append((String)object4);
                        object4 = this.mFragment;
                        ((StringBuilder)object2).append(object4);
                        ((StringBuilder)object2).append((String)object3);
                        object3 = (Object)this.mFinalState;
                        ((StringBuilder)object2).append(object3);
                        ((StringBuilder)object2).append(" -> ");
                        ((StringBuilder)object2).append(object);
                        object3 = ". ";
                        ((StringBuilder)object2).append((String)object3);
                        object2 = ((StringBuilder)object2).toString();
                        Log.v((String)string2, (String)object2);
                    }
                    this.mFinalState = object;
                }
            } else {
                boolean bl2 = FragmentManager.isLoggingEnabled(n12);
                if (bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object4);
                    object2 = this.mFragment;
                    ((StringBuilder)object).append(object2);
                    ((StringBuilder)object).append((String)object3);
                    object2 = this.mFinalState;
                    ((StringBuilder)object).append(object2);
                    ((StringBuilder)object).append(" -> REMOVED. mLifecycleImpact  = ");
                    object2 = this.mLifecycleImpact;
                    ((StringBuilder)object).append(object2);
                    object2 = " to REMOVING.";
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    Log.v((String)string2, (String)object);
                }
                object = SpecialEffectsController$Operation$State.REMOVED;
                this.mFinalState = object;
                object = SpecialEffectsController$Operation$LifecycleImpact.REMOVING;
                this.mLifecycleImpact = object;
            }
        } else {
            object = this.mFinalState;
            object2 = SpecialEffectsController$Operation$State.REMOVED;
            if (object == object2) {
                boolean bl3 = FragmentManager.isLoggingEnabled(n12);
                if (bl3) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object4);
                    object2 = this.mFragment;
                    ((StringBuilder)object).append(object2);
                    ((StringBuilder)object).append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    object2 = this.mLifecycleImpact;
                    ((StringBuilder)object).append(object2);
                    object2 = " to ADDING.";
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    Log.v((String)string2, (String)object);
                }
                object = SpecialEffectsController$Operation$State.VISIBLE;
                this.mFinalState = object;
                object = SpecialEffectsController$Operation$LifecycleImpact.ADDING;
                this.mLifecycleImpact = object;
            }
        }
    }

    public void onStart() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Operation ");
        Object object = "{";
        stringBuilder.append((String)object);
        String string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        string2 = "} ";
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append("mFinalState = ");
        Enum enum_ = this.mFinalState;
        stringBuilder.append(enum_);
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append("mLifecycleImpact = ");
        enum_ = this.mLifecycleImpact;
        stringBuilder.append(enum_);
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append("mFragment = ");
        object = this.mFragment;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

