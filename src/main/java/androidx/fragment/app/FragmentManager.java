/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest$Builder;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R$id;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$OnStartEnterTransitionListener;
import androidx.fragment.app.Fragment$SavedState;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentAnim$AnimationOrAnimator;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentLayoutInflaterFactory;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager$1;
import androidx.fragment.app.FragmentManager$10;
import androidx.fragment.app.FragmentManager$11;
import androidx.fragment.app.FragmentManager$2;
import androidx.fragment.app.FragmentManager$3;
import androidx.fragment.app.FragmentManager$4;
import androidx.fragment.app.FragmentManager$5;
import androidx.fragment.app.FragmentManager$6;
import androidx.fragment.app.FragmentManager$7;
import androidx.fragment.app.FragmentManager$8;
import androidx.fragment.app.FragmentManager$9;
import androidx.fragment.app.FragmentManager$BackStackEntry;
import androidx.fragment.app.FragmentManager$FragmentIntentSenderContract;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import androidx.fragment.app.FragmentManager$LifecycleAwareResultListener;
import androidx.fragment.app.FragmentManager$OnBackStackChangedListener;
import androidx.fragment.app.FragmentManager$OpGenerator;
import androidx.fragment.app.FragmentManager$PopBackStackState;
import androidx.fragment.app.FragmentManager$StartEnterTransitionListener;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentResultOwner;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.FragmentStore;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransaction$Op;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransition$Callback;
import androidx.fragment.app.LogWriter;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsControllerFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager
implements FragmentResultOwner {
    private static boolean DEBUG = false;
    private static final String EXTRA_CREATED_FILLIN_INTENT = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    public static final String TAG = "FragmentManager";
    public static boolean USE_STATE_MANAGER = true;
    public ArrayList mBackStack;
    private ArrayList mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex;
    private FragmentContainer mContainer;
    private ArrayList mCreatedMenus;
    public int mCurState;
    private SpecialEffectsControllerFactory mDefaultSpecialEffectsControllerFactory;
    private boolean mDestroyed;
    private Runnable mExecCommit;
    private boolean mExecutingActions;
    private Map mExitAnimationCancellationSignals;
    private FragmentFactory mFragmentFactory;
    private final FragmentStore mFragmentStore;
    private final FragmentTransition$Callback mFragmentTransitionCallback;
    private boolean mHavePendingDeferredStart;
    private FragmentHostCallback mHost;
    private FragmentFactory mHostFragmentFactory;
    public ArrayDeque mLaunchedFragments;
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory;
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final CopyOnWriteArrayList mOnAttachListeners;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList mPendingActions;
    private ArrayList mPostponedTransactions;
    public Fragment mPrimaryNav;
    private ActivityResultLauncher mRequestPermissions;
    private final Map mResultListeners;
    private final Map mResults;
    private SpecialEffectsControllerFactory mSpecialEffectsControllerFactory;
    private ActivityResultLauncher mStartActivityForResult;
    private ActivityResultLauncher mStartIntentSenderForResult;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList mTmpAddedFragments;
    private ArrayList mTmpIsPop;
    private ArrayList mTmpRecords;

    public FragmentManager() {
        Object object = new ArrayList();
        this.mPendingActions = object;
        this.mFragmentStore = object = new FragmentStore();
        this.mLayoutInflaterFactory = object = new FragmentLayoutInflaterFactory(this);
        this.mOnBackPressedCallback = object = new FragmentManager$1(this, false);
        this.mBackStackIndex = object = new AtomicInteger();
        object = new HashMap();
        object = Collections.synchronizedMap(object);
        this.mResults = object;
        object = new HashMap();
        object = Collections.synchronizedMap(object);
        this.mResultListeners = object;
        object = new HashMap();
        object = Collections.synchronizedMap(object);
        this.mExitAnimationCancellationSignals = object;
        this.mFragmentTransitionCallback = object = new FragmentManager$2(this);
        this.mLifecycleCallbacksDispatcher = object = new FragmentLifecycleCallbacksDispatcher(this);
        object = new CopyOnWriteArrayList();
        this.mOnAttachListeners = object;
        this.mCurState = -1;
        this.mFragmentFactory = null;
        FragmentManager$3 fragmentManager$3 = new FragmentManager$3(this);
        this.mHostFragmentFactory = fragmentManager$3;
        this.mSpecialEffectsControllerFactory = null;
        this.mDefaultSpecialEffectsControllerFactory = object = new FragmentManager$4(this);
        object = new ArrayDeque();
        this.mLaunchedFragments = object;
        this.mExecCommit = object = new FragmentManager$5(this);
    }

    public static /* synthetic */ Map access$000(FragmentManager fragmentManager) {
        return fragmentManager.mResults;
    }

    public static /* synthetic */ Map access$100(FragmentManager fragmentManager) {
        return fragmentManager.mResultListeners;
    }

    public static /* synthetic */ FragmentStore access$200(FragmentManager fragmentManager) {
        return fragmentManager.mFragmentStore;
    }

    private void addAddedFragments(ArraySet arraySet) {
        boolean bl2;
        int n10 = this.mCurState;
        int n11 = 1;
        if (n10 < n11) {
            return;
        }
        n11 = 5;
        n10 = Math.min(n10, n11);
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            int n12 = fragment.mState;
            if (n12 >= n10) continue;
            this.moveToState(fragment, n10);
            View view = fragment.mView;
            if (view == null || (n12 = (int)(fragment.mHidden ? 1 : 0)) != 0 || (n12 = (int)(fragment.mIsNewlyAdded ? 1 : 0)) == 0) continue;
            arraySet.add(fragment);
        }
    }

    private void cancelExitAnimation(Fragment fragment) {
        Object object = (HashSet)this.mExitAnimationCancellationSignals.get(fragment);
        if (object != null) {
            boolean bl2;
            Iterator iterator2 = ((HashSet)object).iterator();
            while (bl2 = iterator2.hasNext()) {
                CancellationSignal cancellationSignal = (CancellationSignal)iterator2.next();
                cancellationSignal.cancel();
            }
            ((HashSet)object).clear();
            this.destroyFragmentView(fragment);
            object = this.mExitAnimationCancellationSignals;
            object.remove(fragment);
        }
    }

    private void checkStateLoss() {
        boolean bl2 = this.isStateSaved();
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can not perform this action after onSaveInstanceState");
        throw illegalStateException;
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private Set collectAllSpecialEffectsController() {
        boolean bl2;
        HashSet<ViewGroup> hashSet = new HashSet<ViewGroup>();
        Iterator iterator2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = ((FragmentStateManager)iterator2.next()).getFragment().mContainer;
            if (object == null) continue;
            SpecialEffectsControllerFactory specialEffectsControllerFactory = this.getSpecialEffectsControllerFactory();
            object = SpecialEffectsController.getOrCreateController(object, specialEffectsControllerFactory);
            hashSet.add((ViewGroup)object);
        }
        return hashSet;
    }

    private Set collectChangedControllers(ArrayList arrayList, int n10, int n11) {
        HashSet<Object> hashSet = new HashSet<Object>();
        while (n10 < n11) {
            boolean bl2;
            Iterator iterator2 = ((BackStackRecord)arrayList.get((int)n10)).mOps.iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object = ((FragmentTransaction$Op)iterator2.next()).mFragment;
                if (object == null || (object = ((Fragment)object).mContainer) == null) continue;
                object = SpecialEffectsController.getOrCreateController((ViewGroup)object, this);
                hashSet.add(object);
            }
            ++n10;
        }
        return hashSet;
    }

    private void completeShowHideFragment(Fragment fragment) {
        int n10;
        Object object = fragment.mView;
        if (object != null) {
            Animator animator2;
            object = this.mHost.getContext();
            boolean bl2 = fragment.mHidden ^ true;
            boolean bl3 = fragment.getPopDirection();
            if ((object = FragmentAnim.loadAnimation((Context)object, fragment, bl2, bl3)) != null && (animator2 = object.animator) != null) {
                View view = fragment.mView;
                animator2.setTarget((Object)view);
                bl2 = fragment.mHidden;
                if (bl2) {
                    bl2 = fragment.isHideReplaced();
                    if (bl2) {
                        fragment.setHideReplaced(false);
                    } else {
                        animator2 = fragment.mContainer;
                        view = fragment.mView;
                        animator2.startViewTransition(view);
                        Animator animator3 = object.animator;
                        FragmentManager$7 fragmentManager$7 = new FragmentManager$7(this, (ViewGroup)animator2, view, fragment);
                        animator3.addListener((Animator.AnimatorListener)fragmentManager$7);
                    }
                } else {
                    animator2 = fragment.mView;
                    animator2.setVisibility(0);
                }
                object = object.animator;
                object.start();
            } else {
                if (object != null) {
                    animator2 = fragment.mView;
                    Animation animation = object.animation;
                    animator2.startAnimation(animation);
                    object = object.animation;
                    object.start();
                }
                if ((n10 = fragment.mHidden) != 0 && (n10 = fragment.isHideReplaced()) == 0) {
                    n10 = 8;
                } else {
                    n10 = 0;
                    object = null;
                }
                animator2 = fragment.mView;
                animator2.setVisibility(n10);
                n10 = (int)(fragment.isHideReplaced() ? 1 : 0);
                if (n10 != 0) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        this.invalidateMenuForFragment(fragment);
        fragment.mHiddenChanged = false;
        n10 = fragment.mHidden;
        fragment.onHiddenChanged(n10 != 0);
    }

    private void destroyFragmentView(Fragment fragment) {
        fragment.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null) {
            Object object = fragment.mWho;
            boolean bl2 = fragment.equals(object = this.findActiveFragment((String)object));
            if (bl2) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    private void dispatchStateChange(int n10) {
        boolean bl2;
        block11: {
            bl2 = true;
            this.mExecutingActions = bl2;
            Object object = this.mFragmentStore;
            ((FragmentStore)object).dispatchStateChange(n10);
            this.moveToState(n10, false);
            n10 = (int)(USE_STATE_MANAGER ? 1 : 0);
            if (n10 == 0) break block11;
            Object object2 = this.collectAllSpecialEffectsController();
            try {
                object2 = object2.iterator();
            }
            catch (Throwable throwable) {
                this.mExecutingActions = false;
                throw throwable;
            }
            while (true) {
                boolean bl3 = object2.hasNext();
                if (!bl3) break;
                object = object2.next();
                object = (SpecialEffectsController)object;
                ((SpecialEffectsController)object).forceCompleteAllOperations();
                continue;
                break;
            }
        }
        this.mExecutingActions = false;
        this.execPendingActions(bl2);
        return;
    }

    private void doPendingDeferredStart() {
        boolean bl2 = this.mHavePendingDeferredStart;
        if (bl2) {
            bl2 = false;
            this.mHavePendingDeferredStart = false;
            this.startPendingDeferredFragments();
        }
    }

    public static void enableDebugLogging(boolean bl2) {
        DEBUG = bl2;
    }

    public static void enableNewStateManager(boolean bl2) {
        USE_STATE_MANAGER = bl2;
    }

    private void endAnimatingAwayFragments() {
        block3: {
            boolean bl2;
            boolean bl3;
            block2: {
                boolean bl4;
                bl3 = USE_STATE_MANAGER;
                if (!bl3) break block2;
                Iterator iterator2 = this.collectAllSpecialEffectsController().iterator();
                while (bl4 = iterator2.hasNext()) {
                    SpecialEffectsController specialEffectsController = (SpecialEffectsController)iterator2.next();
                    specialEffectsController.forceCompleteAllOperations();
                }
                break block3;
            }
            Object object = this.mExitAnimationCancellationSignals;
            bl3 = object.isEmpty();
            if (bl3) break block3;
            object = this.mExitAnimationCancellationSignals.keySet().iterator();
            while (bl2 = object.hasNext()) {
                Fragment fragment = (Fragment)object.next();
                this.cancelExitAnimation(fragment);
                this.moveToState(fragment);
            }
        }
    }

    private void ensureExecReady(boolean bl2) {
        boolean bl3 = this.mExecutingActions;
        if (!bl3) {
            Looper looper;
            FragmentHostCallback fragmentHostCallback = this.mHost;
            if (fragmentHostCallback == null) {
                bl2 = this.mDestroyed;
                if (bl2) {
                    IllegalStateException illegalStateException = new IllegalStateException("FragmentManager has been destroyed");
                    throw illegalStateException;
                }
                IllegalStateException illegalStateException = new IllegalStateException("FragmentManager has not been attached to a host.");
                throw illegalStateException;
            }
            fragmentHostCallback = Looper.myLooper();
            if (fragmentHostCallback == (looper = this.mHost.getHandler().getLooper())) {
                ArrayList arrayList;
                if (!bl2) {
                    this.checkStateLoss();
                }
                if ((arrayList = this.mTmpRecords) == null) {
                    this.mTmpRecords = arrayList = new ArrayList();
                    this.mTmpIsPop = arrayList = new ArrayList();
                }
                this.mExecutingActions = true;
                bl2 = false;
                arrayList = null;
                bl3 = false;
                fragmentHostCallback = null;
                try {
                    this.executePostponedTransaction(null, null);
                    return;
                }
                finally {
                    this.mExecutingActions = false;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Must be called from main thread of fragment host");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("FragmentManager is already executing transactions");
        throw illegalStateException;
    }

    private static void executeOps(ArrayList arrayList, ArrayList arrayList2, int n10, int n11) {
        while (n10 < n11) {
            BackStackRecord backStackRecord = (BackStackRecord)arrayList.get(n10);
            Boolean bl2 = (Boolean)arrayList2.get(n10);
            int n12 = bl2.booleanValue();
            boolean bl3 = true;
            if (n12 != 0) {
                backStackRecord.bumpBackStackNesting(-1);
                n12 = n11 + -1;
                if (n10 != n12) {
                    bl3 = false;
                }
                backStackRecord.executePopOps(bl3);
            } else {
                backStackRecord.bumpBackStackNesting((int)(bl3 ? 1 : 0));
                backStackRecord.executeOps();
            }
            ++n10;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void executeOpsTogether(ArrayList var1_1, ArrayList var2_2, int var3_3, int var4_4) {
        var5_5 = this;
        var6_6 = var1_1;
        var7_7 = var2_2;
        var8_8 = var3_3;
        var9_9 = var4_4;
        var10_10 = ((BackStackRecord)var1_1.get((int)var3_3)).mReorderingAllowed;
        var11_11 = this.mTmpAddedFragments;
        if (var11_11 == null) {
            var11_11 = new ArrayList();
            this.mTmpAddedFragments = var11_11;
        } else {
            var11_11.clear();
        }
        var11_11 = var5_5.mTmpAddedFragments;
        var12_12 = var5_5.mFragmentStore.getFragments();
        var11_11.addAll(var12_12);
        var11_11 = this.getPrimaryNavigationFragment();
        var13_13 = 0;
        var14_14 = 0.0f;
        var12_12 = null;
        var15_15 = 0;
        var16_16 = var8_8;
        while (true) {
            var17_17 = 1;
            var18_18 = 1.4E-45f;
            if (var16_16 >= var9_9) break;
            var19_19 = (BackStackRecord)var6_6.get(var16_16);
            var20_20 = (Boolean)var7_7.get(var16_16);
            var21_21 = var20_20.booleanValue();
            if (!var21_21) {
                var20_20 = var5_5.mTmpAddedFragments;
                var11_11 = var19_19.expandOps((ArrayList)var20_20, (Fragment)var11_11);
            } else {
                var20_20 = var5_5.mTmpAddedFragments;
                var11_11 = var19_19.trackAddedFragmentsInPop((ArrayList)var20_20, (Fragment)var11_11);
            }
            var15_15 = var15_15 == 0 && (var22_22 = var19_19.mAddToBackStack) == 0 ? 0 : var17_17;
            ++var16_16;
        }
        var11_11 = var5_5.mTmpAddedFragments;
        var11_11.clear();
        if (var10_10 != 0 || (var23_23 = var5_5.mCurState) < var17_17) ** GOTO lbl64
        var23_23 = (int)FragmentManager.USE_STATE_MANAGER;
        if (var23_23 == 0) {
            var24_24 = var5_5.mHost.getContext();
            var19_19 = var5_5.mContainer;
            var25_25 = 0;
            var11_11 = var5_5.mFragmentTransitionCallback;
            var20_20 = var1_1;
            var26_26 = var4_4;
            var13_13 = var17_17;
            var14_14 = var18_18;
            FragmentTransition.startTransitions((Context)var24_24, (FragmentContainer)var19_19, var1_1, var2_2, var3_3, var4_4, false, (FragmentTransition$Callback)var11_11);
        } else {
            for (var23_23 = var8_8; var23_23 < var9_9; ++var23_23) {
                var12_12 = ((BackStackRecord)var6_6.get((int)var23_23)).mOps.iterator();
                while ((var16_16 = (int)var12_12.hasNext()) != 0) {
                    var24_24 = ((FragmentTransaction$Op)var12_12.next()).mFragment;
                    if (var24_24 == null || (var19_19 = var24_24.mFragmentManager) == null) continue;
                    var24_24 = var5_5.createOrGetFragmentStateManager((Fragment)var24_24);
                    var19_19 = var5_5.mFragmentStore;
                    var19_19.makeActive((FragmentStateManager)var24_24);
                }
            }
lbl64:
            // 2 sources

            var13_13 = var17_17;
            var14_14 = var18_18;
        }
        FragmentManager.executeOps(var1_1, var2_2, var3_3, var4_4);
        var23_23 = (int)FragmentManager.USE_STATE_MANAGER;
        if (var23_23 != 0) {
            var23_23 = var9_9 + -1;
            var11_11 = (Boolean)var7_7.get(var23_23);
            var23_23 = (int)var11_11.booleanValue();
            for (var10_10 = var8_8; var10_10 < var9_9; ++var10_10) {
                var24_24 = (BackStackRecord)var6_6.get(var10_10);
                if (var23_23 != 0) {
                    var19_19 = var24_24.mOps;
                    for (var22_22 = var19_19.size() - var13_13; var22_22 >= 0; var22_22 += -1) {
                        var20_20 = ((FragmentTransaction$Op)var24_24.mOps.get((int)var22_22)).mFragment;
                        if (var20_20 == null) continue;
                        var20_20 = var5_5.createOrGetFragmentStateManager((Fragment)var20_20);
                        var20_20.moveToExpectedState();
                    }
                    continue;
                }
                var24_24 = var24_24.mOps.iterator();
                while ((var22_22 = (int)var24_24.hasNext()) != 0) {
                    var19_19 = ((FragmentTransaction$Op)var24_24.next()).mFragment;
                    if (var19_19 == null) continue;
                    var19_19 = var5_5.createOrGetFragmentStateManager((Fragment)var19_19);
                    var19_19.moveToExpectedState();
                }
            }
            var10_10 = var5_5.mCurState;
            var5_5.moveToState(var10_10, (boolean)var13_13);
            var12_12 = var5_5.collectChangedControllers(var6_6, var8_8, var9_9).iterator();
            while ((var10_10 = (int)var12_12.hasNext()) != 0) {
                var27_27 = (SpecialEffectsController)var12_12.next();
                var27_27.updateOperationDirection((boolean)var23_23);
                var27_27.markPostponedState();
                var27_27.executePendingOperations();
            }
            var23_23 = var9_9;
            var28_28 = var7_7;
        } else {
            if (var10_10 != 0) {
                var24_24 = new ArraySet();
                var5_5.addAddedFragments((ArraySet)var24_24);
                var11_11 = this;
                var17_17 = var13_13;
                var18_18 = var14_14;
                var12_12 = var1_1;
                var22_22 = var10_10;
                var27_27 = var2_2;
                var25_25 = var9_9;
                var9_9 = var3_3;
                var26_26 = var8_8;
                var8_8 = var4_4;
                var29_29 = var7_7;
                var7_7 = var24_24;
                var23_23 = this.postponePostponableTransactions(var1_1, var2_2, var3_3, var4_4, (ArraySet)var24_24);
                var5_5.makeRemovedFragmentsInvisible((ArraySet)var24_24);
            } else {
                var17_17 = var13_13;
                var18_18 = var14_14;
                var22_22 = var10_10;
                var25_25 = var9_9;
                var26_26 = var8_8;
                var29_29 = var7_7;
                var23_23 = var9_9;
            }
            if (var23_23 != var26_26 && var22_22 != 0) {
                var13_13 = var5_5.mCurState;
                if (var13_13 >= var17_17) {
                    var12_12 = var5_5.mHost;
                    var24_24 = var12_12.getContext();
                    var19_19 = var5_5.mContainer;
                    var27_27 = var5_5.mFragmentTransitionCallback;
                    var20_20 = var1_1;
                    var28_28 = var29_29;
                    var26_26 = var23_23;
                    var23_23 = var25_25;
                    var25_25 = 1;
                    var13_13 = var17_17;
                    var14_14 = var18_18;
                    FragmentTransition.startTransitions((Context)var24_24, (FragmentContainer)var19_19, var1_1, var2_2, var3_3, var26_26, (boolean)var25_25, (FragmentTransition$Callback)var27_27);
                } else {
                    var28_28 = var29_29;
                    var23_23 = var25_25;
                    var13_13 = var17_17;
                    var14_14 = var18_18;
                }
                var10_10 = var5_5.mCurState;
                var5_5.moveToState(var10_10, (boolean)var13_13);
            } else {
                var28_28 = var29_29;
                var23_23 = var25_25;
            }
        }
        for (var13_13 = var3_3; var13_13 < var23_23; ++var13_13) {
            var27_27 = (BackStackRecord)var6_6.get(var13_13);
            var30_30 = (Boolean)var28_28.get(var13_13);
            var8_8 = (int)var30_30.booleanValue();
            if (var8_8 != 0 && (var8_8 = var27_27.mIndex) >= 0) {
                var27_27.mIndex = var8_8 = -1;
            }
            var27_27.runOnCommitRunnables();
        }
        if (var15_15 != 0) {
            this.reportBackStackChanged();
        }
    }

    private void executePostponedTransaction(ArrayList arrayList, ArrayList arrayList2) {
        int n10;
        ArrayList arrayList3 = this.mPostponedTransactions;
        if (arrayList3 == null) {
            n10 = 0;
            arrayList3 = null;
        } else {
            n10 = arrayList3.size();
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Serializable serializable;
            Object object;
            int n12;
            FragmentManager$StartEnterTransitionListener fragmentManager$StartEnterTransitionListener = (FragmentManager$StartEnterTransitionListener)this.mPostponedTransactions.get(i10);
            int n13 = -1;
            if (arrayList != null && (n12 = fragmentManager$StartEnterTransitionListener.mIsBack) == 0 && (n12 = arrayList.indexOf(object = fragmentManager$StartEnterTransitionListener.mRecord)) != n13 && arrayList2 != null && (n12 = (int)(((Boolean)(object = (Boolean)arrayList2.get(n12))).booleanValue() ? 1 : 0)) != 0) {
                serializable = this.mPostponedTransactions;
                ((ArrayList)serializable).remove(i10);
                i10 += -1;
                n10 += -1;
                fragmentManager$StartEnterTransitionListener.cancelTransaction();
                continue;
            }
            n12 = fragmentManager$StartEnterTransitionListener.isReady();
            if (n12 == 0 && (arrayList == null || (n12 = (int)(((BackStackRecord)(object = fragmentManager$StartEnterTransitionListener.mRecord)).interactsWith(arrayList, 0, n11 = arrayList.size()) ? 1 : 0)) == 0)) continue;
            object = this.mPostponedTransactions;
            ((ArrayList)object).remove(i10);
            i10 += -1;
            n10 += -1;
            if (arrayList != null && (n12 = (int)(fragmentManager$StartEnterTransitionListener.mIsBack ? 1 : 0)) == 0 && (n12 = arrayList.indexOf(object = fragmentManager$StartEnterTransitionListener.mRecord)) != n13 && arrayList2 != null && (n13 = (int)(((Boolean)(serializable = (Boolean)arrayList2.get(n12))).booleanValue() ? 1 : 0)) != 0) {
                fragmentManager$StartEnterTransitionListener.cancelTransaction();
                continue;
            }
            fragmentManager$StartEnterTransitionListener.completeTransaction();
        }
    }

    public static Fragment findFragment(View object) {
        Object object2 = FragmentManager.findViewFragment(object);
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" does not have a Fragment set");
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public static FragmentManager findFragmentManager(View object) {
        Object object2;
        Object object3;
        block8: {
            block7: {
                boolean bl2;
                block5: {
                    block6: {
                        object3 = FragmentManager.findViewFragment(object);
                        if (object3 == null) break block5;
                        boolean bl3 = ((Fragment)object3).isAdded();
                        if (!bl3) break block6;
                        object = ((Fragment)object3).getChildFragmentManager();
                        break block7;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("The Fragment ");
                    stringBuilder.append(object3);
                    stringBuilder.append(" that owns View ");
                    stringBuilder.append(object);
                    stringBuilder.append(" has already been destroyed. Nested fragments should always use the child FragmentManager.");
                    object = stringBuilder.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    throw illegalStateException;
                }
                object3 = object.getContext();
                boolean bl4 = false;
                object2 = null;
                while (bl2 = object3 instanceof ContextWrapper) {
                    bl2 = object3 instanceof FragmentActivity;
                    if (bl2) {
                        object2 = object3;
                        object2 = (FragmentActivity)object3;
                        break;
                    }
                    object3 = ((ContextWrapper)object3).getBaseContext();
                }
                if (object2 == null) break block8;
                object = ((FragmentActivity)object2).getSupportFragmentManager();
            }
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("View ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" is not within a subclass of FragmentActivity.");
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalStateException((String)object);
        throw object3;
    }

    private static Fragment findViewFragment(View view) {
        while (view != null) {
            Fragment fragment = FragmentManager.getViewFragment(view);
            if (fragment != null) {
                return fragment;
            }
            boolean bl2 = (view = view.getParent()) instanceof View;
            if (bl2) continue;
            view = null;
        }
        return null;
    }

    private void forcePostponedTransactions() {
        block3: {
            boolean bl2;
            block2: {
                boolean bl3;
                bl2 = USE_STATE_MANAGER;
                if (!bl2) break block2;
                Iterator iterator2 = this.collectAllSpecialEffectsController().iterator();
                while (bl3 = iterator2.hasNext()) {
                    SpecialEffectsController specialEffectsController = (SpecialEffectsController)iterator2.next();
                    specialEffectsController.forcePostponedExecutePendingOperations();
                }
                break block3;
            }
            Object object = this.mPostponedTransactions;
            if (object == null) break block3;
            while (!(bl2 = ((ArrayList)(object = this.mPostponedTransactions)).isEmpty())) {
                object = this.mPostponedTransactions;
                boolean bl4 = false;
                Object var4_7 = null;
                object = (FragmentManager$StartEnterTransitionListener)((ArrayList)object).remove(0);
                ((FragmentManager$StartEnterTransitionListener)object).completeTransaction();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean generateOpsForPendingActions(ArrayList object, ArrayList object2) {
        ArrayList arrayList = this.mPendingActions;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.mPendingActions;
            int n10 = arrayList2.isEmpty();
            int n11 = 0;
            if (n10 != 0) {
                return false;
            }
            arrayList2 = this.mPendingActions;
            n10 = arrayList2.size();
            boolean bl2 = false;
            while (true) {
                if (n11 >= n10) {
                    object = this.mPendingActions;
                    ((ArrayList)object).clear();
                    object = this.mHost;
                    object = ((FragmentHostCallback)object).getHandler();
                    object2 = this.mExecCommit;
                    object.removeCallbacks((Runnable)object2);
                    return bl2;
                }
                Object object3 = this.mPendingActions;
                object3 = ((ArrayList)object3).get(n11);
                object3 = (FragmentManager$OpGenerator)object3;
                boolean bl3 = object3.generateOps((ArrayList)object, (ArrayList)object2);
                bl2 |= bl3;
                ++n11;
            }
        }
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        return this.mNonConfig.getChildNonConfig(fragment);
    }

    private ViewGroup getFragmentContainer(Fragment fragment) {
        int n10;
        Object object = fragment.mContainer;
        if (object != null) {
            return object;
        }
        int n11 = fragment.mContainerId;
        if (n11 <= 0) {
            return null;
        }
        object = this.mContainer;
        n11 = (int)(((FragmentContainer)object).onHasView() ? 1 : 0);
        if (n11 != 0 && (n11 = (fragment = ((FragmentContainer)(object = this.mContainer)).onFindViewById(n10 = fragment.mContainerId)) instanceof ViewGroup) != 0) {
            return (ViewGroup)fragment;
        }
        return null;
    }

    public static Fragment getViewFragment(View object) {
        int n10 = R$id.fragment_container_view_tag;
        if ((n10 = (object = object.getTag(n10)) instanceof Fragment) != 0) {
            return (Fragment)object;
        }
        return null;
    }

    public static boolean isLoggingEnabled(int n10) {
        String string2;
        boolean bl2 = DEBUG;
        n10 = !bl2 && (n10 = (int)(Log.isLoggable((String)(string2 = TAG), (int)n10) ? 1 : 0)) == 0 ? 0 : 1;
        return n10 != 0;
    }

    private boolean isMenuAvailable(Fragment object) {
        boolean bl2;
        boolean bl3 = ((Fragment)object).mHasMenu;
        if (bl3 && (bl3 = ((Fragment)object).mMenuVisible) || (bl2 = ((FragmentManager)(object = ((Fragment)object).mChildFragmentManager)).checkForMenus())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private void makeRemovedFragmentsInvisible(ArraySet arraySet) {
        int n10 = arraySet.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            Fragment fragment = (Fragment)arraySet.valueAt(i10);
            boolean bl2 = fragment.mAdded;
            if (bl2) continue;
            View view = fragment.requireView();
            fragment.mPostponedAlpha = f10 = view.getAlpha();
            fragment = null;
            view.setAlpha(0.0f);
        }
    }

    private boolean popBackStackImmediate(String string2, int n10, int n11) {
        boolean bl2;
        this.execPendingActions(false);
        boolean bl3 = true;
        this.ensureExecReady(bl3);
        Object object = this.mPrimaryNav;
        if (object != null && n10 < 0 && string2 == null && (bl2 = ((FragmentManager)(object = ((Fragment)object).getChildFragmentManager())).popBackStackImmediate())) {
            return bl3;
        }
        ArrayList arrayList = this.mTmpRecords;
        ArrayList arrayList2 = this.mTmpIsPop;
        boolean bl4 = this.popBackStackState(arrayList, arrayList2, string2, n10, n11);
        if (bl4) {
            this.mExecutingActions = bl3;
            try {
                ArrayList arrayList3 = this.mTmpRecords;
                ArrayList arrayList4 = this.mTmpIsPop;
                this.removeRedundantOperationsAndExecute(arrayList3, arrayList4);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return bl4;
    }

    /*
     * Unable to fully structure code
     */
    private int postponePostponableTransactions(ArrayList var1_1, ArrayList var2_2, int var3_3, int var4_4, ArraySet var5_5) {
        var7_7 = var4_4;
        for (var6_6 = var4_4 + -1; var6_6 >= var3_3; var6_6 += -1) {
            var8_8 = (BackStackRecord)var1_1.get(var6_6);
            var9_9 = (Boolean)var2_2.get(var6_6);
            var10_10 = var9_9;
            var11_11 = var8_8.isPostponed();
            if (var11_11 == 0) ** GOTO lbl-1000
            var11_11 = var6_6 + 1;
            if ((var11_11 = (int)var8_8.interactsWith(var1_1, var11_11, var4_4)) == 0) {
                var11_11 = 1;
            } else lbl-1000:
            // 2 sources

            {
                var11_11 = 0;
                var12_12 = null;
            }
            if (var11_11 == 0) continue;
            var12_12 = this.mPostponedTransactions;
            if (var12_12 == null) {
                this.mPostponedTransactions = var12_12 = new ArrayList();
            }
            var12_12 = new ArrayList(var8_8, var10_10);
            var13_13 = this.mPostponedTransactions;
            var13_13.add(var12_12);
            var8_8.setOnStartPostponedListener((Fragment$OnStartEnterTransitionListener)var12_12);
            if (var10_10) {
                var8_8.executeOps();
            } else {
                var8_8.executePopOps(false);
            }
            if (var6_6 != (var7_7 += -1)) {
                var1_1.remove(var6_6);
                var1_1.add(var7_7, var8_8);
            }
            this.addAddedFragments(var5_5);
        }
        return var7_7;
    }

    private void removeRedundantOperationsAndExecute(ArrayList serializable, ArrayList arrayList) {
        int n10;
        boolean n11 = ((ArrayList)serializable).isEmpty();
        if (n11) {
            return;
        }
        int n12 = ((ArrayList)serializable).size();
        if (n12 == (n10 = arrayList.size())) {
            this.executePostponedTransaction((ArrayList)serializable, arrayList);
            int n13 = ((ArrayList)serializable).size();
            int n14 = 0;
            for (n10 = 0; n10 < n13; ++n10) {
                Object object = (BackStackRecord)((ArrayList)serializable).get(n10);
                boolean bl2 = ((FragmentTransaction)object).mReorderingAllowed;
                if (bl2) continue;
                if (n14 != n10) {
                    this.executeOpsTogether((ArrayList)serializable, arrayList, n14, n10);
                }
                if (bl2 = ((Boolean)(object = (Boolean)arrayList.get(n10))).booleanValue()) {
                    for (n14 = n10 + 1; n14 < n13 && (bl2 = ((Boolean)(object = (Boolean)arrayList.get(n14))).booleanValue()); ++n14) {
                        object = (BackStackRecord)((ArrayList)serializable).get(n14);
                        bl2 = ((FragmentTransaction)object).mReorderingAllowed;
                        if (bl2) break;
                    }
                }
                this.executeOpsTogether((ArrayList)serializable, arrayList, n10, n14);
                n10 = n14 + -1;
            }
            if (n14 != n13) {
                this.executeOpsTogether((ArrayList)serializable, arrayList, n14, n13);
            }
            return;
        }
        serializable = new IllegalStateException("Internal error with the back stack records");
        throw serializable;
    }

    private void reportBackStackChanged() {
        ArrayList arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            Object object;
            int n10;
            arrayList = null;
            for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mBackStackChangeListeners)).size()); ++i10) {
                object = (FragmentManager$OnBackStackChangedListener)this.mBackStackChangeListeners.get(i10);
                object.onBackStackChanged();
            }
        }
    }

    public static int reverseTransit(int n10) {
        int n11 = 8194;
        int n12 = 4099;
        int n13 = 4097;
        if (n10 != n13) {
            n11 = n10 != n12 ? (n10 != n11 ? 0 : n13) : n12;
        }
        return n11;
    }

    private void setVisibleRemovingFragment(Fragment fragment) {
        Object object = this.getFragmentContainer(fragment);
        if (object != null) {
            int n10 = fragment.getEnterAnim();
            int n11 = fragment.getExitAnim();
            n10 += n11;
            n11 = fragment.getPopEnterAnim();
            n10 += n11;
            n11 = fragment.getPopExitAnim();
            if ((n10 += n11) > 0) {
                n10 = R$id.visible_removing_fragment_view_tag;
                Object object2 = object.getTag(n10);
                if (object2 == null) {
                    object.setTag(n10, (Object)fragment);
                }
                object = (Fragment)object.getTag(n10);
                boolean bl2 = fragment.getPopDirection();
                ((Fragment)object).setPopDirection(bl2);
            }
        }
    }

    private void startPendingDeferredFragments() {
        boolean bl2;
        Iterator iterator2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (bl2 = iterator2.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager)iterator2.next();
            this.performPendingDeferredStart(fragmentStateManager);
        }
    }

    private void throwException(RuntimeException runtimeException) {
        String[] stringArray = runtimeException.getMessage();
        String string2 = TAG;
        Log.e((String)string2, (String)stringArray);
        Log.e((String)string2, (String)"Activity state:");
        stringArray = new LogWriter(string2);
        PrintWriter printWriter = new PrintWriter((Writer)stringArray);
        stringArray = this.mHost;
        String string3 = "Failed dumping state";
        String[] stringArray2 = null;
        String string4 = "  ";
        if (stringArray != null) {
            stringArray2 = new String[]{};
            try {
                stringArray.onDump(string4, null, printWriter, stringArray2);
            }
            catch (Exception exception) {
                Log.e((String)string2, (String)string3, (Throwable)exception);
            }
        } else {
            stringArray = new String[]{};
            try {
                this.dump(string4, null, printWriter, stringArray);
            }
            catch (Exception exception) {
                Log.e((String)string2, (String)string3, (Throwable)exception);
            }
        }
        throw runtimeException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void updateOnBackPressedCallbackEnabled() {
        Object object = this.mPendingActions;
        synchronized (object) {
            Object object2 = this.mPendingActions;
            int n10 = ((ArrayList)object2).isEmpty();
            boolean bl2 = true;
            if (n10 == 0) {
                object2 = this.mOnBackPressedCallback;
                ((OnBackPressedCallback)object2).setEnabled(bl2);
                return;
            }
            object = this.mOnBackPressedCallback;
            n10 = this.getBackStackEntryCount();
            if (n10 <= 0 || (n10 = (int)(this.isPrimaryNavigation((Fragment)(object2 = this.mParent)) ? 1 : 0)) == 0) {
                bl2 = false;
            }
            ((OnBackPressedCallback)object).setEnabled(bl2);
            return;
        }
    }

    public void addBackStackState(BackStackRecord backStackRecord) {
        ArrayList arrayList = this.mBackStack;
        if (arrayList == null) {
            this.mBackStack = arrayList = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
    }

    public void addCancellationSignal(Fragment fragment, CancellationSignal cancellationSignal) {
        Object object = this.mExitAnimationCancellationSignals.get(fragment);
        if (object == null) {
            object = this.mExitAnimationCancellationSignals;
            HashSet hashSet = new HashSet();
            object.put((Fragment)fragment, hashSet);
        }
        ((HashSet)this.mExitAnimationCancellationSignals.get(fragment)).add(cancellationSignal);
    }

    public FragmentStateManager addFragment(Fragment fragment) {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("add: ");
            ((StringBuilder)object2).append(fragment);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.v((String)object, (String)object2);
        }
        object2 = this.createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        object = this.mFragmentStore;
        ((FragmentStore)object).makeActive((FragmentStateManager)object2);
        boolean bl3 = fragment.mDetached;
        if (!bl3) {
            boolean bl4;
            this.mFragmentStore.addFragment(fragment);
            bl3 = false;
            object = null;
            fragment.mRemoving = false;
            View view = fragment.mView;
            if (view == null) {
                fragment.mHiddenChanged = false;
            }
            if (bl4 = this.isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = bl4 = true;
            }
        }
        return object2;
    }

    public void addFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.add(fragmentOnAttachListener);
    }

    public void addOnBackStackChangedListener(FragmentManager$OnBackStackChangedListener fragmentManager$OnBackStackChangedListener) {
        ArrayList arrayList = this.mBackStackChangeListeners;
        if (arrayList == null) {
            this.mBackStackChangeListeners = arrayList = new ArrayList();
        }
        this.mBackStackChangeListeners.add(fragmentManager$OnBackStackChangedListener);
    }

    public void addRetainedFragment(Fragment fragment) {
        this.mNonConfig.addRetainedFragment(fragment);
    }

    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    public void attachController(FragmentHostCallback object, FragmentContainer object2, Fragment object3) {
        Object object4 = this.mHost;
        if (object4 == null) {
            Object object5;
            boolean bl2;
            this.mHost = object;
            this.mContainer = object2;
            this.mParent = object3;
            if (object3 != null) {
                object2 = new FragmentManager$8(this, (Fragment)object3);
                this.addFragmentOnAttachListener((FragmentOnAttachListener)object2);
            } else {
                bl2 = object instanceof FragmentOnAttachListener;
                if (bl2) {
                    object2 = object;
                    object2 = (FragmentOnAttachListener)object;
                    this.addFragmentOnAttachListener((FragmentOnAttachListener)object2);
                }
            }
            object2 = this.mParent;
            if (object2 != null) {
                this.updateOnBackPressedCallbackEnabled();
            }
            if (bl2 = object instanceof OnBackPressedDispatcherOwner) {
                object2 = object;
                object2 = (OnBackPressedDispatcherOwner)object;
                this.mOnBackPressedDispatcher = object4 = object2.getOnBackPressedDispatcher();
                if (object3 != null) {
                    object2 = object3;
                }
                object5 = this.mOnBackPressedCallback;
                ((OnBackPressedDispatcher)object4).addCallback((LifecycleOwner)object2, (OnBackPressedCallback)object5);
            }
            if (object3 != null) {
                this.mNonConfig = object = ((Fragment)object3).mFragmentManager.getChildNonConfig((Fragment)object3);
            } else {
                bl2 = object instanceof ViewModelStoreOwner;
                if (bl2) {
                    this.mNonConfig = object = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner)object).getViewModelStore());
                } else {
                    bl2 = false;
                    object2 = null;
                    this.mNonConfig = object = new FragmentManagerViewModel(false);
                }
            }
            object = this.mNonConfig;
            bl2 = this.isStateSaved();
            ((FragmentManagerViewModel)object).setIsStateSaved(bl2);
            object = this.mFragmentStore;
            object2 = this.mNonConfig;
            ((FragmentStore)object).setNonConfig((FragmentManagerViewModel)object2);
            object = this.mHost;
            bl2 = object instanceof ActivityResultRegistryOwner;
            if (bl2) {
                object = ((ActivityResultRegistryOwner)object).getActivityResultRegistry();
                if (object3 != null) {
                    object2 = new StringBuilder();
                    object3 = ((Fragment)object3).mWho;
                    ((StringBuilder)object2).append((String)object3);
                    object3 = ":";
                    ((StringBuilder)object2).append((String)object3);
                    object2 = ((StringBuilder)object2).toString();
                } else {
                    object2 = "";
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("FragmentManager:");
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("StartActivityForResult");
                object3 = ((StringBuilder)object3).toString();
                object4 = new ActivityResultContracts$StartActivityForResult();
                object5 = new FragmentManager$9(this);
                this.mStartActivityForResult = object3 = ((ActivityResultRegistry)object).register((String)object3, (ActivityResultContract)object4, (ActivityResultCallback)object5);
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("StartIntentSenderForResult");
                object3 = ((StringBuilder)object3).toString();
                object4 = new FragmentManager$FragmentIntentSenderContract();
                object5 = new FragmentManager$10(this);
                this.mStartIntentSenderForResult = object3 = ((ActivityResultRegistry)object).register((String)object3, (ActivityResultContract)object4, (ActivityResultCallback)object5);
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append("RequestPermissions");
                object2 = ((StringBuilder)object3).toString();
                object3 = new ActivityResultContracts$RequestMultiplePermissions();
                object4 = new FragmentManager$11(this);
                this.mRequestPermissions = object = ((ActivityResultRegistry)object).register((String)object2, (ActivityResultContract)object3, (ActivityResultCallback)object4);
            }
            return;
        }
        object = new IllegalStateException("Already attached");
        throw object;
    }

    public void attachFragment(Fragment fragment) {
        Object object;
        int n10 = 2;
        boolean bl2 = FragmentManager.isLoggingEnabled(n10);
        String string2 = TAG;
        if (bl2) {
            object = new StringBuilder();
            String string3 = "attach: ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(fragment);
            object = ((StringBuilder)object).toString();
            Log.v((String)string2, (String)object);
        }
        if (bl2 = fragment.mDetached) {
            object = null;
            fragment.mDetached = false;
            bl2 = fragment.mAdded;
            if (!bl2) {
                boolean bl3;
                object = this.mFragmentStore;
                ((FragmentStore)object).addFragment(fragment);
                n10 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0);
                if (n10 != 0) {
                    CharSequence charSequence = new StringBuilder();
                    object = "add from attach: ";
                    charSequence.append((String)object);
                    charSequence.append(fragment);
                    charSequence = charSequence.toString();
                    Log.v((String)string2, (String)charSequence);
                }
                if (bl3 = this.isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = bl3 = true;
                }
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        BackStackRecord backStackRecord = new BackStackRecord(this);
        return backStackRecord;
    }

    public boolean checkForMenus() {
        boolean bl2;
        Iterator iterator2 = this.mFragmentStore.getActiveFragments().iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment != null) {
                bl3 = this.isMenuAvailable(fragment);
            }
            if (!bl3) continue;
            return true;
        }
        return false;
    }

    public final void clearFragmentResult(String string2) {
        this.mResults.remove(string2);
    }

    public final void clearFragmentResultListener(String object) {
        Map map = this.mResultListeners;
        if ((object = (FragmentManager$LifecycleAwareResultListener)map.remove(object)) != null) {
            ((FragmentManager$LifecycleAwareResultListener)object).removeObserver();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void completeExecute(BackStackRecord backStackRecord, boolean bl2, boolean bl3, boolean bl4) {
        FragmentContainer fragmentContainer;
        Context context;
        boolean bl5;
        boolean bl6;
        void var4_6;
        if (bl2) {
            backStackRecord.executePopOps((boolean)var4_6);
        } else {
            backStackRecord.executeOps();
        }
        boolean bl7 = true;
        View view = new ArrayList((int)(bl7 ? 1 : 0));
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>((int)(bl7 ? 1 : 0));
        view.add(backStackRecord);
        Object object = bl2;
        arrayList.add((Boolean)object);
        if (bl6 && (bl5 = this.mCurState) >= bl7) {
            object = this.mHost;
            context = ((FragmentHostCallback)object).getContext();
            fragmentContainer = this.mContainer;
            int n10 = 1;
            boolean bl8 = true;
            FragmentTransition$Callback fragmentTransition$Callback = this.mFragmentTransitionCallback;
            FragmentTransition.startTransitions(context, fragmentContainer, view, arrayList, 0, n10, bl8, fragmentTransition$Callback);
        }
        if (var4_6 != false) {
            int n11 = this.mCurState;
            this.moveToState(n11, bl7);
        }
        object = this.mFragmentStore.getActiveFragments().iterator();
        while (bl6 = object.hasNext()) {
            int n12;
            Fragment fragment = (Fragment)object.next();
            if (fragment == null || (context = fragment.mView) == null || (n12 = fragment.mIsNewlyAdded) == 0) continue;
            n12 = fragment.mContainerId;
            if ((n12 = (int)(backStackRecord.interactsWith(n12) ? 1 : 0)) == 0) continue;
            float f10 = fragment.mPostponedAlpha;
            fragmentContainer = null;
            float f11 = f10 - 0.0f;
            Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                view = fragment.mView;
                view.setAlpha(f10);
            }
            if (var4_6 != false) {
                fragment.mPostponedAlpha = 0.0f;
                continue;
            }
            fragment.mPostponedAlpha = -1.0f;
            n12 = 0;
            f10 = 0.0f;
            context = null;
            fragment.mIsNewlyAdded = false;
        }
    }

    public FragmentStateManager createOrGetFragmentStateManager(Fragment object) {
        Object object2 = this.mFragmentStore;
        Object object3 = ((Fragment)object).mWho;
        if ((object2 = ((FragmentStore)object2).getFragmentStateManager((String)object3)) != null) {
            return object2;
        }
        object3 = this.mLifecycleCallbacksDispatcher;
        FragmentStore fragmentStore = this.mFragmentStore;
        object2 = new FragmentStateManager((FragmentLifecycleCallbacksDispatcher)object3, fragmentStore, (Fragment)object);
        object = this.mHost.getContext().getClassLoader();
        ((FragmentStateManager)object2).restoreState((ClassLoader)object);
        int n10 = this.mCurState;
        ((FragmentStateManager)object2).setFragmentManagerState(n10);
        return object2;
    }

    public void detachFragment(Fragment fragment) {
        String string2;
        int n10 = 2;
        boolean bl2 = FragmentManager.isLoggingEnabled(n10);
        String string3 = TAG;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            string2 = "detach: ";
            charSequence.append(string2);
            charSequence.append(fragment);
            charSequence = charSequence.toString();
            Log.v((String)string3, (String)charSequence);
        }
        if (!(bl2 = fragment.mDetached)) {
            fragment.mDetached = bl2 = true;
            boolean bl3 = fragment.mAdded;
            if (bl3) {
                Object object;
                if ((n10 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0)) != 0) {
                    object = new StringBuilder();
                    string2 = "remove from detach: ";
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(fragment);
                    object = ((StringBuilder)object).toString();
                    Log.v((String)string3, (String)object);
                }
                object = this.mFragmentStore;
                ((FragmentStore)object).removeFragment(fragment);
                n10 = (int)(this.isMenuAvailable(fragment) ? 1 : 0);
                if (n10 != 0) {
                    this.mNeedMenuInvalidate = bl2;
                }
                this.setVisibleRemovingFragment(fragment);
            }
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(4);
    }

    public void dispatchAttach() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(0);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        boolean bl2;
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null) continue;
            fragment.performConfigurationChanged(configuration);
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        boolean bl2;
        int n10 = this.mCurState;
        int n11 = 1;
        if (n10 < n11) {
            return false;
        }
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null || !(bl2 = fragment.performContextItemSelected(menuItem))) continue;
            return n11 != 0;
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(Menu object, MenuInflater menuInflater) {
        boolean bl2;
        int n10 = this.mCurState;
        int n11 = 0;
        int n12 = 1;
        if (n10 < n12) {
            return false;
        }
        n10 = 0;
        ArrayList<Fragment> arrayList = null;
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        int n13 = 0;
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null || !(bl3 = this.isParentMenuVisible(fragment)) || !(bl3 = fragment.performCreateOptionsMenu((Menu)object, menuInflater))) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<Fragment>();
            }
            arrayList.add(fragment);
            n13 = n12;
        }
        object = this.mCreatedMenus;
        if (object != null) {
            int n14;
            while (n11 < (n14 = ((ArrayList)(object = this.mCreatedMenus)).size())) {
                boolean bl4;
                object = (Fragment)this.mCreatedMenus.get(n11);
                if (arrayList == null || !(bl4 = arrayList.contains(object))) {
                    ((Fragment)object).onDestroyOptionsMenu();
                }
                ++n11;
            }
        }
        this.mCreatedMenus = arrayList;
        return n13 != 0;
    }

    public void dispatchDestroy() {
        boolean bl2;
        this.mDestroyed = bl2 = true;
        this.execPendingActions(bl2);
        this.endAnimatingAwayFragments();
        this.dispatchStateChange(-1);
        bl2 = false;
        ActivityResultLauncher activityResultLauncher = null;
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        Object object = this.mOnBackPressedDispatcher;
        if (object != null) {
            object = this.mOnBackPressedCallback;
            ((OnBackPressedCallback)object).remove();
            this.mOnBackPressedDispatcher = null;
        }
        if ((activityResultLauncher = this.mStartActivityForResult) != null) {
            activityResultLauncher.unregister();
            this.mStartIntentSenderForResult.unregister();
            activityResultLauncher = this.mRequestPermissions;
            activityResultLauncher.unregister();
        }
    }

    public void dispatchDestroyView() {
        this.dispatchStateChange(1);
    }

    public void dispatchLowMemory() {
        boolean bl2;
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null) continue;
            fragment.performLowMemory();
        }
    }

    public void dispatchMultiWindowModeChanged(boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl3 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null) continue;
            fragment.performMultiWindowModeChanged(bl2);
        }
    }

    public void dispatchOnAttachFragment(Fragment fragment) {
        boolean bl2;
        Iterator iterator2 = this.mOnAttachListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            FragmentOnAttachListener fragmentOnAttachListener = (FragmentOnAttachListener)iterator2.next();
            fragmentOnAttachListener.onAttachFragment(this, fragment);
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        boolean bl2;
        int n10 = this.mCurState;
        int n11 = 1;
        if (n10 < n11) {
            return false;
        }
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null || !(bl2 = fragment.performOptionsItemSelected(menuItem))) continue;
            return n11 != 0;
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu2) {
        int n10 = this.mCurState;
        int n11 = 1;
        if (n10 < n11) {
            return;
        }
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null) continue;
            fragment.performOptionsMenuClosed(menu2);
        }
    }

    public void dispatchPause() {
        this.dispatchStateChange(5);
    }

    public void dispatchPictureInPictureModeChanged(boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl3 = iterator2.hasNext()) {
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null) continue;
            fragment.performPictureInPictureModeChanged(bl2);
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu2) {
        boolean bl2;
        int n10 = this.mCurState;
        int n11 = 0;
        int n12 = 1;
        if (n10 < n12) {
            return false;
        }
        Iterator iterator2 = this.mFragmentStore.getFragments().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Fragment fragment = (Fragment)iterator2.next();
            if (fragment == null || !(bl3 = this.isParentMenuVisible(fragment)) || !(bl2 = fragment.performPrepareOptionsMenu(menu2))) continue;
            n11 = n12;
        }
        return n11 != 0;
    }

    public void dispatchPrimaryNavigationFragmentChanged() {
        this.updateOnBackPressedCallbackEnabled();
        Fragment fragment = this.mPrimaryNav;
        this.dispatchParentPrimaryNavigationFragmentChanged(fragment);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(7);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.setIsStateSaved(false);
        this.dispatchStateChange(5);
    }

    public void dispatchStop() {
        boolean bl2;
        this.mStopped = bl2 = true;
        this.mNonConfig.setIsStateSaved(bl2);
        this.dispatchStateChange(4);
    }

    public void dispatchViewCreated() {
        this.dispatchStateChange(2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] stringArray) {
        String string3;
        int n10;
        Object object2;
        int n11;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append("    ");
        object3 = ((StringBuilder)object3).toString();
        Object object4 = this.mFragmentStore;
        ((FragmentStore)object4).dump(string2, (FileDescriptor)object, printWriter, stringArray);
        object = this.mCreatedMenus;
        int n12 = 0;
        stringArray = null;
        if (object != null && (n11 = ((ArrayList)object).size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Fragments Created Menus:");
            object4 = null;
            for (n10 = 0; n10 < n11; object2 = ((Fragment)object2).toString(), n10 += 1) {
                object2 = (Fragment)this.mCreatedMenus.get(n10);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n10);
                string3 = ": ";
                printWriter.print(string3);
                printWriter.println((String)object2);
            }
        }
        if ((object = this.mBackStack) != null && (n11 = ((ArrayList)object).size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Back Stack:");
            object4 = null;
            for (n10 = 0; n10 < n11; n10 += 1) {
                object2 = (BackStackRecord)this.mBackStack.get(n10);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(n10);
                printWriter.print(": ");
                string3 = ((BackStackRecord)object2).toString();
                printWriter.println(string3);
                ((BackStackRecord)object2).dump((String)object3, printWriter);
            }
        }
        printWriter.print(string2);
        object = new StringBuilder();
        ((StringBuilder)object).append("Back Stack Index: ");
        object3 = this.mBackStackIndex;
        int n13 = ((AtomicInteger)object3).get();
        ((StringBuilder)object).append(n13);
        object = ((StringBuilder)object).toString();
        printWriter.println((String)object);
        object = this.mPendingActions;
        synchronized (object) {
            object3 = this.mPendingActions;
            n13 = ((ArrayList)object3).size();
            if (n13 > 0) {
                printWriter.print(string2);
                object4 = "Pending Actions:";
                printWriter.println((String)object4);
                while (n12 < n13) {
                    object4 = this.mPendingActions;
                    object4 = ((ArrayList)object4).get(n12);
                    object4 = (FragmentManager$OpGenerator)object4;
                    printWriter.print(string2);
                    object2 = "  #";
                    printWriter.print((String)object2);
                    printWriter.print(n12);
                    object2 = ": ";
                    printWriter.print((String)object2);
                    printWriter.println(object4);
                    ++n12;
                }
            }
        }
        printWriter.print(string2);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(string2);
        printWriter.print("  mHost=");
        object = this.mHost;
        printWriter.println(object);
        printWriter.print(string2);
        printWriter.print("  mContainer=");
        object = this.mContainer;
        printWriter.println(object);
        object = this.mParent;
        if (object != null) {
            printWriter.print(string2);
            printWriter.print("  mParent=");
            object = this.mParent;
            printWriter.println(object);
        }
        printWriter.print(string2);
        printWriter.print("  mCurState=");
        n11 = this.mCurState;
        printWriter.print(n11);
        printWriter.print(" mStateSaved=");
        n11 = (int)(this.mStateSaved ? 1 : 0);
        printWriter.print(n11 != 0);
        printWriter.print(" mStopped=");
        n11 = this.mStopped;
        printWriter.print(n11 != 0);
        object = " mDestroyed=";
        printWriter.print((String)object);
        n11 = this.mDestroyed;
        printWriter.println(n11 != 0);
        n11 = this.mNeedMenuInvalidate;
        if (n11) {
            printWriter.print(string2);
            string2 = "  mNeedMenuInvalidate=";
            printWriter.print(string2);
            boolean bl2 = this.mNeedMenuInvalidate;
            printWriter.println(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void enqueueAction(FragmentManager$OpGenerator object, boolean bl2) {
        Object object2;
        if (!bl2) {
            object2 = this.mHost;
            if (object2 == null) {
                boolean bl3 = this.mDestroyed;
                if (bl3) {
                    object = new IllegalStateException("FragmentManager has been destroyed");
                    throw object;
                }
                object = new IllegalStateException("FragmentManager has not been attached to a host.");
                throw object;
            }
            this.checkStateLoss();
        }
        object2 = this.mPendingActions;
        synchronized (object2) {
            FragmentHostCallback fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                ArrayList arrayList = this.mPendingActions;
                arrayList.add(object);
                this.scheduleCommit();
                return;
            }
            if (bl2) {
                return;
            }
            String string2 = "Activity has been destroyed";
            object = new IllegalStateException(string2);
            throw object;
        }
    }

    public boolean execPendingActions(boolean bl2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean bl3;
        this.ensureExecReady(bl2);
        bl2 = true;
        boolean bl4 = false;
        ArrayList arrayList3 = null;
        while (bl3 = this.generateOpsForPendingActions(arrayList2 = this.mTmpRecords, arrayList = this.mTmpIsPop)) {
            this.mExecutingActions = bl2;
            try {
                arrayList3 = this.mTmpRecords;
                arrayList2 = this.mTmpIsPop;
                this.removeRedundantOperationsAndExecute(arrayList3, arrayList2);
                bl4 = bl2;
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return bl4;
    }

    public void execSingleAction(FragmentManager$OpGenerator object, boolean bl2) {
        boolean bl3;
        Object object2;
        if (bl2 && ((object2 = this.mHost) == null || (bl3 = this.mDestroyed))) {
            return;
        }
        this.ensureExecReady(bl2);
        ArrayList arrayList = this.mTmpRecords;
        object2 = this.mTmpIsPop;
        boolean bl4 = object.generateOps(arrayList, (ArrayList)object2);
        if (bl4) {
            this.mExecutingActions = bl4 = true;
            try {
                object = this.mTmpRecords;
                arrayList = this.mTmpIsPop;
                this.removeRedundantOperationsAndExecute((ArrayList)object, arrayList);
            }
            finally {
                this.cleanupExec();
            }
        }
        this.updateOnBackPressedCallbackEnabled();
        this.doPendingDeferredStart();
        this.mFragmentStore.burpActive();
    }

    public boolean executePendingTransactions() {
        boolean bl2 = this.execPendingActions(true);
        this.forcePostponedTransactions();
        return bl2;
    }

    public Fragment findActiveFragment(String string2) {
        return this.mFragmentStore.findActiveFragment(string2);
    }

    public Fragment findFragmentById(int n10) {
        return this.mFragmentStore.findFragmentById(n10);
    }

    public Fragment findFragmentByTag(String string2) {
        return this.mFragmentStore.findFragmentByTag(string2);
    }

    public Fragment findFragmentByWho(String string2) {
        return this.mFragmentStore.findFragmentByWho(string2);
    }

    public int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    public List getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    public FragmentManager$BackStackEntry getBackStackEntryAt(int n10) {
        return (FragmentManager$BackStackEntry)this.mBackStack.get(n10);
    }

    public int getBackStackEntryCount() {
        int n10;
        ArrayList arrayList = this.mBackStack;
        if (arrayList != null) {
            n10 = arrayList.size();
        } else {
            n10 = 0;
            arrayList = null;
        }
        return n10;
    }

    public FragmentContainer getContainer() {
        return this.mContainer;
    }

    public Fragment getFragment(Bundle object, String string2) {
        if ((object = object.getString(string2)) == null) {
            return null;
        }
        Fragment fragment = this.findActiveFragment((String)object);
        if (fragment == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "Fragment no longer exists for key ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = ": unique id ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            this.throwException(illegalStateException);
        }
        return fragment;
    }

    public FragmentFactory getFragmentFactory() {
        Object object = this.mFragmentFactory;
        if (object != null) {
            return object;
        }
        object = this.mParent;
        if (object != null) {
            return ((Fragment)object).mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    public FragmentStore getFragmentStore() {
        return this.mFragmentStore;
    }

    public List getFragments() {
        return this.mFragmentStore.getFragments();
    }

    public FragmentHostCallback getHost() {
        return this.mHost;
    }

    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    public Fragment getParent() {
        return this.mParent;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    public SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        Object object = this.mSpecialEffectsControllerFactory;
        if (object != null) {
            return object;
        }
        object = this.mParent;
        if (object != null) {
            return ((Fragment)object).mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public ViewModelStore getViewModelStore(Fragment fragment) {
        return this.mNonConfig.getViewModelStore(fragment);
    }

    public void handleOnBackPressed() {
        this.execPendingActions(true);
        Object object = this.mOnBackPressedCallback;
        boolean bl2 = ((OnBackPressedCallback)object).isEnabled();
        if (bl2) {
            this.popBackStackImmediate();
        } else {
            object = this.mOnBackPressedDispatcher;
            ((OnBackPressedDispatcher)object).onBackPressed();
        }
    }

    public void hideFragment(Fragment fragment) {
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("hide: ");
            charSequence.append(fragment);
            charSequence = charSequence.toString();
            String string2 = TAG;
            Log.v((String)string2, (String)charSequence);
        }
        if (!(bl2 = fragment.mHidden)) {
            fragment.mHidden = bl2 = true;
            boolean bl3 = fragment.mHiddenChanged;
            fragment.mHiddenChanged = bl2 ^= bl3;
            this.setVisibleRemovingFragment(fragment);
        }
    }

    public void invalidateMenuForFragment(Fragment fragment) {
        boolean bl2;
        boolean bl3 = fragment.mAdded;
        if (bl3 && (bl2 = this.isMenuAvailable(fragment))) {
            this.mNeedMenuInvalidate = bl2 = true;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isParentMenuVisible(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean isPrimaryNavigation(Fragment fragment) {
        boolean bl2 = true;
        if (fragment == null) {
            return bl2;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        Fragment fragment2 = fragmentManager.getPrimaryNavigationFragment();
        boolean bl3 = fragment.equals(fragment2);
        if (!bl3 || !(bl3 = this.isPrimaryNavigation(fragment = fragmentManager.mParent))) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean isStateAtLeast(int n10) {
        int n11 = this.mCurState;
        n10 = n11 >= n10 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isStateSaved() {
        boolean bl2 = this.mStateSaved;
        bl2 = bl2 || (bl2 = this.mStopped);
        return bl2;
    }

    public void launchRequestPermissions(Fragment object, String[] stringArray, int n10) {
        Object object2 = this.mRequestPermissions;
        if (object2 != null) {
            object = ((Fragment)object).mWho;
            object2 = new FragmentManager$LaunchedFragmentInfo((String)object, n10);
            this.mLaunchedFragments.addLast(object2);
            object = this.mRequestPermissions;
            ((ActivityResultLauncher)object).launch(stringArray);
        } else {
            object2 = this.mHost;
            ((FragmentHostCallback)object2).onRequestPermissionsFromFragment((Fragment)object, stringArray, n10);
        }
    }

    public void launchStartActivityForResult(Fragment object, Intent intent, int n10, Bundle bundle) {
        Object object2 = this.mStartActivityForResult;
        if (object2 != null) {
            object = ((Fragment)object).mWho;
            object2 = new FragmentManager$LaunchedFragmentInfo((String)object, n10);
            object = this.mLaunchedFragments;
            ((ArrayDeque)object).addLast(object2);
            if (intent != null && bundle != null) {
                object = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
                intent.putExtra((String)object, bundle);
            }
            object = this.mStartActivityForResult;
            ((ActivityResultLauncher)object).launch(intent);
        } else {
            object2 = this.mHost;
            ((FragmentHostCallback)object2).onStartActivityFromFragment((Fragment)object, intent, n10, bundle);
        }
    }

    public void launchStartIntentSenderForResult(Fragment fragment, IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13, Bundle bundle) {
        FragmentManager fragmentManager = this;
        Object object = fragment;
        Bundle bundle2 = bundle;
        Object object2 = this.mStartIntentSenderForResult;
        if (object2 != null) {
            Object object3;
            Object object4;
            Object object5;
            object2 = TAG;
            int n14 = 2;
            if (bundle != null) {
                boolean bl2;
                if (intent == null) {
                    object5 = new Intent();
                    bl2 = true;
                    object4 = EXTRA_CREATED_FILLIN_INTENT;
                    object5.putExtra((String)object4, bl2);
                } else {
                    object5 = intent;
                }
                bl2 = FragmentManager.isLoggingEnabled(n14);
                if (bl2) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("ActivityOptions ");
                    ((StringBuilder)object3).append(bundle2);
                    ((StringBuilder)object3).append(" were added to fillInIntent ");
                    ((StringBuilder)object3).append(object5);
                    object4 = " for fragment ";
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append(fragment);
                    object3 = ((StringBuilder)object3).toString();
                    Log.v((String)object2, (String)object3);
                }
                object3 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
                object5.putExtra((String)object3, bundle2);
            } else {
                object5 = intent;
            }
            object4 = intentSender;
            object3 = new IntentSenderRequest$Builder(intentSender);
            object5 = ((IntentSenderRequest$Builder)object3).setFillInIntent((Intent)object5).setFlags(n12, n11).build();
            object4 = ((Fragment)object).mWho;
            object3 = new FragmentManager$LaunchedFragmentInfo((String)object4, n10);
            object4 = fragmentManager.mLaunchedFragments;
            object4.addLast(object3);
            n14 = (int)(FragmentManager.isLoggingEnabled(n14) ? 1 : 0);
            if (n14 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                object3 = "Fragment ";
                stringBuilder.append((String)object3);
                stringBuilder.append(fragment);
                stringBuilder.append("is launching an IntentSender for result ");
                object = stringBuilder.toString();
                Log.v((String)object2, (String)object);
            }
            object2 = fragmentManager.mStartIntentSenderForResult;
            ((ActivityResultLauncher)object2).launch(object5);
        } else {
            IntentSender intentSender2 = intentSender;
            object2 = this.mHost;
            IntentSender intentSender3 = intentSender;
            Intent intent2 = intent;
            ((FragmentHostCallback)object2).onStartIntentSenderFromFragment(fragment, intentSender, n10, intent, n11, n12, n13, bundle);
        }
    }

    public void moveFragmentToExpectedState(Fragment object) {
        boolean bl2;
        Object object2 = this.mFragmentStore;
        String string2 = ((Fragment)object).mWho;
        boolean bl3 = ((FragmentStore)object2).containsActiveFragment(string2);
        if (!bl3) {
            bl3 = FragmentManager.isLoggingEnabled(3);
            if (bl3) {
                object2 = new StringBuilder();
                string2 = "Ignoring moving ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" to state ");
                int n10 = this.mCurState;
                ((StringBuilder)object2).append(n10);
                ((StringBuilder)object2).append("since it is not added to ");
                ((StringBuilder)object2).append(this);
                object = ((StringBuilder)object2).toString();
                object2 = TAG;
                Log.d((String)object2, (String)object);
            }
            return;
        }
        this.moveToState((Fragment)object);
        object2 = ((Fragment)object).mView;
        if (object2 != null && (bl2 = ((Fragment)object).mIsNewlyAdded) && (string2 = ((Fragment)object).mContainer) != null) {
            float f10 = ((Fragment)object).mPostponedAlpha;
            boolean bl4 = false;
            View view = null;
            float f11 = f10 - 0.0f;
            Object object3 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object3 > 0) {
                object2.setAlpha(f10);
            }
            ((Fragment)object).mPostponedAlpha = 0.0f;
            bl3 = false;
            ((Fragment)object).mIsNewlyAdded = false;
            object2 = this.mHost.getContext();
            bl2 = true;
            f10 = Float.MIN_VALUE;
            bl4 = ((Fragment)object).getPopDirection();
            if ((object2 = FragmentAnim.loadAnimation((Context)object2, (Fragment)object, bl2, bl4)) != null) {
                string2 = ((FragmentAnim$AnimationOrAnimator)object2).animation;
                if (string2 != null) {
                    object2 = ((Fragment)object).mView;
                    object2.startAnimation((Animation)string2);
                } else {
                    string2 = ((FragmentAnim$AnimationOrAnimator)object2).animator;
                    view = ((Fragment)object).mView;
                    string2.setTarget((Object)view);
                    object2 = ((FragmentAnim$AnimationOrAnimator)object2).animator;
                    object2.start();
                }
            }
        }
        if (bl3 = ((Fragment)object).mHiddenChanged) {
            this.completeShowHideFragment((Fragment)object);
        }
    }

    public void moveToState(int n10, boolean n11) {
        int n12;
        Object object;
        int n13;
        Object object2 = this.mHost;
        if (object2 == null && n10 != (n13 = -1)) {
            IllegalStateException illegalStateException = new IllegalStateException("No activity");
            throw illegalStateException;
        }
        if (n11 == 0 && n10 == (n11 = this.mCurState)) {
            return;
        }
        this.mCurState = n10;
        n10 = (int)(USE_STATE_MANAGER ? 1 : 0);
        n11 = 0;
        if (n10 != 0) {
            object = this.mFragmentStore;
            ((FragmentStore)object).moveToExpectedState();
        } else {
            object = this.mFragmentStore.getFragments().iterator();
            while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (Fragment)object.next();
                this.moveFragmentToExpectedState((Fragment)object2);
            }
            object = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
            while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (FragmentStateManager)object.next();
                Object object3 = ((FragmentStateManager)object2).getFragment();
                boolean bl2 = ((Fragment)object3).mIsNewlyAdded;
                if (!bl2) {
                    this.moveFragmentToExpectedState((Fragment)object3);
                }
                if ((bl2 = ((Fragment)object3).mRemoving) && (n12 = (int)(((Fragment)object3).isInBackStack() ? 1 : 0)) == 0) {
                    n12 = 1;
                } else {
                    n12 = 0;
                    object3 = null;
                }
                if (n12 == 0) continue;
                object3 = this.mFragmentStore;
                ((FragmentStore)object3).makeInactive((FragmentStateManager)object2);
            }
        }
        this.startPendingDeferredFragments();
        n10 = (int)(this.mNeedMenuInvalidate ? 1 : 0);
        if (n10 != 0 && (object = this.mHost) != null && (n13 = this.mCurState) == (n12 = 7)) {
            ((FragmentHostCallback)object).onSupportInvalidateOptionsMenu();
            this.mNeedMenuInvalidate = false;
        }
    }

    public void moveToState(Fragment fragment) {
        int n10 = this.mCurState;
        this.moveToState(fragment, n10);
    }

    public void moveToState(Fragment fragment, int n10) {
        String string2;
        int n11;
        int n12;
        String string3;
        Object object;
        block37: {
            block43: {
                block38: {
                    Object object2;
                    block39: {
                        Object object3;
                        int n13;
                        int n14;
                        float f10;
                        int n15;
                        int n16;
                        int n17;
                        Object object4;
                        block40: {
                            block41: {
                                block42: {
                                    block30: {
                                        block36: {
                                            block35: {
                                                block34: {
                                                    block33: {
                                                        block32: {
                                                            block31: {
                                                                object = this.mFragmentStore;
                                                                string3 = fragment.mWho;
                                                                object = ((FragmentStore)object).getFragmentStateManager(string3);
                                                                n12 = 1;
                                                                if (object == null) {
                                                                    object2 = this.mLifecycleCallbacksDispatcher;
                                                                    object4 = this.mFragmentStore;
                                                                    object = new FragmentStateManager((FragmentLifecycleCallbacksDispatcher)object2, (FragmentStore)object4, fragment);
                                                                    ((FragmentStateManager)object).setFragmentManagerState(n12);
                                                                }
                                                                n17 = fragment.mFromLayout;
                                                                n16 = 2;
                                                                if (n17 && (n17 = fragment.mInLayout) && (n17 = fragment.mState) == n16) {
                                                                    n10 = Math.max(n10, n16);
                                                                }
                                                                n17 = ((FragmentStateManager)object).computeExpectedState();
                                                                n10 = Math.min(n10, n17);
                                                                n17 = fragment.mState;
                                                                n11 = 3;
                                                                string2 = TAG;
                                                                n15 = -1;
                                                                f10 = 0.0f / 0.0f;
                                                                n14 = 5;
                                                                n13 = 4;
                                                                if (n17 > n10) break block30;
                                                                if (n17 < n10 && !(n17 = (int)((object2 = this.mExitAnimationCancellationSignals).isEmpty() ? 1 : 0))) {
                                                                    this.cancelExitAnimation(fragment);
                                                                }
                                                                if ((n17 = fragment.mState) == n15) break block31;
                                                                if (!n17) break block32;
                                                                if (n17 == n12) break block33;
                                                                if (n17 == n16) break block34;
                                                                if (n17 == n13) break block35;
                                                                if (n17 == n14) break block36;
                                                                break block37;
                                                            }
                                                            if (n10 > n15) {
                                                                ((FragmentStateManager)object).attach();
                                                            }
                                                        }
                                                        if (n10 > 0) {
                                                            ((FragmentStateManager)object).create();
                                                        }
                                                    }
                                                    if (n10 > n15) {
                                                        ((FragmentStateManager)object).ensureInflatedView();
                                                    }
                                                    if (n10 > n12) {
                                                        ((FragmentStateManager)object).createView();
                                                    }
                                                }
                                                if (n10 > n16) {
                                                    ((FragmentStateManager)object).activityCreated();
                                                }
                                            }
                                            if (n10 > n13) {
                                                ((FragmentStateManager)object).start();
                                            }
                                        }
                                        if (n10 > n14) {
                                            ((FragmentStateManager)object).resume();
                                        }
                                        break block37;
                                    }
                                    if (n17 <= n10) break block37;
                                    if (!n17) break block38;
                                    if (n17 == n12) break block39;
                                    if (n17 == n16) break block40;
                                    if (n17 == n13) break block41;
                                    if (n17 == n14) break block42;
                                    int n18 = 7;
                                    if (n17 != n18) break block37;
                                    if (n10 < n18) {
                                        ((FragmentStateManager)object).pause();
                                    }
                                }
                                if (n10 < n14) {
                                    ((FragmentStateManager)object).stop();
                                }
                            }
                            if (n10 < n13) {
                                n17 = (int)(FragmentManager.isLoggingEnabled(n11) ? 1 : 0);
                                if (n17) {
                                    object2 = new StringBuilder();
                                    object3 = "movefrom ACTIVITY_CREATED: ";
                                    ((StringBuilder)object2).append((String)object3);
                                    ((StringBuilder)object2).append(fragment);
                                    object2 = ((StringBuilder)object2).toString();
                                    Log.d((String)string2, (String)object2);
                                }
                                if ((object2 = fragment.mView) != null && (n17 = (int)(((FragmentHostCallback)(object2 = this.mHost)).onShouldSaveFragmentState(fragment) ? 1 : 0)) && (object2 = fragment.mSavedViewState) == null) {
                                    ((FragmentStateManager)object).saveViewState();
                                }
                            }
                        }
                        if (n10 < n16) {
                            Object object5;
                            n17 = 0;
                            object2 = null;
                            object3 = fragment.mView;
                            if (object3 != null && (object5 = fragment.mContainer) != null) {
                                object5.endViewTransition(object3);
                                object3 = fragment.mView;
                                object3.clearAnimation();
                                n14 = (int)(fragment.isRemovingParent() ? 1 : 0);
                                if (!n14) {
                                    float f11;
                                    ViewGroup viewGroup;
                                    n14 = this.mCurState;
                                    n13 = 0;
                                    object5 = null;
                                    if (n14 > n15 && !(n15 = (int)(this.mDestroyed ? 1 : 0)) && !(n15 = (viewGroup = fragment.mView).getVisibility()) && (n15 = (int)((f11 = (f10 = fragment.mPostponedAlpha) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) >= 0) {
                                        object2 = this.mHost.getContext();
                                        n15 = 0;
                                        f10 = 0.0f;
                                        viewGroup = null;
                                        n14 = (int)(fragment.getPopDirection() ? 1 : 0);
                                        object2 = FragmentAnim.loadAnimation((Context)object2, fragment, false, n14 != 0);
                                    }
                                    fragment.mPostponedAlpha = 0.0f;
                                    viewGroup = fragment.mContainer;
                                    object3 = fragment.mView;
                                    if (object2 != null) {
                                        object5 = this.mFragmentTransitionCallback;
                                        FragmentAnim.animateRemoveFragment(fragment, (FragmentAnim$AnimationOrAnimator)object2, (FragmentTransition$Callback)object5);
                                    }
                                    viewGroup.removeView(object3);
                                    n17 = (int)(FragmentManager.isLoggingEnabled(n16) ? 1 : 0);
                                    if (n17) {
                                        object2 = new StringBuilder();
                                        ((StringBuilder)object2).append("Removing view ");
                                        ((StringBuilder)object2).append(object3);
                                        ((StringBuilder)object2).append(" for fragment ");
                                        ((StringBuilder)object2).append(fragment);
                                        object4 = " from container ";
                                        ((StringBuilder)object2).append((String)object4);
                                        ((StringBuilder)object2).append(viewGroup);
                                        object2 = ((StringBuilder)object2).toString();
                                        Log.v((String)string2, (String)object2);
                                    }
                                    if (viewGroup != (object2 = fragment.mContainer)) {
                                        return;
                                    }
                                }
                            }
                            if ((object2 = this.mExitAnimationCancellationSignals.get(fragment)) == null) {
                                ((FragmentStateManager)object).destroyFragmentView();
                            }
                        }
                    }
                    if (n10 >= n12) break block38;
                    object2 = this.mExitAnimationCancellationSignals.get(fragment);
                    if (object2 != null) break block43;
                    ((FragmentStateManager)object).destroy();
                }
                n12 = n10;
            }
            if (n12 < 0) {
                ((FragmentStateManager)object).detach();
            }
            n10 = n12;
        }
        int n19 = fragment.mState;
        if (n19 != n10) {
            n19 = (int)(FragmentManager.isLoggingEnabled(n11) ? 1 : 0);
            if (n19 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("moveToState: Fragment state for ");
                ((StringBuilder)object).append(fragment);
                ((StringBuilder)object).append(" not updated inline; expected state ");
                ((StringBuilder)object).append(n10);
                string3 = " found ";
                ((StringBuilder)object).append(string3);
                n12 = fragment.mState;
                ((StringBuilder)object).append(n12);
                object = ((StringBuilder)object).toString();
                Log.d((String)string2, (String)object);
            }
            fragment.mState = n10;
        }
    }

    public void noteStateNotSaved() {
        boolean bl2;
        Object object = this.mHost;
        if (object == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        Object object2 = this.mNonConfig;
        ((FragmentManagerViewModel)object2).setIsStateSaved(false);
        object = this.mFragmentStore.getFragments().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Fragment)object.next();
            if (object2 == null) continue;
            ((Fragment)object2).noteStateNotSaved();
        }
    }

    public void onContainerAvailable(FragmentContainerView fragmentContainerView) {
        boolean bl2;
        Iterator iterator2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (bl2 = iterator2.hasNext()) {
            View view;
            FragmentStateManager fragmentStateManager = (FragmentStateManager)iterator2.next();
            Fragment fragment = fragmentStateManager.getFragment();
            int n10 = fragment.mContainerId;
            int n11 = fragmentContainerView.getId();
            if (n10 != n11 || (view = fragment.mView) == null || (view = view.getParent()) != null) continue;
            fragment.mContainer = fragmentContainerView;
            fragmentStateManager.addViewToContainer();
        }
    }

    public FragmentTransaction openTransaction() {
        return this.beginTransaction();
    }

    public void performPendingDeferredStart(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        boolean bl2 = fragment.mDeferStart;
        if (bl2) {
            bl2 = this.mExecutingActions;
            if (bl2) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            bl2 = USE_STATE_MANAGER;
            if (bl2) {
                fragmentStateManager.moveToExpectedState();
            } else {
                this.moveToState(fragment);
            }
        }
    }

    public void popBackStack() {
        FragmentManager$PopBackStackState fragmentManager$PopBackStackState = new FragmentManager$PopBackStackState(this, null, -1, 0);
        this.enqueueAction(fragmentManager$PopBackStackState, false);
    }

    public void popBackStack(int n10, int n11) {
        if (n10 >= 0) {
            FragmentManager$PopBackStackState fragmentManager$PopBackStackState = new FragmentManager$PopBackStackState(this, null, n10, n11);
            this.enqueueAction(fragmentManager$PopBackStackState, false);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void popBackStack(String string2, int n10) {
        FragmentManager$PopBackStackState fragmentManager$PopBackStackState = new FragmentManager$PopBackStackState(this, string2, -1, n10);
        this.enqueueAction(fragmentManager$PopBackStackState, false);
    }

    public boolean popBackStackImmediate() {
        return this.popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int n10, int n11) {
        if (n10 >= 0) {
            return this.popBackStackImmediate(null, n10, n11);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public boolean popBackStackImmediate(String string2, int n10) {
        return this.popBackStackImmediate(string2, -1, n10);
    }

    public boolean popBackStackState(ArrayList arrayList, ArrayList arrayList2, String string2, int n10, int n11) {
        int n12;
        Boolean bl2 = Boolean.TRUE;
        ArrayList arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        int n13 = 1;
        if (string2 == null && n10 < 0 && (n12 = n11 & 1) == 0) {
            int n14 = arrayList3.size() - n13;
            if (n14 < 0) {
                return false;
            }
            ArrayList arrayList4 = this.mBackStack;
            string2 = arrayList4.remove(n14);
            arrayList.add(string2);
            arrayList2.add(bl2);
        } else {
            BackStackRecord backStackRecord;
            int n15;
            if (string2 == null && n10 < 0) {
                n15 = -1;
            } else {
                Object object;
                int n16;
                for (n16 = arrayList3.size() - n13; n16 >= 0; n16 += -1) {
                    String string3;
                    boolean bl3;
                    object = (BackStackRecord)this.mBackStack.get(n16);
                    if (string2 != null && (bl3 = string2.equals(string3 = ((BackStackRecord)object).getName())) || n10 >= 0 && n10 == (n12 = ((BackStackRecord)object).mIndex)) break;
                }
                if (n16 < 0) {
                    return false;
                }
                if ((n11 &= n13) != 0) {
                    while ((n16 += -1) >= 0) {
                        backStackRecord = (BackStackRecord)this.mBackStack.get(n16);
                        if (string2 != null && (n12 = (int)(string2.equals(object = backStackRecord.getName()) ? 1 : 0)) != 0 || n10 >= 0 && n10 == (n11 = backStackRecord.mIndex)) continue;
                    }
                }
                n15 = n16;
            }
            ArrayList arrayList5 = this.mBackStack;
            n10 = arrayList5.size() - n13;
            if (n15 == n10) {
                return false;
            }
            arrayList5 = this.mBackStack;
            for (n10 = arrayList5.size() - n13; n10 > n15; n10 += -1) {
                backStackRecord = this.mBackStack.remove(n10);
                arrayList.add(backStackRecord);
                arrayList2.add(bl2);
            }
        }
        return n13 != 0;
    }

    public void putFragment(Bundle bundle, String string2, Fragment object) {
        Object object2 = ((Fragment)object).mFragmentManager;
        if (object2 != this) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Fragment ");
            charSequence.append(object);
            String string3 = " is not currently in the FragmentManager";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object2 = new IllegalStateException((String)charSequence);
            this.throwException((RuntimeException)object2);
        }
        object = ((Fragment)object).mWho;
        bundle.putString(string2, (String)object);
    }

    public void registerFragmentLifecycleCallbacks(FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks, boolean bl2) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentManager$FragmentLifecycleCallbacks, bl2);
    }

    public void removeCancellationSignal(Fragment fragment, CancellationSignal object) {
        int n10;
        HashSet hashSet = (HashSet)this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null && (n10 = hashSet.remove(object)) != 0 && (n10 = hashSet.isEmpty()) != 0) {
            object = this.mExitAnimationCancellationSignals;
            object.remove(fragment);
            n10 = fragment.mState;
            int n11 = 5;
            if (n10 < n11) {
                this.destroyFragmentView(fragment);
                this.moveToState(fragment);
            }
        }
    }

    public void removeFragment(Fragment fragment) {
        int n10;
        Object object;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("remove: ");
            ((StringBuilder)object).append(fragment);
            ((StringBuilder)object).append(" nesting=");
            n10 = fragment.mBackStackNesting;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            String string2 = TAG;
            Log.v((String)string2, (String)object);
        }
        bl2 = fragment.isInBackStack();
        n10 = 1;
        boolean bl3 = fragment.mDetached;
        if (!bl3 || (bl2 ^= n10)) {
            object = this.mFragmentStore;
            ((FragmentStore)object).removeFragment(fragment);
            bl2 = this.isMenuAvailable(fragment);
            if (bl2) {
                this.mNeedMenuInvalidate = n10;
            }
            fragment.mRemoving = n10;
            this.setVisibleRemovingFragment(fragment);
        }
    }

    public void removeFragmentOnAttachListener(FragmentOnAttachListener fragmentOnAttachListener) {
        this.mOnAttachListeners.remove(fragmentOnAttachListener);
    }

    public void removeOnBackStackChangedListener(FragmentManager$OnBackStackChangedListener fragmentManager$OnBackStackChangedListener) {
        ArrayList arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(fragmentManager$OnBackStackChangedListener);
        }
    }

    public void removeRetainedFragment(Fragment fragment) {
        this.mNonConfig.removeRetainedFragment(fragment);
    }

    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        Object object = this.mHost;
        boolean bl2 = object instanceof ViewModelStoreOwner;
        if (bl2) {
            String string2 = "You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner";
            object = new IllegalStateException(string2);
            this.throwException((RuntimeException)object);
        }
        this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
        this.restoreSaveState(parcelable);
    }

    public void restoreSaveState(Parcelable object) {
        int n10;
        int n11;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        String string2;
        int n13;
        String string3;
        int n14;
        if (object == null) {
            return;
        }
        object = (FragmentManagerState)object;
        Object object7 = ((FragmentManagerState)object).mActive;
        if (object7 == null) {
            return;
        }
        this.mFragmentStore.resetActiveFragments();
        object7 = ((FragmentManagerState)object).mActive.iterator();
        while (true) {
            n14 = object7.hasNext();
            string3 = "): ";
            n13 = 2;
            string2 = TAG;
            if (n14 == 0) break;
            object6 = object7.next();
            Object object8 = object6;
            object8 = (FragmentState)object6;
            if (object8 == null) continue;
            object6 = this.mNonConfig;
            object5 = ((FragmentState)object8).mWho;
            if ((object6 = ((FragmentManagerViewModel)object6).findRetainedFragmentByWho((String)object5)) != null) {
                boolean n12 = FragmentManager.isLoggingEnabled(n13);
                if (n12) {
                    object5 = new StringBuilder();
                    object4 = "restoreSaveState: re-attaching retained ";
                    ((StringBuilder)object5).append((String)object4);
                    ((StringBuilder)object5).append(object6);
                    object5 = ((StringBuilder)object5).toString();
                    Log.v((String)string2, (String)object5);
                }
                object4 = this.mLifecycleCallbacksDispatcher;
                object3 = this.mFragmentStore;
                object5 = new FragmentStateManager((FragmentLifecycleCallbacksDispatcher)object4, (FragmentStore)object3, (Fragment)object6, (FragmentState)object8);
            } else {
                object4 = this.mLifecycleCallbacksDispatcher;
                object3 = this.mFragmentStore;
                ClassLoader classLoader = this.mHost.getContext().getClassLoader();
                FragmentFactory fragmentFactory = this.getFragmentFactory();
                object5 = object6;
                object6 = new FragmentStateManager((FragmentLifecycleCallbacksDispatcher)object4, (FragmentStore)object3, classLoader, fragmentFactory, (FragmentState)object8);
            }
            object6 = ((FragmentStateManager)object5).getFragment();
            ((Fragment)object6).mFragmentManager = this;
            n13 = (int)(FragmentManager.isLoggingEnabled(n13) ? 1 : 0);
            if (n13 != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("restoreSaveState: active (");
                object4 = ((Fragment)object6).mWho;
                ((StringBuilder)object2).append((String)object4);
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(object6);
                object6 = ((StringBuilder)object2).toString();
                Log.v((String)string2, (String)object6);
            }
            object6 = this.mHost.getContext().getClassLoader();
            ((FragmentStateManager)object5).restoreState((ClassLoader)object6);
            object6 = this.mFragmentStore;
            ((FragmentStore)object6).makeActive((FragmentStateManager)object5);
            n14 = this.mCurState;
            ((FragmentStateManager)object5).setFragmentManagerState(n14);
        }
        object7 = this.mNonConfig.getRetainedFragments().iterator();
        while ((n14 = object7.hasNext()) != 0) {
            object6 = (Fragment)object7.next();
            object5 = this.mFragmentStore;
            object4 = ((Fragment)object6).mWho;
            boolean bl2 = ((FragmentStore)object5).containsActiveFragment((String)object4);
            if (bl2) continue;
            bl2 = FragmentManager.isLoggingEnabled(n13);
            if (bl2) {
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("Discarding retained Fragment ");
                ((StringBuilder)object5).append(object6);
                ((StringBuilder)object5).append(" that was not found in the set of active Fragments ");
                object4 = ((FragmentManagerState)object).mActive;
                ((StringBuilder)object5).append(object4);
                object5 = ((StringBuilder)object5).toString();
                Log.v((String)string2, (String)object5);
            }
            this.mNonConfig.removeRetainedFragment((Fragment)object6);
            ((Fragment)object6).mFragmentManager = this;
            object4 = this.mLifecycleCallbacksDispatcher;
            object3 = this.mFragmentStore;
            object5 = new FragmentStateManager((FragmentLifecycleCallbacksDispatcher)object4, (FragmentStore)object3, (Fragment)object6);
            n11 = 1;
            ((FragmentStateManager)object5).setFragmentManagerState(n11);
            ((FragmentStateManager)object5).moveToExpectedState();
            ((Fragment)object6).mRemoving = n11;
            ((FragmentStateManager)object5).moveToExpectedState();
        }
        object7 = this.mFragmentStore;
        object6 = ((FragmentManagerState)object).mAdded;
        ((FragmentStore)object7).restoreAddedFragments((List)object6);
        object7 = ((FragmentManagerState)object).mBackStack;
        n14 = 0;
        object6 = null;
        if (object7 != null) {
            object5 = ((FragmentManagerState)object).mBackStack;
            int n12 = ((BackStackState[])object5).length;
            this.mBackStack = object7 = new ArrayList(n12);
            object7 = null;
            for (n10 = 0; n10 < (n11 = ((Object)(object5 = ((FragmentManagerState)object).mBackStack)).length); ++n10) {
                object5 = ((BackStackState)object5[n10]).instantiate(this);
                n11 = (int)(FragmentManager.isLoggingEnabled(n13) ? 1 : 0);
                if (n11 != 0) {
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("restoreAllState: back stack #");
                    ((StringBuilder)object4).append(n10);
                    ((StringBuilder)object4).append(" (index ");
                    int n15 = ((BackStackRecord)object5).mIndex;
                    ((StringBuilder)object4).append(n15);
                    ((StringBuilder)object4).append(string3);
                    ((StringBuilder)object4).append(object5);
                    object4 = ((StringBuilder)object4).toString();
                    Log.v((String)string2, (String)object4);
                    object4 = new LogWriter(string2);
                    object3 = new PrintWriter((Writer)object4);
                    object4 = "  ";
                    ((BackStackRecord)object5).dump((String)object4, (PrintWriter)object3, false);
                    ((PrintWriter)object3).close();
                }
                object4 = this.mBackStack;
                ((ArrayList)object4).add(object5);
            }
        } else {
            n10 = 0;
            object7 = null;
            this.mBackStack = null;
        }
        object7 = this.mBackStackIndex;
        int n16 = ((FragmentManagerState)object).mBackStackIndex;
        ((AtomicInteger)object7).set(n16);
        object7 = ((FragmentManagerState)object).mPrimaryNavActiveWho;
        if (object7 != null) {
            this.mPrimaryNav = object7 = this.findActiveFragment((String)object7);
            this.dispatchParentPrimaryNavigationFragmentChanged((Fragment)object7);
        }
        if ((object7 = ((FragmentManagerState)object).mResultKeys) != null) {
            while (n14 < (n16 = ((ArrayList)object7).size())) {
                string3 = (Bundle)((FragmentManagerState)object).mResults.get(n14);
                object2 = this.mHost.getContext().getClassLoader();
                string3.setClassLoader((ClassLoader)object2);
                object2 = this.mResults;
                string2 = ((ArrayList)object7).get(n14);
                object2.put(string2, string3);
                ++n14;
            }
        }
        object = ((FragmentManagerState)object).mLaunchedFragments;
        this.mLaunchedFragments = object7 = new ArrayDeque(object);
    }

    public FragmentManagerNonConfig retainNonConfig() {
        Object object = this.mHost;
        boolean bl2 = object instanceof ViewModelStoreOwner;
        if (bl2) {
            String string2 = "You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner.";
            object = new IllegalStateException(string2);
            this.throwException((RuntimeException)object);
        }
        return this.mNonConfig.getSnapshot();
    }

    public Parcelable saveAllState() {
        int n10;
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        int n11 = 1;
        this.execPendingActions(n11 != 0);
        this.mStateSaved = n11;
        Collection<Object> collection = this.mNonConfig;
        ((FragmentManagerViewModel)((Object)collection)).setIsStateSaved(n11 != 0);
        Object object = this.mFragmentStore.saveActiveFragments();
        boolean bl2 = ((ArrayList)object).isEmpty();
        Object object2 = TAG;
        int n12 = 2;
        BackStackState[] backStackStateArray = null;
        if (bl2) {
            n11 = FragmentManager.isLoggingEnabled(n12);
            if (n11 != 0) {
                object = "saveAllState: no fragments!";
                Log.v((String)object2, (String)object);
            }
            return null;
        }
        collection = this.mFragmentStore.saveAddedFragments();
        ArrayList arrayList = this.mBackStack;
        if (arrayList != null && (n10 = arrayList.size()) > 0) {
            backStackStateArray = new BackStackState[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                BackStackRecord backStackRecord = (BackStackRecord)this.mBackStack.get(i10);
                Object object3 = new BackStackState(backStackRecord);
                backStackStateArray[i10] = object3;
                boolean bl3 = FragmentManager.isLoggingEnabled(n12);
                if (!bl3) continue;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("saveAllState: adding back stack #");
                ((StringBuilder)object3).append(i10);
                ((StringBuilder)object3).append(": ");
                backStackRecord = this.mBackStack.get(i10);
                ((StringBuilder)object3).append(backStackRecord);
                object3 = ((StringBuilder)object3).toString();
                Log.v((String)object2, (String)object3);
            }
        }
        object2 = new FragmentManagerState();
        ((FragmentManagerState)object2).mActive = object;
        ((FragmentManagerState)object2).mAdded = collection;
        ((FragmentManagerState)object2).mBackStack = backStackStateArray;
        ((FragmentManagerState)object2).mBackStackIndex = n11 = this.mBackStackIndex.get();
        object = this.mPrimaryNav;
        if (object != null) {
            object = ((Fragment)object).mWho;
            ((FragmentManagerState)object2).mPrimaryNavActiveWho = object;
        }
        object = ((FragmentManagerState)object2).mResultKeys;
        collection = this.mResults.keySet();
        ((ArrayList)object).addAll(collection);
        object = ((FragmentManagerState)object2).mResults;
        collection = this.mResults.values();
        ((ArrayList)object).addAll(collection);
        collection = this.mLaunchedFragments;
        ((FragmentManagerState)object2).mLaunchedFragments = object = new Object(collection);
        return object2;
    }

    public Fragment$SavedState saveFragmentInstanceState(Fragment object) {
        boolean bl2;
        Object object2 = this.mFragmentStore;
        Object object3 = ((Fragment)object).mWho;
        if ((object2 = ((FragmentStore)object2).getFragmentStateManager((String)object3)) == null || !(bl2 = ((Fragment)(object3 = ((FragmentStateManager)object2).getFragment())).equals(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Fragment ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append(" is not currently in the FragmentManager");
            object = stringBuilder.toString();
            object3 = new IllegalStateException((String)object);
            this.throwException((RuntimeException)object3);
        }
        return ((FragmentStateManager)object2).saveInstanceState();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void scheduleCommit() {
        ArrayList arrayList = this.mPendingActions;
        synchronized (arrayList) {
            int n10;
            Object object = this.mPostponedTransactions;
            int n11 = 0;
            Runnable runnable = null;
            int n12 = 1;
            if (object != null && (n10 = ((ArrayList)object).isEmpty()) == 0) {
                n10 = n12;
            } else {
                n10 = 0;
                object = null;
            }
            ArrayList arrayList2 = this.mPendingActions;
            int n13 = arrayList2.size();
            if (n13 == n12) {
                n11 = n12;
            }
            if (n10 != 0 || n11 != 0) {
                object = this.mHost;
                object = ((FragmentHostCallback)object).getHandler();
                runnable = this.mExecCommit;
                object.removeCallbacks(runnable);
                object = this.mHost;
                object = ((FragmentHostCallback)object).getHandler();
                runnable = this.mExecCommit;
                object.post(runnable);
                this.updateOnBackPressedCallbackEnabled();
            }
            return;
        }
    }

    public void setExitAnimationOrder(Fragment object, boolean bl2) {
        boolean bl3;
        if ((object = this.getFragmentContainer((Fragment)object)) != null && (bl3 = object instanceof FragmentContainerView)) {
            object = (FragmentContainerView)((Object)object);
            ((FragmentContainerView)((Object)object)).setDrawDisappearingViewsLast(bl2 ^= true);
        }
    }

    public void setFragmentFactory(FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    public final void setFragmentResult(String string2, Bundle bundle) {
        Lifecycle$State lifecycle$State;
        boolean bl2;
        Object object = (FragmentManager$LifecycleAwareResultListener)this.mResultListeners.get(string2);
        if (object != null && (bl2 = ((FragmentManager$LifecycleAwareResultListener)object).isAtLeast(lifecycle$State = Lifecycle$State.STARTED))) {
            ((FragmentManager$LifecycleAwareResultListener)object).onFragmentResult(string2, bundle);
        } else {
            object = this.mResults;
            object.put(string2, bundle);
        }
    }

    public final void setFragmentResultListener(String object, LifecycleOwner object2, FragmentResultListener fragmentResultListener) {
        Object object3;
        Object object4 = ((Lifecycle)(object2 = object2.getLifecycle())).getCurrentState();
        if (object4 == (object3 = Lifecycle$State.DESTROYED)) {
            return;
        }
        object4 = new FragmentManager$6(this, (String)object, fragmentResultListener, (Lifecycle)object2);
        ((Lifecycle)object2).addObserver((LifecycleObserver)object4);
        object3 = this.mResultListeners;
        FragmentManager$LifecycleAwareResultListener fragmentManager$LifecycleAwareResultListener = new FragmentManager$LifecycleAwareResultListener((Lifecycle)object2, fragmentResultListener, (LifecycleEventObserver)object4);
        object = object3.put(object, fragmentManager$LifecycleAwareResultListener);
        if (object != null) {
            ((FragmentManager$LifecycleAwareResultListener)object).removeObserver();
        }
    }

    public void setMaxLifecycle(Fragment object, Lifecycle$State object2) {
        Object object3 = ((Fragment)object).mWho;
        boolean bl2 = ((Fragment)object).equals(object3 = this.findActiveFragment((String)object3));
        if (bl2 && ((object3 = ((Fragment)object).mHost) == null || (object3 = ((Fragment)object).mFragmentManager) == this)) {
            ((Fragment)object).mMaxState = object2;
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Fragment ");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(" is not an active fragment of FragmentManager ");
        ((StringBuilder)object3).append(this);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void setPrimaryNavigationFragment(Fragment object) {
        Object object2;
        if (object != null) {
            object2 = ((Fragment)object).mWho;
            boolean bl2 = ((Fragment)object).equals(object2 = this.findActiveFragment((String)object2));
            if (!bl2 || (object2 = ((Fragment)object).mHost) != null && (object2 = ((Fragment)object).mFragmentManager) != this) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment ");
                stringBuilder.append(object);
                stringBuilder.append(" is not an active fragment of FragmentManager ");
                stringBuilder.append(this);
                object = stringBuilder.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
        }
        object2 = this.mPrimaryNav;
        this.mPrimaryNav = object;
        this.dispatchParentPrimaryNavigationFragmentChanged((Fragment)object2);
        object = this.mPrimaryNav;
        this.dispatchParentPrimaryNavigationFragmentChanged((Fragment)object);
    }

    public void setSpecialEffectsControllerFactory(SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        this.mSpecialEffectsControllerFactory = specialEffectsControllerFactory;
    }

    public void showFragment(Fragment fragment) {
        CharSequence charSequence;
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            charSequence = new StringBuilder();
            charSequence.append("show: ");
            charSequence.append(fragment);
            charSequence = charSequence.toString();
            String string2 = TAG;
            Log.v((String)string2, (String)charSequence);
        }
        if (bl2 = fragment.mHidden) {
            charSequence = null;
            fragment.mHidden = false;
            fragment.mHiddenChanged = bl2 = fragment.mHiddenChanged ^ true;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        int n10 = System.identityHashCode(this);
        Object object = Integer.toHexString(n10);
        stringBuilder.append((String)object);
        stringBuilder.append(" in ");
        object = this.mParent;
        String string2 = "}";
        String string3 = "{";
        if (object != null) {
            object = object.getClass().getSimpleName();
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            n10 = System.identityHashCode(this.mParent);
            object = Integer.toHexString(n10);
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        } else {
            object = this.mHost;
            if (object != null) {
                object = object.getClass().getSimpleName();
                stringBuilder.append((String)object);
                stringBuilder.append(string3);
                n10 = System.identityHashCode(this.mHost);
                object = Integer.toHexString(n10);
                stringBuilder.append((String)object);
                stringBuilder.append(string2);
            } else {
                object = "null";
                stringBuilder.append((String)object);
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentManager$FragmentLifecycleCallbacks fragmentManager$FragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentManager$FragmentLifecycleCallbacks);
    }
}

