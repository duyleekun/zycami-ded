/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 */
package com.tencent.rtmp.ui;

import android.view.ScaleGestureDetector;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class TXCloudVideoView$2
implements ScaleGestureDetector.OnScaleGestureListener {
    public final /* synthetic */ TXCloudVideoView a;

    public TXCloudVideoView$2(TXCloudVideoView tXCloudVideoView) {
        this.a = tXCloudVideoView;
    }

    public boolean onScale(ScaleGestureDetector object) {
        int n10;
        Object object2 = TXCloudVideoView.access$400(this.a);
        if (object2 != null) {
            object2 = TXCloudVideoView.access$400(this.a);
            n10 = object2.e();
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 > 0) {
            TXCloudVideoView tXCloudVideoView;
            TXCloudVideoView tXCloudVideoView2;
            float f10;
            int n11;
            float f11 = object.getScaleFactor();
            float f12 = 1.0f;
            Object object3 = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
            int n12 = 0x3F666666;
            float f13 = 0.9f;
            int n13 = 1066192077;
            float f14 = 1.1f;
            float f15 = 0.2f;
            if (object3 > 0) {
                f11 = n10;
                f15 /= f11;
                object = this.a;
                n11 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)object));
                n11 = n10 - n11;
                f11 = n11;
                float f16 = (f11 = (f15 *= f11) + f12) - f14;
                object3 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                if (object3 <= 0) {
                    n11 = n13;
                    f11 = f14;
                }
            } else {
                object3 = f11 == f12 ? 0 : (f11 < f12 ? -1 : 1);
                if (object3 < 0) {
                    f11 = n10;
                    f15 /= f11;
                    object = this.a;
                    n11 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)object));
                    f11 = n11;
                    float f17 = (f11 = f12 - (f15 *= f11)) - f13;
                    object3 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                    if (object3 >= 0) {
                        n11 = n12;
                        f11 = f13;
                    }
                }
            }
            if ((object3 = (Object)Math.round(f10 = (float)TXCloudVideoView.access$500(tXCloudVideoView2 = this.a) * f11)) == (n12 = TXCloudVideoView.access$500(tXCloudVideoView = this.a))) {
                n12 = (int)(f11 == f12 ? 0 : (f11 > f12 ? 1 : -1));
                if (n12 > 0) {
                    ++object3;
                } else {
                    n12 = (int)(f11 == f12 ? 0 : (f11 < f12 ? -1 : 1));
                    if (n12 < 0) {
                        object3 += -1;
                    }
                }
            }
            if (object3 < n10) {
                n10 = (int)object3;
            }
            object3 = true;
            f10 = Float.MIN_VALUE;
            if (n10 <= object3) {
                n10 = (int)object3;
            }
            if ((object3 = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1)) > 0) {
                object = this.a;
                n11 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)object));
                if (n10 < n11) {
                    object = this.a;
                    n10 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)object));
                }
            } else {
                n11 = (int)(f11 == f12 ? 0 : (f11 < f12 ? -1 : 1));
                if (n11 < 0 && n10 > (n11 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)(object = this.a))))) {
                    object = this.a;
                    n10 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)object));
                }
            }
            TXCloudVideoView.access$502(this.a, n10);
            object = TXCloudVideoView.access$400(this.a);
            if (object != null) {
                object = TXCloudVideoView.access$400(this.a);
                object2 = this.a;
                n10 = TXCloudVideoView.access$500((TXCloudVideoView)((Object)object2));
                object.a(n10);
            }
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}

