/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 */
package d.v.e.m;

import android.content.ContentResolver;
import android.database.ContentObserver;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.v0.f;

public final class h
implements f {
    public final /* synthetic */ ContentResolver a;
    public final /* synthetic */ ContentObserver b;

    public /* synthetic */ h(ContentResolver contentResolver, ContentObserver contentObserver) {
        this.a = contentResolver;
        this.b = contentObserver;
    }

    public final void cancel() {
        ContentResolver contentResolver = this.a;
        ContentObserver contentObserver = this.b;
        DeviceViewModel.k(contentResolver, contentObserver);
    }
}

