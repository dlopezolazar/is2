
CREATE TABLE public.Rol (
                id_rol INTEGER NOT NULL,
                rol_descripcion VARCHAR NOT NULL,
                CONSTRAINT rol_pk PRIMARY KEY (id_rol)
);


CREATE TABLE public.Usuario (
                id_usuario INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                correo VARCHAR NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);


CREATE TABLE public.Proyecto (
                id_proyecto INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                fecha_inicio DATE NOT NULL,
                fecha_fin DATE NOT NULL,
                CONSTRAINT proyecto_pk PRIMARY KEY (id_proyecto)
);


CREATE TABLE public.Usuario_Rol (
                id_usuario_rol INTEGER NOT NULL,
                id_proyecto INTEGER,
                id_rol INTEGER NOT NULL,
                id_usuario INTEGER NOT NULL,
                CONSTRAINT usuario_rol_pk PRIMARY KEY (id_usuario_rol)
);


CREATE UNIQUE INDEX equipo_uk
 ON public.Usuario_Rol
 ( id_usuario_rol );

CREATE TABLE public.Backlog (
                id_backlog VARCHAR NOT NULL,
                id_proyecto INTEGER NOT NULL,
                descripcion VARCHAR NOT NULL,
                CONSTRAINT backlog_pk PRIMARY KEY (id_backlog)
);


CREATE TABLE public.Requerimiento (
                id_requerimiento INTEGER NOT NULL,
                id_backlog VARCHAR NOT NULL,
                descripcion VARCHAR NOT NULL,
                CONSTRAINT requerimiento_pk PRIMARY KEY (id_requerimiento)
);


CREATE TABLE public.Sprint (
                sprint_id INTEGER NOT NULL,
                fecha_inicio DATE NOT NULL,
                fecha_fin VARCHAR NOT NULL,
                sprint_description VARCHAR NOT NULL,
                id_proyecto INTEGER NOT NULL,
                CONSTRAINT sprint_pk PRIMARY KEY (sprint_id)
);


CREATE TABLE public.Story (
                id_tarea INTEGER NOT NULL,
                sprint_id INTEGER NOT NULL,
                estado VARCHAR NOT NULL,
                id_usuario INTEGER NOT NULL,
                CONSTRAINT story_pk PRIMARY KEY (id_tarea)
);


ALTER TABLE public.Usuario_Rol ADD CONSTRAINT rol_usuario_rol_fk
FOREIGN KEY (id_rol)
REFERENCES public.Rol (id_rol)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Story ADD CONSTRAINT usuario_story_fk
FOREIGN KEY (id_usuario)
REFERENCES public.Usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Usuario_Rol ADD CONSTRAINT usuario_usuario_rol_fk
FOREIGN KEY (id_usuario)
REFERENCES public.Usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Backlog ADD CONSTRAINT proyecto_backlog_fk
FOREIGN KEY (id_proyecto)
REFERENCES public.Proyecto (id_proyecto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Sprint ADD CONSTRAINT proyecto_sprint_fk
FOREIGN KEY (id_proyecto)
REFERENCES public.Proyecto (id_proyecto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Usuario_Rol ADD CONSTRAINT proyecto_equipo_fk
FOREIGN KEY (id_proyecto)
REFERENCES public.Proyecto (id_proyecto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Requerimiento ADD CONSTRAINT backlog_requerimiento_fk
FOREIGN KEY (id_backlog)
REFERENCES public.Backlog (id_backlog)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Story ADD CONSTRAINT sprint_tarea_sprint_fk
FOREIGN KEY (sprint_id)
REFERENCES public.Sprint (sprint_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
