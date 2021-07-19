/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.Scroller
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.mob.tools.gui.MobDrawerLayout$1;
import com.mob.tools.gui.MobDrawerLayout$2;
import com.mob.tools.gui.MobDrawerLayout$DrawerType;
import com.mob.tools.gui.MobDrawerLayout$OnDrawerStateChangeListener;
import com.mob.tools.gui.SmoothScroller;
import com.mob.tools.utils.ResHelper;

public class MobDrawerLayout
extends ViewGroup {
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private FrameLayout bodyContainer;
    private FrameLayout drawerContainer;
    private double drawerWidth;
    private float lastMotionX;
    private float lastMotionY;
    private MobDrawerLayout$OnDrawerStateChangeListener listener;
    private boolean lockScroll;
    private int maximumVelocity;
    private boolean opened;
    private Paint paint;
    private Scroller scroller;
    private int touchSlop;
    private int touchState;
    private MobDrawerLayout$DrawerType type;
    private VelocityTracker velocityTracker;

    public MobDrawerLayout(Context context) {
        super(context);
        this.init(context);
    }

    public MobDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public MobDrawerLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(context);
    }

    private void computeDrag(int n10) {
        int n11 = 500;
        if (n10 >= n11) {
            int[] nArray = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
            n11 = mobDrawerLayout$DrawerType.ordinal();
            n10 = nArray[n11];
            switch (n10) {
                default: {
                    break;
                }
                case 2: 
                case 5: 
                case 6: {
                    this.close();
                    break;
                }
                case 1: 
                case 3: 
                case 4: {
                    this.open();
                    break;
                }
            }
        } else {
            n11 = -500;
            if (n10 <= n11) {
                int[] nArray = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
                MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
                n11 = mobDrawerLayout$DrawerType.ordinal();
                n10 = nArray[n11];
                switch (n10) {
                    default: {
                        break;
                    }
                    case 2: 
                    case 5: 
                    case 6: {
                        this.open();
                        break;
                    }
                    case 1: 
                    case 3: 
                    case 4: {
                        this.close();
                        break;
                    }
                }
            } else {
                n10 = 0;
                FrameLayout frameLayout = null;
                Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
                MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
                int n12 = mobDrawerLayout$DrawerType.ordinal();
                n11 = object[n12];
                switch (n11) {
                    default: {
                        break;
                    }
                    case 5: {
                        frameLayout = this.bodyContainer;
                        n10 = -frameLayout.getLeft();
                        break;
                    }
                    case 3: {
                        frameLayout = this.bodyContainer;
                        n10 = frameLayout.getLeft();
                        break;
                    }
                    case 2: 
                    case 6: {
                        n10 = this.getWidth();
                        object = this.drawerContainer;
                        n11 = object.getLeft();
                        n10 -= n11;
                        break;
                    }
                    case 1: 
                    case 4: {
                        frameLayout = this.drawerContainer;
                        n10 = frameLayout.getRight();
                    }
                }
                double d10 = this.getWidth();
                double d11 = this.drawerWidth;
                n11 = (int)(d10 *= d11) / 2;
                if (n10 >= n11) {
                    this.open();
                } else {
                    this.close();
                }
            }
        }
    }

    private void dragToLeft(int n10) {
        Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
        int n11 = this.type.ordinal();
        int n12 = object[n11];
        n11 = 0;
        switch (n12) {
            default: {
                break;
            }
            case 6: {
                object = this.drawerContainer;
                n12 = object.getRight();
                int n13 = this.getWidth();
                if (n12 <= n13) break;
                if ((n12 -= n10) >= n13) {
                    n13 = n12;
                }
                double d10 = this.getWidth();
                double d11 = this.drawerWidth;
                n10 = (int)(d10 *= d11);
                n10 = n13 - n10;
                n12 = this.getWidth();
                n12 = n10 - n12;
                FrameLayout frameLayout = this.drawerContainer;
                int n14 = this.getHeight();
                frameLayout.layout(n10, 0, n13, n14);
                FrameLayout frameLayout2 = this.bodyContainer;
                int n15 = this.getHeight();
                frameLayout2.layout(n12, 0, n10, n15);
                break;
            }
            case 5: {
                object = this.bodyContainer;
                n12 = object.getLeft();
                double d12 = -this.getWidth();
                double d13 = this.drawerWidth;
                int n16 = (int)(d12 *= d13);
                if (n12 <= n16) break;
                if ((n12 -= n10) >= n16) {
                    n16 = n12;
                }
                n10 = this.getWidth() + n16;
                object = this.bodyContainer;
                int n17 = this.getHeight();
                object.layout(n16, 0, n10, n17);
                break;
            }
            case 4: {
                object = this.drawerContainer;
                n12 = object.getRight();
                if (n12 <= 0) break;
                if ((n12 -= n10) < 0) {
                    n12 = 0;
                    object = null;
                }
                double d14 = this.getWidth();
                double d15 = this.drawerWidth;
                n10 = (int)(d14 *= d15);
                n10 = n12 - n10;
                int n18 = this.getWidth() + n12;
                FrameLayout frameLayout = this.drawerContainer;
                int n19 = this.getHeight();
                frameLayout.layout(n10, 0, n12, n19);
                FrameLayout frameLayout3 = this.bodyContainer;
                int n20 = this.getHeight();
                frameLayout3.layout(n12, 0, n18, n20);
                break;
            }
            case 3: {
                object = this.bodyContainer;
                n12 = object.getLeft();
                if (n12 <= 0) break;
                if ((n12 -= n10) < 0) {
                    n12 = 0;
                    object = null;
                }
                n10 = this.getWidth() + n12;
                FrameLayout frameLayout = this.bodyContainer;
                int n21 = this.getHeight();
                frameLayout.layout(n12, 0, n10, n21);
                break;
            }
            case 2: {
                object = this.drawerContainer;
                n12 = object.getRight();
                int n22 = this.getWidth();
                if (n12 <= n22) break;
                if ((n12 -= n10) >= n22) {
                    n22 = n12;
                }
                double d16 = this.getWidth();
                double d17 = this.drawerWidth;
                n10 = (int)(d16 *= d17);
                n10 = n22 - n10;
                object = this.drawerContainer;
                int n23 = this.getHeight();
                object.layout(n10, 0, n22, n23);
                break;
            }
            case 1: {
                object = this.drawerContainer;
                n12 = object.getRight();
                if (n12 <= 0) break;
                if ((n12 -= n10) < 0) {
                    n12 = 0;
                    object = null;
                }
                double d18 = this.getWidth();
                double d19 = this.drawerWidth;
                n10 = (int)(d18 *= d19);
                n10 = n12 - n10;
                FrameLayout frameLayout = this.drawerContainer;
                int n24 = this.getHeight();
                frameLayout.layout(n10, 0, n12, n24);
            }
        }
    }

    private void dragToRight(int n10) {
        Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
        int n11 = this.type.ordinal();
        int n12 = object[n11];
        n11 = 0;
        switch (n12) {
            default: {
                break;
            }
            case 6: {
                object = this.bodyContainer;
                n12 = object.getLeft();
                if (n12 >= 0) break;
                if ((n12 += n10) > 0) {
                    n12 = 0;
                    object = null;
                }
                n10 = this.getWidth() + n12;
                double d10 = this.getWidth();
                double d11 = this.drawerWidth;
                int n13 = (int)(d10 *= d11) + n10;
                FrameLayout frameLayout = this.bodyContainer;
                int n14 = this.getHeight();
                frameLayout.layout(n12, 0, n10, n14);
                object = this.drawerContainer;
                int n15 = this.getHeight();
                object.layout(n10, 0, n13, n15);
                break;
            }
            case 5: {
                object = this.bodyContainer;
                n12 = object.getLeft();
                if (n12 >= 0) break;
                if ((n12 += n10) > 0) {
                    n12 = 0;
                    object = null;
                }
                n10 = this.getWidth() + n12;
                FrameLayout frameLayout = this.bodyContainer;
                int n16 = this.getHeight();
                frameLayout.layout(n12, 0, n10, n16);
                break;
            }
            case 4: {
                object = this.drawerContainer;
                n12 = object.getLeft();
                if (n12 >= 0) break;
                if ((n12 += n10) > 0) {
                    n12 = 0;
                    object = null;
                }
                double d12 = this.getWidth();
                double d13 = this.drawerWidth;
                n10 = (int)(d12 *= d13) + n12;
                int n17 = this.getWidth() + n10;
                FrameLayout frameLayout = this.drawerContainer;
                int n18 = this.getHeight();
                frameLayout.layout(n12, 0, n10, n18);
                object = this.bodyContainer;
                int n19 = this.getHeight();
                object.layout(n10, 0, n17, n19);
                break;
            }
            case 3: {
                object = this.bodyContainer;
                n12 = object.getLeft();
                double d14 = this.getWidth();
                double d15 = this.drawerWidth;
                int n20 = (int)(d14 *= d15);
                if (n12 >= n20) break;
                if ((n12 += n10) <= n20) {
                    n20 = n12;
                }
                n10 = this.getWidth() + n20;
                object = this.bodyContainer;
                int n21 = this.getHeight();
                object.layout(n20, 0, n10, n21);
                break;
            }
            case 2: {
                object = this.drawerContainer;
                n12 = object.getLeft();
                int n22 = this.getWidth();
                if (n12 >= n22) break;
                if ((n12 += n10) <= n22) {
                    n22 = n12;
                }
                double d16 = this.getWidth();
                double d17 = this.drawerWidth;
                n10 = (int)(d16 *= d17) + n22;
                object = this.drawerContainer;
                int n23 = this.getHeight();
                object.layout(n22, 0, n10, n23);
                break;
            }
            case 1: {
                object = this.drawerContainer;
                n12 = object.getLeft();
                if (n12 >= 0) break;
                if ((n12 += n10) > 0) {
                    n12 = 0;
                    object = null;
                }
                double d18 = this.getWidth();
                double d19 = this.drawerWidth;
                n10 = (int)(d18 *= d19) + n12;
                FrameLayout frameLayout = this.drawerContainer;
                int n24 = this.getHeight();
                frameLayout.layout(n12, 0, n10, n24);
            }
        }
    }

    private void drawShadow(Canvas canvas) {
        Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
        int n10 = mobDrawerLayout$DrawerType.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 5;
                if (n11 != n10 && n11 != (n10 = 6)) {
                    object = this.bodyContainer;
                    n11 = object.getLeft();
                    if (n11 > 0) {
                        mobDrawerLayout$DrawerType = this.paint;
                        int n12 = n11 + -25;
                        float f10 = n12;
                        float f11 = n11;
                        boolean bl2 = false;
                        Object var11_24 = null;
                        int n13 = -1 << -1;
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        LinearGradient linearGradient = new LinearGradient(f10, 0.0f, f11, 0.0f, 0, n13, tileMode);
                        mobDrawerLayout$DrawerType.setShader((Shader)linearGradient);
                        n10 = this.getHeight();
                        float f12 = n10;
                        Paint paint = this.paint;
                        float f13 = f11;
                        canvas.drawRect(f10, 0.0f, f11, f12, paint);
                    }
                } else {
                    object = this.bodyContainer;
                    n11 = object.getRight();
                    if (n11 < (n10 = this.getWidth())) {
                        mobDrawerLayout$DrawerType = this.paint;
                        float f14 = n11;
                        float f15 = n11 += 25;
                        int n14 = -1 << -1;
                        float f16 = -0.0f;
                        boolean bl3 = false;
                        Object var15_41 = null;
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        LinearGradient linearGradient = new LinearGradient(f14, 0.0f, f15, 0.0f, n14, 0, tileMode);
                        mobDrawerLayout$DrawerType.setShader((Shader)linearGradient);
                        n10 = this.getHeight();
                        float f17 = n10;
                        Paint paint = this.paint;
                        canvas.drawRect(f14, 0.0f, f15, f17, paint);
                    }
                }
            } else {
                object = this.drawerContainer;
                n11 = object.getLeft();
                if (n11 < (n10 = this.getWidth())) {
                    mobDrawerLayout$DrawerType = this.paint;
                    int n15 = n11 + -25;
                    float f18 = n15;
                    float f19 = n11;
                    boolean bl4 = false;
                    Object var11_26 = null;
                    int n16 = -1 << -1;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    LinearGradient linearGradient = new LinearGradient(f18, 0.0f, f19, 0.0f, 0, n16, tileMode);
                    mobDrawerLayout$DrawerType.setShader((Shader)linearGradient);
                    n10 = this.getHeight();
                    float f20 = n10;
                    Paint paint = this.paint;
                    float f21 = f19;
                    canvas.drawRect(f18, 0.0f, f19, f20, paint);
                }
            }
        } else {
            object = this.drawerContainer;
            n11 = object.getRight();
            if (n11 > 0) {
                mobDrawerLayout$DrawerType = this.paint;
                float f22 = n11;
                float f23 = n11 += 25;
                int n17 = -1 << -1;
                float f24 = -0.0f;
                boolean bl5 = false;
                Object var15_43 = null;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                LinearGradient linearGradient = new LinearGradient(f22, 0.0f, f23, 0.0f, n17, 0, tileMode);
                mobDrawerLayout$DrawerType.setShader((Shader)linearGradient);
                n10 = this.getHeight();
                float f25 = n10;
                Paint paint = this.paint;
                canvas.drawRect(f22, 0.0f, f23, f25, paint);
            }
        }
    }

    private void init(Context context) {
        FrameLayout frameLayout;
        int n10;
        int n11;
        Object object;
        this.scroller = object = SmoothScroller.DEFAULT.getScroller(context);
        object = ViewConfiguration.get((Context)context);
        this.touchSlop = n11 = object.getScaledTouchSlop();
        this.maximumVelocity = n10 = object.getScaledMaximumFlingVelocity();
        object = MobDrawerLayout$DrawerType.LEFT_COVER;
        this.type = object;
        this.drawerWidth = 0.8;
        this.touchState = 0;
        object = new Paint();
        this.paint = object;
        object = new MobDrawerLayout$1(this);
        this.bodyContainer = frameLayout = new FrameLayout(context);
        frameLayout.setOnClickListener((View.OnClickListener)object);
        this.drawerContainer = frameLayout = new FrameLayout(context);
        frameLayout.setOnClickListener((View.OnClickListener)object);
        context = this.bodyContainer;
        this.addView((View)context);
        context = this.drawerContainer;
        this.addView((View)context);
    }

    private boolean isClose() {
        int n10;
        block6: {
            int n11;
            block7: {
                Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
                MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
                n11 = mobDrawerLayout$DrawerType.ordinal();
                int n12 = object[n11];
                n11 = 1;
                n10 = 0;
                switch (n12) {
                    default: {
                        break block6;
                    }
                    case 5: 
                    case 6: {
                        object = this.bodyContainer;
                        n12 = object.getRight();
                        int n13 = this.getWidth();
                        if (n12 != n13) break;
                        break block7;
                    }
                    case 3: 
                    case 4: {
                        object = this.bodyContainer;
                        n12 = object.getLeft();
                        if (n12 != 0) break;
                        break block7;
                    }
                    case 2: {
                        object = this.drawerContainer;
                        n12 = object.getLeft();
                        int n14 = this.getWidth();
                        if (n12 != n14) break;
                        break block7;
                    }
                    case 1: {
                        object = this.drawerContainer;
                        n12 = object.getRight();
                        if (n12 == 0) break block7;
                    }
                }
                n11 = 0;
                mobDrawerLayout$DrawerType = null;
            }
            n10 = n11;
        }
        return n10 != 0;
    }

    private void switchDrawer(boolean n10, boolean bl2) {
        int n11;
        FrameLayout frameLayout;
        int n12;
        int n13;
        Object object;
        block11: {
            double d10;
            int n14;
            block12: {
                double d11;
                this.bodyContainer.clearFocus();
                this.drawerContainer.clearFocus();
                object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
                n13 = this.type.ordinal();
                n14 = object[n13];
                n13 = 0;
                d10 = 0.0;
                switch (n14) {
                    default: {
                        n10 = 0;
                        n12 = 0;
                        break block11;
                    }
                    case 5: {
                        object = this.bodyContainer;
                        n14 = object.getLeft();
                        if (n10 != 0) {
                            n10 = -this.getWidth();
                            d10 = n10;
                            d11 = this.drawerWidth;
                            break;
                        }
                        break block12;
                    }
                    case 3: {
                        object = this.bodyContainer;
                        n14 = object.getLeft();
                        if (n10 != 0) {
                            n10 = this.getWidth();
                            d10 = n10;
                            d11 = this.drawerWidth;
                            break;
                        }
                        break block12;
                    }
                    case 2: 
                    case 6: {
                        n14 = this.getWidth();
                        frameLayout = this.drawerContainer;
                        n11 = frameLayout.getLeft();
                        if (n10 != 0) {
                            d10 = n14;
                            double d12 = this.drawerWidth;
                            d10 *= d12;
                        }
                        n10 = (int)d10;
                        n10 = n14 - n10;
                        n12 = n11;
                        break block11;
                    }
                    case 1: 
                    case 4: {
                        object = this.drawerContainer;
                        n14 = object.getLeft();
                        if (n10 != 0) break block12;
                        n10 = -this.getWidth();
                        d10 = n10;
                        d11 = this.drawerWidth;
                    }
                }
                d10 *= d11;
            }
            n10 = (int)d10;
            n12 = n14;
        }
        object = this.scroller;
        object.abortAnimation();
        if (n12 != n10) {
            Scroller scroller = this.scroller;
            n11 = 0;
            frameLayout = null;
            int n15 = n10 - n12;
            if (!bl2) {
                n13 = 100;
            }
            scroller.startScroll(n12, 0, n15, 0, n13);
        }
        this.invalidate();
    }

    public void close() {
        this.close(false);
    }

    public void close(boolean bl2) {
        this.switchDrawer(false, bl2);
    }

    public void computeScroll() {
        Object object = this.scroller;
        int n10 = object.computeScrollOffset();
        int n11 = 0;
        Object object2 = null;
        if (n10 != 0) {
            object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
            int n12 = mobDrawerLayout$DrawerType.ordinal();
            n10 = object[n12];
            switch (n10 ? 1 : 0) {
                default: {
                    break;
                }
                case 6: {
                    n10 = this.getWidth();
                    mobDrawerLayout$DrawerType = this.scroller;
                    n12 = mobDrawerLayout$DrawerType.getCurrX();
                    int n13 = n12 - n10;
                    double d10 = n10;
                    double d11 = this.drawerWidth;
                    n10 = (int)(d10 *= d11) + n12;
                    FrameLayout frameLayout = this.bodyContainer;
                    int n14 = this.getHeight();
                    frameLayout.layout(n13, 0, n12, n14);
                    FrameLayout frameLayout2 = this.drawerContainer;
                    int n15 = this.getHeight();
                    frameLayout2.layout(n12, 0, n10, n15);
                    break;
                }
                case 4: {
                    n10 = this.getWidth();
                    n12 = this.scroller.getCurrX();
                    double d12 = n10;
                    double d13 = this.drawerWidth;
                    int n16 = (int)(d12 *= d13) + n12;
                    FrameLayout frameLayout = this.drawerContainer;
                    int n17 = this.getHeight();
                    frameLayout.layout(n12, 0, n16, n17);
                    mobDrawerLayout$DrawerType = this.bodyContainer;
                    int n18 = this.getHeight();
                    mobDrawerLayout$DrawerType.layout(n16, 0, n10 += n16, n18);
                    break;
                }
                case 3: 
                case 5: {
                    object = this.scroller;
                    n10 = object.getCurrX();
                    n12 = this.getWidth() + n10;
                    FrameLayout frameLayout = this.bodyContainer;
                    int n19 = this.getHeight();
                    frameLayout.layout(n10, 0, n12, n19);
                    break;
                }
                case 1: 
                case 2: {
                    object = this.scroller;
                    n10 = object.getCurrX();
                    double d14 = this.getWidth();
                    double d15 = this.drawerWidth;
                    n12 = (int)(d14 *= d15) + n10;
                    FrameLayout frameLayout = this.drawerContainer;
                    int n20 = this.getHeight();
                    frameLayout.layout(n10, 0, n12, n20);
                }
            }
            this.postInvalidate();
            object = this.listener;
            if (object != null && (n10 = (object = this.scroller).getFinalX()) != (n11 = (object2 = this.scroller).getStartX())) {
                object = this.scroller;
                n10 = object.getCurrX();
                n11 = this.scroller.getStartX();
                n10 = (n10 - n11) * 100;
                object2 = this.scroller;
                n11 = object2.getFinalX();
                mobDrawerLayout$DrawerType = this.scroller;
                n12 = mobDrawerLayout$DrawerType.getStartX();
                n10 /= (n11 -= n12);
                n11 = (int)(this.opened ? 1 : 0);
                if (n11 != 0) {
                    object2 = this.listener;
                    object2.onClosing(this, n10);
                } else {
                    object2 = this.listener;
                    object2.onOpening(this, n10);
                }
            }
            return;
        }
        n10 = this.isClose();
        if (n10 != 0) {
            this.opened = false;
            return;
        }
        this.opened = true;
    }

    public void dispatchDraw(Canvas canvas) {
        long l10 = this.getDrawingTime();
        Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
        MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
        int n10 = mobDrawerLayout$DrawerType.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1) && n11 != (n10 = 2) && n11 != (n10 = 6)) {
            object = this.drawerContainer;
            mobDrawerLayout$DrawerType = this.bodyContainer;
        } else {
            object = this.bodyContainer;
            mobDrawerLayout$DrawerType = this.drawerContainer;
        }
        this.drawChild(canvas, (View)object, l10);
        this.drawChild(canvas, (View)mobDrawerLayout$DrawerType, l10);
        this.drawShadow(canvas);
    }

    public boolean isOpened() {
        return this.opened;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11;
        int n12;
        block9: {
            float f10;
            float f11;
            block6: {
                float f12;
                block7: {
                    float f13;
                    int n13;
                    block8: {
                        int n14;
                        int n15 = this.lockScroll;
                        n12 = 0;
                        if (n15 != 0) {
                            return false;
                        }
                        n15 = motionEvent.getAction();
                        n13 = 2;
                        f13 = 2.8E-45f;
                        n11 = 1;
                        if (n15 == n13 && (n14 = this.touchState) != 0) {
                            return n11 != 0;
                        }
                        VelocityTracker velocityTracker = this.velocityTracker;
                        if (velocityTracker == null) {
                            this.velocityTracker = velocityTracker = VelocityTracker.obtain();
                        }
                        velocityTracker = this.velocityTracker;
                        velocityTracker.addMovement(motionEvent);
                        if (n15 == 0) break block6;
                        if (n15 == n11) break block7;
                        if (n15 == n13) break block8;
                        n10 = 3;
                        f12 = 4.2E-45f;
                        if (n15 == n10) break block7;
                        break block9;
                    }
                    float f14 = motionEvent.getX();
                    float f15 = motionEvent.getY();
                    f13 = this.lastMotionX;
                    f13 = Math.abs(f14 - f13);
                    n13 = (int)f13;
                    float f16 = this.lastMotionY;
                    n10 = (int)(f15 = Math.abs(f15 - f16));
                    if (n10 < n13 && n13 > (n10 = this.touchSlop)) {
                        this.touchState = n11;
                        this.lastMotionX = f14;
                    }
                    break block9;
                }
                if ((motionEvent = this.velocityTracker) != null) {
                    motionEvent.recycle();
                    n10 = 0;
                    f12 = 0.0f;
                    motionEvent = null;
                    this.velocityTracker = null;
                }
                this.touchState = 0;
                break block9;
            }
            this.lastMotionX = f11 = motionEvent.getX();
            this.lastMotionY = f10 = motionEvent.getY();
            motionEvent = this.scroller;
            this.touchState = n10 = motionEvent.isFinished() ^ n11;
        }
        n10 = this.touchState;
        if (n10 != 0) {
            n12 = n11;
        }
        return n12 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        void var5_14;
        void var4_13;
        int n14;
        boolean bl3;
        var5_14 -= bl3;
        double d10 = (double)(var4_13 -= n14);
        double d11 = this.drawerWidth;
        int n15 = (int)(d10 *= d11);
        n14 = this.isOpened();
        bl3 = false;
        if (n14 != 0) {
            Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
            int n16 = mobDrawerLayout$DrawerType.ordinal();
            n14 = object[n16];
            switch (n14) {
                default: {
                    break;
                }
                case 6: {
                    object = this.bodyContainer;
                    n16 = -n15;
                    void var1_3 = var4_13 - n15;
                    object.layout(n16, 0, (int)var1_3, (int)var5_14);
                    object = this.drawerContainer;
                    object.layout((int)var1_3, 0, (int)var4_13, (int)var5_14);
                    break;
                }
                case 5: {
                    object = this.bodyContainer;
                    n16 = -n15;
                    void var1_4 = var4_13 - n15;
                    object.layout(n16, 0, (int)var1_4, (int)var5_14);
                    object = this.drawerContainer;
                    object.layout((int)var1_4, 0, (int)var4_13, (int)var5_14);
                    break;
                }
                case 4: {
                    object = this.bodyContainer;
                    object.layout(n15, 0, (int)(var4_13 += n15), (int)var5_14);
                    object = this.drawerContainer;
                    object.layout(0, 0, n15, (int)var5_14);
                    break;
                }
                case 3: {
                    object = this.bodyContainer;
                    object.layout(n15, 0, (int)(var4_13 += n15), (int)var5_14);
                    object = this.drawerContainer;
                    object.layout(0, 0, n15, (int)var5_14);
                    break;
                }
                case 2: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    void var1_5 = var4_13 - n15;
                    object.layout((int)var1_5, 0, (int)var4_13, (int)var5_14);
                    break;
                }
                case 1: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    object.layout(0, 0, n15, (int)var5_14);
                    break;
                }
            }
        } else {
            Object object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType = this.type;
            int n17 = mobDrawerLayout$DrawerType.ordinal();
            n14 = object[n17];
            switch (n14) {
                default: {
                    break;
                }
                case 6: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    int n18 = n15 + var4_13;
                    object.layout((int)var4_13, 0, n18, (int)var5_14);
                    break;
                }
                case 5: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    void var1_7 = var4_13 - n15;
                    object.layout((int)var1_7, 0, (int)var4_13, (int)var5_14);
                    break;
                }
                case 4: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    int n19 = -n15;
                    object.layout(n19, 0, 0, (int)var5_14);
                    break;
                }
                case 3: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    object.layout(0, 0, n15, (int)var5_14);
                    break;
                }
                case 2: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    int n20 = n15 + var4_13;
                    object.layout((int)var4_13, 0, n20, (int)var5_14);
                    break;
                }
                case 1: {
                    this.bodyContainer.layout(0, 0, (int)var4_13, (int)var5_14);
                    object = this.drawerContainer;
                    int n21 = -n15;
                    object.layout(n21, 0, 0, (int)var5_14);
                }
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        n10 = this.getMeasuredWidth();
        n11 = this.getMeasuredHeight();
        int n12 = 0x40000000;
        int n13 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n12);
        n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n12);
        this.bodyContainer.measure(n13, n11);
        double d10 = n10;
        double d11 = this.drawerWidth;
        n10 = View.MeasureSpec.makeMeasureSpec((int)((int)(d10 * d11)), (int)n12);
        this.drawerContainer.measure(n10, n11);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        block11: {
            int n11;
            VelocityTracker velocityTracker;
            block8: {
                float f10;
                int n12;
                float f11;
                int n13;
                block9: {
                    block10: {
                        velocityTracker = this.velocityTracker;
                        if (velocityTracker == null) {
                            this.velocityTracker = velocityTracker = VelocityTracker.obtain();
                        }
                        velocityTracker = this.velocityTracker;
                        velocityTracker.addMovement(motionEvent);
                        n11 = motionEvent.getAction();
                        n10 = 1;
                        if (n11 == 0) break block8;
                        if (n11 == n10) break block9;
                        n13 = 2;
                        f11 = 2.8E-45f;
                        if (n11 == n13) break block10;
                        n12 = 3;
                        f10 = 4.2E-45f;
                        if (n11 == n12) break block9;
                        break block11;
                    }
                    n11 = this.touchState;
                    if (n11 == n10 || (n11 = (int)(this.onInterceptTouchEvent(motionEvent) ? 1 : 0)) != 0 && (n11 = this.touchState) == n10) {
                        float f12 = motionEvent.getX();
                        float f13 = this.lastMotionX - f12;
                        n11 = (int)f13;
                        if (n11 < 0) {
                            n11 = -n11;
                            this.dragToRight(n11);
                        } else if (n11 > 0) {
                            this.dragToLeft(n11);
                        }
                        this.lastMotionX = f12;
                    }
                    break block11;
                }
                if ((n12 = this.touchState) == n10 && (motionEvent = this.velocityTracker) != null) {
                    n11 = 1000;
                    float f14 = 1.401E-42f;
                    n13 = this.maximumVelocity;
                    f11 = n13;
                    motionEvent.computeCurrentVelocity(n11, f11);
                    n12 = (int)this.velocityTracker.getXVelocity();
                    this.computeDrag(n12);
                    this.velocityTracker.recycle();
                    n12 = 0;
                    f10 = 0.0f;
                    motionEvent = null;
                    this.velocityTracker = null;
                }
                n12 = 0;
                f10 = 0.0f;
                motionEvent = null;
                this.touchState = 0;
                break block11;
            }
            n11 = this.touchState;
            if (n11 != 0) {
                float f15;
                velocityTracker = this.scroller;
                n11 = (int)(velocityTracker.isFinished() ? 1 : 0);
                if (n11 == 0) {
                    velocityTracker = this.scroller;
                    velocityTracker.abortAnimation();
                }
                this.lastMotionX = f15 = motionEvent.getX();
            }
        }
        return n10 != 0;
    }

    public void open() {
        this.open(false);
    }

    public void open(boolean bl2) {
        this.switchDrawer(true, bl2);
    }

    public void setBody(View view) {
        FrameLayout frameLayout = this.bodyContainer;
        int n10 = frameLayout.getChildCount();
        if (n10 == 0) {
            n10 = 0;
            frameLayout = null;
        } else {
            frameLayout = this.bodyContainer.getChildAt(0);
        }
        n10 = (int)(ResHelper.isEqual(frameLayout, view) ? 1 : 0);
        if (n10 == 0) {
            this.bodyContainer.removeAllViews();
            frameLayout = this.bodyContainer;
            frameLayout.addView(view);
        }
    }

    public void setDrawer(View view) {
        FrameLayout frameLayout = this.drawerContainer;
        int n10 = frameLayout.getChildCount();
        if (n10 == 0) {
            n10 = 0;
            frameLayout = null;
        } else {
            frameLayout = this.drawerContainer.getChildAt(0);
        }
        n10 = (int)(ResHelper.isEqual(frameLayout, view) ? 1 : 0);
        if (n10 == 0) {
            this.drawerContainer.removeAllViews();
            frameLayout = this.drawerContainer;
            frameLayout.addView(view);
        }
    }

    public void setDrawerType(MobDrawerLayout$DrawerType mobDrawerLayout$DrawerType) {
        Object object;
        if (mobDrawerLayout$DrawerType == null) {
            mobDrawerLayout$DrawerType = MobDrawerLayout$DrawerType.LEFT_COVER;
        }
        if ((object = this.type) != mobDrawerLayout$DrawerType) {
            this.type = mobDrawerLayout$DrawerType;
            object = MobDrawerLayout$2.$SwitchMap$com$mob$tools$gui$MobDrawerLayout$DrawerType;
            Object object2 = mobDrawerLayout$DrawerType.ordinal();
            Object object3 = 1;
            if ((object2 = (Object)((Object)object[object2])) != object3 && object2 != (object3 = 2)) {
                mobDrawerLayout$DrawerType = this.bodyContainer;
                mobDrawerLayout$DrawerType.bringToFront();
            } else {
                mobDrawerLayout$DrawerType = this.drawerContainer;
                mobDrawerLayout$DrawerType.bringToFront();
            }
            this.postInvalidate();
        }
    }

    public void setDrawerWidth(double d10) {
        double d11;
        double d12;
        double d13;
        double d14 = 0.0;
        double d15 = d10 - d14;
        Object object = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
        if (object < 0) {
            d10 = 0.8f;
        }
        if ((d13 = (d12 = d10 - (d14 = 1.0)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) > 0) {
            d10 = d14;
        }
        if ((object = (d11 = (d14 = this.drawerWidth) - d10) == 0.0 ? 0 : (d11 > 0.0 ? 1 : -1)) != false) {
            this.drawerWidth = d10;
            this.postInvalidate();
        }
    }

    public void setLockScroll(boolean bl2) {
        this.lockScroll = bl2;
    }

    public void setOnDrawerStateChangeListener(MobDrawerLayout$OnDrawerStateChangeListener mobDrawerLayout$OnDrawerStateChangeListener) {
        this.listener = mobDrawerLayout$OnDrawerStateChangeListener;
    }
}

