/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.SpannableStringBuilder
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import androidx.core.widget.TextViewOnReceiveContentListener$Api16Impl;
import androidx.core.widget.TextViewOnReceiveContentListener$ApiImpl;

public final class TextViewOnReceiveContentListener
implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    private static CharSequence coerceToText(ClipData clipData, Context context, int n10) {
        int n11;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i10 = 0; i10 < (n11 = clipData.getItemCount()); ++i10) {
            Object object = clipData.getItemAt(i10);
            if ((object = TextViewOnReceiveContentListener.coerceToText(context, object, n10)) == null) continue;
            spannableStringBuilder.append((CharSequence)object);
        }
        return spannableStringBuilder;
    }

    private static CharSequence coerceToText(Context context, ClipData.Item item, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            return TextViewOnReceiveContentListener$Api16Impl.coerce(context, item, n10);
        }
        return TextViewOnReceiveContentListener$ApiImpl.coerce(context, item, n10);
    }

    private static void onReceiveForDragAndDrop(TextView textView, ContentInfoCompat object) {
        ClipData clipData = ((ContentInfoCompat)object).getClip();
        Context context = textView.getContext();
        int n10 = ((ContentInfoCompat)object).getFlags();
        object = TextViewOnReceiveContentListener.coerceToText(clipData, context, n10);
        TextViewOnReceiveContentListener.replaceSelection((Editable)textView.getText(), (CharSequence)object);
    }

    private static void replaceSelection(Editable editable, CharSequence charSequence) {
        int n10 = Selection.getSelectionStart((CharSequence)editable);
        int n11 = Selection.getSelectionEnd((CharSequence)editable);
        int n12 = Math.min(n10, n11);
        n12 = Math.max(0, n12);
        n10 = Math.max(n10, n11);
        n10 = Math.max(0, n10);
        Selection.setSelection((Spannable)editable, (int)n10);
        editable.replace(n12, n10, charSequence);
    }

    public ContentInfoCompat onReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
        int n10;
        int n11;
        String string2;
        CharSequence charSequence;
        String string3 = LOG_TAG;
        int n12 = 3;
        int n13 = Log.isLoggable((String)string3, (int)n12);
        if (n13 != 0) {
            charSequence = new StringBuilder();
            string2 = "onReceive: ";
            charSequence.append(string2);
            charSequence.append(contentInfoCompat);
            charSequence = charSequence.toString();
            Log.d((String)string3, (String)charSequence);
        }
        if ((n11 = contentInfoCompat.getSource()) == (n13 = 2)) {
            return contentInfoCompat;
        }
        n13 = 0;
        charSequence = null;
        if (n11 == n12) {
            TextViewOnReceiveContentListener.onReceiveForDragAndDrop((TextView)view, contentInfoCompat);
            return null;
        }
        string3 = contentInfoCompat.getClip();
        int n14 = contentInfoCompat.getFlags();
        view = (TextView)view;
        Editable editable = (Editable)view.getText();
        view = view.getContext();
        string2 = null;
        boolean bl2 = false;
        for (int i10 = 0; i10 < (n10 = string3.getItemCount()); ++i10) {
            Object object = string3.getItemAt(i10);
            if ((object = TextViewOnReceiveContentListener.coerceToText((Context)view, object, n14)) == null) continue;
            if (!bl2) {
                TextViewOnReceiveContentListener.replaceSelection(editable, (CharSequence)object);
                bl2 = true;
                continue;
            }
            int n15 = Selection.getSelectionEnd((CharSequence)editable);
            String string4 = "\n";
            editable.insert(n15, (CharSequence)string4);
            n15 = Selection.getSelectionEnd((CharSequence)editable);
            editable.insert(n15, (CharSequence)object);
        }
        return null;
    }
}

