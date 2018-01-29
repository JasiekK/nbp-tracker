--liquibase formatted sql

--changeset jkmiec:1
CREATE TABLE IF NOT EXISTS exchange_rates (
  id         BIGINT PRIMARY KEY     NOT NULL,
  effective_date TIMESTAMP,
  no         VARCHAR(255),
  tab        VARCHAR(255)
);

--changeset jkmiec:2
CREATE TABLE IF NOT EXISTS rate(
exchange_rates_id BIGINT NOT NULL ,
code VARCHAR(255),
currency VARCHAR(255) , mid Numeric
);

--changeset jkmiec:3
CREATE VIEW current_rate_view AS SELECT er.id, er.effective_date, r.code, r.currency, r.mid
FROM exchange_rates er
JOIN rate r ON er.id = r.exchange_rates_id;

