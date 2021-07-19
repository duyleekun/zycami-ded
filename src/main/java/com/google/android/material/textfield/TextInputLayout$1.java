/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayout$1
implements TextWatcher {
    public final /* synthetic */ TextInputLayout this$0;

    public TextInputLayout$1(TextInputLayout textInputLayout) {
        this.this$0 = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.this$0;
        boolean bl2 = TextInputLayout.access$000(textInputLayout) ^ true;
        textInputLayout.updateLabelState(bl2);
        textInputLayout = this.this$0;
        bl2 = textInputLayout.counterEnabled;
        if (bl2) {
            int n10 = editable.length();
            textInputLayout.updateCounter(n10);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

