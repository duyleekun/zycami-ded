/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.method.SingleLineTransformationMethod
 *  android.view.View
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

public class PagerTitleStrip$SingleLineAllCapsTransform
extends SingleLineTransformationMethod {
    private Locale mLocale;

    public PagerTitleStrip$SingleLineAllCapsTransform(Context object) {
        object = object.getResources().getConfiguration().locale;
        this.mLocale = object;
    }

    public CharSequence getTransformation(CharSequence charSequence, View object) {
        if ((charSequence = super.getTransformation(charSequence, object)) != null) {
            charSequence = charSequence.toString();
            object = this.mLocale;
            charSequence = ((String)charSequence).toUpperCase((Locale)object);
        } else {
            charSequence = null;
        }
        return charSequence;
    }
}

