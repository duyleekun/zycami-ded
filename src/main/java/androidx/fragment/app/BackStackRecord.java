/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 */
package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$OnStartEnterTransitionListener;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$BackStackEntry;
import androidx.fragment.app.FragmentManager$OpGenerator;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransaction$Op;
import androidx.fragment.app.LogWriter;
import androidx.lifecycle.Lifecycle$State;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public final class BackStackRecord
extends FragmentTransaction
implements FragmentManager$BackStackEntry,
FragmentManager$OpGenerator {
    private static final String TAG = "FragmentManager";
    public boolean mCommitted;
    public int mIndex;
    public final FragmentManager mManager;

    public BackStackRecord(FragmentManager fragmentManager) {
        FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
        Object object = fragmentManager.getHost();
        object = object != null ? fragmentManager.getHost().getContext().getClassLoader() : null;
        super(fragmentFactory, (ClassLoader)object);
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    private static boolean isFragmentPostponed(FragmentTransaction$Op object) {
        boolean bl2;
        View view;
        boolean bl3;
        object = ((FragmentTransaction$Op)object).mFragment;
        if (object != null && (bl3 = ((Fragment)object).mAdded) && (view = ((Fragment)object).mView) != null && !(bl3 = ((Fragment)object).mDetached) && !(bl3 = ((Fragment)object).mHidden) && (bl2 = ((Fragment)object).isPostponed())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void bumpBackStackNesting(int n10) {
        String string2;
        Object object;
        int n11 = this.mAddToBackStack;
        if (n11 == 0) {
            return;
        }
        n11 = 2;
        int n12 = FragmentManager.isLoggingEnabled(n11);
        String string3 = TAG;
        if (n12 != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Bump nesting in ");
            ((StringBuilder)object).append(this);
            string2 = " by ";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Log.v((String)string3, (String)object);
        }
        object = this.mOps;
        n12 = ((ArrayList)object).size();
        string2 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13;
            Object object2 = (FragmentTransaction$Op)this.mOps.get(i10);
            Object object3 = ((FragmentTransaction$Op)object2).mFragment;
            if (object3 == null) continue;
            ((Fragment)object3).mBackStackNesting = n13 = ((Fragment)object3).mBackStackNesting + n10;
            boolean bl2 = FragmentManager.isLoggingEnabled(n11);
            if (!bl2) continue;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Bump nesting of ");
            Object object4 = ((FragmentTransaction$Op)object2).mFragment;
            ((StringBuilder)object3).append(object4);
            object4 = " to ";
            ((StringBuilder)object3).append((String)object4);
            int n14 = object2.mFragment.mBackStackNesting;
            ((StringBuilder)object3).append(n14);
            object2 = ((StringBuilder)object3).toString();
            Log.v((String)string3, (String)object2);
        }
    }

    public int commit() {
        return this.commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }

    public int commitInternal(boolean bl2) {
        int n10 = this.mCommitted;
        if (n10 == 0) {
            Object object;
            n10 = FragmentManager.isLoggingEnabled(2);
            if (n10 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Commit: ");
                ((StringBuilder)object).append(this);
                object = ((StringBuilder)object).toString();
                Object object2 = TAG;
                Log.v((String)object2, (String)object);
                object = new LogWriter((String)object2);
                object2 = new PrintWriter((Writer)object);
                object = "  ";
                this.dump((String)object, (PrintWriter)object2);
                ((PrintWriter)object2).close();
            }
            this.mCommitted = true;
            n10 = this.mAddToBackStack;
            if (n10 != 0) {
                object = this.mManager;
                this.mIndex = n10 = ((FragmentManager)object).allocBackStackIndex();
            } else {
                this.mIndex = n10 = -1;
            }
            this.mManager.enqueueAction(this, bl2);
            return this.mIndex;
        }
        IllegalStateException illegalStateException = new IllegalStateException("commit already called");
        throw illegalStateException;
    }

    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    public FragmentTransaction detach(Fragment object) {
        Object object2;
        Object object3 = ((Fragment)object).mFragmentManager;
        if (object3 != null && object3 != (object2 = this.mManager)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
            object = ((Fragment)object).toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" is already attached to a FragmentManager.");
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        return super.detach((Fragment)object);
    }

    public void doAddOp(int n10, Fragment fragment, String string2, int n11) {
        FragmentManager fragmentManager;
        super.doAddOp(n10, fragment, string2, n11);
        fragment.mFragmentManager = fragmentManager = this.mManager;
    }

    public void dump(String string2, PrintWriter printWriter) {
        this.dump(string2, printWriter, true);
    }

    public void dump(String string2, PrintWriter printWriter, boolean bl2) {
        int n10;
        Object object;
        if (bl2) {
            printWriter.print(string2);
            printWriter.print("mName=");
            object = this.mName;
            printWriter.print((String)object);
            printWriter.print(" mIndex=");
            n10 = this.mIndex;
            printWriter.print(n10);
            object = " mCommitted=";
            printWriter.print((String)object);
            n10 = (int)(this.mCommitted ? 1 : 0);
            printWriter.println(n10 != 0);
            n10 = this.mTransition;
            if (n10 != 0) {
                printWriter.print(string2);
                printWriter.print("mTransition=#");
                n10 = this.mTransition;
                object = Integer.toHexString(n10);
                printWriter.print((String)object);
            }
            if ((n10 = this.mEnterAnim) != 0 || (n10 = this.mExitAnim) != 0) {
                printWriter.print(string2);
                printWriter.print("mEnterAnim=#");
                object = Integer.toHexString(this.mEnterAnim);
                printWriter.print((String)object);
                printWriter.print(" mExitAnim=#");
                n10 = this.mExitAnim;
                object = Integer.toHexString(n10);
                printWriter.println((String)object);
            }
            if ((n10 = this.mPopEnterAnim) != 0 || (n10 = this.mPopExitAnim) != 0) {
                printWriter.print(string2);
                printWriter.print("mPopEnterAnim=#");
                object = Integer.toHexString(this.mPopEnterAnim);
                printWriter.print((String)object);
                printWriter.print(" mPopExitAnim=#");
                n10 = this.mPopExitAnim;
                object = Integer.toHexString(n10);
                printWriter.println((String)object);
            }
            if ((n10 = this.mBreadCrumbTitleRes) != 0 || (object = this.mBreadCrumbTitleText) != null) {
                printWriter.print(string2);
                printWriter.print("mBreadCrumbTitleRes=#");
                n10 = this.mBreadCrumbTitleRes;
                object = Integer.toHexString(n10);
                printWriter.print((String)object);
                printWriter.print(" mBreadCrumbTitleText=");
                object = this.mBreadCrumbTitleText;
                printWriter.println(object);
            }
            if ((n10 = this.mBreadCrumbShortTitleRes) != 0 || (object = this.mBreadCrumbShortTitleText) != null) {
                printWriter.print(string2);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                n10 = this.mBreadCrumbShortTitleRes;
                object = Integer.toHexString(n10);
                printWriter.print((String)object);
                printWriter.print(" mBreadCrumbShortTitleText=");
                object = this.mBreadCrumbShortTitleText;
                printWriter.println(object);
            }
        }
        if ((n10 = ((ArrayList)(object = this.mOps)).isEmpty()) == 0) {
            printWriter.print(string2);
            printWriter.println("Operations:");
            object = this.mOps;
            n10 = ((ArrayList)object).size();
            for (int i10 = 0; i10 < n10; ++i10) {
                String string3;
                Object object2;
                Object object3 = (FragmentTransaction$Op)this.mOps.get(i10);
                int n11 = ((FragmentTransaction$Op)object3).mCmd;
                switch (n11) {
                    default: {
                        object2 = new StringBuilder();
                        string3 = "cmd=";
                        ((StringBuilder)object2).append(string3);
                        int n12 = ((FragmentTransaction$Op)object3).mCmd;
                        ((StringBuilder)object2).append(n12);
                        object2 = ((StringBuilder)object2).toString();
                        break;
                    }
                    case 10: {
                        object2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    case 9: {
                        object2 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 8: {
                        object2 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 7: {
                        object2 = "ATTACH";
                        break;
                    }
                    case 6: {
                        object2 = "DETACH";
                        break;
                    }
                    case 5: {
                        object2 = "SHOW";
                        break;
                    }
                    case 4: {
                        object2 = "HIDE";
                        break;
                    }
                    case 3: {
                        object2 = "REMOVE";
                        break;
                    }
                    case 2: {
                        object2 = "REPLACE";
                        break;
                    }
                    case 1: {
                        object2 = "ADD";
                        break;
                    }
                    case 0: {
                        object2 = "NULL";
                    }
                }
                printWriter.print(string2);
                printWriter.print("  Op #");
                printWriter.print(i10);
                string3 = ": ";
                printWriter.print(string3);
                printWriter.print((String)object2);
                printWriter.print(" ");
                object2 = ((FragmentTransaction$Op)object3).mFragment;
                printWriter.println(object2);
                if (!bl2) continue;
                n11 = ((FragmentTransaction$Op)object3).mEnterAnim;
                if (n11 != 0 || (n11 = ((FragmentTransaction$Op)object3).mExitAnim) != 0) {
                    printWriter.print(string2);
                    printWriter.print("enterAnim=#");
                    object2 = Integer.toHexString(((FragmentTransaction$Op)object3).mEnterAnim);
                    printWriter.print((String)object2);
                    printWriter.print(" exitAnim=#");
                    n11 = ((FragmentTransaction$Op)object3).mExitAnim;
                    object2 = Integer.toHexString(n11);
                    printWriter.println((String)object2);
                }
                if ((n11 = ((FragmentTransaction$Op)object3).mPopEnterAnim) == 0 && (n11 = ((FragmentTransaction$Op)object3).mPopExitAnim) == 0) continue;
                printWriter.print(string2);
                printWriter.print("popEnterAnim=#");
                n11 = ((FragmentTransaction$Op)object3).mPopEnterAnim;
                object2 = Integer.toHexString(n11);
                printWriter.print((String)object2);
                object2 = " popExitAnim=#";
                printWriter.print((String)object2);
                int n13 = ((FragmentTransaction$Op)object3).mPopExitAnim;
                object3 = Integer.toHexString(n13);
                printWriter.println((String)object3);
            }
        }
    }

    public void executeOps() {
        int n10;
        Object object = this.mOps;
        int n11 = ((ArrayList)object).size();
        int n12 = 0;
        CharSequence charSequence = null;
        int n13 = 0;
        while (true) {
            int n14;
            Object object2;
            Object object3;
            int n15;
            n10 = 1;
            if (n13 >= n11) break;
            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op)this.mOps.get(n13);
            Fragment fragment = fragmentTransaction$Op.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(false);
                n15 = this.mTransition;
                fragment.setNextTransition(n15);
                object3 = this.mSharedElementSourceNames;
                object2 = this.mSharedElementTargetNames;
                fragment.setSharedElementNames((ArrayList)object3, (ArrayList)object2);
            }
            n15 = fragmentTransaction$Op.mCmd;
            switch (n15) {
                default: {
                    charSequence = new StringBuilder();
                    charSequence.append("Unknown cmd: ");
                    n13 = fragmentTransaction$Op.mCmd;
                    charSequence.append(n13);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 10: {
                    object3 = this.mManager;
                    object2 = fragmentTransaction$Op.mCurrentMaxState;
                    ((FragmentManager)object3).setMaxLifecycle(fragment, (Lifecycle$State)((Object)object2));
                    break;
                }
                case 9: {
                    object3 = this.mManager;
                    int n16 = 0;
                    object2 = null;
                    ((FragmentManager)object3).setPrimaryNavigationFragment(null);
                    break;
                }
                case 8: {
                    object3 = this.mManager;
                    ((FragmentManager)object3).setPrimaryNavigationFragment(fragment);
                    break;
                }
                case 7: {
                    n15 = fragmentTransaction$Op.mEnterAnim;
                    int n16 = fragmentTransaction$Op.mExitAnim;
                    int n17 = fragmentTransaction$Op.mPopEnterAnim;
                    int n18 = fragmentTransaction$Op.mPopExitAnim;
                    fragment.setAnimations(n15, n16, n17, n18);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    object3 = this.mManager;
                    ((FragmentManager)object3).attachFragment(fragment);
                    break;
                }
                case 6: {
                    n15 = fragmentTransaction$Op.mEnterAnim;
                    int n16 = fragmentTransaction$Op.mExitAnim;
                    int n17 = fragmentTransaction$Op.mPopEnterAnim;
                    int n18 = fragmentTransaction$Op.mPopExitAnim;
                    fragment.setAnimations(n15, n16, n17, n18);
                    object3 = this.mManager;
                    ((FragmentManager)object3).detachFragment(fragment);
                    break;
                }
                case 5: {
                    n15 = fragmentTransaction$Op.mEnterAnim;
                    int n16 = fragmentTransaction$Op.mExitAnim;
                    int n17 = fragmentTransaction$Op.mPopEnterAnim;
                    int n18 = fragmentTransaction$Op.mPopExitAnim;
                    fragment.setAnimations(n15, n16, n17, n18);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    object3 = this.mManager;
                    ((FragmentManager)object3).showFragment(fragment);
                    break;
                }
                case 4: {
                    n15 = fragmentTransaction$Op.mEnterAnim;
                    int n16 = fragmentTransaction$Op.mExitAnim;
                    int n17 = fragmentTransaction$Op.mPopEnterAnim;
                    int n18 = fragmentTransaction$Op.mPopExitAnim;
                    fragment.setAnimations(n15, n16, n17, n18);
                    object3 = this.mManager;
                    ((FragmentManager)object3).hideFragment(fragment);
                    break;
                }
                case 3: {
                    n15 = fragmentTransaction$Op.mEnterAnim;
                    int n16 = fragmentTransaction$Op.mExitAnim;
                    int n17 = fragmentTransaction$Op.mPopEnterAnim;
                    int n18 = fragmentTransaction$Op.mPopExitAnim;
                    fragment.setAnimations(n15, n16, n17, n18);
                    object3 = this.mManager;
                    ((FragmentManager)object3).removeFragment(fragment);
                    break;
                }
                case 1: {
                    n15 = fragmentTransaction$Op.mEnterAnim;
                    int n16 = fragmentTransaction$Op.mExitAnim;
                    int n17 = fragmentTransaction$Op.mPopEnterAnim;
                    int n18 = fragmentTransaction$Op.mPopExitAnim;
                    fragment.setAnimations(n15, n16, n17, n18);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    object3 = this.mManager;
                    ((FragmentManager)object3).addFragment(fragment);
                }
            }
            n15 = (int)(this.mReorderingAllowed ? 1 : 0);
            if (n15 == 0 && (n14 = fragmentTransaction$Op.mCmd) != n10 && fragment != null && (n10 = (int)(FragmentManager.USE_STATE_MANAGER ? 1 : 0)) == 0) {
                FragmentManager fragmentManager = this.mManager;
                fragmentManager.moveFragmentToExpectedState(fragment);
            }
            ++n13;
        }
        n11 = (int)(this.mReorderingAllowed ? 1 : 0);
        if (n11 == 0 && (n11 = (int)(FragmentManager.USE_STATE_MANAGER ? 1 : 0)) == 0) {
            object = this.mManager;
            n12 = ((FragmentManager)object).mCurState;
            ((FragmentManager)object).moveToState(n12, n10 != 0);
        }
    }

    public void executePopOps(boolean bl2) {
        Object object = this.mOps;
        int n10 = ((ArrayList)object).size();
        int n11 = 1;
        n10 -= n11;
        while (n10 >= 0) {
            int n12;
            Object object2;
            Object object3;
            int n13;
            Object object4 = (FragmentTransaction$Op)this.mOps.get(n10);
            Fragment fragment = ((FragmentTransaction$Op)object4).mFragment;
            if (fragment != null) {
                fragment.setPopDirection(n11 != 0);
                n13 = FragmentManager.reverseTransit(this.mTransition);
                fragment.setNextTransition(n13);
                object3 = this.mSharedElementTargetNames;
                object2 = this.mSharedElementSourceNames;
                fragment.setSharedElementNames((ArrayList)object3, (ArrayList)object2);
            }
            n13 = ((FragmentTransaction$Op)object4).mCmd;
            switch (n13) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unknown cmd: ");
                    n11 = ((FragmentTransaction$Op)object4).mCmd;
                    ((StringBuilder)object).append(n11);
                    object = ((StringBuilder)object).toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                case 10: {
                    object3 = this.mManager;
                    object2 = ((FragmentTransaction$Op)object4).mOldMaxState;
                    ((FragmentManager)object3).setMaxLifecycle(fragment, (Lifecycle$State)((Object)object2));
                    break;
                }
                case 9: {
                    object3 = this.mManager;
                    ((FragmentManager)object3).setPrimaryNavigationFragment(fragment);
                    break;
                }
                case 8: {
                    object3 = this.mManager;
                    int n14 = 0;
                    object2 = null;
                    ((FragmentManager)object3).setPrimaryNavigationFragment(null);
                    break;
                }
                case 7: {
                    n13 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    int n14 = ((FragmentTransaction$Op)object4).mExitAnim;
                    int n15 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    int n16 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    fragment.setAnimations(n13, n14, n15, n16);
                    this.mManager.setExitAnimationOrder(fragment, n11 != 0);
                    object3 = this.mManager;
                    ((FragmentManager)object3).detachFragment(fragment);
                    break;
                }
                case 6: {
                    n13 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    int n14 = ((FragmentTransaction$Op)object4).mExitAnim;
                    int n15 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    int n16 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    fragment.setAnimations(n13, n14, n15, n16);
                    object3 = this.mManager;
                    ((FragmentManager)object3).attachFragment(fragment);
                    break;
                }
                case 5: {
                    n13 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    int n14 = ((FragmentTransaction$Op)object4).mExitAnim;
                    int n15 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    int n16 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    fragment.setAnimations(n13, n14, n15, n16);
                    this.mManager.setExitAnimationOrder(fragment, n11 != 0);
                    object3 = this.mManager;
                    ((FragmentManager)object3).hideFragment(fragment);
                    break;
                }
                case 4: {
                    n13 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    int n14 = ((FragmentTransaction$Op)object4).mExitAnim;
                    int n15 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    int n16 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    fragment.setAnimations(n13, n14, n15, n16);
                    object3 = this.mManager;
                    ((FragmentManager)object3).showFragment(fragment);
                    break;
                }
                case 3: {
                    n13 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    int n14 = ((FragmentTransaction$Op)object4).mExitAnim;
                    int n15 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    int n16 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    fragment.setAnimations(n13, n14, n15, n16);
                    object3 = this.mManager;
                    ((FragmentManager)object3).addFragment(fragment);
                    break;
                }
                case 1: {
                    n13 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    int n14 = ((FragmentTransaction$Op)object4).mExitAnim;
                    int n15 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    int n16 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    fragment.setAnimations(n13, n14, n15, n16);
                    this.mManager.setExitAnimationOrder(fragment, n11 != 0);
                    object3 = this.mManager;
                    ((FragmentManager)object3).removeFragment(fragment);
                }
            }
            n13 = (int)(this.mReorderingAllowed ? 1 : 0);
            if (n13 == 0 && (n12 = ((FragmentTransaction$Op)object4).mCmd) != (n13 = 3) && fragment != null && (n12 = (int)(FragmentManager.USE_STATE_MANAGER ? 1 : 0)) == 0) {
                object4 = this.mManager;
                ((FragmentManager)object4).moveFragmentToExpectedState(fragment);
            }
            n10 += -1;
        }
        n10 = (int)(this.mReorderingAllowed ? 1 : 0);
        if (n10 == 0 && bl2 && !(bl2 = FragmentManager.USE_STATE_MANAGER)) {
            FragmentManager fragmentManager = this.mManager;
            n10 = fragmentManager.mCurState;
            fragmentManager.moveToState(n10, n11 != 0);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public Fragment expandOps(ArrayList arrayList, Fragment fragment) {
        BackStackRecord backStackRecord = this;
        ArrayList arrayList2 = arrayList;
        Object object = fragment;
        int n10 = 0;
        while (true) {
            int n11;
            block12: {
                Object object2;
                int n12;
                Object object3;
                int n13;
                int n14;
                int n15;
                Object object4;
                block13: {
                    block9: {
                        block10: {
                            block11: {
                                int n16;
                                if (n10 >= (n16 = ((ArrayList)(object4 = backStackRecord.mOps)).size())) {
                                    return object;
                                }
                                object4 = (FragmentTransaction$Op)backStackRecord.mOps.get(n10);
                                int n17 = ((FragmentTransaction$Op)object4).mCmd;
                                int n18 = 0;
                                FragmentTransaction$Op fragmentTransaction$Op = null;
                                n11 = 1;
                                if (n17 == n11) break block9;
                                n15 = 2;
                                n14 = 3;
                                n13 = 9;
                                if (n17 == n15) break block10;
                                if (n17 == n14 || n17 == (n15 = 6)) break block11;
                                n18 = 7;
                                if (n17 == n18) break block9;
                                n18 = 8;
                                if (n17 == n18) {
                                    object3 = backStackRecord.mOps;
                                    fragmentTransaction$Op = new FragmentTransaction$Op(n13, (Fragment)object);
                                    ((ArrayList)object3).add(n10, fragmentTransaction$Op);
                                    ++n10;
                                    object = ((FragmentTransaction$Op)object4).mFragment;
                                }
                                break block12;
                            }
                            object3 = ((FragmentTransaction$Op)object4).mFragment;
                            arrayList2.remove(object3);
                            object4 = ((FragmentTransaction$Op)object4).mFragment;
                            if (object4 == object) {
                                object = backStackRecord.mOps;
                                object3 = new FragmentTransaction$Op(n13, (Fragment)object4);
                                ((ArrayList)object).add(n10, object3);
                                ++n10;
                                object = null;
                            }
                            break block12;
                        }
                        object3 = ((FragmentTransaction$Op)object4).mFragment;
                        n15 = ((Fragment)object3).mContainerId;
                        n12 = 0;
                        break block13;
                    }
                    object2 = ((FragmentTransaction$Op)object4).mFragment;
                    arrayList2.add(object2);
                    break block12;
                }
                for (int i10 = arrayList.size() - n11; i10 >= 0; i10 += -1) {
                    int n19;
                    FragmentTransaction$Op fragmentTransaction$Op;
                    Fragment fragment2 = (Fragment)arrayList2.get(i10);
                    int n20 = fragment2.mContainerId;
                    if (n20 != n15) continue;
                    if (fragment2 == object3) {
                        n12 = n11;
                        continue;
                    }
                    if (fragment2 == object) {
                        object = backStackRecord.mOps;
                        fragmentTransaction$Op = new FragmentTransaction$Op(n13, fragment2);
                        ((ArrayList)object).add(n10, fragmentTransaction$Op);
                        ++n10;
                        object = null;
                    }
                    fragmentTransaction$Op = new FragmentTransaction$Op(n14, fragment2);
                    fragmentTransaction$Op.mEnterAnim = n19 = ((FragmentTransaction$Op)object4).mEnterAnim;
                    fragmentTransaction$Op.mPopEnterAnim = n19 = ((FragmentTransaction$Op)object4).mPopEnterAnim;
                    fragmentTransaction$Op.mExitAnim = n19 = ((FragmentTransaction$Op)object4).mExitAnim;
                    fragmentTransaction$Op.mPopExitAnim = n19 = ((FragmentTransaction$Op)object4).mPopExitAnim;
                    object2 = backStackRecord.mOps;
                    ((ArrayList)object2).add(n10, fragmentTransaction$Op);
                    arrayList2.remove(fragment2);
                    n10 += n11;
                }
                if (n12 != 0) {
                    object2 = backStackRecord.mOps;
                    ((ArrayList)object2).remove(n10);
                    n10 += -1;
                } else {
                    ((FragmentTransaction$Op)object4).mCmd = n11;
                    arrayList2.add(object3);
                }
            }
            n10 += n11;
        }
    }

    public boolean generateOps(ArrayList object, ArrayList arrayList) {
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Run: ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            String string2 = TAG;
            Log.v((String)string2, (String)charSequence);
        }
        ((ArrayList)object).add(this);
        object = Boolean.FALSE;
        arrayList.add(object);
        boolean bl3 = this.mAddToBackStack;
        if (bl3) {
            object = this.mManager;
            ((FragmentManager)object).addBackStackState(this);
        }
        return true;
    }

    public CharSequence getBreadCrumbShortTitle() {
        int n10 = this.mBreadCrumbShortTitleRes;
        if (n10 != 0) {
            Context context = this.mManager.getHost().getContext();
            int n11 = this.mBreadCrumbShortTitleRes;
            return context.getText(n11);
        }
        return this.mBreadCrumbShortTitleText;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        int n10 = this.mBreadCrumbTitleRes;
        if (n10 != 0) {
            Context context = this.mManager.getHost().getContext();
            int n11 = this.mBreadCrumbTitleRes;
            return context.getText(n11);
        }
        return this.mBreadCrumbTitleText;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }

    public FragmentTransaction hide(Fragment object) {
        Object object2;
        Object object3 = ((Fragment)object).mFragmentManager;
        if (object3 != null && object3 != (object2 = this.mManager)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
            object = ((Fragment)object).toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" is already attached to a FragmentManager.");
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        return super.hide((Fragment)object);
    }

    public boolean interactsWith(int n10) {
        ArrayList arrayList = this.mOps;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Fragment fragment = ((FragmentTransaction$Op)this.mOps.get((int)i10)).mFragment;
            if (fragment != null) {
                n12 = fragment.mContainerId;
            } else {
                n12 = 0;
                fragment = null;
            }
            if (n12 == 0 || n12 != n10) continue;
            return true;
        }
        return false;
    }

    public boolean interactsWith(ArrayList arrayList, int n10, int n11) {
        if (n11 == n10) {
            return false;
        }
        ArrayList arrayList2 = this.mOps;
        int n12 = arrayList2.size();
        int n13 = -1;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14;
            Fragment fragment = ((FragmentTransaction$Op)this.mOps.get((int)i10)).mFragment;
            if (fragment != null) {
                n14 = fragment.mContainerId;
            } else {
                n14 = 0;
                fragment = null;
            }
            if (n14 == 0 || n14 == n13) continue;
            for (n13 = n10; n13 < n11; ++n13) {
                BackStackRecord backStackRecord = (BackStackRecord)arrayList.get(n13);
                ArrayList arrayList3 = backStackRecord.mOps;
                int n15 = arrayList3.size();
                for (int i11 = 0; i11 < n15; ++i11) {
                    int n16;
                    Fragment fragment2 = ((FragmentTransaction$Op)backStackRecord.mOps.get((int)i11)).mFragment;
                    if (fragment2 != null) {
                        n16 = fragment2.mContainerId;
                    } else {
                        n16 = 0;
                        fragment2 = null;
                    }
                    if (n16 != n14) continue;
                    return true;
                }
            }
            n13 = n14;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public boolean isPostponed() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mOps)).size()); ++i10) {
            object = (FragmentTransaction$Op)this.mOps.get(i10);
            n10 = (int)(BackStackRecord.isFragmentPostponed((FragmentTransaction$Op)object) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public FragmentTransaction remove(Fragment object) {
        Object object2;
        Object object3 = ((Fragment)object).mFragmentManager;
        if (object3 != null && object3 != (object2 = this.mManager)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            object = ((Fragment)object).toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" is already attached to a FragmentManager.");
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        return super.remove((Fragment)object);
    }

    public void runOnCommitRunnables() {
        ArrayList arrayList = this.mCommitRunnables;
        if (arrayList != null) {
            Object object;
            int n10;
            int n11;
            arrayList = null;
            for (n11 = 0; n11 < (n10 = ((ArrayList)(object = this.mCommitRunnables)).size()); ++n11) {
                object = (Runnable)this.mCommitRunnables.get(n11);
                object.run();
            }
            n11 = 0;
            arrayList = null;
            this.mCommitRunnables = null;
        }
    }

    public FragmentTransaction setMaxLifecycle(Fragment object, Lifecycle$State object2) {
        Object object3 = ((Fragment)object).mFragmentManager;
        Object object4 = this.mManager;
        if (object3 == object4) {
            int n10;
            int n11;
            object3 = Lifecycle$State.INITIALIZED;
            object4 = "Cannot set maximum Lifecycle to ";
            if (object2 == object3 && (n11 = ((Fragment)object).mState) > (n10 = -1)) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(object2);
                ((StringBuilder)object3).append(" after the Fragment has been created");
                object2 = ((StringBuilder)object3).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object3 = Lifecycle$State.DESTROYED;
            if (object2 != object3) {
                return super.setMaxLifecycle((Fragment)object, (Lifecycle$State)((Object)object2));
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(object2);
            ((StringBuilder)object3).append(". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
            object2 = ((StringBuilder)object3).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
        object3 = this.mManager;
        ((StringBuilder)object2).append(object3);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public void setOnStartPostponedListener(Fragment$OnStartEnterTransitionListener fragment$OnStartEnterTransitionListener) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mOps)).size()); ++i10) {
            object = (FragmentTransaction$Op)this.mOps.get(i10);
            boolean bl2 = BackStackRecord.isFragmentPostponed((FragmentTransaction$Op)object);
            if (!bl2) continue;
            object = ((FragmentTransaction$Op)object).mFragment;
            ((Fragment)object).setOnStartEnterTransitionListener(fragment$OnStartEnterTransitionListener);
        }
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment object) {
        Object object2;
        Object object3;
        if (object != null && (object3 = ((Fragment)object).mFragmentManager) != null && object3 != (object2 = this.mManager)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
            object = ((Fragment)object).toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" is already attached to a FragmentManager.");
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        return super.setPrimaryNavigationFragment((Fragment)object);
    }

    public FragmentTransaction show(Fragment object) {
        Object object2;
        Object object3 = ((Fragment)object).mFragmentManager;
        if (object3 != null && object3 != (object2 = this.mManager)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cannot show Fragment attached to a different FragmentManager. Fragment ");
            object = ((Fragment)object).toString();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" is already attached to a FragmentManager.");
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        return super.show((Fragment)object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        String string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        int n10 = this.mIndex;
        if (n10 >= 0) {
            string2 = " #";
            stringBuilder.append(string2);
            n10 = this.mIndex;
            stringBuilder.append(n10);
        }
        if ((string2 = this.mName) != null) {
            stringBuilder.append(" ");
            string2 = this.mName;
            stringBuilder.append(string2);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     */
    public Fragment trackAddedFragmentsInPop(ArrayList var1_1, Fragment var2_2) {
        var3_3 = this.mOps;
        var4_4 = var3_3.size();
        var5_5 = 1;
        var4_4 -= var5_5;
        while (var4_4 >= 0) {
            var6_6 = (FragmentTransaction$Op)this.mOps.get(var4_4);
            var7_7 = var6_6.mCmd;
            if (var7_7 == var5_5) ** GOTO lbl-1000
            var8_8 = 3;
            if (var7_7 == var8_8) ** GOTO lbl-1000
            switch (var7_7) {
                default: {
                    break;
                }
                case 10: {
                    var6_6.mCurrentMaxState = var9_9 = var6_6.mOldMaxState;
                    break;
                }
                case 9: {
                    var2_2 = var6_6.mFragment;
                    break;
                }
                case 8: {
                    var2_2 = null;
                    break;
                }
                case 6: lbl-1000:
                // 2 sources

                {
                    var6_6 = var6_6.mFragment;
                    var1_1.add(var6_6);
                    break;
                }
                case 7: lbl-1000:
                // 2 sources

                {
                    var6_6 = var6_6.mFragment;
                    var1_1.remove(var6_6);
                }
            }
            var4_4 += -1;
        }
        return var2_2;
    }
}

