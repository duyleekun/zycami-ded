/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 */
package com.google.android.material.textfield;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R$attr;
import com.google.android.material.textfield.TextInputLayout;

public class TextInputEditText
extends AppCompatEditText {
    public TextInputEditText(Context context) {
        this(context, null);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.editTextStyle;
        this(context, attributeSet, n10);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    private CharSequence getHintFromLayout() {
        Object object = this.getTextInputLayout();
        object = object != null ? object.getHint() : null;
        return object;
    }

    private TextInputLayout getTextInputLayout() {
        boolean bl2;
        ViewParent viewParent = this.getParent();
        while (bl2 = viewParent instanceof View) {
            bl2 = viewParent instanceof TextInputLayout;
            if (bl2) {
                return (TextInputLayout)viewParent;
            }
            viewParent = viewParent.getParent();
        }
        return null;
    }

    public CharSequence getHint() {
        boolean bl2;
        TextInputLayout textInputLayout = this.getTextInputLayout();
        if (textInputLayout != null && (bl2 = textInputLayout.isProvidingHint())) {
            return textInputLayout.getHint();
        }
        return super.getHint();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        CharSequence charSequence;
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnection != null && (charSequence = editorInfo.hintText) == null) {
            editorInfo.hintText = charSequence = this.getHintFromLayout();
        }
        return inputConnection;
    }
}

