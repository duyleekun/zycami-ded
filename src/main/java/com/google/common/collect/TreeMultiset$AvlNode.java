/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multisets;
import com.google.common.collect.TreeMultiset;
import java.util.Comparator;

public final class TreeMultiset$AvlNode {
    private int distinctElements;
    private final Object elem;
    private int elemCount;
    private int height;
    private TreeMultiset$AvlNode left;
    private TreeMultiset$AvlNode pred;
    private TreeMultiset$AvlNode right;
    private TreeMultiset$AvlNode succ;
    private long totalCount;

    public TreeMultiset$AvlNode(Object object, int n10) {
        long l10;
        int n11 = 1;
        int n12 = n10 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        this.elem = object;
        this.elemCount = n10;
        this.totalCount = l10 = (long)n10;
        this.distinctElements = n11;
        this.height = n11;
        this.left = null;
        this.right = null;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$1000(TreeMultiset$AvlNode treeMultiset$AvlNode, Comparator comparator, Object object) {
        return treeMultiset$AvlNode.ceiling(comparator, object);
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$1100(TreeMultiset$AvlNode treeMultiset$AvlNode, Comparator comparator, Object object) {
        return treeMultiset$AvlNode.floor(comparator, object);
    }

    public static /* synthetic */ int access$200(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.elemCount;
    }

    public static /* synthetic */ int access$202(TreeMultiset$AvlNode treeMultiset$AvlNode, int n10) {
        treeMultiset$AvlNode.elemCount = n10;
        return n10;
    }

    public static /* synthetic */ long access$300(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.totalCount;
    }

    public static /* synthetic */ int access$400(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.distinctElements;
    }

    public static /* synthetic */ Object access$500(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.elem;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$600(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.left;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$602(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2) {
        treeMultiset$AvlNode.left = treeMultiset$AvlNode2;
        return treeMultiset$AvlNode2;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$700(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.right;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$702(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2) {
        treeMultiset$AvlNode.right = treeMultiset$AvlNode2;
        return treeMultiset$AvlNode2;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$800(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.succ;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$802(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2) {
        treeMultiset$AvlNode.succ = treeMultiset$AvlNode2;
        return treeMultiset$AvlNode2;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$900(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.pred;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$902(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2) {
        treeMultiset$AvlNode.pred = treeMultiset$AvlNode2;
        return treeMultiset$AvlNode2;
    }

    private TreeMultiset$AvlNode addLeftChild(Object object, int n10) {
        TreeMultiset$AvlNode treeMultiset$AvlNode;
        this.left = treeMultiset$AvlNode = new TreeMultiset$AvlNode(object, n10);
        TreeMultiset.access$1700(this.pred, treeMultiset$AvlNode, this);
        int n11 = this.height;
        this.height = n11 = Math.max(2, n11);
        this.distinctElements = n11 = this.distinctElements + 1;
        long l10 = this.totalCount;
        long l11 = n10;
        this.totalCount = l10 += l11;
        return this;
    }

    private TreeMultiset$AvlNode addRightChild(Object object, int n10) {
        TreeMultiset$AvlNode treeMultiset$AvlNode;
        this.right = treeMultiset$AvlNode = new TreeMultiset$AvlNode(object, n10);
        object = this.succ;
        TreeMultiset.access$1700(this, treeMultiset$AvlNode, (TreeMultiset$AvlNode)object);
        int n11 = this.height;
        this.height = n11 = Math.max(2, n11);
        this.distinctElements = n11 = this.distinctElements + 1;
        long l10 = this.totalCount;
        long l11 = n10;
        this.totalCount = l10 += l11;
        return this;
    }

    private int balanceFactor() {
        int n10 = TreeMultiset$AvlNode.height(this.left);
        int n11 = TreeMultiset$AvlNode.height(this.right);
        return n10 - n11;
    }

    private TreeMultiset$AvlNode ceiling(Comparator object, Object object2) {
        Object object3 = this.elem;
        int n10 = object.compare(object2, object3);
        if (n10 < 0) {
            object3 = this.left;
            object = object3 == null ? this : (TreeMultiset$AvlNode)MoreObjects.firstNonNull(super.ceiling((Comparator)object, object2), this);
            return object;
        }
        if (n10 == 0) {
            return this;
        }
        object3 = this.right;
        object = object3 == null ? null : super.ceiling((Comparator)object, object2);
        return object;
    }

    private TreeMultiset$AvlNode deleteMe() {
        int n10;
        int n11 = this.elemCount;
        int n12 = 0;
        this.elemCount = 0;
        TreeMultiset$AvlNode treeMultiset$AvlNode = this.pred;
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = this.succ;
        TreeMultiset.access$1800(treeMultiset$AvlNode, treeMultiset$AvlNode2);
        treeMultiset$AvlNode = this.left;
        if (treeMultiset$AvlNode == null) {
            return this.right;
        }
        treeMultiset$AvlNode2 = this.right;
        if (treeMultiset$AvlNode2 == null) {
            return treeMultiset$AvlNode;
        }
        int n13 = treeMultiset$AvlNode.height;
        int n14 = treeMultiset$AvlNode2.height;
        if (n13 >= n14) {
            treeMultiset$AvlNode2 = this.pred;
            treeMultiset$AvlNode2.left = treeMultiset$AvlNode = treeMultiset$AvlNode.removeMax(treeMultiset$AvlNode2);
            treeMultiset$AvlNode2.right = treeMultiset$AvlNode = this.right;
            treeMultiset$AvlNode2.distinctElements = n12 = this.distinctElements + -1;
            long l10 = this.totalCount;
            long l11 = n11;
            treeMultiset$AvlNode2.totalCount = l10 -= l11;
            return treeMultiset$AvlNode2.rebalance();
        }
        treeMultiset$AvlNode = this.succ;
        treeMultiset$AvlNode.right = treeMultiset$AvlNode2 = treeMultiset$AvlNode2.removeMin(treeMultiset$AvlNode);
        treeMultiset$AvlNode.left = treeMultiset$AvlNode2 = this.left;
        treeMultiset$AvlNode.distinctElements = n10 = this.distinctElements + -1;
        long l12 = this.totalCount;
        long l13 = n11;
        treeMultiset$AvlNode.totalCount = l12 -= l13;
        return treeMultiset$AvlNode.rebalance();
    }

    private TreeMultiset$AvlNode floor(Comparator object, Object object2) {
        Object object3 = this.elem;
        int n10 = object.compare(object2, object3);
        if (n10 > 0) {
            object3 = this.right;
            object = object3 == null ? this : (TreeMultiset$AvlNode)MoreObjects.firstNonNull(super.floor((Comparator)object, object2), this);
            return object;
        }
        if (n10 == 0) {
            return this;
        }
        object3 = this.left;
        object = object3 == null ? null : super.floor((Comparator)object, object2);
        return object;
    }

    private static int height(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        int n10;
        if (treeMultiset$AvlNode == null) {
            n10 = 0;
            treeMultiset$AvlNode = null;
        } else {
            n10 = treeMultiset$AvlNode.height;
        }
        return n10;
    }

    private TreeMultiset$AvlNode rebalance() {
        int n10;
        int n11 = this.balanceFactor();
        if (n11 != (n10 = -2)) {
            n10 = 2;
            if (n11 != n10) {
                this.recomputeHeight();
                return this;
            }
            TreeMultiset$AvlNode treeMultiset$AvlNode = this.left;
            n11 = treeMultiset$AvlNode.balanceFactor();
            if (n11 < 0) {
                this.left = treeMultiset$AvlNode = this.left.rotateLeft();
            }
            return this.rotateRight();
        }
        TreeMultiset$AvlNode treeMultiset$AvlNode = this.right;
        n11 = treeMultiset$AvlNode.balanceFactor();
        if (n11 > 0) {
            this.right = treeMultiset$AvlNode = this.right.rotateRight();
        }
        return this.rotateLeft();
    }

    private void recompute() {
        this.recomputeMultiset();
        this.recomputeHeight();
    }

    private void recomputeHeight() {
        int n10 = TreeMultiset$AvlNode.height(this.left);
        int n11 = TreeMultiset$AvlNode.height(this.right);
        this.height = n10 = Math.max(n10, n11) + 1;
    }

    private void recomputeMultiset() {
        int n10 = TreeMultiset.distinctElements(this.left) + 1;
        int n11 = TreeMultiset.distinctElements(this.right);
        this.distinctElements = n10 += n11;
        long l10 = this.elemCount;
        long l11 = TreeMultiset$AvlNode.totalCount(this.left);
        l10 += l11;
        l11 = TreeMultiset$AvlNode.totalCount(this.right);
        this.totalCount = l10 += l11;
    }

    private TreeMultiset$AvlNode removeMax(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        int n10;
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = this.right;
        if (treeMultiset$AvlNode2 == null) {
            return this.left;
        }
        this.right = treeMultiset$AvlNode2 = treeMultiset$AvlNode2.removeMax(treeMultiset$AvlNode);
        this.distinctElements = n10 = this.distinctElements + -1;
        long l10 = this.totalCount;
        long l11 = treeMultiset$AvlNode.elemCount;
        this.totalCount = l10 -= l11;
        return this.rebalance();
    }

    private TreeMultiset$AvlNode removeMin(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        int n10;
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = this.left;
        if (treeMultiset$AvlNode2 == null) {
            return this.right;
        }
        this.left = treeMultiset$AvlNode2 = treeMultiset$AvlNode2.removeMin(treeMultiset$AvlNode);
        this.distinctElements = n10 = this.distinctElements + -1;
        long l10 = this.totalCount;
        long l11 = treeMultiset$AvlNode.elemCount;
        this.totalCount = l10 -= l11;
        return this.rebalance();
    }

    private TreeMultiset$AvlNode rotateLeft() {
        int n10;
        long l10;
        TreeMultiset$AvlNode treeMultiset$AvlNode;
        boolean bl2;
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = this.right;
        if (treeMultiset$AvlNode2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            treeMultiset$AvlNode2 = null;
        }
        Preconditions.checkState(bl2);
        treeMultiset$AvlNode2 = this.right;
        this.right = treeMultiset$AvlNode = treeMultiset$AvlNode2.left;
        treeMultiset$AvlNode2.left = this;
        treeMultiset$AvlNode2.totalCount = l10 = this.totalCount;
        treeMultiset$AvlNode2.distinctElements = n10 = this.distinctElements;
        this.recompute();
        treeMultiset$AvlNode2.recomputeHeight();
        return treeMultiset$AvlNode2;
    }

    private TreeMultiset$AvlNode rotateRight() {
        int n10;
        long l10;
        TreeMultiset$AvlNode treeMultiset$AvlNode;
        boolean bl2;
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = this.left;
        if (treeMultiset$AvlNode2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            treeMultiset$AvlNode2 = null;
        }
        Preconditions.checkState(bl2);
        treeMultiset$AvlNode2 = this.left;
        this.left = treeMultiset$AvlNode = treeMultiset$AvlNode2.right;
        treeMultiset$AvlNode2.right = this;
        treeMultiset$AvlNode2.totalCount = l10 = this.totalCount;
        treeMultiset$AvlNode2.distinctElements = n10 = this.distinctElements;
        this.recompute();
        treeMultiset$AvlNode2.recomputeHeight();
        return treeMultiset$AvlNode2;
    }

    private static long totalCount(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        long l10 = treeMultiset$AvlNode == null ? 0L : treeMultiset$AvlNode.totalCount;
        return l10;
    }

    public TreeMultiset$AvlNode add(Comparator object, Object object2, int n10, int[] nArray) {
        int n11;
        Object object3 = this.elem;
        int n12 = object.compare(object2, object3);
        int n13 = 1;
        if (n12 < 0) {
            object3 = this.left;
            if (object3 == null) {
                nArray[0] = 0;
                return this.addLeftChild(object2, n10);
            }
            int n14 = ((TreeMultiset$AvlNode)object3).height;
            this.left = object = ((TreeMultiset$AvlNode)object3).add((Comparator)object, object2, n10, nArray);
            int n15 = nArray[0];
            if (n15 == 0) {
                this.distinctElements = n15 = this.distinctElements + n13;
            }
            long l10 = this.totalCount;
            long l11 = n10;
            this.totalCount = l10 += l11;
            int n16 = ((TreeMultiset$AvlNode)object).height;
            object = n16 == n14 ? this : this.rebalance();
            return object;
        }
        if (n12 > 0) {
            object3 = this.right;
            if (object3 == null) {
                nArray[0] = 0;
                return this.addRightChild(object2, n10);
            }
            int n17 = ((TreeMultiset$AvlNode)object3).height;
            this.right = object = ((TreeMultiset$AvlNode)object3).add((Comparator)object, object2, n10, nArray);
            int n18 = nArray[0];
            if (n18 == 0) {
                this.distinctElements = n18 = this.distinctElements + n13;
            }
            long l12 = this.totalCount;
            long l13 = n10;
            this.totalCount = l12 += l13;
            int n19 = ((TreeMultiset$AvlNode)object).height;
            object = n19 == n17 ? this : this.rebalance();
            return object;
        }
        nArray[0] = n11 = this.elemCount;
        long l14 = n11;
        long l15 = n10;
        long l16 = Integer.MAX_VALUE;
        long l17 = (l14 += l15) - l16;
        n11 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
        if (n11 > 0) {
            n13 = 0;
        }
        Preconditions.checkArgument(n13 != 0);
        this.elemCount = n11 = this.elemCount + n10;
        this.totalCount = l14 = this.totalCount + l15;
        return this;
    }

    public int count(Comparator comparator, Object object) {
        Object object2 = this.elem;
        int n10 = comparator.compare(object, object2);
        int n11 = 0;
        if (n10 < 0) {
            object2 = this.left;
            if (object2 != null) {
                n11 = ((TreeMultiset$AvlNode)object2).count(comparator, object);
            }
            return n11;
        }
        if (n10 > 0) {
            object2 = this.right;
            if (object2 != null) {
                n11 = ((TreeMultiset$AvlNode)object2).count(comparator, object);
            }
            return n11;
        }
        return this.elemCount;
    }

    public int getCount() {
        return this.elemCount;
    }

    public Object getElement() {
        return this.elem;
    }

    public TreeMultiset$AvlNode remove(Comparator object, Object object2, int n10, int[] nArray) {
        int n11;
        Object object3 = this.elem;
        int n12 = object.compare(object2, object3);
        if (n12 < 0) {
            object3 = this.left;
            if (object3 == null) {
                nArray[0] = 0;
                return this;
            }
            this.left = object = ((TreeMultiset$AvlNode)object3).remove((Comparator)object, object2, n10, nArray);
            int n13 = nArray[0];
            if (n13 > 0) {
                n13 = nArray[0];
                if (n10 >= n13) {
                    this.distinctElements = n13 = this.distinctElements + -1;
                    long l10 = this.totalCount;
                    n10 = nArray[0];
                    long l11 = n10;
                    this.totalCount = l10 -= l11;
                } else {
                    long l12 = this.totalCount;
                    long l13 = n10;
                    this.totalCount = l12 -= l13;
                }
            }
            object = (n13 = nArray[0]) == 0 ? this : this.rebalance();
            return object;
        }
        if (n12 > 0) {
            object3 = this.right;
            if (object3 == null) {
                nArray[0] = 0;
                return this;
            }
            this.right = object = ((TreeMultiset$AvlNode)object3).remove((Comparator)object, object2, n10, nArray);
            int n14 = nArray[0];
            if (n14 > 0) {
                n14 = nArray[0];
                if (n10 >= n14) {
                    this.distinctElements = n14 = this.distinctElements + -1;
                    long l14 = this.totalCount;
                    n10 = nArray[0];
                    long l15 = n10;
                    this.totalCount = l14 -= l15;
                } else {
                    long l16 = this.totalCount;
                    long l17 = n10;
                    this.totalCount = l16 -= l17;
                }
            }
            return this.rebalance();
        }
        nArray[0] = n11 = this.elemCount;
        if (n10 >= n11) {
            return this.deleteMe();
        }
        this.elemCount = n11 -= n10;
        long l18 = this.totalCount;
        long l19 = n10;
        this.totalCount = l18 -= l19;
        return this;
    }

    public TreeMultiset$AvlNode setCount(Comparator object, Object object2, int n10, int n11, int[] nArray) {
        int n12;
        Object object3 = this.elem;
        int n13 = object.compare(object2, object3);
        if (n13 < 0) {
            TreeMultiset$AvlNode treeMultiset$AvlNode = this.left;
            if (treeMultiset$AvlNode == null) {
                nArray[0] = 0;
                if (n10 == 0 && n11 > 0) {
                    return this.addLeftChild(object2, n11);
                }
                return this;
            }
            this.left = object = treeMultiset$AvlNode.setCount((Comparator)object, object2, n10, n11, nArray);
            int n14 = nArray[0];
            if (n14 == n10) {
                if (n11 == 0 && (n14 = nArray[0]) != 0) {
                    this.distinctElements = n14 = this.distinctElements + -1;
                } else if (n11 > 0 && (n14 = nArray[0]) == 0) {
                    this.distinctElements = n14 = this.distinctElements + 1;
                }
                long l10 = this.totalCount;
                n10 = nArray[0];
                long l11 = n11 -= n10;
                this.totalCount = l10 += l11;
            }
            return this.rebalance();
        }
        if (n13 > 0) {
            TreeMultiset$AvlNode treeMultiset$AvlNode = this.right;
            if (treeMultiset$AvlNode == null) {
                nArray[0] = 0;
                if (n10 == 0 && n11 > 0) {
                    return this.addRightChild(object2, n11);
                }
                return this;
            }
            this.right = object = treeMultiset$AvlNode.setCount((Comparator)object, object2, n10, n11, nArray);
            int n15 = nArray[0];
            if (n15 == n10) {
                if (n11 == 0 && (n15 = nArray[0]) != 0) {
                    this.distinctElements = n15 = this.distinctElements + -1;
                } else if (n11 > 0 && (n15 = nArray[0]) == 0) {
                    this.distinctElements = n15 = this.distinctElements + 1;
                }
                long l12 = this.totalCount;
                n10 = nArray[0];
                long l13 = n11 -= n10;
                this.totalCount = l12 += l13;
            }
            return this.rebalance();
        }
        nArray[0] = n12 = this.elemCount;
        if (n10 == n12) {
            if (n11 == 0) {
                return this.deleteMe();
            }
            long l14 = this.totalCount;
            n12 = n11 - n12;
            long l15 = n12;
            this.totalCount = l14 += l15;
            this.elemCount = n11;
        }
        return this;
    }

    public TreeMultiset$AvlNode setCount(Comparator object, Object object2, int n10, int[] nArray) {
        int n11;
        Object object3 = this.elem;
        int n12 = object.compare(object2, object3);
        if (n12 < 0) {
            int n13;
            object3 = this.left;
            if (object3 == null) {
                nArray[0] = 0;
                object = n10 > 0 ? this.addLeftChild(object2, n10) : this;
                return object;
            }
            this.left = object = ((TreeMultiset$AvlNode)object3).setCount((Comparator)object, object2, n10, nArray);
            if (n10 == 0 && (n13 = nArray[0]) != 0) {
                this.distinctElements = n13 = this.distinctElements + -1;
            } else if (n10 > 0 && (n13 = nArray[0]) == 0) {
                this.distinctElements = n13 = this.distinctElements + 1;
            }
            long l10 = this.totalCount;
            int n14 = nArray[0];
            long l11 = n10 - n14;
            this.totalCount = l10 += l11;
            return this.rebalance();
        }
        if (n12 > 0) {
            int n15;
            object3 = this.right;
            if (object3 == null) {
                nArray[0] = 0;
                object = n10 > 0 ? this.addRightChild(object2, n10) : this;
                return object;
            }
            this.right = object = ((TreeMultiset$AvlNode)object3).setCount((Comparator)object, object2, n10, nArray);
            if (n10 == 0 && (n15 = nArray[0]) != 0) {
                this.distinctElements = n15 = this.distinctElements + -1;
            } else if (n10 > 0 && (n15 = nArray[0]) == 0) {
                this.distinctElements = n15 = this.distinctElements + 1;
            }
            long l12 = this.totalCount;
            int n16 = nArray[0];
            long l13 = n10 - n16;
            this.totalCount = l12 += l13;
            return this.rebalance();
        }
        nArray[0] = n11 = this.elemCount;
        if (n10 == 0) {
            return this.deleteMe();
        }
        long l14 = this.totalCount;
        long l15 = n10 - n11;
        this.totalCount = l14 += l15;
        this.elemCount = n10;
        return this;
    }

    public String toString() {
        Object object = this.getElement();
        int n10 = this.getCount();
        return Multisets.immutableEntry(object, n10).toString();
    }
}

