/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.CanvasUtils;
import androidx.transition.GhostView;
import androidx.transition.GhostViewHolder;
import androidx.transition.R$id;
import androidx.transition.ViewUtils;

public class GhostViewPort
extends ViewGroup
implements GhostView {
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    public int mReferences;
    public ViewGroup mStartParent;
    public View mStartView;
    public final View mView;

    public GhostViewPort(View view) {
        Object object = view.getContext();
        super(object);
        super(this);
        this.mOnPreDrawListener = object;
        this.mView = view;
        this.setWillNotDraw(false);
        this.setLayerType(2, null);
    }

    public static GhostViewPort addGhost(View object, ViewGroup viewGroup, Matrix matrix) {
        Object object2 = object.getParent();
        boolean bl2 = object2 instanceof ViewGroup;
        if (bl2) {
            int n10;
            GhostViewHolder ghostViewHolder;
            object2 = GhostViewHolder.getHolder(viewGroup);
            GhostViewPort ghostViewPort = GhostViewPort.getGhostView(object);
            int n11 = 0;
            if (ghostViewPort != null && (ghostViewHolder = (GhostViewHolder)ghostViewPort.getParent()) != object2) {
                n11 = ghostViewPort.mReferences;
                ghostViewHolder.removeView((View)ghostViewPort);
                ghostViewPort = null;
            }
            if (ghostViewPort == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    GhostViewPort.calculateMatrix(object, viewGroup, matrix);
                }
                ghostViewPort = new GhostViewPort((View)object);
                ghostViewPort.setMatrix(matrix);
                if (object2 == null) {
                    object2 = new GhostViewHolder(viewGroup);
                } else {
                    ((GhostViewHolder)((Object)object2)).popToOverlayTop();
                }
                GhostViewPort.copySize((View)viewGroup, (View)object2);
                GhostViewPort.copySize((View)viewGroup, (View)ghostViewPort);
                ((GhostViewHolder)((Object)object2)).addGhostView(ghostViewPort);
                ghostViewPort.mReferences = n11;
            } else if (matrix != null) {
                ghostViewPort.setMatrix(matrix);
            }
            ghostViewPort.mReferences = n10 = ghostViewPort.mReferences + 1;
            return ghostViewPort;
        }
        object = new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        throw object;
    }

    public static void calculateMatrix(View view, ViewGroup viewGroup, Matrix matrix) {
        view = (ViewGroup)view.getParent();
        matrix.reset();
        ViewUtils.transformMatrixToGlobal(view, matrix);
        float f10 = -view.getScrollX();
        float f11 = -view.getScrollY();
        matrix.preTranslate(f10, f11);
        ViewUtils.transformMatrixToLocal((View)viewGroup, matrix);
    }

    public static void copySize(View view, View view2) {
        int n10 = view2.getLeft();
        int n11 = view2.getTop();
        int n12 = view2.getLeft();
        int n13 = view.getWidth();
        n12 += n13;
        n13 = view2.getTop();
        int n14 = view.getHeight();
        ViewUtils.setLeftTopRightBottom(view2, n10, n11, n12, n13 += n14);
    }

    public static GhostViewPort getGhostView(View view) {
        int n10 = R$id.ghost_view;
        return (GhostViewPort)view.getTag(n10);
    }

    public static void removeGhost(View object) {
        if ((object = GhostViewPort.getGhostView(object)) != null) {
            int n10;
            object.mReferences = n10 = object.mReferences + -1;
            if (n10 <= 0) {
                GhostViewHolder ghostViewHolder = (GhostViewHolder)object.getParent();
                ghostViewHolder.removeView((View)object);
            }
        }
    }

    public static void setGhostView(View view, GhostViewPort ghostViewPort) {
        int n10 = R$id.ghost_view;
        view.setTag(n10, (Object)ghostViewPort);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GhostViewPort.setGhostView(this.mView, this);
        ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.mOnPreDrawListener;
        viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
        viewTreeObserver = this.mView;
        int n10 = 4;
        ViewUtils.setTransitionVisibility((View)viewTreeObserver, n10);
        viewTreeObserver = this.mView.getParent();
        if (viewTreeObserver != null) {
            viewTreeObserver = (View)this.mView.getParent();
            viewTreeObserver.invalidate();
        }
    }

    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.mOnPreDrawListener;
        viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        viewTreeObserver = this.mView;
        onPreDrawListener = null;
        GhostViewPort.setGhostView((View)viewTreeObserver, null);
        viewTreeObserver = this.mView.getParent();
        if (viewTreeObserver != null) {
            viewTreeObserver = (View)this.mView.getParent();
            viewTreeObserver.invalidate();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        CanvasUtils.enableZ(canvas, true);
        Matrix matrix = this.mMatrix;
        canvas.setMatrix(matrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        matrix = this.mView;
        long l10 = this.getDrawingTime();
        this.drawChild(canvas, (View)matrix, l10);
        CanvasUtils.enableZ(canvas, false);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    public void setMatrix(Matrix matrix) {
        this.mMatrix = matrix;
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        GhostViewPort ghostViewPort = GhostViewPort.getGhostView(this.mView);
        if (ghostViewPort == this) {
            n10 = n10 == 0 ? 4 : 0;
            ghostViewPort = this.mView;
            ViewUtils.setTransitionVisibility((View)ghostViewPort, n10);
        }
    }
}

