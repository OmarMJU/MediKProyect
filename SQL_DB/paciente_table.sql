-- Table: public.paciente

-- DROP TABLE public.paciente;

CREATE TABLE public.paciente
(
    curp_p character varying(50) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(50) COLLATE pg_catalog."default",
    apellido_p character varying(50) COLLATE pg_catalog."default",
    apellido_m character varying(50) COLLATE pg_catalog."default",
    correo character varying(50) COLLATE pg_catalog."default",
    fecha_n date,
    pass character varying(50) COLLATE pg_catalog."default",
    id_medico character varying(50) COLLATE pg_catalog."default",
    diagnostico character varying(500) COLLATE pg_catalog."default",
    tratamiento character varying(500) COLLATE pg_catalog."default",
    fecha_diag date,
    CONSTRAINT pkpaciente PRIMARY KEY (curp_p),
    CONSTRAINT fk_medico_paciente FOREIGN KEY (id_medico)
        REFERENCES public.medico (curp) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.paciente
    OWNER to postgres;

GRANT ALL ON TABLE public.paciente TO postgres WITH GRANT OPTION;