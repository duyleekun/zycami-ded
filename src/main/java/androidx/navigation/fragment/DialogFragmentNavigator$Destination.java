/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package androidx.navigation.fragment;

import android.content.Context;
import android.util.AttributeSet;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.R$styleable;

public class DialogFragmentNavigator$Destination
extends NavDestination
implements FloatingWindow {
    private String mClassName;

    public DialogFragmentNavigator$Destination(Navigator navigator) {
        super(navigator);
    }

    public DialogFragmentNavigator$Destination(NavigatorProvider object) {
        object = ((NavigatorProvider)object).getNavigator(DialogFragmentNavigator.class);
        this((Navigator)object);
    }

    public final String getClassName() {
        Object object = this.mClassName;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("DialogFragment class was not set");
        throw object;
    }

    public void onInflate(Context context, AttributeSet object) {
        super.onInflate(context, (AttributeSet)object);
        context = context.getResources();
        int[] nArray = R$styleable.DialogFragmentNavigator;
        context = context.obtainAttributes(object, nArray);
        int n10 = R$styleable.DialogFragmentNavigator_android_name;
        object = context.getString(n10);
        if (object != null) {
            this.setClassName((String)object);
        }
        context.recycle();
    }

    public final DialogFragmentNavigator$Destination setClassName(String string2) {
        this.mClassName = string2;
        return this;
    }
}

