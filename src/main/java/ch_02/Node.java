package ch_02;

import java.util.LinkedList;
import java.util.Queue;

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

    public void wideWalk() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.ch);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
