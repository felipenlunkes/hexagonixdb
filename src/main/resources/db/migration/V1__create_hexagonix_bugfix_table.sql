CREATE TABLE hexagonix_bugfix (
id VARCHAR(50) PRIMARY KEY,
aux_id CHAR(36) NOT NULL,
description VARCHAR(1000) NOT NULL,
resolution VARCHAR(1000) NOT NULL,
committed BOOLEAN DEFAULT FALSE,
release_date TIMESTAMP(6) NOT NULL,
version_id VARCHAR(50)
);