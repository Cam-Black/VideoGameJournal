DROP TABLE IF EXISTS journal;
CREATE TABLE journal
(
    journal_id   INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    entry        TEXT,
    game_name    VARCHAR(255),
    journal_name VARCHAR(255),
    primary key (journal_id)
);