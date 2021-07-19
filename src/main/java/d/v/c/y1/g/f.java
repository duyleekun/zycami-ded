/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g;

import com.zhiyun.cama.voice.record.EditorRecordFragment;

public final class f
implements Runnable {
    public final /* synthetic */ EditorRecordFragment a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(EditorRecordFragment editorRecordFragment, int n10) {
        this.a = editorRecordFragment;
        this.b = n10;
    }

    public final void run() {
        EditorRecordFragment editorRecordFragment = this.a;
        int n10 = this.b;
        editorRecordFragment.a0(n10);
    }
}

