use master
/*���˱�*/
CREATE TABLE Patient
(Pno CHAR(20) PRIMARY KEY,
 Pname CHAR(20),
 Psex CHAR(20),
 Pbirthday CHAR(20),/*��������*/
 Pplace CHAR(20),  /*������*/
 Pbirthplace CHAR(20),/*����*/
 Pcondition CHAR(20),/*סԺ���*/
 Pbudget CHAR(20)/*Ԥ֧������*/
 );
/*ҽԺԱ����*/
CREATE TABLE Doctor
(Dname char(20) primary key,
 Dno char(20),
 Dage char(20),
 Dtelephone char(20),/*��ϵ�绰*/
 Dsex char(20),
 Drecord char(20),/*ѧ��*/
 Dposition char(20),/*ְ��*/
 Djudgement char(900),/*��������*/
 Dexperience char(2000)/*��������*/
);
/*������*/
CREATE TABLE Presno
(  Presno char(20) primary key,
   Pcontent char(8000),/*��������*/
);
/*���˾�ҽ��*/
CREATE TABLE Hospitalize
(Pno CHAR(20),
 Pname CHAR(20),
 Dsubject CHAR(20),/*��ҽ�Ʊ�*/
 Dmdoctor CHAR(20),/*����ҽ��*/
 Dcause CHAR(20),/*����*/
 Dpresno CHAR(20),/*�������*/
 Dpill CHAR(20),/*��ҩ*/
 foreign key (Pno) references Patient(Pno),/*��������ò��˱��Pno�ֶ�*/
 foreign key (Dpresno) references Presno(Presno)/*��������ô������Presno�ֶ�*/
);
/*�����շѱ�*/
CREATE TABLE Charge
(Pno CHAR(20),
 Cmedicine INT,/*ҩ���շ�*/
 Creg INT,/*�Һŷ�*/
 Cdisposal INT,/*���÷�*/
 Cexamine INT,/*�����*/
 foreign key (Pno) references Patient(Pno)/*��������ò��˱��Pno�ֶ�*/
);
/*ҩ���*/
CREATE TABLE Medicine
(Mno char(10) primary key,/*ҩ����*/
 Mname CHAR(20) , /*ҩ����*/
 Mprice CHAR(20)     /*ҩ��۸�*/
  );
/*�����*/
CREATE TABLE Examine
(Eno char(10) primary key,/*������*/
 Ename CHAR(20) , /*������*/
 Eprice CHAR(20)/*����۸�*/
);







