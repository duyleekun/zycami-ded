/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.R$styleable;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.R$id;

public class NavHostFragment
extends Fragment
implements NavHost {
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
    private static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
    private static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean mDefaultNavHost;
    private int mGraphId;
    private Boolean mIsPrimaryBeforeOnCreate = null;
    private NavHostController mNavController;
    private View mViewParent;

    public static NavHostFragment create(int n10) {
        return NavHostFragment.create(n10, null);
    }

    public static NavHostFragment create(int n10, Bundle bundle) {
        Object object;
        Object object2;
        if (n10 != 0) {
            object2 = new Bundle();
            String string2 = KEY_GRAPH_ID;
            object2.putInt(string2, n10);
        } else {
            object2 = null;
        }
        if (bundle != null) {
            if (object2 == null) {
                object = new Bundle();
                object2 = object;
            }
            object = KEY_START_DESTINATION_ARGS;
            object2.putBundle((String)object, bundle);
        }
        object = new NavHostFragment();
        if (object2 != null) {
            ((Fragment)object).setArguments((Bundle)object2);
        }
        return object;
    }

    public static NavController findNavController(Fragment object) {
        Object object2;
        Object object3;
        for (object3 = object; object3 != null; object3 = ((Fragment)object3).getParentFragment()) {
            boolean bl2 = object3 instanceof NavHostFragment;
            if (bl2) {
                return ((NavHostFragment)object3).getNavController();
            }
            object2 = ((Fragment)object3).getParentFragmentManager().getPrimaryNavigationFragment();
            boolean bl3 = object2 instanceof NavHostFragment;
            if (!bl3) continue;
            return ((NavHostFragment)object2).getNavController();
        }
        object3 = ((Fragment)object).getView();
        if (object3 != null) {
            return Navigation.findNavController((View)object3);
        }
        boolean bl4 = object instanceof DialogFragment;
        if (bl4) {
            object3 = object;
            object3 = ((DialogFragment)object).getDialog();
        } else {
            bl4 = false;
            object3 = null;
        }
        if (object3 != null && (object2 = object3.getWindow()) != null) {
            return Navigation.findNavController(object3.getWindow().getDecorView());
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Fragment ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" does not have a NavController set");
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalStateException((String)object);
        throw object3;
    }

    private int getContainerId() {
        int n10;
        int n11 = this.getId();
        if (n11 != 0 && n11 != (n10 = -1)) {
            return n11;
        }
        return R$id.nav_host_fragment_container;
    }

    public Navigator createFragmentNavigator() {
        Context context = this.requireContext();
        FragmentManager fragmentManager = this.getChildFragmentManager();
        int n10 = this.getContainerId();
        FragmentNavigator fragmentNavigator = new FragmentNavigator(context, fragmentManager, n10);
        return fragmentNavigator;
    }

    public final NavController getNavController() {
        Object object = this.mNavController;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("NavController is not available before onCreate()");
        throw object;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        boolean bl2 = this.mDefaultNavHost;
        if (bl2) {
            object = this.getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this);
            ((FragmentTransaction)object).commit();
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        ((DialogFragmentNavigator)this.mNavController.getNavigatorProvider().getNavigator(DialogFragmentNavigator.class)).onAttachFragment(fragment);
    }

    public void onCreate(Bundle bundle) {
        Object object;
        int n10;
        Object object2 = this.requireContext();
        Object object3 = new NavHostController((Context)object2);
        this.mNavController = object3;
        ((NavHostController)object3).setLifecycleOwner(this);
        object2 = this.mNavController;
        object3 = this.requireActivity().getOnBackPressedDispatcher();
        ((NavHostController)object2).setOnBackPressedDispatcher((OnBackPressedDispatcher)object3);
        object2 = this.mNavController;
        object3 = this.mIsPrimaryBeforeOnCreate;
        int n11 = 1;
        int n12 = 0;
        if (object3 != null && (n10 = ((Boolean)object3).booleanValue()) != 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object3 = null;
        }
        ((NavHostController)object2).enableOnBackPressed(n10 != 0);
        object2 = null;
        this.mIsPrimaryBeforeOnCreate = null;
        object3 = this.mNavController;
        ViewModelStore viewModelStore = this.getViewModelStore();
        ((NavHostController)object3).setViewModelStore(viewModelStore);
        object3 = this.mNavController;
        this.onCreateNavController((NavController)object3);
        object3 = KEY_GRAPH_ID;
        if (bundle != null) {
            viewModelStore = bundle.getBundle(KEY_NAV_CONTROLLER_STATE);
            String string2 = KEY_DEFAULT_NAV_HOST;
            boolean bl2 = bundle.getBoolean(string2, false);
            if (bl2) {
                this.mDefaultNavHost = n11;
                object = this.getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this);
                ((FragmentTransaction)object).commit();
            }
            this.mGraphId = n11 = bundle.getInt((String)object3);
        } else {
            viewModelStore = null;
        }
        if (viewModelStore != null) {
            object = this.mNavController;
            ((NavController)object).restoreState((Bundle)viewModelStore);
        }
        if ((n11 = this.mGraphId) != 0) {
            object2 = this.mNavController;
            ((NavController)object2).setGraph(n11);
        } else {
            object = this.getArguments();
            if (object != null) {
                n12 = object.getInt((String)object3);
            }
            if (object != null) {
                object2 = object.getBundle(KEY_START_DESTINATION_ARGS);
            }
            if (n12 != 0) {
                object3 = this.mNavController;
                ((NavController)object3).setGraph(n12, (Bundle)object2);
            }
        }
        super.onCreate(bundle);
    }

    public void onCreateNavController(NavController object) {
        Object object2 = ((NavController)object).getNavigatorProvider();
        Context context = this.requireContext();
        FragmentManager fragmentManager = this.getChildFragmentManager();
        DialogFragmentNavigator dialogFragmentNavigator = new DialogFragmentNavigator(context, fragmentManager);
        ((NavigatorProvider)object2).addNavigator(dialogFragmentNavigator);
        object = ((NavController)object).getNavigatorProvider();
        object2 = this.createFragmentNavigator();
        ((NavigatorProvider)object).addNavigator((Navigator)object2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup object, Bundle bundle) {
        layoutInflater = layoutInflater.getContext();
        object = new FragmentContainerView((Context)layoutInflater);
        int n10 = this.getContainerId();
        object.setId(n10);
        return object;
    }

    public void onDestroyView() {
        NavHostController navHostController;
        super.onDestroyView();
        Object object = this.mViewParent;
        if (object != null && (object = Navigation.findNavController(object)) == (navHostController = this.mNavController)) {
            object = this.mViewParent;
            Navigation.setViewNavController(object, null);
        }
        this.mViewParent = null;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle object) {
        super.onInflate(context, attributeSet, (Bundle)object);
        object = R$styleable.NavHost;
        object = context.obtainStyledAttributes(attributeSet, (int[])object);
        int n10 = R$styleable.NavHost_navGraph;
        n10 = object.getResourceId(n10, 0);
        if (n10 != 0) {
            this.mGraphId = n10;
        }
        object.recycle();
        object = androidx.navigation.fragment.R$styleable.NavHostFragment;
        context = context.obtainStyledAttributes(attributeSet, (int[])object);
        int n11 = androidx.navigation.fragment.R$styleable.NavHostFragment_defaultNavHost;
        n11 = (int)(context.getBoolean(n11, false) ? 1 : 0);
        if (n11 != 0) {
            n11 = 1;
            this.mDefaultNavHost = n11;
        }
        context.recycle();
    }

    public void onPrimaryNavigationFragmentChanged(boolean bl2) {
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            navHostController.enableOnBackPressed(bl2);
        } else {
            Boolean bl3;
            this.mIsPrimaryBeforeOnCreate = bl3 = Boolean.valueOf(bl2);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        int n10;
        String string2;
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = this.mNavController.saveState();
        if (bundle2 != null) {
            string2 = KEY_NAV_CONTROLLER_STATE;
            bundle.putBundle(string2, bundle2);
        }
        if ((n10 = this.mDefaultNavHost) != 0) {
            n10 = 1;
            string2 = KEY_DEFAULT_NAV_HOST;
            bundle.putBoolean(string2, n10 != 0);
        }
        if ((n10 = this.mGraphId) != 0) {
            string2 = KEY_GRAPH_ID;
            bundle.putInt(string2, n10);
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        int n10 = object instanceof ViewGroup;
        if (n10 != 0) {
            object2 = this.mNavController;
            Navigation.setViewNavController(object, (NavController)object2);
            object2 = object.getParent();
            if (object2 != null) {
                this.mViewParent = object = (View)object.getParent();
                int n11 = object.getId();
                if (n11 == (n10 = this.getId())) {
                    object = this.mViewParent;
                    object2 = this.mNavController;
                    Navigation.setViewNavController(object, (NavController)object2);
                }
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("created host view ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a ViewGroup");
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }
}

