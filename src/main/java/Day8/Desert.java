package Day8;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Desert {
    List<Node> map = new ArrayList<>();
    String directions;
    List<Node> currentNodes = new ArrayList<>();


    public int task1() {
        int result = 0;
        Node currentNode = new Node("AAA = ( AAA, AAA )");
        currentNode = map.get(map.indexOf(currentNode));
        while (!currentNode.name.equals("ZZZ")) {
            for (int i = 0; i < directions.length(); i++) {
                char d = directions.charAt(i);
                if (d == 'L') {
                    Node directionNode = new Node(currentNode.left, "xxx");
                    currentNode = map.get(map.indexOf(directionNode));
                } else {
                    Node directionNode = new Node(currentNode.right, "xxx");
                    currentNode = map.get(map.indexOf(directionNode));
                }
                result++;
            }
        }

        return result;
    }

    public long task2() {
        long result = 0;
        int[] partials =  {0,0,0,0,0,0 };
        while (!areDone()) {
            for (int i = 0; i < directions.length(); i++) {
                char d = directions.charAt(i);
                List<Node> nextNodes = new ArrayList<>();
                for (Node n : currentNodes) {
                        if(d=='L'){
                            nextNodes.add(map.get(map.indexOf(new Node(n.left,""))));
                        }else{
                            nextNodes.add(map.get(map.indexOf(new Node(n.right,""))));
                        }
                }
                Collections.copy(currentNodes,nextNodes);
                result++;
            }
           // System.out.println("Did rotation, ended on: "+currentNodes+" after "+result+" steps");
            for(int i=0;i<currentNodes.size();i++){
                  if(currentNodes.get(i).name.charAt(2)=='Z' && partials[i]==0)  partials[i]=(int)result;
            }
            if(partials[0]!=0 && partials[1]!=0 &&partials[2]!=0 &&
                    partials[3]!=0 &&partials[4]!=0 &&partials[5]!=0){
                      return(lcm(partials[0],lcm(partials[1],lcm(partials[2],
                              lcm(partials[3],lcm(partials[4],partials[5]))))));
            }
        }
        System.out.println(partials);
        
        return result;
    }

    private long lcm(long a1, long a2){
        long absHigherNumber = Math.max(a1, a2);
        long absLowerNumber = Math.min(a1, a2);
        long lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    private boolean areDone() {
        for (Node n : currentNodes) {
            if (n.name.charAt(2) != 'Z') return false;
        }
        return true;
    }

    public Desert(String filePath) {
        try {
            File input = new File(filePath);
            Scanner scanner = new Scanner(input);
            this.directions = scanner.nextLine();
            scanner.nextLine(); //empty line
            while (scanner.hasNextLine()) {
                map.add(new Node(scanner.nextLine()));
            }
            for (Node n : map) {
                if (n.name.charAt(2) == 'A') {
                    currentNodes.add(n);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
