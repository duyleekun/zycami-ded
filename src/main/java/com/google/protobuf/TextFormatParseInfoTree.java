/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.TextFormatParseInfoTree$1;
import com.google.protobuf.TextFormatParseInfoTree$Builder;
import com.google.protobuf.TextFormatParseLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFormatParseInfoTree {
    private Map locationsFromField;
    public Map subtreesFromField;

    private TextFormatParseInfoTree(Map map, Map object) {
        boolean bl2;
        Object object2;
        List<TextFormatParseInfoTree> list;
        boolean bl3;
        Object object3 = new HashMap();
        map = map.entrySet().iterator();
        while (bl3 = map.hasNext()) {
            list = (Map.Entry)map.next();
            object2 = list.getKey();
            list = Collections.unmodifiableList((List)list.getValue());
            object3.put(object2, list);
        }
        map = Collections.unmodifiableMap(object3);
        this.locationsFromField = map;
        map = new Map<Object, ArrayList<TextFormatParseInfoTree>>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            boolean bl4;
            object3 = (Map.Entry)object.next();
            list = new List<TextFormatParseInfoTree>();
            object2 = ((List)object3.getValue()).iterator();
            while (bl4 = object2.hasNext()) {
                TextFormatParseInfoTree textFormatParseInfoTree = ((TextFormatParseInfoTree$Builder)object2.next()).build();
                list.add(textFormatParseInfoTree);
            }
            object3 = object3.getKey();
            list = Collections.unmodifiableList(list);
            map.put(object3, (ArrayList<TextFormatParseInfoTree>)list);
        }
        this.subtreesFromField = map = Collections.unmodifiableMap(map);
    }

    public /* synthetic */ TextFormatParseInfoTree(Map map, Map map2, TextFormatParseInfoTree$1 textFormatParseInfoTree$1) {
        this(map, map2);
    }

    public static TextFormatParseInfoTree$Builder builder() {
        TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder = new TextFormatParseInfoTree$Builder(null);
        return textFormatParseInfoTree$Builder;
    }

    private static Object getFromList(List object, int n10, Descriptors$FieldDescriptor object2) {
        Object object3;
        int n11 = object.size();
        if (n10 < n11 && n10 >= 0) {
            return object.get(n10);
        }
        n11 = 2;
        Object[] objectArray = new Object[n11];
        object2 = object2 == null ? "<null>" : ((Descriptors$FieldDescriptor)object2).getName();
        objectArray[0] = object2;
        objectArray[1] = object3 = Integer.valueOf(n10);
        object3 = String.format("Illegal index field: %s, index %d", objectArray);
        object = new IllegalArgumentException((String)object3);
        throw object;
    }

    public TextFormatParseLocation getLocation(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return (TextFormatParseLocation)TextFormatParseInfoTree.getFromList(this.getLocations(descriptors$FieldDescriptor), n10, descriptors$FieldDescriptor);
    }

    public List getLocations(Descriptors$FieldDescriptor list) {
        Map map = this.locationsFromField;
        if ((list = (List)map.get(list)) == null) {
            list = Collections.emptyList();
        }
        return list;
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        return (TextFormatParseInfoTree)TextFormatParseInfoTree.getFromList(this.getNestedTrees(descriptors$FieldDescriptor), n10, descriptors$FieldDescriptor);
    }

    public List getNestedTrees(Descriptors$FieldDescriptor list) {
        Map map = this.subtreesFromField;
        if ((list = (List)map.get(list)) == null) {
            list = Collections.emptyList();
        }
        return list;
    }
}

