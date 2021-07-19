/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.inputmethod.InputContentInfo
 */
package androidx.appcompat.widget;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat$Builder;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public class AppCompatReceiveContentHelper$1
implements InputConnectionCompat$OnCommitContentListener {
    public final /* synthetic */ View val$view;

    public AppCompatReceiveContentHelper$1(View view) {
        this.val$view = view;
    }

    public boolean onCommitContent(InputContentInfoCompat object, int n10, Bundle bundle) {
        Object object2;
        ClipData clipData;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 0;
        int n13 = 1;
        int n14 = 25;
        if (n11 >= n14 && (n10 &= n13) != 0) {
            try {
                ((InputContentInfoCompat)object).requestPermission();
            }
            catch (Exception exception) {
                Log.w((String)"ReceiveContent", (String)"Can't insert content from IME; requestPermission() failed", (Throwable)exception);
                return false;
            }
            clipData = (InputContentInfo)((InputContentInfoCompat)object).unwrap();
            if (bundle == null) {
                bundle = new Bundle();
            } else {
                object2 = new Bundle(bundle);
                bundle = object2;
            }
            object2 = "androidx.core.view.extra.INPUT_CONTENT_INFO";
            bundle.putParcelable((String)object2, (Parcelable)clipData);
        }
        object2 = ((InputContentInfoCompat)object).getDescription();
        Uri uri = ((InputContentInfoCompat)object).getContentUri();
        ClipData.Item item = new ClipData.Item(uri);
        clipData = new ClipData((ClipDescription)object2, item);
        n14 = 2;
        object2 = new ContentInfoCompat$Builder(clipData, n14);
        object = ((InputContentInfoCompat)object).getLinkUri();
        object = ((ContentInfoCompat$Builder)object2).setLinkUri((Uri)object).setExtras(bundle).build();
        clipData = this.val$view;
        if ((object = ViewCompat.performReceiveContent((View)clipData, (ContentInfoCompat)object)) == null) {
            n12 = n13;
        }
        return n12 != 0;
    }
}

