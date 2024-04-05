package ch_02;

public class Main {
    public static void main(String[] args) {
        Node tree = Node.of('a',
                Node.of('b',
                        Node.of('d',
                                Node.of('h', Node.of('p'), Node.of('q')),
                                Node.of('i', Node.of('r'), Node.of('s'))
                        ),
                        Node.of('e',
                                Node.of('j', Node.of('t'), Node.of('u')),
                                Node.of('k', Node.of('v'), Node.of('w'))
                        )
                ), Node.of('c',
                        Node.of('f',
                                Node.of('l',Node.of('x'), Node.of('y')),
                                Node.of('m', Node.of('z' ), null)
                        ),
                        Node.of('g', Node.of('n' ), Node.of('o'))
                )
        );

        System.out.print("Deep walk: ");
        tree.deepWalk();
        System.out.println();

        System.out.print("Wide walk: ");
        tree.wideWalk();
        System.out.println();
    }
}
