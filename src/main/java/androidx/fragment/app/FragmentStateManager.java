/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.Resources$NotFoundException
 *  android.os.Bundle
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$SavedState;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStateManager$1;
import androidx.fragment.app.FragmentStateManager$2;
import androidx.fragment.app.FragmentStore;
import androidx.fragment.app.FragmentViewLifecycleOwner;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.ViewModelStoreOwner;

public class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    private final Fragment mFragment;
    private int mFragmentManagerState;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState = false;

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.mFragmentManagerState = -1;
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore object, Fragment fragment, FragmentState fragmentState) {
        int n10;
        this.mFragmentManagerState = n10 = -1;
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = object;
        this.mFragment = fragment;
        fragmentLifecycleCallbacksDispatcher = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        object = fragment.mTarget;
        object = object != null ? ((Fragment)object).mWho : null;
        fragment.mTargetWho = object;
        fragment.mTarget = null;
        fragmentLifecycleCallbacksDispatcher = fragmentState.mSavedFragmentState;
        if (fragmentLifecycleCallbacksDispatcher != null) {
            fragment.mSavedFragmentState = fragmentLifecycleCallbacksDispatcher;
        } else {
            fragment.mSavedFragmentState = fragmentLifecycleCallbacksDispatcher;
        }
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher object, FragmentStore object2, ClassLoader object3, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        int n10;
        int n11;
        this.mFragmentManagerState = n11 = -1;
        this.mDispatcher = object;
        this.mFragmentStore = object2;
        object = fragmentState.mClassName;
        this.mFragment = object = fragmentFactory.instantiate((ClassLoader)object3, (String)object);
        object2 = fragmentState.mArguments;
        if (object2 != null) {
            object2.setClassLoader((ClassLoader)object3);
        }
        object2 = fragmentState.mArguments;
        ((Fragment)object).setArguments((Bundle)object2);
        ((Fragment)object).mWho = object2 = fragmentState.mWho;
        ((Fragment)object).mFromLayout = n10 = fragmentState.mFromLayout;
        ((Fragment)object).mRestored = true;
        ((Fragment)object).mFragmentId = n10 = fragmentState.mFragmentId;
        ((Fragment)object).mContainerId = n10 = fragmentState.mContainerId;
        ((Fragment)object).mTag = object2 = fragmentState.mTag;
        n10 = (int)(fragmentState.mRetainInstance ? 1 : 0);
        ((Fragment)object).mRetainInstance = n10;
        n10 = (int)(fragmentState.mRemoving ? 1 : 0);
        ((Fragment)object).mRemoving = n10;
        n10 = (int)(fragmentState.mDetached ? 1 : 0);
        ((Fragment)object).mDetached = n10;
        n10 = (int)(fragmentState.mHidden ? 1 : 0);
        ((Fragment)object).mHidden = n10;
        object2 = Lifecycle$State.values();
        int n12 = fragmentState.mMaxLifecycleState;
        object2 = object2[n12];
        ((Fragment)object).mMaxState = object2;
        object2 = fragmentState.mSavedFragmentState;
        if (object2 != null) {
            ((Fragment)object).mSavedFragmentState = object2;
        } else {
            object2 = new Bundle();
            ((Fragment)object).mSavedFragmentState = object2;
        }
        n10 = (int)(FragmentManager.isLoggingEnabled(2) ? 1 : 0);
        if (n10 != 0) {
            object3 = "Instantiated fragment ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            object2 = TAG;
            Log.v((String)object2, (String)object);
        }
    }

    private boolean isFragmentViewChild(View view) {
        View view2 = this.mFragment.mView;
        boolean bl2 = true;
        if (view == view2) {
            return bl2;
        }
        for (view = view.getParent(); view != null; view = view.getParent()) {
            view2 = this.mFragment.mView;
            if (view != view2) continue;
            return bl2;
        }
        return false;
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        Object object = this.mDispatcher;
        Object object2 = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentSaveInstanceState((Fragment)object2, bundle, false);
        boolean bl2 = bundle.isEmpty();
        if (bl2) {
            bundle = null;
        }
        if ((object = this.mFragment.mView) != null) {
            this.saveViewState();
        }
        if ((object = this.mFragment.mSavedViewState) != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            object = this.mFragment.mSavedViewState;
            object2 = VIEW_STATE_TAG;
            bundle.putSparseParcelableArray((String)object2, (SparseArray)object);
        }
        if ((object = this.mFragment.mSavedViewRegistryState) != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            object = this.mFragment.mSavedViewRegistryState;
            object2 = VIEW_REGISTRY_STATE_TAG;
            bundle.putBundle((String)object2, (Bundle)object);
        }
        object = this.mFragment;
        bl2 = ((Fragment)object).mUserVisibleHint;
        if (!bl2) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            object = this.mFragment;
            bl2 = ((Fragment)object).mUserVisibleHint;
            object2 = USER_VISIBLE_HINT_TAG;
            bundle.putBoolean((String)object2, bl2);
        }
        return bundle;
    }

    public void activityCreated() {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("moveto ACTIVITY_CREATED: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        object2 = this.mFragment;
        object = ((Fragment)object2).mSavedFragmentState;
        ((Fragment)object2).performActivityCreated((Bundle)object);
        object2 = this.mDispatcher;
        object = this.mFragment;
        Bundle bundle = object.mSavedFragmentState;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentActivityCreated((Fragment)object, bundle, false);
    }

    public void addViewToContainer() {
        FragmentStore fragmentStore = this.mFragmentStore;
        Fragment fragment = this.mFragment;
        int n10 = fragmentStore.findFragmentIndexInContainer(fragment);
        fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        fragment = fragment.mView;
        viewGroup.addView((View)fragment, n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void attach() {
        Object object;
        Object object2;
        block8: {
            Object object3;
            block9: {
                int n10 = FragmentManager.isLoggingEnabled(3);
                if (n10 != 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("moveto ATTACHED: ");
                    object = this.mFragment;
                    ((StringBuilder)object2).append(object);
                    object2 = ((StringBuilder)object2).toString();
                    object = TAG;
                    Log.d((String)object, (String)object2);
                }
                object2 = this.mFragment;
                object = ((Fragment)object2).mTarget;
                String string2 = " that does not belong to this FragmentManager!";
                Object object4 = " declared target fragment ";
                Object object5 = "Fragment ";
                object3 = null;
                if (object != null) {
                    object2 = this.mFragmentStore;
                    object = ((Fragment)object).mWho;
                    if ((object2 = ((FragmentStore)object2).getFragmentStateManager((String)object)) == null) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)object5);
                        object5 = this.mFragment;
                        ((StringBuilder)object).append(object5);
                        ((StringBuilder)object).append((String)object4);
                        object4 = this.mFragment.mTarget;
                        ((StringBuilder)object).append(object4);
                        ((StringBuilder)object).append(string2);
                        object = ((StringBuilder)object).toString();
                        object2 = new IllegalStateException((String)object);
                        throw object2;
                    }
                    object = this.mFragment;
                    ((Fragment)object).mTargetWho = string2 = object.mTarget.mWho;
                    ((Fragment)object).mTarget = null;
                    object3 = object2;
                } else {
                    object2 = ((Fragment)object2).mTargetWho;
                    if (object2 != null && (object3 = ((FragmentStore)(object = this.mFragmentStore)).getFragmentStateManager((String)object2)) == null) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)object5);
                        object5 = this.mFragment;
                        ((StringBuilder)object).append(object5);
                        ((StringBuilder)object).append((String)object4);
                        object4 = this.mFragment.mTargetWho;
                        ((StringBuilder)object).append((String)object4);
                        ((StringBuilder)object).append(string2);
                        object = ((StringBuilder)object).toString();
                        object2 = new IllegalStateException((String)object);
                        throw object2;
                    }
                }
                if (object3 == null) break block8;
                n10 = FragmentManager.USE_STATE_MANAGER;
                if (n10 != 0) break block9;
                object2 = ((FragmentStateManager)object3).getFragment();
                n10 = ((Fragment)object2).mState;
                int n11 = 1;
                if (n10 >= n11) break block8;
            }
            ((FragmentStateManager)object3).moveToExpectedState();
        }
        object2 = this.mFragment;
        ((Fragment)object2).mHost = object = ((Fragment)object2).mFragmentManager.getHost();
        object2 = this.mFragment;
        ((Fragment)object2).mParentFragment = object = ((Fragment)object2).mFragmentManager.getParent();
        object2 = this.mDispatcher;
        object = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentPreAttached((Fragment)object, false);
        this.mFragment.performAttach();
        object2 = this.mDispatcher;
        object = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentAttached((Fragment)object, false);
    }

    public int computeExpectedState() {
        Object object;
        Object object2 = this.mFragment;
        FragmentManager fragmentManager = ((Fragment)object2).mFragmentManager;
        if (fragmentManager == null) {
            return ((Fragment)object2).mState;
        }
        int n10 = this.mFragmentManagerState;
        Object object3 = FragmentStateManager$2.$SwitchMap$androidx$lifecycle$Lifecycle$State;
        object2 = ((Fragment)object2).mMaxState;
        int n11 = ((Enum)object2).ordinal();
        n11 = object3[n11];
        int n12 = -1;
        int n13 = 5;
        int n14 = 3;
        int n15 = 4;
        int n16 = 2;
        int n17 = 1;
        if (n11 != n17) {
            if (n11 != n16) {
                if (n11 != n14) {
                    if (n11 != n15) {
                        n10 = Math.min(n10, n12);
                    } else {
                        n11 = 0;
                        object2 = null;
                        n10 = Math.min(n10, 0);
                    }
                } else {
                    n10 = Math.min(n10, n17);
                }
            } else {
                n10 = Math.min(n10, n13);
            }
        }
        object2 = this.mFragment;
        int n18 = ((Fragment)object2).mFromLayout;
        if (n18 != 0) {
            n18 = ((Fragment)object2).mInLayout;
            if (n18 != 0) {
                n11 = this.mFragmentManagerState;
                n10 = Math.max(n11, n16);
                object2 = this.mFragment.mView;
                if (object2 != null && (object2 = object2.getParent()) == null) {
                    n10 = Math.min(n10, n16);
                }
            } else {
                n18 = this.mFragmentManagerState;
                if (n18 < n15) {
                    n11 = ((Fragment)object2).mState;
                    n10 = Math.min(n10, n11);
                } else {
                    n10 = Math.min(n10, n17);
                }
            }
        }
        object2 = this.mFragment;
        n11 = (int)(((Fragment)object2).mAdded ? 1 : 0);
        if (n11 == 0) {
            n10 = Math.min(n10, n17);
        }
        n11 = 0;
        object2 = null;
        n18 = (int)(FragmentManager.USE_STATE_MANAGER ? 1 : 0);
        if (n18 != 0) {
            object = this.mFragment;
            ViewGroup viewGroup = ((Fragment)object).mContainer;
            if (viewGroup != null) {
                object2 = ((Fragment)object).getParentFragmentManager();
                object2 = SpecialEffectsController.getOrCreateController(viewGroup, (FragmentManager)object2).getAwaitingCompletionLifecycleImpact(this);
            }
        }
        if (object2 == (object = SpecialEffectsController$Operation$LifecycleImpact.ADDING)) {
            n11 = 6;
            n10 = Math.min(n10, n11);
        } else {
            object = SpecialEffectsController$Operation$LifecycleImpact.REMOVING;
            if (object2 == object) {
                n10 = Math.max(n10, n14);
            } else {
                object2 = this.mFragment;
                n14 = (int)(((Fragment)object2).mRemoving ? 1 : 0);
                if (n14 != 0) {
                    n11 = (int)(((Fragment)object2).isInBackStack() ? 1 : 0);
                    n10 = n11 != 0 ? Math.min(n10, n17) : Math.min(n10, n12);
                }
            }
        }
        object2 = this.mFragment;
        n12 = (int)(((Fragment)object2).mDeferStart ? 1 : 0);
        if (n12 != 0 && (n11 = ((Fragment)object2).mState) < n13) {
            n10 = Math.min(n10, n15);
        }
        if ((n11 = (int)(FragmentManager.isLoggingEnabled(n16) ? 1 : 0)) != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("computeExpectedState() of ");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append(" for ");
            object3 = this.mFragment;
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object3 = TAG;
            Log.v((String)object3, (String)object2);
        }
        return n10;
    }

    public void create() {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("moveto CREATED: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        object2 = this.mFragment;
        boolean bl3 = ((Fragment)object2).mIsCreated;
        if (!bl3) {
            object = this.mDispatcher;
            Bundle bundle = ((Fragment)object2).mSavedFragmentState;
            ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentPreCreated((Fragment)object2, bundle, false);
            object2 = this.mFragment;
            object = ((Fragment)object2).mSavedFragmentState;
            ((Fragment)object2).performCreate((Bundle)object);
            object2 = this.mDispatcher;
            object = this.mFragment;
            bundle = ((Fragment)object).mSavedFragmentState;
            ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentCreated((Fragment)object, bundle, false);
        } else {
            object = ((Fragment)object2).mSavedFragmentState;
            ((Fragment)object2).restoreChildFragmentState((Bundle)object);
            object2 = this.mFragment;
            bl3 = true;
            ((Fragment)object2).mState = (int)(bl3 ? 1 : 0);
        }
    }

    public void createView() {
        int n10;
        int n11;
        Object object;
        Object object2 = this.mFragment;
        int n12 = ((Fragment)object2).mFromLayout;
        if (n12 != 0) {
            return;
        }
        n12 = FragmentManager.isLoggingEnabled(3);
        Object object3 = TAG;
        if (n12 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("moveto CREATE_VIEW: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            Log.d((String)object3, (String)object2);
        }
        object2 = this.mFragment;
        object = ((Fragment)object2).mSavedFragmentState;
        object2 = ((Fragment)object2).performGetLayoutInflater((Bundle)object);
        int n13 = 0;
        float f10 = 0.0f;
        object = null;
        Object object4 = this.mFragment;
        Object object5 = ((Fragment)object4).mContainer;
        if (object5 != null) {
            object = object5;
        } else {
            n11 = ((Fragment)object4).mContainerId;
            if (n11 != 0) {
                n13 = -1;
                f10 = 0.0f / 0.0f;
                if (n11 != n13) {
                    object = ((Fragment)object4).mFragmentManager.getContainer();
                    object4 = this.mFragment;
                    n10 = ((Fragment)object4).mContainerId;
                    if ((object = (ViewGroup)((FragmentContainer)object).onFindViewById(n10)) == null) {
                        object4 = this.mFragment;
                        n11 = (int)(((Fragment)object4).mRestored ? 1 : 0);
                        if (n11 == 0) {
                            object2 = ((Fragment)object4).getResources();
                            object3 = this.mFragment;
                            int n14 = ((Fragment)object3).mContainerId;
                            try {
                                object2 = object2.getResourceName(n14);
                            }
                            catch (Resources.NotFoundException notFoundException) {
                                object2 = "unknown";
                            }
                            object = new StringBuilder();
                            ((StringBuilder)object).append("No view found for id 0x");
                            object4 = Integer.toHexString(this.mFragment.mContainerId);
                            ((StringBuilder)object).append((String)object4);
                            ((StringBuilder)object).append(" (");
                            ((StringBuilder)object).append((String)object2);
                            ((StringBuilder)object).append(") for fragment ");
                            object2 = this.mFragment;
                            ((StringBuilder)object).append(object2);
                            object2 = ((StringBuilder)object).toString();
                            object3 = new IllegalArgumentException((String)object2);
                            throw object3;
                        }
                    }
                } else {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Cannot create fragment ");
                    object = this.mFragment;
                    ((StringBuilder)object3).append(object);
                    ((StringBuilder)object3).append(" for a container view with no id");
                    object3 = ((StringBuilder)object3).toString();
                    object2 = new IllegalArgumentException((String)object3);
                    throw object2;
                }
            }
        }
        object4 = this.mFragment;
        ((Fragment)object4).mContainer = object;
        object5 = ((Fragment)object4).mSavedFragmentState;
        ((Fragment)object4).performCreateView((LayoutInflater)object2, (ViewGroup)object, (Bundle)object5);
        object2 = this.mFragment.mView;
        n10 = 2;
        if (object2 != null) {
            n11 = 0;
            object5 = null;
            object2.setSaveFromParentEnabled(false);
            object2 = this.mFragment;
            View view = ((Fragment)object2).mView;
            int n15 = R$id.fragment_container_view_tag;
            view.setTag(n15, object2);
            if (object != null) {
                this.addViewToContainer();
            }
            object2 = this.mFragment;
            n13 = (int)(((Fragment)object2).mHidden ? 1 : 0);
            if (n13 != 0) {
                object2 = ((Fragment)object2).mView;
                n13 = 8;
                f10 = 1.1E-44f;
                object2.setVisibility(n13);
            }
            if ((n12 = ViewCompat.isAttachedToWindow((View)(object2 = this.mFragment.mView))) != 0) {
                object2 = this.mFragment.mView;
                ViewCompat.requestApplyInsets((View)object2);
            } else {
                object2 = this.mFragment.mView;
                object = new FragmentStateManager$1(this, (View)object2);
                object2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)object);
            }
            this.mFragment.performViewCreated();
            object2 = this.mDispatcher;
            object = this.mFragment;
            view = ((Fragment)object).mView;
            Bundle bundle = ((Fragment)object).mSavedFragmentState;
            ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentViewCreated((Fragment)object, view, bundle, false);
            object2 = this.mFragment.mView;
            n12 = object2.getVisibility();
            object = this.mFragment.mView;
            f10 = object.getAlpha();
            boolean bl2 = FragmentManager.USE_STATE_MANAGER;
            if (bl2) {
                this.mFragment.setPostOnViewCreatedAlpha(f10);
                object = this.mFragment;
                object5 = ((Fragment)object).mContainer;
                if (object5 != null && n12 == 0) {
                    object2 = ((Fragment)object).mView.findFocus();
                    if (object2 != null) {
                        object = this.mFragment;
                        ((Fragment)object).setFocusedView((View)object2);
                        n13 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0);
                        if (n13 != 0) {
                            object = new StringBuilder();
                            object5 = "requestFocus: Saved focused view ";
                            ((StringBuilder)object).append((String)object5);
                            ((StringBuilder)object).append(object2);
                            ((StringBuilder)object).append(" for Fragment ");
                            object2 = this.mFragment;
                            ((StringBuilder)object).append(object2);
                            object2 = ((StringBuilder)object).toString();
                            Log.v((String)object3, (String)object2);
                        }
                    }
                    object2 = this.mFragment.mView;
                    boolean bl3 = false;
                    object3 = null;
                    object2.setAlpha(0.0f);
                }
            } else {
                object3 = this.mFragment;
                if (n12 == 0 && (object2 = ((Fragment)object3).mContainer) != null) {
                    n11 = 1;
                }
                ((Fragment)object3).mIsNewlyAdded = n11;
            }
        }
        this.mFragment.mState = n10;
    }

    public void destroy() {
        Fragment fragment;
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("movefrom CREATED: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        object2 = this.mFragment;
        boolean bl3 = ((Fragment)object2).mRemoving;
        boolean bl4 = true;
        String string2 = null;
        if (bl3 && !(bl2 = ((Fragment)object2).isInBackStack())) {
            bl2 = bl4;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (!bl2 && !(bl3 = ((FragmentManagerViewModel)(object = this.mFragmentStore.getNonConfig())).shouldDestroy(fragment = this.mFragment))) {
            bl3 = false;
            object = null;
        } else {
            bl3 = bl4;
        }
        if (bl3) {
            Object object3;
            object = this.mFragment.mHost;
            boolean bl5 = object instanceof ViewModelStoreOwner;
            if (bl5) {
                object = this.mFragmentStore.getNonConfig();
                bl4 = ((FragmentManagerViewModel)object).isCleared();
            } else {
                fragment = ((FragmentHostCallback)object).getContext();
                bl5 = fragment instanceof Activity;
                if (bl5) {
                    object = (Activity)((FragmentHostCallback)object).getContext();
                    bl3 = object.isChangingConfigurations();
                    bl4 ^= bl3;
                }
            }
            if (bl2 || bl4) {
                object2 = this.mFragmentStore.getNonConfig();
                object = this.mFragment;
                ((FragmentManagerViewModel)object2).clearNonConfigState((Fragment)object);
            }
            this.mFragment.performDestroy();
            object2 = this.mDispatcher;
            object = this.mFragment;
            ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentDestroyed((Fragment)object, false);
            object2 = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
            while (bl3 = object2.hasNext()) {
                object = (FragmentStateManager)object2.next();
                if (object == null) continue;
                object = ((FragmentStateManager)object).getFragment();
                object3 = this.mFragment.mWho;
                string2 = ((Fragment)object).mTargetWho;
                bl4 = ((String)object3).equals(string2);
                if (!bl4) continue;
                ((Fragment)object).mTarget = object3 = this.mFragment;
                bl4 = false;
                object3 = null;
                ((Fragment)object).mTargetWho = null;
            }
            object2 = this.mFragment;
            object = ((Fragment)object2).mTargetWho;
            if (object != null) {
                object3 = this.mFragmentStore;
                ((Fragment)object2).mTarget = object = ((FragmentStore)object3).findActiveFragment((String)object);
            }
            object2 = this.mFragmentStore;
            ((FragmentStore)object2).makeInactive(this);
        } else {
            object2 = this.mFragment.mTargetWho;
            if (object2 != null && (object2 = ((FragmentStore)(object = this.mFragmentStore)).findActiveFragment((String)object2)) != null && (bl3 = ((Fragment)object2).mRetainInstance)) {
                object = this.mFragment;
                ((Fragment)object).mTarget = object2;
            }
            object2 = this.mFragment;
            ((Fragment)object2).mState = 0;
        }
    }

    public void destroyFragmentView() {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("movefrom CREATE_VIEW: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        object2 = this.mFragment;
        object = ((Fragment)object2).mContainer;
        if (object != null && (object2 = ((Fragment)object2).mView) != null) {
            object.removeView((View)object2);
        }
        this.mFragment.performDestroyView();
        object2 = this.mDispatcher;
        object = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentViewDestroyed((Fragment)object, false);
        object2 = this.mFragment;
        ((Fragment)object2).mContainer = null;
        ((Fragment)object2).mView = null;
        ((Fragment)object2).mViewLifecycleOwner = null;
        ((Fragment)object2).mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    public void detach() {
        Fragment fragment;
        Object object;
        int n10 = 3;
        boolean bl2 = FragmentManager.isLoggingEnabled(n10);
        String string2 = TAG;
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("movefrom ATTACHED: ");
            fragment = this.mFragment;
            ((StringBuilder)object).append(fragment);
            object = ((StringBuilder)object).toString();
            Log.d((String)string2, (String)object);
        }
        this.mFragment.performDetach();
        object = this.mDispatcher;
        fragment = this.mFragment;
        boolean bl3 = false;
        ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentDetached(fragment, false);
        object = this.mFragment;
        ((Fragment)object).mState = -1;
        fragment = null;
        ((Fragment)object).mHost = null;
        ((Fragment)object).mParentFragment = null;
        ((Fragment)object).mFragmentManager = null;
        boolean bl4 = ((Fragment)object).mRemoving;
        if (bl4 && !(bl2 = ((Fragment)object).isInBackStack())) {
            bl3 = true;
        }
        if (bl3 || (bl2 = ((FragmentManagerViewModel)(object = this.mFragmentStore.getNonConfig())).shouldDestroy(fragment = this.mFragment))) {
            Object object2;
            if ((n10 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0)) != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("initState called for fragment: ");
                object = this.mFragment;
                ((StringBuilder)object2).append(object);
                object2 = ((StringBuilder)object2).toString();
                Log.d((String)string2, (String)object2);
            }
            object2 = this.mFragment;
            ((Fragment)object2).initState();
        }
    }

    public void ensureInflatedView() {
        boolean bl2;
        Object object = this.mFragment;
        int n10 = ((Fragment)object).mFromLayout;
        if (n10 != 0 && (n10 = ((Fragment)object).mInLayout) != 0 && !(bl2 = ((Fragment)object).mPerformedCreateView)) {
            Object object2;
            bl2 = FragmentManager.isLoggingEnabled(3);
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("moveto CREATE_VIEW: ");
                object2 = this.mFragment;
                ((StringBuilder)object).append(object2);
                object = ((StringBuilder)object).toString();
                object2 = TAG;
                Log.d((String)object2, (String)object);
            }
            object = this.mFragment;
            object2 = ((Fragment)object).mSavedFragmentState;
            object2 = ((Fragment)object).performGetLayoutInflater((Bundle)object2);
            int n11 = 0;
            Object object3 = null;
            Bundle bundle = this.mFragment.mSavedFragmentState;
            ((Fragment)object).performCreateView((LayoutInflater)object2, null, bundle);
            object = this.mFragment.mView;
            if (object != null) {
                n10 = 0;
                object2 = null;
                object.setSaveFromParentEnabled(false);
                object = this.mFragment;
                object3 = ((Fragment)object).mView;
                int n12 = R$id.fragment_container_view_tag;
                object3.setTag(n12, object);
                object = this.mFragment;
                n11 = ((Fragment)object).mHidden;
                if (n11 != 0) {
                    object = ((Fragment)object).mView;
                    n11 = 8;
                    object.setVisibility(n11);
                }
                this.mFragment.performViewCreated();
                object = this.mDispatcher;
                object3 = this.mFragment;
                bundle = object3.mView;
                Bundle bundle2 = object3.mSavedFragmentState;
                ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentViewCreated((Fragment)object3, (View)bundle, bundle2, false);
                object = this.mFragment;
                ((Fragment)object).mState = n10 = 2;
            }
        }
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    /*
     * Exception decompiling
     */
    public void moveToExpectedState() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [50[CASE]], but top level block is 4[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void pause() {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("movefrom RESUMED: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        this.mFragment.performPause();
        object2 = this.mDispatcher;
        object = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentPaused((Fragment)object, false);
    }

    public void restoreState(ClassLoader object) {
        String string2;
        boolean bl2;
        Object object2 = this.mFragment.mSavedFragmentState;
        if (object2 == null) {
            return;
        }
        object2.setClassLoader((ClassLoader)object);
        object = this.mFragment;
        object2 = ((Fragment)object).mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        ((Fragment)object).mSavedViewState = object2;
        object = this.mFragment;
        object2 = ((Fragment)object).mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        ((Fragment)object).mSavedViewRegistryState = object2;
        object = this.mFragment;
        object2 = ((Fragment)object).mSavedFragmentState;
        String string3 = TARGET_STATE_TAG;
        object2 = object2.getString(string3);
        ((Fragment)object).mTargetWho = object2;
        object = this.mFragment;
        object2 = ((Fragment)object).mTargetWho;
        if (object2 != null) {
            int n10;
            object2 = ((Fragment)object).mSavedFragmentState;
            bl2 = false;
            string3 = null;
            string2 = TARGET_REQUEST_CODE_STATE_TAG;
            ((Fragment)object).mTargetRequestCode = n10 = object2.getInt(string2, 0);
        }
        object = this.mFragment;
        object2 = ((Fragment)object).mSavedUserVisibleHint;
        bl2 = true;
        if (object2 != null) {
            boolean bl3;
            ((Fragment)object).mUserVisibleHint = bl3 = ((Boolean)object2).booleanValue();
            object = this.mFragment;
            boolean bl4 = false;
            object2 = null;
            ((Fragment)object).mSavedUserVisibleHint = null;
        } else {
            boolean bl5;
            object2 = ((Fragment)object).mSavedFragmentState;
            string2 = USER_VISIBLE_HINT_TAG;
            ((Fragment)object).mUserVisibleHint = bl5 = object2.getBoolean(string2, bl2);
        }
        object = this.mFragment;
        boolean bl6 = ((Fragment)object).mUserVisibleHint;
        if (!bl6) {
            ((Fragment)object).mDeferStart = bl2;
        }
    }

    public void resume() {
        boolean bl2;
        Fragment fragment;
        Object object;
        boolean bl3 = FragmentManager.isLoggingEnabled(3);
        String string2 = TAG;
        if (bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("moveto RESUMED: ");
            fragment = this.mFragment;
            ((StringBuilder)object).append(fragment);
            object = ((StringBuilder)object).toString();
            Log.d((String)string2, (String)object);
        }
        if ((object = this.mFragment.getFocusedView()) != null && (bl2 = this.isFragmentViewChild((View)object))) {
            bl2 = object.requestFocus();
            boolean bl4 = FragmentManager.isLoggingEnabled(2);
            if (bl4) {
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "requestFocus: Restoring focused view ";
                stringBuilder.append(string3);
                stringBuilder.append(object);
                object = " ";
                stringBuilder.append((String)object);
                object = bl2 ? "succeeded" : "failed";
                stringBuilder.append((String)object);
                stringBuilder.append(" on Fragment ");
                object = this.mFragment;
                stringBuilder.append(object);
                stringBuilder.append(" resulting in focused view ");
                object = this.mFragment.mView.findFocus();
                stringBuilder.append(object);
                object = stringBuilder.toString();
                Log.v((String)string2, (String)object);
            }
        }
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        object = this.mDispatcher;
        fragment = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object).dispatchOnFragmentResumed(fragment, false);
        object = this.mFragment;
        ((Fragment)object).mSavedFragmentState = null;
        ((Fragment)object).mSavedViewState = null;
        ((Fragment)object).mSavedViewRegistryState = null;
    }

    public Fragment$SavedState saveInstanceState() {
        Fragment fragment = this.mFragment;
        int n10 = fragment.mState;
        Fragment$SavedState fragment$SavedState = null;
        int n11 = -1;
        if (n10 > n11 && (fragment = this.saveBasicState()) != null) {
            fragment$SavedState = new Fragment$SavedState((Bundle)fragment);
        }
        return fragment$SavedState;
    }

    public FragmentState saveState() {
        Object object;
        Fragment fragment = this.mFragment;
        FragmentState fragmentState = new FragmentState(fragment);
        fragment = this.mFragment;
        int n10 = fragment.mState;
        int n11 = -1;
        if (n10 > n11 && (object = fragmentState.mSavedFragmentState) == null) {
            fragment = this.saveBasicState();
            fragmentState.mSavedFragmentState = fragment;
            object = this.mFragment.mTargetWho;
            if (object != null) {
                if (fragment == null) {
                    fragment = new Bundle();
                    fragmentState.mSavedFragmentState = fragment;
                }
                fragment = fragmentState.mSavedFragmentState;
                object = this.mFragment.mTargetWho;
                String string2 = TARGET_STATE_TAG;
                fragment.putString(string2, (String)object);
                fragment = this.mFragment;
                int n12 = fragment.mTargetRequestCode;
                if (n12 != 0) {
                    object = fragmentState.mSavedFragmentState;
                    string2 = TARGET_REQUEST_CODE_STATE_TAG;
                    object.putInt(string2, n12);
                }
            }
        } else {
            fragment = fragment.mSavedFragmentState;
            fragmentState.mSavedFragmentState = fragment;
        }
        return fragmentState;
    }

    public void saveViewState() {
        View view = this.mFragment.mView;
        if (view == null) {
            return;
        }
        view = new SparseArray();
        Object object = this.mFragment.mView;
        object.saveHierarchyState((SparseArray)view);
        int n10 = view.size();
        if (n10 > 0) {
            object = this.mFragment;
            ((Fragment)object).mSavedViewState = view;
        }
        view = new Bundle();
        object = this.mFragment.mViewLifecycleOwner;
        ((FragmentViewLifecycleOwner)object).performSave((Bundle)view);
        n10 = (int)(view.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            object = this.mFragment;
            ((Fragment)object).mSavedViewRegistryState = view;
        }
    }

    public void setFragmentManagerState(int n10) {
        this.mFragmentManagerState = n10;
    }

    public void start() {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("moveto STARTED: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        this.mFragment.performStart();
        object2 = this.mDispatcher;
        object = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentStarted((Fragment)object, false);
    }

    public void stop() {
        Object object;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("movefrom STARTED: ");
            object = this.mFragment;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = TAG;
            Log.d((String)object, (String)object2);
        }
        this.mFragment.performStop();
        object2 = this.mDispatcher;
        object = this.mFragment;
        ((FragmentLifecycleCallbacksDispatcher)object2).dispatchOnFragmentStopped((Fragment)object, false);
    }
}

