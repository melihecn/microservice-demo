-- init.sql
\connect postgres

DO
$$
    BEGIN
        IF NOT EXISTS (
            SELECT FROM pg_database WHERE datname = 'order_service'
        ) THEN
            EXECUTE 'CREATE DATABASE order_service';
        END IF;
    END
$$;
