/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 */
package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar$OnNavigationListener;

public class NavItemSelectedListener
implements AdapterView.OnItemSelectedListener {
    private final ActionBar$OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar$OnNavigationListener actionBar$OnNavigationListener) {
        this.mListener = actionBar$OnNavigationListener;
    }

    public void onItemSelected(AdapterView object, View view, int n10, long l10) {
        object = this.mListener;
        if (object != null) {
            object.onNavigationItemSelected(n10, l10);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}

