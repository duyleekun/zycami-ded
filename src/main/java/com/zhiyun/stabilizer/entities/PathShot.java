/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhiyun.stabilizer.entities.PathShot$DecimalJsonSerializer;
import com.zhiyun.stabilizer.entities.PathShot$Point;
import com.zhiyun.stabilizer.entities.PathShot$Transition;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class PathShot {
    private final LinkedList path;

    public PathShot() {
        LinkedList linkedList;
        this.path = linkedList = new LinkedList();
    }

    public void add(PathShot$Point pathShot$Point) {
        this.path.addLast(pathShot$Point);
    }

    public void add(PathShot$Transition pathShot$Transition) {
        this.path.addLast(pathShot$Transition);
    }

    public void clear() {
        this.path.clear();
    }

    public void remove(int n10) {
        this.path.remove(n10);
    }

    public String toJsonString() {
        Object object = new GsonBuilder();
        PathShot$DecimalJsonSerializer pathShot$DecimalJsonSerializer = new PathShot$DecimalJsonSerializer(this, null);
        object = ((GsonBuilder)object).registerTypeAdapter((Type)((Object)Double.class), pathShot$DecimalJsonSerializer).create();
        LinkedList linkedList = this.path;
        return ((Gson)object).toJson(linkedList);
    }

    public String toString() {
        return this.toJsonString();
    }
}

