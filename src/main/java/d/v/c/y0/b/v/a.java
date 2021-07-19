/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.y0.b.v;

import android.view.View;
import com.zhiyun.device.connection.BleDevice;
import d.v.c.y0.b.v.b;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ BleDevice b;
    public final /* synthetic */ int c;

    public /* synthetic */ a(b b10, BleDevice bleDevice, int n10) {
        this.a = b10;
        this.b = bleDevice;
        this.c = n10;
    }

    public final void onClick(View view) {
        b b10 = this.a;
        BleDevice bleDevice = this.b;
        int n10 = this.c;
        b10.g(bleDevice, n10, view);
    }
}

