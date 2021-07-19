/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Log
 */
package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;
import androidx.navigation.fragment.DialogFragmentNavigator$1;
import androidx.navigation.fragment.DialogFragmentNavigator$Destination;
import java.util.HashSet;

public final class DialogFragmentNavigator
extends Navigator {
    private static final String DIALOG_TAG = "androidx-nav-fragment:navigator:dialog:";
    private static final String KEY_DIALOG_COUNT = "androidx-nav-dialogfragment:navigator:count";
    private static final String TAG = "DialogFragmentNavigator";
    private final Context mContext;
    private int mDialogCount = 0;
    private final FragmentManager mFragmentManager;
    private LifecycleEventObserver mObserver;
    private final HashSet mRestoredTagsAwaitingAttach;

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        Object object = new HashSet();
        this.mRestoredTagsAwaitingAttach = object;
        this.mObserver = object = new DialogFragmentNavigator$1(this);
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
    }

    public DialogFragmentNavigator$Destination createDestination() {
        DialogFragmentNavigator$Destination dialogFragmentNavigator$Destination = new DialogFragmentNavigator$Destination(this);
        return dialogFragmentNavigator$Destination;
    }

    public NavDestination navigate(DialogFragmentNavigator$Destination object, Bundle object2, NavOptions object3, Navigator$Extras clazz) {
        Class<?> clazz2;
        int n10;
        object3 = this.mFragmentManager;
        boolean bl2 = ((FragmentManager)object3).isStateSaved();
        if (bl2) {
            Log.i((String)TAG, (String)"Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        object3 = ((DialogFragmentNavigator$Destination)object).getClassName();
        clazz = null;
        int n11 = ((String)object3).charAt(0);
        if (n11 == (n10 = 46)) {
            clazz = new StringBuilder();
            clazz2 = this.mContext.getPackageName();
            ((StringBuilder)((Object)clazz)).append((String)((Object)clazz2));
            ((StringBuilder)((Object)clazz)).append((String)object3);
            object3 = ((StringBuilder)((Object)clazz)).toString();
        }
        clazz = this.mFragmentManager.getFragmentFactory();
        clazz2 = this.mContext.getClassLoader();
        clazz = DialogFragment.class;
        n11 = (int)(clazz.isAssignableFrom(clazz2 = (object3 = ((FragmentFactory)((Object)clazz)).instantiate((ClassLoader)((Object)clazz2), (String)object3)).getClass()) ? 1 : 0);
        if (n11 != 0) {
            int n12;
            object3 = (DialogFragment)object3;
            ((Fragment)object3).setArguments((Bundle)object2);
            object2 = ((Fragment)object3).getLifecycle();
            clazz = this.mObserver;
            ((Lifecycle)object2).addObserver((LifecycleObserver)((Object)clazz));
            object2 = this.mFragmentManager;
            clazz = new StringBuilder();
            ((StringBuilder)((Object)clazz)).append(DIALOG_TAG);
            n10 = this.mDialogCount;
            this.mDialogCount = n12 = n10 + 1;
            ((StringBuilder)((Object)clazz)).append(n10);
            clazz = ((StringBuilder)((Object)clazz)).toString();
            ((DialogFragment)object3).show((FragmentManager)object2, (String)((Object)clazz));
            return object;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Dialog destination ");
        object = ((DialogFragmentNavigator$Destination)object).getClassName();
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(" is not an instance of DialogFragment");
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void onAttachFragment(Fragment object) {
        Object object2 = this.mRestoredTagsAwaitingAttach;
        String string2 = ((Fragment)object).getTag();
        boolean bl2 = ((HashSet)object2).remove(string2);
        if (bl2) {
            object = ((Fragment)object).getLifecycle();
            object2 = this.mObserver;
            ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        }
    }

    public void onRestoreState(Bundle object) {
        if (object != null) {
            int n10;
            Object object2 = KEY_DIALOG_COUNT;
            this.mDialogCount = n10 = object.getInt((String)object2, 0);
            for (int i10 = 0; i10 < (n10 = this.mDialogCount); ++i10) {
                object = this.mFragmentManager;
                object2 = new StringBuilder();
                String string2 = DIALOG_TAG;
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(i10);
                object2 = ((StringBuilder)object2).toString();
                object = (DialogFragment)((FragmentManager)object).findFragmentByTag((String)object2);
                if (object != null) {
                    object = ((Fragment)object).getLifecycle();
                    object2 = this.mObserver;
                    ((Lifecycle)object).addObserver((LifecycleObserver)object2);
                    continue;
                }
                object = this.mRestoredTagsAwaitingAttach;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(i10);
                object2 = ((StringBuilder)object2).toString();
                ((HashSet)object).add(object2);
            }
        }
    }

    public Bundle onSaveState() {
        int n10 = this.mDialogCount;
        if (n10 == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        int n11 = this.mDialogCount;
        bundle.putInt(KEY_DIALOG_COUNT, n11);
        return bundle;
    }

    public boolean popBackStack() {
        int n10 = this.mDialogCount;
        Object object = null;
        if (n10 == 0) {
            return false;
        }
        Object object2 = this.mFragmentManager;
        n10 = (int)(((FragmentManager)object2).isStateSaved() ? 1 : 0);
        if (n10 != 0) {
            Log.i((String)TAG, (String)"Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        object2 = this.mFragmentManager;
        object = new StringBuilder();
        Object object3 = DIALOG_TAG;
        ((StringBuilder)object).append((String)object3);
        int n11 = this.mDialogCount;
        int n12 = 1;
        this.mDialogCount = n11 -= n12;
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        object2 = ((FragmentManager)object2).findFragmentByTag((String)object);
        if (object2 != null) {
            object = ((Fragment)object2).getLifecycle();
            object3 = this.mObserver;
            ((Lifecycle)object).removeObserver((LifecycleObserver)object3);
            object2 = (DialogFragment)object2;
            ((DialogFragment)object2).dismiss();
        }
        return n12 != 0;
    }
}

