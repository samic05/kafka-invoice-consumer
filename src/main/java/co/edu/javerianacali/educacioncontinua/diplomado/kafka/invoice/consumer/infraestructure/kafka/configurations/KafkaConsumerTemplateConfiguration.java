package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.configurations;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.events.SaleEvent;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class KafkaConsumerTemplateConfiguration {

  @Value("${application.kafka.host}")
  private String kafkaHost;

  @Value("${application.kafka.port}")
  private String kafkaPort;

  @Bean
  public ConsumerFactory<String, SaleEvent> consumerFactory() {

    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost + ":" + kafkaPort);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "restaurant_invoice");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(
        JsonDeserializer.VALUE_DEFAULT_TYPE,
        "co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.events.SaleEvent");
    props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, "false");

    return new DefaultKafkaConsumerFactory<>(props);
  }

  @Bean
  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, SaleEvent>>
      listenerContainerFactory(ConsumerFactory<String, SaleEvent> consumerFactory) {
    ConcurrentKafkaListenerContainerFactory<String, SaleEvent> listenerContainerFactory =
        new ConcurrentKafkaListenerContainerFactory<>();
    listenerContainerFactory.setConsumerFactory(consumerFactory);
    return listenerContainerFactory;
  }
}
