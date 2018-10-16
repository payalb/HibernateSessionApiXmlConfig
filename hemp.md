Hibernate: orm framework: object relational mapping

JPA: java persistence api : orm

JPA: 


EclipseLink

JDBC: interfaces: Connection/ Statement
implementation: jdbc driver ojdbc jar

entity: table
relational db
: primary key column: error

hibernate:
xml files

hibernate.cfg.cml: 
hibernate mapping file:  //3 versions: 4 annotations
xml:


DDL: data def language

altering ur schema: create table/ aletr/ drop


hbm2ddl:1)  create: create the schema for u according to ur entity class 

//beg: drop all the tables : student | recreate this table

//5 tables: student, employee, manager

2) update: It will not drop the table: just update it

table already exist: some data

3) validate: error

4) none: no change to my schema

5) create-drop: testing : test cases:
//create the schema: drop all the schema


database: keywords

varchar
varchar2
integer
int
number


Dialect: (language)jar: mysql: url/ driverclassname


static: @auowired

@Configuratio
@Value()


metadata: mysql db
//sessionfactory: factory of sessions: user

//connection pool

static



object states


1) Transient
2) Persistent
3) detached

//dirty checking: peristent state: hibernate will keep track of what all changes you are doing to that object: flush()| commit(): these changes would be made to the database.


save 	| update: data in the db: fail


tx 		tx



update				read

500

				
				300

rollback


another transaction shud not be able to see the change until and unless the change
is final/persistent/commit				


dirty read: dirty checking: commit
phantom read
non-repeatable read: in 1 transaction, i shud not see diff values for the any data
account

	1
	-1		
			0
	rollback		
			1


	
	200	
		
			200
			-200
	0		commit
	-200
		
	-200


command prompt:

	sql
	insert into student
	
commit

	command prompt
	
			







//flush


update



save
=> persist
get
=> load
merge


dirty checking

flush, evict, clear

commit
save, get, update, delete

state:
1) transient
2) persistent: session.get/ update/ delete/save
3) detached state: removed from the session: session.close()/ evict()/ clear():

tx			tx
1	 payal		1	payal
 	ritu			puja
	commit
				commit: update stu: where id=1

