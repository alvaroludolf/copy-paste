package br.com.loom.copypaste.random;
//package com.codility;

import java.util.ArrayList;
import java.util.List;

public class FindFamily {

    private List<Node> nodes = new ArrayList<>();

    public FindFamily() {
        Node node1 = new Node(1L, null);
        nodes.add(node1);
        Node node2 = new Node(8L, node1);
        nodes.add(node2);
        Node node3 = new Node(2L, node1);
        nodes.add(node3);
        Node node4 = new Node(3L, node1);
        nodes.add(node4);
        Node node5 = new Node(5L, node2);
        nodes.add(node5);
        Node node6 = new Node(6L, node2);
        nodes.add(node6);
        Node node7 = new Node(9L, node3);
        nodes.add(node7);
        Node node8 = new Node(4L, node4);
        nodes.add(node8);
        Node node9 = new Node(7L, node5);
        nodes.add(node9);
        Node node10 = new Node(0L, node6);
        nodes.add(node10);
    }

    public static void main(String[] args) {
    }

    static class Node {
        public Long id;
        public Node parent;

        public Node(Long id, Node parent) {
            this.id = id;
            this.parent = parent;
        }
    }

}
