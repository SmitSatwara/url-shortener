CREATE SEQUENCE url_mapping_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE url_mapping (
                             id           BIGINT        PRIMARY KEY,
                             short_code   VARCHAR(10)   NOT NULL UNIQUE,
                             original_url VARCHAR(2048) NOT NULL,
                             created_at   TIMESTAMPTZ   NOT NULL DEFAULT now(),
                             expires_at   TIMESTAMPTZ,
                             click_count  BIGINT        NOT NULL DEFAULT 0
);

CREATE INDEX idx_url_mapping_expires_at ON url_mapping (expires_at);