/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap$1;
import com.google.gson.internal.LinkedTreeMap$EntrySet;
import com.google.gson.internal.LinkedTreeMap$KeySet;
import com.google.gson.internal.LinkedTreeMap$Node;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class LinkedTreeMap
extends AbstractMap
implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER;
    public Comparator comparator;
    private LinkedTreeMap$EntrySet entrySet;
    public final LinkedTreeMap$Node header;
    private LinkedTreeMap$KeySet keySet;
    public int modCount;
    public LinkedTreeMap$Node root;
    public int size;

    static {
        LinkedTreeMap$1 linkedTreeMap$1 = new LinkedTreeMap$1();
        NATURAL_ORDER = linkedTreeMap$1;
    }

    public LinkedTreeMap() {
        Comparator comparator = NATURAL_ORDER;
        this(comparator);
    }

    public LinkedTreeMap(Comparator comparator) {
        LinkedTreeMap$Node linkedTreeMap$Node;
        this.size = 0;
        this.modCount = 0;
        this.header = linkedTreeMap$Node = new LinkedTreeMap$Node();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        this.comparator = comparator;
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

    private void rebalance(LinkedTreeMap$Node linkedTreeMap$Node, boolean bl2) {
        while (linkedTreeMap$Node != null) {
            int n10;
            LinkedTreeMap$Node linkedTreeMap$Node2;
            int n11;
            LinkedTreeMap$Node linkedTreeMap$Node3 = linkedTreeMap$Node.left;
            LinkedTreeMap$Node linkedTreeMap$Node4 = linkedTreeMap$Node.right;
            int n12 = 0;
            if (linkedTreeMap$Node3 != null) {
                n11 = linkedTreeMap$Node3.height;
            } else {
                n11 = 0;
                linkedTreeMap$Node2 = null;
            }
            int n13 = linkedTreeMap$Node4 != null ? linkedTreeMap$Node4.height : 0;
            int n14 = n11 - n13;
            int n15 = -2;
            if (n14 == n15) {
                linkedTreeMap$Node3 = linkedTreeMap$Node4.left;
                linkedTreeMap$Node2 = linkedTreeMap$Node4.right;
                if (linkedTreeMap$Node2 != null) {
                    n11 = linkedTreeMap$Node2.height;
                } else {
                    n11 = 0;
                    linkedTreeMap$Node2 = null;
                }
                if (linkedTreeMap$Node3 != null) {
                    n12 = linkedTreeMap$Node3.height;
                }
                if ((n12 -= n11) != (n10 = -1) && (n12 != 0 || bl2)) {
                    this.rotateRight(linkedTreeMap$Node4);
                    this.rotateLeft(linkedTreeMap$Node);
                } else {
                    this.rotateLeft(linkedTreeMap$Node);
                }
                if (bl2) {
                    break;
                }
            } else {
                int n16 = 2;
                n15 = 1;
                if (n14 == n16) {
                    linkedTreeMap$Node4 = linkedTreeMap$Node3.left;
                    linkedTreeMap$Node2 = linkedTreeMap$Node3.right;
                    if (linkedTreeMap$Node2 != null) {
                        n11 = linkedTreeMap$Node2.height;
                    } else {
                        n11 = 0;
                        linkedTreeMap$Node2 = null;
                    }
                    if (linkedTreeMap$Node4 != null) {
                        n12 = linkedTreeMap$Node4.height;
                    }
                    if ((n12 -= n11) != n15 && (n12 != 0 || bl2)) {
                        this.rotateLeft(linkedTreeMap$Node3);
                        this.rotateRight(linkedTreeMap$Node);
                    } else {
                        this.rotateRight(linkedTreeMap$Node);
                    }
                    if (bl2) {
                        break;
                    }
                } else if (n14 == 0) {
                    linkedTreeMap$Node.height = ++n11;
                    if (bl2) {
                        break;
                    }
                } else {
                    linkedTreeMap$Node.height = n10 = Math.max(n11, n13) + n15;
                    if (!bl2) break;
                }
            }
            linkedTreeMap$Node = linkedTreeMap$Node.parent;
        }
    }

    private void replaceInParent(LinkedTreeMap$Node linkedTreeMap$Node, LinkedTreeMap$Node linkedTreeMap$Node2) {
        LinkedTreeMap$Node linkedTreeMap$Node3 = linkedTreeMap$Node.parent;
        LinkedTreeMap$Node linkedTreeMap$Node4 = null;
        linkedTreeMap$Node.parent = null;
        if (linkedTreeMap$Node2 != null) {
            linkedTreeMap$Node2.parent = linkedTreeMap$Node3;
        }
        if (linkedTreeMap$Node3 != null) {
            linkedTreeMap$Node4 = linkedTreeMap$Node3.left;
            if (linkedTreeMap$Node4 == linkedTreeMap$Node) {
                linkedTreeMap$Node3.left = linkedTreeMap$Node2;
            } else {
                linkedTreeMap$Node3.right = linkedTreeMap$Node2;
            }
        } else {
            this.root = linkedTreeMap$Node2;
        }
    }

    private void rotateLeft(LinkedTreeMap$Node linkedTreeMap$Node) {
        int n10;
        int n11;
        int n12;
        LinkedTreeMap$Node linkedTreeMap$Node2 = linkedTreeMap$Node.left;
        LinkedTreeMap$Node linkedTreeMap$Node3 = linkedTreeMap$Node.right;
        LinkedTreeMap$Node linkedTreeMap$Node4 = linkedTreeMap$Node3.left;
        LinkedTreeMap$Node linkedTreeMap$Node5 = linkedTreeMap$Node3.right;
        linkedTreeMap$Node.right = linkedTreeMap$Node4;
        if (linkedTreeMap$Node4 != null) {
            linkedTreeMap$Node4.parent = linkedTreeMap$Node;
        }
        this.replaceInParent(linkedTreeMap$Node, linkedTreeMap$Node3);
        linkedTreeMap$Node3.left = linkedTreeMap$Node;
        linkedTreeMap$Node.parent = linkedTreeMap$Node3;
        int n13 = 0;
        if (linkedTreeMap$Node2 != null) {
            n12 = linkedTreeMap$Node2.height;
        } else {
            n12 = 0;
            linkedTreeMap$Node2 = null;
        }
        if (linkedTreeMap$Node4 != null) {
            n11 = linkedTreeMap$Node4.height;
        } else {
            n11 = 0;
            linkedTreeMap$Node4 = null;
        }
        linkedTreeMap$Node.height = n12 = Math.max(n12, n11) + 1;
        if (linkedTreeMap$Node5 != null) {
            n13 = linkedTreeMap$Node5.height;
        }
        linkedTreeMap$Node3.height = n10 = Math.max(n12, n13) + 1;
    }

    private void rotateRight(LinkedTreeMap$Node linkedTreeMap$Node) {
        int n10;
        int n11;
        int n12;
        LinkedTreeMap$Node linkedTreeMap$Node2;
        LinkedTreeMap$Node linkedTreeMap$Node3 = linkedTreeMap$Node.left;
        LinkedTreeMap$Node linkedTreeMap$Node4 = linkedTreeMap$Node.right;
        LinkedTreeMap$Node linkedTreeMap$Node5 = linkedTreeMap$Node3.left;
        linkedTreeMap$Node.left = linkedTreeMap$Node2 = linkedTreeMap$Node3.right;
        if (linkedTreeMap$Node2 != null) {
            linkedTreeMap$Node2.parent = linkedTreeMap$Node;
        }
        this.replaceInParent(linkedTreeMap$Node, linkedTreeMap$Node3);
        linkedTreeMap$Node3.right = linkedTreeMap$Node;
        linkedTreeMap$Node.parent = linkedTreeMap$Node3;
        int n13 = 0;
        if (linkedTreeMap$Node4 != null) {
            n12 = linkedTreeMap$Node4.height;
        } else {
            n12 = 0;
            linkedTreeMap$Node4 = null;
        }
        if (linkedTreeMap$Node2 != null) {
            n11 = linkedTreeMap$Node2.height;
        } else {
            n11 = 0;
            linkedTreeMap$Node2 = null;
        }
        linkedTreeMap$Node.height = n12 = Math.max(n12, n11) + 1;
        if (linkedTreeMap$Node5 != null) {
            n13 = linkedTreeMap$Node5.height;
        }
        linkedTreeMap$Node3.height = n10 = Math.max(n12, n13) + 1;
    }

    private Object writeReplace() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this);
        return linkedHashMap;
    }

    public void clear() {
        LinkedTreeMap$Node linkedTreeMap$Node;
        int n10;
        this.root = null;
        this.size = 0;
        this.modCount = n10 = this.modCount + 1;
        linkedTreeMap$Node.prev = linkedTreeMap$Node = this.header;
        linkedTreeMap$Node.next = linkedTreeMap$Node;
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
        LinkedTreeMap$EntrySet linkedTreeMap$EntrySet = this.entrySet;
        if (linkedTreeMap$EntrySet == null) {
            this.entrySet = linkedTreeMap$EntrySet = new LinkedTreeMap$EntrySet(this);
        }
        return linkedTreeMap$EntrySet;
    }

    public LinkedTreeMap$Node find(Object object, boolean bl2) {
        int n10;
        int n11;
        Object object2;
        Object object3 = this.comparator;
        LinkedTreeMap$Node linkedTreeMap$Node = this.root;
        int n12 = 0;
        if (linkedTreeMap$Node != null) {
            object2 = NATURAL_ORDER;
            if (object3 == object2) {
                object2 = object;
                object2 = (Comparable)object;
            } else {
                object2 = null;
            }
            while (true) {
                Object object4;
                if (object2 != null) {
                    object4 = linkedTreeMap$Node.key;
                    n11 = object2.compareTo(object4);
                } else {
                    object4 = linkedTreeMap$Node.key;
                    n11 = object3.compare(object, object4);
                }
                if (n11 == 0) {
                    return linkedTreeMap$Node;
                }
                LinkedTreeMap$Node linkedTreeMap$Node2 = n11 < 0 ? linkedTreeMap$Node.left : linkedTreeMap$Node.right;
                if (linkedTreeMap$Node2 != null) {
                    linkedTreeMap$Node = linkedTreeMap$Node2;
                    continue;
                }
                break;
            }
        } else {
            n11 = 0;
            Object var7_8 = null;
        }
        if (!bl2) {
            return null;
        }
        Object object5 = this.header;
        n12 = 1;
        if (linkedTreeMap$Node == null) {
            boolean bl3;
            object2 = NATURAL_ORDER;
            if (object3 == object2 && !(bl3 = object instanceof Comparable)) {
                object3 = new StringBuilder();
                object = object.getClass().getName();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(" is not Comparable");
                object = ((StringBuilder)object3).toString();
                object5 = new ClassCastException((String)object);
                throw object5;
            }
            object2 = ((LinkedTreeMap$Node)object5).prev;
            this.root = object3 = new LinkedTreeMap$Node(linkedTreeMap$Node, object, (LinkedTreeMap$Node)object5, (LinkedTreeMap$Node)object2);
        } else {
            object2 = ((LinkedTreeMap$Node)object5).prev;
            object3 = new LinkedTreeMap$Node(linkedTreeMap$Node, object, (LinkedTreeMap$Node)object5, (LinkedTreeMap$Node)object2);
            if (n11 < 0) {
                linkedTreeMap$Node.left = object3;
            } else {
                linkedTreeMap$Node.right = object3;
            }
            this.rebalance(linkedTreeMap$Node, n12 != 0);
        }
        this.size = n10 = this.size + n12;
        this.modCount = n10 = this.modCount + n12;
        return object3;
    }

    public LinkedTreeMap$Node findByEntry(Map.Entry entry) {
        Object object;
        boolean bl2;
        Object object2 = entry.getKey();
        if ((object2 = this.findByObject(object2)) != null && (bl2 = this.equal(object = ((LinkedTreeMap$Node)object2).value, entry = entry.getValue()))) {
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
    public LinkedTreeMap$Node findByObject(Object object) {
        LinkedTreeMap$Node linkedTreeMap$Node = null;
        if (object == null) return linkedTreeMap$Node;
        try {
            return this.find(object, false);
        }
        catch (ClassCastException classCastException) {
            return linkedTreeMap$Node;
        }
    }

    public Object get(Object object) {
        object = (object = this.findByObject(object)) != null ? ((LinkedTreeMap$Node)object).value : null;
        return object;
    }

    public Set keySet() {
        LinkedTreeMap$KeySet linkedTreeMap$KeySet = this.keySet;
        if (linkedTreeMap$KeySet == null) {
            this.keySet = linkedTreeMap$KeySet = new LinkedTreeMap$KeySet(this);
        }
        return linkedTreeMap$KeySet;
    }

    public Object put(Object object, Object object2) {
        Objects.requireNonNull(object, "key == null");
        object = this.find(object, true);
        Object object3 = ((LinkedTreeMap$Node)object).value;
        ((LinkedTreeMap$Node)object).value = object2;
        return object3;
    }

    public Object remove(Object object) {
        object = (object = this.removeInternalByKey(object)) != null ? ((LinkedTreeMap$Node)object).value : null;
        return object;
    }

    public void removeInternal(LinkedTreeMap$Node linkedTreeMap$Node, boolean bl2) {
        int n10;
        LinkedTreeMap$Node linkedTreeMap$Node2;
        LinkedTreeMap$Node linkedTreeMap$Node3;
        if (bl2) {
            linkedTreeMap$Node3 = linkedTreeMap$Node.prev;
            linkedTreeMap$Node3.next = linkedTreeMap$Node2 = linkedTreeMap$Node.next;
            linkedTreeMap$Node2 = linkedTreeMap$Node.next;
            linkedTreeMap$Node2.prev = linkedTreeMap$Node3;
        }
        linkedTreeMap$Node3 = linkedTreeMap$Node.left;
        linkedTreeMap$Node2 = linkedTreeMap$Node.right;
        LinkedTreeMap$Node linkedTreeMap$Node4 = linkedTreeMap$Node.parent;
        int n11 = 0;
        if (linkedTreeMap$Node3 != null && linkedTreeMap$Node2 != null) {
            int n12;
            int n13 = linkedTreeMap$Node3.height;
            int n14 = linkedTreeMap$Node2.height;
            linkedTreeMap$Node3 = n13 > n14 ? linkedTreeMap$Node3.last() : linkedTreeMap$Node2.first();
            this.removeInternal(linkedTreeMap$Node3, false);
            linkedTreeMap$Node2 = linkedTreeMap$Node.left;
            if (linkedTreeMap$Node2 != null) {
                n13 = linkedTreeMap$Node2.height;
                linkedTreeMap$Node3.left = linkedTreeMap$Node2;
                linkedTreeMap$Node2.parent = linkedTreeMap$Node3;
                linkedTreeMap$Node.left = null;
            } else {
                n13 = 0;
                linkedTreeMap$Node4 = null;
            }
            linkedTreeMap$Node2 = linkedTreeMap$Node.right;
            if (linkedTreeMap$Node2 != null) {
                n11 = linkedTreeMap$Node2.height;
                linkedTreeMap$Node3.right = linkedTreeMap$Node2;
                linkedTreeMap$Node2.parent = linkedTreeMap$Node3;
                linkedTreeMap$Node.right = null;
            }
            linkedTreeMap$Node3.height = n12 = Math.max(n13, n11) + 1;
            this.replaceInParent(linkedTreeMap$Node, linkedTreeMap$Node3);
            return;
        }
        if (linkedTreeMap$Node3 != null) {
            this.replaceInParent(linkedTreeMap$Node, linkedTreeMap$Node3);
            linkedTreeMap$Node.left = null;
        } else if (linkedTreeMap$Node2 != null) {
            this.replaceInParent(linkedTreeMap$Node, linkedTreeMap$Node2);
            linkedTreeMap$Node.right = null;
        } else {
            this.replaceInParent(linkedTreeMap$Node, null);
        }
        this.rebalance(linkedTreeMap$Node4, false);
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
    }

    public LinkedTreeMap$Node removeInternalByKey(Object object) {
        if ((object = this.findByObject(object)) != null) {
            boolean bl2 = true;
            this.removeInternal((LinkedTreeMap$Node)object, bl2);
        }
        return object;
    }

    public int size() {
        return this.size;
    }
}

