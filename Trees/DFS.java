// Three types of traversal for DFS: pre-order, in-order, and post-order

// PRE ORDER TRAVERSAL
// root --> left --> right
public static void preOrder(TreeNode root) {
    if (root == null)
        return;

    System.out.println(root.val);

    preOrder(root.left);

    preOrder(root.right);
}

// IN ORDER TRAVERSAL
// left --> root --> right
public static void inOrder(TreeNode root) {
    if (root == null)
        return;

    inOrder(root.left);

    System.out.println(root.val);

    inOrder(root.right);
}

// POST ORDER TRAVERSAL
// left --> right --> root
public static void postOrder(TreeNode root) {
    if (root == null)
        return;

    postOrder(root.left);

    postOrder(root.right);

    System.out.println(root.val);
}