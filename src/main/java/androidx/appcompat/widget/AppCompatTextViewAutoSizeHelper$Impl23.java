/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl;

public class AppCompatTextViewAutoSizeHelper$Impl23
extends AppCompatTextViewAutoSizeHelper$Impl {
    public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        textView = (TextDirectionHeuristic)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", textDirectionHeuristic);
        builder.setTextDirection((TextDirectionHeuristic)textView);
    }
}

