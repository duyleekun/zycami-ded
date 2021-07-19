/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import java.util.concurrent.CopyOnWriteArrayList;

public class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList mLifecycleCallbacks;

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.mLifecycleCallbacks = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mFragmentManager = fragmentManager;
    }

    public void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentActivityCreated(fragment, bundle, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentActivityCreated(fragmentManager, fragment, bundle);
        }
    }

    public void dispatchOnFragmentAttached(Fragment fragment, boolean bl2) {
        boolean bl3;
        Context context = this.mFragmentManager.getHost().getContext();
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentAttached(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentAttached(fragmentManager, fragment, context);
        }
    }

    public void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentCreated(fragment, bundle, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentCreated(fragmentManager, fragment, bundle);
        }
    }

    public void dispatchOnFragmentDestroyed(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentDestroyed(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentDestroyed(fragmentManager, fragment);
        }
    }

    public void dispatchOnFragmentDetached(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentDetached(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentDetached(fragmentManager, fragment);
        }
    }

    public void dispatchOnFragmentPaused(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentPaused(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentPaused(fragmentManager, fragment);
        }
    }

    public void dispatchOnFragmentPreAttached(Fragment fragment, boolean bl2) {
        boolean bl3;
        Context context = this.mFragmentManager.getHost().getContext();
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentPreAttached(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentPreAttached(fragmentManager, fragment, context);
        }
    }

    public void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentPreCreated(fragment, bundle, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentPreCreated(fragmentManager, fragment, bundle);
        }
    }

    public void dispatchOnFragmentResumed(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentResumed(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentResumed(fragmentManager, fragment);
        }
    }

    public void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentSaveInstanceState(fragment, bundle, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
        }
    }

    public void dispatchOnFragmentStarted(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentStarted(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentStarted(fragmentManager, fragment);
        }
    }

    public void dispatchOnFragmentStopped(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentStopped(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentStopped(fragmentManager, fragment);
        }
    }

    public void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentViewCreated(fragment, view, bundle, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        }
    }

    public void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean bl2) {
        boolean bl3;
        Object object = this.mFragmentManager.getParent();
        if (object != null) {
            object = ((Fragment)object).getParentFragmentManager().getLifecycleCallbacksDispatcher();
            bl3 = true;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentViewDestroyed(fragment, bl3);
        }
        object = this.mLifecycleCallbacks.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            Object object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object.next();
            if (bl2 && !(bl4 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mRecursive)) continue;
            object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
            FragmentManager fragmentManager = this.mFragmentManager;
            ((FragmentManager$FragmentLifecycleCallbacks)object2).onFragmentViewDestroyed(fragmentManager, fragment);
        }
    }

    public void registerFragmentLifecycleCallbacks(FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks, boolean bl2) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mLifecycleCallbacks;
        FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder = new FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder(fragmentManager$FragmentLifecycleCallbacks, bl2);
        copyOnWriteArrayList.add(fragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterFragmentLifecycleCallbacks(FragmentManager$FragmentLifecycleCallbacks object) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mLifecycleCallbacks;
        synchronized (copyOnWriteArrayList) {
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.mLifecycleCallbacks;
            int n10 = copyOnWriteArrayList2.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = this.mLifecycleCallbacks;
                object2 = ((CopyOnWriteArrayList)object2).get(i10);
                object2 = (FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2;
                object2 = ((FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder)object2).mCallback;
                if (object2 != object) continue;
                object = this.mLifecycleCallbacks;
                ((CopyOnWriteArrayList)object).remove(i10);
                break;
            }
            return;
        }
    }
}

