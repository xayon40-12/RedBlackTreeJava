package com.xayon40_12.app;

// ================= Color ===============

sealed interface Color permits Red, Black {}

record Red() implements Color {}

record Black() implements Color {}

// ================= Num ===============

sealed interface Num permits Z, S {}

record Z() implements Num {}

record S<N extends Num>() implements Num {}

// ================= Node ===============

sealed interface Node<C extends Color, N extends Num, A extends Comparable<A>> permits Leaf, B, R {}

record Leaf<A extends Comparable<A>>() implements Node<Black, S<Z>, A> {}

record B<
        N extends Num,
        A extends Comparable<A>,
        CL extends Color,
        NL extends Node<CL, N, A>,
        CR extends Color,
        NR extends Node<CR, N, A>>(
    NL l, A a, NR r) implements Node<Black, S<N>, A> {}

record R<
        N extends Num,
        A extends Comparable<A>,
        NL extends Node<Black, N, A>,
        NR extends Node<Black, N, A>>(
    NL l, A a, NR r) implements Node<Red, N, A> {}

// ================= CNode ===============

sealed interface CNode<M extends Num, C extends Color, N extends Num, A extends Comparable<A>>
    permits Root, CBL, CBR, CRL, CRR {}

record Root<N extends Num, A extends Comparable<A>>() implements CNode<N, Black, N, A> {}

record CBL<N extends Num, A extends Comparable<A>>() implements CNode {}

record CBR<N extends Num, A extends Comparable<A>>() implements CNode {}

record CRL<N extends Num, A extends Comparable<A>>() implements CNode {}

record CRR<N extends Num, A extends Comparable<A>>() implements CNode {}

// ================= Node ===============

record RedBlackTree<A extends Comparable<A>>(Node<Black, ? extends Num, A> n) {
  public static <A extends Comparable<A>> RedBlackTree<A> empty() {
    return new RedBlackTree<A>(new Leaf<A>());
  }
}

/** Hello world! */
public class App {
  public static void main(String[] args) {
    Color c = new Red();

    RedBlackTree<Integer> r = RedBlackTree.empty();

    Node<Black, S<S<Z>>, Integer> n = new B<>(new Leaf<>(), 3, new Leaf<>());
    RedBlackTree<Integer> r2 = new RedBlackTree<>(n);
    System.out.println("%s\n%s\n%s".formatted(c.toString(), r.toString(), r2.toString()));
  }
}
