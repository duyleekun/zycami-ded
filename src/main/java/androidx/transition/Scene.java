/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId = -1;
    private ViewGroup mSceneRoot;

    public Scene(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
    }

    private Scene(ViewGroup viewGroup, int n10, Context context) {
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = n10;
    }

    public Scene(ViewGroup viewGroup, View view) {
        this.mSceneRoot = viewGroup;
        this.mLayout = view;
    }

    public static Scene getCurrentScene(ViewGroup viewGroup) {
        int n10 = R$id.transition_current_scene;
        return (Scene)viewGroup.getTag(n10);
    }

    public static Scene getSceneForLayout(ViewGroup viewGroup, int n10, Context context) {
        Scene scene;
        int n11 = R$id.transition_scene_layoutid_cache;
        SparseArray sparseArray = (SparseArray)viewGroup.getTag(n11);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(n11, (Object)sparseArray);
        }
        if ((scene = (Scene)sparseArray.get(n10)) != null) {
            return scene;
        }
        scene = new Scene(viewGroup, n10, context);
        sparseArray.put(n10, (Object)scene);
        return scene;
    }

    public static void setCurrentScene(ViewGroup viewGroup, Scene scene) {
        int n10 = R$id.transition_current_scene;
        viewGroup.setTag(n10, (Object)scene);
    }

    public void enter() {
        Object object;
        int n10 = this.mLayoutId;
        if (n10 > 0 || (object = this.mLayout) != null) {
            object = this.getSceneRoot();
            object.removeAllViews();
            n10 = this.mLayoutId;
            if (n10 > 0) {
                object = LayoutInflater.from((Context)this.mContext);
                int n11 = this.mLayoutId;
                ViewGroup viewGroup = this.mSceneRoot;
                object.inflate(n11, viewGroup);
            } else {
                object = this.mSceneRoot;
                View view = this.mLayout;
                object.addView(view);
            }
        }
        if ((object = this.mEnterAction) != null) {
            object.run();
        }
        Scene.setCurrentScene(this.mSceneRoot, this);
    }

    public void exit() {
        Object object = Scene.getCurrentScene(this.mSceneRoot);
        if (object == this && (object = this.mExitAction) != null) {
            object.run();
        }
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public boolean isCreatedFromLayoutResource() {
        int n10 = this.mLayoutId;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setEnterAction(Runnable runnable) {
        this.mEnterAction = runnable;
    }

    public void setExitAction(Runnable runnable) {
        this.mExitAction = runnable;
    }
}

