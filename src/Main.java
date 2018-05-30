import java.io.IOException;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //创建xml对象
        Xml xml = new Xml(null);
        //设置编码
        xml.setEncoding("utf-8");
        //设置版本
        xml.setVersion("1.1");
        //创建节点这个节点是个初始节点
        Node initNode = new Node("ininNode", null);
        //节点添加属性
        initNode.addAttr("value", "123");

        //创建节点
        Node sonNode1 = new Node("sonNode1", initNode);
        //节点设置属性
        sonNode1.addAttr("value", "456");
        sonNode1.addAttr("name", "呵呵哒");

        Node sonNode11 = new Node("sonNode11");
        //设置节点text值
        sonNode11.setText("12312321321");
        //添加子节点
        sonNode1.addSonNode(sonNode11);

        Node sonNode2 = new Node("sonNode2", initNode);
        sonNode1.addAttr("value", "456");

        Node sonNode3 = new Node("sonNode3", initNode, "sonNode3");
        sonNode3.addAttr("value", "789");

        //添加子节点
        initNode.addSonNode(sonNode1);
        initNode.addSonNode(sonNode2);
        initNode.addSonNode(sonNode3);
        //打印节点 到控制台
        // Xml.printNode(sonNode1, System.out, 0);

        //删除节点属性根据属性吗
        initNode.delAttr("value");
        xml.setInintNode(initNode);

        //打印xml到a.txt
        xml.printXml(new FileOutputStream(new File("a.txt")));
        //打印xml到控制台
        // xml.printXml(System.out);
    }
}
