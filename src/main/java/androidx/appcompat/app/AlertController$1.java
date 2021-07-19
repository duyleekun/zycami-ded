/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 */
package androidx.appcompat.app;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertController;

public class AlertController$1
implements View.OnClickListener {
    public final /* synthetic */ AlertController this$0;

    public AlertController$1(AlertController alertController) {
        this.this$0 = alertController;
    }

    public void onClick(View object) {
        AlertController alertController = this.this$0;
        Button button = alertController.mButtonPositive;
        if ((object = object == button && (button = alertController.mButtonPositiveMessage) != null ? Message.obtain((Message)button) : (object == (button = alertController.mButtonNegative) && (button = alertController.mButtonNegativeMessage) != null ? Message.obtain((Message)button) : (object == (button = alertController.mButtonNeutral) && (object = alertController.mButtonNeutralMessage) != null ? Message.obtain((Message)object) : null))) != null) {
            object.sendToTarget();
        }
        object = this.this$0;
        alertController = object.mHandler;
        object = object.mDialog;
        alertController.obtainMessage(1, object).sendToTarget();
    }
}

