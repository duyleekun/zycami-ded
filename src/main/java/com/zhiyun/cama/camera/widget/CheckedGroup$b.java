/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package com.zhiyun.cama.camera.widget;

import android.widget.CompoundButton;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import com.zhiyun.cama.camera.widget.CheckedGroup$a;

public class CheckedGroup$b
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ CheckedGroup a;

    private CheckedGroup$b(CheckedGroup checkedGroup) {
        this.a = checkedGroup;
    }

    public /* synthetic */ CheckedGroup$b(CheckedGroup checkedGroup, CheckedGroup$a checkedGroup$a) {
        this(checkedGroup);
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean n10) {
        CheckedGroup checkedGroup = this.a;
        n10 = CheckedGroup.a(checkedGroup);
        if (n10 != 0) {
            return;
        }
        CheckedGroup.b(this.a, true);
        checkedGroup = this.a;
        n10 = CheckedGroup.c(checkedGroup);
        int n11 = -1;
        if (n10 != n11) {
            checkedGroup = this.a;
            n11 = CheckedGroup.c(checkedGroup);
            CheckedGroup.d(checkedGroup, n11, false);
        }
        CheckedGroup.b(this.a, false);
        int n12 = compoundButton.getId();
        CheckedGroup.e(this.a, n12, false);
    }
}

