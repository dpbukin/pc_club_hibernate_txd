PGDMP         -                {            PC_club    15.3    15.3 S    J           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            K           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            L           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            M           1262    33293    PC_club    DATABASE     }   CREATE DATABASE "PC_club" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Europe.1251';
    DROP DATABASE "PC_club";
                postgres    false            �            1259    33294    clients    TABLE     o   CREATE TABLE public.clients (
    client_id bigint NOT NULL,
    human_id bigint,
    account_score integer
);
    DROP TABLE public.clients;
       public         heap    postgres    false            �            1259    33379    clients_clientId_seq    SEQUENCE        CREATE SEQUENCE public."clients_clientId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public."clients_clientId_seq";
       public          postgres    false    214            N           0    0    clients_clientId_seq    SEQUENCE OWNED BY     P   ALTER SEQUENCE public."clients_clientId_seq" OWNED BY public.clients.client_id;
          public          postgres    false    220            �            1259    33524    clients_humanID_seq    SEQUENCE     ~   CREATE SEQUENCE public."clients_humanID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public."clients_humanID_seq";
       public          postgres    false    214            O           0    0    clients_humanID_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public."clients_humanID_seq" OWNED BY public.clients.human_id;
          public          postgres    false    232            �            1259    33301    computer_clubs    TABLE     7  CREATE TABLE public.computer_clubs (
    club_id bigint NOT NULL,
    room_rental_agreement_number character varying(16),
    region character varying(32),
    city character varying(32),
    street character varying(32),
    building integer,
    job_status character varying(16),
    office_number integer
);
 "   DROP TABLE public.computer_clubs;
       public         heap    postgres    false            �            1259    33386    computerClubs_clubId_seq    SEQUENCE     �   CREATE SEQUENCE public."computerClubs_clubId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."computerClubs_clubId_seq";
       public          postgres    false    216            P           0    0    computerClubs_clubId_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public."computerClubs_clubId_seq" OWNED BY public.computer_clubs.club_id;
          public          postgres    false    221            �            1259    33298 	   computers    TABLE     T  CREATE TABLE public.computers (
    computer_id bigint NOT NULL,
    serial_number character varying(16),
    processor_model character varying(32),
    ram_capacity character varying(16),
    video_card_model character varying(32),
    hard_disk_capacity character varying(16),
    status character varying(16),
    comp_club_id bigint
);
    DROP TABLE public.computers;
       public         heap    postgres    false            �            1259    33433    computers_compClubID_seq    SEQUENCE     �   CREATE SEQUENCE public."computers_compClubID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."computers_compClubID_seq";
       public          postgres    false    215            Q           0    0    computers_compClubID_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public."computers_compClubID_seq" OWNED BY public.computers.comp_club_id;
          public          postgres    false    227            �            1259    33394    computers_computerId_seq    SEQUENCE     �   CREATE SEQUENCE public."computers_computerId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."computers_computerId_seq";
       public          postgres    false    215            R           0    0    computers_computerId_seq    SEQUENCE OWNED BY     X   ALTER SEQUENCE public."computers_computerId_seq" OWNED BY public.computers.computer_id;
          public          postgres    false    222            �            1259    33307 	   employees    TABLE     �   CREATE TABLE public.employees (
    employee_id bigint NOT NULL,
    contract_number character varying(16),
    "position" character varying(32),
    human_id bigint
);
    DROP TABLE public.employees;
       public         heap    postgres    false            �            1259    33401    employees_employeeId_seq    SEQUENCE     �   CREATE SEQUENCE public."employees_employeeId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public."employees_employeeId_seq";
       public          postgres    false    217            S           0    0    employees_employeeId_seq    SEQUENCE OWNED BY     X   ALTER SEQUENCE public."employees_employeeId_seq" OWNED BY public.employees.employee_id;
          public          postgres    false    223            �            1259    33427    employees_humanID_seq    SEQUENCE     �   CREATE SEQUENCE public."employees_humanID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."employees_humanID_seq";
       public          postgres    false    217            T           0    0    employees_humanID_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public."employees_humanID_seq" OWNED BY public.employees.human_id;
          public          postgres    false    226            �            1259    33535    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    33312    humans    TABLE     �   CREATE TABLE public.humans (
    human_id bigint NOT NULL,
    name character varying(16),
    surname character varying(16),
    otchestvo character varying(16),
    phone_number character varying(16),
    email character varying(32),
    age integer
);
    DROP TABLE public.humans;
       public         heap    postgres    false            �            1259    33408    humans_humanId_seq    SEQUENCE     }   CREATE SEQUENCE public."humans_humanId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."humans_humanId_seq";
       public          postgres    false    218            U           0    0    humans_humanId_seq    SEQUENCE OWNED BY     L   ALTER SEQUENCE public."humans_humanId_seq" OWNED BY public.humans.human_id;
          public          postgres    false    224            �            1259    33316    subscriptions    TABLE     �  CREATE TABLE public.subscriptions (
    subscription_id bigint NOT NULL,
    unique_subscription_number character varying(16),
    type character varying(16),
    cost integer,
    validity_period character varying(16),
    registration_date character varying(16),
    status character varying(16),
    computer_id bigint,
    employee_id bigint,
    client_id bigint,
    comp_club_id bigint
);
 !   DROP TABLE public.subscriptions;
       public         heap    postgres    false            �            1259    33491    subscriptions_clientID_seq    SEQUENCE     �   CREATE SEQUENCE public."subscriptions_clientID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public."subscriptions_clientID_seq";
       public          postgres    false    219            V           0    0    subscriptions_clientID_seq    SEQUENCE OWNED BY     \   ALTER SEQUENCE public."subscriptions_clientID_seq" OWNED BY public.subscriptions.client_id;
          public          postgres    false    230            �            1259    33497    subscriptions_compClubID_seq    SEQUENCE     �   CREATE SEQUENCE public."subscriptions_compClubID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public."subscriptions_compClubID_seq";
       public          postgres    false    219            W           0    0    subscriptions_compClubID_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public."subscriptions_compClubID_seq" OWNED BY public.subscriptions.comp_club_id;
          public          postgres    false    231            �            1259    33479    subscriptions_computerID_seq    SEQUENCE     �   CREATE SEQUENCE public."subscriptions_computerID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public."subscriptions_computerID_seq";
       public          postgres    false    219            X           0    0    subscriptions_computerID_seq    SEQUENCE OWNED BY     `   ALTER SEQUENCE public."subscriptions_computerID_seq" OWNED BY public.subscriptions.computer_id;
          public          postgres    false    228            �            1259    33485    subscriptions_employeeID_seq    SEQUENCE     �   CREATE SEQUENCE public."subscriptions_employeeID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public."subscriptions_employeeID_seq";
       public          postgres    false    219            Y           0    0    subscriptions_employeeID_seq    SEQUENCE OWNED BY     `   ALTER SEQUENCE public."subscriptions_employeeID_seq" OWNED BY public.subscriptions.employee_id;
          public          postgres    false    229            �            1259    33415     subscriptions_subscriptionId_seq    SEQUENCE     �   CREATE SEQUENCE public."subscriptions_subscriptionId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public."subscriptions_subscriptionId_seq";
       public          postgres    false    219            Z           0    0     subscriptions_subscriptionId_seq    SEQUENCE OWNED BY     h   ALTER SEQUENCE public."subscriptions_subscriptionId_seq" OWNED BY public.subscriptions.subscription_id;
          public          postgres    false    225            �           2604    33380    clients client_id    DEFAULT     w   ALTER TABLE ONLY public.clients ALTER COLUMN client_id SET DEFAULT nextval('public."clients_clientId_seq"'::regclass);
 @   ALTER TABLE public.clients ALTER COLUMN client_id DROP DEFAULT;
       public          postgres    false    220    214            �           2604    33525    clients human_id    DEFAULT     u   ALTER TABLE ONLY public.clients ALTER COLUMN human_id SET DEFAULT nextval('public."clients_humanID_seq"'::regclass);
 ?   ALTER TABLE public.clients ALTER COLUMN human_id DROP DEFAULT;
       public          postgres    false    232    214            �           2604    33387    computer_clubs club_id    DEFAULT     �   ALTER TABLE ONLY public.computer_clubs ALTER COLUMN club_id SET DEFAULT nextval('public."computerClubs_clubId_seq"'::regclass);
 E   ALTER TABLE public.computer_clubs ALTER COLUMN club_id DROP DEFAULT;
       public          postgres    false    221    216            �           2604    33395    computers computer_id    DEFAULT        ALTER TABLE ONLY public.computers ALTER COLUMN computer_id SET DEFAULT nextval('public."computers_computerId_seq"'::regclass);
 D   ALTER TABLE public.computers ALTER COLUMN computer_id DROP DEFAULT;
       public          postgres    false    222    215            �           2604    33434    computers comp_club_id    DEFAULT     �   ALTER TABLE ONLY public.computers ALTER COLUMN comp_club_id SET DEFAULT nextval('public."computers_compClubID_seq"'::regclass);
 E   ALTER TABLE public.computers ALTER COLUMN comp_club_id DROP DEFAULT;
       public          postgres    false    227    215            �           2604    33402    employees employee_id    DEFAULT        ALTER TABLE ONLY public.employees ALTER COLUMN employee_id SET DEFAULT nextval('public."employees_employeeId_seq"'::regclass);
 D   ALTER TABLE public.employees ALTER COLUMN employee_id DROP DEFAULT;
       public          postgres    false    223    217            �           2604    33428    employees human_id    DEFAULT     y   ALTER TABLE ONLY public.employees ALTER COLUMN human_id SET DEFAULT nextval('public."employees_humanID_seq"'::regclass);
 A   ALTER TABLE public.employees ALTER COLUMN human_id DROP DEFAULT;
       public          postgres    false    226    217            �           2604    33409    humans human_id    DEFAULT     s   ALTER TABLE ONLY public.humans ALTER COLUMN human_id SET DEFAULT nextval('public."humans_humanId_seq"'::regclass);
 >   ALTER TABLE public.humans ALTER COLUMN human_id DROP DEFAULT;
       public          postgres    false    224    218            �           2604    33416    subscriptions subscription_id    DEFAULT     �   ALTER TABLE ONLY public.subscriptions ALTER COLUMN subscription_id SET DEFAULT nextval('public."subscriptions_subscriptionId_seq"'::regclass);
 L   ALTER TABLE public.subscriptions ALTER COLUMN subscription_id DROP DEFAULT;
       public          postgres    false    225    219            �           2604    33480    subscriptions computer_id    DEFAULT     �   ALTER TABLE ONLY public.subscriptions ALTER COLUMN computer_id SET DEFAULT nextval('public."subscriptions_computerID_seq"'::regclass);
 H   ALTER TABLE public.subscriptions ALTER COLUMN computer_id DROP DEFAULT;
       public          postgres    false    228    219            �           2604    33486    subscriptions employee_id    DEFAULT     �   ALTER TABLE ONLY public.subscriptions ALTER COLUMN employee_id SET DEFAULT nextval('public."subscriptions_employeeID_seq"'::regclass);
 H   ALTER TABLE public.subscriptions ALTER COLUMN employee_id DROP DEFAULT;
       public          postgres    false    229    219            �           2604    33492    subscriptions client_id    DEFAULT     �   ALTER TABLE ONLY public.subscriptions ALTER COLUMN client_id SET DEFAULT nextval('public."subscriptions_clientID_seq"'::regclass);
 F   ALTER TABLE public.subscriptions ALTER COLUMN client_id DROP DEFAULT;
       public          postgres    false    230    219            �           2604    33498    subscriptions comp_club_id    DEFAULT     �   ALTER TABLE ONLY public.subscriptions ALTER COLUMN comp_club_id SET DEFAULT nextval('public."subscriptions_compClubID_seq"'::regclass);
 I   ALTER TABLE public.subscriptions ALTER COLUMN comp_club_id DROP DEFAULT;
       public          postgres    false    231    219            4          0    33294    clients 
   TABLE DATA           E   COPY public.clients (client_id, human_id, account_score) FROM stdin;
    public          postgres    false    214   td       6          0    33301    computer_clubs 
   TABLE DATA           �   COPY public.computer_clubs (club_id, room_rental_agreement_number, region, city, street, building, job_status, office_number) FROM stdin;
    public          postgres    false    216   �d       5          0    33298 	   computers 
   TABLE DATA           �   COPY public.computers (computer_id, serial_number, processor_model, ram_capacity, video_card_model, hard_disk_capacity, status, comp_club_id) FROM stdin;
    public          postgres    false    215   ?f       7          0    33307 	   employees 
   TABLE DATA           W   COPY public.employees (employee_id, contract_number, "position", human_id) FROM stdin;
    public          postgres    false    217   Eg       8          0    33312    humans 
   TABLE DATA           ^   COPY public.humans (human_id, name, surname, otchestvo, phone_number, email, age) FROM stdin;
    public          postgres    false    218   �g       9          0    33316    subscriptions 
   TABLE DATA           �   COPY public.subscriptions (subscription_id, unique_subscription_number, type, cost, validity_period, registration_date, status, computer_id, employee_id, client_id, comp_club_id) FROM stdin;
    public          postgres    false    219   �k       [           0    0    clients_clientId_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."clients_clientId_seq"', 13, true);
          public          postgres    false    220            \           0    0    clients_humanID_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public."clients_humanID_seq"', 13, true);
          public          postgres    false    232            ]           0    0    computerClubs_clubId_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."computerClubs_clubId_seq"', 7, true);
          public          postgres    false    221            ^           0    0    computers_compClubID_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."computers_compClubID_seq"', 20, true);
          public          postgres    false    227            _           0    0    computers_computerId_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."computers_computerId_seq"', 20, true);
          public          postgres    false    222            `           0    0    employees_employeeId_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public."employees_employeeId_seq"', 10, true);
          public          postgres    false    223            a           0    0    employees_humanID_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."employees_humanID_seq"', 10, true);
          public          postgres    false    226            b           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    233            c           0    0    humans_humanId_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."humans_humanId_seq"', 23, true);
          public          postgres    false    224            d           0    0    subscriptions_clientID_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public."subscriptions_clientID_seq"', 13, true);
          public          postgres    false    230            e           0    0    subscriptions_compClubID_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public."subscriptions_compClubID_seq"', 13, true);
          public          postgres    false    231            f           0    0    subscriptions_computerID_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public."subscriptions_computerID_seq"', 13, true);
          public          postgres    false    228            g           0    0    subscriptions_employeeID_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public."subscriptions_employeeID_seq"', 13, true);
          public          postgres    false    229            h           0    0     subscriptions_subscriptionId_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public."subscriptions_subscriptionId_seq"', 13, true);
          public          postgres    false    225            �           2606    33385    clients clients_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (client_id);
 >   ALTER TABLE ONLY public.clients DROP CONSTRAINT clients_pkey;
       public            postgres    false    214            �           2606    33392 !   computer_clubs computerClubs_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.computer_clubs
    ADD CONSTRAINT "computerClubs_pkey" PRIMARY KEY (club_id);
 M   ALTER TABLE ONLY public.computer_clubs DROP CONSTRAINT "computerClubs_pkey";
       public            postgres    false    216            �           2606    33400    computers computers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.computers
    ADD CONSTRAINT computers_pkey PRIMARY KEY (computer_id);
 B   ALTER TABLE ONLY public.computers DROP CONSTRAINT computers_pkey;
       public            postgres    false    215            �           2606    33407    employees employees_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (employee_id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            postgres    false    217            �           2606    33414    humans humans_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.humans
    ADD CONSTRAINT humans_pkey PRIMARY KEY (human_id);
 <   ALTER TABLE ONLY public.humans DROP CONSTRAINT humans_pkey;
       public            postgres    false    218            �           2606    33421     subscriptions subscriptions_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT subscriptions_pkey PRIMARY KEY (subscription_id);
 J   ALTER TABLE ONLY public.subscriptions DROP CONSTRAINT subscriptions_pkey;
       public            postgres    false    219            �           2606    33530    clients clients_humanID_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.clients
    ADD CONSTRAINT "clients_humanID_fkey" FOREIGN KEY (human_id) REFERENCES public.humans(human_id) NOT VALID;
 H   ALTER TABLE ONLY public.clients DROP CONSTRAINT "clients_humanID_fkey";
       public          postgres    false    218    3228    214            �           2606    33439 #   computers computers_compClubID_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.computers
    ADD CONSTRAINT "computers_compClubID_fkey" FOREIGN KEY (comp_club_id) REFERENCES public.computer_clubs(club_id) NOT VALID;
 O   ALTER TABLE ONLY public.computers DROP CONSTRAINT "computers_compClubID_fkey";
       public          postgres    false    216    215    3224            �           2606    33546 %   employees fkjb27riyg43820pqtkkf98bulb    FK CONSTRAINT     �   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fkjb27riyg43820pqtkkf98bulb FOREIGN KEY (human_id) REFERENCES public.humans(human_id);
 O   ALTER TABLE ONLY public.employees DROP CONSTRAINT fkjb27riyg43820pqtkkf98bulb;
       public          postgres    false    217    218    3228            �           2606    33503 )   subscriptions subscriptions_clientID_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT "subscriptions_clientID_fkey" FOREIGN KEY (client_id) REFERENCES public.clients(client_id) NOT VALID;
 U   ALTER TABLE ONLY public.subscriptions DROP CONSTRAINT "subscriptions_clientID_fkey";
       public          postgres    false    214    219    3220            �           2606    33508 +   subscriptions subscriptions_compClubID_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT "subscriptions_compClubID_fkey" FOREIGN KEY (comp_club_id) REFERENCES public.computer_clubs(club_id) NOT VALID;
 W   ALTER TABLE ONLY public.subscriptions DROP CONSTRAINT "subscriptions_compClubID_fkey";
       public          postgres    false    216    219    3224            �           2606    33518 +   subscriptions subscriptions_computerID_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT "subscriptions_computerID_fkey" FOREIGN KEY (computer_id) REFERENCES public.computers(computer_id) NOT VALID;
 W   ALTER TABLE ONLY public.subscriptions DROP CONSTRAINT "subscriptions_computerID_fkey";
       public          postgres    false    219    215    3222            �           2606    33513 +   subscriptions subscriptions_employeeID_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.subscriptions
    ADD CONSTRAINT "subscriptions_employeeID_fkey" FOREIGN KEY (employee_id) REFERENCES public.employees(employee_id) NOT VALID;
 W   ALTER TABLE ONLY public.subscriptions DROP CONSTRAINT "subscriptions_employeeID_fkey";
       public          postgres    false    217    3226    219            4   S   x�5ι�@B����9�����a[��e_*�71F0�F�PF��Fsb��X�����15���%��;TB.Q�H>V �      6   X  x���Kn�@�מSp����ޅ3��,��HUR��UR�4�DC W�ܨ��T�D�"����o~�)�\���<�?so��7�]����\�̬��ğ0R���CHϵ�5y�o\ Co2ܵ�(��T��zgA��[s�Ӛ��Bbq7���F�����-i=�Aǡ�m���+��J?p!�I���L_G*�̀xm�G�����pG����O贓'��EƜZ�@B���?F��������R*JA� ?�q�S��3!��Dq�"[FD|'$D6�Ҝ���ȇ��l���u)�����)n��rc�`#才�������o���_�Z�(� k���R�2i#      5   �   x���1j�0��Y�:AГl9C�t�b<x�0%Yک�E�Q
