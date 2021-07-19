/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.StaticLayout$Builder
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;

public class AppCompatTextViewAutoSizeHelper$Impl {
    public void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
    }

    public boolean isHorizontallyScrollable(TextView textView) {
        Boolean bl2 = Boolean.FALSE;
        return (Boolean)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", bl2);
    }
}

