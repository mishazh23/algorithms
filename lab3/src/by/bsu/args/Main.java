package by.bsu.args;

import by.bsu.args.action.SequenceCreator;
import by.bsu.args.entity.BinaryTree;
import by.bsu.args.exception.ArrayException;
import by.bsu.args.filter.StringFilter;
import by.bsu.args.reader.InfoReader;

public class Main {

    public static void main(String[] args) throws ArrayException {
        System.out.println("Enter the number of values in the sequence:");
        InfoReader reader = new InfoReader();
        String str = reader.readString(System.in);
        StringFilter filter = new StringFilter();
        int size = filter.filterInt(str);
        int p = 1000;

        int[] array = SequenceCreator.SequenceCreator(size, p);
       // int[] array = {20, 8, 22, 4, 12, 10, 14, 3, 2, 1};
        BinaryTree tree = new BinaryTree();
        tree = tree.createTree(array);

        System.out.println("\n" + "In order:" );
        tree.traverseInOrder(tree.root);

        System.out.println("\n\n" + "In decrease order:" );
        tree.traverseInDecreaseOrder(tree.root);

        if(BinaryTree.isTreeBalanced(tree.root)){
            System.out.println("\n" + "The tree is balanced.");
        }else {
            System.out.println("\n" + "The tree isn't balanced.");
            BinaryTree.BalanceTree();
            if (BinaryTree.isTreeBalanced(tree.root)) {
                System.out.println("\n" + "The tree is balanced.");
            } else {
                System.out.println("\n" + "Function is not working!");
            }
        }
    }
}
