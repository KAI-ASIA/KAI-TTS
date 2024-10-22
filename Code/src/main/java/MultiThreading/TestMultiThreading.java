package MultiThreading;

import database.TikTokUser;
import generics.httpCommon.KaiHttpClient;
import generics.httpCommon.SampleResponse2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMultiThreading {

//    public static void main(String[] args) {
//        try{
//            long a = System.currentTimeMillis();
//            KaiHttpClient kaiHttpClient = new KaiHttpClient();
//            List<String> userName = new ArrayList<>();
//            userName.add("nvloc2909");
//            userName.add("_immling");
//            userName.add("doandang2705");
//            userName.add("anh.lt15");
//            userName.add("tu.nh");
//            userName.add("spacex90");
//            List<TikTokUser> list = new ArrayList<>();
//            for(String u : userName){
//                TikTokUser b = kaiHttpClient.callRestApi("https://tiktok-api6.p.rapidapi.com/user/details", "nvl2909", TikTokUser.class);
//                if(b != null){
//                    list.add(b);
//                }
//            }
//            System.out.println(list.size());
//            System.out.println("Duration: " + (System.currentTimeMillis() - a));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

        public static void main(String[] args) {
        try{
            long a = System.currentTimeMillis();
            KaiHttpClient kaiHttpClient = new KaiHttpClient();
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            List<String> userName = new ArrayList<>();
            userName.add("nvloc2909");
            userName.add("_immling");
            userName.add("doandang2705");
            userName.add("anh.lt15");
            userName.add("tu.nh");
            userName.add("spacex90");
            List<TikTokUser> list = new ArrayList<>();
            for(String u : userName){
                CallTiktokTask callTiktokTask = new CallTiktokTask(list);
                executorService.execute(callTiktokTask);
            }
            executorService.shutdown();
            while (!executorService.isTerminated()){
                continue;
            }
            System.out.println(list.size());
            System.out.println("Duration: " + (System.currentTimeMillis() - a));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class CallTiktokTask implements Runnable{

    List<TikTokUser> list;

    public CallTiktokTask(){
        this.list = new ArrayList<>();
    }

    public CallTiktokTask(List<TikTokUser> list){
        this.list = list;
    }

    @Override
    public void run() {
        KaiHttpClient kaiHttpClient = new KaiHttpClient();
        TikTokUser b = kaiHttpClient.callRestApi("https://tiktok-api6.p.rapidapi.com/user/details", "nvl2909", TikTokUser.class);
        if(b != null){
            list.add(b);
        }
    }
}
