--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: accounts; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.accounts (
    account_id bigint NOT NULL,
    account_name character varying(255),
    creation_date timestamp without time zone,
    state boolean,
    update_date timestamp without time zone
);


ALTER TABLE public.accounts OWNER TO test;

--
-- Name: accounts_list_devices; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.accounts_list_devices (
    account_account_id bigint NOT NULL,
    list_devices_device_id bigint NOT NULL
);


ALTER TABLE public.accounts_list_devices OWNER TO test;

--
-- Name: accounts_services; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.accounts_services (
    account_id bigint NOT NULL,
    service_id bigint NOT NULL
);


ALTER TABLE public.accounts_services OWNER TO test;

--
-- Name: companies; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.companies (
    company_id bigint NOT NULL,
    company_name character varying(255),
    creation_date timestamp without time zone,
    state boolean,
    update_date timestamp without time zone
);


ALTER TABLE public.companies OWNER TO test;

--
-- Name: companies_company_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE public.companies_company_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.companies_company_id_seq OWNER TO test;

--
-- Name: companies_company_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE public.companies_company_id_seq OWNED BY public.companies.company_id;


--
-- Name: customers; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    creation_date timestamp without time zone,
    customer_name character varying(255),
    update_date timestamp without time zone,
    account_id bigint
);


ALTER TABLE public.customers OWNER TO test;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customers_customer_id_seq OWNER TO test;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;


--
-- Name: devices; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.devices (
    device_id bigint NOT NULL,
    creation_date timestamp without time zone,
    device_name character varying(255),
    state boolean,
    type character varying(255),
    update_date timestamp without time zone,
    account_id bigint
);


ALTER TABLE public.devices OWNER TO test;

--
-- Name: devices_device_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE public.devices_device_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.devices_device_id_seq OWNER TO test;

--
-- Name: devices_device_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE public.devices_device_id_seq OWNED BY public.devices.device_id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO test;

--
-- Name: list_price; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.list_price (
    list_price_id bigint NOT NULL,
    price double precision,
    type character varying(255),
    service_id bigint
);


ALTER TABLE public.list_price OWNER TO test;

--
-- Name: list_price_list_price_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE public.list_price_list_price_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.list_price_list_price_id_seq OWNER TO test;

--
-- Name: list_price_list_price_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE public.list_price_list_price_id_seq OWNED BY public.list_price.list_price_id;


--
-- Name: services; Type: TABLE; Schema: public; Owner: test
--

CREATE TABLE public.services (
    service_id bigint NOT NULL,
    apply_type boolean,
    creation_date timestamp without time zone,
    creation_user character varying(255),
    service_name character varying(255),
    state boolean,
    update_date timestamp without time zone,
    update_user character varying(255)
);


ALTER TABLE public.services OWNER TO test;

--
-- Name: services_service_id_seq; Type: SEQUENCE; Schema: public; Owner: test
--

CREATE SEQUENCE public.services_service_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.services_service_id_seq OWNER TO test;

--
-- Name: services_service_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test
--

ALTER SEQUENCE public.services_service_id_seq OWNED BY public.services.service_id;


--
-- Name: companies company_id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.companies ALTER COLUMN company_id SET DEFAULT nextval('public.companies_company_id_seq'::regclass);


--
-- Name: customers customer_id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);


--
-- Name: devices device_id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.devices ALTER COLUMN device_id SET DEFAULT nextval('public.devices_device_id_seq'::regclass);


--
-- Name: list_price list_price_id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.list_price ALTER COLUMN list_price_id SET DEFAULT nextval('public.list_price_list_price_id_seq'::regclass);


--
-- Name: services service_id; Type: DEFAULT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.services ALTER COLUMN service_id SET DEFAULT nextval('public.services_service_id_seq'::regclass);


--
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.accounts (account_id, account_name, creation_date, state, update_date) FROM stdin;
2	Edison Mora 2022-01-10T12:13:29.962191	2022-01-10 12:13:29.962427	t	\N
\.


--
-- Data for Name: accounts_list_devices; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.accounts_list_devices (account_account_id, list_devices_device_id) FROM stdin;
2	1
2	2
2	3
2	4
2	5
\.


--
-- Data for Name: accounts_services; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.accounts_services (account_id, service_id) FROM stdin;
2	1
2	2
2	3
\.


--
-- Data for Name: companies; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.companies (company_id, company_name, creation_date, state, update_date) FROM stdin;
\.


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.customers (customer_id, creation_date, customer_name, update_date, account_id) FROM stdin;
1	\N	Edison Mora	\N	2
\.


