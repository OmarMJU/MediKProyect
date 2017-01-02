-- Table: public.medico

-- DROP TABLE public.medico;

CREATE TABLE public.medico
(
    curp character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido_p character varying(50) COLLATE pg_catalog."default" NOT NULL,
    apellido_m character varying(50) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(50) COLLATE pg_catalog."default" NOT NULL,
    fecha_n date NOT NULL,
    pass character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pkmedico PRIMARY KEY (curp)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.medico
    OWNER to postgres;

GRANT ALL ON TABLE public.medico TO postgres WITH GRANT OPTION;