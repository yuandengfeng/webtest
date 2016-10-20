package servlet.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Main1 {

      private static final String EXCHANGE_NAME ="connectionevent";
//    private final static String QUEUE_NAME = "wifitest";
      private final static String QUEUE_NAME = "yuantest";

//
////    private static final String EXCHANGE_NAME = "kt.macscan";
//     private static final String EXCHANGE_NAME ="connectionevent";


//    private final static String QUEUE_NAME = "mqtest";
//    private static final String EXCHANGE_NAME ="mqtest";

    public static void main(String[] args) throws IOException, InterruptedException {



        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.20.78");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null); //申明一个新的queue

//        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "fanout");

//        String QUEUE_NAME = channel.queueDeclare().getQueue();
        // 将队列，exchange，routekey进行绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "ktmsg.core.connection.enterprise.POA.W4W");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        }

//        //利用自带的类 消费消息
        Consumer consumer = new RabbitMQConsumer(channel,"ktmsg.core.connection.enterprise.POA.W4W");
        channel.basicConsume(QUEUE_NAME, true, consumer);


    }

}
