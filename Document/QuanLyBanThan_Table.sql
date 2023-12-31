﻿--CREATE DATABASE QuanLyBanThan;
USE QuanLyBanThan;

-- Table
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ACCOUNTS](
	[USERNAME] [NVARCHAR](50) NOT NULL,
	[PASSWORD] [NVARCHAR](50) NOT NULL,
	[FULL_NAME] [NVARCHAR](50),
	[EMAIL] [NVARCHAR](50),
	[PHONE] [VARCHAR](15),
	[ACTIVE] [FLOAT](1),
	[LDAP_FLAG] [FLOAT](1),
	[CREATED_BY] [NVARCHAR](50),
	[CREATED_DATE] [DATE],
	[UPDATED_BY] [NVARCHAR](50),
	[UPDATED_DATE] [DATE],
	[DELETED_BY] [NVARCHAR](50),
	[DELETED_DATE] [DATE],
 CONSTRAINT [PK_ACCOUNTS] PRIMARY KEY CLUSTERED 
(
	[USERNAME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MENU_TASK](
	[MENU_ID] [VARCHAR](10) NOT NULL,
	[NAME_TASK] [NVARCHAR](50),
	[IMAGE] [NVARCHAR](50),
	[URL] [VARCHAR](50),
	[DESCRIBE] [NVARCHAR](100)
 CONSTRAINT [PK_MENU_TASK] PRIMARY KEY CLUSTERED 
(
	[MENU_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QUAN_LY_CONG_VIEC](
	[ID] [INT] IDENTITY(1,1) NOT NULL,
	[USERNAME] [NVARCHAR](50),
	[TODAY_DATE] [DATE],
	[ACTIVE] [FLOAT](1),
	[LDAP_FLAG] [FLOAT](1),
	[CREATED_BY] [NVARCHAR](50),
	[CREATED_DATE] [DATE],
	[UPDATED_BY] [NVARCHAR](50),
	[UPDATED_DATE] [DATE],
	[DELETED_BY] [NVARCHAR](50),
	[DELETED_DATE] [DATE],
 CONSTRAINT [PK_QUAN_LY_CONG_VIEC] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QUAN_LY_CONG_VIEC_DETAIL](
	[ID] [INT] IDENTITY(1,1) NOT NULL,
	[QLCV_ID] [INT],
	[NAME] [NVARCHAR](50),
	[WORKPLACE] [NVARCHAR](100),
	[DATE_START] [DATE],
	[DATE_END] [DATE],
	[DESCRIBE] [NVARCHAR](255),
	[LDAP_FLAG] [FLOAT](1),
	[CREATED_BY] [NVARCHAR](50),
	[CREATED_DATE] [DATE],
	[UPDATED_BY] [NVARCHAR](50),
	[UPDATED_DATE] [DATE],
	[DELETED_BY] [NVARCHAR](50),
	[DELETED_DATE] [DATE],
 CONSTRAINT [PK_QUAN_LY_CONG_VIEC_DETAIL] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO



-- Insert data
INSERT INTO ACCOUNTS (USERNAME, PASSWORD, FULL_NAME, EMAIL, PHONE, ACTIVE, LDAP_FLAG) 
	values ('admin', '123', 'pkduy', 'pkduy@gmail.com', '0858343798', 0, 0);


insert into MENU_TASK(MENU_ID, NAME_TASK, IMAGE, URL, DESCRIBE) values ('QLCV', N'Quản lý công việc', 'QuanLyCongViec.png', '/task/qlcv', N'Quản lý về công việc của bản thân, thời gian làm việc');
insert into MENU_TASK(MENU_ID, NAME_TASK, IMAGE, URL, DESCRIBE) values ('QLTG', N'Quản lý thời gian','QuanLyThoiGian.png', '/task/qltg', N'Quản lý thời gian bản thân, giờ giấc sinh hoạt, thời gian biểu');
insert into MENU_TASK(MENU_ID, NAME_TASK, IMAGE, URL, DESCRIBE) values ('QLT', N'Quản lý tiền','QuanLyTien.png', '/task/qlt', N'Quản lý tiền bạc bản thân, chi tiêu,...');


insert into QUAN_LY_CONG_VIEC(USERNAME, TODAY_DATE, ACTIVE) values ('admin', '2023-10-30', 1);

insert into QUAN_LY_CONG_VIEC_DETAIL(QLCV_ID, NAME) values (1,'a');
insert into QUAN_LY_CONG_VIEC_DETAIL(QLCV_ID, NAME) values (1,'b');



-- Thao tác nháp
drop table MENU_TASK

update ACCOUNTS set ACTIVE = 0, LDAP_FLAG = 0 where USERNAME = 'admin'


select * from QUAN_LY_CONG_VIEC where TODAY_DATE = '2023-10-30'

delete QUAN_LY_CONG_VIEC_DETAIL

SELECT * FROM QUAN_LY_CONG_VIEC_DETAIL


select * from QUAN_LY_CONG_VIEC where TODAY_DATE = '2023-10-30';

select quanlycong0_.id as id1_2_, quanlycong0_.active as active2_2_, quanlycong0_.ldap_flag as ldap_fla3_2_,
quanlycong0_.today_date as today_da4_2_, quanlycong0_.username as username5_2_ 
from quan_ly_cong_viec quanlycong0_ 
where quanlycong0_.today_date='2023-10-30'