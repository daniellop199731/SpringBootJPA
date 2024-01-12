drop table if exists tbl_persons;
create table tbl_persons (
	cl_id bigint not null auto_increment, 
    cl_lastname varchar(255), 
    cl_name varchar(255), 
    cl_programming_language varchar(255), 
    primary key (cl_id)
) engine=InnoDB