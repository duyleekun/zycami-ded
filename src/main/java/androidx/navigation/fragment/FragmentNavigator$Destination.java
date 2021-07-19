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
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.R$styleable;

public class FragmentNavigator$Destination
extends NavDestination {
    private String mClassName;

    public FragmentNavigator$Destination(Navigator navigator) {
        super(navigator);
    }

    public FragmentNavigator$Destination(NavigatorProvider object) {
        object = ((NavigatorProvider)object).getNavigator(FragmentNavigator.class);
        this((Navigator)object);
    }

    public final String getClassName() {
        Object object = this.mClassName;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Fragment class was not set");
        throw object;
    }

    public void onInflate(Context context, AttributeSet object) {
        super.onInflate(context, (AttributeSet)object);
        context = context.getResources();
        int[] nArray = R$styleable.FragmentNavigator;
        context = context.obtainAttributes(object, nArray);
        int n10 = R$styleable.FragmentNavigator_android_name;
        object = context.getString(n10);
        if (object != null) {
            this.setClassName((String)object);
        }
        context.recycle();
    }

    public final FragmentNavigator$Destination setClassName(String string2) {
        this.mClassName = string2;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append(" class=");
        string2 = this.mClassName;
        if (string2 == null) {
            string2 = "null";
            stringBuilder.append(string2);
        } else {
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

