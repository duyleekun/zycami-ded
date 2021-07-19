/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

import androidx.recyclerview.widget.DiffUtil$DiffResult;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import f.h2.t.f0;
import f.h2.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

public abstract class BaseNodeAdapter
extends BaseProviderMultiAdapter {
    private final HashSet fullSpanNodeTypeSet;

    public BaseNodeAdapter() {
        this(null, 1, null);
    }

    public BaseNodeAdapter(List list) {
        int n10;
        HashSet hashSet;
        List list2 = null;
        super(null);
        this.fullSpanNodeTypeSet = hashSet = new HashSet();
        if (list != null && (n10 = list.isEmpty()) == 0) {
            n10 = 0;
            hashSet = null;
        } else {
            n10 = 1;
        }
        if (n10 == 0) {
            n10 = 2;
            list = BaseNodeAdapter.flatData$default(this, list, null, n10, null);
            list2 = this.getData();
            list2.addAll(list);
        }
    }

    public /* synthetic */ BaseNodeAdapter(List list, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            list = null;
        }
        this(list);
    }

    private final int collapse(int n10, boolean bl2, boolean bl3, boolean bl4, Object object) {
        Object object2 = (BaseNode)this.getData().get(n10);
        int n11 = object2 instanceof BaseExpandNode;
        if (n11 != 0) {
            Object object3 = object2;
            object3 = (BaseExpandNode)object2;
            boolean n12 = ((BaseExpandNode)object3).isExpanded();
            if (n12) {
                Object object4;
                int n13 = this.getHeaderLayoutCount();
                n10 += n13;
                ((BaseExpandNode)object3).setExpanded(false);
                object3 = ((BaseNode)object2).getChildNode();
                int n14 = 1;
                if (object3 != null && (n11 = object3.isEmpty()) == 0) {
                    n11 = 0;
                    object3 = null;
                } else {
                    n11 = n14;
                }
                if (n11 != 0) {
                    this.notifyItemChanged(n10, object);
                    return 0;
                }
                if ((object2 = ((BaseNode)object2).getChildNode()) == null) {
                    f0.L();
                }
                if (bl2) {
                    object4 = Boolean.FALSE;
                } else {
                    bl2 = false;
                    object4 = null;
                }
                object4 = this.flatData((Collection)object2, (Boolean)object4);
                int n15 = object4.size();
                object3 = this.getData();
                object3.removeAll((Collection<?>)object4);
                if (bl4) {
                    if (bl3) {
                        this.notifyItemChanged(n10, object);
                        this.notifyItemRangeRemoved(n10 += n14, n15);
                    } else {
                        this.notifyDataSetChanged();
                    }
                }
                return n15;
            }
        }
        return 0;
    }

    public static /* synthetic */ int collapse$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, Object object2, int n11, Object object3) {
        if (object3 == null) {
            int n12 = n11 & 2;
            boolean bl4 = true;
            if (n12 != 0) {
                bl2 = bl4;
            }
            if ((n12 = n11 & 4) != 0) {
                bl3 = bl4;
            }
            if ((n11 &= 8) != 0) {
                object2 = null;
            }
            return ((BaseNodeAdapter)object).collapse(n10, bl2, bl3, object2);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ int collapse$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, boolean bl4, Object object2, int n11, Object object3) {
        void var7_11;
        if (var7_11 == null) {
            Object var5_9;
            void var4_8;
            void var3_7;
            boolean bl5;
            void var6_10;
            int n12 = var6_10 & 2;
            if (n12) {
                bl5 = false;
            }
            void var9_13 = bl5;
            int n13 = var6_10 & 4;
            n12 = 1;
            int n14 = n13 != 0 ? n12 : var3_7;
            int n15 = var6_10 & 8;
            int n16 = n15 != 0 ? n12 : var4_8;
            int n17 = var6_10 & 0x10;
            if (n17 != 0) {
                var5_9 = null;
            }
            return super.collapse(n10, (boolean)var9_13, n14 != 0, n16 != 0, var5_9);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        throw object;
    }

    public static /* synthetic */ int collapseAndChild$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, Object object2, int n11, Object object3) {
        if (object3 == null) {
            int n12 = n11 & 2;
            boolean bl4 = true;
            if (n12 != 0) {
                bl2 = bl4;
            }
            if ((n12 = n11 & 4) != 0) {
                bl3 = bl4;
            }
            if ((n11 &= 8) != 0) {
                object2 = null;
            }
            return ((BaseNodeAdapter)object).collapseAndChild(n10, bl2, bl3, object2);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapseAndChild");
        throw object;
    }

    private final int expand(int n10, boolean bl2, boolean bl3, boolean bl4, Object object) {
        Object object2 = (BaseNode)this.getData().get(n10);
        int n11 = object2 instanceof BaseExpandNode;
        if (n11 != 0) {
            Object object3 = object2;
            object3 = (BaseExpandNode)object2;
            boolean n12 = ((BaseExpandNode)object3).isExpanded();
            if (!n12) {
                Object object4;
                int n13 = this.getHeaderLayoutCount() + n10;
                int n14 = 1;
                ((BaseExpandNode)object3).setExpanded(n14 != 0);
                object3 = ((BaseNode)object2).getChildNode();
                if (object3 != null && (n11 = object3.isEmpty()) == 0) {
                    n11 = 0;
                    object3 = null;
                } else {
                    n11 = n14;
                }
                if (n11 != 0) {
                    this.notifyItemChanged(n13, object);
                    return 0;
                }
                if ((object2 = ((BaseNode)object2).getChildNode()) == null) {
                    f0.L();
                }
                if (bl2) {
                    object4 = Boolean.TRUE;
                } else {
                    bl2 = false;
                    object4 = null;
                }
                object4 = this.flatData((Collection)object2, (Boolean)object4);
                int n15 = object4.size();
                object3 = this.getData();
                object3.addAll(n10 += n14, object4);
                if (bl4) {
                    if (bl3) {
                        this.notifyItemChanged(n13, object);
                        int n16 = n13 + n14;
                        this.notifyItemRangeInserted(n16, n15);
                    } else {
                        this.notifyDataSetChanged();
                    }
                }
                return n15;
            }
        }
        return 0;
    }

    public static /* synthetic */ int expand$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, Object object2, int n11, Object object3) {
        if (object3 == null) {
            int n12 = n11 & 2;
            boolean bl4 = true;
            if (n12 != 0) {
                bl2 = bl4;
            }
            if ((n12 = n11 & 4) != 0) {
                bl3 = bl4;
            }
            if ((n11 &= 8) != 0) {
                object2 = null;
            }
            return ((BaseNodeAdapter)object).expand(n10, bl2, bl3, object2);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ int expand$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, boolean bl4, Object object2, int n11, Object object3) {
        void var7_11;
        if (var7_11 == null) {
            Object var5_9;
            void var4_8;
            void var3_7;
            boolean bl5;
            void var6_10;
            int n12 = var6_10 & 2;
            if (n12) {
                bl5 = false;
            }
            void var9_13 = bl5;
            int n13 = var6_10 & 4;
            n12 = 1;
            int n14 = n13 != 0 ? n12 : var3_7;
            int n15 = var6_10 & 8;
            int n16 = n15 != 0 ? n12 : var4_8;
            int n17 = var6_10 & 0x10;
            if (n17 != 0) {
                var5_9 = null;
            }
            return super.expand(n10, (boolean)var9_13, n14 != 0, n16 != 0, var5_9);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        throw object;
    }

    public static /* synthetic */ int expandAndChild$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, Object object2, int n11, Object object3) {
        if (object3 == null) {
            int n12 = n11 & 2;
            boolean bl4 = true;
            if (n12 != 0) {
                bl2 = bl4;
            }
            if ((n12 = n11 & 4) != 0) {
                bl3 = bl4;
            }
            if ((n11 &= 8) != 0) {
                object2 = null;
            }
            return ((BaseNodeAdapter)object).expandAndChild(n10, bl2, bl3, object2);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndChild");
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ void expandAndCollapseOther$default(BaseNodeAdapter baseNodeAdapter, int n10, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Object object, Object object2, int n11, Object object3) {
        Object var9_11;
        if (var9_11 == null) {
            void var14_23;
            void var12_18;
            Object var17_26;
            void var5_7;
            void var8_10;
            int n12 = var8_10 & 2;
            if (n12) {
                n12 = 0;
                Object var11_13 = null;
            } else {
                n12 = (int)(bl2 ? 1 : 0);
            }
            int n13 = var8_10 & 4;
            boolean bl6 = true;
            if (n13 != 0) {
                boolean bl7 = bl6;
            } else {
                boolean bl8 = bl3;
            }
            int n14 = var8_10 & 8;
            if (n14 != 0) {
                boolean bl9 = bl6;
            } else {
                void var4_5;
                void var14_22 = var4_5;
            }
            int n15 = var8_10 & 0x10;
            if (n15 == 0) {
                bl6 = var5_7;
            }
            n15 = var8_10 & 0x20;
            Object var16_25 = null;
            if (n15 != 0) {
                n15 = 0;
                var17_26 = null;
            } else {
                void var6_8;
                var17_26 = var6_8;
            }
            int n16 = var8_10 & 0x40;
            if (n16 == 0) {
                void var7_9;
                var16_25 = var7_9;
            }
            int n17 = n10;
            int n18 = n12;
            var5_7 = var12_18;
            var9_11 = var16_25;
            baseNodeAdapter.expandAndCollapseOther(n10, n12 != 0, (boolean)var12_18, (boolean)var14_23, bl6, var17_26, var16_25);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndCollapseOther");
        throw unsupportedOperationException;
    }

    public static /* synthetic */ int expandOrCollapse$default(BaseNodeAdapter object, int n10, boolean bl2, boolean bl3, Object object2, int n11, Object object3) {
        if (object3 == null) {
            int n12 = n11 & 2;
            boolean bl4 = true;
            if (n12 != 0) {
                bl2 = bl4;
            }
            if ((n12 = n11 & 4) != 0) {
                bl3 = bl4;
            }
            if ((n11 &= 8) != 0) {
                object2 = null;
            }
            return ((BaseNodeAdapter)object).expandOrCollapse(n10, bl2, bl3, object2);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
        throw object;
    }

    private final List flatData(Collection object, Boolean bl2) {
        boolean bl3;
        ArrayList<BaseNode> arrayList = new ArrayList<BaseNode>();
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            boolean bl4;
            BaseNode baseNode;
            block13: {
                boolean bl5;
                Object object2;
                boolean bl6;
                boolean bl7;
                block10: {
                    BaseNode baseNode2;
                    block12: {
                        block11: {
                            baseNode = (BaseNode)object.next();
                            arrayList.add(baseNode);
                            bl4 = baseNode instanceof BaseExpandNode;
                            bl7 = false;
                            baseNode2 = null;
                            bl6 = true;
                            if (!bl4) break block10;
                            object2 = Boolean.TRUE;
                            bl4 = f0.g(bl2, object2);
                            if (bl4) break block11;
                            object2 = baseNode;
                            object2 = (BaseExpandNode)baseNode;
                            bl4 = ((BaseExpandNode)object2).isExpanded();
                            if (!bl4) break block12;
                        }
                        if ((object2 = baseNode.getChildNode()) == null || (bl5 = object2.isEmpty())) {
                            bl7 = bl6;
                        }
                        if (!bl7) {
                            object2 = this.flatData((Collection)object2, bl2);
                            arrayList.addAll((Collection<BaseNode>)object2);
                        }
                    }
                    if (bl2 != null) {
                        bl4 = bl2;
                        baseNode2 = baseNode;
                        baseNode2 = (BaseExpandNode)baseNode;
                        ((BaseExpandNode)baseNode2).setExpanded(bl4);
                    }
                    break block13;
                }
                object2 = baseNode.getChildNode();
                if (object2 == null || (bl5 = object2.isEmpty())) {
                    bl7 = bl6;
                }
                if (!bl7) {
                    object2 = this.flatData((Collection)object2, bl2);
                    arrayList.addAll((Collection<BaseNode>)object2);
                }
            }
            if (!(bl4 = baseNode instanceof NodeFooterImp) || (baseNode = ((NodeFooterImp)((Object)baseNode)).getFooterNode()) == null) continue;
            arrayList.add(baseNode);
        }
        return arrayList;
    }

    public static /* synthetic */ List flatData$default(BaseNodeAdapter object, Collection collection, Boolean bl2, int n10, Object object2) {
        if (object2 == null) {
            if ((n10 &= 2) != 0) {
                bl2 = null;
            }
            return super.flatData(collection, bl2);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
        throw object;
    }

    private final int removeChildAt(int n10) {
        Object object = this.getData();
        int n11 = object.size();
        int n12 = 0;
        if (n10 >= n11) {
            return 0;
        }
        Object object2 = (BaseNode)this.getData().get(n10);
        object = ((BaseNode)object2).getChildNode();
        if (object != null && (n11 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            n11 = 0;
            object = null;
        } else {
            n11 = 1;
        }
        if (n11 == 0) {
            n11 = object2 instanceof BaseExpandNode;
            int n13 = 2;
            if (n11 != 0) {
                object = object2;
                object = (BaseExpandNode)object2;
                n11 = (int)(((BaseExpandNode)object).isExpanded() ? 1 : 0);
                if (n11 != 0) {
                    if ((object2 = ((BaseNode)object2).getChildNode()) == null) {
                        f0.L();
                    }
                    object2 = BaseNodeAdapter.flatData$default(this, (Collection)object2, null, n13, null);
                    object = this.getData();
                    object.removeAll((Collection<?>)object2);
                    n12 = object2.size();
                }
            } else {
                if ((object2 = ((BaseNode)object2).getChildNode()) == null) {
                    f0.L();
                }
                object2 = BaseNodeAdapter.flatData$default(this, (Collection)object2, null, n13, null);
                object = this.getData();
                object.removeAll((Collection<?>)object2);
                n12 = object2.size();
            }
        }
        return n12;
    }

    private final int removeNodesAt(int n10) {
        List list = this.getData();
        int n11 = list.size();
        if (n10 >= n11) {
            return 0;
        }
        n11 = this.removeChildAt(n10);
        this.getData().remove(n10);
        ++n11;
        Object object = (BaseNode)this.getData().get(n10);
        boolean bl2 = object instanceof NodeFooterImp;
        if (bl2 && (object = ((NodeFooterImp)object).getFooterNode()) != null) {
            object = this.getData();
            object.remove(n10);
            ++n11;
        }
        return n11;
    }

    public void addData(int n10, BaseNode object) {
        f0.q(object, "data");
        Object[] objectArray = new BaseNode[]{object};
        object = CollectionsKt__CollectionsKt.r(objectArray);
        this.addData(n10, (Collection)object);
    }

    public void addData(int n10, Collection collection) {
        f0.q(collection, "newData");
        collection = BaseNodeAdapter.flatData$default(this, collection, null, 2, null);
        super.addData(n10, collection);
    }

    public void addData(BaseNode object) {
        f0.q(object, "data");
        Object[] objectArray = new BaseNode[]{object};
        object = CollectionsKt__CollectionsKt.r(objectArray);
        this.addData((Collection)object);
    }

    public void addData(Collection collection) {
        f0.q(collection, "newData");
        collection = BaseNodeAdapter.flatData$default(this, collection, null, 2, null);
        super.addData(collection);
    }

    public final void addFooterNodeProvider(BaseNodeProvider baseNodeProvider) {
        f0.q(baseNodeProvider, "provider");
        this.addFullSpanNodeProvider(baseNodeProvider);
    }

    public final void addFullSpanNodeProvider(BaseNodeProvider baseNodeProvider) {
        f0.q(baseNodeProvider, "provider");
        HashSet hashSet = this.fullSpanNodeTypeSet;
        Integer n10 = baseNodeProvider.getItemViewType();
        hashSet.add(n10);
        this.addItemProvider(baseNodeProvider);
    }

    public void addItemProvider(BaseItemProvider object) {
        String string2 = "provider";
        f0.q(object, string2);
        boolean bl2 = object instanceof BaseNodeProvider;
        if (bl2) {
            super.addItemProvider((BaseItemProvider)object);
            return;
        }
        object = new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
        throw object;
    }

    public final void addNodeProvider(BaseNodeProvider baseNodeProvider) {
        f0.q(baseNodeProvider, "provider");
        this.addItemProvider(baseNodeProvider);
    }

    public final int collapse(int n10) {
        return BaseNodeAdapter.collapse$default(this, n10, false, false, null, 14, null);
    }

    public final int collapse(int n10, boolean bl2) {
        return BaseNodeAdapter.collapse$default(this, n10, bl2, false, null, 12, null);
    }

    public final int collapse(int n10, boolean bl2, boolean bl3) {
        return BaseNodeAdapter.collapse$default(this, n10, bl2, bl3, null, 8, null);
    }

    public final int collapse(int n10, boolean bl2, boolean bl3, Object object) {
        return this.collapse(n10, false, bl2, bl3, object);
    }

    public final int collapseAndChild(int n10) {
        return BaseNodeAdapter.collapseAndChild$default(this, n10, false, false, null, 14, null);
    }

    public final int collapseAndChild(int n10, boolean bl2) {
        return BaseNodeAdapter.collapseAndChild$default(this, n10, bl2, false, null, 12, null);
    }

    public final int collapseAndChild(int n10, boolean bl2, boolean bl3) {
        return BaseNodeAdapter.collapseAndChild$default(this, n10, bl2, bl3, null, 8, null);
    }

    public final int collapseAndChild(int n10, boolean bl2, boolean bl3, Object object) {
        return this.collapse(n10, true, bl2, bl3, object);
    }

    public final int expand(int n10) {
        return BaseNodeAdapter.expand$default(this, n10, false, false, null, 14, null);
    }

    public final int expand(int n10, boolean bl2) {
        return BaseNodeAdapter.expand$default(this, n10, bl2, false, null, 12, null);
    }

    public final int expand(int n10, boolean bl2, boolean bl3) {
        return BaseNodeAdapter.expand$default(this, n10, bl2, bl3, null, 8, null);
    }

    public final int expand(int n10, boolean bl2, boolean bl3, Object object) {
        return this.expand(n10, false, bl2, bl3, object);
    }

    public final int expandAndChild(int n10) {
        return BaseNodeAdapter.expandAndChild$default(this, n10, false, false, null, 14, null);
    }

    public final int expandAndChild(int n10, boolean bl2) {
        return BaseNodeAdapter.expandAndChild$default(this, n10, bl2, false, null, 12, null);
    }

    public final int expandAndChild(int n10, boolean bl2, boolean bl3) {
        return BaseNodeAdapter.expandAndChild$default(this, n10, bl2, bl3, null, 8, null);
    }

    public final int expandAndChild(int n10, boolean bl2, boolean bl3, Object object) {
        return this.expand(n10, true, bl2, bl3, object);
    }

    public final void expandAndCollapseOther(int n10) {
        BaseNodeAdapter.expandAndCollapseOther$default(this, n10, false, false, false, false, null, null, 126, null);
    }

    public final void expandAndCollapseOther(int n10, boolean bl2) {
        BaseNodeAdapter.expandAndCollapseOther$default(this, n10, bl2, false, false, false, null, null, 124, null);
    }

    public final void expandAndCollapseOther(int n10, boolean bl2, boolean bl3) {
        BaseNodeAdapter.expandAndCollapseOther$default(this, n10, bl2, bl3, false, false, null, null, 120, null);
    }

    public final void expandAndCollapseOther(int n10, boolean bl2, boolean bl3, boolean bl4) {
        BaseNodeAdapter.expandAndCollapseOther$default(this, n10, bl2, bl3, bl4, false, null, null, 112, null);
    }

    public final void expandAndCollapseOther(int n10, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        BaseNodeAdapter.expandAndCollapseOther$default(this, n10, bl2, bl3, bl4, bl5, null, null, 96, null);
    }

    public final void expandAndCollapseOther(int n10, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Object object) {
        BaseNodeAdapter.expandAndCollapseOther$default(this, n10, bl2, bl3, bl4, bl5, object, null, 64, null);
    }

    public final void expandAndCollapseOther(int n10, boolean n11, boolean bl2, boolean n12, boolean n13, Object object, Object object2) {
        int n14 = n10;
        int n15 = n11;
        int n16 = n12;
        int n17 = n13;
        int n18 = this.expand(n10, n11 != 0, n12 != 0, n13 != 0, object);
        if (n18 == 0) {
            return;
        }
        n14 = this.findParentNode(n10);
        n15 = 0;
        n16 = -1;
        n17 = n14 == n16 ? 0 : n14 + 1;
        int n19 = n10 - n17;
        if (n19 > 0) {
            int n20 = n17;
            n17 = n10;
            while (++n20 < (n17 -= (n19 = this.collapse(n20, bl2, n12 != 0, n13 != 0, object2)))) {
            }
        } else {
            n17 = n10;
        }
        if (n14 == n16) {
            List list = this.getData();
            n14 = list.size() + -1;
        } else {
            List list = ((BaseNode)this.getData().get(n14)).getChildNode();
            if (list != null) {
                n15 = list.size();
            }
            n14 = n14 + n15 + n18;
        }
        if ((n17 += n18) < n14) {
            for (n18 = ++n17; n18 <= n14; ++n18, n14 -= n15) {
                n16 = n18;
                n17 = (int)(bl2 ? 1 : 0);
                n19 = n12;
                n15 = this.collapse(n18, bl2, n12 != 0, n13 != 0, object2);
            }
        }
    }

    public final int expandOrCollapse(int n10) {
        return BaseNodeAdapter.expandOrCollapse$default(this, n10, false, false, null, 14, null);
    }

    public final int expandOrCollapse(int n10, boolean bl2) {
        return BaseNodeAdapter.expandOrCollapse$default(this, n10, bl2, false, null, 12, null);
    }

    public final int expandOrCollapse(int n10, boolean bl2, boolean bl3) {
        return BaseNodeAdapter.expandOrCollapse$default(this, n10, bl2, bl3, null, 8, null);
    }

    public final int expandOrCollapse(int n10, boolean bl2, boolean bl3, Object object) {
        Object object2 = (BaseNode)this.getData().get(n10);
        int n11 = object2 instanceof BaseExpandNode;
        if (n11 != 0) {
            boolean bl4 = ((BaseExpandNode)(object2 = (BaseExpandNode)object2)).isExpanded();
            if (bl4) {
                n10 = this.collapse(n10, false, bl2, bl3, object);
            } else {
                object2 = this;
                n11 = n10;
                n10 = this.expand(n10, false, bl2, bl3, object);
            }
            return n10;
        }
        return 0;
    }

    public final int findParentNode(int n10) {
        int n11 = -1;
        if (n10 == 0) {
            return n11;
        }
        BaseNode baseNode = (BaseNode)this.getData().get(n10);
        int n12 = 1;
        n10 -= n12;
        while (n10 >= 0) {
            int n13;
            List list = ((BaseNode)this.getData().get(n10)).getChildNode();
            if (list != null && (n13 = list.contains(baseNode)) == n12) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public final int findParentNode(BaseNode baseNode) {
        f0.q(baseNode, "node");
        List list = this.getData();
        int n10 = list.indexOf(baseNode);
        int n11 = -1;
        if (n10 != n11 && n10 != 0) {
            int n12 = 1;
            n10 -= n12;
            while (n10 >= 0) {
                int n13;
                List list2 = ((BaseNode)this.getData().get(n10)).getChildNode();
                if (list2 != null && (n13 = list2.contains(baseNode)) == n12) {
                    return n10;
                }
                n10 += -1;
            }
        }
        return n11;
    }

    public boolean isFixedViewType(int n10) {
        Integer n11;
        HashSet hashSet;
        boolean bl2 = super.isFixedViewType(n10);
        if (!bl2 && (n10 = (int)((hashSet = this.fullSpanNodeTypeSet).contains(n11 = Integer.valueOf(n10)) ? 1 : 0)) == 0) {
            n10 = 0;
            n11 = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public final void nodeAddData(BaseNode baseNode, int n10, BaseNode baseNode2) {
        f0.q(baseNode, "parentNode");
        f0.q(baseNode2, "data");
        Object object = baseNode.getChildNode();
        if (object != null) {
            object.add(n10, baseNode2);
            boolean bl2 = baseNode instanceof BaseExpandNode;
            if (bl2) {
                object = baseNode;
                object = (BaseExpandNode)baseNode;
                bl2 = ((BaseExpandNode)object).isExpanded();
                if (!bl2) {
                    return;
                }
            }
            object = this.getData();
            int n11 = object.indexOf(baseNode) + 1 + n10;
            this.addData(n11, baseNode2);
        }
    }

    public final void nodeAddData(BaseNode baseNode, int n10, Collection collection) {
        f0.q(baseNode, "parentNode");
        f0.q(collection, "newData");
        Object object = baseNode.getChildNode();
        if (object != null) {
            object.addAll(n10, collection);
            boolean bl2 = baseNode instanceof BaseExpandNode;
            if (bl2) {
                object = baseNode;
                object = (BaseExpandNode)baseNode;
                bl2 = ((BaseExpandNode)object).isExpanded();
                if (!bl2) {
                    return;
                }
            }
            object = this.getData();
            int n11 = object.indexOf(baseNode) + 1 + n10;
            this.addData(n11, collection);
        }
    }

    public final void nodeAddData(BaseNode baseNode, BaseNode baseNode2) {
        f0.q(baseNode, "parentNode");
        f0.q(baseNode2, "data");
        List list = baseNode.getChildNode();
        if (list != null) {
            Object object;
            list.add(baseNode2);
            boolean bl2 = baseNode instanceof BaseExpandNode;
            if (bl2) {
                object = baseNode;
                object = (BaseExpandNode)baseNode;
                bl2 = ((BaseExpandNode)object).isExpanded();
                if (!bl2) {
                    return;
                }
            }
            object = this.getData();
            int n10 = object.indexOf(baseNode);
            int n11 = list.size();
            this.addData(n10 += n11, baseNode2);
        }
    }

    public final void nodeRemoveData(BaseNode baseNode, int n10) {
        f0.q(baseNode, "parentNode");
        List list = baseNode.getChildNode();
        if (list != null) {
            Object object;
            int n11 = list.size();
            if (n10 >= n11) {
                return;
            }
            n11 = baseNode instanceof BaseExpandNode;
            if (n11 != 0) {
                object = baseNode;
                object = (BaseExpandNode)baseNode;
                n11 = (int)(((BaseExpandNode)object).isExpanded() ? 1 : 0);
                if (n11 == 0) {
                    list.remove(n10);
                    return;
                }
            }
            object = this.getData();
            int n12 = object.indexOf(baseNode) + 1 + n10;
            this.remove(n12);
            baseNode = (BaseNode)list.remove(n10);
        }
    }

    public final void nodeRemoveData(BaseNode baseNode, BaseNode baseNode2) {
        f0.q(baseNode, "parentNode");
        f0.q(baseNode2, "childNode");
        List list = baseNode.getChildNode();
        if (list != null) {
            boolean bl2;
            boolean bl3 = baseNode instanceof BaseExpandNode;
            if (bl3 && !(bl2 = ((BaseExpandNode)(baseNode = (BaseExpandNode)baseNode)).isExpanded())) {
                list.remove(baseNode2);
                return;
            }
            this.remove(baseNode2);
            list.remove(baseNode2);
        }
    }

    public final void nodeReplaceChildData(BaseNode baseNode, Collection collection) {
        f0.q(baseNode, "parentNode");
        f0.q(collection, "newData");
        List list = baseNode.getChildNode();
        if (list != null) {
            Object object;
            boolean n10 = baseNode instanceof BaseExpandNode;
            if (n10) {
                object = baseNode;
                object = (BaseExpandNode)baseNode;
                boolean bl2 = ((BaseExpandNode)object).isExpanded();
                if (!bl2) {
                    list.clear();
                    list.addAll(collection);
                    return;
                }
            }
            object = this.getData();
            int n11 = object.indexOf(baseNode);
            int n12 = this.removeChildAt(n11);
            list.clear();
            list.addAll(collection);
            collection = BaseNodeAdapter.flatData$default(this, collection, null, 2, null);
            list = this.getData();
            list.addAll(++n11, collection);
            int n13 = this.getHeaderLayoutCount();
            n11 += n13;
            n13 = collection.size();
            if (n12 == n13) {
                this.notifyItemRangeChanged(n11, n12);
            } else {
                this.notifyItemRangeRemoved(n11, n12);
                int n14 = collection.size();
                this.notifyItemRangeInserted(n11, n14);
            }
        }
    }

    public final void nodeSetData(BaseNode baseNode, int n10, BaseNode baseNode2) {
        f0.q(baseNode, "parentNode");
        f0.q(baseNode2, "data");
        List list = baseNode.getChildNode();
        if (list != null) {
            Object object;
            int n11 = list.size();
            if (n10 >= n11) {
                return;
            }
            n11 = baseNode instanceof BaseExpandNode;
            if (n11 != 0) {
                object = baseNode;
                object = (BaseExpandNode)baseNode;
                n11 = (int)(((BaseExpandNode)object).isExpanded() ? 1 : 0);
                if (n11 == 0) {
                    list.set(n10, baseNode2);
                    return;
                }
            }
            object = this.getData();
            int n12 = object.indexOf(baseNode) + 1 + n10;
            this.setData(n12, baseNode2);
            list.set(n10, baseNode2);
        }
    }

    public void removeAt(int n10) {
        int n11 = this.removeNodesAt(n10);
        int n12 = this.getHeaderLayoutCount();
        this.notifyItemRangeRemoved(n10 += n12, n11);
        this.compatibilityDataSizeChanged(0);
    }

    public void setData(int n10, BaseNode object) {
        String string2 = "data";
        f0.q(object, string2);
        int n11 = this.removeNodesAt(n10);
        Object object2 = new BaseNode[]{object};
        object = CollectionsKt__CollectionsKt.r((Object[])object2);
        int n12 = 2;
        object = BaseNodeAdapter.flatData$default(this, (Collection)object, null, n12, null);
        object2 = this.getData();
        object2.addAll(n10, object);
        int n13 = object.size();
        if (n11 == n13) {
            int n14 = this.getHeaderLayoutCount();
            this.notifyItemRangeChanged(n10 += n14, n11);
        } else {
            n13 = this.getHeaderLayoutCount() + n10;
            this.notifyItemRangeRemoved(n13, n11);
            n11 = this.getHeaderLayoutCount();
            int n15 = object.size();
            this.notifyItemRangeInserted(n10 += n11, n15);
        }
    }

    public void setDiffNewData(DiffUtil$DiffResult diffUtil$DiffResult, List list) {
        f0.q(diffUtil$DiffResult, "diffResult");
        String string2 = "list";
        f0.q(list, string2);
        boolean bl2 = this.hasEmptyView();
        if (bl2) {
            this.setNewInstance(list);
            return;
        }
        list = BaseNodeAdapter.flatData$default(this, list, null, 2, null);
        super.setDiffNewData(diffUtil$DiffResult, list);
    }

    public void setDiffNewData(List list) {
        boolean bl2 = this.hasEmptyView();
        if (bl2) {
            this.setNewInstance(list);
            return;
        }
        if (list == null) {
            list = new List();
        }
        list = BaseNodeAdapter.flatData$default(this, list, null, 2, null);
        super.setDiffNewData(list);
    }

    public void setList(Collection list) {
        if (list == null) {
            list = new List();
        }
        list = BaseNodeAdapter.flatData$default(this, list, null, 2, null);
        super.setList(list);
    }

    public void setNewInstance(List list) {
        if (list == null) {
            list = new List();
        }
        list = BaseNodeAdapter.flatData$default(this, list, null, 2, null);
        super.setNewInstance(list);
    }
}

