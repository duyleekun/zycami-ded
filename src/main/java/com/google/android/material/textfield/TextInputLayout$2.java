/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.material.textfield;

import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputLayout$2
implements View.OnClickListener {
    public final /* synthetic */ TextInputLayout this$0;

    public TextInputLayout$2(TextInputLayout textInputLayout) {
        this.this$0 = textInputLayout;
    }

    public void onClick(View view) {
        this.this$0.passwordVisibilityToggleRequested(false);
    }
}

