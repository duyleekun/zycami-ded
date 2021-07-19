/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 */
package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavAction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController$1;
import androidx.navigation.NavController$2;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestination$DeepLinkMatch;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.NavInflater;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptions$Builder;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;
import androidx.navigation.NavigatorProvider;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private Activity mActivity;
    public final Deque mBackStack;
    private Parcelable[] mBackStackToRestore;
    private final Context mContext;
    private boolean mDeepLinkHandled;
    private boolean mEnableOnBackPressedCallback;
    public NavGraph mGraph;
    private NavInflater mInflater;
    private final LifecycleObserver mLifecycleObserver;
    private LifecycleOwner mLifecycleOwner;
    private NavigatorProvider mNavigatorProvider;
    private Bundle mNavigatorStateToRestore;
    private final OnBackPressedCallback mOnBackPressedCallback;
    private final CopyOnWriteArrayList mOnDestinationChangedListeners;
    private NavControllerViewModel mViewModel;

    public NavController(Context object) {
        boolean bl2;
        Object object2 = new ArrayDeque();
        this.mBackStack = object2;
        this.mNavigatorProvider = object2 = new NavigatorProvider();
        object2 = new CopyOnWriteArrayList();
        this.mOnDestinationChangedListeners = object2;
        this.mLifecycleObserver = object2 = new NavController$1(this);
        Context context = null;
        this.mOnBackPressedCallback = object2 = new NavController$2(this, false);
        this.mEnableOnBackPressedCallback = bl2 = true;
        this.mContext = object;
        while (bl2 = object instanceof ContextWrapper) {
            bl2 = object instanceof Activity;
            if (bl2) {
                object = (Activity)object;
                this.mActivity = object;
                break;
            }
            object = ((ContextWrapper)object).getBaseContext();
        }
        object = this.mNavigatorProvider;
        object2 = new NavGraphNavigator((NavigatorProvider)object);
        ((NavigatorProvider)object).addNavigator((Navigator)object2);
        object = this.mNavigatorProvider;
        context = this.mContext;
        object2 = new ActivityNavigator(context);
        ((NavigatorProvider)object).addNavigator((Navigator)object2);
    }

    private boolean dispatchOnDestinationChanged() {
        Object object;
        boolean bl2;
        int n10;
        do {
            object = this.mBackStack;
            n10 = object.isEmpty();
            bl2 = true;
            if (n10 != 0 || (n10 = (object = ((NavBackStackEntry)this.mBackStack.peekLast()).getDestination()) instanceof NavGraph) == 0) break;
            object = ((NavBackStackEntry)this.mBackStack.peekLast()).getDestination();
            n10 = ((NavDestination)object).getId();
        } while ((n10 = (int)(this.popBackStackInternal(n10, bl2) ? 1 : 0)) != 0);
        if ((n10 = (object = this.mBackStack).isEmpty()) == 0) {
            NavBackStackEntry navBackStackEntry;
            boolean bl3;
            Object object2;
            Object object3;
            object = ((NavBackStackEntry)this.mBackStack.peekLast()).getDestination();
            boolean bl4 = false;
            Object object4 = null;
            boolean bl5 = object instanceof FloatingWindow;
            if (bl5) {
                boolean bl6;
                object3 = this.mBackStack.descendingIterator();
                while (bl6 = object3.hasNext()) {
                    object2 = ((NavBackStackEntry)object3.next()).getDestination();
                    bl3 = object2 instanceof NavGraph;
                    if (bl3 || (bl3 = object2 instanceof FloatingWindow)) continue;
                    object4 = object2;
                    break;
                }
            }
            object3 = new HashMap();
            object2 = this.mBackStack.descendingIterator();
            while (bl3 = object2.hasNext()) {
                int n11;
                int n12;
                int n13;
                navBackStackEntry = (NavBackStackEntry)object2.next();
                Lifecycle$State lifecycle$State = navBackStackEntry.getMaxLifecycle();
                Object object5 = navBackStackEntry.getDestination();
                if (object != null && (n13 = object5.getId()) == (n12 = ((NavDestination)object).getId())) {
                    object5 = Lifecycle$State.RESUMED;
                    if (lifecycle$State != object5) {
                        ((HashMap)object3).put(navBackStackEntry, object5);
                    }
                    object = ((NavDestination)object).getParent();
                    continue;
                }
                if (object4 != null && (n11 = object5.getId()) == (n13 = ((NavDestination)object4).getId())) {
                    object5 = Lifecycle$State.RESUMED;
                    if (lifecycle$State == object5) {
                        lifecycle$State = Lifecycle$State.STARTED;
                        navBackStackEntry.setMaxLifecycle(lifecycle$State);
                    } else {
                        object5 = Lifecycle$State.STARTED;
                        if (lifecycle$State != object5) {
                            ((HashMap)object3).put(navBackStackEntry, object5);
                        }
                    }
                    object4 = ((NavDestination)object4).getParent();
                    continue;
                }
                lifecycle$State = Lifecycle$State.CREATED;
                navBackStackEntry.setMaxLifecycle(lifecycle$State);
            }
            object = this.mBackStack.iterator();
            while (bl4 = object.hasNext()) {
                object4 = (NavBackStackEntry)object.next();
                object2 = (Lifecycle$State)((Object)((HashMap)object3).get(object4));
                if (object2 != null) {
                    ((NavBackStackEntry)object4).setMaxLifecycle((Lifecycle$State)((Object)object2));
                    continue;
                }
                ((NavBackStackEntry)object4).updateState();
            }
            object = (NavBackStackEntry)this.mBackStack.peekLast();
            object4 = this.mOnDestinationChangedListeners.iterator();
            while (bl5 = object4.hasNext()) {
                object3 = (NavController$OnDestinationChangedListener)object4.next();
                object2 = ((NavBackStackEntry)object).getDestination();
                navBackStackEntry = ((NavBackStackEntry)object).getArguments();
                object3.onDestinationChanged(this, (NavDestination)object2, (Bundle)navBackStackEntry);
            }
            return bl2;
        }
        return false;
    }

    private String findInvalidDestinationDisplayNameInDeepLink(int[] nArray) {
        NavDestination navDestination = this.mGraph;
        int n10 = 0;
        while (true) {
            int n11 = nArray.length;
            NavDestination navDestination2 = null;
            if (n10 >= n11) break;
            n11 = nArray[n10];
            if (n10 == 0) {
                NavGraph navGraph = this.mGraph;
                int n12 = navGraph.getId();
                if (n12 == n11) {
                    navDestination2 = this.mGraph;
                }
            } else {
                navDestination2 = navDestination.findNode(n11);
            }
            if (navDestination2 == null) {
                return NavDestination.getDisplayName(this.mContext, n11);
            }
            n11 = nArray.length + -1;
            if (n10 != n11) {
                navDestination2 = (NavGraph)navDestination2;
                while (true) {
                    int n13 = ((NavGraph)navDestination2).getStartDestination();
                    navDestination = ((NavGraph)navDestination2).findNode(n13);
                    if ((n13 = navDestination instanceof NavGraph) == 0) break;
                    n13 = ((NavGraph)navDestination2).getStartDestination();
                    navDestination = ((NavGraph)navDestination2).findNode(n13);
                    navDestination2 = navDestination;
                    navDestination2 = navDestination;
                }
                navDestination = navDestination2;
            }
            ++n10;
        }
        return null;
    }

    private int getDestinationCountOnBackStack() {
        boolean bl2;
        Iterator iterator2 = this.mBackStack.iterator();
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            NavDestination navDestination = ((NavBackStackEntry)iterator2.next()).getDestination();
            bl2 = navDestination instanceof NavGraph;
            if (bl2) continue;
            ++n10;
        }
        return n10;
    }

    /*
     * WARNING - void declaration
     */
    private void navigate(NavDestination object, Bundle object2, NavOptions object3, Navigator$Extras object4) {
        void var6_10;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5 = false;
        if (object3 != null && (bl4 = ((NavOptions)object3).getPopUpTo()) != (bl3 = -1 != 0)) {
            int n10 = ((NavOptions)object3).getPopUpTo();
            bl3 = ((NavOptions)object3).isPopUpToInclusive();
            boolean bl6 = this.popBackStackInternal(n10, bl3);
        } else {
            boolean bl7 = false;
        }
        Object object5 = this.mNavigatorProvider;
        Object object6 = ((NavDestination)object).getNavigatorName();
        object5 = ((NavigatorProvider)object5).getNavigator((String)object6);
        object2 = ((NavDestination)object).addInDefaultArgs((Bundle)object2);
        object4 = ((Navigator)object5).navigate((NavDestination)object, (Bundle)object2, (NavOptions)object3, (Navigator$Extras)object4);
        bl3 = true;
        if (object4 != null) {
            boolean bl8;
            Object object7;
            Object object8;
            NavControllerViewModel navControllerViewModel;
            LifecycleOwner lifecycleOwner;
            Context context;
            Object object9;
            int n11 = object4 instanceof FloatingWindow;
            if (n11 == 0) {
                while ((n11 = (object3 = this.mBackStack).isEmpty()) == 0 && (n11 = (object3 = ((NavBackStackEntry)this.mBackStack.peekLast()).getDestination()) instanceof FloatingWindow) != 0) {
                    object3 = ((NavBackStackEntry)this.mBackStack.peekLast()).getDestination();
                    n11 = ((NavDestination)object3).getId();
                    if ((n11 = (int)(this.popBackStackInternal(n11, bl3) ? 1 : 0)) != 0) continue;
                }
            }
            object3 = new ArrayDeque();
            int n12 = object instanceof NavGraph;
            if (n12 != 0) {
                object6 = object4;
                while (true) {
                    if ((object9 = ((NavDestination)object6).getParent()) != null) {
                        NavBackStackEntry navBackStackEntry;
                        context = this.mContext;
                        lifecycleOwner = this.mLifecycleOwner;
                        navControllerViewModel = this.mViewModel;
                        object6 = navBackStackEntry;
                        object8 = object9;
                        object7 = object2;
                        navBackStackEntry = new NavBackStackEntry(context, (NavDestination)object9, (Bundle)object2, lifecycleOwner, navControllerViewModel);
                        ((ArrayDeque)object3).addFirst(navBackStackEntry);
                        object6 = this.mBackStack;
                        n12 = (int)(object6.isEmpty() ? 1 : 0);
                        if (n12 == 0 && (object6 = ((NavBackStackEntry)this.mBackStack.getLast()).getDestination()) == object9) {
                            n12 = ((NavDestination)object9).getId();
                            this.popBackStackInternal(n12, bl3);
                        }
                    }
                    if (object9 == null || object9 == object) break;
                    object6 = object9;
                }
            }
            object = (bl8 = ((ArrayDeque)object3).isEmpty()) ? object4 : ((NavBackStackEntry)((ArrayDeque)object3).getFirst()).getDestination();
            while (object != null && (object6 = this.findDestination(n12 = ((NavDestination)object).getId())) == null) {
                if ((object = ((NavDestination)object).getParent()) == null) continue;
                context = this.mContext;
                lifecycleOwner = this.mLifecycleOwner;
                navControllerViewModel = this.mViewModel;
                object6 = object9;
                object8 = object;
                object7 = object2;
                object9 = new NavBackStackEntry(context, (NavDestination)object, (Bundle)object2, lifecycleOwner, navControllerViewModel);
                ((ArrayDeque)object3).addFirst(object9);
            }
            bl8 = ((ArrayDeque)object3).isEmpty();
            object = bl8 ? object4 : ((NavBackStackEntry)((ArrayDeque)object3).getLast()).getDestination();
            while ((n12 = (int)((object6 = this.mBackStack).isEmpty() ? 1 : 0)) == 0 && (n12 = (object6 = ((NavBackStackEntry)this.mBackStack.getLast()).getDestination()) instanceof NavGraph) != 0) {
                object6 = (NavGraph)((NavBackStackEntry)this.mBackStack.getLast()).getDestination();
                int n13 = ((NavDestination)object).getId();
                if ((object6 = ((NavGraph)object6).findNode(n13, false)) != null) break;
                object6 = ((NavBackStackEntry)this.mBackStack.getLast()).getDestination();
                n12 = ((NavDestination)object6).getId();
                if ((n12 = (int)(this.popBackStackInternal(n12, bl3) ? 1 : 0)) != 0) continue;
            }
            this.mBackStack.addAll(object3);
            object = this.mBackStack;
            bl8 = object.isEmpty();
            if (bl8 || (object = ((NavBackStackEntry)this.mBackStack.getFirst()).getDestination()) != (object3 = this.mGraph)) {
                context = this.mContext;
                object8 = this.mGraph;
                lifecycleOwner = this.mLifecycleOwner;
                navControllerViewModel = this.mViewModel;
                object6 = object;
                object7 = object2;
                object = new NavBackStackEntry(context, (NavDestination)object8, (Bundle)object2, lifecycleOwner, navControllerViewModel);
                object3 = this.mBackStack;
                object3.addFirst(object);
            }
            context = this.mContext;
            object7 = ((NavDestination)object4).addInDefaultArgs((Bundle)object2);
            lifecycleOwner = this.mLifecycleOwner;
            navControllerViewModel = this.mViewModel;
            object6 = object;
            object8 = object4;
            object = new NavBackStackEntry(context, (NavDestination)object4, (Bundle)object7, lifecycleOwner, navControllerViewModel);
            object2 = this.mBackStack;
            object2.add(object);
        } else if (object3 != null && (bl2 = ((NavOptions)object3).shouldLaunchSingleTop())) {
            object = (NavBackStackEntry)this.mBackStack.peekLast();
            if (object != null) {
                ((NavBackStackEntry)object).replaceArguments((Bundle)object2);
            }
            bl5 = bl3;
        }
        this.updateOnBackPressedCallbackEnabled();
        if (var6_10 != false || object4 != null || bl5) {
            this.dispatchOnDestinationChanged();
        }
    }

    private void onGraphCreated(Bundle bundle) {
        boolean bl2;
        Object object;
        int n10;
        Object object2;
        NavController navController = this;
        Object object3 = this.mNavigatorStateToRestore;
        if (object3 != null && (object3 = object3.getStringArrayList((String)(object2 = KEY_NAVIGATOR_STATE_NAMES))) != null) {
            object3 = ((ArrayList)object3).iterator();
            while ((n10 = object3.hasNext()) != 0) {
                object2 = (String)object3.next();
                object = navController.mNavigatorProvider.getNavigator((String)object2);
                Bundle bundle2 = navController.mNavigatorStateToRestore;
                if ((object2 = bundle2.getBundle((String)object2)) == null) continue;
                ((Navigator)object).onRestoreState((Bundle)object2);
            }
        }
        object3 = navController.mBackStackToRestore;
        n10 = 0;
        object2 = null;
        object = null;
        if (object3 != null) {
            int n11 = ((Object)object3).length;
            for (int i10 = 0; i10 < n11; ++i10) {
                Object object4 = (NavBackStackEntryState)object3[i10];
                int n12 = ((NavBackStackEntryState)object4).getDestinationId();
                NavDestination navDestination = navController.findDestination(n12);
                if (navDestination != null) {
                    Object object5;
                    Bundle bundle3 = ((NavBackStackEntryState)object4).getArgs();
                    if (bundle3 != null) {
                        object5 = navController.mContext.getClassLoader();
                        bundle3.setClassLoader((ClassLoader)object5);
                    }
                    Context context = navController.mContext;
                    LifecycleOwner lifecycleOwner = navController.mLifecycleOwner;
                    NavControllerViewModel navControllerViewModel = navController.mViewModel;
                    UUID uUID = ((NavBackStackEntryState)object4).getUUID();
                    Bundle bundle4 = ((NavBackStackEntryState)object4).getSavedState();
                    object5 = new NavBackStackEntry(context, navDestination, bundle3, lifecycleOwner, navControllerViewModel, uUID, bundle4);
                    object4 = navController.mBackStack;
                    object4.add(object5);
                    continue;
                }
                object3 = navController.mContext;
                n10 = ((NavBackStackEntryState)object4).getDestinationId();
                object3 = NavDestination.getDisplayName((Context)object3, n10);
                object = new StringBuilder();
                ((StringBuilder)object).append("Restoring the Navigation back stack failed: destination ");
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(" cannot be found from the current destination ");
                object3 = this.getCurrentDestination();
                ((StringBuilder)object).append(object3);
                object3 = ((StringBuilder)object).toString();
                object2 = new IllegalStateException((String)object3);
                throw object2;
            }
            this.updateOnBackPressedCallbackEnabled();
            navController.mBackStackToRestore = null;
        }
        if ((object3 = navController.mGraph) != null && (bl2 = (object3 = navController.mBackStack).isEmpty())) {
            bl2 = navController.mDeepLinkHandled;
            if (!bl2 && (object3 = navController.mActivity) != null && (bl2 = navController.handleDeepLink((Intent)(object3 = object3.getIntent())))) {
                n10 = 1;
            }
            if (n10 == 0) {
                object3 = navController.mGraph;
                object2 = bundle;
                navController.navigate((NavDestination)object3, bundle, null, null);
            }
        } else {
            this.dispatchOnDestinationChanged();
        }
    }

    private void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        int n10 = this.mEnableOnBackPressedCallback;
        int n11 = 1;
        if (n10 == 0 || (n10 = this.getDestinationCountOnBackStack()) <= n11) {
            n11 = 0;
        }
        onBackPressedCallback.setEnabled(n11 != 0);
    }

    public void addOnDestinationChangedListener(NavController$OnDestinationChangedListener navController$OnDestinationChangedListener) {
        Object object = this.mBackStack;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            object = (NavBackStackEntry)this.mBackStack.peekLast();
            NavDestination navDestination = ((NavBackStackEntry)object).getDestination();
            object = ((NavBackStackEntry)object).getArguments();
            navController$OnDestinationChangedListener.onDestinationChanged(this, navDestination, (Bundle)object);
        }
        this.mOnDestinationChangedListeners.add(navController$OnDestinationChangedListener);
    }

    public NavDeepLinkBuilder createDeepLink() {
        NavDeepLinkBuilder navDeepLinkBuilder = new NavDeepLinkBuilder(this);
        return navDeepLinkBuilder;
    }

    public void enableOnBackPressed(boolean bl2) {
        this.mEnableOnBackPressedCallback = bl2;
        this.updateOnBackPressedCallbackEnabled();
    }

    public NavDestination findDestination(int n10) {
        Object object = this.mGraph;
        if (object == null) {
            return null;
        }
        int n11 = ((NavDestination)object).getId();
        if (n11 == n10) {
            return this.mGraph;
        }
        object = this.mBackStack;
        n11 = (int)(object.isEmpty() ? 1 : 0);
        object = n11 != 0 ? this.mGraph : ((NavBackStackEntry)this.mBackStack.getLast()).getDestination();
        boolean bl2 = object instanceof NavGraph;
        object = bl2 ? (NavGraph)object : ((NavDestination)object).getParent();
        return ((NavGraph)object).findNode(n10);
    }

    public Deque getBackStack() {
        return this.mBackStack;
    }

    public NavBackStackEntry getBackStackEntry(int n10) {
        Object object;
        Object object2;
        block2: {
            boolean bl2;
            object2 = this.mBackStack.descendingIterator();
            while (bl2 = object2.hasNext()) {
                object = (NavBackStackEntry)object2.next();
                NavDestination navDestination = ((NavBackStackEntry)object).getDestination();
                int n11 = navDestination.getId();
                if (n11 != n10) continue;
                break block2;
            }
            bl2 = false;
            object = null;
        }
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No destination with ID ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is on the NavController's back stack. The current destination is ");
        Object object3 = this.getCurrentDestination();
        ((StringBuilder)object).append(object3);
        object3 = ((StringBuilder)object).toString();
        object2 = new IllegalArgumentException((String)object3);
        throw object2;
    }

    public Context getContext() {
        return this.mContext;
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        Deque deque = this.mBackStack;
        boolean bl2 = deque.isEmpty();
        if (bl2) {
            return null;
        }
        return (NavBackStackEntry)this.mBackStack.getLast();
    }

    public NavDestination getCurrentDestination() {
        Object object = this.getCurrentBackStackEntry();
        object = object != null ? ((NavBackStackEntry)object).getDestination() : null;
        return object;
    }

    public NavGraph getGraph() {
        Object object = this.mGraph;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("You must call setGraph() before calling getGraph()");
        throw object;
    }

    public NavInflater getNavInflater() {
        NavInflater navInflater = this.mInflater;
        if (navInflater == null) {
            Context context = this.mContext;
            NavigatorProvider navigatorProvider = this.mNavigatorProvider;
            this.mInflater = navInflater = new NavInflater(context, navigatorProvider);
        }
        return this.mInflater;
    }

    public NavigatorProvider getNavigatorProvider() {
        return this.mNavigatorProvider;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator iterator2 = this.mBackStack.descendingIterator();
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            iterator2.next();
        }
        while (bl2 = iterator2.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry)iterator2.next();
            NavDestination navDestination = navBackStackEntry.getDestination();
            boolean bl3 = navDestination instanceof NavGraph;
            if (bl3) continue;
            return navBackStackEntry;
        }
        return null;
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int n10) {
        Object object = this.mViewModel;
        if (object != null) {
            object = this.getBackStackEntry(n10);
            Object object2 = ((NavBackStackEntry)object).getDestination();
            boolean bl2 = object2 instanceof NavGraph;
            if (bl2) {
                return object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("No NavGraph with ID ");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append(" is on the NavController's back stack");
            String string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
        throw illegalStateException;
    }

    public boolean handleDeepLink(Intent object) {
        Object object2;
        Object object3;
        String string2 = null;
        if (object == null) {
            return false;
        }
        Object object4 = object.getExtras();
        Serializable serializable = null;
        Object object5 = object4 != null ? object4.getIntArray(KEY_DEEP_LINK_IDS) : null;
        Bundle bundle = new Bundle();
        if (object4 != null) {
            object3 = KEY_DEEP_LINK_EXTRAS;
            object4 = object4.getBundle((String)object3);
        } else {
            object2 = 0;
            object4 = null;
        }
        if (object4 != null) {
            bundle.putAll((Bundle)object4);
        }
        if ((object5 == null || (object2 = ((int[])object5).length) == 0) && (object4 = object.getData()) != null) {
            object4 = this.mGraph;
            object3 = new NavDeepLinkRequest((Intent)object);
            if ((object4 = ((NavGraph)object4).matchDeepLink((NavDeepLinkRequest)object3)) != null) {
                object5 = ((NavDestination$DeepLinkMatch)object4).getDestination();
                object3 = object5.buildDeepLinkIds();
                object4 = ((NavDestination$DeepLinkMatch)object4).getMatchingArgs();
                object4 = object5.addInDefaultArgs((Bundle)object4);
                bundle.putAll((Bundle)object4);
                object5 = object3;
            }
        }
        if (object5 != null && (object2 = ((int[])object5).length) != 0) {
            Object object6;
            object4 = this.findInvalidDestinationDisplayNameInDeepLink((int[])object5);
            if (object4 != null) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("Could not find destination ");
                ((StringBuilder)serializable).append((String)object4);
                ((StringBuilder)serializable).append(" in the navigation graph, ignoring the deep link from ");
                ((StringBuilder)serializable).append(object);
                object = ((StringBuilder)serializable).toString();
                Log.i((String)TAG, (String)object);
                return false;
            }
            object4 = KEY_DEEP_LINK_INTENT;
            bundle.putParcelable((String)object4, (Parcelable)object);
            object2 = object.getFlags();
            Object object7 = 0x10000000 & object2;
            int n10 = 1;
            if (object7 != 0 && (object2 &= (object6 = 32768)) == 0) {
                object.addFlags(object6);
                object4 = TaskStackBuilder.create(this.mContext);
                ((TaskStackBuilder)object4).addNextIntentWithParentStack((Intent)object).startActivities();
                object = this.mActivity;
                if (object != null) {
                    object.finish();
                    object = this.mActivity;
                    object.overridePendingTransition(0, 0);
                }
                return n10 != 0;
            }
            object = "Deep Linking failed: destination ";
            if (object7 != 0) {
                object4 = this.mBackStack;
                object2 = object4.isEmpty();
                if (object2 == 0) {
                    object4 = this.mGraph;
                    object2 = ((NavDestination)object4).getId();
                    this.popBackStackInternal((int)object2, n10 != 0);
                }
                object2 = 0;
                object4 = null;
                while (object2 < (object7 = ((Object)object5).length)) {
                    object7 = object2 + 1;
                    NavDestination navDestination = this.findDestination((int)(object2 = (Object)object5[object2]));
                    if (navDestination != null) {
                        object4 = new NavOptions$Builder();
                        object4 = ((NavOptions$Builder)object4).setEnterAnim(0).setExitAnim(0).build();
                        this.navigate(navDestination, bundle, (NavOptions)object4, null);
                        object2 = object7;
                        continue;
                    }
                    string2 = NavDestination.getDisplayName(this.mContext, object2);
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append((String)object);
                    ((StringBuilder)serializable).append(string2);
                    ((StringBuilder)serializable).append(" cannot be found from the current destination ");
                    object = this.getCurrentDestination();
                    ((StringBuilder)serializable).append(object);
                    object = ((StringBuilder)serializable).toString();
                    object4 = new IllegalStateException((String)object);
                    throw object4;
                }
                return n10 != 0;
            }
            object4 = this.mGraph;
            object3 = null;
            for (object7 = 0; object7 < (object6 = ((Object)object5).length); ++object7) {
                object6 = object5[object7];
                Object object8 = object7 == 0 ? this.mGraph : ((NavGraph)object4).findNode((int)object6);
                if (object8 != null) {
                    object6 = ((Object)object5).length - n10;
                    if (object7 != object6) {
                        while (true) {
                            object2 = ((NavGraph)object8).getStartDestination();
                            object4 = ((NavGraph)object8).findNode((int)object2);
                            if ((object2 = object4 instanceof NavGraph) == 0) break;
                            object2 = ((NavGraph)object8).getStartDestination();
                            object8 = object4 = ((NavGraph)object8).findNode((int)object2);
                            object8 = (NavGraph)object4;
                        }
                        object4 = object8;
                        continue;
                    }
                    Bundle bundle2 = ((NavDestination)object8).addInDefaultArgs(bundle);
                    Object object9 = new NavOptions$Builder();
                    NavGraph navGraph = this.mGraph;
                    int n11 = navGraph.getId();
                    object9 = ((NavOptions$Builder)object9).setPopUpTo(n11, n10 != 0).setEnterAnim(0).setExitAnim(0).build();
                    this.navigate((NavDestination)object8, bundle2, (NavOptions)object9, null);
                    continue;
                }
                string2 = NavDestination.getDisplayName(this.mContext, object6);
                object5 = new StringBuilder();
                object5.append((String)object);
                object5.append(string2);
                object5.append(" cannot be found in graph ");
                object5.append(object4);
                object = object5.toString();
                serializable = new IllegalStateException((String)object);
                throw serializable;
            }
            this.mDeepLinkHandled = n10;
            return n10 != 0;
        }
        return false;
    }

    public void navigate(int n10) {
        this.navigate(n10, null);
    }

    public void navigate(int n10, Bundle bundle) {
        this.navigate(n10, bundle, null);
    }

    public void navigate(int n10, Bundle bundle, NavOptions navOptions) {
        this.navigate(n10, bundle, navOptions, null);
    }

    public void navigate(int n10, Bundle object, NavOptions object2, Navigator$Extras object3) {
        Object object4 = this.mBackStack;
        boolean bl2 = object4.isEmpty();
        object4 = bl2 ? this.mGraph : ((NavBackStackEntry)this.mBackStack.getLast()).getDestination();
        if (object4 != null) {
            boolean bl3;
            boolean bl4;
            int n11;
            Object object5 = ((NavDestination)object4).getAction(n10);
            Bundle bundle = null;
            if (object5 != null) {
                if (object2 == null) {
                    object2 = ((NavAction)object5).getNavOptions();
                }
                n11 = ((NavAction)object5).getDestinationId();
                Bundle bundle2 = ((NavAction)object5).getDefaultArguments();
                if (bundle2 != null) {
                    bundle = new Bundle();
                    bundle.putAll(bundle2);
                }
            } else {
                n11 = n10;
            }
            if (object != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putAll(object);
            }
            if (n11 == 0 && object2 != null && (bl4 = ((NavOptions)object2).getPopUpTo()) != (bl3 = -1 != 0)) {
                n10 = ((NavOptions)object2).getPopUpTo();
                bl4 = ((NavOptions)object2).isPopUpToInclusive();
                this.popBackStack(n10, bl4);
                return;
            }
            if (n11 != 0) {
                object = this.findDestination(n11);
                if (object == null) {
                    object = NavDestination.getDisplayName(this.mContext, n11);
                    object2 = " cannot be found from the current destination ";
                    if (object5 != null) {
                        object5 = new StringBuilder();
                        ((StringBuilder)object5).append("Navigation destination ");
                        ((StringBuilder)object5).append((String)object);
                        ((StringBuilder)object5).append(" referenced from action ");
                        String string2 = NavDestination.getDisplayName(this.mContext, n10);
                        ((StringBuilder)object5).append(string2);
                        ((StringBuilder)object5).append((String)object2);
                        ((StringBuilder)object5).append(object4);
                        string2 = ((StringBuilder)object5).toString();
                        object3 = new IllegalArgumentException(string2);
                        throw object3;
                    }
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Navigation action/destination ");
                    ((StringBuilder)object3).append((String)object);
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append(object4);
                    object = ((StringBuilder)object3).toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                this.navigate((NavDestination)object, bundle, (NavOptions)object2, (Navigator$Extras)object3);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            throw illegalArgumentException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("no current navigation node");
        throw illegalStateException;
    }

    public void navigate(Uri uri) {
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(uri, null, null);
        this.navigate(navDeepLinkRequest);
    }

    public void navigate(Uri uri, NavOptions navOptions) {
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(uri, null, null);
        this.navigate(navDeepLinkRequest, navOptions);
    }

    public void navigate(Uri uri, NavOptions navOptions, Navigator$Extras navigator$Extras) {
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(uri, null, null);
        this.navigate(navDeepLinkRequest, navOptions, navigator$Extras);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest) {
        this.navigate(navDeepLinkRequest, null);
    }

    public void navigate(NavDeepLinkRequest navDeepLinkRequest, NavOptions navOptions) {
        this.navigate(navDeepLinkRequest, navOptions, null);
    }

    public void navigate(NavDeepLinkRequest object, NavOptions object2, Navigator$Extras object3) {
        Object object4 = this.mGraph.matchDeepLink((NavDeepLinkRequest)object);
        if (object4 != null) {
            NavDestination navDestination = ((NavDestination$DeepLinkMatch)object4).getDestination();
            Bundle bundle = ((NavDestination$DeepLinkMatch)object4).getMatchingArgs();
            if ((navDestination = navDestination.addInDefaultArgs(bundle)) == null) {
                navDestination = new Bundle();
            }
            object4 = ((NavDestination$DeepLinkMatch)object4).getDestination();
            bundle = new Intent();
            Uri uri = ((NavDeepLinkRequest)object).getUri();
            String string2 = ((NavDeepLinkRequest)object).getMimeType();
            bundle.setDataAndType(uri, string2);
            object = ((NavDeepLinkRequest)object).getAction();
            bundle.setAction((String)object);
            navDestination.putParcelable(KEY_DEEP_LINK_INTENT, (Parcelable)bundle);
            this.navigate((NavDestination)object4, (Bundle)navDestination, (NavOptions)object2, (Navigator$Extras)object3);
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Navigation destination that matches request ");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(" cannot be found in the navigation graph ");
        object = this.mGraph;
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void navigate(NavDirections navDirections) {
        int n10 = navDirections.getActionId();
        navDirections = navDirections.getArguments();
        this.navigate(n10, (Bundle)navDirections);
    }

    public void navigate(NavDirections navDirections, NavOptions navOptions) {
        int n10 = navDirections.getActionId();
        navDirections = navDirections.getArguments();
        this.navigate(n10, (Bundle)navDirections, navOptions);
    }

    public void navigate(NavDirections navDirections, Navigator$Extras navigator$Extras) {
        int n10 = navDirections.getActionId();
        navDirections = navDirections.getArguments();
        this.navigate(n10, (Bundle)navDirections, null, navigator$Extras);
    }

    public boolean navigateUp() {
        int n10;
        int n11 = this.getDestinationCountOnBackStack();
        if (n11 == (n10 = 1)) {
            NavDestination navDestination = this.getCurrentDestination();
            int n12 = navDestination.getId();
            for (navDestination = navDestination.getParent(); navDestination != null; navDestination = navDestination.getParent()) {
                int n13 = ((NavGraph)navDestination).getStartDestination();
                if (n13 != n12) {
                    Bundle bundle = new Bundle();
                    Object object = this.mActivity;
                    if (object != null && (object = object.getIntent()) != null && (object = this.mActivity.getIntent().getData()) != null) {
                        object = this.mActivity.getIntent();
                        bundle.putParcelable(KEY_DEEP_LINK_INTENT, (Parcelable)object);
                        object = this.mGraph;
                        Intent intent = this.mActivity.getIntent();
                        Object object2 = new NavDeepLinkRequest(intent);
                        object = ((NavGraph)object).matchDeepLink((NavDeepLinkRequest)object2);
                        if (object != null) {
                            object2 = ((NavDestination$DeepLinkMatch)object).getDestination();
                            object = ((NavDestination$DeepLinkMatch)object).getMatchingArgs();
                            object = ((NavDestination)object2).addInDefaultArgs((Bundle)object);
                            bundle.putAll((Bundle)object);
                        }
                    }
                    object = new NavDeepLinkBuilder(this);
                    n11 = navDestination.getId();
                    ((NavDeepLinkBuilder)object).setDestination(n11).setArguments(bundle).createTaskStackBuilder().startActivities();
                    navDestination = this.mActivity;
                    if (navDestination != null) {
                        navDestination.finish();
                    }
                    return n10 != 0;
                }
                n12 = navDestination.getId();
            }
            return false;
        }
        return this.popBackStack();
    }

    public boolean popBackStack() {
        Deque deque = this.mBackStack;
        int n10 = deque.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.getCurrentDestination().getId();
        return this.popBackStack(n10, true);
    }

    public boolean popBackStack(int n10, boolean bl2) {
        n10 = (n10 = (int)(this.popBackStackInternal(n10, bl2) ? 1 : 0)) != 0 && (n10 = (int)(this.dispatchOnDestinationChanged() ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean popBackStackInternal(int n10, boolean bl2) {
        Object object;
        boolean bl3;
        Lifecycle$State lifecycle$State;
        boolean bl4;
        boolean bl5;
        Object object2;
        block7: {
            block6: {
                NavDestination navDestination;
                int n11;
                object2 = this.mBackStack;
                bl5 = object2.isEmpty();
                bl4 = false;
                lifecycle$State = null;
                if (bl5) {
                    return false;
                }
                object2 = new ArrayList();
                Iterator iterator2 = this.mBackStack.descendingIterator();
                do {
                    int n12;
                    n11 = iterator2.hasNext();
                    bl3 = true;
                    if (n11 == 0) break block6;
                    navDestination = ((NavBackStackEntry)iterator2.next()).getDestination();
                    Object object3 = this.mNavigatorProvider;
                    String string2 = navDestination.getNavigatorName();
                    object3 = ((NavigatorProvider)object3).getNavigator(string2);
                    if (!bl2 && (n12 = navDestination.getId()) == n10) continue;
                    ((ArrayList)object2).add((Object)object3);
                } while ((n11 = navDestination.getId()) != n10);
                bl2 = bl3;
                break block7;
            }
            bl2 = false;
            object = null;
        }
        if (!bl2) {
            String string3 = NavDestination.getDisplayName(this.mContext, n10);
            object = new StringBuilder();
            ((StringBuilder)object).append("Ignoring popBackStack to destination ");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(" as it was not found on the current back stack");
            string3 = ((StringBuilder)object).toString();
            Log.i((String)TAG, (String)string3);
            return false;
        }
        Iterator iterator3 = ((ArrayList)object2).iterator();
        while ((bl2 = iterator3.hasNext()) && (bl2 = ((Navigator)(object = (Navigator)iterator3.next())).popBackStack())) {
            object = (NavBackStackEntry)this.mBackStack.removeLast();
            object2 = ((NavBackStackEntry)object).getLifecycle().getCurrentState();
            bl5 = ((Lifecycle$State)((Object)object2)).isAtLeast(lifecycle$State = Lifecycle$State.CREATED);
            if (bl5) {
                object2 = Lifecycle$State.DESTROYED;
                ((NavBackStackEntry)object).setMaxLifecycle((Lifecycle$State)((Object)object2));
            }
            if ((object2 = this.mViewModel) != null) {
                object = ((NavBackStackEntry)object).mId;
                ((NavControllerViewModel)object2).clear((UUID)object);
            }
            bl4 = bl3;
        }
        this.updateOnBackPressedCallbackEnabled();
        return bl4;
    }

    public void removeOnDestinationChangedListener(NavController$OnDestinationChangedListener navController$OnDestinationChangedListener) {
        this.mOnDestinationChangedListeners.remove(navController$OnDestinationChangedListener);
    }

    public void restoreState(Bundle bundle) {
        boolean bl2;
        if (bundle == null) {
            return;
        }
        Parcelable[] parcelableArray = this.mContext.getClassLoader();
        bundle.setClassLoader((ClassLoader)parcelableArray);
        parcelableArray = bundle.getBundle(KEY_NAVIGATOR_STATE);
        this.mNavigatorStateToRestore = parcelableArray;
        parcelableArray = bundle.getParcelableArray(KEY_BACK_STACK);
        this.mBackStackToRestore = parcelableArray;
        this.mDeepLinkHandled = bl2 = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    public Bundle saveState() {
        boolean bl2;
        Object object;
        Iterator iterator2;
        boolean bl22;
        Bundle bundle = new ArrayList();
        Object object2 = new Bundle();
        Object object3 = this.mNavigatorProvider.getNavigators().entrySet().iterator();
        while (bl22 = object3.hasNext()) {
            iterator2 = object3.next();
            object = (String)iterator2.getKey();
            if ((iterator2 = ((Navigator)iterator2.getValue()).onSaveState()) == null) continue;
            bundle.add((String)object);
            object2.putBundle((String)object, (Bundle)iterator2);
        }
        boolean bl3 = bundle.isEmpty();
        if (!bl3) {
            object3 = new Bundle();
            iterator2 = KEY_NAVIGATOR_STATE_NAMES;
            object2.putStringArrayList((String)((Object)iterator2), bundle);
            bundle = KEY_NAVIGATOR_STATE;
            object3.putBundle((String)bundle, object2);
        } else {
            bl3 = false;
            object3 = null;
        }
        bundle = this.mBackStack;
        boolean bl4 = bundle.isEmpty();
        if (!bl4) {
            boolean bl5;
            if (object3 == null) {
                object3 = bundle = new Bundle();
            }
            int n10 = this.mBackStack.size();
            bundle = new Parcelable[n10];
            int n11 = 0;
            object2 = null;
            iterator2 = this.mBackStack.iterator();
            while (bl5 = iterator2.hasNext()) {
                object = (NavBackStackEntry)iterator2.next();
                int n12 = n11 + 1;
                NavBackStackEntryState navBackStackEntryState = new NavBackStackEntryState((NavBackStackEntry)object);
                bundle[n11] = navBackStackEntryState;
                n11 = n12;
            }
            object2 = KEY_BACK_STACK;
            object3.putParcelableArray((String)object2, (Parcelable[])bundle);
        }
        if (bl2 = this.mDeepLinkHandled) {
            if (object3 == null) {
                object3 = bundle = new Bundle();
            }
            boolean bl6 = this.mDeepLinkHandled;
            object2 = KEY_DEEP_LINK_HANDLED;
            object3.putBoolean((String)object2, bl6);
        }
        return object3;
    }

    public void setGraph(int n10) {
        this.setGraph(n10, null);
    }

    public void setGraph(int n10, Bundle bundle) {
        NavGraph navGraph = this.getNavInflater().inflate(n10);
        this.setGraph(navGraph, bundle);
    }

    public void setGraph(NavGraph navGraph) {
        this.setGraph(navGraph, null);
    }

    public void setGraph(NavGraph navGraph, Bundle bundle) {
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 != null) {
            int n10 = navGraph2.getId();
            boolean bl2 = true;
            this.popBackStackInternal(n10, bl2);
        }
        this.mGraph = navGraph;
        this.onGraphCreated(bundle);
    }

    public void setLifecycleOwner(LifecycleOwner object) {
        Object object2 = this.mLifecycleOwner;
        if (object == object2) {
            return;
        }
        this.mLifecycleOwner = object;
        object = object.getLifecycle();
        object2 = this.mLifecycleObserver;
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
    }

    public void setNavigatorProvider(NavigatorProvider object) {
        Deque deque = this.mBackStack;
        boolean bl2 = deque.isEmpty();
        if (bl2) {
            this.mNavigatorProvider = object;
            return;
        }
        object = new IllegalStateException("NavigatorProvider must be set before setGraph call");
        throw object;
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher object) {
        Object object2 = this.mLifecycleOwner;
        if (object2 != null) {
            this.mOnBackPressedCallback.remove();
            object2 = this.mLifecycleOwner;
            OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
            ((OnBackPressedDispatcher)object).addCallback((LifecycleOwner)object2, onBackPressedCallback);
            object = this.mLifecycleOwner.getLifecycle();
            object2 = this.mLifecycleObserver;
            ((Lifecycle)object).removeObserver((LifecycleObserver)object2);
            object = this.mLifecycleOwner.getLifecycle();
            object2 = this.mLifecycleObserver;
            ((Lifecycle)object).addObserver((LifecycleObserver)object2);
            return;
        }
        object = new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        throw object;
    }

    public void setViewModelStore(ViewModelStore object) {
        Object object2 = this.mViewModel;
        NavControllerViewModel navControllerViewModel = NavControllerViewModel.getInstance((ViewModelStore)object);
        if (object2 == navControllerViewModel) {
            return;
        }
        object2 = this.mBackStack;
        boolean bl2 = object2.isEmpty();
        if (bl2) {
            this.mViewModel = object = NavControllerViewModel.getInstance((ViewModelStore)object);
            return;
        }
        object = new IllegalStateException("ViewModelStore should be set before setGraph call");
        throw object;
    }
}

