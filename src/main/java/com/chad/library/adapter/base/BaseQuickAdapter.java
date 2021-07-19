/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 */
package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams;
import com.chad.library.adapter.base.BaseQuickAdapter$AnimationType;
import com.chad.library.adapter.base.BaseQuickAdapter$Companion;
import com.chad.library.adapter.base.BaseQuickAdapter$WhenMappings;
import com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1;
import com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2;
import com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$3;
import com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4;
import com.chad.library.adapter.base.BaseQuickAdapter$onAttachedToRecyclerView$1;
import com.chad.library.adapter.base.BaseQuickAdapterModuleImp;
import com.chad.library.adapter.base.BaseQuickAdapterModuleImp$DefaultImpls;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.animation.SlideInLeftAnimation;
import com.chad.library.adapter.base.animation.SlideInRightAnimation;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig$Builder;
import com.chad.library.adapter.base.diff.BrvahListUpdateCallback;
import com.chad.library.adapter.base.listener.BaseListenerImp;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.UpFetchModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import f.h2.t.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;

public abstract class BaseQuickAdapter
extends RecyclerView$Adapter
implements BaseQuickAdapterModuleImp,
BaseListenerImp {
    public static final BaseQuickAdapter$Companion Companion;
    public static final int EMPTY_VIEW = 0x10000555;
    public static final int FOOTER_VIEW = 0x10000333;
    public static final int HEADER_VIEW = 0x10000111;
    public static final int LOAD_MORE_VIEW = 0x10000222;
    private BaseAnimation adapterAnimation;
    private boolean animationEnable;
    private final LinkedHashSet childClickViewIds;
    private final LinkedHashSet childLongClickViewIds;
    private Context context;
    private List data;
    private boolean footerViewAsFlow;
    private boolean footerWithEmptyEnable;
    private boolean headerViewAsFlow;
    private boolean headerWithEmptyEnable;
    private boolean isAnimationFirstOnly;
    private boolean isUseEmpty;
    private final int layoutResId;
    private BrvahAsyncDiffer mDiffHelper;
    private BaseDraggableModule mDraggableModule;
    private FrameLayout mEmptyLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mHeaderLayout;
    private int mLastPosition;
    private BaseLoadMoreModule mLoadMoreModule;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private RecyclerView mRecyclerView;
    private GridSpanSizeLookup mSpanSizeLookup;
    private BaseUpFetchModule mUpFetchModule;
    public WeakReference weakRecyclerView;

    static {
        BaseQuickAdapter$Companion baseQuickAdapter$Companion;
        Companion = baseQuickAdapter$Companion = new BaseQuickAdapter$Companion(null);
    }

    public BaseQuickAdapter(int n10) {
        this(n10, null, 2, null);
    }

    public BaseQuickAdapter(int n10, List list) {
        LinkedHashSet linkedHashSet;
        this.layoutResId = n10;
        if (list == null) {
        }
        this.data = list;
        n10 = 1;
        this.isUseEmpty = n10;
        this.isAnimationFirstOnly = n10;
        this.mLastPosition = -1;
        this.checkModule();
        this.childClickViewIds = linkedHashSet = new LinkedHashSet();
        this.childLongClickViewIds = linkedHashSet = new LinkedHashSet();
    }

    public /* synthetic */ BaseQuickAdapter(int n10, List list, int n11, u u10) {
        if ((n11 &= 2) != 0) {
            list = null;
        }
        this(n10, list);
    }

    public static final /* synthetic */ FrameLayout access$getMEmptyLayout$p(BaseQuickAdapter baseQuickAdapter) {
        baseQuickAdapter = baseQuickAdapter.mEmptyLayout;
        if (baseQuickAdapter == null) {
            String string2 = "mEmptyLayout";
            f0.S(string2);
        }
        return baseQuickAdapter;
    }

    public static final /* synthetic */ LinearLayout access$getMFooterLayout$p(BaseQuickAdapter baseQuickAdapter) {
        baseQuickAdapter = baseQuickAdapter.mFooterLayout;
        if (baseQuickAdapter == null) {
            String string2 = "mFooterLayout";
            f0.S(string2);
        }
        return baseQuickAdapter;
    }

    public static final /* synthetic */ LinearLayout access$getMHeaderLayout$p(BaseQuickAdapter baseQuickAdapter) {
        baseQuickAdapter = baseQuickAdapter.mHeaderLayout;
        if (baseQuickAdapter == null) {
            String string2 = "mHeaderLayout";
            f0.S(string2);
        }
        return baseQuickAdapter;
    }

    public static final /* synthetic */ GridSpanSizeLookup access$getMSpanSizeLookup$p(BaseQuickAdapter baseQuickAdapter) {
        return baseQuickAdapter.mSpanSizeLookup;
    }

    public static final /* synthetic */ void access$setMEmptyLayout$p(BaseQuickAdapter baseQuickAdapter, FrameLayout frameLayout) {
        baseQuickAdapter.mEmptyLayout = frameLayout;
    }

    public static final /* synthetic */ void access$setMFooterLayout$p(BaseQuickAdapter baseQuickAdapter, LinearLayout linearLayout) {
        baseQuickAdapter.mFooterLayout = linearLayout;
    }

    public static final /* synthetic */ void access$setMHeaderLayout$p(BaseQuickAdapter baseQuickAdapter, LinearLayout linearLayout) {
        baseQuickAdapter.mHeaderLayout = linearLayout;
    }

    public static final /* synthetic */ void access$setMSpanSizeLookup$p(BaseQuickAdapter baseQuickAdapter, GridSpanSizeLookup gridSpanSizeLookup) {
        baseQuickAdapter.mSpanSizeLookup = gridSpanSizeLookup;
    }

    private final void addAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10;
        int n11 = this.animationEnable;
        if (n11 != 0 && ((n11 = this.isAnimationFirstOnly) == 0 || (n11 = recyclerView$ViewHolder.getLayoutPosition()) > (n10 = this.mLastPosition))) {
            int n12;
            View view;
            Animator[] animatorArray = this.adapterAnimation;
            if (animatorArray == null) {
                n10 = 0;
                view = null;
                int n13 = 0;
                int n14 = 1;
                animatorArray = new AlphaInAnimation(0.0f, n14, null);
            }
            view = recyclerView$ViewHolder.itemView;
            f0.h(view, "holder.itemView");
            for (Animator animator2 : animatorArray.animators(view)) {
                int n15 = recyclerView$ViewHolder.getLayoutPosition();
                this.startAnim(animator2, n15);
            }
            this.mLastPosition = n12 = recyclerView$ViewHolder.getLayoutPosition();
        }
    }

    public static /* synthetic */ int addFooterView$default(BaseQuickAdapter object, View view, int n10, int n11, int n12, Object object2) {
        if (object2 == null) {
            int n13 = n12 & 2;
            if (n13 != 0) {
                n10 = -1;
            }
            if ((n12 &= 4) != 0) {
                n11 = 1;
            }
            return ((BaseQuickAdapter)object).addFooterView(view, n10, n11);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        throw object;
    }

    public static /* synthetic */ int addHeaderView$default(BaseQuickAdapter object, View view, int n10, int n11, int n12, Object object2) {
        if (object2 == null) {
            int n13 = n12 & 2;
            if (n13 != 0) {
                n10 = -1;
            }
            if ((n12 &= 4) != 0) {
                n11 = 1;
            }
            return ((BaseQuickAdapter)object).addHeaderView(view, n10, n11);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
        throw object;
    }

    private final void checkModule() {
        Object object;
        boolean bl2 = this instanceof LoadMoreModule;
        if (bl2) {
            object = this.addLoadMoreModule(this);
            this.mLoadMoreModule = object;
        }
        if (bl2 = this instanceof UpFetchModule) {
            this.mUpFetchModule = object = this.addUpFetchModule(this);
        }
        if (bl2 = this instanceof DraggableModule) {
            this.mDraggableModule = object = this.addDraggableModule(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final BaseViewHolder createBaseGenericKInstance(Class object, View view) {
        try {
            Class<View> clazz;
            int n10 = ((Class)object).isMemberClass();
            String string2 = "null cannot be cast to non-null type VH";
            int n11 = 1;
            if (n10 != 0) {
                n10 = ((Class)object).getModifiers();
                if ((n10 = (int)(Modifier.isStatic(n10) ? 1 : 0)) == 0) {
                    Class<View> clazz2;
                    Class<?> clazz3;
                    n10 = 2;
                    Class[] classArray = new Class[n10];
                    classArray[0] = clazz3 = this.getClass();
                    classArray[n11] = clazz2 = View.class;
                    object = ((Class)object).getDeclaredConstructor(classArray);
                    String string3 = "z.getDeclaredConstructor\u2026aClass, View::class.java)";
                    f0.h(object, string3);
                    ((Constructor)object).setAccessible(n11 != 0);
                    Object[] objectArray = new Object[n10];
                    objectArray[0] = this;
                    objectArray[n11] = view;
                    object = ((Constructor)object).newInstance(objectArray);
                    if (object != null) {
                        return (BaseViewHolder)object;
                    }
                    object = new TypeCastException(string2);
                    throw object;
                }
            }
            Object[] objectArray = new Class[n11];
            objectArray[0] = clazz = View.class;
            object = ((Class)object).getDeclaredConstructor((Class<?>[])objectArray);
            objectArray = "z.getDeclaredConstructor(View::class.java)";
            f0.h(object, (String)objectArray);
            ((Constructor)object).setAccessible(n11 != 0);
            objectArray = new Object[n11];
            objectArray[0] = view;
            object = ((Constructor)object).newInstance(objectArray);
            if (object != null) {
                return (BaseViewHolder)object;
            }
            object = new TypeCastException(string2);
            throw object;
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
            return null;
        }
        catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return null;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        return null;
    }

    private final Class getInstancedGenericKClass(Class type) {
        block19: {
            Class<BaseViewHolder> clazz = BaseViewHolder.class;
            type = ((Class)type).getGenericSuperclass();
            int n10 = type instanceof ParameterizedType;
            if (n10 == 0) break block19;
            type = (ParameterizedType)type;
            type = type.getActualTypeArguments();
            String string2 = "type.actualTypeArguments";
            f0.h(type, string2);
            n10 = ((Type)type).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object;
                Type type2 = type[i10];
                boolean bl2 = type2 instanceof Class;
                if (bl2) {
                    object = type2;
                    object = (Class)type2;
                    bl2 = clazz.isAssignableFrom((Class<?>)object);
                    if (!bl2) continue;
                    return (Class)type2;
                }
                bl2 = type2 instanceof ParameterizedType;
                if (!bl2) continue;
                type2 = (ParameterizedType)type2;
                type2 = type2.getRawType();
                object = "temp.rawType";
                f0.h(type2, (String)object);
                bl2 = type2 instanceof Class;
                if (!bl2) continue;
                object = type2;
                object = (Class)type2;
                bl2 = clazz.isAssignableFrom((Class<?>)object);
                if (!bl2) continue;
                try {
                    return (Class)type2;
                }
                catch (MalformedParameterizedTypeException malformedParameterizedTypeException) {
                    malformedParameterizedTypeException.printStackTrace();
                    break;
                }
                catch (TypeNotPresentException typeNotPresentException) {
                    typeNotPresentException.printStackTrace();
                    break;
                }
                catch (GenericSignatureFormatError genericSignatureFormatError) {
                    genericSignatureFormatError.printStackTrace();
                    break;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ int setFooterView$default(BaseQuickAdapter object, View view, int n10, int n11, int n12, Object object2) {
        if (object2 == null) {
            int n13 = n12 & 2;
            if (n13 != 0) {
                n10 = 0;
            }
            if ((n12 &= 4) != 0) {
                n11 = 1;
            }
            return ((BaseQuickAdapter)object).setFooterView(view, n10, n11);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
        throw object;
    }

    public static /* synthetic */ int setHeaderView$default(BaseQuickAdapter object, View view, int n10, int n11, int n12, Object object2) {
        if (object2 == null) {
            int n13 = n12 & 2;
            if (n13 != 0) {
                n10 = 0;
            }
            if ((n12 &= 4) != 0) {
                n11 = 1;
            }
            return ((BaseQuickAdapter)object).setHeaderView(view, n10, n11);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
        throw object;
    }

    public static /* synthetic */ void weakRecyclerView$annotations() {
    }

    public final void addChildClickViewIds(int ... nArray) {
        String string2 = "viewIds";
        f0.q(nArray, string2);
        for (int n10 : nArray) {
            LinkedHashSet linkedHashSet = this.childClickViewIds;
            Integer n11 = n10;
            linkedHashSet.add(n11);
        }
    }

    public final void addChildLongClickViewIds(int ... nArray) {
        String string2 = "viewIds";
        f0.q(nArray, string2);
        for (int n10 : nArray) {
            LinkedHashSet linkedHashSet = this.childLongClickViewIds;
            Integer n11 = n10;
            linkedHashSet.add(n11);
        }
    }

    public void addData(int n10, Object object) {
        this.data.add(n10, object);
        int n11 = this.getHeaderLayoutCount();
        this.notifyItemInserted(n10 += n11);
        this.compatibilityDataSizeChanged(1);
    }

    public void addData(int n10, Collection collection) {
        f0.q(collection, "newData");
        this.data.addAll(n10, collection);
        int n11 = this.getHeaderLayoutCount();
        n10 += n11;
        n11 = collection.size();
        this.notifyItemRangeInserted(n10, n11);
        n10 = collection.size();
        this.compatibilityDataSizeChanged(n10);
    }

    public void addData(Object object) {
        this.data.add(object);
        int n10 = this.data.size();
        int n11 = this.getHeaderLayoutCount();
        this.notifyItemInserted(n10 += n11);
        this.compatibilityDataSizeChanged(1);
    }

    public void addData(Collection collection) {
        f0.q(collection, "newData");
        this.data.addAll(collection);
        int n10 = this.data.size();
        int n11 = collection.size();
        n10 -= n11;
        n11 = this.getHeaderLayoutCount();
        n10 += n11;
        n11 = collection.size();
        this.notifyItemRangeInserted(n10, n11);
        int n12 = collection.size();
        this.compatibilityDataSizeChanged(n12);
    }

    public BaseDraggableModule addDraggableModule(BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp$DefaultImpls.addDraggableModule(this, baseQuickAdapter);
    }

    public final int addFooterView(View view) {
        return BaseQuickAdapter.addFooterView$default(this, view, 0, 0, 6, null);
    }

    public final int addFooterView(View view, int n10) {
        return BaseQuickAdapter.addFooterView$default(this, view, n10, 0, 4, null);
    }

    public final int addFooterView(View view, int n10, int n11) {
        int n12;
        Object object;
        f0.q(view, "view");
        LinearLayout linearLayout = this.mFooterLayout;
        int n13 = 1;
        int n14 = -1;
        String string2 = "mFooterLayout";
        if (linearLayout == null) {
            Context context = view.getContext();
            this.mFooterLayout = linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(n11);
            linearLayout = this.mFooterLayout;
            if (linearLayout == null) {
                f0.S(string2);
            }
            int n15 = -2;
            object = n11 == n13 ? new RecyclerView$LayoutParams(n14, n15) : new RecyclerView$LayoutParams(n15, n14);
            linearLayout.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        if ((object = this.mFooterLayout) == null) {
            f0.S(string2);
        }
        n11 = object.getChildCount();
        if (n10 < 0 || n10 > n11) {
            n10 = n11;
        }
        if ((object = this.mFooterLayout) == null) {
            f0.S(string2);
        }
        object.addView(view, n10);
        view = this.mFooterLayout;
        if (view == null) {
            f0.S(string2);
        }
        if ((n12 = view.getChildCount()) == n13 && (n12 = this.getFooterViewPosition()) != n14) {
            this.notifyItemInserted(n12);
        }
        return n10;
    }

    public final int addHeaderView(View view) {
        return BaseQuickAdapter.addHeaderView$default(this, view, 0, 0, 6, null);
    }

    public final int addHeaderView(View view, int n10) {
        return BaseQuickAdapter.addHeaderView$default(this, view, n10, 0, 4, null);
    }

    public final int addHeaderView(View view, int n10, int n11) {
        int n12;
        Object object;
        f0.q(view, "view");
        LinearLayout linearLayout = this.mHeaderLayout;
        int n13 = 1;
        int n14 = -1;
        String string2 = "mHeaderLayout";
        if (linearLayout == null) {
            Context context = view.getContext();
            this.mHeaderLayout = linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(n11);
            linearLayout = this.mHeaderLayout;
            if (linearLayout == null) {
                f0.S(string2);
            }
            int n15 = -2;
            object = n11 == n13 ? new RecyclerView$LayoutParams(n14, n15) : new RecyclerView$LayoutParams(n15, n14);
            linearLayout.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        if ((object = this.mHeaderLayout) == null) {
            f0.S(string2);
        }
        n11 = object.getChildCount();
        if (n10 < 0 || n10 > n11) {
            n10 = n11;
        }
        if ((object = this.mHeaderLayout) == null) {
            f0.S(string2);
        }
        object.addView(view, n10);
        view = this.mHeaderLayout;
        if (view == null) {
            f0.S(string2);
        }
        if ((n12 = view.getChildCount()) == n13 && (n12 = this.getHeaderViewPosition()) != n14) {
            this.notifyItemInserted(n12);
        }
        return n10;
    }

    public BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp$DefaultImpls.addLoadMoreModule(this, baseQuickAdapter);
    }

    public BaseUpFetchModule addUpFetchModule(BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp$DefaultImpls.addUpFetchModule(this, baseQuickAdapter);
    }

    public void bindViewClickListener(BaseViewHolder baseViewHolder, int n10) {
        boolean bl2;
        Object object;
        Integer n11;
        int n12;
        Object object2;
        f0.q(baseViewHolder, "viewHolder");
        Iterator iterator2 = this.mOnItemClickListener;
        if (iterator2 != null) {
            iterator2 = baseViewHolder.itemView;
            object2 = new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1(this, baseViewHolder);
            iterator2.setOnClickListener((View.OnClickListener)object2);
        }
        if ((iterator2 = this.mOnItemLongClickListener) != null) {
            iterator2 = baseViewHolder.itemView;
            object2 = new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2(this, baseViewHolder);
            iterator2.setOnLongClickListener((View.OnLongClickListener)object2);
        }
        iterator2 = this.mOnItemChildClickListener;
        boolean bl3 = true;
        String string2 = "id";
        if (iterator2 != null) {
            iterator2 = this.getChildClickViewIds().iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                n11 = (Integer)iterator2.next();
                object = baseViewHolder.itemView;
                f0.h(n11, string2);
                n12 = n11;
                if ((n11 = object.findViewById(n12)) == null) continue;
                bl2 = n11.isClickable();
                if (!bl2) {
                    n11.setClickable(bl3);
                }
                object = new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$3(this, baseViewHolder);
                n11.setOnClickListener((View.OnClickListener)object);
            }
        }
        if ((iterator2 = this.mOnItemChildLongClickListener) != null) {
            iterator2 = this.getChildLongClickViewIds().iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                n11 = (Integer)iterator2.next();
                object = baseViewHolder.itemView;
                f0.h(n11, string2);
                n12 = n11;
                if ((n11 = object.findViewById(n12)) == null) continue;
                bl2 = n11.isLongClickable();
                if (!bl2) {
                    n11.setLongClickable(bl3);
                }
                object = new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4(this, baseViewHolder);
                n11.setOnLongClickListener((View.OnLongClickListener)object);
            }
        }
    }

    public final void compatibilityDataSizeChanged(int n10) {
        List list = this.data;
        int n11 = list.size();
        if (n11 == n10) {
            this.notifyDataSetChanged();
        }
    }

    public abstract void convert(BaseViewHolder var1, Object var2);

    public void convert(BaseViewHolder baseViewHolder, Object object, List list) {
        f0.q(baseViewHolder, "holder");
        f0.q(list, "payloads");
    }

    public BaseViewHolder createBaseViewHolder(View view) {
        Object object;
        f0.q(view, "view");
        Class clazz = null;
        for (object = this.getClass(); clazz == null && object != null; object = ((Class)object).getSuperclass()) {
            clazz = this.getInstancedGenericKClass((Class)object);
        }
        object = clazz == null ? new BaseViewHolder(view) : this.createBaseGenericKInstance(clazz, view);
        if (object == null) {
            object = new BaseViewHolder(view);
        }
        return object;
    }

    public BaseViewHolder createBaseViewHolder(ViewGroup viewGroup, int n10) {
        f0.q(viewGroup, "parent");
        viewGroup = AdapterUtilsKt.getItemView(viewGroup, n10);
        return this.createBaseViewHolder((View)viewGroup);
    }

    public final BaseAnimation getAdapterAnimation() {
        return this.adapterAnimation;
    }

    public final boolean getAnimationEnable() {
        return this.animationEnable;
    }

    public final LinkedHashSet getChildClickViewIds() {
        return this.childClickViewIds;
    }

    public final LinkedHashSet getChildLongClickViewIds() {
        return this.childLongClickViewIds;
    }

    public final Context getContext() {
        Context context = this.context;
        if (context == null) {
            String string2 = "context";
            f0.S(string2);
        }
        return context;
    }

    public final List getData() {
        return this.data;
    }

    public int getDefItemCount() {
        return this.data.size();
    }

    public int getDefItemViewType(int n10) {
        return super.getItemViewType(n10);
    }

    public final BrvahAsyncDiffer getDiffHelper() {
        return this.getDiffer();
    }

    public final BrvahAsyncDiffer getDiffer() {
        Object object = this.mDiffHelper;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        String string2 = "Please use setDiffCallback() or setDiffConfig() first!".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final BaseDraggableModule getDraggableModule() {
        Object object = this.mDraggableModule;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        String string2 = "Please first implements DraggableModule".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final FrameLayout getEmptyLayout() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                String string2 = "mEmptyLayout";
                f0.S(string2);
            }
        } else {
            frameLayout = null;
        }
        return frameLayout;
    }

    public final LinearLayout getFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                String string2 = "mFooterLayout";
                f0.S(string2);
            }
        } else {
            linearLayout = null;
        }
        return linearLayout;
    }

    public final int getFooterLayoutCount() {
        return (int)(this.hasFooterLayout() ? 1 : 0);
    }

    public final boolean getFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public final int getFooterViewPosition() {
        int n10 = this.hasEmptyView();
        if (n10 != 0) {
            n10 = 1;
            boolean bl2 = this.headerWithEmptyEnable;
            if (bl2 && (bl2 = this.hasHeaderLayout())) {
                n10 = 2;
            }
            if (bl2 = this.footerWithEmptyEnable) {
                return n10;
            }
            return -1;
        }
        n10 = this.getHeaderLayoutCount();
        int n11 = this.data.size();
        return n10 + n11;
    }

    public final boolean getFooterWithEmptyEnable() {
        return this.footerWithEmptyEnable;
    }

    public final LinearLayout getHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                String string2 = "mHeaderLayout";
                f0.S(string2);
            }
        } else {
            linearLayout = null;
        }
        return linearLayout;
    }

    public final int getHeaderLayoutCount() {
        return (int)(this.hasHeaderLayout() ? 1 : 0);
    }

    public final boolean getHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public final int getHeaderViewPosition() {
        boolean bl2 = this.hasEmptyView();
        if (bl2) {
            bl2 = this.headerWithEmptyEnable;
            if (bl2) {
                return 0;
            }
            return -1;
        }
        return 0;
    }

    public final boolean getHeaderWithEmptyEnable() {
        return this.headerWithEmptyEnable;
    }

    public Object getItem(int n10) {
        return this.data.get(n10);
    }

    public int getItemCount() {
        int n10 = this.hasEmptyView();
        int n11 = 1;
        if (n10 != 0) {
            n10 = this.headerWithEmptyEnable;
            if (n10 != 0 && (n10 = this.hasHeaderLayout()) != 0) {
                n11 = 2;
            }
            if ((n10 = this.footerWithEmptyEnable) != 0 && (n10 = (int)(this.hasFooterLayout() ? 1 : 0)) != 0) {
                ++n11;
            }
            return n11;
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule == null || (n10 = baseLoadMoreModule.hasLoadMoreView()) != n11) {
            n11 = 0;
        }
        n10 = this.getHeaderLayoutCount();
        int n12 = this.getDefItemCount();
        n10 += n12;
        n12 = this.getFooterLayoutCount();
        return n10 + n12 + n11;
    }

    public long getItemId(int n10) {
        return n10;
    }

    public Object getItemOrNull(int n10) {
        return CollectionsKt___CollectionsKt.H2(this.data, n10);
    }

    public int getItemPosition(Object object) {
        int n10;
        List list;
        boolean bl2;
        if (object != null && (bl2 = (list = this.data).isEmpty() ^ true)) {
            list = this.data;
            n10 = list.indexOf(object);
        } else {
            n10 = -1;
        }
        return n10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int getItemViewType(int n10) {
        List list;
        int n11 = this.hasEmptyView();
        int n12 = 0x10000111;
        int n13 = 0x10000333;
        if (n11 != 0) {
            n11 = this.headerWithEmptyEnable;
            int n14 = 1;
            if (n11 != 0 && (n11 = this.hasHeaderLayout()) != 0) {
                n11 = n14;
            } else {
                n11 = 0;
                Object var6_6 = null;
            }
            int n15 = 0x10000555;
            if (n10 != 0) {
                if (n10 != n14) {
                    n11 = 2;
                    if (n10 == n11) return n13;
                    return n15;
                }
                if (n11 == 0) return n13;
                return n15;
            }
            if (n11 == 0) return n15;
            return n12;
        }
        n11 = this.hasHeaderLayout();
        if (n11 != 0 && n10 == 0) {
            return n12;
        }
        if (n11 != 0) {
            n10 += -1;
        }
        if (n10 < (n11 = (list = this.data).size())) {
            return this.getDefItemViewType(n10);
        }
        if ((n10 -= n11) >= (n11 = (int)(this.hasFooterLayout() ? 1 : 0))) return 0x10000222;
        return n13;
    }

    public final BaseLoadMoreModule getLoadMoreModule() {
        Object object = this.mLoadMoreModule;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        String string2 = "Please first implements LoadMoreModule".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final BaseLoadMoreModule getMLoadMoreModule$com_github_CymChad_brvah() {
        return this.mLoadMoreModule;
    }

    public final RecyclerView getMRecyclerView$com_github_CymChad_brvah() {
        return this.mRecyclerView;
    }

    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final RecyclerView getRecyclerView() {
        Object object = this.mRecyclerView;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        String string2 = "Please get it after onAttachedToRecyclerView()".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final BaseUpFetchModule getUpFetchModule() {
        Object object = this.mUpFetchModule;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        String string2 = "Please first implements UpFetchModule".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final View getViewByPosition(int n10, int n11) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (baseViewHolder = (BaseViewHolder)recyclerView.findViewHolderForLayoutPosition(n10)) != null) {
            return baseViewHolder.getViewOrNull(n11);
        }
        return null;
    }

    public final WeakReference getWeakRecyclerView() {
        WeakReference weakReference = this.weakRecyclerView;
        if (weakReference == null) {
            String string2 = "weakRecyclerView";
            f0.S(string2);
        }
        return weakReference;
    }

    public final boolean hasEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            int n10;
            if (frameLayout == null) {
                String string2 = "mEmptyLayout";
                f0.S(string2);
            }
            if ((n10 = frameLayout.getChildCount()) != 0) {
                n10 = (int)(this.isUseEmpty ? 1 : 0);
                if (n10 == 0) {
                    return false;
                }
                return this.data.isEmpty();
            }
        }
        return false;
    }

    public final boolean hasFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            int n10;
            if (linearLayout == null) {
                String string2 = "mFooterLayout";
                f0.S(string2);
            }
            if ((n10 = linearLayout.getChildCount()) > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            int n10;
            if (linearLayout == null) {
                String string2 = "mHeaderLayout";
                f0.S(string2);
            }
            if ((n10 = linearLayout.getChildCount()) > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAnimationFirstOnly() {
        return this.isAnimationFirstOnly;
    }

    public boolean isFixedViewType(int n10) {
        int n11 = 0x10000555;
        n10 = n10 != n11 && n10 != (n11 = 0x10000111) && n10 != (n11 = 0x10000333) && n10 != (n11 = 0x10000222) ? 0 : 1;
        return n10 != 0;
    }

    public final boolean isUseEmpty() {
        return this.isUseEmpty;
    }

    public void onAttachedToRecyclerView(RecyclerView object) {
        boolean bl2;
        f0.q(object, "recyclerView");
        super.onAttachedToRecyclerView((RecyclerView)object);
        Object object2 = new WeakReference(object);
        this.weakRecyclerView = object2;
        this.mRecyclerView = object;
        object2 = object.getContext();
        Object object3 = "recyclerView.context";
        f0.h(object2, (String)object3);
        this.context = object2;
        object2 = this.mDraggableModule;
        if (object2 != null) {
            ((BaseDraggableModule)object2).attachToRecyclerView((RecyclerView)object);
        }
        if (bl2 = (object = ((RecyclerView)object).getLayoutManager()) instanceof GridLayoutManager) {
            object2 = object;
            object2 = (GridLayoutManager)object;
            object3 = ((GridLayoutManager)object2).getSpanSizeLookup();
            BaseQuickAdapter$onAttachedToRecyclerView$1 baseQuickAdapter$onAttachedToRecyclerView$1 = new BaseQuickAdapter$onAttachedToRecyclerView$1(this, (RecyclerView$LayoutManager)object, (GridLayoutManager$SpanSizeLookup)object3);
            ((GridLayoutManager)object2).setSpanSizeLookup(baseQuickAdapter$onAttachedToRecyclerView$1);
        }
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int n10) {
        f0.q(baseViewHolder, "holder");
        Object object = this.mUpFetchModule;
        if (object != null) {
            ((BaseUpFetchModule)object).autoUpFetch$com_github_CymChad_brvah(n10);
        }
        if ((object = this.mLoadMoreModule) != null) {
            ((BaseLoadMoreModule)object).autoLoadMore$com_github_CymChad_brvah(n10);
        }
        int n11 = baseViewHolder.getItemViewType();
        switch (n11) {
            default: {
                n11 = this.getHeaderLayoutCount();
                Object object2 = this.getItem(n10 -= n11);
                this.convert(baseViewHolder, object2);
                break;
            }
            case 0x10000222: {
                object = this.mLoadMoreModule;
                if (object == null) break;
                BaseLoadMoreView baseLoadMoreView = ((BaseLoadMoreModule)object).getLoadMoreView();
                object = ((BaseLoadMoreModule)object).getLoadMoreStatus();
                baseLoadMoreView.convert(baseViewHolder, n10, (LoadMoreStatus)((Object)object));
            }
            case 0x10000111: 
            case 0x10000333: 
            case 0x10000555: 
        }
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int n10, List object) {
        f0.q(baseViewHolder, "holder");
        Object object2 = "payloads";
        f0.q(object, (String)object2);
        int n11 = object.isEmpty();
        if (n11 != 0) {
            this.onBindViewHolder(baseViewHolder, n10);
            return;
        }
        object2 = this.mUpFetchModule;
        if (object2 != null) {
            ((BaseUpFetchModule)object2).autoUpFetch$com_github_CymChad_brvah(n10);
        }
        if ((object2 = this.mLoadMoreModule) != null) {
            ((BaseLoadMoreModule)object2).autoLoadMore$com_github_CymChad_brvah(n10);
        }
        n11 = baseViewHolder.getItemViewType();
        switch (n11) {
            default: {
                n11 = this.getHeaderLayoutCount();
                Object object3 = this.getItem(n10 -= n11);
                this.convert(baseViewHolder, object3, (List)object);
                break;
            }
            case 0x10000222: {
                object = this.mLoadMoreModule;
                if (object == null) break;
                object2 = ((BaseLoadMoreModule)object).getLoadMoreView();
                object = ((BaseLoadMoreModule)object).getLoadMoreStatus();
                ((BaseLoadMoreView)object2).convert(baseViewHolder, n10, (LoadMoreStatus)((Object)object));
            }
            case 0x10000111: 
            case 0x10000333: 
            case 0x10000555: 
        }
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup viewGroup, int n10) {
        f0.q(viewGroup, "parent");
        n10 = this.layoutResId;
        return this.createBaseViewHolder(viewGroup, n10);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup object, int n10) {
        block20: {
            Object object2 = "parent";
            f0.q(object, (String)object2);
            switch (n10) {
                default: {
                    object = this.onCreateDefViewHolder((ViewGroup)object, n10);
                    this.bindViewClickListener((BaseViewHolder)object, n10);
                    object2 = this.mDraggableModule;
                    if (object2 == null) break;
                    ((BaseDraggableModule)object2).initView$com_github_CymChad_brvah((BaseViewHolder)object);
                    break;
                }
                case 0x10000555: {
                    boolean bl2;
                    object = this.mEmptyLayout;
                    String string2 = "mEmptyLayout";
                    if (object == null) {
                        f0.S(string2);
                    }
                    if (bl2 = (object = object.getParent()) instanceof ViewGroup) {
                        object2 = this.mEmptyLayout;
                        if (object2 == null) {
                            f0.S(string2);
                        }
                        object.removeView((View)object2);
                    }
                    if ((object = this.mEmptyLayout) == null) {
                        f0.S(string2);
                    }
                    object = this.createBaseViewHolder((View)object);
                    break block20;
                }
                case 0x10000333: {
                    boolean bl3;
                    object = this.mFooterLayout;
                    String string3 = "mFooterLayout";
                    if (object == null) {
                        f0.S(string3);
                    }
                    if (bl3 = (object = object.getParent()) instanceof ViewGroup) {
                        object2 = this.mFooterLayout;
                        if (object2 == null) {
                            f0.S(string3);
                        }
                        object.removeView((View)object2);
                    }
                    if ((object = this.mFooterLayout) == null) {
                        f0.S(string3);
                    }
                    object = this.createBaseViewHolder((View)object);
                    break block20;
                }
                case 0x10000222: {
                    BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
                    if (baseLoadMoreModule == null) {
                        f0.L();
                    }
                    object = baseLoadMoreModule.getLoadMoreView().getRootView((ViewGroup)object);
                    object = this.createBaseViewHolder((View)object);
                    baseLoadMoreModule = this.mLoadMoreModule;
                    if (baseLoadMoreModule == null) {
                        f0.L();
                    }
                    baseLoadMoreModule.setupViewHolder$com_github_CymChad_brvah((BaseViewHolder)object);
                    break block20;
                }
                case 0x10000111: {
                    boolean bl4;
                    object = this.mHeaderLayout;
                    String string4 = "mHeaderLayout";
                    if (object == null) {
                        f0.S(string4);
                    }
                    if (bl4 = (object = object.getParent()) instanceof ViewGroup) {
                        object2 = this.mHeaderLayout;
                        if (object2 == null) {
                            f0.S(string4);
                        }
                        object.removeView((View)object2);
                    }
                    if ((object = this.mHeaderLayout) == null) {
                        f0.S(string4);
                    }
                    object = this.createBaseViewHolder((View)object);
                    break block20;
                }
            }
            this.onItemViewHolderCreated((BaseViewHolder)object, n10);
        }
        return object;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        f0.q(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    public void onItemViewHolderCreated(BaseViewHolder baseViewHolder, int n10) {
        f0.q(baseViewHolder, "viewHolder");
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        String string2 = "holder";
        f0.q(baseViewHolder, string2);
        super.onViewAttachedToWindow(baseViewHolder);
        int n10 = baseViewHolder.getItemViewType();
        n10 = (int)(this.isFixedViewType(n10) ? 1 : 0);
        if (n10 != 0) {
            this.setFullSpan(baseViewHolder);
        } else {
            this.addAnimation(baseViewHolder);
        }
    }

    public void remove(int n10) {
        this.removeAt(n10);
    }

    public void remove(Object object) {
        int n10;
        List list = this.data;
        int n11 = list.indexOf(object);
        if (n11 == (n10 = -1)) {
            return;
        }
        this.removeAt(n11);
    }

    public final void removeAllFooterView() {
        int n10 = this.hasFooterLayout();
        if (n10 == 0) {
            return;
        }
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) {
            String string2 = "mFooterLayout";
            f0.S(string2);
        }
        linearLayout.removeAllViews();
        n10 = this.getFooterViewPosition();
        int n11 = -1;
        if (n10 != n11) {
            this.notifyItemRemoved(n10);
        }
    }

    public final void removeAllHeaderView() {
        int n10 = this.hasHeaderLayout();
        if (n10 == 0) {
            return;
        }
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) {
            String string2 = "mHeaderLayout";
            f0.S(string2);
        }
        linearLayout.removeAllViews();
        n10 = this.getHeaderViewPosition();
        int n11 = -1;
        if (n10 != n11) {
            this.notifyItemRemoved(n10);
        }
    }

    public void removeAt(int n10) {
        List list = this.data;
        int n11 = list.size();
        if (n10 >= n11) {
            return;
        }
        this.data.remove(n10);
        n11 = this.getHeaderLayoutCount();
        this.notifyItemRemoved(n10 += n11);
        this.compatibilityDataSizeChanged(0);
        n11 = this.data.size() - n10;
        this.notifyItemRangeChanged(n10, n11);
    }

    public final void removeEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                String string2 = "mEmptyLayout";
                f0.S(string2);
            }
            frameLayout.removeAllViews();
        }
    }

    public final void removeFooterView(View view) {
        int n10;
        String string2 = "footer";
        f0.q(view, string2);
        int n11 = this.hasFooterLayout();
        if (n11 == 0) {
            return;
        }
        string2 = this.mFooterLayout;
        String string3 = "mFooterLayout";
        if (string2 == null) {
            f0.S(string3);
        }
        string2.removeView(view);
        view = this.mFooterLayout;
        if (view == null) {
            f0.S(string3);
        }
        if ((n10 = view.getChildCount()) == 0 && (n10 = this.getFooterViewPosition()) != (n11 = -1)) {
            this.notifyItemRemoved(n10);
        }
    }

    public final void removeHeaderView(View view) {
        int n10;
        String string2 = "header";
        f0.q(view, string2);
        int n11 = this.hasHeaderLayout();
        if (n11 == 0) {
            return;
        }
        string2 = this.mHeaderLayout;
        String string3 = "mHeaderLayout";
        if (string2 == null) {
            f0.S(string3);
        }
        string2.removeView(view);
        view = this.mHeaderLayout;
        if (view == null) {
            f0.S(string3);
        }
        if ((n10 = view.getChildCount()) == 0 && (n10 = this.getHeaderViewPosition()) != (n11 = -1)) {
            this.notifyItemRemoved(n10);
        }
    }

    public void replaceData(Collection collection) {
        f0.q(collection, "newData");
        this.setList(collection);
    }

    public final void setAdapterAnimation(BaseAnimation baseAnimation) {
        this.animationEnable = true;
        this.adapterAnimation = baseAnimation;
    }

    public final void setAnimationEnable(boolean bl2) {
        this.animationEnable = bl2;
    }

    public final void setAnimationFirstOnly(boolean bl2) {
        this.isAnimationFirstOnly = bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final void setAnimationWithDefault(BaseQuickAdapter$AnimationType object) {
        void var1_8;
        block5: {
            int n10;
            block6: {
                block7: {
                    f0.q(object, "animationType");
                    int[] nArray = BaseQuickAdapter$WhenMappings.$EnumSwitchMapping$0;
                    int n11 = ((Enum)object).ordinal();
                    n11 = nArray[n11];
                    int n12 = 0;
                    nArray = null;
                    n10 = 1;
                    if (n11 == n10) break block6;
                    int n13 = 2;
                    if (n11 == n13) break block7;
                    n12 = 3;
                    if (n11 != n12) {
                        n12 = 4;
                        if (n11 != n12) {
                            n12 = 5;
                            if (n11 != n12) {
                                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                                throw noWhenBranchMatchedException;
                            }
                            SlideInRightAnimation slideInRightAnimation = new SlideInRightAnimation();
                            break block5;
                        } else {
                            SlideInLeftAnimation slideInLeftAnimation = new SlideInLeftAnimation();
                        }
                        break block5;
                    } else {
                        SlideInBottomAnimation slideInBottomAnimation = new SlideInBottomAnimation();
                    }
                    break block5;
                }
                ScaleInAnimation scaleInAnimation = new ScaleInAnimation(0.0f, n10, null);
                break block5;
            }
            AlphaInAnimation alphaInAnimation = new AlphaInAnimation(0.0f, n10, null);
        }
        this.setAdapterAnimation((BaseAnimation)var1_8);
    }

    public void setData(int n10, Object object) {
        List list = this.data;
        int n11 = list.size();
        if (n10 >= n11) {
            return;
        }
        this.data.set(n10, object);
        int n12 = this.getHeaderLayoutCount();
        this.notifyItemChanged(n10 += n12);
    }

    public final void setData$com_github_CymChad_brvah(List list) {
        f0.q(list, "<set-?>");
        this.data = list;
    }

    public final void setDiffCallback(DiffUtil$ItemCallback object) {
        f0.q(object, "diffCallback");
        BrvahAsyncDifferConfig$Builder brvahAsyncDifferConfig$Builder = new BrvahAsyncDifferConfig$Builder((DiffUtil$ItemCallback)object);
        object = brvahAsyncDifferConfig$Builder.build();
        this.setDiffConfig((BrvahAsyncDifferConfig)object);
    }

    public final void setDiffConfig(BrvahAsyncDifferConfig brvahAsyncDifferConfig) {
        BrvahAsyncDiffer brvahAsyncDiffer;
        f0.q(brvahAsyncDifferConfig, "config");
        this.mDiffHelper = brvahAsyncDiffer = new BrvahAsyncDiffer(this, brvahAsyncDifferConfig);
    }

    public void setDiffNewData(DiffUtil$DiffResult diffUtil$DiffResult, List list) {
        f0.q(diffUtil$DiffResult, "diffResult");
        Object object = "list";
        f0.q(list, (String)object);
        boolean bl2 = this.hasEmptyView();
        if (bl2) {
            this.setNewInstance(list);
            return;
        }
        object = new BrvahListUpdateCallback(this);
        diffUtil$DiffResult.dispatchUpdatesTo((ListUpdateCallback)object);
        this.data = list;
    }

    public void setDiffNewData(List list) {
        boolean bl2 = this.hasEmptyView();
        if (bl2) {
            this.setNewInstance(list);
            return;
        }
        BrvahAsyncDiffer brvahAsyncDiffer = this.mDiffHelper;
        if (brvahAsyncDiffer != null) {
            int n10 = 2;
            BrvahAsyncDiffer.submitList$default(brvahAsyncDiffer, list, null, n10, null);
        }
    }

    public final void setEmptyView(int n10) {
        Object object = this.mRecyclerView;
        if (object != null) {
            LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
            View view = layoutInflater.inflate(n10, (ViewGroup)object, false);
            object = "view";
            f0.h(view, (String)object);
            this.setEmptyView(view);
        }
    }

    public final void setEmptyView(View view) {
        int n10;
        int n11;
        Context context;
        String string2 = "emptyView";
        f0.q(view, string2);
        int n12 = this.getItemCount();
        FrameLayout frameLayout = this.mEmptyLayout;
        int n13 = 0;
        int n14 = 1;
        String string3 = "mEmptyLayout";
        if (frameLayout == null) {
            ViewGroup.LayoutParams layoutParams;
            context = view.getContext();
            this.mEmptyLayout = frameLayout = new FrameLayout(context);
            if (frameLayout == null) {
                f0.S(string3);
            }
            if ((context = view.getLayoutParams()) != null) {
                int n15 = context.width;
                int n16 = context.height;
                layoutParams = new ViewGroup.LayoutParams(n15, n16);
            } else {
                int n17 = -1;
                layoutParams = new ViewGroup.LayoutParams(n17, n17);
            }
            frameLayout.setLayoutParams(layoutParams);
            n11 = n14;
        } else {
            frameLayout = view.getLayoutParams();
            if (frameLayout != null) {
                int n18;
                context = this.mEmptyLayout;
                if (context == null) {
                    f0.S(string3);
                }
                context = context.getLayoutParams();
                context.width = n18 = frameLayout.width;
                context.height = n11 = frameLayout.height;
                frameLayout = this.mEmptyLayout;
                if (frameLayout == null) {
                    f0.S(string3);
                }
                frameLayout.setLayoutParams((ViewGroup.LayoutParams)context);
            }
            n11 = 0;
            frameLayout = null;
        }
        context = this.mEmptyLayout;
        if (context == null) {
            f0.S(string3);
        }
        context.removeAllViews();
        context = this.mEmptyLayout;
        if (context == null) {
            f0.S(string3);
        }
        context.addView(view);
        this.isUseEmpty = n14;
        if (n11 != 0 && (n10 = this.hasEmptyView()) != 0) {
            n10 = this.headerWithEmptyEnable;
            if (n10 != 0 && (n10 = this.hasHeaderLayout()) != 0) {
                n13 = n14;
            }
            if ((n10 = this.getItemCount()) > n12) {
                this.notifyItemInserted(n13);
            } else {
                this.notifyDataSetChanged();
            }
        }
    }

    public final int setFooterView(View view) {
        return BaseQuickAdapter.setFooterView$default(this, view, 0, 0, 6, null);
    }

    public final int setFooterView(View view, int n10) {
        return BaseQuickAdapter.setFooterView$default(this, view, n10, 0, 4, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int setFooterView(View view, int n10, int n11) {
        int n12;
        f0.q(view, "view");
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) return this.addFooterView(view, n10, n11);
        String string2 = "mFooterLayout";
        if (linearLayout == null) {
            f0.S(string2);
        }
        if ((n12 = linearLayout.getChildCount()) <= n10) return this.addFooterView(view, n10, n11);
        LinearLayout linearLayout2 = this.mFooterLayout;
        if (linearLayout2 == null) {
            f0.S(string2);
        }
        linearLayout2.removeViewAt(n10);
        linearLayout2 = this.mFooterLayout;
        if (linearLayout2 == null) {
            f0.S(string2);
        }
        linearLayout2.addView(view, n10);
        return n10;
    }

    public final void setFooterViewAsFlow(boolean bl2) {
        this.footerViewAsFlow = bl2;
    }

    public final void setFooterWithEmptyEnable(boolean bl2) {
        this.footerWithEmptyEnable = bl2;
    }

    public void setFullSpan(RecyclerView$ViewHolder object) {
        f0.q(object, "holder");
        object = ((RecyclerView$ViewHolder)object).itemView;
        String string2 = "holder.itemView";
        f0.h(object, string2);
        object = object.getLayoutParams();
        boolean bl2 = object instanceof StaggeredGridLayoutManager$LayoutParams;
        if (bl2) {
            object = (StaggeredGridLayoutManager$LayoutParams)((Object)object);
            bl2 = true;
            ((StaggeredGridLayoutManager$LayoutParams)((Object)object)).setFullSpan(bl2);
        }
    }

    public void setGridSpanSizeLookup(GridSpanSizeLookup gridSpanSizeLookup) {
        this.mSpanSizeLookup = gridSpanSizeLookup;
    }

    public final int setHeaderView(View view) {
        return BaseQuickAdapter.setHeaderView$default(this, view, 0, 0, 6, null);
    }

    public final int setHeaderView(View view, int n10) {
        return BaseQuickAdapter.setHeaderView$default(this, view, n10, 0, 4, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int setHeaderView(View view, int n10, int n11) {
        int n12;
        f0.q(view, "view");
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) return this.addHeaderView(view, n10, n11);
        String string2 = "mHeaderLayout";
        if (linearLayout == null) {
            f0.S(string2);
        }
        if ((n12 = linearLayout.getChildCount()) <= n10) return this.addHeaderView(view, n10, n11);
        LinearLayout linearLayout2 = this.mHeaderLayout;
        if (linearLayout2 == null) {
            f0.S(string2);
        }
        linearLayout2.removeViewAt(n10);
        linearLayout2 = this.mHeaderLayout;
        if (linearLayout2 == null) {
            f0.S(string2);
        }
        linearLayout2.addView(view, n10);
        return n10;
    }

    public final void setHeaderViewAsFlow(boolean bl2) {
        this.headerViewAsFlow = bl2;
    }

    public final void setHeaderWithEmptyEnable(boolean bl2) {
        this.headerWithEmptyEnable = bl2;
    }

    public void setList(Collection object) {
        int n10;
        ArrayList arrayList = this.data;
        boolean bl2 = false;
        boolean bl3 = true;
        if (object != arrayList) {
            boolean bl4;
            arrayList.clear();
            if (object == null || (bl4 = object.isEmpty())) {
                bl2 = bl3;
            }
            if (!bl2) {
                arrayList = this.data;
                arrayList.addAll(object);
            }
        } else {
            boolean bl5;
            if (object == null || (bl5 = object.isEmpty())) {
                bl2 = bl3;
            }
            if (!bl2) {
                arrayList = new ArrayList(object);
                this.data.clear();
                object = this.data;
                object.addAll(arrayList);
            } else {
                object = this.data;
                object.clear();
            }
        }
        if ((object = this.mLoadMoreModule) != null) {
            ((BaseLoadMoreModule)object).reset$com_github_CymChad_brvah();
        }
        this.mLastPosition = n10 = -1;
        this.notifyDataSetChanged();
        object = this.mLoadMoreModule;
        if (object != null) {
            ((BaseLoadMoreModule)object).checkDisableLoadMoreIfNotFullPage();
        }
    }

    public final void setMLoadMoreModule$com_github_CymChad_brvah(BaseLoadMoreModule baseLoadMoreModule) {
        this.mLoadMoreModule = baseLoadMoreModule;
    }

    public final void setMRecyclerView$com_github_CymChad_brvah(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setNewData(List list) {
        this.setNewInstance(list);
    }

    public void setNewInstance(List object) {
        int n10;
        List list = this.data;
        if (object == list) {
            return;
        }
        if (object == null) {
            object = new ArrayList();
        }
        this.data = object;
        object = this.mLoadMoreModule;
        if (object != null) {
            ((BaseLoadMoreModule)object).reset$com_github_CymChad_brvah();
        }
        this.mLastPosition = n10 = -1;
        this.notifyDataSetChanged();
        object = this.mLoadMoreModule;
        if (object != null) {
            ((BaseLoadMoreModule)object).checkDisableLoadMoreIfNotFullPage();
        }
    }

    public void setOnItemChildClick(View view, int n10) {
        f0.q(view, "v");
        OnItemChildClickListener onItemChildClickListener = this.mOnItemChildClickListener;
        if (onItemChildClickListener != null) {
            onItemChildClickListener.onItemChildClick(this, view, n10);
        }
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        this.mOnItemChildClickListener = onItemChildClickListener;
    }

    public boolean setOnItemChildLongClick(View view, int n10) {
        boolean bl2;
        f0.q(view, "v");
        OnItemChildLongClickListener onItemChildLongClickListener = this.mOnItemChildLongClickListener;
        if (onItemChildLongClickListener != null) {
            bl2 = onItemChildLongClickListener.onItemChildLongClick(this, view, n10);
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        this.mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public void setOnItemClick(View view, int n10) {
        f0.q(view, "v");
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(this, view, n10);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public boolean setOnItemLongClick(View view, int n10) {
        boolean bl2;
        f0.q(view, "v");
        OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            bl2 = onItemLongClickListener.onItemLongClick(this, view, n10);
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        f0.q(recyclerView, "value");
        this.mRecyclerView = recyclerView;
    }

    public final void setUseEmpty(boolean bl2) {
        this.isUseEmpty = bl2;
    }

    public final void setWeakRecyclerView(WeakReference weakReference) {
        f0.q(weakReference, "<set-?>");
        this.weakRecyclerView = weakReference;
    }

    public void startAnim(Animator animator2, int n10) {
        f0.q(animator2, "anim");
        animator2.start();
    }
}

