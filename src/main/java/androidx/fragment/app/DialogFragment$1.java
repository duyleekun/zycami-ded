/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

public class DialogFragment$1
implements Runnable {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$1(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    public void run() {
        DialogInterface.OnDismissListener onDismissListener = DialogFragment.access$100(this.this$0);
        Dialog dialog = DialogFragment.access$000(this.this$0);
        onDismissListener.onDismiss((DialogInterface)dialog);
    }
}

