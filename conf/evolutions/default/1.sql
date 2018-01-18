# --- !Ups
create table jenres (
    id              INT not null auto_increment,
    name            char(64) not null,
    sentence        varchar(255) not null,
    PRIMARY KEY (id)
);
INSERT INTO jenres (name, sentence) VALUES("RPG", "ロールプレイングアクション");
INSERT INTO jenres (name, sentence) VALUES("STG", "シューティング");
INSERT INTO jenres (name, sentence) VALUES("ACT", "アクション");
INSERT INTO jenres (name, sentence) VALUES("ADV", "アドベンチャー");
INSERT INTO jenres (name, sentence) VALUES("PZL", "パズル");
INSERT INTO jenres (name, sentence) VALUES("RCG", "レース");
INSERT INTO jenres (name, sentence) VALUES("SLG", "シミュレーション");
INSERT INTO jenres (name, sentence) VALUES("MUS", "音楽");

# --- !Downs 
drop table if exists jenres;
