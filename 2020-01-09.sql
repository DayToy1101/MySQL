show databases ;

use course_system;

show tables ;

-- 按班级统计总成绩
-- 1. student 和 take inner join
-- 2. 安装 classsid 分组
-- 3. sum（score）

select s.classid, sum(t.score)
from student s inner join take t
on (s.sn <=> t.sn)
where t.id=1
group by s.classid
having s.classid=1;

-- 查询选了课的学生信息
select s.*, t.*
from student s inner join take t
    on (s.sn=t.sn);

-- 查询选课的学生信息和课程信息，没有选课的学生只打印学生信息
select s.*, t.*
  from student s left join take t
  on (s.sn=t.sn);

-- 用自连接查询课程 id 等于 4 的课程的成绩小于课程 id 等于 3的课程的成绩
select *
  from take t1 inner join take t2
  on t1.sn=t2.sn
  where t1.id = 4 && t2.id = 3
  and t1.score < t2.score

-- 用自连接查询复变函数的成绩小于线性代数成绩的信息
select *
from take t1 inner join course cs1
on (t1.id=cs1.id) inner join take t2
on (t1.sn=t2.sn) inner join course cs2
on (cs2.id=t2.id)
  where cs1.name='复变函数' && cs2.name='线性代数'
        and t1.score < t2.score;


-- 查询计算机一班的学生
-- 1. student 和 class 表
-- 2. 内连接
select s.*
  from student s , class c
  where s.classid=c.id && c.name='computer 1';

-- 单行子查询，查询计算机一班的学生
select * from student where classid=(select id
from class
where name = 'computer 1');

-- 查询复变函数，线性代数的成绩
-- 子查询，内查询：先查 course 表
--        外查询，查成绩表

select * from take where id in
(select id
  from course
  where name='复变函数' || name ='线性代数') ;

-- 查询学生所学的某一门课的成绩大于班级平均成绩的学生信息

select *
  from student outer_s inner join take outer_t
  using (sn)
where outer_t.score> (
select avg(t.score)
from student s inner join take t
using(sn)
where t.id = outer_t.id
and outer_s.classid=s.classid
group by s.classid)

-- 验证以上语句是否正确的方法：统计每一个班级每一梦课程的平均分和选修课程的人数
select s.classid,t.id, avg(t.score), count(t.score)
from student s inner join take t
  using(sn)
group by s.classid,t.id


select * from student;

select * from take;
