/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentLayoutInflaterFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController;

public class FragmentLayoutInflaterFactory$1
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ FragmentLayoutInflaterFactory this$0;
    public final /* synthetic */ FragmentStateManager val$fragmentStateManager;

    public FragmentLayoutInflaterFactory$1(FragmentLayoutInflaterFactory fragmentLayoutInflaterFactory, FragmentStateManager fragmentStateManager) {
        this.this$0 = fragmentLayoutInflaterFactory;
        this.val$fragmentStateManager = fragmentStateManager;
    }

    public void onViewAttachedToWindow(View object) {
        object = this.val$fragmentStateManager.getFragment();
        this.val$fragmentStateManager.moveToExpectedState();
        object = (ViewGroup)object.mView.getParent();
        FragmentManager fragmentManager = this.this$0.mFragmentManager;
        SpecialEffectsController.getOrCreateController((ViewGroup)object, fragmentManager).forceCompleteAllOperations();
    }

    public void onViewDetachedFromWindow(View view) {
    }
}

