package by.bsu.args.filter;

import by.bsu.args.exception.ArrayException;

public class StringFilter {
    public int filterInt(String str) throws ArrayException {
        String validStr;
        if (str.matches("\\d+")){
            validStr = str;
            int n = Integer.parseInt(validStr);
            return n;
        }else{
            throw new ArrayException("Input info isn't correct!");
        }
    }
}
