/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$1;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$AvlBuilder;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$AvlIterator;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$EntrySet;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$KeySet;
import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$Node;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class LinkedHashTreeMap
extends AbstractMap
implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER;
    public Comparator comparator;
    private LinkedHashTreeMap$EntrySet entrySet;
    public final LinkedHashTreeMap$Node header;
    private LinkedHashTreeMap$KeySet keySet;
    public int modCount;
    public int size;
    public LinkedHashTreeMap$Node[] table;
    public int threshold;

    static {
        LinkedHashTreeMap$1 linkedHashTreeMap$1 = new LinkedHashTreeMap$1();
        NATURAL_ORDER = linkedHashTreeMap$1;
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    public LinkedHashTreeMap(Comparator linkedHashTreeMap$NodeArray) {
        int n10 = 0;
        this.size = 0;
        this.modCount = 0;
        if (linkedHashTreeMap$NodeArray == null) {
            linkedHashTreeMap$NodeArray = NATURAL_ORDER;
        }
        this.comparator = linkedHashTreeMap$NodeArray;
        linkedHashTreeMap$NodeArray = new LinkedHashTreeMap$Node();
        this.header = linkedHashTreeMap$NodeArray;
        linkedHashTreeMap$NodeArray = new LinkedHashTreeMap$Node[16];
        this.table = linkedHashTreeMap$NodeArray;
        n10 = linkedHashTreeMap$NodeArray.length / 2;
        int n11 = linkedHashTreeMap$NodeArray.length / 4;
        this.threshold = n10 += n11;
    }

    private void doubleCapacity() {
        LinkedHashTreeMap$Node[] linkedHashTreeMap$NodeArray = LinkedHashTreeMap.doubleCapacity(this.table);
        this.table = linkedHashTreeMap$NodeArray;
        int n10 = linkedHashTreeMap$NodeArray.length / 2;
        int n11 = linkedHashTreeMap$NodeArray.length / 4;
        this.threshold = n10 += n11;
    }

    public static LinkedHashTreeMap$Node[] doubleCapacity(LinkedHashTreeMap$Node[] linkedHashTreeMap$NodeArray) {
        int n10 = linkedHashTreeMap$NodeArray.length;
        int n11 = n10 * 2;
        LinkedHashTreeMap$Node[] linkedHashTreeMap$NodeArray2 = new LinkedHashTreeMap$Node[n11];
        LinkedHashTreeMap$AvlIterator linkedHashTreeMap$AvlIterator = new LinkedHashTreeMap$AvlIterator();
        LinkedHashTreeMap$AvlBuilder linkedHashTreeMap$AvlBuilder = new LinkedHashTreeMap$AvlBuilder();
        LinkedHashTreeMap$AvlBuilder linkedHashTreeMap$AvlBuilder2 = new LinkedHashTreeMap$AvlBuilder();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = linkedHashTreeMap$NodeArray[i10];
            if (linkedHashTreeMap$Node2 == null) continue;
            linkedHashTreeMap$AvlIterator.reset(linkedHashTreeMap$Node2);
            int n13 = 0;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = null;
            int n14 = 0;
            while ((linkedHashTreeMap$Node = linkedHashTreeMap$AvlIterator.next()) != null) {
                n12 = linkedHashTreeMap$Node.hash & n10;
                if (n12 == 0) {
                    ++n13;
                    continue;
                }
                ++n14;
            }
            linkedHashTreeMap$AvlBuilder.reset(n13);
            linkedHashTreeMap$AvlBuilder2.reset(n14);
            linkedHashTreeMap$AvlIterator.reset(linkedHashTreeMap$Node2);
            while ((linkedHashTreeMap$Node2 = linkedHashTreeMap$AvlIterator.next()) != null) {
                n12 = linkedHashTreeMap$Node2.hash & n10;
                if (n12 == 0) {
                    linkedHashTreeMap$AvlBuilder.add(linkedHashTreeMap$Node2);
                    continue;
                }
                linkedHashTreeMap$AvlBuilder2.add(linkedHashTreeMap$Node2);
            }
            linkedHashTreeMap$Node2 = null;
            if (n13 > 0) {
                linkedHashTreeMap$Node3 = linkedHashTreeMap$AvlBuilder.root();
            } else {
                n13 = 0;
                linkedHashTreeMap$Node3 = null;
            }
            linkedHashTreeMap$NodeArray2[i10] = linkedHashTreeMap$Node3;
            n13 = i10 + n10;
            if (n14 > 0) {
                linkedHashTreeMap$Node2 = linkedHashTreeMap$AvlBuilder2.root();
            }
            linkedHashTreeMap$NodeArray2[n13] = linkedHashTreeMap$Node2;
        }
        return linkedHashTreeMap$NodeArray2;
    }

    private boolean equal(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void rebalance(LinkedHashTreeMap$Node linkedHashTreeMap$Node, boolean bl2) {
        while (linkedHashTreeMap$Node != null) {
            int n10;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node2;
            int n11;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.left;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node4 = linkedHashTreeMap$Node.right;
            int n12 = 0;
            if (linkedHashTreeMap$Node3 != null) {
                n11 = linkedHashTreeMap$Node3.height;
            } else {
                n11 = 0;
                linkedHashTreeMap$Node2 = null;
            }
            int n13 = linkedHashTreeMap$Node4 != null ? linkedHashTreeMap$Node4.height : 0;
            int n14 = n11 - n13;
            int n15 = -2;
            if (n14 == n15) {
                linkedHashTreeMap$Node3 = linkedHashTreeMap$Node4.left;
                linkedHashTreeMap$Node2 = linkedHashTreeMap$Node4.right;
                if (linkedHashTreeMap$Node2 != null) {
                    n11 = linkedHashTreeMap$Node2.height;
                } else {
                    n11 = 0;
                    linkedHashTreeMap$Node2 = null;
                }
                if (linkedHashTreeMap$Node3 != null) {
                    n12 = linkedHashTreeMap$Node3.height;
                }
                if ((n12 -= n11) != (n10 = -1) && (n12 != 0 || bl2)) {
                    this.rotateRight(linkedHashTreeMap$Node4);
                    this.rotateLeft(linkedHashTreeMap$Node);
                } else {
                    this.rotateLeft(linkedHashTreeMap$Node);
                }
                if (bl2) {
                    break;
                }
            } else {
                int n16 = 2;
                n15 = 1;
                if (n14 == n16) {
                    linkedHashTreeMap$Node4 = linkedHashTreeMap$Node3.left;
                    linkedHashTreeMap$Node2 = linkedHashTreeMap$Node3.right;
                    if (linkedHashTreeMap$Node2 != null) {
                        n11 = linkedHashTreeMap$Node2.height;
                    } else {
                        n11 = 0;
                        linkedHashTreeMap$Node2 = null;
                    }
                    if (linkedHashTreeMap$Node4 != null) {
                        n12 = linkedHashTreeMap$Node4.height;
                    }
                    if ((n12 -= n11) != n15 && (n12 != 0 || bl2)) {
                        this.rotateLeft(linkedHashTreeMap$Node3);
                        this.rotateRight(linkedHashTreeMap$Node);
                    } else {
                        this.rotateRight(linkedHashTreeMap$Node);
                    }
                    if (bl2) {
                        break;
                    }
                } else if (n14 == 0) {
                    linkedHashTreeMap$Node.height = ++n11;
                    if (bl2) {
                        break;
                    }
                } else {
                    linkedHashTreeMap$Node.height = n10 = Math.max(n11, n13) + n15;
                    if (!bl2) break;
                }
            }
            linkedHashTreeMap$Node = linkedHashTreeMap$Node.parent;
        }
    }

    private void replaceInParent(LinkedHashTreeMap$Node linkedHashTreeMap$Node, LinkedHashTreeMap$Node linkedHashTreeMap$Node2) {
        LinkedHashTreeMap$Node[] linkedHashTreeMap$NodeArray = linkedHashTreeMap$Node.parent;
        int n10 = 0;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = null;
        linkedHashTreeMap$Node.parent = null;
        if (linkedHashTreeMap$Node2 != null) {
            linkedHashTreeMap$Node2.parent = linkedHashTreeMap$NodeArray;
        }
        if (linkedHashTreeMap$NodeArray != null) {
            linkedHashTreeMap$Node3 = linkedHashTreeMap$NodeArray.left;
            if (linkedHashTreeMap$Node3 == linkedHashTreeMap$Node) {
                linkedHashTreeMap$NodeArray.left = linkedHashTreeMap$Node2;
            } else {
                linkedHashTreeMap$NodeArray.right = linkedHashTreeMap$Node2;
            }
        } else {
            int n11 = linkedHashTreeMap$Node.hash;
            linkedHashTreeMap$NodeArray = this.table;
            n10 = linkedHashTreeMap$NodeArray.length + -1;
            linkedHashTreeMap$NodeArray[n11 &= n10] = linkedHashTreeMap$Node2;
        }
    }

    private void rotateLeft(LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        int n10;
        int n11;
        int n12;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.left;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.right;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node4 = linkedHashTreeMap$Node3.left;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node5 = linkedHashTreeMap$Node3.right;
        linkedHashTreeMap$Node.right = linkedHashTreeMap$Node4;
        if (linkedHashTreeMap$Node4 != null) {
            linkedHashTreeMap$Node4.parent = linkedHashTreeMap$Node;
        }
        this.replaceInParent(linkedHashTreeMap$Node, linkedHashTreeMap$Node3);
        linkedHashTreeMap$Node3.left = linkedHashTreeMap$Node;
        linkedHashTreeMap$Node.parent = linkedHashTreeMap$Node3;
        int n13 = 0;
        if (linkedHashTreeMap$Node2 != null) {
            n12 = linkedHashTreeMap$Node2.height;
        } else {
            n12 = 0;
            linkedHashTreeMap$Node2 = null;
        }
        if (linkedHashTreeMap$Node4 != null) {
            n11 = linkedHashTreeMap$Node4.height;
        } else {
            n11 = 0;
            linkedHashTreeMap$Node4 = null;
        }
        linkedHashTreeMap$Node.height = n12 = Math.max(n12, n11) + 1;
        if (linkedHashTreeMap$Node5 != null) {
            n13 = linkedHashTreeMap$Node5.height;
        }
        linkedHashTreeMap$Node3.height = n10 = Math.max(n12, n13) + 1;
    }

    private void rotateRight(LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        int n10;
        int n11;
        int n12;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.left;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node4 = linkedHashTreeMap$Node.right;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node5 = linkedHashTreeMap$Node3.left;
        linkedHashTreeMap$Node.left = linkedHashTreeMap$Node2 = linkedHashTreeMap$Node3.right;
        if (linkedHashTreeMap$Node2 != null) {
            linkedHashTreeMap$Node2.parent = linkedHashTreeMap$Node;
        }
        this.replaceInParent(linkedHashTreeMap$Node, linkedHashTreeMap$Node3);
        linkedHashTreeMap$Node3.right = linkedHashTreeMap$Node;
        linkedHashTreeMap$Node.parent = linkedHashTreeMap$Node3;
        int n13 = 0;
        if (linkedHashTreeMap$Node4 != null) {
            n12 = linkedHashTreeMap$Node4.height;
        } else {
            n12 = 0;
            linkedHashTreeMap$Node4 = null;
        }
        if (linkedHashTreeMap$Node2 != null) {
            n11 = linkedHashTreeMap$Node2.height;
        } else {
            n11 = 0;
            linkedHashTreeMap$Node2 = null;
        }
        linkedHashTreeMap$Node.height = n12 = Math.max(n12, n11) + 1;
        if (linkedHashTreeMap$Node5 != null) {
            n13 = linkedHashTreeMap$Node5.height;
        }
        linkedHashTreeMap$Node3.height = n10 = Math.max(n12, n13) + 1;
    }

    private static int secondaryHash(int n10) {
        int n11 = n10 >>> 20;
        int n12 = n10 >>> 12;
        n11 = (n10 ^= (n11 ^= n12)) >>> 7 ^ n10;
        return n10 >>> 4 ^ n11;
    }

    private Object writeReplace() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this);
        return linkedHashMap;
    }

    public void clear() {
        int n10;
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount = n10 = this.modCount + 1;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = this.header;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.next;
        while (linkedHashTreeMap$Node2 != linkedHashTreeMap$Node) {
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node2.next;
            linkedHashTreeMap$Node2.prev = null;
            linkedHashTreeMap$Node2.next = null;
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node3;
        }
        linkedHashTreeMap$Node.prev = linkedHashTreeMap$Node;
        linkedHashTreeMap$Node.next = linkedHashTreeMap$Node;
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.findByObject(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Set entrySet() {
        LinkedHashTreeMap$EntrySet linkedHashTreeMap$EntrySet = this.entrySet;
        if (linkedHashTreeMap$EntrySet == null) {
            this.entrySet = linkedHashTreeMap$EntrySet = new LinkedHashTreeMap$EntrySet(this);
        }
        return linkedHashTreeMap$EntrySet;
    }

    public LinkedHashTreeMap$Node find(Object object, boolean bl2) {
        int n10;
        Object object2;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node;
        int n11;
        Object object3;
        Object object4;
        Object object5 = this.comparator;
        LinkedHashTreeMap$Node[] linkedHashTreeMap$NodeArray = this.table;
        int n12 = LinkedHashTreeMap.secondaryHash(object.hashCode());
        int n13 = linkedHashTreeMap$NodeArray.length;
        int n14 = 1;
        Object object6 = linkedHashTreeMap$NodeArray[n13 = n13 - n14 & n12];
        if (object6 != null) {
            object4 = NATURAL_ORDER;
            if (object5 == object4) {
                object4 = object;
                object4 = (Comparable)object;
            } else {
                object4 = null;
            }
            while (true) {
                if (object4 != null) {
                    object3 = ((LinkedHashTreeMap$Node)object6).key;
                    n11 = object4.compareTo(object3);
                } else {
                    object3 = ((LinkedHashTreeMap$Node)object6).key;
                    n11 = object5.compare(object, object3);
                }
                if (n11 == 0) {
                    return object6;
                }
                linkedHashTreeMap$Node = n11 < 0 ? ((LinkedHashTreeMap$Node)object6).left : ((LinkedHashTreeMap$Node)object6).right;
                if (linkedHashTreeMap$Node != null) {
                    object6 = linkedHashTreeMap$Node;
                    continue;
                }
                break;
            }
        } else {
            n11 = 0;
            object3 = null;
        }
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = object6;
        if (!bl2) {
            return null;
        }
        object3 = this.header;
        if (object6 == null) {
            object2 = NATURAL_ORDER;
            if (object5 == object2 && !(bl2 = object instanceof Comparable)) {
                object5 = new StringBuilder();
                object = object.getClass().getName();
                ((StringBuilder)object5).append((String)object);
                ((StringBuilder)object5).append(" is not Comparable");
                object = ((StringBuilder)object5).toString();
                object2 = new ClassCastException((String)object);
                throw object2;
            }
            linkedHashTreeMap$Node = ((LinkedHashTreeMap$Node)object3).prev;
            object6 = object2;
            object4 = object;
            linkedHashTreeMap$NodeArray[n13] = object2 = new LinkedHashTreeMap$Node(linkedHashTreeMap$Node2, object, n12, (LinkedHashTreeMap$Node)object3, linkedHashTreeMap$Node);
        } else {
            linkedHashTreeMap$Node = ((LinkedHashTreeMap$Node)object3).prev;
            object6 = object2;
            object4 = object;
            object2 = new LinkedHashTreeMap$Node(linkedHashTreeMap$Node2, object, n12, (LinkedHashTreeMap$Node)object3, linkedHashTreeMap$Node);
            if (n11 < 0) {
                linkedHashTreeMap$Node2.left = object2;
            } else {
                linkedHashTreeMap$Node2.right = object2;
            }
            this.rebalance(linkedHashTreeMap$Node2, n14 != 0);
        }
        int n15 = this.size;
        this.size = n10 = n15 + 1;
        n10 = this.threshold;
        if (n15 > n10) {
            this.doubleCapacity();
        }
        this.modCount = n15 = this.modCount + n14;
        return object2;
    }

    public LinkedHashTreeMap$Node findByEntry(Map.Entry entry) {
        Object object;
        boolean bl2;
        Object object2 = entry.getKey();
        if ((object2 = this.findByObject(object2)) != null && (bl2 = this.equal(object = ((LinkedHashTreeMap$Node)object2).value, entry = entry.getValue()))) {
            bl2 = true;
        } else {
            bl2 = false;
            entry = null;
        }
        if (!bl2) {
            object2 = null;
        }
        return object2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public LinkedHashTreeMap$Node findByObject(Object object) {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = null;
        if (object == null) return linkedHashTreeMap$Node;
        try {
            return this.find(object, false);
        }
        catch (ClassCastException classCastException) {
            return linkedHashTreeMap$Node;
        }
    }

    public Object get(Object object) {
        object = (object = this.findByObject(object)) != null ? ((LinkedHashTreeMap$Node)object).value : null;
        return object;
    }

    public Set keySet() {
        LinkedHashTreeMap$KeySet linkedHashTreeMap$KeySet = this.keySet;
        if (linkedHashTreeMap$KeySet == null) {
            this.keySet = linkedHashTreeMap$KeySet = new LinkedHashTreeMap$KeySet(this);
        }
        return linkedHashTreeMap$KeySet;
    }

    public Object put(Object object, Object object2) {
        Objects.requireNonNull(object, "key == null");
        object = this.find(object, true);
        Object object3 = ((LinkedHashTreeMap$Node)object).value;
        ((LinkedHashTreeMap$Node)object).value = object2;
        return object3;
    }

    public Object remove(Object object) {
        object = (object = this.removeInternalByKey(object)) != null ? ((LinkedHashTreeMap$Node)object).value : null;
        return object;
    }

    public void removeInternal(LinkedHashTreeMap$Node linkedHashTreeMap$Node, boolean bl2) {
        int n10;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node3;
        int n11 = 0;
        if (bl2) {
            linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.prev;
            linkedHashTreeMap$Node3.next = linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.next;
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.next;
            linkedHashTreeMap$Node2.prev = linkedHashTreeMap$Node3;
            linkedHashTreeMap$Node.prev = null;
            linkedHashTreeMap$Node.next = null;
        }
        linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.left;
        linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.right;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node4 = linkedHashTreeMap$Node.parent;
        int n12 = 0;
        if (linkedHashTreeMap$Node3 != null && linkedHashTreeMap$Node2 != null) {
            int n13 = linkedHashTreeMap$Node3.height;
            int n14 = linkedHashTreeMap$Node2.height;
            linkedHashTreeMap$Node3 = n13 > n14 ? linkedHashTreeMap$Node3.last() : linkedHashTreeMap$Node2.first();
            this.removeInternal(linkedHashTreeMap$Node3, false);
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.left;
            if (linkedHashTreeMap$Node2 != null) {
                n13 = linkedHashTreeMap$Node2.height;
                linkedHashTreeMap$Node3.left = linkedHashTreeMap$Node2;
                linkedHashTreeMap$Node2.parent = linkedHashTreeMap$Node3;
                linkedHashTreeMap$Node.left = null;
            } else {
                n13 = 0;
                linkedHashTreeMap$Node4 = null;
            }
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.right;
            if (linkedHashTreeMap$Node2 != null) {
                n12 = linkedHashTreeMap$Node2.height;
                linkedHashTreeMap$Node3.right = linkedHashTreeMap$Node2;
                linkedHashTreeMap$Node2.parent = linkedHashTreeMap$Node3;
                linkedHashTreeMap$Node.right = null;
            }
            linkedHashTreeMap$Node3.height = n11 = Math.max(n13, n12) + 1;
            this.replaceInParent(linkedHashTreeMap$Node, linkedHashTreeMap$Node3);
            return;
        }
        if (linkedHashTreeMap$Node3 != null) {
            this.replaceInParent(linkedHashTreeMap$Node, linkedHashTreeMap$Node3);
            linkedHashTreeMap$Node.left = null;
        } else if (linkedHashTreeMap$Node2 != null) {
            this.replaceInParent(linkedHashTreeMap$Node, linkedHashTreeMap$Node2);
            linkedHashTreeMap$Node.right = null;
        } else {
            this.replaceInParent(linkedHashTreeMap$Node, null);
        }
        this.rebalance(linkedHashTreeMap$Node4, false);
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
    }

    public LinkedHashTreeMap$Node removeInternalByKey(Object object) {
        if ((object = this.findByObject(object)) != null) {
            boolean bl2 = true;
            this.removeInternal((LinkedHashTreeMap$Node)object, bl2);
        }
        return object;
    }

    public int size() {
        return this.size;
    }
}

