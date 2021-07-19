/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.DragEvent
 *  android.view.View
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatReceiveContentHelper$1;
import androidx.appcompat.widget.AppCompatReceiveContentHelper$OnDropApi24Impl;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat$Builder;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;

public final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    private AppCompatReceiveContentHelper() {
    }

    public static InputConnectionCompat$OnCommitContentListener createOnCommitContentListener(View view) {
        AppCompatReceiveContentHelper$1 appCompatReceiveContentHelper$1 = new AppCompatReceiveContentHelper$1(view);
        return appCompatReceiveContentHelper$1;
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(View object, DragEvent object2) {
        Activity activity;
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        int n11 = 24;
        if (n10 >= n11 && (activity = object2.getLocalState()) == null && (activity = ViewCompat.getOnReceiveContentMimeTypes(object)) != null) {
            int n12;
            activity = AppCompatReceiveContentHelper.tryGetActivity(object);
            if (activity == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Can't handle drop: no activity: view=");
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                Log.i((String)LOG_TAG, (String)object);
                return false;
            }
            n11 = object2.getAction();
            if (n11 == (n12 = 1)) {
                return (object instanceof TextView ^ n12) != 0;
            }
            n11 = object2.getAction();
            if (n11 == (n12 = 3)) {
                boolean bl3;
                bl2 = object instanceof TextView;
                if (bl2) {
                    object = (TextView)object;
                    bl3 = AppCompatReceiveContentHelper$OnDropApi24Impl.onDropForTextView((DragEvent)object2, (TextView)object, activity);
                } else {
                    bl3 = AppCompatReceiveContentHelper$OnDropApi24Impl.onDropForView((DragEvent)object2, object, activity);
                }
                return bl3;
            }
        }
        return false;
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView textView, int n10) {
        int n11;
        Context context;
        int n12;
        int n13 = 0;
        int n14 = 0x1020022;
        if (n10 != n14 && n10 != (n12 = 16908337) || (context = ViewCompat.getOnReceiveContentMimeTypes((View)textView)) == null) {
            return false;
        }
        context = textView.getContext();
        String string2 = "clipboard";
        if ((context = (ClipboardManager)context.getSystemService(string2)) == null) {
            n12 = 0;
            context = null;
        } else {
            context = context.getPrimaryClip();
        }
        int n15 = 1;
        if (context != null && (n11 = context.getItemCount()) > 0) {
            ContentInfoCompat$Builder contentInfoCompat$Builder = new ContentInfoCompat$Builder((ClipData)context, n15);
            if (n10 != n14) {
                n13 = n15;
            }
            ContentInfoCompat contentInfoCompat = contentInfoCompat$Builder.setFlags(n13).build();
            ViewCompat.performReceiveContent((View)textView, contentInfoCompat);
        }
        return n15 != 0;
    }

    public static Activity tryGetActivity(View view) {
        boolean bl2;
        view = view.getContext();
        while (bl2 = view instanceof ContextWrapper) {
            bl2 = view instanceof Activity;
            if (bl2) {
                return (Activity)view;
            }
            view = ((ContextWrapper)view).getBaseContext();
        }
        return null;
    }
}

