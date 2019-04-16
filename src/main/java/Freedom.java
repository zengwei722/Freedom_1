import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

public class Freedom {
    public static void main(String[] args) throws Exception{
        Map<String,ArrayList> redmap= new HashMap<String, ArrayList>();
        Map<String,ArrayList> bluemap= new HashMap<String, ArrayList>();
        HashMap<Integer,Integer> hm = new HashMap();
        //循环改变地址
        long l = System.currentTimeMillis();
        for (int i = 2; i <= 91; i++) {
            String url= "http://www.lottery.gov.cn/historykj/history_"+i+".jspx?_ltype=dlt";
            reset(url,redmap,bluemap);
        }
        count(redmap,bluemap,hm);
        long l1 = System.currentTimeMillis();
        System.out.println("总共用时"+(l1-l)/1000+"秒");
    }
    public static void reset(String url,Map<String, ArrayList> redmap, Map<String, ArrayList> bluemap)throws Exception{

        //获取整个网页的dcoumout对象
        Document document = Jsoup.connect(url).get();
        Elements tr1 = document.select("tr");
        for (Element element : tr1) {
            //集合存放红球.篮球的号码
            ArrayList<String> red = new ArrayList();
            ArrayList<String> blue = new ArrayList();
            String time =null;
            Elements td = element.select("td");
            for (Element element1 : td) {
                if (element1.toString().contains("height=\"23\"")){
                    time = element1.text();
                }
                if (element1.toString().contains("class=\"red\"")){
                    red.add(element1.text());
                }
                if (element1.toString().contains("class=\"blue\"")){
                    blue.add(element1.text());
                }
            }
            if (time!=null){
                redmap.put("第"+time+"期", red);
                bluemap.put("第"+time+"期", blue);
            }
        }
    }
    private static void count(Map<String, ArrayList> redmap, Map<String, ArrayList> bluemap, HashMap<Integer, Integer> hm) {
        hm.put(1,0 );
        Collection<ArrayList> values = redmap.values();
       int z= 1;
       for (ArrayList value : values) {
           for (Object o : value) {
               int j=Integer.parseInt(o.toString());
               if (!hm.containsKey(j)){
                    hm.put(j,z );
               }
               Integer integer1 = hm.get(j);
               hm.put(j,++integer1 );
           }
       }
        HashMap<Integer,Integer> hm1 = new HashMap();
        ArrayList<Integer> al = new ArrayList();
       //用出现次数作为KEY
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hm.entrySet()) {
            al.add(integerIntegerEntry.getValue());
           // hm1.put(integerIntegerEntry.getValue(),integerIntegerEntry.getKey());
        }
       Collections.sort(al);
       for (int i = al.size() - 1; i >= 0; i--) {
           Integer integer1 = al.get(i);

           for (Integer integer : hm.keySet()) {
               if (hm.get(integer)==integer1){
                   System.out.println(integer+" 出现次数 :"+integer1);
               }
           }
       }


        //号码出现次数排序
       // for (Map.Entry<Integer, Integer> integerIntegerEntry : hm1.entrySet()) {
//
       //     System.out.println(integerIntegerEntry.getKey()+"出现的次数是: "+integerIntegerEntry.getValue());
       // }





     //
     //  Set<Integer> integers = hm1.keySet();
     //  for (Integer integer : integers) {
     //      al.add(integer);
     //  }
     //  Collections.sort(al);
     //  for (int i = al.size() - 1; i >=0 ; i--) {
     //      System.out.println(hm1.get(al.get(i))+"出现次数"+al.get(i));
     //  }
    }
}