/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 */
package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment
extends DialogFragment {
    public Dialog onCreateDialog(Bundle object) {
        Context context = this.getContext();
        int n10 = this.getTheme();
        object = new AppCompatDialog(context, n10);
        return object;
    }

    public void setupDialog(Dialog dialog, int n10) {
        block4: {
            block2: {
                int n11;
                Dialog dialog2;
                block3: {
                    int n12;
                    boolean bl2 = dialog instanceof AppCompatDialog;
                    if (!bl2) break block2;
                    dialog2 = dialog;
                    dialog2 = (AppCompatDialog)dialog;
                    n11 = 1;
                    if (n10 == n11 || n10 == (n12 = 2)) break block3;
                    n12 = 3;
                    if (n10 != n12) break block4;
                    dialog = dialog.getWindow();
                    n10 = 24;
                    dialog.addFlags(n10);
                }
                dialog2.supportRequestWindowFeature(n11);
                break block4;
            }
            super.setupDialog(dialog, n10);
        }
    }
}

