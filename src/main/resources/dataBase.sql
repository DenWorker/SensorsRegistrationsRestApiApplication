create table Sensors
(
    id          int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    sensor_name varchar(31) NOT NULL,
    created_at timestamp,
    update_at timestamp,
    created_who varchar(100)
);