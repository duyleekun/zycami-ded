/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipboardManager
 */
package com.zhiyun.cama.device.active;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.fragment.app.Fragment;
import com.zhiyun.cama.device.active.ActivationFailFragment;
import d.v.e.l.n2;
import d.v.f.i.g;

public class ActivationFailFragment$b {
    public final /* synthetic */ ActivationFailFragment a;

    public ActivationFailFragment$b(ActivationFailFragment activationFailFragment) {
        this.a = activationFailFragment;
    }

    public void a() {
        Object object = (ClipboardManager)this.a.requireActivity().getSystemService("clipboard");
        Object object2 = this.a;
        int n10 = 2131951719;
        object2 = g.s((Fragment)object2, n10);
        String string2 = "Label";
        object2 = ClipData.newPlainText((CharSequence)string2, (CharSequence)object2);
        if (object != null) {
            object.setPrimaryClip((ClipData)object2);
            object = this.a;
            int n11 = 2131951919;
            object = g.s((Fragment)object, n11);
            n2.e((String)object);
        }
    }
}

