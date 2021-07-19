/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.query;

import cn.leancloud.AVObject;
import cn.leancloud.ops.Utils;
import cn.leancloud.query.QueryOperation;
import cn.leancloud.types.AVGeoPoint;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QueryConditions
implements Cloneable {
    private List include;
    private boolean includeACL = false;
    private int limit;
    private String order;
    private Map parameters;
    private Set selectedKeys;
    private int skip = -1;
    private boolean trace;
    public Map where;

    public QueryConditions() {
        HashMap hashMap;
        Cloneable cloneable;
        this.where = cloneable = new Cloneable();
        this.include = cloneable;
        this.includeACL = false;
        this.parameters = hashMap = new HashMap();
    }

    private void removeDuplications(QueryOperation queryOperation, List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            QueryOperation queryOperation2 = (QueryOperation)object.next();
            bl2 = queryOperation2.sameOp(queryOperation);
            if (!bl2) continue;
            object.remove();
        }
    }

    public void addAndItems(QueryConditions list) {
        boolean bl2;
        Object object;
        list = ((QueryConditions)((Object)list)).compileWhereOperationMap();
        Object object2 = "$and";
        QueryOperation queryOperation = new QueryOperation((String)object2, (String)object2, list);
        list = (List)this.where.get(object2);
        if (list == null) {
            list = new List<QueryOperation>();
            object = this.where;
            object.put(object2, list);
        }
        object2 = list.iterator();
        while (bl2 = object2.hasNext()) {
            object = (QueryOperation)object2.next();
            bl2 = ((QueryOperation)object).equals(queryOperation);
            if (!bl2) continue;
            object2.remove();
        }
        list.add(queryOperation);
    }

    public void addAscendingOrder(String string2) {
        Object[] objectArray = this.order;
        boolean bl2 = StringUtil.isEmpty((String)objectArray);
        if (bl2) {
            this.orderByAscending(string2);
            return;
        }
        objectArray = new Object[2];
        String string3 = this.order;
        objectArray[0] = string3;
        objectArray[1] = string2;
        this.order = string2 = String.format("%s,%s", objectArray);
    }

    public void addDescendingOrder(String string2) {
        Object[] objectArray = this.order;
        boolean bl2 = StringUtil.isEmpty((String)objectArray);
        if (bl2) {
            this.orderByDescending(string2);
            return;
        }
        objectArray = new Object[2];
        String string3 = this.order;
        objectArray[0] = string3;
        objectArray[1] = string2;
        this.order = string2 = String.format("%s,-%s", objectArray);
    }

    public void addOrItems(QueryOperation queryOperation) {
        boolean bl2;
        Object object;
        LinkedList<QueryOperation> linkedList = this.where;
        Object object2 = "$or";
        if ((linkedList = (List)linkedList.get(object2)) == null) {
            linkedList = new LinkedList<QueryOperation>();
            object = this.where;
            object.put(object2, linkedList);
        }
        object2 = linkedList.iterator();
        while (bl2 = object2.hasNext()) {
            object = (QueryOperation)object2.next();
            bl2 = ((QueryOperation)object).equals(queryOperation);
            if (!bl2) continue;
            object2.remove();
        }
        linkedList.add(queryOperation);
    }

    public void addWhereItem(QueryOperation queryOperation) {
        LinkedList<QueryOperation> linkedList = this.where;
        Object object = queryOperation.getKey();
        if ((linkedList = (List)linkedList.get(object)) == null) {
            linkedList = new LinkedList<QueryOperation>();
            object = this.where;
            String string2 = queryOperation.getKey();
            object.put(string2, linkedList);
        }
        this.removeDuplications(queryOperation, linkedList);
        linkedList.add(queryOperation);
    }

    public void addWhereItem(String string2, String string3, Object object) {
        QueryOperation queryOperation = new QueryOperation(string2, string3, object);
        this.addWhereItem(queryOperation);
    }

    public Map assembleJsonParam() {
        String string2;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Set set = this.where.keySet();
        int n10 = set.size();
        if (n10 > 0) {
            set = this.compileWhereOperationMap();
            string2 = "where";
            hashMap.put(string2, set);
        }
        if ((n10 = this.limit) > 0) {
            set = n10;
            string2 = "limit";
            hashMap.put(string2, set);
        }
        if ((n10 = this.skip) >= 0) {
            set = n10;
            string2 = "skip";
            hashMap.put(string2, set);
        }
        if ((n10 = (int)(this.includeACL ? 1 : 0)) != 0) {
            set = "returnACL";
            string2 = "true";
            hashMap.put(set, string2);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)((Object)(set = this.order))) ? 1 : 0)) == 0) {
            set = this.order;
            string2 = "order";
            hashMap.put(string2, set);
        }
        set = this.include;
        string2 = ",";
        if (set != null && (n10 = set.size()) > 0) {
            set = this.include;
            set = StringUtil.join(string2, set);
            String string3 = "include";
            hashMap.put(string3, set);
        }
        if ((set = this.selectedKeys) != null && (n10 = set.size()) > 0) {
            set = this.selectedKeys;
            set = StringUtil.join(string2, set);
            string2 = "keys";
            hashMap.put(string2, set);
        }
        return hashMap;
    }

    public Map assembleParameters() {
        Object object;
        Object object2;
        Set set = this.where.keySet();
        int n10 = set.size();
        if (n10 > 0) {
            set = AVUtils.jsonStringFromMapWithNull(Utils.getParsedMap(this.compileWhereOperationMap()));
            object2 = this.parameters;
            object = "where";
            object2.put(object, set);
        }
        if ((n10 = this.limit) > 0) {
            object2 = this.parameters;
            set = Integer.toString(n10);
            object = "limit";
            object2.put(object, set);
        }
        if ((n10 = this.skip) >= 0) {
            object2 = this.parameters;
            set = Integer.toString(n10);
            object = "skip";
            object2.put(object, set);
        }
        if ((n10 = (int)(this.includeACL ? 1 : 0)) != 0) {
            set = this.parameters;
            object2 = "returnACL";
            object = "true";
            set.put(object2, object);
        }
        if ((n10 = (int)(StringUtil.isEmpty((String)((Object)(set = this.order))) ? 1 : 0)) == 0) {
            set = this.parameters;
            object2 = this.order;
            object = "order";
            set.put(object, object2);
        }
        set = this.include;
        object2 = ",";
        if (set != null && (n10 = set.size()) > 0) {
            set = this.include;
            set = StringUtil.join((CharSequence)object2, set);
            object = this.parameters;
            String string2 = "include";
            object.put(string2, set);
        }
        if ((set = this.selectedKeys) != null && (n10 = set.size()) > 0) {
            set = this.selectedKeys;
            set = StringUtil.join((CharSequence)object2, set);
            object2 = this.parameters;
            object = "keys";
            object2.put(object, set);
        }
        return this.parameters;
    }

    public QueryConditions clone() {
        QueryConditions queryConditions = new QueryConditions();
        Object object = queryConditions.where;
        Object object2 = this.where;
        object.putAll(object2);
        object = queryConditions.include;
        object2 = this.include;
        object.addAll(object2);
        object = queryConditions.parameters;
        object2 = this.parameters;
        object.putAll(object2);
        object = this.selectedKeys;
        queryConditions.selectKeys((Collection)object);
        int bl2 = this.limit;
        queryConditions.setLimit(bl2);
        boolean bl3 = this.trace;
        queryConditions.setTrace(bl3);
        int n10 = this.skip;
        queryConditions.setSkip(n10);
        object = this.order;
        queryConditions.setOrder((String)object);
        boolean bl4 = this.includeACL;
        queryConditions.includeACL(bl4);
        return queryConditions;
    }

    public Map compileWhereOperationMap() {
        boolean bl2;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Iterator iterator2 = this.where.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object;
            Object object2;
            List list = iterator2.next();
            Object object3 = (List)list.getValue();
            int n10 = ((String)((Object)(list = (String)list.getKey()))).equals(object2 = "$or");
            if (n10 != 0) {
                list = new List();
                object3 = object3.iterator();
                while ((n10 = object3.hasNext()) != 0) {
                    object = ((QueryOperation)object3.next()).toResult();
                    list.add(object);
                }
                object3 = (List)hashMap.get(object2);
                if (object3 != null) {
                    object3.addAll(list);
                    continue;
                }
                hashMap.put(object2, list);
                continue;
            }
            object2 = "$and";
            n10 = ((String)((Object)list)).equals(object2);
            if (n10 != 0) {
                list = new List();
                object3 = object3.iterator();
                while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                    object = ((QueryOperation)object3.next()).getValue();
                    list.add(object);
                }
                object3 = (List)hashMap.get(object2);
                if (object3 != null) {
                    object3.addAll(list);
                    continue;
                }
                hashMap.put(object2, list);
                continue;
            }
            n10 = object3.size();
            if (n10 == 0) continue;
            int n11 = 1;
            if (n10 != n11) {
                boolean bl4;
                object = new ArrayList();
                HashMap hashMap2 = new HashMap();
                int n12 = 0;
                object3 = object3.iterator();
                while (bl4 = object3.hasNext()) {
                    Object object4 = (QueryOperation)object3.next();
                    Object object5 = ((QueryOperation)object4).toResult((String)((Object)list));
                    object.add(object5);
                    object5 = ((QueryOperation)object4).getOp();
                    String string2 = "__eq";
                    boolean bl5 = string2.equals(object5);
                    if (bl5) {
                        n12 = n11;
                    }
                    if (n12 != 0) continue;
                    object4 = (Map)((QueryOperation)object4).toResult();
                    hashMap2.putAll(object4);
                }
                if (n12 != 0) {
                    list = (List)hashMap.get(object2);
                    if (list != null) {
                        list.addAll(object);
                        continue;
                    }
                    hashMap.put(object2, object);
                    continue;
                }
                hashMap.put(list, hashMap2);
                continue;
            }
            object3 = object3.iterator();
            while (bl3 = object3.hasNext()) {
                object2 = ((QueryOperation)object3.next()).toResult();
                hashMap.put(list, object2);
            }
        }
        return hashMap;
    }

    public List getInclude() {
        return this.include;
    }

    public int getLimit() {
        return this.limit;
    }

    public String getOrder() {
        return this.order;
    }

    public Map getParameters() {
        Map map = this.parameters;
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }

    public Set getSelectedKeys() {
        return this.selectedKeys;
    }

    public int getSkip() {
        return this.skip;
    }

    public Map getWhere() {
        return this.where;
    }

    public void include(String string2) {
        this.include.add(string2);
    }

    public void includeACL(boolean bl2) {
        this.includeACL = bl2;
    }

    public boolean isIncludeACL() {
        return this.includeACL;
    }

    public boolean isTrace() {
        return this.trace;
    }

    public void orderByAscending(String string2) {
        Object[] objectArray = new Object[]{string2};
        this.order = string2 = String.format("%s", objectArray);
    }

    public void orderByDescending(String string2) {
        Object[] objectArray = new Object[]{string2};
        this.order = string2 = String.format("-%s", objectArray);
    }

    public void selectKeys(Collection collection) {
        Set set = this.selectedKeys;
        if (set == null) {
            this.selectedKeys = set = new Set();
        }
        if (collection != null) {
            set = this.selectedKeys;
            set.addAll(collection);
        }
    }

    public void setInclude(List list) {
        this.include = list;
    }

    public void setLimit(int n10) {
        this.limit = n10;
    }

    public void setOrder(String string2) {
        this.order = string2;
    }

    public void setParameters(Map map) {
        this.parameters = map;
    }

    public void setSelectedKeys(Set set) {
        this.selectedKeys = set;
    }

    public void setSkip(int n10) {
        this.skip = n10;
    }

    public void setTrace(boolean bl2) {
        this.trace = bl2;
    }

    public void setWhere(Map map) {
        this.where = map;
    }

    public void whereContainedIn(String string2, Collection collection) {
        this.addWhereItem(string2, "$in", collection);
    }

    public void whereContains(String string2, String string3) {
        Object[] objectArray = new Object[]{string3};
        string3 = String.format(".*%s.*", objectArray);
        this.whereMatches(string2, string3);
    }

    public void whereContainsAll(String string2, Collection collection) {
        this.addWhereItem(string2, "$all", collection);
    }

    public void whereDoesNotExist(String string2) {
        Boolean bl2 = Boolean.FALSE;
        this.addWhereItem(string2, "$exists", bl2);
    }

    public void whereEndsWith(String string2, String string3) {
        Object[] objectArray = new Object[]{string3};
        string3 = String.format(".*%s$", objectArray);
        this.whereMatches(string2, string3);
    }

    public void whereEqualTo(String string2, Object object) {
        boolean bl2 = object instanceof AVObject;
        String string3 = "__eq";
        if (bl2) {
            object = Utils.mapFromPointerObject((AVObject)object);
            this.addWhereItem(string2, string3, object);
        } else {
            this.addWhereItem(string2, string3, object);
        }
    }

    public void whereExists(String string2) {
        Boolean bl2 = Boolean.TRUE;
        this.addWhereItem(string2, "$exists", bl2);
    }

    public void whereGreaterThan(String string2, Object object) {
        this.addWhereItem(string2, "$gt", object);
    }

    public void whereGreaterThanOrEqualTo(String string2, Object object) {
        QueryOperation queryOperation = new QueryOperation(string2, "$gte", object);
        this.addWhereItem(queryOperation);
    }

    public void whereLessThan(String string2, Object object) {
        this.addWhereItem(string2, "$lt", object);
    }

    public void whereLessThanOrEqualTo(String string2, Object object) {
        this.addWhereItem(string2, "$lte", object);
    }

    public void whereMatches(String string2, String string3) {
        this.addWhereItem(string2, "$regex", string3);
    }

    public void whereMatches(String string2, String string3, String string4) {
        this.addWhereItem(string2, "$regex", string3);
        this.addWhereItem(string2, "$options", string4);
    }

    public void whereNear(String string2, AVGeoPoint object) {
        object = Utils.mapFromGeoPoint((AVGeoPoint)object);
        this.addWhereItem(string2, "$nearSphere", object);
    }

    public void whereNotContainedIn(String string2, Collection collection) {
        this.addWhereItem(string2, "$nin", collection);
    }

    public void whereNotEqualTo(String string2, Object object) {
        this.addWhereItem(string2, "$ne", object);
    }

    public void whereSizeEqual(String string2, int n10) {
        Integer n11 = n10;
        this.addWhereItem(string2, "$size", n11);
    }

    public void whereStartsWith(String string2, String string3) {
        Object[] objectArray = new Object[]{string3};
        string3 = String.format("^%s.*", objectArray);
        this.whereMatches(string2, string3);
    }

    public void whereWithinGeoBox(String string2, AVGeoPoint object, AVGeoPoint aVGeoPoint) {
        LinkedList<Object> linkedList = new LinkedList<Object>();
        object = Utils.mapFromGeoPoint((AVGeoPoint)object);
        linkedList.add(object);
        object = Utils.mapFromGeoPoint(aVGeoPoint);
        linkedList.add(object);
        object = AVUtils.createMap("$box", linkedList);
        this.addWhereItem(string2, "$within", object);
    }

    public void whereWithinKilometers(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.whereWithinKilometers(string2, aVGeoPoint, d10, -1.0);
    }

    public void whereWithinKilometers(String string2, AVGeoPoint object, double d10, double d11) {
        double d12;
        String string3;
        Double d13;
        object = Utils.mapFromGeoPoint((AVGeoPoint)object);
        String string4 = "$nearSphere";
        object = AVUtils.createMap(string4, object);
        double d14 = 0.0;
        double d15 = d10 - d14;
        Object object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        if (object2 >= 0) {
            d13 = d10;
            string3 = "$maxDistanceInKilometers";
            object.put(string3, d13);
        }
        if ((d12 = d11 == d14 ? 0 : (d11 > d14 ? 1 : -1)) >= 0) {
            d13 = d11;
            string3 = "$minDistanceInKilometers";
            object.put(string3, d13);
        }
        this.addWhereItem(string2, null, object);
    }

    public void whereWithinMiles(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.whereWithinMiles(string2, aVGeoPoint, d10, -1.0);
    }

    public void whereWithinMiles(String string2, AVGeoPoint object, double d10, double d11) {
        double d12;
        String string3;
        Double d13;
        object = Utils.mapFromGeoPoint((AVGeoPoint)object);
        String string4 = "$nearSphere";
        object = AVUtils.createMap(string4, object);
        double d14 = 0.0;
        double d15 = d10 - d14;
        Object object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        if (object2 >= 0) {
            d13 = d10;
            string3 = "$maxDistanceInMiles";
            object.put(string3, d13);
        }
        if ((d12 = d11 == d14 ? 0 : (d11 > d14 ? 1 : -1)) >= 0) {
            d13 = d11;
            string3 = "$minDistanceInMiles";
            object.put(string3, d13);
        }
        this.addWhereItem(string2, null, object);
    }

    public void whereWithinRadians(String string2, AVGeoPoint aVGeoPoint, double d10) {
        this.whereWithinRadians(string2, aVGeoPoint, d10, -1.0);
    }

    public void whereWithinRadians(String string2, AVGeoPoint object, double d10, double d11) {
        double d12;
        String string3;
        Object object2;
        object = Utils.mapFromGeoPoint((AVGeoPoint)object);
        String string4 = "$nearSphere";
        object = AVUtils.createMap(string4, object);
        double d13 = 0.0;
        double d14 = d10 - d13;
        Object object3 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object3 >= 0) {
            object2 = d10;
            string3 = "$maxDistanceInRadians";
            object.put(string3, object2);
        }
        if ((d12 = d11 == d13 ? 0 : (d11 > d13 ? 1 : -1)) >= 0) {
            object2 = d11;
            string3 = "$minDistanceInRadians";
            object.put(string3, object2);
        }
        object2 = new QueryOperation(string2, null, object);
        this.addWhereItem((QueryOperation)object2);
    }
}

