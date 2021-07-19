/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSortedMultiset;
import com.google.common.collect.BoundType;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.GeneralRange;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.Serialization$FieldSetter;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset$1;
import com.google.common.collect.TreeMultiset$2;
import com.google.common.collect.TreeMultiset$3;
import com.google.common.collect.TreeMultiset$4;
import com.google.common.collect.TreeMultiset$Aggregate;
import com.google.common.collect.TreeMultiset$AvlNode;
import com.google.common.collect.TreeMultiset$Reference;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

public final class TreeMultiset
extends AbstractSortedMultiset
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final transient TreeMultiset$AvlNode header;
    private final transient GeneralRange range;
    private final transient TreeMultiset$Reference rootReference;

    public TreeMultiset(TreeMultiset$Reference treeMultiset$Reference, GeneralRange generalRange, TreeMultiset$AvlNode treeMultiset$AvlNode) {
        Comparator comparator = generalRange.comparator();
        super(comparator);
        this.rootReference = treeMultiset$Reference;
        this.range = generalRange;
        this.header = treeMultiset$AvlNode;
    }

    public TreeMultiset(Comparator object) {
        super((Comparator)object);
        this.range = object = GeneralRange.all((Comparator)object);
        this.header = object = new TreeMultiset$AvlNode(null, 1);
        TreeMultiset.successor((TreeMultiset$AvlNode)object, (TreeMultiset$AvlNode)object);
        this.rootReference = object = new TreeMultiset$Reference(null);
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$1200(TreeMultiset treeMultiset) {
        return treeMultiset.firstNode();
    }

    public static /* synthetic */ GeneralRange access$1300(TreeMultiset treeMultiset) {
        return treeMultiset.range;
    }

    public static /* synthetic */ Multiset$Entry access$1400(TreeMultiset treeMultiset, TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset.wrapEntry(treeMultiset$AvlNode);
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$1500(TreeMultiset treeMultiset) {
        return treeMultiset.header;
    }

    public static /* synthetic */ TreeMultiset$AvlNode access$1600(TreeMultiset treeMultiset) {
        return treeMultiset.lastNode();
    }

    public static /* synthetic */ void access$1700(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2, TreeMultiset$AvlNode treeMultiset$AvlNode3) {
        TreeMultiset.successor(treeMultiset$AvlNode, treeMultiset$AvlNode2, treeMultiset$AvlNode3);
    }

    public static /* synthetic */ void access$1800(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2) {
        TreeMultiset.successor(treeMultiset$AvlNode, treeMultiset$AvlNode2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long aggregateAboveRange(TreeMultiset$Aggregate object, TreeMultiset$AvlNode treeMultiset$AvlNode) {
        long l10;
        long l11;
        Object object2;
        Object object3;
        if (treeMultiset$AvlNode == null) {
            return 0L;
        }
        Object object4 = this.comparator();
        int n10 = object4.compare(object3 = this.range.getUpperEndpoint(), object2 = TreeMultiset$AvlNode.access$500(treeMultiset$AvlNode));
        if (n10 > 0) {
            treeMultiset$AvlNode = TreeMultiset$AvlNode.access$700(treeMultiset$AvlNode);
            return this.aggregateAboveRange((TreeMultiset$Aggregate)((Object)object), treeMultiset$AvlNode);
        }
        if (n10 == 0) {
            object4 = TreeMultiset$4.$SwitchMap$com$google$common$collect$BoundType;
            object3 = this.range.getUpperBoundType();
            int n11 = ((Enum)object3).ordinal();
            Object object5 = object4[n11];
            if (object5 != (n11 = 1)) {
                n11 = 2;
                if (object5 == n11) {
                    treeMultiset$AvlNode = TreeMultiset$AvlNode.access$700(treeMultiset$AvlNode);
                    return ((TreeMultiset$Aggregate)((Object)object)).treeAggregate(treeMultiset$AvlNode);
                }
                object = new AssertionError();
                throw object;
            }
            int n12 = ((TreeMultiset$Aggregate)((Object)object)).nodeAggregate(treeMultiset$AvlNode);
            l11 = n12;
            treeMultiset$AvlNode = TreeMultiset$AvlNode.access$700(treeMultiset$AvlNode);
            l10 = ((TreeMultiset$Aggregate)((Object)object)).treeAggregate(treeMultiset$AvlNode);
            return l11 + l10;
        }
        object4 = TreeMultiset$AvlNode.access$700(treeMultiset$AvlNode);
        l11 = ((TreeMultiset$Aggregate)((Object)object)).treeAggregate((TreeMultiset$AvlNode)object4);
        int n13 = ((TreeMultiset$Aggregate)((Object)object)).nodeAggregate(treeMultiset$AvlNode);
        long l12 = n13;
        l11 += l12;
        treeMultiset$AvlNode = TreeMultiset$AvlNode.access$600(treeMultiset$AvlNode);
        l10 = this.aggregateAboveRange((TreeMultiset$Aggregate)((Object)object), treeMultiset$AvlNode);
        return l11 + l10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long aggregateBelowRange(TreeMultiset$Aggregate object, TreeMultiset$AvlNode treeMultiset$AvlNode) {
        long l10;
        long l11;
        Object object2;
        Object object3;
        if (treeMultiset$AvlNode == null) {
            return 0L;
        }
        Object object4 = this.comparator();
        int n10 = object4.compare(object3 = this.range.getLowerEndpoint(), object2 = TreeMultiset$AvlNode.access$500(treeMultiset$AvlNode));
        if (n10 < 0) {
            treeMultiset$AvlNode = TreeMultiset$AvlNode.access$600(treeMultiset$AvlNode);
            return this.aggregateBelowRange((TreeMultiset$Aggregate)((Object)object), treeMultiset$AvlNode);
        }
        if (n10 == 0) {
            object4 = TreeMultiset$4.$SwitchMap$com$google$common$collect$BoundType;
            object3 = this.range.getLowerBoundType();
            int n11 = ((Enum)object3).ordinal();
            Object object5 = object4[n11];
            if (object5 != (n11 = 1)) {
                n11 = 2;
                if (object5 == n11) {
                    treeMultiset$AvlNode = TreeMultiset$AvlNode.access$600(treeMultiset$AvlNode);
                    return ((TreeMultiset$Aggregate)((Object)object)).treeAggregate(treeMultiset$AvlNode);
                }
                object = new AssertionError();
                throw object;
            }
            int n12 = ((TreeMultiset$Aggregate)((Object)object)).nodeAggregate(treeMultiset$AvlNode);
            l11 = n12;
            treeMultiset$AvlNode = TreeMultiset$AvlNode.access$600(treeMultiset$AvlNode);
            l10 = ((TreeMultiset$Aggregate)((Object)object)).treeAggregate(treeMultiset$AvlNode);
            return l11 + l10;
        }
        object4 = TreeMultiset$AvlNode.access$600(treeMultiset$AvlNode);
        l11 = ((TreeMultiset$Aggregate)((Object)object)).treeAggregate((TreeMultiset$AvlNode)object4);
        int n13 = ((TreeMultiset$Aggregate)((Object)object)).nodeAggregate(treeMultiset$AvlNode);
        long l12 = n13;
        l11 += l12;
        treeMultiset$AvlNode = TreeMultiset$AvlNode.access$700(treeMultiset$AvlNode);
        l10 = this.aggregateBelowRange((TreeMultiset$Aggregate)((Object)object), treeMultiset$AvlNode);
        return l11 + l10;
    }

    private long aggregateForEntries(TreeMultiset$Aggregate treeMultiset$Aggregate) {
        long l10;
        TreeMultiset$AvlNode treeMultiset$AvlNode = (TreeMultiset$AvlNode)this.rootReference.get();
        long l11 = treeMultiset$Aggregate.treeAggregate(treeMultiset$AvlNode);
        GeneralRange generalRange = this.range;
        boolean bl2 = generalRange.hasLowerBound();
        if (bl2) {
            l10 = this.aggregateBelowRange(treeMultiset$Aggregate, treeMultiset$AvlNode);
            l11 -= l10;
        }
        if (bl2 = (generalRange = this.range).hasUpperBound()) {
            l10 = this.aggregateAboveRange(treeMultiset$Aggregate, treeMultiset$AvlNode);
            l11 -= l10;
        }
        return l11;
    }

    public static TreeMultiset create() {
        Ordering ordering = Ordering.natural();
        TreeMultiset treeMultiset = new TreeMultiset(ordering);
        return treeMultiset;
    }

    public static TreeMultiset create(Iterable iterable) {
        TreeMultiset treeMultiset = TreeMultiset.create();
        Iterables.addAll(treeMultiset, iterable);
        return treeMultiset;
    }

    public static TreeMultiset create(Comparator object) {
        if (object == null) {
            Ordering ordering = Ordering.natural();
            object = new TreeMultiset(ordering);
        } else {
            TreeMultiset treeMultiset = new TreeMultiset((Comparator)object);
            object = treeMultiset;
        }
        return object;
    }

    public static int distinctElements(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        int n10;
        if (treeMultiset$AvlNode == null) {
            n10 = 0;
            treeMultiset$AvlNode = null;
        } else {
            n10 = TreeMultiset$AvlNode.access$400(treeMultiset$AvlNode);
        }
        return n10;
    }

    private TreeMultiset$AvlNode firstNode() {
        boolean bl2;
        Object object;
        TreeMultiset$AvlNode treeMultiset$AvlNode;
        Object object2 = (TreeMultiset$AvlNode)this.rootReference.get();
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = null;
        if (object2 == null) {
            return null;
        }
        object2 = this.range;
        boolean n10 = ((GeneralRange)object2).hasLowerBound();
        if (n10) {
            int n11;
            Object object3;
            object2 = this.range.getLowerEndpoint();
            treeMultiset$AvlNode = (TreeMultiset$AvlNode)this.rootReference.get();
            object = this.comparator();
            if ((treeMultiset$AvlNode = TreeMultiset$AvlNode.access$1000(treeMultiset$AvlNode, (Comparator)object, object2)) == null) {
                return null;
            }
            object = this.range.getLowerBoundType();
            if (object == (object3 = BoundType.OPEN) && (n11 = (object = this.comparator()).compare(object2, object3 = treeMultiset$AvlNode.getElement())) == 0) {
                treeMultiset$AvlNode = TreeMultiset$AvlNode.access$800(treeMultiset$AvlNode);
            }
        } else {
            object2 = this.header;
            treeMultiset$AvlNode = TreeMultiset$AvlNode.access$800((TreeMultiset$AvlNode)object2);
        }
        if (treeMultiset$AvlNode != (object2 = this.header) && (bl2 = ((GeneralRange)(object2 = this.range)).contains(object = treeMultiset$AvlNode.getElement()))) {
            treeMultiset$AvlNode2 = treeMultiset$AvlNode;
        }
        return treeMultiset$AvlNode2;
    }

    private TreeMultiset$AvlNode lastNode() {
        boolean bl2;
        Object object;
        TreeMultiset$AvlNode treeMultiset$AvlNode;
        Object object2 = (TreeMultiset$AvlNode)this.rootReference.get();
        TreeMultiset$AvlNode treeMultiset$AvlNode2 = null;
        if (object2 == null) {
            return null;
        }
        object2 = this.range;
        boolean n10 = ((GeneralRange)object2).hasUpperBound();
        if (n10) {
            int n11;
            Object object3;
            object2 = this.range.getUpperEndpoint();
            treeMultiset$AvlNode = (TreeMultiset$AvlNode)this.rootReference.get();
            object = this.comparator();
            if ((treeMultiset$AvlNode = TreeMultiset$AvlNode.access$1100(treeMultiset$AvlNode, (Comparator)object, object2)) == null) {
                return null;
            }
            object = this.range.getUpperBoundType();
            if (object == (object3 = BoundType.OPEN) && (n11 = (object = this.comparator()).compare(object2, object3 = treeMultiset$AvlNode.getElement())) == 0) {
                treeMultiset$AvlNode = TreeMultiset$AvlNode.access$900(treeMultiset$AvlNode);
            }
        } else {
            object2 = this.header;
            treeMultiset$AvlNode = TreeMultiset$AvlNode.access$900((TreeMultiset$AvlNode)object2);
        }
        if (treeMultiset$AvlNode != (object2 = this.header) && (bl2 = ((GeneralRange)(object2 = this.range)).contains(object = treeMultiset$AvlNode.getElement()))) {
            treeMultiset$AvlNode2 = treeMultiset$AvlNode;
        }
        return treeMultiset$AvlNode2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Object object = (Comparator)objectInputStream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set((Object)this, object);
        Object object2 = Serialization.getFieldSetter(TreeMultiset.class, "range");
        object = GeneralRange.all((Comparator)object);
        ((Serialization$FieldSetter)object2).set((Object)this, object);
        object = Serialization.getFieldSetter(TreeMultiset.class, "rootReference");
        object2 = new TreeMultiset$Reference(null);
        ((Serialization$FieldSetter)object).set((Object)this, object2);
        object = new TreeMultiset$AvlNode(null, 1);
        Serialization.getFieldSetter(TreeMultiset.class, "header").set((Object)this, object);
        TreeMultiset.successor((TreeMultiset$AvlNode)object, (TreeMultiset$AvlNode)object);
        Serialization.populateMultiset(this, objectInputStream);
    }

    private static void successor(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2) {
        TreeMultiset$AvlNode.access$802(treeMultiset$AvlNode, treeMultiset$AvlNode2);
        TreeMultiset$AvlNode.access$902(treeMultiset$AvlNode2, treeMultiset$AvlNode);
    }

    private static void successor(TreeMultiset$AvlNode treeMultiset$AvlNode, TreeMultiset$AvlNode treeMultiset$AvlNode2, TreeMultiset$AvlNode treeMultiset$AvlNode3) {
        TreeMultiset.successor(treeMultiset$AvlNode, treeMultiset$AvlNode2);
        TreeMultiset.successor(treeMultiset$AvlNode2, treeMultiset$AvlNode3);
    }

    private Multiset$Entry wrapEntry(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        TreeMultiset$1 treeMultiset$1 = new TreeMultiset$1(this, treeMultiset$AvlNode);
        return treeMultiset$1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Comparator comparator = this.elementSet().comparator();
        objectOutputStream.writeObject(comparator);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    public int add(Object object, int n10) {
        Object object2 = "occurrences";
        CollectPreconditions.checkNonnegative(n10, (String)object2);
        if (n10 == 0) {
            return this.count(object);
        }
        boolean bl2 = this.range.contains(object);
        Preconditions.checkArgument(bl2);
        object2 = (TreeMultiset$AvlNode)this.rootReference.get();
        if (object2 == null) {
            this.comparator().compare(object, object);
            TreeMultiset$AvlNode treeMultiset$AvlNode = new TreeMultiset$AvlNode(object, n10);
            object = this.header;
            TreeMultiset.successor((TreeMultiset$AvlNode)object, treeMultiset$AvlNode, (TreeMultiset$AvlNode)object);
            this.rootReference.checkAndSet(object2, treeMultiset$AvlNode);
            return 0;
        }
        int[] nArray = new int[1];
        Comparator comparator = this.comparator();
        object = ((TreeMultiset$AvlNode)object2).add(comparator, object, n10, nArray);
        this.rootReference.checkAndSet(object2, object);
        return nArray[0];
    }

    public void clear() {
        Object object = this.range;
        boolean bl2 = ((GeneralRange)object).hasLowerBound();
        if (!bl2 && !(bl2 = ((GeneralRange)(object = this.range)).hasUpperBound())) {
            TreeMultiset$AvlNode treeMultiset$AvlNode;
            object = TreeMultiset$AvlNode.access$800(this.header);
            while (object != (treeMultiset$AvlNode = this.header)) {
                treeMultiset$AvlNode = TreeMultiset$AvlNode.access$800((TreeMultiset$AvlNode)object);
                TreeMultiset$AvlNode.access$202((TreeMultiset$AvlNode)object, 0);
                TreeMultiset$AvlNode.access$602((TreeMultiset$AvlNode)object, null);
                TreeMultiset$AvlNode.access$702((TreeMultiset$AvlNode)object, null);
                TreeMultiset$AvlNode.access$902((TreeMultiset$AvlNode)object, null);
                TreeMultiset$AvlNode.access$802((TreeMultiset$AvlNode)object, null);
                object = treeMultiset$AvlNode;
            }
            TreeMultiset.successor(treeMultiset$AvlNode, treeMultiset$AvlNode);
            object = this.rootReference;
            ((TreeMultiset$Reference)object).clear();
        } else {
            object = this.entryIterator();
            Iterators.clear((Iterator)object);
        }
    }

    public int count(Object object) {
        block8: {
            Object object2 = this.rootReference;
            object2 = ((TreeMultiset$Reference)object2).get();
            object2 = (TreeMultiset$AvlNode)object2;
            Object object3 = this.range;
            boolean bl2 = ((GeneralRange)object3).contains(object);
            if (!bl2 || object2 == null) break block8;
            object3 = this.comparator();
            try {
                return ((TreeMultiset$AvlNode)object2).count((Comparator)object3, object);
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
        }
        return 0;
    }

    public Iterator descendingEntryIterator() {
        TreeMultiset$3 treeMultiset$3 = new TreeMultiset$3(this);
        return treeMultiset$3;
    }

    public int distinctElements() {
        TreeMultiset$Aggregate treeMultiset$Aggregate = TreeMultiset$Aggregate.DISTINCT;
        return Ints.saturatedCast(this.aggregateForEntries(treeMultiset$Aggregate));
    }

    public Iterator elementIterator() {
        return Multisets.elementIterator(this.entryIterator());
    }

    public Iterator entryIterator() {
        TreeMultiset$2 treeMultiset$2 = new TreeMultiset$2(this);
        return treeMultiset$2;
    }

    public SortedMultiset headMultiset(Object object, BoundType object2) {
        TreeMultiset$Reference treeMultiset$Reference = this.rootReference;
        GeneralRange generalRange = this.range;
        object = GeneralRange.upTo(this.comparator(), object, object2);
        object = generalRange.intersect((GeneralRange)object);
        object2 = this.header;
        TreeMultiset treeMultiset = new TreeMultiset(treeMultiset$Reference, (GeneralRange)object, (TreeMultiset$AvlNode)object2);
        return treeMultiset;
    }

    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public int remove(Object object, int n10) {
        block3: {
            Object object2 = "occurrences";
            CollectPreconditions.checkNonnegative(n10, (String)object2);
            if (n10 == 0) {
                return this.count(object);
            }
            object2 = (TreeMultiset$AvlNode)this.rootReference.get();
            int n11 = 1;
            int[] nArray = new int[n11];
            try {
                Object object3 = this.range;
                boolean bl2 = ((GeneralRange)object3).contains(object);
                if (!bl2 || object2 == null) break block3;
                object3 = this.comparator();
                object = ((TreeMultiset$AvlNode)object2).remove((Comparator)object3, object, n10, nArray);
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
            this.rootReference.checkAndSet(object2, object);
            return nArray[0];
        }
        return 0;
    }

    public int setCount(Object object, int n10) {
        CollectPreconditions.checkNonnegative(n10, "count");
        Object object2 = this.range;
        boolean bl2 = ((GeneralRange)object2).contains(object);
        int n11 = 1;
        if (!bl2) {
            if (n10 != 0) {
                n11 = 0;
                Object var6_6 = null;
            }
            Preconditions.checkArgument(n11 != 0);
            return 0;
        }
        object2 = (TreeMultiset$AvlNode)this.rootReference.get();
        if (object2 == null) {
            if (n10 > 0) {
                this.add(object, n10);
            }
            return 0;
        }
        int[] nArray = new int[n11];
        Comparator comparator = this.comparator();
        object = ((TreeMultiset$AvlNode)object2).setCount(comparator, object, n10, nArray);
        this.rootReference.checkAndSet(object2, object);
        return nArray[0];
    }

    public boolean setCount(Object object, int n10, int n11) {
        CollectPreconditions.checkNonnegative(n11, "newCount");
        CollectPreconditions.checkNonnegative(n10, "oldCount");
        boolean bl2 = this.range.contains(object);
        Preconditions.checkArgument(bl2);
        TreeMultiset$AvlNode treeMultiset$AvlNode = (TreeMultiset$AvlNode)this.rootReference.get();
        boolean bl3 = false;
        boolean bl4 = true;
        if (treeMultiset$AvlNode == null) {
            if (n10 == 0) {
                if (n11 > 0) {
                    this.add(object, n11);
                }
                return bl4;
            }
            return false;
        }
        int[] nArray = new int[bl4];
        Comparator comparator = this.comparator();
        object = treeMultiset$AvlNode.setCount(comparator, object, n10, n11, nArray);
        TreeMultiset$Reference treeMultiset$Reference = this.rootReference;
        treeMultiset$Reference.checkAndSet(treeMultiset$AvlNode, object);
        int n12 = nArray[0];
        if (n12 == n10) {
            bl3 = bl4;
        }
        return bl3;
    }

    public int size() {
        TreeMultiset$Aggregate treeMultiset$Aggregate = TreeMultiset$Aggregate.SIZE;
        return Ints.saturatedCast(this.aggregateForEntries(treeMultiset$Aggregate));
    }

    public SortedMultiset tailMultiset(Object object, BoundType object2) {
        TreeMultiset$Reference treeMultiset$Reference = this.rootReference;
        GeneralRange generalRange = this.range;
        object = GeneralRange.downTo(this.comparator(), object, object2);
        object = generalRange.intersect((GeneralRange)object);
        object2 = this.header;
        TreeMultiset treeMultiset = new TreeMultiset(treeMultiset$Reference, (GeneralRange)object, (TreeMultiset$AvlNode)object2);
        return treeMultiset;
    }
}

