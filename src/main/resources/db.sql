CREATE DATABASE oabs;

USE oabs;

# 专业
CREATE TABLE major (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '专业ID',
    name VARCHAR(100) NOT NULL UNIQUE COMMENT '专业名称',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
);

insert into major (name, create_time) values ('计算机科学与技术', NOW());

# 班级
CREATE TABLE class (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '班级ID',
    major_id INT NOT NULL COMMENT '所属专业ID',
    created_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
);

insert into class (id, major_id, created_time) values (2201, 1, NOW());

# 学生
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '学号',
    name VARCHAR(50) UNIQUE NOT NULL COMMENT '姓名',
    password VARCHAR(255) NOT NULL COMMENT '登录密码',
    major_id INT COMMENT '所属专业ID',
    class_id INT COMMENT '所属班级ID',
    enrollment_year YEAR NOT NULL COMMENT '入校年份',
    graduation_year YEAR NOT NULL COMMENT '毕业年份',
    employment VARCHAR(100) COMMENT '就业单位',
    city VARCHAR(50) COMMENT '所在城市',
    phone VARCHAR(50) COMMENT '联系方式',
    email VARCHAR(100) COMMENT '电子邮箱',
    is_approved BOOLEAN DEFAULT FALSE COMMENT '是否通过审核（0未审核，1已审核）',
    is_active BOOLEAN DEFAULT TRUE COMMENT '账户状态（0禁用，1启用）',
    last_login_time DATETIME COMMENT '最近登录时间',
    login_count INT DEFAULT 0 COMMENT '登录次数',
    created_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
);

INSERT INTO student (id, name, password, major_id, class_id, enrollment_year, graduation_year, city, phone, email, is_approved, create_time)
VALUES (20220001, '张三', '1234', 1, 2201, 2022, 2026, '南昌', '12345678901', 'zhangsan@123.com', true, NOW());

# 管理员
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '管理员ID',
    name VARCHAR(50) UNIQUE NOT NULL COMMENT '管理员姓名',
    password VARCHAR(255) NOT NULL COMMENT '管理员密码',
    last_login_time DATETIME COMMENT '最近登录时间',
    login_count INT DEFAULT 0 COMMENT '登录次数',
    created_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
);

INSERT INTO admin (name, password, created_time) VALUES ('admin', '1234', NOW());