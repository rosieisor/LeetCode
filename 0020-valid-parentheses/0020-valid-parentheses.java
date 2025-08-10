import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        for(int i=0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                case ')':
                    if (!deque.isEmpty() && deque.getLast() == '(') { 
                        deque.pollLast(); 
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!deque.isEmpty() && deque.getLast() == '[') { 
                        deque.pollLast(); 
                    } else {
                        return false;
                    }
                    break; 
                case '}':
                    if (!deque.isEmpty() && deque.getLast() == '{') { 
                        deque.pollLast(); 
                    } else {
                        return false;
                    }
                    break; 
                default:
                    deque.offer(s.charAt(i));
                    break;
            }
        }

        if (deque.isEmpty()) {
            return true;
        } 

        return false;
    }
}