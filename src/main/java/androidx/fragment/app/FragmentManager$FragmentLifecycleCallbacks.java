/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class FragmentManager$FragmentLifecycleCallbacks {
    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
    }

    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
    }

    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
    }

    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
    }

    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
    }

    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
    }

    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
    }

    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
    }

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
    }

    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
    }

    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
    }

    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
    }

    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
    }
}

