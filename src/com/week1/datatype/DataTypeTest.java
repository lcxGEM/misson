package com.week1.datatype;

public class DataTypeTest {
    public static void main(String[] args) {
        // 基本数据类型：byte、char、short、int、long、float、double、boolean
        // 自动转换，基本类型从小到大转换
        byte a = 1;
        char b = 'a';
        short c = a;
        int d = b;
        int e = c;
        long f = e;
        float g = f;
        double h = g;
        System.out.println(a+", "+b+", "+c+", "+d+", "+e+", "+f+", "+g+", "+h);
        // 强制类型转换，基本类型从大到小转换
        // 强制类型转换规则：
        // 浮点型数据转化成整型数据直接截断小数后的部分。
        // 整型数据如果超出数据范围，由低位到可以取到的最高位截取数据。重新解析(此时的符号位是原来的数据位，因此数据征服可能会变化)
        double dou = -1055555.6*100000000;//当数据超出范围，强制类型转换会精度溢出
        float flo = (float) dou;
        long lon = (long)flo;
        int in = (int) lon;
        int i = 32768;
        short sho = (short) i;//取值范围-32768~32767
        short shor = 128;
        byte byt = (byte) shor;//取值范围-128~127
        System.out.println(dou+", "+flo+", "+lon+", "+in+", "+sho+", "+byt);
        char cha = 'A';
        int ch = cha;
        byte bb= (byte) cha;
        System.out.println(cha+", "+ch+", "+ bb);
        System.out.println("--------------");
        //java的整型缓存机制
        /*当Integer类用自动装箱赋值时，会启动整形缓存机制。如果数值大小在-127~128之间，会先在内存中寻找是否有实例，如果有则直接返回该值
        不会重新创建对象。
        整形缓存机制的默认数值大小为-127~128之间，不过可以进行设置，设置方式：
        java -D java.lang.Integer.IntegerCache.high=1000 TestAutoBoxCache
        java -XX:AutoBoxCacheMax=1000 TestAutoBoxCache
        其他缓存的对象：
            这种缓存行为不仅适用于Integer对象。我们针对所有的整数类型的类都有类似的缓存机制。
            有ByteCache用于缓存Byte对象
            有ShortCache用于缓存Short对象
            有LongCache用于缓存Long对象
            有CharacterCache用于缓存Character对象
            Byte, Short, Long有固定范围: -128 到 127。对于Character, 范围是 0 到 127。除了Integer以外，这个范围都不能改变。

        Integer 中的valueOf方法
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
         */
        Integer aaaa = new Integer(11);
        Integer bbbb = new Integer(11);
        System.out.println(aaaa==bbbb);//false
        Integer xx = new Integer(128);
        Integer yy = new Integer(128);
        System.out.println(xx==yy);//false
        aaaa = 11;
        bbbb = 11;
        aaaa++;
        //aaaa数值修改时不会影响bbbb的值
        System.out.println(aaaa+"    "+bbbb);
        System.out.println(aaaa==bbbb);//true
        xx=128;
        yy=128;
        System.out.println(xx==yy);//false

    }
}
