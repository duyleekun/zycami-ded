/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

public class DialogFragment$2
implements DialogInterface.OnCancelListener {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$2(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    public void onCancel(DialogInterface object) {
        object = DialogFragment.access$000(this.this$0);
        if (object != null) {
            object = this.this$0;
            Dialog dialog = DialogFragment.access$000((DialogFragment)object);
            ((DialogFragment)object).onCancel((DialogInterface)dialog);
        }
    }
}

