/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.TabHost$TabContentFactory
 */
package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

public class FragmentTabHost$DummyTabFactory
implements TabHost.TabContentFactory {
    private final Context mContext;

    public FragmentTabHost$DummyTabFactory(Context context) {
        this.mContext = context;
    }

    public View createTabContent(String string2) {
        Context context = this.mContext;
        string2 = new View(context);
        string2.setMinimumWidth(0);
        string2.setMinimumHeight(0);
        return string2;
    }
}

