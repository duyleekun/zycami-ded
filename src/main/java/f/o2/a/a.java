/*
 * Decompiled with CFR 0.151.
 */
package f.o2.a;

import f.h2.t.f0;
import f.n2.m;
import f.o2.a.a$a;
import f.o2.a.a$b;
import f.o2.a.a$c;
import f.o2.a.a$d;
import f.o2.a.a$e;
import f.x1.n;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class a {
    public static final m a(DoubleStream doubleStream) {
        f0.p(doubleStream, "$this$asSequence");
        a$d a$d = new a$d(doubleStream);
        return a$d;
    }

    public static final m b(IntStream intStream) {
        f0.p(intStream, "$this$asSequence");
        a$b a$b = new a$b(intStream);
        return a$b;
    }

    public static final m c(LongStream longStream) {
        f0.p(longStream, "$this$asSequence");
        a$c a$c = new a$c(longStream);
        return a$c;
    }

    public static final m d(Stream stream) {
        f0.p(stream, "$this$asSequence");
        a$a a$a = new a$a(stream);
        return a$a;
    }

    public static final Stream e(m object) {
        f0.p(object, "$this$asStream");
        a$e a$e = new a$e((m)object);
        object = StreamSupport.stream(a$e, 16, false);
        f0.o(object, "StreamSupport.stream({ S\u2026literator.ORDERED, false)");
        return object;
    }

    public static final List f(DoubleStream object) {
        f0.p(object, "$this$toList");
        object = object.toArray();
        f0.o(object, "toArray()");
        return n.p((double[])object);
    }

    public static final List g(IntStream object) {
        f0.p(object, "$this$toList");
        object = object.toArray();
        f0.o(object, "toArray()");
        return n.r((int[])object);
    }

    public static final List h(LongStream object) {
        f0.p(object, "$this$toList");
        object = object.toArray();
        f0.o(object, "toArray()");
        return n.s((long[])object);
    }

    public static final List i(Stream object) {
        f0.p(object, "$this$toList");
        Collector collector = Collectors.toList();
        object = object.collect(collector);
        f0.o(object, "collect(Collectors.toList<T>())");
        return (List)object;
    }
}