--
-- Data for Name: devices; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.devices (device_id, creation_date, device_name, state, type, update_date, account_id) FROM stdin;
1	\N	PC 2	t	WindowsWorkstation	\N	2
2	\N	PC 1	t	WindowsServer	\N	2
3	\N	Mac 1	t	Mac	\N	2
4	\N	Mac 2	t	Mac	\N	2
5	\N	Mac 3	t	Mac	\N	2
\.


--
-- Data for Name: list_price; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.list_price (list_price_id, price, type, service_id) FROM stdin;
1	1	\N	1
2	7	Mac	2
3	5	WindowsWorkstation	2
4	5	WindowsServer	2
5	3	\N	3
6	2	\N	4
\.


--
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: test
--

COPY public.services (service_id, apply_type, creation_date, creation_user, service_name, state, update_date, update_user) FROM stdin;
1	f	\N	UserDefault	TeamViewer	t	\N	\N
2	t	\N	UserDefault	Antivirus	t	\N	\N
3	f	\N	UserDefault	CloudBerry	t	\N	\N
4	f	\N	UserDefault	PSA	t	\N	\N
\.


--
-- Name: companies_company_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('public.companies_company_id_seq', 1, false);


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('public.customers_customer_id_seq', 1, true);


--
-- Name: devices_device_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('public.devices_device_id_seq', 6, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('public.hibernate_sequence', 2, true);


--
-- Name: list_price_list_price_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('public.list_price_list_price_id_seq', 6, true);


--
-- Name: services_service_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test
--

SELECT pg_catalog.setval('public.services_service_id_seq', 4, true);


--
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (account_id);


--
-- Name: accounts_services accounts_services_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts_services
    ADD CONSTRAINT accounts_services_pkey PRIMARY KEY (account_id, service_id);


--
-- Name: companies companies_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.companies
    ADD CONSTRAINT companies_pkey PRIMARY KEY (company_id);


--
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);


--
-- Name: devices devices_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT devices_pkey PRIMARY KEY (device_id);


--
-- Name: list_price list_price_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.list_price
    ADD CONSTRAINT list_price_pkey PRIMARY KEY (list_price_id);


--
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (service_id);


--
-- Name: accounts_list_devices uk_c4rhpd0tenu5l8u4o7rq6pc2f; Type: CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts_list_devices
    ADD CONSTRAINT uk_c4rhpd0tenu5l8u4o7rq6pc2f UNIQUE (list_devices_device_id);


--
-- Name: accounts_list_devices fk3mk1rml1f7jos65bmuchlifae; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts_list_devices
    ADD CONSTRAINT fk3mk1rml1f7jos65bmuchlifae FOREIGN KEY (list_devices_device_id) REFERENCES public.devices(device_id);


--
-- Name: accounts_list_devices fk619uy1xfq3l2k83i2ll977t6; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts_list_devices
    ADD CONSTRAINT fk619uy1xfq3l2k83i2ll977t6 FOREIGN KEY (account_account_id) REFERENCES public.accounts(account_id);


--
-- Name: accounts_services fk6mkoe8ndeurt6x8rdx5la8ii4; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts_services
    ADD CONSTRAINT fk6mkoe8ndeurt6x8rdx5la8ii4 FOREIGN KEY (account_id) REFERENCES public.accounts(account_id);


--
-- Name: devices fkcr2kplm4cgs2x2xl3h04ryqvs; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.devices
    ADD CONSTRAINT fkcr2kplm4cgs2x2xl3h04ryqvs FOREIGN KEY (account_id) REFERENCES public.accounts(account_id);


--
-- Name: list_price fkf83df8l46827qqm7rqmnytepd; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.list_price
    ADD CONSTRAINT fkf83df8l46827qqm7rqmnytepd FOREIGN KEY (service_id) REFERENCES public.services(service_id);


--
-- Name: accounts_services fkoqb0hsn9nh9623paucb290is0; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.accounts_services
    ADD CONSTRAINT fkoqb0hsn9nh9623paucb290is0 FOREIGN KEY (service_id) REFERENCES public.services(service_id);


--
-- Name: customers fkor0fx9fttvasr4grtaqnltyrl; Type: FK CONSTRAINT; Schema: public; Owner: test
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT fkor0fx9fttvasr4grtaqnltyrl FOREIGN KEY (account_id) REFERENCES public.accounts(account_id);


--
-- PostgreSQL database dump complete
--

