/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 */
package b.a.d;

import android.view.View;
import androidx.camera.view.PreviewView;

public final class k
implements View.OnLayoutChangeListener {
    public final /* synthetic */ PreviewView a;

    public /* synthetic */ k(PreviewView previewView) {
        this.a = previewView;
    }

    public final void onLayoutChange(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        this.a.b(view, n10, n11, n12, n13, n14, n15, n16, n17);
    }
}

