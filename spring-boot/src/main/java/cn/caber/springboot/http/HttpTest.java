package cn.caber.springboot.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

public class HttpTest {

    private static final CountDownLatch countDownLatch  = new CountDownLatch(1);
    public static void main(String[] args) {

        CloseableHttpAsyncClient httpClient = AsyncHttpClientConfig.getHttpClient();
        String url = "http://localhost:8080/httpPost";
        String body = "{ \"name\" : \" 张三 \"}";
        HttpPost httpPost = AsyncHttpClientConfig.getPostBody(url, body, ContentType.APPLICATION_JSON);
        httpClient.execute(httpPost, new FutureCallback<HttpResponse>() {

            @Override
            public void completed(HttpResponse httpResponse) {
                countDownLatch.countDown();
                HttpEntity entity = httpResponse.getEntity();
                try {
                    InputStream content = entity.getContent();
                    String s = ConvertStreamToString(content);
                    System.out.println("------------------------------");
                    System.out.println(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }

            @Override
            public void failed(Exception e) {
                countDownLatch.countDown();
            }

            @Override
            public void cancelled() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"结束");

    }

    public static String ConvertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error=" + e.toString());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println("Error=" + e.toString());
            }
        }
        return sb.toString();

    }
}
