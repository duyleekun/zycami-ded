/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import d.v.c.y1.f.p;

public class p$c
extends FragmentStateAdapter {
    public final /* synthetic */ p a;

    public p$c(p p10, Fragment fragment) {
        this.a = p10;
        super(fragment);
    }

    public Fragment createFragment(int n10) {
        return p.y(this.a)[n10];
    }

    public int getItemCount() {
        return p.y(this.a).length;
    }
}