C� ߨ��m��<}ؘ���I�9��q8�[����vS��imꦵ�EgX>�~���c�_�{�ȧ|6L�W@�5Q�(���@i����_�����"�6ʓm��F�#��
F�����0�S�#�&v?�̄�0�I����S5�Q*�/�2����n�*R��	r/UF}d*���N��@�2Z��O��fD�����      7   �   x�}�M
�@�ur�L;?�K��jA�@<A+E�gxs#S�lq��^B"��sN��h=��X:��������aE���Ҁ��$rmX�
oL:=�C�5:�s��=I�`�@���q��P�h�� i8Y,�����a�@�ư�@��~�m�����1��.��      8   �  x����r�6����dH��Ϯ�$�
*QP)�������"��M2�x�i�龊lM[r^|���URn��������^x��ffn6O���,j�*^�8�\/a>�\���Xɮ�4��M�0����2B�C���W��8���*>^�/�|�ĉ�D�s%�q=���������8>1�Ŭ8-.�ڂϋ�%k��4��6@���K��%1���l�>����������K�/!��2��b�����EA$�EK��n�jZW�÷�s�mqB�k�ߚ�ܕ��?�� �0r��D<�!۹T���	���ܬ����O+�y��}����.�n��2M���M���{\x�k��vgǅ���kt��Fƹ�2i���8~� 1�K����EH�����őʲF�"' z��31��������^���	ɎU\�;H<Xs�{����`��L�u��R�P$,"�\LQ21�ݼ�	
���Y�.�Ɩ�~��.mX�]�=��%GJ�D�/G�%�-�?ڨ�a�[� ̊�v�{�=�uC�x�K#2ߋNG���q�L���{���+C-�W�Kq֔>ߞ���4�$&�E�8�]�&?�"xc��mY�����8B�T�窧q�j�z����BM��k��K�}-^�G��V}� �8pC��Y�0�BsX^!�.�9���]Zޕ�Y��7����1F+���5E�t�/eMoʎYY�����n�|�TN�z�'���Gb0�UNQ~̸�����ޜ?n��n��(�}�&$�sd�t���a%��ue�r�(;��B ��P��'I���E	Gr��o^ԭ�k���ZTz�t;���X����X�ǇW��W���
ۦ
�#�\���q��:\���<6-��Z.@.^`lm��}Iq$��FJ��'d��J����0�͹H�G��^J�ϻ��o��X@q2Uc��-�F7C���8� ��3�      9   �   x���=nA��>EN���Ӧ�K��&����� g�@$�0�Q�F�� ����;��g��~���U����q�q����O�L��h|���a����H2e2VW4�j�$l�X@�4����Jƅ׏�vC��d�P����š�LT��OӜi&#�̳3s�)HAsw���睁%@�~�%uH��(IAj����[�lhIY�A_j���T�-��e#�zb��Q     