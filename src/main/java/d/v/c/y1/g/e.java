/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 */
package d.v.c.y1.g;

import android.view.View;
import com.zhiyun.cama.voice.record.EditorRecordFragment;

public final class e
implements View.OnScrollChangeListener {
    public final /* synthetic */ EditorRecordFragment a;

    public /* synthetic */ e(EditorRecordFragment editorRecordFragment) {
        this.a = editorRecordFragment;
    }

    public final void onScrollChange(View view, int n10, int n11, int n12, int n13) {
        this.a.g0(view, n10, n11, n12, n13);
    }
}

