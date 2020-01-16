# create keyspace

CREATE KEYSPACE oneviewdashboard WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

# create table

CREATE TABLE IF NOT EXISTS oneviewdashboard.billing_account (
  account_number TEXT,
  account_type TEXT,
  account_subtype TEXT,
  line_of_business TEXT,
  account_status TEXT,
  credit_class TEXT,
  timestamp BIGINT,
  PRIMARY KEY(account_number)
);