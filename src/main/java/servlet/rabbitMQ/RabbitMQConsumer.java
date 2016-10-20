package servlet.rabbitMQ;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/19.
 */
public class RabbitMQConsumer extends DefaultConsumer {

    public static final String PING_TYPE = "ping";
    public static final String LOGIN_TYPE = "login";
    public static final String LOGOUT_TYPE = "logout";
    public static final String COUNTER_TYPE = "counter";

    private String topic;

//    @Autowired
//    @Qualifier("byteArrayCodeFactory")
//    private CodecFacotry codecFacotry;
//
//    @Autowired
//    private EntryDao entryDao;

    public RabbitMQConsumer(Channel channel) {
        super(channel);
        this.topic = "ping";
    }

    public RabbitMQConsumer(Channel channel, String topic) {
        this(channel);
        this.topic = topic;
    }

//    public static Map<String,APstation> map=new HashMap<>();

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {

        String message = new String(body);

        System.out.println(message);

    }


}
