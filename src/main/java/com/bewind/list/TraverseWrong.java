package com.bewind.list;

import java.util.*;

// 嵌套迭代误区
public class TraverseWrong {
    enum Suit {CLUB, DIAMOND, HEART, SPADE}

    enum Rank {ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN}

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    public static void main(String[] args) {
        // 嵌套迭代误区
//        nestWrong();

        // 错误示例，打印一对骰子所有可能滚法
//        printDice();

        // ✅推荐做法
        printDiceForeach();

        // 为什么 for 循环比 while 循环更好
        testWhileLoop();
    }

    public static void printDiceForeach() {
        enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}
        Collection<Face> faces = Arrays.asList(Face.values());
        for (Face face1 : faces) {
            for (Face face2 : faces) {
                System.out.println(face1 + " " + face2);
            }
        }
    }

    public static void testWhileLoop() {
        Iterator<Suit> i = suits.iterator();
        while (i.hasNext()) {
            Suit suit = i.next();
            System.out.println(suit);
        }

        Iterator<Suit> j = suits.iterator();
        // ❌容易在复制粘贴的时候出错
        while (i.hasNext()) {
            Suit suit = i.next();
            System.out.println(suit);
        }
    }

    public static void nestWrong() {
        List<Card> deck = new ArrayList<>();

        // java.util.NoSuchElementException
        /*
         * 问题在于，在迭代器上对外部的集合(suits)调用了太多次next方法。它应该从外部的循环进行调用，以便每种花色调用一次，
         * 但它却是从内部循环调用，因此每张牌调用一次。在用完所有花色之后，循环就会抛出 NoSuchElementException 异常。
         */
//        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
//            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
//                // ❌
//                deck.add(new Card(i.next(), j.next()));
//            }
//        }

        // 修正
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit next = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(next, j.next()));
            }
        }
        for (Card card : deck) {
            System.out.println(card.rank + " of " + card.suit);
        }
    }

    // 与上面同样的bug
    public static void printDice() {
        enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}
        Collection<Face> faces = Arrays.asList(Face.values());
//        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
//            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
//                System.out.println(i.next() + " " + j.next());
//            }
//        }

        // 修正
        for (Iterator<Face> i = faces.iterator(); i.hasNext(); ) {
            // ⚠️注意
            Face first = i.next();
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(first + " " + j.next());
            }
        }
    }

}

class Card {
    TraverseWrong.Suit suit;
    TraverseWrong.Rank rank;

    public Card(TraverseWrong.Suit suit, TraverseWrong.Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}


