/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextHelper;

public class AppCompatTextHelper$2
implements Runnable {
    public final /* synthetic */ AppCompatTextHelper this$0;
    public final /* synthetic */ int val$style;
    public final /* synthetic */ TextView val$textView;
    public final /* synthetic */ Typeface val$typeface;

    public AppCompatTextHelper$2(AppCompatTextHelper appCompatTextHelper, TextView textView, Typeface typeface, int n10) {
        this.this$0 = appCompatTextHelper;
        this.val$textView = textView;
        this.val$typeface = typeface;
        this.val$style = n10;
    }

    public void run() {
        TextView textView = this.val$textView;
        Typeface typeface = this.val$typeface;
        int n10 = this.val$style;
        textView.setTypeface(typeface, n10);
    }
}

