/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.text.Spanned
 */
package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Spanned;

public final class TextViewOnReceiveContentListener$Api16Impl {
    private TextViewOnReceiveContentListener$Api16Impl() {
    }

    public static CharSequence coerce(Context object, ClipData.Item item, int n10) {
        if ((n10 &= 1) != 0) {
            boolean bl2 = (object = item.coerceToText(object)) instanceof Spanned;
            if (bl2) {
                object = ((CharSequence)object).toString();
            }
            return object;
        }
        return item.coerceToStyledText(object);
    }
}

