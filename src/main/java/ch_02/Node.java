package ch_02;

class Node {
    private final char ch;
    private final Node left;
    private final Node right;

    private Node(char ch, Node left, Node right) {
        this.ch = ch;
        this.left = left;
        this.right = right;
    }

    public static Node of(char ch, Node left, Node right) {
        return new Node(ch, left, right);
    }

    public static Node of(char ch) {
        return new Node(ch, null, null);
    }


    public void deepWalk() {
        System.out.print(ch);

        if (left != null) {
            left.deepWalk();
        }

        if (right != null) {
            right.deepWalk();
        }
    }
}
