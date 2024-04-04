CREATE TABLE hexagonix_bugfix (
fix_id VARCHAR(50) PRIMARY KEY,
description VARCHAR(1000) NOT NULL,
resolution VARCHAR(1000) NOT NULL,
committed BOOLEAN DEFAULT FALSE,
release_date TIMESTAMP(6) NOT NULL,
version_id VARCHAR(50)
);