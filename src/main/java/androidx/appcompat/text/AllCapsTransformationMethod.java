/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.text.method.TransformationMethod
 *  android.view.View
 */
package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod
implements TransformationMethod {
    private Locale mLocale;

    public AllCapsTransformationMethod(Context object) {
        object = object.getResources().getConfiguration().locale;
        this.mLocale = object;
    }

    public CharSequence getTransformation(CharSequence charSequence, View object) {
        if (charSequence != null) {
            charSequence = charSequence.toString();
            object = this.mLocale;
            charSequence = ((String)charSequence).toUpperCase((Locale)object);
        } else {
            charSequence = null;
        }
        return charSequence;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean bl2, int n10, Rect rect) {
    }
}

