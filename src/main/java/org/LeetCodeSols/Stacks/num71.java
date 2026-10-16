package org.LeetCodeSols.Stacks;

import java.util.Stack;

/***
 * splitting the path on "/" breaks it into every segment between slashes, with empty strings showing up wherever there was a double slash or the leading slash
 * an empty segment or a lone "." doesn't move you anywhere, so both just get skipped
 * ".." means stepping back up a directory, which is exactly what popping the stack does, as long as there's still something on it to pop
 * anything else is a real directory name, so it gets pushed onto the stack to become part of the current path
 * by the time every segment has been processed, the stack holds only the directories still standing after all the "." and ".." segments cancelled out, in order from root to deepest
 * joining those directories back together with "/" and adding the leading slash turns the stack into the simplified absolute path
 */

public class num71 {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        return "/" + String.join("/", stack);
    }
}
