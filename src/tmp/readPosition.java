//package tmp;
//
//
//import com.lagou.mining.companymodel.service.dataaccess.mysql.dao.PositionDao;
//import com.lagou.mining.companymodel.service.dataaccess.mysql.entity.Position;
//import com.lagou.mining.uitl.Path;
//import com.lagou.mining.uitl.ServerCluster;
//import com.lagou.mining.uitl.SystemConfig;
//import com.lagou.mining.uitl.dao.DBName;
//import com.lagou.mining.uitl.dao.DaoHelperPool;
//import com.lagou.mining.uitl.dao.mongo.MongoClientManager;
//import com.lagou.mining.uitl.dao.mongo.MongoDBName;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.log4j.PropertyConfigurator;
//
//import java.io.BufferedWriter;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.List;
//
//
///**
// * 获取职位信息
// *
// * @Author: milo
// * @Create: 2017-02-26
// */
//public class readPosition {
//
//    private static String basePath = null;
//    private static String confPath = null;
//    private static Log logger = LogFactory.getLog(readPosition.class);
//
//    private static String outfile = "/data/milo/positionDetail.txt";
//
//    public static void main(String[] args) {
//
//        logger.info("CompanyModel main start...");
//
//        basePath = Path.getCurrentPath();
//
//        /**
//         * pro-c,new-c环境用
//         */
//        confPath = basePath + "/../conf/";
//        /**
//         * develop环境用
//         */
//        //confPath = basePath + "/conf/";
//
//        try {
//            SystemConfig.init(confPath + "system.properties");
//        } catch (IOException e) {
//            System.err.println("init system configuration failed, system will exit.");
//            System.exit(1);
//        }
//
//        PropertyConfigurator.configure(confPath + "log4j.properties");
//
//        ServerCluster.report();
//        initDB();
//
//
//        PositionDao posDao = null;
//        try {
//            posDao = new PositionDao();
//        } catch (Exception e) {
//            logger.error("connect to mysql failed, will not batch update company feature", e);
//        }
//        if (posDao == null) {
//            return;
//        }
//
//
//        final int PAGE_NO = 1;
//        final int PAGE_SIZE = 500;
//        int maxid = -1;
//        int failNum = 0;
//        while (failNum < 100) {
//            List<Position> datas = posDao.getDataByPage("id,positionName", "id >" + maxid + " and isEnable=1 and isExpired=0", PAGE_NO, PAGE_SIZE);
//            if (datas == null) { // 返回null可能是读取超时，并不代表数据已经读完了
//                failNum++;
//                continue;
//            }
//            if (datas.size() == 0) {
//                break;
//            }
//            for (Position ele : datas) {
//                int id = ele.getId();
//                if (id > maxid) {
//                    maxid = id;
//                }
//
//                String positionName = ele.getPositionName();
//
//
//                if (positionName==null){
//                    logger.info("positionName is null");
//                }
//
//
//                appendfile(outfile, ele.getId() + "\t" + positionName);
//                logger.info("reading");
//
//
//            }
//        }
//    }
//
//    /**
//     * 初始化各种DB连接
//     */
//    private static void initDB() {
//        DaoHelperPool.configDb(DBName.ZHU_ZHAN, null, confPath + "db_lagou.properties");
//        MongoClientManager.configMongo(MongoDBName.COMPANY_MODEL, confPath + "mongo_company.properties");
//    }
//
//
//    public static void appendfile(String file, String content) {
//        BufferedWriter out = null;
//        try {
//            out = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(file, true)));
//            out.write(content + "\r\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
