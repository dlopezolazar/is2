--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.13
-- Dumped by pg_dump version 9.4.13
-- Started on 2018-03-19 12:01:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 177 (class 1259 OID 16424)
-- Name: backlog; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE backlog (
    id_backlog character varying NOT NULL,
    id_proyecto integer NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE backlog OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16410)
-- Name: proyecto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proyecto (
    id_proyecto integer NOT NULL,
    nombre character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL
);


ALTER TABLE proyecto OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16432)
-- Name: requerimiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE requerimiento (
    id_requerimiento integer NOT NULL,
    id_backlog character varying NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE requerimiento OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16394)
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rol (
    id_rol integer NOT NULL,
    rol_descripcion character varying NOT NULL
);


ALTER TABLE rol OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16496)
-- Name: sesion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sesion (
    id_sesion integer NOT NULL,
    access_token character varying,
    sesion_fecha_hora timestamp with time zone,
    estado_session integer,
    usuario integer
);


ALTER TABLE sesion OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16440)
-- Name: sprint; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sprint (
    sprint_id integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin character varying NOT NULL,
    sprint_description character varying NOT NULL,
    id_proyecto integer NOT NULL
);


ALTER TABLE sprint OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 16448)
-- Name: story; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE story (
    id_tarea integer NOT NULL,
    sprint_id integer NOT NULL,
    estado character varying NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE story OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16402)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    nombre_completo character varying NOT NULL,
    correo character varying NOT NULL,
    uid character varying,
    password character varying
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16418)
-- Name: usuario_rol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario_rol (
    id_usuario_rol integer NOT NULL,
    id_proyecto integer,
    id_rol integer NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE usuario_rol OWNER TO postgres;

--
-- TOC entry 2060 (class 0 OID 16424)
-- Dependencies: 177
-- Data for Name: backlog; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY backlog (id_backlog, id_proyecto, descripcion) FROM stdin;
\.


--
-- TOC entry 2058 (class 0 OID 16410)
-- Dependencies: 175
-- Data for Name: proyecto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY proyecto (id_proyecto, nombre, fecha_inicio, fecha_fin) FROM stdin;
\.


--
-- TOC entry 2061 (class 0 OID 16432)
-- Dependencies: 178
-- Data for Name: requerimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY requerimiento (id_requerimiento, id_backlog, descripcion) FROM stdin;
\.


--
-- TOC entry 2056 (class 0 OID 16394)
-- Dependencies: 173
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rol (id_rol, rol_descripcion) FROM stdin;
\.


--
-- TOC entry 2064 (class 0 OID 16496)
-- Dependencies: 181
-- Data for Name: sesion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sesion (id_sesion, access_token, sesion_fecha_hora, estado_session, usuario) FROM stdin;
\.


--
-- TOC entry 2062 (class 0 OID 16440)
-- Dependencies: 179
-- Data for Name: sprint; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sprint (sprint_id, fecha_inicio, fecha_fin, sprint_description, id_proyecto) FROM stdin;
\.


--
-- TOC entry 2063 (class 0 OID 16448)
-- Dependencies: 180
-- Data for Name: story; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY story (id_tarea, sprint_id, estado, id_usuario) FROM stdin;
\.


--
-- TOC entry 2057 (class 0 OID 16402)
-- Dependencies: 174
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id_usuario, nombre_completo, correo, uid, password) FROM stdin;
1	Diego	dlopezolazar93@gmail.com	dlopez	MTIzNDU2
2	Juan Jose	jjosesantacruz@gmail.com	jsantacruz	MTIzNDU2
3	Cami	lameza@gmail.com	cmeza	MTIzNDU2
\.


--
-- TOC entry 2059 (class 0 OID 16418)
-- Dependencies: 176
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario_rol (id_usuario_rol, id_proyecto, id_rol, id_usuario) FROM stdin;
\.


--
-- TOC entry 1929 (class 2606 OID 16431)
-- Name: backlog_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY backlog
    ADD CONSTRAINT backlog_pk PRIMARY KEY (id_backlog);


--
-- TOC entry 1924 (class 2606 OID 16417)
-- Name: proyecto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proyecto
    ADD CONSTRAINT proyecto_pk PRIMARY KEY (id_proyecto);


--
-- TOC entry 1931 (class 2606 OID 16439)
-- Name: requerimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY requerimiento
    ADD CONSTRAINT requerimiento_pk PRIMARY KEY (id_requerimiento);


--
-- TOC entry 1920 (class 2606 OID 16401)
-- Name: rol_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rol
    ADD CONSTRAINT rol_pk PRIMARY KEY (id_rol);


--
-- TOC entry 1937 (class 2606 OID 16500)
-- Name: session_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT session_pk PRIMARY KEY (id_sesion);


--
-- TOC entry 1933 (class 2606 OID 16447)
-- Name: sprint_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sprint
    ADD CONSTRAINT sprint_pk PRIMARY KEY (sprint_id);


--
-- TOC entry 1935 (class 2606 OID 16455)
-- Name: story_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY story
    ADD CONSTRAINT story_pk PRIMARY KEY (id_tarea);


--
-- TOC entry 1922 (class 2606 OID 16409)
-- Name: usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id_usuario);


--
-- TOC entry 1927 (class 2606 OID 16422)
-- Name: usuario_rol_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT usuario_rol_pk PRIMARY KEY (id_usuario_rol);


--
-- TOC entry 1925 (class 1259 OID 16423)
-- Name: equipo_uk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX equipo_uk ON usuario_rol USING btree (id_usuario_rol);


--
-- TOC entry 1942 (class 2606 OID 16486)
-- Name: backlog_requerimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY requerimiento
    ADD CONSTRAINT backlog_requerimiento_fk FOREIGN KEY (id_backlog) REFERENCES backlog(id_backlog);


--
-- TOC entry 1941 (class 2606 OID 16471)
-- Name: proyecto_backlog_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY backlog
    ADD CONSTRAINT proyecto_backlog_fk FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto);


--
-- TOC entry 1940 (class 2606 OID 16481)
-- Name: proyecto_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT proyecto_equipo_fk FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto);


--
-- TOC entry 1943 (class 2606 OID 16476)
-- Name: proyecto_sprint_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sprint
    ADD CONSTRAINT proyecto_sprint_fk FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto);


--
-- TOC entry 1938 (class 2606 OID 16456)
-- Name: rol_usuario_rol_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT rol_usuario_rol_fk FOREIGN KEY (id_rol) REFERENCES rol(id_rol);


--
-- TOC entry 1946 (class 2606 OID 16504)
-- Name: sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT sesion_fk FOREIGN KEY (usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 1945 (class 2606 OID 16491)
-- Name: sprint_tarea_sprint_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY story
    ADD CONSTRAINT sprint_tarea_sprint_fk FOREIGN KEY (sprint_id) REFERENCES sprint(sprint_id);


--
-- TOC entry 1944 (class 2606 OID 16461)
-- Name: usuario_story_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY story
    ADD CONSTRAINT usuario_story_fk FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 1939 (class 2606 OID 16466)
-- Name: usuario_usuario_rol_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT usuario_usuario_rol_fk FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 2071 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-03-19 12:01:50

--
-- PostgreSQL database dump complete
--

