/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.core.provider;

import android.content.Context;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontRequestWorker$TypefaceResult;
import java.util.concurrent.Callable;

public class FontRequestWorker$3
implements Callable {
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String val$id;
    public final /* synthetic */ FontRequest val$request;
    public final /* synthetic */ int val$style;

    public FontRequestWorker$3(String string2, Context context, FontRequest fontRequest, int n10) {
        this.val$id = string2;
        this.val$context = context;
        this.val$request = fontRequest;
        this.val$style = n10;
    }

    public FontRequestWorker$TypefaceResult call() {
        String string2 = this.val$id;
        Context context = this.val$context;
        FontRequest fontRequest = this.val$request;
        int n10 = this.val$style;
        return FontRequestWorker.getFontSync(string2, context, fontRequest, n10);
    }
}

