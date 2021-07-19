/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public final class FragmentTabHost$TabInfo {
    public final Bundle args;
    public final Class clss;
    public Fragment fragment;
    public final String tag;

    public FragmentTabHost$TabInfo(String string2, Class clazz, Bundle bundle) {
        this.tag = string2;
        this.clss = clazz;
        this.args = bundle;
    }
}

