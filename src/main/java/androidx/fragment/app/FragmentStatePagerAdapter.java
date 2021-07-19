/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$SavedState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle$State;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

public abstract class FragmentStatePagerAdapter
extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;
    private ArrayList mFragments;
    private ArrayList mSavedState;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager, int n10) {
        ArrayList arrayList;
        this.mSavedState = arrayList = new ArrayList();
        this.mFragments = arrayList = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = n10;
    }

    public void destroyItem(ViewGroup object, int n10, Object object2) {
        Fragment$SavedState fragment$SavedState;
        int n11;
        object2 = (Fragment)object2;
        object = this.mCurTransaction;
        if (object == null) {
            this.mCurTransaction = object = this.mFragmentManager.beginTransaction();
        }
        while ((n11 = ((ArrayList)(object = this.mSavedState)).size()) <= n10) {
            object = this.mSavedState;
            ((ArrayList)object).add(null);
        }
        object = this.mSavedState;
        boolean bl2 = ((Fragment)object2).isAdded();
        if (bl2) {
            fragment$SavedState = this.mFragmentManager.saveFragmentInstanceState((Fragment)object2);
        } else {
            bl2 = false;
            fragment$SavedState = null;
        }
        ((ArrayList)object).set(n10, fragment$SavedState);
        this.mFragments.set(n10, null);
        this.mCurTransaction.remove((Fragment)object2);
        object = this.mCurrentPrimaryItem;
        n11 = (int)(((Fragment)object2).equals(object) ? 1 : 0);
        if (n11 != 0) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void finishUpdate(ViewGroup object) {
        object = this.mCurTransaction;
        if (object != null) {
            boolean bl2 = this.mExecutingFinishUpdate;
            if (!bl2) {
                bl2 = true;
                try {
                    this.mExecutingFinishUpdate = bl2;
                    ((FragmentTransaction)object).commitNowAllowingStateLoss();
                }
                finally {
                    this.mExecutingFinishUpdate = false;
                }
            }
            object = null;
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int var1);

    public Object instantiateItem(ViewGroup object, int n10) {
        int n11;
        Object object2 = this.mFragments;
        int n12 = ((ArrayList)object2).size();
        if (n12 > n10 && (object2 = (Fragment)this.mFragments.get(n10)) != null) {
            return object2;
        }
        object2 = this.mCurTransaction;
        if (object2 == null) {
            this.mCurTransaction = object2 = this.mFragmentManager.beginTransaction();
        }
        object2 = this.getItem(n10);
        Object object3 = this.mSavedState;
        int n13 = ((ArrayList)object3).size();
        if (n13 > n10 && (object3 = (Fragment$SavedState)this.mSavedState.get(n10)) != null) {
            ((Fragment)object2).setInitialSavedState((Fragment$SavedState)object3);
        }
        while ((n13 = ((ArrayList)(object3 = this.mFragments)).size()) <= n10) {
            object3 = this.mFragments;
            n11 = 0;
            ((ArrayList)object3).add(null);
        }
        n13 = 0;
        object3 = null;
        ((Fragment)object2).setMenuVisibility(false);
        n11 = this.mBehavior;
        if (n11 == 0) {
            ((Fragment)object2).setUserVisibleHint(false);
        }
        object3 = this.mFragments;
        ((ArrayList)object3).set(n10, object2);
        Object object4 = this.mCurTransaction;
        int n14 = object.getId();
        object4.add(n14, (Fragment)object2);
        n14 = this.mBehavior;
        n10 = 1;
        if (n14 == n10) {
            object = this.mCurTransaction;
            object4 = Lifecycle$State.STARTED;
            ((FragmentTransaction)object).setMaxLifecycle((Fragment)object2, (Lifecycle$State)((Object)object4));
        }
        return object2;
    }

    public boolean isViewFromObject(View view, Object object) {
        boolean bl2;
        if ((object = ((Fragment)object).getView()) == view) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void restoreState(Parcelable parcelable, ClassLoader object) {
        if (parcelable != null) {
            Object object2;
            Object object3;
            int n10;
            int n11;
            Object object4;
            parcelable = (Bundle)parcelable;
            parcelable.setClassLoader((ClassLoader)object);
            object = parcelable.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (object != null) {
                object4 = null;
                for (n11 = 0; n11 < (n10 = ((Parcelable[])object).length); ++n11) {
                    object3 = this.mSavedState;
                    object2 = (Fragment$SavedState)object[n11];
                    ((ArrayList)object3).add(object2);
                }
            }
            object = parcelable.keySet().iterator();
            while ((n11 = object.hasNext()) != 0) {
                object4 = (String)object.next();
                n10 = (int)(((String)object4).startsWith((String)(object3 = "f")) ? 1 : 0);
                if (n10 == 0) continue;
                object3 = ((String)object4).substring(1);
                n10 = Integer.parseInt((String)object3);
                object2 = this.mFragmentManager.getFragment((Bundle)parcelable, (String)object4);
                if (object2 != null) {
                    while ((n11 = ((ArrayList)(object4 = this.mFragments)).size()) <= n10) {
                        object4 = this.mFragments;
                        ((ArrayList)object4).add(null);
                    }
                    ((Fragment)object2).setMenuVisibility(false);
                    object4 = this.mFragments;
                    ((ArrayList)object4).set(n10, object2);
                    continue;
                }
                object3 = new StringBuilder();
                object2 = "Bad fragment at key ";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append((String)object4);
                object4 = ((StringBuilder)object3).toString();
                object3 = "FragmentStatePagerAdapt";
                Log.w((String)object3, (String)object4);
            }
        }
    }

    public Parcelable saveState() {
        int n10;
        Object object;
        Parcelable[] parcelableArray;
        int n11;
        ArrayList arrayList = this.mSavedState;
        int n12 = arrayList.size();
        if (n12 > 0) {
            arrayList = new Bundle();
            n11 = this.mSavedState.size();
            parcelableArray = new Fragment$SavedState[n11];
            this.mSavedState.toArray(parcelableArray);
            object = "states";
            arrayList.putParcelableArray((String)object, parcelableArray);
        } else {
            n12 = 0;
            arrayList = null;
        }
        parcelableArray = null;
        for (n11 = 0; n11 < (n10 = ((ArrayList)(object = this.mFragments)).size()); ++n11) {
            boolean bl2;
            object = (Fragment)this.mFragments.get(n11);
            if (object == null || !(bl2 = ((Fragment)object).isAdded())) continue;
            if (arrayList == null) {
                arrayList = new Bundle();
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("f");
            charSequence.append(n11);
            charSequence = charSequence.toString();
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.putFragment((Bundle)arrayList, (String)charSequence, (Fragment)object);
        }
        return arrayList;
    }

    public void setPrimaryItem(ViewGroup object, int n10, Object object2) {
        object = this.mCurrentPrimaryItem;
        if ((object2 = (Fragment)object2) != object) {
            int n11;
            n10 = 1;
            if (object != null) {
                Fragment fragment = null;
                ((Fragment)object).setMenuVisibility(false);
                n11 = this.mBehavior;
                if (n11 == n10) {
                    object = this.mCurTransaction;
                    if (object == null) {
                        this.mCurTransaction = object = this.mFragmentManager.beginTransaction();
                    }
                    object = this.mCurTransaction;
                    fragment = this.mCurrentPrimaryItem;
                    Lifecycle$State lifecycle$State = Lifecycle$State.STARTED;
                    ((FragmentTransaction)object).setMaxLifecycle(fragment, lifecycle$State);
                } else {
                    object = this.mCurrentPrimaryItem;
                    ((Fragment)object).setUserVisibleHint(false);
                }
            }
            ((Fragment)object2).setMenuVisibility(n10 != 0);
            n11 = this.mBehavior;
            if (n11 == n10) {
                object = this.mCurTransaction;
                if (object == null) {
                    this.mCurTransaction = object = this.mFragmentManager.beginTransaction();
                }
                object = this.mCurTransaction;
                Lifecycle$State lifecycle$State = Lifecycle$State.RESUMED;
                ((FragmentTransaction)object).setMaxLifecycle((Fragment)object2, lifecycle$State);
            } else {
                ((Fragment)object2).setUserVisibleHint(n10 != 0);
            }
            this.mCurrentPrimaryItem = object2;
        }
    }

    public void startUpdate(ViewGroup object) {
        int n10;
        int n11 = object.getId();
        if (n11 != (n10 = -1)) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("ViewPager with adapter ");
        charSequence.append(this);
        charSequence.append(" requires a view id");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }
}

