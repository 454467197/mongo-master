import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.MongoIterable;
import org.apache.log4j.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


/**
 * @author wuyanzu
 * **
 * @Package PACKAGE_NAME
 * **
 * @Create with 2018/1/5 1:39
 * **
 * @Description: test
 */
public class jtest {

    public static Logger log= Logger.getLogger(jtest.class);
    private MongoDatabase db;
    private MongoClient client;
    private MongoCollection collection;

    @Before
    public void init(){
        List <CodecRegistry> codelist=new ArrayList<CodecRegistry>();
        codelist.add(MongoClient.getDefaultCodecRegistry());
        CodecRegistry codecRegistry=CodecRegistries.fromRegistries(codelist);
        client=new MongoClient(new ServerAddress("192.168.1.109"),
                MongoClientOptions.builder().codecRegistry(codecRegistry).build());
        System.out.println("init 初始化各种数据");
        client=new MongoClient("192.168.1.109");
        db=client.getDatabase("zzw");



    }

    @Test
    public  void test(){

        MongoIterable<String> strings = db.listCollectionNames();
        MongoCursor<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println("----"+iterator.next());
        }
        System.out.println("do someThing...");
    }
}
