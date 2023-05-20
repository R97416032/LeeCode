class Solution {
    public String convert(String s, int numRows) {
        int slen=s.length(),row=numRows;
        if(row==1||row>=slen)
            return s;
        StringBuffer[] mat=new StringBuffer[row];
        /*
            StringBuffer和String的区别:
                StringBuffer对象的内容可以修改；
                而String对象一旦产生后就不可以被修改，重新赋值其实是两个对象。

                String:在String类中没有用来改变已有字符串中的某个字符的方法，由于不能改变一个java字符串中的某个单独字符，所以在JDK文档中称String类的对象是不可改变的。
                然而，不可改变的字符串具有一个很大的优点:编译器可以把字符串设为共享的。 
                StringBuffer:StringBuffer类属于一种辅助类，可预先分配指定长度的内存块建立一个字符串缓冲区。
                这样使用StringBuffer类的append方法追加字符 比 String使用 + 操作符添加字符 到 一个已经存在的字符串后面有效率得多。
                因为使用 + 操作符每一次将字符添加到一个字符串中去时，字符串对象都需要寻找一个新的内存空间来容纳更大的字符串，这无凝是一个非常消耗时间的操作。
                添加多个字符也就意味着要一次又一次的对字符串重新分配内存。
                使用StringBuffer类就避免了这个问题。
        */
        for(int i=0;i<row;i++)
            mat[i]=new StringBuffer();
        for(int i=0,t=2*row-2,r=0;i<slen;i++){
            mat[r].append(s.charAt(i));
            if(i%t<row-1)
                r++;
            else
                r--;
        }
        StringBuffer res=new StringBuffer();
        /*
            for-each遍历
            foreach 循环语句是 Java 1.5 的新特征之一，在遍历数组、集合方面，foreach 为开发者提供了极大的方便。
            foreach 循环语句是 for 语句的特殊简化版本，主要用于执行遍历功能的循环。
            当使用 foreach 来迭代访问数组元素时，foreach 中的循环变量相当于一个临时变量，
            系统会把数组元素依次赋给这个临时变量，而这个临时变量并不是数组元素，它只是保存了数组元素的值。
            因此，如果希望改变数组元素的值，则不能使用这种 foreach 循环。

        */
        for(StringBuffer sb:mat){
            res.append(sb);
        }
        return res.toString();
    }
}