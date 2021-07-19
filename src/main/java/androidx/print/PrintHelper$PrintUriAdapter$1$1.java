/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal$OnCancelListener
 */
package androidx.print;

import android.os.CancellationSignal;
import androidx.print.PrintHelper$PrintUriAdapter$1;

public class PrintHelper$PrintUriAdapter$1$1
implements CancellationSignal.OnCancelListener {
    public final /* synthetic */ PrintHelper$PrintUriAdapter$1 this$2;

    public PrintHelper$PrintUriAdapter$1$1(PrintHelper$PrintUriAdapter$1 var1_1) {
        this.this$2 = var1_1;
    }

    public void onCancel() {
        this.this$2.this$1.cancelLoad();
        this.this$2.cancel(false);
    }
}

