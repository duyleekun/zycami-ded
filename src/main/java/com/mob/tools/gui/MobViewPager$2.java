/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.gui.MobViewPager;

public class MobViewPager$2
implements Runnable {
    public final /* synthetic */ MobViewPager this$0;
    public final /* synthetic */ boolean val$immediate;
    public final /* synthetic */ int val$whichScreen;

    public MobViewPager$2(MobViewPager mobViewPager, int n10, boolean bl2) {
        this.this$0 = mobViewPager;
        this.val$whichScreen = n10;
        this.val$immediate = bl2;
    }

    public void run() {
        MobViewPager mobViewPager = this.this$0;
        int n10 = this.val$whichScreen;
        boolean bl2 = this.val$immediate;
        MobViewPager.access$000(mobViewPager, n10, bl2);
    }
}

