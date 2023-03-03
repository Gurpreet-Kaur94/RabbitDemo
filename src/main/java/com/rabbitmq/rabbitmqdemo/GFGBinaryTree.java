package com.rabbitmq.rabbitmqdemo;

public class GFGBinaryTree {

        // Tree Node
        static class Node {
            int data;

            Node left, right, parent;

            Node(int data)
            {
                this.data = data;
                this.left = null;
                this.right = null;
                this.parent = null;
            }
        }


        public static int getResult(Node node)
        {
            if(node == null || node.parent == null)
                return 0;
            Node parent = node.parent;
            int count = 1;
            int h = height(node);
            if(parent.left == node) {
                count +=  height(parent.right);
                System.out.println(node.data + " right  "  + count + " " + (h-1));
            } else {
                count +=  height(parent.left);
                System.out.println(node.data + " left "  + count + " " + (h -1 ));
            }

            return  Integer.max(h-1 + count  , getResult(parent));
        }



        public static int height(Node root) {
            if(root == null) {
                return 0;
            }
            return 1 + (Integer.max(height(root.left), height(root.right)));

        }

        static void getParent(Node node, Node parent) {
            if(node == null) {
                return;
            }
            node.parent = parent;
            parent = node;

            getParent(node.left, parent);
            getParent(node.right, parent);
        }

        static Node getNode(Node node, int target) {
            if(node == null ) {
                return null;
            }
            if(node.data == target) {
              //  System.out.println("found " + node.data);
                return node;
            }
            Node left = getNode(node.left, target);
            if(left != null) {
                return left;
            }

            return getNode(node.right, target);
        }
        // To store the result

        // Driver Code
        public static void main(String args[])
        {

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.left.left.left = new Node(8);
            root.left.right.left = new Node(9);
            root.left.right.right = new Node(10);
            root.left.right.left.left = new Node(11);


          /*  root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.left.right.left = new Node(7);
            root.left.right.right = new Node(8);
            root.right.right = new Node(6);
            root.right.right.right = new Node(9);
            root.right.right.right.right = new Node(10);
*/
            int target = 11;

            getParent(root, null);
            Node fireNode = getNode(root, target);
            int h = height(fireNode);
            int res = getResult(fireNode);
         //   System.out.println(fireNode.data + " parent  " + fireNode.parent.data);


            System.out.println(res-(h-1));
        }
}
