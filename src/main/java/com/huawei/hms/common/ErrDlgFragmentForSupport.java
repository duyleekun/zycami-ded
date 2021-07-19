/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.app.DialogFragment
 *  android.app.FragmentManager
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.os.Bundle
 */
package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

public class ErrDlgFragmentForSupport
extends DialogFragment {
    private DialogInterface.OnCancelListener listener = null;
    private Dialog log = null;

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog) {
        return ErrDlgFragmentForSupport.newInstance(dialog, null);
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrDlgFragmentForSupport errDlgFragmentForSupport = new ErrDlgFragmentForSupport();
        errDlgFragmentForSupport.log = dialog;
        dialog.setOnCancelListener(null);
        errDlgFragmentForSupport.log.setOnDismissListener(null);
        errDlgFragmentForSupport.listener = onCancelListener;
        return errDlgFragmentForSupport;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.listener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        bundle = this.log;
        if (bundle == null) {
            bundle = null;
            this.setShowsDialog(false);
        }
        return this.log;
    }

    public void show(FragmentManager fragmentManager, String string2) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, string2);
    }
}

