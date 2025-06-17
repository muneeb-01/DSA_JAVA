import java.util.*;
public class main {
    public static void main(String[] args) {
        String input = "{[(a+b]*c)}";
        List<String> result = removeInvalidBrackets(input);
        for (String s : result) {
            System.out.println(isValid(s));
        }
    }
    public static List<String> removeInvalidBrackets(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() ==0 ) return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        boolean found = false;
        queue.offer(s);
        set.add(s);

        while(!queue.isEmpty()){
            String str = queue.poll();
            if(isValid(str)) {
                result.add(str);
                found = true;
            }

            if(found) continue;

            for(int i = 0; i < str.length(); i++){
                if(mapping(str.charAt(i))==0) continue;

                String next = str.substring(0,i)+str.substring(i+1);
                if(!set.contains(next)) {
                    queue.offer(next);
                    set.add(next);
                };
            }

        }

        return result;
    }
    static boolean isValid(String str) {
        Stack<Integer> st = new Stack<>();
        if (str.isEmpty()) return true;

        for(char c : str.toCharArray()) {
            int map = mapping(c);

            if(map > 0){
                st.push(map);
            }else if(map < 0){
                if(st.isEmpty() || st.peek() + map != 0){
                    return false;
                }
                st.pop();
            }
        }

        return st.isEmpty();
    }
    static void isValidWithPositions(String str){
        class BracketwithPosition{
            int type, position;
            public BracketwithPosition(int type, int position) {
                this.type = type;
                this.position = position;
            }
        }
        Stack<BracketwithPosition> st = new Stack<>();
        List<BracketwithPosition> list = new ArrayList<>();
        for (int i = 0; i< str.length(); i++) {
            char c  = str.charAt(i);
            int map = mapping(c);

            if(map> 0){
                st.push(new BracketwithPosition(map, i));
            }
            else if(map < 0){

                if(st.isEmpty() || ((st.peek().type + map) != 0)){
                    list.add(new BracketwithPosition(map, i));
                }
                else{
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()){
            list.add(new BracketwithPosition(st.peek().type, st.peek().position));
            st.pop();
        }

        for(BracketwithPosition b : list){
            char map = mapBack(b.type);
            System.out.println(map + " " + b.position);
        }

    }
    static char mapBack(int i){
        switch(i){
            case 1: return '(';
            case -1: return ')';
            case 2: return '{';
            case -2: return '}';
            case 3: return '[';
            case -3: return ']';
            default: return ' ';
        }

    }
    static int mapping(char c){
        switch (c){
            case '(': return 1;
            case ')': return -1;
            case '{': return 2;
            case '}': return -2;
            case '[': return 3;
            case ']': return -3;
            default: return 0;
        }
    }
}

