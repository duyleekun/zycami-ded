/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.ui.R$string;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractAppBarOnDestinationChangedListener
implements NavController$OnDestinationChangedListener {
    private ValueAnimator mAnimator;
    private DrawerArrowDrawable mArrowDrawable;
    private final Context mContext;
    private final WeakReference mOpenableLayoutWeakReference;
    private final Set mTopLevelDestinations;

    public AbstractAppBarOnDestinationChangedListener(Context object, AppBarConfiguration weakReference) {
        this.mContext = object;
        object = ((AppBarConfiguration)((Object)weakReference)).getTopLevelDestinations();
        this.mTopLevelDestinations = object;
        object = ((AppBarConfiguration)((Object)weakReference)).getOpenableLayout();
        if (object != null) {
            this.mOpenableLayoutWeakReference = weakReference = new WeakReference<Context>((Context)object);
        } else {
            object = null;
            this.mOpenableLayoutWeakReference = null;
        }
    }

    private void setActionBarUpIndicator(boolean bl2) {
        ObjectAnimator objectAnimator;
        float f10;
        float f11;
        int n10;
        Object object;
        DrawerArrowDrawable drawerArrowDrawable = this.mArrowDrawable;
        int n11 = 1;
        float f12 = Float.MIN_VALUE;
        if (drawerArrowDrawable == null) {
            object = this.mContext;
            this.mArrowDrawable = drawerArrowDrawable = new DrawerArrowDrawable((Context)object);
            n10 = 0;
            drawerArrowDrawable = null;
            f11 = 0.0f;
        } else {
            n10 = n11;
            f11 = f12;
        }
        object = this.mArrowDrawable;
        int n12 = bl2 ? R$string.nav_app_bar_open_drawer_description : R$string.nav_app_bar_navigate_up_description;
        this.setNavigationIcon((Drawable)object, n12);
        if (bl2) {
            boolean bl3 = false;
            f10 = 0.0f;
            objectAnimator = null;
        } else {
            int n13 = 1065353216;
            f10 = 1.0f;
        }
        if (n10 != 0) {
            drawerArrowDrawable = this.mArrowDrawable;
            f11 = drawerArrowDrawable.getProgress();
            object = this.mAnimator;
            if (object != null) {
                object.cancel();
            }
            object = this.mArrowDrawable;
            n12 = 2;
            float[] fArray = new float[n12];
            fArray[0] = f11;
            fArray[n11] = f10;
            objectAnimator = ObjectAnimator.ofFloat((Object)object, (String)"progress", (float[])fArray);
            this.mAnimator = objectAnimator;
            objectAnimator.start();
        } else {
            drawerArrowDrawable = this.mArrowDrawable;
            drawerArrowDrawable.setProgress(f10);
        }
    }

    public void onDestinationChanged(NavController object, NavDestination object2, Bundle bundle) {
        boolean bl2 = object2 instanceof FloatingWindow;
        if (bl2) {
            return;
        }
        Object object3 = this.mOpenableLayoutWeakReference;
        if (object3 != null) {
            object3 = (Openable)((Reference)object3).get();
        } else {
            bl2 = false;
            object3 = null;
        }
        WeakReference weakReference = this.mOpenableLayoutWeakReference;
        if (weakReference != null && object3 == null) {
            ((NavController)object).removeOnDestinationChangedListener(this);
            return;
        }
        object = ((NavDestination)object2).getLabel();
        boolean bl3 = true;
        if (object != null) {
            boolean bl4;
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher((CharSequence)object);
            while (bl4 = matcher.find()) {
                boolean bl5;
                String string2 = matcher.group((int)(bl3 ? 1 : 0));
                if (bundle != null && (bl5 = bundle.containsKey(string2))) {
                    String string3 = "";
                    matcher.appendReplacement(stringBuffer, string3);
                    string2 = bundle.get(string2).toString();
                    stringBuffer.append(string2);
                    continue;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Could not find ");
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(" in ");
                ((StringBuilder)object3).append(bundle);
                ((StringBuilder)object3).append(" to fill label ");
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            matcher.appendTail(stringBuffer);
            this.setTitle(stringBuffer);
        }
        object = this.mTopLevelDestinations;
        boolean bl6 = NavigationUI.matchDestinations((NavDestination)object2, (Set)object);
        object2 = null;
        if (object3 == null && bl6) {
            this.setNavigationIcon(null, 0);
        } else {
            if (object3 == null || !bl6) {
                bl3 = false;
                weakReference = null;
            }
            this.setActionBarUpIndicator(bl3);
        }
    }

    public abstract void setNavigationIcon(Drawable var1, int var2);

    public abstract void setTitle(CharSequence var1);
}

