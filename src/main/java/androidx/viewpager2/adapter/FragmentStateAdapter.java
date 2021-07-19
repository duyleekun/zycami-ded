/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 */
package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$SavedState;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.viewpager2.adapter.FragmentStateAdapter$1;
import androidx.viewpager2.adapter.FragmentStateAdapter$2;
import androidx.viewpager2.adapter.FragmentStateAdapter$3;
import androidx.viewpager2.adapter.FragmentStateAdapter$4;
import androidx.viewpager2.adapter.FragmentStateAdapter$5;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer;
import androidx.viewpager2.adapter.FragmentViewHolder;
import androidx.viewpager2.adapter.StatefulAdapter;

public abstract class FragmentStateAdapter
extends RecyclerView$Adapter
implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000L;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    public final FragmentManager mFragmentManager;
    private FragmentStateAdapter$FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    public final LongSparseArray mFragments;
    private boolean mHasStaleFragments;
    public boolean mIsInGracePeriod;
    private final LongSparseArray mItemIdToViewHolder;
    public final Lifecycle mLifecycle;
    private final LongSparseArray mSavedStates;

    public FragmentStateAdapter(Fragment object) {
        FragmentManager fragmentManager = ((Fragment)object).getChildFragmentManager();
        object = ((Fragment)object).getLifecycle();
        this(fragmentManager, (Lifecycle)object);
    }

    public FragmentStateAdapter(FragmentActivity object) {
        FragmentManager fragmentManager = ((FragmentActivity)object).getSupportFragmentManager();
        object = ((ComponentActivity)object).getLifecycle();
        this(fragmentManager, (Lifecycle)object);
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        LongSparseArray longSparseArray;
        this.mFragments = longSparseArray = new LongSparseArray();
        this.mSavedStates = longSparseArray = new LongSparseArray();
        this.mItemIdToViewHolder = longSparseArray = new LongSparseArray();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    private static String createKey(String string2, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }

    private void ensureFragment(int n10) {
        Object object = this.mFragments;
        long l10 = this.getItemId(n10);
        boolean bl2 = ((LongSparseArray)object).containsKey(l10);
        if (!bl2) {
            Fragment fragment = this.createFragment(n10);
            object = (Fragment$SavedState)this.mSavedStates.get(l10);
            fragment.setInitialSavedState((Fragment$SavedState)object);
            object = this.mFragments;
            ((LongSparseArray)object).put(l10, fragment);
        }
    }

    private boolean isFragmentViewBound(long l10) {
        LongSparseArray longSparseArray = this.mItemIdToViewHolder;
        boolean bl2 = longSparseArray.containsKey(l10);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        longSparseArray = this.mFragments;
        Fragment fragment = (Fragment)longSparseArray.get(l10);
        if (fragment == null) {
            return false;
        }
        if ((fragment = fragment.getView()) == null) {
            return false;
        }
        if ((fragment = fragment.getParent()) == null) {
            bl3 = false;
        }
        return bl3;
    }

    private static boolean isValidKey(String string2, String string3) {
        int n10;
        int n11;
        boolean bl2 = string2.startsWith(string3);
        if (bl2 && (n11 = string2.length()) > (n10 = string3.length())) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        return n11 != 0;
    }

    private Long itemForViewHolder(int n10) {
        Object object;
        int n11;
        Long l10 = null;
        for (int i10 = 0; i10 < (n11 = ((LongSparseArray)(object = this.mItemIdToViewHolder)).size()); ++i10) {
            object = (Integer)this.mItemIdToViewHolder.valueAt(i10);
            n11 = (Integer)object;
            if (n11 != n10) continue;
            if (l10 == null) {
                long l11 = this.mItemIdToViewHolder.keyAt(i10);
                l10 = l11;
                continue;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
            throw illegalStateException;
        }
        return l10;
    }

    private static long parseIdFromKey(String string2, String string3) {
        int n10 = string3.length();
        return Long.parseLong(string2.substring(n10));
    }

    private void removeFragment(long l10) {
        boolean bl2;
        Fragment fragment = (Fragment)this.mFragments.get(l10);
        if (fragment == null) {
            return;
        }
        Object object = fragment.getView();
        if (object != null && (object = fragment.getView().getParent()) != null) {
            object = (FrameLayout)object;
            object.removeAllViews();
        }
        if (!(bl2 = this.containsItem(l10))) {
            object = this.mSavedStates;
            ((LongSparseArray)object).remove(l10);
        }
        if (!(bl2 = fragment.isAdded())) {
            this.mFragments.remove(l10);
            return;
        }
        bl2 = this.shouldDelayFragmentTransactions();
        if (bl2) {
            this.mHasStaleFragments = true;
            return;
        }
        bl2 = fragment.isAdded();
        if (bl2 && (bl2 = this.containsItem(l10))) {
            object = this.mSavedStates;
            Fragment$SavedState fragment$SavedState = this.mFragmentManager.saveFragmentInstanceState(fragment);
            ((LongSparseArray)object).put(l10, fragment$SavedState);
        }
        this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
        this.mFragments.remove(l10);
    }

    private void scheduleGracePeriodEnd() {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new FragmentStateAdapter$4(this);
        Lifecycle lifecycle = this.mLifecycle;
        FragmentStateAdapter$5 fragmentStateAdapter$5 = new FragmentStateAdapter$5(this, handler, (Runnable)object);
        lifecycle.addObserver(fragmentStateAdapter$5);
        handler.postDelayed((Runnable)object, 10000L);
    }

    private void scheduleViewAttach(Fragment fragment, FrameLayout frameLayout) {
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentStateAdapter$3 fragmentStateAdapter$3 = new FragmentStateAdapter$3(this, fragment, frameLayout);
        fragmentManager.registerFragmentLifecycleCallbacks(fragmentStateAdapter$3, false);
    }

    public void addViewToContainer(View object, FrameLayout frameLayout) {
        int n10;
        int n11 = frameLayout.getChildCount();
        if (n11 <= (n10 = 1)) {
            ViewParent viewParent = object.getParent();
            if (viewParent == frameLayout) {
                return;
            }
            n11 = frameLayout.getChildCount();
            if (n11 > 0) {
                frameLayout.removeAllViews();
            }
            if ((viewParent = object.getParent()) != null) {
                viewParent = (ViewGroup)object.getParent();
                viewParent.removeView(object);
            }
            frameLayout.addView(object);
            return;
        }
        object = new IllegalStateException("Design assumption violated.");
        throw object;
    }

    public boolean containsItem(long l10) {
        long l11;
        int n10;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        n10 = object >= 0 && (n10 = (l11 = l10 - (l12 = (long)(object = (Object)this.getItemCount()))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0 ? 1 : 0;
        return n10 != 0;
    }

    public abstract Fragment createFragment(int var1);

    public void gcFragments() {
        boolean bl2 = this.mHasStaleFragments;
        if (bl2 && !(bl2 = this.shouldDelayFragmentTransactions())) {
            LongSparseArray longSparseArray;
            int n10;
            int n11;
            Object object = new ArraySet();
            int n12 = 0;
            Long l10 = null;
            Object object2 = null;
            for (n11 = 0; n11 < (n10 = (longSparseArray = this.mFragments).size()); ++n11) {
                longSparseArray = this.mFragments;
                long l11 = longSparseArray.keyAt(n11);
                boolean bl3 = this.containsItem(l11);
                if (bl3) continue;
                Object object3 = l11;
                object.add(object3);
                object3 = this.mItemIdToViewHolder;
                ((LongSparseArray)object3).remove(l11);
            }
            n11 = (int)(this.mIsInGracePeriod ? 1 : 0);
            if (n11 == 0) {
                this.mHasStaleFragments = false;
                while (n12 < (n11 = ((LongSparseArray)(object2 = this.mFragments)).size())) {
                    object2 = this.mFragments;
                    long l12 = ((LongSparseArray)object2).keyAt(n12);
                    boolean bl4 = this.isFragmentViewBound(l12);
                    if (!bl4) {
                        object2 = l12;
                        object.add(object2);
                    }
                    ++n12;
                }
            }
            object = object.iterator();
            while ((n12 = object.hasNext()) != 0) {
                l10 = (Long)object.next();
                long l13 = l10;
                this.removeFragment(l13);
            }
        }
    }

    public long getItemId(int n10) {
        return n10;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean bl2;
        FragmentStateAdapter$FragmentMaxLifecycleEnforcer fragmentStateAdapter$FragmentMaxLifecycleEnforcer = this.mFragmentMaxLifecycleEnforcer;
        if (fragmentStateAdapter$FragmentMaxLifecycleEnforcer == null) {
            bl2 = true;
        } else {
            bl2 = false;
            fragmentStateAdapter$FragmentMaxLifecycleEnforcer = null;
        }
        Preconditions.checkArgument(bl2);
        this.mFragmentMaxLifecycleEnforcer = fragmentStateAdapter$FragmentMaxLifecycleEnforcer = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer(this);
        fragmentStateAdapter$FragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    public final void onBindViewHolder(FragmentViewHolder object, int n10) {
        long l10;
        long l11;
        long l12;
        long l13 = ((RecyclerView$ViewHolder)object).getItemId();
        Object object2 = ((FragmentViewHolder)object).getContainer();
        int n11 = object2.getId();
        Object object3 = this.itemForViewHolder(n11);
        if (object3 != null && (l12 = (l11 = (l10 = ((Long)object3).longValue()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            l10 = (Long)object3;
            this.removeFragment(l10);
            LongSparseArray longSparseArray = this.mItemIdToViewHolder;
            long l14 = (Long)object3;
            longSparseArray.remove(l14);
        }
        object3 = this.mItemIdToViewHolder;
        object2 = n11;
        ((LongSparseArray)object3).put(l13, object2);
        this.ensureFragment(n10);
        FrameLayout frameLayout = ((FragmentViewHolder)object).getContainer();
        boolean bl2 = ViewCompat.isAttachedToWindow((View)frameLayout);
        if (bl2) {
            Object object4 = frameLayout.getParent();
            if (object4 == null) {
                object4 = new FragmentStateAdapter$1(this, frameLayout, (FragmentViewHolder)object);
                frameLayout.addOnLayoutChangeListener((View.OnLayoutChangeListener)object4);
            } else {
                object = new IllegalStateException("Design assumption violated.");
                throw object;
            }
        }
        this.gcFragments();
    }

    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        return FragmentViewHolder.create(viewGroup);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        this.placeFragmentInViewHolder(fragmentViewHolder);
        this.gcFragments();
    }

    public final void onViewRecycled(FragmentViewHolder object) {
        int n10 = ((FragmentViewHolder)object).getContainer().getId();
        if ((object = this.itemForViewHolder(n10)) != null) {
            long l10 = (Long)object;
            this.removeFragment(l10);
            LongSparseArray longSparseArray = this.mItemIdToViewHolder;
            long l11 = (Long)object;
            longSparseArray.remove(l11);
        }
    }

    public void placeFragmentInViewHolder(FragmentViewHolder object) {
        Object object2 = this.mFragments;
        long l10 = ((RecyclerView$ViewHolder)object).getItemId();
        object2 = (Fragment)((LongSparseArray)object2).get(l10);
        Object object3 = "Design assumption violated.";
        if (object2 != null) {
            Object object4 = ((FragmentViewHolder)object).getContainer();
            Object object5 = ((Fragment)object2).getView();
            boolean bl2 = ((Fragment)object2).isAdded();
            if (!bl2 && object5 != null) {
                object = new IllegalStateException((String)object3);
                throw object;
            }
            boolean bl3 = ((Fragment)object2).isAdded();
            if (bl3 && object5 == null) {
                this.scheduleViewAttach((Fragment)object2, (FrameLayout)object4);
                return;
            }
            bl3 = ((Fragment)object2).isAdded();
            if (bl3 && (object3 = object5.getParent()) != null) {
                object = object5.getParent();
                if (object != object4) {
                    this.addViewToContainer((View)object5, (FrameLayout)object4);
                }
                return;
            }
            bl3 = ((Fragment)object2).isAdded();
            if (bl3) {
                this.addViewToContainer((View)object5, (FrameLayout)object4);
                return;
            }
            bl3 = this.shouldDelayFragmentTransactions();
            if (!bl3) {
                this.scheduleViewAttach((Fragment)object2, (FrameLayout)object4);
                object3 = this.mFragmentManager.beginTransaction();
                object4 = new StringBuilder();
                object5 = "f";
                ((StringBuilder)object4).append((String)object5);
                long l11 = ((RecyclerView$ViewHolder)object).getItemId();
                ((StringBuilder)object4).append(l11);
                object = ((StringBuilder)object4).toString();
                object = ((FragmentTransaction)object3).add((Fragment)object2, (String)object);
                object3 = Lifecycle$State.STARTED;
                ((FragmentTransaction)object).setMaxLifecycle((Fragment)object2, (Lifecycle$State)((Object)object3)).commitNow();
                object = this.mFragmentMaxLifecycleEnforcer;
                boolean bl4 = false;
                object2 = null;
                ((FragmentStateAdapter$FragmentMaxLifecycleEnforcer)object).updateFragmentMaxLifecycle(false);
            } else {
                object2 = this.mFragmentManager;
                boolean bl5 = ((FragmentManager)object2).isDestroyed();
                if (bl5) {
                    return;
                }
                object2 = this.mLifecycle;
                object3 = new FragmentStateAdapter$2(this, (FragmentViewHolder)object);
                ((Lifecycle)object2).addObserver((LifecycleObserver)object3);
            }
            return;
        }
        object = new IllegalStateException((String)object3);
        throw object;
    }

    public final void restoreState(Parcelable object) {
        Object object2 = this.mSavedStates;
        boolean bl2 = ((LongSparseArray)object2).isEmpty();
        if (bl2 && (bl2 = ((LongSparseArray)(object2 = this.mFragments)).isEmpty())) {
            boolean bl3;
            object2 = (object = (Bundle)object).getClassLoader();
            if (object2 == null) {
                object2 = this.getClass().getClassLoader();
                object.setClassLoader(object2);
            }
            object2 = object.keySet().iterator();
            while (bl3 = object2.hasNext()) {
                LongSparseArray longSparseArray;
                long l10;
                String string2;
                Object object3 = (String)object2.next();
                boolean bl4 = FragmentStateAdapter.isValidKey((String)object3, string2 = "f#");
                if (bl4) {
                    l10 = FragmentStateAdapter.parseIdFromKey((String)object3, string2);
                    object3 = this.mFragmentManager.getFragment((Bundle)object, (String)object3);
                    longSparseArray = this.mFragments;
                    longSparseArray.put(l10, object3);
                    continue;
                }
                string2 = "s#";
                bl4 = FragmentStateAdapter.isValidKey((String)object3, string2);
                if (bl4) {
                    l10 = FragmentStateAdapter.parseIdFromKey((String)object3, string2);
                    object3 = (Fragment$SavedState)object.getParcelable((String)object3);
                    boolean bl5 = this.containsItem(l10);
                    if (!bl5) continue;
                    longSparseArray = this.mSavedStates;
                    longSparseArray.put(l10, object3);
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unexpected key in savedState: ");
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object = this.mFragments;
            boolean bl6 = ((LongSparseArray)object).isEmpty();
            if (!bl6) {
                this.mHasStaleFragments = bl6 = true;
                this.mIsInGracePeriod = bl6;
                this.gcFragments();
                this.scheduleGracePeriodEnd();
            }
            return;
        }
        object = new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        throw object;
    }

    public final Parcelable saveState() {
        Object object;
        Object object2;
        Object object3;
        int n10;
        int n11 = this.mFragments.size();
        int n12 = this.mSavedStates.size();
        Bundle bundle = new Bundle(n11 += n12);
        n11 = 0;
        LongSparseArray longSparseArray = null;
        for (n12 = 0; n12 < (n10 = ((LongSparseArray)(object3 = this.mFragments)).size()); ++n12) {
            boolean bl2;
            object3 = this.mFragments;
            long l10 = ((LongSparseArray)object3).keyAt(n12);
            object2 = (Fragment)this.mFragments.get(l10);
            if (object2 == null || !(bl2 = ((Fragment)object2).isAdded())) continue;
            String string2 = "f#";
            object3 = FragmentStateAdapter.createKey(string2, l10);
            object = this.mFragmentManager;
            ((FragmentManager)object).putFragment(bundle, (String)object3, (Fragment)object2);
        }
        while (n11 < (n12 = (longSparseArray = this.mSavedStates).size())) {
            longSparseArray = this.mSavedStates;
            long l11 = longSparseArray.keyAt(n11);
            boolean bl3 = this.containsItem(l11);
            if (bl3) {
                object = FragmentStateAdapter.createKey("s#", l11);
                object2 = this.mSavedStates;
                longSparseArray = (Parcelable)((LongSparseArray)object2).get(l11);
                bundle.putParcelable((String)object, (Parcelable)longSparseArray);
            }
            ++n11;
        }
        return bundle;
    }

    public final void setHasStableIds(boolean bl2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
        throw unsupportedOperationException;
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }
}

