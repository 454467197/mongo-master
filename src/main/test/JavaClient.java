import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.junit.Before;
import org.junit.Test;
import org.bson.Document;

import java.util.*;

/**
 *
 * {
 "_id": "5a5394e3f6c2c8493d8561f3",
 "username": "test",
 "country": "UK",
 "address": {
 "aCode": "411000",
 "add": "TEST"
 },
 "favorites": {
 "movies": [
 "蜘蛛侠",
 "钢铁侠",
 "蝙蝠侠"
 ],
 "cites": [
 "青岛",
 "东莞",
 "上海"
 ]
 },
 "salary": {
 "$numberDecimal": "1969.88"
 }
 }
 */

public class JavaClient {

   private MongoDatabase dbs;

   private MongoClient cl;

   private MongoCollection<Document>  collection;
    @Before
    public  void  init()
    {
        System.out.println("init....");
        cl=new MongoClient("192.168.1.109");
        dbs=cl.getDatabase("test");
        collection=dbs.getCollection("users");
        System.out.println(collection.getNamespace());

    }
    @Test
    public  void test(){
        DeleteResult dr=collection.deleteMany(Filters.eq("username","wuyanzu"));
        System.out.println("删除了"+dr.getDeletedCount()+"行...");
        Document  doc=new Document();
        doc.append("username","wuyanzu");
        doc.append("country","Shanghai");
        Map<String,String> address=new HashMap<>();
        address.put("acode","40082");
        address.put("add","恒南路851号");
        doc.append("address",address);
        Map<String,List<String>> favorites=new HashMap<>();
        List<String> movies=new ArrayList<>();
        List<String> cites=new Vector<>();
        movies.add("功夫熊猫");
        movies.add("kongfu");
        favorites.put("movies",movies);
        doc.append("favorites",favorites);
        cites.add("Changsha");
        cites.add("Shanghai");
        cites.add("ShenZhen");
        doc.append("cites",cites);

        doc.append("age",18);
        doc.append("salary",18888.88);
        doc.append("lenght",1.75f);
        collection.insertOne(doc);
        System.out.printf("结束");
    }
}


