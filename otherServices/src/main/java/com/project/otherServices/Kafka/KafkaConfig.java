package com.project.otherServices.Kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.internals.Topic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
@EnableKafka
public class KafkaConfig {

	@Bean
	public NewTopic paymentTopic() {
		return TopicBuilder.name("payment-topic").build();
	}
	
	  @Bean
	    public ProducerFactory<String, PaymentNotifyProducer> producerFactory() {
	        Map<String, Object> configProps = new HashMap<>();
	        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); //(4:02)
	        configProps.put("spring.json.type.mapping", "PaymentConfirmation:com.project.otherServices.Kafka.PaymentConfirmation");
//	        configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 60000);
//	        configProps.put(ProducerConfig.METADATA_MAX_IDLE_CONFIG, 60000);
	        
	        return new DefaultKafkaProducerFactory<>(configProps);
	    }
	  
	  @Bean
	    public KafkaTemplate<String, PaymentNotifyProducer> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }
}
