/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.q0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.main.EditorMainActivity;
import d.v.c.b1.t.g;
import d.v.c.q0.c;
import d.v.i0.b;
import java.util.Objects;

public abstract class d
extends c {
    public g g;
    private long h = -1;
    private boolean i = true;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object object = this.requireActivity();
        boolean bl2 = object instanceof EditorMainActivity;
        if (bl2) {
            object = d.v.i0.b.c(this.requireActivity());
            Class<g> clazz = g.class;
            this.g = object = (g)((ViewModelProvider)object).get(clazz);
            Objects.requireNonNull(object);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void t() {
        this.v(false);
        super.t();
    }

    public void u() {
        boolean bl2 = this.i;
        if (bl2) {
            long l10 = this.h;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) {
                g g10 = this.g;
                g10.b3(l10);
            }
            this.r();
        }
    }

    public void v(boolean bl2) {
        this.i = bl2;
    }

    public void w(long l10) {
        this.h = l10;
    }
}

