/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.Intent
 *  android.net.Uri
 */
package androidx.core.app;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

public class ShareCompat$Api16Impl {
    private ShareCompat$Api16Impl() {
    }

    public static void migrateExtraStreamToClipData(Intent intent, ArrayList arrayList) {
        String string2;
        CharSequence charSequence = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String string3 = intent.getStringExtra("android.intent.extra.HTML_TEXT");
        int n10 = 1;
        Uri uri = new String[n10];
        uri[0] = string2 = intent.getType();
        Uri uri2 = (Uri)arrayList.get(0);
        string2 = new ClipData.Item(charSequence, string3, null, uri2);
        ClipData clipData = new ClipData(null, (String[])uri, (ClipData.Item)string2);
        int n11 = arrayList.size();
        for (int i10 = n10; i10 < n11; ++i10) {
            uri = (Uri)arrayList.get(i10);
            string2 = new ClipData.Item(uri);
            clipData.addItem((ClipData.Item)string2);
        }
        intent.setClipData(clipData);
        intent.addFlags(n10);
    }

    public static void removeClipData(Intent intent) {
        intent.setClipData(null);
        int n10 = intent.getFlags() & 0xFFFFFFFE;
        intent.setFlags(n10);
    }
}

