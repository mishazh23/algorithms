package by.bsu.args.action;

import by.bsu.args.entity.Averages;
import by.bsu.args.entity.HashChain;
import by.bsu.args.intrface.HashFuncWithConst;
import by.bsu.args.intrface.hashFunc;

import java.util.List;

public class Output {
    public static void outputInfo(int size, List<Integer[]> arr, hashFunc func) throws Exception{
        HashChain hashChains = new HashChain(size, func);
        for (int i = 0; i < size; i++) {
            hashChains.put(arr.get(i)[0], 10);
        }
        System.out.println("Average chain length: " + Averages.getAverageChainLength(hashChains));
        System.out.println("Medium chain length: " + Averages.getMediumChainLength(hashChains));
    }
    public static void outputInfoWithConstant(int size, List<Integer[]> arr, HashFuncWithConst func, Double constant) throws Exception{
        HashChain hashChains = new HashChain(size, func, constant);
        for (int i = 0; i < size; i++) {
            hashChains.put(arr.get(i)[0], 10);
        }
        System.out.println("Average chain length: " + Averages.getAverageChainLength(hashChains));
        System.out.println("Medium chain length: " + Averages.getMediumChainLength(hashChains));
    }
}
