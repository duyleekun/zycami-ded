/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package com.zhiyun.cama.me.help;

import android.text.Editable;
import android.text.TextWatcher;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment;

public class FeedbackEditAddFragment$a
implements TextWatcher {
    public final /* synthetic */ FeedbackEditAddFragment a;

    public FeedbackEditAddFragment$a(FeedbackEditAddFragment feedbackEditAddFragment) {
        this.a = feedbackEditAddFragment;
    }

    public void afterTextChanged(Editable editable) {
        FeedbackEditAddFragment.j(this.a);
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

