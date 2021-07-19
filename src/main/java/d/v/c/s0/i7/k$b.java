/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 */
package d.v.c.s0.i7;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import l.a.e.e;

public class k$b
extends LayoutInflater {
    private static final String[] b = new String[]{"android.widget.", "android.webkit.", "android.app."};
    private e a;

    public k$b(Context object) {
        super(object);
        boolean bl2 = object instanceof AppCompatActivity;
        if (bl2) {
            object = e.b(object);
            this.a = object;
            LayoutInflaterCompat.setFactory2(this, (LayoutInflater.Factory2)object);
        }
    }

    public void a() {
        e e10 = this.a;
        if (e10 != null) {
            e10.a();
        }
    }

    public LayoutInflater cloneInContext(Context context) {
        k$b k$b = new k$b(context);
        return k$b;
    }

    public View onCreateView(String string2, AttributeSet attributeSet) {
        for (String string3 : b) {
            try {
                string3 = this.createView(string2, string3, attributeSet);
                if (string3 == null) continue;
                return string3;
            }
            catch (ClassNotFoundException classNotFoundException) {}
        }
        return super.onCreateView(string2, attributeSet);
    }
}

