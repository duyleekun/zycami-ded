/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package androidx.navigation.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.transition.TransitionManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;

public class CollapsingToolbarOnDestinationChangedListener
extends AbstractAppBarOnDestinationChangedListener {
    private final WeakReference mCollapsingToolbarLayoutWeakReference;
    private final WeakReference mToolbarWeakReference;

    public CollapsingToolbarOnDestinationChangedListener(CollapsingToolbarLayout object, Toolbar toolbar, AppBarConfiguration weakReference) {
        Context context = object.getContext();
        super(context, (AppBarConfiguration)((Object)weakReference));
        this.mCollapsingToolbarLayoutWeakReference = weakReference = new WeakReference<CollapsingToolbarLayout>((CollapsingToolbarLayout)((Object)object));
        super(toolbar);
        this.mToolbarWeakReference = object;
    }

    public void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)((Object)this.mCollapsingToolbarLayoutWeakReference.get());
        Toolbar toolbar = (Toolbar)((Object)this.mToolbarWeakReference.get());
        if (collapsingToolbarLayout != null && toolbar != null) {
            super.onDestinationChanged(navController, navDestination, bundle);
            return;
        }
        navController.removeOnDestinationChangedListener(this);
    }

    public void setNavigationIcon(Drawable drawable2, int n10) {
        Toolbar toolbar = (Toolbar)((Object)this.mToolbarWeakReference.get());
        if (toolbar != null) {
            boolean bl2;
            Drawable drawable3;
            if (drawable2 == null && (drawable3 = toolbar.getNavigationIcon()) != null) {
                bl2 = true;
            } else {
                bl2 = false;
                drawable3 = null;
            }
            toolbar.setNavigationIcon(drawable2);
            toolbar.setNavigationContentDescription(n10);
            if (bl2) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)((Object)this.mCollapsingToolbarLayoutWeakReference.get());
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(charSequence);
        }
    }
}

