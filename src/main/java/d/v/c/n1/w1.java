/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.VideoCropFragment;

public final class w1
implements Runnable {
    public final /* synthetic */ VideoCropFragment a;
    public final /* synthetic */ UploadCEMediaInfo b;

    public /* synthetic */ w1(VideoCropFragment videoCropFragment, UploadCEMediaInfo uploadCEMediaInfo) {
        this.a = videoCropFragment;
        this.b = uploadCEMediaInfo;
    }

    public final void run() {
        VideoCropFragment videoCropFragment = this.a;
        UploadCEMediaInfo uploadCEMediaInfo = this.b;
        videoCropFragment.U(uploadCEMediaInfo);
    }
}

