import java.util.*;

public class Node {
    //节点名字
    private String name;
    //节点属性集合
    private Map<String, String> attrs = new HashMap<>();
    //父节点
    private Node parNode;
    //子节点集合
    private List<Node> sonNodes;
    //当前节点文本::只有是文本节点才会打印
    private String text;

    public String getText() {
        return text == null ? "" : text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Node(String name, Node parNode, String text) {
        this.parNode = parNode;
        sonNodes = new ArrayList<>();
        this.name = name;
        this.text = text;
    }

    public Node(String name, Node parNode) {
        this(name, parNode, "");
    }

    public Node(String name) {
        sonNodes = new ArrayList<>();
        this.name = name;
    }

    //添加属性
    public void addAttr(String name, String value) {
        attrs.put(name, value);
    }

    //删除属性
    public void delAttr(String name) {
        attrs.remove(name);
    }

    //添加子节点
    public void addSonNode(Node node) {
        node.setParNode(this);
        sonNodes.add(node);
    }

    //删除子节点
    public boolean delSonNode(Node node) {
        return sonNodes.remove(node);
    }

    //根据节点名字返回删除节点个数
    public int delSonNodeByName(Node sonNode) {
        int i = 0;
        Iterator<Node> iterator = this.sonNodes.iterator();
        while ( iterator.hasNext() ) {
            Node next = iterator.next();
            if ( next.getName().equals(sonNode.getName()) ) {
                i++;
                iterator.remove();
            }
        }
        return i;
    }

    //模糊删除返回删除节点个数
    public int delSonNodeLikeName(Node sonNode, String name) {
        int i = 0;
        Iterator<Node> iterator = this.sonNodes.iterator();
        while ( iterator.hasNext() ) {
            Node next = iterator.next();
            if ( next.getName().indexOf(name) != -1 ) {
                i++;
                iterator.remove();
            }
        }
        return i;
    }

    //根据子节点名字取出子节点
    public List<Node> getSonNodeByNames(String name) {
        List<Node> res = new ArrayList<>();
        for ( Node sonNode : this.sonNodes ) {
            if ( sonNode.getName().equals(name) )
                res.add(sonNode);
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    public Node getParNode() {
        return parNode;
    }

    public void setParNode(Node parNode) {
        this.parNode = parNode;
    }

    public List<Node> getSonNodes() {
        return sonNodes;
    }

}
