/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristic
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl23;

public class AppCompatTextViewAutoSizeHelper$Impl29
extends AppCompatTextViewAutoSizeHelper$Impl23 {
    public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        textView = textView.getTextDirectionHeuristic();
        builder.setTextDirection((TextDirectionHeuristic)textView);
    }

    public boolean isHorizontallyScrollable(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}

