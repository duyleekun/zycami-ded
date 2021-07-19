/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.app.Activity
 *  android.app.Application
 *  android.content.ComponentCallbacks
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnCreateContextMenuListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.Fragment$1;
import androidx.fragment.app.Fragment$2;
import androidx.fragment.app.Fragment$3;
import androidx.fragment.app.Fragment$4;
import androidx.fragment.app.Fragment$5;
import androidx.fragment.app.Fragment$6;
import androidx.fragment.app.Fragment$7;
import androidx.fragment.app.Fragment$8;
import androidx.fragment.app.Fragment$9;
import androidx.fragment.app.Fragment$AnimationInfo;
import androidx.fragment.app.Fragment$InstantiationException;
import androidx.fragment.app.Fragment$OnPreAttachedListener;
import androidx.fragment.app.Fragment$OnStartEnterTransitionListener;
import androidx.fragment.app.Fragment$SavedState;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.FragmentViewLifecycleOwner;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SuperNotCalledException;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment
implements ComponentCallbacks,
View.OnCreateContextMenuListener,
LifecycleOwner,
ViewModelStoreOwner,
HasDefaultViewModelProviderFactory,
SavedStateRegistryOwner,
ActivityResultCaller {
    public static final int ACTIVITY_CREATED = 4;
    public static final int ATTACHED = 0;
    public static final int AWAITING_ENTER_EFFECTS = 6;
    public static final int AWAITING_EXIT_EFFECTS = 3;
    public static final int CREATED = 1;
    public static final int INITIALIZING = 255;
    public static final int RESUMED = 7;
    public static final int STARTED = 5;
    public static final Object USE_DEFAULT_TRANSITION;
    public static final int VIEW_CREATED = 2;
    public boolean mAdded;
    public Fragment$AnimationInfo mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    private boolean mCalled;
    public FragmentManager mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    private int mContentLayoutId;
    public ViewModelProvider$Factory mDefaultFactory;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public FragmentManager mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public FragmentHostCallback mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    public LayoutInflater mLayoutInflater;
    public LifecycleRegistry mLifecycleRegistry;
    public Lifecycle$State mMaxState;
    public boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList mOnPreAttachedListeners;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public SavedStateRegistryController mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public Bundle mSavedViewRegistryState;
    public SparseArray mSavedViewState;
    public int mState = -1;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public FragmentViewLifecycleOwner mViewLifecycleOwner;
    public MutableLiveData mViewLifecycleOwnerLiveData;
    public String mWho;

    static {
        Object object;
        USE_DEFAULT_TRANSITION = object = new Object();
    }

    public Fragment() {
        boolean bl2;
        Object object = UUID.randomUUID().toString();
        this.mWho = object;
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = object = new FragmentManagerImpl();
        this.mMenuVisible = bl2 = true;
        this.mUserVisibleHint = bl2;
        this.mPostponedDurationRunnable = object = new Fragment$1(this);
        object = Lifecycle$State.RESUMED;
        this.mMaxState = object;
        object = new MutableLiveData();
        this.mViewLifecycleOwnerLiveData = object;
        object = new AtomicInteger();
        this.mNextLocalRequestCode = object;
        object = new ArrayList();
        this.mOnPreAttachedListeners = object;
        this.initLifecycle();
    }

    public Fragment(int n10) {
        this();
        this.mContentLayoutId = n10;
    }

    private Fragment$AnimationInfo ensureAnimationInfo() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            this.mAnimationInfo = fragment$AnimationInfo = new Fragment$AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle$State lifecycle$State = this.mMaxState;
        Object object = Lifecycle$State.INITIALIZED;
        if (lifecycle$State != object && (object = this.mParentFragment) != null) {
            int n10 = lifecycle$State.ordinal();
            int n11 = this.mParentFragment.getMinimumMaxLifecycleState();
            return Math.min(n10, n11);
        }
        return lifecycle$State.ordinal();
    }

    private void initLifecycle() {
        Object object = new LifecycleRegistry(this);
        this.mLifecycleRegistry = object;
        this.mSavedStateRegistryController = object = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
    }

    public static Fragment instantiate(Context context, String string2) {
        return Fragment.instantiate(context, string2, null);
    }

    public static Fragment instantiate(Context object, String string2, Bundle object2) {
        block15: {
            CharSequence charSequence = ": make sure class name exists, is public, and has an empty constructor that is public";
            String string3 = "Unable to instantiate fragment ";
            object = object.getClassLoader();
            object = FragmentFactory.loadFragmentClass((ClassLoader)object, string2);
            Object object3 = null;
            Class[] classArray = new Class[]{};
            object = ((Class)object).getConstructor(classArray);
            object3 = new Object[]{};
            object = ((Constructor)object).newInstance((Object[])object3);
            object = (Fragment)object;
            if (object2 == null) break block15;
            object3 = object.getClass();
            object3 = ((Class)object3).getClassLoader();
            object2.setClassLoader((ClassLoader)object3);
            try {
                ((Fragment)object).setArguments((Bundle)object2);
            }
            catch (InvocationTargetException invocationTargetException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(": calling Fragment constructor caused an exception");
                string2 = ((StringBuilder)charSequence).toString();
                object2 = new Fragment$InstantiationException(string2, invocationTargetException);
                throw object2;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(": could not find Fragment constructor");
                string2 = ((StringBuilder)charSequence).toString();
                object2 = new Fragment$InstantiationException(string2, noSuchMethodException);
                throw object2;
            }
            catch (IllegalAccessException illegalAccessException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)charSequence);
                string2 = ((StringBuilder)object3).toString();
                object2 = new Fragment$InstantiationException(string2, illegalAccessException);
                throw object2;
            }
            catch (InstantiationException instantiationException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)charSequence);
                string2 = ((StringBuilder)object3).toString();
                object2 = new Fragment$InstantiationException(string2, instantiationException);
                throw object2;
            }
        }
        return object;
    }

    private ActivityResultLauncher prepareCallInternal(ActivityResultContract object, Function object2, ActivityResultCallback activityResultCallback) {
        int n10 = this.mState;
        int n11 = 1;
        if (n10 <= n11) {
            AtomicReference atomicReference = new AtomicReference();
            Fragment$8 fragment$8 = new Fragment$8(this, (Function)object2, atomicReference, (ActivityResultContract)object, activityResultCallback);
            this.registerOnPreAttachListener(fragment$8);
            object2 = new Fragment$9(this, atomicReference, (ActivityResultContract)object);
            return object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Fragment ");
        ((StringBuilder)object2).append(this);
        ((StringBuilder)object2).append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    private void registerOnPreAttachListener(Fragment$OnPreAttachedListener fragment$OnPreAttachedListener) {
        int n10 = this.mState;
        if (n10 >= 0) {
            fragment$OnPreAttachedListener.onPreAttached();
        } else {
            ArrayList arrayList = this.mOnPreAttachedListeners;
            arrayList.add(fragment$OnPreAttachedListener);
        }
    }

    private void restoreViewState() {
        CharSequence charSequence;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            charSequence = new StringBuilder();
            charSequence.append("moveto RESTORE_VIEW_STATE: ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            String string2 = "FragmentManager";
            Log.d((String)string2, (String)charSequence);
        }
        if ((charSequence = this.mView) != null) {
            charSequence = this.mSavedFragmentState;
            this.restoreViewState((Bundle)charSequence);
        }
        this.mSavedFragmentState = null;
    }

    public void callStartTransitionListener(boolean bl2) {
        Object object = this.mAnimationInfo;
        Object object2 = null;
        if (object != null) {
            ((Fragment$AnimationInfo)object).mEnterTransitionPostponed = false;
            Fragment$OnStartEnterTransitionListener fragment$OnStartEnterTransitionListener = ((Fragment$AnimationInfo)object).mStartEnterTransitionListener;
            ((Fragment$AnimationInfo)object).mStartEnterTransitionListener = null;
            object2 = fragment$OnStartEnterTransitionListener;
        }
        if (object2 != null) {
            object2.onStartEnterTransition();
        } else {
            boolean bl3 = FragmentManager.USE_STATE_MANAGER;
            if (bl3 && (object = this.mView) != null && (object = this.mContainer) != null && (object2 = this.mFragmentManager) != null) {
                object = SpecialEffectsController.getOrCreateController((ViewGroup)object, (FragmentManager)object2);
                ((SpecialEffectsController)object).markPostponedState();
                if (bl2) {
                    Handler handler = this.mHost.getHandler();
                    object2 = new Fragment$3(this, (SpecialEffectsController)object);
                    handler.post((Runnable)object2);
                } else {
                    ((SpecialEffectsController)object).executePendingOperations();
                }
            }
        }
    }

    public FragmentContainer createFragmentContainer() {
        Fragment$4 fragment$4 = new Fragment$4(this);
        return fragment$4;
    }

    public void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Object object;
        printWriter.print(string2);
        printWriter.print("mFragmentId=#");
        Object object2 = Integer.toHexString(this.mFragmentId);
        printWriter.print((String)object2);
        printWriter.print(" mContainerId=#");
        object2 = Integer.toHexString(this.mContainerId);
        printWriter.print((String)object2);
        printWriter.print(" mTag=");
        object2 = this.mTag;
        printWriter.println((String)object2);
        printWriter.print(string2);
        printWriter.print("mState=");
        int n10 = this.mState;
        printWriter.print(n10);
        printWriter.print(" mWho=");
        object2 = this.mWho;
        printWriter.print((String)object2);
        printWriter.print(" mBackStackNesting=");
        n10 = this.mBackStackNesting;
        printWriter.println(n10);
        printWriter.print(string2);
        printWriter.print("mAdded=");
        n10 = (int)(this.mAdded ? 1 : 0);
        printWriter.print(n10 != 0);
        printWriter.print(" mRemoving=");
        n10 = this.mRemoving;
        printWriter.print(n10 != 0);
        printWriter.print(" mFromLayout=");
        n10 = this.mFromLayout;
        printWriter.print(n10 != 0);
        printWriter.print(" mInLayout=");
        n10 = this.mInLayout;
        printWriter.println(n10 != 0);
        printWriter.print(string2);
        printWriter.print("mHidden=");
        n10 = this.mHidden;
        printWriter.print(n10 != 0);
        printWriter.print(" mDetached=");
        n10 = this.mDetached;
        printWriter.print(n10 != 0);
        printWriter.print(" mMenuVisible=");
        n10 = this.mMenuVisible;
        printWriter.print(n10 != 0);
        printWriter.print(" mHasMenu=");
        n10 = this.mHasMenu;
        printWriter.println(n10 != 0);
        printWriter.print(string2);
        printWriter.print("mRetainInstance=");
        n10 = this.mRetainInstance;
        printWriter.print(n10 != 0);
        printWriter.print(" mUserVisibleHint=");
        n10 = this.mUserVisibleHint;
        printWriter.println(n10 != 0);
        object2 = this.mFragmentManager;
        if (object2 != null) {
            printWriter.print(string2);
            printWriter.print("mFragmentManager=");
            object2 = this.mFragmentManager;
            printWriter.println(object2);
        }
        if ((object2 = this.mHost) != null) {
            printWriter.print(string2);
            printWriter.print("mHost=");
            object2 = this.mHost;
            printWriter.println(object2);
        }
        if ((object2 = this.mParentFragment) != null) {
            printWriter.print(string2);
            printWriter.print("mParentFragment=");
            object2 = this.mParentFragment;
            printWriter.println(object2);
        }
        if ((object2 = this.mArguments) != null) {
            printWriter.print(string2);
            printWriter.print("mArguments=");
            object2 = this.mArguments;
            printWriter.println(object2);
        }
        if ((object2 = this.mSavedFragmentState) != null) {
            printWriter.print(string2);
            printWriter.print("mSavedFragmentState=");
            object2 = this.mSavedFragmentState;
            printWriter.println(object2);
        }
        if ((object2 = this.mSavedViewState) != null) {
            printWriter.print(string2);
            printWriter.print("mSavedViewState=");
            object2 = this.mSavedViewState;
            printWriter.println(object2);
        }
        if ((object2 = this.mSavedViewRegistryState) != null) {
            printWriter.print(string2);
            printWriter.print("mSavedViewRegistryState=");
            object2 = this.mSavedViewRegistryState;
            printWriter.println(object2);
        }
        if ((object2 = this.getTargetFragment()) != null) {
            printWriter.print(string2);
            object = "mTarget=";
            printWriter.print((String)object);
            printWriter.print(object2);
            object2 = " mTargetRequestCode=";
            printWriter.print((String)object2);
            n10 = this.mTargetRequestCode;
            printWriter.println(n10);
        }
        printWriter.print(string2);
        object2 = "mPopDirection=";
        printWriter.print((String)object2);
        n10 = this.getPopDirection();
        printWriter.println(n10 != 0);
        n10 = this.getEnterAnim();
        if (n10 != 0) {
            printWriter.print(string2);
            object2 = "getEnterAnim=";
            printWriter.print((String)object2);
            n10 = this.getEnterAnim();
            printWriter.println(n10);
        }
        if ((n10 = this.getExitAnim()) != 0) {
            printWriter.print(string2);
            object2 = "getExitAnim=";
            printWriter.print((String)object2);
            n10 = this.getExitAnim();
            printWriter.println(n10);
        }
        if ((n10 = this.getPopEnterAnim()) != 0) {
            printWriter.print(string2);
            object2 = "getPopEnterAnim=";
            printWriter.print((String)object2);
            n10 = this.getPopEnterAnim();
            printWriter.println(n10);
        }
        if ((n10 = this.getPopExitAnim()) != 0) {
            printWriter.print(string2);
            object2 = "getPopExitAnim=";
            printWriter.print((String)object2);
            n10 = this.getPopExitAnim();
            printWriter.println(n10);
        }
        if ((object2 = this.mContainer) != null) {
            printWriter.print(string2);
            printWriter.print("mContainer=");
            object2 = this.mContainer;
            printWriter.println(object2);
        }
        if ((object2 = this.mView) != null) {
            printWriter.print(string2);
            printWriter.print("mView=");
            object2 = this.mView;
            printWriter.println(object2);
        }
        if ((object2 = this.getAnimatingAway()) != null) {
            printWriter.print(string2);
            printWriter.print("mAnimatingAway=");
            object2 = this.getAnimatingAway();
            printWriter.println(object2);
        }
        if ((object2 = this.getContext()) != null) {
            object2 = LoaderManager.getInstance(this);
            ((LoaderManager)object2).dump(string2, fileDescriptor, printWriter, stringArray);
        }
        printWriter.print(string2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Child ");
        object = this.mChildFragmentManager;
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(":");
        object2 = ((StringBuilder)object2).toString();
        printWriter.println((String)object2);
        object2 = this.mChildFragmentManager;
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("  ");
        string2 = ((StringBuilder)object).toString();
        ((FragmentManager)object2).dump(string2, fileDescriptor, printWriter, stringArray);
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    public Fragment findFragmentByWho(String string2) {
        String string3 = this.mWho;
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return this;
        }
        return this.mChildFragmentManager.findFragmentByWho(string2);
    }

    public String generateActivityResultKey() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fragment_");
        String string2 = this.mWho;
        stringBuilder.append(string2);
        stringBuilder.append("_rq#");
        int n10 = this.mNextLocalRequestCode.getAndIncrement();
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public final FragmentActivity getActivity() {
        Object object = this.mHost;
        object = object == null ? null : (FragmentActivity)((FragmentHostCallback)object).getActivity();
        return object;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Object object = this.mAnimationInfo;
        boolean bl2 = object != null && (object = ((Fragment$AnimationInfo)object).mAllowEnterTransitionOverlap) != null ? (Boolean)object : true;
        return bl2;
    }

    public boolean getAllowReturnTransitionOverlap() {
        Object object = this.mAnimationInfo;
        boolean bl2 = object != null && (object = ((Fragment$AnimationInfo)object).mAllowReturnTransitionOverlap) != null ? (Boolean)object : true;
        return bl2;
    }

    public View getAnimatingAway() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mAnimatingAway;
    }

    public Animator getAnimator() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mAnimator;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        Object object = this.mHost;
        if (object != null) {
            return this.mChildFragmentManager;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" has not been attached yet.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public Context getContext() {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        fragmentHostCallback = fragmentHostCallback == null ? null : fragmentHostCallback.getContext();
        return fragmentHostCallback;
    }

    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        Object object = this.mFragmentManager;
        if (object != null) {
            object = this.mDefaultFactory;
            if (object == null) {
                Object object2;
                boolean bl2;
                boolean bl3;
                object = null;
                Object object3 = this.requireContext().getApplicationContext();
                while (bl3 = object3 instanceof ContextWrapper) {
                    bl3 = object3 instanceof Application;
                    if (bl3) {
                        object = object3;
                        object = (Application)object3;
                        break;
                    }
                    object3 = ((ContextWrapper)object3).getBaseContext();
                }
                if (object == null && (bl2 = FragmentManager.isLoggingEnabled(3))) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Could not find Application instance from Context ");
                    object2 = this.requireContext().getApplicationContext();
                    ((StringBuilder)object3).append(object2);
                    ((StringBuilder)object3).append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    object3 = ((StringBuilder)object3).toString();
                    object2 = "FragmentManager";
                    Log.d((String)object2, (String)object3);
                }
                object2 = this.getArguments();
                this.mDefaultFactory = object3 = new SavedStateViewModelFactory((Application)object, this, (Bundle)object2);
            }
            return this.mDefaultFactory;
        }
        object = new IllegalStateException("Can't access ViewModels from detached fragment");
        throw object;
    }

    public int getEnterAnim() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return 0;
        }
        return fragment$AnimationInfo.mEnterAnim;
    }

    public Object getEnterTransition() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mEnterTransition;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mEnterTransitionCallback;
    }

    public int getExitAnim() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return 0;
        }
        return fragment$AnimationInfo.mExitAnim;
    }

    public Object getExitTransition() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mExitTransition;
    }

    public SharedElementCallback getExitTransitionCallback() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mExitTransitionCallback;
    }

    public View getFocusedView() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mFocusedView;
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        Object object = this.mHost;
        object = object == null ? null : ((FragmentHostCallback)object).onGetHost();
        return object;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        if (layoutInflater == null) {
            layoutInflater = this.performGetLayoutInflater(null);
        }
        return layoutInflater;
    }

    public LayoutInflater getLayoutInflater(Bundle object) {
        object = this.mHost;
        if (object != null) {
            object = ((FragmentHostCallback)object).onGetLayoutInflater();
            LayoutInflater.Factory2 factory2 = this.mChildFragmentManager.getLayoutInflaterFactory();
            LayoutInflaterCompat.setFactory2((LayoutInflater)object, factory2);
            return object;
        }
        object = new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        throw object;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public int getNextTransition() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return 0;
        }
        return fragment$AnimationInfo.mNextTransition;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        Object object = this.mFragmentManager;
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" not associated with a fragment manager.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public boolean getPopDirection() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return false;
        }
        return fragment$AnimationInfo.mIsPop;
    }

    public int getPopEnterAnim() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return 0;
        }
        return fragment$AnimationInfo.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return 0;
        }
        return fragment$AnimationInfo.mPopExitAnim;
    }

    public float getPostOnViewCreatedAlpha() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return 1.0f;
        }
        return fragment$AnimationInfo.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        Object object = this.mAnimationInfo;
        if (object == null) {
            return null;
        }
        object = ((Fragment$AnimationInfo)object).mReenterTransition;
        Object object2 = USE_DEFAULT_TRANSITION;
        if (object == object2) {
            object = this.getExitTransition();
        }
        return object;
    }

    public final Resources getResources() {
        return this.requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        Object object = this.mAnimationInfo;
        if (object == null) {
            return null;
        }
        object = ((Fragment$AnimationInfo)object).mReturnTransition;
        Object object2 = USE_DEFAULT_TRANSITION;
        if (object == object2) {
            object = this.getEnterTransition();
        }
        return object;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return null;
        }
        return fragment$AnimationInfo.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        Object object = this.mAnimationInfo;
        if (object == null) {
            return null;
        }
        object = ((Fragment$AnimationInfo)object).mSharedElementReturnTransition;
        Object object2 = USE_DEFAULT_TRANSITION;
        if (object == object2) {
            object = this.getSharedElementEnterTransition();
        }
        return object;
    }

    public ArrayList getSharedElementSourceNames() {
        Object object = this.mAnimationInfo;
        if (object != null && (object = ((Fragment$AnimationInfo)object).mSharedElementSourceNames) != null) {
            return object;
        }
        object = new Object();
        return object;
    }

    public ArrayList getSharedElementTargetNames() {
        Object object = this.mAnimationInfo;
        if (object != null && (object = ((Fragment$AnimationInfo)object).mSharedElementTargetNames) != null) {
            return object;
        }
        object = new Object();
        return object;
    }

    public final String getString(int n10) {
        return this.getResources().getString(n10);
    }

    public final String getString(int n10, Object ... objectArray) {
        return this.getResources().getString(n10, objectArray);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        String string2;
        Object object = this.mTarget;
        if (object != null) {
            return object;
        }
        object = this.mFragmentManager;
        if (object != null && (string2 = this.mTargetWho) != null) {
            return ((FragmentManager)object).findActiveFragment(string2);
        }
        return null;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int n10) {
        return this.getResources().getText(n10);
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        Object object = this.mViewLifecycleOwner;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
        throw object;
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    public ViewModelStore getViewModelStore() {
        Object object = this.mFragmentManager;
        if (object != null) {
            Lifecycle$State lifecycle$State;
            int n10;
            int n11 = this.getMinimumMaxLifecycleState();
            if (n11 != (n10 = (lifecycle$State = Lifecycle$State.INITIALIZED).ordinal())) {
                return this.mFragmentManager.getViewModelStore(this);
            }
            object = new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
            throw object;
        }
        object = new IllegalStateException("Can't access ViewModels from detached fragment");
        throw object;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        String string2;
        this.initLifecycle();
        this.mWho = string2 = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        FragmentManagerImpl fragmentManagerImpl = new FragmentManagerImpl();
        this.mChildFragmentManager = fragmentManagerImpl;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        boolean bl2;
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null && (bl2 = this.mAdded)) {
            bl2 = true;
        } else {
            bl2 = false;
            fragmentHostCallback = null;
        }
        return bl2;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return false;
        }
        return fragment$AnimationInfo.mIsHideReplaced;
    }

    public final boolean isInBackStack() {
        int n10 = this.mBackStackNesting;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        Fragment fragment;
        FragmentManager fragmentManager;
        boolean bl2 = this.mMenuVisible;
        if (bl2 && ((fragmentManager = this.mFragmentManager) == null || (bl2 = fragmentManager.isParentMenuVisible(fragment = this.mParentFragment)))) {
            bl2 = true;
        } else {
            bl2 = false;
            fragmentManager = null;
        }
        return bl2;
    }

    public boolean isPostponed() {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return false;
        }
        return fragment$AnimationInfo.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        boolean bl2;
        boolean bl3;
        Fragment fragment = this.getParentFragment();
        if (fragment != null && ((bl3 = fragment.isRemoving()) || (bl2 = fragment.isRemovingParent()))) {
            bl2 = true;
        } else {
            bl2 = false;
            fragment = null;
        }
        return bl2;
    }

    public final boolean isResumed() {
        int n10 = this.mState;
        int n11 = 7;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    public final boolean isVisible() {
        View view;
        int n10 = this.isAdded();
        if (n10 != 0 && (n10 = this.isHidden()) == 0 && (view = this.mView) != null && (view = view.getWindowToken()) != null && (n10 = (view = this.mView).getVisibility()) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        return n10 != 0;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        boolean bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            String string2 = " received the following in onActivityResult(): requestCode: ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(" resultCode: ");
            stringBuilder.append(n11);
            stringBuilder.append(" data: ");
            stringBuilder.append(intent);
            String string3 = stringBuilder.toString();
            String string4 = "FragmentManager";
            Log.v((String)string4, (String)string3);
        }
    }

    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context object) {
        boolean bl2;
        this.mCalled = bl2 = true;
        object = this.mHost;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = ((FragmentHostCallback)object).getActivity();
        }
        if (object != null) {
            this.mCalled = false;
            this.onAttach((Activity)object);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle object) {
        int n10 = 1;
        this.mCalled = n10;
        this.restoreChildFragmentState((Bundle)object);
        object = this.mChildFragmentManager;
        boolean bl2 = ((FragmentManager)object).isStateAtLeast(n10);
        if (!bl2) {
            object = this.mChildFragmentManager;
            ((FragmentManager)object).dispatchCreate();
        }
    }

    public Animation onCreateAnimation(int n10, boolean bl2, int n11) {
        return null;
    }

    public Animator onCreateAnimator(int n10, boolean bl2, int n11) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int n10 = this.mContentLayoutId;
        if (n10 != 0) {
            return layoutInflater.inflate(n10, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return this.getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean bl2) {
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context object, AttributeSet attributeSet, Bundle bundle) {
        boolean bl2;
        this.mCalled = bl2 = true;
        object = this.mHost;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = ((FragmentHostCallback)object).getActivity();
        }
        if (object != null) {
            this.mCalled = false;
            this.onInflate((Activity)object, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean bl2) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu2) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean bl2) {
    }

    public void onPrepareOptionsMenu(Menu menu2) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean bl2) {
    }

    public void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle object) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        CharSequence charSequence = null;
        this.mCalled = false;
        this.onActivityCreated((Bundle)object);
        boolean bl2 = this.mCalled;
        if (bl2) {
            this.restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
            return;
        }
        charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" did not call through to super.onActivityCreated()");
        charSequence = charSequence.toString();
        object = new SuperNotCalledException((String)charSequence);
        throw object;
    }

    public void performAttach() {
        Object object;
        boolean bl2;
        Object object2 = this.mOnPreAttachedListeners.iterator();
        while (bl2 = object2.hasNext()) {
            object = (Fragment$OnPreAttachedListener)object2.next();
            ((Fragment$OnPreAttachedListener)object).onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        object2 = this.mChildFragmentManager;
        object = this.mHost;
        FragmentContainer fragmentContainer = this.createFragmentContainer();
        ((FragmentManager)object2).attachController((FragmentHostCallback)object, fragmentContainer, this);
        this.mState = 0;
        this.mCalled = false;
        object2 = this.mHost.getContext();
        this.onAttach((Context)object2);
        boolean bl3 = this.mCalled;
        if (bl3) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onAttach()");
        object = ((StringBuilder)object).toString();
        object2 = new SuperNotCalledException((String)object);
        throw object2;
    }

    public void performConfigurationChanged(Configuration configuration) {
        this.onConfigurationChanged(configuration);
        this.mChildFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        boolean bl2 = this.mHidden;
        if (!bl2) {
            bl2 = this.onContextItemSelected(menuItem);
            if (bl2) {
                return true;
            }
            return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
        }
        return false;
    }

    public void performCreate(Bundle object) {
        int n10;
        Object object2 = this.mChildFragmentManager;
        ((FragmentManager)object2).noteStateNotSaved();
        this.mState = n10 = 1;
        Object object3 = null;
        this.mCalled = false;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            object3 = this.mLifecycleRegistry;
            Fragment$5 fragment$5 = new Fragment$5(this);
            ((LifecycleRegistry)object3).addObserver(fragment$5);
        }
        object3 = this.mSavedStateRegistryController;
        ((SavedStateRegistryController)object3).performRestore((Bundle)object);
        this.onCreate((Bundle)object);
        this.mIsCreated = n10;
        boolean bl2 = this.mCalled;
        if (bl2) {
            object = this.mLifecycleRegistry;
            object2 = Lifecycle$Event.ON_CREATE;
            ((LifecycleRegistry)object).handleLifecycleEvent((Lifecycle$Event)((Object)object2));
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Fragment ");
        ((StringBuilder)object2).append(this);
        ((StringBuilder)object2).append(" did not call through to super.onCreate()");
        object2 = ((StringBuilder)object2).toString();
        object = new SuperNotCalledException((String)object2);
        throw object;
    }

    public boolean performCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        boolean bl2 = this.mHidden;
        boolean bl3 = false;
        if (!bl2) {
            bl2 = this.mHasMenu;
            if (bl2 && (bl2 = this.mMenuVisible)) {
                bl3 = true;
                this.onCreateOptionsMenu(menu2, menuInflater);
            }
            FragmentManager fragmentManager = this.mChildFragmentManager;
            boolean bl4 = fragmentManager.dispatchCreateOptionsMenu(menu2, menuInflater);
            bl3 |= bl4;
        }
        return bl3;
    }

    public void performCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        block4: {
            block3: {
                block2: {
                    FragmentViewLifecycleOwner fragmentViewLifecycleOwner;
                    boolean bl2;
                    this.mChildFragmentManager.noteStateNotSaved();
                    this.mPerformedCreateView = bl2 = true;
                    ViewModelStore viewModelStore = this.getViewModelStore();
                    this.mViewLifecycleOwner = fragmentViewLifecycleOwner = new FragmentViewLifecycleOwner(this, viewModelStore);
                    object = this.onCreateView((LayoutInflater)object, (ViewGroup)object2, bundle);
                    this.mView = object;
                    if (object == null) break block2;
                    this.mViewLifecycleOwner.initialize();
                    object = this.mView;
                    object2 = this.mViewLifecycleOwner;
                    ViewTreeLifecycleOwner.set((View)object, (LifecycleOwner)object2);
                    object = this.mView;
                    object2 = this.mViewLifecycleOwner;
                    ViewTreeViewModelStoreOwner.set((View)object, (ViewModelStoreOwner)object2);
                    object = this.mView;
                    object2 = this.mViewLifecycleOwner;
                    ViewTreeSavedStateRegistryOwner.set((View)object, (SavedStateRegistryOwner)object2);
                    object = this.mViewLifecycleOwnerLiveData;
                    object2 = this.mViewLifecycleOwner;
                    ((MutableLiveData)object).setValue(object2);
                    break block3;
                }
                object = this.mViewLifecycleOwner;
                boolean bl3 = ((FragmentViewLifecycleOwner)object).isInitialized();
                if (bl3) break block4;
                bl3 = false;
                object = null;
                this.mViewLifecycleOwner = null;
            }
            return;
        }
        object = new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        throw object;
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        Object object = this.mLifecycleRegistry;
        Object object2 = Lifecycle$Event.ON_DESTROY;
        object.handleLifecycleEvent((Lifecycle$Event)((Object)object2));
        object = null;
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        this.onDestroy();
        boolean bl2 = this.mCalled;
        if (bl2) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Fragment ");
        ((StringBuilder)object2).append(this);
        ((StringBuilder)object2).append(" did not call through to super.onDestroy()");
        object2 = ((StringBuilder)object2).toString();
        object = new SuperNotCalledException((String)object2);
        throw object;
    }

    public void performDestroyView() {
        Object object;
        boolean bl2;
        this.mChildFragmentManager.dispatchDestroyView();
        Object object2 = this.mView;
        if (object2 != null && (bl2 = (object2 = this.mViewLifecycleOwner.getLifecycle().getCurrentState()).isAtLeast((Lifecycle$State)((Object)(object = Lifecycle$State.CREATED))))) {
            object2 = this.mViewLifecycleOwner;
            object = Lifecycle$Event.ON_DESTROY;
            object2.handleLifecycleEvent((Lifecycle$Event)((Object)object));
        }
        this.mState = 1;
        bl2 = false;
        object2 = null;
        this.mCalled = false;
        this.onDestroyView();
        boolean bl3 = this.mCalled;
        if (bl3) {
            LoaderManager.getInstance(this).markForRedelivery();
            this.mPerformedCreateView = false;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onDestroyView()");
        object = ((StringBuilder)object).toString();
        object2 = new SuperNotCalledException((String)object);
        throw object2;
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        this.onDetach();
        Object object = null;
        this.mLayoutInflater = null;
        boolean bl2 = this.mCalled;
        if (bl2) {
            object = this.mChildFragmentManager;
            bl2 = ((FragmentManager)object).isDestroyed();
            if (!bl2) {
                this.mChildFragmentManager.dispatchDestroy();
                this.mChildFragmentManager = object = new FragmentManagerImpl();
            }
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" did not call through to super.onDetach()");
        charSequence = charSequence.toString();
        object = new SuperNotCalledException((String)charSequence);
        throw object;
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        bundle = this.onGetLayoutInflater(bundle);
        this.mLayoutInflater = bundle;
        return bundle;
    }

    public void performLowMemory() {
        this.onLowMemory();
        this.mChildFragmentManager.dispatchLowMemory();
    }

    public void performMultiWindowModeChanged(boolean bl2) {
        this.onMultiWindowModeChanged(bl2);
        this.mChildFragmentManager.dispatchMultiWindowModeChanged(bl2);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        boolean bl2 = this.mHidden;
        if (!bl2) {
            bl2 = this.mHasMenu;
            if (bl2 && (bl2 = this.mMenuVisible) && (bl2 = this.onOptionsItemSelected(menuItem))) {
                return true;
            }
            return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
        }
        return false;
    }

    public void performOptionsMenuClosed(Menu menu2) {
        boolean bl2 = this.mHidden;
        if (!bl2) {
            bl2 = this.mHasMenu;
            if (bl2 && (bl2 = this.mMenuVisible)) {
                this.onOptionsMenuClosed(menu2);
            }
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.dispatchOptionsMenuClosed(menu2);
        }
    }

    public void performPause() {
        Object object;
        this.mChildFragmentManager.dispatchPause();
        Object object2 = this.mView;
        if (object2 != null) {
            object2 = this.mViewLifecycleOwner;
            object = Lifecycle$Event.ON_PAUSE;
            object2.handleLifecycleEvent((Lifecycle$Event)((Object)object));
        }
        object2 = this.mLifecycleRegistry;
        object = Lifecycle$Event.ON_PAUSE;
        object2.handleLifecycleEvent((Lifecycle$Event)((Object)object));
        this.mState = 6;
        object2 = null;
        this.mCalled = false;
        this.onPause();
        boolean bl2 = this.mCalled;
        if (bl2) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onPause()");
        object = ((StringBuilder)object).toString();
        object2 = new SuperNotCalledException((String)object);
        throw object2;
    }

    public void performPictureInPictureModeChanged(boolean bl2) {
        this.onPictureInPictureModeChanged(bl2);
        this.mChildFragmentManager.dispatchPictureInPictureModeChanged(bl2);
    }

    public boolean performPrepareOptionsMenu(Menu menu2) {
        boolean bl2 = this.mHidden;
        boolean bl3 = false;
        if (!bl2) {
            bl2 = this.mHasMenu;
            if (bl2 && (bl2 = this.mMenuVisible)) {
                bl3 = true;
                this.onPrepareOptionsMenu(menu2);
            }
            FragmentManager fragmentManager = this.mChildFragmentManager;
            boolean bl4 = fragmentManager.dispatchPrepareOptionsMenu(menu2);
            bl3 |= bl4;
        }
        return bl3;
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean bl2;
        FragmentManager fragmentManager = this.mFragmentManager;
        boolean bl3 = fragmentManager.isPrimaryNavigation(this);
        Boolean bl4 = this.mIsPrimaryNavigationFragment;
        if (bl4 == null || (bl2 = bl4.booleanValue()) != bl3) {
            this.mIsPrimaryNavigationFragment = bl4 = Boolean.valueOf(bl3);
            this.onPrimaryNavigationFragmentChanged(bl3);
            fragmentManager = this.mChildFragmentManager;
            fragmentManager.dispatchPrimaryNavigationFragmentChanged();
        }
    }

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        Object object = this.mChildFragmentManager;
        boolean bl2 = true;
        ((FragmentManager)object).execPendingActions(bl2);
        this.mState = 7;
        object = null;
        this.mCalled = false;
        this.onResume();
        boolean bl3 = this.mCalled;
        if (bl3) {
            object = this.mLifecycleRegistry;
            Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_RESUME;
            ((LifecycleRegistry)object).handleLifecycleEvent(lifecycle$Event);
            object = this.mView;
            if (object != null) {
                object = this.mViewLifecycleOwner;
                ((FragmentViewLifecycleOwner)object).handleLifecycleEvent(lifecycle$Event);
            }
            this.mChildFragmentManager.dispatchResume();
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" did not call through to super.onResume()");
        charSequence = charSequence.toString();
        object = new SuperNotCalledException((String)charSequence);
        throw object;
    }

    public void performSaveInstanceState(Bundle bundle) {
        this.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        Parcelable parcelable = this.mChildFragmentManager.saveAllState();
        if (parcelable != null) {
            String string2 = "android:support:fragments";
            bundle.putParcelable(string2, parcelable);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        Object object = this.mChildFragmentManager;
        boolean bl2 = true;
        ((FragmentManager)object).execPendingActions(bl2);
        this.mState = 5;
        object = null;
        this.mCalled = false;
        this.onStart();
        boolean bl3 = this.mCalled;
        if (bl3) {
            object = this.mLifecycleRegistry;
            Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
            ((LifecycleRegistry)object).handleLifecycleEvent(lifecycle$Event);
            object = this.mView;
            if (object != null) {
                object = this.mViewLifecycleOwner;
                ((FragmentViewLifecycleOwner)object).handleLifecycleEvent(lifecycle$Event);
            }
            this.mChildFragmentManager.dispatchStart();
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" did not call through to super.onStart()");
        charSequence = charSequence.toString();
        object = new SuperNotCalledException((String)charSequence);
        throw object;
    }

    public void performStop() {
        Object object;
        this.mChildFragmentManager.dispatchStop();
        Object object2 = this.mView;
        if (object2 != null) {
            object2 = this.mViewLifecycleOwner;
            object = Lifecycle$Event.ON_STOP;
            object2.handleLifecycleEvent((Lifecycle$Event)((Object)object));
        }
        object2 = this.mLifecycleRegistry;
        object = Lifecycle$Event.ON_STOP;
        object2.handleLifecycleEvent((Lifecycle$Event)((Object)object));
        this.mState = 4;
        object2 = null;
        this.mCalled = false;
        this.onStop();
        boolean bl2 = this.mCalled;
        if (bl2) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" did not call through to super.onStop()");
        object = ((StringBuilder)object).toString();
        object2 = new SuperNotCalledException((String)object);
        throw object2;
    }

    public void performViewCreated() {
        View view = this.mView;
        Bundle bundle = this.mSavedFragmentState;
        this.onViewCreated(view, bundle);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public void postponeEnterTransition() {
        this.ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public final void postponeEnterTransition(long l10, TimeUnit timeUnit) {
        Object object;
        boolean bl2;
        Object object2 = this.ensureAnimationInfo();
        ((Fragment$AnimationInfo)object2).mEnterTransitionPostponed = bl2 = true;
        object2 = this.mFragmentManager;
        if (object2 != null) {
            object2 = ((FragmentManager)object2).getHost().getHandler();
        } else {
            object = Looper.getMainLooper();
            object2 = new Handler(object);
        }
        object = this.mPostponedDurationRunnable;
        object2.removeCallbacks((Runnable)object);
        object = this.mPostponedDurationRunnable;
        l10 = timeUnit.toMillis(l10);
        object2.postDelayed((Runnable)object, l10);
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        Fragment$6 fragment$6 = new Fragment$6(this);
        return this.prepareCallInternal(activityResultContract, fragment$6, activityResultCallback);
    }

    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback activityResultCallback) {
        Fragment$7 fragment$7 = new Fragment$7(this, activityResultRegistry);
        return this.prepareCallInternal(activityResultContract, fragment$7, activityResultCallback);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener((View.OnCreateContextMenuListener)this);
    }

    public final void requestPermissions(String[] stringArray, int n10) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            this.getParentFragmentManager().launchRequestPermissions(this, stringArray, n10);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" not attached to Activity");
        charSequence = charSequence.toString();
        stringArray = new IllegalStateException((String)charSequence);
        throw stringArray;
    }

    public final FragmentActivity requireActivity() {
        Object object = this.getActivity();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" not attached to an activity.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public final Bundle requireArguments() {
        Object object = this.getArguments();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" does not have any arguments.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public final Context requireContext() {
        Object object = this.getContext();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" not attached to a context.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public final FragmentManager requireFragmentManager() {
        return this.getParentFragmentManager();
    }

    public final Object requireHost() {
        Object object = this.getHost();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" not attached to a host.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public final Fragment requireParentFragment() {
        Object object = this.getParentFragment();
        if (object == null) {
            object = this.getContext();
            String string2 = "Fragment ";
            if (object == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(this);
                stringBuilder.append(" is not attached to any Fragment or host");
                string2 = stringBuilder.toString();
                object = new IllegalStateException(string2);
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(this);
            stringBuilder.append(" is not a child Fragment, it is directly attached to ");
            string2 = this.getContext();
            stringBuilder.append((Object)string2);
            string2 = stringBuilder.toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        return object;
    }

    public final View requireView() {
        Object object = this.getView();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" did not return a View from onCreateView() or this was called before onCreateView().");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void restoreChildFragmentState(Bundle object) {
        Object object2;
        if (object != null && (object = object.getParcelable((String)(object2 = "android:support:fragments"))) != null) {
            object2 = this.mChildFragmentManager;
            ((FragmentManager)object2).restoreSaveState((Parcelable)object);
            object = this.mChildFragmentManager;
            ((FragmentManager)object).dispatchCreate();
        }
    }

    public final void restoreViewState(Bundle object) {
        View view;
        Object object2 = this.mSavedViewState;
        if (object2 != null) {
            view = this.mView;
            view.restoreHierarchyState((SparseArray)object2);
            this.mSavedViewState = null;
        }
        if ((object2 = this.mView) != null) {
            object2 = this.mViewLifecycleOwner;
            view = this.mSavedViewRegistryState;
            ((FragmentViewLifecycleOwner)object2).performRestore((Bundle)view);
            this.mSavedViewRegistryState = null;
        }
        object2 = null;
        this.mCalled = false;
        this.onViewStateRestored((Bundle)object);
        boolean bl2 = this.mCalled;
        if (bl2) {
            object = this.mView;
            if (object != null) {
                object = this.mViewLifecycleOwner;
                object2 = Lifecycle$Event.ON_CREATE;
                ((FragmentViewLifecycleOwner)object).handleLifecycleEvent((Lifecycle$Event)((Object)object2));
            }
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Fragment ");
        ((StringBuilder)object2).append(this);
        ((StringBuilder)object2).append(" did not call through to super.onViewStateRestored()");
        object2 = ((StringBuilder)object2).toString();
        object = new SuperNotCalledException((String)object2);
        throw object;
    }

    public void setAllowEnterTransitionOverlap(boolean bl2) {
        Boolean bl3;
        Fragment$AnimationInfo fragment$AnimationInfo = this.ensureAnimationInfo();
        fragment$AnimationInfo.mAllowEnterTransitionOverlap = bl3 = Boolean.valueOf(bl2);
    }

    public void setAllowReturnTransitionOverlap(boolean bl2) {
        Boolean bl3;
        Fragment$AnimationInfo fragment$AnimationInfo = this.ensureAnimationInfo();
        fragment$AnimationInfo.mAllowReturnTransitionOverlap = bl3 = Boolean.valueOf(bl2);
    }

    public void setAnimatingAway(View view) {
        this.ensureAnimationInfo().mAnimatingAway = view;
    }

    public void setAnimations(int n10, int n11, int n12, int n13) {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null && n10 == 0 && n11 == 0 && n12 == 0 && n13 == 0) {
            return;
        }
        this.ensureAnimationInfo().mEnterAnim = n10;
        this.ensureAnimationInfo().mExitAnim = n11;
        this.ensureAnimationInfo().mPopEnterAnim = n12;
        this.ensureAnimationInfo().mPopExitAnim = n13;
    }

    public void setAnimator(Animator animator2) {
        this.ensureAnimationInfo().mAnimator = animator2;
    }

    public void setArguments(Bundle object) {
        boolean bl2;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null && (bl2 = this.isStateSaved())) {
            object = new IllegalStateException("Fragment already added and state has been saved");
            throw object;
        }
        this.mArguments = object;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.ensureAnimationInfo().mEnterTransitionCallback = sharedElementCallback;
    }

    public void setEnterTransition(Object object) {
        this.ensureAnimationInfo().mEnterTransition = object;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.ensureAnimationInfo().mExitTransitionCallback = sharedElementCallback;
    }

    public void setExitTransition(Object object) {
        this.ensureAnimationInfo().mExitTransition = object;
    }

    public void setFocusedView(View view) {
        this.ensureAnimationInfo().mFocusedView = view;
    }

    public void setHasOptionsMenu(boolean bl2) {
        boolean bl3 = this.mHasMenu;
        if (bl3 != bl2) {
            this.mHasMenu = bl2;
            bl2 = this.isAdded();
            if (bl2 && !(bl2 = this.isHidden())) {
                FragmentHostCallback fragmentHostCallback = this.mHost;
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setHideReplaced(boolean bl2) {
        this.ensureAnimationInfo().mIsHideReplaced = bl2;
    }

    public void setInitialSavedState(Fragment$SavedState object) {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            if (object == null || (object = ((Fragment$SavedState)object).mState) == null) {
                object = null;
            }
            this.mSavedFragmentState = object;
            return;
        }
        object = new IllegalStateException("Fragment already added");
        throw object;
    }

    public void setMenuVisibility(boolean bl2) {
        boolean bl3 = this.mMenuVisible;
        if (bl3 != bl2) {
            this.mMenuVisible = bl2;
            bl2 = this.mHasMenu;
            if (bl2 && (bl2 = this.isAdded()) && !(bl2 = this.isHidden())) {
                FragmentHostCallback fragmentHostCallback = this.mHost;
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int n10) {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null && n10 == 0) {
            return;
        }
        this.ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = n10;
    }

    public void setOnStartEnterTransitionListener(Fragment$OnStartEnterTransitionListener object) {
        this.ensureAnimationInfo();
        Object object2 = this.mAnimationInfo;
        Fragment$OnStartEnterTransitionListener fragment$OnStartEnterTransitionListener = ((Fragment$AnimationInfo)object2).mStartEnterTransitionListener;
        if (object == fragment$OnStartEnterTransitionListener) {
            return;
        }
        if (object != null && fragment$OnStartEnterTransitionListener != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Trying to set a replacement startPostponedEnterTransition on ");
            ((StringBuilder)object2).append(this);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        boolean bl2 = ((Fragment$AnimationInfo)object2).mEnterTransitionPostponed;
        if (bl2) {
            ((Fragment$AnimationInfo)object2).mStartEnterTransitionListener = object;
        }
        if (object != null) {
            object.startListening();
        }
    }

    public void setPopDirection(boolean bl2) {
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        if (fragment$AnimationInfo == null) {
            return;
        }
        this.ensureAnimationInfo().mIsPop = bl2;
    }

    public void setPostOnViewCreatedAlpha(float f10) {
        this.ensureAnimationInfo().mPostOnViewCreatedAlpha = f10;
    }

    public void setReenterTransition(Object object) {
        this.ensureAnimationInfo().mReenterTransition = object;
    }

    public void setRetainInstance(boolean bl2) {
        this.mRetainInstance = bl2;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            if (bl2) {
                fragmentManager.addRetainedFragment(this);
            } else {
                fragmentManager.removeRetainedFragment(this);
            }
        } else {
            this.mRetainInstanceChangedWhileDetached = bl2 = true;
        }
    }

    public void setReturnTransition(Object object) {
        this.ensureAnimationInfo().mReturnTransition = object;
    }

    public void setSharedElementEnterTransition(Object object) {
        this.ensureAnimationInfo().mSharedElementEnterTransition = object;
    }

    public void setSharedElementNames(ArrayList arrayList, ArrayList arrayList2) {
        this.ensureAnimationInfo();
        Fragment$AnimationInfo fragment$AnimationInfo = this.mAnimationInfo;
        fragment$AnimationInfo.mSharedElementSourceNames = arrayList;
        fragment$AnimationInfo.mSharedElementTargetNames = arrayList2;
    }

    public void setSharedElementReturnTransition(Object object) {
        this.ensureAnimationInfo().mSharedElementReturnTransition = object;
    }

    public void setTargetFragment(Fragment object, int n10) {
        boolean bl2;
        FragmentManager fragmentManager;
        Object object2 = this.mFragmentManager;
        if (object != null) {
            fragmentManager = ((Fragment)object).mFragmentManager;
        } else {
            bl2 = false;
            fragmentManager = null;
        }
        if (object2 != null && fragmentManager != null && object2 != fragmentManager) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Fragment ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" must share the same FragmentManager to be set as a target fragment");
            object = ((StringBuilder)object2).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        for (object2 = object; object2 != null; object2 = ((Fragment)object2).getTargetFragment()) {
            bl2 = ((Fragment)object2).equals(this);
            if (!bl2) {
                continue;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Setting ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" as the target of ");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append(" would create a target cycle");
            object = ((StringBuilder)object2).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        if (object == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else {
            object2 = this.mFragmentManager;
            if (object2 != null && (object2 = ((Fragment)object).mFragmentManager) != null) {
                this.mTargetWho = object = ((Fragment)object).mWho;
                this.mTarget = null;
            } else {
                this.mTargetWho = null;
                this.mTarget = object;
            }
        }
        this.mTargetRequestCode = n10;
    }

    public void setUserVisibleHint(boolean bl2) {
        FragmentManager fragmentManager;
        int n10 = this.mUserVisibleHint;
        int n11 = 5;
        if (n10 == 0 && bl2 && (n10 = this.mState) < n11 && (fragmentManager = this.mFragmentManager) != null && (n10 = (int)(this.isAdded() ? 1 : 0)) != 0 && (n10 = (int)(this.mIsCreated ? 1 : 0)) != 0) {
            fragmentManager = this.mFragmentManager;
            FragmentStateManager fragmentStateManager = fragmentManager.createOrGetFragmentStateManager(this);
            fragmentManager.performPendingDeferredStart(fragmentStateManager);
        }
        this.mUserVisibleHint = bl2;
        n10 = this.mState;
        if (n10 < n11 && !bl2) {
            n10 = 1;
        } else {
            n10 = 0;
            fragmentManager = null;
        }
        this.mDeferStart = n10;
        fragmentManager = this.mSavedFragmentState;
        if (fragmentManager != null) {
            Boolean bl3;
            this.mSavedUserVisibleHint = bl3 = Boolean.valueOf(bl2);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String string2) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            return fragmentHostCallback.onShouldShowRequestPermissionRationale(string2);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        this.startActivity(intent, null);
    }

    public void startActivity(Intent object, Bundle object2) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.onStartActivityFromFragment(this, (Intent)object, -1, (Bundle)object2);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Fragment ");
        ((StringBuilder)object2).append(this);
        ((StringBuilder)object2).append(" not attached to Activity");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void startActivityForResult(Intent intent, int n10) {
        this.startActivityForResult(intent, n10, null);
    }

    public void startActivityForResult(Intent object, int n10, Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            this.getParentFragmentManager().launchStartActivityForResult(this, (Intent)object, n10, bundle);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Fragment ");
        charSequence.append(this);
        charSequence.append(" not attached to Activity");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void startIntentSenderForResult(IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13, Bundle bundle) {
        Object object = this.mHost;
        Object object2 = "Fragment ";
        if (object != null) {
            IntentSender intentSender2;
            boolean bl2 = FragmentManager.isLoggingEnabled(2);
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(this);
                ((StringBuilder)object).append(" received the following in startIntentSenderForResult() requestCode: ");
                ((StringBuilder)object).append(n10);
                ((StringBuilder)object).append(" IntentSender: ");
                intentSender2 = intentSender;
                ((StringBuilder)object).append(intentSender);
                ((StringBuilder)object).append(" fillInIntent: ");
                ((StringBuilder)object).append(intent);
                ((StringBuilder)object).append(" options: ");
                ((StringBuilder)object).append(bundle);
                object = ((StringBuilder)object).toString();
                object2 = "FragmentManager";
                Log.v((String)object2, (String)object);
            } else {
                intentSender2 = intentSender;
            }
            object = this.getParentFragmentManager();
            object2 = this;
            intentSender2 = intentSender;
            ((FragmentManager)object).launchStartIntentSenderForResult(this, intentSender, n10, intent, n11, n12, n13, bundle);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        stringBuilder.append(this);
        stringBuilder.append(" not attached to Activity");
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void startPostponedEnterTransition() {
        Object object = this.mAnimationInfo;
        if (object != null) {
            object = this.ensureAnimationInfo();
            boolean bl2 = ((Fragment$AnimationInfo)object).mEnterTransitionPostponed;
            if (bl2) {
                object = this.mHost;
                if (object == null) {
                    object = this.ensureAnimationInfo();
                    Object var3_3 = null;
                    ((Fragment$AnimationInfo)object).mEnterTransitionPostponed = false;
                } else {
                    Object object2;
                    object = Looper.myLooper();
                    if (object != (object2 = this.mHost.getHandler().getLooper())) {
                        object = this.mHost.getHandler();
                        object2 = new Fragment$2(this);
                        object.postAtFrontOfQueue((Runnable)object2);
                    } else {
                        bl2 = true;
                        this.callStartTransitionListener(bl2);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        String string2 = this.getClass().getSimpleName();
        stringBuilder.append(string2);
        stringBuilder.append("{");
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append("}");
        stringBuilder.append(" (");
        string2 = this.mWho;
        stringBuilder.append(string2);
        int n10 = this.mFragmentId;
        if (n10 != 0) {
            stringBuilder.append(" id=0x");
            n10 = this.mFragmentId;
            string2 = Integer.toHexString(n10);
            stringBuilder.append(string2);
        }
        if ((string2 = this.mTag) != null) {
            stringBuilder.append(" tag=");
            string2 = this.mTag;
            stringBuilder.append(string2);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}

