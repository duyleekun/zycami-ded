/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 */
package d.v.f.c;

import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import d.v.e.l.o1;

public class c
extends AppCompatActivity {
    private Resources a = null;

    public Resources getResources() {
        Resources resources = this.a;
        if (resources == null) {
            this.a = resources = super.getResources();
        }
        return o1.K(this.a);
    }
}

