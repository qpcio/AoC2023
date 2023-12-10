package Day8;

import java.util.Objects;

public class Node {
    String name;
    String left;
    String right;

    public Node(String s){
           s=s.replace(" ","").replace("(","").replace(")","");
           String split1[] = s.split("=");
           this.name = split1[0];
           String split2[] = split1[1].split(",");
           this.left = split2[0];
           this.right = split2[1];
    }

    public Node(String name, String b){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
