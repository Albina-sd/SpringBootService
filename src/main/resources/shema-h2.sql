CREATE TABLE public.storehouses
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    name character varying NOT NULL,
    address character varying,
    city character varying NOT NULL,
    country character varying NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.storehouses
    OWNER to postgres;

CREATE TABLE public.sweets_types
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    name character varying NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.sweets_types
    OWNER to postgres;

CREATE TABLE public.sweets
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    sweets_types_id integer references sweets_types(id),
    name character varying NOT NULL,
    cost integer NOT NULL,
    weight integer NOT NULL,
    manufacturer_id integer NOT NULL references manufacturers(id),
    with_sugar boolean,
    requires_freezing boolean,
    production_date date NOT NULL,
    expiration_date date NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.sweets
    OWNER to postgres;

CREATE TABLE public.manufacturers_storehouses
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    storehouses_id integer NOT NULL,
    manufacturers_id integer NOT NULL,
    PRIMARY KEY (id)
)