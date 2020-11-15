package by.bsu.args.entity;

public class BinaryTree {
    public static Node root;
    static int countElement = 0;
    public BinaryTree(){
        root = null;
    }
    public static void Insert(int value){
        if(root == null){
            root = new Node(value);
        }else{
            addNode(root, value);
        }
    }

    private static Node addNode(Node root, int value){
        if(root == null){
            root = new Node(value);
        }else{
            if(value <= root.value){
                root.left = addNode(root.left, value);
                root.lCount++;
            }else{
                root.right = addNode(root.right, value);
                root.rCount++;
            }
        }
        return root;
    }
    public BinaryTree createTree(int a[]){
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < a.length; i++){
            tree.Insert(a[i]);
        }
        return tree;
    }
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traverseInDecreaseOrder(Node node) {
        if (node != null) {
            traverseInDecreaseOrder(node.right);
            System.out.print(" " + node.value);
            traverseInDecreaseOrder(node.left);
        }
    }

    public static Node findNode(int value){
        return findNode(root, value);
    }

    private static Node findNode(Node root, int value){
        Node result = null;
        if(value == root.value){
            return root;
        }else{
            if( value < root.value && root.left != null){
                result = findNode(root.left, value);
            }else {
                if(root.right != null){
                    result = findNode(root.right, value);
                }
            }
        }
        return result;
    }
    public static int countNodes(Node root){
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static Node findKMin(Node root, int k){
        Node current = root;
        int count = k;
        while (current != null){
            int leftTreeSize = countNodes(current.left);
            if (leftTreeSize + 1 == count)
            {
                return current;
            }
            if (leftTreeSize < count)
            {
                current = current.right;
                count -= leftTreeSize + 1;
            }
            else
            {
                current = current.left;
            }
        }

        return new Node(-1);
    }

    public static boolean isTreeBalanced(Node root){
        return depth(root) != -1;
    }
    public static int depth(Node root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        if(left == -1){
            return -1;
        }

        int right = depth(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }
        return 1 + Math.max(left, right);
    }
    public static Node getParent(int value){
        Node parent = null;
        Node node = root;
        while (true){
            if(node == null){
                return null;
            }else{
                if(node.value == value){
                    return parent;
                }else{
                    parent = node;
                    node = value < node.value ? node.left : node.right;
                }
            }
        }
    }

    public static Node leftRotation(int value){
        Node parent = getParent(value);
        Node node = findNode(value);
        if(node == null || node.right == null){
            return null;
        }

        Node oldSubRoot = node;
        node = oldSubRoot.right;
        oldSubRoot.right = node.left;
        node.left = oldSubRoot;

        if(parent == null){
            root = node;
        }else{
            if(parent.value < node.value){
                parent.right = node;
            }else{
                parent.left = node;
            }
        }
        return node;
    }

    public static Node rightRotation(int value){
        Node parent = getParent(value);
        Node node = findNode(value);
        if(node == null || node.left == null){
            return null;
        }

        Node oldSubRoot = node;
        node = oldSubRoot.left;
        oldSubRoot.left = node.right;
        node.right = oldSubRoot;
        if(parent == null){
            root = node;
        }else{
            if(parent.value < node.value){
                parent.right = node;
            }else{
                parent.left = node;
            }
        }
        return node;
    }

    public static Node placeInRoot(int value, Node root){
        if(root == null || root.hasNoChild()){
            return null;
        }
        Node parent = getParent(value);
        Node node = findNode(value);
        while (parent != null && node != null && !node.hasDirectChild(root)){
            if(node.value < parent.value){
                node = rightRotation(parent.value);
            }else{
                node = leftRotation(parent.value);
            }
            parent = getParent(node.value);
            node = findNode(node.value);
        }
        return node;
    }


    public static void BalanceTree(){
        BalanceBinaryTree(root);
    }
    private static void BalanceBinaryTree(Node node){
        if (node == null) return;

        int count = countNodes(node);
        if(count <= 1) return;

        int mid = count / 2 == 0 ? count / 2 : count / 2 + 1;
        Node key = findKMin(node, mid);
        if(key.value != node.value){
            Node newSubTreeRoot = placeInRoot(key.value, node);

            BalanceBinaryTree(newSubTreeRoot.left);
            BalanceBinaryTree(newSubTreeRoot.right);
        }
    }
}
