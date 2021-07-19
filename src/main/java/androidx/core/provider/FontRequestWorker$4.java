/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.collection.SimpleArrayMap;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontRequestWorker$TypefaceResult;
import androidx.core.util.Consumer;
import java.util.ArrayList;

public class FontRequestWorker$4
implements Consumer {
    public final /* synthetic */ String val$id;

    public FontRequestWorker$4(String string2) {
        this.val$id = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void accept(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        Object object;
        Object object2;
        Object object3 = FontRequestWorker.LOCK;
        synchronized (object3) {
            object2 = FontRequestWorker.PENDING_REPLIES;
            object = this.val$id;
            object = ((SimpleArrayMap)object2).get(object);
            object = (ArrayList)object;
            if (object == null) {
                return;
            }
            String string2 = this.val$id;
            ((SimpleArrayMap)object2).remove(string2);
        }
        int n10 = 0;
        object3 = null;
        int n11;
        while (n10 < (n11 = ((ArrayList)object).size())) {
            object2 = (Consumer)((ArrayList)object).get(n10);
            object2.accept(fontRequestWorker$TypefaceResult);
            ++n10;
        }
        return;
    }
}

