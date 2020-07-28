package huffmanTree;

import java.io.*;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * public 的方法:
 *      MyhuffmanTree()         有两个方法,可以输入文件,或者字符串
 *      getRoot()               获取根节点
 *      getlhm()                获取LinkedListMap()字典
 *      printAllNode()          打印出所有的节点
 *      getTextEncode()         返回文本文件的huffman编码
 *      zip()                   压缩文件,并且生成test.slime文件
 *      restore()               将huffman编码转换为字符
 *
 */
class MyhuffmanTree{

    private String text;

    private Node root;

    private StringBuffer sb;

    private int[] data;

    private LinkedList<Node> list;

    private LinkedHashMap<String,String> lhm;

    private String textCode;

    private File file;

    public Node getRoot() {
        return root;
    }

    public LinkedHashMap<String,String> getLhm(){
        return lhm;
    }

    public MyhuffmanTree(String txt){
        this.text = txt;
        start();
    }

    public MyhuffmanTree(File file){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            this.file = file;
            this.text = br.readLine();
            start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 开始执行计算文本字符串的字符和编码
     * 创建树,并设置了root
     * 对root进行递归编码
     * 创建字典,存入字符和对应的编码
     */
    private void start(){
        caclText();
        create(list);
        encode();
        setMap();
        textEncode();
    }

    /**
     *
     * @param nodeList  存入一个node链表
     * @return Node     根节点
     */
    private void create(LinkedList<Node> nodeList){

        int len = nodeList.size();
        Collections.sort(nodeList);


        for (int i = 1; i < len; i++){

            int index = 0;
            Node node1 = nodeList.remove(0);
            Node node2 = nodeList.remove(0);


            int newNodeWeight = node1.getWeight() + node2.getWeight();
            Node newnode = new Node(newNodeWeight);
            newnode.setLeftNode(node1);
            newnode.setRightNode(node2);
            newnode.setData(null);

            while (true){
                if (index == nodeList.size() || newnode.getWeight() < nodeList.get(index).getWeight()){
                    nodeList.add(index,newnode);
                    break;
                }
                index++;
            }

        }

        root = nodeList.get(0);

    }

    /**
     * 默认编码
     * 左节点编码为0,又节点编码为0
     */
    private void encode(){

        huffmanEncode(root, "0", "1", "");

    }

    /**
     * 对huffmanTree 进行编码
     * @param node          根节点
     * @param leftcode      左节点编码
     * @param rightcode     右节点编码
     * @param code          初始的编码
     */
    private void huffmanEncode(Node node, String leftcode, String rightcode, String code){

        if (node.getLeftNode() != null){
            String temp = code + leftcode;
            huffmanEncode(node.getLeftNode(), leftcode, rightcode, temp);
        }

        if (node.getRightNode() != null){
            String temp = code + rightcode;
            huffmanEncode(node.getRightNode(), leftcode, rightcode, temp);
        }

        if (node.getLeftNode() == null || node.getRightNode() == null){
            node.setEncode(code);
        }

    }

    /**
     * 返回编码后的文本编码
     * @return
     */
    private void textEncode(){
        sb = new StringBuffer();

        for (int i = 0; i < text.length(); i++){
            String temp = "" + this.text.charAt(i);
            for (String key : lhm.keySet()){
                if (temp.equals(lhm.get(key))){
                    sb.append(key);
                    break;
                }
            }
        }

        this.textCode = sb + "";
    }

    /**
     * 返回编码后的文本编码
     * @return
     */
    public String getTextEncode(){
        return this.textCode;
    }

    /**
     * 创建LinkedHashMap实例,调用getStr()方法
     */
    private void setMap(){

        lhm = new LinkedHashMap<>();
        getStr(root);

    }

    /**
     * 将字符与编码存到LinkedHashMap()之中
     * @param root
     */
    private void getStr(Node root){

        if (root.getLeftNode() != null){
            if (root.getLeftNode().getData() != null){
                lhm.put(root.getLeftNode().getEncode(),root.getLeftNode().getData());
            }
            getStr(root.getLeftNode());
        }
        if (root.getRightNode() != null){
            if (root.getRightNode().getData() != null){
                lhm.put(root.getRightNode().getEncode(), root.getRightNode().getData());
            }
            getStr(root.getRightNode());
        }

    }

    /**
     *
     * @param root 树的根节点
     */
    public void printAllNode(Node root){
        //先序遍历
        System.out.println(root.getData() + " -> " + root.getEncode());
        if (root.getLeftNode() != null){
            printAllNode(root.getLeftNode());
        }
        if (root.getRightNode() != null){
            printAllNode(root.getRightNode());
        }

    }

    /**
     * 计算文本的字符频率,并调用create()方法,创建huffmanTree
     * @return      返回的根节点
     */
    private void caclText(){
        data = new int[127];

        list = new LinkedList<>();

        for (int i = 0; i < this.text.length(); i++){
            data[(int)this.text.charAt(i)]++;
        }

        for (int i = 0; i < data.length; i++){

            if (data[i] != 0){
                Node temp = new Node(data[i],"" + (char)i);
                list.add(temp);
            }
        }

    }

    /**
     * 压缩文件,并生成test.slime
     * 压缩原理是:将每八位的huffman编码当作二进制,然后
     * 转为10进制,10进制转为字符
     * 最后一位不足8位,补零,并且增加一位来记录0的位数
     * @return
     * @throws Exception
     */
    public boolean zip() throws Exception{
        File f = new File("./test.slime");

        if (!f.exists()){
            f.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));

        while (sb.length() > 0){
            if (sb.length() <= 8){
                int len = 8 - sb.length();
                String s = sb.substring(0,sb.length());
                while (len > 0){
                    s = s + "0";
                    len--;
                }
                int temp = Integer.parseInt(s,2);
                bw.write((char)temp);
                bw.write((char)(8-sb.length()));
                break;
            }
            int temp = Integer.parseInt(sb.substring(0,8),2);
            bw.write((char)temp);
            sb.delete(0,8);
        }

        bw.flush();
        bw.close();
        return true;
    }

    /**
     * 恢复为原来的编码,并且将系统删除的0,恢复为8位数
     * @return
     * @throws Exception
     */
    public String restore() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./test.slime")));

        String s = br.readLine();

        if (s == null){
            System.out.println("文件 为空");
            return null;
        }

        StringBuffer sb = new StringBuffer();

        String s2;
        for (int i = 0; i < s.length(); i++){
            s2 = bu(Integer.toBinaryString((int)s.charAt(i)));
            if (i == s.length() - 2){
                int temp =(int)s.charAt(s.length()-1);
                sb.append(s2,0,8 -temp);
                break;
            }
            sb.append(s2);
            System.out.println((int)s.charAt(i) + " -> " + s2);
        }

        return sb.toString();
    }

    /**
     * 为字符串补零
     * @param s
     * @return
     */
    private String bu(String s){
        while (s.length() < 8){
            s = "0" + s;
        }

        return s;
    }

}


class Node implements Comparable{

    private String data;
    private String encode;
    private int weight;
    private Node leftNode;
    private Node rightNode;


    public void setData(String data) {
        this.data = data;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public String getData() {
        return data;
    }

    public String getEncode() {
        return encode;
    }

    public int getWeight() {
        return weight;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    /**
     *
     * @param weight       权重
     * @param data         数据
     */
    public Node(int weight, String data){
        this.weight = weight;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", encode='" + encode + '\'' +
                ", weight=" + weight +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Node node = (Node)o;
        return this.getWeight() - node.getWeight();
    }
}

