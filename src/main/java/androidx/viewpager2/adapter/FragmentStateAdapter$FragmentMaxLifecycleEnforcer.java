/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.adapter;

import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2;
import androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;

public class FragmentStateAdapter$FragmentMaxLifecycleEnforcer {
    private RecyclerView$AdapterDataObserver mDataObserver;
    private LifecycleEventObserver mLifecycleObserver;
    private ViewPager2$OnPageChangeCallback mPageChangeCallback;
    private long mPrimaryItemId = -1;
    private ViewPager2 mViewPager;
    public final /* synthetic */ FragmentStateAdapter this$0;

    public FragmentStateAdapter$FragmentMaxLifecycleEnforcer(FragmentStateAdapter fragmentStateAdapter) {
        this.this$0 = fragmentStateAdapter;
    }

    private ViewPager2 inferViewPager(RecyclerView object) {
        boolean bl2 = (object = object.getParent()) instanceof ViewPager2;
        if (bl2) {
            return (ViewPager2)((Object)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ViewPager2 instance. Got: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public void register(RecyclerView object) {
        object = this.inferViewPager((RecyclerView)object);
        this.mViewPager = object;
        object = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1(this);
        this.mPageChangeCallback = object;
        this.mViewPager.registerOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object);
        object = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2(this);
        this.mDataObserver = object;
        this.this$0.registerAdapterDataObserver((RecyclerView$AdapterDataObserver)object);
        object = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(this);
        this.mLifecycleObserver = object;
        this.this$0.mLifecycle.addObserver((LifecycleObserver)object);
    }

    public void unregister(RecyclerView object) {
        object = this.inferViewPager((RecyclerView)object);
        Object object2 = this.mPageChangeCallback;
        ((ViewPager2)((Object)object)).unregisterOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object2);
        object = this.this$0;
        object2 = this.mDataObserver;
        ((RecyclerView$Adapter)object).unregisterAdapterDataObserver((RecyclerView$AdapterDataObserver)object2);
        object = this.this$0.mLifecycle;
        object2 = this.mLifecycleObserver;
        ((Lifecycle)object).removeObserver((LifecycleObserver)object2);
        this.mViewPager = null;
    }

    public void updateFragmentMaxLifecycle(boolean bl2) {
        Object object = this.this$0;
        int n10 = object.shouldDelayFragmentTransactions();
        if (n10 != 0) {
            return;
        }
        object = this.mViewPager;
        n10 = ((ViewPager2)((Object)object)).getScrollState();
        if (n10 != 0) {
            return;
        }
        object = this.this$0.mFragments;
        n10 = (int)(((LongSparseArray)object).isEmpty() ? 1 : 0);
        if (n10 == 0 && (n10 = (object = this.this$0).getItemCount()) != 0) {
            long l10;
            Object object2;
            int n11;
            object = this.mViewPager;
            n10 = ((ViewPager2)((Object)object)).getCurrentItem();
            if (n10 >= (n11 = (object2 = this.this$0).getItemCount())) {
                return;
            }
            object2 = this.this$0;
            long l11 = object2.getItemId(n10);
            long l12 = l11 - (l10 = this.mPrimaryItemId);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 == false && !bl2) {
                return;
            }
            Object object4 = (Fragment)this.this$0.mFragments.get(l11);
            if (object4 != null && (bl2 = ((Fragment)object4).isAdded())) {
                LongSparseArray longSparseArray;
                boolean bl3;
                this.mPrimaryItemId = l11;
                object4 = this.this$0.mFragmentManager.beginTransaction();
                n10 = 0;
                object = null;
                n11 = 0;
                object2 = null;
                for (object3 = (Object)0; object3 < (bl3 = (longSparseArray = this.this$0.mFragments).size()); ++object3) {
                    longSparseArray = this.this$0.mFragments;
                    long l13 = longSparseArray.keyAt((int)object3);
                    Fragment fragment = (Fragment)this.this$0.mFragments.valueAt((int)object3);
                    Object object5 = fragment.isAdded();
                    if (!object5) continue;
                    long l14 = this.mPrimaryItemId;
                    long l15 = l13 - l14;
                    object5 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                    if (object5) {
                        Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
                        ((FragmentTransaction)object4).setMaxLifecycle(fragment, lifecycle$State);
                    } else {
                        object = fragment;
                    }
                    l14 = this.mPrimaryItemId;
                    bl3 = (boolean)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1));
                    if (!bl3) {
                        bl3 = true;
                    } else {
                        bl3 = false;
                        longSparseArray = null;
                    }
                    fragment.setMenuVisibility(bl3);
                }
                if (object != null) {
                    object2 = Lifecycle$State.RESUMED;
                    ((FragmentTransaction)object4).setMaxLifecycle((Fragment)object, (Lifecycle$State)((Object)object2));
                }
                if ((n10 = (int)(((FragmentTransaction)object4).isEmpty() ? 1 : 0)) == 0) {
                    ((FragmentTransaction)object4).commitNow();
                }
            }
        }
    }
}

