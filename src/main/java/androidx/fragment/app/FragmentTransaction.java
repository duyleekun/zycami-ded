/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentTransaction$Op;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle$State;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    public static final int OP_ADD = 1;
    public static final int OP_ATTACH = 7;
    public static final int OP_DETACH = 6;
    public static final int OP_HIDE = 4;
    public static final int OP_NULL = 0;
    public static final int OP_REMOVE = 3;
    public static final int OP_REPLACE = 2;
    public static final int OP_SET_MAX_LIFECYCLE = 10;
    public static final int OP_SET_PRIMARY_NAV = 8;
    public static final int OP_SHOW = 5;
    public static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = 255;
    public boolean mAddToBackStack;
    public boolean mAllowAddToBackStack;
    public int mBreadCrumbShortTitleRes;
    public CharSequence mBreadCrumbShortTitleText;
    public int mBreadCrumbTitleRes;
    public CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    public ArrayList mCommitRunnables;
    public int mEnterAnim;
    public int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    public String mName;
    public ArrayList mOps;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public boolean mReorderingAllowed;
    public ArrayList mSharedElementSourceNames;
    public ArrayList mSharedElementTargetNames;
    public int mTransition;

    public FragmentTransaction() {
        ArrayList arrayList;
        this.mOps = arrayList = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        ArrayList arrayList;
        this.mOps = arrayList = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    private Fragment createFragment(Class object, Bundle bundle) {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.mClassLoader;
            if (classLoader != null) {
                object = ((Class)object).getName();
                object = fragmentFactory.instantiate(classLoader, (String)object);
                if (bundle != null) {
                    ((Fragment)object).setArguments(bundle);
                }
                return object;
            }
            object = new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
            throw object;
        }
        object = new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        throw object;
    }

    public FragmentTransaction add(int n10, Fragment fragment) {
        this.doAddOp(n10, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int n10, Fragment fragment, String string2) {
        this.doAddOp(n10, fragment, string2, 1);
        return this;
    }

    public final FragmentTransaction add(int n10, Class object, Bundle bundle) {
        object = this.createFragment((Class)object, bundle);
        return this.add(n10, (Fragment)object);
    }

    public final FragmentTransaction add(int n10, Class object, Bundle bundle, String string2) {
        object = this.createFragment((Class)object, bundle);
        return this.add(n10, (Fragment)object, string2);
    }

    public FragmentTransaction add(ViewGroup viewGroup, Fragment fragment, String string2) {
        fragment.mContainer = viewGroup;
        int n10 = viewGroup.getId();
        return this.add(n10, fragment, string2);
    }

    public FragmentTransaction add(Fragment fragment, String string2) {
        this.doAddOp(0, fragment, string2, 1);
        return this;
    }

    public final FragmentTransaction add(Class object, Bundle bundle, String string2) {
        object = this.createFragment((Class)object, bundle);
        return this.add((Fragment)object, string2);
    }

    public void addOp(FragmentTransaction$Op fragmentTransaction$Op) {
        int n10;
        this.mOps.add(fragmentTransaction$Op);
        fragmentTransaction$Op.mEnterAnim = n10 = this.mEnterAnim;
        fragmentTransaction$Op.mExitAnim = n10 = this.mExitAnim;
        fragmentTransaction$Op.mPopEnterAnim = n10 = this.mPopEnterAnim;
        fragmentTransaction$Op.mPopExitAnim = n10 = this.mPopExitAnim;
    }

    /*
     * Enabled aggressive block sorting
     */
    public FragmentTransaction addSharedElement(View object, String object2) {
        boolean bl2 = FragmentTransition.supportsTransition();
        if (!bl2) return this;
        if ((object = ViewCompat.getTransitionName((View)object)) == null) {
            object = new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            throw object;
        }
        Serializable serializable = this.mSharedElementSourceNames;
        if (serializable == null) {
            serializable = new ArrayList();
            this.mSharedElementSourceNames = serializable;
            serializable = new ArrayList();
            this.mSharedElementTargetNames = serializable;
        } else {
            serializable = this.mSharedElementTargetNames;
            bl2 = ((ArrayList)serializable).contains(object2);
            String string2 = "' has already been added to the transaction.";
            if (bl2) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("A shared element with the target name '");
                ((StringBuilder)serializable).append((String)object2);
                ((StringBuilder)serializable).append(string2);
                object2 = ((StringBuilder)serializable).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            serializable = this.mSharedElementSourceNames;
            bl2 = ((ArrayList)serializable).contains(object);
            if (bl2) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("A shared element with the source name '");
                ((StringBuilder)serializable).append((String)object);
                ((StringBuilder)serializable).append(string2);
                object = ((StringBuilder)serializable).toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
        }
        serializable = this.mSharedElementSourceNames;
        ((ArrayList)serializable).add(object);
        object = this.mSharedElementTargetNames;
        ((ArrayList)object).add(object2);
        return this;
    }

    public FragmentTransaction addToBackStack(String object) {
        boolean bl2 = this.mAllowAddToBackStack;
        if (bl2) {
            this.mAddToBackStack = true;
            this.mName = object;
            return this;
        }
        object = new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        throw object;
    }

    public FragmentTransaction attach(Fragment fragment) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(7, fragment);
        this.addOp(fragmentTransaction$Op);
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    public FragmentTransaction detach(Fragment fragment) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(6, fragment);
        this.addOp(fragmentTransaction$Op);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        boolean bl2 = this.mAddToBackStack;
        if (!bl2) {
            this.mAllowAddToBackStack = false;
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This transaction is already being added to the back stack");
        throw illegalStateException;
    }

    public void doAddOp(int n10, Fragment object, String object2, int n11) {
        boolean bl2;
        boolean bl3;
        Object object3 = object.getClass();
        int n12 = ((Class)object3).getModifiers();
        boolean n13 = ((Class)object3).isAnonymousClass();
        if (!(n13 || !(bl3 = Modifier.isPublic(n12)) || (bl2 = ((Class)object3).isMemberClass()) && (n12 = (int)(Modifier.isStatic(n12) ? 1 : 0)) == 0)) {
            object3 = " now ";
            String string2 = ": was ";
            if (object2 != null) {
                boolean bl4;
                String string3 = ((Fragment)object).mTag;
                if (string3 != null && !(bl4 = ((String)object2).equals(string3))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Can't change tag of fragment ");
                    stringBuilder.append(object);
                    stringBuilder.append(string2);
                    object = ((Fragment)object).mTag;
                    stringBuilder.append((String)object);
                    stringBuilder.append((String)object3);
                    stringBuilder.append((String)object2);
                    object = stringBuilder.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    throw illegalStateException;
                }
                ((Fragment)object).mTag = object2;
            }
            if (n10 != 0) {
                int n14 = -1;
                if (n10 != n14) {
                    int n15 = ((Fragment)object).mFragmentId;
                    if (n15 != 0 && n15 != n10) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Can't change container ID of fragment ");
                        stringBuilder.append(object);
                        stringBuilder.append(string2);
                        int n16 = ((Fragment)object).mFragmentId;
                        stringBuilder.append(n16);
                        stringBuilder.append((String)object3);
                        stringBuilder.append(n10);
                        String string4 = stringBuilder.toString();
                        object2 = new IllegalStateException(string4);
                        throw object2;
                    }
                    ((Fragment)object).mFragmentId = n10;
                    ((Fragment)object).mContainerId = n10;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Can't add fragment ");
                    stringBuilder.append(object);
                    stringBuilder.append(" with tag ");
                    stringBuilder.append((String)object2);
                    stringBuilder.append(" to container view with no id");
                    object = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
            }
            FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(n11, (Fragment)object);
            this.addOp(fragmentTransaction$Op);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        object2 = ((Class)object3).getCanonicalName();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" must be a public static class to be  properly recreated from instance state.");
        object = ((StringBuilder)object).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public FragmentTransaction hide(Fragment fragment) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(4, fragment);
        this.addOp(fragmentTransaction$Op);
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public FragmentTransaction remove(Fragment fragment) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(3, fragment);
        this.addOp(fragmentTransaction$Op);
        return this;
    }

    public FragmentTransaction replace(int n10, Fragment fragment) {
        return this.replace(n10, fragment, null);
    }

    public FragmentTransaction replace(int n10, Fragment fragment, String string2) {
        if (n10 != 0) {
            this.doAddOp(n10, fragment, string2, 2);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must use non-zero containerViewId");
        throw illegalArgumentException;
    }

    public final FragmentTransaction replace(int n10, Class clazz, Bundle bundle) {
        return this.replace(n10, clazz, bundle, null);
    }

    public final FragmentTransaction replace(int n10, Class object, Bundle bundle, String string2) {
        object = this.createFragment((Class)object, bundle);
        return this.replace(n10, (Fragment)object, string2);
    }

    public FragmentTransaction runOnCommit(Runnable runnable) {
        this.disallowAddToBackStack();
        ArrayList arrayList = this.mCommitRunnables;
        if (arrayList == null) {
            this.mCommitRunnables = arrayList = new ArrayList();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    public FragmentTransaction setAllowOptimization(boolean bl2) {
        return this.setReorderingAllowed(bl2);
    }

    public FragmentTransaction setBreadCrumbShortTitle(int n10) {
        this.mBreadCrumbShortTitleRes = n10;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int n10) {
        this.mBreadCrumbTitleRes = n10;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int n10, int n11) {
        return this.setCustomAnimations(n10, n11, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int n10, int n11, int n12, int n13) {
        this.mEnterAnim = n10;
        this.mExitAnim = n11;
        this.mPopEnterAnim = n12;
        this.mPopExitAnim = n13;
        return this;
    }

    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle$State lifecycle$State) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(10, fragment, lifecycle$State);
        this.addOp(fragmentTransaction$Op);
        return this;
    }

    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(8, fragment);
        this.addOp(fragmentTransaction$Op);
        return this;
    }

    public FragmentTransaction setReorderingAllowed(boolean bl2) {
        this.mReorderingAllowed = bl2;
        return this;
    }

    public FragmentTransaction setTransition(int n10) {
        this.mTransition = n10;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int n10) {
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(5, fragment);
        this.addOp(fragmentTransaction$Op);
        return this;
    }
}

