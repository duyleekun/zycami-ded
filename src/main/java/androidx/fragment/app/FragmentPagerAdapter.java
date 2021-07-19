/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle$State;
import androidx.viewpager.widget.PagerAdapter;

public abstract class FragmentPagerAdapter
extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager, int n10) {
        this.mFragmentManager = fragmentManager;
        this.mBehavior = n10;
    }

    private static String makeFragmentName(int n10, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android:switcher:");
        stringBuilder.append(n10);
        stringBuilder.append(":");
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }

    public void destroyItem(ViewGroup object, int n10, Object object2) {
        object2 = (Fragment)object2;
        object = this.mCurTransaction;
        if (object == null) {
            object = this.mFragmentManager.beginTransaction();
            this.mCurTransaction = object;
        }
        this.mCurTransaction.detach((Fragment)object2);
        object = this.mCurrentPrimaryItem;
        boolean bl2 = ((Fragment)object2).equals(object);
        if (bl2) {
            bl2 = false;
            object = null;
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

    public long getItemId(int n10) {
        return n10;
    }

    public Object instantiateItem(ViewGroup object, int n10) {
        int n11;
        Object object2;
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction == null) {
            this.mCurTransaction = fragmentTransaction = this.mFragmentManager.beginTransaction();
        }
        long l10 = this.getItemId(n10);
        int n12 = object.getId();
        Object object3 = FragmentPagerAdapter.makeFragmentName(n12, l10);
        FragmentManager fragmentManager = this.mFragmentManager;
        if ((object3 = fragmentManager.findFragmentByTag((String)object3)) != null) {
            object = this.mCurTransaction;
            ((FragmentTransaction)object).attach((Fragment)object3);
        } else {
            object3 = this.getItem(n10);
            object2 = this.mCurTransaction;
            int n13 = object.getId();
            n11 = object.getId();
            object = FragmentPagerAdapter.makeFragmentName(n11, l10);
            object2.add(n13, (Fragment)object3, (String)object);
        }
        object = this.mCurrentPrimaryItem;
        if (object3 != object) {
            n11 = 0;
            object = null;
            ((Fragment)object3).setMenuVisibility(false);
            n10 = this.mBehavior;
            int n14 = 1;
            if (n10 == n14) {
                object = this.mCurTransaction;
                object2 = Lifecycle$State.STARTED;
                ((FragmentTransaction)object).setMaxLifecycle((Fragment)object3, (Lifecycle$State)((Object)object2));
            } else {
                ((Fragment)object3).setUserVisibleHint(false);
            }
        }
        return object3;
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

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
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

