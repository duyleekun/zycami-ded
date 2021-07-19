/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextPaint
 *  android.text.style.ClickableSpan
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.e.l;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class t1$a
extends ClickableSpan {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ int b;

    public t1$a(View.OnClickListener onClickListener, int n10) {
        this.a = onClickListener;
        this.b = n10;
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        int n10 = this.b;
        textPaint.setColor(n10);
    }
}

