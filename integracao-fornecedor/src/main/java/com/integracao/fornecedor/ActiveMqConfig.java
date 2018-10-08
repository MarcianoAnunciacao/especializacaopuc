package com.integracao.fornecedor;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class ActiveMqConfig {

	@Value("${jsa.activemq.broker.url}")
	String brokerUrl;

	@Value("${jsa.activemq.borker.username}")
	String userName;

	@Value("${jsa.activemq.borker.password}")
	String password;

	/**
	 * Criar conexão com a Fila
	 * 
	 * @return ConnectionFactory
	 */
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setUserName(userName);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}

	/**
	 * Método que converte a mensagem em objeto Java
	 * 
	 * @return MessageConverter
	 */
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	/**
	 * Método utilizado para o recebimento de mensagem
	 * 
	 * @param connectionFactory
	 * @param configurer
	 * @return
	 */
	@Bean
	public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setMessageConverter(jacksonJmsMessageConverter());
		configurer.configure(factory, connectionFactory);
		return factory;
	}
	
	/**
	 * Método utilizado para o envio de mensagem
	 * @return JmsTemplate
	 */
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setMessageConverter(jacksonJmsMessageConverter());
        template.setConnectionFactory(connectionFactory());
        return template;
    }

}
