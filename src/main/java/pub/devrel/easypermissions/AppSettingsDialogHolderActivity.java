/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import j.a.a.b;

public class AppSettingsDialogHolderActivity
extends AppCompatActivity
implements DialogInterface.OnClickListener {
    private static final int c = 7534;
    private AlertDialog a;
    private int b;

    public static Intent d(Context context, b b10) {
        Intent intent = new Intent(context, AppSettingsDialogHolderActivity.class);
        intent.putExtra("extra_app_settings", (Parcelable)b10);
        return intent;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        this.setResult(n11, intent);
        this.finish();
    }

    public void onClick(DialogInterface object, int n10) {
        block4: {
            block3: {
                int n11;
                block2: {
                    n11 = -1;
                    if (n10 != n11) break block2;
                    object = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    String string2 = this.getPackageName();
                    Object var5_6 = null;
                    String string3 = "package";
                    string2 = Uri.fromParts((String)string3, (String)string2, null);
                    object = object.setData((Uri)string2);
                    n10 = this.b;
                    object.addFlags(n10);
                    n10 = 7534;
                    this.startActivityForResult((Intent)object, n10);
                    break block3;
                }
                n11 = -2;
                if (n10 != n11) break block4;
                n11 = 0;
                object = null;
                this.setResult(0);
                this.finish();
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown button type: ");
        stringBuilder.append(n10);
        String string4 = stringBuilder.toString();
        object = new IllegalStateException(string4);
        throw object;
    }

    public void onCreate(Bundle object) {
        int n10;
        super.onCreate((Bundle)object);
        object = j.a.a.b.a(this.getIntent(), this);
        this.b = n10 = ((b)object).b();
        this.a = object = ((b)object).e(this, this);
    }

    public void onDestroy() {
        boolean bl2;
        super.onDestroy();
        AlertDialog alertDialog = this.a;
        if (alertDialog != null && (bl2 = alertDialog.isShowing())) {
            alertDialog = this.a;
            alertDialog.dismiss();
        }
    }
}

