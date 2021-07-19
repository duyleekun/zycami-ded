/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure1V;
import com.mob.tools.java8.Collect;
import com.mob.tools.java8.Collect$CollectByte;
import com.mob.tools.java8.Collect$CollectDouble;
import com.mob.tools.java8.Collect$CollectFloat;
import com.mob.tools.java8.Collect$CollectInt;
import com.mob.tools.java8.Collect$CollectLong;
import com.mob.tools.java8.Collect$CollectShort;
import com.mob.tools.java8.Each;
import com.mob.tools.java8.Filter;
import com.mob.tools.java8.Flow;
import com.mob.tools.java8.Inject;
import com.mob.tools.java8.Map;
import com.mob.tools.java8.Map$MapByte;
import com.mob.tools.java8.Map$MapDouble;
import com.mob.tools.java8.Map$MapFloat;
import com.mob.tools.java8.Map$MapInt;
import com.mob.tools.java8.Map$MapLong;
import com.mob.tools.java8.Map$MapShort;
import com.mob.tools.java8.MapMaker;
import com.mob.tools.java8.NumberFlow$1;
import com.mob.tools.java8.NumberFlow$ByteFlow;
import com.mob.tools.java8.NumberFlow$DoubleFlow;
import com.mob.tools.java8.NumberFlow$FloatFlow;
import com.mob.tools.java8.NumberFlow$IntFlow;
import com.mob.tools.java8.NumberFlow$LongFlow;
import com.mob.tools.java8.NumberFlow$ShortFlow;
import com.mob.tools.java8.Optional;
import com.mob.tools.java8.Peek;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public abstract class NumberFlow {
    private Flow flow;
    private NumberFlow self;

    private NumberFlow(Flow flow) {
        this.flow = flow;
        this.self = this;
    }

    public /* synthetic */ NumberFlow(Flow flow, NumberFlow$1 numberFlow$1) {
        this(flow);
    }

    public boolean any() {
        return this.flow.any();
    }

    public abstract Optional average();

    public Flow chunk(int n10) {
        return this.flow.chunk(n10);
    }

    public Flow chunkCollect(int n10) {
        return this.flow.chunkCollect(n10);
    }

    public NumberFlow$ByteFlow collect(Collect$CollectByte object) {
        object = this.flow.collect((Collect)object);
        NumberFlow$ByteFlow numberFlow$ByteFlow = new NumberFlow$ByteFlow((Flow)object);
        return numberFlow$ByteFlow;
    }

    public NumberFlow$DoubleFlow collect(Collect$CollectDouble object) {
        object = this.flow.collect((Collect)object);
        NumberFlow$DoubleFlow numberFlow$DoubleFlow = new NumberFlow$DoubleFlow((Flow)object);
        return numberFlow$DoubleFlow;
    }

    public NumberFlow$FloatFlow collect(Collect$CollectFloat object) {
        object = this.flow.collect((Collect)object);
        NumberFlow$FloatFlow numberFlow$FloatFlow = new NumberFlow$FloatFlow((Flow)object);
        return numberFlow$FloatFlow;
    }

    public NumberFlow$IntFlow collect(Collect$CollectInt object) {
        object = this.flow.collect((Collect)object);
        NumberFlow$IntFlow numberFlow$IntFlow = new NumberFlow$IntFlow((Flow)object);
        return numberFlow$IntFlow;
    }

    public NumberFlow$LongFlow collect(Collect$CollectLong object) {
        object = this.flow.collect((Collect)object);
        NumberFlow$LongFlow numberFlow$LongFlow = new NumberFlow$LongFlow((Flow)object);
        return numberFlow$LongFlow;
    }

    public NumberFlow$ShortFlow collect(Collect$CollectShort object) {
        object = this.flow.collect((Collect)object);
        NumberFlow$ShortFlow numberFlow$ShortFlow = new NumberFlow$ShortFlow((Flow)object);
        return numberFlow$ShortFlow;
    }

    public NumberFlow$ByteFlow collectByte(Collect$CollectByte collect$CollectByte) {
        return this.collect(collect$CollectByte);
    }

    public NumberFlow$DoubleFlow collectByte(Collect$CollectDouble collect$CollectDouble) {
        return this.collect(collect$CollectDouble);
    }

    public NumberFlow$FloatFlow collectByte(Collect$CollectFloat collect$CollectFloat) {
        return this.collect(collect$CollectFloat);
    }

    public NumberFlow$IntFlow collectByte(Collect$CollectInt collect$CollectInt) {
        return this.collect(collect$CollectInt);
    }

    public NumberFlow$LongFlow collectByte(Collect$CollectLong collect$CollectLong) {
        return this.collect(collect$CollectLong);
    }

    public NumberFlow$ShortFlow collectByte(Collect$CollectShort collect$CollectShort) {
        return this.collect(collect$CollectShort);
    }

    public int count() {
        return this.flow.count();
    }

    public void cowork(int n10, Closure$IClosure1V closure$IClosure1V) {
        this.flow.cowork(n10, closure$IClosure1V);
    }

    public void cowork(Closure$IClosure1V closure$IClosure1V) {
        this.flow.cowork(closure$IClosure1V);
    }

    public NumberFlow distinct() {
        Flow flow;
        this.flow = flow = this.flow.distinct();
        return this.self;
    }

    public void each(Each each) {
        this.flow.each(each);
    }

    public NumberFlow filter(Filter object) {
        this.flow = object = this.flow.filter((Filter)object);
        return this.self;
    }

    public Optional first() {
        return this.flow.first();
    }

    public Object inject(Inject inject) {
        return this.inject(null, inject);
    }

    public Object inject(Object object, Inject inject) {
        return this.flow.inject(object, inject);
    }

    public NumberFlow jumble() {
        Flow flow;
        this.flow = flow = this.flow.jumble();
        return this.self;
    }

    public Optional last() {
        return this.flow.last();
    }

    public NumberFlow limit(int n10) {
        Flow flow;
        this.flow = flow = this.flow.limit(n10);
        return this.self;
    }

    public NumberFlow$ByteFlow map(Map$MapByte object) {
        object = this.flow.map((Map)object);
        NumberFlow$ByteFlow numberFlow$ByteFlow = new NumberFlow$ByteFlow((Flow)object);
        return numberFlow$ByteFlow;
    }

    public NumberFlow$DoubleFlow map(Map$MapDouble object) {
        object = this.flow.map((Map)object);
        NumberFlow$DoubleFlow numberFlow$DoubleFlow = new NumberFlow$DoubleFlow((Flow)object);
        return numberFlow$DoubleFlow;
    }

    public NumberFlow$FloatFlow map(Map$MapFloat object) {
        object = this.flow.map((Map)object);
        NumberFlow$FloatFlow numberFlow$FloatFlow = new NumberFlow$FloatFlow((Flow)object);
        return numberFlow$FloatFlow;
    }

    public NumberFlow$IntFlow map(Map$MapInt object) {
        object = this.flow.map((Map)object);
        NumberFlow$IntFlow numberFlow$IntFlow = new NumberFlow$IntFlow((Flow)object);
        return numberFlow$IntFlow;
    }

    public NumberFlow$LongFlow map(Map$MapLong object) {
        object = this.flow.map((Map)object);
        NumberFlow$LongFlow numberFlow$LongFlow = new NumberFlow$LongFlow((Flow)object);
        return numberFlow$LongFlow;
    }

    public NumberFlow$ShortFlow map(Map$MapShort object) {
        object = this.flow.map((Map)object);
        NumberFlow$ShortFlow numberFlow$ShortFlow = new NumberFlow$ShortFlow((Flow)object);
        return numberFlow$ShortFlow;
    }

    public NumberFlow$ByteFlow mapByte(Map$MapByte map$MapByte) {
        return this.map(map$MapByte);
    }

    public NumberFlow$DoubleFlow mapDouble(Map$MapDouble map$MapDouble) {
        return this.map(map$MapDouble);
    }

    public NumberFlow$FloatFlow mapFloat(Map$MapFloat map$MapFloat) {
        return this.map(map$MapFloat);
    }

    public NumberFlow$IntFlow mapInt(Map$MapInt map$MapInt) {
        return this.map(map$MapInt);
    }

    public NumberFlow$LongFlow mapLong(Map$MapLong map$MapLong) {
        return this.map(map$MapLong);
    }

    public NumberFlow$ShortFlow mapShort(Map$MapShort map$MapShort) {
        return this.map(map$MapShort);
    }

    public Optional max() {
        return this.flow.sort().last();
    }

    public Optional min() {
        return this.flow.sort().first();
    }

    public NumberFlow peek(Peek object) {
        this.flow = object = this.flow.peek((Peek)object);
        return this.self;
    }

    public Flow rawCollect(Collect collect) {
        return this.flow.collect(collect);
    }

    public Flow rawMap(Map map) {
        return this.flow.map(map);
    }

    public NumberFlow skip(int n10) {
        Flow flow;
        this.flow = flow = this.flow.skip(n10);
        return this.self;
    }

    public NumberFlow sort() {
        return this.sort(null);
    }

    public NumberFlow sort(Comparator object) {
        this.flow = object = this.flow.sort((Comparator)object);
        return this.self;
    }

    public abstract Number sum();

    public abstract Number[] toArray();

    public List toList() {
        return this.flow.toList();
    }

    public java.util.Map toMap(MapMaker mapMaker) {
        return this.flow.toMap(mapMaker);
    }

    public Set toSet() {
        return this.flow.toSet();
    }
}

