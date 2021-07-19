/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 */
package com.zhiyun.account.me.account.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.zhiyun.account.me.account.widget.InputCodeView;

public class InputCodeView$b
extends AppCompatEditText {
    private long a;
    public final /* synthetic */ InputCodeView b;

    public InputCodeView$b(InputCodeView inputCodeView, Context context) {
        this.b = inputCodeView;
        super(context);
        this.a = 0L;
    }

    public InputCodeView$b(InputCodeView inputCodeView, Context context, AttributeSet attributeSet) {
        this.b = inputCodeView;
        super(context, attributeSet);
        this.a = 0L;
    }

    public InputCodeView$b(InputCodeView inputCodeView, Context context, AttributeSet attributeSet, int n10) {
        this.b = inputCodeView;
        super(context, attributeSet, n10);
        this.a = 0L;
    }

    public void onSelectionChanged(int n10, int n11) {
        super.onSelectionChanged(n10, n11);
        n10 = this.getText().length();
        this.setSelection(n10);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.a;
            long l12 = 500L;
            long l13 = (l11 = l10 - l11) - l12;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object < 0) {
                this.a = l10;
                return true;
            }
            this.a = l10;
        }
        return super.onTouchEvent(motionEvent);
    }
}

