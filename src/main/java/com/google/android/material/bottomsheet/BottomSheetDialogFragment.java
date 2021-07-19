/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 */
package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetDialogFragment
extends AppCompatDialogFragment {
    public Dialog onCreateDialog(Bundle object) {
        Context context = this.getContext();
        int n10 = this.getTheme();
        object = new BottomSheetDialog(context, n10);
        return object;
    }
}

