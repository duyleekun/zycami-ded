/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 */
package com.zhiyun.zyplayer;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.zhiyun.zyplayer.GestureView;
import com.zhiyun.zyplayer.GestureView$b;

public class GestureView$c
extends GestureDetector.SimpleOnGestureListener {
    private GestureView a;
    public final /* synthetic */ GestureView b;

    public GestureView$c(GestureView gestureView, GestureView gestureView2) {
        this.b = gestureView;
        this.a = gestureView2;
    }

    public boolean onContextClick(MotionEvent motionEvent) {
        return true;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        GestureView$b gestureView$b = GestureView.c(this.b);
        if (gestureView$b != null) {
            gestureView$b = GestureView.c(this.b);
            gestureView$b.a(motionEvent);
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return super.onDoubleTapEvent(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        GestureView.b(this.b, false);
        GestureView.f(this.b, 0);
        GestureView$b gestureView$b = GestureView.c(this.b);
        if (gestureView$b != null) {
            gestureView$b = GestureView.c(this.b);
            gestureView$b.onDown(motionEvent);
        }
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        return super.onFling(motionEvent, motionEvent2, f10, f11);
    }

    public void onLongPress(MotionEvent motionEvent) {
        super.onLongPress(motionEvent);
    }

    public boolean onScroll(MotionEvent object, MotionEvent object2, float f10, float f11) {
        Object object3 = this.b;
        int n10 = GestureView.e((GestureView)((Object)object3));
        int n11 = 3;
        int n12 = 2;
        int n13 = 1;
        if (n10 != 0) {
            if (n10 != n13) {
                if (n10 != n12) {
                    if (n10 == n11) {
                        object3 = GestureView.c(this.b);
                        if (object3 != null) {
                            object3 = GestureView.c(this.b);
                            object3.e((MotionEvent)object, (MotionEvent)object2, f10, f11);
                        }
                        object = this.b;
                        GestureView.b((GestureView)((Object)object), n13 != 0);
                    }
                } else {
                    object3 = GestureView.c(this.b);
                    if (object3 != null) {
                        object3 = GestureView.c(this.b);
                        object3.b((MotionEvent)object, (MotionEvent)object2, f10, f11);
                    }
                }
            } else {
                object3 = GestureView.c(this.b);
                if (object3 != null) {
                    object3 = GestureView.c(this.b);
                    object3.c((MotionEvent)object, (MotionEvent)object2, f10, f11);
                }
            }
        } else {
            float f12 = Math.abs(f10);
            f10 = Math.abs(f11);
            GestureView gestureView = this.b;
            int n14 = GestureView.g(gestureView);
            float f13 = (f12 -= f10) - (f10 = (float)n14);
            Object object4 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object4 > 0) {
                object = this.b;
                GestureView.f((GestureView)((Object)object), n11);
            } else {
                float f14 = object.getX();
                float f15 = f14 - (f12 = (float)(object4 = (Object)((object2 = this.b).getWidth() / n12)));
                Object object5 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                if (object5 < 0) {
                    object = this.b;
                    GestureView.f((GestureView)((Object)object), n12);
                } else {
                    object = this.b;
                    GestureView.f((GestureView)((Object)object), n13);
                }
            }
        }
        return n13 != 0;
    }

    public void onShowPress(MotionEvent motionEvent) {
        super.onShowPress(motionEvent);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        GestureView$b gestureView$b = GestureView.c(this.b);
        if (gestureView$b != null) {
            gestureView$b = GestureView.c(this.b);
            gestureView$b.f(motionEvent);
        }
        return super.onSingleTapConfirmed(motionEvent);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return super.onSingleTapUp(motionEvent);
    }
}

