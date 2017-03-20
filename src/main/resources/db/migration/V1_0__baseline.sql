CREATE SEQUENCE competition_scoring_id_seq START WITH 1;

CREATE TABLE competition_scoring
(
  id      BIGINT       NOT NULL DEFAULT nextval('competition_scoring_id_seq') PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL,
  CONSTRAINT competition_scoring_name_uq UNIQUE (name)
);

CREATE SEQUENCE competition_type_id_seq START WITH 1;

CREATE TABLE competition_types
(
  id      BIGINT       NOT NULL DEFAULT nextval('competition_type_id_seq') PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL,
  CONSTRAINT competition_type_name_uq UNIQUE (name)
);

CREATE SEQUENCE competition_id_seq START WITH 1;

CREATE TABLE competitions
(
  id      BIGINT       NOT NULL DEFAULT nextval('competition_id_seq') PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  type_id BIGINT       NOT NULL,
  version BIGINT,
  created TIMESTAMP    NOT NULL,
  updated TIMESTAMP    NOT NULL,
  CONSTRAINT type_id_fk FOREIGN KEY (type_id) REFERENCES competition_types (id)
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
  id             BIGINT    NOT NULL DEFAULT nextval('match_id_seq') PRIMARY KEY,
  competition_id BIGINT    NOT NULL,
  home_player_id BIGINT    NOT NULL,
  away_player_id BIGINT    NOT NULL,
  home_score     INT       NOT NULL,
  away_score     INT       NOT NULL,
  version        BIGINT,
  created        TIMESTAMP NOT NULL,
  updated        TIMESTAMP NOT NULL,
  CONSTRAINT matches_competition_id_fk FOREIGN KEY (competition_id) REFERENCES competitions (id),
  CONSTRAINT home_player_id_fk FOREIGN KEY (home_player_id) REFERENCES players (id),
  CONSTRAINT away_player_id FOREIGN KEY (away_player_id) REFERENCES players (id)
);

CREATE SEQUENCE match_players_id_seq START WITH 1;


CREATE TABLE match_players
(
  id        BIGINT    NOT NULL DEFAULT nextval('match_players_id_seq') PRIMARY KEY,
  match_id  BIGINT    NOT NULL,
  player_id BIGINT REFERENCES players (id) ON UPDATE CASCADE ON DELETE CASCADE,
  home_team BOOLEAN   NOT NULL,
  VERSION   BIGINT,
  created   TIMESTAMP NOT NULL,
  updated   TIMESTAMP NOT NULL,
  CONSTRAINT match_player_uq UNIQUE (match_id, player_id),
  CONSTRAINT match_players_player_id_fk FOREIGN KEY (player_id) REFERENCES players (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT match_players_match_id_fk FOREIGN KEY (match_id) REFERENCES matches (id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE SEQUENCE competition_players_id_seq START WITH 1;


CREATE TABLE competition_players
(
  id             BIGINT    NOT NULL DEFAULT nextval('competition_players_id_seq') PRIMARY KEY,
  competition_id BIGINT    NOT NULL,
  player_id      BIGINT REFERENCES players (id) ON UPDATE CASCADE ON DELETE CASCADE,
  rating         INT       NOT NULL DEFAULT 0,
  version        BIGINT,
  created        TIMESTAMP NOT NULL,
  updated        TIMESTAMP NOT NULL,
  CONSTRAINT competition_player_uq UNIQUE (competition_id, player_id),
  CONSTRAINT competition_players_player_id_fk FOREIGN KEY (player_id) REFERENCES players (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT competition_players_competition_id_fk FOREIGN KEY (competition_id) REFERENCES competitions (id) ON UPDATE CASCADE ON DELETE CASCADE
);