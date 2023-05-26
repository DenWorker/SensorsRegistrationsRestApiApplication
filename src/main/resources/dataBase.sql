create table Sensors
(
    id          int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    sensor_name varchar(31) NOT NULL,
    created_at  timestamp,
    update_at   timestamp
);

create table Measurements
(
    id               int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    sensor_id        int                                                  NOT NULL,
    value            NUMERIC(10, 2) CHECK ( value > -100 AND value < 100) NOT NULL,
    raining          bool                                                 NOT NULL,
    measurement_time timestamp,

    FOREIGN KEY (sensor_id) REFERENCES Sensors (id) ON DELETE CASCADE
);