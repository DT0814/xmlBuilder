import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class Xml {
    //xml编码格式 默认gbk
    private String encoding = "gbk";
    //xml版本 默认1.0
    private String version = "1.0";
    //xml根元素
    private Node inintNode;

    //初始化XML
    public Xml(Node inintNode) {
        this.inintNode = inintNode;
    }

    //获得当前xml编码
    public String getEncoding() {
        return encoding;
    }

    //设置当前xml编码
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    //获得当前xml版本
    public String getVersion() {
        return version;
    }

    //设置当前xml版本
    public void setVersion(String version) {
        this.version = version;
    }

    //获得当前xml根元素
    public Node getInintNode() {
        return inintNode;
    }

    //设置当前xml根元素
    public void setInintNode(Node inintNode) {
        this.inintNode = inintNode;
    }

    //打印当前xml到out输出流
    public void printXml(OutputStream out) throws IOException {
        String str = "<?xml version=\"" + version + "\" encoding=\"" + encoding + "\"?>";
        out.write(str.getBytes());
        out.write("\n".getBytes());
        printNode(inintNode, out, 0);

    }

    //打印node节点到out输出流
    public static void printNode(Node node, OutputStream out, Integer tabNum) throws IOException {
        //当前节点缩进级别
        String tabStr = "";
        if ( tabNum != null ) {
            for ( int i = 0; i < tabNum; i++ ) {
                tabStr += "  ";
            }
        }
        //节点开始字符串
        String str = "";
        //节点属性字符串
        String attrStr = printAttr(node);
        str = "<" + node.getName() + attrStr + ">";
        //节点输出到out
        out.write(tabStr.getBytes());
        out.write(str.getBytes());
        List<Node> sonNode = node.getSonNodes();
        //是否有子节点
        if ( sonNode != null && sonNode.size() > 0 ) {
            out.write("\n".getBytes());
            tabNum++;
            for ( Node node1 : sonNode ) {
                printNode(node1, out, tabNum);
            }
            out.write(tabStr.getBytes());
        } else {
            //没有子节点打印当前节点文本
            out.write(node.getText().getBytes());
        }
        //节点结束字符串
        str = "</" + node.getName() + ">";
        out.write(str.getBytes());
        out.write("\n".getBytes());
    }

    //打印当前节点属性
    private static String printAttr(Node node) {
        String attrStr = "";
        Map<String, String> attrs = node.getAttrs();
        if ( attrs != null && attrs.keySet().size() > 0 ) {
            for ( String attrName : attrs.keySet() ) {
                attrStr += " " + attrName + "=\"" + attrs.get(attrName) + "\"";
            }
        }
        return attrStr;
    }

}
