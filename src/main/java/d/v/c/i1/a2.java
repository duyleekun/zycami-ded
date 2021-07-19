/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package d.v.c.i1;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener;
import com.zhiyun.cama.main.MainFragment;

public final class a2
implements BottomNavigationView$OnNavigationItemSelectedListener {
    public final /* synthetic */ MainFragment a;

    public /* synthetic */ a2(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return MainFragment.S(this.a, menuItem);
    }
}

