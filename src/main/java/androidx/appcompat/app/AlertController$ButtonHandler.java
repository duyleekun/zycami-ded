/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Handler
 *  android.os.Message
 */
package androidx.appcompat.app;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public final class AlertController$ButtonHandler
extends Handler {
    private static final int MSG_DISMISS_DIALOG = 1;
    private WeakReference mDialog;

    public AlertController$ButtonHandler(DialogInterface dialogInterface) {
        WeakReference<DialogInterface> weakReference;
        this.mDialog = weakReference = new WeakReference<DialogInterface>(dialogInterface);
    }

    public void handleMessage(Message message) {
        int n10 = message.what;
        int n11 = -3;
        if (n10 != n11 && n10 != (n11 = -2) && n10 != (n11 = -1)) {
            n11 = 1;
            if (n10 == n11) {
                message = (DialogInterface)message.obj;
                message.dismiss();
            }
        } else {
            DialogInterface.OnClickListener onClickListener = (DialogInterface.OnClickListener)message.obj;
            DialogInterface dialogInterface = (DialogInterface)this.mDialog.get();
            int n12 = message.what;
            onClickListener.onClick(dialogInterface, n12);
        }
    }
}

