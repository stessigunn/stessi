CREATE SEQUENCE competition_id_seq START WITH 1;


CREATE TABLE competitions
(
  id      BIGINT       NOT NULL DEFAULT nextval('competition_id_seq') PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL
);

CREATE SEQUENCE player_id_seq START WITH 1;


CREATE TABLE players
(
  id      BIGINT       NOT NULL DEFAULT nextval('player_id_seq') PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL
);

CREATE SEQUENCE match_id_seq START WITH 1;

CREATE TABLE matches
(
  id      BIGINT       NOT NULL DEFAULT nextval('match_id_seq') PRIMARY KEY,
  home_player_id BIGINT NOT NULL,
  away_player_id BIGINT NOT NULL,
  home_score INT NOT NULL,
  away_score INT NOT NULL,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL,
  CONSTRAINT home_player_id_fk FOREIGN KEY (home_player_id) REFERENCES players(id),
  CONSTRAINT away_player_id FOREIGN KEY (away_player_id) REFERENCES players(id)
);


CREATE TABLE competition_players
(
  competition_id BIGINT NOT NULL ,
  player_id BIGINT references players (id) ON UPDATE CASCADE ON DELETE CASCADE,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL,
  CONSTRAINT competition_player_pk PRIMARY KEY (competition_id, player_id),
  CONSTRAINT player_id_fk FOREIGN KEY (player_id) references players (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT competition_id_fk FOREIGN KEY (competition_id) references competitions (id) ON UPDATE CASCADE ON DELETE CASCADE
);


