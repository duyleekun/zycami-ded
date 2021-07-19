/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure2V;
import com.mob.tools.java8.Collect$MapCollect;
import com.mob.tools.java8.Each$MapEach;
import com.mob.tools.java8.Filter$MapFilter;
import com.mob.tools.java8.Flow;
import com.mob.tools.java8.Inject$MapInject;
import com.mob.tools.java8.Map$MapMap;
import com.mob.tools.java8.MapFlow$1;
import com.mob.tools.java8.MapFlow$10;
import com.mob.tools.java8.MapFlow$11;
import com.mob.tools.java8.MapFlow$12;
import com.mob.tools.java8.MapFlow$2;
import com.mob.tools.java8.MapFlow$3;
import com.mob.tools.java8.MapFlow$4;
import com.mob.tools.java8.MapFlow$5;
import com.mob.tools.java8.MapFlow$6;
import com.mob.tools.java8.MapFlow$7;
import com.mob.tools.java8.MapFlow$8;
import com.mob.tools.java8.MapFlow$9;
import com.mob.tools.java8.MapFlow$MapItem;
import com.mob.tools.java8.Optional;
import com.mob.tools.java8.Peek$MapPeek;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapFlow {
    public Flow flow;

    public MapFlow(Flow flow) {
        this.flow = flow;
    }

    public boolean any() {
        return this.flow.any();
    }

    public MapFlow collect(Collect$MapCollect object) {
        Flow flow = this.flow;
        MapFlow$4 mapFlow$4 = new MapFlow$4(this, (Collect$MapCollect)object);
        object = flow.collect(mapFlow$4);
        MapFlow mapFlow = new MapFlow((Flow)object);
        return mapFlow;
    }

    public int count() {
        return this.flow.count();
    }

    public void cowork(int n10, Closure$IClosure2V closure$IClosure2V) {
        Flow flow = this.flow;
        MapFlow$11 mapFlow$11 = new MapFlow$11(this, closure$IClosure2V);
        flow.cowork(n10, mapFlow$11);
    }

    public void cowork(Closure$IClosure2V closure$IClosure2V) {
        Flow flow = this.flow;
        MapFlow$12 mapFlow$12 = new MapFlow$12(this, closure$IClosure2V);
        flow.cowork(mapFlow$12);
    }

    public MapFlow distinct() {
        Flow flow;
        this.flow = flow = this.flow.distinct();
        return this;
    }

    public void each(Each$MapEach each$MapEach) {
        Flow flow = this.flow;
        MapFlow$8 mapFlow$8 = new MapFlow$8(this, each$MapEach);
        flow.each(mapFlow$8);
    }

    public MapFlow filter(Filter$MapFilter object) {
        Flow flow = this.flow;
        MapFlow$1 mapFlow$1 = new MapFlow$1(this, (Filter$MapFilter)object);
        object = flow.filter(mapFlow$1);
        MapFlow mapFlow = new MapFlow((Flow)object);
        return mapFlow;
    }

    public Optional first() {
        Object object = this.flow.first();
        Object object2 = null;
        if ((object = (MapFlow$MapItem)((Optional)object).orElse((Object)null)) != null) {
            object2 = ((MapFlow$MapItem)object).value;
        }
        Optional optional = new Optional(object2);
        return optional;
    }

    public Object inject(Inject$MapInject inject$MapInject) {
        return this.inject(null, inject$MapInject);
    }

    public Object inject(Object object, Inject$MapInject inject$MapInject) {
        Flow flow = this.flow;
        MapFlow$10 mapFlow$10 = new MapFlow$10(this, inject$MapInject);
        return flow.inject(object, mapFlow$10);
    }

    public Optional last() {
        Object object = this.flow.last();
        Object object2 = null;
        if ((object = (MapFlow$MapItem)((Optional)object).orElse((Object)null)) != null) {
            object2 = ((MapFlow$MapItem)object).value;
        }
        Optional optional = new Optional(object2);
        return optional;
    }

    public MapFlow limit(int n10) {
        Flow flow;
        this.flow = flow = this.flow.limit(n10);
        return this;
    }

    public MapFlow map(Map$MapMap object) {
        Flow flow = this.flow;
        MapFlow$2 mapFlow$2 = new MapFlow$2(this, (Map$MapMap)object);
        object = flow.map(mapFlow$2);
        MapFlow mapFlow = new MapFlow((Flow)object);
        return mapFlow;
    }

    public MapFlow mapKey(Map$MapMap object) {
        Flow flow = this.flow;
        MapFlow$3 mapFlow$3 = new MapFlow$3(this, (Map$MapMap)object);
        object = flow.map(mapFlow$3);
        MapFlow mapFlow = new MapFlow((Flow)object);
        return mapFlow;
    }

    public MapFlow peek(Peek$MapPeek object) {
        Flow flow = this.flow;
        MapFlow$5 mapFlow$5 = new MapFlow$5(this, (Peek$MapPeek)object);
        this.flow = object = flow.peek(mapFlow$5);
        return this;
    }

    public MapFlow skip(int n10) {
        Flow flow;
        this.flow = flow = this.flow.skip(n10);
        return this;
    }

    public MapFlow sort() {
        Flow flow = this.flow;
        MapFlow$7 mapFlow$7 = new MapFlow$7(this);
        this.flow = flow = flow.sort(mapFlow$7);
        return this;
    }

    public MapFlow sort(Comparator object) {
        Flow flow = this.flow;
        MapFlow$6 mapFlow$6 = new MapFlow$6(this, (Comparator)object);
        this.flow = object = flow.sort(mapFlow$6);
        return this;
    }

    public Map toMap() {
        HashMap hashMap = new HashMap();
        MapFlow$9 mapFlow$9 = new MapFlow$9(this, hashMap);
        this.each(mapFlow$9);
        return hashMap;
    }
}

