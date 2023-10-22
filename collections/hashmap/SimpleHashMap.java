package collections.hashmap;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class SimpleHashMap<K, V> {
    private static final int defaultInitialCapacity = 16;
    private static final int maximumCapacity = 1 << 30;
    private static final float defaultLoadFactor = 0.75f;
    private static final int treeifyFactor = 8;
    private static final int untreeifyFactor = 6;
    private static final int minTreeifyCapacity = 64;
    private Node<K, V>[] map;
    private int size;
    private int resizeFactor;
    private final float loadFactor;

    public SimpleHashMap() {
        this.loadFactor = defaultLoadFactor;
    }

    public SimpleHashMap(int initialCapacity) {
        this(initialCapacity, defaultLoadFactor);
    }

    public SimpleHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > maximumCapacity) {
            initialCapacity = maximumCapacity;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.resizeFactor = mapSizeFor(initialCapacity);
    }

    public void put(K key, V value) {
        putVal(hash(key), key, value);
    }

    public V get(Object key) {
        Node<K, V> target;
        return (target = getNode(key)) == null ? null : target.value;
    }

    public void remove(Object key) {
        removeNode(hash(key), key, null, false);
    }

    public void remove(Object key, Object value) {
        removeNode(hash(key), key, value, true);
    }

    public void replace(K key, V oldValue, V newValue) {
        Node<K, V> target;
        V value;
        if ((target = getNode(key)) != null && ((value = target.value) == oldValue || (value != null && value.equals(oldValue)))) {
            target.value = newValue;
        }
    }

    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void putVal(int hash, K key, V value) {
        Node<K, V>[] currentMap;
        Node<K, V> putNode;
        int bucketLength, index;
        if ((currentMap = map) == null || (bucketLength = currentMap.length) == 0) {
            bucketLength = (currentMap = resize()).length;
        }
        if ((putNode = currentMap[index = (bucketLength - 1) & hash]) == null) {
            currentMap[index] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> nextNode;
            K currentKey;
            if (putNode.hash == hash && ((currentKey = putNode.key) == key || (key != null && key.equals(currentKey)))) {
                for (int binCount = 0; ; ++binCount) {
                    if ((nextNode = putNode.next) == null) {
                        putNode.next = new Node<>(hash, key, value, null);
                        if (binCount >= treeifyFactor - 1) {
                            treeifyBin(currentMap, hash);
                        }
                        break;
                    }
                    if (nextNode.hash == hash && ((currentKey = nextNode.key) == key || (key != null && key.equals(currentKey)))) {
                        break;
                    }
                    putNode = nextNode;
                }
            }
        }
        if (++size > resizeFactor) {
            resize();
        }
    }

    private Node<K, V>[] resize() {
        Node<K, V>[] currentMap = map;
        int oldCap = (currentMap == null) ? 0 : currentMap.length;
        int oldThr = resizeFactor;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= maximumCapacity) {
                resizeFactor = Integer.MAX_VALUE;
                return currentMap;
            } else if ((newCap = oldCap << 1) < maximumCapacity && oldCap >= defaultInitialCapacity) {
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            newCap = oldThr;
        } else {
            newCap = defaultInitialCapacity;
            newThr = (int)(defaultLoadFactor * defaultInitialCapacity);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < maximumCapacity && ft < (float) maximumCapacity ? (int)ft : Integer.MAX_VALUE);
        }
        resizeFactor = newThr;
        @SuppressWarnings("unchecked")
        Node<K, V>[] newMap = (Node<K, V>[])new Node[newCap];
        map = newMap;
        if (currentMap != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                if ((e = currentMap[j]) != null) {
                    currentMap[j] = null;
                    if (e.next == null) {
                        newMap[e.hash & (newCap - 1)] = e;
                    } else if (e instanceof TreeNode) {
                        ((TreeNode<K, V>) e).split(this, newMap, j, oldCap);
                    } else {
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            } else {
                                if (hiTail == null) {
                                    hiHead = e;
                                } else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newMap[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newMap[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newMap;
    }

    private Node<K, V> getNode(Object key) {
        Node<K, V>[] currentMap;
        Node<K, V> firstNode, target;
        int mapLength, hash;
        K targetKey;
        if ((currentMap = map) != null && (mapLength = currentMap.length) > 0 && (firstNode = currentMap[(mapLength - 1) & (hash = hash(key))]) != null) {
            if (firstNode.hash == hash && ((targetKey = firstNode.key) == key || (key != null && key.equals(targetKey)))) {
                return firstNode;
            }
            if ((target = firstNode.next) != null) {
                if (firstNode instanceof TreeNode) {
                    return ((TreeNode<K, V>) firstNode).getTreeNode(hash, key);
                } do {
                    if (target.hash == hash && ((targetKey = target.key) == key || (key != null && key.equals(targetKey)))) {
                        return target;
                    }
                } while ((target = target.next) != null);
            }
        }
        return null;
    }

    private void removeNode(int hash, Object key, Object value, boolean matchValue) {
        Node<K, V>[] currentMap;
        Node<K, V> firstNode;
        int mapLength, index;
        if ((currentMap = map) != null && (mapLength = currentMap.length) > 0 && (firstNode = currentMap[index = (mapLength - 1) & hash]) != null) {
            Node<K, V> target = null, nextNode;
            K k;
            V v;
            if (firstNode.hash == hash && ((k = firstNode.key) == key || (key != null && key.equals(k)))) {
                target = firstNode;
            } else if ((nextNode = firstNode.next) != null) {
                if (firstNode instanceof TreeNode) {
                    target = ((TreeNode<K, V>) firstNode).getTreeNode(hash, key);
                } else {
                    do {
                        if (nextNode.hash == hash && ((k = nextNode.key) == key || (key != null && key.equals(k)))) {
                            target = nextNode;
                            break;
                        }
                        firstNode = nextNode;
                    } while ((nextNode = nextNode.next) != null);
                }
            }
            if (target != null && (!matchValue || (v = target.value) == value || (value != null && value.equals(v)))) {
                if (target instanceof TreeNode) {
                    ((TreeNode<K, V>) target).removeTreeNode(this, currentMap, true);
                } else if (target == firstNode) {
                    currentMap[index] = target.next;
                } else {
                    firstNode.next = target.next;
                }
                --size;
            }
        }
    }

    private void treeifyBin(Node<K, V>[] currentMap, int hash) {
        int mapLength, index;
        Node<K, V> e;
        if (currentMap == null || (mapLength = currentMap.length) < minTreeifyCapacity) {
            resize();
        } else if ((e = currentMap[index = (mapLength - 1) & hash]) != null) {
            TreeNode<K, V> hd = null, tl = null;
            do {
                TreeNode<K, V> p = replacementTreeNode(e, null);
                if (tl == null) {
                    hd = p;
                } else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((currentMap[index] = hd) != null) {
                hd.treeify(currentMap);
            }
        }
    }

    private static int hash(Object key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
    }

    private Node<K, V> replacementNode(Node<K, V> p, Node<K, V> next) {
        return new Node<>(p.hash, p.key, p.value, next);
    }

    private static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c; Type[] ts, as; ParameterizedType p;
            if ((c = x.getClass()) == String.class) {
                return c;
            }
            if ((ts = c.getGenericInterfaces()) != null) {
                for (Type t : ts) {
                    if ((t instanceof ParameterizedType) && ((p = (ParameterizedType) t).getRawType() == Comparable.class) && (as = p.getActualTypeArguments()) != null && as.length == 1 && as[0] == c) {
                        return c;
                    }
                }
            }
        }
        return null;
    }

    private static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue(){
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            return o instanceof Map.Entry<?, ?> e && Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
        }
    }

    private static int compareComparables(Class<?> kc, Object k, Object x) {
        //noinspection rawtypes,unchecked
        return (x == null || x.getClass() != kc ? 0 : ((Comparable)k).compareTo(x));
    }

    private static int mapSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= maximumCapacity) ? maximumCapacity : n + 1;
    }

    private TreeNode<K, V> replacementTreeNode(Node<K, V> p, Node<K, V> next) {
        return new TreeNode<>(p.hash, p.key, p.value, next);
    }

    private static final class TreeNode<K, V> extends Node<K, V> {
        private TreeNode<K, V> parent;
        private TreeNode<K, V> left;
        private TreeNode<K, V> right;
        private TreeNode<K, V> prev;
        private boolean red;

        private TreeNode(int hash, K key, V val, Node<K, V> next) {
            super(hash, key, val, next);
        }

        private TreeNode<K, V> root() {
            for (TreeNode<K, V> r = this, p;;) {
                if ((p = r.parent) == null) {
                    return r;
                }
                r = p;
            }
        }

        private static <K, V> void moveRootToFront(Node<K, V>[] tab, TreeNode<K, V> root) {
            int n;
            if (root != null && tab != null && (n = tab.length) > 0) {
                int index = (n - 1) & root.hash;
                TreeNode<K, V> first = (TreeNode<K, V>)tab[index];
                if (root != first) {
                    Node<K, V> rn;
                    tab[index] = root;
                    TreeNode<K, V> rp = root.prev;
                    if ((rn = root.next) != null) {
                        ((TreeNode<K, V>) rn).prev = rp;
                    }
                    if (rp != null) {
                        rp.next = rn;
                    }
                    if (first != null) {
                        first.prev = root;
                    }
                    root.next = first;
                    root.prev = null;
                }
                assert checkInvariants(root);
            }
        }

        private TreeNode<K, V> find(int h, Object k, Class<?> kc) {
            TreeNode<K, V> p = this;
            do {
                int ph, dir; K pk;
                TreeNode<K, V> pl = p.left, pr = p.right, q;
                if ((ph = p.hash) > h) {
                    p = pl;
                } else if (ph < h) {
                    p = pr;
                } else if ((pk = p.key) == k || (k != null && k.equals(pk))) {
                    return p;
                } else if (pl == null) {
                    p = pr;
                } else if (pr == null) {
                    p = pl;
                } else if ((kc != null || (kc = comparableClassFor(k)) != null) && (dir = compareComparables(kc, k, pk)) != 0) {
                    p = (dir < 0) ? pl : pr;
                } else if ((q = pr.find(h, k, kc)) != null) {
                    return q;
                } else {
                    p = pl;
                }
            } while (p != null);
            return null;
        }

        private TreeNode<K, V> getTreeNode(int h, Object k) {
            return ((parent != null) ? root() : this).find(h, k, null);
        }

        private static int tieBreakOrder(Object a, Object b) {
            int d;
            if (a == null || b == null || (d = a.getClass().getName().compareTo(b.getClass().getName())) == 0) {
                d = (System.identityHashCode(a) <= System.identityHashCode(b) ? -1 : 1);
            }
            return d;
        }

        private void treeify(Node<K, V>[] tab) {
            TreeNode<K, V> root = null;
            for (TreeNode<K, V> x = this, next; x != null; x = next) {
                next = (TreeNode<K, V>)x.next;
                x.left = x.right = null;
                if (root == null) {
                    x.parent = null;
                    x.red = false;
                    root = x;
                } else {
                    K k = x.key;
                    int h = x.hash;
                    Class<?> kc = null;
                    for (TreeNode<K, V> p = root;;) {
                        int dir, ph;
                        K pk = p.key;
                        if ((ph = p.hash) > h) {
                            dir = -1;
                        } else if (ph < h) {
                            dir = 1;
                        } else if ((kc == null && (kc = comparableClassFor(k)) == null) || (dir = compareComparables(kc, k, pk)) == 0) {
                            dir = tieBreakOrder(k, pk);
                        }

                        TreeNode<K, V> xp = p;
                        if ((p = (dir <= 0) ? p.left : p.right) == null) {
                            x.parent = xp;
                            if (dir <= 0) {
                                xp.left = x;
                            } else {
                                xp.right = x;
                            }
                            root = balanceInsertion(root, x);
                            break;
                        }
                    }
                }
            }
            moveRootToFront(tab, root);
        }

        private Node<K, V> untreeify(SimpleHashMap<K, V> map) {
            Node<K, V> hd = null, tl = null;
            for (Node<K, V> q = this; q != null; q = q.next) {
                Node<K, V> p = map.replacementNode(q, null);
                if (tl == null) {
                    hd = p;
                } else {
                    tl.next = p;
                }
                tl = p;
            }
            return hd;
        }

        private void removeTreeNode(SimpleHashMap<K, V> map, Node<K, V>[] tab, boolean movable) {
            int n;
            if (tab == null || (n = tab.length) == 0) {
                return;
            }
            int index = (n - 1) & hash;
            TreeNode<K, V> first = (TreeNode<K, V>)tab[index], root = first, rl;
            TreeNode<K, V> succ = (TreeNode<K, V>)next, pred = prev;
            if (pred == null) {
                tab[index] = first = succ;
            } else {
                pred.next = succ;
            }
            if (succ != null) {
                succ.prev = pred;
            }
            if (first == null) {
                return;
            }
            if (root.parent != null) {
                root = root.root();
            }
            if (root == null || (movable && (root.right == null || (rl = root.left) == null || rl.left == null))) {
                tab[index] = first.untreeify(map);
                return;
            }
            TreeNode<K, V> p = this, pl = left, pr = right, replacement;
            if (pl != null && pr != null) {
                TreeNode<K, V> s = pr, sl;
                while ((sl = s.left) != null) {
                    s = sl;
                }
                boolean c = s.red; s.red = p.red; p.red = c;
                TreeNode<K, V> sr = s.right;
                TreeNode<K, V> pp = p.parent;
                if (s == pr) {
                    p.parent = s;
                    s.right = p;
                } else {
                    TreeNode<K, V> sp = s.parent;
                    if ((p.parent = sp) != null) {
                        if (s == sp.left) {
                            sp.left = p;
                        } else {
                            sp.right = p;
                        }
                    }
                    if ((s.right = pr) != null) {
                        pr.parent = s;
                    }
                }
                p.left = null;
                if ((p.right = sr) != null) {
                    sr.parent = p;
                }
                if ((s.left = pl) != null) {
                    pl.parent = s;
                }
                if ((s.parent = pp) == null) {
                    root = s;
                } else if (p == pp.left) {
                    pp.left = s;
                } else {
                    pp.right = s;
                }
                if (sr != null) {
                    replacement = sr;
                } else {
                    replacement = p;
                }
            } else if (pl != null) {
                replacement = pl;
            } else if (pr != null) {
                replacement = pr;
            } else {
                replacement = p;
            }
            if (replacement != p) {
                TreeNode<K, V> pp = replacement.parent = p.parent;
                if (pp == null) {
                    (root = replacement).red = false;
                } else if (p == pp.left) {
                    pp.left = replacement;
                } else {
                    pp.right = replacement;
                }
                p.left = p.right = p.parent = null;
            }

            TreeNode<K, V> r = p.red ? root : balanceDeletion(root, replacement);

            if (replacement == p) {
                TreeNode<K, V> pp = p.parent;
                p.parent = null;
                if (pp != null) {
                    if (p == pp.left) {
                        pp.left = null;
                    } else if (p == pp.right) {
                        pp.right = null;
                    }
                }
            }
            if (movable) {
                moveRootToFront(tab, r);
            }
        }

        private void split(SimpleHashMap<K, V> map, Node<K, V>[] tab, int index, int bit) {
            TreeNode<K, V> b = this;
            TreeNode<K, V> loHead = null, loTail = null;
            TreeNode<K, V> hiHead = null, hiTail = null;
            int lc = 0, hc = 0;
            for (TreeNode<K, V> e = b, next; e != null; e = next) {
                next = (TreeNode<K, V>)e.next;
                e.next = null;
                if ((e.hash & bit) == 0) {
                    if ((e.prev = loTail) == null) {
                        loHead = e;
                    } else {
                        loTail.next = e;
                    }
                    loTail = e;
                    ++lc;
                } else {
                    if ((e.prev = hiTail) == null) {
                        hiHead = e;
                    } else {
                        hiTail.next = e;
                    }
                    hiTail = e;
                    ++hc;
                }
            }

            if (loHead != null) {
                if (lc <= untreeifyFactor) {
                    tab[index] = loHead.untreeify(map);
                } else {
                    tab[index] = loHead;
                    if (hiHead != null) {
                        loHead.treeify(tab);
                    }
                }
            }
            if (hiHead != null) {
                if (hc <= untreeifyFactor) {
                    tab[index + bit] = hiHead.untreeify(map);
                } else {
                    tab[index + bit] = hiHead;
                    if (loHead != null) {
                        hiHead.treeify(tab);
                    }
                }
            }
        }

        private static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> root, TreeNode<K, V> p) {
            TreeNode<K, V> r, pp, rl;
            if (p != null && (r = p.right) != null) {
                if ((rl = p.right = r.left) != null) {
                    rl.parent = p;
                }
                if ((pp = r.parent = p.parent) == null) {
                    (root = r).red = false;
                } else if (pp.left == p) {
                    pp.left = r;
                } else {
                    pp.right = r;
                }
                r.left = p;
                p.parent = r;
            }
            return root;
        }

        private static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> root, TreeNode<K, V> p) {
            TreeNode<K, V> l, pp, lr;
            if (p != null && (l = p.left) != null) {
                if ((lr = p.left = l.right) != null) {
                    lr.parent = p;
                }
                if ((pp = l.parent = p.parent) == null) {
                    (root = l).red = false;
                } else if (pp.right == p) {
                    pp.right = l;
                } else {
                    pp.left = l;
                }
                l.right = p;
                p.parent = l;
            }
            return root;
        }

        private static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> root, TreeNode<K, V> x) {
            x.red = true;
            for (TreeNode<K, V> xp, xpp, xppl, xppr;;) {
                if ((xp = x.parent) == null) {
                    x.red = false;
                    return x;
                } else if (!xp.red || (xpp = xp.parent) == null) {
                    return root;
                }
                if (xp == (xppl = xpp.left)) {
                    if ((xppr = xpp.right) != null && xppr.red) {
                        xppr.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    } else {
                        if (x == xp.right) {
                            root = rotateLeft(root, x = xp);
                            xpp = (xp = x.parent) == null ? null : xp.parent;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = rotateRight(root, xpp);
                            }
                        }
                    }
                } else {
                    if (xppl != null && xppl.red) {
                        xppl.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    } else {
                        if (x == xp.left) {
                            root = rotateRight(root, x = xp);
                            xpp = (xp = x.parent) == null ? null : xp.parent;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = rotateLeft(root, xpp);
                            }
                        }
                    }
                }
            }
        }

        private static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> root, TreeNode<K, V> x) {
            for (TreeNode<K, V> xp, xpl, xpr;;) {
                if (x == null || x == root) {
                    return root;
                } else if ((xp = x.parent) == null) {
                    x.red = false;
                    return x;
                } else if (x.red) {
                    x.red = false;
                    return root;
                } else if ((xpl = xp.left) == x) {
                    if ((xpr = xp.right) != null && xpr.red) {
                        xpr.red = false;
                        xp.red = true;
                        root = rotateLeft(root, xp);
                        xpr = (xp = x.parent) == null ? null : xp.right;
                    }
                    if (xpr == null) {
                        x = xp;
                    } else {
                        TreeNode<K, V> sl = xpr.left, sr = xpr.right;
                        if ((sr == null || !sr.red) && (sl == null || !sl.red)) {
                            xpr.red = true;
                            x = xp;
                        } else {
                            if (sr == null || !sr.red) {
                                if (sl != null) {
                                    sl.red = false;
                                }
                                xpr.red = true;
                                root = rotateRight(root, xpr);
                                xpr = (xp = x.parent) == null ? null : xp.right;
                            }
                            if (xpr != null) {
                                xpr.red = (xp == null) ? false : xp.red;
                                if ((sr = xpr.right) != null) {
                                    sr.red = false;
                                }
                            }
                            if (xp != null) {
                                xp.red = false;
                                root = rotateLeft(root, xp);
                            }
                            x = root;
                        }
                    }
                } else {
                    if (xpl != null && xpl.red) {
                        xpl.red = false;
                        xp.red = true;
                        root = rotateRight(root, xp);
                        xpl = (xp = x.parent) == null ? null : xp.left;
                    }
                    if (xpl == null) {
                        x = xp;
                    } else {
                        TreeNode<K, V> sl = xpl.left, sr = xpl.right;
                        if ((sl == null || !sl.red) && (sr == null || !sr.red)) {
                            xpl.red = true;
                            x = xp;
                        } else {
                            if (sl == null || !sl.red) {
                                if (sr != null) {
                                    sr.red = false;
                                }
                                xpl.red = true;
                                root = rotateLeft(root, xpl);
                                xpl = (xp = x.parent) == null ?
                                        null : xp.left;
                            }
                            if (xpl != null) {
                                xpl.red = (xp == null) ? false : xp.red;
                                if ((sl = xpl.left) != null) {
                                    sl.red = false;
                                }
                            }
                            if (xp != null) {
                                xp.red = false;
                                root = rotateRight(root, xp);
                            }
                            x = root;
                        }
                    }
                }
            }
        }
        
        private static <K, V> boolean checkInvariants(TreeNode<K, V> t) {
            TreeNode<K, V> tp = t.parent, tl = t.left, tr = t.right,
                    tb = t.prev, tn = (TreeNode<K, V>)t.next;
            if (tb != null && tb.next != t) {
                return false;
            }
            if (tn != null && tn.prev != t) {
                return false;
            }
            if (tp != null && t != tp.left && t != tp.right) {
                return false;
            }
            if (tl != null && (tl.parent != t || tl.hash > t.hash)) {
                return false;
            }
            if (tr != null && (tr.parent != t || tr.hash < t.hash)) {
                return false;
            }
            if (t.red && tl != null && tl.red && tr != null && tr.red) {
                return false;
            }
            if (tl != null && !checkInvariants(tl)) {
                return false;
            }
            return tr == null || checkInvariants(tr);
        }
    }
}
