/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.app;

import androidx.appcompat.app.ActionBar$Tab;
import androidx.fragment.app.FragmentTransaction;

public interface ActionBar$TabListener {
    public void onTabReselected(ActionBar$Tab var1, FragmentTransaction var2);

    public void onTabSelected(ActionBar$Tab var1, FragmentTransaction var2);

    public void onTabUnselected(ActionBar$Tab var1, FragmentTransaction var2);
}

