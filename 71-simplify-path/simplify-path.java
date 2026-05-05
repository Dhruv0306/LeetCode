import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        
        String[] components = path.split("/");
        
        for (String directory : components) {
            if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else if (!directory.equals(".") && !directory.isEmpty()) {
                stack.push(directory);
            }
        }
        
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        
        // Deque.pollLast() allows us to build the string from bottom to top
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }
        
        return result.toString();
    }
}
