package com.myfintech.accountservice.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.myfintech.accountservice.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Value("${mongo.database}")
  private String database;

  @Value("${mongo.host}")
  private String host;

  @Value("${mongo.port}")
  private int port;

  @Override
  protected String getDatabaseName() {
    return database;
  }

  @Override
  protected void configureClientSettings(MongoClientSettings.Builder builder) {
    builder.applyToClusterSettings(
        settings -> settings.hosts(Collections.singletonList(new ServerAddress(host, port))));
  }
}
