
import java.util.ArrayList; // Imports ArrayList to store traversal results dynamically.
import java.util.Arrays;    // Imports Arrays to compare two arrays using Arrays.equals().
import java.util.List;      // Imports List interface for storing traversal results.

public class Q1Test {

    // Represents one node in a Binary Search Tree (BST).
    private static class Node {

        int val;             // Stores the integer value of this node.
        Node left, right;    // References to the left and right child nodes.

        // Constructor: creates a node with the given value.
        Node(int val) {
            this.val = val;
        }
    }

    // Inserts a new value into the Binary Search Tree.
    private static Node insert(Node root, int v) {

        // If the current position is empty, create a new node here.
        if (root == null) return new Node(v);

        // If the new value is smaller, insert it into the left subtree.
        if (v < root.val)
            root.left = insert(root.left, v);

        // Otherwise, insert it into the right subtree.
        // This also means duplicate values are placed on the right.
        else
            root.right = insert(root.right, v);

        // Return the root so the tree structure is maintained.
        return root;
    }

    // Performs an Inorder traversal: Left -> Root -> Right.
    private static void inorder(Node n, List<Integer> out) {

        // Base case: stop when there is no node to visit.
        if (n == null) return;

        // First, visit all nodes in the left subtree.
        inorder(n.left, out);

        // Next, visit and store the current node's value.
        out.add(n.val);

        // Finally, visit all nodes in the right subtree.
        inorder(n.right, out);
    }

    // Performs a Preorder traversal: Root -> Left -> Right.
    private static void preorder(Node n, List<Integer> out) {

        // Base case: stop when there is no node to visit.
        if (n == null) return;

        // First, visit and store the current node's value.
        out.add(n.val);

        // Next, visit all nodes in the left subtree.
        preorder(n.left, out);

        // Finally, visit all nodes in the right subtree.
        preorder(n.right, out);
    }

    // Performs a Postorder traversal: Left -> Right -> Root.
    private static void postorder(Node n, List<Integer> out) {

        // Base case: stop when there is no node to visit.
        if (n == null) return;

        // First, visit all nodes in the left subtree.
        postorder(n.left, out);

        // Next, visit all nodes in the right subtree.
        postorder(n.right, out);

        // Finally, visit and store the current node's value.
        postorderValue(n, out);
    }

    // Helper method to add the current node's value during Postorder.
    private static void postorderValue(Node n, List<Integer> out) {
        out.add(n.val);
    }

    // Converts a string of numbers separated by hyphens into an integer array.
    // Example: "10-20-30" becomes [10, 20, 30].
    private static int[] parse(String s) {

        // Splits the input string wherever a hyphen appears.
        String[] parts = s.split("-");

        // Creates an integer array with the same number of elements.
        int[] arr = new int[parts.length];

        // Converts each string element into an integer.
        for (int i = 0; i < parts.length; i++)
            arr[i] = Integer.parseInt(parts[i].trim());

        // Returns the converted integer array.
        return arr;
    }

    // Converts a List of Integers into a normal integer array.
    private static int[] toArray(List<Integer> list) {

        // Creates an integer array with the same size as the list.
        int[] arr = new int[list.size()];

        // Copies each element from the list into the array.
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);

