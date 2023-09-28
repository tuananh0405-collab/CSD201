package TreeN;

import java.util.Map;
import java.util.TreeMap;

public class TreeNode {
    private String name;
    private Map<String, TreeNode> children;

    public TreeNode(String name) {
        this.name = name;
        this.children = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.put(child.getName(), child);
    }
}
