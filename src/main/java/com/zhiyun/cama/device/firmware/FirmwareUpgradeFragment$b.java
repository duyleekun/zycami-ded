/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.device.firmware;

import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment;
import d.v.c.y0.c.d;
import d.v.c.z0.k$b;
import d.v.f.g.b;
import d.v.f.i.g;
import d.v.g.g.c1;

public class FirmwareUpgradeFragment$b {
    public final /* synthetic */ FirmwareUpgradeFragment a;

    public FirmwareUpgradeFragment$b(FirmwareUpgradeFragment firmwareUpgradeFragment) {
        this.a = firmwareUpgradeFragment;
    }

    private /* synthetic */ void d(DialogFragment dialogFragment) {
        FirmwareUpgradeFragment.m(this.a).Q(false);
        FirmwareUpgradeFragment.m(this.a).R();
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void b() {
        block9: {
            int n10;
            Object object;
            block6: {
                block8: {
                    int n11;
                    block7: {
                        object = (Integer)FirmwareUpgradeFragment.l(this.a).p().getValue();
                        n10 = d.v.e.h.d.d((Integer)object, n11 = -1);
                        if (n10 == 0 || n10 == (n11 = 2)) break block6;
                        n11 = 4;
                        if (n10 == n11) break block7;
                        n11 = 6;
                        if (n10 == n11 || n10 == (n11 = 9)) break block8;
                        n11 = 10;
                        if (n10 == n11) {
                            object = FirmwareUpgradeFragment.p(this.a).e();
                            n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                            if (n11 == 0) {
                                FirmwareUpgradeFragment firmwareUpgradeFragment = this.a;
                                FirmwareUpgradeFragment.q(firmwareUpgradeFragment, (String)object, false);
                            } else {
                                this.a();
                            }
                        }
                        break block9;
                    }
                    object = FirmwareUpgradeFragment.p(this.a).f();
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                    if (n11 == 0) {
                        FirmwareUpgradeFragment.q(this.a, (String)object, true);
                        return;
                    }
                }
                object = this.a;
                FirmwareUpgradeFragment.r((FirmwareUpgradeFragment)object);
                break block9;
            }
            object = FirmwareUpgradeFragment.m(this.a);
            n10 = (int)(((c1)object).u() ? 1 : 0);
            if (n10 != 0) {
                object = this.a;
                FirmwareUpgradeFragment.n((FirmwareUpgradeFragment)object);
            } else {
                object = this.a;
                FirmwareUpgradeFragment.o((FirmwareUpgradeFragment)object);
            }
        }
    }

    public void c() {
        Object object = new k$b();
        Object object2 = g.o(this.a.getResources(), 2131951977);
        object = ((k$b)object).y((String)object2);
        object2 = g.o(this.a.getResources(), 2131951833);
        object = ((k$b)object).D((String)object2, null);
        object2 = g.o(this.a.getResources(), 2131952621);
        d d10 = new d(this);
        object = ((k$b)object).G((String)object2, d10).v();
        object2 = this.a.getChildFragmentManager();
        ((b)object).q((FragmentManager)object2);
    }

    public /* synthetic */ void e(DialogFragment dialogFragment) {
        this.d(dialogFragment);
    }
}

