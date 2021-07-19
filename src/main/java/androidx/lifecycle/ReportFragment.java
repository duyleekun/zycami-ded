/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleRegistryOwner;
import androidx.lifecycle.ReportFragment$ActivityInitializationListener;
import androidx.lifecycle.ReportFragment$LifecycleCallbacks;

public class ReportFragment
extends Fragment {
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ReportFragment$ActivityInitializationListener mProcessListener;

    public static void dispatch(Activity object, Lifecycle$Event lifecycle$Event) {
        boolean bl2 = object instanceof LifecycleRegistryOwner;
        if (bl2) {
            ((LifecycleRegistryOwner)object).getLifecycle().handleLifecycleEvent(lifecycle$Event);
            return;
        }
        bl2 = object instanceof LifecycleOwner;
        if (bl2 && (bl2 = (object = ((LifecycleOwner)object).getLifecycle()) instanceof LifecycleRegistry)) {
            object = (LifecycleRegistry)object;
            ((LifecycleRegistry)object).handleLifecycleEvent(lifecycle$Event);
        }
    }

    private void dispatch(Lifecycle$Event lifecycle$Event) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 < n11) {
            Activity activity = this.getActivity();
            ReportFragment.dispatch(activity, lifecycle$Event);
        }
    }

    private void dispatchCreate(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        if (reportFragment$ActivityInitializationListener != null) {
            reportFragment$ActivityInitializationListener.onCreate();
        }
    }

    private void dispatchResume(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        if (reportFragment$ActivityInitializationListener != null) {
            reportFragment$ActivityInitializationListener.onResume();
        }
    }

    private void dispatchStart(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        if (reportFragment$ActivityInitializationListener != null) {
            reportFragment$ActivityInitializationListener.onStart();
        }
    }

    public static ReportFragment get(Activity activity) {
        return (ReportFragment)activity.getFragmentManager().findFragmentByTag(REPORT_FRAGMENT_TAG);
    }

    public static void injectIfNeededIn(Activity activity) {
        String string2;
        Fragment fragment;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            ReportFragment$LifecycleCallbacks.registerIn(activity);
        }
        if ((fragment = (activity = activity.getFragmentManager()).findFragmentByTag(string2 = REPORT_FRAGMENT_TAG)) == null) {
            fragment = activity.beginTransaction();
            ReportFragment reportFragment = new ReportFragment();
            string2 = fragment.add((Fragment)reportFragment, string2);
            string2.commit();
            activity.executePendingTransactions();
        }
    }

    public void onActivityCreated(Bundle object) {
        super.onActivityCreated(object);
        object = this.mProcessListener;
        this.dispatchCreate((ReportFragment$ActivityInitializationListener)object);
        object = Lifecycle$Event.ON_CREATE;
        this.dispatch((Lifecycle$Event)((Object)object));
    }

    public void onDestroy() {
        super.onDestroy();
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_DESTROY;
        this.dispatch(lifecycle$Event);
        this.mProcessListener = null;
    }

    public void onPause() {
        super.onPause();
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_PAUSE;
        this.dispatch(lifecycle$Event);
    }

    public void onResume() {
        super.onResume();
        Object object = this.mProcessListener;
        this.dispatchResume((ReportFragment$ActivityInitializationListener)object);
        object = Lifecycle$Event.ON_RESUME;
        this.dispatch((Lifecycle$Event)((Object)object));
    }

    public void onStart() {
        super.onStart();
        Object object = this.mProcessListener;
        this.dispatchStart((ReportFragment$ActivityInitializationListener)object);
        object = Lifecycle$Event.ON_START;
        this.dispatch((Lifecycle$Event)((Object)object));
    }

    public void onStop() {
        super.onStop();
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
        this.dispatch(lifecycle$Event);
    }

    public void setProcessListener(ReportFragment$ActivityInitializationListener reportFragment$ActivityInitializationListener) {
        this.mProcessListener = reportFragment$ActivityInitializationListener;
    }
}

