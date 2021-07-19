/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator$1;
import androidx.recyclerview.widget.DefaultItemAnimator$2;
import androidx.recyclerview.widget.DefaultItemAnimator$3;
import androidx.recyclerview.widget.DefaultItemAnimator$4;
import androidx.recyclerview.widget.DefaultItemAnimator$5;
import androidx.recyclerview.widget.DefaultItemAnimator$6;
import androidx.recyclerview.widget.DefaultItemAnimator$7;
import androidx.recyclerview.widget.DefaultItemAnimator$8;
import androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo;
import androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator
extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    public ArrayList mAddAnimations;
    public ArrayList mAdditionsList;
    public ArrayList mChangeAnimations;
    public ArrayList mChangesList;
    public ArrayList mMoveAnimations;
    public ArrayList mMovesList;
    private ArrayList mPendingAdditions;
    private ArrayList mPendingChanges;
    private ArrayList mPendingMoves;
    private ArrayList mPendingRemovals;
    public ArrayList mRemoveAnimations;

    public DefaultItemAnimator() {
        ArrayList arrayList;
        this.mPendingRemovals = arrayList = new ArrayList();
        this.mPendingAdditions = arrayList = new ArrayList();
        this.mPendingMoves = arrayList = new ArrayList();
        this.mPendingChanges = arrayList = new ArrayList();
        this.mAdditionsList = arrayList = new ArrayList();
        this.mMovesList = arrayList = new ArrayList();
        this.mChangesList = arrayList = new ArrayList();
        this.mAddAnimations = arrayList = new ArrayList();
        this.mMoveAnimations = arrayList = new ArrayList();
        this.mRemoveAnimations = arrayList = new ArrayList();
        this.mChangeAnimations = arrayList = new ArrayList();
    }

    private void animateRemoveImpl(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.mRemoveAnimations.add(recyclerView$ViewHolder);
        long l10 = this.getRemoveDuration();
        ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator.setDuration(l10).alpha(0.0f);
        DefaultItemAnimator$4 defaultItemAnimator$4 = new DefaultItemAnimator$4(this, recyclerView$ViewHolder, viewPropertyAnimator, view);
        viewPropertyAnimator2.setListener((Animator.AnimatorListener)defaultItemAnimator$4).start();
    }

    private void endChangeAnimation(List list, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$ViewHolder recyclerView$ViewHolder2;
            DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo = (DefaultItemAnimator$ChangeInfo)list.get(i10);
            boolean bl2 = this.endChangeAnimationIfNecessary(defaultItemAnimator$ChangeInfo, recyclerView$ViewHolder);
            if (!bl2 || (recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.oldHolder) != null || (recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.newHolder) != null) continue;
            list.remove(defaultItemAnimator$ChangeInfo);
        }
    }

    private void endChangeAnimationIfNecessary(DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = defaultItemAnimator$ChangeInfo.oldHolder;
        if (recyclerView$ViewHolder != null) {
            this.endChangeAnimationIfNecessary(defaultItemAnimator$ChangeInfo, recyclerView$ViewHolder);
        }
        if ((recyclerView$ViewHolder = defaultItemAnimator$ChangeInfo.newHolder) != null) {
            this.endChangeAnimationIfNecessary(defaultItemAnimator$ChangeInfo, recyclerView$ViewHolder);
        }
    }

    private boolean endChangeAnimationIfNecessary(DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        block4: {
            boolean bl2;
            boolean bl3;
            block3: {
                RecyclerView$ViewHolder recyclerView$ViewHolder2;
                block2: {
                    recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.newHolder;
                    bl3 = true;
                    bl2 = false;
                    if (recyclerView$ViewHolder2 != recyclerView$ViewHolder) break block2;
                    defaultItemAnimator$ChangeInfo.newHolder = null;
                    break block3;
                }
                recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.oldHolder;
                if (recyclerView$ViewHolder2 != recyclerView$ViewHolder) break block4;
                defaultItemAnimator$ChangeInfo.oldHolder = null;
                bl2 = bl3;
            }
            recyclerView$ViewHolder.itemView.setAlpha(1.0f);
            recyclerView$ViewHolder.itemView.setTranslationX(0.0f);
            recyclerView$ViewHolder.itemView.setTranslationY(0.0f);
            this.dispatchChangeFinished(recyclerView$ViewHolder, bl2);
            return bl3;
        }
        return false;
    }

    private void resetAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        TimeInterpolator timeInterpolator = sDefaultInterpolator;
        if (timeInterpolator == null) {
            timeInterpolator = new ValueAnimator();
            sDefaultInterpolator = timeInterpolator = timeInterpolator.getInterpolator();
        }
        timeInterpolator = recyclerView$ViewHolder.itemView.animate();
        TimeInterpolator timeInterpolator2 = sDefaultInterpolator;
        timeInterpolator.setInterpolator(timeInterpolator2);
        this.endAnimation(recyclerView$ViewHolder);
    }

    public boolean animateAdd(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.resetAnimation(recyclerView$ViewHolder);
        recyclerView$ViewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(recyclerView$ViewHolder);
        return true;
    }

    public void animateAddImpl(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.mAddAnimations.add(recyclerView$ViewHolder);
        ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator.alpha(1.0f);
        long l10 = this.getAddDuration();
        viewPropertyAnimator2 = viewPropertyAnimator2.setDuration(l10);
        DefaultItemAnimator$5 defaultItemAnimator$5 = new DefaultItemAnimator$5(this, recyclerView$ViewHolder, view, viewPropertyAnimator);
        viewPropertyAnimator2.setListener((Animator.AnimatorListener)defaultItemAnimator$5).start();
    }

    public boolean animateChange(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, int n10, int n11, int n12, int n13) {
        DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo;
        if (recyclerView$ViewHolder == recyclerView$ViewHolder2) {
            DefaultItemAnimator defaultItemAnimator = this;
            RecyclerView$ViewHolder recyclerView$ViewHolder3 = recyclerView$ViewHolder;
            int n14 = n11;
            int n15 = n12;
            return this.animateMove(recyclerView$ViewHolder, n10, n11, n12, n13);
        }
        float f10 = recyclerView$ViewHolder.itemView.getTranslationX();
        Object object = recyclerView$ViewHolder.itemView;
        float f11 = object.getTranslationY();
        Object object2 = recyclerView$ViewHolder.itemView;
        float f12 = object2.getAlpha();
        this.resetAnimation(recyclerView$ViewHolder);
        float f13 = (float)(n12 - n10) - f10;
        int n16 = (int)f13;
        float f14 = (float)(n13 - n11) - f11;
        int n17 = (int)f14;
        View view = recyclerView$ViewHolder.itemView;
        view.setTranslationX(f10);
        recyclerView$ViewHolder.itemView.setTranslationY(f11);
        Object object3 = recyclerView$ViewHolder.itemView;
        object3.setAlpha(f12);
        if (recyclerView$ViewHolder2 != null) {
            this.resetAnimation(recyclerView$ViewHolder2);
            object3 = recyclerView$ViewHolder2.itemView;
            f11 = -n16;
            object3.setTranslationX(f11);
            object3 = recyclerView$ViewHolder2.itemView;
            f11 = -n17;
            object3.setTranslationY(f11);
            object3 = recyclerView$ViewHolder2.itemView;
            f11 = 0.0f;
            object = null;
            object3.setAlpha(0.0f);
        }
        object3 = this.mPendingChanges;
        object = defaultItemAnimator$ChangeInfo;
        object2 = recyclerView$ViewHolder;
        n17 = n10;
        defaultItemAnimator$ChangeInfo = new DefaultItemAnimator$ChangeInfo(recyclerView$ViewHolder, recyclerView$ViewHolder2, n10, n11, n12, n13);
        ((ArrayList)object3).add(defaultItemAnimator$ChangeInfo);
        return true;
    }

    public void animateChangeImpl(DefaultItemAnimator$ChangeInfo defaultItemAnimator$ChangeInfo) {
        Object object;
        Object object2;
        RecyclerView$ViewHolder recyclerView$ViewHolder = defaultItemAnimator$ChangeInfo.oldHolder;
        View view = null;
        recyclerView$ViewHolder = recyclerView$ViewHolder == null ? null : recyclerView$ViewHolder.itemView;
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = defaultItemAnimator$ChangeInfo.newHolder;
        if (recyclerView$ViewHolder2 != null) {
            view = recyclerView$ViewHolder2.itemView;
        }
        recyclerView$ViewHolder2 = null;
        if (recyclerView$ViewHolder != null) {
            object2 = recyclerView$ViewHolder.animate();
            long l10 = this.getChangeDuration();
            object2 = object2.setDuration(l10);
            object = this.mChangeAnimations;
            Object object3 = defaultItemAnimator$ChangeInfo.oldHolder;
            ((ArrayList)object).add(object3);
            int n10 = defaultItemAnimator$ChangeInfo.toX;
            int n11 = defaultItemAnimator$ChangeInfo.fromX;
            float f10 = n10 - n11;
            object2.translationX(f10);
            n10 = defaultItemAnimator$ChangeInfo.toY;
            n11 = defaultItemAnimator$ChangeInfo.fromY;
            f10 = n10 -= n11;
            object2.translationY(f10);
            object = object2.alpha(0.0f);
            object3 = new DefaultItemAnimator$7(this, defaultItemAnimator$ChangeInfo, (ViewPropertyAnimator)object2, (View)recyclerView$ViewHolder);
            recyclerView$ViewHolder = object.setListener((Animator.AnimatorListener)object3);
            recyclerView$ViewHolder.start();
        }
        if (view != null) {
            recyclerView$ViewHolder = view.animate();
            object2 = this.mChangeAnimations;
            object = defaultItemAnimator$ChangeInfo.newHolder;
            object2.add(object);
            recyclerView$ViewHolder2 = recyclerView$ViewHolder.translationX(0.0f).translationY(0.0f);
            long l11 = this.getChangeDuration();
            recyclerView$ViewHolder2 = recyclerView$ViewHolder2.setDuration(l11);
            float f11 = 1.0f;
            recyclerView$ViewHolder2 = recyclerView$ViewHolder2.alpha(f11);
            object2 = new DefaultItemAnimator$8(this, defaultItemAnimator$ChangeInfo, (ViewPropertyAnimator)recyclerView$ViewHolder, view);
            defaultItemAnimator$ChangeInfo = recyclerView$ViewHolder2.setListener((Animator.AnimatorListener)object2);
            defaultItemAnimator$ChangeInfo.start();
        }
    }

    public boolean animateMove(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, int n11, int n12, int n13) {
        View view = recyclerView$ViewHolder.itemView;
        float f10 = view.getTranslationX();
        int n14 = (int)f10;
        int n15 = n10 + n14;
        Object object = recyclerView$ViewHolder.itemView;
        float f11 = object.getTranslationY();
        n10 = (int)f11;
        int n16 = n11 + n10;
        this.resetAnimation(recyclerView$ViewHolder);
        n10 = n12 - n15;
        n11 = n13 - n16;
        if (n10 == 0 && n11 == 0) {
            this.dispatchMoveFinished(recyclerView$ViewHolder);
            return false;
        }
        if (n10 != 0) {
            n10 = -n10;
            f11 = n10;
            view.setTranslationX(f11);
        }
        if (n11 != 0) {
            n10 = -n11;
            f11 = n10;
            view.setTranslationY(f11);
        }
        object = this.mPendingMoves;
        DefaultItemAnimator$MoveInfo defaultItemAnimator$MoveInfo = new DefaultItemAnimator$MoveInfo(recyclerView$ViewHolder, n15, n16, n12, n13);
        ((ArrayList)object).add(defaultItemAnimator$MoveInfo);
        return true;
    }

    public void animateMoveImpl(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, int n11, int n12, int n13) {
        Object object;
        View view = recyclerView$ViewHolder.itemView;
        int n14 = n12 - n10;
        int n15 = n13 - n11;
        n10 = 0;
        ViewPropertyAnimator viewPropertyAnimator = null;
        if (n14 != 0) {
            object = view.animate();
            object.translationX(0.0f);
        }
        if (n15 != 0) {
            object = view.animate();
            object.translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimator2 = view.animate();
        this.mMoveAnimations.add(recyclerView$ViewHolder);
        long l10 = this.getMoveDuration();
        viewPropertyAnimator = viewPropertyAnimator2.setDuration(l10);
        object = new DefaultItemAnimator$6(this, recyclerView$ViewHolder, n14, view, n15, viewPropertyAnimator2);
        viewPropertyAnimator.setListener((Animator.AnimatorListener)object).start();
    }

    public boolean animateRemove(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.resetAnimation(recyclerView$ViewHolder);
        this.mPendingRemovals.add(recyclerView$ViewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, List list) {
        boolean bl2;
        boolean bl3 = list.isEmpty();
        if (bl3 && !(bl2 = super.canReuseUpdatedViewHolder(recyclerView$ViewHolder, list))) {
            bl2 = false;
            recyclerView$ViewHolder = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void cancelAll(List list) {
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            ViewPropertyAnimator viewPropertyAnimator = ((RecyclerView$ViewHolder)list.get((int)i10)).itemView.animate();
            viewPropertyAnimator.cancel();
        }
    }

    public void dispatchFinishedWhenDone() {
        boolean bl2 = this.isRunning();
        if (!bl2) {
            this.dispatchAnimationsFinished();
        }
    }

    public void endAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean bl2;
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean bl3;
        View view = recyclerView$ViewHolder.itemView;
        view.animate().cancel();
        ArrayList arrayList3 = this.mPendingMoves;
        int n10 = arrayList3.size() + -1;
        while (true) {
            bl3 = false;
            arrayList2 = null;
            if (n10 < 0) break;
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = ((DefaultItemAnimator$MoveInfo)this.mPendingMoves.get((int)n10)).holder;
            if (recyclerView$ViewHolder2 == recyclerView$ViewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                this.dispatchMoveFinished(recyclerView$ViewHolder);
                arrayList2 = this.mPendingMoves;
                arrayList2.remove(n10);
            }
            n10 += -1;
        }
        arrayList3 = this.mPendingChanges;
        this.endChangeAnimation(arrayList3, recyclerView$ViewHolder);
        arrayList3 = this.mPendingRemovals;
        n10 = (int)(arrayList3.remove(recyclerView$ViewHolder) ? 1 : 0);
        float f10 = 1.0f;
        if (n10 != 0) {
            view.setAlpha(f10);
            this.dispatchRemoveFinished(recyclerView$ViewHolder);
        }
        if ((n10 = (int)((arrayList3 = this.mPendingAdditions).remove(recyclerView$ViewHolder) ? 1 : 0)) != 0) {
            view.setAlpha(f10);
            this.dispatchAddFinished(recyclerView$ViewHolder);
        }
        arrayList3 = this.mChangesList;
        for (n10 = arrayList3.size() + -1; n10 >= 0; n10 += -1) {
            arrayList = (ArrayList)this.mChangesList.get(n10);
            this.endChangeAnimation(arrayList, recyclerView$ViewHolder);
            bl2 = arrayList.isEmpty();
            if (!bl2) continue;
            arrayList = this.mChangesList;
            arrayList.remove(n10);
        }
        arrayList3 = this.mMovesList;
        block2: for (n10 = arrayList3.size() + -1; n10 >= 0; n10 += -1) {
            arrayList = (ArrayList)this.mMovesList.get(n10);
            for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
                RecyclerView$ViewHolder recyclerView$ViewHolder3 = ((DefaultItemAnimator$MoveInfo)arrayList.get((int)i10)).holder;
                if (recyclerView$ViewHolder3 != recyclerView$ViewHolder) continue;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                this.dispatchMoveFinished(recyclerView$ViewHolder);
                arrayList.remove(i10);
                bl2 = arrayList.isEmpty();
                if (!bl2) continue block2;
                arrayList = this.mMovesList;
                arrayList.remove(n10);
                continue block2;
            }
        }
        arrayList3 = this.mAdditionsList;
        for (n10 = arrayList3.size() + -1; n10 >= 0; n10 += -1) {
            arrayList2 = (ArrayList)this.mAdditionsList.get(n10);
            bl2 = arrayList2.remove(recyclerView$ViewHolder);
            if (!bl2) continue;
            view.setAlpha(f10);
            this.dispatchAddFinished(recyclerView$ViewHolder);
            bl3 = arrayList2.isEmpty();
            if (!bl3) continue;
            arrayList2 = this.mAdditionsList;
            arrayList2.remove(n10);
        }
        this.mRemoveAnimations.remove(recyclerView$ViewHolder);
        this.mAddAnimations.remove(recyclerView$ViewHolder);
        this.mChangeAnimations.remove(recyclerView$ViewHolder);
        this.mMoveAnimations.remove(recyclerView$ViewHolder);
        this.dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int n10;
        Object object;
        int n11;
        Object object2;
        float f10;
        int n12;
        Object object3;
        Object object4;
        Object object5;
        ArrayList arrayList = this.mPendingMoves;
        int n13 = arrayList.size() + -1;
        while (true) {
            object5 = null;
            if (n13 < 0) break;
            object4 = (DefaultItemAnimator$MoveInfo)this.mPendingMoves.get(n13);
            object3 = object4.holder.itemView;
            object3.setTranslationY(0.0f);
            object3.setTranslationX(0.0f);
            object5 = ((DefaultItemAnimator$MoveInfo)object4).holder;
            this.dispatchMoveFinished((RecyclerView$ViewHolder)object5);
            object5 = this.mPendingMoves;
            ((ArrayList)object5).remove(n13);
            n13 += -1;
        }
        arrayList = this.mPendingRemovals;
        for (n13 = arrayList.size() + -1; n13 >= 0; n13 += -1) {
            object4 = (RecyclerView$ViewHolder)this.mPendingRemovals.get(n13);
            this.dispatchRemoveFinished((RecyclerView$ViewHolder)object4);
            object4 = this.mPendingRemovals;
            ((ArrayList)object4).remove(n13);
        }
        arrayList = this.mPendingAdditions;
        n13 = arrayList.size() + -1;
        while (true) {
            n12 = 1065353216;
            f10 = 1.0f;
            if (n13 < 0) break;
            object3 = (RecyclerView$ViewHolder)this.mPendingAdditions.get(n13);
            object2 = ((RecyclerView$ViewHolder)object3).itemView;
            object2.setAlpha(f10);
            this.dispatchAddFinished((RecyclerView$ViewHolder)object3);
            object4 = this.mPendingAdditions;
            ((ArrayList)object4).remove(n13);
            n13 += -1;
        }
        arrayList = this.mPendingChanges;
        for (n13 = arrayList.size() + -1; n13 >= 0; n13 += -1) {
            object3 = (DefaultItemAnimator$ChangeInfo)this.mPendingChanges.get(n13);
            this.endChangeAnimationIfNecessary((DefaultItemAnimator$ChangeInfo)object3);
        }
        arrayList = this.mPendingChanges;
        arrayList.clear();
        n13 = (int)(this.isRunning() ? 1 : 0);
        if (n13 == 0) {
            return;
        }
        arrayList = this.mMovesList;
        for (n13 = arrayList.size() + -1; n13 >= 0; n13 += -1) {
            object3 = (ArrayList)this.mMovesList.get(n13);
            for (n11 = ((ArrayList)object3).size() + -1; n11 >= 0; n11 += -1) {
                object = (DefaultItemAnimator$MoveInfo)((ArrayList)object3).get(n11);
                View view = object.holder.itemView;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                object = ((DefaultItemAnimator$MoveInfo)object).holder;
                this.dispatchMoveFinished((RecyclerView$ViewHolder)object);
                ((ArrayList)object3).remove(n11);
                boolean bl2 = ((ArrayList)object3).isEmpty();
                if (!bl2) continue;
                object = this.mMovesList;
                ((ArrayList)object).remove(object3);
            }
        }
        arrayList = this.mAdditionsList;
        for (n13 = arrayList.size() + -1; n13 >= 0; n13 += -1) {
            object5 = (ArrayList)this.mAdditionsList.get(n13);
            for (n10 = ((ArrayList)object5).size() + -1; n10 >= 0; n10 += -1) {
                object2 = (RecyclerView$ViewHolder)((ArrayList)object5).get(n10);
                object = ((RecyclerView$ViewHolder)object2).itemView;
                object.setAlpha(f10);
                this.dispatchAddFinished((RecyclerView$ViewHolder)object2);
                ((ArrayList)object5).remove(n10);
                n11 = (int)(((ArrayList)object5).isEmpty() ? 1 : 0);
                if (n11 == 0) continue;
                object2 = this.mAdditionsList;
                ((ArrayList)object2).remove(object5);
            }
        }
        arrayList = this.mChangesList;
        for (n13 = arrayList.size() + -1; n13 >= 0; n13 += -1) {
            object5 = (ArrayList)this.mChangesList.get(n13);
            for (n12 = ((ArrayList)object5).size() + -1; n12 >= 0; n12 += -1) {
                object3 = (DefaultItemAnimator$ChangeInfo)((ArrayList)object5).get(n12);
                this.endChangeAnimationIfNecessary((DefaultItemAnimator$ChangeInfo)object3);
                n10 = (int)(((ArrayList)object5).isEmpty() ? 1 : 0);
                if (n10 == 0) continue;
                object3 = this.mChangesList;
                ((ArrayList)object3).remove(object5);
            }
        }
        arrayList = this.mRemoveAnimations;
        this.cancelAll(arrayList);
        arrayList = this.mMoveAnimations;
        this.cancelAll(arrayList);
        arrayList = this.mAddAnimations;
        this.cancelAll(arrayList);
        arrayList = this.mChangeAnimations;
        this.cancelAll(arrayList);
        this.dispatchAnimationsFinished();
    }

    public boolean isRunning() {
        ArrayList arrayList = this.mPendingAdditions;
        boolean bl2 = arrayList.isEmpty();
        if (bl2 && (bl2 = (arrayList = this.mPendingChanges).isEmpty()) && (bl2 = (arrayList = this.mPendingMoves).isEmpty()) && (bl2 = (arrayList = this.mPendingRemovals).isEmpty()) && (bl2 = (arrayList = this.mMoveAnimations).isEmpty()) && (bl2 = (arrayList = this.mRemoveAnimations).isEmpty()) && (bl2 = (arrayList = this.mAddAnimations).isEmpty()) && (bl2 = (arrayList = this.mChangeAnimations).isEmpty()) && (bl2 = (arrayList = this.mMovesList).isEmpty()) && (bl2 = (arrayList = this.mAdditionsList).isEmpty()) && (bl2 = (arrayList = this.mChangesList).isEmpty())) {
            bl2 = false;
            arrayList = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void runPendingAnimations() {
        long l10;
        Object object;
        Object object2;
        boolean bl2;
        ArrayList arrayList = this.mPendingRemovals;
        boolean bl3 = arrayList.isEmpty() ^ true;
        ArrayList arrayList2 = this.mPendingMoves;
        boolean bl4 = arrayList2.isEmpty() ^ true;
        ArrayList arrayList3 = this.mPendingChanges;
        boolean bl5 = arrayList3.isEmpty() ^ true;
        ArrayList arrayList4 = this.mPendingAdditions;
        boolean bl6 = arrayList4.isEmpty() ^ true;
        if (!(bl3 || bl4 || bl6 || bl5)) {
            return;
        }
        Iterator iterator2 = this.mPendingRemovals.iterator();
        while (bl2 = iterator2.hasNext()) {
            object2 = (RecyclerView$ViewHolder)iterator2.next();
            this.animateRemoveImpl((RecyclerView$ViewHolder)object2);
        }
        this.mPendingRemovals.clear();
        iterator2 = null;
        if (bl4) {
            object2 = new ArrayList();
            object = this.mPendingMoves;
            ((ArrayList)object2).addAll(object);
            this.mMovesList.add(object2);
            this.mPendingMoves.clear();
            object = new DefaultItemAnimator$1(this, (ArrayList)object2);
            if (bl3) {
                object2 = ((DefaultItemAnimator$MoveInfo)object2.get((int)0)).holder.itemView;
                l10 = this.getRemoveDuration();
                ViewCompat.postOnAnimationDelayed((View)object2, (Runnable)object, l10);
            } else {
                object.run();
            }
        }
        if (bl5) {
            object2 = new ArrayList();
            object = this.mPendingChanges;
            ((ArrayList)object2).addAll(object);
            this.mChangesList.add(object2);
            this.mPendingChanges.clear();
            object = new DefaultItemAnimator$2(this, (ArrayList)object2);
            if (bl3) {
                object2 = ((DefaultItemAnimator$ChangeInfo)object2.get((int)0)).oldHolder.itemView;
                l10 = this.getRemoveDuration();
                ViewCompat.postOnAnimationDelayed((View)object2, (Runnable)object, l10);
            } else {
                object.run();
            }
        }
        if (bl6) {
            arrayList4 = new ArrayList();
            object2 = this.mPendingAdditions;
            arrayList4.addAll(object2);
            this.mAdditionsList.add(arrayList4);
            this.mPendingAdditions.clear();
            object2 = new DefaultItemAnimator$3(this, arrayList4);
            if (!(bl3 || bl4 || bl5)) {
                object2.run();
            } else {
                long l11 = 0L;
                long l12 = bl3 ? this.getRemoveDuration() : l11;
                long l13 = bl4 ? this.getMoveDuration() : l11;
                if (bl5) {
                    l11 = this.getChangeDuration();
                }
                l13 = Math.max(l13, l11);
                arrayList = ((RecyclerView$ViewHolder)arrayList4.get((int)0)).itemView;
                ViewCompat.postOnAnimationDelayed((View)arrayList, (Runnable)object2, l12 += l13);
            }
        }
    }
}

