/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController$1;
import androidx.fragment.app.SpecialEffectsController$2;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact;
import androidx.fragment.app.SpecialEffectsController$Operation$State;
import androidx.fragment.app.SpecialEffectsControllerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    public boolean mIsContainerPostponed;
    public boolean mOperationDirectionIsPop;
    public final ArrayList mPendingOperations;
    public final ArrayList mRunningOperations;

    public SpecialEffectsController(ViewGroup viewGroup) {
        ArrayList arrayList;
        this.mPendingOperations = arrayList = new ArrayList();
        this.mRunningOperations = arrayList = new ArrayList();
        this.mOperationDirectionIsPop = false;
        this.mIsContainerPostponed = false;
        this.mContainer = viewGroup;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void enqueue(SpecialEffectsController$Operation$State object, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, FragmentStateManager fragmentStateManager) {
        ArrayList arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Object object2 = fragmentStateManager.getFragment();
            object2 = this.findPendingOperation((Fragment)object2);
            if (object2 != null) {
                ((SpecialEffectsController$Operation)object2).mergeWith((SpecialEffectsController$Operation$State)((Object)object), specialEffectsController$Operation$LifecycleImpact);
                return;
            }
            object2 = new SpecialEffectsController$FragmentStateManagerOperation((SpecialEffectsController$Operation$State)((Object)object), specialEffectsController$Operation$LifecycleImpact, fragmentStateManager, cancellationSignal);
            object = this.mPendingOperations;
            ((ArrayList)object).add(object2);
            object = new SpecialEffectsController$1(this, (SpecialEffectsController$FragmentStateManagerOperation)object2);
            ((SpecialEffectsController$Operation)object2).addCompletionListener((Runnable)object);
            object = new SpecialEffectsController$2(this, (SpecialEffectsController$FragmentStateManagerOperation)object2);
            ((SpecialEffectsController$Operation)object2).addCompletionListener((Runnable)object);
            return;
        }
    }

    private SpecialEffectsController$Operation findPendingOperation(Fragment fragment) {
        boolean bl2;
        Iterator iterator2 = this.mPendingOperations.iterator();
        while (bl2 = iterator2.hasNext()) {
            SpecialEffectsController$Operation specialEffectsController$Operation = (SpecialEffectsController$Operation)iterator2.next();
            Fragment fragment2 = specialEffectsController$Operation.getFragment();
            boolean bl3 = fragment2.equals(fragment);
            if (!bl3 || (bl3 = specialEffectsController$Operation.isCanceled())) continue;
            return specialEffectsController$Operation;
        }
        return null;
    }

    private SpecialEffectsController$Operation findRunningOperation(Fragment fragment) {
        boolean bl2;
        Iterator iterator2 = this.mRunningOperations.iterator();
        while (bl2 = iterator2.hasNext()) {
            SpecialEffectsController$Operation specialEffectsController$Operation = (SpecialEffectsController$Operation)iterator2.next();
            Fragment fragment2 = specialEffectsController$Operation.getFragment();
            boolean bl3 = fragment2.equals(fragment);
            if (!bl3 || (bl3 = specialEffectsController$Operation.isCanceled())) continue;
            return specialEffectsController$Operation;
        }
        return null;
    }

    public static SpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager object) {
        object = ((FragmentManager)object).getSpecialEffectsControllerFactory();
        return SpecialEffectsController.getOrCreateController(viewGroup, (SpecialEffectsControllerFactory)object);
    }

    public static SpecialEffectsController getOrCreateController(ViewGroup viewGroup, SpecialEffectsControllerFactory object) {
        int n10 = R$id.special_effects_controller_view_tag;
        Object object2 = viewGroup.getTag(n10);
        boolean bl2 = object2 instanceof SpecialEffectsController;
        if (bl2) {
            return (SpecialEffectsController)object2;
        }
        object = object.createController(viewGroup);
        viewGroup.setTag(n10, object);
        return object;
    }

    private void updateFinalState() {
        boolean bl2;
        Iterator iterator2 = this.mPendingOperations.iterator();
        while (bl2 = iterator2.hasNext()) {
            SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact;
            SpecialEffectsController$Operation specialEffectsController$Operation = (SpecialEffectsController$Operation)iterator2.next();
            Enum enum_ = specialEffectsController$Operation.getLifecycleImpact();
            if (enum_ != (specialEffectsController$Operation$LifecycleImpact = SpecialEffectsController$Operation$LifecycleImpact.ADDING)) continue;
            int n10 = specialEffectsController$Operation.getFragment().requireView().getVisibility();
            enum_ = SpecialEffectsController$Operation$State.from(n10);
            specialEffectsController$Operation$LifecycleImpact = SpecialEffectsController$Operation$LifecycleImpact.NONE;
            specialEffectsController$Operation.mergeWith((SpecialEffectsController$Operation$State)enum_, specialEffectsController$Operation$LifecycleImpact);
        }
    }

    public void enqueueAdd(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, FragmentStateManager fragmentStateManager) {
        Object object;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("SpecialEffectsController: Enqueuing add operation for fragment ");
            Object object2 = fragmentStateManager.getFragment();
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = "FragmentManager";
            Log.v((String)object2, (String)object);
        }
        object = SpecialEffectsController$Operation$LifecycleImpact.ADDING;
        this.enqueue(specialEffectsController$Operation$State, (SpecialEffectsController$Operation$LifecycleImpact)((Object)object), fragmentStateManager);
    }

    public void enqueueHide(FragmentStateManager fragmentStateManager) {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            object = fragmentStateManager.getFragment();
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = "FragmentManager";
            Log.v((String)object, (String)object2);
        }
        object2 = SpecialEffectsController$Operation$State.GONE;
        object = SpecialEffectsController$Operation$LifecycleImpact.NONE;
        this.enqueue((SpecialEffectsController$Operation$State)((Object)object2), (SpecialEffectsController$Operation$LifecycleImpact)((Object)object), fragmentStateManager);
    }

    public void enqueueRemove(FragmentStateManager fragmentStateManager) {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            object = fragmentStateManager.getFragment();
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = "FragmentManager";
            Log.v((String)object, (String)object2);
        }
        object2 = SpecialEffectsController$Operation$State.REMOVED;
        object = SpecialEffectsController$Operation$LifecycleImpact.REMOVING;
        this.enqueue((SpecialEffectsController$Operation$State)((Object)object2), (SpecialEffectsController$Operation$LifecycleImpact)((Object)object), fragmentStateManager);
    }

    public void enqueueShow(FragmentStateManager fragmentStateManager) {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("SpecialEffectsController: Enqueuing show operation for fragment ");
            object = fragmentStateManager.getFragment();
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = "FragmentManager";
            Log.v((String)object, (String)object2);
        }
        object2 = SpecialEffectsController$Operation$State.VISIBLE;
        object = SpecialEffectsController$Operation$LifecycleImpact.NONE;
        this.enqueue((SpecialEffectsController$Operation$State)((Object)object2), (SpecialEffectsController$Operation$LifecycleImpact)((Object)object), fragmentStateManager);
    }

    public abstract void executeOperations(List var1, boolean var2);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executePendingOperations() {
        boolean bl2 = this.mIsContainerPostponed;
        if (bl2) {
            return;
        }
        Object object = this.mContainer;
        bl2 = ViewCompat.isAttachedToWindow((View)object);
        Object var3_3 = null;
        if (!bl2) {
            this.forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        object = this.mPendingOperations;
        synchronized (object) {
            ArrayList arrayList = this.mPendingOperations;
            boolean bl3 = arrayList.isEmpty();
            if (!bl3) {
                Object object2;
                int n10;
                boolean bl4;
                Iterator iterator2 = this.mRunningOperations;
                arrayList = new ArrayList(iterator2);
                iterator2 = this.mRunningOperations;
                ((ArrayList)((Object)iterator2)).clear();
                arrayList = arrayList.iterator();
                while (bl4 = arrayList.hasNext()) {
                    iterator2 = arrayList.next();
                    iterator2 = (SpecialEffectsController$Operation)((Object)iterator2);
                    n10 = 2;
                    if ((n10 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0)) != 0) {
                        object2 = "FragmentManager";
                        CharSequence charSequence = new StringBuilder();
                        String string2 = "SpecialEffectsController: Cancelling operation ";
                        charSequence.append(string2);
                        charSequence.append(iterator2);
                        charSequence = charSequence.toString();
                        Log.v((String)object2, (String)charSequence);
                    }
                    ((SpecialEffectsController$Operation)((Object)iterator2)).cancel();
                    n10 = (int)(((SpecialEffectsController$Operation)((Object)iterator2)).isComplete() ? 1 : 0);
                    if (n10 != 0) continue;
                    object2 = this.mRunningOperations;
                    ((ArrayList)object2).add(iterator2);
                }
                this.updateFinalState();
                iterator2 = this.mPendingOperations;
                arrayList = new ArrayList(iterator2);
                iterator2 = this.mPendingOperations;
                ((ArrayList)((Object)iterator2)).clear();
                iterator2 = this.mRunningOperations;
                ((ArrayList)((Object)iterator2)).addAll(arrayList);
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    object2 = iterator2.next();
                    object2 = (SpecialEffectsController$Operation)object2;
                    ((SpecialEffectsController$Operation)object2).onStart();
                }
                bl4 = this.mOperationDirectionIsPop;
                this.executeOperations(arrayList, bl4);
                this.mOperationDirectionIsPop = false;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void forceCompleteAllOperations() {
        ViewGroup viewGroup = this.mContainer;
        boolean bl2 = ViewCompat.isAttachedToWindow((View)viewGroup);
        ArrayList arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            CharSequence charSequence;
            CharSequence charSequence2;
            CharSequence charSequence3;
            int n10;
            Object object;
            boolean bl3;
            this.updateFinalState();
            Object object2 = this.mPendingOperations;
            object2 = ((ArrayList)object2).iterator();
            while (bl3 = object2.hasNext()) {
                object = object2.next();
                object = (SpecialEffectsController$Operation)object;
                ((SpecialEffectsController$Operation)object).onStart();
            }
            object = this.mRunningOperations;
            object2 = new ArrayList(object);
            object2 = ((ArrayList)object2).iterator();
            while (true) {
                bl3 = object2.hasNext();
                n10 = 2;
                if (!bl3) break;
                object = object2.next();
                object = (SpecialEffectsController$Operation)object;
                if ((n10 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0)) != 0) {
                    String string2 = "FragmentManager";
                    charSequence3 = new StringBuilder();
                    charSequence2 = "SpecialEffectsController: ";
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    if (bl2) {
                        charSequence2 = "";
                    } else {
                        charSequence2 = new StringBuilder();
                        charSequence = "Container ";
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        charSequence = this.mContainer;
                        ((StringBuilder)charSequence2).append((Object)charSequence);
                        charSequence = " is not attached to window. ";
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                    }
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    charSequence2 = "Cancelling running operation ";
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    ((StringBuilder)charSequence3).append(object);
                    charSequence3 = ((StringBuilder)charSequence3).toString();
                    Log.v((String)string2, (String)charSequence3);
                }
                ((SpecialEffectsController$Operation)object).cancel();
            }
            object = this.mPendingOperations;
            object2 = new ArrayList(object);
            object2 = ((ArrayList)object2).iterator();
            while (bl3 = object2.hasNext()) {
                object = object2.next();
                object = (SpecialEffectsController$Operation)object;
                boolean bl4 = FragmentManager.isLoggingEnabled(n10);
                if (bl4) {
                    charSequence3 = "FragmentManager";
                    charSequence2 = new StringBuilder();
                    charSequence = "SpecialEffectsController: ";
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    if (bl2) {
                        charSequence = "";
                    } else {
                        charSequence = new StringBuilder();
                        String string3 = "Container ";
                        ((StringBuilder)charSequence).append(string3);
                        string3 = this.mContainer;
                        ((StringBuilder)charSequence).append((Object)string3);
                        string3 = " is not attached to window. ";
                        ((StringBuilder)charSequence).append(string3);
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    charSequence = "Cancelling pending operation ";
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append(object);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                    Log.v((String)charSequence3, (String)charSequence2);
                }
                ((SpecialEffectsController$Operation)object).cancel();
            }
            return;
        }
    }

    public void forcePostponedExecutePendingOperations() {
        boolean bl2 = this.mIsContainerPostponed;
        if (bl2) {
            bl2 = false;
            this.mIsContainerPostponed = false;
            this.executePendingOperations();
        }
    }

    public SpecialEffectsController$Operation$LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager object) {
        Object object2 = ((FragmentStateManager)object).getFragment();
        if ((object2 = this.findPendingOperation((Fragment)object2)) != null) {
            return ((SpecialEffectsController$Operation)object2).getLifecycleImpact();
        }
        object = ((FragmentStateManager)object).getFragment();
        if ((object = this.findRunningOperation((Fragment)object)) != null) {
            return ((SpecialEffectsController$Operation)object).getLifecycleImpact();
        }
        return null;
    }

    public ViewGroup getContainer() {
        return this.mContainer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void markPostponedState() {
        ArrayList arrayList = this.mPendingOperations;
        synchronized (arrayList) {
            this.updateFinalState();
            int n10 = 0;
            Object object = null;
            this.mIsContainerPostponed = false;
            object = this.mPendingOperations;
            for (n10 = ((ArrayList)object).size() + -1; n10 >= 0; n10 += -1) {
                SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
                Object object2 = this.mPendingOperations;
                object2 = ((ArrayList)object2).get(n10);
                object2 = (SpecialEffectsController$Operation)object2;
                Object object3 = ((SpecialEffectsController$Operation)object2).getFragment();
                object3 = object3.mView;
                object3 = SpecialEffectsController$Operation$State.from((View)object3);
                SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = ((SpecialEffectsController$Operation)object2).getFinalState();
                if (specialEffectsController$Operation$State2 != (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE) || object3 == specialEffectsController$Operation$State) continue;
                object = ((SpecialEffectsController$Operation)object2).getFragment();
                n10 = (int)(((Fragment)object).isPostponed() ? 1 : 0);
                this.mIsContainerPostponed = n10;
                break;
            }
            return;
        }
    }

    public void updateOperationDirection(boolean bl2) {
        this.mOperationDirectionIsPop = bl2;
    }
}

