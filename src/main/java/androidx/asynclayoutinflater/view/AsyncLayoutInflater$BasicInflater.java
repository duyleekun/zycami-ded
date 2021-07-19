/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 */
package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class AsyncLayoutInflater$BasicInflater
extends LayoutInflater {
    private static final String[] sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};

    public AsyncLayoutInflater$BasicInflater(Context context) {
        super(context);
    }

    public LayoutInflater cloneInContext(Context context) {
        AsyncLayoutInflater$BasicInflater asyncLayoutInflater$BasicInflater = new AsyncLayoutInflater$BasicInflater(context);
        return asyncLayoutInflater$BasicInflater;
    }

    public View onCreateView(String string2, AttributeSet attributeSet) {
        for (String string3 : sClassPrefixList) {
            try {
                string3 = this.createView(string2, string3, attributeSet);
                if (string3 == null) continue;
                return string3;
            }
            catch (ClassNotFoundException classNotFoundException) {}
        }
        return super.onCreateView(string2, attributeSet);
    }
}

