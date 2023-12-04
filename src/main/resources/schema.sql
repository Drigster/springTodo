CREATE TABLE IF NOT EXISTS todos (
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    text varchar(255),
    is_done boolean DEFAULT false,
    created_at timestamp,
    updated_at timestamp
);