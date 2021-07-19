/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.widget.TextView
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.zhiyun.cama.widget.BackEditText$a;

public class BackEditText
extends AppCompatEditText {
    private BackEditText$a a;

    public BackEditText(Context context) {
        super(context);
    }

    public BackEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BackEditText(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public boolean onKeyPreIme(int n10, KeyEvent keyEvent) {
        BackEditText$a backEditText$a;
        int n11 = 4;
        if (n10 == n11 && (backEditText$a = this.a) != null) {
            backEditText$a.a((TextView)this);
        }
        return false;
    }

    public void setBackListener(BackEditText$a backEditText$a) {
        this.a = backEditText$a;
    }
}

