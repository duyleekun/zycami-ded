/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.text.Selection
 *  android.text.Spannable
 *  android.view.DragEvent
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat$Builder;
import androidx.core.view.ViewCompat;

public final class AppCompatReceiveContentHelper$OnDropApi24Impl {
    private AppCompatReceiveContentHelper$OnDropApi24Impl() {
    }

    public static boolean onDropForTextView(DragEvent object, TextView textView, Activity object2) {
        object2.requestDragAndDropPermissions(object);
        float f10 = object.getX();
        float f11 = object.getY();
        int n10 = textView.getOffsetForPosition(f10, f11);
        textView.beginBatchEdit();
        CharSequence charSequence = textView.getText();
        charSequence = (Spannable)charSequence;
        Selection.setSelection((Spannable)charSequence, (int)n10);
        object = object.getClipData();
        int n11 = 3;
        f11 = 4.2E-45f;
        try {
            object2 = new ContentInfoCompat$Builder((ClipData)object, n11);
            object = ((ContentInfoCompat$Builder)object2).build();
            ViewCompat.performReceiveContent((View)textView, (ContentInfoCompat)object);
            return true;
        }
        finally {
            textView.endBatchEdit();
        }
    }

    public static boolean onDropForView(DragEvent object, View view, Activity object2) {
        object2.requestDragAndDropPermissions(object);
        object = object.getClipData();
        object2 = new ContentInfoCompat$Builder((ClipData)object, 3);
        object = ((ContentInfoCompat$Builder)object2).build();
        ViewCompat.performReceiveContent(view, (ContentInfoCompat)object);
        return true;
    }
}

