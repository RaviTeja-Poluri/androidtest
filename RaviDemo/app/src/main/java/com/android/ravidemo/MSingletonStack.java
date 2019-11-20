package com.android.ravidemo;

import java.util.Stack;

public class MSingletonStack {
    private static final Stack<String> stack = new Stack<>();

    static String push(String string) {
        return stack.push(string);
    }

    static String pop() {
        return stack.pop();
    }

    static String peek() {
        return stack.peek();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    void clearAll() {
        stack.clear();
    }
}
