/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Batch;
import com.mob.tools.java8.Batch$Chunk;
import com.mob.tools.java8.Batch$Limit;
import com.mob.tools.java8.Batch$Skip;
import com.mob.tools.java8.Closure$IClosure1V;
import com.mob.tools.java8.Collect;
import com.mob.tools.java8.CoworkerThread;
import com.mob.tools.java8.Each;
import com.mob.tools.java8.Filter;
import com.mob.tools.java8.Flow$1;
import com.mob.tools.java8.Flow$10;
import com.mob.tools.java8.Flow$11;
import com.mob.tools.java8.Flow$2;
import com.mob.tools.java8.Flow$3;
import com.mob.tools.java8.Flow$4;
import com.mob.tools.java8.Flow$5;
import com.mob.tools.java8.Flow$6;
import com.mob.tools.java8.Flow$7;
import com.mob.tools.java8.Flow$8;
import com.mob.tools.java8.Flow$9;
import com.mob.tools.java8.FlowIterator;
import com.mob.tools.java8.FlowIterator$ArrayIterator;
import com.mob.tools.java8.FlowIterator$BoolArrayIterator;
import com.mob.tools.java8.FlowIterator$BufferedReaderIterator;
import com.mob.tools.java8.FlowIterator$ByteArrayIterator;
import com.mob.tools.java8.FlowIterator$CharArrayIterator;
import com.mob.tools.java8.FlowIterator$DoubleArrayIterator;
import com.mob.tools.java8.FlowIterator$DoubleRangeIterator;
import com.mob.tools.java8.FlowIterator$EnumerationIterator;
import com.mob.tools.java8.FlowIterator$FileReaderIterator;
import com.mob.tools.java8.FlowIterator$FloatArrayIterator;
import com.mob.tools.java8.FlowIterator$IntArrayIterator;
import com.mob.tools.java8.FlowIterator$IntRangeIterator;
import com.mob.tools.java8.FlowIterator$IterableIterator;
import com.mob.tools.java8.FlowIterator$LongArrayIterator;
import com.mob.tools.java8.FlowIterator$MapIterator;
import com.mob.tools.java8.FlowIterator$ShortArrayIterator;
import com.mob.tools.java8.Function;
import com.mob.tools.java8.Inject;
import com.mob.tools.java8.Map;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapMaker;
import com.mob.tools.java8.NumberFlow$ByteFlow;
import com.mob.tools.java8.NumberFlow$DoubleFlow;
import com.mob.tools.java8.NumberFlow$FloatFlow;
import com.mob.tools.java8.NumberFlow$IntFlow;
import com.mob.tools.java8.NumberFlow$LongFlow;
import com.mob.tools.java8.NumberFlow$ShortFlow;
import com.mob.tools.java8.Optional;
import com.mob.tools.java8.Peek;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Flow {
    public LinkedList functions;
    public FlowIterator iterator;

    private Flow() {
        LinkedList linkedList;
        this.functions = linkedList = new LinkedList();
    }

    public /* synthetic */ Flow(Flow$1 var1_1) {
        this();
    }

    private Flow(Flow object) {
        FlowIterator flowIterator;
        this.iterator = flowIterator = ((Flow)object).iterator;
        this.functions = object = ((Flow)object).functions;
    }

    private Flow(FlowIterator linkedList) {
        this.iterator = linkedList;
        this.functions = linkedList = new LinkedList();
    }

    public static Flow concat(Flow ... flowArray) {
        Flow$1 flow$1 = new Flow$1(flowArray);
        return flow$1;
    }

    private void evaluate(FlowIterator flowIterator, int n10) {
        int n11;
        while ((n11 = flowIterator.hasNext()) != 0) {
            n11 = 0;
            Object object = flowIterator.next();
            LinkedList linkedList = this.functions;
            int n12 = linkedList.size();
            for (int i10 = n10; i10 < n12; ++i10) {
                int n13;
                Function function = (Function)this.functions.get(i10);
                int n14 = function instanceof Filter;
                if (n14 != 0) {
                    n13 = (function = (Filter)function).filter(object);
                    if (n13 != 0) continue;
                    break;
                }
                n14 = function instanceof Map;
                if (n14 != 0) {
                    function = (Map)function;
                    object = function.map(object);
                    continue;
                }
                n14 = function instanceof Collect;
                if (n14 != 0) {
                    function = (Collect)function;
                    object = function.collect((Object)object).iterator;
                    this.evaluate((FlowIterator)object, ++i10);
                    break;
                }
                n14 = function instanceof Each;
                if (n14 != 0) {
                    function = (Each)function;
                    function.each(object);
                    continue;
                }
                n14 = function instanceof Batch$Limit;
                int n15 = 1;
                if (n14 != 0) {
                    n13 = ((Batch)(function = (Batch$Limit)function)).test(object);
                    if (n13 <= 0) continue;
                    n11 = n15;
                    continue;
                }
                n14 = function instanceof Batch$Skip;
                if (n14 != 0) {
                    n13 = ((Batch)(function = (Batch$Skip)function)).test(object);
                    if (n13 >= (n14 = 2)) continue;
                    break;
                }
                n14 = function instanceof Batch$Chunk;
                if (n14 != 0) {
                    int n16 = ((Batch)(function = (Batch$Chunk)function)).test(object);
                    if (n16 < n15 && (n16 = (int)(flowIterator.hasNext() ? 1 : 0)) != 0) break;
                    object = ((Batch)function).output();
                    ((Batch$Chunk)function).reset();
                    continue;
                }
                n14 = function instanceof Peek;
                if (n14 == 0) continue;
                function = (Peek)function;
                function.peek(object);
            }
            if (n11 == 0) continue;
        }
        flowIterator.finish();
    }

    private Flow nextFlow(Function object) {
        this.functions.add(object);
        object = new Flow(this);
        return object;
    }

    public static Flow of(FlowIterator flowIterator) {
        Flow flow = new Flow(flowIterator);
        return flow;
    }

    public static Flow of(BufferedReader bufferedReader) {
        FlowIterator$BufferedReaderIterator flowIterator$BufferedReaderIterator = new FlowIterator$BufferedReaderIterator(bufferedReader);
        return Flow.of(flowIterator$BufferedReaderIterator);
    }

    public static Flow of(File file) {
        return Flow.of(file, "utf-8");
    }

    public static Flow of(File file, String object) {
        object = Charset.forName((String)object);
        return Flow.of(file, (Charset)object);
    }

    public static Flow of(File file, Charset charset) {
        FlowIterator$FileReaderIterator flowIterator$FileReaderIterator = new FlowIterator$FileReaderIterator(file, charset);
        return Flow.of(flowIterator$FileReaderIterator);
    }

    public static Flow of(Iterable iterable) {
        FlowIterator$IterableIterator flowIterator$IterableIterator = new FlowIterator$IterableIterator(iterable);
        return Flow.of(flowIterator$IterableIterator);
    }

    public static Flow of(Enumeration enumeration) {
        FlowIterator$EnumerationIterator flowIterator$EnumerationIterator = new FlowIterator$EnumerationIterator(enumeration);
        return Flow.of(flowIterator$EnumerationIterator);
    }

    public static Flow of(char ... cArray) {
        FlowIterator$CharArrayIterator flowIterator$CharArrayIterator = new FlowIterator$CharArrayIterator(cArray);
        return Flow.of(flowIterator$CharArrayIterator);
    }

    public static Flow of(Object ... objectArray) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(objectArray);
        return Flow.of(flowIterator$ArrayIterator);
    }

    public static Flow of(boolean ... blArray) {
        FlowIterator$BoolArrayIterator flowIterator$BoolArrayIterator = new FlowIterator$BoolArrayIterator(blArray);
        return Flow.of(flowIterator$BoolArrayIterator);
    }

    public static MapFlow of(java.util.Map object) {
        FlowIterator$MapIterator flowIterator$MapIterator = new FlowIterator$MapIterator((java.util.Map)object);
        object = Flow.of(flowIterator$MapIterator);
        MapFlow mapFlow = new MapFlow((Flow)object);
        return mapFlow;
    }

    public static NumberFlow$ByteFlow of(byte ... object) {
        FlowIterator$ByteArrayIterator flowIterator$ByteArrayIterator = new FlowIterator$ByteArrayIterator((byte)object);
        object = Flow.of(flowIterator$ByteArrayIterator);
        NumberFlow$ByteFlow numberFlow$ByteFlow = new NumberFlow$ByteFlow((Flow)object);
        return numberFlow$ByteFlow;
    }

    public static NumberFlow$ByteFlow of(Byte ... object) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(object);
        object = Flow.of(flowIterator$ArrayIterator);
        NumberFlow$ByteFlow numberFlow$ByteFlow = new NumberFlow$ByteFlow((Flow)object);
        return numberFlow$ByteFlow;
    }

    public static NumberFlow$DoubleFlow of(double ... object) {
        FlowIterator$DoubleArrayIterator flowIterator$DoubleArrayIterator = new FlowIterator$DoubleArrayIterator((double)object);
        object = Flow.of(flowIterator$DoubleArrayIterator);
        NumberFlow$DoubleFlow numberFlow$DoubleFlow = new NumberFlow$DoubleFlow((Flow)object);
        return numberFlow$DoubleFlow;
    }

    public static NumberFlow$DoubleFlow of(Double ... object) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(object);
        object = Flow.of(flowIterator$ArrayIterator);
        NumberFlow$DoubleFlow numberFlow$DoubleFlow = new NumberFlow$DoubleFlow((Flow)object);
        return numberFlow$DoubleFlow;
    }

    public static NumberFlow$FloatFlow of(float ... object) {
        FlowIterator$FloatArrayIterator flowIterator$FloatArrayIterator = new FlowIterator$FloatArrayIterator((float)object);
        object = Flow.of(flowIterator$FloatArrayIterator);
        NumberFlow$FloatFlow numberFlow$FloatFlow = new NumberFlow$FloatFlow((Flow)object);
        return numberFlow$FloatFlow;
    }

    public static NumberFlow$FloatFlow of(Float ... object) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(object);
        object = Flow.of(flowIterator$ArrayIterator);
        NumberFlow$FloatFlow numberFlow$FloatFlow = new NumberFlow$FloatFlow((Flow)object);
        return numberFlow$FloatFlow;
    }

    public static NumberFlow$IntFlow of(int ... object) {
        FlowIterator$IntArrayIterator flowIterator$IntArrayIterator = new FlowIterator$IntArrayIterator((int)object);
        object = Flow.of(flowIterator$IntArrayIterator);
        NumberFlow$IntFlow numberFlow$IntFlow = new NumberFlow$IntFlow((Flow)object);
        return numberFlow$IntFlow;
    }

    public static NumberFlow$IntFlow of(Integer ... object) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(object);
        object = Flow.of(flowIterator$ArrayIterator);
        NumberFlow$IntFlow numberFlow$IntFlow = new NumberFlow$IntFlow((Flow)object);
        return numberFlow$IntFlow;
    }

    public static NumberFlow$LongFlow of(long ... object) {
        FlowIterator$LongArrayIterator flowIterator$LongArrayIterator = new FlowIterator$LongArrayIterator((long)object);
        object = Flow.of(flowIterator$LongArrayIterator);
        NumberFlow$LongFlow numberFlow$LongFlow = new NumberFlow$LongFlow((Flow)object);
        return numberFlow$LongFlow;
    }

    public static NumberFlow$LongFlow of(Long ... object) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(object);
        object = Flow.of(flowIterator$ArrayIterator);
        NumberFlow$LongFlow numberFlow$LongFlow = new NumberFlow$LongFlow((Flow)object);
        return numberFlow$LongFlow;
    }

    public static NumberFlow$ShortFlow of(Short ... object) {
        FlowIterator$ArrayIterator flowIterator$ArrayIterator = new FlowIterator$ArrayIterator(object);
        object = Flow.of(flowIterator$ArrayIterator);
        NumberFlow$ShortFlow numberFlow$ShortFlow = new NumberFlow$ShortFlow((Flow)object);
        return numberFlow$ShortFlow;
    }

    public static NumberFlow$ShortFlow of(short ... object) {
        FlowIterator$ShortArrayIterator flowIterator$ShortArrayIterator = new FlowIterator$ShortArrayIterator((short)object);
        object = Flow.of(flowIterator$ShortArrayIterator);
        NumberFlow$ShortFlow numberFlow$ShortFlow = new NumberFlow$ShortFlow((Flow)object);
        return numberFlow$ShortFlow;
    }

    public static NumberFlow$DoubleFlow range(double d10, double d11) {
        return Flow.range(d10, d11, 1.0);
    }

    public static NumberFlow$DoubleFlow range(double d10, double d11, double d12) {
        Object object = d10;
        Double d13 = d11;
        Double d14 = d12;
        FlowIterator$DoubleRangeIterator flowIterator$DoubleRangeIterator = new FlowIterator$DoubleRangeIterator((Double)object, d13, d14);
        object = Flow.of(flowIterator$DoubleRangeIterator);
        NumberFlow$DoubleFlow numberFlow$DoubleFlow = new NumberFlow$DoubleFlow((Flow)object);
        return numberFlow$DoubleFlow;
    }

    public static NumberFlow$IntFlow range(int n10, int n11) {
        return Flow.range(n10, n11, 1);
    }

    public static NumberFlow$IntFlow range(int n10, int n11, int n12) {
        Object object = n10;
        Integer n13 = n11;
        Integer n14 = n12;
        FlowIterator$IntRangeIterator flowIterator$IntRangeIterator = new FlowIterator$IntRangeIterator((Integer)object, n13, n14);
        object = Flow.of(flowIterator$IntRangeIterator);
        NumberFlow$IntFlow numberFlow$IntFlow = new NumberFlow$IntFlow((Flow)object);
        return numberFlow$IntFlow;
    }

    public boolean any() {
        int n10 = 1;
        Batch$Limit batch$Limit = new Batch$Limit(n10);
        this.nextFlow(batch$Limit);
        this.evaluate();
        return (batch$Limit.output().isEmpty() ^ n10) != 0;
    }

    public boolean any(Filter filter) {
        return this.filter(filter).any();
    }

    public Flow chunk(int n10) {
        Batch$Chunk batch$Chunk = new Batch$Chunk(n10);
        return this.nextFlow(batch$Chunk);
    }

    public Flow chunkCollect(int n10) {
        Flow flow = this.chunk(n10);
        Flow$3 flow$3 = new Flow$3(this);
        return flow.collect(flow$3);
    }

    public Flow collect(Collect collect) {
        return this.nextFlow(collect);
    }

    public int count() {
        int[] nArray = new int[1];
        Flow$9 flow$9 = new Flow$9(this, nArray);
        this.each(flow$9);
        return nArray[0];
    }

    public void cowork(int n10, Closure$IClosure1V closure$IClosure1V) {
        List list = this.toList();
        int n11 = list == null ? 0 : list.size();
        Flow$6 flow$6 = new Flow$6(this, n11, list);
        CoworkerThread.produceWork(flow$6).consumeWork(closure$IClosure1V).threadCount(n10).start();
    }

    public void cowork(Closure$IClosure1V closure$IClosure1V) {
        this.cowork(5, closure$IClosure1V);
    }

    public Flow distinct() {
        Flow$2 flow$2 = new Flow$2(this);
        return this.nextFlow(flow$2);
    }

    public void each(Each each) {
        this.nextFlow(each);
        this.evaluate();
    }

    public void evaluate() {
        FlowIterator flowIterator = this.iterator;
        this.evaluate(flowIterator, 0);
    }

    public Flow filter(Filter filter) {
        return this.nextFlow(filter);
    }

    public Optional first() {
        int n10 = 1;
        Object object = new Batch$Limit(n10);
        this.nextFlow((Function)object);
        this.evaluate();
        object = ((Batch)object).output();
        boolean bl2 = ((AbstractCollection)object).isEmpty();
        object = bl2 ? null : ((LinkedList)object).getFirst();
        Optional optional = new Optional(object);
        return optional;
    }

    public Object inject(Inject inject) {
        return this.inject(null, inject);
    }

    public Object inject(Object object, Inject inject) {
        Object[] objectArray = new Object[]{object};
        object = new Flow$10(this, objectArray, inject);
        this.each((Each)object);
        return objectArray[0];
    }

    public Flow jumble() {
        Flow flow = new Flow();
        Flow$5 flow$5 = new Flow$5(this, this);
        flow.iterator = flow$5;
        return flow;
    }

    public Optional last() {
        Object object = new Batch$Limit();
        this.nextFlow((Function)object);
        this.evaluate();
        object = ((Batch)object).output();
        boolean bl2 = ((AbstractCollection)object).isEmpty();
        object = bl2 ? null : ((LinkedList)object).getLast();
        Optional optional = new Optional(object);
        return optional;
    }

    public Flow limit(int n10) {
        if (n10 < 0) {
            return this;
        }
        Batch$Limit batch$Limit = new Batch$Limit(n10);
        return this.nextFlow(batch$Limit);
    }

    public Flow map(Map map) {
        return this.nextFlow(map);
    }

    public Flow peek(Peek peek) {
        return this.nextFlow(peek);
    }

    public Flow skip(int n10) {
        if (n10 < 0) {
            return this;
        }
        Batch$Skip batch$Skip = new Batch$Skip(n10);
        return this.nextFlow(batch$Skip);
    }

    public Flow sort() {
        return this.sort(null);
    }

    public Flow sort(Comparator comparator) {
        Flow flow = new Flow();
        Flow$4 flow$4 = new Flow$4(this, this, comparator);
        flow.iterator = flow$4;
        return flow;
    }

    public Object[] toArray() {
        return this.toList().toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.toList().toArray(objectArray);
    }

    public List toList() {
        LinkedList linkedList = new LinkedList();
        Flow$8 flow$8 = new Flow$8(this, linkedList);
        this.each(flow$8);
        return linkedList;
    }

    public java.util.Map toMap(MapMaker mapMaker) {
        HashMap hashMap = new HashMap();
        Flow$11 flow$11 = new Flow$11(this, mapMaker, hashMap);
        this.each(flow$11);
        return hashMap;
    }

    public Set toSet() {
        HashSet hashSet = new HashSet();
        Flow$7 flow$7 = new Flow$7(this, hashSet);
        this.each(flow$7);
        return hashSet;
    }
}

