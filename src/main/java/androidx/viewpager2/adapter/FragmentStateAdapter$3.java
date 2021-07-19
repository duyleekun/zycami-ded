/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.FrameLayout
 */
package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentStateAdapter$3
extends FragmentManager$FragmentLifecycleCallbacks {
    public final /* synthetic */ FragmentStateAdapter this$0;
    public final /* synthetic */ FrameLayout val$container;
    public final /* synthetic */ Fragment val$fragment;

    public FragmentStateAdapter$3(FragmentStateAdapter fragmentStateAdapter, Fragment fragment, FrameLayout frameLayout) {
        this.this$0 = fragmentStateAdapter;
        this.val$fragment = fragment;
        this.val$container = frameLayout;
    }

    public void onFragmentViewCreated(FragmentManager object, Fragment fragment, View view, Bundle object2) {
        object2 = this.val$fragment;
        if (fragment == object2) {
            ((FragmentManager)object).unregisterFragmentLifecycleCallbacks(this);
            object = this.this$0;
            fragment = this.val$container;
            ((FragmentStateAdapter)object).addViewToContainer(view, (FrameLayout)fragment);
        }
    }
}

