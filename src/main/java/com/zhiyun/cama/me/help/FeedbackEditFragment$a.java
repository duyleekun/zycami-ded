/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 */
package com.zhiyun.cama.me.help;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.zhiyun.cama.me.help.FeedbackEditFragment;
import com.zhiyun.cama.me.help.FeedbackEditFragment$b;
import com.zhiyun.cama.me.help.data.FeedbackSet$Type;

public class FeedbackEditFragment$a
implements TextWatcher {
    public final /* synthetic */ FeedbackEditFragment a;

    public FeedbackEditFragment$a(FeedbackEditFragment feedbackEditFragment) {
        this.a = feedbackEditFragment;
    }

    public void afterTextChanged(Editable object) {
        object = (FeedbackSet$Type)((Object)FeedbackEditFragment.j((FeedbackEditFragment)this.a).p.getValue());
        if (object != null) {
            boolean bl2;
            int[] nArray = FeedbackEditFragment$b.a;
            int bl22 = object.ordinal();
            boolean bl3 = nArray[bl22];
            if (bl3 != (bl2 = true)) {
                boolean bl4 = 2 != 0;
                if (bl3 != bl4) {
                    boolean bl5;
                    boolean bl6 = 3 != 0;
                    if (bl3 == bl6 || bl3 == (bl5 = 4 != 0)) {
                        object = FeedbackEditFragment.l((FeedbackEditFragment)this.a).l;
                        String string2 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).d.getText().toString().trim();
                        boolean bl7 = TextUtils.isEmpty((CharSequence)string2);
                        object.setEnabled(bl2 ^= bl7);
                    }
                } else {
                    object = FeedbackEditFragment.l((FeedbackEditFragment)this.a).l;
                    String string3 = FeedbackEditFragment.l((FeedbackEditFragment)this.a).e.getText().toString().trim();
                    int n10 = TextUtils.isEmpty((CharSequence)string3);
                    object.setEnabled(bl2 ^= n10);
                }
            } else {
                object = this.a;
                FeedbackEditFragment.k((FeedbackEditFragment)object);
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

