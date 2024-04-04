CREATE TABLE hexagonix_version (
id VARCHAR(50) PRIMARY KEY,
description VARCHAR(1000) NOT NULL,
codename VARCHAR(1000) NOT NULL,
release_channel VARCHAR(50) NOT NULL,
release_tag VARCHAR(100) NOT NULL,
git_server VARCHAR(300),
committed BOOLEAN DEFAULT FALSE,
release_date TIMESTAMP(6) NOT NULL
);