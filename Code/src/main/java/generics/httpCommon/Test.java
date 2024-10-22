package generics.httpCommon;

public class Test {

    public static void main(String[] args) {

        KaiHttpClient kaiHttpClient = new KaiHttpClient();

        SampleResponse1 a = kaiHttpClient.callRestApi("https://tiktok-api6.p.rapidapi.com/user/videos", "nvl2909", SampleResponse1.class);

        SampleResponse2 b = kaiHttpClient.callRestApi("https://tiktok-api6.p.rapidapi.com/user/details", "nvl2909", SampleResponse2.class);

        System.out.println(b);
    }

}
