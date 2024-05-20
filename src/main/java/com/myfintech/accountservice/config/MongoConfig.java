package com.myfintech.accountservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.myfintech.accountservice.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Value("${mongo.database}")
  private String database;

  @Value("${mongo.connection}")
  private String connection;

  /**
   * Get database name.
   *
   * @return String database name
   */
  @Override
  protected String getDatabaseName() {
    return database;
  }

  /**
   * Configure mongodb client.
   *
   * @return MongoClient mongo client based on uri connection.
   */
  @Override
  public MongoClient mongoClient() {
    return MongoClients.create(
        MongoClientSettings.builder().applyConnectionString(new ConnectionString(connection)).build());
  }

  /**
   * Transaction manager bean.
   *
   * @return MongoTransactionManager
   */
  @Bean
  MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
    return new MongoTransactionManager(dbFactory);
  }

}