        // Returns the converted array.
        return arr;
    }

    // Main method: runs the provided test cases.
    public static void main(String[] args) {

        // Stores the result returned by verify().
        // The three variables store the three traversal sequences.
        String result, traversal1, traversal2, traversal3;

        // -------------------- TEST CASE 1 --------------------

        traversal1 = "1-2";
        traversal2 = "2-1-3";
        traversal3 = "1-3-2";

        // Checks whether the three sequences represent valid traversals
        // of the same Binary Search Tree.
        result = verify(traversal1, traversal2, traversal3);

        // Displays the three input traversal sequences.
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);

        // Displays the expected output for comparison.
        System.out.println("Expected Result : Invalid traversals");

        // Displays the actual result returned by verify().
        System.out.println(" Actual Result : " + result);
        System.out.println();

        // -------------------- TEST CASE 2 --------------------

        traversal1 = "1-2-3";
        traversal2 = "2-1-3";
        traversal3 = "1-3-2";

        result = verify(traversal1, traversal2, traversal3);

        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);

        System.out.println(
            "Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder");

        System.out.println(" Actual Result : " + result);
        System.out.println();

        // -------------------- TEST CASE 3 --------------------

        traversal1 = "1-2-3";
        traversal2 = "3-2-1";
        traversal3 = "2-3-1";

        result = verify(traversal1, traversal2, traversal3);

        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);

        System.out.println("Expected Result : Invalid traversals");

        System.out.println(" Actual Result : " + result);
        System.out.println();

        // -------------------- TEST CASE 4 --------------------

        traversal1 = "3-1-2-5-4";
        traversal2 = "2-1-4-5-3";
        traversal3 = "1-2-3-4-5";

        result = verify(traversal1, traversal2, traversal3);

        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);

        System.out.println(
            "Expected Result : Traversal 1 - Preorder, Traversal 2 - Postorder, Traversal 3 - Inorder");

        System.out.println(" Actual Result : " + result);
        System.out.println();

        // -------------------- TEST CASE 5 --------------------

        traversal1 = "10-20-30-40-50";
        traversal2 = "20-10-30-40-50";
        traversal3 = "10-50-40-30-20";

        result = verify(traversal1, traversal2, traversal3);

        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);

        System.out.println(
            "Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder");

        System.out.println(" Actual Result : " + result);
        System.out.println();
    }

    // -------------------- VERIFY METHOD --------------------

    // Determines which traversal order belongs to each of the three inputs.
    // Returns the correct traversal names if all three are valid.
    // Otherwise, returns "Invalid traversals".
    public static String verify(String traversal1, String traversal2, String traversal3) {

        // Converts all three input strings into integer arrays.
        // given[0] = Traversal 1
        // given[1] = Traversal 2
        // given[2] = Traversal 3
        int[][] given = {
            parse(traversal1),
            parse(traversal2),
            parse(traversal3)
        };

        // Stores the names corresponding to the traversal indexes.
        // Index 0 = Inorder
        // Index 1 = Preorder
        // Index 2 = Postorder
        String[] names = { "Inorder", "Preorder", "Postorder" };

        // Lists all six possible ways to assign three traversal types
        // to the three input sequences.
        //
        // Each number represents a traversal type:
        // 0 = Inorder
        // 1 = Preorder
        // 2 = Postorder
        //
        // For example, {0, 1, 2} means:
        // Traversal 1 = Inorder
        // Traversal 2 = Preorder
        // Traversal 3 = Postorder
        int[][] perms = {
            {0, 1, 2},
            {0, 2, 1},
            {1, 0, 2},
            {1, 2, 0},
            {2, 0, 1},
            {2, 1, 0}
        };

        // Tries every possible assignment of traversal types.
        for (int[] perm : perms) {

            // Stores the index of the input assumed to be Preorder.
            // We need Preorder because it can be used to reconstruct
            // the Binary Search Tree by inserting its values in order.
            int preIdx = -1;

            // Searches the current permutation for traversal type 1 (Preorder).
            for (int i = 0; i < 3; i++) {

                // If the traversal type is 1, this input is Preorder.
                if (perm[i] == 1)
                    preIdx = i;
            }

            // Starts with an empty Binary Search Tree.
            Node root = null;

            // Inserts the Preorder sequence into the BST.
            // The insertion order determines the structure of the tree.
            for (int v : given[preIdx]) {
                root = insert(root, v);
            }

            // Creates three lists to store the generated traversals.
            List<Integer> in = new ArrayList<>();
            List<Integer> pre = new ArrayList<>();
            List<Integer> post = new ArrayList<>();

            // Generates the Inorder traversal of the constructed BST.
            inorder(root, in);

            // Generates the Preorder traversal of the constructed BST.
            preorder(root, pre);

            // Generates the Postorder traversal of the constructed BST.
            postorder(root, post);

            // Converts the three generated traversal lists into arrays.
            //
            // actual[0] = Generated Inorder
            // actual[1] = Generated Preorder
            // actual[2] = Generated Postorder
            int[][] actual = {
                toArray(in),
                toArray(pre),
                toArray(post)
            };

            // Initially assumes that all three input traversals are correct.
            boolean ok = true;

            // Compares each given traversal against its assigned
            // generated traversal from the constructed BST.
            for (int i = 0; i < 3; i++) {

                // Arrays.equals() checks whether both arrays contain
                // exactly the same elements in exactly the same order.
                //
                // If they are different, this permutation is incorrect.
                if (!Arrays.equals(given[i], actual[perm[i]])) {

                    // Marks the current permutation as invalid.
                    ok = false;

                    // No need to check the remaining traversals
                    // because one mismatch already makes it invalid.
                    break;
                }
            }

            // If all three given traversals match the generated traversals,
            // the current permutation is the correct assignment.
            if (ok) {

                // Returns the traversal type assigned to each input.
                return "Traversal 1 - " + names[perm[0]]
                    + ", Traversal 2 - " + names[perm[1]]
                    + ", Traversal 3 - " + names[perm[2]];
            }
        }

        // If none of the six possible assignments works,
        // the three input sequences cannot represent valid traversals
        // of the same Binary Search Tree.
        return "Invalid traversals";
    }
}
