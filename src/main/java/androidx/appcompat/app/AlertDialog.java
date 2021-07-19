/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Message
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.widget.Button
 *  android.widget.ListView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AppCompatDialog;

public class AlertDialog
extends AppCompatDialog
implements DialogInterface {
    public static final int LAYOUT_HINT_NONE = 0;
    public static final int LAYOUT_HINT_SIDE = 1;
    public final AlertController mAlert;

    public AlertDialog(Context context) {
        this(context, 0);
    }

    public AlertDialog(Context object, int n10) {
        n10 = AlertDialog.resolveDialogTheme(object, n10);
        super((Context)object, n10);
        Context context = this.getContext();
        Window window = this.getWindow();
        super(context, this, window);
        this.mAlert = object;
    }

    public AlertDialog(Context context, boolean bl2, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        this.setCancelable(bl2);
        this.setOnCancelListener(onCancelListener);
    }

    public static int resolveDialogTheme(Context context, int n10) {
        int n11 = n10 >>> 24 & 0xFF;
        int n12 = 1;
        if (n11 >= n12) {
            return n10;
        }
        TypedValue typedValue = new TypedValue();
        context = context.getTheme();
        n11 = R$attr.alertDialogTheme;
        context.resolveAttribute(n11, typedValue, n12 != 0);
        return typedValue.resourceId;
    }

    public Button getButton(int n10) {
        return this.mAlert.getButton(n10);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        AlertController alertController = this.mAlert;
        boolean bl2 = alertController.onKeyDown(n10, keyEvent);
        if (bl2) {
            return true;
        }
        return super.onKeyDown(n10, keyEvent);
    }

    public boolean onKeyUp(int n10, KeyEvent keyEvent) {
        AlertController alertController = this.mAlert;
        boolean bl2 = alertController.onKeyUp(n10, keyEvent);
        if (bl2) {
            return true;
        }
        return super.onKeyUp(n10, keyEvent);
    }

    public void setButton(int n10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(n10, charSequence, onClickListener, null, null);
    }

    public void setButton(int n10, CharSequence charSequence, Drawable drawable2, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(n10, charSequence, onClickListener, null, drawable2);
    }

    public void setButton(int n10, CharSequence charSequence, Message message) {
        this.mAlert.setButton(n10, charSequence, null, message, null);
    }

    public void setButtonPanelLayoutHint(int n10) {
        this.mAlert.setButtonPanelLayoutHint(n10);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int n10) {
        this.mAlert.setIcon(n10);
    }

    public void setIcon(Drawable drawable2) {
        this.mAlert.setIcon(drawable2);
    }

    public void setIconAttribute(int n10) {
        TypedValue typedValue = new TypedValue();
        this.getContext().getTheme().resolveAttribute(n10, typedValue, true);
        AlertController alertController = this.mAlert;
        int n11 = typedValue.resourceId;
        alertController.setIcon(n11);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int n10, int n11, int n12, int n13) {
        this.mAlert.setView(view, n10, n11, n12, n13);
    }
}

